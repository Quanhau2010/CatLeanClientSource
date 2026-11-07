package su.catlean.mixins.render;

import net.minecraft.class_10014;
import net.minecraft.class_11659;
import net.minecraft.class_12075;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.render.CrystalRenderEvent;
import su.catlean.api.event.events.render.CrystalYOffsetEvent;
import su.catlean.api.event.events.render.SetCrystalScaleEvent;

public class EndCrystalRendererMixin {

    public EndCrystalRendererMixin() {
    }

    private void renderHook(class_10014 endCrystalEntityRenderState, MatrixStack matrixStack, class_11659 orderedRenderCommandQueue, class_12075 cameraRenderState, CallbackInfo ci) {
        ci.cancel();
    }

    private void scaleHook(class_10014 endCrystalEntityRenderState, MatrixStack matrixStack, class_11659 orderedRenderCommandQueue, class_12075 cameraRenderState, CallbackInfo ci) {
        float factor = SetCrystalScaleEvent.INSTANCE.getScale();
        matrixStack.method_22905(factor, factor, factor);
    }

    private static void getYOffsetHook(float age, CallbackInfoReturnable cir) {
        cir.setReturnValue(Float.valueOf(CrystalYOffsetEvent.INSTANCE.getOffset()));
    }

}
