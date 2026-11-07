package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1293;

public class ServiceComponent84 {

    private final int countValue;
    private final class_1293 minecraftRef;
    private static boolean enabledFlag;

    public ServiceComponent84(int slot, class_1293 effect) {
        this.countValue = slot;
        this.minecraftRef = effect;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public class_1293 getMinecraftObject() {
        return this.minecraftRef;
    }

    public int getNumericValue2() {
        return this.countValue;
    }

    public class_1293 getMinecraftObject2() {
        return this.minecraftRef;
    }

    public ServiceComponent84 resolveServiceComponent84(int slot, class_1293 effect) {
        return new ServiceComponent84(slot, effect);
    }

    public static ServiceComponent84 resolveServiceComponent84(ServiceComponent84 arg0, int arg1, class_1293 arg2, int arg3, short arg4, Object arg5) {
        if ((arg3 & 1)) {
            arg1 = arg0.countValue;
        }
        if ((arg3 & 2)) {
            arg2 = arg0.minecraftRef;
        }
        if (arg4 >= 0) {
            if (arg0.resolveServiceComponent84(arg1, arg2) != null) {
            }
        }
        return 0;
    }

    public String toString() {
        return (null + this.countValue + ", effect=" + this.minecraftRef + ")");
    }

    public int hashCode() {
        int var4 = Integer.hashCode(this.countValue);
        var4 = ((var4 * -4194200521352937441L) + this.minecraftRef != null);
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent84)) {
            return false;
        }
        ServiceComponent84 var5 = (ServiceComponent84) other;
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.minecraftRef, var5.minecraftRef))) {
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
