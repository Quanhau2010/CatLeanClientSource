package su.catlean.api.setting;

import kotlin.jvm.functions.Function0;
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

    public void setValue(String setting) {
        Json json = VisibleSettingProperty.serviceComponent79.getJson();
        json.getSerializersModule();
        this.updateValue(json.decodeFromString(((DeserializationStrategy) XRecord.serviceComponent16.getKSerializer()), setting));
    }

    public String toString() {
        Json json = VisibleSettingProperty.serviceComponent79.getJson();
        Object element = this.getObject2();
        json.getSerializersModule();
        return json.encodeToString(((SerializationStrategy) XRecord.serviceComponent16.getKSerializer()), element);
    }

    private static boolean isActive() {
        return true;
    }

}
