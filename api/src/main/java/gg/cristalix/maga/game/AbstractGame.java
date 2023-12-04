package gg.cristalix.maga.game;

import gg.cristalix.maga.arena.IArena;
import gg.cristalix.maga.phase.BasePhase;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractGame {

    @Getter
    private final String name;
    @Getter
    private final IArena arena;
    private final Queue<BasePhase> phases = new LinkedList<>();
    @Getter
    private BasePhase phase;
    @Getter
    private final GameSettings settings = new GameSettings();

    public abstract void enable();

    public abstract void disable();

    public void addPhase(BasePhase phase) {
        phases.add(phase);
    }

    public void nextPhase() {
        if (phases.isEmpty()) {
            return;
        }
        if (phase != null) {
            phase.getEnding().accept(this);
        }
        BasePhase poll = phases.poll();
        if (poll != null) {
            phase = poll;
            phase.getStarting().accept(this);
        }
    }

}
