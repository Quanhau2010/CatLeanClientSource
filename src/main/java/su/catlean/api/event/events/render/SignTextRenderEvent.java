package su.catlean.api.event.events.render;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class SignTextRenderEvent extends Event {

    public static final SignTextRenderEvent INSTANCE;
    private static BlockPos pos;

    private SignTextRenderEvent() {
        super();
    }

    public BlockPos getPos() {
        if (pos != null) {
            return pos;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pos");
        return null;
    }

    public boolean call(BlockPos pos) {
        this.setCancelled(false);
        pos = pos;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new SignTextRenderEvent();
    }

}
