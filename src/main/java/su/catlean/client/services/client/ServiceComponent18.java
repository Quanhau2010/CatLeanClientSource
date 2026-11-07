package su.catlean.client.services.client;

public class ServiceComponent18 {

    private final double preciseValue;
    private final double preciseValue2;
    private final double preciseValue3;
    private final double preciseValue4;
    private final double preciseValue5;
    private final double preciseValue6;

    public ServiceComponent18(double westDelta, double eastDelta, double northDelta, double southDelta, double upDelta, double downDelta) {
        this.preciseValue = westDelta;
        this.preciseValue2 = eastDelta;
        this.preciseValue3 = northDelta;
        this.preciseValue4 = southDelta;
        this.preciseValue5 = upDelta;
        this.preciseValue6 = downDelta;
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

    public double getNumericValue4() {
        return this.preciseValue4;
    }

    public double getNumericValue5() {
        return this.preciseValue5;
    }

    public double getNumericValue6() {
        return this.preciseValue6;
    }

    public double getNumericValue7() {
        return this.preciseValue;
    }

    public double getNumericValue8() {
        return this.preciseValue2;
    }

    public double getNumericValue9() {
        return this.preciseValue3;
    }

    public double getNumericValue10() {
        return this.preciseValue4;
    }

    public double getNumericValue11() {
        return this.preciseValue5;
    }

    public double getNumericValue12() {
        return this.preciseValue6;
    }

    public ServiceComponent18 resolveServiceComponent18(double westDelta, double eastDelta, double northDelta, double southDelta, double upDelta, double downDelta) {
        return new ServiceComponent18(westDelta, eastDelta, northDelta, southDelta, upDelta, downDelta);
    }

    public static ServiceComponent18 resolveServiceComponent18(ServiceComponent18 arg0, double arg1, double arg2, double arg3, double arg4, double arg5, double arg6, int arg7, Object arg8) {
        if ((arg7 & 1)) {
            arg1 = arg0.preciseValue;
        }
        if ((arg7 & 2)) {
            arg2 = arg0.preciseValue2;
        }
        if ((arg7 & 4)) {
            arg3 = arg0.preciseValue3;
        }
        if ((arg7 & 8)) {
            arg4 = arg0.preciseValue4;
        }
        if ((arg7 & 16)) {
            arg5 = arg0.preciseValue5;
        }
        if ((arg7 & 32)) {
            arg6 = arg0.preciseValue6;
        }
        return arg0.resolveServiceComponent18(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public String toString() {
        double var3 = this.preciseValue6;
        double var5 = this.preciseValue5;
        double var7 = this.preciseValue4;
        double var9 = this.preciseValue3;
        double var11 = this.preciseValue2;
        double var13 = this.preciseValue;
        return ("DirectionDeltas(westDelta=" + var13 + ", eastDelta=" + var11 + ", northDelta=" + var9 + ", southDelta=" + var7 + ", upDelta=" + var5 + ", downDelta=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Double.hashCode(this.preciseValue);
        var3 = ((var3 * 31) + Double.hashCode(this.preciseValue2));
        var3 = ((var3 * 31) + Double.hashCode(this.preciseValue3));
        var3 = ((var3 * 31) + Double.hashCode(this.preciseValue4));
        var3 = ((var3 * 31) + Double.hashCode(this.preciseValue5));
        var3 = ((var3 * 31) + Double.hashCode(this.preciseValue6));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent18)) {
            return false;
        }
        ServiceComponent18 var5 = (ServiceComponent18) other;
        if (Double.compare(this.preciseValue, var5.preciseValue)) {
            return false;
        }
        if (Double.compare(this.preciseValue2, var5.preciseValue2)) {
            return false;
        }
        if (Double.compare(this.preciseValue3, var5.preciseValue3)) {
            return false;
        }
        if (Double.compare(this.preciseValue4, var5.preciseValue4)) {
            return false;
        }
        if (Double.compare(this.preciseValue5, var5.preciseValue5)) {
            return false;
        }
        if (Double.compare(this.preciseValue6, var5.preciseValue6)) {
            return false;
        }
        return true;
    }

}
