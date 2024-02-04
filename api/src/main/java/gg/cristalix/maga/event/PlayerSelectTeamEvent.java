package gg.cristalix.maga.event;

import gg.cristalix.maga.team.Team;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@RequiredArgsConstructor
public class PlayerSelectTeamEvent extends Event {

    @Getter
    private static final HandlerList handlerList = new HandlerList();

    private final Player player;
    private final Team team;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
