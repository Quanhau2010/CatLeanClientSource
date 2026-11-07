package su.catlean;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import su.catlean.api.IPasteable;
import su.catlean.api.event.events.client.InitEvent;
import su.catlean.api.event.events.client.PostTitleScreenInitEvent;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.ServiceComponent68;
import su.catlean.client.services.client.ServiceComponent99;
import su.catlean.client.services.client.SfMediumServiceComponent;
import su.catlean.client.services.client.VersionServiceComponent;
import su.catlean.client.ui.clickgui.WarningGuiElement;

public class CatLean implements IPasteable {

    public static final CatLean INSTANCE;

    private CatLean() {
    }

    public void onInitializeClient() {
        ServiceComponent99.executeAction(((IPasteable) this));
        ServiceComponent68.executeAction(((IPasteable) this));
    }

    private void onInitEvent(InitEvent arg0) {
        PreLaunch.INSTANCE.executeAction();
        SfMediumServiceComponent.executeAction(((IPasteable) this));
        KeyServiceComponent.INSTANCE.executeAction();
        System.setProperty("java.version", ("CatVM " + System.getProperty("java.version")));
    }

    private void onPostTitleScreenInitEvent(PostTitleScreenInitEvent arg0) {
        SharedKt.getMc().method_1507(((Screen) new WarningGuiElement()));
    }

    static {
        INSTANCE = new CatLean();
    }

}
