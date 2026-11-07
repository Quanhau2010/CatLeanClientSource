package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.Item;
import su.catlean.client.features.modules.Module;

public class ItemServiceComponent3 {

    private final Item minecraftRef;
    private final int countValue;
    private final int countValue2;
    private final int countValue3;

    public ItemServiceComponent3(Item item, int price, int lowestPrice, int id) {
        this.minecraftRef = item;
        this.countValue = price;
        this.countValue2 = lowestPrice;
        this.countValue3 = id;
    }

    public Item getMinecraftObject() {
        return this.minecraftRef;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public int getNumericValue3() {
        return this.countValue3;
    }

    public Item getMinecraftObject2() {
        return this.minecraftRef;
    }

    public int getNumericValue4() {
        return this.countValue;
    }

    public int getNumericValue5() {
        return this.countValue2;
    }

    public int getNumericValue6() {
        return this.countValue3;
    }

    public ItemServiceComponent3 resolveItemServiceComponent3(Item item, int price, int lowestPrice, int id) {
        return new ItemServiceComponent3(item, price, lowestPrice, id);
    }

    public static ItemServiceComponent3 resolveItemServiceComponent3(ItemServiceComponent3 arg0, Item arg1, int arg2, int arg3, char arg4, int arg5, int arg6, int arg7, Object arg8, int arg9) {
        if ((arg7 & 1)) {
            arg1 = arg0.minecraftRef;
        }
        if (arg9 > 0) {
            if (var14 == null) {
                if ((arg7 & 2)) {
                    arg2 = arg0.countValue;
                }
            }
        }
        if (arg3 >= 0 && var14 == null) {
            if ((arg7 & 4)) {
                arg5 = arg0.countValue2;
            }
        }
        if ((arg7 & 8)) {
            arg6 = arg0.countValue3;
        }
        if (arg4 >= 0 && arg0.resolveItemServiceComponent3(arg1, arg2, arg5, arg6) != null) {
        }
        return null;
    }

    public String toString() {
        int var3 = this.countValue3;
        int var4 = this.countValue2;
        int var5 = this.countValue;
        Item var6 = this.minecraftRef;
        return ("AucItem(item=" + var6 + ", price=" + var5 + ", lowestPrice=" + var4 + ", id=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = this.minecraftRef.hashCode();
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue2));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue3));
        if (var3 != null) {
        }
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemServiceComponent3)) {
            return false;
        }
        ItemServiceComponent3 var5 = (ItemServiceComponent3) other;
        if (!(Intrinsics.areEqual(this.minecraftRef, var5.minecraftRef))) {
            return false;
        }
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (this.countValue2 != var5.countValue2) {
            return false;
        }
        if (this.countValue3 != var5.countValue3) {
            return false;
        }
        return true;
    }

}
