package su.catlean.client.services.render;

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
        this.enabledFlag4 = true;
    }

    public void updateValue() {
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        if (this.enabledFlag4) {
            this.updateValue();
            this.enabledFlag4 = false;
        }
        StackShaderComponent2.executeAction(context.method_51448(), this.factorValue, this.factorValue2, this.factorValue3, this.factorValue4, 5.0F, 1.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78((this.factorValue + 2), (this.factorValue2 + 14), ((this.factorValue + this.factorValue3) - 2), (this.factorValue2 + this.factorValue4)));
        StackShaderComponent2.executeAction(context.method_51448(), (this.factorValue + 1), (this.factorValue2 + 12), (this.factorValue3 - 2), (this.factorValue4 - 14.0F), 5.0F, 1.0F, 0.1F, 0.5F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        PolygonShaderComponent.INSTANCE.render(context);
        StackShaderComponent2.executeAction(context.method_51448(), ((this.factorValue + this.factorValue3) - 10), (this.factorValue2 + 3), 8.0F, 8.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), ((this.factorValue + this.factorValue3) - 20), (this.factorValue2 + 3), 8.0F, 8.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), ((this.factorValue + this.factorValue3) - 30), (this.factorValue2 + 3), 8.0F, 8.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper().render(context, this.textValue, (this.factorValue + (this.factorValue3 / 2)), (this.factorValue2 + 6.0F), NewThemeRenderHelper.INSTANCE.getColor5());
        if (this.enabledFlag) {
            this.factorValue = (mouseX - this.factorValue7);
            this.factorValue2 = (mouseY - this.factorValue8);
        }
        if (this.enabledFlag2) {
            this.factorValue3 = Math.max(this.factorValue5, (mouseX - this.factorValue7));
        }
        this.factorValue4 = Math.max(this.factorValue6, (mouseY - this.factorValue8));
    }

    public void executeAction(float mX, float mY) {
        float factor = this.factorValue;
        if (mX <= (this.factorValue + this.factorValue3)) {
        } else {
            if (factor <= mX) {
                factor = this.factorValue2;
                if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ == null) {
                    if (mY <= (this.factorValue2 + 15)) {
                    } else {
                    }
                }
                if (factor <= mY && CatleanPanelScreenGuiElement.INSTANCE.getRenderHelper3() == null) {
                    this.enabledFlag = true;
                    this.factorValue7 = (mX - this.factorValue);
                    this.factorValue8 = (mY - this.factorValue2);
                }
            }
        }
        factor = this.factorValue;
        if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__ == null) {
            if (mX <= (this.factorValue + this.factorValue3)) {
            } else {
                if (factor <= mX) {
                    factor = ((this.factorValue2 + this.factorValue4) - 5);
                    if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__ == null) {
                        if (mY <= (this.factorValue2 + this.factorValue4)) {
                        } else {
                        }
                    }
                    if (factor <= mY && CatleanPanelScreenGuiElement.INSTANCE.getRenderHelper3() == null) {
                        this.enabledFlag3 = true;
                        this.factorValue8 = (mY - this.factorValue4);
                    }
                }
            }
        }
        factor = ((this.factorValue + this.factorValue3) - 5);
        if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ == null) {
            if (mX <= (this.factorValue + this.factorValue3)) {
            } else {
                if (factor <= mX) {
                    factor = this.factorValue2;
                    if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ == null) {
                        if (mY <= (this.factorValue2 + this.factorValue4)) {
                        } else {
                        }
                    }
                    if (__UNDEF_KEY__ >= 0) {
                        if (factor <= mY && CatleanPanelScreenGuiElement.INSTANCE.getRenderHelper3() == null) {
                            this.enabledFlag2 = true;
                            this.factorValue7 = (mX - this.factorValue3);
                        }
                    }
                }
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ == null) {
            }
            if (__UNDEF_KEY__ >= 0) {
                if (!(this.enabledFlag) && !(this.enabledFlag2)) {
                    if (this.enabledFlag3) {
                        CatleanPanelScreenGuiElement.INSTANCE.updateValue(this);
                    }
                }
            }
        }
    }

    public void executeAction(char key) {
        if (this.contract4 != null) {
            this.contract4.executeAction(key);
        } else {
        }
    }

    public void executeAction(int keyCode) {
        if (this.contract4 != null) {
            this.contract4.executeAction(keyCode);
        } else {
        }
    }

    public void executeAction(double mouseX, double mouseY, double amount) {
    }

    public void executeAction2() {
        this.enabledFlag = false;
        this.enabledFlag2 = false;
        this.enabledFlag3 = false;
        CatleanPanelScreenGuiElement.INSTANCE.updateValue(null);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
