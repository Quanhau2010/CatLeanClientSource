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
        long var8 = ((0L ^ 122872324218116L) >>> 48);
        long var9 = (((0L ^ 122872324218116L) << 16) >>> 48);
        long var10 = (((0L ^ 122872324218116L) << 32) >>> 32);
        long var11 = (0L ^ 97956880838355L);
        long var13 = (0L ^ 15727589290443L);
        long var15 = (0L ^ 81101117301204L);
        long var17 = (0L ^ 112712302870369L);
        long var19 = (0L ^ 117649217993747L);
        long var21 = ((0L ^ 81010294496925L) >>> 48);
        long var22 = (((0L ^ 81010294496925L) << 16) >>> 32);
        long var23 = (((0L ^ 81010294496925L) << 48) >>> 48);
        long var24 = (0L ^ 71473437392130L);
        float var42 = (x + 4.0F);
        if (mouseX <= (x + 102.0F)) {
        } else {
        }
        if (0L > 0L) {
        }
        if (0L >= 0L) {
            if (var41 != null) {
                if (y <= mouseY) {
                }
            }
        } else {
        }
        if (0L >= 0L) {
            if (var42 <= mouseX && mouseY <= (y + 25.0F)) {
            }
        } else {
        }
        1.enabledFlag2 = 0;
        if (this.enabledFlag2) {
        } else {
        }
        1.0F.executeAction(0.0F);
        if (this.enabledFlag2) {
        } else {
        }
        int var27 = 14336;
        float var28 = 0.0F;
        float var29 = 0.0F;
        float var30 = 0.0F;
        Color var31 = NewThemeRenderHelper.INSTANCE.getColor6();
        Color var32 = NewThemeRenderHelper.INSTANCE.getColor5();
        float var33 = 1.0F;
        float var34 = 0.15F;
        float var35 = 0.0F;
        float var36 = 2.0F;
        float var37 = 2.0F;
        float var38 = 25.0F;
        float var39 = 102.0F;
        float var40 = y;
        StackShaderComponent2.executeAction((x + 4.0F));
        if (0L >= 0L) {
            if (this.minecraftRef == null) {
            }
            if (0L > 0L) {
                if (!(this.enabledFlag)) {
                    this.enabledFlag = 1;
                    this.minecraftRef = UrlServiceComponent.INSTANCE.resolveMinecraftObject(("https://minotar.net/helm/" + this.textValue + "/32.png"));
                    this.enabledFlag = 0;
                    if (0L >= 0L) {
                    } else {
                        ColorValueShaderComponent.executeAction((x + 6.0F), (y + 2), 20.0F, 20.0F, 2.0F, 0.0F, 0.0F, 1.0F, Color.WHITE, Color.WHITE, context.method_51448(), this.minecraftRef);
                    }
                }
                SFMServiceComponent.resolveFontRenderHelper().render(context, this.textValue, (x + 30.0F), (y + 7.0F), Color.WHITE);
            }
        }
        if (this.easingServiceComponent.getNumericValue() > 0.0F) {
            MissingnoRenderHelper.executeAction(HomiesPanelRenderHelper3Impl.INSTANCE.getMissingnoRenderHelper(), (Matrix3x2f) context.method_51448(), ((x + 85.0F) + (10.0F - (10.0F * this.easingServiceComponent.getNumericValue()))), (y + 2.0F), 0.0F, 0.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, this.easingServiceComponent.getNumericValue()), null, 0.0F);
        }
    }

    public boolean checkCondition(float x, float y) {
        long var6 = (0L ^ 118079633004369L);
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
