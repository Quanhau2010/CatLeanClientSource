package su.catlean.mixins.render;

import java.util.Map;
import net.minecraft.client.gui.DrawContext;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.BossBarRenderEvent;

public class BossHealthOverlayMixin {

    private Map field_2060;

    public BossHealthOverlayMixin() {
    }

    private void renderHook(DrawContext context, CallbackInfo ci) {
        ci.cancel();
    }

}
