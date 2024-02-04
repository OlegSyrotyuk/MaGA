package gg.cristalix.maga.service.game;

import ru.cristalix.core.CoreApi;
import ru.cristalix.core.IService;
import ru.cristalix.core.realm.RealmId;

import java.util.List;

public interface IGameService extends IService {

    default IGameService get() {
        return CoreApi.get().getService(IGameService.class);
    }

    void addGameServer(RealmId realmId, IGameServer server);

    void removeGameServer(RealmId realmId);

    IGameServer getGameServerById(RealmId realmId);

    IGameServer getGameServerByMinigame(String minigame);

    List<IGameServer> getGameServers();

}
