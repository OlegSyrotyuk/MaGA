package gg.cristalix.maga.service.matchmaking;

import ru.cristalix.core.CoreApi;
import ru.cristalix.core.IService;
import ru.cristalix.core.party.PartySnapshot;

import java.util.UUID;

public interface IMatchMakingService extends IService {

    default IMatchMakingService get() {
        return CoreApi.get().getService(IMatchMakingService.class);
    }

    void joinToQueue(UUID uuid, String minigame);

    void joinToQueue(PartySnapshot party, String minigame);

    void leaveFromQueue(UUID uuid, String minigame);

    void leaveFromQueue(PartySnapshot party, String minigame);

}
