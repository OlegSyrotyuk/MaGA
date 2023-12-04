package gg.cristalix.maga.test;

import gg.cristalix.maga.arena.IArena;
import gg.cristalix.maga.game.AbstractGame;
import gg.cristalix.maga.kit.IKitSection;
import gg.cristalix.maga.kit.IKitService;
import gg.cristalix.maga.kit.Kit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TestGame extends AbstractGame {

    public TestGame(IArena arena) {
        super("bedrock-box-classic", arena);
        getSettings().set("min-players", 10);
        getSettings().set("max-players", 100);
        getSettings().set("nollen-churka", true);
        Boolean parameter = getSettings().get("nollen-churka", Boolean.class);

        Boolean orDefault = getSettings().getOrDefault("nollen-churka", true, Boolean.class);
    }

    @Override
    public void enable() {

        registerKits();
        //TODO: подготовка игре

        getArena().ready();
    }

    @Override
    public void disable() {
        getArena().unload();
    }

    private void registerKits() {
        IKitSection kitSection = IKitService.get().registerKitSection("bedrock-box-classic");
        kitSection.registerKit(Kit.builder()
                .id("miner")
                .name("&bШахтер")
                .item(new ItemStack(Material.STONE_PICKAXE))
                .build());
    }

    private void registerPhases() {
        addPhase(TestPhase.IN_GAME);
    }
}
