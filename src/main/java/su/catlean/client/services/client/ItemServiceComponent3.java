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
        if ((arg7 & 1) != 0) {
            arg1 = arg0.minecraftRef;
        }
        if (arg9 > 0) {
            if (__UNDEF_KEY__ == null) {
                if ((arg7 & 2) != 0) {
                    arg2 = arg0.countValue;
                }
            }
        }
        if (arg3 >= 0 && __UNDEF_KEY__ == null) {
            if ((arg7 & 4) != 0) {
                arg5 = arg0.countValue2;
            }
        }
        if ((arg7 & 8) != 0) {
            arg6 = arg0.countValue3;
        }
        if (arg4 >= 0 && arg0.resolveItemServiceComponent3(arg1, arg2, arg5, arg6) != null) {
        }
        return null;
    }

    public String toString() {
        int index = this.countValue3;
        int index2 = this.countValue2;
        int index3 = this.countValue;
        Item item = this.minecraftRef;
        return ("AucItem(item=" + item + ", price=" + index3 + ", lowestPrice=" + index2 + ", id=" + index + ")");
    }

    public int hashCode() {
        int index = this.minecraftRef.hashCode();
        index = ((index * 31) + Integer.hashCode(this.countValue));
        index = ((index * 31) + Integer.hashCode(this.countValue2));
        index = ((index * 31) + Integer.hashCode(this.countValue3));
        if (__UNDEF_KEY__ != null) {
        }
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemServiceComponent3)) {
            return false;
        }
        ItemServiceComponent3 itemServiceComponent3 = ((ItemServiceComponent3) other);
        if (!(Intrinsics.areEqual(this.minecraftRef, itemServiceComponent3.minecraftRef))) {
            return false;
        }
        if (this.countValue != itemServiceComponent3.countValue) {
            return false;
        }
        if (this.countValue2 != itemServiceComponent3.countValue2) {
            return false;
        }
        if (this.countValue3 != itemServiceComponent3.countValue3) {
            return false;
        }
        return true;
    }

}
