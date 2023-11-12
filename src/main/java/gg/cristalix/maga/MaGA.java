package gg.cristalix.maga;

import gg.cristalix.maga.timer.ITimerService;
import gg.cristalix.maga.timer.TimerService;
import lombok.experimental.UtilityClass;
import org.bukkit.plugin.java.JavaPlugin;
import ru.cristalix.core.CoreApi;

@UtilityClass
public class MaGA {

    public void initialize(JavaPlugin plugin) {
        CoreApi.get().registerService(ITimerService.class, new TimerService(plugin));
    }

}
