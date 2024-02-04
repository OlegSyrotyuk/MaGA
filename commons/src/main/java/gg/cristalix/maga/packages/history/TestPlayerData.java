package gg.cristalix.maga.packages.history;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class TestPlayerData implements PlayerSessionData {

    private final UUID uuid;
    private int kills;
    private int deaths;

}
