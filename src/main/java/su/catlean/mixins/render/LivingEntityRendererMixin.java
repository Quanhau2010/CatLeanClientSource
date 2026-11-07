package su.catlean.mixins.render;

import java.awt.Color;
import java.util.Objects;
import net.minecraft.class_10042;
import net.minecraft.class_10055;
import net.minecraft.class_11659;
import net.minecraft.class_12075;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import su.catlean.api.event.events.render.EntityAlphaEvent;
import su.catlean.api.event.events.render.LookRenderEvent;

public class LivingEntityRendererMixin {

    private class_10042 prevState;

    public LivingEntityRendererMixin() {
    }

    private void renderHook(class_10042 state, MatrixStack matrixStack, class_11659 orderedRenderCommandQueue, class_12075 cameraRenderState, CallbackInfo ci) {
        this.prevState = state;
        class_10055 class10055 = ((class_10055) state);
        LookRenderEvent.INSTANCE.call(state.field_53447, state.field_53448, state.field_53446);
        state.field_53447 = LookRenderEvent.INSTANCE.getYaw();
        state.field_53448 = LookRenderEvent.INSTANCE.getPitch();
        state.field_53446 = LookRenderEvent.INSTANCE.getBodyYaw();
    }

    private void renderHook(Args args) {
        class_10042 class10042 = this.prevState;
        class_10055 class10055 = ((class_10055) class10042);
        args.set(6, Integer.valueOf(this.withAlpha(new Color(654311423), EntityAlphaEvent.INSTANCE.getAlpha()).getRGB()));
    }

    private Color withAlpha(Color c, float alpha) {
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), (255.0F * alpha));
    }

}
