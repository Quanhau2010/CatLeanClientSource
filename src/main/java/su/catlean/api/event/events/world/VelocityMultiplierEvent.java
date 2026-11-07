package su.catlean.api.event.events.world;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class VelocityMultiplierEvent extends Event {

    public static final VelocityMultiplierEvent INSTANCE;
    private static Block block;

    private VelocityMultiplierEvent() {
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
        this.setCancelled(false);
        block = block;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new VelocityMultiplierEvent();
    }

}
