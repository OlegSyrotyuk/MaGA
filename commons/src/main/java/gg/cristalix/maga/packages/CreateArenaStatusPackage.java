package gg.cristalix.maga.packages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.cristalix.core.network.CorePackage;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreateArenaStatusPackage extends CorePackage {

    private Status status;
    private UUID uuid;

    public enum Status {
        SUCCESS,
        FAILED
    }
}
