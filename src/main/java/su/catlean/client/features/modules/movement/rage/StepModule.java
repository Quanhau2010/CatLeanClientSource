package su.catlean.client.features.modules.movement.rage;

import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1324;
import net.minecraft.class_2828.class_2829;
import net.minecraft.class_5134;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.network.packet.Packet;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class StepModule extends Module {

    public static final StepModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl2 heightSetting;
    private static final VisibleVisibleSettingPropertyImpl useTimerSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseIfShiftSetting;

    private StepModule() {
        super("step", SubCategoriesKt.getRageMovementCategory());
    }

    private StepMode getMode() {
        return (StepMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setMode(StepMode value) {
        modeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private float getHeight() {
        return (Number) heightSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setHeight(float value) {
        heightSetting.setValue(this, DELEGATED_PROPERTIES[1], Float.valueOf(value));
    }

    private boolean getUseTimer() {
        return (Boolean) useTimerSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setUseTimer(boolean value) {
        useTimerSetting.setValue(this, DELEGATED_PROPERTIES[2], Boolean.valueOf(value));
    }

    private boolean getPauseIfShift() {
        return (Boolean) pauseIfShiftSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setPauseIfShift(boolean value) {
        pauseIfShiftSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    public void updateValue2(long arg0) {
        long var3 = (arg0 ^ 117573222669056L);
        this.executeAction(0.6F);
    }

    public void onPreSyncEvent(PreSyncEvent e) {
        if (this.getMode() == StepMode.NCP_2) {
            return;
        }
        if (this.getPauseIfShift()) {
        }
        if (!(SharedKt.getMc().options.field_1832.method_1434()) && !(SharedKt.getPlayer().method_31549().field_7479) && !(SharedKt.getPlayer().method_3144()) && !(SharedKt.getPlayer().method_5799())) {
            if (SharedKt.getPlayer().isFallFlying()) {
            }
            this.executeAction(0.6F);
            return;
        }
        if (SharedKt.getPlayer().isOnGround()) {
            if (this.getMode() == StepMode.STRICT_NCP) {
            } else {
            }
            1.0F.executeAction(this.getHeight());
        } else {
            this.executeAction(0.6F);
        }
        if (this.getMode() != StepMode.NCP) {
        }
        double var25 = (SharedKt.getPlayer().getY() - SharedKt.getPlayer().field_6036);
        if (this.getMode() != StepMode.STRICT_NCP || var25 <= 0.75D || var25 > this.getHeight()) {
            return;
        }
        double[] var27 = this.process();
        if (this.getUseTimer()) {
            ServiceComponent98.INSTANCE.updateValue2((1.0F / var27));
        }
        int var28 = 0;
        Object var29 = var27;
        if (var28 < var29) {
            Object var30 = var27[var28];
            PacketPacketHelper.handlePacket((Packet) new class_2829(SharedKt.getPlayer().field_6014, (SharedKt.getPlayer().field_6036 + var30), SharedKt.getPlayer().field_5969, 0, SharedKt.getPlayer().field_5976));
        }
        PacketPacketHelper.handlePacket((Packet) new class_2829(SharedKt.getPlayer().field_6014, (SharedKt.getPlayer().field_6036 + var25), SharedKt.getPlayer().field_5969, 0, SharedKt.getPlayer().field_5976));
    }

    private void onMoveEvent(MoveEvent arg0) {
        if (this.getPauseIfShift()) {
        }
        if (SharedKt.getPlayer().isOnGround()) {
            arg0.setY(0.42D);
        } else {
            if (arg0.getY() == -0.1552320045166016D) {
                arg0.setY(0.333D);
            } else {
                arg0.setY(0.25D);
                return;
            }
        }
        arg0.cancel();
    }

    private double[] process(double arg0) {
        Object var9 = new double[2];
        var9[0] = 0.42D;
        var9[1] = 0.753D;
        var9 = new double[2];
        var9[0] = 0.39D;
        var9[1] = 0.7D;
        var9 = new double[6];
        var9[0] = 0.42D;
        var9[1] = 0.75D;
        var9[2] = 1.0D;
        var9[3] = 1.16D;
        var9[4] = 1.23D;
        var9[5] = 1.2D;
        var9 = new double[8];
        var9[0] = 0.42D;
        var9[1] = 0.78D;
        var9[2] = 0.63D;
        var9[3] = 0.51D;
        var9[4] = 0.9D;
        var9[5] = 1.21D;
        var9[6] = 1.45D;
        var9[7] = 1.43D;
        var9 = new double[10];
        var9[0] = 0.425D;
        var9[1] = 0.821D;
        var9[2] = 0.699D;
        var9[3] = 0.599D;
        var9[4] = 1.022D;
        var9[5] = 1.372D;
        var9[6] = 1.652D;
        var9[7] = 1.869D;
        var9[8] = 2.019D;
        var9[9] = 1.907D;
        return null;
    }

    private void executeAction(float arg0) {
        SharedKt.getPlayer().method_5996(class_5134.field_47761).method_6192(arg0);
    }

    private static boolean isActive() {
        return INSTANCE.getMode() != StepMode.NCP_2;
    }

    private static boolean isActive2() {
        return INSTANCE.getMode() != StepMode.NCP_2;
    }

    static {
        KProperty[] var30 = new KProperty[4];
        INSTANCE = new StepModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", StepMode.NCP);
        heightSetting = VisibleRenderHelper.registerSetting(INSTANCE, "height", 2.0F, RangesKt.rangeTo(1.0F, 2.5F), null, this::isActive);
        useTimerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timer", 1, null, this::isActive2);
        pauseIfShiftSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-if-shift");
    }

}
