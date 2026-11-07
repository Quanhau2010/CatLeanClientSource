package su.catlean.client.services.client;

import su.catlean.client.types.OptionMode8;

public class ServiceComponent87 {

    private String textValue;
    private float factorValue;
    private float factorValue2;
    private final OptionMode8 optionMode8;

    public ServiceComponent87(String name, float x, float y, OptionMode8 type) {
        this.textValue = name;
        this.factorValue = x;
        this.factorValue2 = y;
        this.optionMode8 = type;
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(String value) {
        this.textValue = value;
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

    public OptionMode8 getOptionMode8() {
        return this.optionMode8;
    }

}
