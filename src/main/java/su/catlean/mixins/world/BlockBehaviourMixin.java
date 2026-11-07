package su.catlean.mixins.world;

import net.minecraft.block.BlockState;
import net.minecraft.class_1922;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.player.CalcBlockBreakingDeltaEvent;

public class BlockBehaviourMixin {

    public BlockBehaviourMixin() {
    }

    public void calcBlockBreakingDeltaHook(BlockState state, PlayerEntity player, class_1922 world, BlockPos pos, CallbackInfoReturnable ci) {
        ci.setReturnValue(Float.valueOf(CalcBlockBreakingDeltaEvent.INSTANCE.getDelta()));
    }

}
