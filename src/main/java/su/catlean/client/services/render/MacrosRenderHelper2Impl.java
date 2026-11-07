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
        long var8 = (0L ^ 127744779498483L);
        long var10 = ((0L ^ 122872324218116L) >>> 48);
        long var11 = (((0L ^ 122872324218116L) << 16) >>> 48);
        long var12 = (((0L ^ 122872324218116L) << 32) >>> 32);
        long var13 = (0L ^ 18569812997841L);
        long var15 = (0L ^ 97956880838355L);
        long var17 = (0L ^ 15727589290443L);
        long var19 = (0L ^ 81101117301204L);
        long var21 = (0L ^ 53580834126530L);
        long var23 = (0L ^ 18592005668209L);
        long var25 = ((0L ^ 81010294496925L) >>> 48);
        long var26 = (((0L ^ 81010294496925L) << 16) >>> 32);
        long var27 = (((0L ^ 81010294496925L) << 48) >>> 48);
        if (x <= mouseX) {
        } else {
        }
        if (0L > 0L) {
        }
        if (0L > 0L) {
            if (!(var28)) {
                if (y <= mouseY) {
                }
            }
        } else {
        }
        if (0L >= 0L) {
            if (mouseX <= (x + 70.0F) && mouseY <= (y + 25.0F)) {
            }
        } else {
        }
        this.updateValue2(MacroPanelRenderHelper3Impl.INSTANCE.getRenderHelper22());
        1.0F.executeAction(0.0F);
        if (this.contract8.isActive()) {
        } else {
        }
        Color var30 = NewThemeRenderHelper.INSTANCE.getColor10().resolveColor(NewThemeRenderHelper.INSTANCE.getColor11(), 1.0F, 0.0F);
        if (this.contract8.isActive()) {
        } else {
        }
        Color var31 = NewThemeRenderHelper.INSTANCE.getColor13().resolveColor(NewThemeRenderHelper.INSTANCE.getColor12(), 1.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 4.0F), y, 70.0F, 25.0F, 2.0F, (2.5F + this.easingServiceComponent.getNumericValue()), 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 54.0F), (y + 5.0F), 15.0F, 15.0F, 2.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        float var32 = (x + 54.0F);
        if (0L >= 0L && !(var28)) {
            if (mouseX <= (x + 69.0F)) {
            }
        } else {
        }
        if (var32 <= mouseX) {
            var32 = (y + 5.0F);
            if (0L >= 0L && !(var28)) {
                if (mouseY <= (y + 20.0F)) {
                }
            } else {
            }
            if (var32 <= mouseY) {
                MacroPanelRenderHelper3Impl.INSTANCE.updateValue(1);
            }
        }
        SFMServiceComponent.resolveFontRenderHelper().render(context, this.contract8.getString(), (x + 6.0F), y, Color.WHITE);
        Contract8 var33 = this.contract8;
        if (0L > 0L) {
            if (var33 instanceof IdRecord9) {
            } else {
            }
            if (0L >= 0L) {
                if (var33 instanceof IdRecord) {
                } else {
                }
            }
        }
        var32 = "setting";
        SFMServiceComponent.resolveFontRenderHelper().render(context, (x + 6.0F), (y + 11.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.7F));
        context.method_51448().pushMatrix();
        var33 = NoneServiceComponent.INSTANCE.resolveString(this.contract8.getKeyRecord().getNumericValue());
        Object var34 = var33;
        if (0L > 0L) {
            context.method_51448().translate(((x + 54.0F) + 7.5F), ((y + 5.0F) + 7.5F));
            context.method_51448().scale(0.5F, 0.5F);
            context.method_51448().translate(((x + 54.0F) + 7.5F), ((y + 5.0F) + 7.5F));
        }
        if (var33.length() > 1 && var33.length() > 5) {
            var34 = var33.substring(0, 4);
        }
        if (0L > 0L) {
            if (Intrinsics.areEqual(MacroPanelRenderHelper3Impl.INSTANCE.getMacrosRenderHelper2Impl2(), this)) {
            }
        } else {
        }
        context.render(StringsKt.dropLast("...", (3 - (4 * ((System.currentTimeMillis() % 700) / 700.0D)))), (x + 61.5F), (y + 11.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.7F));
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
