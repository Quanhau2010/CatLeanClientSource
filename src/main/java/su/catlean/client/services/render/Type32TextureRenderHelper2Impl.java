package su.catlean.client.services.render;

import java.awt.Color;
import net.minecraft.class_2960;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2f;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.UrlServiceComponent;
import su.catlean.client.services.player.PlayerEntityHelper;
import su.catlean.client.services.render.shader.ColorValueShaderComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class Type32TextureRenderHelper2Impl extends RenderHelper2 {

    private String textValue;
    private class_2960 minecraftRef;
    private boolean enabledFlag;
    private boolean enabledFlag2;
    private EasingServiceComponent easingServiceComponent;
    private static String[] textValueArray;

    public Type32TextureRenderHelper2Impl(String name) {
        super();
        this.textValue = name;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, timestampValue);
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(String value) {
        this.textValue = value;
    }

    public void render(DrawContext context, float x, float y, float mouseX, float mouseY) {
        float factor = (x + 4.0F);
        if (mouseX <= (x + 102.0F)) {
        } else {
        }
        if (y <= mouseY) {
        } else {
        }
        this.enabledFlag2 = mouseY <= (y + 25.0F);
        if (this.enabledFlag2) {
        } else {
        }
        this.executeAction(0.0F);
        if (this.enabledFlag2) {
        } else {
        }
        int index = 14336;
        float factor2 = 0.0F;
        float factor3 = 0.0F;
        float factor4 = 0.0F;
        Color color = NewThemeRenderHelper.INSTANCE.getColor6();
        Color color2 = NewThemeRenderHelper.INSTANCE.getColor5();
        float factor5 = 1.0F;
        float factor6 = 0.15F;
        float factor7 = 0.0F;
        float factor8 = 2.0F;
        float factor9 = 2.0F;
        float factor10 = 25.0F;
        float factor11 = 102.0F;
        StackShaderComponent2.executeAction((x + 4.0F), y, factor11, factor10, factor9, factor8, factor7, factor6, factor5, color2, color, factor4, factor3, factor2, index);
        if (this.minecraftRef == null) {
            if (!(this.enabledFlag)) {
                this.enabledFlag = true;
                this.minecraftRef = UrlServiceComponent.INSTANCE.resolveMinecraftObject(("https://minotar.net/helm/" + this.textValue + "/32.png"));
                this.enabledFlag = false;
                ColorValueShaderComponent.executeAction((x + 6.0F), (y + 2), 20.0F, 20.0F, 2.0F, 0.0F, 0.0F, 1.0F, Color.WHITE, Color.WHITE, context.method_51448(), this.minecraftRef);
            }
        } else {
        }
        SFMServiceComponent.resolveFontRenderHelper().render(context, this.textValue, (x + 30.0F), (y + 7.0F), Color.WHITE);
        if (this.easingServiceComponent.getNumericValue() > 0.0F) {
            MissingnoRenderHelper.executeAction(HomiesPanelRenderHelper3Impl.INSTANCE.getMissingnoRenderHelper(), ((Matrix3x2f) context.method_51448()), ((x + 85.0F) + (10.0F - (10.0F * this.easingServiceComponent.getNumericValue()))), (y + 2.0F), 0.0F, 0.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, this.easingServiceComponent.getNumericValue()), null, 0.0F);
        }
    }

    public boolean checkCondition(float x, float y) {
        if (this.enabledFlag2) {
            PlayerEntityHelper.INSTANCE.checkCondition2(this.textValue);
            return true;
        }
        return false;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
