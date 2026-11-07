package su.catlean.mixins.render;

import java.util.Collection;
import net.minecraft.class_266;
import net.minecraft.class_9779;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.CrosshairRenderEvent;
import su.catlean.api.event.events.render.HotBarRenderEventPost;
import su.catlean.api.event.events.render.HotBarRenderEventPre;
import su.catlean.api.event.events.render.ItemNameRenderEvent;
import su.catlean.api.event.events.render.NauseaRenderEvent;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.RenderPortalOverlayEvent;
import su.catlean.api.event.events.render.RenderVignetteOverlayEvent;
import su.catlean.api.event.events.render.ScoreBoardRenderEvent;
import su.catlean.api.event.events.render.StatusEffectsRenderEvent;

public abstract class GuiMixin {

    public GuiMixin() {
    }

    public void renderHook(DrawContext context, class_9779 tickCounter, CallbackInfo ci) {
        Render2DEvent.INSTANCE.call(context);
    }

    public void renderHeldItemTooltipHook(DrawContext context, CallbackInfo ci) {
        ci.cancel();
    }

    private void renderScoreboardSidebarHook(DrawContext context, class_266 objective, CallbackInfo ci) {
        ci.cancel();
    }

    private void renderVignetteOverlayHook(DrawContext context, Entity entity, CallbackInfo ci) {
        ci.cancel();
    }

    private void renderPortalOverlayHook(DrawContext context, float nauseaStrength, CallbackInfo ci) {
        ci.cancel();
    }

    private void renderStatusEffectOverlayHook(DrawContext context, class_9779 tickCounter, CallbackInfo ci) {
        Collection collection = MinecraftClient.method_1551().player.method_6026();
        ci.cancel();
    }

    private void renderNauseaOverlayHook(DrawContext context, float nauseaStrength, CallbackInfo ci) {
        ci.cancel();
    }

    public void renderCrosshair(DrawContext context, class_9779 tickCounter, CallbackInfo ci) {
        ci.cancel();
    }

    public void renderHotbarHookPre(DrawContext context, class_9779 tickCounter, CallbackInfo ci) {
        HotBarRenderEventPre.INSTANCE.call();
    }

    public void renderHotbarHookPost(DrawContext context, class_9779 tickCounter, CallbackInfo ci) {
        HotBarRenderEventPost.INSTANCE.call();
    }

}
