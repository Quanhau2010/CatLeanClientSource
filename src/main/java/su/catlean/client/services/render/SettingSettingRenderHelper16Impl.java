package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.ui.clickgui.REDGuiElement;

public class SettingSettingRenderHelper16Impl extends SettingRenderHelper16 {

    private final VisibleSettingProperty visibleSettingProperty;
    private boolean enabledFlag;
    private boolean enabledFlag2;
    private boolean enabledFlag3;
    private boolean enabledFlag4;
    private final EasingServiceComponent easingServiceComponent;
    private final EasingServiceComponent easingServiceComponent2;
    private final EasingServiceComponent easingServiceComponent3;
    private final ArrayList arrayList;

    public SettingSettingRenderHelper16Impl(VisibleSettingProperty setting) {
        super(setting);
        this.visibleSettingProperty = setting;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 300L);
        this.easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 300L);
        this.easingServiceComponent3 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 300L);
        this.arrayList = new ArrayList();
        int index = 4;
        int index2 = 0;
        if (index2 < index) {
            this.arrayList.add(new SettingRenderHelper(this.getVisibleSettingProperty(), this.getNumericValue(), this.getNumericValue2(), index2));
        }
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float factor) {
        Matrix3x2fStack matrix3x2fStack = context.method_51448();
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), this.getNumericValue(), this.getNumericValue2(), NewThemeRenderHelper.INSTANCE.getColor7(), false);
        if (this.enabledFlag) {
        } else {
        }
        this.updateValue4(14.0F);
        if (this.enabledFlag) {
        } else {
        }
        this.executeAction(0.0F);
        float factor2 = (1.0F - this.easingServiceComponent.getNumericValue());
        if (__UNDEF_KEY__ != null) {
            if (this.enabledFlag) {
                float factor3 = this.getNumericValue();
                float factor4 = (this.getNumericValue() + 25.0F);
                int index = mouseX;
                if (__UNDEF_KEY__ != null) {
                    if (factor3 <= index) {
                        if (__UNDEF_KEY__ != null) {
                        }
                    } else {
                        if (index <= factor4) {
                            factor3 = (this.getNumericValue2() + 24.0F);
                            factor4 = (this.getNumericValue2() + 34.0F);
                            index = mouseY;
                            if (__UNDEF_KEY__ != null) {
                                if (factor3 <= index) {
                                    if (__UNDEF_KEY__ != null) {
                                    }
                                } else {
                                    if (index <= factor4) {
                                    } else {
                                    }
                                }
                            }
                        } else {
                        }
                    }
                }
            } else {
            }
        }
        this.executeAction(0.0F);
        if (__UNDEF_KEY__ != null) {
            if (this.enabledFlag) {
                factor3 = this.getNumericValue();
                factor4 = (this.getNumericValue() + 25.0F);
                index = mouseX;
                if (__UNDEF_KEY__ != null) {
                    if (factor3 <= index) {
                        if (__UNDEF_KEY__ != null) {
                        }
                    } else {
                        if (index <= factor4) {
                            factor3 = (this.getNumericValue2() + 38.0F);
                            factor4 = (this.getNumericValue2() + 47.0F);
                            index = mouseY;
                            if (__UNDEF_KEY__ != null) {
                                if (factor3 <= index) {
                                    if (__UNDEF_KEY__ != null) {
                                    }
                                } else {
                                    if (index <= factor4) {
                                    } else {
                                    }
                                }
                            }
                        } else {
                        }
                    }
                }
            } else {
            }
        }
        this.executeAction(0.0F);
        factor3 = new float[3];
        Color.RGBtoHSB(((Color) this.getVisibleSettingProperty().getObject2()).getRed(), ((Color) this.getVisibleSettingProperty().getObject2()).getGreen(), ((Color) this.getVisibleSettingProperty().getObject2()).getBlue(), factor3);
        StackShaderComponent2.executeAction(matrix3x2fStack, ((this.getNumericValue() + this.getNumericValue3()) - 18.0F), (this.getNumericValue2() + (11 * this.easingServiceComponent.getNumericValue())), 11.0F, (11.0F * factor2), 3.0F, 2.5F, 1.0F, 1.0F, ((Color) this.getVisibleSettingProperty().getObject2()), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        if (__UNDEF_KEY__ != null) {
            MissingnoRenderHelper.executeAction(REDGuiElement.INSTANCE.getMissingnoRenderHelper(), ((Matrix3x2f) context.method_51448()), ((this.getNumericValue() + this.getNumericValue3()) - 17.0D), (this.getNumericValue2() - 2), 0.0F, 0.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), this.easingServiceComponent.getNumericValue()), null, 0.0F);
            int index2 = 3072;
            float factor5 = 0.0F;
            Matrix3x2fStack matrix3x2fStack2 = matrix3x2fStack;
            Color color = new Color(Color.HSBtoRGB(factor3[0], 1.0F, 1.0F));
            Color color2 = new Color(0);
            ColorValue1RenderHelper.executeAction(((this.getNumericValue() + this.getNumericValue3()) - (48.0F * this.easingServiceComponent.getNumericValue())), (this.getNumericValue2() + (10.0F * this.easingServiceComponent.getNumericValue())), (40.0F * this.easingServiceComponent.getNumericValue()), (39.5F * this.easingServiceComponent.getNumericValue()), 3.0F, new Color(0), new Color(-1), color2, color, matrix3x2fStack2, factor5, index2);
        }
        factor4 = ((Iterable) this.arrayList);
        index = 0;
        Iterator iterator = factor4.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SettingRenderHelper settingRenderHelper = ((SettingRenderHelper) element);
            int index3 = 0;
            settingRenderHelper.updateValue(this.getNumericValue());
            settingRenderHelper.updateValue2(this.getNumericValue2());
            settingRenderHelper.render(matrix3x2fStack, context);
            if (__UNDEF_KEY__ != null) {
            }
        }
        iterator = "%02X%02X%02X";
        element = new Object[3];
        element[0] = Integer.valueOf(((Color) this.getVisibleSettingProperty().getObject2()).getRed());
        element[1] = Integer.valueOf(((Color) this.getVisibleSettingProperty().getObject2()).getGreen());
        element[2] = Integer.valueOf(((Color) this.getVisibleSettingProperty().getObject2()).getBlue());
        factor4 = String.format(iterator, Arrays.copyOf(element, element));
        index = 3;
        iterator = 0;
        if (iterator < index) {
            element = iterator;
            settingRenderHelper = 0;
            if (__UNDEF_KEY__ != null) {
                index2 = 14336;
                float factor6 = 0.0F;
                factor5 = 0.0F;
                matrix3x2fStack2 = 0.0F;
                color = NewThemeRenderHelper.INSTANCE.getColor9();
                color2 = NewThemeRenderHelper.INSTANCE.getColor11();
                float factor7 = 1.0F;
                float factor8 = (this.easingServiceComponent3.getNumericValue() * 0.0F);
                float factor9 = this.easingServiceComponent2.getNumericValue();
                float factor10 = 0.5F;
                float factor11 = (this.easingServiceComponent3.getNumericValue() + 0.0F);
                float factor12 = this.easingServiceComponent2.getNumericValue();
                StackShaderComponent2.executeAction(2.0F, element, factor12, factor11, factor10, element, factor9, factor8, factor7, color2, color, matrix3x2fStack2, factor5, factor6, index2);
                index3 = new String[3];
                index3[0] = factor4;
                index3[1] = "Copy";
                index3[2] = "Paste";
                SFMServiceComponent.resolveFontRenderHelper4().render(context, ((String) CollectionsKt.listOf(index3).get(element)), (this.getNumericValue() + 13.5F), ((this.getNumericValue2() + 14.5F) + (element * 14.0F)), NewThemeRenderHelper.INSTANCE.getColor7());
                index = new Color[4];
                index[0] = PolygonShaderComponent.INSTANCE.resolveColor(((Color) this.getVisibleSettingProperty().getObject2()), 0.0F);
                index[1] = PolygonShaderComponent.INSTANCE.resolveColor(((Color) this.getVisibleSettingProperty().getObject2()), 0.0F);
                index[2] = PolygonShaderComponent.INSTANCE.resolveColor(((Color) this.getVisibleSettingProperty().getObject2()), 1.0F);
                index[3] = PolygonShaderComponent.INSTANCE.resolveColor(((Color) this.getVisibleSettingProperty().getObject2()), 1.0F);
                PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (this.getNumericValue() + 61.0F), (this.getNumericValue2() + 10.0F), 2.0F, 39.0F, index);
                index = 1;
                iterator = index;
            }
        }
        element = Math.clamp((1.0F / (107.0F / ((iterator * this.easingServiceComponent.getNumericValue()) * this.easingServiceComponent.getNumericValue()))), 0.0F, 1.0F);
        settingRenderHelper = Color.getHSBColor(element, 1.0F, 1.0F);
        index3 = new Color[4];
        index3[0] = settingRenderHelper;
        index3[1] = settingRenderHelper;
        index3[2] = settingRenderHelper;
        index3[3] = settingRenderHelper;
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (this.getNumericValue() + iterator), (this.getNumericValue2() + 55.0F), 1.0F, 2.0F, index3);
        this.setValue(matrix3x2fStack, mouseX);
        this.setValue(matrix3x2fStack, mouseX, mouseY);
        this.setValue(matrix3x2fStack, mouseY);
    }

    private void setValue(Matrix3x2fStack arg0, int arg1, int arg2) {
        float factor = (((this.getNumericValue() + this.getNumericValue3()) - 48.0F) + 2.0F);
        float factor2 = ((this.getNumericValue2() + 10.0F) + 2.0F);
        Object element = new float[3];
        Color.RGBtoHSB(((Color) this.getVisibleSettingProperty().getObject2()).getRed(), ((Color) this.getVisibleSettingProperty().getObject2()).getGreen(), ((Color) this.getVisibleSettingProperty().getObject2()).getBlue(), element);
        StackShaderComponent2.executeAction(arg0, ((factor - 4.0F) + (40 * element[1])), ((factor2 - 4.0F) + (40 * (1.0F - element[2]))), 7.0F, 7.0F, 2.5F, 1.5F, 1.0F, 1.0F, ((Color) this.getVisibleSettingProperty().getObject2()), Color.BLACK, 0.0F, 0.0F, 0.0F);
        float factor3 = Math.clamp(((arg1 - factor) / 40.0F), 0.0F, 1.0F);
        float factor4 = Math.clamp((1.0F - ((arg2 - factor2) / 40.0F)), 0.0F, 1.0F);
        this.getVisibleSettingProperty().updateValue(PolygonShaderComponent.INSTANCE.resolveColor(new Color(Color.HSBtoRGB(element[0], factor3, factor4)), (((Color) this.getVisibleSettingProperty().getObject2()).getAlpha() / 255.0F)));
    }

    private void setValue(Matrix3x2fStack arg0, int arg1) {
        float factor = (this.getNumericValue2() + 11.0F);
        StackShaderComponent2.executeAction(arg0, (this.getNumericValue() + 58.0F), ((factor - 4.0F) + (38 * (1.0F - (((Color) this.getVisibleSettingProperty().getObject2()).getAlpha() / 255.0F)))), 7.0F, 7.0F, 2.5F, 1.0F, 1.0F, 1.0F, ((Color) this.getVisibleSettingProperty().getObject2()), PolygonShaderComponent.INSTANCE.resolveColor(((Color) this.getVisibleSettingProperty().getObject2()), 1.0F), 0.0F, 0.0F, 0.0F);
        float factor2 = Math.clamp((1.0F - ((arg1 - factor) / 39.0F)), 0.0F, 1.0F);
        this.getVisibleSettingProperty().updateValue(PolygonShaderComponent.INSTANCE.resolveColor(((Color) this.getVisibleSettingProperty().getObject2()), factor2));
    }

    private void setValue(Matrix3x2fStack arg0, int arg1) {
        float factor = this.getNumericValue();
        Object element = new float[3];
        Color.RGBtoHSB(((Color) this.getVisibleSettingProperty().getObject2()).getRed(), ((Color) this.getVisibleSettingProperty().getObject2()).getGreen(), ((Color) this.getVisibleSettingProperty().getObject2()).getBlue(), element);
        StackShaderComponent2.executeAction(arg0, ((factor - 3.5F) + (106 * element[0])), (this.getNumericValue2() + 52.0F), 7.0F, 7.0F, 2.5F, 1.0F, 1.0F, 1.0F, new Color(Color.HSBtoRGB(element[0], 1.0F, 1.0F)), new Color(Color.HSBtoRGB(element[0], 1.0F, 1.0F)), 0.0F, 0.0F, 0.0F);
        float factor2 = Math.clamp(((arg1 - factor) / 107.0F), 0.0F, 1.0F);
        this.getVisibleSettingProperty().updateValue(PolygonShaderComponent.INSTANCE.resolveColor(new Color(Color.HSBtoRGB(factor2, element[1], element[2])), (((Color) this.getVisibleSettingProperty().getObject2()).getAlpha() / 255.0F)));
    }

    public void setValue(double mouseX, double mouseY) {
        Iterable iterable = ((Iterable) this.arrayList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SettingRenderHelper settingRenderHelper = ((SettingRenderHelper) element);
            settingRenderHelper.setValue(mouseX, mouseY);
        }
        iterable = this.getNumericValue();
        if (mouseX <= (this.getNumericValue() + this.getNumericValue3())) {
        } else {
            if (iterable <= mouseX) {
                iterable = this.getNumericValue2();
                if (mouseY <= (this.getNumericValue2() + 8.0F)) {
                } else {
                    if (iterable <= mouseY) {
                        this.enabledFlag = !(this.enabledFlag);
                        this.enabledFlag3 = false;
                        this.enabledFlag4 = false;
                        this.enabledFlag2 = false;
                        return;
                    }
                }
            }
        }
        if (this.enabledFlag) {
            iterable = (this.getNumericValue() + 57.0F);
            if (mouseX <= (this.getNumericValue() + 68.0F)) {
            } else {
                if (iterable <= mouseX) {
                    iterable = (this.getNumericValue2() + 11.0F);
                    if (mouseY <= (this.getNumericValue2() + 50.0F)) {
                    } else {
                        if (iterable <= mouseY) {
                            this.enabledFlag3 = true;
                        } else {
                            if (this.enabledFlag) {
                                iterable = this.getNumericValue();
                                if (mouseX <= (this.getNumericValue() + 108.0F)) {
                                } else {
                                    if (iterable <= mouseX) {
                                        iterable = (this.getNumericValue2() + 53.0F);
                                        if (mouseY <= (this.getNumericValue2() + 58.0F)) {
                                        } else {
                                            if (iterable <= mouseY) {
                                                this.enabledFlag4 = true;
                                            } else {
                                                if (this.enabledFlag) {
                                                    iterable = ((this.getNumericValue() + this.getNumericValue3()) - 48.0F);
                                                    if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 8.0F)) {
                                                    } else {
                                                        if (iterable <= mouseX) {
                                                            iterable = (this.getNumericValue2() + 11.0F);
                                                            if (mouseY <= (this.getNumericValue2() + 51.0F)) {
                                                            } else {
                                                                if (iterable <= mouseY) {
                                                                    this.enabledFlag2 = true;
                                                                } else {
                                                                    if (this.enabledFlag) {
                                                                        iterable = this.getNumericValue();
                                                                        if (mouseX <= (this.getNumericValue() + 25.0F)) {
                                                                        } else {
                                                                            if (iterable <= mouseX) {
                                                                                iterable = (this.getNumericValue2() + 24.0F);
                                                                                if (mouseY <= (this.getNumericValue2() + 34.0F)) {
                                                                                } else {
                                                                                    if (iterable <= mouseY) {
                                                                                        NewThemeRenderHelper.INSTANCE.executeAction(((Color) this.getVisibleSettingProperty().getObject2()));
                                                                                    } else {
                                                                                        iterable = this.getNumericValue();
                                                                                        if (mouseX <= (this.getNumericValue() + 25.0F)) {
                                                                                        } else {
                                                                                        }
                                                                                        iterable = (this.getNumericValue2() + 38.0F);
                                                                                        if (mouseY <= (this.getNumericValue2() + 47.0F)) {
                                                                                        } else {
                                                                                        }
                                                                                        this.getVisibleSettingProperty().updateValue(NewThemeRenderHelper.INSTANCE.getColor());
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

    public void setValue(double mouseX, double mouseY) {
        this.enabledFlag2 = false;
        this.enabledFlag4 = false;
        this.enabledFlag3 = false;
    }

    public void setValue(int key) {
        Iterable iterable = ((Iterable) this.arrayList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SettingRenderHelper settingRenderHelper = ((SettingRenderHelper) element);
            settingRenderHelper.setValue(key);
            if (__UNDEF_KEY__ > 0) {
            }
        }
    }

    public void setValue(char charParam) {
        Iterable iterable = ((Iterable) this.arrayList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SettingRenderHelper settingRenderHelper = ((SettingRenderHelper) element);
            settingRenderHelper.setValue(charParam);
        }
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        if (!(this.enabledFlag)) {
            return false;
        }
        int index = 0;
        Iterable iterable = ((Iterable) this.arrayList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SettingRenderHelper settingRenderHelper = ((SettingRenderHelper) element);
            if (settingRenderHelper.checkCondition(mouseX, mouseY, verticalAmount)) {
                index = 1;
            }
        }
        return index;
    }

    public void setValue() {
        this.enabledFlag2 = false;
        this.enabledFlag4 = false;
        this.enabledFlag3 = false;
    }

}
