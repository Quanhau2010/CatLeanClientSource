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
        long var4 = (0L ^ 73719739740194L);
        long var6 = ((0L ^ 104104530525409L) >>> 48);
        long var7 = (((0L ^ 104104530525409L) << 16) >>> 32);
        long var8 = (((0L ^ 104104530525409L) << 48) >>> 48);
        long var9 = (0L ^ 25262470473906L);
        long var11 = (0L ^ 50910300018319L);
        long var13 = (0L ^ 128377113661390L);
        long var15 = (0L ^ 122759580220691L);
        long var17 = (0L ^ 23238624456863L);
        long var19 = (0L ^ 30591967126976L);
        long var21 = (0L ^ 118028023098805L);
        if (minecraftRef == null) {
            minecraftRef = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        if (0L > 0L) {
            if (SharedKt.getMc().method_1522().field_1482 == minecraftRef.field_1482) {
            }
            if (SharedKt.getMc().method_1522().field_1481 != minecraftRef.field_1481) {
            }
            minecraftRef.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        String var24 = "Inventory";
        float var25 = this.computeValue();
        CheckRenderHelper.executeAction(this, context.method_51448(), this.computeValue2(), 145.0F, 13.0F, 0.0F);
        Color[] var26 = new Color[1];
        var26[0] = new Color(1157627903, 1);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (var25 + 14), (this.computeValue2() + 3.0F), 0.5F, 7.5F);
        CheckRenderHelper.executeAction(this, this.getMissingnoRenderHelper(), context.method_51448(), (var25 + 2.0F), this.computeValue2(), 10.0F, 10.0F, 0.0F);
        this.render(context, (var25 + 18.0F), (this.computeValue2() + 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        var26 = 0;
        var26 = 9;
        int var27 = 3;
        int var28 = 0;
        if (var28 < var27) {
            int var29 = var28;
            int var30 = 0;
            float var31 = ((INSTANCE.computeValue2() + (var29 * 17)) + 14);
            CheckRenderHelper.executeAction(INSTANCE, context.method_51448(), 145.0F, 16.0F, 0.0F);
            int var32 = 9;
            if (0L >= 0L) {
            }
            int var33 = 0;
            if (var33 < var32) {
                int var34 = var33;
                int var35 = 0;
                if (!(var23)) {
                    if (var34 < 8) {
                        CheckRenderHelper.executeAction(INSTANCE, context.method_51448(), ((var25 + 16) + (var34 * 16)), (var31 + 4.0F), 0.0F);
                    }
                }
                var26 = (var26 + 1);
            }
        }
        this.render(context);
        this.executeAction(145.0F, 70.0F);
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 96852611647315L);
        long var6 = (0L ^ 99437811927052L);
        long var8 = (0L ^ 98664999447709L);
        this.updateValue();
        this.render2(context, this.computeValue());
    }

    private void render(DrawContext arg0, long arg1, float arg2) {
        if ((SharedKt.getNumericValue() - timestampValue) < timestampValue2 && !(Intrinsics.areEqual(POSITIONCOLORRenderHelper.INSTANCE.getCheckRenderHelper(), this))) {
            return;
        }
        timestampValue = SharedKt.getNumericValue();
        GofraState.INSTANCE.setModifyBuffer(1);
        enabledFlag = 1;
        RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(minecraftRef.method_30277(), 0, minecraftRef.method_30278(), 1.0D);
        MatrixStack matrices = new MatrixStack();
        RenderSystem.backupProjectionMatrix();
        RenderSystem.setProjectionMatrix((GameRendererAccessor) SharedKt.getMc().field_1773.getLevelProjectionMatrixBuffer().method_71123(new Matrix4f().identity().setOrtho(0.0F, SharedKt.getMc().method_22683().method_4486(), SharedKt.getMc().method_22683().method_4502(), 0.0F, -160.0F, 160.0F)), RenderSystem.getProjectionType());
        SharedKt.getMc().field_1773.method_71114().method_71034(class_11274.field_60026);
        int var15 = 0;
        var15 = 9;
        int var16 = 3;
        int var17 = 0;
        if (var17 < var16) {
            int var18 = var17;
            int var19 = 0;
            float var20 = ((INSTANCE.computeValue2() + (var18 * 17)) + 14);
            int var21 = 9;
            int var22 = 0;
            if (var22 < var21) {
                int var23 = var22;
                int var24 = 0;
                ItemStack stack = SharedKt.getPlayer().method_31548().method_5438();
                matrices.method_22903();
                matrices.method_46416(((arg2 + 2.5F) + (var23 * 16)), (var20 + 2.5F), 0.0F);
                matrices.method_22905(0.75F, 0.75F, 1.0F);
                PolygonShaderComponent.INSTANCE.render(matrices, stack);
                matrices.method_22909();
                var15 = (var15 + 1);
            }
        }
        SharedKt.getMc().field_1773.method_72911().method_73002();
        SharedKt.getMc().method_22940().method_23000().method_22993();
        SharedKt.getMc().field_1773.method_72910().method_72953();
        RenderSystem.restoreProjectionMatrix();
        enabledFlag = 0;
        GofraState.INSTANCE.setModifyBuffer(0);
    }

    private void updateValue() {
        int var20 = SharedKt.getMc().method_22683().method_4486();
        int var21 = SharedKt.getMc().method_22683().method_4502();
        int var16 = 6;
        int var17 = 0;
        int var18 = 0;
        VertexFormat var19 = class_290.field_1575;
        FormatRenderHelper var22 = new FormatRenderHelper();
        FormatRenderHelper.resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(Color.WHITE);
        FormatRenderHelper.resolveFormatRenderHelper(0.0F, 4, null).resolveFormatRenderHelper(1.0F, 0.0F).resolveFormatRenderHelper(Color.WHITE);
        FormatRenderHelper.resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(1.0F, 1.0F).resolveFormatRenderHelper(Color.WHITE);
        FormatRenderHelper.resolveFormatRenderHelper(0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(0.0F, 1.0F).resolveFormatRenderHelper(Color.WHITE);
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline14(), SharedKt.getMc().method_1522(), null, null, null, MapsKt.mapOf(TuplesKt.to("Sampler0", minecraftRef.method_71639())));
    }

    private void render2(DrawContext arg0, float arg1) {
        int var17 = 0;
        var17 = 9;
        int var18 = 3;
        int var19 = 0;
        if (var19 < var18) {
            int var20 = var19;
            int var21 = 0;
            float var22 = ((INSTANCE.computeValue2() + (var20 * 17)) + 14);
            int var23 = 9;
            int var24 = 0;
            if (var24 < var23) {
                int var25 = var24;
                int var26 = 0;
                ItemStack stack = SharedKt.getPlayer().method_31548().method_5438();
                if (!(var16)) {
                    if (stack.method_7947() > 1) {
                        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper10(), arg0.method_51448(), String.valueOf(stack.method_7947()), (((arg1 + 2.0F) + (var25 * 16)) + 4.0F), ((var22 + 1.5F) + 4.0F), NewThemeRenderHelper.INSTANCE.getColor7());
                    }
                }
                var17 = (var17 + 1);
            }
        }
        SFMServiceComponent.resolveFontRenderHelper10().executeAction();
    }

    static {
        INSTANCE = new InventoryWidgetCheckRenderHelperImpl();
    }

}
