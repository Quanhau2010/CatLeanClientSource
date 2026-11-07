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
        return (Color) fireColorSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private Color getColor() {
        return (Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private Color getColorBottom() {
        return (Color) colorBottomSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private int getCount() {
        return (Number) countSetting.getValue(this, DELEGATED_PROPERTIES[3]);
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
            ServiceComponent30 var36 = (ServiceComponent30) iterator.next();
            var36.updateValue4(var36.getNumericValue());
            var36.updateValue5(var36.getNumericValue2());
            var36.updateValue6(var36.getNumericValue3());
            var36.updateValue7((var36.getNumericValue7() + RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(-0.00125F, 0.00125F))));
            var36.updateValue8((var36.getNumericValue8() + RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(2.0E-4F, 6.0E-4F))));
            var36.updateValue9((var36.getNumericValue9() + RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(-0.00125F, 0.00125F))));
            var36.updateValue7((var36.getNumericValue7() * 0.99F));
            var36.updateValue8((var36.getNumericValue8() * 0.99F));
            var36.updateValue9((var36.getNumericValue9() * 0.99F));
            var36.updateValue((var36.getNumericValue() + var36.getNumericValue7()));
            var36.updateValue2((var36.getNumericValue2() + var36.getNumericValue8()));
            var36.updateValue3((var36.getNumericValue3() + var36.getNumericValue9()));
            var36.updateValue10((var36.getNumericValue10() + var36.getNumericValue11()));
            double var37 = Math.sin((PolygonShaderComponent.INSTANCE.computeValue((var36.getNumericValue() - 1.0F), var36.getNumericValue()) / 60.0F));
            float var38 = (PolygonShaderComponent.INSTANCE.computeValue(var36.getNumericValue4(), var36.getNumericValue()) + var37);
            float var39 = PolygonShaderComponent.INSTANCE.computeValue(var36.getNumericValue5(), var36.getNumericValue2());
            float var40 = (PolygonShaderComponent.INSTANCE.computeValue(var36.getNumericValue6(), var36.getNumericValue3()) - var37);
            if ((var36.getNumericValue3() - var36.getNumericValue()) < 10.0F) {
            } else {
            }
            float var41 = 1.0F;
            Color var42 = PolygonShaderComponent.INSTANCE.resolveColor(this.getFireColor(), this.getColor(), 0.5F);
            OptionMode6 var43 = HitFxParticleMode.FIRE_FLY.getOptionMode6();
            Vec3d vec = new Vec3d((var38 + ((Random.Default.nextFloat() - 0.5F) * 0.06D)), (var39 + 0.5D), (var40 + ((Random.Default.nextFloat() - 0.5F) * 0.06D)));
            float var45 = (Random.Default.nextFloat() * 20.0F);
            Vec3d vec2 = new Vec3d((((Random.Default.nextDouble() - 0.5D) * 0.02D) + var36.getNumericValue7()), ((Random.Default.nextDouble() * 0.06D) + var36.getNumericValue8()), (((Random.Default.nextDouble() - 0.5D) * 0.02D) + var36.getNumericValue9()));
            Color var47 = PolygonShaderComponent.INSTANCE.resolveColor(this.getFireColor(), (PolygonShaderComponent.INSTANCE.computeValue2(this.getFireColor()) * var41));
            POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(vec, 0.25F, 12, vec2, 0.0F, 0.0F));
            if (!((var36.getNumericValue() % 2))) {
                var43 = HitFxParticleMode.FIRE_FLY.getOptionMode6();
                vec = new Vec3d((var38 + RangeServiceComponent.k((ClosedRange) RangesKt.rangeTo(-0.03D, 0.03D))), (var39 + 1.0D), (var40 + RangeServiceComponent.k((ClosedRange) RangesKt.rangeTo(-0.03D, 0.03D))));
                var45 = RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(0.0F, 20.0F));
                vec2 = new Vec3d(var36.getNumericValue7(), var36.getNumericValue8(), var36.getNumericValue9());
                var47 = PolygonShaderComponent.INSTANCE.resolveColor((0.5F * var41));
                POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(vec, 1.5F, 2, vec2, 0.0F, 0.0F));
                var43 = HitFxParticleMode.FIRE_FLY.getOptionMode6();
                vec = new Vec3d((var38 + ((Random.Default.nextFloat() - 0.5F) * 0.06D)), (var39 + 1.0D), (var40 + ((Random.Default.nextFloat() - 0.5F) * 0.06D)));
                var45 = RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(0.0F, 20.0F));
                vec2 = new Vec3d(var36.getNumericValue7(), var36.getNumericValue8(), var36.getNumericValue9());
                var47 = PolygonShaderComponent.INSTANCE.resolveColor((0.2F * var41));
                POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(vec, 3.0F, 2, vec2, 0.0F, 0.0F));
            }
            var43 = var36.getNumericValue();
            var36.updateValue((var43 + 1));
            if (var43 <= var36.getNumericValue3()) {
            }
            iterator.remove();
        }
    }

    private void updateValue() {
        Vec3d vec = this.resolveMinecraftObject(SharedKt.getPlayer()).method_1019(SharedKt.getPlayer().method_18798().method_1021(10.0D));
        itemList.add(new ServiceComponent30((vec.field_1352 + RangeServiceComponent.D(-48.0F, 48.0F)), ((vec.field_1351 + 4.0F) + RangeServiceComponent.D(-2.0F, 2.0F)), (vec.field_1350 + RangeServiceComponent.D(-48.0F, 48.0F)), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F));
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (itemList.isEmpty()) {
            return;
        }
        class_4184 var22 = SharedKt.getMc().field_1773.method_19418();
        int var17 = 4;
        int var18 = 0;
        int var19 = (9 * itemList.size());
        VertexFormat var20 = class_290.field_1576;
        FormatRenderHelper var23 = new FormatRenderHelper();
        Iterable var25 = (Iterable) itemList;
        int var26 = 0;
        Object var27 = var25;
        Collection var28 = (Collection) new ArrayList();
        int var29 = 0;
        Iterator iterator = var27.iterator();
        while (iterator.hasNext()) {
            Object var31 = iterator.next();
            ServiceComponent30 var32 = (ServiceComponent30) var31;
            int var33 = 0;
            if (!(TextShaderComponent2.INSTANCE.getMinecraftObject().method_74404(var32.getNumericValue(), (var32.getNumericValue2() + 1.5D), var32.getNumericValue3()))) {
                if (TextShaderComponent2.INSTANCE.getMinecraftObject().method_74404(var32.getNumericValue(), var32.getNumericValue2(), var32.getNumericValue3())) {
                }
            } else {
            }
            var28.add();
        }
        Iterator iterator2 = var28.iterator();
        while (iterator2.hasNext()) {
            var25 = (ServiceComponent30) iterator2.next();
            var26 = RangesKt.coerceAtLeast(PolygonShaderComponent.INSTANCE.computeValue((var25.getNumericValue() - 1.0F), var25.getNumericValue()), 0.0F);
            var27 = Math.sin((var26 / 60.0F));
            var28 = (PolygonShaderComponent.INSTANCE.computeValue(var25.getNumericValue4(), var25.getNumericValue()) + var27);
            var29 = PolygonShaderComponent.INSTANCE.computeValue(var25.getNumericValue5(), var25.getNumericValue2());
            iterator = (PolygonShaderComponent.INSTANCE.computeValue(var25.getNumericValue6(), var25.getNumericValue3()) - var27);
            arg0.getStack().method_22903();
            arg0.getStack().method_22904((var28 - var22.method_71156().field_1352), (var29 - var22.method_71156().field_1351), (iterator - var22.method_71156().field_1350));
            arg0.getStack().method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees(PolygonShaderComponent.INSTANCE.computeValue((var25.getNumericValue10() - var25.getNumericValue11()), var25.getNumericValue10())));
            this.executeAction(arg0.getStack().method_23760().method_23761(), iterator, PolygonShaderComponent.INSTANCE.computeValue((var25.getNumericValue10() - var25.getNumericValue11()), var25.getNumericValue10()), var25.getNumericValue3());
            arg0.getStack().method_22909();
        }
        arg0.getStack().method_22903();
        RenderHelper4.render(arg0.getStack(), (Quaternionfc) class_7833.field_40716.rotation(TextShaderComponent2.INSTANCE.getNumericValue2()));
        RenderHelper4.render(arg0.getStack(), (Quaternionfc) class_7833.field_40714.rotation(TextShaderComponent2.INSTANCE.getNumericValue3()));
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline23(), null, null, arg0.getStack().method_23760().method_23761());
        arg0.getStack().method_22909();
    }

    private void executeAction(FormatRenderHelper arg0, Matrix4f arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float arg7) {
        float var29 = 0.33F;
        float var30 = 0.2F;
        float var31 = 0.08F;
        float var32 = 0.78F;
        float var33 = 1.3299999F;
        float var34 = (0.78F + var30);
        if (0.0F <= arg6) {
        } else {
        }
        if (arg6 <= 10.0F) {
        } else {
            if ((arg7 - arg6) < 10.0F) {
            } else {
            }
        }
        float var35 = 1.0F;
        Color var36 = PolygonShaderComponent.INSTANCE.resolveColor(this.getColor(), (PolygonShaderComponent.INSTANCE.computeValue2(this.getColor()) * var35));
        Color var37 = PolygonShaderComponent.INSTANCE.resolveColor(this.getColorBottom(), (PolygonShaderComponent.INSTANCE.computeValue2(this.getColorBottom()) * var35));
        Color var38 = PolygonShaderComponent.INSTANCE.resolveColor(colorValue, (PolygonShaderComponent.INSTANCE.computeValue2(colorValue) * var35));
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var29 + var31), (var32 - var30), (var29 + var31)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var34 - var30)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var34 - var30)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var29 - var31), (var32 - var30), (var29 + var31)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var29 + var31), (var32 - var30), (var29 - var31)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var34 - var30)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var34 - var30)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var29 - var31), (var32 - var30), (var29 - var31)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var29 + var31), (var32 - var30), (var29 + var31)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var34 - var30)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var34 - var30)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var29 + var31), (var32 - var30), (var29 - var31)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var29 - var31), (var32 - var30), (var29 + var31)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var34 - var30)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var34 - var30)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1, (var29 - var31), (var32 - var30), (var29 - var31)).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        arg0.resolveFormatRenderHelper(arg1).resolveFormatRenderHelper();
        double var39 = Math.toRadians(arg5);
        Vec3d vec = this.resolveMinecraftObject(((arg2 - var29) + var31), (arg3 + 0.58F), ((arg4 + var31) - var29), arg2, (arg3 + 0.58F), arg4);
        Vec3d vec2 = this.resolveMinecraftObject(((arg2 + var29) - var31), (arg3 + 0.58F), ((arg4 + var31) - var29), arg2, (arg3 + 0.58F), arg4);
        Vec3d vec3 = this.resolveMinecraftObject(((arg2 - var29) + var31), (arg3 + 0.58F), ((arg4 - var31) + var29), arg2, (arg3 + 0.58F), arg4);
        Vec3d vec4 = this.resolveMinecraftObject(((arg2 + var29) - var31), (arg3 + 0.58F), ((arg4 - var31) + var29), arg2, (arg3 + 0.58F), arg4);
        Vec3d vec5 = this.resolveMinecraftObject(((arg2 - var29) + var31), (arg3 + 0.58F), arg4, arg2, (arg3 + 0.58F), arg4);
        Vec3d vec6 = this.resolveMinecraftObject(((arg2 + var29) - var31), (arg3 + 0.58F), arg4, arg2, (arg3 + 0.58F), arg4);
        Vec3d vec7 = this.resolveMinecraftObject(arg2, (arg3 + 0.58F), ((arg4 + var31) - var29), arg2, (arg3 + 0.58F), arg4);
        Vec3d vec8 = this.resolveMinecraftObject(arg2, (arg3 + 0.58F), ((arg4 - var31) + var29), arg2, (arg3 + 0.58F), arg4);
        TextShaderComponent2.checkCondition(vec, vec2);
        TextShaderComponent2.checkCondition(vec3, vec4);
        TextShaderComponent2.checkCondition(vec5, vec6);
        TextShaderComponent2.checkCondition(vec2, vec4);
        TextShaderComponent2.checkCondition(vec, vec3);
        TextShaderComponent2.checkCondition(vec7, vec8);
    }

    private Vec3d resolveMinecraftObject(float arg0, float arg1, float arg2, float arg3, float arg4, float arg5, double arg6) {
        double var9 = Math.sin(arg6);
        double var11 = Math.cos(arg6);
        float var13 = (arg0 - arg3);
        float var14 = (arg2 - arg5);
        float var15 = (arg1 - arg4);
        float var16 = ((var13 * var11) + (var14 * var9));
        float var18 = ((var13 * var9) + (var14 * var11));
        return new Vec3d((arg3 + var16), (arg4 + var15), (arg5 + var18));
    }

    static {
        KProperty[] var32 = new KProperty[4];
        INSTANCE = new SkyLanternsModule();
        fireColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire-color", Color.YELLOW);
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color", PolygonShaderComponent.INSTANCE.resolveColor(Color.YELLOW, 0.2F));
        colorBottomSetting = VisibleRenderHelper.registerSetting(INSTANCE, "bottom-color", PolygonShaderComponent.INSTANCE.resolveColor(Color.ORANGE, 0.2F));
        countSetting = VisibleRenderHelper.registerSetting(INSTANCE, "count", 256, new IntRange(0, 512));
        colorValue = new Color(70, 70, 70);
        itemList = new ArrayList();
    }

}
