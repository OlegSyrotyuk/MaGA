package gg.cristalix.maga;

import gg.cristalix.maga.arena.ArenaService;
import gg.cristalix.maga.arena.IArena;
import gg.cristalix.maga.arena.IArenaService;
import gg.cristalix.maga.game.AbstractGame;
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
        CoreApi coreApi = CoreApi.get();
        coreApi.registerService(ITimerService.class, new TimerService(plugin));
        coreApi.registerService(IArenaService.class, new ArenaService(plugin));
        coreApi.registerService(IKitService.class, new KitService());
    }

    public IArena getArena(UUID uuid) {
        return IArenaService.get().getArena(uuid);
    }

    public void createGame(AbstractGame game) {
        game.enable();
    }

}
