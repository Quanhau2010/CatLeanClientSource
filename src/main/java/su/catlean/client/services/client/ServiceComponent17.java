package su.catlean.client.services.client;

import kotlin.Unit;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

public class ServiceComponent17 {

    private static final Json json;

    public static Json getJson() {
        return json;
    }

    private static Unit resolveUnit(JsonBuilder arg0) {
        arg0.setIgnoreUnknownKeys(true);
        arg0.setLenient(true);
        return Unit.INSTANCE;
    }

    static {
        json = JsonKt.Json$default(null, this::resolveUnit);
    }

}
