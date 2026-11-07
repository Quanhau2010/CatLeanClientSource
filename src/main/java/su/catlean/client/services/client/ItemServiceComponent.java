package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.Item;
import su.catlean.client.features.modules.Module;

public class ItemServiceComponent {

    private final Item minecraftRef;
    private final boolean enabledFlag;
    private final boolean enabledFlag2;
    private final String textValue;

    public ItemServiceComponent(Item item, boolean another, boolean enchanted, String name) {
        this.minecraftRef = item;
        this.enabledFlag = another;
        this.enabledFlag2 = enchanted;
        this.textValue = name;
    }

    public Item getMinecraftObject() {
        return this.minecraftRef;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public boolean isActive2() {
        return this.enabledFlag2;
    }

    public String getString() {
        return this.textValue;
    }

    public Item getMinecraftObject2() {
        return this.minecraftRef;
    }

    public boolean isActive3() {
        return this.enabledFlag;
    }

    public boolean isActive4() {
        return this.enabledFlag2;
    }

    public String getString2() {
        return this.textValue;
    }

    public ItemServiceComponent resolveItemServiceComponent(Item item, boolean another, boolean enchanted, String name) {
        return new ItemServiceComponent(item, another, enchanted, name);
    }

    public static ItemServiceComponent resolveItemServiceComponent(ItemServiceComponent arg0, Item arg1, boolean arg2, boolean arg3, String arg4, int arg5, Object arg6) {
        if ((arg5 & 1) != 0) {
            arg1 = arg0.minecraftRef;
        }
        if ((arg5 & 2) != 0) {
            arg2 = arg0.enabledFlag;
        }
        if ((arg5 & 4) != 0) {
            arg3 = arg0.enabledFlag2;
        }
        if ((arg5 & 8) != 0) {
            arg4 = arg0.textValue;
        }
        if (arg0.resolveItemServiceComponent(arg1, arg2, arg3, arg4) != null) {
        }
        return null;
    }

    public String toString() {
        String text = this.textValue;
        boolean flag = this.enabledFlag2;
        boolean flag2 = this.enabledFlag;
        Item item = this.minecraftRef;
        return ("RequiredItem(item=" + item + ", another=" + flag2 + ", enchanted=" + flag + ", name=" + text + ")");
    }

    public int hashCode() {
        int index = this.minecraftRef.hashCode();
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag2));
        index = ((index * 31) + this.textValue.hashCode());
        if (__UNDEF_KEY__ != null) {
        }
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemServiceComponent)) {
            return false;
        }
        ItemServiceComponent itemServiceComponent = ((ItemServiceComponent) other);
        if (!(Intrinsics.areEqual(this.minecraftRef, itemServiceComponent.minecraftRef))) {
            return false;
        }
        if (this.enabledFlag != itemServiceComponent.enabledFlag) {
            return false;
        }
        if (this.enabledFlag2 != itemServiceComponent.enabledFlag2) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue, itemServiceComponent.textValue))) {
            return false;
        }
        return true;
    }

}
