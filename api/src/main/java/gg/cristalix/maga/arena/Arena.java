package gg.cristalix.maga.arena;

import gg.cristalix.maga.event.PlayerJoinArenaEvent;
import gg.cristalix.maga.event.PlayerQuitArenaEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Arena implements IArena {

    private final UUID uuid;
    private final Set<Player> players = new HashSet<>();
    private final Map<String, World> worlds = new HashMap<>();
    private final JavaPlugin plugin;

    @Override
    public void addWorld(String name, World world) {
        worlds.put(name, world);
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
        Bukkit.getOnlinePlayers()
                .stream()
                .filter(p2 -> !players.contains(p2))
                .forEach(player2 -> {
                    player2.hidePlayer(plugin, player);
                    player.hidePlayer(plugin, player2);
                });
        players.forEach(player2 -> {
            player2.showPlayer(plugin, player);
            player.showPlayer(plugin, player2);
        });
        log.info("{} ({}) joined to arena {}", player.getName(), player.getUniqueId(), this.getUuid());
        Bukkit.getPluginManager().callEvent(new PlayerJoinArenaEvent(player, this));
    }

    @Override
    public void removePlayer(Player player) {
        if (!players.contains(player)) {
            return;
        }
        players.remove(player);
        log.info("{} ({}) quit from arena {}", player.getName(), player.getUniqueId(), this);
        Bukkit.getPluginManager().callEvent(new PlayerQuitArenaEvent(player, this));
    }

    @Override
    public void addPlayers(List<Player> players) {
        players.forEach(this::addPlayer);
    }

    @Override
    public void broadcast(String message, Object... args) {
        players.forEach(player -> {
            player.sendMessage(String.format(message, args));
        });
    }

    @Override
    public void ready() {

    }

}
