package su.catlean.client.features.modules.render.cosmetic;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_1306;
import net.minecraft.class_3532;
import net.minecraft.class_7833;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Quaternionfc;
import su.catlean.api.event.events.render.EquipArmEvent;
import su.catlean.api.event.events.render.SwingArmEvent;
import su.catlean.api.event.events.render.SwingDurationEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent34;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.TpYawSmootherMode;

public class SwingAnimationsModule extends Module {

    public static final SwingAnimationsModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl speedSetting;
    private static float factorValue;

    private SwingAnimationsModule() {
        super("swing-animations", SubCategoriesKt.getCosmeticCategory());
    }

    private SwingAnimationsMode getMode() {
        return ((SwingAnimationsMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setMode(SwingAnimationsMode value) {
        modeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private int getSpeed() {
        return ((Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setSpeed(int value) {
        speedSetting.setValue(this, DELEGATED_PROPERTIES[1], Integer.valueOf(value));
    }

    private void onSwingDurationEvent(SwingDurationEvent arg0) {
        arg0.setValue(this.getSpeed());
        arg0.cancel();
    }

    private void onEquipArmEvent(EquipArmEvent arg0) {
        factorValue = arg0.getProgress();
    }

    private void onSwingArmEvent(SwingArmEvent arg0) {
        if (arg0.getArm() != class_1306.field_6183) {
            return;
        }
        arg0.getMatrices().method_46416(-0.56F, (0.52F - (factorValue * -0.6F)), 0.72F);
        arg0.cancel();
        this.render(arg0.getMatrices(), arg0.getArm(), 0.0F);
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        this.render(arg0.getMatrices(), arg0.getArm(), arg0.getSwingProgress());
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        this.render(arg0.getMatrices(), arg0.getArm(), 0.0F);
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        double offset = ((Number) TpYawSmootherMode.OUT_ELASTIC.getFunction1().invoke(Double.valueOf(arg0.getSwingProgress())));
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees((offset * -90.0F))));
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        this.render(arg0.getMatrices(), arg0.getArm(), 0.0F);
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        offset = ((Number) TpYawSmootherMode.OUT_ELASTIC.getFunction1().invoke(Double.valueOf(arg0.getSwingProgress())));
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees((offset * -360.0F))));
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        this.render(arg0.getMatrices(), arg0.getArm(), 0.0F);
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        offset = ((Number) TpYawSmootherMode.OUT_SINE.getFunction1().invoke(Double.valueOf(arg0.getSwingProgress())));
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees((offset * -360.0F))));
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        this.render(arg0.getMatrices(), arg0.getArm(), 0.0F);
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        offset = ((Number) TpYawSmootherMode.OUT_BACK.getFunction1().invoke(Double.valueOf(arg0.getSwingProgress())));
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees((offset * -360.0F))));
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        offset = Math.sin((class_3532.method_15355(arg0.getSwingProgress()) * 3.1415927F));
        this.render(arg0.getMatrices(), arg0.getArm(), 0.0F);
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(50.0F)));
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees(((-30.0F * (1.0F - offset)) - 30.0F))));
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees(110.0F)));
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        offset = Math.sin((class_3532.method_15355(arg0.getSwingProgress()) * 3.1415927F));
        arg0.getMatrices().method_22904(0.0D, 0.0D, 0.0D);
        this.render(arg0.getMatrices(), arg0.getArm(), 0.0F);
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(50.0F)));
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees(((-60.0F * offset) - 50))));
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees(110.0F)));
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        offset = Math.sin((class_3532.method_15355(arg0.getSwingProgress()) * 3.1415927F));
        this.render(arg0.getMatrices(), arg0.getArm(), 0.0F);
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(50.0F)));
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees(-60.0F)));
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees((110.0F + (20.0F * offset)))));
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        offset = Math.sin((class_3532.method_15355(arg0.getSwingProgress()) * 3.1415927F));
        this.render(arg0.getMatrices(), arg0.getArm(), 0.0F);
        arg0.getMatrices().method_22904(0.0D, 0.0D, (offset / 4.0D));
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(-120.0F)));
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        offset = Math.sin((class_3532.method_15355(arg0.getSwingProgress()) * 3.1415927F));
        this.render(arg0.getMatrices(), arg0.getArm(), 0.0F);
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees((Math.sin((arg0.getSwingProgress() * 3.0F)) * 60.0F))));
        arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees((-60.0F * offset))));
        ViewModelModule.INSTANCE.render(arg0.getMatrices());
        if (arg0.getSwingProgress() > 0.0F) {
            offset = Math.sin((class_3532.method_15355(arg0.getSwingProgress()) * 3.1415927F));
            arg0.getMatrices().method_46416(0.56F, ((factorValue * -0.2F) - 0.5F), -0.7F);
            ViewModelModule.INSTANCE.render(arg0.getMatrices());
            arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees(45.0F)));
            arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees((offset * -85.0F))));
            if (ViewModelModule.INSTANCE.getEnabled()) {
                arg0.getMatrices().method_46416((-0.1F * ViewModelModule.INSTANCE.getScale()), (0.28F * ViewModelModule.INSTANCE.getScale()), (0.2F * ViewModelModule.INSTANCE.getScale()));
            } else {
                arg0.getMatrices().method_46416(-0.1F, 0.28F, 0.2F);
            }
            arg0.getMatrices().method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(-85.0F)));
            ViewModelModule.INSTANCE.render(arg0.getMatrices());
        } else {
            offset = (-0.4F * Math.sin((class_3532.method_15355(arg0.getSwingProgress()) * 3.1415927F)));
            float factor = (0.2F * Math.sin((class_3532.method_15355(arg0.getSwingProgress()) * 6.2831855F)));
            float factor2 = (-0.2F * Math.sin((arg0.getSwingProgress() * 3.1415927F)));
            arg0.getMatrices().method_46416(offset, factor, factor2);
            this.render(arg0.getMatrices(), arg0.getArm(), factorValue);
            this.render(arg0.getMatrices(), arg0.getArm(), arg0.getSwingProgress());
        }
    }

    private void render(MatrixStack arg0, class_1306 arg1, float arg2) {
        boolean flag = arg1 == class_1306.field_6183;
        double offset = Math.sin(((arg2 * arg2) * 3.1415927F));
        arg0.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees((flag * (45.0F + (offset * -20.0F))))));
        double offset2 = Math.sin((class_3532.method_15355(arg2) * 3.1415927F));
        arg0.method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees(((flag * offset2) * -20.0F))));
        arg0.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees((offset2 * -80.0F))));
        arg0.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees((flag * -45.0F))));
    }

    private void render(MatrixStack arg0, class_1306 arg1, float arg2) {
        arg0.method_46416((arg1 == class_1306.field_6183 * 0.56F), (-0.52F + (arg2 * -0.6F)), -0.72F);
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new SwingAnimationsModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", SwingAnimationsMode.Default);
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 12, new IntRange(0, 64));
    }

}
