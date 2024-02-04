package gg.cristalix.maga.test;

import gg.cristalix.maga.game.AbstractGame;
import gg.cristalix.maga.phase.BasePhase;
import gg.cristalix.maga.timer.ITimerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;

import java.util.function.Consumer;

@Getter
@RequiredArgsConstructor
public enum TestPhase implements BasePhase {

    IN_GAME(game -> {
        ITimerService timerService = ITimerService.get();
        game.getTeamManager().balanceBetweenTeams();
        timerService.createSimpleTimer(30 * 60)
                .finish(game::disable)
                .start();
        timerService.createSimpleTimer(20 * 60)
                .finish(game::nextPhase);
    }, game -> {
        Bukkit.broadcastMessage("Начался лейт гейм!!!");
    });

    private final Consumer<AbstractGame> starting;
    private final Consumer<AbstractGame> ending;
}
