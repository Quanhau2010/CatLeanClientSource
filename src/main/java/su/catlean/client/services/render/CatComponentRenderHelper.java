package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.DrawContext;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.misc.UIModule;
import su.catlean.client.features.modules.utility.misc.UIModuleMode;
import su.catlean.client.features.modules.utility.misc.UIModuleTextMode;
import su.catlean.client.services.client.ActionServiceComponent2;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.EntitiesServiceComponent;
import su.catlean.client.services.client.ItemsServiceComponent2;
import su.catlean.client.services.client.NoneServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.client.SettingServiceComponent;
import su.catlean.client.services.client.StartupServiceComponent;
import su.catlean.client.services.client.SubCategoryServiceComponent;
import su.catlean.client.services.client.TextServiceComponent;
import su.catlean.client.services.client.VecServiceComponent;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.TpYawSmootherMode;

public class CatComponentRenderHelper {

    private final CategoryRenderHelper categoryRenderHelper;
    private final Module module;
    private float factorValue;
    private float factorValue2;
    private float factorValue3;
    private float factorValue4;
    private final EasingServiceComponent easingServiceComponent;
    private final EasingServiceComponent easingServiceComponent2;
    private final EasingServiceComponent easingServiceComponent3;
    private final EasingServiceComponent easingServiceComponent4;
    private final EasingServiceComponent easingServiceComponent5;
    private final EasingServiceComponent easingServiceComponent6;
    private final EasingServiceComponent easingServiceComponent7;
    private final List itemList;
    private boolean enabledFlag;
    private boolean enabledFlag2;

