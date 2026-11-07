package su.catlean.client.services.client;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.utility.player.AutoFishModule;

public class ServiceComponent108 implements Runnable {

    public static final ServiceComponent108 INSTANCE;

    private ServiceComponent108() {
    }

    public void run() {
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        SharedKt.getPlayer().method_6104(Hand.field_5808);
        AutoFishModule.getServiceComponent10().executeAction();
    }

    static {
        INSTANCE = new ServiceComponent108();
    }

}
