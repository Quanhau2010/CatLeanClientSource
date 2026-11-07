package su.catlean.client.features.modules.utility.misc;

import kotlin.text.StringsKt;
import net.minecraft.class_2720;
import net.minecraft.class_2856;
import net.minecraft.class_2856.class_2857;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.Packet;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;

public class AntiResourcePackModule extends Module {

    public static final AntiResourcePackModule INSTANCE;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static int countValue;

    private AntiResourcePackModule() {
        super("anti-resource-pack", SubCategoriesKt.getMiscUtilityCategory());
    }

    public void onReceivePacket(ReceivePacket e) {
        if (e.getPacket() instanceof class_2720) {
            enabledFlag = 1;
            enabledFlag2 = 0;
            countValue = 0;
            e.cancel();
        }
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        if (SharedKt.getNetwork().method_45734() != null && SharedKt.getNetwork().method_45734().field_3761 != null) {
        } else {
        }
        if (StringsKt.contains$default((CharSequence) SharedKt.getNetwork().method_45734().field_3761, (CharSequence) "crystalpvp.cc") == 1) {
            this.updateValue2();
        }
        int var13 = countValue;
        countValue = (var13 + 1);
        if (countValue > (15 + (Math.random() * 15)) && !(enabledFlag2)) {
            PacketPacketHelper.handlePacket((Packet) new class_2856(SharedKt.getPlayer().method_5667(), class_2857.field_13016));
            enabledFlag2 = 1;
        }
        PacketPacketHelper.handlePacket((Packet) new class_2856(SharedKt.getPlayer().method_5667(), class_2857.field_13017));
        enabledFlag = 0;
    }

    static {
        INSTANCE = new AntiResourcePackModule();
    }

}
