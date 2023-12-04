package gg.cristalix.maga.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;
import java.util.UUID;

@UtilityClass
public class WorldUtil {

    /**
     * Создает абсолютно пустой мир.
     *
     * @return пустой мир
     */
    public World createEmptyWorld() {
        WorldCreator worldCreator = new WorldCreator(UUID.randomUUID().toString());
        worldCreator.generator(new EmptyChunkGenerator());
        return worldCreator.createWorld();
    }

    /**
     * Полное удаление и отгрузка мира.
     *
     * @param world мир
     */
    @SneakyThrows
    public void deleteWorld(World world) {
        Bukkit.unloadWorld(world, false);
        for (Chunk chunk : world.getLoadedChunks()) {
            chunk.unload();
        }
        FileUtils.deleteDirectory(world.getWorldFolder());
    }

    public class EmptyChunkGenerator extends ChunkGenerator {

        @Override
        public byte[] generate(World world, Random random, int x, int z) {
            return new byte[32768];
        }
    }

}
