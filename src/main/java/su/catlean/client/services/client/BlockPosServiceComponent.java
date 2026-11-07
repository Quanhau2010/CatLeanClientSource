package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;
import su.catlean.client.features.modules.Module;

public class BlockPosServiceComponent {

    private final BlockPos blockPos;
    private final float factorValue;

    public BlockPosServiceComponent(BlockPos blockPos, float damage) {
        this.blockPos = blockPos;
        this.factorValue = damage;
    }

    public BlockPos getMinecraftObject() {
        return this.blockPos;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public BlockPos getMinecraftObject2() {
        return this.blockPos;
    }

    public float getNumericValue2() {
        return this.factorValue;
    }

    public BlockPosServiceComponent resolveBlockPosServiceComponent(BlockPos blockPos, float damage) {
        return new BlockPosServiceComponent(blockPos, damage);
    }

    public static BlockPosServiceComponent resolveBlockPosServiceComponent(BlockPosServiceComponent arg0, BlockPos arg1, float arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = arg0.blockPos;
        }
        if ((arg3 & 2)) {
            arg2 = arg0.factorValue;
        }
        return arg0.resolveBlockPosServiceComponent(arg1, arg2);
    }

    public String toString() {
        return (null + this.blockPos + ", damage=" + this.factorValue + ")");
    }

    public int hashCode() {
        int var4 = this.blockPos.hashCode();
        var4 = ((var4 * 4032238704780115999L) + Float.hashCode(this.factorValue));
        if (var4 != null) {
        }
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlockPosServiceComponent)) {
            return false;
        }
        BlockPosServiceComponent var5 = (BlockPosServiceComponent) other;
        if (!(Intrinsics.areEqual(this.blockPos, var5.blockPos))) {
            return false;
        }
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        return true;
    }

}
