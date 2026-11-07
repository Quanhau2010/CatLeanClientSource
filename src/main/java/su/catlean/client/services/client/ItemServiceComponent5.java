package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.Item;
import net.minecraft.util.math.Vec3d;

public class ItemServiceComponent5 {

    private final Vec3d vec3d;
    private final Item minecraftRef;

    public ItemServiceComponent5(Vec3d pos, long expiresOn, Item item) {
        this.vec3d = pos;
        this.timestampValue = expiresOn;
        this.minecraftRef = item;
    }

    public Vec3d getMinecraftObject() {
        return this.vec3d;
    }

    public long getNumericValue() {
        return this.timestampValue;
    }

    public Item getMinecraftObject() {
        return this.minecraftRef;
    }

    public Vec3d getMinecraftObject2() {
        return this.vec3d;
    }

    public long getNumericValue2() {
        return this.timestampValue;
    }

    public Item getMinecraftObject2() {
        return this.minecraftRef;
    }

    public ItemServiceComponent5 resolveItemServiceComponent5(Vec3d pos, long expiresOn, Item item) {
        return new ItemServiceComponent5(pos, expiresOn, item);
    }

    public static ItemServiceComponent5 resolveItemServiceComponent5(ItemServiceComponent5 arg0, Vec3d arg1, long arg2, Item arg3, int arg4, Object arg5) {
        if ((arg4 & 1)) {
            arg1 = arg0.vec3d;
        }
        if ((arg4 & 2)) {
        }
        if ((arg4 & 4)) {
            arg3 = arg0.minecraftRef;
        }
        return arg0.resolveItemServiceComponent5(arg1, arg2, arg3);
    }

    public String toString() {
        Item var3 = this.minecraftRef;
        Vec3d vec = this.vec3d;
        return ("Consumable(pos=" + vec + ", expiresOn=" + var4 + ", item=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.vec3d.hashCode();
        var3 = ((var3 * 31) + this.minecraftRef.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemServiceComponent5)) {
            return false;
        }
        ItemServiceComponent5 var5 = (ItemServiceComponent5) other;
        if (!(Intrinsics.areEqual(this.vec3d, var5.vec3d))) {
            return false;
        }
        if (this.timestampValue != var5.timestampValue) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.minecraftRef, var5.minecraftRef))) {
            return false;
        }
        return true;
    }

}
