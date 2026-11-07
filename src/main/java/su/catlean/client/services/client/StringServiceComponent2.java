package su.catlean.client.services.client;

import net.minecraft.class_2960;
import su.catlean.client.features.modules.Module;

public class StringServiceComponent2 {

    private static Module[] moduleArray;

    public static class_2960 resolveMinecraftObject(String string) {
        return class_2960.method_60654(string);
    }

    public static class_2960 resolveMinecraftObject(String id, String string) {
        return class_2960.method_60655(id, string);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
