package su.catlean.client.services.render;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import kotlin.ranges.RangesKt;
import net.minecraft.class_1041;
import net.minecraft.class_290;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fc;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;

public class CrosshairRenderHelper extends CheckRenderHelper {

    public static final CrosshairRenderHelper INSTANCE;
    private static float factorValue;

    private CrosshairRenderHelper() {
        super("crosshair");
    }

    public float getNumericValue() {
        return factorValue;
    }

    public void updateValue(float value) {
        factorValue = value;
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 73719739740194L);
        long var6 = (0L ^ 34973642043217L);
        long var8 = (0L ^ 17946477735558L);
        long var10 = (0L ^ 80556358892348L);
        long var12 = (0L ^ 41533572548145L);
        long var14 = (0L ^ 20494741382199L);
        Color var22 = NewThemeRenderHelper.INSTANCE.resolveColor(0);
        int var23 = (SharedKt.getMc().method_22683().method_4486() / 2.0F);
        int var24 = (SharedKt.getMc().method_22683().method_4502() / 2.0F);
        float var25 = ((3.0F - (SharedKt.getMc().player.method_7261(0.5F) * 3.0F)) + RangesKt.coerceIn((EventPacketHelper2.INSTANCE.getNumericValue() * 10.0F), 0.0F, 3.0F));
        float var26 = (PolygonShaderComponent.INSTANCE.computeValue(factorValue, PolygonShaderComponent.INSTANCE.computeValue()) + 7.0F);
        factorValue = var25;
        int var17 = 4;
        int var18 = 0;
        int var19 = 8;
        VertexFormat var20 = class_290.field_1576;
        FormatRenderHelper var27 = new FormatRenderHelper();
        Color[] var28 = new Color[1];
        var28[0] = Color.BLACK;
        PolygonShaderComponent.INSTANCE.executeAction((var23 - 1.0F), ((var24 - 6.0F) + var26), 2.0F, 4.0F);
        var28 = new Color[1];
        var28[0] = var22;
        PolygonShaderComponent.INSTANCE.executeAction((var23 - 0.5F), ((var24 - 5.5F) + var26), 1.0F, 3.0F);
        var28 = new Color[1];
        var28[0] = Color.BLACK;
        PolygonShaderComponent.INSTANCE.executeAction((var23 - 1.0F), ((var24 + 2.0F) - var26), 2.0F, 4.0F);
        var28 = new Color[1];
        var28[0] = var22;
        PolygonShaderComponent.INSTANCE.executeAction((var23 - 0.5F), ((var24 + 2.5F) - var26), 1.0F, 3.0F);
        var28 = new Color[1];
        var28[0] = Color.BLACK;
        PolygonShaderComponent.INSTANCE.executeAction(((var23 - 6.0F) + var26), (var24 - 1.0F), 4.0F, 2.0F);
        var28 = new Color[1];
        var28[0] = var22;
        PolygonShaderComponent.INSTANCE.executeAction(((var23 - 5.5F) + var26), (var24 - 0.5F), 3.0F, 1.0F);
        var28 = new Color[1];
        var28[0] = Color.BLACK;
        PolygonShaderComponent.INSTANCE.executeAction(((var23 + 2.0F) - var26), (var24 - 1.0F), 4.0F, 2.0F);
        var28 = new Color[1];
        var28[0] = var22;
        PolygonShaderComponent.INSTANCE.executeAction(((var23 + 2.5F) - var26), (var24 - 0.5F), 3.0F, 1.0F);
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, null, new Matrix3x2f((Matrix3x2fc) context.method_51448()));
    }

    static {
        INSTANCE = new CrosshairRenderHelper();
    }

}
