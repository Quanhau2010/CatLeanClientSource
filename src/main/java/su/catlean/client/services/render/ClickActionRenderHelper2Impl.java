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
        if (x <= mouseX) {
        } else {
        }
        if (y <= mouseY) {
        } else {
        }
        this.kMutableProperty0.set(this);
        int index = 14336;
        float factor = 0.0F;
        float factor2 = 0.0F;
        float factor3 = 0.0F;
        Color color = Color.RED;
        Color color2 = PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, 0.5F);
        float factor4 = 1.0F;
        float factor5 = 0.1F;
        float factor6 = 1.0F;
        float factor7 = 2.0F;
        float factor8 = 2.0F;
        float factor9 = 13.0F;
        float factor10 = (this.factorValue - 88.0F);
        StackShaderComponent2.executeAction(x, y, factor10, factor9, factor8, factor7, factor6, factor5, factor4, color2, color, factor3, factor2, factor, index);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "Delete", (x + ((this.factorValue - 88.0F) / 2.0F)), (y + 5.0F), Color.WHITE);
    }

    public boolean checkCondition(float x, float y) {
        this.function0.invoke();
        return true;
    }

}
