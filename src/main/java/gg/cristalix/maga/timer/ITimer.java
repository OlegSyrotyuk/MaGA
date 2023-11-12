package gg.cristalix.maga.timer;

public interface ITimer {

    /**
     * Действие, которое будет выполняться каждую секунду.
     *
     * @param runnable действие
     */
    void everySecond(Runnable runnable);

    /**
     * Действие, которое будет выполнено после завершения таймера.
     *
     * @param runnable действие
     */
    void onFinish(Runnable runnable);

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
