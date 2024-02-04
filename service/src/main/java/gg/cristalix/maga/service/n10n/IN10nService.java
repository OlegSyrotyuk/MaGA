package gg.cristalix.maga.service.n10n;

import ru.cristalix.core.CoreApi;
import ru.cristalix.core.IService;

public interface IN10nService extends IService {

    default IN10nService get() {
        return CoreApi.get().getService(IN10nService.class);
    }

    IDeveloper getDeveloper(String name);

    IDeveloper getDeveloperByMinigame(String name);

}
