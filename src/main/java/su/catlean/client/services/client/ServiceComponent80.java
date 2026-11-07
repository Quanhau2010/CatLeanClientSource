package su.catlean.client.services.client;

import kotlin.Unit;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.JsonNamingStrategy.Builtins;

public class ServiceComponent80 {

    private static final Json json;
    private static int[] countValueArray;

    public static Json getJson() {
        return json;
    }

    public static void executeAction() {
    }

    private static Unit resolveUnit(JsonBuilder arg0) {
        arg0.setIgnoreUnknownKeys(true);
        arg0.setExplicitNulls(false);
        arg0.setNamingStrategy(JsonNamingStrategy.Builtins.getSnakeCase());
        return Unit.INSTANCE;
    }

    static {
        json = JsonKt.Json$default(null, this::resolveUnit);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
