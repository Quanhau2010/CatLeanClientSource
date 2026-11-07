package su.catlean.client.features.modules.movement.rage;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.mappings.LevitationControlModeWhenMappings;

public class LevitationControlModule extends Module {

    public static final LevitationControlModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;

    private LevitationControlModule() {
        super("levitation-control", SubCategoriesKt.getRageMovementCategory());
    }

    private LevitationControlMode getMode() {
        return (LevitationControlMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public void onMoveEvent(MoveEvent e) {
        if (var12 != null) {
        }
        int var13 = SharedKt.getPlayer().method_6112(class_1294.field_5902).method_5578();
        if (var12 != null) {
        }
        if (var12 != null) {
            if (SharedKt.getMc().options.field_1903.method_1434()) {
                e.setY((e.getY() + (((0.05D * (var13 + 1)) - e.getY()) * 0.2D)));
            }
        }
        if (var12 != null) {
            if (SharedKt.getMc().options.field_1832.method_1434()) {
                e.setY(-0.08D);
                e.setX(0.0D);
                e.setZ(0.0D);
            }
        }
        if (var12 != null) {
            if (!(EventPacketHelper2.INSTANCE.checkCondition())) {
            }
            if (EventPacketHelper2.INSTANCE.getNumericValue() > 0.0F) {
            }
            e.setY(0.004D);
            if (var12 == null && var12 == null && var12 == null) {
            }
            e.setY(0.0D);
        }
        e.cancel();
        if (var12 != null) {
            if (SharedKt.getMc().options.field_1903.method_1434()) {
                e.setY(0.1D);
            }
        }
        if (SharedKt.getMc().options.field_1832.method_1434()) {
            e.setY(-0.1D);
            if (var12 == null && var12 == null) {
            }
            e.setY(0.0D);
        }
        e.cancel();
        SharedKt.getPlayer().method_6016(class_1294.field_5902);
    }

    static {
        KProperty[] var22 = new KProperty[1];
        INSTANCE = new LevitationControlModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", LevitationControlMode.NCP);
    }

}
