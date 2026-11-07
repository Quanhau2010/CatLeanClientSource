package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.ItemStack;
import su.catlean.client.features.modules.Module;

public class ItemNameServiceComponent {

    private final String textValue;
    private final ItemStack itemStack;

    public ItemNameServiceComponent(String itemName, ItemStack i, long startTime) {
        this.textValue = itemName;
        this.itemStack = i;
        this.timestampValue = startTime;
    }

    public String getString() {
        return this.textValue;
    }

    public ItemStack getMinecraftObject() {
        return this.itemStack;
    }

    public long getNumericValue() {
        return this.timestampValue;
    }

    public String getString2() {
        return this.textValue;
    }

    public ItemStack getMinecraftObject2() {
        return this.itemStack;
    }

    public long getNumericValue2() {
        return this.timestampValue;
    }

    public ItemNameServiceComponent resolveItemNameServiceComponent(String itemName, ItemStack i, long startTime) {
        return new ItemNameServiceComponent(itemName, i, startTime);
    }

    public static ItemNameServiceComponent resolveItemNameServiceComponent(ItemNameServiceComponent arg0, String arg1, ItemStack arg2, long arg3, int arg4, Object arg5) {
        if ((arg4 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg4 & 2)) {
            arg2 = arg0.itemStack;
        }
        if ((arg4 & 4)) {
        }
        if (arg0.resolveItemNameServiceComponent(arg1, arg2, arg3) != null) {
        }
        return null;
    }

    public String toString() {
        ItemStack stack = this.itemStack;
        String var6 = this.textValue;
        return ("UsageInfo(itemName=" + var6 + ", i=" + stack + ", startTime=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = this.textValue.hashCode();
        var4 = ((var4 * 31) + this.itemStack.hashCode());
        if (var3 == null) {
        }
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemNameServiceComponent)) {
            return false;
        }
        ItemNameServiceComponent var5 = (ItemNameServiceComponent) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemStack, var5.itemStack))) {
            return false;
        }
        if (this.timestampValue != var5.timestampValue) {
            return false;
        }
        return true;
    }

}
