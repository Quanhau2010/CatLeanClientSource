package su.catlean.client.features.modules.movement.basic;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class MoveFixModule extends Module {

    public static final MoveFixModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static Module[] moduleArray;

    private MoveFixModule() {
        super("move-fix", SubCategoriesKt.getBasicMovementCategory());
    }

    public MoveFixMode getMode() {
        return ((MoveFixMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new MoveFixModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", MoveFixMode.FREE);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
