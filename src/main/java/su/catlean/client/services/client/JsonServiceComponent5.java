package su.catlean.client.services.client;

import java.io.File;
import kotlinx.serialization.json.Json;
import su.catlean.api.contracts.Contract3;

public abstract class JsonServiceComponent5 implements Contract3 {

    private final Json json;
    private static boolean enabledFlag;

    public JsonServiceComponent5(Json json) {
        this.json = json;
    }

    protected Json getJson() {
        return this.json;
    }

    public File getFile() {
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
