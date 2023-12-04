package gg.cristalix.maga.service;

import ru.cristalix.core.CoreApi;
import ru.cristalix.core.CoreCredentials;
import ru.cristalix.core.IPlatform;
import ru.cristalix.core.JavaTaskScheduler;
import ru.cristalix.core.microservice.MicroServicePlatform;
import ru.cristalix.core.network.ISocketClient;
import ru.cristalix.core.network.PacketNameHelper;
import ru.cristalix.core.network.SocketClient;
import ru.cristalix.core.realm.IRealmService;
import ru.cristalix.core.realm.RealmService;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;


public class MagaServer {

    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

    private ISocketClient socketClient;

    public void start() {
        IPlatform platform = new MicroServicePlatform(this.executorService);
        // internal init for start service
        CoreApi api = CoreApi.get();
        api.init(platform);
        Logger logger = platform.getRootLogger();
        this.socketClient = new SocketClient(logger);
        api.setSocketClient(socketClient);
        socketClient.setAutoReconnect(true);

        JavaTaskScheduler.setScheduler(new JavaTaskScheduler() {
            @Override
            public void invoke(Runnable runnable) {
                executorService.execute(runnable);
            }
        });

        PacketNameHelper.defaultInit();

        CoreApi.get().registerService(IRealmService.class, new RealmService(CoreApi.get().bus(), this.socketClient));

        // connect to tower
        String towerIp = System.getenv().getOrDefault("TOWER_IP", "tower.c7x.dev");
        String textPort = Objects.requireNonNull(System.getenv("TOWER_PORT"), "TOWER_PORT");
        int towerPort = Integer.parseInt(textPort, 10);
        socketClient.connect(towerIp, towerPort, CoreCredentials.fromEnvironment());
        socketClient.waitForHandshake();

        registerCapabilities(socketClient);
        registerListeners(socketClient);
    }

    private void registerCapabilities(ISocketClient socketClient) {

    }

    private void registerListeners(ISocketClient socketClient) {

    }
}
