package su.catlean.client.services.render;

import java.awt.Color;
import net.minecraft.client.gui.DrawContext;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.config.models.IdRecord7;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.ui.clickgui.WaypointPanelGuiElement;

public class PointRenderHelper2Impl extends RenderHelper2 {

    private IdRecord7 idRecord7;
    private final EasingServiceComponent easingServiceComponent;

    public PointRenderHelper2Impl(IdRecord7 point) {
        super();
        this.idRecord7 = point;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
    }

    public IdRecord7 getIdRecord7() {
        return this.idRecord7;
    }

    public void executeAction(IdRecord7 value) {
        this.idRecord7 = value;
    }

    public void render(DrawContext context, float x, float y, float mouseX, float mouseY) {
        long var8 = (0L ^ 127744779498483L);
        long var10 = ((0L ^ 122872324218116L) >>> 48);
        long var11 = (((0L ^ 122872324218116L) << 16) >>> 48);
        long var12 = (((0L ^ 122872324218116L) << 32) >>> 32);
        long var13 = (0L ^ 97956880838355L);
        long var15 = (0L ^ 15727589290443L);
        long var17 = (0L ^ 81101117301204L);
        long var19 = ((0L ^ 81010294496925L) >>> 48);
        long var20 = (((0L ^ 81010294496925L) << 16) >>> 32);
        long var21 = (((0L ^ 81010294496925L) << 48) >>> 48);
        if (x <= mouseX) {
        } else {
        }
        if (0L >= 0L) {
        }
        if (0L > 0L) {
            if (var22 == null) {
                if (y <= mouseY) {
                }
            }
        } else {
        }
        if (0L > 0L) {
            if (mouseX <= (x + 70.0F) && mouseY <= (y + 25.0F)) {
            }
        } else {
        }
        1.0F.executeAction(0.0F);
        if (0L > 0L) {
            WaypointPanelGuiElement.INSTANCE.updateValue2(this);
        }
        if (this.idRecord7.isActive()) {
        } else {
        }
        Color var24 = NewThemeRenderHelper.INSTANCE.getColor10().resolveColor(NewThemeRenderHelper.INSTANCE.getColor11(), 1.0F, 0.0F);
        if (this.idRecord7.isActive()) {
        } else {
        }
        Color var25 = NewThemeRenderHelper.INSTANCE.getColor13().resolveColor(NewThemeRenderHelper.INSTANCE.getColor12(), 1.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 4.0F), y, 70.0F, 25.0F, 2.0F, (2.5F + this.easingServiceComponent.getNumericValue()), 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, timestampValue);
        SFMServiceComponent.resolveFontRenderHelper().render(context, this.idRecord7.getString(), (x + 6.0F), y, Color.WHITE);
        SFMServiceComponent.resolveFontRenderHelper().render(context, this.idRecord7.getString2(), (x + 6.0F), (y + 11.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.7F));
    }

    public boolean checkCondition(float x, float y) {
        return false;
    }

}
