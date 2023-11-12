package gg.cristalix.maga.timer;

import lombok.RequiredArgsConstructor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

@RequiredArgsConstructor
public class SimpleTimer implements ITimer {

    private final JavaPlugin plugin;
    private final String name;
    private final int time;
    private int leftTime = time;
    private Runnable everySecond;
    private Runnable onFinish;
    private BukkitRunnable task;

    @Override
    public void everySecond(Runnable runnable) {
        this.everySecond = runnable;
    }

    @Override
    public void onFinish(Runnable runnable) {
        this.onFinish = runnable;
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
                    everySecond.run();
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
            ((TimerService) ITimerService.get()).deleteTimer(name);
            task.cancel();
        }
    }
}
