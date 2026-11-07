package su.catlean.mixins.client;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.world.StepOnSlimeEvent;

public class SlimeBlockMixin {

    public SlimeBlockMixin() {
    }

    public void onSteppedOnHook(World world, BlockPos pos, BlockState state, Entity entity, CallbackInfo ci) {
        ci.cancel();
    }

}
