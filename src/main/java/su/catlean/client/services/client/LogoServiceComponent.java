package su.catlean.client.services.client;

import su.catlean.api.event.events.render.SplashOverlayEvent;
import su.catlean.client.services.render.MissingnoRenderHelper;
import su.catlean.client.types.TpYawSmootherMode;

public class LogoServiceComponent {

    public static final LogoServiceComponent INSTANCE;
    private static final MissingnoRenderHelper missingnoRenderHelper;
    private static final EasingServiceComponent easingServiceComponent;

    private LogoServiceComponent() {
    }

    private void onSplashOverlayEvent(SplashOverlayEvent arg0) {
    }

    static {
        INSTANCE = new LogoServiceComponent();
        missingnoRenderHelper = new MissingnoRenderHelper(var7[0], var7[1]);
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
    }

}
