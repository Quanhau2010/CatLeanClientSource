package su.catlean.mixins.render;

import net.minecraft.class_10055;
import net.minecraft.class_11659;
import net.minecraft.class_12075;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.RenderNameTagEvent;

public class AvatarRendererMixin {

    public AvatarRendererMixin() {
    }

    private void renderLabelIfPresent(class_10055 playerEntityRenderState, MatrixStack matrixStack, class_11659 orderedRenderCommandQueue, class_12075 cameraRenderState, CallbackInfo ci) {
        ci.cancel();
    }

}
