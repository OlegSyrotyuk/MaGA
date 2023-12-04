package gg.cristalix.maga.kit;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class KitSection implements IKitSection {

    private final String name;
    private final Map<String, Kit> KITS = new HashMap<>();

    @Override
    public void registerKit(Kit kit) {
        if (kit == null) {
            return;
        }
        KITS.put(kit.getId(), kit);
    }

    @Override
    public Kit getKit(String id) {
        return KITS.getOrDefault(id, null);
    }

    @Override
    public Collection<Kit> getKits() {
        return KITS.values();
    }
}
