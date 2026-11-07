package su.catlean.client.services.client;

import su.catlean.client.features.modules.Module;

public class ServiceComponent8 {

    private final float factorValue;
    private final float factorValue2;
    private final boolean enabledFlag;
    private final boolean enabledFlag2;
    private final boolean enabledFlag3;
    private final boolean enabledFlag4;
    private final boolean enabledFlag5;
    private final boolean enabledFlag6;
    private final boolean enabledFlag7;
    private final boolean enabledFlag8;
    private static String textValue;

    public ServiceComponent8(float yaw, float pitch, boolean forward, boolean back, boolean left, boolean right, boolean sneak, boolean jump, boolean use, boolean attack) {
        this.factorValue = yaw;
        this.factorValue2 = pitch;
        this.enabledFlag = forward;
        this.enabledFlag2 = back;
        this.enabledFlag3 = left;
        this.enabledFlag4 = right;
        this.enabledFlag5 = sneak;
        this.enabledFlag6 = jump;
        this.enabledFlag7 = use;
        this.enabledFlag8 = attack;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public boolean isActive2() {
        return this.enabledFlag2;
    }

    public boolean isActive3() {
        return this.enabledFlag3;
    }

    public boolean isActive4() {
        return this.enabledFlag4;
    }

    public boolean isActive5() {
        return this.enabledFlag5;
    }

    public boolean isActive6() {
        return this.enabledFlag6;
    }

    public boolean isActive7() {
        return this.enabledFlag7;
    }

    public boolean isActive8() {
        return this.enabledFlag8;
    }

    public float getNumericValue3() {
        return this.factorValue;
    }

    public float getNumericValue4() {
        return this.factorValue2;
    }

    public boolean isActive9() {
        return this.enabledFlag;
    }

    public boolean isActive10() {
        return this.enabledFlag2;
    }

    public boolean isActive11() {
        return this.enabledFlag3;
    }

    public boolean isActive12() {
        return this.enabledFlag4;
    }

    public boolean isActive13() {
        return this.enabledFlag5;
    }

    public boolean isActive14() {
        return this.enabledFlag6;
    }

    public boolean isActive15() {
        return this.enabledFlag7;
    }

    public boolean isActive16() {
        return this.enabledFlag8;
    }

    public ServiceComponent8 resolveServiceComponent8(float yaw, float pitch, boolean forward, boolean back, boolean left, boolean right, boolean sneak, boolean jump, boolean use, boolean attack) {
        return new ServiceComponent8(yaw, pitch, forward, back, left, right, sneak, jump, use, attack);
    }

    public static ServiceComponent8 resolveServiceComponent8(ServiceComponent8 arg0, float arg1, float arg2, boolean arg3, boolean arg4, boolean arg5, boolean arg6, boolean arg7, boolean arg8, boolean arg9, boolean arg10, int arg11, Object arg12) {
        if ((arg11 & 1)) {
            arg1 = arg0.factorValue;
        }
        if ((arg11 & 2)) {
            arg2 = arg0.factorValue2;
        }
        if ((arg11 & 4)) {
            arg3 = arg0.enabledFlag;
        }
        if ((arg11 & 8)) {
            arg4 = arg0.enabledFlag2;
        }
        if ((arg11 & 16)) {
            arg5 = arg0.enabledFlag3;
        }
        if ((arg11 & 32)) {
            arg6 = arg0.enabledFlag4;
        }
        if ((arg11 & 64)) {
            arg7 = arg0.enabledFlag5;
        }
        if ((arg11 & 128)) {
            arg8 = arg0.enabledFlag6;
        }
        if ((arg11 & 256)) {
            arg9 = arg0.enabledFlag7;
        }
        if ((arg11 & 512)) {
            arg10 = arg0.enabledFlag8;
        }
        if (arg0.resolveServiceComponent8(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) != null) {
        }
        return null;
    }

    public String toString() {
        boolean var3 = this.enabledFlag8;
        boolean var4 = this.enabledFlag7;
        boolean var5 = this.enabledFlag6;
        boolean var6 = this.enabledFlag5;
        boolean var7 = this.enabledFlag4;
        boolean var8 = this.enabledFlag3;
        boolean var9 = this.enabledFlag2;
        boolean var10 = this.enabledFlag;
        float var11 = this.factorValue2;
        float var12 = this.factorValue;
        return ("ActionRecord(yaw=" + var12 + ", pitch=" + var11 + ", forward=" + var10 + ", back=" + var9 + ", left=" + var8 + ", right=" + var7 + ", sneak=" + var6 + ", jump=" + var5 + ", use=" + var4 + ", attack=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = Float.hashCode(this.factorValue);
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue2));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag2));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag3));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag4));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag5));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag6));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag7));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag8));
        if (var3 != null) {
        }
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent8)) {
            return false;
        }
        ServiceComponent8 var5 = (ServiceComponent8) other;
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        if (this.enabledFlag2 != var5.enabledFlag2) {
            return false;
        }
        if (this.enabledFlag3 != var5.enabledFlag3) {
            return false;
        }
        if (this.enabledFlag4 != var5.enabledFlag4) {
            return false;
        }
        if (this.enabledFlag5 != var5.enabledFlag5) {
            return false;
        }
        if (this.enabledFlag6 != var5.enabledFlag6) {
            return false;
        }
        if (this.enabledFlag7 != var5.enabledFlag7) {
            return false;
        }
        if (this.enabledFlag8 != var5.enabledFlag8) {
            return false;
        }
        return true;
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
