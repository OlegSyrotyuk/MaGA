package gg.cristalix.maga.kit;

import java.util.Collection;

/**
 * Класс IKitSection для организации и управления наборами в различных мини-играх.
 * Позволяет группировать наборы по секциям для удобства использования.
 *
 * @see Kit
 */
public interface IKitSection {

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

    /**
     * Получить список всех наборов.
     *
     * @return список всех наборов
     */
    Collection<Kit> getKits();

}
