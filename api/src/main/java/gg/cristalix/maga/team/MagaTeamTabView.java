package gg.cristalix.maga.team;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.jetbrains.annotations.NotNull;
import ru.cristalix.core.IPlatform;
import ru.cristalix.core.formatting.Colors;
import ru.cristalix.core.formatting.Formatting;
import ru.cristalix.core.lib.Strings;
import ru.cristalix.core.permissions.CustomProfile;
import ru.cristalix.core.permissions.IGroup;
import ru.cristalix.core.permissions.IPermissionService;
import ru.cristalix.core.tab.ITabTextFormatter;
import ru.cristalix.core.tab.ITabView;
import ru.cristalix.core.tab.TabHeaderFooter;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Setter
public class MagaTeamTabView implements ITabView {

    private ITabTextFormatter formatter;
    @Getter
    private TabHeaderFooter tabHeaderFooter = TabHeaderFooter.of(
            new ComponentBuilder("Cristalix").color(ChatColor.AQUA).create(),
            new ComponentBuilder("cristalix.gg").color(ChatColor.WHITE).create()
    );

    public MagaTeamTabView(
            @NotNull TeamManager manager,
            @NotNull IPlatform platform,
            @NotNull IPermissionService permissionService
    ) {
        formatter = new ITabTextFormatter() {
            @Override
            @SneakyThrows
            public CompletableFuture<BaseComponent[]> format(UUID uuid) {
                return permissionService.getPermissionContext(uuid).thenCompose(bestContext -> {
                    IGroup best = bestContext.getDisplayGroup();
                    CompletableFuture<String> future = permissionService.getNameColor(uuid);
                    return future.thenCompose(color -> {
                        CustomProfile customProfile = bestContext.getCustomProfile();
                        //val gamePlayer = plugin.playerManager().get(uuid);
                        if (color == null) color = best.getNameColor();

                        StringBuilder prefixBuilder = new StringBuilder();
//                        if (gamePlayer != null) {
//                            prefixBuilder.append("§8[§e").append(gamePlayer.getLevel()).append("§8]").append(" ");
//                        }
                        String evoPrefix = prefixBuilder.toString();
                        String tabPrefix = best.getTabPrefix();
                        String prefix = Strings.nonNullOr(customProfile.getTabPrefix(), best.getTabPrefixColor() + tabPrefix);
                        String _color = color;
                        return platform.getNameByUuid(uuid).thenApply(name -> {
                            name = customProfile.getPlayerName(name);
                            StringBuilder builder = new StringBuilder().append(evoPrefix);
                            if (!tabPrefix.isEmpty()) {
                                builder.append(prefix).append(" ");
                            }
                            builder.append(_color).append(name);
                            return new ComponentBuilder(builder.toString()).create();
                        });
                    });
                });
            }

//            @Override
//            @SneakyThrows
//            public CompletableFuture<Integer> getOrderingComponent(UUID uuid) {
//                return permissionService.getPermissionContext(uuid).thenApply(context -> {
//                    //val gamePlayer = plugin.playerManager().get(uuid);
//                    return gamePlayer == null ? 0 : -gamePlayer.getLevel();
//                });
//            }
        };
    }

    @Override
    public CompletableFuture<BaseComponent> getFormattedComponent(UUID uuid) {
        TextComponent root = new TextComponent("");
        if (formatter == null) return CompletableFuture.completedFuture(root);
        return formatter.format(uuid).thenApply(Formatting::join);
    }

    @Override
    public CompletableFuture<String> getOrderingComponent(UUID uuid) {
        return formatter.getOrderingComponent(uuid).thenApply(i -> Colors.colorChar + (char) i.intValue());
    }
}
