package gg.cristalix.maga.service.game;

import ru.cristalix.core.realm.RealmId;

import java.util.Set;
import java.util.UUID;

public interface IGameServer {

    Set<UUID> getArenas();

    Set<String> getAvailableGames();

    void createGame(String minigame, Set<UUID> players);

    void addPlayerToArena(UUID arena, UUID player);

    void removePlayerFromArena(UUID arena, UUID player);

    RealmId getRealmId();

}
