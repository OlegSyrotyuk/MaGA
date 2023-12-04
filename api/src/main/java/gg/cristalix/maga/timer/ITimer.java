package gg.cristalix.maga.timer;

import java.util.function.Consumer;

public interface ITimer {

    /**
     * Действие, которое будет выполняться каждую секунду.
     *
     * @param consumer действие
     */
    ITimer everySecond(Consumer<ITimer> consumer);

    /**
     * Действие, которое будет выполнено после завершения таймера.
     *
     * @param runnable действие
     */
    ITimer finish(Runnable runnable);

    /**
     * Получить оставшееся время до конца таймера.
     *
     * @return время
     */
    int getLeftTime();

    /**
     * Запуск таймера.
     */
    void start();

    /**
     * Отмена таймера.
     */
    void cancel();

}
