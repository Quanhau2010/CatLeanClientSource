package su.catlean.mixins.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.class_2598;
import net.minecraft.class_8042;
import net.minecraft.class_8762;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.Packet;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.network.AddHandlersEvent;
import su.catlean.api.event.events.network.AfterSendPacket;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;

public class ConnectionMixin {

    public ConnectionMixin() {
    }

    public void channelRead0(ChannelHandlerContext channelHandlerContext, Packet packet, CallbackInfo info) {
        if (MinecraftClient.method_1551().player == null || packet == null) {
            return;
        }
        if (packet instanceof class_8042) {
            class_8042 var4 = (class_8042) packet;
            var4.method_48324().forEach(this::lambda$channelRead0$0);
        } else {
            info.cancel();
        }
    }

    private void onSendPacketPre(Packet packet, CallbackInfo info) {
        if (MinecraftClient.method_1551().player == null) {
            return;
        }
        info.cancel();
    }

    private void onSendPacketPost(Packet packet, CallbackInfo info) {
        if (MinecraftClient.method_1551().player == null) {
            return;
        }
        info.cancel();
    }

    private static void addHandlersHook(ChannelPipeline pipeline, class_2598 side, boolean local, class_8762 packetSizeLogger, CallbackInfo ci) {
        AddHandlersEvent.INSTANCE.call(new AtomicReference(pipeline), side, local);
    }

}
