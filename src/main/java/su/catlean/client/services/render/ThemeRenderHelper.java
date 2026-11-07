package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KMutableProperty0;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.SettingServiceComponent3;
import su.catlean.client.services.client.config.models.IdRecord6;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.ui.clickgui.REDGuiElement;

public class ThemeRenderHelper {

    private String textValue;
    private final IdRecord6 idRecord6;
    private float factorValue;
    private float factorValue2;
    private Color colorValue;
    private boolean enabledFlag;
    private boolean enabledFlag2;
    private boolean enabledFlag3;
    private boolean enabledFlag4;
    private float factorValue3;
    private float factorValue4;
    private final EasingServiceComponent easingServiceComponent;
    private final EasingServiceComponent easingServiceComponent2;
    private final EasingServiceComponent easingServiceComponent3;
    private final ArrayList arrayList;

    public ThemeRenderHelper(String id, IdRecord6 theme, float x, float y, Color setting) {
        this.textValue = id;
        this.idRecord6 = theme;
        this.factorValue = x;
        this.factorValue2 = y;
        this.colorValue = setting;
        this.factorValue3 = 116.0F;
        this.factorValue4 = 14.0F;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 300L);
        this.easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 300L);
        this.easingServiceComponent3 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 300L);
        this.arrayList = new ArrayList();
        int index = 4;
        int index2 = 0;
        if (index2 < index) {
            this.arrayList.add(new SettingRenderHelper4(((KMutableProperty0) new SettingServiceComponent3(this)), this.factorValue, this.factorValue2, index2));
            if (__UNDEF_KEY__ >= 0) {
            }
        }
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(String value) {
        this.textValue = value;
    }

    public IdRecord6 getIdRecord6() {
        return this.idRecord6;
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

    public Color getColor() {
        return this.colorValue;
    }

    public void executeAction(Color value) {
        this.colorValue = value;
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

    public void render(DrawContext context, int mouseX, int mouseY) {
        Matrix3x2fStack matrix3x2fStack = context.method_51448();
        SFMServiceComponent.resolveFontRenderHelper3().render(context, KeyServiceComponent.INSTANCE.resolveString(("hub.theme-editor." + this.textValue), new Object[0]), (this.factorValue - 1.0F), (this.factorValue2 - 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        if (this.enabledFlag) {
        } else {
        }
        this.factorValue4 = 14.0F;
        if (this.enabledFlag) {
        } else {
        }
        this.executeAction(0.0F);
        float factor = (1.0F - this.easingServiceComponent.getNumericValue());
        if (this.enabledFlag) {
            float factor2 = this.factorValue;
            float factor3 = (this.factorValue + 25.0F);
            int index = mouseX;
            if (factor2 <= index) {
            } else {
                if (index <= factor3) {
                    factor2 = (this.factorValue2 + 24.0F);
                    factor3 = (this.factorValue2 + 34.0F);
                    index = mouseY;
                    if (factor2 <= index) {
                    } else {
                        if (index <= factor3) {
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        this.executeAction(0.0F);
        if (this.enabledFlag) {
            factor2 = this.factorValue;
            factor3 = (this.factorValue + 25.0F);
            index = mouseX;
            if (factor2 <= index) {
            } else {
                if (index <= factor3) {
                    factor2 = (this.factorValue2 + 38.0F);
                    factor3 = (this.factorValue2 + 47.0F);
                    index = mouseY;
                    if (factor2 <= index) {
                    } else {
                        if (index <= factor3) {
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        this.executeAction(0.0F);
        factor2 = new float[3];
        Color.RGBtoHSB(this.colorValue.getRed(), this.colorValue.getGreen(), this.colorValue.getBlue(), factor2);
        StackShaderComponent2.executeAction(context.method_51448(), ((this.factorValue + this.factorValue3) - 18.0F), (this.factorValue2 + (11 * this.easingServiceComponent.getNumericValue())), 11.0F, (11.0F * factor), 3.0F, 2.5F, 1.0F, 1.0F, this.colorValue, NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        if (this.enabledFlag) {
            MissingnoRenderHelper.executeAction(REDGuiElement.INSTANCE.getMissingnoRenderHelper(), ((Matrix3x2f) context.method_51448()), ((this.factorValue + this.factorValue3) - 17.0D), (this.factorValue2 - 2.0D), 0.0F, 0.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), this.easingServiceComponent.getNumericValue()), null, 0.0F);
            int index2 = 3072;
            float factor4 = 0.0F;
            Matrix3x2fStack matrix3x2fStack2 = matrix3x2fStack;
            Color color = new Color(Color.HSBtoRGB(factor2[0], 1.0F, 1.0F));
            Color color2 = new Color(0);
            ColorValue1RenderHelper.executeAction(((this.factorValue + this.factorValue3) - (48.0F * this.easingServiceComponent.getNumericValue())), (this.factorValue2 + (10.0F * this.easingServiceComponent.getNumericValue())), (40.0F * this.easingServiceComponent.getNumericValue()), (39.5F * this.easingServiceComponent.getNumericValue()), 3.0F, new Color(0), new Color(-1), color2, color, matrix3x2fStack2, factor4, index2);
            factor3 = ((Iterable) this.arrayList);
            index = 0;
            Iterator iterator = factor3.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                SettingRenderHelper4 settingRenderHelper4 = ((SettingRenderHelper4) element);
                int index3 = 0;
                settingRenderHelper4.updateValue(this.factorValue);
                settingRenderHelper4.updateValue2(this.factorValue2);
                settingRenderHelper4.render(matrix3x2fStack, context);
            }
            iterator = "%02X%02X%02X";
            element = new Object[3];
            element[0] = Integer.valueOf(this.colorValue.getRed());
            element[1] = Integer.valueOf(this.colorValue.getGreen());
            element[2] = Integer.valueOf(this.colorValue.getBlue());
            factor3 = String.format(iterator, Arrays.copyOf(element, element));
            index = 3;
            iterator = 0;
            if (iterator < index) {
                element = iterator;
                settingRenderHelper4 = 0;
                index2 = 14336;
                float factor5 = 0.0F;
                factor4 = 0.0F;
                matrix3x2fStack2 = 0.0F;
                color = NewThemeRenderHelper.INSTANCE.getColor9();
                color2 = NewThemeRenderHelper.INSTANCE.getColor11();
                float factor6 = 1.0F;
                float factor7 = (this.easingServiceComponent3.getNumericValue() * 0.0F);
                float factor8 = this.easingServiceComponent2.getNumericValue();
                float factor9 = 0.5F;
                float factor10 = (this.easingServiceComponent3.getNumericValue() + 0.0F);
                float factor11 = this.easingServiceComponent2.getNumericValue();
                StackShaderComponent2.executeAction(2.0F, element, factor11, factor10, factor9, element, factor8, factor7, factor6, color2, color, matrix3x2fStack2, factor4, factor5, index2);
                index3 = new String[3];
                index3[0] = factor3;
                index3[1] = "Copy";
                index3[2] = "Paste";
                SFMServiceComponent.resolveFontRenderHelper4().render(context, ((String) CollectionsKt.listOf(index3).get(element)), (this.factorValue + 13.5F), ((this.factorValue2 + 14.5F) + (element * 14.0F)), NewThemeRenderHelper.INSTANCE.getColor7());
            }
            index = new Color[4];
            index[0] = PolygonShaderComponent.INSTANCE.resolveColor(this.colorValue, 0.0F);
            index[1] = PolygonShaderComponent.INSTANCE.resolveColor(this.colorValue, 0.0F);
            index[2] = PolygonShaderComponent.INSTANCE.resolveColor(this.colorValue, 1.0F);
            index[3] = PolygonShaderComponent.INSTANCE.resolveColor(this.colorValue, 1.0F);
            PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (this.factorValue + 61.0F), (this.factorValue2 + 10.0F), 2.0F, 39.0F, index);
            index = 1;
            if (index < 108) {
                iterator = Math.clamp((1.0F / (107.0F / ((index * this.easingServiceComponent.getNumericValue()) * this.easingServiceComponent.getNumericValue()))), 0.0F, 1.0F);
                element = Color.getHSBColor(iterator, 1.0F, 1.0F);
                settingRenderHelper4 = new Color[4];
                settingRenderHelper4[0] = element;
                settingRenderHelper4[1] = element;
                settingRenderHelper4[2] = element;
                settingRenderHelper4[3] = element;
                PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (this.factorValue + index), (this.factorValue2 + 55.0F), 1.0F, 2.0F, settingRenderHelper4);
            }
            this.executeAction(matrix3x2fStack, mouseX);
            this.executeAction(matrix3x2fStack, mouseX, mouseY);
            this.executeAction(matrix3x2fStack, mouseY);
        }
        this.executeAction(this.idRecord6);
    }

    private void executeAction(Matrix3x2fStack arg0, int arg1, int arg2) {
        float factor = (((this.factorValue + this.factorValue3) - 48.0F) + 2.0F);
        float factor2 = ((this.factorValue2 + 10.0F) + 2.0F);
        Object element = new float[3];
        Color.RGBtoHSB(this.colorValue.getRed(), this.colorValue.getGreen(), this.colorValue.getBlue(), element);
        StackShaderComponent2.executeAction(arg0, ((factor - 4.0F) + (40 * element[1])), ((factor2 - 4.0F) + (40 * (1.0F - element[2]))), 7.0F, 7.0F, 2.5F, 1.5F, 1.0F, 1.0F, this.colorValue, Color.BLACK, 0.0F, 0.0F, 0.0F);
        float factor3 = Math.clamp(((arg1 - factor) / 40.0F), 0.0F, 1.0F);
        float factor4 = Math.clamp((1.0F - ((arg2 - factor2) / 40.0F)), 0.0F, 1.0F);
        this.colorValue = PolygonShaderComponent.INSTANCE.resolveColor(new Color(Color.HSBtoRGB(element[0], factor3, factor4)), (this.colorValue.getAlpha() / 255.0F));
    }

    private void executeAction(Matrix3x2fStack arg0, int arg1) {
        float factor = (this.factorValue2 + 11.0F);
        StackShaderComponent2.executeAction(arg0, (this.factorValue + 58.0F), ((factor - 4.0F) + (38 * (1.0F - (this.colorValue.getAlpha() / 255.0F)))), 7.0F, 7.0F, 2.5F, 1.0F, 1.0F, 1.0F, this.colorValue, PolygonShaderComponent.INSTANCE.resolveColor(this.colorValue, 1.0F), 0.0F, 0.0F, 0.0F);
        if (__UNDEF_KEY__ != null) {
        }
        this.colorValue = PolygonShaderComponent.INSTANCE.resolveColor(this.colorValue, Math.clamp((1.0F - ((arg1 - factor) / 39.0F)), 0.0F, 1.0F));
    }

    private void executeAction(Matrix3x2fStack arg0, int arg1) {
        float factor = this.factorValue;
        Object element = new float[3];
        Color.RGBtoHSB(this.colorValue.getRed(), this.colorValue.getGreen(), this.colorValue.getBlue(), element);
        StackShaderComponent2.executeAction(arg0, ((factor - 3.5F) + (106 * element[0])), (this.factorValue2 + 52.0F), 7.0F, 7.0F, 2.5F, 1.0F, 1.0F, 1.0F, new Color(Color.HSBtoRGB(element[0], 1.0F, 1.0F)), new Color(Color.HSBtoRGB(element[0], 1.0F, 1.0F)), 0.0F, 0.0F, 0.0F);
        float factor2 = Math.clamp(((arg1 - factor) / 107.0F), 0.0F, 1.0F);
        this.colorValue = PolygonShaderComponent.INSTANCE.resolveColor(new Color(Color.HSBtoRGB(factor2, element[1], element[2])), (this.colorValue.getAlpha() / 255.0F));
    }

    public void executeAction(double mouseX, double mouseY) {
        float factor = this.factorValue;
        if (mouseX <= (this.factorValue + this.factorValue3)) {
        } else {
            if (factor <= mouseX) {
                factor = this.factorValue2;
                if (mouseY <= (this.factorValue2 + 8.0F)) {
                } else {
                    if (factor <= mouseY) {
                        this.enabledFlag = !(this.enabledFlag);
                        this.enabledFlag3 = false;
                        this.enabledFlag4 = false;
                        this.enabledFlag2 = false;
                        return;
                    }
                }
            }
        }
        if (!(this.enabledFlag)) {
            return;
        }
        factor = ((Iterable) this.arrayList);
        Iterator iterator = factor.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SettingRenderHelper4 settingRenderHelper4 = ((SettingRenderHelper4) element);
            settingRenderHelper4.setValue(mouseX, mouseY);
        }
        if (this.enabledFlag) {
            factor = (this.factorValue + 57.0F);
            if (mouseX <= (this.factorValue + 68.0F)) {
            } else {
                if (factor <= mouseX) {
                    factor = (this.factorValue2 + 11.0F);
                    if (mouseY <= (this.factorValue2 + 50.0F)) {
                    } else {
                        if (factor <= mouseY) {
                            this.enabledFlag3 = true;
                        } else {
                            if (this.enabledFlag) {
                                factor = this.factorValue;
                                if (mouseX <= (this.factorValue + 108.0F)) {
                                } else {
                                    if (factor <= mouseX) {
                                        factor = (this.factorValue2 + 53.0F);
                                        if (mouseY <= (this.factorValue2 + 58.0F)) {
                                        } else {
                                            if (factor <= mouseY) {
                                                this.enabledFlag4 = true;
                                            } else {
                                                if (this.enabledFlag) {
                                                    factor = ((this.factorValue + this.factorValue3) - 48.0F);
                                                    if (mouseX <= ((this.factorValue + this.factorValue3) - 8.0F)) {
                                                    } else {
                                                        if (factor <= mouseX) {
                                                            factor = (this.factorValue2 + 11.0F);
                                                            if (mouseY <= (this.factorValue2 + 51.0F)) {
                                                            } else {
                                                                if (factor <= mouseY) {
                                                                    this.enabledFlag2 = true;
                                                                } else {
                                                                    if (this.enabledFlag) {
                                                                        factor = this.factorValue;
                                                                        if (mouseX <= (this.factorValue + 25.0F)) {
                                                                        } else {
                                                                            if (factor <= mouseX) {
                                                                                factor = (this.factorValue2 + 24.0F);
                                                                                if (mouseY <= (this.factorValue2 + 34.0F)) {
                                                                                } else {
                                                                                    if (factor <= mouseY) {
                                                                                        NewThemeRenderHelper.INSTANCE.executeAction(this.colorValue);
                                                                                    } else {
                                                                                        factor = this.factorValue;
                                                                                        if (mouseX <= (this.factorValue + 25.0F)) {
                                                                                        } else {
                                                                                        }
                                                                                        factor = (this.factorValue2 + 38.0F);
                                                                                        if (mouseY <= (this.factorValue2 + 47.0F)) {
                                                                                        } else {
                                                                                        }
                                                                                        this.colorValue = NewThemeRenderHelper.INSTANCE.getColor();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                            }
                                                                        }
                                                                    } else {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void executeAction() {
        this.enabledFlag2 = false;
        this.enabledFlag4 = false;
        this.enabledFlag3 = false;
    }

    public void executeAction(int key) {
        Iterable iterable = ((Iterable) this.arrayList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SettingRenderHelper4 settingRenderHelper4 = ((SettingRenderHelper4) element);
            settingRenderHelper4.setValue(key);
        }
    }

    public void executeAction(char charParam) {
        Iterable iterable = ((Iterable) this.arrayList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SettingRenderHelper4 settingRenderHelper4 = ((SettingRenderHelper4) element);
            settingRenderHelper4.setValue(charParam);
        }
    }

    public void executeAction(double mouseX, double mouseY, double verticalAmount) {
        Iterable iterable = ((Iterable) this.arrayList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SettingRenderHelper4 settingRenderHelper4 = ((SettingRenderHelper4) element);
            settingRenderHelper4.setValue(mouseX, mouseY, verticalAmount);
        }
    }

    private void executeAction(IdRecord6 arg0) {
        String text = this.textValue;
        if (!(text.equals("secondary"))) {
            if (!(text.equals("widget-blur"))) {
                if (!(text.equals("outline"))) {
                    if (!(text.equals("inactive-module-outline"))) {
                        if (!(text.equals("inactive-text"))) {
                            if (!(text.equals("inactive-module"))) {
                                if (!(text.equals("module"))) {
                                    if (!(text.equals("module-outline"))) {
                                        if (!(text.equals("blur"))) {
                                            if (!(text.equals("text"))) {
                                                if (!(text.equals("sliders"))) {
                                                    arg0.executeAction(this.colorValue);
                                                    arg0.executeAction(this.colorValue);
                                                    arg0.executeAction2(this.colorValue);
                                                    arg0.executeAction3(this.colorValue);
                                                    arg0.executeAction2(this.colorValue);
                                                    arg0.executeAction4(this.colorValue);
                                                    arg0.executeAction5(this.colorValue);
                                                } else {
                                                    arg0.executeAction(this.colorValue);
                                                    arg0.executeAction3(this.colorValue);
                                                    arg0.executeAction(this.colorValue);
                                                    arg0.executeAction4(this.colorValue);
                                                    arg0.executeAction6(this.colorValue);
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
