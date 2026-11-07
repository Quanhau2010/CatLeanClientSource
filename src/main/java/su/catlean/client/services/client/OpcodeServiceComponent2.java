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
        Map var8 = MapsKt.toMutableMap((Map) JsonElementKt.getJsonObject(element));
        var8.put("nonce", JsonElementKt.JsonPrimitive(UUID.randomUUID().toString()));
        Json var9 = ServiceComponent80.getJson();
        JsonObject var10 = new JsonObject();
        int var11 = 0;
        var9.getSerializersModule();
        var9 = var9.encodeToString((SerializationStrategy) JsonObject.Companion.serializer());
        var9 = var9.getBytes(Charsets.UTF_8);
        var10 = var9;
        var11 = 0;
        ByteBuffer var12 = ByteBuffer.allocate((var10 + -394760223815892984L));
        Object var13 = var12;
        Object var14 = this;
        int var15 = 0;
        var13.putInt(ServiceComponent52.computeValue(opcode.ordinal()));
        var13.putInt(ServiceComponent52.computeValue());
        var13.put();
        var13.flip();
        var14.executeAction();
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
