package su.catlean;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SharedKt {

    private static final Logger logger;
    private static boolean enabledFlag;

    public static MinecraftClient getMc() {
        return MinecraftClient.method_1551();
    }

    public static ClientPlayerEntity getPlayer() {
        return getMc().player;
    }

    public static ClientWorld getWorld() {
        return getMc().world;
    }

    public static ClientPlayerInteractionManager getInteractionManager() {
        return getMc().interactionManager;
    }

    public static ClientPlayNetworkHandler getNetwork() {
        return getMc().method_1562();
    }

    public static long getNumericValue() {
        return System.currentTimeMillis();
    }

    public static Logger getLogger() {
        return logger;
    }

    static {
        logger = LoggerFactory.getLogger("catlean");
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
