package su.catlean.client.features.modules.utility.misc;

import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;

public class RPCModule extends Module {

    public static final RPCModule INSTANCE;

    private RPCModule() {
        super("RPC", SubCategoriesKt.getMiscUtilityCategory());
    }

    static {
        INSTANCE = new RPCModule();
    }

}
