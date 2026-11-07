package su.catlean.mixins.render;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.FlipFrameEvent;

public abstract class RenderSystemMixin {

    public RenderSystemMixin() {
    }

    private static void flipFrameHook(CallbackInfo ci) {
        FlipFrameEvent.INSTANCE.call();
    }

}
