package su.catlean.mixins.world;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import su.catlean.api.event.events.player.BoxContractEvent;
import su.catlean.api.event.events.player.EntityPushEvent;
import su.catlean.api.event.events.player.FixVelocityEvent;
import su.catlean.api.event.events.player.SetPoseEvent;
import su.catlean.interfaces.IEntity;

public abstract class EntityMixin implements IEntity {

    private Vec3d field_22467;

    public EntityMixin() {
    }

    public Box method_5829() {
    }

    public Vec3d catLean$getPosition() {
        return this.field_22467;
    }

    public void setPoseHook(CallbackInfoReturnable cir) {
        cir.cancel();
        cir.setReturnValue(SetPoseEvent.INSTANCE.getPose());
    }

    public void updateVelocityHook(float speed, Vec3d movementInput, CallbackInfo ci) {
        ci.cancel();
        MinecraftClient.method_1551().player.method_18799(MinecraftClient.method_1551().player.method_18798().method_1019(FixVelocityEvent.INSTANCE.getVelocity()));
    }

    public void pushAwayFromHook(Args args) {
        args.set(0, Double.valueOf(0.0D));
        args.set(1, Double.valueOf(0.0D));
        args.set(2, Double.valueOf(0.0D));
    }

    public void getBoundingBoxHook(CallbackInfoReturnable cir) {
        cir.setReturnValue(BoxContractEvent.INSTANCE.getValue());
        cir.cancel();
    }

}
