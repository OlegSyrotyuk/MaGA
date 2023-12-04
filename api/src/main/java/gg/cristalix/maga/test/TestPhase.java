package gg.cristalix.maga.test;

import gg.cristalix.maga.game.AbstractGame;
import gg.cristalix.maga.phase.BasePhase;
import gg.cristalix.maga.timer.ITimerService;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;

import java.util.function.Consumer;

@RequiredArgsConstructor
public enum TestPhase implements BasePhase {

    IN_GAME(game -> {
        ITimerService timerService = ITimerService.get();
        timerService.createSimpleTimer("to-end", 30 * 60)
                .finish(game::disable)
                .start();
        timerService.createSimpleTimer("to-late-game", 20 * 60)
                .finish(game::nextPhase);
    }, game -> {
        Bukkit.broadcastMessage("Начался лейт гейм!!!");
    });

    private final Consumer<AbstractGame> starting;
    private final Consumer<AbstractGame> ending;

    @Override
    public Consumer<AbstractGame> getStarting() {
        return starting;
    }

    @Override
    public Consumer<AbstractGame> getEnding() {
        return ending;
    }
}
