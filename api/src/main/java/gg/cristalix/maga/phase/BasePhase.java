package gg.cristalix.maga.phase;

import gg.cristalix.maga.game.AbstractGame;

import java.util.function.Consumer;

/**
 * Интерфейс {@code BasePhase} представляет собой базовый контракт для описания игровой фазы.
 * Разработчику следует создать enum, реализующее этот интерфейс, чтобы определить
 * различные игровые фазы с соответствующей логикой начала и завершения.
 * <p>
 * Пример использования:
 * <pre>{@code
 * public enum MyGamePhase implements BasePhase {
 *     // Определение конкретных фаз и их действий
 *     PHASE_1(
 *         game -> {
 *             // Логика, выполняемая при начале фазы PHASE_1
 *             // ...
 *         },
 *         game -> {
 *             // Логика, выполняемая при завершении фазы PHASE_1
 *             // ...
 *         }
 *     ),
 *     PHASE_2(
 *         // Аналогично для фазы PHASE_2
 *     ),
 *     // Добавьте другие фазы, если необходимо
 *     ;
 *
 *     private final Consumer<AbstractGame> starting;
 *     private final Consumer<AbstractGame> ending;
 *
 *     MyGamePhase(Consumer<AbstractGame> starting, Consumer<AbstractGame> ending) {
 *         this.starting = starting;
 *         this.ending = ending;
 *     }
 *
 *     {@literal @}Override
 *     public Consumer<AbstractGame> getStarting() {
 *         return starting;
 *     }
 *
 *     {@literal @}Override
 *     public Consumer<AbstractGame> getEnding() {
 *         return ending;
 *     }
 * }
 * }</pre>
 */
public interface BasePhase {

    /**
     * Получить действия, которые произойдут при начале фазы.
     *
     * @return действия
     */
    Consumer<AbstractGame> getStarting();

    /**
     * Получить действия, которые произойдут после окончания фазы.
     *
     * @return действия
     */
    Consumer<AbstractGame> getEnding();

}
