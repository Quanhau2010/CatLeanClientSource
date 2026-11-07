package su.catlean.mixins.render;

import net.minecraft.class_10017;
import net.minecraft.class_11659;
import net.minecraft.class_12075;
import net.minecraft.class_4604;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.render.RenderEntityEvent;
import su.catlean.api.event.events.render.RenderFireOnEntityEvent;

public class EntityRenderDispatcherMixin {

    public EntityRenderDispatcherMixin() {
    }

    private void onRenderHead(class_10017 renderState, class_12075 cameraRenderState, double d, double e, double f, MatrixStack matrixStack, class_11659 orderedRenderCommandQueue, CallbackInfo ci) {
        renderState.field_53335 = false;
    }

    public void onRenderEntity(Entity entity, class_4604 frustum, double x, double y, double z, CallbackInfoReturnable cir) {
        cir.setReturnValue(Boolean.valueOf(false));
    }

}
