package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2f;
import su.catlean.SharedKt;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.EnabledServiceComponent;
import su.catlean.client.services.client.EventServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.client.StartupServiceComponent;
import su.catlean.client.services.client.SubCategoriesServiceComponent;
import su.catlean.client.services.client.SubCategoryServiceComponent;
import su.catlean.client.services.client.VecServiceComponent;
import su.catlean.client.services.client.module.category.SubCategory;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.tools.comparators.Comparator19;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.ui.clickgui.REDGuiElement;

public class CategoryRenderHelper {

    private final SubCategoriesServiceComponent subCategoriesServiceComponent;
    private int countValue;
    private int countValue2;
    private int countValue3;
    private int countValue4;
    private int countValue5;
    private float factorValue;
    private float factorValue2;
    private SubCategoryServiceComponent subCategoryServiceComponent;
    private SubCategoryServiceComponent subCategoryServiceComponent2;
    private int countValue6;
    private final ArrayList arrayList;
    private final ArrayList arrayList2;
    private final EasingServiceComponent easingServiceComponent;
    private final EasingServiceComponent easingServiceComponent2;
    private final EasingServiceComponent easingServiceComponent3;
    private CatComponentRenderHelper catComponentRenderHelper;
    private boolean enabledFlag;

    public CategoryRenderHelper(SubCategoriesServiceComponent category, int offset) {
        this.subCategoriesServiceComponent = category;
        this.countValue = offset;
        this.countValue2 = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) + ((this.countValue - 2) * 125.0F));
        this.countValue3 = 100;
        this.countValue4 = this.countValue2;
        this.countValue5 = this.countValue3;
        this.factorValue = 120.0F;
        this.factorValue2 = 350.0F;
        this.countValue6 = -1;
        this.arrayList = new ArrayList();
        this.arrayList2 = new ArrayList();
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 300L);
        this.easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_EXPO, 400L);
        this.easingServiceComponent3 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.enabledFlag = true;
        int index = 0;
        Iterable iterable = ((Iterable) EnabledServiceComponent.INSTANCE.getArrayList2());
        iterable = ((Iterable) CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator19())));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Module module = ((Module) element);
            if (__UNDEF_KEY__ >= 0) {
                if (__UNDEF_KEY__ >= 0L) {
                    if (this.subCategoriesServiceComponent.getList().contains(module.getSubCategory())) {
                        this.arrayList2.add(new CatComponentRenderHelper(this, module, (this.countValue2 + 3.0F), ((this.countValue3 + 45.0F) + (18 * index))));
                        index = (index + 1);
                    }
                }
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            if (this.subCategoriesServiceComponent.getList().size() == 2) {
                this.arrayList.add(new SubCategoryServiceComponent(0.0F, 54.0F, ((SubCategory) this.subCategoriesServiceComponent.getList().get(0))));
                this.arrayList.add(new SubCategoryServiceComponent(56.0F, 54.0F, ((SubCategory) this.subCategoriesServiceComponent.getList().get(1))));
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            if (this.subCategoriesServiceComponent.getList().size() == 3) {
                this.arrayList.add(new SubCategoryServiceComponent(0.0F, 35.5F, ((SubCategory) this.subCategoriesServiceComponent.getList().get(0))));
                this.arrayList.add(new SubCategoryServiceComponent(37.5F, 35.5F, ((SubCategory) this.subCategoriesServiceComponent.getList().get(1))));
                this.arrayList.add(new SubCategoryServiceComponent(74.5F, 35.5F, ((SubCategory) this.subCategoriesServiceComponent.getList().get(2))));
            }
            if (__UNDEF_KEY__ >= 0) {
                if (this.subCategoriesServiceComponent.getList().size() == 4) {
                    this.arrayList.add(new SubCategoryServiceComponent(0.0F, 27.0F, ((SubCategory) this.subCategoriesServiceComponent.getList().get(0))));
                    this.arrayList.add(new SubCategoryServiceComponent(28.0F, 27.0F, ((SubCategory) this.subCategoriesServiceComponent.getList().get(1))));
                    this.arrayList.add(new SubCategoryServiceComponent(56.0F, 27.0F, ((SubCategory) this.subCategoriesServiceComponent.getList().get(2))));
                    this.arrayList.add(new SubCategoryServiceComponent(83.0F, 27.0F, ((SubCategory) this.subCategoriesServiceComponent.getList().get(3))));
                }
                this.subCategoryServiceComponent = ((SubCategoryServiceComponent) this.arrayList.get(0));
            }
        }
        this.subCategoryServiceComponent2 = this.subCategoryServiceComponent;
    }

    public SubCategoriesServiceComponent getSubCategoriesServiceComponent() {
        return this.subCategoriesServiceComponent;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public void updateValue2(int value) {
        this.countValue2 = value;
    }

    public int getNumericValue3() {
        return this.countValue3;
    }

    public void updateValue3(int value) {
        this.countValue3 = value;
    }

    public int getNumericValue4() {
        return this.countValue4;
    }

    public void updateValue4(int value) {
        this.countValue4 = value;
    }

    public int getNumericValue5() {
        return this.countValue5;
    }

    public void updateValue5(int value) {
        this.countValue5 = value;
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

    public SubCategoryServiceComponent getSubCategoryServiceComponent() {
        return this.subCategoryServiceComponent;
    }

    public void executeAction(SubCategoryServiceComponent value) {
        this.subCategoryServiceComponent = value;
    }

    public ArrayList getArrayList() {
        return this.arrayList;
    }

    public ArrayList getArrayList2() {
        return this.arrayList2;
    }

    public CatComponentRenderHelper getCatComponentRenderHelper() {
        return this.catComponentRenderHelper;
    }

    public void updateValue(CatComponentRenderHelper value) {
        this.catComponentRenderHelper = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        SFMServiceComponent.resolveFontRenderHelper3().updateValue(50.0F);
        SFMServiceComponent.resolveFontRenderHelper2().updateValue(50.0F);
        if (this.enabledFlag) {
            this.countValue2 = ((SharedKt.getMc().method_22683().method_4486() / 2) + ((this.countValue - 2) * 125));
            this.countValue3 = 100;
            this.countValue4 = this.countValue2;
            this.countValue5 = this.countValue3;
            this.enabledFlag = false;
        }
        this.countValue2 = MathKt.roundToInt(this.computeValue(this.countValue2, this.countValue4, 13.0F));
        this.countValue3 = MathKt.roundToInt(this.computeValue(this.countValue3, this.countValue5, 13.0F));
        StackShaderComponent2.executeAction(context.method_51448(), this.countValue2, this.countValue3, this.factorValue, 25.0F, 7.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4().brighter(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 7.0F);
        StackShaderComponent2.executeAction(context.method_51448(), this.countValue2, (this.countValue3 + 24.0F), this.factorValue, (this.easingServiceComponent.getNumericValue() - 24.0F), 0.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 7.0F, 7.0F, 0.0F);
        String text = this.subCategoriesServiceComponent.getString();
        if (((CharSequence) text).length() > 0) {
            char ch = text.charAt(0);
            FontRenderHelper fontRenderHelper = SFMServiceComponent.resolveFontRenderHelper9();
            int index = 0;
            char ch2 = Character.toUpperCase(ch);
            ch = ch2;
            index = text;
            int index2 = 1;
            index = index.substring(index2);
        } else {
        }
        int index3 = 10;
        int index4 = (this.countValue3 + 5.0F);
        int index5 = (this.countValue2 + (this.factorValue / 2.0F));
        String text2 = new StringBuilder().append(ch).append(index).toString();
        context.render(text2, text, index5, index4, index3);
        text = new Color[1];
        text[0] = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor6(), 0.3F);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), this.countValue2, (this.countValue3 + 41.0F), this.factorValue, 1.0F, text);
        this.easingServiceComponent2.executeAction(1.0F);
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78((this.countValue2 + 1.0F), this.countValue3, (this.countValue2 + this.factorValue), (this.countValue3 + this.easingServiceComponent.getNumericValue())));
        if (this.catComponentRenderHelper == null) {
            this.render(mouseX, mouseY, context, this.easingServiceComponent.isActive());
        }
        this.render(mouseX, mouseY, context);
        SFMServiceComponent.resolveFontRenderHelper3().executeAction();
        SFMServiceComponent.resolveFontRenderHelper2().executeAction();
        PolygonShaderComponent.INSTANCE.render(context);
    }

    private void render(int arg0, int arg1, DrawContext arg2) {
        this.easingServiceComponent3.executeAction(1.0F);
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), arg2.method_51448(), this.catComponentRenderHelper.getModule().getString2(), ((this.countValue2 + 8.0F) + (40.0F * (1 - this.easingServiceComponent3.getNumericValue()))), (this.countValue3 + 27), NewThemeRenderHelper.INSTANCE.getColor7(), false);
        float factor = 0.0F;
        if (this.catComponentRenderHelper != null && this.catComponentRenderHelper.resolveList() != null) {
            Iterable iterable = ((Iterable) this.catComponentRenderHelper.resolveList());
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                SettingRenderHelper16 settingRenderHelper16 = ((SettingRenderHelper16) element);
                if (settingRenderHelper16.getVisibleSettingProperty().getSettingGroup() != null) {
                    if (settingRenderHelper16.getVisibleSettingProperty().getSettingGroup().isActive() && settingRenderHelper16.getVisibleSettingProperty().getSettingGroup().getOptionMode14() != OptionMode14.BOOLS) {
                        settingRenderHelper16.updateValue((this.countValue2 + 5.0F));
                        settingRenderHelper16.updateValue2(((this.countValue3 + 47.0F) + factor));
                        settingRenderHelper16.render(arg2, arg0, arg1, this.easingServiceComponent2.getNumericValue());
                        factor = (factor + (settingRenderHelper16.getNumericValue4() + 2.0F));
                    }
                }
            }
        } else {
        }
        MissingnoRenderHelper.executeAction(REDGuiElement.INSTANCE.getMissingnoRenderHelper(), ((Matrix3x2f) arg2.method_51448()), ((this.countValue2 + this.factorValue) - 15.0D), (this.countValue3 + 26.0D), 0.0F, 0.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), this.easingServiceComponent3.getNumericValue()), null, 0.0F);
        this.easingServiceComponent.executeAction((49.0F + factor));
    }

    private void render(int arg0, int arg1, DrawContext arg2, boolean arg3) {
        this.easingServiceComponent3.executeAction(0.0F);
        Iterable iterable = ((Iterable) this.arrayList);
        int index = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SubCategoryServiceComponent subCategoryServiceComponent = ((SubCategoryServiceComponent) element);
            int index2 = 0;
            if (Intrinsics.areEqual(subCategoryServiceComponent, this.subCategoryServiceComponent)) {
            } else {
            }
            this.executeAction(0.0F);
            if (subCategoryServiceComponent.getEasingServiceComponent().getNumericValue() > 0.001D) {
                StackShaderComponent2.executeAction(arg2.method_51448(), ((this.countValue2 + subCategoryServiceComponent.getNumericValue()) + 5.0F), (this.countValue3 + 27.0F), subCategoryServiceComponent.getNumericValue2(), 11.5F, 2.0F, (2.0F * subCategoryServiceComponent.getEasingServiceComponent().getNumericValue()), (0.05F * subCategoryServiceComponent.getEasingServiceComponent().getNumericValue()), 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            }
            Color color = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor8(), NewThemeRenderHelper.INSTANCE.getColor7(), subCategoryServiceComponent.getEasingServiceComponent().getNumericValue());
            String text = subCategoryServiceComponent.getSubCategory().getString();
            if (((CharSequence) text).length() > 0) {
                char ch = text.charAt(0);
                DrawContext context = arg2;
                FontRenderHelper fontRenderHelper = SFMServiceComponent.resolveFontRenderHelper3();
                int index3 = 0;
                char ch2 = Character.toUpperCase(ch);
                ch = ch2;
                index3 = text;
                int index4 = 1;
                index3 = index3.substring(index4);
            } else {
            }
            context.render(new StringBuilder().append(ch).append(index3).toString(), text, (((this.countValue2 + subCategoryServiceComponent.getNumericValue()) + 5.0F) + (MathKt.roundToInt((subCategoryServiceComponent.getNumericValue2() / 0.2F)) / 10.0F)), (this.countValue3 + 31.5F), color);
        }
        iterable = 0.0F;
        index = 0.0F;
        iterator = 0.0F;
        element = ((Iterable) this.arrayList2);
        subCategoryServiceComponent = 0;
        index2 = element;
        color = ((Collection) new ArrayList());
        text = 0;
        ch = index2.iterator();
        while (ch.hasNext()) {
            context = ch.next();
            fontRenderHelper = ((CatComponentRenderHelper) context);
            index3 = 0;
            if (!(Intrinsics.areEqual(fontRenderHelper.getModule().getSubCategory(), this.subCategoryServiceComponent.getSubCategory()))) {
                if (Intrinsics.areEqual(fontRenderHelper.getModule().getSubCategory(), this.subCategoryServiceComponent2.getSubCategory()) && this.easingServiceComponent2.getNumericValue() < 1.0F) {
                } else {
                }
            }
            color.add(context);
        }
        element = ((Iterable) color);
        subCategoryServiceComponent = 0;
        index2 = element.iterator();
        while (index2.hasNext()) {
            color = index2.next();
            text = ((CatComponentRenderHelper) color);
            ch = 0;
            if (Intrinsics.areEqual(text.getModule().getSubCategory(), this.subCategoryServiceComponent.getSubCategory())) {
            } else {
            }
            context = (this.countValue2 + (this.countValue6 * (this.factorValue * this.easingServiceComponent2.getNumericValue())));
            text.updateValue((context + 3.0F));
            if (Intrinsics.areEqual(text.getModule().getSubCategory(), this.subCategoryServiceComponent.getSubCategory())) {
                text.updateValue2(((this.countValue3 + 44.0F) + iterable));
                iterable = (iterable + (text.getNumericValue4() + 2.0F));
                if (text.isActive()) {
                } else {
                }
                iterator = (31.0F + (17.0F + 2.0F));
            } else {
                text.updateValue2(((this.countValue3 + 44.0F) + index));
                index = (index + (text.getNumericValue4() + 2.0F));
            }
            text.render(arg2, arg0, arg1, this.easingServiceComponent2.getNumericValue(), arg3);
        }
        this.easingServiceComponent.executeAction((45.0F + iterator));
    }

    public void executeAction(SubCategoryServiceComponent selector) {
        this.subCategoryServiceComponent2 = this.subCategoryServiceComponent;
        this.subCategoryServiceComponent = selector;
        this.countValue6 = this.subCategoryServiceComponent2.getNumericValue() > this.subCategoryServiceComponent.getNumericValue();
        if (this.countValue6 == 1) {
            StartupServiceComponent.INSTANCE.getVecServiceComponent4().updateValue();
        } else {
            StartupServiceComponent.INSTANCE.getVecServiceComponent5().updateValue();
        }
        this.easingServiceComponent2.updateValue(0.0F);
        this.easingServiceComponent2.updateValue2(this.easingServiceComponent2.getNumericValue());
    }

    public void executeAction(double mouseX, double mouseY, int button) {
        if (this.catComponentRenderHelper == null) {
            Iterable iterable = ((Iterable) this.arrayList);
            int index = 0;
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                SubCategoryServiceComponent subCategoryServiceComponent = ((SubCategoryServiceComponent) element);
                int index2 = 0;
                float factor = (subCategoryServiceComponent.getNumericValue() + this.countValue2);
                if (mouseX <= ((subCategoryServiceComponent.getNumericValue() + subCategoryServiceComponent.getNumericValue2()) + this.countValue2)) {
                } else {
                    if (factor <= mouseX) {
                        factor = (this.countValue3 + 27);
                        int index3 = (this.countValue3 + 38);
                        double offset = mouseY;
                        if (factor <= offset) {
                        } else {
                        }
                        if (offset <= index3 && !(Intrinsics.areEqual(this.subCategoryServiceComponent, subCategoryServiceComponent))) {
                            this.executeAction(subCategoryServiceComponent);
                        }
                    }
                }
            }
            iterable = ((Iterable) this.arrayList2);
            index = 0;
            iterator = iterable;
            element = ((Collection) new ArrayList());
            subCategoryServiceComponent = 0;
            index2 = iterator.iterator();
            while (index2.hasNext()) {
                factor = index2.next();
                index3 = ((CatComponentRenderHelper) factor);
                offset = 0;
                element.add(factor);
            }
            iterable = ((Iterable) element);
            index = 0;
            iterator = iterable.iterator();
            while (iterator.hasNext()) {
                element = iterator.next();
                subCategoryServiceComponent = ((CatComponentRenderHelper) element);
                index2 = 0;
                subCategoryServiceComponent.executeAction(mouseX, mouseY, button);
            }
        } else {
            iterable = (this.countValue2 + 3);
            index = ((this.countValue2 + this.factorValue) - 3);
            iterator = mouseX;
            if (iterable <= iterator) {
            } else {
                if (iterator <= index) {
                    iterable = (this.countValue3 + 25);
                    index = (this.countValue3 + 40);
                    iterator = mouseY;
                    if (iterable <= iterator) {
                    } else {
                        if (iterator <= index) {
                            this.catComponentRenderHelper = null;
                            StartupServiceComponent.INSTANCE.getVecServiceComponent2().updateValue();
                        } else {
                            iterable = this.catComponentRenderHelper;
                            if (iterable != null) {
                                index = iterable.resolveList();
                                if (index != null) {
                                    element = ((Iterable) index);
                                    subCategoryServiceComponent = 0;
                                    index2 = element;
                                    factor = ((Collection) new ArrayList());
                                    index3 = 0;
                                    offset = index2.iterator();
                                    while (offset.hasNext()) {
                                        Object element2 = offset.next();
                                        SettingRenderHelper16 settingRenderHelper16 = ((SettingRenderHelper16) element2);
                                        if (((Boolean) settingRenderHelper16.getVisibleSettingProperty().getFunction0().invoke())) {
                                            if (settingRenderHelper16.getVisibleSettingProperty().getSettingGroup() != null) {
                                                if (settingRenderHelper16.getVisibleSettingProperty().getSettingGroup().isActive() && settingRenderHelper16.getVisibleSettingProperty().getSettingGroup().getOptionMode14() != OptionMode14.BOOLS) {
                                                } else {
                                                }
                                            }
                                        }
                                        factor.add(element2);
                                    }
                                    element = ((Iterable) factor);
                                    subCategoryServiceComponent = 0;
                                    index2 = element.iterator();
                                    while (index2.hasNext()) {
                                        factor = index2.next();
                                        index3 = ((SettingRenderHelper16) factor);
                                        offset = 0;
                                        index3.setValue(mouseX, mouseY, button);
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                    }
                } else {
                }
            }
        }
    }

    public void executeAction(double mouseX, double mouseY, int button) {
        if (this.catComponentRenderHelper != null && this.catComponentRenderHelper.resolveList() != null) {
            Iterable iterable = ((Iterable) this.catComponentRenderHelper.resolveList());
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                SettingRenderHelper16 settingRenderHelper16 = ((SettingRenderHelper16) element);
                settingRenderHelper16.setValue(mouseX, mouseY, button);
            }
        } else {
        }
    }

    public void executeAction(int key) {
        Iterable iterable = ((Iterable) this.arrayList2);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CatComponentRenderHelper catComponentRenderHelper = ((CatComponentRenderHelper) element);
            catComponentRenderHelper.executeAction(key);
        }
    }

    public void executeAction(char charParam) {
        Iterable iterable = ((Iterable) this.arrayList2);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CatComponentRenderHelper catComponentRenderHelper = ((CatComponentRenderHelper) element);
            catComponentRenderHelper.executeAction(charParam);
            if (__UNDEF_KEY__ >= 0) {
            }
        }
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount, double horizontalAmmount) {
        int index = 0;
        Iterable iterable = ((Iterable) this.arrayList2);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CatComponentRenderHelper catComponentRenderHelper = ((CatComponentRenderHelper) element);
            if (catComponentRenderHelper.checkCondition(mouseX, mouseY, verticalAmount)) {
                index = 1;
            }
        }
        return index;
    }

    public void executeAction(double verticalAmount, double horizontalAmmount) {
        this.countValue5 = (this.countValue5 + (verticalAmount * 10.0F));
        this.countValue4 = (this.countValue4 + (horizontalAmmount * 10.0F));
    }

    private float computeValue(float arg0, float arg1, float arg2) {
        if (EventServiceComponent.INSTANCE.getNumericValue() > 5) {
        } else {
        }
        float factor = Math.clamp((0.016F * arg2), 0.0F, 1.0F);
        return (((1.0F - factor) * arg0) + (factor * arg1));
    }

    public void updateValue() {
        if (this.catComponentRenderHelper != null && this.catComponentRenderHelper.resolveList() != null) {
            Iterable iterable = ((Iterable) this.catComponentRenderHelper.resolveList());
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                SettingRenderHelper16 settingRenderHelper16 = ((SettingRenderHelper16) element);
                settingRenderHelper16.setValue();
            }
        } else {
        }
        this.enabledFlag = true;
    }

    private float computeValue(float arg0) {
        if (Float.isNaN(arg0)) {
        } else {
        }
        return (MathKt.roundToInt(((MathKt.roundToInt((arg0 * 100.0F)) / 100.0F) * 10.0F)) / 10.0F);
    }

}
