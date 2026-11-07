package su.catlean.mixins.render;

import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.GofraState;

public class VisGraphMixin {

    public VisGraphMixin() {
    }

    private void markClosedHook(BlockPos pos, CallbackInfo ci) {
        ci.cancel();
    }

}
