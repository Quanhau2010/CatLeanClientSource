package su.catlean.mixins.client;

import net.minecraft.class_2708;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.network.SendMessageEvent;
import su.catlean.api.event.events.player.FlagEvent;
import su.catlean.api.event.events.world.WorldUpdateEvent;

public class ClientPacketListenerMixin {

    public ClientPacketListenerMixin() {
    }

    private void onPlayerPositionLookHook(class_2708 packet, CallbackInfo ci) {
        ci.cancel();
    }

    private void sendChatMessageHook(String message, CallbackInfo ci) {
        ci.cancel();
    }

    private void onBlockUpdateHook(CallbackInfo ci) {
    }

    private void onChunkDeltaUpdateHook(CallbackInfo ci) {
    }

}
