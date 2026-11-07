package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class PositionServiceComponent {

    private final BlockPos blockPos;
    private final Direction minecraftRef;

    public PositionServiceComponent(BlockPos position, Direction facing) {
        this.blockPos = position;
        this.minecraftRef = facing;
    }

    public BlockPos getMinecraftObject() {
        return this.blockPos;
    }

    public Direction getMinecraftObject() {
        return this.minecraftRef;
    }

    public BlockPos getMinecraftObject2() {
        return this.blockPos;
    }

    public Direction getMinecraftObject2() {
        return this.minecraftRef;
    }

    public PositionServiceComponent resolvePositionServiceComponent(BlockPos position, Direction facing) {
        return new PositionServiceComponent(position, facing);
    }

    public static PositionServiceComponent resolvePositionServiceComponent(PositionServiceComponent arg0, BlockPos arg1, Direction arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = arg0.blockPos;
        }
        if ((arg3 & 2)) {
            arg2 = arg0.minecraftRef;
        }
        return arg0.resolvePositionServiceComponent(arg1, arg2);
    }

    public String toString() {
        return (null + this.blockPos + ", facing=" + this.minecraftRef + ")");
    }

    public int hashCode() {
        int var3 = this.blockPos.hashCode();
        var3 = ((var3 * -2746611700093419489L) + this.minecraftRef.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (var4 == null) {
            if (this == other) {
                return true;
            }
        }
        if (var4 == null) {
            if (!(other instanceof PositionServiceComponent)) {
                return false;
            }
        }
        PositionServiceComponent var5 = (PositionServiceComponent) other;
        if (var4 == null) {
            if (!(Intrinsics.areEqual(this.blockPos, var5.blockPos))) {
                return false;
            }
        }
        if (this.minecraftRef != var5.minecraftRef) {
            return false;
        }
        return true;
    }

}
