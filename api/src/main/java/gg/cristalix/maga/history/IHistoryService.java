package gg.cristalix.maga.history;

import ru.cristalix.core.CoreApi;
import ru.cristalix.core.IService;

public interface IHistoryService extends IService {

    default IHistoryService get() {
        return CoreApi.get().getService(IHistoryService.class);
    }


}
