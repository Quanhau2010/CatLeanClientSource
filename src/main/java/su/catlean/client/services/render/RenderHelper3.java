package su.catlean.client.services.render;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.gui.DrawContext;
import su.catlean.api.contracts.Contract4;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.ui.clickgui.CatleanPanelScreenGuiElement;

public abstract class RenderHelper3 {

    private String textValue;
    private float factorValue;
    private float factorValue2;
    private float factorValue3;
    private float factorValue4;
    private float factorValue5;
    private float factorValue6;
    private Contract4 contract4;
    private float factorValue7;
    private float factorValue8;
    private boolean enabledFlag;
    private boolean enabledFlag2;
    private boolean enabledFlag3;
    private boolean enabledFlag4;
    private static int[] countValueArray;

    public RenderHelper3(String name, float x, float y, float width, float height) {
        this.textValue = name;
        this.factorValue = x;
        this.factorValue2 = y;
        this.factorValue3 = width;
        this.factorValue4 = height;
        this.factorValue5 = this.factorValue3;
        this.factorValue6 = this.factorValue4;
    }

    public RenderHelper3(String arg0, float arg1, float arg2, float arg3, float arg4, int arg5, DefaultConstructorMarker arg6) {
        if ((arg5 & 2)) {
            arg1 = 50.0F;
        }
        if ((arg5 & 4)) {
            arg2 = 50.0F;
        }
        if ((arg5 & 8)) {
            arg3 = 230.0F;
        }
        if ((arg5 & 16)) {
            arg4 = 180.0F;
        }
        this(arg0, arg1, arg2, arg3, arg4);
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(String value) {
        this.textValue = value;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public void updateValue2(float value) {
        this.factorValue2 = value;
    }

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public void updateValue3(float value) {
        this.factorValue3 = value;
    }

    public float getNumericValue4() {
        return this.factorValue4;
    }

    public void updateValue4(float value) {
        this.factorValue4 = value;
    }

    public Contract4 getContract4() {
        return this.contract4;
    }

    public void updateValue(Contract4 value) {
        this.contract4 = value;
    }

    public void executeAction() {
        this.enabledFlag4 = 1;
    }

    public void updateValue() {
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        long var6 = ((0L ^ 22135879901675L) >>> 48);
        long var7 = (((0L ^ 22135879901675L) << 16) >>> 48);
        long var8 = (((0L ^ 22135879901675L) << 32) >>> 32);
        long var9 = (0L ^ 55127167163707L);
        long var11 = (0L ^ 117687767941534L);
        long var13 = (0L ^ 2881734234662L);
        long var15 = (0L ^ 55531218400380L);
        long var17 = (0L ^ 118149162295806L);
        if (this.enabledFlag4) {
            this.updateValue();
            this.enabledFlag4 = 0;
        }
        StackShaderComponent2.executeAction(context.method_51448(), this.factorValue, this.factorValue2, this.factorValue3, this.factorValue4, 5.0F, 1.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78((this.factorValue + 2), (this.factorValue2 + 14), ((this.factorValue + this.factorValue3) - 2), (this.factorValue2 + this.factorValue4)));
        StackShaderComponent2.executeAction(context.method_51448(), (this.factorValue + 1), (this.factorValue2 + 12), (this.factorValue3 - 2), (this.factorValue4 - 14.0F), 5.0F, 1.0F, 0.1F, 0.5F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        PolygonShaderComponent.INSTANCE.render(context);
        StackShaderComponent2.executeAction(context.method_51448(), ((this.factorValue + this.factorValue3) - 10), (this.factorValue2 + 3), 8.0F, 8.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), ((this.factorValue + this.factorValue3) - 20), (this.factorValue2 + 3), 8.0F, 8.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), ((this.factorValue + this.factorValue3) - 30), (this.factorValue2 + 3), 8.0F, 8.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper().render(context, this.textValue, (this.factorValue + (this.factorValue3 / 2)), (this.factorValue2 + 6.0F), NewThemeRenderHelper.INSTANCE.getColor5());
        if (0L > 0L && var19 == null) {
            if (this.enabledFlag) {
                this.factorValue = (mouseX - this.factorValue7);
                this.factorValue2 = (mouseY - this.factorValue8);
            }
        }
        if (this.enabledFlag2) {
            this.factorValue3 = Math.max(this.factorValue5, (mouseX - this.factorValue7));
        }
        if (this.enabledFlag3) {
            this.factorValue4 = Math.max(this.factorValue6, (mouseY - this.factorValue8));
        }
    }

    public void executeAction(float mX, float mY) {
        int var7 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        float var10 = this.factorValue;
        if (mX <= (this.factorValue + this.factorValue3)) {
        } else {
        }
        if (var10 <= mX) {
            var10 = this.factorValue2;
            if (0L >= 0 && var9 == null) {
                if (mY <= (this.factorValue2 + 15)) {
                }
            } else {
            }
            if (var10 <= mY && CatleanPanelScreenGuiElement.INSTANCE.getRenderHelper3() == null) {
                this.enabledFlag = 1;
                this.factorValue7 = (mX - this.factorValue);
                this.factorValue8 = (mY - this.factorValue2);
            }
        }
        var10 = this.factorValue;
        if (0L > 0 && var9 == null) {
            if (mX <= (this.factorValue + this.factorValue3)) {
            }
        } else {
        }
        if (var10 <= mX) {
            var10 = ((this.factorValue2 + this.factorValue4) - 5);
            if (0L > 0 && var9 == null) {
                if (mY <= (this.factorValue2 + this.factorValue4)) {
                }
            } else {
            }
            if (var10 <= mY && CatleanPanelScreenGuiElement.INSTANCE.getRenderHelper3() == null) {
                this.enabledFlag3 = 1;
                this.factorValue8 = (mY - this.factorValue4);
            }
        }
        var10 = ((this.factorValue + this.factorValue3) - 5);
        if (0L >= 0 && var9 == null) {
            if (mX <= (this.factorValue + this.factorValue3)) {
            }
        } else {
        }
        if (var10 <= mX) {
            var10 = this.factorValue2;
            if (0L >= 0 && var9 == null) {
                if (mY <= (this.factorValue2 + this.factorValue4)) {
                }
            } else {
            }
            if (0L >= 0) {
                if (var10 <= mY && CatleanPanelScreenGuiElement.INSTANCE.getRenderHelper3() == null) {
                    this.enabledFlag2 = 1;
                    this.factorValue7 = (mX - this.factorValue3);
                }
            }
        }
        if (0L >= 0) {
            if (var9 == null) {
            }
            if (0L >= 0) {
            }
            if (!(this.enabledFlag) && !(this.enabledFlag2)) {
            }
            if (this.enabledFlag3) {
            }
            CatleanPanelScreenGuiElement.INSTANCE.updateValue(this);
        }
    }

    public void executeAction(char key) {
        if (var6 == null) {
            if (this.contract4 != null) {
                this.contract4.executeAction(key);
            }
        } else {
        }
    }

    public void executeAction(int keyCode) {
        long var6 = ((0L ^ 109767034341650L) >>> 48);
        long var7 = (((0L ^ 109767034341650L) << 16) >>> 32);
        long var8 = (((0L ^ 109767034341650L) << 48) >>> 48);
        if (var9 == null) {
            if (this.contract4 != null) {
                this.contract4.executeAction(keyCode);
            }
        } else {
        }
    }

    public void executeAction(double mouseX, double mouseY, double amount) {
    }

    public void executeAction2() {
        this.enabledFlag = 0;
        this.enabledFlag2 = 0;
        this.enabledFlag3 = 0;
        CatleanPanelScreenGuiElement.INSTANCE.updateValue(null);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
