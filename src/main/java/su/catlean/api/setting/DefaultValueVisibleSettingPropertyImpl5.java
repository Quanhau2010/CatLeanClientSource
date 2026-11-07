package su.catlean.api.setting;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import su.catlean.client.services.client.ServiceComponent16;
import su.catlean.client.services.client.ServiceComponent79;
import su.catlean.client.services.client.config.models.XRecord;

public class DefaultValueVisibleSettingPropertyImpl5 extends VisibleSettingProperty {

    public DefaultValueVisibleSettingPropertyImpl5(String id, XRecord defaultValue, SettingGroup group, Function0 visible) {
        super(id, defaultValue, null, group, visible);
    }

    public DefaultValueVisibleSettingPropertyImpl5(String arg0, XRecord arg1, SettingGroup arg2, Function0 arg3, int arg4, DefaultConstructorMarker arg5) {
        if ((arg4 & 4)) {
        }
        if ((arg4 & -7724479268603822072L)) {
            arg3 = this::isActive;
        }
        this(arg0, arg1, arg2, arg3);
    }

    public void setValue(String setting) {
        Json var4 = VisibleSettingProperty.serviceComponent79.getJson();
        Object var5 = setting;
        int var6 = 0;
        var4.getSerializersModule();
        this.updateValue(var4.decodeFromString((DeserializationStrategy) XRecord.serviceComponent16.getKSerializer()));
    }

    public String toString() {
        Json var1 = VisibleSettingProperty.serviceComponent79.getJson();
        Object var2 = this.getObject2();
        int var3 = 0;
        var1.getSerializersModule();
        return var1.encodeToString((SerializationStrategy) XRecord.serviceComponent16.getKSerializer());
    }

    private static boolean isActive() {
        return true;
    }

}
