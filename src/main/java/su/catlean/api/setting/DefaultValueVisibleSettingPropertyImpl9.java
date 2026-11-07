package su.catlean.api.setting;

import java.awt.Color;
import kotlin.jvm.functions.Function0;

public class DefaultValueVisibleSettingPropertyImpl9 extends VisibleSettingProperty {

    private static String textValue;

    public DefaultValueVisibleSettingPropertyImpl9(String id, Color defaultValue, SettingGroup group, Function0 visible) {
        super(id, defaultValue, null, group, visible);
    }

    public void setValue(String setting) {
        this.updateValue(new Color(Integer.parseInt(setting), 1));
    }

    public String toString() {
        return String.valueOf((Color) this.getObject2().getRGB());
    }

    private static boolean isActive() {
        return true;
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
