package su.catlean.mixins.render;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import su.catlean.api.event.events.player.FreecamStateEvent;
import su.catlean.api.event.events.render.CameraOffsetEvent;
import su.catlean.api.event.events.render.SetupTerrainEvent;

public abstract class CameraMixin {

    private boolean field_18719;

    public CameraMixin() {
    }

    protected float method_19318(float arg0) {
    }

    private void modifyCameraDistance(Args args) {
        args.set(0, Float.valueOf(this.method_19318(CameraOffsetEvent.INSTANCE.getOffset())));
    }

    private void onClipToSpace(float f, CallbackInfoReturnable cir) {
        cir.setReturnValue(Float.valueOf(CameraOffsetEvent.INSTANCE.getOffset()));
    }

    private void updateHook(World area, Entity focusedEntity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo ci) {
        this.field_18719 = true;
    }

    private void setRotationHook(Args args) {
        new Object[2][0] = Float.valueOf(FreecamStateEvent.INSTANCE.getYaw());
        new Object[2][1] = Float.valueOf(FreecamStateEvent.INSTANCE.getPitch());
        args.setAll(new Object[2]);
    }

    private void setPosHook(Args args) {
        new Object[3][0] = Double.valueOf(FreecamStateEvent.INSTANCE.getX());
        new Object[3][1] = Double.valueOf(FreecamStateEvent.INSTANCE.getY());
        new Object[3][2] = Double.valueOf(FreecamStateEvent.INSTANCE.getZ());
        args.setAll(new Object[3]);
    }

}
