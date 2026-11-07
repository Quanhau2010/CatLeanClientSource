package su.catlean.mixins.render;

import net.minecraft.class_10090;
import net.minecraft.class_11659;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.MapRenderEvent;

public class MapRendererMixin {

    public MapRendererMixin() {
    }

    public void drawHook(class_10090 state, MatrixStack matrices, class_11659 queue, boolean bl, CallbackInfo ci) {
        ci.cancel();
    }

}
