package su.catlean.mixins.client;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.player.KeyboardInputEvent;

public class KeyboardInputMixin {

    public KeyboardInputMixin() {
    }

    private void tickHook(CallbackInfo ci) {
        ci.cancel();
    }

}
