package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.Vec3d;

public class VecServiceComponent2 {

    private final Vec3d vec3d;
    private final EasingServiceComponent easingServiceComponent;

    public VecServiceComponent2(Vec3d vec, EasingServiceComponent animation) {
        this.vec3d = vec;
        this.easingServiceComponent = animation;
    }

    public Vec3d getMinecraftObject() {
        return this.vec3d;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return this.easingServiceComponent;
    }

    public Vec3d getMinecraftObject2() {
        return this.vec3d;
    }

    public EasingServiceComponent getEasingServiceComponent2() {
        return this.easingServiceComponent;
    }

    public VecServiceComponent2 resolveVecServiceComponent2(Vec3d vec, EasingServiceComponent animation) {
        return new VecServiceComponent2(vec, animation);
    }

    public String toString() {
        return (null + this.vec3d + ", animation=" + this.easingServiceComponent + ")");
    }

    public int hashCode() {
        int index = this.vec3d.hashCode();
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VecServiceComponent2)) {
            return false;
        }
        VecServiceComponent2 vecServiceComponent2 = ((VecServiceComponent2) other);
        if (!(Intrinsics.areEqual(this.vec3d, vecServiceComponent2.vec3d))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, vecServiceComponent2.easingServiceComponent))) {
            return false;
        }
        return true;
    }

}
