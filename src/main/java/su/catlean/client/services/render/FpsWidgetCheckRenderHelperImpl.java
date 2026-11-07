package su.catlean.client.services.render;

import net.minecraft.class_315;
import net.minecraft.class_7172;
import net.minecraft.client.gui.DrawContext;
import su.catlean.SharedKt;
import su.catlean.client.services.client.EventServiceComponent;

public class FpsWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final FpsWidgetCheckRenderHelperImpl INSTANCE;
    private static int countValue;

    private FpsWidgetCheckRenderHelperImpl() {
        super("fps-widget");
    }

    public void render(DrawContext context) {
        if (((Boolean) SharedKt.getMc().options.method_42433().method_41753())) {
        } else {
        }
        context.render(countValue, ("v-sync" + "fps"));
    }

    public void updateValue() {
        countValue = EventServiceComponent.INSTANCE.getNumericValue();
    }

    static {
        INSTANCE = new FpsWidgetCheckRenderHelperImpl();
    }

}
