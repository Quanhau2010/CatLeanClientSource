package su.catlean.mixins.client;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.RenderSpawnerEntityEvent;

public class SpawnerRendererMixin {

    public SpawnerRendererMixin() {
    }

    private static void renderHook(CallbackInfo ci) {
        ci.cancel();
    }

}
