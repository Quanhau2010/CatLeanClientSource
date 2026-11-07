package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class DirServiceComponent {

    private final Direction minecraftRef;
    private final Vec3d vec3d;

    public DirServiceComponent(Direction dir, Vec3d vector) {
        this.minecraftRef = dir;
        this.vec3d = vector;
    }

    public Direction getMinecraftObject() {
        return this.minecraftRef;
    }

    public Vec3d getMinecraftObject() {
        return this.vec3d;
    }

    public Direction getMinecraftObject2() {
        return this.minecraftRef;
    }

    public Vec3d getMinecraftObject2() {
        return this.vec3d;
    }

    public DirServiceComponent resolveDirServiceComponent(Direction dir, Vec3d vector) {
        return new DirServiceComponent(dir, vector);
    }

    public static DirServiceComponent resolveDirServiceComponent(DirServiceComponent arg0, Direction arg1, Vec3d arg2, int arg3, Object arg4) {
        if ((arg3 & 1) != 0) {
            arg1 = arg0.minecraftRef;
        }
        if ((arg3 & 2) != 0) {
            arg2 = arg0.vec3d;
        }
        return arg0.resolveDirServiceComponent(arg1, arg2);
    }

    public String toString() {
        return (null + this.minecraftRef + ", vector=" + this.vec3d + ")");
    }

    public int hashCode() {
        int index = this.minecraftRef.hashCode();
        index = ((index * 31) + this.vec3d.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirServiceComponent)) {
            return false;
        }
        DirServiceComponent dirServiceComponent = ((DirServiceComponent) other);
        if (this.minecraftRef != dirServiceComponent.minecraftRef) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.vec3d, dirServiceComponent.vec3d))) {
            return false;
        }
        return true;
    }

}
