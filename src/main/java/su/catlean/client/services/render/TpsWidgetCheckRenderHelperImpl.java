package su.catlean.client.services.render;

import net.minecraft.client.gui.DrawContext;
import su.catlean.client.services.network.TheNetherPacketHelper;

public class TpsWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final TpsWidgetCheckRenderHelperImpl INSTANCE;

    private TpsWidgetCheckRenderHelperImpl() {
        super("tps-widget");
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 106730335067037L);
        long var6 = (0L ^ 116853176505585L);
        long var8 = ((0L ^ 100541977110631L) >>> 32);
        long var10 = (((0L ^ 100541977110631L) << 32) >>> 32);
        if (!(var11)) {
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
