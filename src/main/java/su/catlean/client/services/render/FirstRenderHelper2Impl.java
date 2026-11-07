package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.reflect.KMutableProperty0;
import net.minecraft.client.gui.DrawContext;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;

public class FirstRenderHelper2Impl extends RenderHelper2 {

    private final float factorValue;
    private String textValue;
    private String textValue2;
    private KMutableProperty0 kMutableProperty0;
    private KMutableProperty0 kMutableProperty02;

    public FirstRenderHelper2Impl(float width, String first, String second, KMutableProperty0 ref, KMutableProperty0 hoverRef) {
        super();
        this.factorValue = width;
        this.textValue = first;
        this.textValue2 = second;
        this.kMutableProperty0 = ref;
        this.kMutableProperty02 = hoverRef;
    }

    public void render(DrawContext context, float x, float y, float mouseX, float mouseY) {
        long var8 = ((0L ^ 122872324218116L) >>> 48);
        long var9 = (((0L ^ 122872324218116L) << 16) >>> 48);
        long var10 = (((0L ^ 122872324218116L) << 32) >>> 32);
        long var11 = (0L ^ 81101117301204L);
        long var13 = (0L ^ 18592005668209L);
        long var15 = (0L ^ 6627968639251L);
        long var17 = ((0L ^ 81010294496925L) >>> 48);
        long var18 = (((0L ^ 81010294496925L) << 16) >>> 32);
        long var19 = (((0L ^ 81010294496925L) << 48) >>> 48);
        if (x <= mouseX) {
        } else {
        }
        if (0L > 0L) {
        }
        if (0L >= 0L) {
            if (var35 != null) {
                if (y <= mouseY) {
                }
            }
        } else {
        }
        if (0L > 0L) {
            if (mouseX <= (x + (this.factorValue - 88.0F)) && mouseY <= (y + 13.0F)) {
            }
        } else {
        }
        if (0L >= 0L) {
            this.kMutableProperty02.set(this);
        }
        int var21 = 14336;
        float var22 = 0.0F;
        float var23 = 0.0F;
        float var24 = 0.0F;
        Color var25 = NewThemeRenderHelper.INSTANCE.getColor6();
        Color var26 = NewThemeRenderHelper.INSTANCE.getColor5().darker();
        float var27 = 1.0F;
        float var28 = 0.0F;
        float var29 = 0.0F;
        float var30 = 2.0F;
        float var31 = 2.0F;
        float var32 = 13.0F;
        float var33 = (this.factorValue - 88.0F);
        float var34 = y;
        StackShaderComponent2.executeAction(x);
        Color[] var37 = new Color[1];
        var37[0] = new Color(1157627903, 1);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + ((this.factorValue - 88.0F) / 2.0F)), (y + 2.0F), 0.5F, 9.0F);
        if ((Boolean) this.kMutableProperty0.get()) {
        } else {
        }
        var37 = Color.WHITE;
        if (0L > 0L) {
            context.render(this.textValue, (x + ((this.factorValue - 88.0F) * 0.25F)), (y + 5.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.5F));
        }
        if (!((Boolean) this.kMutableProperty0.get())) {
        } else {
        }
        var37 = Color.WHITE;
        context.render(this.textValue2, (x + ((this.factorValue - 88.0F) * 0.75F)), (y + 5.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.5F));
    }

    public boolean checkCondition(float x, float y) {
        this.kMutableProperty0.set(Boolean.valueOf(!((Boolean) this.kMutableProperty0.get())));
        return false;
    }

}
