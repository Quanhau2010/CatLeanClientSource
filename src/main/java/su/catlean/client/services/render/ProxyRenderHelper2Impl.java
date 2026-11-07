package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.DrawContext;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.ProxyServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.config.models.IdRecord12;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class ProxyRenderHelper2Impl extends RenderHelper2 {

    private IdRecord12 idRecord12;
    private final EasingServiceComponent easingServiceComponent;
    private static String[] textValueArray;

    public ProxyRenderHelper2Impl(IdRecord12 proxy) {
        super();
        this.idRecord12 = proxy;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, timestampValue);
    }

    public IdRecord12 getIdRecord12() {
        return this.idRecord12;
    }

    public void executeAction(IdRecord12 value) {
        this.idRecord12 = value;
    }

    public void render(DrawContext context, float x, float y, float mouseX, float mouseY) {
        long var8 = (0L ^ 127744779498483L);
        long var10 = ((0L ^ 122872324218116L) >>> 48);
        long var11 = (((0L ^ 122872324218116L) << 16) >>> 48);
        long var12 = (((0L ^ 122872324218116L) << 32) >>> 32);
        long var13 = (0L ^ 97956880838355L);
        long var15 = (0L ^ 15727589290443L);
        long var17 = (0L ^ 1638017753221L);
        long var19 = (0L ^ 81101117301204L);
        long var21 = (0L ^ 16131101211356L);
        long var23 = ((0L ^ 81010294496925L) >>> 48);
        long var24 = (((0L ^ 81010294496925L) << 16) >>> 32);
        long var25 = (((0L ^ 81010294496925L) << 48) >>> 48);
        if (x <= mouseX) {
        } else {
        }
        if (0L > 0L) {
        }
        if (0L >= 0L) {
            if (var26 == null) {
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
        1.0F.executeAction(0.0F);
        if (0L >= 0L) {
            ProxyPanelRenderHelper3Impl.INSTANCE.updateValue2(this);
        }
        if (Intrinsics.areEqual(this.idRecord12, ProxyServiceComponent.INSTANCE.getIdRecord12())) {
        } else {
        }
        Color var28 = NewThemeRenderHelper.INSTANCE.getColor10().resolveColor(NewThemeRenderHelper.INSTANCE.getColor11(), 1.0F, 0.0F);
        if (Intrinsics.areEqual(this.idRecord12, ProxyServiceComponent.INSTANCE.getIdRecord12())) {
        } else {
        }
        Color var29 = NewThemeRenderHelper.INSTANCE.getColor13().resolveColor(NewThemeRenderHelper.INSTANCE.getColor12(), 1.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 4.0F), y, 70.0F, 25.0F, 2.0F, (2.5F + this.easingServiceComponent.getNumericValue()), 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper().render(context, this.idRecord12.getString(), (x + 6.0F), y, Color.WHITE);
        SFMServiceComponent.resolveFontRenderHelper().render(context, this.idRecord12.getString2(), (x + 6.0F), (y + 11.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.7F));
        String var30 = (this.idRecord12.getNumericValue2() + "ms");
        float var31 = SFMServiceComponent.resolveFontRenderHelper4().computeValue();
        StackShaderComponent2.executeAction(context.method_51448(), ((x + 67.0F) - var31), (y + 2.0F), (var31 + 4.0F), 8.0F, 2.0F, 2.0F, 0.15F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper4().render(context, ((x + 68.0F) - var31), (y + 0.5F), Color.WHITE);
    }

    public boolean checkCondition(float x, float y) {
        return false;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
