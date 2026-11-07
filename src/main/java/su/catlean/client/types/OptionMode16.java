package su.catlean.client.types;

import net.minecraft.class_124;

public enum OptionMode16 {

    private final class_124 minecraftRef;
    public static final OptionMode16 SUCCESS;
    public static final OptionMode16 INFO;
    public static final OptionMode16 WARNING;
    public static final OptionMode16 ERROR;
    public static final OptionMode16 ENABLED;
    public static final OptionMode16 DISABLED;
    private static String textValue;

    OptionMode16(String arg0, int arg1, class_124 arg2) {
        super(arg0, arg1);
        this.minecraftRef = arg2;
    }

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
