package gg.cristalix.maga.packages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.cristalix.core.network.CorePackage;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class PlayerJoinQueuePackage extends CorePackage {

    private UUID playerUuid;
    private String minigame;

}
