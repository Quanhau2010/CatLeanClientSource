package su.catlean.client.features.modules.movement.rage;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class TimerModule extends Module {

    public static final TimerModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl2 valueSetting;
    private static final VisibleVisibleSettingPropertyImpl timeOutSetting;
    private static final RangeVisibleSettingPropertyImpl timeOutValueSetting;
    private static final ServiceComponent10 serviceComponent10;

    private TimerModule() {
        super("timer", SubCategoriesKt.getRageMovementCategory());
    }

    public float getValue() {
        return ((Number) valueSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public boolean getTimeOut() {
        if (((Boolean) timeOutSetting.getValue(this, DELEGATED_PROPERTIES[1])) != null) {
        }
        return null;
    }

    public int getTimeOutValue() {
        return ((Number) timeOutValueSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    public ServiceComponent10 getServiceComponent10() {
        return serviceComponent10;
    }

    public void updateValue() {
        serviceComponent10.executeAction();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        ServiceComponent98.INSTANCE.updateValue2(this.getValue());
        this.updateValue2();
    }

    private static boolean isActive() {
        return INSTANCE.getTimeOut();
    }

    static {
        KProperty[] items = new KProperty[3];
        INSTANCE = new TimerModule();
        valueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "value", 1.0F, RangesKt.rangeTo(0.1F, 10.0F));
        timeOutSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timeout", false);
        timeOutValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timeout-value", 1, new IntRange(1, 10000), null, this::isActive);
        serviceComponent10 = new ServiceComponent10();
    }

}
