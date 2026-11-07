package su.catlean.api.event.events.player;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class CalcBlockBreakingDeltaEvent extends Event {

    public static final CalcBlockBreakingDeltaEvent INSTANCE;
    public static BlockPos blockPos;
    public static BlockState state;
    private static float delta;

    private CalcBlockBreakingDeltaEvent() {
        super();
    }

    public BlockPos getBlockPos() {
        if (blockPos != null) {
            return blockPos;
        }
        Intrinsics.throwUninitializedPropertyAccessException("blockPos");
        return null;
    }

    public void setBlockPos(BlockPos value) {
        blockPos = value;
    }

    public BlockState getState() {
        if (state != null) {
            return state;
        }
        Intrinsics.throwUninitializedPropertyAccessException("state");
        return null;
    }

    public void setState(BlockState value) {
        state = value;
    }

    public float getDelta() {
        return delta;
    }

    public void setDelta(float value) {
        delta = value;
    }

    public boolean call(BlockPos pos, BlockState state) {
        this.setCancelled(0);
        this.setBlockPos(pos);
        INSTANCE.setState(state);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new CalcBlockBreakingDeltaEvent();
    }

}
