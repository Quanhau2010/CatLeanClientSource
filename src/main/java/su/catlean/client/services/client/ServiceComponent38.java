package su.catlean.client.services.client;

import su.catlean.SharedKt;

public class ServiceComponent38 {

    private int countValue;
    private static String[] textValueArray;

    public ServiceComponent38() {
        this.updateValue();
    }

    public boolean checkCondition(int t) {
        if (this.computeValue2() < 0) {
            this.updateValue();
        }
        if (0L >= 0) {
            if (!(var11)) {
            }
            if (this.computeValue2() >= t) {
            }
        } else {
        }
        return false;
    }

    public boolean checkCondition(int ms) {
        if (this.computeValue2() < 0) {
            this.updateValue();
        }
        boolean var9 = this.computeValue2() >= ms;
        if (var9) {
            this.updateValue();
        }
        return var9;
    }

    public void executeAction(int t) {
        this.countValue = (SharedKt.getMc().player != null + t);
    }

    public void updateValue() {
        this.countValue = SharedKt.getMc().player != null;
    }

    public int computeValue() {
        return this.computeValue2();
    }

    private int computeValue2() {
        if (SharedKt.getMc().player == null) {
        } else {
        }
        return (SharedKt.getMc().player.field_6012 - this.countValue);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
