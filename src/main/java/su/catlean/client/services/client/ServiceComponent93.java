package su.catlean.client.services.client;

import net.minecraft.class_2824;
import su.catlean.client.features.modules.Module;
import su.catlean.mixins.accessors.ServerboundInteractPacketAccessor;

public class ServiceComponent93 {

    private static Module[] moduleArray;

    public static void executeAction(class_2824 receiver, int id) {
        ((ServerboundInteractPacketAccessor) receiver).setEntityId(id);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
