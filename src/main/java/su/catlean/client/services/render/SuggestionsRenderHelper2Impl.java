package su.catlean.client.services.render;

import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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

    public SuggestionsRenderHelper2Impl(String arg0, float arg1, SuggestionsServiceComponent arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        if ((arg4 & 4)) {
            arg2 = new SuggestionsServiceComponent(CollectionsKt.emptyList());
        }
        this(arg0, arg1, arg2, arg3);
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
        long var8 = (0L ^ 134444255136690L);
        long var10 = ((0L ^ 122872324218116L) >>> 48);
        long var11 = (((0L ^ 122872324218116L) << 16) >>> 48);
        long var12 = (((0L ^ 122872324218116L) << 32) >>> 32);
        long var13 = (0L ^ 15727589290443L);
        long var15 = (0L ^ 81101117301204L);
        long var17 = (0L ^ 18592005668209L);
        long var19 = (0L ^ 6627968639251L);
        long var21 = ((0L ^ 81010294496925L) >>> 48);
        long var22 = (((0L ^ 81010294496925L) << 16) >>> 32);
        long var23 = (((0L ^ 81010294496925L) << 48) >>> 48);
        if (x <= mouseX) {
        } else {
        }
        if (0L > 0L) {
        }
        if (0L >= 0L) {
            if (var39 != null) {
                if (y <= mouseY) {
                }
            }
        } else {
        }
        if (mouseX <= (x + (this.factorValue - 88.0F)) && mouseY <= (y + 13.0F)) {
            Iterable var41 = (Iterable) CatleanPanelScreenGuiElement.INSTANCE.getSet();
            int var42 = 0;
            if (var41 instanceof Collection && (Collection) var41.isEmpty()) {
            } else {
                if (var43.hasNext()) {
                    Object var44 = var43.next();
                    RenderHelper3 var45 = (RenderHelper3) var44;
                    int var46 = 0;
                } else {
                }
            }
            if (0L >= 0L) {
                if (1) {
                }
            }
        } else {
        }
        }
        if (0L >= 0L) {
            CatleanPanelScreenGuiElement.INSTANCE.updateValue(this);
        }
        int var25 = 14336;
        float var26 = 0.0F;
        float var27 = 0.0F;
        float var28 = 0.0F;
        Color var29 = NewThemeRenderHelper.INSTANCE.getColor6();
        Color var30 = NewThemeRenderHelper.INSTANCE.getColor5().darker();
        float var31 = 1.0F;
        float var32 = 0.0F;
        float var33 = 0.0F;
        float var34 = 2.0F;
        float var35 = 2.0F;
        float var36 = 13.0F;
        float var37 = (this.factorValue - 88.0F);
        float var38 = y;
        StackShaderComponent2.executeAction(x);
        var41 = new Color[1];
        var41[0] = new Color(1157627903, 1);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + 30.0F), (y + 2.0F), 0.5F, 9.0F);
        SFMServiceComponent.resolveFontRenderHelper().render(context, this.textValue, (x + 14.0F), (y + 5.5F), Color.WHITE);
        var41 = this.suggestionsServiceComponent.resolveString(this.getString2());
        var42 = (CharSequence) var41;
        if (0L >= 0L) {
            if (var42 != null) {
            }
            if (!(var42.length())) {
            }
        } else {
        }
        if (!(0)) {
            SFMServiceComponent.resolveFontRenderHelper().render(context, (x + 38.0F), y, PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.5F));
        }
        if (this.getString2().length() > 26) {
        } else {
        }
        var42 = this.getString2();
        if (0L >= 0L && var39 != null) {
        }
        if (0L > 0L) {
            if (!(var40)) {
            }
            if (0L >= 0L) {
                if (!(StringsKt.contains$default((CharSequence) this.textValue, (CharSequence) "Login"))) {
                    if (0L >= 0L) {
                        if (StringsKt.contains$default((CharSequence) this.textValue, (CharSequence) "Pass")) {
                        }
                    }
                }
            } else {
            }
        }
        }
        "**************".render(("|" + ""), (x + 38.0F), (y + 0.5F), Color.WHITE);
    }

    public boolean checkCondition(float x, float y) {
        return false;
    }

    public Unit resolveUnit() {
        if (var10 != null) {
            if (this.suggestionsServiceComponent.resolveString(this.getString2()) != null) {
                String var11 = this.suggestionsServiceComponent.resolveString(this.getString2());
                int var12 = 0;
                this.executeAction();
            } else {
            }
        }
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
