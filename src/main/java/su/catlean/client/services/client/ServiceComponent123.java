package su.catlean.client.services.client;

import net.minecraft.client.MinecraftClient;
import su.catlean.SharedKt;

public class ServiceComponent123 implements Runnable {

    private final int countValue;

    public ServiceComponent123(int $delay) {
        this.countValue = $delay;
    }

    public void run() {
        Thread.sleep(this.countValue);
        int var6 = 0;
        SharedKt.getMc().method_40000((Runnable) ServiceComponent63.INSTANCE);
    }

}
