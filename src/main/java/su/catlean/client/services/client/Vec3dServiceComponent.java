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
        if ((arg4 & 1) != 0) {
            arg1 = arg0.blockPos;
        }
        if ((arg4 & 2) != 0) {
            arg2 = arg0.vec3d;
        }
        if ((arg4 & 4) != 0) {
            arg3 = arg0.minecraftRef;
        }
        return arg0.resolveVec3dServiceComponent(arg1, arg2, arg3);
    }

    public String toString() {
        Direction direction = this.minecraftRef;
        Vec3d vec = this.vec3d;
        BlockPos blockPos = this.blockPos;
        return ("BlockData(bp=" + blockPos + ", vec3d=" + vec + ", dir=" + direction + ")");
    }

    public int hashCode() {
        int index = this.blockPos.hashCode();
        index = ((index * 31) + this.vec3d.hashCode());
        index = ((index * 31) + this.minecraftRef.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vec3dServiceComponent)) {
            return false;
        }
        Vec3dServiceComponent vec3dServiceComponent = ((Vec3dServiceComponent) other);
        if (!(Intrinsics.areEqual(this.blockPos, vec3dServiceComponent.blockPos))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.vec3d, vec3dServiceComponent.vec3d))) {
            return false;
        }
        if (this.minecraftRef != vec3dServiceComponent.minecraftRef) {
            return false;
        }
        return true;
    }

}
