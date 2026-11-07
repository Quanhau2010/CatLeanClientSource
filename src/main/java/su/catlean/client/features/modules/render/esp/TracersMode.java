package su.catlean.client.features.modules.render.esp;

import su.catlean.client.types.OptionMode6;

public enum TracersMode {

    ARROWS_1,
    ARROWS_2,
    ARROWS_3,
    ARROWS_4,
    ARROWS_5,
    LINES;

    private final OptionMode6 optionMode6;
    private static int countValue;

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
