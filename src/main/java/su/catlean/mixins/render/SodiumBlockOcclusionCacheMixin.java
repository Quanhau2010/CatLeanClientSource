package su.catlean.mixins.render;

import net.minecraft.block.BlockState;
import net.minecraft.class_1922;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.GofraState;
import su.catlean.api.event.events.render.XRayBlockEvent;

public class SodiumBlockOcclusionCacheMixin {

    public SodiumBlockOcclusionCacheMixin() {
    }

    private void shouldDrawSideHook(BlockState state, class_1922 view, BlockPos pos, Direction facing, CallbackInfoReturnable cir) {
        XRayBlockEvent var6 = new XRayBlockEvent();
        var6.call(state.getBlock());
        cir.setReturnValue(Boolean.valueOf(var6.getCancelled()));
    }

}
