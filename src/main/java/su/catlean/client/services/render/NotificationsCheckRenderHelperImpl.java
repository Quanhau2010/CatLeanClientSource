package su.catlean.client.services.render;

import net.minecraft.client.gui.DrawContext;

public class NotificationsCheckRenderHelperImpl extends CheckRenderHelper {

    public static final NotificationsCheckRenderHelperImpl INSTANCE;

    private NotificationsCheckRenderHelperImpl() {
        super("notifications");
    }

    public void render(DrawContext context) {
    }

    static {
        INSTANCE = new NotificationsCheckRenderHelperImpl();
    }

}
