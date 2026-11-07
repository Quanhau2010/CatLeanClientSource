package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import su.catlean.client.features.modules.Module;

public class ServiceComponent30 {

    private float factorValue;
    private float factorValue2;
    private float factorValue3;
    private float factorValue4;
    private float factorValue5;
    private float factorValue6;
    private float factorValue7;
    private float factorValue8;
    private float factorValue9;
    private int countValue;
    private float factorValue10;
    private final float factorValue11;
    private final int countValue2;
    private final int countValue3;

    public ServiceComponent30(float x, float y, float z, float prevX, float prevY, float prevZ, float motionX, float motionY, float motionZ, int age, float rotation, float rotationSpeed, int offset, int maxAge) {
        this.factorValue = x;
        this.factorValue2 = y;
        this.factorValue3 = z;
        this.factorValue4 = prevX;
        this.factorValue5 = prevY;
        this.factorValue6 = prevZ;
        this.factorValue7 = motionX;
        this.factorValue8 = motionY;
        this.factorValue9 = motionZ;
        this.countValue = age;
        this.factorValue10 = rotation;
        this.factorValue11 = rotationSpeed;
        this.countValue2 = offset;
        this.countValue3 = maxAge;
    }

    public ServiceComponent30(float arg0, float arg1, float arg2, char arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, int arg10, float arg11, float arg12, int arg13, int arg14, int arg15, DefaultConstructorMarker arg16) {
        if ((arg15 & 8)) {
            arg4 = arg0;
        }
        if ((arg15 & 16)) {
            arg5 = arg1;
        }
        if ((arg15 & 32)) {
            arg6 = arg2;
        }
        if ((arg15 & 64)) {
            arg7 = RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(-0.1F, 0.1F));
        }
        if ((arg15 & 128)) {
            arg8 = RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(0.01F, 0.03F));
        }
        if ((arg15 & 256)) {
            arg9 = RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(-0.1F, 0.1F));
        }
        if ((arg15 & 512)) {
            arg10 = 0;
        }
        if ((arg15 & 1024)) {
            arg11 = RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(-15.0F, 15.0F));
        }
        if ((arg15 & 2048)) {
            arg12 = RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(-0.5F, 0.5F));
        }
        if ((arg15 & 4096)) {
            arg13 = RangeServiceComponent.f((ClosedRange) new IntRange(0, 360));
        }
        if ((arg15 & 8192)) {
            arg14 = RangeServiceComponent.f((ClosedRange) new IntRange(100, 200));
        }
        this(arg0, arg1, arg2, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
        if (arg3 > 0) {
        }
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

    public void updateValue4(float value) {
        this.factorValue4 = value;
    }

    public float getNumericValue5() {
        return this.factorValue5;
    }

    public void updateValue5(float value) {
        this.factorValue5 = value;
    }

    public float getNumericValue6() {
        return this.factorValue6;
    }

    public void updateValue6(float value) {
        this.factorValue6 = value;
    }

    public float getNumericValue7() {
        return this.factorValue7;
    }

    public void updateValue7(float value) {
        this.factorValue7 = value;
    }

    public float getNumericValue8() {
        return this.factorValue8;
    }

    public void updateValue8(float value) {
        this.factorValue8 = value;
    }

    public float getNumericValue9() {
        return this.factorValue9;
    }

    public void updateValue9(float value) {
        this.factorValue9 = value;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public float getNumericValue10() {
        return this.factorValue10;
    }

    public void updateValue10(float value) {
        this.factorValue10 = value;
    }

    public float getNumericValue11() {
        return this.factorValue11;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public int getNumericValue3() {
        return this.countValue3;
    }

}
