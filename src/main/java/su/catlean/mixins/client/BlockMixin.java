package su.catlean.mixins.client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.GofraState;
import su.catlean.api.event.events.render.XRayBlockEvent;
import su.catlean.api.event.events.world.SlipperinessEvent;
import su.catlean.api.event.events.world.VelocityMultiplierEvent;

public class BlockMixin {

    public BlockMixin() {
    }

    public void getVelocityMultiplierHook(CallbackInfoReturnable cir) {
        cir.setReturnValue(Float.valueOf(Blocks.field_10566.method_23349()));
    }

    public void getSlipperinessHook(CallbackInfoReturnable cir) {
        cir.setReturnValue(Float.valueOf(Blocks.field_10566.method_9499()));
    }

    private static boolean shouldDrawSideHook(boolean original, BlockState state, BlockState otherState, Direction side) {
        if (GofraState.INSTANCE.getXray()) {
            XRayBlockEvent var4 = new XRayBlockEvent();
            var4.call(state.getBlock());
            return var4.getCancelled();
        }
        return original;
    }

}
