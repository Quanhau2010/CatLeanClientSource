package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2f;
import org.lwjgl.glfw.GLFW;
import su.catlean.SharedKt;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.SettingServiceComponent2;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.tools.comparators.Comparator8;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.TpYawSmootherMode;

public class SettingRenderHelper5 extends SettingRenderHelper16 {

    private final VisibleSettingProperty visibleSettingProperty;
    private final CatComponentRenderHelper catComponentRenderHelper;
    private final EasingServiceComponent easingServiceComponent;
    private final MissingnoRenderHelper missingnoRenderHelper;
    private List itemList;
    private float factorValue;

    public SettingRenderHelper5(VisibleSettingProperty setting, CatComponentRenderHelper module) {
        super(setting);
        this.visibleSettingProperty = setting;
        this.catComponentRenderHelper = module;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, timestampValue);
        this.missingnoRenderHelper = new MissingnoRenderHelper("extra", 10, 10);
        this.itemList = new ArrayList();
        if (((SettingGroup) this.getVisibleSettingProperty().getObject2()).getOptionMode14() == OptionMode14.BOOLS) {
            float factor = 0.0F;
            factor = 2.0F;
            Iterable iterable = ((Iterable) this.catComponentRenderHelper.getModule().getList());
            Iterable iterable2 = iterable;
            Collection collection = ((Collection) new ArrayList());
            int index = 0;
            Iterator iterator = iterable2.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                VisibleSettingProperty visibleSettingProperty = ((VisibleSettingProperty) element);
                collection.add(element);
            }
            iterable = ((Iterable) collection);
            iterable = ((Iterable) CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator8())));
            iterable2 = iterable.iterator();
            while (iterable2.hasNext()) {
                collection = iterable2.next();
                index = ((VisibleSettingProperty) collection);
                iterator = 0;
                element = index.getString2();
                visibleSettingProperty = (SFMServiceComponent.resolveFontRenderHelper4().computeValue(element) + 6.0F);
                if ((factor + visibleSettingProperty) > (this.getNumericValue3() - 10.0F)) {
                    this.factorValue = (this.factorValue + 12.0F);
                    factor = 2.0F;
                }
                this.itemList.add(new SettingServiceComponent2(factor, this.factorValue, visibleSettingProperty, index));
                factor = (factor + (visibleSettingProperty + 2.0F));
            }
        }
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public CatComponentRenderHelper getCatComponentRenderHelper() {
        return this.catComponentRenderHelper;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float factor) {
        if (__UNDEF_KEY__ != null) {
            if (((SettingGroup) this.getVisibleSettingProperty().getObject2()).getOptionMode14() == OptionMode14.BOOLS) {
                FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), this.getNumericValue(), (this.getNumericValue2() - 1.0F), NewThemeRenderHelper.INSTANCE.getColor7(), false);
                this.updateValue4((this.factorValue + 26.0F));
                Iterable iterable = ((Iterable) this.itemList);
                int index = 0;
                Iterator iterator = iterable.iterator();
                while (iterator.hasNext()) {
                    Object element = iterator.next();
                    SettingServiceComponent2 settingServiceComponent2 = ((SettingServiceComponent2) element);
                    if (__UNDEF_KEY__ != null) {
                        if (((Boolean) settingServiceComponent2.getVisibleSettingProperty().getObject2())) {
                        } else {
                        }
                        this.executeAction(0.0F);
                        Color color = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor11(), settingServiceComponent2.getEasingServiceComponent().getNumericValue()).brighter();
                        Color color2 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor13(), NewThemeRenderHelper.INSTANCE.getColor12(), settingServiceComponent2.getEasingServiceComponent().getNumericValue()).brighter();
                        StackShaderComponent2.executeAction(context.method_51448(), (this.getNumericValue() + settingServiceComponent2.getNumericValue()), ((this.getNumericValue2() + settingServiceComponent2.getNumericValue2()) + 13.0F), settingServiceComponent2.getNumericValue3(), 10.0F, 2.0F, 2.5F, 0.8F, 1.0F, color, color2, 0.0F, 0.0F, 0.0F);
                        SFMServiceComponent.resolveFontRenderHelper4().render(context, settingServiceComponent2.getVisibleSettingProperty().getString2(), (((this.getNumericValue() + settingServiceComponent2.getNumericValue()) + (settingServiceComponent2.getNumericValue3() / 2.0F)) - 1.0F), (((this.getNumericValue2() - 1.0F) + settingServiceComponent2.getNumericValue2()) + 18.0F), NewThemeRenderHelper.INSTANCE.getColor7());
                        float factor2 = ((this.getNumericValue() + settingServiceComponent2.getNumericValue()) + 1.0F);
                        float factor3 = (((this.getNumericValue() + settingServiceComponent2.getNumericValue()) + 1.0F) + settingServiceComponent2.getNumericValue3());
                        int index2 = mouseX;
                        if (__UNDEF_KEY__ != null) {
                            if (factor2 <= index2) {
                                if (__UNDEF_KEY__ != null) {
                                }
                            } else {
                                if (index2 <= factor3) {
                                    factor2 = (((this.getNumericValue2() - 1.0F) + settingServiceComponent2.getNumericValue2()) + 14.0F);
                                    factor3 = ((this.getNumericValue2() + settingServiceComponent2.getNumericValue2()) + 23.0F);
                                    index2 = mouseY;
                                    if (__UNDEF_KEY__ != null) {
                                        if (factor2 <= index2) {
                                            if (__UNDEF_KEY__ != null) {
                                            }
                                        } else {
                                        }
                                    }
                                    if (index2 <= factor3 && GLFW.glfwGetPlatform() != 393219) {
                                        GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221188));
                                        CatleanInterfaceRenderHelper.INSTANCE.updateValue(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (((SettingGroup) this.getVisibleSettingProperty().getObject2()).isActive()) {
        } else {
        }
        this.executeAction(0.0F);
        if (((SettingGroup) this.getVisibleSettingProperty().getObject2()).isActive()) {
        } else {
        }
        iterable = (1.0F + 0.0F);
        index = (this.easingServiceComponent.getNumericValue() * 2);
        this.updateValue4(13.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (this.getNumericValue() - index), (this.getNumericValue2() - 1.0F), ((this.getNumericValue3() - 7.0F) + (index * 2)), iterable, 3.0F, 2.5F, (this.easingServiceComponent.getNumericValue() / 2.0F), 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), (this.getNumericValue() + 3.0F), (this.getNumericValue2() - 1.0F), NewThemeRenderHelper.INSTANCE.getColor7(), false);
        MissingnoRenderHelper.executeAction(this.missingnoRenderHelper, ((Matrix3x2f) context.method_51448()), ((this.getNumericValue() + this.getNumericValue3()) - 18.0D), (this.getNumericValue2() - 1.0D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor7(), null, 0.0F);
    }

    public void setValue(double mouseX, double mouseY) {
        if (__UNDEF_KEY__ >= 0L) {
        }
        if (((SettingGroup) this.getVisibleSettingProperty().getObject2()).getOptionMode14() == OptionMode14.BOOLS) {
            Iterable iterable = ((Iterable) this.itemList);
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                SettingServiceComponent2 settingServiceComponent2 = ((SettingServiceComponent2) element);
                float factor = (this.getNumericValue() + settingServiceComponent2.getNumericValue());
                if (__UNDEF_KEY__ > 0L && __UNDEF_KEY__ != null) {
                    if (__UNDEF_KEY__ >= 0L && __UNDEF_KEY__ != null) {
                        if (mouseX <= ((this.getNumericValue() + settingServiceComponent2.getNumericValue()) + settingServiceComponent2.getNumericValue3())) {
                        } else {
                            if (factor <= mouseX) {
                                factor = (((this.getNumericValue2() - 1.0F) + settingServiceComponent2.getNumericValue2()) + 14.0F);
                                if (__UNDEF_KEY__ >= 0L && __UNDEF_KEY__ != null) {
                                    if (mouseY <= ((this.getNumericValue2() + settingServiceComponent2.getNumericValue2()) + 23.0F)) {
                                    } else {
                                        if (factor <= mouseY) {
                                            settingServiceComponent2.getVisibleSettingProperty().updateValue(Boolean.valueOf(!(((Boolean) settingServiceComponent2.getVisibleSettingProperty().getObject2()))));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (__UNDEF_KEY__ >= 0L) {
                    }
                }
            }
        } else {
            iterable = this.getNumericValue();
            if (__UNDEF_KEY__ >= 0L && __UNDEF_KEY__ != null) {
                if (mouseX <= (this.getNumericValue() + (this.getNumericValue3() - 7))) {
                } else {
                }
            }
            iterable = this.getNumericValue2();
            if (__UNDEF_KEY__ >= 0L && __UNDEF_KEY__ != null) {
                if (mouseY <= (this.getNumericValue2() + 13.0F)) {
                } else {
                }
            }
            ((SettingGroup) this.getVisibleSettingProperty().getObject2()).updateValue(!(((SettingGroup) this.getVisibleSettingProperty().getObject2()).isActive()));
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

}
