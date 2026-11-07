package su.catlean.mixins.render;

import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import net.minecraft.class_3695;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.render.DarknessEffectEvent;
import su.catlean.api.event.events.render.LightMapUpdateEvent;

public class LightTextureMixin {

    private GpuTexture field_57927;

    public LightTextureMixin() {
    }

    private void getDarknessHook(LivingEntity entity, float factor, float tickProgress, CallbackInfoReturnable cir) {
        cir.setReturnValue(Float.valueOf(0.0F));
    }

    private void updateHook(float tickProgress, CallbackInfo ci, class_3695 profiler) {
        RenderSystem.getDevice().createCommandEncoder().clearColorTexture(this.field_57927, -1);
        profiler.method_15407();
        ci.cancel();
    }

}
