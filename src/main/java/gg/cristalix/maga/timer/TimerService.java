package gg.cristalix.maga.timer;

import lombok.RequiredArgsConstructor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class TimerService implements ITimerService {

    private final JavaPlugin plugin;
    private final Map<String, ITimer> TIMERS = new HashMap<>();

    @Override
    public ITimer createSimpleTimer(String name, int time) {
        SimpleTimer timer = new SimpleTimer(plugin, name, time);
        TIMERS.put(name, timer);
        return timer;
    }

    @Override
    public ITimer getTimer(String name) {
        return TIMERS.getOrDefault(name, null);
    }

    public void deleteTimer(String name) {
        TIMERS.remove(name);
    }
}
