package su.catlean.client.features.modules.utility.misc;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class UIModule extends Module {

    public static final UIModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 moduleModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 moduleTextSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 linesModeSetting;
    private static int countValue;

    private UIModule() {
        super("UI", SubCategoriesKt.getMiscUtilityCategory());
    }

    public UIModuleMode getModuleMode() {
        return (UIModuleMode) moduleModeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public UIModuleTextMode getModuleText() {
        if ((UIModuleTextMode) moduleTextSetting.getValue(this, DELEGATED_PROPERTIES[1]) != null) {
        }
        return null;
    }

    public UILinesMode getLinesMode() {
        if (var8) {
        }
        return (UILinesMode) linesModeSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    static {
        KProperty[] var28 = new KProperty[3];
        INSTANCE = new UIModule();
        moduleModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "module-mode", UIModuleMode.DEFAULT, null, null, -4536637048387272692L);
        moduleTextSetting = VisibleRenderHelper.registerSetting(INSTANCE, "module-text", UIModuleTextMode.CENTER, null, null, 1350166967142580236L);
        linesModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "lines-mode", UILinesMode.NEW, null, null, 1350166967142580236L);
        INSTANCE.getBind().updateValue(-630024706791047088L);
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 56;
        return 0;
    }

}
