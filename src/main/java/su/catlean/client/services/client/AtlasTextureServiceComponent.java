package su.catlean.client.services.client;

import net.minecraft.class_2960;

public class AtlasTextureServiceComponent {

    private static final class_2960 minecraftRef;
    private static String textValue;

    public static class_2960 getMinecraftObject() {
        return minecraftRef;
    }

    static {
        minecraftRef = StringServiceComponent2.resolveMinecraftObject("catlean", "textures/atlas.png");
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
