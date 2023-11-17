package gg.cristalix.maga;

import gg.cristalix.maga.arena.Arena;
import gg.cristalix.maga.arena.ArenaService;
import gg.cristalix.maga.arena.IArenaService;
import gg.cristalix.maga.kit.IKitService;
import gg.cristalix.maga.kit.KitService;
import gg.cristalix.maga.timer.ITimerService;
import gg.cristalix.maga.timer.TimerService;
import lombok.experimental.UtilityClass;
import org.bukkit.plugin.java.JavaPlugin;
import ru.cristalix.core.CoreApi;

import java.util.UUID;

@UtilityClass
public class Maga {

    public void initialize(JavaPlugin plugin) {
        CoreApi.get().registerService(ITimerService.class, new TimerService(plugin));
        CoreApi.get().registerService(IArenaService.class, new ArenaService(plugin));
        CoreApi.get().registerService(IKitService.class, new KitService());
    }

    public Arena getArena(UUID uuid) {
        return IArenaService.get().getArena(uuid);
    }

}
