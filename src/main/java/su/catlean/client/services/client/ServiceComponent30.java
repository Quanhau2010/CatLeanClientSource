package su.catlean.client.services.client;

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
