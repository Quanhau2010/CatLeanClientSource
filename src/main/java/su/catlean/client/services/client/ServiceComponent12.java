package su.catlean.client.services.client;

public class ServiceComponent12 {

    private int countValue;

    public ServiceComponent12(int age) {
        this.countValue = age;
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
