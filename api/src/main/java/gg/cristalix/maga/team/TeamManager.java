package gg.cristalix.maga.team;

import org.bukkit.entity.Player;

public interface TeamManager {

    /**
     * Зарегистрировать новую команду.
     *
     * @param team команда
     */
    void registerTeam(Team team);

    /**
     * Выбор команды для игрока.
     *
     * @param player игрок
     * @param team   команда
     */
    void select(Player player, Team team);

    Team getTeam(Player player);

    void balanceBetweenTeams();

}
