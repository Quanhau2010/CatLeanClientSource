package su.catlean.client.services.client;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.MapsKt;
import kotlin.text.Charsets;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObject.Companion;
import su.catlean.client.features.modules.Module;
import su.catlean.client.types.OptionMode2;

public abstract class OpcodeServiceComponent2 {

    private static int countValue;

    public OpcodeServiceComponent2() {
    }

    public void executeAction(OptionMode2 opcode, JsonElement element) {
        Map map = MapsKt.toMutableMap(((Map) JsonElementKt.getJsonObject(element)));
        map.put("nonce", JsonElementKt.JsonPrimitive(UUID.randomUUID().toString()));
        Json json = ServiceComponent80.getJson();
        JsonObject element2 = new JsonObject(map);
        json.getSerializersModule();
        json = json.encodeToString(((SerializationStrategy) JsonObject.Companion.serializer()), element2);
        json = json.getBytes(Charsets.UTF_8);
        element2 = json;
        ByteBuffer byteBuffer = ByteBuffer.allocate((element2 + 8));
        byteBuffer.putInt(ServiceComponent52.computeValue(opcode.ordinal()));
        byteBuffer.putInt(ServiceComponent52.computeValue(element2));
        byteBuffer.put(element2);
        byteBuffer.flip();
        this.executeAction(byteBuffer);
    }

    protected void executeAction(ByteBuffer arg0) {
    }

    public void executeAction() {
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 118;
        return 0;
    }

}
