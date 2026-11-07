package su.catlean.mixins.client;

import net.minecraft.class_8042;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.Packet;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.network.AfterReceivePacket;

public class MixinNetworkThreadUtils {

    private Packet comp_4822;

    public MixinNetworkThreadUtils() {
    }

    private void afterPacketApply(CallbackInfo ci) {
        if (MinecraftClient.method_1551().player == null) {
            return;
        }
        Packet packet = this.comp_4822;
        if (packet instanceof class_8042) {
            class_8042 class8042 = ((class_8042) packet);
            class8042.method_48324().forEach(this::lambda$afterPacketApply$0);
        } else {
        }
    }

}
