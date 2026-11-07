package su.catlean.client.services.client;

public class ServiceComponent78 {

    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;
    private final float factorValue4;
    private static boolean enabledFlag;

    public ServiceComponent78(float x, float y, float x1, float y1) {
        this.factorValue = x;
        this.factorValue2 = y;
        this.factorValue3 = x1;
        this.factorValue4 = y1;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public float getNumericValue4() {
        return this.factorValue4;
    }

    public float getNumericValue5() {
        return this.factorValue;
    }

    public float getNumericValue6() {
        return this.factorValue2;
    }

    public float getNumericValue7() {
        return this.factorValue3;
    }

    public float getNumericValue8() {
        return this.factorValue4;
    }

    public ServiceComponent78 resolveServiceComponent78(float x, float y, float x1, float y1) {
        return new ServiceComponent78(x, y, x1, y1);
    }

    public static ServiceComponent78 resolveServiceComponent78(ServiceComponent78 arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if ((arg5 & 1)) {
            arg1 = arg0.factorValue;
        }
        if ((arg5 & 2)) {
            arg2 = arg0.factorValue2;
        }
        if ((arg5 & 4)) {
            arg3 = arg0.factorValue3;
        }
        if ((arg5 & 8)) {
            arg4 = arg0.factorValue4;
        }
        return arg0.resolveServiceComponent78(arg1, arg2, arg3, arg4);
    }

    public String toString() {
        float var3 = this.factorValue4;
        float var4 = this.factorValue3;
        float var5 = this.factorValue2;
        float var6 = this.factorValue;
        return ("Rectangle(x=" + var6 + ", y=" + var5 + ", x1=" + var4 + ", y1=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Float.hashCode(this.factorValue);
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue2));
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue3));
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue4));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent78)) {
            return false;
        }
        ServiceComponent78 var5 = (ServiceComponent78) other;
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
        return true;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
