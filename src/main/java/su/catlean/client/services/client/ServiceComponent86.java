package su.catlean.client.services.client;

import net.minecraft.class_2561;

public class ServiceComponent86 {

    private static int[] countValueArray;

    public static String resolveString(class_2561 receiver) {
        return StyleServiceComponent.INSTANCE.resolveString(receiver);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
