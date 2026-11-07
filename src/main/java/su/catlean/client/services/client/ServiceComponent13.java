package su.catlean.client.services.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import net.minecraft.class_3675;
import net.minecraft.class_408;
import net.minecraft.client.MinecraftClient;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;

public class ServiceComponent13 {

    private static Module[] moduleArray;

    public static boolean checkCondition(int key) {
        if (RenderSystem.isOnRenderThread() && key != -1) {
            if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ == null) {
                if (SharedKt.getMc().currentScreen instanceof class_408) {
                    return false;
                }
            }
        }
        if (key < 10) {
            return EnabledServiceComponent.INSTANCE.getArrayList3().contains(Integer.valueOf(key));
        }
        return class_3675.method_15987(SharedKt.getMc().method_22683(), key);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
