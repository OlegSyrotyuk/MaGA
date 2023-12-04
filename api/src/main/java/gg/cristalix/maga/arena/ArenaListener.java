package gg.cristalix.maga.arena;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class ArenaListener implements Listener {

    //TODO: ограничение на вход игрока

    @EventHandler
    public void on(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        IArena arena = IArenaService.get().getArenaByPlayer(player);
        if (arena != null) {
            event.getRecipients().removeIf(p -> !arena.getPlayers().contains(p));
        }
    }

    @EventHandler
    public void on(AsyncPlayerPreLoginEvent event) {

    }

}
