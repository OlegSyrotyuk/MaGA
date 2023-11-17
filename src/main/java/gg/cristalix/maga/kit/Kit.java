package gg.cristalix.maga.kit;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.function.Consumer;

@Getter
@Builder
public class Kit {

    private String name;
    private @Singular List<ItemStack> contents;
    private Consumer<Player> takeHandler;

    public void give(Player player) {
        if (contents != null && !contents.isEmpty()) {
            contents.forEach(itemStack -> {
                player.getInventory().addItem(itemStack);
            });
        }
        takeHandler.accept(player);
    }

}
