package su.catlean.client.services.render;

import net.minecraft.client.gui.DrawContext;
import su.catlean.client.services.network.TheNetherPacketHelper;

public class TpsWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final TpsWidgetCheckRenderHelperImpl INSTANCE;

    private TpsWidgetCheckRenderHelperImpl() {
        super("tps-widget");
    }

    public void render(DrawContext context) {
        if (!(__UNDEF_KEY__)) {
            if (TheNetherPacketHelper.INSTANCE.checkCondition2()) {
            } else {
            }
        }
        context.render(TheNetherPacketHelper.INSTANCE.computeValue(), ("--.--" + " (" + Float.valueOf(TheNetherPacketHelper.INSTANCE.getNumericValue()) + ") t/s"));
    }

    static {
        INSTANCE = new TpsWidgetCheckRenderHelperImpl();
    }

}
