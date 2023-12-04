package gg.cristalix.maga.packages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.cristalix.core.network.CorePackage;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreateArenaPackage extends CorePackage {

    private String minigame;
    private List<UUID> players;

}
