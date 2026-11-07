package su.catlean.client.services.render;

import net.minecraft.client.gui.DrawContext;
import su.catlean.client.services.network.TheNetherPacketHelper;

public class PingWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final PingWidgetCheckRenderHelperImpl INSTANCE;

    private PingWidgetCheckRenderHelperImpl() {
        super("ping-widget");
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 116853176505585L);
        long var6 = ((0L ^ 116341584688376L) >>> 16);
        long var8 = (((0L ^ 116341584688376L) << 48) >>> 48);
        this.render(context, (TheNetherPacketHelper.f() + " ms"));
    }

    static {
        INSTANCE = new PingWidgetCheckRenderHelperImpl();
    }

}
