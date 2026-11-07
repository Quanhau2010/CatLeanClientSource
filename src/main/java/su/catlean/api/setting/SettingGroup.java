package su.catlean.api.setting;

import su.catlean.client.types.OptionMode14;

public class SettingGroup {

    private boolean enabledFlag;
    private OptionMode14 optionMode14;
    private static String[] textValueArray;

    public SettingGroup(boolean extended, OptionMode14 type) {
        this.enabledFlag = extended;
        this.optionMode14 = type;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public OptionMode14 getOptionMode14() {
        return this.optionMode14;
    }

    public void setValue(OptionMode14 value) {
        this.optionMode14 = value;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
