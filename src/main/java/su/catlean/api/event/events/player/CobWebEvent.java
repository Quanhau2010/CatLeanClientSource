package su.catlean.api.event.events.player;

import net.minecraft.util.math.BlockPos;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class CobWebEvent extends Event {

    public static final CobWebEvent INSTANCE;
    private static BlockPos pos;

    private CobWebEvent() {
        super();
    }

    public BlockPos getPos() {
        return pos;
    }

    public void setPos(BlockPos value) {
        pos = value;
    }

    public boolean call(BlockPos pos) {
        this.setCancelled(false);
        pos = pos;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new CobWebEvent();
        pos = BlockPos.field_10980;
    }

}
