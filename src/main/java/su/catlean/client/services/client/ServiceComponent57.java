package su.catlean.client.services.client;

import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.player.AutoRespawnModule;

public class ServiceComponent57 implements Runnable {

    private final int countValue;
    private static String textValue;

    public ServiceComponent57(int $delay) {
        this.countValue = $delay;
    }

    public void run() {
        Thread.sleep(this.countValue);
        int var6 = 0;
        AutoRespawnModule.INSTANCE.updateValue();
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
