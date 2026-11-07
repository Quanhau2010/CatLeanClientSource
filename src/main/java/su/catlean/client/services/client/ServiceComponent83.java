package su.catlean.client.services.client;

public class ServiceComponent83 {

    private float factorValue;
    private float factorValue2;
    private float factorValue3;
    private float factorValue4;
    private int countValue;
    private float factorValue5;
    private float factorValue6;
    private boolean enabledFlag;

    public ServiceComponent83(float x, float y, float motionX, float motionY, int time, float lastX, float lastY, boolean flame) {
        this.factorValue = x;
        this.factorValue2 = y;
        this.factorValue3 = motionX;
        this.factorValue4 = motionY;
        this.countValue = time;
        this.factorValue5 = lastX;
        this.factorValue6 = lastY;
        this.enabledFlag = flame;
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

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
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

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

}
