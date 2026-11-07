package su.catlean.client.features.modules.utility.misc;

import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;

public class AssistantModule extends Module {

    public static final AssistantModule INSTANCE;

    private AssistantModule() {
        super("assistant", SubCategoriesKt.getMiscUtilityCategory());
    }

    static {
        INSTANCE = new AssistantModule();
    }

}
