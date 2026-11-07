package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class Vec3dServiceComponent {

    private final BlockPos blockPos;
    private final Vec3d vec3d;
    private final Direction minecraftRef;

    public Vec3dServiceComponent(BlockPos bp, Vec3d vec3d, Direction dir) {
        this.blockPos = bp;
        this.vec3d = vec3d;
        this.minecraftRef = dir;
    }

    public BlockPos getMinecraftObject() {
        return this.blockPos;
    }

    public Vec3d getMinecraftObject() {
        return this.vec3d;
    }

    public Direction getMinecraftObject() {
        return this.minecraftRef;
    }

    public BlockPos getMinecraftObject2() {
        return this.blockPos;
    }

    public Vec3d getMinecraftObject2() {
        return this.vec3d;
    }

    public Direction getMinecraftObject2() {
        return this.minecraftRef;
    }

    public Vec3dServiceComponent resolveVec3dServiceComponent(BlockPos bp, Vec3d vec3d, Direction dir) {
        return new Vec3dServiceComponent(bp, vec3d, dir);
    }

    public static Vec3dServiceComponent resolveVec3dServiceComponent(Vec3dServiceComponent arg0, BlockPos arg1, Vec3d arg2, Direction arg3, int arg4, Object arg5) {
        if ((arg4 & 1)) {
            arg1 = arg0.blockPos;
        }
        if ((arg4 & 2)) {
            arg2 = arg0.vec3d;
        }
        if ((arg4 & 4)) {
            arg3 = arg0.minecraftRef;
        }
        return arg0.resolveVec3dServiceComponent(arg1, arg2, arg3);
    }

    public String toString() {
        Direction var3 = this.minecraftRef;
        Vec3d vec = this.vec3d;
        BlockPos blockPos = this.blockPos;
        return ("BlockData(bp=" + blockPos + ", vec3d=" + vec + ", dir=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.blockPos.hashCode();
        var3 = ((var3 * 31) + this.vec3d.hashCode());
        var3 = ((var3 * 31) + this.minecraftRef.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vec3dServiceComponent)) {
            return false;
        }
        Vec3dServiceComponent var5 = (Vec3dServiceComponent) other;
        if (!(Intrinsics.areEqual(this.blockPos, var5.blockPos))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.vec3d, var5.vec3d))) {
            return false;
        }
        if (this.minecraftRef != var5.minecraftRef) {
            return false;
        }
        return true;
    }

}
