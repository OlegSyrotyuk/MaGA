package gg.cristalix.maga.packages.history;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class GameSession {

    @SerializedName("game_uuid")
    private final UUID gameUuid;
    @SerializedName("start_time")
    private long startTime;
    @SerializedName("end_time")
    private long endTime;
    private Set<PlayerSessionData> players;

    public long getTotalTime() {
        return endTime - startTime;
    }

}
