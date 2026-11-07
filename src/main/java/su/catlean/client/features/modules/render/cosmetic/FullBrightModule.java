package su.catlean.client.features.modules.render.cosmetic;

import su.catlean.api.event.events.render.LightMapUpdateEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;

public class FullBrightModule extends Module {

    public static final FullBrightModule INSTANCE;

    private FullBrightModule() {
        super("full-bright", SubCategoriesKt.getCosmeticCategory());
    }

    private void onLightMapUpdateEvent(LightMapUpdateEvent arg0) {
        arg0.cancel();
    }

    static {
        INSTANCE = new FullBrightModule();
    }

}
