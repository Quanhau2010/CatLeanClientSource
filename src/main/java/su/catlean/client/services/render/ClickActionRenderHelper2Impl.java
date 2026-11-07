package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KMutableProperty0;
import net.minecraft.client.gui.DrawContext;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;

public class ClickActionRenderHelper2Impl extends RenderHelper2 {

    private Function0 function0;
    private float factorValue;
    private KMutableProperty0 kMutableProperty0;

    public ClickActionRenderHelper2Impl(Function0 clickAction, float width, KMutableProperty0 hoverRef) {
        super();
        this.function0 = clickAction;
        this.factorValue = width;
        this.kMutableProperty0 = hoverRef;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public void render(DrawContext context, float x, float y, float mouseX, float mouseY) {
        long var8 = ((0L ^ 122872324218116L) >>> 48);
        long var9 = (((0L ^ 122872324218116L) << 16) >>> 48);
        long var10 = (((0L ^ 122872324218116L) << 32) >>> 32);
        long var11 = (0L ^ 81101117301204L);
        long var13 = (0L ^ 18592005668209L);
        long var15 = ((0L ^ 81010294496925L) >>> 48);
        long var16 = (((0L ^ 81010294496925L) << 16) >>> 32);
        long var17 = (((0L ^ 81010294496925L) << 48) >>> 48);
        if (x <= mouseX) {
        } else {
        }
        if (0L >= 0L) {
        }
        if (0L >= 0L) {
            if (var33 != null) {
                if (y <= mouseY) {
                }
            }
        } else {
        }
        if (0L >= 0L) {
            if (mouseX <= (x + (this.factorValue - 88.0F)) && mouseY <= (y + 13.0F)) {
            }
        } else {
        }
        if (0L > 0L) {
            this.kMutableProperty0.set(this);
        }
        long var19 = 8996027473573459968L;
        float var20 = 0.0F;
        float var21 = 0.0F;
        float var22 = 0.0F;
        Color var23 = Color.RED;
        Color var24 = PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, 0.5F);
        float var25 = 1.0F;
        float var26 = 0.1F;
        float var27 = 1.0F;
        float var28 = 2.0F;
        float var29 = 2.0F;
        float var30 = 13.0F;
        float var31 = (this.factorValue - 88.0F);
        float var32 = y;
        StackShaderComponent2.executeAction(x);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "Delete", (x + ((this.factorValue - 88.0F) / 2.0F)), (y + 5.0F), Color.WHITE);
    }

    public boolean checkCondition(float x, float y) {
        this.function0.invoke();
        return true;
    }

}
