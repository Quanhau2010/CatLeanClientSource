package su.catlean.mixins.client;

import com.mojang.authlib.GameProfile;
import net.minecraft.class_1313;
import net.minecraft.class_3532;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.network.SlowDownEvent;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PostPlayerUpdateEvent;
import su.catlean.api.event.events.player.PostSyncEvent;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.event.events.player.PushOutOfBlocksEvent;
import su.catlean.api.event.events.player.ShouldStopSprintingEvent;
import su.catlean.api.event.events.player.UsingItemEvent;

public abstract class LocalPlayerMixin extends AbstractClientPlayerEntity {

    public LocalPlayerMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    public void tickHook(CallbackInfo info) {
        info.cancel();
    }

    public void postTickHook(CallbackInfo info) {
        PostPlayerUpdateEvent.INSTANCE.call();
    }

    private void sendMovementPacketsHook(CallbackInfo info) {
        info.cancel();
    }

    private void sendMovementPacketsPostHook(CallbackInfo info) {
        PostSyncEvent.INSTANCE.call();
    }

    public void onMoveHook(class_1313 movementType, Vec3d movement, CallbackInfo ci) {
        double var4 = this.getX();
        double var6 = this.getZ();
        this.method_5784(movementType, new Vec3d(MoveEvent.INSTANCE.getX(), MoveEvent.INSTANCE.getY(), MoveEvent.INSTANCE.getZ()));
        this.field_5994 = (this.field_5994 + (class_3532.method_61344((this.getX() - var4), (this.getZ() - var6)) * 0.6F));
        ci.cancel();
    }

    public void shouldSlowDownHook(CallbackInfoReturnable cir) {
        cir.setReturnValue(Boolean.valueOf(0));
    }

    public void isUsingItemHook(CallbackInfoReturnable cir) {
        cir.setReturnValue(Boolean.valueOf(1));
    }

    private void onPushOutOfBlocksHook(double x, double d, CallbackInfo info) {
        info.cancel();
    }

    public void shouldStopSprintingHook(CallbackInfoReturnable cir) {
        cir.setReturnValue(Boolean.valueOf(0));
    }

}
