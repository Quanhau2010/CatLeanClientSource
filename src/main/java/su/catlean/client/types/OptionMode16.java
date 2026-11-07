package su.catlean.client.types;

import net.minecraft.class_124;

public enum OptionMode16 {

    SUCCESS,
    INFO,
    WARNING,
    ERROR,
    ENABLED,
    DISABLED;

    private final class_124 minecraftRef;
    private static String textValue;

    public class_124 getMinecraftObject() {
        return this.minecraftRef;
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
