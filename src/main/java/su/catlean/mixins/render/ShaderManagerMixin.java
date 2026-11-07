package su.catlean.mixins.render;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.ShaderApplyEvent;

public abstract class ShaderManagerMixin {

    public ShaderManagerMixin() {
    }

    private void applyResourcesHook(CallbackInfo info) {
        ShaderApplyEvent.INSTANCE.call();
    }

}
