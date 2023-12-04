package gg.cristalix.maga.game;

import java.util.HashMap;
import java.util.Map;

public class GameSettings {

    private final Map<String, Object> SETTINGS = new HashMap<>();

    public void set(String key, Object value) {
        SETTINGS.put(key, value);
    }

    public Object get(String key) {
        return SETTINGS.get(key);
    }

    public Object getOrDefault(String key, Object defaultObject) {
        return SETTINGS.getOrDefault(key, defaultObject);
    }

    public <T> T get(String key, Class<T> type) {
        return type.cast(get(key));
    }

    public <T> T getOrDefault(String key, Object defaultObject, Class<T> type) {
        return type.cast(getOrDefault(key, defaultObject));
    }

}