    public CatComponentRenderHelper(CategoryRenderHelper catComponent, Module module, float x, float y) {
        this.categoryRenderHelper = catComponent;
        this.module = module;
        this.factorValue = x;
        this.factorValue2 = y;
        this.factorValue3 = 120.0F;
        this.factorValue4 = 17.0F;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.easingServiceComponent3 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 300L);
        this.easingServiceComponent4 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.easingServiceComponent5 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.easingServiceComponent6 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.easingServiceComponent7 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.itemList = new ArrayList();
        Iterable iterable = ((Iterable) this.module.getList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            VisibleSettingProperty visibleSettingProperty = ((VisibleSettingProperty) element);
            Object element2 = visibleSettingProperty.getObject2();
            if (element2 instanceof Boolean) {
            }
            if (element2 instanceof Float) {
            }
            if (element2 instanceof Integer) {
            }
            if (element2 instanceof KeyRecord) {
            }
            if (element2 instanceof String) {
            }
            if (element2 instanceof Color) {
            }
            if (element2 instanceof SettingGroup) {
            }
            if (element2 instanceof BlocksServiceComponent) {
            }
            if (element2 instanceof EntitiesServiceComponent) {
            }
            if (element2 instanceof ItemsServiceComponent2) {
            }
            if (element2 instanceof ActionServiceComponent2) {
            }
            if (element2 instanceof TextServiceComponent) {
            }
            SettingRenderHelper16 settingRenderHelper16 = ((SettingRenderHelper16) new SettingRenderHelper10(visibleSettingProperty));
            if (!(Intrinsics.areEqual(visibleSettingProperty.getString(), "enabled")) && !(Intrinsics.areEqual(visibleSettingProperty.getString(), "bind"))) {
                this.itemList.add(settingRenderHelper16);
            }
        }
    }

    public Module getModule() {
        return this.module;
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

    public List resolveList() {
        Iterable iterable = ((Iterable) this.itemList);
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SettingRenderHelper16 settingRenderHelper16 = ((SettingRenderHelper16) element);
            if (!(__UNDEF_KEY__)) {
            }
            collection.add(element);
        }
        return collection;
    }

    public void executeAction(List value) {
        this.itemList.addAll(((Collection) value));
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float factor, boolean hAnimation) {
        if (this.enabledFlag) {
        }
        this.factorValue4 = 17.0F;
        if (this.module.getEnabled()) {
        }
        this.executeAction(0.0F);
        float factor2 = this.factorValue;
        float factor3 = ((this.factorValue + this.factorValue3) - 6);
        int index = mouseX;
        if (__UNDEF_KEY__ >= 0) {
            if (!(__UNDEF_KEY__)) {
                if (factor2 <= index) {
                    if (!(__UNDEF_KEY__)) {
                        if (index <= factor3) {
                        }
                    }
                } else {
                }
            }
        }
        if (0) {
            factor2 = this.factorValue2;
            factor3 = (this.factorValue2 + this.factorValue4);
            index = mouseY;
            if (__UNDEF_KEY__ >= 0) {
                if (!(__UNDEF_KEY__)) {
                    if (factor2 <= index) {
                        if (!(__UNDEF_KEY__)) {
                            if (index <= factor3) {
                            }
                        }
                    } else {
                    }
                }
            }
            if (__UNDEF_KEY__ >= 0) {
            }
            if (0 && !(this.enabledFlag)) {
            }
        }
        if (__UNDEF_KEY__ > 0) {
            this.executeAction(0.0F);
            if (this.enabledFlag) {
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            this.executeAction(0.0F);
            if (ServiceComponent13.checkCondition(342)) {
            }
        }
        this.executeAction(1.0F);
        this.factorValue4 = (17.0F + (14.0F * this.easingServiceComponent3.getNumericValue()));
        factor2 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor11(), this.easingServiceComponent.getNumericValue());
        factor3 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor13(), NewThemeRenderHelper.INSTANCE.getColor12(), this.easingServiceComponent.getNumericValue());
        if (!(__UNDEF_KEY__)) {
            if (UIModule.INSTANCE.getModuleMode() == UIModuleMode.DEFAULT) {
                StackShaderComponent2.executeAction(context.method_51448(), this.factorValue, this.factorValue2, (this.factorValue3 - 6), (17.0F + (14.0F * this.easingServiceComponent3.getNumericValue())), 4.0F, (2.5F + this.easingServiceComponent2.getNumericValue()), 1.0F, 1.0F, factor2, factor3, 0.0F, 0.0F, 0.0F);
                if (__UNDEF_KEY__) {
                    if (__UNDEF_KEY__ > 0 && !(__UNDEF_KEY__)) {
                        if (UIModule.INSTANCE.getModuleMode() == UIModuleMode.RECT) {
                            index = this.categoryRenderHelper.getArrayList2();
                            int index2 = 0;
                            ListIterator iterator = index.listIterator(index.size());
                            if (iterator.hasPrevious()) {
                                Object element = iterator.previous();
                                CatComponentRenderHelper catComponentRenderHelper = ((CatComponentRenderHelper) element);
                            } else {
                            }
                            if (__UNDEF_KEY__ >= 0) {
                                if (Intrinsics.areEqual(((CatComponentRenderHelper) new NoSuchElementException("List contains no element matching the predicate.")).module.getString(), this.module.getString())) {
                                    StackShaderComponent2.executeAction(context.method_51448(), this.factorValue, this.factorValue2, (this.factorValue3 - 6), (17.0F + (14.0F * this.easingServiceComponent3.getNumericValue())), 0.0F, (2.5F + this.easingServiceComponent2.getNumericValue()), 1.0F, 1.0F, factor2, factor3, 4.0F, 4.0F, 0.0F);
                                }
                            }
                            StackShaderComponent2.executeAction(context.method_51448(), this.factorValue, this.factorValue2, (this.factorValue3 - 6), (17.0F + (14.0F * this.easingServiceComponent3.getNumericValue())), 0.0F, (2.5F + this.easingServiceComponent2.getNumericValue()), 1.0F, 1.0F, factor2, factor3, 0.0F, 0.0F, 0.0F);
                        }
                        if (!(__UNDEF_KEY__)) {
                            if (__UNDEF_KEY__ && this.module.getEnabled()) {
                                index = this.categoryRenderHelper.getArrayList2();
                                index2 = 0;
                                iterator = index.listIterator(index.size());
                                if (iterator.hasPrevious()) {
                                    element = iterator.previous();
                                    catComponentRenderHelper = ((CatComponentRenderHelper) element);
                                } else {
                                }
                                if (__UNDEF_KEY__ >= 0) {
                                    if (Intrinsics.areEqual(((CatComponentRenderHelper) new NoSuchElementException("List contains no element matching the predicate.")).module.getString(), this.module.getString())) {
                                        StackShaderComponent2.executeAction(context.method_51448(), (this.factorValue - 3.0F), this.factorValue2, this.factorValue3, (20.0F + (14.0F * this.easingServiceComponent3.getNumericValue())), 0.0F, 0.0F, 1.0F, 1.0F, factor2, factor3, 7.0F, 7.0F, 0.0F);
                                        if (__UNDEF_KEY__) {
                                            StackShaderComponent2.executeAction(context.method_51448(), (this.factorValue - 3.0F), this.factorValue2, this.factorValue3, (19.0F + (14.0F * this.easingServiceComponent3.getNumericValue())), 0.0F, 0.0F, 1.0F, 1.0F, factor2, factor3, 0.0F, 0.0F, 0.0F);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        index = PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, NewThemeRenderHelper.INSTANCE.getColor7(), factor);
        if (!(__UNDEF_KEY__)) {
            if (this.easingServiceComponent2.getNumericValue() == 0.0F) {
            } else {
            }
        }
        if (__UNDEF_KEY__ > 0) {
        }
        if (__UNDEF_KEY__ >= 0) {
            if (!(__UNDEF_KEY__)) {
            }
        }
        if (!(__UNDEF_KEY__)) {
            if (!(0) && ServiceComponent13.checkCondition(341) && ServiceComponent13.checkCondition(340)) {
            } else {
            }
        }
        index2 = 0;
        if (__UNDEF_KEY__ > 0 && !(__UNDEF_KEY__)) {
            if ((System.currentTimeMillis() - this.timestampValue) >= 400L) {
                if (index2) {
                    if (index2) {
                    }
                } else {
                }
            }
        }
        iterator = Float.valueOf(0.0F);
        if (__UNDEF_KEY__ >= 0 && !(__UNDEF_KEY__)) {
            if (UIModule.INSTANCE.getModuleText() == UIModuleTextMode.LEFT) {
            }
            if (!(__UNDEF_KEY__)) {
                if (this.module.getBind().getNumericValue() != -1) {
                } else {
                }
            }
        }
        FontRenderHelper.W(this.module.getString2(), ((this.factorValue + 4.0F) + ((Number) iterator)), (((this.factorValue3 - 8.0F) / 2.0F) - (SFMServiceComponent.resolveFontRenderHelper2().computeValue(this.module.getString2()) / 2.0F)), (0.0F + (this.easingServiceComponent7.getNumericValue() * 1.0F)), ((this.factorValue2 + (this.factorValue4 / 2.0F)) - 7.0F), PolygonShaderComponent.INSTANCE.resolveColor(index, (1.0F - this.easingServiceComponent3.getNumericValue())), false);
        if (this.easingServiceComponent7.getNumericValue() < 1.0F) {
            if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                if (!(this.enabledFlag)) {
                    element = NoneServiceComponent.INSTANCE.resolveString(this.module.getBind().getNumericValue());
                    if (__UNDEF_KEY__ >= 0) {
                        if (!(__UNDEF_KEY__)) {
                            if (this.module.getBind().getNumericValue() != -1) {
                                FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper2(), context.method_51448(), element, (((this.factorValue + this.factorValue3) - 10.0F) - SFMServiceComponent.resolveFontRenderHelper2().computeValue(element)), ((this.factorValue2 + (this.factorValue4 / 2.0F)) - 7.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor8(), (1.0F - this.easingServiceComponent7.getNumericValue())), false);
                            }
                            if (!(__UNDEF_KEY__)) {
                                if (this.easingServiceComponent3.getNumericValue() > 0.0F) {
                                    this.render(context, mouseX, mouseY, index, factor3);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (__UNDEF_KEY__) {
        }
    }

    private void render(DrawContext arg0, int arg1, int arg2, Color arg3, Color arg4) {
        float factor = (this.factorValue + 58.0F);
        float factor2 = (((this.factorValue + 58.0F) + (this.factorValue3 / 2.0F)) - 6);
        int index = arg1;
        if (factor <= index) {
            if (index <= factor2) {
            }
        } else {
        }
        if (0) {
            factor = (this.factorValue2 + 15.0F);
            factor2 = (this.factorValue2 + 27.0F);
            index = arg2;
            if (factor <= index) {
                if (index <= factor2) {
                }
            } else {
            }
            if (0) {
            }
        }
        this.executeAction(0.0F);
        factor = (this.factorValue + 2.0F);
        factor2 = (((this.factorValue + 2.0F) + (this.factorValue3 / 2.0F)) - 6);
        index = arg1;
        if (factor <= index) {
            if (index <= factor2) {
            }
        } else {
        }
        if (0) {
            factor = (this.factorValue2 + 15.0F);
            factor2 = (this.factorValue2 + 27.0F);
            index = arg2;
            if (factor <= index) {
                if (index <= factor2) {
                }
            } else {
            }
            if (0) {
            }
        }
        this.executeAction(0.0F);
        if (this.enabledFlag2) {
        }
        this.executeAction(0.0F);
        PolygonShaderComponent.INSTANCE.render(arg0, new ServiceComponent78(this.factorValue, this.factorValue2, (this.factorValue + this.factorValue3), (this.factorValue2 + this.factorValue4)));
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper2(), arg0.method_51448(), StringsKt.dropLast("Press any key                    ...", (3 - (4 * ((System.currentTimeMillis() % 700) / 700.0D)))), ((this.factorValue + 3.0F) + (60 * (1.0F - this.easingServiceComponent3.getNumericValue()))), (this.factorValue2 + 2.0F), PolygonShaderComponent.INSTANCE.resolveColor(arg3, (this.easingServiceComponent3.getNumericValue() - 0.1F)), false);
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.factorValue + 2.0F), (this.factorValue2 + 17.0F), ((this.factorValue3 / 2.0F) - 6), 12.0F, 3.0F, (2.5F + (this.easingServiceComponent4.getNumericValue() / 2.0F)), (1.0F - this.easingServiceComponent6.getNumericValue()), 1.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor11(), (1.0F - this.easingServiceComponent6.getNumericValue())), arg4, 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper10().render(arg0, "Toggle", (this.factorValue + 15.0F), (this.factorValue2 + 17.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor8(), NewThemeRenderHelper.INSTANCE.getColor7(), (this.easingServiceComponent4.getNumericValue() + ((1.0F - this.easingServiceComponent6.getNumericValue()) / 2.0F))));
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.factorValue + 58.0F), (this.factorValue2 + 17.0F), ((this.factorValue3 / 2.0F) - 6), 12.0F, 3.0F, (2.5F + (this.easingServiceComponent5.getNumericValue() / 2.0F)), this.easingServiceComponent6.getNumericValue(), 1.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor11(), this.easingServiceComponent6.getNumericValue()), arg4, 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper10().render(arg0, "Hold", (this.factorValue + 76.0F), (this.factorValue2 + 17.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor8(), NewThemeRenderHelper.INSTANCE.getColor7(), (this.easingServiceComponent5.getNumericValue() + (this.easingServiceComponent6.getNumericValue() / 2.0F))));
        PolygonShaderComponent.INSTANCE.render(arg0);
    }

    public void executeAction(double mouseX, double mouseY, int button) {
        if (this.enabledFlag) {
            float factor = (this.factorValue + 58.0F);
            float factor2 = (((this.factorValue + 58.0F) + (this.factorValue3 / 2.0F)) - 6);
            double offset = mouseX;
            if (__UNDEF_KEY__ >= 0 && !(__UNDEF_KEY__)) {
                if (factor <= offset) {
                    if (offset <= factor2) {
                    }
                } else {
                }
            }
            if (0) {
                factor = (this.factorValue2 + 15.0F);
                factor2 = (this.factorValue2 + 27.0F);
                offset = mouseY;
                if (__UNDEF_KEY__ >= 0 && !(__UNDEF_KEY__)) {
                    if (factor <= offset) {
                        if (offset <= factor2) {
                        }
                    } else {
                    }
                }
                if (__UNDEF_KEY__ > 0) {
                }
                if (__UNDEF_KEY__ >= 0) {
                    if (!(__UNDEF_KEY__)) {
                        if (0 && !(button)) {
                            this.enabledFlag2 = true;
                        }
                        factor = (this.factorValue + 2.0F);
                        factor2 = (((this.factorValue + 2.0F) + (this.factorValue3 / 2.0F)) - 6);
                        offset = mouseX;
                    }
                }
            }
            if (__UNDEF_KEY__ > 0 && !(__UNDEF_KEY__)) {
                if (factor <= offset) {
                    if (offset <= factor2) {
                    }
                } else {
                }
            }
            if (0) {
                factor = (this.factorValue2 + 15.0F);
                factor2 = (this.factorValue2 + 27.0F);
                offset = mouseY;
                if (__UNDEF_KEY__ >= 0 && !(__UNDEF_KEY__)) {
                    if (factor <= offset) {
                        if (offset <= factor2) {
                        }
                    } else {
                    }
                }
                if (__UNDEF_KEY__ >= 0) {
                }
                if (0 && !(button)) {
                    this.enabledFlag2 = false;
                }
            }
            this.module.setBind(new KeyRecord(button, this.enabledFlag2, true));
            this.enabledFlag = false;
        }
        factor = this.factorValue;
        if (__UNDEF_KEY__ > 0 && !(__UNDEF_KEY__)) {
            if (mouseX <= ((this.factorValue + this.factorValue3) - 6)) {
                if (factor <= mouseX) {
                }
            } else {
            }
        }
        factor = this.factorValue2;
        if (__UNDEF_KEY__ >= 0 && !(__UNDEF_KEY__)) {
            if (mouseY <= (this.factorValue2 + this.factorValue4)) {
                if (factor <= mouseY) {
                }
            } else {
            }
        }
        if (__UNDEF_KEY__ >= 0) {
        }
        if (__UNDEF_KEY__ >= 0 && !(__UNDEF_KEY__)) {
        }
        if (__UNDEF_KEY__ >= 0) {
            if (!(__UNDEF_KEY__)) {
                if (__UNDEF_KEY__ > 0) {
                    if (ServiceComponent13.checkCondition(341) && ServiceComponent13.checkCondition(340)) {
                        if (this.module.getEnabled()) {
                            this.module.updateValue2();
                        }
                        factor = this.module.getList().iterator();
                        while (factor.hasNext()) {
                            factor2 = ((VisibleSettingProperty) factor.next());
                            factor2.setValue();
                            if (__UNDEF_KEY__ >= 0) {
                                if (ServiceComponent13.checkCondition(342)) {
                                    this.enabledFlag = true;
                                }
                            }
                            if (__UNDEF_KEY__ > 0) {
                                this.module.updateValue();
                            }
                            if (!(((Collection) this.itemList).isEmpty())) {
                            } else {
                            }
                            if (__UNDEF_KEY__ >= 0) {
                                if (0) {
                                    StartupServiceComponent.INSTANCE.getVecServiceComponent().updateValue();
                                    this.categoryRenderHelper.updateValue(this);
                                }
                                this.updateValue();
                            }
                            this.enabledFlag = true;
                        }
                    }
                }
            }
        }
    }

    public void updateValue() {
        StartupServiceComponent.INSTANCE.getVecServiceComponent3().updateValue();
        this.timestampValue = System.currentTimeMillis();
    }

    public void executeAction(int key) {
        Iterable iterable = ((Iterable) this.itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SettingRenderHelper16 settingRenderHelper16 = ((SettingRenderHelper16) element);
            settingRenderHelper16.setValue(key);
            if (__UNDEF_KEY__ >= 0) {
                if (__UNDEF_KEY__) {
                }
            }
        }
        if (__UNDEF_KEY__ >= 0) {
        }
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ > 0) {
                this.module.setBind(new KeyRecord(-1, this.enabledFlag2, false));
                this.module.setBind(new KeyRecord(key, this.enabledFlag2, false));
            }
        }
        this.enabledFlag = false;
    }

    public void executeAction(char charParam) {
        Iterable iterable = ((Iterable) this.itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SettingRenderHelper16 settingRenderHelper16 = ((SettingRenderHelper16) element);
            settingRenderHelper16.setValue(charParam);
        }
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        int index = 0;
        if (__UNDEF_KEY__) {
            if (Intrinsics.areEqual(this.categoryRenderHelper.getCatComponentRenderHelper(), this)) {
                Iterable iterable = ((Iterable) this.itemList);
                Iterator iterator = iterable.iterator();
                while (iterator.hasNext()) {
                    Object element = iterator.next();
                    SettingRenderHelper16 settingRenderHelper16 = ((SettingRenderHelper16) element);
                    if (__UNDEF_KEY__) {
                        if (settingRenderHelper16.getVisibleSettingProperty().getSettingGroup() != null) {
                            if (__UNDEF_KEY__) {
                                if (settingRenderHelper16.getVisibleSettingProperty().getSettingGroup().isActive()) {
                                    if (__UNDEF_KEY__ && __UNDEF_KEY__) {
                                    }
                                    if (__UNDEF_KEY__) {
                                    }
                                    if (__UNDEF_KEY__) {
                                        if (settingRenderHelper16.getVisibleSettingProperty().getSettingGroup().getOptionMode14() != OptionMode14.BOOLS && ((Boolean) settingRenderHelper16.getVisibleSettingProperty().getFunction0().invoke()) && settingRenderHelper16.checkCondition(mouseX, mouseY, verticalAmount)) {
                                            index = 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return index;
    }

    public float computeValue(SettingGroup group) {
        if (__UNDEF_KEY__) {
        }
        if (!(group.isActive()) && group.getOptionMode14() != OptionMode14.BOOLS) {
            return 13.0F;
        }
        float factor = 0.0F;
        factor = 13.0F;
        Iterable iterable = ((Iterable) this.itemList);
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            SettingRenderHelper16 settingRenderHelper16 = ((SettingRenderHelper16) element);
            if (__UNDEF_KEY__) {
            }
            if (__UNDEF_KEY__) {
                if (Intrinsics.areEqual(settingRenderHelper16.getVisibleSettingProperty().getSettingGroup(), group) && ((Boolean) settingRenderHelper16.getVisibleSettingProperty().getFunction0().invoke())) {
                } else {
                }
            }
            collection.add(element);
        }
        iterable = ((Iterable) collection);
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index = ((SettingRenderHelper16) collection);
            iterator = 0;
            factor = (factor + (index.getNumericValue4() + 2.0F));
            if (__UNDEF_KEY__) {
            }
        }
        return factor;
    }

}
