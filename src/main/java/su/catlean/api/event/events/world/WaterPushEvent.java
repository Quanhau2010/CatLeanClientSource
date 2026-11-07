package su.catlean.api.event.events.world;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class WaterPushEvent extends Event {

    public static final WaterPushEvent INSTANCE;
    private static BlockPos pos;
    private static class_3610 state;
    private static class_3611 fluid;
    public static Vec3d vec;

    private WaterPushEvent() {
        super();
    }

    public BlockPos getPos() {
        if (pos != null) {
            return pos;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pos");
        return null;
    }

    public class_3610 getState() {
        if (state != null) {
            return state;
        }
        Intrinsics.throwUninitializedPropertyAccessException("state");
        return null;
    }

    public class_3611 getFluid() {
        if (fluid != null) {
            return fluid;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fluid");
        return null;
    }

    public Vec3d getVec() {
        if (vec != null) {
            return vec;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vec");
        return null;
    }

    public void setVec(Vec3d value) {
        vec = value;
    }

    public boolean call(BlockPos pos, class_3611 fluid, class_3610 state, Vec3d vec) {
        this.setCancelled(0);
        pos = pos;
        this.setVec(vec);
        fluid = fluid;
        state = state;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new WaterPushEvent();
    }

}
