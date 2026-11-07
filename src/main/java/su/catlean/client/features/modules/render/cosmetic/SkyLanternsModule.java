package su.catlean.client.features.modules.render.cosmetic;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_290;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_4604;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.TickEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.ServiceComponent30;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.RenderHelper4;
import su.catlean.client.services.render.TexRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.POSITIONTEXCOLORShaderComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.types.OptionMode6;

public class SkyLanternsModule extends Module {

    public static final SkyLanternsModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl9 fireColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 colorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 colorBottomSetting;
    private static final RangeVisibleSettingPropertyImpl countSetting;
    private static final Color colorValue;
    private static final List itemList;

    private SkyLanternsModule() {
        super("sky-lanterns", SubCategoriesKt.getCosmeticCategory());
    }

    private Color getFireColor() {
        return ((Color) fireColorSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private Color getColor() {
        return ((Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private Color getColorBottom() {
        return ((Color) colorBottomSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private int getCount() {
        return ((Number) countSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    public void updateValue() {
        itemList.clear();
    }

    public void updateValue2() {
        itemList.clear();
    }

    private void onTickEvent(TickEvent arg0) {
        if (!(this.checkCondition()) || SharedKt.getMc().method_1493()) {
            return;
        }
        if (itemList.size() < this.getCount()) {
            this.updateValue();
        }
        Iterator iterator = itemList.iterator();
        while (iterator.hasNext()) {
            ServiceComponent30 serviceComponent30 = ((ServiceComponent30) iterator.next());
            serviceComponent30.updateValue4(serviceComponent30.getNumericValue());
            serviceComponent30.updateValue5(serviceComponent30.getNumericValue2());
            serviceComponent30.updateValue6(serviceComponent30.getNumericValue3());
            serviceComponent30.updateValue7((serviceComponent30.getNumericValue7() + RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(-0.00125F, 0.00125F)), false)));
            serviceComponent30.updateValue8((serviceComponent30.getNumericValue8() + RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(2.0E-4F, 6.0E-4F)), false)));
            serviceComponent30.updateValue9((serviceComponent30.getNumericValue9() + RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(-0.00125F, 0.00125F)), false)));
            serviceComponent30.updateValue7((serviceComponent30.getNumericValue7() * 0.99F));
            serviceComponent30.updateValue8((serviceComponent30.getNumericValue8() * 0.99F));
            serviceComponent30.updateValue9((serviceComponent30.getNumericValue9() * 0.99F));
            serviceComponent30.updateValue((serviceComponent30.getNumericValue() + serviceComponent30.getNumericValue7()));
            serviceComponent30.updateValue2((serviceComponent30.getNumericValue2() + serviceComponent30.getNumericValue8()));
            serviceComponent30.updateValue3((serviceComponent30.getNumericValue3() + serviceComponent30.getNumericValue9()));
            serviceComponent30.updateValue10((serviceComponent30.getNumericValue10() + serviceComponent30.getNumericValue11()));
            double offset = Math.sin((PolygonShaderComponent.INSTANCE.computeValue((serviceComponent30.getNumericValue() - 1.0F), serviceComponent30.getNumericValue()) / 60.0F));
            float factor = (PolygonShaderComponent.INSTANCE.computeValue(serviceComponent30.getNumericValue4(), serviceComponent30.getNumericValue()) + offset);
            float factor2 = PolygonShaderComponent.INSTANCE.computeValue(serviceComponent30.getNumericValue5(), serviceComponent30.getNumericValue2());
            float factor3 = (PolygonShaderComponent.INSTANCE.computeValue(serviceComponent30.getNumericValue6(), serviceComponent30.getNumericValue3()) - offset);
            if ((serviceComponent30.getNumericValue3() - serviceComponent30.getNumericValue()) < 10.0F) {
            } else {
            }
            float factor4 = 1.0F;
            Color color = PolygonShaderComponent.INSTANCE.resolveColor(this.getFireColor(), this.getColor(), 0.5F);
            OptionMode6 optionMode6 = HitFxParticleMode.FIRE_FLY.getOptionMode6();
            Vec3d vec = new Vec3d((factor + ((Random.Default.nextFloat() - 0.5F) * 0.06D)), (factor2 + 0.5D), (factor3 + ((Random.Default.nextFloat() - 0.5F) * 0.06D)));
            float factor5 = (Random.Default.nextFloat() * 20.0F);
            Vec3d vec2 = new Vec3d((((Random.Default.nextDouble() - 0.5D) * 0.02D) + serviceComponent30.getNumericValue7()), ((Random.Default.nextDouble() * 0.06D) + serviceComponent30.getNumericValue8()), (((Random.Default.nextDouble() - 0.5D) * 0.02D) + serviceComponent30.getNumericValue9()));
            Color color2 = PolygonShaderComponent.INSTANCE.resolveColor(this.getFireColor(), (PolygonShaderComponent.INSTANCE.computeValue2(this.getFireColor()) * factor4));
            POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(optionMode6, vec, factor5, 0.25F, 12, vec2, color2, 0.0F, 0.0F, false));
            if (!((serviceComponent30.getNumericValue() % 2))) {
                optionMode6 = HitFxParticleMode.FIRE_FLY.getOptionMode6();
                vec = new Vec3d((factor + RangeServiceComponent.k(((ClosedRange) RangesKt.rangeTo(-0.03D, 0.03D)), false)), (factor2 + 1.0D), (factor3 + RangeServiceComponent.k(((ClosedRange) RangesKt.rangeTo(-0.03D, 0.03D)), false)));
                factor5 = RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(0.0F, 20.0F)), false);
                vec2 = new Vec3d(serviceComponent30.getNumericValue7(), serviceComponent30.getNumericValue8(), serviceComponent30.getNumericValue9());
                color2 = PolygonShaderComponent.INSTANCE.resolveColor(color, (0.5F * factor4));
                POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(optionMode6, vec, factor5, 1.5F, 2, vec2, color2, 0.0F, 0.0F, false));
                optionMode6 = HitFxParticleMode.FIRE_FLY.getOptionMode6();
                vec = new Vec3d((factor + ((Random.Default.nextFloat() - 0.5F) * 0.06D)), (factor2 + 1.0D), (factor3 + ((Random.Default.nextFloat() - 0.5F) * 0.06D)));
                factor5 = RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(0.0F, 20.0F)), false);
                vec2 = new Vec3d(serviceComponent30.getNumericValue7(), serviceComponent30.getNumericValue8(), serviceComponent30.getNumericValue9());
                color2 = PolygonShaderComponent.INSTANCE.resolveColor(color, (0.2F * factor4));
                POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(optionMode6, vec, factor5, 3.0F, 2, vec2, color2, 0.0F, 0.0F, false));
            }
            optionMode6 = serviceComponent30.getNumericValue();
            serviceComponent30.updateValue((optionMode6 + 1));
            if (optionMode6 <= serviceComponent30.getNumericValue3()) {
            }
            iterator.remove();
        }
    }

    private void updateValue() {
        Vec3d vec = this.resolveMinecraftObject(SharedKt.getPlayer()).method_1019(SharedKt.getPlayer().method_18798().method_1021(10.0D));
        itemList.add(new ServiceComponent30((vec.field_1352 + RangeServiceComponent.D(-48.0F, 48.0F, false)), ((vec.field_1351 + 4.0F) + RangeServiceComponent.D(-2.0F, 2.0F, false)), (vec.field_1350 + RangeServiceComponent.D(-48.0F, 48.0F, false)), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F));
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (itemList.isEmpty()) {
            return;
        }
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        int index = 4;
        int index2 = 0;
        int index3 = (9 * itemList.size());
        VertexFormat vertexFormat = class_290.field_1576;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        Iterable iterable = ((Iterable) itemList);
        int index4 = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index5 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ServiceComponent30 serviceComponent30 = ((ServiceComponent30) element);
            if (!(TextShaderComponent2.INSTANCE.getMinecraftObject().method_74404(serviceComponent30.getNumericValue(), (serviceComponent30.getNumericValue2() + 1.5D), serviceComponent30.getNumericValue3()))) {
                if (TextShaderComponent2.INSTANCE.getMinecraftObject().method_74404(serviceComponent30.getNumericValue(), serviceComponent30.getNumericValue2(), serviceComponent30.getNumericValue3())) {
                } else {
                }
            }
            collection.add(element);
        }
        Iterator iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            iterable = ((ServiceComponent30) iterator2.next());
            index4 = RangesKt.coerceAtLeast(PolygonShaderComponent.INSTANCE.computeValue((iterable.getNumericValue() - 1.0F), iterable.getNumericValue()), 0.0F);
            iterable2 = Math.sin((index4 / 60.0F));
            collection = (PolygonShaderComponent.INSTANCE.computeValue(iterable.getNumericValue4(), iterable.getNumericValue()) + iterable2);
            index5 = PolygonShaderComponent.INSTANCE.computeValue(iterable.getNumericValue5(), iterable.getNumericValue2());
            iterator = (PolygonShaderComponent.INSTANCE.computeValue(iterable.getNumericValue6(), iterable.getNumericValue3()) - iterable2);
            arg0.getStack().method_22903();
            arg0.getStack().method_22904((collection - class4184.method_71156().field_1352), (index5 - class4184.method_71156().field_1351), (iterator - class4184.method_71156().field_1350));
            arg0.getStack().method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees(PolygonShaderComponent.INSTANCE.computeValue((iterable.getNumericValue10() - iterable.getNumericValue11()), iterable.getNumericValue10()))));
            this.executeAction(formatRenderHelper, arg0.getStack().method_23760().method_23761(), collection, index5, iterator, PolygonShaderComponent.INSTANCE.computeValue((iterable.getNumericValue10() - iterable.getNumericValue11()), iterable.getNumericValue10()), index4, iterable.getNumericValue3());
            arg0.getStack().method_22909();
        }
        arg0.getStack().method_22903();
        RenderHelper4.render(arg0.getStack(), ((Quaternionfc) class_7833.field_40716.rotation(TextShaderComponent2.INSTANCE.getNumericValue2())));
        RenderHelper4.render(arg0.getStack(), ((Quaternionfc) class_7833.field_40714.rotation(TextShaderComponent2.INSTANCE.getNumericValue3())));
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline23(), null, null, arg0.getStack().method_23760().method_23761());
        arg0.getStack().method_22909();
    }

    private void executeAction(FormatRenderHelper arg0, Matrix4f arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float arg7) {
        float factor = 0.33F;
        float factor2 = 0.2F;
        float factor3 = 0.08F;
        float factor4 = 0.78F;
        float factor5 = 1.3299999F;
        float factor6 = (0.78F + factor2);
        if (0.0F <= arg6) {
        } else {
            if (arg6 <= 10.0F) {
            } else {
                if ((arg7 - arg6) < 10.0F) {
                } else {
                }
            }
        }
        float factor7 = 1.0F;
        Color color = PolygonShaderComponent.INSTANCE.resolveColor(this.getColor(), (PolygonShaderComponent.INSTANCE.computeValue2(this.getColor()) * factor7));
        Color color2 = PolygonShaderComponent.INSTANCE.resolveColor(this.getColorBottom(), (PolygonShaderComponent.INSTANCE.computeValue2(this.getColorBottom()) * factor7));
        Color color3 = PolygonShaderComponent.INSTANCE.resolveColor(colorValue, (PolygonShaderComponent.INSTANCE.computeValue2(colorValue) * factor7));
        arg0.resolveFormatRenderHelper(arg1, factor, factor4, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor5, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor5, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor4, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, (factor + factor3), (factor4 - factor2), (factor + factor3)).resolveFormatRenderHelper(color2);
        arg0.resolveFormatRenderHelper(arg1, factor, (factor6 - factor2), factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, (factor6 - factor2), factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, (factor - factor3), (factor4 - factor2), (factor + factor3)).resolveFormatRenderHelper(color2);
        arg0.resolveFormatRenderHelper(arg1, factor, factor4, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor5, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor5, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor4, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, (factor + factor3), (factor4 - factor2), (factor - factor3)).resolveFormatRenderHelper(color2);
        arg0.resolveFormatRenderHelper(arg1, factor, (factor6 - factor2), factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, (factor6 - factor2), factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, (factor - factor3), (factor4 - factor2), (factor - factor3)).resolveFormatRenderHelper(color2);
        arg0.resolveFormatRenderHelper(arg1, factor, factor4, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor5, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor5, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor4, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, (factor + factor3), (factor4 - factor2), (factor + factor3)).resolveFormatRenderHelper(color2);
        arg0.resolveFormatRenderHelper(arg1, factor, (factor6 - factor2), factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, (factor6 - factor2), factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, (factor + factor3), (factor4 - factor2), (factor - factor3)).resolveFormatRenderHelper(color2);
        arg0.resolveFormatRenderHelper(arg1, factor, factor4, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor5, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor5, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor4, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, (factor - factor3), (factor4 - factor2), (factor + factor3)).resolveFormatRenderHelper(color2);
        arg0.resolveFormatRenderHelper(arg1, factor, (factor6 - factor2), factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, (factor6 - factor2), factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, (factor - factor3), (factor4 - factor2), (factor - factor3)).resolveFormatRenderHelper(color2);
        arg0.resolveFormatRenderHelper(arg1, factor, factor5, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor5, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor5, factor).resolveFormatRenderHelper(color);
        arg0.resolveFormatRenderHelper(arg1, factor, factor5, factor).resolveFormatRenderHelper(color);
        double offset = Math.toRadians(arg5);
        Vec3d vec = this.resolveMinecraftObject(((arg2 - factor) + factor3), (arg3 + 0.58F), ((arg4 + factor3) - factor), arg2, (arg3 + 0.58F), arg4, offset);
        Vec3d vec2 = this.resolveMinecraftObject(((arg2 + factor) - factor3), (arg3 + 0.58F), ((arg4 + factor3) - factor), arg2, (arg3 + 0.58F), arg4, offset);
        Vec3d vec3 = this.resolveMinecraftObject(((arg2 - factor) + factor3), (arg3 + 0.58F), ((arg4 - factor3) + factor), arg2, (arg3 + 0.58F), arg4, offset);
        Vec3d vec4 = this.resolveMinecraftObject(((arg2 + factor) - factor3), (arg3 + 0.58F), ((arg4 - factor3) + factor), arg2, (arg3 + 0.58F), arg4, offset);
        Vec3d vec5 = this.resolveMinecraftObject(((arg2 - factor) + factor3), (arg3 + 0.58F), arg4, arg2, (arg3 + 0.58F), arg4, offset);
        Vec3d vec6 = this.resolveMinecraftObject(((arg2 + factor) - factor3), (arg3 + 0.58F), arg4, arg2, (arg3 + 0.58F), arg4, offset);
        Vec3d vec7 = this.resolveMinecraftObject(arg2, (arg3 + 0.58F), ((arg4 + factor3) - factor), arg2, (arg3 + 0.58F), arg4, offset);
        Vec3d vec8 = this.resolveMinecraftObject(arg2, (arg3 + 0.58F), ((arg4 - factor3) + factor), arg2, (arg3 + 0.58F), arg4, offset);
        TextShaderComponent2.checkCondition(vec, vec2, color3);
        TextShaderComponent2.checkCondition(vec3, vec4, color3);
        TextShaderComponent2.checkCondition(vec5, vec6, color3);
        TextShaderComponent2.checkCondition(vec2, vec4, color3);
        TextShaderComponent2.checkCondition(vec, vec3, color3);
        TextShaderComponent2.checkCondition(vec7, vec8, color3);
    }

    private Vec3d resolveMinecraftObject(float arg0, float arg1, float arg2, float arg3, float arg4, float arg5, double arg6) {
        double offset = Math.sin(arg6);
        double offset2 = Math.cos(arg6);
        float factor = (arg0 - arg3);
        float factor2 = (arg2 - arg5);
        float factor3 = (arg1 - arg4);
        float factor4 = ((factor * offset2) + (factor2 * offset));
        float factor5 = ((factor * offset) + (factor2 * offset2));
        return new Vec3d((arg3 + factor4), (arg4 + factor3), (arg5 + factor5));
    }

    static {
        KProperty[] items = new KProperty[4];
        INSTANCE = new SkyLanternsModule();
        fireColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire-color", Color.YELLOW);
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color", PolygonShaderComponent.INSTANCE.resolveColor(Color.YELLOW, 0.2F));
        colorBottomSetting = VisibleRenderHelper.registerSetting(INSTANCE, "bottom-color", PolygonShaderComponent.INSTANCE.resolveColor(Color.ORANGE, 0.2F));
        countSetting = VisibleRenderHelper.registerSetting(INSTANCE, "count", 256, new IntRange(0, 512));
        colorValue = new Color(70, 70, 70);
        itemList = new ArrayList();
    }

}
