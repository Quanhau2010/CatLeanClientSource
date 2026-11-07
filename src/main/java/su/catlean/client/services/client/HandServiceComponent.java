package su.catlean.client.services.client;

import net.minecraft.class_1269;
import net.minecraft.class_1713;
import net.minecraft.class_2815;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.client.services.network.PacketPacketHelper;

public class HandServiceComponent {

    private static String textValue;

    public static void executeAction(int id, int button, class_1713 type, boolean closeAfter) {
        if (!(__UNDEF_KEY__)) {
            if (SharedKt.getMc().interactionManager != null) {
                SharedKt.getMc().interactionManager.method_2906(SharedKt.getPlayer().field_7512.field_7763, id, button, type, ((PlayerEntity) SharedKt.getPlayer()));
            } else {
            }
        }
        PacketPacketHelper.handlePacket(((Packet) new class_2815(SharedKt.getPlayer().field_7512.field_7763)));
    }

    public static class_1269 resolveMinecraftObject(Hand hand, float y, float p) {
        class_1269 class1269 = SharedKt.getInteractionManager().method_2919(((PlayerEntity) SharedKt.getPlayer()), hand);
        return class1269;
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
