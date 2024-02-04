package gg.cristalix.maga.service.game;

import gg.cristalix.maga.packages.CreateArenaPackage;
import lombok.RequiredArgsConstructor;
import ru.cristalix.core.network.ISocketClient;
import ru.cristalix.core.realm.RealmId;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
public class GameServer implements IGameServer {

    private final RealmId realmId;
    private final Set<UUID> arenas = new HashSet<>();
    private final Set<String> availableGames = new HashSet<>();
    private final ISocketClient socketClient;

    @Override
    public Set<UUID> getArenas() {
        return arenas;
    }

    @Override
    public Set<String> getAvailableGames() {
        return availableGames;
    }

    @Override
    public void createGame(String minigame, Set<UUID> players) {
        socketClient.writeAndAwaitResponse(new CreateArenaPackage(minigame, players));
    }

    @Override
    public void addPlayerToArena(UUID arena, UUID player) {

    }

    @Override
    public void removePlayerFromArena(UUID arena, UUID player) {

    }

    @Override
    public RealmId getRealmId() {
        return realmId;
    }
}
