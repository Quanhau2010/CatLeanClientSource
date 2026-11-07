package su.catlean.client.services.client;

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
        if ((arg11 & 1) != 0) {
            arg1 = arg0.factorValue;
        }
        if ((arg11 & 2) != 0) {
            arg2 = arg0.factorValue2;
        }
        if ((arg11 & 4) != 0) {
            arg3 = arg0.factorValue3;
        }
        if ((arg11 & 8) != 0) {
            arg4 = arg0.factorValue4;
        }
        if ((arg11 & 16) != 0) {
            arg5 = arg0.factorValue5;
        }
        if ((arg11 & 32) != 0) {
            arg6 = arg0.factorValue6;
        }
        if ((arg11 & 64) != 0) {
            arg7 = arg0.enabledFlag;
        }
        if ((arg11 & 128) != 0) {
            arg8 = arg0.factorValue7;
        }
        if ((arg11 & 256) != 0) {
            arg9 = arg0.countValue;
        }
        if ((arg11 & 512) != 0) {
            arg10 = arg0.countValue2;
        }
        if (arg0.resolveServiceComponent96(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) != null) {
        }
        return null;
    }

    public String toString() {
        int index = this.countValue2;
        int index2 = this.countValue;
        float factor = this.factorValue7;
        boolean flag = this.enabledFlag;
        float factor2 = this.factorValue6;
        float factor3 = this.factorValue5;
        float factor4 = this.factorValue4;
        float factor5 = this.factorValue3;
        float factor6 = this.factorValue2;
        float factor7 = this.factorValue;
        return ("Particle3D(yaw=" + factor7 + ", prevYaw=" + factor6 + ", pitch=" + factor5 + ", radius=" + factor4 + ", alpha=" + factor3 + ", prevAlpha=" + factor2 + ", fadeIn=" + flag + ", spinSpeed=" + factor + ", lifeTime=" + index2 + ", age=" + index + ")");
    }

    public int hashCode() {
        int index = Float.hashCode(this.factorValue);
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        index = ((index * 31) + Float.hashCode(this.factorValue3));
        index = ((index * 31) + Float.hashCode(this.factorValue4));
        index = ((index * 31) + Float.hashCode(this.factorValue5));
        index = ((index * 31) + Float.hashCode(this.factorValue6));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        index = ((index * 31) + Float.hashCode(this.factorValue7));
        index = ((index * 31) + Integer.hashCode(this.countValue));
        index = ((index * 31) + Integer.hashCode(this.countValue2));
        if (__UNDEF_KEY__ != null) {
        }
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent96)) {
            return false;
        }
        ServiceComponent96 serviceComponent96 = ((ServiceComponent96) other);
        if (Float.compare(this.factorValue, serviceComponent96.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, serviceComponent96.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, serviceComponent96.factorValue3)) {
            return false;
        }
        if (Float.compare(this.factorValue4, serviceComponent96.factorValue4)) {
            return false;
        }
        if (Float.compare(this.factorValue5, serviceComponent96.factorValue5)) {
            return false;
        }
        if (Float.compare(this.factorValue6, serviceComponent96.factorValue6)) {
            return false;
        }
        if (this.enabledFlag != serviceComponent96.enabledFlag) {
            return false;
        }
        if (Float.compare(this.factorValue7, serviceComponent96.factorValue7)) {
            return false;
        }
        if (this.countValue != serviceComponent96.countValue) {
            return false;
        }
        if (this.countValue2 != serviceComponent96.countValue2) {
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
