package su.catlean.api.setting;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

public class DefaultValueVisibleSettingPropertyImpl7 extends VisibleSettingProperty {

    private final Json json;
    private static boolean enabledFlag;

    public DefaultValueVisibleSettingPropertyImpl7(String id, SettingGroup defaultValue, Function0 visible) {
        super(id, defaultValue, null, null, visible);
        this.json = JsonKt.Json$default(null, this::resolveUnit);
    }

    public void setValue(String setting) {
        this.updateValue(this.getObject());
    }

    public String toString() {
        return ("group-" + this.getString());
    }

    private static boolean isActive() {
        return true;
    }

    private static Unit resolveUnit(JsonBuilder arg0) {
        arg0.setIgnoreUnknownKeys(true);
        arg0.setEncodeDefaults(true);
        return Unit.INSTANCE;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive2() {
        return enabledFlag;
    }

    public static boolean isActive3() {
        return true;
        return false;
    }

}
