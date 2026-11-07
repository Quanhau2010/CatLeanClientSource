package su.catlean.client.services.client;

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
        double offset = ((Math.pow(((((Number) SharedKt.getMc().options.method_42495().method_41753()) * 0.6D) + 0.2D), 3) * 8.0D) * 0.15F);
        float factor = class_3532.method_15393((this.factorValue - ((LocalPlayerAccessor) SharedKt.getPlayer()).getLastYaw()));
        float factor2 = class_3532.method_15393((this.factorValue2 - ((LocalPlayerAccessor) SharedKt.getPlayer()).getLastPitch()));
        int index = (MathKt.roundToInt((factor / offset)) * offset);
        int index2 = (MathKt.roundToInt((factor2 / offset)) * offset);
        this.factorValue = (((LocalPlayerAccessor) SharedKt.getPlayer()).getLastYaw() + index);
        this.factorValue2 = RangesKt.coerceIn((((LocalPlayerAccessor) SharedKt.getPlayer()).getLastPitch() + index2), -90.0F, 90.0F);
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
        if ((arg5 & 1) != 0) {
            arg1 = arg0.factorValue;
        }
        if ((arg5 & 2) != 0) {
            arg2 = arg0.factorValue2;
        }
        if ((arg5 & 4) != 0) {
            arg3 = arg0.enabledFlag;
        }
        if ((arg5 & 8) != 0) {
            arg4 = arg0.optionMode18;
        }
        return arg0.resolveMoveFixServiceComponent(arg1, arg2, arg3, arg4);
    }

    public String toString() {
        OptionMode18 optionMode18 = this.optionMode18;
        boolean flag = this.enabledFlag;
        float factor = this.factorValue2;
        float factor2 = this.factorValue;
        return ("Rotation(yaw=" + factor2 + ", pitch=" + factor + ", grim=" + flag + ", moveFix=" + optionMode18 + ")");
    }

    public int hashCode() {
        int index = Float.hashCode(this.factorValue);
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        index = ((index * 31) + this.optionMode18.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MoveFixServiceComponent)) {
            return false;
        }
        MoveFixServiceComponent moveFixServiceComponent = ((MoveFixServiceComponent) other);
        if (Float.compare(this.factorValue, moveFixServiceComponent.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, moveFixServiceComponent.factorValue2)) {
            return false;
        }
        if (this.enabledFlag != moveFixServiceComponent.enabledFlag) {
            return false;
        }
        if (this.optionMode18 != moveFixServiceComponent.optionMode18) {
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
