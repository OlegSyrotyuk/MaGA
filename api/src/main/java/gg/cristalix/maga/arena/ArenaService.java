package gg.cristalix.maga.arena;

import gg.cristalix.maga.util.WorldUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j(topic = "ArenaService")
@RequiredArgsConstructor
public class ArenaService implements IArenaService {

    private final Map<UUID, Arena> ARENAS = new HashMap<>();
    private final JavaPlugin plugin;

    @Override
    public void enable() {
        Bukkit.getPluginManager().registerEvents(new ArenaListener(), plugin);
    }

    @Override
    public void disable() {
        unloadAllArenas();
    }

    @Override
    public IArena createArena() {
        Arena arena = new Arena(UUID.randomUUID(), plugin);
        ARENAS.put(arena.getUuid(), arena);
        log.info("Create new arena {}.", arena.getUuid());
        return arena;
    }

    @Override
    public IArena getArena(UUID uuid) {
        return ARENAS.getOrDefault(uuid, null);
    }

    @Override
    public IArena getArenaByPlayer(Player player) {
        return ARENAS.values()
                .stream()
                .filter(arena -> arena.getPlayers().contains(player))
                .findFirst().orElse(null);
    }

    @Override
    public void unloadArena(UUID uuid) {
        IArena arena = getArena(uuid);
        if (arena == null) {
            return;
        }
        arena.getPlayers().forEach(player -> {
            player.kickPlayer("[MaGA] Arena has been unloaded.");
        });
        arena.getWorlds().values().forEach(WorldUtil::deleteWorld);
        ARENAS.remove(uuid);
    }

    public void unloadAllArenas() {
        ARENAS.values().forEach(arena -> {
            unloadArena(arena.getUuid());
        });
    }
}
