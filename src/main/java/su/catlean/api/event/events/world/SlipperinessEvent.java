package su.catlean.api.event.events.world;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class SlipperinessEvent extends Event {

    public static final SlipperinessEvent INSTANCE;
    private static Block block;

    private SlipperinessEvent() {
        super();
    }

    public Block getBlock() {
        if (block != null) {
            return block;
        }
        Intrinsics.throwUninitializedPropertyAccessException("block");
        return null;
    }

    public boolean call(Block block) {
        this.setCancelled(0);
        block = block;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new SlipperinessEvent();
    }

}
