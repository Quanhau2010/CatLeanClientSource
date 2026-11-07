package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.lwjgl.glfw.GLFW;
import su.catlean.SharedKt;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.AnimationServiceComponent3;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.tools.comparators.Comparator11;
import su.catlean.client.types.TpYawSmootherMode;

public class SettingRenderHelper10 extends SettingRenderHelper16 {

    private final VisibleSettingProperty visibleSettingProperty;
    private boolean enabledFlag;
    private final EasingServiceComponent easingServiceComponent;
    private List itemList;
    private float factorValue;
    private boolean enabledFlag2;

    public SettingRenderHelper10(VisibleSettingProperty setting) {
        super(setting);
        this.visibleSettingProperty = setting;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, timestampValue);
        this.itemList = new ArrayList();
        if (this.enabledFlag2) {
            Object[] var17 = this.getVisibleSettingProperty().getObject2().getClass().getEnumConstants();
            int var18 = 0;
            int var19 = 0;
            Object var20 = var17;
            if (var19 < var20) {
                Object var21 = var17[var19];
                Enum var22 = var21;
                int var23 = 0;
                this.itemList.add(new AnimationServiceComponent3(1.0F, this.factorValue, (this.getNumericValue3() - 11.0F)));
                this.factorValue = (this.factorValue + 15.0F);
                if (0L > 0) {
                }
            }
            if (0L < 0) {
            }
            var17 = 0.0F;
            var17 = 2.0F;
            var18 = this.getVisibleSettingProperty().getObject2().getClass().getEnumConstants();
            var19 = 0;
            var18 = (Iterable) ArraysKt.sortedWith((Comparator) new Comparator11());
            var19 = 0;
            var20 = var18.iterator();
            if (var20.hasNext()) {
                var21 = var20.next();
                var22 = var21;
                var23 = 0;
                String var24 = var22.name();
                float var25 = (SFMServiceComponent.resolveFontRenderHelper4().computeValue() + 4.0F);
                if (0L > 0) {
                    if ((var17 + var25) > (this.getNumericValue3() - 10.0F)) {
                        this.factorValue = (this.factorValue + 12.0F);
                        var17 = 2.0F;
                    }
                }
                this.itemList.add(new AnimationServiceComponent3(this.factorValue));
                var17 = (var17 + (var25 + 2.0F));
            }
        }
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public List getList() {
        return this.itemList;
    }

