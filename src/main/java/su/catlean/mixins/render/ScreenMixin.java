package su.catlean.mixins.render;

import java.util.List;
import net.minecraft.client.gui.DrawContext;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.FilesDraggedEvent;
import su.catlean.api.event.events.render.RenderGuiBackgroundEvent;
import su.catlean.api.event.events.render.ScreenMouseCoordsEvent;

public class ScreenMixin {

    public ScreenMixin() {
    }

    private void renderInGameBackground(DrawContext context, CallbackInfo ci) {
        ci.cancel();
    }

    public void renderHook(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        ScreenMouseCoordsEvent.INSTANCE.call(mouseX, mouseY);
    }

    public void filesDragged(List paths, CallbackInfo ci) {
        FilesDraggedEvent.INSTANCE.call(paths);
    }

}
