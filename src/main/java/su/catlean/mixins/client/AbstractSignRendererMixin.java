package su.catlean.mixins.client;

import net.minecraft.class_11659;
import net.minecraft.class_11971;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.SignTextRenderEvent;

public class AbstractSignRendererMixin {

    public AbstractSignRendererMixin() {
    }

    public void renderTextHook(class_11971 renderState, MatrixStack matrices, class_11659 queue, boolean front, CallbackInfo ci) {
        ci.cancel();
    }

}
