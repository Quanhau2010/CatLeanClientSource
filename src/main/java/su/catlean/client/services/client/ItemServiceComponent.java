package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
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

    public ItemServiceComponent(Item arg0, boolean arg1, boolean arg2, String arg3, int arg4, DefaultConstructorMarker arg5) {
        if ((arg4 & 2)) {
            arg1 = 0;
        }
        if ((arg4 & 4)) {
            arg2 = 0;
        }
        if ((arg4 & 8)) {
            arg3 = "";
        }
        this(arg0, arg1, arg2, arg3);
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
        if ((arg5 & 1)) {
            arg1 = arg0.minecraftRef;
        }
        if ((arg5 & 2)) {
            arg2 = arg0.enabledFlag;
        }
        if ((arg5 & 4)) {
            arg3 = arg0.enabledFlag2;
        }
        if ((arg5 & 8)) {
            arg4 = arg0.textValue;
        }
        if (arg0.resolveItemServiceComponent(arg1, arg2, arg3, arg4) != null) {
        }
        return null;
    }

    public String toString() {
        String var3 = this.textValue;
        boolean var4 = this.enabledFlag2;
        boolean var5 = this.enabledFlag;
        Item var6 = this.minecraftRef;
        return ("RequiredItem(item=" + var6 + ", another=" + var5 + ", enchanted=" + var4 + ", name=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = this.minecraftRef.hashCode();
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag2));
        var4 = ((var4 * 31) + this.textValue.hashCode());
        if (var3 != null) {
        }
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemServiceComponent)) {
            return false;
        }
        ItemServiceComponent var5 = (ItemServiceComponent) other;
        if (!(Intrinsics.areEqual(this.minecraftRef, var5.minecraftRef))) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        if (this.enabledFlag2 != var5.enabledFlag2) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        return true;
    }

}
