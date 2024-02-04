package gg.cristalix.maga.team;

import gg.cristalix.maga.util.Color;
import org.bukkit.entity.Player;
import ru.cristalix.core.display.IDisplayService;
import ru.cristalix.core.i18n.I18n;

import java.util.HashMap;
import java.util.Map;

public class TeamManagerImpl implements TeamManager {

    private final Map<Color, Team> TEAMS = new HashMap<>();

    @Override
    public void registerTeam(Team team) {
        TEAMS.put(team.getColor(), team);
    }

    @Override
    public void select(Player player, Team team) {
        if (team.getPlayers().size() >= team.getSlots()) {
            player.sendMessage(I18n.of("maga.game.team.select.full"));
            return;
        }
        player.sendMessage(I18n.of("maga.game.team.selected", team.getColor().getTeamName()));
        IDisplayService displayService = IDisplayService.get();

    }

    @Override
    public Team getTeam(Player player) {
        return null;
    }

    @Override
    public void balanceBetweenTeams() {

    }
}
