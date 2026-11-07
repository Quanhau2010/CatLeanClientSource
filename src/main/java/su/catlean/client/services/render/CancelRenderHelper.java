package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.DrawContext;
import su.catlean.api.contracts.Contract4;
import su.catlean.api.contracts.Contract8;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MacroServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.config.models.IdRecord;
import su.catlean.client.services.client.config.models.IdRecord11;
import su.catlean.client.services.client.config.models.IdRecord9;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;

public class CancelRenderHelper implements Contract4 {

    private String textValue;
    private int countValue;
    private boolean enabledFlag;
    private boolean enabledFlag2;
    private boolean enabledFlag3;
    private boolean enabledFlag4;

    public CancelRenderHelper() {
        this.textValue = "";
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(String value) {
        this.textValue = value;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public void render(DrawContext context, float x, float y, float mouseX, float mouseY) {
        long var8 = ((0L ^ 13851571978927L) >>> 48);
        long var9 = (((0L ^ 13851571978927L) << 16) >>> 48);
        long var10 = (((0L ^ 13851571978927L) << 32) >>> 32);
        long var11 = (0L ^ 119935861042784L);
        long var13 = (0L ^ 46848168590975L);
        long var15 = (0L ^ 127206913172186L);
        long var17 = (0L ^ 111455786286776L);
        long var19 = ((0L ^ 47230931714358L) >>> 48);
        long var20 = (((0L ^ 47230931714358L) << 16) >>> 32);
        long var21 = (((0L ^ 47230931714358L) << 48) >>> 48);
        float var23 = (x + 43.0F);
        if (mouseX <= (x + 77.0F)) {
        } else {
        }
        if (var23 <= mouseX) {
            var23 = (y + 45.0F);
            if (0L >= 0L && var22) {
                if (mouseY <= (y + 58.0F)) {
                }
            } else {
            }
            if (0L > 0L) {
                if (var23 <= mouseY) {
                }
            }
        } else {
        }
        }
        1.enabledFlag = 0;
        StackShaderComponent2.executeAction(context.method_51448(), x, y, 120.0F, 66.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 43.0F), (y + 45.0F), 34.0F, 13.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        if (0L >= 0L) {
        }
        if (0L >= 0L) {
            if (StringsKt.isBlank((CharSequence) this.textValue)) {
            } else {
            }
        }
        context.render("Cancel", "Create", (x + 48), (y + 46.0F), Color.WHITE);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 5.0F), (y + 5.0F), 110.0F, 13.0F, 3.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        var23 = new Color[1];
        var23[0] = new Color(1157627903, 1);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + 33.0F), (y + 9.0F), 0.5F, 7.0F);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "Name", (x + 8.0F), (y + 6.0F), Color.WHITE);
        if ((System.currentTimeMillis() % 700) > timestampValue) {
        } else {
        }
        context.render(this.textValue, ("" + "|"), (x + 37.0F), (y + 6.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.8F));
        StackShaderComponent2.executeAction(context.method_51448(), (x + 5.0F), (y + 25.0F), 110.0F, 13.0F, 3.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        var23 = (x + 5.0F);
        if (0L > 0L && var22) {
            if (mouseX <= (x + 41.0F)) {
            }
        } else {
        }
        if (var23 <= mouseX) {
            var23 = (y + 25.0F);
            if (0L >= 0L && var22) {
                if (mouseY <= (y + 38.0F)) {
                }
            } else {
            }
            if (0L >= 0L) {
                if (var23 <= mouseY) {
                }
            }
        } else {
        }
        }
        1.enabledFlag2 = 0;
        var23 = (x + 42.0F);
        if (0L >= 0L && var22) {
            if (mouseX <= (x + 77.0F)) {
            }
        } else {
        }
        if (var23 <= mouseX) {
            var23 = (y + 25.0F);
            if (0L >= 0L && var22) {
                if (mouseY <= (y + 38.0F)) {
                }
            } else {
            }
            if (0L >= 0L) {
                if (var23 <= mouseY) {
                }
            }
        } else {
        }
        }
        1.enabledFlag3 = 0;
        var23 = (x + 78.0F);
        if (0L > 0L && var22) {
            if (mouseX <= (x + 100.0F)) {
            }
        } else {
        }
        if (var23 <= mouseX) {
            var23 = (y + 25.0F);
            if (0L > 0L && var22) {
                if (mouseY <= (y + 38.0F)) {
                }
            } else {
            }
            if (0L >= 0L) {
                if (var23 <= mouseY) {
                }
            }
        } else {
        }
        }
        1.enabledFlag4 = 0;
        if (!(this.countValue)) {
        } else {
        }
        var23 = PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.3F);
        context.render("Chat", (x + 23.0F), (y + 30.0F), Color.WHITE);
        var23 = new Color[1];
        var23[0] = new Color(1157627903, 1);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + 41.0F), (y + 29.0F), 0.5F, 7.0F);
        if (this.countValue == 1) {
        } else {
        }
        var23 = PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.3F);
        context.render("Item", (x + 58.0F), (y + 30.0F), Color.WHITE);
        var23 = new Color[1];
        var23[0] = new Color(1157627903, 1);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + 77.0F), (y + 29.0F), 0.5F, 7.0F);
        if (this.countValue == 2) {
        } else {
        }
        var23 = PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.3F);
        context.render("Setting", (x + 94.0F), (y + 30.0F), Color.WHITE);
        if (0L > 0L) {
        }
    }

    public void executeAction(char chr) {
        if (var4) {
        }
        this.textValue = (this.textValue + chr);
    }

    public void executeAction(int key) {
        int var5 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        long var7 = (var5 ^ 118101170463243L);
        this.textValue = StringsKt.dropLast(this.textValue, 1);
        this.updateValue();
    }

    public boolean checkCondition(float x, float y) {
        long var6 = (0L ^ 92955783432307L);
        if (this.enabledFlag) {
            this.updateValue();
            return true;
        }
        if (0L > 0L) {
            if (!(var8)) {
                if (this.enabledFlag2) {
                    this.countValue = 0;
                    return true;
                }
            }
        }
        if (0L > 0L && !(var8)) {
            if (this.enabledFlag3) {
                this.countValue = 1;
                return true;
            }
        }
        if (this.enabledFlag4) {
            this.countValue = 2;
            return true;
        }
        return false;
    }

    private void updateValue() {
        if (!(StringsKt.isBlank((CharSequence) this.textValue))) {
            String var16 = "";
            int var17 = 1;
            KeyRecord var18 = new KeyRecord();
            var16 = 0;
            var17 = "";
            var18 = 1;
            KeyRecord var19 = new KeyRecord();
            Contract8 var21 = new IdRecord11(this.textValue, new KeyRecord(), 1, "", "", "0", "0", 0);
            MacroServiceComponent.INSTANCE.checkCondition();
            MacroPanelRenderHelper3Impl.INSTANCE.updateValue();
        }
        MacroPanelRenderHelper3Impl.INSTANCE.updateValue(null);
    }

}
