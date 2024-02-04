package gg.cristalix.maga.packages.history;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.UUID;

public class Test {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        TestPlayerData data = new TestPlayerData(UUID.randomUUID(), 1, 10);

    }

}
