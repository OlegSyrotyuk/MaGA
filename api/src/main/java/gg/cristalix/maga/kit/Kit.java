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

    private String id;
    private String name;
    private List<String> description;
    private @Singular List<ItemStack> items;
    private Consumer<Player> receiving;

    /**
     * Выдать игроку набор.
     *
     * @param player игрок
     */
    public void give(Player player) {
        if (items != null && !items.isEmpty()) {
            items.forEach(itemStack -> {
                player.getInventory().addItem(itemStack);
            });
        }
        receiving.accept(player);
    }

}
