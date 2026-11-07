package su.catlean.client.features.modules.render.cosmetic;

import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import su.catlean.api.event.events.render.BasicProjectionMatrixEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AspectModule extends Module {

    public static final AspectModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl2 ratioSetting;

    private AspectModule() {
        super("aspect", SubCategoriesKt.getCosmeticCategory());
    }

    public float getRatio() {
        if ((Number) ratioSetting.getValue(this, DELEGATED_PROPERTIES[0]) != null) {
        }
        return null;
    }

    public void setRatio(float value) {
        ratioSetting.setValue(this, DELEGATED_PROPERTIES[0], Float.valueOf(value));
    }

    private void onBasicProjectionMatrixEvent(BasicProjectionMatrixEvent arg0) {
        arg0.setRatio(this.getRatio());
        arg0.cancel();
    }

    static {
        KProperty[] var22 = new KProperty[1];
        INSTANCE = new AspectModule();
        ratioSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ratio", 1.0F, RangesKt.rangeTo(0.1F, 10.0F));
    }

}
