package gg.cristalix.maga.timer;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;
import java.util.function.Consumer;

public class SimpleTimer implements ITimer {

    private final UUID uuid;
    private final JavaPlugin plugin;
    private int leftTime;
    private Consumer<ITimer> everySecond;
    private Runnable onFinish;
    private BukkitRunnable task;

    public SimpleTimer(UUID uuid, JavaPlugin plugin, int time) {
        this.uuid = uuid;
        this.plugin = plugin;
        this.leftTime = time;
        this.everySecond = timer -> {
        };
        this.onFinish = () -> {
        };
    }

    @Override
    public ITimer everySecond(Consumer<ITimer> consumer) {
        this.everySecond = consumer;
        return this;
    }

    @Override
    public ITimer finish(Runnable runnable) {
        this.onFinish = runnable;
        return this;
    }

    @Override
    public int getLeftTime() {
        return leftTime;
    }

    @Override
    public void start() {
        task = new BukkitRunnable() {
            @Override
            public void run() {
                if (leftTime > 0) {
                    everySecond.accept(SimpleTimer.this);
                    leftTime--;
                } else {
                    onFinish.run();
                    cancel();
                }
            }
        };
        task.runTaskTimer(plugin, 0L, 20L);
    }

    @Override
    public void cancel() {
        if (task != null) {
            ((TimerService) ITimerService.get()).deleteTimer(uuid);
            task.cancel();
        }
    }
}
