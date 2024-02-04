package gg.cristalix.maga.arena;

import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface IArena {

    /**
     * Получить уникальный идентификатор арены.
     *
     * @return Уникальный идентификатор арены в форме UUID.
     */
    UUID getUuid();

    /**
     * Получить игроков, находящихся на арене.
     *
     * @return игроки на арене.
     */
    Set<Player> getPlayers();

    /**
     * Получить все миры арены.
     *
     * @return Все миры арены.
     */
    Map<String, World> getWorlds();

    /**
     * Добавить мир на арену с заданным именем.
     *
     * @param name  имя мира.
     * @param world Объект мира.
     */
    void addWorld(String name, World world);

    /**
     * Добавить игрока на арену.
     *
     * @param player Добавляемый игрок.
     */
    void addPlayer(Player player);

    /**
     * Удалить игрока с арены.
     *
     * @param player Удаляемый игрок.
     */
    void removePlayer(Player player);

    /**
     * Добавить список игроков на арену.
     *
     * @param players Список добавляемых игроков.
     */
    void addPlayers(List<Player> players);

    /**
     * Отправить сообщение всем игрокам на арене.
     *
     * @param message Сообщение для отправки.
     * @param args    Дополнительные аргументы для форматирования сообщения.
     */
    void broadcast(String message, Object... args);

    /**
     * Сказать сервису, что арена готова к игре.
     * Сервис в свою очередь переместит игроков на необходимый сервер.
     */
    void ready();

    /**
     * Выгрузить арену. По умолчанию использует {@link IArenaService}, чтобы выгрузить арену
     * по её уникальному идентификатору.
     */
    default void unload() {
        IArenaService.get().unloadArena(getUuid());
    }
}
