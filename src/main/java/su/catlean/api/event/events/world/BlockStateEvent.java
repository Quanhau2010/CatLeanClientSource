package su.catlean.api.event.events.world;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class BlockStateEvent extends Event {

    public static final BlockStateEvent INSTANCE;
    private static BlockPos pos;
    private static BlockState prevState;
    private static BlockState state;

    private BlockStateEvent() {
        super();
    }

    public BlockPos getPos() {
        if (pos != null) {
            return pos;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pos");
        return null;
    }

    public BlockState getPrevState() {
        return prevState;
    }

    public void setPrevState(BlockState value) {
        prevState = value;
    }

    public BlockState getState() {
        return state;
    }

    public boolean call(BlockPos pos, BlockState prevState, BlockState state) {
        this.setCancelled(0);
        pos = pos;
        state = state;
        prevState = prevState;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new BlockStateEvent();
    }

}
