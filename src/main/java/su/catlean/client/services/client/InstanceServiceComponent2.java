package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1293;

public class InstanceServiceComponent2 {

    private final class_1293 minecraftRef;
    private final EasingServiceComponent easingServiceComponent;
    private boolean enabledFlag;

    public InstanceServiceComponent2(class_1293 instance, EasingServiceComponent animation, boolean removing) {
        this.minecraftRef = instance;
        this.easingServiceComponent = animation;
        this.enabledFlag = removing;
    }

    public class_1293 getMinecraftObject() {
        return this.minecraftRef;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return this.easingServiceComponent;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public class_1293 getMinecraftObject2() {
        return this.minecraftRef;
    }

    public EasingServiceComponent getEasingServiceComponent2() {
        return this.easingServiceComponent;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public InstanceServiceComponent2 resolveInstanceServiceComponent2(class_1293 instance, EasingServiceComponent animation, boolean removing) {
        return new InstanceServiceComponent2(instance, animation, removing);
    }

    public String toString() {
        boolean var3 = this.enabledFlag;
        EasingServiceComponent var4 = this.easingServiceComponent;
        class_1293 var5 = this.minecraftRef;
        return ("PotionHolder(instance=" + var5 + ", animation=" + var4 + ", removing=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.minecraftRef.hashCode();
        var3 = ((var3 * 31) + this.easingServiceComponent.hashCode());
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstanceServiceComponent2)) {
            return false;
        }
        InstanceServiceComponent2 var5 = (InstanceServiceComponent2) other;
        if (!(Intrinsics.areEqual(this.minecraftRef, var5.minecraftRef))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, var5.easingServiceComponent))) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        return true;
    }

}
