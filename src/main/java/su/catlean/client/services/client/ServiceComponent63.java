package su.catlean.client.services.client;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;

public class ServiceComponent63 implements Runnable {

    public static final ServiceComponent63 INSTANCE;

    private ServiceComponent63() {
    }

    public void run() {
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        SharedKt.getPlayer().method_6104(Hand.field_5808);
    }

    static {
        INSTANCE = new ServiceComponent63();
    }

}
