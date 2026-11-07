package su.catlean.mixins.render;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.GofraState;
import su.catlean.api.event.events.render.FrameBufferEvent;

public class MixinRenderPhase {

    public MixinRenderPhase() {
    }

    public void getHook(CallbackInfoReturnable cir) {
        cir.setReturnValue(FrameBufferEvent.INSTANCE.getFrameBuffer());
        cir.cancel();
    }

}
