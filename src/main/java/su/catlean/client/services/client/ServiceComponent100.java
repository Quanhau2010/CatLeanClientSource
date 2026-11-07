package su.catlean.client.services.client;

import net.minecraft.client.MinecraftClient;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;

public class ServiceComponent100 implements Runnable {

    private final int countValue;
    private static String[] textValueArray;

    public ServiceComponent100(int $delay) {
        this.countValue = $delay;
    }

    public void run() {
        Thread.sleep(this.countValue);
        int var6 = 0;
        SharedKt.getMc().method_40000((Runnable) ServiceComponent108.INSTANCE);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
