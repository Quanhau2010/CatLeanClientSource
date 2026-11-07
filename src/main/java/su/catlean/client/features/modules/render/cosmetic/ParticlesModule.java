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
        return (HitFxParticleMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private ParticlesLmodeMode getLmode() {
        return (ParticlesLmodeMode) lmodeSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private ParticlesPhysicsMode getPhysics() {
        return (ParticlesPhysicsMode) physicsSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private Color getColor() {
        return (Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private int getAmount() {
        return (Number) amountSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private int getLifetime() {
        return (Number) lifetimeSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private float getSize() {
        return (Number) sizeSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        arrayList.removeIf(this::checkCondition);
        arrayList2.removeIf(this::checkCondition2);
        Vec3d vec = this.resolveMinecraftObject(SharedKt.getPlayer()).method_1019(SharedKt.getPlayer().method_18798().method_1021(10.0D));
        int var31 = this.getAmount();
        int var32 = 0;
        int var33 = var32;
        int var34 = 0;
        if (INSTANCE.getPhysics() == ParticlesPhysicsMode.RAIN) {
        } else {
            float var20 = INSTANCE.getSize();
            float var21 = 0.0F;
            float var22 = 0.0F;
            float var23 = RangeServiceComponent.D(0.1F, 0.25F);
            float var24 = RangeServiceComponent.D(-0.4F, 0.4F);
            float var25 = 0.0F;
            Object var26 = ParticlesPhysicsModeWhenMappings.ENUM_SWITCH_MAP[INSTANCE.getPhysics().ordinal()];
            float var27 = RangeServiceComponent.D(-0.4F, -0.1F);
            float var28 = RangeServiceComponent.D(-0.1F, 0.1F);
            RangeServiceComponent.D(-0.2F, -0.05F).<init>();
        }
        Object var35 = ParticlesPhysicsModeWhenMappings.ENUM_SWITCH_MAP[INSTANCE.getPhysics().ordinal()];
        arrayList.add();
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        class_4184 var31 = SharedKt.getMc().field_1773.method_19418();
        arg0.getStack().method_22903();
        RenderHelper4.render(arg0.getStack(), (Quaternionfc) class_7833.field_40716.rotation(TextShaderComponent2.INSTANCE.getNumericValue2()));
        RenderHelper4.render(arg0.getStack(), (Quaternionfc) class_7833.field_40714.rotation(TextShaderComponent2.INSTANCE.getNumericValue3()));
        int var26 = 4;
        int var27 = 0;
        int var28 = (arrayList.size() + arrayList2.size());
        VertexFormat var29 = class_290.field_1575;
        FormatRenderHelper var32 = new FormatRenderHelper();
        MatrixStack matrices = new MatrixStack();
        RenderHelper4.render(matrices, (Quaternionfc) class_7833.field_40714.rotation(TextShaderComponent2.INSTANCE.getNumericValue3()));
        RenderHelper4.render(matrices, (Quaternionfc) class_7833.field_40716.rotation(TextShaderComponent2.INSTANCE.getNumericValue2()));
        Quaternionf var34 = new Quaternionf().rotateYXZ(TextShaderComponent2.INSTANCE.getNumericValue(), TextShaderComponent2.INSTANCE.getNumericValue3(), 0.0F);
        Iterable var35 = (Iterable) arrayList;
        int var36 = 0;
        Iterator iterator = var35.iterator();
        while (iterator.hasNext()) {
            Object var38 = iterator.next();
            RenderHelper5 var39 = (RenderHelper5) var38;
            int var40 = 0;
            INSTANCE.render(matrices, (Quaternionfc) var34);
        }
        var35 = new Quaternionf().rotateYXZ(TextShaderComponent2.INSTANCE.getNumericValue(), 1.5708F, 0.0F);
        var36 = (Iterable) arrayList2;
        iterator = 0;
        var38 = var36.iterator();
        while (var38.hasNext()) {
            var39 = var38.next();
            var40 = (ColorRenderHelper3) var39;
            int var41 = 0;
            if (TextShaderComponent2.INSTANCE.getMinecraftObject().method_74404(var40.getNumericValue(), var40.getNumericValue2(), var40.getNumericValue3())) {
                matrices.method_22903();
                matrices.method_22904((var40.getNumericValue() - var31.method_71156().field_1352), (var40.getNumericValue2() - var31.method_71156().field_1351), (var40.getNumericValue3() - var31.method_71156().field_1350));
                RenderHelper4.render(matrices, (Quaternionfc) var35);
                Matrix4f var42 = matrices.method_23760().method_23761();
                float var43 = PolygonShaderComponent.INSTANCE.computeValue(Math.max(1, (var40.getNumericValue() - 1)), var40.getNumericValue());
                float var44 = (1.0F - (var43 / 15.0F));
                Color var45 = PolygonShaderComponent.INSTANCE.resolveColor(var40.getColor());
                float var46 = (0.5F + (1.0F * (var43 / 15.0F)));
                OptionMode6 var47 = OptionMode6.CIRCLE;
                matrices.method_22904((var46 / 2.0D), (var46 / 2.0D), -0.01D);
                var32.resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(var47.getNumericValue3(), var47.getNumericValue2()).resolveFormatRenderHelper();
                var32.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var47.getNumericValue(), var47.getNumericValue2()).resolveFormatRenderHelper();
                var32.resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(var47.getNumericValue(), var47.getNumericValue4()).resolveFormatRenderHelper();
                var32.resolveFormatRenderHelper(0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(var47.getNumericValue3(), var47.getNumericValue4()).resolveFormatRenderHelper();
                matrices.method_22909();
            }
        }
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline19(), null, null, arg0.getStack().method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0", SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659())));
        arg0.getStack().method_22909();
    }

    private boolean checkCondition(RenderHelper5 arg0) {
        if (SharedKt.getPlayer().method_5649(arg0.getNumericValue(), arg0.getNumericValue2(), arg0.getNumericValue3()) <= 4096.0D) {
            if (arg0.isActive()) {
            }
            arg0.updateValue((arg0.getNumericValue() - 16));
        } else {
            int var22 = arg0.getNumericValue();
            arg0.updateValue((var22 + -1));
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
            }
            arg0.updateValue5((arg0.getNumericValue5() * 0.9F));
        }
        if (this.getPhysics() == ParticlesPhysicsMode.RAIN && arg0.isActive()) {
        } else {
            if (this.getPhysics() == ParticlesPhysicsMode.RAIN) {
            } else {
            }
        }
        0.08F.updateValue5((0.02F - 0.001F));
        if ((arg0.getNumericValue2() - this.getSize()) < arg0.getNumericValue14() && !(arg0.isActive()) && this.getPhysics() == ParticlesPhysicsMode.RAIN) {
            arg0.updateValue5((arg0.getNumericValue5() / 4.0F));
            arg0.updateValue(1);
            arg0.updateValue(128);
            arg0.updateValue4(RangeServiceComponent.D(-0.2F, 0.2F));
            arg0.updateValue6(RangeServiceComponent.D(-0.2F, 0.2F));
            var22 = 5;
            int var23 = 0;
            if (var23 < var22) {
                int var24 = var23;
                int var25 = 0;
                POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(OptionMode6.FIREFLY, new Vec3d(arg0.getNumericValue(), arg0.getNumericValue14(), arg0.getNumericValue3()), 0.0F, 0.1F, 8, new Vec3d(((Math.random() / 2.0F) - 0.25F), (Math.random() / 4.0F), ((Math.random() / 2.0F) - 0.25F)), NewThemeRenderHelper.INSTANCE.resolveColor((var24 * 10)), 0.0F, 0.0F));
            }
            arg0.updateValue8(RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(-20.0F, 20.0F)));
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
        class_4184 var31 = SharedKt.getMc().field_1773.method_19418();
        float var32 = PolygonShaderComponent.INSTANCE.computeValue(arg0.getNumericValue10(), arg0.getNumericValue());
        float var34 = PolygonShaderComponent.INSTANCE.computeValue(arg0.getNumericValue11(), arg0.getNumericValue2());
        float var36 = PolygonShaderComponent.INSTANCE.computeValue(arg0.getNumericValue12(), arg0.getNumericValue3());
        arg1.method_22903();
        arg1.method_22904((var32 - var31.method_71156().field_1352), (var34 - var31.method_71156().field_1351), (var36 - var31.method_71156().field_1350));
        RenderHelper4.render(arg1, arg2);
        if (this.getPhysics() == ParticlesPhysicsMode.RAIN) {
            RenderHelper4.render(arg1, (Quaternionfc) class_7833.field_40718.rotationDegrees(PolygonShaderComponent.INSTANCE.computeValue(arg0.getNumericValue13(), arg0.getNumericValue7())));
        }
        Matrix4f var38 = arg1.method_23760().method_23761();
        int var39 = (arg0.getNumericValue() / arg0.getNumericValue2());
        if (this.getPhysics() == ParticlesPhysicsMode.RAIN) {
            if (arg0.isActive()) {
            }
        } else {
        }
        Color var40 = arg0.getColor();
        arg1.method_22904((this.getSize() / 2.0D), (this.getSize() / 2.0D), -0.01D);
        OptionMode6 var41 = this.getMode().getOptionMode6();
        arg3.resolveFormatRenderHelper(0.0F, this.getSize(), 0.0F).resolveFormatRenderHelper(var41.getNumericValue3(), var41.getNumericValue2()).resolveFormatRenderHelper();
        arg3.resolveFormatRenderHelper(this.getSize(), this.getSize(), 0.0F).resolveFormatRenderHelper(var41.getNumericValue(), var41.getNumericValue2()).resolveFormatRenderHelper();
        arg3.resolveFormatRenderHelper(this.getSize(), 0.0F, 0.0F).resolveFormatRenderHelper(var41.getNumericValue(), var41.getNumericValue4()).resolveFormatRenderHelper();
        arg3.resolveFormatRenderHelper(0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(var41.getNumericValue3(), var41.getNumericValue4()).resolveFormatRenderHelper();
        arg1.method_22909();
        float var42 = RangesKt.coerceIn((arg0.getNumericValue() / 20.0F), 0.0F, 1.0F);
        TextShaderComponent2.INSTANCE.checkCondition(new Vec3d(), new Vec3d((var34 + 3)), PolygonShaderComponent.INSTANCE.resolveColor((var42 / 3.0F)), PolygonShaderComponent.INSTANCE.resolveColor(0.0F));
    }

    private static boolean isActive() {
        return INSTANCE.getLmode() == ParticlesLmodeMode.CUSTOM;
    }

    private static boolean checkCondition(RenderHelper5 arg0) {
        return INSTANCE.checkCondition(arg0);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static boolean checkCondition(ColorRenderHelper3 arg0) {
        int var4 = arg0.getNumericValue();
        arg0.updateValue((var4 + 1));
        if (var3 != null) {
            if (var4 > 15) {
            }
        } else {
        }
        return false;
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
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
        KProperty[] var34 = new KProperty[7];
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
