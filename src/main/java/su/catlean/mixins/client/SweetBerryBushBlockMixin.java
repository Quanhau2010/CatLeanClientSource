package su.catlean.mixins.client;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.world.SweetBerryBushCollisionEvent;

public class SweetBerryBushBlockMixin {

    public SweetBerryBushBlockMixin() {
    }

    public void onEntityCollisionHook(CallbackInfo ci) {
        ci.cancel();
    }

}
