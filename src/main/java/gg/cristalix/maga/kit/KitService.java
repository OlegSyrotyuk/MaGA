package gg.cristalix.maga.kit;

import java.util.HashMap;
import java.util.Map;

public class KitService implements IKitService {

    private final Map<String, Kit> KITS = new HashMap<>();

    @Override
    public void registerKit(Kit kit) {
        if (kit == null) {
            return;
        }
        KITS.put(kit.getName(), kit);
    }

    @Override
    public Kit getKit(String name) {
        return KITS.getOrDefault(name, null);
    }
}
