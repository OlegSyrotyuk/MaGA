package gg.cristalix.maga.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.md_5.bungee.api.ChatColor;

@Getter
@AllArgsConstructor
public enum Color {

    WHITE("Белые", 0, 15, 16383998, 15790320, "§f", 15, ChatColor.WHITE, ru.cristalix.wada.util.Color.WHITE),
    ORANGE("Оранжевые", 1, 14, 16351261, 15435844, "§6", 6, ChatColor.GOLD, ru.cristalix.wada.util.Color.ORANGE),
    MAGENTA("Пурпурные", 2, 13, 13061821, 12801229, "§d", 13, ChatColor.LIGHT_PURPLE, ru.cristalix.wada.util.Color.LIGHT_VIOLET),
    AQUA("Аквамариновые", 3, 12, 3847130, 6719955, "§b", 11, ChatColor.AQUA, ru.cristalix.wada.util.Color.CIAN),
    YELLOW("Жёлтые", 4, 11, 16701501, 14602026, "§e", 14, ChatColor.YELLOW, ru.cristalix.wada.util.Color.YELLOW),
    LIME("Лаймовые", 5, 10, 8439583, 4312372, "§a", 10, ChatColor.GREEN, ru.cristalix.wada.util.Color.LIGHT_GREEN),
    RED("Красные", 14, 9, 16733525, 14188952, "§c", 12, ChatColor.RED, ru.cristalix.wada.util.Color.RED),
    GRAY("Серые", 7, 8, 4673362, 4408131, "§8", 8, ChatColor.DARK_GRAY, ru.cristalix.wada.util.Color.DARK_GREY),
    SILVER("Серебрянные", 8, 7, 10329495, 11250603, "§7", 7, ChatColor.GRAY, ru.cristalix.wada.util.Color.LIGHT_GREY),
    CYAN("Бирюзовые", 9, 6, 1481884, 2651799, "§3", 3, ChatColor.DARK_AQUA, ru.cristalix.wada.util.Color.CIAN),
    PURPLE("Пурпурные", 10, 5, 8991416, 8073150, "§5", 5, ChatColor.DARK_PURPLE, ru.cristalix.wada.util.Color.DARK_PINK),
    DARK_BLUE("Темно синие", 11, 4, 3949738, 2437522, "§1", 1, ChatColor.DARK_BLUE, ru.cristalix.wada.util.Color.DARK_BLUE),
    BLUE("Синие", 11, 3, 5592575, 5320730, "§9", 9, ChatColor.BLUE, ru.cristalix.wada.util.Color.BLUE),
    GREEN("Зелёные", 13, 2, 6192150, 3887386, "§2", 2, ChatColor.DARK_GREEN, ru.cristalix.wada.util.Color.DARK_GREEN),
    DARK_RED("Темно красные", 14, 1, 11546150, 11743532, "§4", 4, ChatColor.DARK_RED, ru.cristalix.wada.util.Color.DARK_RED),
    BLACK("Чёрные", 15, 0, 1908001, 1973019, "§0", 0, ChatColor.BLACK, ru.cristalix.wada.util.Color.BLACK);

    private final String teamName;
    private final int woolData;
    private final int dyeData;
    private final int color;
    private final int fireworkColor;
    private final String chatFormat;
    private final int chatFormatCode;
    private final ChatColor chatColor;
    private final ru.cristalix.wada.util.Color wadaColor;
}
