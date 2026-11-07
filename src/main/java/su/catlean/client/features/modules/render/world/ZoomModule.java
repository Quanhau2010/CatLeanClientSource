package su.catlean.client.features.modules.render.world;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import su.catlean.SharedKt;
import su.catlean.api.event.events.render.BasicProjectionMatrixEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.TpYawSmootherMode;

public class ZoomModule extends Module {

    public static final ZoomModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl2 teleBindSetting;
    private static final RangeVisibleSettingPropertyImpl2 teleScaleSetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 wideBindSetting;
    private static final RangeVisibleSettingPropertyImpl2 wideScaleSetting;
    private static final EasingServiceComponent easingServiceComponent;

    private ZoomModule() {
        super("zoom", SubCategoriesKt.getWorldRenderCategory());
    }

    private KeyRecord getTeleBind() {
        return (KeyRecord) teleBindSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private float getTeleScale() {
        return (Number) teleScaleSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private KeyRecord getWideBind() {
        return (KeyRecord) wideBindSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private float getWideScale() {
        return (Number) wideScaleSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void onBasicProjectionMatrixEvent(BasicProjectionMatrixEvent arg0) {
        if (ServiceComponent13.checkCondition(this.getTeleBind().getNumericValue())) {
        } else {
            if (ServiceComponent13.checkCondition(this.getWideBind().getNumericValue())) {
            } else {
            }
        }
        this.getWideScale().executeAction(1.0F);
        if (!(ServiceComponent13.checkCondition(this.getWideBind().getNumericValue())) && !(ServiceComponent13.checkCondition(this.getTeleBind().getNumericValue()))) {
        }
        arg0.setFov((arg0.getFov() / easingServiceComponent.getNumericValue()));
        arg0.setRatio((SharedKt.getMc().method_22683().method_4489() / SharedKt.getMc().method_22683().method_4506()));
        arg0.cancel();
    }

    static {
        KProperty[] var40 = new KProperty[4];
        INSTANCE = new ZoomModule();
        teleBindSetting = VisibleRenderHelper.registerSetting(INSTANCE, "telephoto", new KeyRecord(0, 0, 0, var7[3]), null, null, var7[0]);
        teleScaleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crop", 8.0F, RangesKt.rangeTo(1.0F, 25.0F), null, null, var7[1]);
        wideBindSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ultra-wide", new KeyRecord(0, 0, 0, var7[2]), null, null, var7[4]);
        wideScaleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "reversed-crop", 0.75F, RangesKt.rangeTo(0.1F, 1.0F), null, null, var7[5]);
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
    }

}
