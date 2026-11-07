package su.catlean.client.services.render;

import net.minecraft.client.gui.DrawContext;
import su.catlean.client.services.network.TheNetherPacketHelper;

public class PingWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final PingWidgetCheckRenderHelperImpl INSTANCE;

    private PingWidgetCheckRenderHelperImpl() {
        super("ping-widget");
    }

    public void render(DrawContext context) {
        this.render(context, (TheNetherPacketHelper.f() + " ms"));
    }

    static {
        INSTANCE = new PingWidgetCheckRenderHelperImpl();
    }

}
