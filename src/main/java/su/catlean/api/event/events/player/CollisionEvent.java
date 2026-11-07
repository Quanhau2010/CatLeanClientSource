package su.catlean.api.event.events.player;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class CollisionEvent extends Event {

    private BlockState state;
    private BlockPos pos;

    public CollisionEvent() {
        super();
        this.state = Blocks.AIR.method_9564();
        this.pos = BlockPos.field_10980;
    }

    public BlockState getState() {
        return this.state;
    }

    public void setState(BlockState value) {
        this.state = value;
    }

    public BlockPos getPos() {
        return this.pos;
    }

    public void setPos(BlockPos value) {
        this.pos = value;
    }

    public boolean call(BlockState state, BlockPos pos) {
        this.setCancelled(0);
        this.pos = pos;
        this.state = state;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

}
