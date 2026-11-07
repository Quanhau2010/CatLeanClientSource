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
        if (x <= mouseX) {
        } else {
        }
        if (y <= mouseY) {
        } else {
        }
        this.kMutableProperty02.set(this);
        int index = 14336;
        float factor = 0.0F;
        float factor2 = 0.0F;
        float factor3 = 0.0F;
        Color color = NewThemeRenderHelper.INSTANCE.getColor6();
        Color color2 = NewThemeRenderHelper.INSTANCE.getColor5().darker();
        float factor4 = 1.0F;
        float factor5 = 0.0F;
        float factor6 = 0.0F;
        float factor7 = 2.0F;
        float factor8 = 2.0F;
        float factor9 = 13.0F;
        float factor10 = (this.factorValue - 88.0F);
        StackShaderComponent2.executeAction(x, y, factor10, factor9, factor8, factor7, factor6, factor5, factor4, color2, color, factor3, factor2, factor, index);
        Color[] items = new Color[1];
        items[0] = new Color(1157627903, true);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + ((this.factorValue - 88.0F) / 2.0F)), (y + 2.0F), 0.5F, 9.0F, items);
        if (((Boolean) this.kMutableProperty0.get())) {
        } else {
        }
        items = Color.WHITE;
        context.render(this.textValue, (x + ((this.factorValue - 88.0F) * 0.25F)), (y + 5.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.5F), items);
        if (!(((Boolean) this.kMutableProperty0.get()))) {
        } else {
        }
        items = Color.WHITE;
        context.render(this.textValue2, (x + ((this.factorValue - 88.0F) * 0.75F)), (y + 5.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.5F), items);
    }

    public boolean checkCondition(float x, float y) {
        this.kMutableProperty0.set(Boolean.valueOf(!(((Boolean) this.kMutableProperty0.get()))));
        return false;
    }

}
