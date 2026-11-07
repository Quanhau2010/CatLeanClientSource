package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1113;
import net.minecraft.class_1144;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_5819;
import net.minecraft.class_7923;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;

public class VecServiceComponent {

    private final String textValue;
    private final float factorValue;
    private final class_3414 minecraftRef;
    private static int[] countValueArray;

    public VecServiceComponent(String name, float volume) {
        this.textValue = name;
        this.factorValue = volume;
        class_2960 var10 = StringServiceComponent2.resolveMinecraftObject(("catlean:" + this.textValue));
        this.minecraftRef = class_3414.method_47908();
        class_2378.method_10230(class_7923.field_41172, this.minecraftRef);
    }

    public String getString() {
        return this.textValue;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue() {
        SharedKt.getMc().method_40000(this::updateValue);
    }

    public void executeAction(Vec3d vec) {
        this.executeAction(this, vec.field_1352, vec.field_1351, vec.field_1350);
    }

    public void executeAction(double x, double y, double z) {
        SharedKt.getMc().method_40000(this::executeAction);
    }

    public String getString2() {
        return this.textValue;
    }

    public float getNumericValue2() {
        return this.factorValue;
    }

    public VecServiceComponent resolveVecServiceComponent(String name, float volume) {
        return new VecServiceComponent(name, volume);
    }

    public static VecServiceComponent resolveVecServiceComponent(VecServiceComponent arg0, String arg1, float arg2, int arg3, Object arg4, long arg5) {
        if ((arg3 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg3 & 2)) {
            arg2 = arg0.factorValue;
        }
        if (arg5 > 0L && arg0.resolveVecServiceComponent(arg1, arg2) != null) {
        }
        return null;
    }

    public String toString() {
        return (null + this.textValue + ", volume=" + this.factorValue + ")");
    }

    public int hashCode() {
        int var4 = this.textValue.hashCode();
        var4 = ((var4 * 3290624610130722847L) + Float.hashCode(this.factorValue));
        if (var3 != null) {
        }
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VecServiceComponent)) {
            return false;
        }
        VecServiceComponent var5 = (VecServiceComponent) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        return true;
    }

    private static void updateValue(VecServiceComponent arg0) {
        class_3414 var5 = arg0.minecraftRef;
        class_3419 var6 = class_3419.field_15246;
        class_5819 var7 = class_1113.method_43221();
        SharedKt.getMc().method_1483().method_4873((class_1113) new ServiceComponent2());
    }

    private static void executeAction(double arg0, double arg1, double arg2, VecServiceComponent arg3) {
        SharedKt.getWorld().method_8486(arg0, arg1, arg2, arg3.minecraftRef, class_3419.field_15248, arg3.factorValue, 1.0F, 1);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
