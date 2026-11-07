package su.catlean.mixins.render;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import net.minecraft.class_11658;
import net.minecraft.class_4184;
import net.minecraft.class_4604;
import net.minecraft.class_9779;
import net.minecraft.class_9909;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.FrustrumEvent;
import su.catlean.api.event.events.render.SetupTerrainEvent;
import su.catlean.api.event.events.render.WeatherRenderEvent;
import su.catlean.api.event.events.world.ApplyFogEvent;

public class LevelRendererMixin {

    public LevelRendererMixin() {
    }

    private boolean renderHook(boolean spectator) {
        if (!(SetupTerrainEvent.INSTANCE.call())) {
            if (spectator) {
            } else {
            }
        }
        return false;
    }

    private void frustrumHook(class_4184 camera, class_4604 frustum, class_9779 tickCounter, class_11658 renderStates, CallbackInfo ci) {
        FrustrumEvent.INSTANCE.setFrustrum(frustum);
        FrustrumEvent.INSTANCE.call();
    }

    private Vector4f getFogColorHook(Vector4f value) {
        if (ApplyFogEvent.INSTANCE.call()) {
            return ApplyFogEvent.INSTANCE.getColorVec();
        }
        return value;
    }

    private void renderWeatherHook(class_9909 frameGraphBuilder, GpuBufferSlice gpuBufferSlice, CallbackInfo ci) {
        ci.cancel();
    }

}
