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
        if ((arg6 & 1)) {
            arg1 = arg0.preciseValue;
        }
        if ((arg6 & 2)) {
            arg2 = arg0.preciseValue2;
        }
        if ((arg6 & 4)) {
            arg3 = arg0.preciseValue3;
        }
        if ((arg6 & 8)) {
            arg4 = arg0.factorValue;
        }
        if ((arg6 & 16)) {
            arg5 = arg0.factorValue2;
        }
        if (arg0.resolveServiceComponent130(arg1, arg2, arg3, arg4, arg5) != null) {
        }
        return null;
    }

    public String toString() {
        float var3 = this.factorValue2;
        float var4 = this.factorValue;
        double var5 = this.preciseValue3;
        double var7 = this.preciseValue2;
        double var9 = this.preciseValue;
        return ("PlayerState(x=" + var9 + ", y=" + var7 + ", z=" + var5 + ", yaw=" + var4 + ", pitch=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = Double.hashCode(this.preciseValue);
        var4 = ((var4 * 31) + Double.hashCode(this.preciseValue2));
        var4 = ((var4 * 31) + Double.hashCode(this.preciseValue3));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue2));
        if (var3 != null) {
        }
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent130)) {
            return false;
        }
        ServiceComponent130 var5 = (ServiceComponent130) other;
        if (Double.compare(this.preciseValue, var5.preciseValue)) {
            return false;
        }
        if (Double.compare(this.preciseValue2, var5.preciseValue2)) {
            return false;
        }
        if (Double.compare(this.preciseValue3, var5.preciseValue3)) {
            return false;
        }
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        return true;
    }

}
