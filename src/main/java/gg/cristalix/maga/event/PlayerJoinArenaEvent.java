package gg.cristalix.maga.event;

import gg.cristalix.maga.arena.Arena;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@RequiredArgsConstructor
public class PlayerJoinArenaEvent extends Event {

    @Getter
    private static final HandlerList handlerList = new HandlerList();

    private final Player player;
    private final Arena arena;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
