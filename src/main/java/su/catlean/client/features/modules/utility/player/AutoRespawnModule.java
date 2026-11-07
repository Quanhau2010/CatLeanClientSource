package su.catlean.client.features.modules.utility.player;

import java.util.concurrent.ExecutorService;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_2663;
import net.minecraft.class_418;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.world.World;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.SettingIdVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent;
import su.catlean.client.services.client.ServiceComponent57;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.mappings.AutoRespawnDeathCommandModeWhenMappings;

public class AutoRespawnModule extends Module {

    public static final AutoRespawnModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl deathCoordsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 deathCommandSetting;
    private static final SettingIdVisibleSettingPropertyImpl kitSetting;
    private static final SettingIdVisibleSettingPropertyImpl commandSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 commandTimingSetting;
    private static boolean enabledFlag;
    private static int countValue;

    private AutoRespawnModule() {
        super("auto-respawn", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private boolean getDeathCoords() {
        return ((Boolean) deathCoordsSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private AutoRespawnDeathCommandMode getDeathCommand() {
        return ((AutoRespawnDeathCommandMode) deathCommandSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private String getKit() {
        return ((String) kitSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private String getCommand() {
        return ((String) commandSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private AutoRespawnCommandTimingMode getCommandTiming() {
        return ((AutoRespawnCommandTimingMode) commandTimingSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getMc().currentScreen instanceof class_418) {
            countValue = (countValue + 1);
            if (this.getDeathCoords()) {
                MessageServiceComponent.S(null, (this + MessageServiceComponent.Z(this, "respawn-message", new Object[0], false) + SharedKt.getPlayer().getX() + " Z: " + SharedKt.getPlayer().getZ()), false);
            }
            SharedKt.getPlayer().method_7331();
            SharedKt.getMc().method_1507(null);
            if (this.getCommandTiming() == AutoRespawnCommandTimingMode.DELAYED) {
                RunnableServiceComponent runnableServiceComponent = RunnableServiceComponent.INSTANCE;
                int index = 1000;
                runnableServiceComponent.getExecutorService().execute(((Runnable) new ServiceComponent57(index)));
            }
            enabledFlag = 0;
        } else {
            enabledFlag = 1;
        }
    }

    private void onReceivePacket(ReceivePacket arg0) {
        class_2663 class2663 = ((class_2663) arg0.getPacket());
        if (class2663.method_11470() != 3) {
        }
        this.updateValue();
    }

    public void updateValue() {
        PacketPacketHelper.executeAction(("kit " + this.getKit()));
        PacketPacketHelper.executeAction("back");
        PacketPacketHelper.executeAction("home");
        PacketPacketHelper.executeAction(this.getCommand());
    }

    private static boolean isActive() {
        return INSTANCE.getDeathCommand() == AutoRespawnDeathCommandMode.KIT;
    }

    private static boolean isActive2() {
        return INSTANCE.getDeathCommand() == AutoRespawnDeathCommandMode.CUSTOM;
    }

    static {
        KProperty[] items = new KProperty[5];
        INSTANCE = new AutoRespawnModule();
        deathCoordsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "death-coords", true);
        deathCommandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "death-command", AutoRespawnDeathCommandMode.KIT);
        kitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "kit-name", "kitname", null, this::isActive);
        commandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "command", "/ebal", null, this::isActive2);
        commandTimingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "command-timing", AutoRespawnCommandTimingMode.DELAYED);
    }

}
