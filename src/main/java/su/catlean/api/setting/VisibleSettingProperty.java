package su.catlean.api.setting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
        StringBuilder var8 = new StringBuilder();
        Object var9 = var8;
        Object var20 = this;
        int var10 = 0;
        String[] var11 = new String[1];
        var11[0] = "-";
        var11 = (Iterable) StringsKt.split$default((CharSequence) this.textValue);
        int var12 = 0;
        Object var13 = var11;
        Collection var14 = (Collection) new ArrayList();
        int var15 = 0;
        Iterator iterator = var13.iterator();
        while (iterator.hasNext()) {
            Object var17 = iterator.next();
            String var18 = (String) var17;
            int var19 = 0;
            var14.add();
        }
        var11 = (Iterable) var14;
        var12 = 0;
        var13 = var11.iterator();
        while (var13.hasNext()) {
            var14 = var13.next();
            var15 = (String) var14;
            iterator = 0;
            var9.append(" ");
            var9.append(var15.substring(0, 1).toUpperCase(Locale.ROOT));
            var9.append(var15.substring(1).toLowerCase(Locale.ROOT));
        }
        var20.textValue2 = var8.toString();
    }

    public VisibleSettingProperty(String arg0, Object arg1, Object arg2, SettingGroup arg3, Function0 arg4, int arg5, DefaultConstructorMarker arg6) {
        if ((arg5 & 4)) {
            arg2 = arg1;
        }
        if ((arg5 & 8)) {
        }
        if ((arg5 & 16)) {
            arg4 = this::isActive;
        }
        this(arg0, arg1, arg2, arg3, arg4);
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
        arg0.setIgnoreUnknownKeys(1);
        arg0.setEncodeDefaults(1);
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
