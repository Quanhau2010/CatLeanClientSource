package su.catlean.client.services.client;

import kotlin.enums.EnumEntriesKt;
import net.minecraft.util.math.Direction;

public class ServiceComponent120 {

    private static String textValue;

    static {
        enumEntries = EnumEntriesKt.enumEntries(((Enum[]) Direction.values()));
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
