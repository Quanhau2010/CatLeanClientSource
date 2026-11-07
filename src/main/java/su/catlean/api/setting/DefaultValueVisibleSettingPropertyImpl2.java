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
        super(id, defaultValue, null, null, visible, 7831325809976541196L);
        this.json = JsonKt.Json$default(null, this::resolveUnit);
    }

    public void setValue(String setting) {
        Json var4 = this.json;
        Object var5 = setting;
        int var6 = 0;
        var4.getSerializersModule();
        this.updateValue(var4.decodeFromString((DeserializationStrategy) KeyRecord.serviceComponent70.getKSerializer()));
    }

    public String toString() {
        Json var1 = this.json;
        Object var2 = this.getObject2();
        int var3 = 0;
        var1.getSerializersModule();
        return var1.encodeToString((SerializationStrategy) KeyRecord.serviceComponent70.getKSerializer());
    }

    private static boolean isActive() {
        return true;
    }

    private static Unit resolveUnit(JsonBuilder arg0) {
        arg0.setIgnoreUnknownKeys(1);
        arg0.setEncodeDefaults(1);
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
