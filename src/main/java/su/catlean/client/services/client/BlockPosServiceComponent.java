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
        if ((arg3 & 1) != 0) {
            arg1 = arg0.blockPos;
        }
        if ((arg3 & 2) != 0) {
            arg2 = arg0.factorValue;
        }
        return arg0.resolveBlockPosServiceComponent(arg1, arg2);
    }

    public String toString() {
        return (null + this.blockPos + ", damage=" + this.factorValue + ")");
    }

    public int hashCode() {
        int index = this.blockPos.hashCode();
        index = ((index * 31) + Float.hashCode(this.factorValue));
        if (index != null) {
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
        BlockPosServiceComponent blockPosServiceComponent = ((BlockPosServiceComponent) other);
        if (!(Intrinsics.areEqual(this.blockPos, blockPosServiceComponent.blockPos))) {
            return false;
        }
        if (Float.compare(this.factorValue, blockPosServiceComponent.factorValue)) {
            return false;
        }
        return true;
    }

}
