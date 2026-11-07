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
        int var11 = 4;
        int var12 = 0;
        if (var12 < var11) {
            int var13 = var12;
            int var14 = 0;
            this.arrayList.add(new SettingRenderHelper(this.getVisibleSettingProperty(), this.getNumericValue(), this.getNumericValue2()));
        }
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float factor) {
        long var7 = (0L ^ 39844814704388L);
        long var9 = (0L ^ 68939168652928L);
        long var11 = (0L ^ 115096991696004L);
        long var13 = (0L ^ 127000398109451L);
        long var15 = ((0L ^ 57758330175306L) >>> 48);
        long var16 = (((0L ^ 57758330175306L) << 16) >>> 32);
        long var17 = (((0L ^ 57758330175306L) << 48) >>> 48);
        long var18 = (0L ^ 133532887051749L);
        long var20 = ((0L ^ 20797107207379L) >>> 48);
        long var21 = (((0L ^ 20797107207379L) << 16) >>> 48);
        long var22 = (((0L ^ 20797107207379L) << 32) >>> 32);
        long var23 = (0L ^ 81750728905703L);
        long var25 = ((0L ^ 88672139111771L) >>> 48);
        long var26 = (((0L ^ 88672139111771L) << 16) >>> 32);
        long var27 = (((0L ^ 88672139111771L) << 48) >>> 48);
        long var28 = (0L ^ 105309425727100L);
        long var30 = (0L ^ 114903264084220L);
        long var32 = (0L ^ 24369959771588L);
        long var34 = (0L ^ 120682356120742L);
        long var36 = (0L ^ 135435160666308L);
        Matrix3x2fStack var54 = context.method_51448();
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), this.getNumericValue(), this.getNumericValue2(), NewThemeRenderHelper.INSTANCE.getColor7());
        if (this.enabledFlag) {
        } else {
        }
        65.0F.updateValue4(14.0F);
        if (this.enabledFlag) {
        } else {
        }
        1.0F.executeAction(0.0F);
        float var55 = (1.0F - this.easingServiceComponent.getNumericValue());
        if (var53 != null) {
            if (this.enabledFlag) {
            }
            float var56 = this.getNumericValue();
            float var57 = (this.getNumericValue() + 25.0F);
            int var58 = mouseX;
            if (0L >= 0L) {
                if (var53 != null) {
                    if (var56 <= var58) {
                    }
                }
                if (var53 != null) {
                }
            } else {
            }
            if (var58 <= var57) {
                var56 = (this.getNumericValue2() + 24.0F);
                var57 = (this.getNumericValue2() + 34.0F);
                var58 = mouseY;
                if (0L >= 0L) {
                    if (var53 != null) {
                        if (var56 <= var58) {
                        }
                    }
                    if (var53 != null) {
                    }
                } else {
                }
                if (var58 <= var57) {
                }
            }
        } else {
        }
        }
        }
        if (0L > 0L) {
            1.0F.executeAction(0.0F);
            if (var53 != null) {
                if (this.enabledFlag) {
                }
            }
            var56 = this.getNumericValue();
            var57 = (this.getNumericValue() + 25.0F);
            var58 = mouseX;
            if (0L >= 0L) {
                if (var53 != null) {
                    if (var56 <= var58) {
                    }
                }
                if (var53 != null) {
                }
            } else {
            }
            if (var58 <= var57) {
                var56 = (this.getNumericValue2() + 38.0F);
                var57 = (this.getNumericValue2() + 47.0F);
                var58 = mouseY;
                if (0L >= 0L) {
                    if (var53 != null) {
                        if (var56 <= var58) {
                        }
                    }
                    if (var53 != null) {
                    }
                } else {
                }
                if (var58 <= var57) {
                }
            }
        } else {
        }
        }
        }
        1.0F.executeAction(0.0F);
        var56 = new float[3];
        if (0L >= 0L) {
            Color.RGBtoHSB((Color) this.getVisibleSettingProperty().getObject2().getRed(), (Color) this.getVisibleSettingProperty().getObject2().getGreen(), (Color) this.getVisibleSettingProperty().getObject2().getBlue());
            StackShaderComponent2.executeAction(((this.getNumericValue() + this.getNumericValue3()) - 18.0F), (this.getNumericValue2() + (11 * this.easingServiceComponent.getNumericValue())), 11.0F, (11.0F * var55), 3.0F, 2.5F, 1.0F, 1.0F, (Color) this.getVisibleSettingProperty().getObject2(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
            if (var53 != null) {
            }
            MissingnoRenderHelper.executeAction(REDGuiElement.INSTANCE.getMissingnoRenderHelper(), (Matrix3x2f) context.method_51448(), ((this.getNumericValue() + this.getNumericValue3()) - 17.0D), (this.getNumericValue2() - 2), 0.0F, 0.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), this.easingServiceComponent.getNumericValue()), null, 0.0F);
            int var39 = 3072;
            float var41 = 0.0F;
            Object var42 = var54;
            Color var43 = new Color(Color.HSBtoRGB(var56[0], 1.0F, 1.0F));
            Color var44 = new Color(0);
            ColorValue1RenderHelper.executeAction(((this.getNumericValue() + this.getNumericValue3()) - (48.0F * this.easingServiceComponent.getNumericValue())), (this.getNumericValue2() + (10.0F * this.easingServiceComponent.getNumericValue())), (40.0F * this.easingServiceComponent.getNumericValue()), (39.5F * this.easingServiceComponent.getNumericValue()), 3.0F, new Color(0), new Color(-1));
        }
        var57 = (Iterable) this.arrayList;
        var58 = 0;
        Iterator iterator = var57.iterator();
        if (iterator.hasNext()) {
            Object var60 = iterator.next();
            SettingRenderHelper var61 = (SettingRenderHelper) var60;
            if (0L > 0L) {
                int var62 = 0;
                var61.updateValue(this.getNumericValue());
                var61.updateValue2(this.getNumericValue2());
                var61.render(context);
                if (var53 != null) {
                }
            }
        }
        iterator = "%02X%02X%02X";
        var60 = new Object[3];
        var60[0] = Integer.valueOf((Color) this.getVisibleSettingProperty().getObject2().getRed());
        var60[1] = Integer.valueOf((Color) this.getVisibleSettingProperty().getObject2().getGreen());
        var60[2] = Integer.valueOf((Color) this.getVisibleSettingProperty().getObject2().getBlue());
        var57 = String.format(iterator, Arrays.copyOf());
        var58 = 3;
        iterator = 0;
        if (iterator < var58) {
            var60 = iterator;
            var61 = 0;
            if (var53 != null) {
                var39 = 14336;
                float var40 = 0.0F;
                var41 = 0.0F;
                var42 = 0.0F;
                var43 = NewThemeRenderHelper.INSTANCE.getColor9();
                var44 = NewThemeRenderHelper.INSTANCE.getColor11();
                float var45 = 1.0F;
                float var46 = (this.easingServiceComponent3.getNumericValue() * 0.0F);
                float var47 = this.easingServiceComponent2.getNumericValue();
                int var48 = var60;
                float var49 = 0.5F;
                float var50 = (this.easingServiceComponent3.getNumericValue() + 0.0F);
                float var51 = this.easingServiceComponent2.getNumericValue();
                int var52 = var60;
                StackShaderComponent2.executeAction(2.0F);
                var62 = new String[3];
                var62[0] = var57;
                var62[1] = "Copy";
                var62[2] = "Paste";
                SFMServiceComponent.resolveFontRenderHelper4().render(context, (String) CollectionsKt.listOf().get(), (this.getNumericValue() + 13.5F), ((this.getNumericValue2() + 14.5F) + (var60 * 14.0F)), NewThemeRenderHelper.INSTANCE.getColor7());
            }
            var58 = new Color[4];
            var58[0] = PolygonShaderComponent.INSTANCE.resolveColor((Color) this.getVisibleSettingProperty().getObject2(), 0.0F);
            var58[1] = PolygonShaderComponent.INSTANCE.resolveColor((Color) this.getVisibleSettingProperty().getObject2(), 0.0F);
            var58[2] = PolygonShaderComponent.INSTANCE.resolveColor((Color) this.getVisibleSettingProperty().getObject2(), 1.0F);
            var58[3] = PolygonShaderComponent.INSTANCE.resolveColor((Color) this.getVisibleSettingProperty().getObject2(), 1.0F);
            PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (this.getNumericValue() + 61.0F), (this.getNumericValue2() + 10.0F), 2.0F, 39.0F);
            var58 = 1;
            iterator = var58;
        }
        var60 = Math.clamp((1.0F / (107.0F / ((iterator * this.easingServiceComponent.getNumericValue()) * this.easingServiceComponent.getNumericValue()))), 0.0F, 1.0F);
        var61 = Color.getHSBColor(1.0F, 1.0F);
        var62 = new Color[4];
        var62[0] = var61;
        var62[1] = var61;
        var62[2] = var61;
        var62[3] = var61;
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (this.getNumericValue() + iterator), (this.getNumericValue2() + 55.0F), 1.0F, 2.0F);
        this.setValue(mouseX);
        this.setValue(mouseX, mouseY);
        this.setValue(mouseY);
    }

    private void setValue(Matrix3x2fStack arg0, int arg1, int arg2) {
        float var13 = (((this.getNumericValue() + this.getNumericValue3()) - 48.0F) + 2.0F);
        float var14 = ((this.getNumericValue2() + 10.0F) + 2.0F);
        Object var15 = new float[3];
        Color.RGBtoHSB((Color) this.getVisibleSettingProperty().getObject2().getRed(), (Color) this.getVisibleSettingProperty().getObject2().getGreen(), (Color) this.getVisibleSettingProperty().getObject2().getBlue());
        StackShaderComponent2.executeAction(arg0, ((var13 - 4.0F) + (40 * var15[1])), ((var14 - 4.0F) + (40 * (1.0F - var15[2]))), 7.0F, 7.0F, 2.5F, 1.5F, 1.0F, 1.0F, (Color) this.getVisibleSettingProperty().getObject2(), Color.BLACK, 0.0F, 0.0F, 0.0F);
        float var16 = Math.clamp(((arg1 - var13) / 40.0F), 0.0F, 1.0F);
        float var17 = Math.clamp((1.0F - ((arg2 - var14) / 40.0F)), 0.0F, 1.0F);
        this.getVisibleSettingProperty().updateValue(PolygonShaderComponent.INSTANCE.resolveColor(new Color(Color.HSBtoRGB(var15[0])), ((Color) this.getVisibleSettingProperty().getObject2().getAlpha() / 255.0F)));
    }

    private void setValue(Matrix3x2fStack arg0, int arg1) {
        float var11 = (this.getNumericValue2() + 11.0F);
        StackShaderComponent2.executeAction(arg0, (this.getNumericValue() + 58.0F), ((var11 - 4.0F) + (38 * (1.0F - ((Color) this.getVisibleSettingProperty().getObject2().getAlpha() / 255.0F)))), 7.0F, 7.0F, 2.5F, 1.0F, 1.0F, 1.0F, (Color) this.getVisibleSettingProperty().getObject2(), PolygonShaderComponent.INSTANCE.resolveColor((Color) this.getVisibleSettingProperty().getObject2(), 1.0F), 0.0F, 0.0F, 0.0F);
        float var12 = Math.clamp((1.0F - ((arg1 - var11) / 39.0F)), 0.0F, 1.0F);
        this.getVisibleSettingProperty().updateValue(PolygonShaderComponent.INSTANCE.resolveColor((Color) this.getVisibleSettingProperty().getObject2()));
    }

    private void setValue(Matrix3x2fStack arg0, int arg1) {
        float var15 = this.getNumericValue();
        Object var16 = new float[3];
        Color.RGBtoHSB((Color) this.getVisibleSettingProperty().getObject2().getRed(), (Color) this.getVisibleSettingProperty().getObject2().getGreen(), (Color) this.getVisibleSettingProperty().getObject2().getBlue());
        StackShaderComponent2.executeAction(arg0, ((var15 - 3.5F) + (106 * var16[0])), (this.getNumericValue2() + 52.0F), 7.0F, 7.0F, 2.5F, 1.0F, 1.0F, 1.0F, new Color(Color.HSBtoRGB(var16[0], 1.0F, 1.0F)), new Color(Color.HSBtoRGB(var16[0], 1.0F, 1.0F)), 0.0F, 0.0F, 0.0F);
        float var17 = Math.clamp(((arg1 - var15) / 107.0F), 0.0F, 1.0F);
        this.getVisibleSettingProperty().updateValue(PolygonShaderComponent.INSTANCE.resolveColor(new Color(Color.HSBtoRGB(var16[1], var16[2])), ((Color) this.getVisibleSettingProperty().getObject2().getAlpha() / 255.0F)));
    }

    public void setValue(double mouseX, double mouseY) {
        long var8 = (0L ^ 138687564201394L);
        long var10 = (0L ^ 17677138035447L);
        Iterable var13 = (Iterable) this.arrayList;
        int var14 = 0;
        Iterator iterator = var13.iterator();
        while (iterator.hasNext()) {
            Object var16 = iterator.next();
            SettingRenderHelper var17 = (SettingRenderHelper) var16;
            int var18 = 0;
            var17.setValue(mouseX, mouseY);
            if (0L <= 0L || var12 != null) {
                continue;
            }
        }
        var13 = this.getNumericValue();
        if (0L >= 0L && var12 != null) {
            if (mouseX <= (this.getNumericValue() + this.getNumericValue3())) {
            }
        } else {
        }
        if (var13 <= mouseX) {
            var13 = this.getNumericValue2();
            if (0L >= 0L && var12 != null) {
                if (mouseY <= (this.getNumericValue2() + 8.0F)) {
                }
            } else {
            }
            if (0L >= 0L) {
                if (var13 <= mouseY) {
                    this.enabledFlag = !(this.enabledFlag);
                    this.enabledFlag3 = 0;
                    this.enabledFlag4 = 0;
                    this.enabledFlag2 = 0;
                    return;
                }
            }
        }
        if (0L > 0L) {
            if (var12 != null) {
                if (this.enabledFlag) {
                    var13 = (this.getNumericValue() + 57.0F);
                    if (0L >= 0L && var12 != null) {
                        if (mouseX <= (this.getNumericValue() + 68.0F)) {
                        }
                    } else {
                    }
                    if (var13 <= mouseX) {
                        var13 = (this.getNumericValue2() + 11.0F);
                        if (0L > 0L && var12 != null) {
                            if (mouseY <= (this.getNumericValue2() + 50.0F)) {
                            }
                        } else {
                        }
                        if (0L >= 0L) {
                            if (var13 <= mouseY) {
                                this.enabledFlag3 = 1;
                            }
                        }
                    } else {
                    }
                }
            }
            if (0L > 0L) {
                if (var12 != null) {
                    if (this.enabledFlag) {
                        var13 = this.getNumericValue();
                        if (0L > 0L && var12 != null) {
                            if (mouseX <= (this.getNumericValue() + 108.0F)) {
                            }
                        } else {
                        }
                        if (var13 <= mouseX) {
                            var13 = (this.getNumericValue2() + 53.0F);
                            if (0L >= 0L && var12 != null) {
                                if (mouseY <= (this.getNumericValue2() + 58.0F)) {
                                }
                            } else {
                            }
                            if (0L >= 0L) {
                                if (var13 <= mouseY) {
                                    this.enabledFlag4 = 1;
                                }
                            }
                        } else {
                        }
                    }
                }
                if (0L >= 0L) {
                    if (var12 != null) {
                        if (this.enabledFlag) {
                            var13 = ((this.getNumericValue() + this.getNumericValue3()) - 48.0F);
                            if (0L >= 0L && var12 != null) {
                                if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 8.0F)) {
                                }
                            } else {
                            }
                            if (var13 <= mouseX) {
                                var13 = (this.getNumericValue2() + 11.0F);
                                if (0L > 0L && var12 != null) {
                                    if (mouseY <= (this.getNumericValue2() + 51.0F)) {
                                    }
                                } else {
                                }
                                if (0L >= 0L) {
                                    if (var13 <= mouseY) {
                                        this.enabledFlag2 = 1;
                                    }
                                }
                            } else {
                            }
                        }
                    }
                    if (0L >= 0L) {
                        if (var12 != null) {
                            if (this.enabledFlag) {
                                var13 = this.getNumericValue();
                                if (0L > 0L && var12 != null) {
                                    if (mouseX <= (this.getNumericValue() + 25.0F)) {
                                    }
                                } else {
                                }
                                if (var13 <= mouseX) {
                                    var13 = (this.getNumericValue2() + 24.0F);
                                    if (0L > 0L && var12 != null) {
                                        if (mouseY <= (this.getNumericValue2() + 34.0F)) {
                                        }
                                    } else {
                                    }
                                    if (0L >= 0L) {
                                        if (var13 <= mouseY) {
                                            NewThemeRenderHelper.INSTANCE.executeAction((Color) this.getVisibleSettingProperty().getObject2());
                                        }
                                    }
                                } else {
                                }
                            }
                        }
                        if (0L >= 0L) {
                            if (var12 != null) {
                                var13 = this.getNumericValue();
                            }
                        }
                        if (0L > 0L && var12 != null) {
                            if (mouseX <= (this.getNumericValue() + 25.0F)) {
                            }
                        } else {
                        }
                        var13 = (this.getNumericValue2() + 38.0F);
                        if (0L > 0L && var12 != null) {
                            if (mouseY <= (this.getNumericValue2() + 47.0F)) {
                            }
                        } else {
                        }
                        this.getVisibleSettingProperty().updateValue(NewThemeRenderHelper.INSTANCE.getColor());
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
        this.enabledFlag2 = 0;
        this.enabledFlag4 = 0;
        this.enabledFlag3 = 0;
    }

    public void setValue(int key) {
        int var5 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        long var7 = ((var5 ^ 70303453601542L) >>> 56);
        long var8 = (((var5 ^ 70303453601542L) << 8) >>> 8);
        Iterable var11 = (Iterable) this.arrayList;
        int var12 = 0;
        Iterator iterator = var11.iterator();
        if (iterator.hasNext()) {
            Object var14 = iterator.next();
            SettingRenderHelper var15 = (SettingRenderHelper) var14;
            int var16 = 0;
            var15.setValue(key);
            if (0L > 0) {
            }
        }
    }

    public void setValue(char char) {
        long var4 = (0L ^ 78532298840237L);
        Iterable var7 = (Iterable) this.arrayList;
        int var8 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var10 = iterator.next();
            SettingRenderHelper var11 = (SettingRenderHelper) var10;
            int var12 = 0;
            var11.setValue(char);
            if (0L > 0L) {
            }
        }
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        int var10 = ((0L << 56) | ((0L << 8) >>> 8));
        long var12 = (var10 ^ 89558228970238L);
        if (!(this.enabledFlag)) {
            return false;
        }
        int var15 = 0;
        Iterable var16 = (Iterable) this.arrayList;
        int var17 = 0;
        Iterator iterator = var16.iterator();
        while (iterator.hasNext()) {
            Object var19 = iterator.next();
            SettingRenderHelper var20 = (SettingRenderHelper) var19;
            int var21 = 0;
            if (var20.checkCondition(mouseX, mouseY, verticalAmount)) {
                var15 = 1;
            }
        }
        return var15;
    }

    public void setValue() {
        this.enabledFlag2 = 0;
        this.enabledFlag4 = 0;
        this.enabledFlag3 = 0;
    }

}
