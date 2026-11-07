package su.catlean.mixins.client;

import net.minecraft.class_1058;
import net.minecraft.class_11659;
import net.minecraft.class_4597;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.RenderFireOverlayEvent;
import su.catlean.api.event.events.render.RenderFloatingItemEvent;
import su.catlean.api.event.events.render.RenderInWallOverlayEvent;
import su.catlean.api.event.events.render.RenderUnderwaterOverlayEvent;

public class GameOverlayRendererMixin {

    public GameOverlayRendererMixin() {
    }

    private static void renderFireOverlayHook(MatrixStack matrices, class_4597 vertexConsumers, class_1058 sprite, CallbackInfo ci) {
        ci.cancel();
    }

    private void renderFloatingItemHook(MatrixStack matrices, float tickProgress, class_11659 queue, CallbackInfo ci) {
        ci.cancel();
    }

    private static void renderUnderwaterOverlayHook(MinecraftClient client, MatrixStack matrices, class_4597 vertexConsumers, CallbackInfo ci) {
        ci.cancel();
    }

    private static void renderInWallOverlayHook(class_1058 sprite, MatrixStack matrices, class_4597 vertexConsumers, CallbackInfo ci) {
        ci.cancel();
    }

}
