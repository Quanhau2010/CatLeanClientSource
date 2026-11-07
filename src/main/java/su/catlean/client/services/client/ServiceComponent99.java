package su.catlean.client.services.client;

import su.catlean.api.IPasteable;
import su.catlean.client.features.modules.Module;

public class ServiceComponent99 {

    private static String textValue;

    public static void executeAction(IPasteable receiver) {
        Runtime.getRuntime().addShutdownHook(((Thread) new ServiceComponent61()));
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
