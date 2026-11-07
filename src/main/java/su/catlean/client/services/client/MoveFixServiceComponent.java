package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_7172;
import su.catlean.SharedKt;
import su.catlean.client.types.OptionMode18;
import su.catlean.mixins.accessors.LocalPlayerAccessor;

public class MoveFixServiceComponent {

    public static final VectorServiceComponent vectorServiceComponent;
    private float factorValue;
    private float factorValue2;
    private boolean enabledFlag;
    private OptionMode18 optionMode18;
    private static boolean enabledFlag2;

    public MoveFixServiceComponent(float yaw, float pitch, boolean grim, OptionMode18 moveFix) {
        this.factorValue = yaw;
        this.factorValue2 = pitch;
        this.enabledFlag = grim;
        this.optionMode18 = moveFix;
    }

    public MoveFixServiceComponent(float arg0, float arg1, boolean arg2, OptionMode18 arg3, int arg4, DefaultConstructorMarker arg5) {
        if ((arg4 & 4)) {
            arg2 = 0;
        }
        if ((arg4 & 8)) {
            arg3 = OptionMode18.NONE;
        }
        this(arg0, arg1, arg2, arg3);
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public void updateValue2(float value) {
        this.factorValue2 = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public OptionMode18 getOptionMode18() {
        return this.optionMode18;
    }

    public void executeAction(OptionMode18 value) {
        this.optionMode18 = value;
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent() {
        double var7 = ((Math.pow((((Number) SharedKt.getMc().options.method_42495().method_41753() * 0.6D) + 0.2D), 3) * 8.0D) * 0.15F);
        float var9 = class_3532.method_15393((this.factorValue - (LocalPlayerAccessor) SharedKt.getPlayer().getLastYaw()));
        float var10 = class_3532.method_15393((this.factorValue2 - (LocalPlayerAccessor) SharedKt.getPlayer().getLastPitch()));
        int var11 = (MathKt.roundToInt((var9 / var7)) * var7);
        int var13 = (MathKt.roundToInt((var10 / var7)) * var7);
        this.factorValue = ((LocalPlayerAccessor) SharedKt.getPlayer().getLastYaw() + var11);
        this.factorValue2 = RangesKt.coerceIn(((LocalPlayerAccessor) SharedKt.getPlayer().getLastPitch() + var13), -90.0F, 90.0F);
        return this;
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(OptionMode18 v) {
        this.optionMode18 = v;
        return this;
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(boolean v) {
        this.enabledFlag = v;
        return this;
    }

    public float getNumericValue3() {
        return this.factorValue;
    }

    public float getNumericValue4() {
        return this.factorValue2;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public OptionMode18 getOptionMode182() {
        return this.optionMode18;
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(float yaw, float pitch, boolean grim, OptionMode18 moveFix) {
        return new MoveFixServiceComponent(yaw, pitch, grim, moveFix);
    }

    public static MoveFixServiceComponent resolveMoveFixServiceComponent(MoveFixServiceComponent arg0, float arg1, float arg2, boolean arg3, OptionMode18 arg4, int arg5, Object arg6) {
        if ((arg5 & 1)) {
            arg1 = arg0.factorValue;
        }
        if ((arg5 & 2)) {
            arg2 = arg0.factorValue2;
        }
        if ((arg5 & 4)) {
            arg3 = arg0.enabledFlag;
        }
        if ((arg5 & 8)) {
            arg4 = arg0.optionMode18;
        }
        return arg0.resolveMoveFixServiceComponent(arg1, arg2, arg3, arg4);
    }

    public String toString() {
        OptionMode18 var3 = this.optionMode18;
        boolean var4 = this.enabledFlag;
        float var5 = this.factorValue2;
        float var6 = this.factorValue;
        return ("Rotation(yaw=" + var6 + ", pitch=" + var5 + ", grim=" + var4 + ", moveFix=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Float.hashCode(this.factorValue);
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue2));
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag));
        var3 = ((var3 * 31) + this.optionMode18.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MoveFixServiceComponent)) {
            return false;
        }
        MoveFixServiceComponent var5 = (MoveFixServiceComponent) other;
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        if (this.optionMode18 != var5.optionMode18) {
            return false;
        }
        return true;
    }

    static {
        vectorServiceComponent = new VectorServiceComponent();
    }

    public static void updateValue2(boolean arg0) {
        enabledFlag2 = arg0;
    }

    public static boolean isActive3() {
        return enabledFlag2;
    }

    public static boolean isActive4() {
        return true;
        return false;
    }

}
