package su.catlean.mixins.client;

import net.minecraft.class_1041;
import net.minecraft.class_11910;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.client.InputEvent.Device;
import su.catlean.interfaces.IMouse;

public class MixinMouseHandler implements IMouse {

    private double field_1795;
    private double field_1794;

    public MixinMouseHandler() {
    }

    public void onMouseButtonHook(long window, class_11910 input, int action, CallbackInfo ci) {
        if (!(action)) {
        } else {
        }
        ci.cancel();
    }

    public void setPosition(int xp, int yp) {
        this.field_1795 = xp;
        this.field_1794 = yp;
    }

}
