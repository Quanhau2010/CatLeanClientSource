package su.catlean.mixins.render;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.class_9779;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.player.UpdateCrosshairTarget;
import su.catlean.api.event.events.render.BasicProjectionMatrixEvent;
import su.catlean.api.event.events.render.HurtTiltEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.render.RenderHandEvent;
import su.catlean.api.event.events.render.RenderScreenEvent;
import su.catlean.api.event.events.render.ShowFloatingItemEvent;

public abstract class GameRendererMixin {

    public GameRendererMixin() {
    }

    public float method_32796() {
    }

    private void render3dHook(class_9779 renderTickCounter, CallbackInfo ci, Matrix4f projection) {
        class_4184 var4 = MinecraftClient.method_1551().field_1773.method_19418();
        MatrixStack matrices = new MatrixStack();
        RenderSystem.getModelViewStack().pushMatrix().mul(matrices.method_23760().method_23761());
        matrices.method_22907(class_7833.field_40714.rotationDegrees(var4.method_19329()));
        matrices.method_22907(class_7833.field_40716.rotationDegrees((var4.method_19330() + 180.0F)));
        Render3DEvent.INSTANCE.call(matrices, projection);
        RenderSystem.getModelViewStack().popMatrix();
    }

    private void onUpdateTargetedEntity(float tickDelta, CallbackInfo info) {
        info.cancel();
    }

    private void render2dHook(class_9779 tickCounter, boolean tick, CallbackInfo ci, DrawContext dc) {
        RenderScreenEvent.INSTANCE.call(dc);
    }

    private void renderHand(float tickProgress, boolean sleeping, Matrix4f positionMatrix, CallbackInfo ci) {
        ci.cancel();
    }

    private void showFloatingItemHook(ItemStack floatingItem, CallbackInfo info) {
        info.cancel();
    }

    private void tiltViewWhenHurtHook(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        ci.cancel();
    }

    private void getBasicProjectionMatrixHook(float fovDegrees, CallbackInfoReturnable cir) {
        BasicProjectionMatrixEvent.INSTANCE.setFov(fovDegrees);
        Matrix4f var3 = new Matrix4f();
        float var4 = BasicProjectionMatrixEvent.INSTANCE.getZoom();
        float var5 = BasicProjectionMatrixEvent.INSTANCE.getZoomX();
        float var6 = BasicProjectionMatrixEvent.INSTANCE.getZoomY();
        float var7 = BasicProjectionMatrixEvent.INSTANCE.getFov();
        if (var4 != 1.0F) {
            var3.translate(0.0F);
            var3.scale(1.0F);
        }
        cir.setReturnValue(var3.perspective((var7 * 0.017453292F), BasicProjectionMatrixEvent.INSTANCE.getRatio(), 0.05F, this.method_32796()));
        cir.cancel();
    }

}
