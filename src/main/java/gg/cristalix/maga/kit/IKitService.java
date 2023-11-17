package gg.cristalix.maga.kit;

import ru.cristalix.core.CoreApi;
import ru.cristalix.core.IService;

/**
 * Данный сервис позволить вам создать неограниченное
 * количество наборов предметов.
 */
public interface IKitService extends IService {

    static IKitService get() {
        return CoreApi.get().getService(IKitService.class);
    }

    /**
     * Зарегистрировать новый набор.
     *
     * @param kit набор
     */
    void registerKit(Kit kit);

    /**
     * Получить набор по его имени.
     *
     * @param name имя набора
     * @return набор или null
     */
    Kit getKit(String name);

}