    public void setValue(List value) {
        this.itemList = value;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float factor) {
        long var7 = (0L ^ 49494862758009L);
        long var9 = (0L ^ 39844814704388L);
        long var11 = (0L ^ 115096991696004L);
        long var13 = (0L ^ 127000398109451L);
        long var15 = ((0L ^ 57758330175306L) >>> 48);
        long var16 = (((0L ^ 57758330175306L) << 16) >>> 32);
        long var17 = (((0L ^ 57758330175306L) << 48) >>> 48);
        long var18 = (0L ^ 9915521765924L);
        long var20 = ((0L ^ 20797107207379L) >>> 48);
        long var21 = (((0L ^ 20797107207379L) << 16) >>> 48);
        long var22 = (((0L ^ 20797107207379L) << 32) >>> 32);
        long var23 = (0L ^ 114903264084220L);
        long var25 = (0L ^ 136713714549074L);
        long var27 = (0L ^ 120682356120742L);
        long var29 = (0L ^ 4763820429086L);
        long var31 = (0L ^ 57494645123396L);
        long var33 = ((0L ^ 22712070180255L) >>> 48);
        long var34 = (((0L ^ 22712070180255L) << 16) >>> 16);
        if (this.enabledFlag2) {
            if (this.enabledFlag) {
            } else {
            } else {
                if (this.enabledFlag) {
                } else {
                }
            }
        }
        (this.factorValue + 28.0F).updateValue4(14.0F);
        if (this.enabledFlag) {
        } else {
        }
        1.0F.executeAction(0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), this.getNumericValue(), (this.getNumericValue2() - 1.0F), (this.getNumericValue3() - 7.0F), (((this.easingServiceComponent.getNumericValue() * (this.getNumericValue4() - 14.0F)) + 14.0F) - 1.0F), 3.0F, 2.5F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(this.getNumericValue(), (this.getNumericValue2() - 1.0F), ((this.getNumericValue() + this.getNumericValue3()) - 7.0F), ((this.getNumericValue2() - 1.0F) + (((this.easingServiceComponent.getNumericValue() * (this.getNumericValue4() - 14.0F)) + 14.0F) - 1.0F))));
        float var37 = (SFMServiceComponent.resolveFontRenderHelper3().computeValue(this.getVisibleSettingProperty().getString2()) / 2.0F);
        float var38 = ((((this.getNumericValue3() - 16.0F) / 2.0F) - var37) * this.easingServiceComponent.getNumericValue());
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), ((this.getNumericValue() + 3.0F) + var38), this.getNumericValue2(), NewThemeRenderHelper.INSTANCE.getColor7());
        String[] var40 = new String[1];
        var40[0] = "_";
        String var39 = StringsKt.trim((CharSequence) CollectionsKt.joinToString$default((Iterable) StringsKt.split$default((CharSequence) this.getVisibleSettingProperty().getObject2().name().toLowerCase(Locale.ROOT)), (CharSequence) " ", null, null, 0, null, this::resolveCharSequence)).toString();
        var40 = SFMServiceComponent.resolveFontRenderHelper3().computeValue();
        FontRenderHelper.v(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), ((((this.getNumericValue() + this.getNumericValue3()) - 11.0F) - var40) + var38), this.getNumericValue2(), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), (1.0F - this.easingServiceComponent.getNumericValue())));
        if (this.enabledFlag) {
            Iterable var41 = (Iterable) this.itemList;
            int var42 = 0;
            Iterator iterator = var41.iterator();
            while (iterator.hasNext()) {
                Object var44 = iterator.next();
                AnimationServiceComponent3 var45 = (AnimationServiceComponent3) var44;
                int var46 = 0;
                if (Intrinsics.areEqual(var45.getEnum(), this.getVisibleSettingProperty().getObject2())) {
                } else {
                }
                1.0F.executeAction(0.0F);
                Color var47 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor11(), var45.getEasingServiceComponent().getNumericValue()).brighter();
                Color var48 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor13(), NewThemeRenderHelper.INSTANCE.getColor12(), var45.getEasingServiceComponent().getNumericValue()).brighter();
                if (this.enabledFlag2) {
                    StackShaderComponent2.executeAction(context.method_51448(), ((this.getNumericValue() + var45.getNumericValue()) + 1.0F), ((this.getNumericValue2() + var45.getNumericValue2()) + 13.0F), var45.getNumericValue3(), 13.0F, 2.0F, 2.5F, 0.8F, 1.0F, 0.0F, 0.0F, 0.0F);
                    String[] var49 = new String[1];
                    var49[0] = "_";
                    SFMServiceComponent.resolveFontRenderHelper3().render(context, StringsKt.trim((CharSequence) CollectionsKt.joinToString$default((Iterable) StringsKt.split$default((CharSequence) var45.getEnum().name().toLowerCase(Locale.ROOT)), (CharSequence) " ", null, null, 0, null, this::resolveCharSequence2)).toString(), (((this.getNumericValue() + var45.getNumericValue()) + 1.0F) + (var45.getNumericValue3() / 2.0F)), ((this.getNumericValue2() + var45.getNumericValue2()) + 18.0F), NewThemeRenderHelper.INSTANCE.getColor7());
                    if (0L > 0L) {
                        if (var36 == null) {
                        }
                    }
                    StackShaderComponent2.executeAction(context.method_51448(), ((this.getNumericValue() + var45.getNumericValue()) + 1.0F), ((this.getNumericValue2() + var45.getNumericValue2()) + 13.0F), var45.getNumericValue3(), 10.0F, 2.0F, 2.5F, 0.8F, 1.0F, 0.0F, 0.0F, 0.0F);
                    var49 = new String[1];
                    var49[0] = "_";
                    SFMServiceComponent.resolveFontRenderHelper4().render(context, StringsKt.trim((CharSequence) CollectionsKt.joinToString$default((Iterable) StringsKt.split$default((CharSequence) var45.getEnum().name().toLowerCase(Locale.ROOT)), (CharSequence) " ", null, null, 0, null, this::resolveCharSequence3)).toString(), (((this.getNumericValue() + var45.getNumericValue()) + 1.0F) + (var45.getNumericValue3() / 2.0F)), (((this.getNumericValue2() - 1.0F) + var45.getNumericValue2()) + 18.0F), NewThemeRenderHelper.INSTANCE.getColor7());
                }
                var49 = ((this.getNumericValue() + var45.getNumericValue()) + 1.0F);
                float var50 = (((this.getNumericValue() + var45.getNumericValue()) + 1.0F) + var45.getNumericValue3());
                int var51 = mouseX;
                if (0L >= 0L && var36 != null) {
                    if (var49 <= var51) {
                    }
                } else {
                }
                if (var51 <= var50) {
                    var49 = (((this.getNumericValue2() - 1.0F) + var45.getNumericValue2()) + 14.0F);
                    var50 = ((this.getNumericValue2() + var45.getNumericValue2()) + 23.0F);
                    var51 = mouseY;
                    if (0L > 0L && var36 != null) {
                        if (var49 <= var51) {
                        }
                    } else {
                    }
                    if (0L > 0L) {
                    }
                    if (var51 <= var50 && GLFW.glfwGetPlatform() != 393219) {
                        GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221188));
                        CatleanInterfaceRenderHelper.INSTANCE.updateValue(0);
                    }
                }
            }
        }
        PolygonShaderComponent.INSTANCE.render(context);
    }

    public void setValue(double mouseX, double mouseY) {
        float var9 = this.getNumericValue();
        if (0L >= 0L && var8 != null) {
            if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 7.0F)) {
            }
        } else {
        }
        if (var9 <= mouseX) {
            var9 = this.getNumericValue2();
            if (0L > 0L && var8 != null) {
                if (mouseY <= (this.getNumericValue2() + 12)) {
                }
            } else {
            }
            if (var9 <= mouseY) {
                this.enabledFlag = !(this.enabledFlag);
            }
        }
        var9 = (Iterable) this.itemList;
        int var10 = 0;
        Iterator iterator = var9.iterator();
        while (iterator.hasNext()) {
            Object var12 = iterator.next();
            AnimationServiceComponent3 var13 = (AnimationServiceComponent3) var12;
            int var14 = 0;
            float var15 = ((this.getNumericValue() + var13.getNumericValue()) + 1.0F);
            if (0L > 0L && var8 != null) {
                if (mouseX <= (((this.getNumericValue() + var13.getNumericValue()) + 1.0F) + var13.getNumericValue3())) {
                }
            } else {
            }
            if (var15 <= mouseX) {
                var15 = (((this.getNumericValue2() - 1.0F) + var13.getNumericValue2()) + 14.0F);
                if (0L > 0L && var8 != null) {
                    if (mouseY <= ((this.getNumericValue2() + var13.getNumericValue2()) + 23.0F)) {
                    }
                } else {
                }
                if (var15 <= mouseY) {
                    this.getVisibleSettingProperty().updateValue(var13.getEnum());
                }
            }
        }
    }

    public void setValue(double mouseX, double mouseY) {
    }

    public void setValue() {
    }

    public void setValue() {
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        return false;
    }

    public void setValue() {
    }

    private static CharSequence resolveCharSequence(String arg0) {
        Object var4 = arg0;
        if ((CharSequence) var4.length() > 0) {
            char var5 = var4.charAt(0);
            StringBuilder var7 = new StringBuilder();
            int var6 = 0;
            var5 = var4;
            var6 = 1;
        } else {
        }
        return (CharSequence) var4;
    }

    private static CharSequence resolveCharSequence2(String arg0) {
        Object var4 = arg0;
        if ((CharSequence) var4.length() > 0) {
            char var5 = var4.charAt(0);
            StringBuilder var7 = new StringBuilder();
            int var6 = 0;
            var5 = var4;
            var6 = 1;
        } else {
        }
        return (CharSequence) var4;
    }

    private static CharSequence resolveCharSequence3(String arg0) {
        Object var4 = arg0;
        if ((CharSequence) var4.length() > 0) {
            char var5 = var4.charAt(0);
            StringBuilder var7 = new StringBuilder();
            int var6 = 0;
            var5 = var4;
            var6 = 1;
        } else {
        }
        return (CharSequence) var4;
    }

}
