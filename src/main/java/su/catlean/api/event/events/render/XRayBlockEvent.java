package su.catlean.api.event.events.render;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class XRayBlockEvent extends Event {

    private Block block;

    public XRayBlockEvent() {
        super();
        this.block = Blocks.field_10566;
    }

    public Block getBlock() {
        return this.block;
    }

    public void setBlock(Block value) {
        this.block = value;
    }

    public boolean call(Block block) {
        this.setCancelled(false);
        this.block = block;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

}
