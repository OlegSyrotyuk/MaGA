package gg.cristalix.maga.arena;

import org.bukkit.entity.Player;
import ru.cristalix.core.CoreApi;
import ru.cristalix.core.IService;

import java.util.UUID;

/**
 * Данный сервис позволяет создавать так называемые под-сервера.
 * <p>
 * Arena - виртуальное игровое пространство, обладающее своими собственными
 * мирами, где игроки могут сражаться и взаимодействовать. Каждая арена является независимым
 * игровым полем с собственным чатом и видимостью игроков.
 * <p>
 * На одном сервере может существовать несколько арен, которые функционируют независимо друг от друга.
 * Каждая арена содержит свой набор игроков, миры и чат.
 */
public interface IArenaService extends IService {

    static IArenaService get() {
        return CoreApi.get().getService(IArenaService.class);
    }

    /**
     * Создать новую арену.
     *
     * @return новая арена
     */
    Arena createArena();

    /**
     * Получить арену по её uuid.
     *
     * @param uuid айди арены
     * @return арена или null
     */
    Arena getArena(UUID uuid);

    /**
     * Получить арену по игроку, находящемся на ней.
     *
     * @param player игрок
     * @return арена или null
     */
    Arena getArenaByPlayer(Player player);

    /**
     * Отгрузить арену и удалить её.
     *
     * @param uuid айди арены
     */
    void unloadArena(UUID uuid);

}
