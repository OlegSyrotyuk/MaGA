package gg.cristalix.maga.game;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameParameter<K, V> {

    private K key;

    private V value;

    public static <K, V> GameParameter<K, V> of(K key, V value) {
        return new GameParameter<>(key, value);
    }

}