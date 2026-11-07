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
        boolean var3 = this.enabledFlag;
        EasingServiceComponent var4 = this.easingServiceComponent;
        int var5 = this.countValue;
        Item var6 = this.minecraftRef;
        return ("CooldownHolder(instance=" + var6 + ", endTick=" + var5 + ", animation=" + var4 + ", removing=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.minecraftRef.hashCode();
        var3 = ((var3 * 31) + Integer.hashCode(this.countValue));
        var3 = ((var3 * 31) + this.easingServiceComponent.hashCode());
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstanceServiceComponent)) {
            return false;
        }
        InstanceServiceComponent var5 = (InstanceServiceComponent) other;
        if (!(Intrinsics.areEqual(this.minecraftRef, var5.minecraftRef))) {
            return false;
        }
        if (this.countValue != var5.countValue) {
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
