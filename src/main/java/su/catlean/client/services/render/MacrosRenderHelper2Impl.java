package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;
import su.catlean.api.contracts.Contract8;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.NoneServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.config.models.IdRecord;
import su.catlean.client.services.client.config.models.IdRecord9;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class MacrosRenderHelper2Impl extends RenderHelper2 {

    private Contract8 contract8;
    private final EasingServiceComponent easingServiceComponent;
    private static boolean enabledFlag;

    public MacrosRenderHelper2Impl(Contract8 macros) {
        super();
        this.contract8 = macros;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, timestampValue);
    }

    public Contract8 getContract8() {
        return this.contract8;
    }

    public void executeAction(Contract8 value) {
        this.contract8 = value;
    }

    public void render(DrawContext context, float x, float y, float mouseX, float mouseY) {
        if (x <= mouseX) {
        } else {
        }
        if (y <= mouseY) {
        } else {
        }
        this.updateValue2(MacroPanelRenderHelper3Impl.INSTANCE.getRenderHelper22());
        this.executeAction(0.0F);
        if (this.contract8.isActive()) {
        } else {
        }
        Color color = NewThemeRenderHelper.INSTANCE.getColor10().resolveColor(NewThemeRenderHelper.INSTANCE.getColor11(), 1.0F, 0.0F);
        if (this.contract8.isActive()) {
        } else {
        }
        Color color2 = NewThemeRenderHelper.INSTANCE.getColor13().resolveColor(NewThemeRenderHelper.INSTANCE.getColor12(), 1.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 4.0F), y, 70.0F, 25.0F, 2.0F, (2.5F + this.easingServiceComponent.getNumericValue()), 1.0F, 1.0F, color, color2, 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 54.0F), (y + 5.0F), 15.0F, 15.0F, 2.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        float factor = (x + 54.0F);
        if (mouseX <= (x + 69.0F)) {
        } else {
            if (factor <= mouseX) {
                factor = (y + 5.0F);
                if (mouseY <= (y + 20.0F)) {
                } else {
                    if (factor <= mouseY) {
                        MacroPanelRenderHelper3Impl.INSTANCE.updateValue(true);
                    }
                }
            }
        }
        SFMServiceComponent.resolveFontRenderHelper().render(context, this.contract8.getString(), (x + 6.0F), y, Color.WHITE);
        Contract8 contract8 = this.contract8;
        if (contract8 instanceof IdRecord9) {
        } else {
            if (contract8 instanceof IdRecord) {
            } else {
            }
        }
        factor = "setting";
        SFMServiceComponent.resolveFontRenderHelper().render(context, factor, (x + 6.0F), (y + 11.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.7F));
        context.method_51448().pushMatrix();
        contract8 = NoneServiceComponent.INSTANCE.resolveString(this.contract8.getKeyRecord().getNumericValue());
        Contract8 contract82 = contract8;
        if (contract8.length() > 1) {
            context.method_51448().translate(((x + 54.0F) + 7.5F), ((y + 5.0F) + 7.5F));
            context.method_51448().scale(0.5F, 0.5F);
            context.method_51448().translate(((x + 54.0F) + 7.5F), ((y + 5.0F) + 7.5F));
            if (contract8.length() > 5) {
                contract82 = contract8.substring(0, 4);
            }
        }
        if (Intrinsics.areEqual(MacroPanelRenderHelper3Impl.INSTANCE.getMacrosRenderHelper2Impl2(), this)) {
        } else {
        }
        context.render(StringsKt.dropLast("...", (3 - (4 * ((System.currentTimeMillis() % 700) / 700.0D)))), contract82, (x + 61.5F), (y + 11.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.7F));
        context.method_51448().popMatrix();
    }

    public boolean checkCondition(float x, float y) {
        return false;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
