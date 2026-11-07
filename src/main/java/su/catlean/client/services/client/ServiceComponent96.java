package su.catlean.client.services.client;

import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.DefaultConstructorMarker;
import su.catlean.client.features.modules.Module;

public class ServiceComponent96 {

    private float factorValue;
    private float factorValue2;
    private float factorValue3;
    private final float factorValue4;
    private float factorValue5;
    private float factorValue6;
    private boolean enabledFlag;
    private final float factorValue7;
    private final int countValue;
    private int countValue2;
    private static String[] textValueArray;

    public ServiceComponent96(float yaw, float prevYaw, float pitch, float radius, float alpha, float prevAlpha, boolean fadeIn, float spinSpeed, int lifeTime, int age) {
        this.factorValue = yaw;
        this.factorValue2 = prevYaw;
        this.factorValue3 = pitch;
        this.factorValue4 = radius;
        this.factorValue5 = alpha;
        this.factorValue6 = prevAlpha;
        this.enabledFlag = fadeIn;
        this.factorValue7 = spinSpeed;
        this.countValue = lifeTime;
        this.countValue2 = age;
    }

    public ServiceComponent96(float arg0, float arg1, float arg2, float arg3, float arg4, float arg5, boolean arg6, float arg7, int arg8, int arg9, int arg10, DefaultConstructorMarker arg11) {
        if ((arg10 & 2)) {
            arg1 = arg0;
        }
        if ((arg10 & 16)) {
            arg4 = 0.0F;
        }
        if ((arg10 & 32)) {
            arg5 = 0.0F;
        }
        if ((arg10 & 64)) {
            arg6 = 1;
        }
        if ((arg10 & 128)) {
            arg7 = (1.5F + (ThreadLocalRandom.current().nextFloat() * 1.0F));
        }
        if ((arg10 & 256)) {
            arg8 = ThreadLocalRandom.current().nextInt(15, 35);
        }
        if ((arg10 & 512)) {
            arg9 = 0;
        }
        this(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
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

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public void updateValue3(float value) {
        this.factorValue3 = value;
    }

    public float getNumericValue4() {
        return this.factorValue4;
    }

    public float getNumericValue5() {
        return this.factorValue5;
    }

    public void updateValue4(float value) {
        this.factorValue5 = value;
    }

    public float getNumericValue6() {
        return this.factorValue6;
    }

    public void updateValue5(float value) {
        this.factorValue6 = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public float getNumericValue7() {
        return this.factorValue7;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public void updateValue(int value) {
        this.countValue2 = value;
    }

    public float getNumericValue8() {
        return this.factorValue;
    }

    public float getNumericValue9() {
        return this.factorValue2;
    }

    public float getNumericValue10() {
        return this.factorValue3;
    }

    public float getNumericValue11() {
        return this.factorValue4;
    }

    public float getNumericValue12() {
        return this.factorValue5;
    }

    public float getNumericValue13() {
        return this.factorValue6;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public float getNumericValue14() {
        return this.factorValue7;
    }

    public int getNumericValue3() {
        return this.countValue;
    }

    public int getNumericValue4() {
        return this.countValue2;
    }

    public ServiceComponent96 resolveServiceComponent96(float yaw, float prevYaw, float pitch, float radius, float alpha, float prevAlpha, boolean fadeIn, float spinSpeed, int lifeTime, int age) {
        return new ServiceComponent96(yaw, prevYaw, pitch, radius, alpha, prevAlpha, fadeIn, spinSpeed, lifeTime, age);
    }

    public static ServiceComponent96 resolveServiceComponent96(ServiceComponent96 arg0, float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, boolean arg7, float arg8, int arg9, int arg10, int arg11, Object arg12) {
        if ((arg11 & 1)) {
            arg1 = arg0.factorValue;
        }
        if ((arg11 & 2)) {
            arg2 = arg0.factorValue2;
        }
        if ((arg11 & 4)) {
            arg3 = arg0.factorValue3;
        }
        if ((arg11 & 8)) {
            arg4 = arg0.factorValue4;
        }
        if ((arg11 & 16)) {
            arg5 = arg0.factorValue5;
        }
        if ((arg11 & 32)) {
            arg6 = arg0.factorValue6;
        }
        if ((arg11 & 64)) {
            arg7 = arg0.enabledFlag;
        }
        if ((arg11 & 128)) {
            arg8 = arg0.factorValue7;
        }
        if ((arg11 & 256)) {
            arg9 = arg0.countValue;
        }
        if ((arg11 & 512)) {
            arg10 = arg0.countValue2;
        }
        if (arg0.resolveServiceComponent96(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) != null) {
        }
        return null;
    }

    public String toString() {
        int var3 = this.countValue2;
        int var4 = this.countValue;
        float var5 = this.factorValue7;
        boolean var6 = this.enabledFlag;
        float var7 = this.factorValue6;
        float var8 = this.factorValue5;
        float var9 = this.factorValue4;
        float var10 = this.factorValue3;
        float var11 = this.factorValue2;
        float var12 = this.factorValue;
        return ("Particle3D(yaw=" + var12 + ", prevYaw=" + var11 + ", pitch=" + var10 + ", radius=" + var9 + ", alpha=" + var8 + ", prevAlpha=" + var7 + ", fadeIn=" + var6 + ", spinSpeed=" + var5 + ", lifeTime=" + var4 + ", age=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = Float.hashCode(this.factorValue);
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue2));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue3));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue4));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue5));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue6));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue7));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue2));
        if (var3 != null) {
        }
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent96)) {
            return false;
        }
        ServiceComponent96 var5 = (ServiceComponent96) other;
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, var5.factorValue3)) {
            return false;
        }
        if (Float.compare(this.factorValue4, var5.factorValue4)) {
            return false;
        }
        if (Float.compare(this.factorValue5, var5.factorValue5)) {
            return false;
        }
        if (Float.compare(this.factorValue6, var5.factorValue6)) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        if (Float.compare(this.factorValue7, var5.factorValue7)) {
            return false;
        }
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (this.countValue2 != var5.countValue2) {
            return false;
        }
        return true;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
