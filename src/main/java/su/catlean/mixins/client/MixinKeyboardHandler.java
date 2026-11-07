package su.catlean.mixins.client;

import net.minecraft.class_1041;
import net.minecraft.class_11908;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.client.InputEvent.Device;

public class MixinKeyboardHandler {

    public MixinKeyboardHandler() {
    }

    private void onKey(long window, int action, class_11908 input, CallbackInfo ci) {
        if (!(action)) {
        } else {
            if (action == 1) {
            } else {
            }
        }
        ci.cancel();
    }

}
