package su.catlean.mixins.client;

import net.minecraft.class_1922;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.world.WaterPushEvent;

public abstract class FlowingFluidMixin {

    public FlowingFluidMixin() {
    }

    private void getVelocityHook(class_1922 world, BlockPos pos, class_3610 state, CallbackInfoReturnable cir) {
        cir.setReturnValue(WaterPushEvent.INSTANCE.getVec());
    }

}
