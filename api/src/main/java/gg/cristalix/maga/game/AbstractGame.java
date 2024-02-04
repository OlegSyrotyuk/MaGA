package gg.cristalix.maga.game;

import gg.cristalix.maga.arena.IArena;
import gg.cristalix.maga.phase.BasePhase;
import gg.cristalix.maga.team.TeamManager;
import gg.cristalix.maga.team.TeamManagerImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractGame {

    @Getter
    private final String name;
    @Getter
    private final IArena arena;
    @Getter
    private final JavaPlugin plugin;
    private final Queue<BasePhase> phases = new LinkedList<>();
    @Getter
    private BasePhase phase;
    @Getter
    private final GameSettings settings = new GameSettings();
    @Getter
    private final TeamManager teamManager = new TeamManagerImpl();

    public abstract void enable();

    public abstract void disable();

    public void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

    public void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            registerListener(listener);
        }
    }

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
