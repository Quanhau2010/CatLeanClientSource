package su.catlean.client.features.modules.utility.equip;

import net.minecraft.class_1661;
import net.minecraft.class_2735;
import net.minecraft.class_2868;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.Packet;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;

public class NoServerSlotModule extends Module {

    public static final NoServerSlotModule INSTANCE;

    private NoServerSlotModule() {
        super("no-server-slot", SubCategoriesKt.getEquipCategory());
    }

    public void onReceivePacket(ReceivePacket event) {
        if (__UNDEF_KEY__ != null) {
            if (event.getPacket() instanceof class_2735) {
                event.cancel();
                PacketPacketHelper.handlePacket(((Packet) new class_2868(SharedKt.getPlayer().method_31548().method_67532())));
            }
        }
    }

    static {
        INSTANCE = new NoServerSlotModule();
    }

}
