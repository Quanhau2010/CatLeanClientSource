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
            Object[] items = this.getVisibleSettingProperty().getObject2().getClass().getEnumConstants();
            int index = 0;
            int index2 = 0;
            Object[] items2 = items;
            if (index2 < items2) {
                Object element = items[index2];
                Enum value = element;
                this.itemList.add(new AnimationServiceComponent3(1.0F, this.factorValue, (this.getNumericValue3() - 11.0F), value));
                this.factorValue = (this.factorValue + 15.0F);
                if (__UNDEF_KEY__ > 0) {
                }
            }
            if (__UNDEF_KEY__ < 0) {
                items = 0.0F;
                items = 2.0F;
                index = this.getVisibleSettingProperty().getObject2().getClass().getEnumConstants();
                index2 = 0;
                index = ((Iterable) ArraysKt.sortedWith(index, ((Comparator) new Comparator11())));
                index2 = 0;
                items2 = index.iterator();
                while (items2.hasNext()) {
                    element = items2.next();
                    value = element;
                    String text = value.name();
                    float factor = (SFMServiceComponent.resolveFontRenderHelper4().computeValue(text) + 4.0F);
                    if (__UNDEF_KEY__ > 0) {
                        if ((items + factor) > (this.getNumericValue3() - 10.0F)) {
                            this.factorValue = (this.factorValue + 12.0F);
                            items = 2.0F;
                        }
                    }
                    this.itemList.add(new AnimationServiceComponent3(items, this.factorValue, factor, value));
                    items = (items + (factor + 2.0F));
                }
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
        if (this.enabledFlag2) {
            if (this.enabledFlag) {
            } else {
                if (this.enabledFlag) {
                } else {
                }
            }
        } else {
        }
        (this.factorValue + 28.0F).updateValue4(14.0F);
        if (this.enabledFlag) {
        } else {
        }
        this.executeAction(0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), this.getNumericValue(), (this.getNumericValue2() - 1.0F), (this.getNumericValue3() - 7.0F), (((this.easingServiceComponent.getNumericValue() * (this.getNumericValue4() - 14.0F)) + 14.0F) - 1.0F), 3.0F, 2.5F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(this.getNumericValue(), (this.getNumericValue2() - 1.0F), ((this.getNumericValue() + this.getNumericValue3()) - 7.0F), ((this.getNumericValue2() - 1.0F) + (((this.easingServiceComponent.getNumericValue() * (this.getNumericValue4() - 14.0F)) + 14.0F) - 1.0F))));
        float factor2 = (SFMServiceComponent.resolveFontRenderHelper3().computeValue(this.getVisibleSettingProperty().getString2()) / 2.0F);
        float factor3 = ((((this.getNumericValue3() - 16.0F) / 2.0F) - factor2) * this.easingServiceComponent.getNumericValue());
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), ((this.getNumericValue() + 3.0F) + factor3), this.getNumericValue2(), NewThemeRenderHelper.INSTANCE.getColor7(), false);
        String[] items = new String[1];
        items[0] = "_";
        String text = StringsKt.trim(((CharSequence) CollectionsKt.joinToString$default(((Iterable) StringsKt.split$default(((CharSequence) this.getVisibleSettingProperty().getObject2().name().toLowerCase(Locale.ROOT)), items, false)), ((CharSequence) " "), null, null, 0, null, this::resolveCharSequence))).toString();
        items = SFMServiceComponent.resolveFontRenderHelper3().computeValue(text);
        FontRenderHelper.v(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), text, ((((this.getNumericValue() + this.getNumericValue3()) - 11.0F) - items) + factor3), this.getNumericValue2(), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), (1.0F - this.easingServiceComponent.getNumericValue())), false);
        if (this.enabledFlag) {
            Iterable iterable = ((Iterable) this.itemList);
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                AnimationServiceComponent3 animationServiceComponent3 = ((AnimationServiceComponent3) element);
                if (Intrinsics.areEqual(animationServiceComponent3.getEnum(), this.getVisibleSettingProperty().getObject2())) {
                } else {
                }
                this.executeAction(0.0F);
                Color color = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor11(), animationServiceComponent3.getEasingServiceComponent().getNumericValue()).brighter();
                Color color2 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor13(), NewThemeRenderHelper.INSTANCE.getColor12(), animationServiceComponent3.getEasingServiceComponent().getNumericValue()).brighter();
                if (this.enabledFlag2) {
                    StackShaderComponent2.executeAction(context.method_51448(), ((this.getNumericValue() + animationServiceComponent3.getNumericValue()) + 1.0F), ((this.getNumericValue2() + animationServiceComponent3.getNumericValue2()) + 13.0F), animationServiceComponent3.getNumericValue3(), 13.0F, 2.0F, 2.5F, 0.8F, 1.0F, color, color2, 0.0F, 0.0F, 0.0F);
                    String[] items2 = new String[1];
                    items2[0] = "_";
                    SFMServiceComponent.resolveFontRenderHelper3().render(context, StringsKt.trim(((CharSequence) CollectionsKt.joinToString$default(((Iterable) StringsKt.split$default(((CharSequence) animationServiceComponent3.getEnum().name().toLowerCase(Locale.ROOT)), items2, false)), ((CharSequence) " "), null, null, 0, null, this::resolveCharSequence2))).toString(), (((this.getNumericValue() + animationServiceComponent3.getNumericValue()) + 1.0F) + (animationServiceComponent3.getNumericValue3() / 2.0F)), ((this.getNumericValue2() + animationServiceComponent3.getNumericValue2()) + 18.0F), NewThemeRenderHelper.INSTANCE.getColor7());
                    animationServiceComponent3.getEasingServiceComponent();
                }
                StackShaderComponent2.executeAction(context.method_51448(), ((this.getNumericValue() + animationServiceComponent3.getNumericValue()) + 1.0F), ((this.getNumericValue2() + animationServiceComponent3.getNumericValue2()) + 13.0F), animationServiceComponent3.getNumericValue3(), 10.0F, 2.0F, 2.5F, 0.8F, 1.0F, color, color2, 0.0F, 0.0F, 0.0F);
                items2 = new String[1];
                items2[0] = "_";
                SFMServiceComponent.resolveFontRenderHelper4().render(context, StringsKt.trim(((CharSequence) CollectionsKt.joinToString$default(((Iterable) StringsKt.split$default(((CharSequence) animationServiceComponent3.getEnum().name().toLowerCase(Locale.ROOT)), items2, false)), ((CharSequence) " "), null, null, 0, null, this::resolveCharSequence3))).toString(), (((this.getNumericValue() + animationServiceComponent3.getNumericValue()) + 1.0F) + (animationServiceComponent3.getNumericValue3() / 2.0F)), (((this.getNumericValue2() - 1.0F) + animationServiceComponent3.getNumericValue2()) + 18.0F), NewThemeRenderHelper.INSTANCE.getColor7());
                items2 = ((this.getNumericValue() + animationServiceComponent3.getNumericValue()) + 1.0F);
                float factor4 = (((this.getNumericValue() + animationServiceComponent3.getNumericValue()) + 1.0F) + animationServiceComponent3.getNumericValue3());
                int index = mouseX;
                if (items2 <= index) {
                } else {
                    if (index <= factor4) {
                        items2 = (((this.getNumericValue2() - 1.0F) + animationServiceComponent3.getNumericValue2()) + 14.0F);
                        factor4 = ((this.getNumericValue2() + animationServiceComponent3.getNumericValue2()) + 23.0F);
                        index = mouseY;
                        if (items2 <= index) {
                        } else {
                        }
                        if (index <= factor4 && GLFW.glfwGetPlatform() != 393219) {
                            GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221188));
                            CatleanInterfaceRenderHelper.INSTANCE.updateValue(false);
                        }
                    }
                }
            }
        }
        PolygonShaderComponent.INSTANCE.render(context);
    }

    public void setValue(double mouseX, double mouseY) {
        float factor = this.getNumericValue();
        if (__UNDEF_KEY__ >= 0L && __UNDEF_KEY__ != null) {
            if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 7.0F)) {
            } else {
                if (factor <= mouseX) {
                    factor = this.getNumericValue2();
                    if (__UNDEF_KEY__ > 0L && __UNDEF_KEY__ != null) {
                        if (mouseY <= (this.getNumericValue2() + 12)) {
                        } else {
                            if (factor <= mouseY) {
                                this.enabledFlag = !(this.enabledFlag);
                            }
                        }
                    }
                }
            }
        }
        factor = ((Iterable) this.itemList);
        Iterator iterator = factor.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            AnimationServiceComponent3 animationServiceComponent3 = ((AnimationServiceComponent3) element);
            float factor2 = ((this.getNumericValue() + animationServiceComponent3.getNumericValue()) + 1.0F);
            if (__UNDEF_KEY__ > 0L && __UNDEF_KEY__ != null) {
                if (mouseX <= (((this.getNumericValue() + animationServiceComponent3.getNumericValue()) + 1.0F) + animationServiceComponent3.getNumericValue3())) {
                } else {
                    if (factor2 <= mouseX) {
                        factor2 = (((this.getNumericValue2() - 1.0F) + animationServiceComponent3.getNumericValue2()) + 14.0F);
                        if (__UNDEF_KEY__ > 0L && __UNDEF_KEY__ != null) {
                            if (mouseY <= ((this.getNumericValue2() + animationServiceComponent3.getNumericValue2()) + 23.0F)) {
                            } else {
                                if (factor2 <= mouseY) {
                                    this.getVisibleSettingProperty().updateValue(animationServiceComponent3.getEnum());
                                }
                            }
                        }
                    }
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
        if (((CharSequence) arg0).length() > 0) {
            char ch = arg0.charAt(0);
            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            ch = arg0;
            index = 1;
        } else {
        }
        return ((CharSequence) arg0);
    }

    private static CharSequence resolveCharSequence2(String arg0) {
        if (((CharSequence) arg0).length() > 0) {
            char ch = arg0.charAt(0);
            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            ch = arg0;
            index = 1;
        } else {
        }
        return ((CharSequence) arg0);
    }

    private static CharSequence resolveCharSequence3(String arg0) {
        if (((CharSequence) arg0).length() > 0) {
            char ch = arg0.charAt(0);
            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            ch = arg0;
            index = 1;
        } else {
        }
        return ((CharSequence) arg0);
    }

}
