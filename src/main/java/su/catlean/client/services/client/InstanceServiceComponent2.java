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
        boolean flag = this.enabledFlag;
        EasingServiceComponent easingServiceComponent = this.easingServiceComponent;
        class_1293 class1293 = this.minecraftRef;
        return ("PotionHolder(instance=" + class1293 + ", animation=" + easingServiceComponent + ", removing=" + flag + ")");
    }

    public int hashCode() {
        int index = this.minecraftRef.hashCode();
        index = ((index * 31) + this.easingServiceComponent.hashCode());
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstanceServiceComponent2)) {
            return false;
        }
        InstanceServiceComponent2 instanceServiceComponent2 = ((InstanceServiceComponent2) other);
        if (!(Intrinsics.areEqual(this.minecraftRef, instanceServiceComponent2.minecraftRef))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, instanceServiceComponent2.easingServiceComponent))) {
            return false;
        }
        if (this.enabledFlag != instanceServiceComponent2.enabledFlag) {
            return false;
        }
        return true;
    }

}
