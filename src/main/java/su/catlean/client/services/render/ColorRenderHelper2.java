package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;

public class ColorRenderHelper2 {

    private final BlockPos blockPos;
    private final Color colorValue;

    public ColorRenderHelper2(BlockPos pos, Color color) {
        this.blockPos = pos;
        this.colorValue = color;
    }

    public BlockPos getMinecraftObject() {
        return this.blockPos;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public BlockPos getMinecraftObject2() {
        return this.blockPos;
    }

    public Color getColor2() {
        return this.colorValue;
    }

    public ColorRenderHelper2 resolveColorRenderHelper2(BlockPos pos, Color color) {
        return new ColorRenderHelper2(pos, color);
    }

    public String toString() {
        return (null + this.blockPos + ", color=" + this.colorValue + ")");
    }

    public int hashCode() {
        int index = this.blockPos.hashCode();
        index = ((index * 31) + this.colorValue.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorRenderHelper2)) {
            return false;
        }
        ColorRenderHelper2 colorRenderHelper2 = ((ColorRenderHelper2) other);
        if (!(Intrinsics.areEqual(this.blockPos, colorRenderHelper2.blockPos))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue, colorRenderHelper2.colorValue))) {
            return false;
        }
        return true;
    }

}
