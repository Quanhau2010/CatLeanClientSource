package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.Vec3d;
import su.catlean.client.features.modules.Module;

public class ServiceComponent101 {

    private final Vec3d vec3d;
    private int countValue;
    private int countValue2;
    private static boolean enabledFlag;

    public ServiceComponent101(Vec3d pos, int color, int age) {
        this.vec3d = pos;
        this.countValue = color;
        this.countValue2 = age;
    }

    public Vec3d getMinecraftObject() {
        return this.vec3d;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public void updateValue2(int value) {
        this.countValue2 = value;
    }

    public Vec3d getMinecraftObject2() {
        return this.vec3d;
    }

    public int getNumericValue3() {
        return this.countValue;
    }

    public int getNumericValue4() {
        return this.countValue2;
    }

    public ServiceComponent101 resolveServiceComponent101(Vec3d pos, int color, int age) {
        return new ServiceComponent101(pos, color, age);
    }

    public static ServiceComponent101 resolveServiceComponent101(ServiceComponent101 arg0, Vec3d arg1, int arg2, int arg3, int arg4, Object arg5) {
        if ((arg4 & 1) != 0) {
            arg1 = arg0.vec3d;
        }
        if ((arg4 & 2) != 0) {
            arg2 = arg0.countValue;
        }
        if ((arg4 & 4) != 0) {
            arg3 = arg0.countValue2;
        }
        if (arg0.resolveServiceComponent101(arg1, arg2, arg3) != null) {
        }
        return 0;
    }

    public String toString() {
        int index = this.countValue2;
        int index2 = this.countValue;
        Vec3d vec = this.vec3d;
        return ("Effect(pos=" + vec + ", color=" + index2 + ", age=" + index + ")");
    }

    public int hashCode() {
        int index = this.vec3d.hashCode();
        index = ((index * 31) + Integer.hashCode(this.countValue));
        index = ((index * 31) + Integer.hashCode(this.countValue2));
        if (!(__UNDEF_KEY__)) {
        }
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent101)) {
            return false;
        }
        ServiceComponent101 serviceComponent101 = ((ServiceComponent101) other);
        if (!(Intrinsics.areEqual(this.vec3d, serviceComponent101.vec3d))) {
            return false;
        }
        if (this.countValue != serviceComponent101.countValue) {
            return false;
        }
        if (this.countValue2 != serviceComponent101.countValue2) {
            return false;
        }
        return true;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
