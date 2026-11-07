package su.catlean.client.features.modules.movement.basic;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.client.network.ClientPlayerEntity;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.TickEvent;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.render.VisibleRenderHelper;

public class SprintModule extends Module {

    public static final SprintModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl pauseInWaterSetting;
    private static boolean enabledFlag;

    private SprintModule() {
        super("sprint", SubCategoriesKt.getBasicMovementCategory());
    }

    private boolean getPauseInWater() {
        return ((Boolean) pauseInWaterSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    private void onTickEvent(TickEvent arg0) {
        if (!(this.checkCondition())) {
            return;
        }
        if (enabledFlag) {
            enabledFlag = 0;
            return;
        }
        if (this.getPauseInWater()) {
        }
        SharedKt.getPlayer().method_5728(true);
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new SprintModule();
        pauseInWaterSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-in-water", false);
    }

}
