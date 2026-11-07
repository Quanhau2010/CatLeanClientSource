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

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 32978412894279L);
        long var5 = (arg0 ^ 69599493015750L);
        long var7 = (arg0 ^ 67464996320865L);
        if (SharedKt.getMc().player == null) {
            return;
        }
        countValue = 0;
        SharedKt.getWorld().method_8486(factorValue, (factorValue2 + 0.5D), factorValue3, class_3417.field_15079, class_3419.field_15245, 0.2F, 1.0F, 0);
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
        class_3965 var17 = ExplosionPosEntityHelper.resolveMinecraftObject(new Vec3d(factorValue, factorValue2, factorValue3), new Vec3d(factorValue4, factorValue5, factorValue6));
        if (var17 != null) {
        } else {
        }
        factorValue = factorValue4;
        if (var17 != null && var17.method_17777() != null && var17.method_17777().up() != null) {
        } else {
            var17.method_17777().up().method_10264();
        }
        factorValue2 = factorValue5;
        factorValue3 = factorValue6;
        factorValue7 = (factorValue7 * 0.81F);
        factorValue9 = (factorValue9 * 0.81F);
        factorValue8 = (factorValue8 - 0.08F);
        int var19 = countValue;
        countValue = (var19 + 1);
        var19 = 3;
        int var20 = 0;
        if (var20 < var19) {
            int var21 = var20;
            int var22 = 0;
            POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(HitFxParticleMode.STAR.getOptionMode6(), new Vec3d(factorValue, (factorValue2 + 0.5D), factorValue3), (Math.random() * 50.0F), 0.2F, 5, new Vec3d(((Math.random() / 4.0F) - 0.125F), (Math.random() / 2.0F), ((Math.random() / 4.0F) - 0.125F)), null, 0.0F, 0.0F));
        }
        var19 = (360 + 180.0F);
        this.updateValue2();
        SharedKt.getWorld().method_8486(factorValue, (factorValue2 + 0.5D), factorValue3, (class_3414) class_3417.field_15152.comp_349(), class_3419.field_15245, 0.2F, 1.0F, 0);
        var21 = 100;
        var22 = 0;
        int var23 = var22;
        int var24 = 0;
        POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(HitFxParticleMode.STAR.getOptionMode6(), new Vec3d(factorValue, (factorValue2 + 0.5D), factorValue3), (Math.random() * 50.0F), 0.5F, 20, new Vec3d(((Math.random() - 0.5D) * 1.5F), Math.random(), ((Math.random() - 0.5D) * 1.5F)), null, 0.0F, 0.0F));
        POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(HitFxParticleMode.FIRE_FLY.getOptionMode6(), new Vec3d(factorValue, (factorValue2 + 0.5D), factorValue3), (Math.random() * 50.0F), 0.3F, 20, new Vec3d(((Math.random() - 0.5D) * 1.5F), Math.random(), ((Math.random() - 0.5D) * 1.5F)), null, 0.0F, 0.0F));
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        class_4184 var11 = SharedKt.getMc().field_1773.method_19418();
        float var12 = PolygonShaderComponent.INSTANCE.computeValue(factorValue4, factorValue, PolygonShaderComponent.INSTANCE.computeValue());
        float var13 = PolygonShaderComponent.INSTANCE.computeValue(factorValue5, factorValue2, PolygonShaderComponent.INSTANCE.computeValue());
        float var14 = PolygonShaderComponent.INSTANCE.computeValue(factorValue6, factorValue3, PolygonShaderComponent.INSTANCE.computeValue());
        arg0.getStack().method_22903();
        arg0.getStack().method_22904((var12 - var11.method_71156().field_1352), (var13 - var11.method_71156().field_1351), (var14 - var11.method_71156().field_1350));
        this.render(arg0.getStack(), 0.0F, 0.0F, 0.0F);
        arg0.getStack().method_22909();
    }

    public void render(MatrixStack matrices, float x, float y, float z) {
        Matrix4f var24 = matrices.method_23760().method_23761();
        int var19 = 4;
        int var20 = 0;
        int var21 = 48;
        VertexFormat var22 = class_290.field_1576;
        FormatRenderHelper var25 = new FormatRenderHelper();
        float var26 = 0.12F;
        float var27 = 0.5F;
        float var28 = 0.2F;
        int var29 = 16;
        int var30 = 0;
        if (var30 < var29) {
            double var31 = ((6.283185307179586D * var30) / var29);
            double var32 = ((6.283185307179586D * (var30 + 1)) / var29);
            float var33 = (x + (Math.cos() * var26));
            float var34 = (z + (Math.sin() * var26));
            float var35 = (x + (Math.cos() * var26));
            if (var23 != null) {
                float var36 = (z + (Math.sin() * var26));
                Color var37 = Color.DARK_GRAY;
                var25.resolveFormatRenderHelper(y).resolveFormatRenderHelper();
                var25.resolveFormatRenderHelper((y + var27)).resolveFormatRenderHelper();
                var25.resolveFormatRenderHelper((y + var27)).resolveFormatRenderHelper();
                var25.resolveFormatRenderHelper(y).resolveFormatRenderHelper();
            }
        }
        var30 = ((y + (var27 / 2)) - (var28 / 2));
        var31 = 0;
        if (var31 < var29) {
            var32 = ((6.283185307179586D * var31) / var29);
            var33 = ((6.283185307179586D * (var31 + 1)) / var29);
            var34 = (x + (Math.cos() * (var26 + 0.01F)));
            var35 = (z + (Math.sin() * (var26 + 0.01F)));
            var36 = (x + (Math.cos() * (var26 + 0.01F)));
            if (var23 != null) {
                var37 = (z + (Math.sin() * (var26 + 0.01F)));
                var25.resolveFormatRenderHelper().resolveFormatRenderHelper(Color.WHITE);
                var25.resolveFormatRenderHelper((var30 + var28)).resolveFormatRenderHelper(Color.WHITE);
                var25.resolveFormatRenderHelper((var30 + var28)).resolveFormatRenderHelper(Color.WHITE);
                var25.resolveFormatRenderHelper().resolveFormatRenderHelper(Color.WHITE);
            }
        }
        var31 = 0.06F;
        var32 = 0.03F;
        var25.resolveFormatRenderHelper((x - var32), ((y + var27) + var31), (z - var32)).resolveFormatRenderHelper(Color.BLACK);
        var25.resolveFormatRenderHelper((x - var32), (y + var27), (z - var32)).resolveFormatRenderHelper(Color.BLACK);
        var25.resolveFormatRenderHelper((x + var32), (y + var27), (z + var32)).resolveFormatRenderHelper(Color.BLACK);
        var25.resolveFormatRenderHelper((x + var32), ((y + var27) + var31), (z + var32)).resolveFormatRenderHelper(Color.BLACK);
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, matrices.method_23760().method_23761());
    }

    static {
        INSTANCE = new ThrowPetardModule();
    }

}
