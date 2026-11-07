package su.catlean.client.services.client;

import su.catlean.client.features.modules.Module;

public class ServiceComponent130 {

    private final double preciseValue;
    private final double preciseValue2;
    private final double preciseValue3;
    private final float factorValue;
    private final float factorValue2;

    public ServiceComponent130(double x, double y, double z, float yaw, float pitch) {
        this.preciseValue = x;
        this.preciseValue2 = y;
        this.preciseValue3 = z;
        this.factorValue = yaw;
        this.factorValue2 = pitch;
    }

    public double getNumericValue() {
        return this.preciseValue;
    }

    public double getNumericValue2() {
        return this.preciseValue2;
    }

    public double getNumericValue3() {
        return this.preciseValue3;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public double getNumericValue4() {
        return this.preciseValue;
    }

    public double getNumericValue5() {
        return this.preciseValue2;
    }

    public double getNumericValue6() {
        return this.preciseValue3;
    }

    public float getNumericValue3() {
        return this.factorValue;
    }

    public float getNumericValue4() {
        return this.factorValue2;
    }

    public ServiceComponent130 resolveServiceComponent130(double x, double y, double z, float yaw, float pitch) {
        return new ServiceComponent130(x, y, z, yaw, pitch);
    }

    public static ServiceComponent130 resolveServiceComponent130(ServiceComponent130 arg0, double arg1, double arg2, double arg3, float arg4, float arg5, int arg6, Object arg7) {
        if ((arg6 & 1) != 0) {
            arg1 = arg0.preciseValue;
        }
        if ((arg6 & 2) != 0) {
            arg2 = arg0.preciseValue2;
        }
        if ((arg6 & 4) != 0) {
            arg3 = arg0.preciseValue3;
        }
        if ((arg6 & 8) != 0) {
            arg4 = arg0.factorValue;
        }
        if ((arg6 & 16) != 0) {
            arg5 = arg0.factorValue2;
        }
        if (arg0.resolveServiceComponent130(arg1, arg2, arg3, arg4, arg5) != null) {
        }
        return null;
    }

    public String toString() {
        float factor = this.factorValue2;
        float factor2 = this.factorValue;
        double offset = this.preciseValue3;
        double offset2 = this.preciseValue2;
        double offset3 = this.preciseValue;
        return ("PlayerState(x=" + offset3 + ", y=" + offset2 + ", z=" + offset + ", yaw=" + factor2 + ", pitch=" + factor + ")");
    }

    public int hashCode() {
        int index = Double.hashCode(this.preciseValue);
        index = ((index * 31) + Double.hashCode(this.preciseValue2));
        index = ((index * 31) + Double.hashCode(this.preciseValue3));
        index = ((index * 31) + Float.hashCode(this.factorValue));
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        if (__UNDEF_KEY__ != null) {
        }
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent130)) {
            return false;
        }
        ServiceComponent130 serviceComponent130 = ((ServiceComponent130) other);
        if (Double.compare(this.preciseValue, serviceComponent130.preciseValue)) {
            return false;
        }
        if (Double.compare(this.preciseValue2, serviceComponent130.preciseValue2)) {
            return false;
        }
        if (Double.compare(this.preciseValue3, serviceComponent130.preciseValue3)) {
            return false;
        }
        if (Float.compare(this.factorValue, serviceComponent130.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, serviceComponent130.factorValue2)) {
            return false;
        }
        return true;
    }

}
