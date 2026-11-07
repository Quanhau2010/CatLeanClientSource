package su.catlean.client.features.modules.movement.rage;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.SprintEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.render.VisibleRenderHelper;

public class WaterSpeedModule extends Module {

    public static final WaterSpeedModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl2 speedSetting;

    private WaterSpeedModule() {
        super("water-speed", SubCategoriesKt.getRageMovementCategory());
    }

    private WaterSpeedMode getMode() {
        return ((WaterSpeedMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private float getSpeed() {
        return ((Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    public void updateValue2() {
        SharedKt.getPlayer().method_6016(class_1294.field_5900);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getPlayer().method_5681()) {
        } else {
        }
        SharedKt.getPlayer().method_6016(class_1294.field_5900);
    }

    private void onMoveEvent(MoveEvent arg0) {
        this.executeAction(EventPacketHelper2.INSTANCE, arg0, this.getSpeed());
        arg0.cancel();
    }

    private void onSprintEvent(SprintEvent arg0) {
        if (!(SharedKt.getPlayer().method_5799())) {
        }
        arg0.setSprinting(true);
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new WaterSpeedModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", WaterSpeedMode.DolphinGrace);
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 2.0F, RangesKt.rangeTo(1.0F, 10.0F));
    }

}
