package su.catlean.client.features.modules.render.cosmetic;

import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1041;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_2664;
import net.minecraft.class_2743;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_7833;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.AtlasTextureServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.VecServiceComponent2;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.types.OptionMode6;

public class DamageTintModule extends Module {

    public static final DamageTintModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl vectorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 vectorColorSetting;
    private static final RangeVisibleSettingPropertyImpl vectorSizeSetting;
    private static final VisibleVisibleSettingPropertyImpl tintSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 tintColorSetting;
    private static final class_2960 minecraftRef;
    private static Vec3d vec3d;
    private static Vec3d vec3d2;
    private static final List itemList;

    private DamageTintModule() {
        super("damage-tint", SubCategoriesKt.getCosmeticCategory());
    }

    private boolean getVector() {
        return ((Boolean) vectorSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private Color getVectorColor() {
        return ((Color) vectorColorSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private int getVectorSize() {
        return ((Number) vectorSizeSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getTint() {
        return ((Boolean) tintSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private Color getTintColor() {
        return ((Color) tintColorSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        if (SharedKt.getPlayer().field_6235 > 0) {
            if (vec3d != null) {
                itemList.add(new VecServiceComponent2(vec3d));
                vec3d = null;
            } else {
                if (vec3d2 != null) {
                    itemList.add(new VecServiceComponent2(vec3d2));
                    vec3d2 = null;
                }
            }
        }
        if (this.getTint()) {
            this.executeAction(10.0F, 2.0F);
        }
        if (this.getVector()) {
            Iterator iterator = itemList.iterator();
            while (iterator.hasNext()) {
                VecServiceComponent2 vecServiceComponent2 = ((VecServiceComponent2) iterator.next());
                vecServiceComponent2.getEasingServiceComponent().executeAction(1.0F);
                int index = (SharedKt.getMc().method_22683().method_4486() / 2.0F);
                int index2 = (SharedKt.getMc().method_22683().method_4502() / 2.0F);
                MatrixStack matrices = new MatrixStack();
                float factor = (MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(vecServiceComponent2.getMinecraftObject()).getNumericValue() - SharedKt.getPlayer().method_36454());
                matrices.method_46416(index, index2, 0.0F);
                matrices.method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees(factor)));
                matrices.method_46416(index, index2, 0.0F);
                this.render(matrices, index, index2, this.getVectorSize(), PolygonShaderComponent.INSTANCE.resolveColor(this.getVectorColor(), (1.0F - vecServiceComponent2.getEasingServiceComponent().getNumericValue())));
            }
        }
        itemList.removeIf(this::checkCondition);
    }

    public void render(MatrixStack matrices, float x, float y, float size, Color color) {
        Matrix4f matrix4f = matrices.method_23760().method_23761();
        PolygonShaderComponent.INSTANCE.executeAction(matrix4f, AtlasTextureServiceComponent.getMinecraftObject(), x, y, size, size, color, color, color, color, true, OptionMode6.HALO.getNumericValue(), OptionMode6.HALO.getNumericValue2(), OptionMode6.HALO.getNumericValue3(), OptionMode6.HALO.getNumericValue4());
    }

    public void executeAction(float threshold, float power) {
        float factor = (SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067());
        float factor2 = (Math.abs((1.0F - 1.0F)) * power);
        if (__UNDEF_KEY__ >= 0L) {
            if (factor <= 4.0F) {
                factor2 = (factor2 + Math.abs((0.2F * Math.sin(Math.toRadians(((SharedKt.getPlayer().field_6012 * 16.0D) + PolygonShaderComponent.INSTANCE.computeValue()))))));
            }
        }
        factor2 = RangesKt.coerceIn(factor2, 0.0F, 1.0F);
        Color color = new Color((((1.0F - PolygonShaderComponent.INSTANCE.computeValue(this.getTintColor())) * factor2) * 255), (((1.0F - PolygonShaderComponent.INSTANCE.computeValue(this.getTintColor())) * factor2) * 255), (((1.0F - PolygonShaderComponent.INSTANCE.computeValue(this.getTintColor())) * factor2) * 255), 255);
        int index = SharedKt.getMc().method_22683().method_4486();
        int index2 = SharedKt.getMc().method_22683().method_4502();
        GpuTextureView gpuTextureView = SharedKt.getMc().method_1531().method_4619(minecraftRef).method_71659();
        int index3 = 6;
        int index4 = 0;
        int index5 = 0;
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index5, index4, index3);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, 0.0F, index2, 0.0F).resolveFormatRenderHelper(0.0F, 1.0F).resolveFormatRenderHelper(color);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, index, index2, 0.0F).resolveFormatRenderHelper(1.0F, 1.0F).resolveFormatRenderHelper(color);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, index, 0.0F, 0.0F).resolveFormatRenderHelper(1.0F, 0.0F).resolveFormatRenderHelper(color);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, 0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(color);
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline20(), null, null, null, null, MapsKt.mapOf(TuplesKt.to("Sampler0", gpuTextureView)));
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (arg0.getPacket() instanceof class_2743) {
            Packet packet = arg0.getPacket();
            if (((class_2743) packet).method_11818() == SharedKt.getPlayer().method_5628() && ((class_2743) packet).method_73085().field_1352 != 0.0D && ((class_2743) packet).method_73085().field_1350 != 0.0D) {
                vec3d2 = new Vec3d(((class_2743) packet).method_73085().field_1352, ((class_2743) packet).method_73085().field_1351, ((class_2743) packet).method_73085().field_1350).method_1019(this.resolveMinecraftObject(SharedKt.getPlayer()));
            }
        }
        packet = arg0.getPacket();
        vec3d = new Vec3d(((class_2664) packet).comp_2883().field_1352, ((class_2664) packet).comp_2883().field_1351, ((class_2664) packet).comp_2883().field_1350);
    }

    private static boolean isActive() {
        return INSTANCE.getVector();
    }

    private static boolean isActive2() {
        return INSTANCE.getVector();
    }

    private static boolean isActive3() {
        return INSTANCE.getTint();
    }

    private static boolean checkCondition(VecServiceComponent2 arg0) {
        return arg0.getEasingServiceComponent().isActive();
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        KProperty[] items = new KProperty[5];
        INSTANCE = new DamageTintModule();
        vectorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "vector", true);
        vectorColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "vector-color", Color.RED, null, this::isActive);
        vectorSizeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "vector-size", 100, new IntRange(10, 500), null, this::isActive2);
        tintSetting = VisibleRenderHelper.registerSetting(INSTANCE, "tint", true);
        tintColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "tint-color", Color.RED, null, this::isActive3);
        minecraftRef = class_2960.method_60656("textures/misc/vignette.png");
        itemList = new ArrayList();
    }

}
