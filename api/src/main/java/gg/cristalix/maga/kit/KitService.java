package gg.cristalix.maga.kit;

import java.util.HashMap;
import java.util.Map;

public class KitService implements IKitService {

    private final Map<String, IKitSection> SECTIONS = new HashMap<>();

    @Override
    public IKitSection registerKitSection(String name) {
        IKitSection section = SECTIONS.getOrDefault(name, null);
        if (section == null) {
            section = new KitSection(name);
            SECTIONS.put(name, section);
        }
        return section;
    }

    @Override
    public IKitSection getKitSection(String name) {
        return SECTIONS.getOrDefault(name, null);
    }
}
