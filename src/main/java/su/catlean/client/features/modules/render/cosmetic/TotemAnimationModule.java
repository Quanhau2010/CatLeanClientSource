package su.catlean.client.features.modules.render.cosmetic;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_1041;
import net.minecraft.class_1044;
import net.minecraft.class_10442;
import net.minecraft.class_10444;
import net.minecraft.class_1059;
import net.minecraft.class_1060;
import net.minecraft.class_11659;
import net.minecraft.class_11661;
import net.minecraft.class_11684;
import net.minecraft.class_290;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.class_811;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.ItemCommandEvent;
import su.catlean.api.event.events.render.RenderFloatingItemEvent;
import su.catlean.api.event.events.render.ShowFloatingItemEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.BufferServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.PolygonRenderHelper3;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.types.mappings.TotemAnimationModeWhenMappings;

public class TotemAnimationModule extends Module {

    public static final TotemAnimationModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl speedSetting;
    private static ItemStack itemStack;
    private static int countValue;
    private static class_4597 minecraftRef;

    private TotemAnimationModule() {
        super("totem-animation", SubCategoriesKt.getCosmeticCategory());
    }

    private TotemAnimationMode getMode() {
        return ((TotemAnimationMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private int getSpeed() {
        return ((Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void onShowFloatingItemEvent(ShowFloatingItemEvent arg0) {
        itemStack = arg0.getItem();
        countValue = this.computeValue();
        arg0.cancel();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        countValue = (countValue + -1);
        itemStack = null;
    }

    private void onRenderFloatingItemEvent(RenderFloatingItemEvent arg0) {
        int index = SharedKt.getMc().method_22683().method_4486();
        int index2 = SharedKt.getMc().method_22683().method_4502();
        int index3 = (this.computeValue() - countValue);
        int index4 = ((index3 + PolygonShaderComponent.INSTANCE.computeValue()) / this.computeValue());
        int index5 = (index4 * index4);
        int index6 = (index4 * index5);
        float factor = ((((((10.25F * index6) * index5) - ((24.95F * index5) * index5)) + (25.5F * index6)) - (13.8F * index5)) + (4.0F * index4));
        float factor2 = (factor * 3.1415927F);
        MatrixStack matrices = new MatrixStack();
        matrices.method_22903();
        int index7 = (index3 + PolygonShaderComponent.INSTANCE.computeValue());
        float factor3 = (50.0F + (175.0F * Math.sin(factor2)));
        double offset = (Math.sin(((index7 * 112) / 180.0F)) * 100);
        double offset2 = (Math.cos(((index7 * 112) / 180.0F)) * 50);
        matrices.method_46416(((index / 2) + offset), ((index2 / 2) + offset2), -50.0F);
        matrices.method_22905(factor3, factor3, factor3);
        matrices.method_46416((index / 2), (index2 / 2), -50.0F);
        matrices.method_22905(factor3, factor3, factor3);
        matrices.method_46416((index / 2), (index2 / 2), -50.0F);
        matrices.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees((index7 * 2))));
        matrices.method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees((index7 * 2))));
        matrices.method_22905((200 - (index7 * 1.5F)), (-200 + (index7 * 1.5F)), (200 - (index7 * 1.5F)));
        matrices.method_46416((index / 2), (index2 / 2), -50.0F);
        matrices.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees((index7 * 3))));
        matrices.method_22905((200 - (index7 * 1.5F)), (-200 + (index7 * 1.5F)), (200 - (index7 * 1.5F)));
        offset = (Math.pow(index7, 3.0D) * 0.2F);
        matrices.method_46416((index / 2), ((index2 / 2) + offset), -50.0F);
        matrices.method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees((index7 * 5))));
        matrices.method_22905((200 - (index7 * 1.5F)), (-200 + (index7 * 1.5F)), (200 - (index7 * 1.5F)));
        offset = ((Math.pow(index7, 3.0D) * 0.2F) - 20);
        matrices.method_46416((index / 2), ((index2 / 2) - offset), -50.0F);
        matrices.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees(((index7 * countValue) * 2))));
        matrices.method_22905((200 - (index7 * 1.5F)), (-200 + (index7 * 1.5F)), (200 - (index7 * 1.5F)));
        offset = (Math.pow(index7, 2.0D) * 4.5F);
        matrices.method_46416(((index / 2) + offset), (index2 / 2), -50.0F);
        matrices.method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees((index7 * 40))));
        matrices.method_22905((200 - (index7 * 1.5F)), (-200 + (index7 * 1.5F)), (200 - (index7 * 1.5F)));
        int index8 = 4;
        int index9 = 0;
        int index10 = 1024;
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index10, index9, index8);
        PolygonRenderHelper3 polygonRenderHelper3 = new PolygonRenderHelper3(formatRenderHelper, PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, (1.0F - index4)).darker());
        minecraftRef = ((class_4597) new BufferServiceComponent(((class_4588) polygonRenderHelper3)));
        offset = new class_10444();
        SharedKt.getMc().method_65386().method_65598(offset, itemStack.getItem().method_7854(), class_811.field_4319, ((World) SharedKt.getWorld()), null, 0);
        offset.method_65604(matrices, ((class_11659) SharedKt.getMc().field_1773.method_72910()), 15728880, class_4608.field_21444, 0);
        SharedKt.getMc().field_1773.method_72911().method_73002();
        SharedKt.getMc().field_1773.method_72910().method_72953();
        offset2 = SharedKt.getMc().method_1531().method_4619(class_1059.field_64467).method_71659();
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline14(), null, null, new MatrixStack().method_23760().method_23761(), ((Matrix3x2f) new Matrix3x2fStack()), MapsKt.mapOf(TuplesKt.to("Sampler0", offset2)));
        minecraftRef = null;
        matrices.method_22909();
    }

    private void onItemCommandEvent(ItemCommandEvent arg0) {
        arg0.setProvider(minecraftRef);
        arg0.cancel();
    }

    private int computeValue() {
        int index = (101 - this.getSpeed());
        if (__UNDEF_KEY__ == null) {
            if (this.getMode() == TotemAnimationMode.FadeOut) {
                return (index / 4);
            }
        }
        if (this.getMode() == TotemAnimationMode.Insert) {
            return (index / 2);
        }
        return index;
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new TotemAnimationModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", TotemAnimationMode.FadeOut);
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 40, new IntRange(1, 100));
    }

}
