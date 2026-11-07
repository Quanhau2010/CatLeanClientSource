package su.catlean.api.event.events.player;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class AttackBlockEvent extends Event {

    public static final AttackBlockEvent INSTANCE;
    private static Direction direction;
    private static BlockPos pos;

    private AttackBlockEvent() {
        super();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction value) {
        direction = value;
    }

    public BlockPos getPos() {
        return pos;
    }

    public void setPos(BlockPos value) {
        pos = value;
    }

    public boolean call(Direction direction, BlockPos pos) {
        this.setCancelled(0);
        pos = pos;
        direction = direction;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new AttackBlockEvent();
        direction = Direction.UP;
        pos = BlockPos.field_10980;
    }

}
