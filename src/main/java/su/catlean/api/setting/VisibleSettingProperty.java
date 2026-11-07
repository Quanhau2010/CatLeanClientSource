package su.catlean.api.setting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import su.catlean.client.services.client.ServiceComponent79;

public abstract class VisibleSettingProperty {

    public static final ServiceComponent79 serviceComponent79;
    private final String textValue;
    private final Object object;
    private Object object2;
    private SettingGroup settingGroup;
    private Function0 function0;
    private final String textValue2;
    private static final Json json;
    private static int countValue;

    public VisibleSettingProperty(String id, Object defaultValue, Object value, SettingGroup group, Function0 visible) {
        this.textValue = id;
        this.object = defaultValue;
        this.object2 = value;
        this.settingGroup = group;
        this.function0 = visible;
        StringBuilder stringBuilder = new StringBuilder();
        String[] items = new String[1];
        items[0] = "-";
        items = ((Iterable) StringsKt.split$default(((CharSequence) this.textValue), items, false));
        String[] items2 = items;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = items2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            String text = ((String) element);
            collection.add(element);
        }
        items = ((Iterable) collection);
        items2 = items.iterator();
        while (items2.hasNext()) {
            collection = items2.next();
            index = ((String) collection);
            iterator = 0;
            stringBuilder.append(" ");
            stringBuilder.append(index.substring(0, 1).toUpperCase(Locale.ROOT));
            stringBuilder.append(index.substring(1).toLowerCase(Locale.ROOT));
        }
        this.textValue2 = stringBuilder.toString();
    }

    public String getString() {
        return this.textValue;
    }

    public Object getObject() {
        return this.object;
    }

    public Object getObject2() {
        return this.object2;
    }

    public void updateValue(Object value) {
        this.object2 = value;
    }

    public SettingGroup getSettingGroup() {
        return this.settingGroup;
    }

    public void updateValue(SettingGroup value) {
        this.settingGroup = value;
    }

    public Function0 getFunction0() {
        return this.function0;
    }

    public void setValue(Function0 value) {
        this.function0 = value;
    }

    public String getString2() {
        return this.textValue2;
    }

    public Object getValue(Object thisRef, KProperty property) {
        return this.object2;
    }

    public void setValue(Object thisRef, KProperty property, Object value) {
        this.object2 = value;
    }

    public void setValue() {
        this.object2 = this.object;
    }

    public void setValue(String arg0) {
    }

    private static boolean isActive() {
        return true;
    }

    private static Unit resolveUnit(JsonBuilder arg0) {
        arg0.setIgnoreUnknownKeys(true);
        arg0.setEncodeDefaults(true);
        return Unit.INSTANCE;
    }

    public static Json getJson() {
        return json;
    }

    static {
        serviceComponent79 = new ServiceComponent79();
        json = JsonKt.Json$default(null, this::resolveUnit);
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 62;
        return 0;
    }

}
