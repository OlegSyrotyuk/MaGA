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
     * Зарегистрировать новую секцию наборов.
     * <p>
     * Секции необходимы для разделения наборов на разные игровые режимы.
     *
     * @param name название секции
     */
    IKitSection registerKitSection(String name);

    /**
     * Получить секцию наборов по её имени.
     *
     * @param name имя секции
     * @return секция или null
     */
    IKitSection getKitSection(String name);

}
