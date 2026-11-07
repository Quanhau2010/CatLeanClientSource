package su.catlean.client.features.modules.render.cosmetic;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
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
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.AtlasTextureServiceComponent;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.ColorRenderHelper3;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.RenderHelper4;
import su.catlean.client.services.render.RenderHelper5;
import su.catlean.client.services.render.TexRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.POSITIONTEXCOLORShaderComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.types.OptionMode6;
import su.catlean.client.types.mappings.ParticlesPhysicsModeWhenMappings;

public class ParticlesModule extends Module {

    public static final ParticlesModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 lmodeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 physicsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 colorSetting;
    private static final RangeVisibleSettingPropertyImpl amountSetting;
    private static final RangeVisibleSettingPropertyImpl lifetimeSetting;
    private static final RangeVisibleSettingPropertyImpl2 sizeSetting;
    private static final ArrayList arrayList;
    private static final ArrayList arrayList2;
    private static int countValue;

    private ParticlesModule() {
        super("particles", SubCategoriesKt.getCosmeticCategory());
    }

    private HitFxParticleMode getMode() {
        return ((HitFxParticleMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private ParticlesLmodeMode getLmode() {
        return ((ParticlesLmodeMode) lmodeSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private ParticlesPhysicsMode getPhysics() {
        return ((ParticlesPhysicsMode) physicsSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private Color getColor() {
        return ((Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private int getAmount() {
        return ((Number) amountSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private int getLifetime() {
        return ((Number) lifetimeSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private float getSize() {
        return ((Number) sizeSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        arrayList.removeIf(this::checkCondition);
        arrayList2.removeIf(this::checkCondition2);
        Vec3d vec = this.resolveMinecraftObject(SharedKt.getPlayer()).method_1019(SharedKt.getPlayer().method_18798().method_1021(10.0D));
        int index = this.getAmount();
        int index2 = 0;
        if (INSTANCE.getPhysics() == ParticlesPhysicsMode.RAIN) {
        } else {
            float factor = INSTANCE.getSize();
            float factor2 = 0.0F;
            float factor3 = 0.0F;
            float factor4 = RangeServiceComponent.D(0.1F, 0.25F, false);
            float factor5 = RangeServiceComponent.D(-0.4F, 0.4F, false);
            float factor6 = 0.0F;
            Object element = ParticlesPhysicsModeWhenMappings.ENUM_SWITCH_MAP[INSTANCE.getPhysics().ordinal()];
            float factor7 = RangeServiceComponent.D(-0.4F, -0.1F, false);
            float factor8 = RangeServiceComponent.D(-0.1F, 0.1F, false);
        }
        RenderHelper5 renderHelper5 = new RenderHelper5(factor8, factor7, element, factor6, factor5, factor4, factor3, factor2, factor);
        arrayList.add(renderHelper5);
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        arg0.getStack().method_22903();
        RenderHelper4.render(arg0.getStack(), ((Quaternionfc) class_7833.field_40716.rotation(TextShaderComponent2.INSTANCE.getNumericValue2())));
        RenderHelper4.render(arg0.getStack(), ((Quaternionfc) class_7833.field_40714.rotation(TextShaderComponent2.INSTANCE.getNumericValue3())));
        int index = 4;
        int index2 = 0;
        int index3 = (arrayList.size() + arrayList2.size());
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        MatrixStack matrices = new MatrixStack();
        RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40714.rotation(TextShaderComponent2.INSTANCE.getNumericValue3())));
        RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40716.rotation(TextShaderComponent2.INSTANCE.getNumericValue2())));
        Quaternionf quaternionf = new Quaternionf().rotateYXZ(TextShaderComponent2.INSTANCE.getNumericValue(), TextShaderComponent2.INSTANCE.getNumericValue3(), 0.0F);
        Iterable iterable = ((Iterable) arrayList);
        int index4 = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            RenderHelper5 renderHelper5 = ((RenderHelper5) element);
            int index5 = 0;
            INSTANCE.render(renderHelper5, matrices, ((Quaternionfc) quaternionf), formatRenderHelper);
        }
        iterable = new Quaternionf().rotateYXZ(TextShaderComponent2.INSTANCE.getNumericValue(), 1.5708F, 0.0F);
        index4 = ((Iterable) arrayList2);
        iterator = 0;
        element = index4.iterator();
        while (element.hasNext()) {
            renderHelper5 = element.next();
            index5 = ((ColorRenderHelper3) renderHelper5);
            if (TextShaderComponent2.INSTANCE.getMinecraftObject().method_74404(index5.getNumericValue(), index5.getNumericValue2(), index5.getNumericValue3())) {
                matrices.method_22903();
                matrices.method_22904((index5.getNumericValue() - class4184.method_71156().field_1352), (index5.getNumericValue2() - class4184.method_71156().field_1351), (index5.getNumericValue3() - class4184.method_71156().field_1350));
                RenderHelper4.render(matrices, ((Quaternionfc) iterable));
                Matrix4f matrix4f = matrices.method_23760().method_23761();
                float factor = PolygonShaderComponent.INSTANCE.computeValue(Math.max(1, (index5.getNumericValue() - 1)), index5.getNumericValue());
                float factor2 = (1.0F - (factor / 15.0F));
                Color color = PolygonShaderComponent.INSTANCE.resolveColor(index5.getColor(), factor2);
                float factor3 = (0.5F + (1.0F * (factor / 15.0F)));
                OptionMode6 optionMode6 = OptionMode6.CIRCLE;
                matrices.method_22904((factor3 / 2.0D), (factor3 / 2.0D), -0.01D);
                formatRenderHelper.resolveFormatRenderHelper(matrix4f, 0.0F, factor3, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color);
                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor3, factor3, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color);
                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor3, 0.0F, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color);
                formatRenderHelper.resolveFormatRenderHelper(matrix4f, 0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color);
                matrices.method_22909();
            }
        }
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline19(), null, null, arg0.getStack().method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0", SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659())));
        arg0.getStack().method_22909();
    }

    private boolean checkCondition(RenderHelper5 arg0) {
        if (SharedKt.getPlayer().method_5649(arg0.getNumericValue(), arg0.getNumericValue2(), arg0.getNumericValue3()) <= 4096.0D) {
            if (arg0.isActive()) {
                arg0.updateValue((arg0.getNumericValue() - 16));
            } else {
                int index = arg0.getNumericValue();
                arg0.updateValue((index + -1));
            }
        }
        if (arg0.getNumericValue() < 0) {
            return true;
        }
        arg0.updateValue10(arg0.getNumericValue());
        arg0.updateValue11(arg0.getNumericValue2());
        arg0.updateValue12(arg0.getNumericValue3());
        arg0.updateValue((arg0.getNumericValue() + arg0.getNumericValue4()));
        arg0.updateValue2((arg0.getNumericValue2() + arg0.getNumericValue5()));
        arg0.updateValue3((arg0.getNumericValue3() + arg0.getNumericValue6()));
        arg0.updateValue13(arg0.getNumericValue7());
        arg0.updateValue7((arg0.getNumericValue7() + arg0.getNumericValue8()));
        if (this.getPhysics() != ParticlesPhysicsMode.FALLING_STARS) {
            arg0.updateValue4((arg0.getNumericValue4() * 0.9F));
            arg0.updateValue6((arg0.getNumericValue6() * 0.9F));
        }
        if (this.getPhysics() != ParticlesPhysicsMode.FLY) {
            if (this.getPhysics() == ParticlesPhysicsMode.RAIN && arg0.isActive()) {
                arg0.updateValue5((arg0.getNumericValue5() * 0.9F));
            }
        }
        if (this.getPhysics() == ParticlesPhysicsMode.RAIN && arg0.isActive()) {
        } else {
            if (this.getPhysics() == ParticlesPhysicsMode.RAIN) {
            } else {
            }
        }
        this.updateValue5((0.02F - 0.001F));
        if ((arg0.getNumericValue2() - this.getSize()) < arg0.getNumericValue14() && !(arg0.isActive()) && this.getPhysics() == ParticlesPhysicsMode.RAIN) {
            arg0.updateValue5((arg0.getNumericValue5() / 4.0F));
            arg0.updateValue(true);
            arg0.updateValue(128);
            arg0.updateValue4(RangeServiceComponent.D(-0.2F, 0.2F, false));
            arg0.updateValue6(RangeServiceComponent.D(-0.2F, 0.2F, false));
            index = 5;
            int index2 = 0;
            if (index2 < index) {
                POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(OptionMode6.FIREFLY, 0.0F, 0.1F, 8, NewThemeRenderHelper.INSTANCE.resolveColor((index2 * 10)), 0.0F, 0.0F, false));
            }
            arg0.updateValue8(RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(-20.0F, 20.0F)), false));
            arrayList2.add(new ColorRenderHelper3(arg0.getNumericValue(), arg0.getNumericValue14(), arg0.getNumericValue3(), 0, arg0.getColor()));
        }
        if (this.getPhysics() == ParticlesPhysicsMode.RAIN) {
        } else {
        }
        Math.hypot((arg0.getNumericValue() - SharedKt.getPlayer().getX()), (arg0.getNumericValue3() - SharedKt.getPlayer().getZ())).updateValue2(1024.0F < 2304.0F);
        return false;
    }

    private void render(RenderHelper5 arg0, MatrixStack arg1, Quaternionfc arg2, FormatRenderHelper arg3) {
        if (!(arg0.isActive2()) || !(TextShaderComponent2.INSTANCE.getMinecraftObject().method_74404(arg0.getNumericValue(), arg0.getNumericValue2(), arg0.getNumericValue3()))) {
            return;
        }
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        float factor = PolygonShaderComponent.INSTANCE.computeValue(arg0.getNumericValue10(), arg0.getNumericValue());
        float factor2 = PolygonShaderComponent.INSTANCE.computeValue(arg0.getNumericValue11(), arg0.getNumericValue2());
        float factor3 = PolygonShaderComponent.INSTANCE.computeValue(arg0.getNumericValue12(), arg0.getNumericValue3());
        arg1.method_22903();
        arg1.method_22904((factor - class4184.method_71156().field_1352), (factor2 - class4184.method_71156().field_1351), (factor3 - class4184.method_71156().field_1350));
        RenderHelper4.render(arg1, arg2);
        if (this.getPhysics() == ParticlesPhysicsMode.RAIN) {
            RenderHelper4.render(arg1, ((Quaternionfc) class_7833.field_40718.rotationDegrees(PolygonShaderComponent.INSTANCE.computeValue(arg0.getNumericValue13(), arg0.getNumericValue7()))));
        }
        Matrix4f matrix4f = arg1.method_23760().method_23761();
        int index = (arg0.getNumericValue() / arg0.getNumericValue2());
        if (this.getPhysics() == ParticlesPhysicsMode.RAIN) {
            if (arg0.isActive()) {
            } else {
            }
        }
        Color color = arg0.getColor();
        arg1.method_22904((this.getSize() / 2.0D), (this.getSize() / 2.0D), -0.01D);
        OptionMode6 optionMode6 = this.getMode().getOptionMode6();
        arg3.resolveFormatRenderHelper(matrix4f, 0.0F, this.getSize(), 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color);
        arg3.resolveFormatRenderHelper(matrix4f, this.getSize(), this.getSize(), 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color);
        arg3.resolveFormatRenderHelper(matrix4f, this.getSize(), 0.0F, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color);
        arg3.resolveFormatRenderHelper(matrix4f, 0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color);
        arg1.method_22909();
        float factor4 = RangesKt.coerceIn((arg0.getNumericValue() / 20.0F), 0.0F, 1.0F);
        TextShaderComponent2.INSTANCE.checkCondition(new Vec3d(factor, factor2, factor3), new Vec3d(factor, (factor2 + 3), factor3), PolygonShaderComponent.INSTANCE.resolveColor(color, (factor4 / 3.0F)), PolygonShaderComponent.INSTANCE.resolveColor(color, 0.0F));
    }

    private static boolean isActive() {
        return INSTANCE.getLmode() == ParticlesLmodeMode.CUSTOM;
    }

    private static boolean checkCondition(RenderHelper5 arg0) {
        return INSTANCE.checkCondition(arg0);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static boolean checkCondition(ColorRenderHelper3 arg0) {
        int index = arg0.getNumericValue();
        arg0.updateValue((index + 1));
        if (__UNDEF_KEY__ != null) {
            if (index > 15) {
            } else {
            }
        }
        return false;
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    public static ParticlesPhysicsMode resolveParticlesPhysicsMode(ParticlesModule $this) {
        return $this.getPhysics();
    }

    public static int computeValue(ParticlesModule $this) {
        return $this.getLifetime();
    }

    public static ParticlesLmodeMode resolveParticlesLmodeMode(ParticlesModule $this) {
        return $this.getLmode();
    }

    public static Color resolveColor(ParticlesModule $this) {
        return $this.getColor();
    }

    static {
        KProperty[] items = new KProperty[7];
        INSTANCE = new ParticlesModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", HitFxParticleMode.SNOW_FLAKE);
        lmodeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color-mode", ParticlesLmodeMode.SYNC);
        physicsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "physics", ParticlesPhysicsMode.FLY);
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color", Color.WHITE, null, this::isActive);
        amountSetting = VisibleRenderHelper.registerSetting(INSTANCE, "amount", 10, new IntRange(1, 50));
        lifetimeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "time", 256, new IntRange(5, 80));
        sizeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "size", 1.0F, RangesKt.rangeTo(0.1F, 1.5F));
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 17;
        return 0;
    }

}
