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
        int var19 = 4;
        int var20 = 0;
        if (var20 < var19) {
            int var21 = var20;
            int var22 = 0;
            this.arrayList.add(new SettingRenderHelper4((KMutableProperty0) new SettingServiceComponent3(this), this.factorValue, this.factorValue2));
            if (0L >= 0) {
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
        Matrix3x2fStack var59 = context.method_51448();
        SFMServiceComponent.resolveFontRenderHelper3().render(context, KeyServiceComponent.INSTANCE.resolveString(("hub.theme-editor." + this.textValue), new Object[0]), (this.factorValue - 1.0F), (this.factorValue2 - 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        if (this.enabledFlag) {
        } else {
        }
        65.0F.factorValue4 = 14.0F;
        if (this.enabledFlag) {
        } else {
        }
        1.0F.executeAction(0.0F);
        float var60 = (1.0F - this.easingServiceComponent.getNumericValue());
        if (this.enabledFlag) {
            float var61 = this.factorValue;
            float var62 = (this.factorValue + 25.0F);
            int var63 = mouseX;
            if (var61 <= var63) {
            } else {
            }
            if (var63 <= var62) {
                var61 = (this.factorValue2 + 24.0F);
                var62 = (this.factorValue2 + 34.0F);
                var63 = mouseY;
                if (var61 <= var63) {
                } else {
                }
                if (var63 <= var62) {
                }
            }
        } else {
        }
        }
        }
        1.0F.executeAction(0.0F);
        if (this.enabledFlag) {
            var61 = this.factorValue;
            var62 = (this.factorValue + 25.0F);
            var63 = mouseX;
            if (var61 <= var63) {
            } else {
            }
            if (var63 <= var62) {
                var61 = (this.factorValue2 + 38.0F);
                var62 = (this.factorValue2 + 47.0F);
                var63 = mouseY;
                if (var61 <= var63) {
                } else {
                }
                if (var63 <= var62) {
                }
            }
        } else {
        }
        }
        }
        1.0F.executeAction(0.0F);
        var61 = new float[3];
        Color.RGBtoHSB(this.colorValue.getRed(), this.colorValue.getGreen(), this.colorValue.getBlue());
        StackShaderComponent2.executeAction(context.method_51448(), ((this.factorValue + this.factorValue3) - 18.0F), (this.factorValue2 + (11 * this.easingServiceComponent.getNumericValue())), 11.0F, (11.0F * var60), 3.0F, 2.5F, 1.0F, 1.0F, this.colorValue, NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        if (this.enabledFlag) {
            MissingnoRenderHelper.executeAction(REDGuiElement.INSTANCE.getMissingnoRenderHelper(), (Matrix3x2f) context.method_51448(), ((this.factorValue + this.factorValue3) - 17.0D), (this.factorValue2 - 2.0D), 0.0F, 0.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), this.easingServiceComponent.getNumericValue()), null, 0.0F);
            int var44 = 3072;
            float var46 = 0.0F;
            Object var47 = var59;
            Color var48 = new Color(Color.HSBtoRGB(var61[0], 1.0F, 1.0F));
            Color var49 = new Color(0);
            ColorValue1RenderHelper.executeAction(((this.factorValue + this.factorValue3) - (48.0F * this.easingServiceComponent.getNumericValue())), (this.factorValue2 + (10.0F * this.easingServiceComponent.getNumericValue())), (40.0F * this.easingServiceComponent.getNumericValue()), (39.5F * this.easingServiceComponent.getNumericValue()), 3.0F, new Color(0), new Color(-1));
            var62 = (Iterable) this.arrayList;
            var63 = 0;
            Iterator iterator = var62.iterator();
            while (iterator.hasNext()) {
                Object var65 = iterator.next();
                SettingRenderHelper4 var66 = (SettingRenderHelper4) var65;
                int var67 = 0;
                var66.updateValue(this.factorValue);
                var66.updateValue2(this.factorValue2);
                var66.render(context);
            }
            iterator = "%02X%02X%02X";
            var65 = new Object[3];
            var65[0] = Integer.valueOf(this.colorValue.getRed());
            var65[1] = Integer.valueOf(this.colorValue.getGreen());
            var65[2] = Integer.valueOf(this.colorValue.getBlue());
            var62 = String.format(iterator, Arrays.copyOf());
            var63 = 3;
            iterator = 0;
            if (iterator < var63) {
                var65 = iterator;
                var66 = 0;
                var44 = 14336;
                float var45 = 0.0F;
                var46 = 0.0F;
                var47 = 0.0F;
                var48 = NewThemeRenderHelper.INSTANCE.getColor9();
                var49 = NewThemeRenderHelper.INSTANCE.getColor11();
                float var50 = 1.0F;
                float var51 = (this.easingServiceComponent3.getNumericValue() * 0.0F);
                float var52 = this.easingServiceComponent2.getNumericValue();
                int var53 = var65;
                float var54 = 0.5F;
                float var55 = (this.easingServiceComponent3.getNumericValue() + 0.0F);
                float var56 = this.easingServiceComponent2.getNumericValue();
                int var57 = var65;
                StackShaderComponent2.executeAction(2.0F);
                var67 = new String[3];
                var67[0] = var62;
                var67[1] = "Copy";
                var67[2] = "Paste";
                SFMServiceComponent.resolveFontRenderHelper4().render(context, (String) CollectionsKt.listOf().get(), (this.factorValue + 13.5F), ((this.factorValue2 + 14.5F) + (var65 * 14.0F)), NewThemeRenderHelper.INSTANCE.getColor7());
            }
            var63 = new Color[4];
            var63[0] = PolygonShaderComponent.INSTANCE.resolveColor(this.colorValue, 0.0F);
            var63[1] = PolygonShaderComponent.INSTANCE.resolveColor(this.colorValue, 0.0F);
            var63[2] = PolygonShaderComponent.INSTANCE.resolveColor(this.colorValue, 1.0F);
            var63[3] = PolygonShaderComponent.INSTANCE.resolveColor(this.colorValue, 1.0F);
            PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (this.factorValue + 61.0F), (this.factorValue2 + 10.0F), 2.0F, 39.0F);
            var63 = 1;
            if (var63 < 108) {
                iterator = Math.clamp((1.0F / (107.0F / ((var63 * this.easingServiceComponent.getNumericValue()) * this.easingServiceComponent.getNumericValue()))), 0.0F, 1.0F);
                var65 = Color.getHSBColor(iterator, 1.0F, 1.0F);
                var66 = new Color[4];
                var66[0] = var65;
                var66[1] = var65;
                var66[2] = var65;
                var66[3] = var65;
                PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (this.factorValue + var63), (this.factorValue2 + 55.0F), 1.0F, 2.0F);
            }
            this.executeAction(mouseX);
            this.executeAction(mouseX, mouseY);
            this.executeAction(mouseY);
        }
        this.executeAction(this.idRecord6);
    }

    private void executeAction(Matrix3x2fStack arg0, int arg1, int arg2) {
        float var13 = (((this.factorValue + this.factorValue3) - 48.0F) + 2.0F);
        float var14 = ((this.factorValue2 + 10.0F) + 2.0F);
        Object var15 = new float[3];
        Color.RGBtoHSB(this.colorValue.getRed(), this.colorValue.getGreen(), this.colorValue.getBlue());
        StackShaderComponent2.executeAction(arg0, ((var13 - 4.0F) + (40 * var15[1])), ((var14 - 4.0F) + (40 * (1.0F - var15[2]))), 7.0F, 7.0F, 2.5F, 1.5F, 1.0F, 1.0F, this.colorValue, Color.BLACK, 0.0F, 0.0F, 0.0F);
        float var16 = Math.clamp(((arg1 - var13) / 40.0F), 0.0F, 1.0F);
        float var17 = Math.clamp((1.0F - ((arg2 - var14) / 40.0F)), 0.0F, 1.0F);
        this.colorValue = PolygonShaderComponent.INSTANCE.resolveColor(new Color(Color.HSBtoRGB(var15[0])), (this.colorValue.getAlpha() / 255.0F));
    }

    private void executeAction(Matrix3x2fStack arg0, int arg1) {
        float var12 = (this.factorValue2 + 11.0F);
        StackShaderComponent2.executeAction(arg0, (this.factorValue + 58.0F), ((var12 - 4.0F) + (38 * (1.0F - (this.colorValue.getAlpha() / 255.0F)))), 7.0F, 7.0F, 2.5F, 1.0F, 1.0F, 1.0F, this.colorValue, PolygonShaderComponent.INSTANCE.resolveColor(this.colorValue, 1.0F), 0.0F, 0.0F, 0.0F);
        if (var11 != null) {
        }
        this.colorValue = PolygonShaderComponent.INSTANCE.resolveColor(this.colorValue, Math.clamp((1.0F - ((arg1 - var12) / 39.0F)), 0.0F, 1.0F));
    }

    private void executeAction(Matrix3x2fStack arg0, int arg1) {
        float var15 = this.factorValue;
        Object var16 = new float[3];
        Color.RGBtoHSB(this.colorValue.getRed(), this.colorValue.getGreen(), this.colorValue.getBlue());
        StackShaderComponent2.executeAction(arg0, ((var15 - 3.5F) + (106 * var16[0])), (this.factorValue2 + 52.0F), 7.0F, 7.0F, 2.5F, 1.0F, 1.0F, 1.0F, new Color(Color.HSBtoRGB(var16[0], 1.0F, 1.0F)), new Color(Color.HSBtoRGB(var16[0], 1.0F, 1.0F)), 0.0F, 0.0F, 0.0F);
        float var17 = Math.clamp(((arg1 - var15) / 107.0F), 0.0F, 1.0F);
        this.colorValue = PolygonShaderComponent.INSTANCE.resolveColor(new Color(Color.HSBtoRGB(var16[1], var16[2])), (this.colorValue.getAlpha() / 255.0F));
    }

    public void executeAction(double mouseX, double mouseY) {
        float var13 = this.factorValue;
        if (mouseX <= (this.factorValue + this.factorValue3)) {
        } else {
        }
        if (var13 <= mouseX) {
            var13 = this.factorValue2;
            if (mouseY <= (this.factorValue2 + 8.0F)) {
            } else {
            }
            if (var13 <= mouseY) {
                this.enabledFlag = !(this.enabledFlag);
                this.enabledFlag3 = 0;
                this.enabledFlag4 = 0;
                this.enabledFlag2 = 0;
                return;
            }
        }
        if (!(this.enabledFlag)) {
            return;
        }
        var13 = (Iterable) this.arrayList;
        int var14 = 0;
        Iterator iterator = var13.iterator();
        while (iterator.hasNext()) {
            Object var16 = iterator.next();
            SettingRenderHelper4 var17 = (SettingRenderHelper4) var16;
            int var18 = 0;
            var17.setValue(mouseX, mouseY);
        }
        if (this.enabledFlag) {
            var13 = (this.factorValue + 57.0F);
            if (mouseX <= (this.factorValue + 68.0F)) {
            } else {
            }
            if (var13 <= mouseX) {
                var13 = (this.factorValue2 + 11.0F);
                if (mouseY <= (this.factorValue2 + 50.0F)) {
                } else {
                }
                if (var13 <= mouseY) {
                    this.enabledFlag3 = 1;
                }
            }
        } else {
            if (this.enabledFlag) {
                var13 = this.factorValue;
                if (mouseX <= (this.factorValue + 108.0F)) {
                } else {
                }
                if (var13 <= mouseX) {
                    var13 = (this.factorValue2 + 53.0F);
                    if (mouseY <= (this.factorValue2 + 58.0F)) {
                    } else {
                    }
                    if (var13 <= mouseY) {
                        this.enabledFlag4 = 1;
                    }
                }
            } else {
                if (this.enabledFlag) {
                    var13 = ((this.factorValue + this.factorValue3) - 48.0F);
                    if (mouseX <= ((this.factorValue + this.factorValue3) - 8.0F)) {
                    } else {
                    }
                    if (var13 <= mouseX) {
                        var13 = (this.factorValue2 + 11.0F);
                        if (mouseY <= (this.factorValue2 + 51.0F)) {
                        } else {
                        }
                        if (var13 <= mouseY) {
                            this.enabledFlag2 = 1;
                        }
                    }
                } else {
                    if (this.enabledFlag) {
                        var13 = this.factorValue;
                        if (mouseX <= (this.factorValue + 25.0F)) {
                        } else {
                        }
                        if (var13 <= mouseX) {
                            var13 = (this.factorValue2 + 24.0F);
                            if (mouseY <= (this.factorValue2 + 34.0F)) {
                            } else {
                            }
                            if (var13 <= mouseY) {
                                NewThemeRenderHelper.INSTANCE.executeAction(this.colorValue);
                            }
                        }
                    } else {
                        var13 = this.factorValue;
                        if (mouseX <= (this.factorValue + 25.0F)) {
                        } else {
                        }
                        var13 = (this.factorValue2 + 38.0F);
                        if (mouseY <= (this.factorValue2 + 47.0F)) {
                        } else {
                        }
                        this.colorValue = NewThemeRenderHelper.INSTANCE.getColor();
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
        this.enabledFlag2 = 0;
        this.enabledFlag4 = 0;
        this.enabledFlag3 = 0;
    }

    public void executeAction(int key) {
        if (var6 != null) {
        }
        Iterable var7 = (Iterable) this.arrayList;
        int var8 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var10 = iterator.next();
            SettingRenderHelper4 var11 = (SettingRenderHelper4) var10;
            int var12 = 0;
            var11.setValue(key);
        }
    }

    public void executeAction(char char) {
        if (var7 != null) {
        }
        Iterable var8 = (Iterable) this.arrayList;
        int var9 = 0;
        Iterator iterator = var8.iterator();
        if (iterator.hasNext()) {
            Object var11 = iterator.next();
            SettingRenderHelper4 var12 = (SettingRenderHelper4) var11;
            int var13 = 0;
            var12.setValue(char);
        }
    }

    public void executeAction(double mouseX, double mouseY, double verticalAmount) {
        if (var11 != null) {
        }
        Iterable var12 = (Iterable) this.arrayList;
        int var13 = 0;
        Iterator iterator = var12.iterator();
        if (iterator.hasNext()) {
            Object var15 = iterator.next();
            SettingRenderHelper4 var16 = (SettingRenderHelper4) var15;
            int var17 = 0;
            var16.setValue(mouseX, mouseY, verticalAmount);
        }
    }

    private void executeAction(IdRecord6 arg0) {
        String var31 = this.textValue;
        if (!(var31.equals("secondary"))) {
            if (!(var31.equals("widget-blur"))) {
                if (!(var31.equals("outline"))) {
                    if (!(var31.equals("inactive-module-outline"))) {
                        if (!(var31.equals("inactive-text"))) {
                            if (!(var31.equals("inactive-module"))) {
                                if (!(var31.equals("module"))) {
                                    if (!(var31.equals("module-outline"))) {
                                        if (!(var31.equals("blur"))) {
                                            if (!(var31.equals("text"))) {
                                                if (!(var31.equals("sliders"))) {
                                                    arg0.executeAction(this.colorValue);
                                                } else {
                                                    arg0.executeAction(this.colorValue);
                                                } else {
                                                    arg0.executeAction2(this.colorValue);
                                                } else {
                                                    arg0.executeAction3(this.colorValue);
                                                } else {
                                                    arg0.executeAction2(this.colorValue);
                                                } else {
                                                    arg0.executeAction4(this.colorValue);
                                                } else {
                                                    arg0.executeAction5(this.colorValue);
                                                } else {
                                                    arg0.executeAction(this.colorValue);
                                                } else {
                                                    arg0.executeAction3(this.colorValue);
                                                } else {
                                                    arg0.executeAction(this.colorValue);
                                                } else {
                                                    arg0.executeAction4(this.colorValue);
                                                } else {
                                                    arg0.executeAction6(this.colorValue);
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
