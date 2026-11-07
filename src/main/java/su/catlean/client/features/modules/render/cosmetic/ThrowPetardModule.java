package su.catlean.client.features.modules.render.cosmetic;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import net.minecraft.class_239.class_240;
import net.minecraft.class_290;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3965;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_6880.class_6883;
import net.minecraft.class_757;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.TexRenderHelper;
import su.catlean.client.services.render.shader.POSITIONTEXCOLORShaderComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;

public class ThrowPetardModule extends Module {

    public static final ThrowPetardModule INSTANCE;
    private static float factorValue;
    private static float factorValue2;
    private static float factorValue3;
    private static float factorValue4;
    private static float factorValue5;
    private static float factorValue6;
    private static float factorValue7;
    private static float factorValue8;
    private static float factorValue9;
    private static int countValue;

    private ThrowPetardModule() {
        super("throw-petard", SubCategoriesKt.getCosmeticCategory());
    }

    public void updateValue() {
        if (SharedKt.getMc().player == null) {
            return;
        }
        countValue = 0;
        SharedKt.getWorld().method_8486(factorValue, (factorValue2 + 0.5D), factorValue3, class_3417.field_15079, class_3419.field_15245, 0.2F, 1.0F, false);
        factorValue = SharedKt.getPlayer().getEyePos().field_1352;
        factorValue2 = SharedKt.getPlayer().getEyePos().field_1351;
        factorValue3 = SharedKt.getPlayer().getEyePos().field_1350;
        factorValue7 = SharedKt.getPlayer().method_5720().field_1352;
        factorValue8 = ((SharedKt.getPlayer().method_5720().field_1351 + 0.42F) + SharedKt.getPlayer().method_18798().field_1351);
        factorValue9 = SharedKt.getPlayer().method_5720().field_1350;
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        factorValue4 = factorValue;
        factorValue5 = factorValue2;
        factorValue6 = factorValue3;
        factorValue = (factorValue + factorValue7);
        factorValue2 = (factorValue2 + factorValue8);
        factorValue3 = (factorValue3 + factorValue9);
        factorValue7 = (factorValue7 * 0.98F);
        factorValue8 = (factorValue8 * 0.98F);
        factorValue9 = (factorValue9 * 0.98F);
        class_3965 class3965 = ExplosionPosEntityHelper.resolveMinecraftObject(new Vec3d(factorValue, factorValue2, factorValue3), new Vec3d(factorValue4, factorValue5, factorValue6), false, null, false);
        if (class3965 != null) {
        } else {
        }
        factorValue = factorValue4;
        if (class3965 != null && class3965.method_17777() != null && class3965.method_17777().up() != null) {
        } else {
            class3965.method_17777().up().method_10264();
        }
        factorValue2 = factorValue5;
        factorValue3 = factorValue6;
        factorValue7 = (factorValue7 * 0.81F);
        factorValue9 = (factorValue9 * 0.81F);
        factorValue8 = (factorValue8 - 0.08F);
        int index = countValue;
        countValue = (index + 1);
        index = 3;
        int index2 = 0;
        if (index2 < index) {
            int index3 = index2;
            int index4 = 0;
            POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(HitFxParticleMode.STAR.getOptionMode6(), (Math.random() * 50.0F), 0.2F, 5, null, 0.0F, 0.0F, false));
        }
        index = (360 + 180.0F);
        this.updateValue2();
        SharedKt.getWorld().method_8486(factorValue, (factorValue2 + 0.5D), factorValue3, ((class_3414) class_3417.field_15152.comp_349()), class_3419.field_15245, 0.2F, 1.0F, false);
        index3 = 100;
        index4 = 0;
        POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(HitFxParticleMode.STAR.getOptionMode6(), (Math.random() * 50.0F), 0.5F, 20, null, 0.0F, 0.0F, false));
        POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(HitFxParticleMode.FIRE_FLY.getOptionMode6(), (Math.random() * 50.0F), 0.3F, 20, null, 0.0F, 0.0F, false));
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        float factor = PolygonShaderComponent.INSTANCE.computeValue(factorValue4, factorValue, PolygonShaderComponent.INSTANCE.computeValue());
        float factor2 = PolygonShaderComponent.INSTANCE.computeValue(factorValue5, factorValue2, PolygonShaderComponent.INSTANCE.computeValue());
        float factor3 = PolygonShaderComponent.INSTANCE.computeValue(factorValue6, factorValue3, PolygonShaderComponent.INSTANCE.computeValue());
        arg0.getStack().method_22903();
        arg0.getStack().method_22904((factor - class4184.method_71156().field_1352), (factor2 - class4184.method_71156().field_1351), (factor3 - class4184.method_71156().field_1350));
        this.render(arg0.getStack(), 0.0F, 0.0F, 0.0F);
        arg0.getStack().method_22909();
    }

    public void render(MatrixStack matrices, float x, float y, float z) {
        Matrix4f matrix4f = matrices.method_23760().method_23761();
        int index = 4;
        int index2 = 0;
        int index3 = 48;
        VertexFormat vertexFormat = class_290.field_1576;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        float factor = 0.12F;
        float factor2 = 0.5F;
        float factor3 = 0.2F;
        int index4 = 16;
        int index5 = 0;
        if (index5 < index4) {
            double offset = ((6.283185307179586D * index5) / index4);
            double offset2 = ((6.283185307179586D * (index5 + 1)) / index4);
            float factor4 = (x + (Math.cos(offset) * factor));
            float factor5 = (z + (Math.sin(offset) * factor));
            float factor6 = (x + (Math.cos(offset2) * factor));
            if (__UNDEF_KEY__ != null) {
                float factor7 = (z + (Math.sin(offset2) * factor));
                Color color = Color.DARK_GRAY;
                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor4, y, factor5).resolveFormatRenderHelper(color);
                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor4, (y + factor2), factor5).resolveFormatRenderHelper(color);
                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor6, (y + factor2), factor7).resolveFormatRenderHelper(color);
                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor6, y, factor7).resolveFormatRenderHelper(color);
            }
        }
        index5 = ((y + (factor2 / 2)) - (factor3 / 2));
        offset = 0;
        if (offset < index4) {
            offset2 = ((6.283185307179586D * offset) / index4);
            factor4 = ((6.283185307179586D * (offset + 1)) / index4);
            factor5 = (x + (Math.cos(offset2) * (factor + 0.01F)));
            factor6 = (z + (Math.sin(offset2) * (factor + 0.01F)));
            factor7 = (x + (Math.cos(factor4) * (factor + 0.01F)));
            if (__UNDEF_KEY__ != null) {
                color = (z + (Math.sin(factor4) * (factor + 0.01F)));
                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor5, index5, factor6).resolveFormatRenderHelper(Color.WHITE);
                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor5, (index5 + factor3), factor6).resolveFormatRenderHelper(Color.WHITE);
                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor7, (index5 + factor3), color).resolveFormatRenderHelper(Color.WHITE);
                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor7, index5, color).resolveFormatRenderHelper(Color.WHITE);
            }
        }
        offset = 0.06F;
        offset2 = 0.03F;
        formatRenderHelper.resolveFormatRenderHelper(matrix4f, (x - offset2), ((y + factor2) + offset), (z - offset2)).resolveFormatRenderHelper(Color.BLACK);
        formatRenderHelper.resolveFormatRenderHelper(matrix4f, (x - offset2), (y + factor2), (z - offset2)).resolveFormatRenderHelper(Color.BLACK);
        formatRenderHelper.resolveFormatRenderHelper(matrix4f, (x + offset2), (y + factor2), (z + offset2)).resolveFormatRenderHelper(Color.BLACK);
        formatRenderHelper.resolveFormatRenderHelper(matrix4f, (x + offset2), ((y + factor2) + offset), (z + offset2)).resolveFormatRenderHelper(Color.BLACK);
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, matrices.method_23760().method_23761());
    }

    static {
        INSTANCE = new ThrowPetardModule();
    }

}
