package su.catlean.client.services.client;

import kotlin.Unit;
import net.minecraft.class_2824;
import net.minecraft.class_2879;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;

public class ServiceComponent131 {

    public static final ServiceComponent131 INSTANCE;
    private static int countValue;
    private static final ServiceComponent10 serviceComponent10;

    private ServiceComponent131() {
    }

    public void executeAction(int offset, int maxAttacks, int delay, boolean swingOnce) {
        serviceComponent10.executeAction();
        int index = offset;
        int index2 = (countValue + index);
        Entity entity = SharedKt.getWorld().method_8469(index2);
        if (entity != null) {
            if (entity instanceof EndCrystalEntity) {
                class_2824 class2824 = class_2824.method_34206(SharedKt.getPlayer(), SharedKt.getPlayer().method_5715());
                ServiceComponent93.executeAction(class2824, index2);
                SharedKt.getNetwork().method_52787(((Packet) class2824));
                if (index == maxAttacks) {
                    SharedKt.getNetwork().method_52787(((Packet) new class_2879(Hand.field_5808)));
                }
            }
        }
    }

    public Unit resolveUnit(int id) {
        if (id > countValue) {
            countValue = id;
        } else {
        }
        return null;
    }

    static {
        INSTANCE = new ServiceComponent131();
        countValue = -1;
        serviceComponent10 = new ServiceComponent10();
    }

}
