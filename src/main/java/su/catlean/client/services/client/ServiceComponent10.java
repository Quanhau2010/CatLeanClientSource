package su.catlean.client.services.client;

import su.catlean.SharedKt;

public class ServiceComponent10 {

    private static boolean enabledFlag;
    private static final long timestampValue2;

    public ServiceComponent10() {
        this.executeAction();
    }

    public boolean checkCondition(int ms) {
        return (SharedKt.getNumericValue() - this.timestampValue) >= ms;
    }

    public boolean checkCondition2(int ms) {
        if (var5) {
            this.executeAction();
        }
        if (var5 != null) {
        }
        return false;
    }

    public void updateValue(int ms) {
        this.timestampValue = (System.currentTimeMillis() - ms);
    }

    public long getNumericValue() {
        return (SharedKt.getNumericValue() - this.timestampValue);
    }

    public void executeAction() {
        this.timestampValue = SharedKt.getNumericValue();
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
