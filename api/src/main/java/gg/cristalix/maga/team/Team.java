package gg.cristalix.maga.team;

import gg.cristalix.maga.util.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
public class Team {

    private Color color;
    private int slots;
    private final Set<Player> players = new HashSet<>();

}
