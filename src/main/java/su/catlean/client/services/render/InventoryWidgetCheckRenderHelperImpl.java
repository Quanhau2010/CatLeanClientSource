package su.catlean.client.services.render;

import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1041;
import net.minecraft.class_11286;
import net.minecraft.class_11661;
import net.minecraft.class_11684;
import net.minecraft.class_1661;
import net.minecraft.class_290;
import net.minecraft.class_308;
import net.minecraft.class_308.class_11274;
import net.minecraft.class_4597.class_4598;
import net.minecraft.class_4599;
import net.minecraft.class_6364;
import net.minecraft.class_757;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.joml.Matrix4f;
import su.catlean.SharedKt;
import su.catlean.api.event.GofraState;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.mixins.accessors.GameRendererAccessor;

public class InventoryWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final InventoryWidgetCheckRenderHelperImpl INSTANCE;
    private static class_6364 minecraftRef;
    private static boolean enabledFlag;
    private static final long timestampValue2;

    private InventoryWidgetCheckRenderHelperImpl() {
        super("inventory-widget");
    }

    public class_6364 getMinecraftObject() {
        return minecraftRef;
    }

    public void updateValue(class_6364 value) {
        minecraftRef = value;
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public void render(DrawContext context) {
        if (minecraftRef == null) {
            minecraftRef = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        if (SharedKt.getMc().method_1522().field_1482 == minecraftRef.field_1482) {
            if (SharedKt.getMc().method_1522().field_1481 != minecraftRef.field_1481) {
                minecraftRef.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
            }
        }
        String text = "Inventory";
        float factor = this.computeValue();
        CheckRenderHelper.executeAction(this, context.method_51448(), factor, this.computeValue2(), 145.0F, 13.0F, 0.0F, false);
        Color[] items = new Color[1];
        items[0] = new Color(1157627903, true);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (factor + 14), (this.computeValue2() + 3.0F), 0.5F, 7.5F, items);
        CheckRenderHelper.executeAction(this, this.getMissingnoRenderHelper(), context.method_51448(), (factor + 2.0F), this.computeValue2(), 10.0F, 10.0F, 0.0F);
        this.render(context, text, (factor + 18.0F), (this.computeValue2() + 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        items = 0;
        items = 9;
        int index = 3;
        int index2 = 0;
        if (index2 < index) {
            float factor2 = ((INSTANCE.computeValue2() + (index2 * 17)) + 14);
            CheckRenderHelper.executeAction(INSTANCE, context.method_51448(), factor, factor2, 145.0F, 16.0F, 0.0F, false);
            int index3 = 9;
            int index4 = 0;
            if (index4 < index3) {
                if (index4 < 8) {
                    CheckRenderHelper.executeAction(INSTANCE, context.method_51448(), ((factor + 16) + (index4 * 16)), (factor2 + 4.0F), 0.0F);
                }
                items = (items + 1);
            }
        }
        this.render(context, factor);
        this.executeAction(145.0F, 70.0F);
    }

    public void render(DrawContext context) {
        this.updateValue();
        this.render2(context, this.computeValue());
    }

    private void render(DrawContext arg0, long arg1, float arg2) {
        if ((SharedKt.getNumericValue() - timestampValue) < timestampValue2 && !(Intrinsics.areEqual(POSITIONCOLORRenderHelper.INSTANCE.getCheckRenderHelper(), this))) {
            return;
        }
        timestampValue = SharedKt.getNumericValue();
        GofraState.INSTANCE.setModifyBuffer(true);
        enabledFlag = 1;
        RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(minecraftRef.method_30277(), 0, minecraftRef.method_30278(), 1.0D);
        MatrixStack matrices = new MatrixStack();
        RenderSystem.backupProjectionMatrix();
        RenderSystem.setProjectionMatrix(((GameRendererAccessor) SharedKt.getMc().field_1773).getLevelProjectionMatrixBuffer().method_71123(new Matrix4f().identity().setOrtho(0.0F, SharedKt.getMc().method_22683().method_4486(), SharedKt.getMc().method_22683().method_4502(), 0.0F, -160.0F, 160.0F)), RenderSystem.getProjectionType());
        SharedKt.getMc().field_1773.method_71114().method_71034(class_11274.field_60026);
        int index = 0;
        index = 9;
        int index2 = 3;
        int index3 = 0;
        if (index3 < index2) {
            float factor = ((INSTANCE.computeValue2() + (index3 * 17)) + 14);
            int index4 = 9;
            int index5 = 0;
            if (index5 < index4) {
                ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(index);
                matrices.method_22903();
                matrices.method_46416(((arg2 + 2.5F) + (index5 * 16)), (factor + 2.5F), 0.0F);
                matrices.method_22905(0.75F, 0.75F, 1.0F);
                PolygonShaderComponent.INSTANCE.render(matrices, stack);
                matrices.method_22909();
                index = (index + 1);
            }
        }
        SharedKt.getMc().field_1773.method_72911().method_73002();
        SharedKt.getMc().method_22940().method_23000().method_22993();
        SharedKt.getMc().field_1773.method_72910().method_72953();
        RenderSystem.restoreProjectionMatrix();
        enabledFlag = 0;
        GofraState.INSTANCE.setModifyBuffer(false);
    }

    private void updateValue() {
        int index = SharedKt.getMc().method_22683().method_4486();
        int index2 = SharedKt.getMc().method_22683().method_4502();
        int index3 = 6;
        int index4 = 0;
        int index5 = 0;
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index5, index4, index3);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, 0.0F, index2, 0.0F).resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(Color.WHITE);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, index, index2, 0.0F).resolveFormatRenderHelper(1.0F, 0.0F).resolveFormatRenderHelper(Color.WHITE);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, index, 0.0F, 0.0F).resolveFormatRenderHelper(1.0F, 1.0F).resolveFormatRenderHelper(Color.WHITE);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, 0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(0.0F, 1.0F).resolveFormatRenderHelper(Color.WHITE);
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline14(), SharedKt.getMc().method_1522(), null, null, null, MapsKt.mapOf(TuplesKt.to("Sampler0", minecraftRef.method_71639())));
    }

    private void render2(DrawContext arg0, float arg1) {
        int index = 0;
        index = 9;
        int index2 = 3;
        int index3 = 0;
        if (index3 < index2) {
            float factor = ((INSTANCE.computeValue2() + (index3 * 17)) + 14);
            int index4 = 9;
            int index5 = 0;
            if (index5 < index4) {
                ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(index);
                if (!(__UNDEF_KEY__)) {
                    if (stack.method_7947() > 1) {
                        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper10(), arg0.method_51448(), String.valueOf(stack.method_7947()), (((arg1 + 2.0F) + (index5 * 16)) + 4.0F), ((factor + 1.5F) + 4.0F), NewThemeRenderHelper.INSTANCE.getColor7(), false);
                    }
                }
                index = (index + 1);
            }
        }
        SFMServiceComponent.resolveFontRenderHelper10().executeAction();
    }

    static {
        INSTANCE = new InventoryWidgetCheckRenderHelperImpl();
    }

}
