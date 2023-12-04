package gg.cristalix.maga.team;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public class Team {

    private final String id;
    private String displayName;
    private Set<Player> players;

}
