package su.catlean.client.services.render;

import net.minecraft.client.gui.DrawContext;

public abstract class RenderHelper2 {

    private static String textValue;

    public RenderHelper2() {
    }

    public void render(DrawContext arg0, float arg1, float arg2, float arg3, float arg4) {
    }

    public boolean checkCondition(float arg0, float arg1) {
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
