package su.catlean.client.features.modules.render.cosmetic;

import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_315;
import net.minecraft.class_5498;
import su.catlean.SharedKt;
import su.catlean.api.event.events.render.CameraOffsetEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.TpYawSmootherMode;

public class NoCameraClipModule extends Module {

    public static final NoCameraClipModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl2 distanceSetting;
    private static EasingServiceComponent easingServiceComponent;
    private static class_5498 minecraftRef;

    private NoCameraClipModule() {
        super("no-camera-clip", SubCategoriesKt.getCosmeticCategory());
    }

    private float getDistance() {
        return (Number) distanceSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setDistance(float value) {
        distanceSetting.setValue(this, DELEGATED_PROPERTIES[0], Float.valueOf(value));
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (minecraftRef != SharedKt.getMc().options.method_31044()) {
            easingServiceComponent.updateValue2(0.0F);
            minecraftRef = SharedKt.getMc().options.method_31044();
        }
        easingServiceComponent.executeAction(1.0F);
    }

    private void onCameraOffsetEvent(CameraOffsetEvent arg0) {
        arg0.setOffset((1.0F + ((this.getDistance() - 1.0F) * easingServiceComponent.getNumericValue())));
        arg0.cancel();
    }

    static {
        KProperty[] var32 = new KProperty[1];
        INSTANCE = new NoCameraClipModule();
        distanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "distance", 3.0F, RangesKt.rangeTo(1.0F, 20.0F));
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        minecraftRef = class_5498.field_26664;
    }

}
