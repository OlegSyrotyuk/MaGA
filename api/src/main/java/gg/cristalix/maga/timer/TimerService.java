package gg.cristalix.maga.timer;

import lombok.RequiredArgsConstructor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
public class TimerService implements ITimerService {

    private final JavaPlugin plugin;
    private final Map<UUID, ITimer> TIMERS = new HashMap<>();

    @Override
    public ITimer createSimpleTimer(int time) {
        UUID uuid = UUID.randomUUID();
        SimpleTimer timer = new SimpleTimer(uuid, plugin, time);
        TIMERS.put(uuid, timer);
        return timer;
    }

    public void deleteTimer(UUID uuid) {
        TIMERS.remove(uuid);
    }
}
