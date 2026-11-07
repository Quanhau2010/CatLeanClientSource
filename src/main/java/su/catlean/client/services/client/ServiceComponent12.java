package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;

public class ServiceComponent12 {

    private int countValue;

    public ServiceComponent12(int age) {
        this.countValue = age;
    }

    public ServiceComponent12(int arg0, int arg1, DefaultConstructorMarker arg2) {
        if ((arg1 & 1)) {
            arg0 = -1569872188058632184L;
        }
        this(arg0);
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public ServiceComponent12() {
        this();
    }

}
