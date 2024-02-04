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
     * @param time время таймера
     * @return таймер
     */
    ITimer createSimpleTimer(int time);

}
