package su.catlean.mixins.player;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.player.EventPlayerTravel;
import su.catlean.api.event.events.player.EventPostPlayerTravel;
import su.catlean.api.event.events.player.PostAttackEvent;
import su.catlean.api.event.events.player.ReachStateEvent;
import su.catlean.api.event.events.player.ShouldDismountEvent;

public class PlayerMixin {

    public PlayerMixin() {
    }

    public void getBlockInteractionRangeHook(CallbackInfoReturnable cir) {
        cir.setReturnValue(Double.valueOf(ReachStateEvent.INSTANCE.getBlockRange()));
    }

    public void getEntityInteractionRangeHook(CallbackInfoReturnable cir) {
        cir.setReturnValue(Double.valueOf(ReachStateEvent.INSTANCE.getEntityRange()));
    }

    public void attackAHook(CallbackInfo callbackInfo) {
        PostAttackEvent.INSTANCE.call();
    }

    private void onTravelhookPre(Vec3d movementInput, CallbackInfo ci) {
        ci.cancel();
    }

    private void onTravelhookPost(Vec3d movementInput, CallbackInfo ci) {
        EventPostPlayerTravel.INSTANCE.call();
    }

    protected void shouldDismountHook(CallbackInfoReturnable cir) {
        cir.setReturnValue(Boolean.valueOf(false));
    }

}
