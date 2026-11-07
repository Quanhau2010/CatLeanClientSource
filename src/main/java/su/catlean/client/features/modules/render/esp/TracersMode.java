package su.catlean.client.features.modules.render.esp;

import su.catlean.client.types.OptionMode6;

public enum TracersMode {

    private final OptionMode6 optionMode6;
    public static final TracersMode ARROWS_1;
    public static final TracersMode ARROWS_2;
    public static final TracersMode ARROWS_3;
    public static final TracersMode ARROWS_4;
    public static final TracersMode ARROWS_5;
    public static final TracersMode LINES;
    private static int countValue;

    TracersMode(String arg0, int arg1, OptionMode6 arg2) {
        super(arg0, arg1);
        this.optionMode6 = arg2;
    }

    public OptionMode6 getOptionMode6() {
        return this.optionMode6;
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 94;
        return 0;
    }

}
