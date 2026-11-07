package su.catlean.mixins.render;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.GofraState;

public class GlStateManagerMixin {

    public GlStateManagerMixin() {
    }

    private static void _glBindFramebuffer(CallbackInfo ci) {
        ci.cancel();
    }

}
