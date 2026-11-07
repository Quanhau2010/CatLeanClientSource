package su.catlean.mixins.client;

import net.minecraft.class_1269;
import net.minecraft.class_1713;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.player.AttackBlockEvent;
import su.catlean.api.event.events.player.BreakBlockEvent;
import su.catlean.api.event.events.player.ClickSlotEvent;
import su.catlean.api.event.events.player.InteractBlockEvent;
import su.catlean.api.event.events.player.PickUpBlockEvent;
import su.catlean.api.event.events.player.PostInteractItemEvent;
import su.catlean.api.event.events.player.PreInteractItemEvent;
import su.catlean.api.event.events.player.StopUsingItemEvent;
import su.catlean.api.event.events.world.UpdateBlockBreakingProgressEvent;

public class MultiPlayerGameModeMixin {

    public MultiPlayerGameModeMixin() {
    }

    public void updateBlockBreakingProgress(BlockPos pos, Direction direction, CallbackInfoReturnable cir) {
        cir.setReturnValue(Boolean.valueOf(false));
    }

    private void attackBlockHook(BlockPos pos, Direction direction, CallbackInfoReturnable cir) {
        cir.setReturnValue(Boolean.valueOf(false));
    }

    public void breakBlockHook(BlockPos pos, CallbackInfoReturnable cir) {
        cir.setReturnValue(Boolean.valueOf(false));
    }

    public void clickSlotHook(int syncId, int slotId, int button, class_1713 actionType, PlayerEntity player, CallbackInfo ci) {
        ci.cancel();
    }

    public void stopUsingItemHook(PlayerEntity player, CallbackInfo ci) {
        ci.cancel();
    }

    private void interactBlockHook(ClientPlayerEntity player, Hand hand, class_3965 hitResult, CallbackInfoReturnable cir) {
        cir.setReturnValue(class_1269.field_5811);
    }

    private void preInteractItemHook(PlayerEntity player, Hand hand, CallbackInfoReturnable cir) {
        cir.setReturnValue(class_1269.field_5811);
        cir.cancel();
    }

    private void postInteractItemHook(PlayerEntity player, Hand hand, CallbackInfoReturnable cir) {
        PostInteractItemEvent.INSTANCE.call();
    }

    public void pickItemFromBlockHook(BlockPos pos, boolean includeData, CallbackInfo ci) {
        ci.cancel();
    }

}
