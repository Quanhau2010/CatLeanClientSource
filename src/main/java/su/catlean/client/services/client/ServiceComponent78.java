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
        if ((arg5 & 1) != 0) {
            arg1 = arg0.factorValue;
        }
        if ((arg5 & 2) != 0) {
            arg2 = arg0.factorValue2;
        }
        if ((arg5 & 4) != 0) {
            arg3 = arg0.factorValue3;
        }
        if ((arg5 & 8) != 0) {
            arg4 = arg0.factorValue4;
        }
        return arg0.resolveServiceComponent78(arg1, arg2, arg3, arg4);
    }

    public String toString() {
        float factor = this.factorValue4;
        float factor2 = this.factorValue3;
        float factor3 = this.factorValue2;
        float factor4 = this.factorValue;
        return ("Rectangle(x=" + factor4 + ", y=" + factor3 + ", x1=" + factor2 + ", y1=" + factor + ")");
    }

    public int hashCode() {
        int index = Float.hashCode(this.factorValue);
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        index = ((index * 31) + Float.hashCode(this.factorValue3));
        index = ((index * 31) + Float.hashCode(this.factorValue4));
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent78)) {
            return false;
        }
        ServiceComponent78 serviceComponent78 = ((ServiceComponent78) other);
        if (Float.compare(this.factorValue, serviceComponent78.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, serviceComponent78.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, serviceComponent78.factorValue3)) {
            return false;
        }
        if (Float.compare(this.factorValue4, serviceComponent78.factorValue4)) {
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
