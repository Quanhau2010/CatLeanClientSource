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
        Color color = NewThemeRenderHelper.INSTANCE.resolveColor(0);
        int index = (SharedKt.getMc().method_22683().method_4486() / 2.0F);
        int index2 = (SharedKt.getMc().method_22683().method_4502() / 2.0F);
        float factor = ((3.0F - (SharedKt.getMc().player.method_7261(0.5F) * 3.0F)) + RangesKt.coerceIn((EventPacketHelper2.INSTANCE.getNumericValue() * 10.0F), 0.0F, 3.0F));
        float factor2 = (PolygonShaderComponent.INSTANCE.computeValue(factorValue, factor, PolygonShaderComponent.INSTANCE.computeValue()) + 7.0F);
        factorValue = factor;
        int index3 = 4;
        int index4 = 0;
        int index5 = 8;
        VertexFormat vertexFormat = class_290.field_1576;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index5, index4, index3);
        Color[] items = new Color[1];
        items[0] = Color.BLACK;
        PolygonShaderComponent.INSTANCE.executeAction(formatRenderHelper, (index - 1.0F), ((index2 - 6.0F) + factor2), 2.0F, 4.0F, items);
        items = new Color[1];
        items[0] = color;
        PolygonShaderComponent.INSTANCE.executeAction(formatRenderHelper, (index - 0.5F), ((index2 - 5.5F) + factor2), 1.0F, 3.0F, items);
        items = new Color[1];
        items[0] = Color.BLACK;
        PolygonShaderComponent.INSTANCE.executeAction(formatRenderHelper, (index - 1.0F), ((index2 + 2.0F) - factor2), 2.0F, 4.0F, items);
        items = new Color[1];
        items[0] = color;
        PolygonShaderComponent.INSTANCE.executeAction(formatRenderHelper, (index - 0.5F), ((index2 + 2.5F) - factor2), 1.0F, 3.0F, items);
        items = new Color[1];
        items[0] = Color.BLACK;
        PolygonShaderComponent.INSTANCE.executeAction(formatRenderHelper, ((index - 6.0F) + factor2), (index2 - 1.0F), 4.0F, 2.0F, items);
        items = new Color[1];
        items[0] = color;
        PolygonShaderComponent.INSTANCE.executeAction(formatRenderHelper, ((index - 5.5F) + factor2), (index2 - 0.5F), 3.0F, 1.0F, items);
        items = new Color[1];
        items[0] = Color.BLACK;
        PolygonShaderComponent.INSTANCE.executeAction(formatRenderHelper, ((index + 2.0F) - factor2), (index2 - 1.0F), 4.0F, 2.0F, items);
        items = new Color[1];
        items[0] = color;
        PolygonShaderComponent.INSTANCE.executeAction(formatRenderHelper, ((index + 2.5F) - factor2), (index2 - 0.5F), 3.0F, 1.0F, items);
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, null, new Matrix3x2f(((Matrix3x2fc) context.method_51448())));
    }

    static {
        INSTANCE = new CrosshairRenderHelper();
    }

}
