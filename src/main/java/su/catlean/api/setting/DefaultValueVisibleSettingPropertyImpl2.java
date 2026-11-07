package su.catlean.api.setting;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import su.catlean.client.services.client.ServiceComponent70;
import su.catlean.client.services.client.config.models.KeyRecord;

public class DefaultValueVisibleSettingPropertyImpl2 extends VisibleSettingProperty {

    private final Json json;
    private static int countValue;

    public DefaultValueVisibleSettingPropertyImpl2(String id, KeyRecord defaultValue, Function0 visible) {
        super(id, defaultValue, null, null, visible);
        this.json = JsonKt.Json$default(null, this::resolveUnit);
    }

    public void setValue(String setting) {
        Json json = this.json;
        json.getSerializersModule();
        this.updateValue(json.decodeFromString(((DeserializationStrategy) KeyRecord.serviceComponent70.getKSerializer()), setting));
    }

    public String toString() {
        Json json = this.json;
        Object element = this.getObject2();
        json.getSerializersModule();
        return json.encodeToString(((SerializationStrategy) KeyRecord.serviceComponent70.getKSerializer()), element);
    }

    private static boolean isActive() {
        return true;
    }

    private static Unit resolveUnit(JsonBuilder arg0) {
        arg0.setIgnoreUnknownKeys(true);
        arg0.setEncodeDefaults(true);
        return Unit.INSTANCE;
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 21;
        return 0;
    }

}
