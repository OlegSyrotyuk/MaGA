package gg.cristalix.maga.timer;

import ru.cristalix.core.CoreApi;
import ru.cristalix.core.IService;

public interface ITimerService extends IService {

    static ITimerService get() {
        return CoreApi.get().getService(ITimerService.class);
    }

    /**
     * Создать простой таймер.
     *
     * @param name имя таймера
     * @param time время таймера
     * @return таймер
     */
    ITimer createSimpleTimer(String name, int time);

    /**
     * Получить таймер по его имени.
     *
     * @param name имя таймера
     * @return таймер
     */
    ITimer getTimer(String name);
}
