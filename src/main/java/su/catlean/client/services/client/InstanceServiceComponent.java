package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.Item;

public class InstanceServiceComponent {

    private final Item minecraftRef;
    private final int countValue;
    private final EasingServiceComponent easingServiceComponent;
    private boolean enabledFlag;

    public InstanceServiceComponent(Item instance, int endTick, EasingServiceComponent animation, boolean removing) {
        this.minecraftRef = instance;
        this.countValue = endTick;
        this.easingServiceComponent = animation;
        this.enabledFlag = removing;
    }

    public Item getMinecraftObject() {
        return this.minecraftRef;
    }

    public int getNumericValue() {
        return this.countValue;
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

    public Item getMinecraftObject2() {
        return this.minecraftRef;
    }

    public int getNumericValue2() {
        return this.countValue;
    }

    public EasingServiceComponent getEasingServiceComponent2() {
        return this.easingServiceComponent;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public InstanceServiceComponent resolveInstanceServiceComponent(Item instance, int endTick, EasingServiceComponent animation, boolean removing) {
        return new InstanceServiceComponent(instance, endTick, animation, removing);
    }

    public String toString() {
        boolean flag = this.enabledFlag;
        EasingServiceComponent easingServiceComponent = this.easingServiceComponent;
        int index = this.countValue;
        Item item = this.minecraftRef;
        return ("CooldownHolder(instance=" + item + ", endTick=" + index + ", animation=" + easingServiceComponent + ", removing=" + flag + ")");
    }

    public int hashCode() {
        int index = this.minecraftRef.hashCode();
        index = ((index * 31) + Integer.hashCode(this.countValue));
        index = ((index * 31) + this.easingServiceComponent.hashCode());
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstanceServiceComponent)) {
            return false;
        }
        InstanceServiceComponent instanceServiceComponent = ((InstanceServiceComponent) other);
        if (!(Intrinsics.areEqual(this.minecraftRef, instanceServiceComponent.minecraftRef))) {
            return false;
        }
        if (this.countValue != instanceServiceComponent.countValue) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, instanceServiceComponent.easingServiceComponent))) {
            return false;
        }
        if (this.enabledFlag != instanceServiceComponent.enabledFlag) {
            return false;
        }
        return true;
    }

}
