package gg.cristalix.maga.voting;

import ru.cristalix.core.CoreApi;
import ru.cristalix.core.IService;

public interface IVotingService extends IService {

    default IVotingService get() {
        return CoreApi.get().getService(IVotingService.class);
    }

}
