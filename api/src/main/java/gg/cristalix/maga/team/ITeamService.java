package gg.cristalix.maga.team;

import gg.cristalix.maga.arena.Arena;
import ru.cristalix.core.CoreApi;
import ru.cristalix.core.IService;

public interface ITeamService extends IService {

    static ITeamService get() {
        return CoreApi.get().getService(ITeamService.class);
    }

    void registerTeam(Arena arena, Team team);

    void sortPlayers(Arena arena);

}
