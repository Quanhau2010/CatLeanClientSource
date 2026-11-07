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
        return (TotemAnimationMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private int getSpeed() {
        return (Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void onShowFloatingItemEvent(ShowFloatingItemEvent arg0) {
        itemStack = arg0.getItem();
        countValue = this.computeValue();
        arg0.cancel();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (var4 == null) {
            countValue = (countValue + -1);
        }
        itemStack = null;
    }

    private void onRenderFloatingItemEvent(RenderFloatingItemEvent arg0) {
        int var32 = SharedKt.getMc().method_22683().method_4486();
        int var33 = SharedKt.getMc().method_22683().method_4502();
        int var34 = (this.computeValue() - countValue);
        int var35 = ((var34 + PolygonShaderComponent.INSTANCE.computeValue()) / this.computeValue());
        float var36 = (var35 * var35);
        float var37 = (var35 * var36);
        float var38 = ((((((10.25F * var37) * var36) - ((24.95F * var36) * var36)) + (25.5F * var37)) - (13.8F * var36)) + (4.0F * var35));
        float var39 = (var38 * 3.1415927F);
        MatrixStack matrices = new MatrixStack();
        matrices.method_22903();
        int var41 = (var34 + PolygonShaderComponent.INSTANCE.computeValue());
        float var42 = (50.0F + (175.0F * Math.sin()));
        double var45 = (Math.sin(((var41 * 112) / 180.0F)) * 100);
        double var46 = (Math.cos(((var41 * 112) / 180.0F)) * 50);
        matrices.method_46416(((var32 / 2) + var45), ((var33 / 2) + var46), -50.0F);
        matrices.method_22905();
        matrices.method_46416((var32 / 2), (var33 / 2), -50.0F);
        matrices.method_22905();
        matrices.method_46416((var32 / 2), (var33 / 2), -50.0F);
        matrices.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees((var41 * 2)));
        matrices.method_22907((Quaternionfc) class_7833.field_40718.rotationDegrees((var41 * 2)));
        matrices.method_22905((200 - (var41 * 1.5F)), (-200 + (var41 * 1.5F)), (200 - (var41 * 1.5F)));
        matrices.method_46416((var32 / 2), (var33 / 2), -50.0F);
        matrices.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees((var41 * 3)));
        matrices.method_22905((200 - (var41 * 1.5F)), (-200 + (var41 * 1.5F)), (200 - (var41 * 1.5F)));
        if (var31 != null && var31 != null && var31 != null && var31 != null) {
            var45 = (Math.pow(3.0D) * 0.2F);
            matrices.method_46416((var32 / 2), ((var33 / 2) + var45), -50.0F);
            matrices.method_22907((Quaternionfc) class_7833.field_40718.rotationDegrees((var41 * 5)));
            matrices.method_22905((200 - (var41 * 1.5F)), (-200 + (var41 * 1.5F)), (200 - (var41 * 1.5F)));
            if (var31 != null) {
                var45 = ((Math.pow(3.0D) * 0.2F) - 20);
                matrices.method_46416((var32 / 2), ((var33 / 2) - var45), -50.0F);
                matrices.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees(((var41 * countValue) * 2)));
                matrices.method_22905((200 - (var41 * 1.5F)), (-200 + (var41 * 1.5F)), (200 - (var41 * 1.5F)));
                if (var31 != null) {
                    var45 = (Math.pow(2.0D) * 4.5F);
                    matrices.method_46416(((var32 / 2) + var45), (var33 / 2), -50.0F);
                    matrices.method_22907((Quaternionfc) class_7833.field_40718.rotationDegrees((var41 * 40)));
                    matrices.method_22905((200 - (var41 * 1.5F)), (-200 + (var41 * 1.5F)), (200 - (var41 * 1.5F)));
                    if (var31 != null && var31 != null) {
                    }
                }
            }
        }
        int var27 = 4;
        int var28 = 0;
        int var29 = 1024;
        VertexFormat var30 = class_290.field_1575;
        FormatRenderHelper var43 = new FormatRenderHelper();
        PolygonRenderHelper3 var44 = new PolygonRenderHelper3(PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, (1.0F - var35)).darker());
        minecraftRef = (class_4597) new BufferServiceComponent((class_4588) var44);
        var45 = new class_10444();
        SharedKt.getMc().method_65386().method_65598(itemStack.getItem().method_7854(), class_811.field_4319, (World) SharedKt.getWorld(), null, 0);
        var45.method_65604(matrices, (class_11659) SharedKt.getMc().field_1773.method_72910(), 15728880, class_4608.field_21444, 0);
        SharedKt.getMc().field_1773.method_72911().method_73002();
        SharedKt.getMc().field_1773.method_72910().method_72953();
        var46 = SharedKt.getMc().method_1531().method_4619(class_1059.field_64467).method_71659();
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline14(), null, null, new MatrixStack().method_23760().method_23761(), (Matrix3x2f) new Matrix3x2fStack(), MapsKt.mapOf(TuplesKt.to("Sampler0")));
        minecraftRef = null;
        matrices.method_22909();
    }

    private void onItemCommandEvent(ItemCommandEvent arg0) {
        if (var4 == null) {
            arg0.setProvider(minecraftRef);
        }
        arg0.cancel();
    }

    private int computeValue() {
        int var8 = (101 - this.getSpeed());
        if (var7 == null) {
            if (this.getMode() == TotemAnimationMode.FadeOut) {
                return (var8 / 4);
            }
        }
        if (this.getMode() == TotemAnimationMode.Insert) {
            return (var8 / 2);
        }
        return var8;
    }

    static {
        KProperty[] var29 = new KProperty[2];
        INSTANCE = new TotemAnimationModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", TotemAnimationMode.FadeOut);
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 40, new IntRange(1, 100));
    }

}
