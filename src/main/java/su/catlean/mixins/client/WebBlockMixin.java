package su.catlean.mixins.client;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.player.CobWebEvent;

public class WebBlockMixin {

    public WebBlockMixin() {
    }

    public void onEntityCollisionHook(CallbackInfo ci) {
        ci.cancel();
    }

}
