package su.catlean.client.features.modules.utility.misc;

import su.catlean.api.event.events.network.PlayerListSizeEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;

public class ExtraTabModule extends Module {

    public static final ExtraTabModule INSTANCE;

    private ExtraTabModule() {
        super("extra-tab", SubCategoriesKt.getMiscUtilityCategory());
    }

    private void onPlayerListSizeEvent(PlayerListSizeEvent arg0) {
        arg0.cancel();
    }

    static {
        INSTANCE = new ExtraTabModule();
    }

}
