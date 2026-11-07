package su.catlean.client.services.render;

import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.DrawContext;
import su.catlean.SharedKt;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent7;
import su.catlean.client.services.client.SuggestionsServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.ui.clickgui.CatleanPanelScreenGuiElement;

public class SuggestionsRenderHelper2Impl extends RenderHelper2 {

    public static final ServiceComponent7 serviceComponent7;
    private final String textValue;
    private float factorValue;
    private SuggestionsServiceComponent suggestionsServiceComponent;
    private final Function1 function1;
    private String textValue2;
    private static SuggestionsRenderHelper2Impl INSTANCE;

    public SuggestionsRenderHelper2Impl(String name, float width, SuggestionsServiceComponent suggestions, Function1 onChange) {
        super();
        this.textValue = name;
        this.factorValue = width;
        this.suggestionsServiceComponent = suggestions;
        this.function1 = onChange;
        this.textValue2 = "";
    }

    public String getString() {
        return this.textValue;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public SuggestionsServiceComponent getSuggestionsServiceComponent() {
        return this.suggestionsServiceComponent;
    }

    public void executeAction(SuggestionsServiceComponent value) {
        this.suggestionsServiceComponent = value;
    }

    public String getString2() {
        return this.textValue2;
    }

    public void executeAction(String value) {
        this.textValue2 = value;
        this.function1.invoke(this);
    }

    public void render(DrawContext context, float x, float y, float mouseX, float mouseY) {
        if (x <= mouseX) {
        } else {
        }
        if (y <= mouseY) {
        } else {
            if (mouseX <= (x + (this.factorValue - 88.0F)) && mouseY <= (y + 13.0F)) {
                Iterable iterable = ((Iterable) CatleanPanelScreenGuiElement.INSTANCE.getSet());
                int index = 0;
                if (iterable instanceof Collection && ((Collection) iterable).isEmpty()) {
                } else {
                    while (this.hasNext()) {
                        Object element = this.next();
                        RenderHelper3 renderHelper3 = ((RenderHelper3) element);
                    }
                }
            } else {
            }
        }
        CatleanPanelScreenGuiElement.INSTANCE.updateValue(this);
        int index2 = 14336;
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
        StackShaderComponent2.executeAction(x, y, factor10, factor9, factor8, factor7, factor6, factor5, factor4, color2, color, factor3, factor2, factor, index2);
        iterable = new Color[1];
        iterable[0] = new Color(1157627903, true);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + 30.0F), (y + 2.0F), 0.5F, 9.0F, iterable);
        SFMServiceComponent.resolveFontRenderHelper().render(context, this.textValue, (x + 14.0F), (y + 5.5F), Color.WHITE);
        iterable = this.suggestionsServiceComponent.resolveString(this.getString2());
        index = ((CharSequence) iterable);
        if (index != null) {
            if (!(index.length())) {
            } else {
            }
        }
        if (!(0)) {
            SFMServiceComponent.resolveFontRenderHelper().render(context, iterable, (x + 38.0F), y, PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.5F));
        }
        if (this.getString2().length() > 26) {
        } else {
        }
        index = this.getString2();
        if (!(StringsKt.contains$default(((CharSequence) this.textValue), ((CharSequence) "Login"), false))) {
            if (StringsKt.contains$default(((CharSequence) this.textValue), ((CharSequence) "Pass"), false)) {
            } else {
            }
        }
        "**************".render(index, ("|" + ""), (x + 38.0F), (y + 0.5F), Color.WHITE);
    }

    public boolean checkCondition(float x, float y) {
        return false;
    }

    public Unit resolveUnit() {
        this.executeAction();
        return null;
    }

    public static SuggestionsRenderHelper2Impl getSuggestionsRenderHelper2Impl() {
        return INSTANCE;
    }

    public static void updateValue(SuggestionsRenderHelper2Impl value) {
        INSTANCE = value;
    }

    static {
        serviceComponent7 = new ServiceComponent7();
    }

}
