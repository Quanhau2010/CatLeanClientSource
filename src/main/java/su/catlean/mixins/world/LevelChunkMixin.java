package su.catlean.mixins.world;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.world.BlockStateEvent;

public class LevelChunkMixin {

    private World field_12858;

    public LevelChunkMixin() {
    }

    private void setBlockStateHook(BlockPos pos, BlockState state, CallbackInfoReturnable cir) {
        BlockStateEvent.INSTANCE.call(pos, state, (BlockState) cir.getReturnValue());
    }

}
