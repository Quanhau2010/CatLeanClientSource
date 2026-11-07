package su.catlean.mixins.render;

import net.minecraft.class_10017;
import net.minecraft.class_11659;
import net.minecraft.class_12075;
import net.minecraft.class_4604;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.GofraState;
import su.catlean.api.event.events.render.RenderNameTagEvent;
import su.catlean.api.event.events.render.ShouldRenderEntityEvent;

public abstract class EntityRendererMixin {

    public EntityRendererMixin() {
    }

    private void renderLabelIfPresent(class_10017 state, MatrixStack matrices, class_11659 queue, class_12075 cameraRenderState, CallbackInfo ci) {
        ci.cancel();
    }

    public void shouldRender(Entity entity, class_4604 frustum, double x, double y, double z, CallbackInfoReturnable cir) {
        cir.setReturnValue(Boolean.valueOf(0));
    }

}
