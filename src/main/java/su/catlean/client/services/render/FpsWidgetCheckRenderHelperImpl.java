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
        long var4 = (0L ^ 73719739740194L);
        long var6 = (0L ^ 116853176505585L);
        if ((Boolean) SharedKt.getMc().options.method_42433().method_41753()) {
        } else {
        }
        context.render(countValue, ("v-sync" + "fps"));
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 38798774274332L);
        countValue = EventServiceComponent.INSTANCE.getNumericValue();
    }

    static {
        INSTANCE = new FpsWidgetCheckRenderHelperImpl();
    }

}
