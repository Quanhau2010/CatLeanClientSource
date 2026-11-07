package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.text.StringsKt;
import net.minecraft.block.Block;
import net.minecraft.class_7923;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.Item;
import su.catlean.api.contracts.Contract4;
import su.catlean.api.contracts.Contract8;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.EnabledServiceComponent;
import su.catlean.client.services.client.HoldServiceComponent;
import su.catlean.client.services.client.HoveringComponentServiceComponent;
import su.catlean.client.services.client.HoveringComponentServiceComponent2;
import su.catlean.client.services.client.HoveringComponentServiceComponent3;
import su.catlean.client.services.client.HoveringComponentServiceComponent4;
import su.catlean.client.services.client.HoveringComponentServiceComponent8;
import su.catlean.client.services.client.LegitServiceComponent;
import su.catlean.client.services.client.MacroServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent7;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.client.SuggestionsServiceComponent;
import su.catlean.client.services.client.config.models.IdRecord;
import su.catlean.client.services.client.config.models.IdRecord11;
import su.catlean.client.services.client.config.models.IdRecord9;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class MacroPanelRenderHelper3Impl extends RenderHelper3 {

    public static final MacroPanelRenderHelper3Impl INSTANCE;
    private static final List itemList;
    private static RenderHelper2 renderHelper2;
    private static RenderHelper2 renderHelper22;
    private static RenderHelper2 renderHelper23;
    private static boolean enabledFlag;
    private static MacrosRenderHelper2Impl macrosRenderHelper2Impl;
    private static MacrosRenderHelper2Impl macrosRenderHelper2Impl2;
    private static final EasingServiceComponent easingServiceComponent;
    private static final EasingServiceComponent easingServiceComponent2;
    private static final EasingServiceComponent easingServiceComponent3;
    private static boolean enabledFlag2;
    private static float factorValue;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl2;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl3;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl4;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl5;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl6;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl7;
    private static String[] textValueArray;

    private MacroPanelRenderHelper3Impl() {
        super("macro-panel", 0.0F, 0.0F, 0.0F, 0.0F);
    }

    public List getList() {
        return itemList;
    }

    public RenderHelper2 getRenderHelper2() {
        return renderHelper2;
    }

    public void updateValue(RenderHelper2 value) {
        renderHelper2 = value;
    }

    public RenderHelper2 getRenderHelper22() {
        return renderHelper23;
    }

    public void updateValue2(RenderHelper2 value) {
        renderHelper23 = value;
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public MacrosRenderHelper2Impl getMacrosRenderHelper2Impl() {
        return macrosRenderHelper2Impl;
    }

    public void updateValue(MacrosRenderHelper2Impl value) {
        macrosRenderHelper2Impl = value;
    }

    public MacrosRenderHelper2Impl getMacrosRenderHelper2Impl2() {
        return macrosRenderHelper2Impl2;
    }

    public void updateValue2(MacrosRenderHelper2Impl value) {
        macrosRenderHelper2Impl2 = value;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return easingServiceComponent;
    }

    public void updateValue() {
        itemList.clear();
        Iterable iterable = ((Iterable) MacroServiceComponent.INSTANCE.resolveList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            itemList.add(new MacrosRenderHelper2Impl(element));
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        this.render(context, mouseX, mouseY);
        if (__UNDEF_KEY__) {
            easingServiceComponent.executeAction(1.0F);
            if (this.getContract4() != null) {
            } else {
            }
        }
        this.executeAction(0.0F);
        easingServiceComponent3.executeAction(factorValue);
        float factor = (this.getNumericValue() + 3.0F);
        float factor2 = (this.getNumericValue() + 72.0F);
        int index = mouseX;
        if (__UNDEF_KEY__) {
            if (factor <= index) {
                if (__UNDEF_KEY__) {
                    if (index <= factor2) {
                    }
                }
            } else {
            }
        }
        if (0) {
            factor = (this.getNumericValue2() + 5.0F);
            factor2 = (this.getNumericValue2() + 13.0F);
            index = mouseY;
            if (__UNDEF_KEY__) {
                if (factor <= index) {
                    if (__UNDEF_KEY__) {
                        if (index <= factor2) {
                        }
                    }
                } else {
                }
            }
        }
        enabledFlag2 = 0;
        if (enabledFlag2) {
        }
        if (enabledFlag2) {
        }
        int index2 = 14336;
        float factor3 = 0.0F;
        float factor4 = 0.0F;
        float factor5 = 0.0F;
        Color color = NewThemeRenderHelper.INSTANCE.getColor6();
        Color color2 = NewThemeRenderHelper.INSTANCE.getColor4();
        float factor6 = 1.0F;
        float factor7 = 0.0F;
        float factor8 = 0.1F;
        float factor9 = 2.0F;
        float factor10 = 2.5F;
        float factor11 = 2.0F;
        float factor12 = 8.0F;
        float factor13 = 69.0F;
        StackShaderComponent2.executeAction((this.getNumericValue2() + 3.0F), factor13, factor12, factor11, factor10, factor9, factor8, factor7, factor6, color2, color, factor5, factor4, factor3, index2);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "+", (this.getNumericValue() + 36.0F), (this.getNumericValue2() + 1.0F), Color.WHITE);
        StackShaderComponent2.executeAction(context.method_51448(), (this.getNumericValue() + 76.0F), this.getNumericValue2(), 6.0F, this.getNumericValue4(), 1.0F, 0.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        renderHelper23 = null;
        renderHelper2 = null;
        enabledFlag = 0;
        factor = 0.0F;
        factor = (17.0F + easingServiceComponent3.getNumericValue());
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(this.getNumericValue(), (this.getNumericValue2() + 14), (this.getNumericValue() + 76), ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)));
        factor2 = ((Iterable) itemList);
        index = 0;
        Iterator iterator = factor2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            MacrosRenderHelper2Impl macrosRenderHelper2Impl = ((MacrosRenderHelper2Impl) element);
            macrosRenderHelper2Impl.render(context, INSTANCE.getNumericValue(), (INSTANCE.getNumericValue2() + factor), mouseX, mouseY);
            factor = (factor + 29.0F);
            if (__UNDEF_KEY__) {
                PolygonShaderComponent.INSTANCE.render(context);
            }
        }
        if (__UNDEF_KEY__) {
            if (macrosRenderHelper2Impl != null) {
                factor2 = ((1.0F - easingServiceComponent.getNumericValue()) * 10.0F);
                index = this::getUnit;
                suggestionsRenderHelper2Impl.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 17.0F) + factor2), mouseX, mouseY);
                iterator = macrosRenderHelper2Impl.getContract8();
                if (__UNDEF_KEY__) {
                    if (iterator instanceof IdRecord9) {
                        suggestionsRenderHelper2Impl2.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 32.0F) + factor2), mouseX, mouseY);
                        new ClickActionRenderHelper2Impl(index, this.getNumericValue3(), ((KMutableProperty0) new HoveringComponentServiceComponent8(this))).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 47.0F) + factor2), mouseX, mouseY);
                    }
                }
                if (__UNDEF_KEY__) {
                    if (iterator instanceof IdRecord) {
                        suggestionsRenderHelper2Impl3.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 32.0F) + factor2), mouseX, mouseY);
                        new FirstRenderHelper2Impl(this.getNumericValue3(), "Rage", "Legit", ((KMutableProperty0) new LegitServiceComponent(((IdRecord) macrosRenderHelper2Impl.getContract8()))), ((KMutableProperty0) new HoveringComponentServiceComponent2(this))).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 47.0F) + factor2), mouseX, mouseY);
                        new ClickActionRenderHelper2Impl(index, this.getNumericValue3(), ((KMutableProperty0) new HoveringComponentServiceComponent(this))).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 62.0F) + factor2), mouseX, mouseY);
                    }
                }
                if (iterator instanceof IdRecord11) {
                    suggestionsRenderHelper2Impl4.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 32.0F) + factor2), mouseX, mouseY);
                    suggestionsRenderHelper2Impl5.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 47.0F) + factor2), mouseX, mouseY);
                    suggestionsRenderHelper2Impl6.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 62.0F) + factor2), mouseX, mouseY);
                    suggestionsRenderHelper2Impl7.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 77.0F) + factor2), mouseX, mouseY);
                    new FirstRenderHelper2Impl(this.getNumericValue3(), "Toggle", "Hold", ((KMutableProperty0) new HoldServiceComponent(((IdRecord11) macrosRenderHelper2Impl.getContract8()))), ((KMutableProperty0) new HoveringComponentServiceComponent4(this))).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 92.0F) + factor2), mouseX, mouseY);
                    new ClickActionRenderHelper2Impl(index, this.getNumericValue3(), ((KMutableProperty0) new HoveringComponentServiceComponent3(this))).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 107.0F) + factor2), mouseX, mouseY);
                    if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                    }
                }
            }
            ColorValue1RenderHelper.executeAction(this.getNumericValue(), this.getNumericValue2(), this.getNumericValue3(), this.getNumericValue4(), 5.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), context.method_51448(), 0.0F);
        }
        if (__UNDEF_KEY__) {
            if (this.getContract4() != null) {
                this.getContract4().render(context, ((this.getNumericValue() + (this.getNumericValue3() / 2.0F)) - 60.0F), ((this.getNumericValue2() + (this.getNumericValue4() / 2)) - 35.0F), mouseX, mouseY);
            } else {
            }
        }
        if (__UNDEF_KEY__) {
        }
    }

    public void executeAction(int keyCode, int scanCode, int modifiers) {
        if (macrosRenderHelper2Impl2 != null) {
            if (macrosRenderHelper2Impl2 != null && macrosRenderHelper2Impl2.getContract8() != null) {
                macrosRenderHelper2Impl2.getContract8().executeAction(new KeyRecord(keyCode, false, false));
            }
            macrosRenderHelper2Impl2 = null;
            return;
        }
        this.executeAction(keyCode, scanCode, modifiers);
    }

    public void executeAction(float mX, float mY, int button) {
        this.executeAction(mX, mY, button);
        if (!(__UNDEF_KEY__)) {
            if (this.getContract4() != null) {
                if (!(__UNDEF_KEY__)) {
                    if (this.getContract4().checkCondition(mX, mY, button) == 1) {
                    }
                }
            } else {
            }
        }
        if (0) {
            return;
        }
        if (__UNDEF_KEY__ >= 0) {
            if (enabledFlag2) {
                SuggestionsRenderHelper2Impl.serviceComponent7.updateValue(null);
                this.updateValue(new CancelRenderHelper());
                return;
            }
            this.updateValue(null);
        }
        if (__UNDEF_KEY__ >= 0) {
            if (!(__UNDEF_KEY__)) {
                if (macrosRenderHelper2Impl2 != null) {
                    macrosRenderHelper2Impl2.getContract8().executeAction(new KeyRecord(button, false, true));
                    macrosRenderHelper2Impl2 = null;
                    return;
                }
            }
        }
        if (__UNDEF_KEY__ > 0 && !(__UNDEF_KEY__)) {
            if (renderHelper2 != null) {
                renderHelper22 = renderHelper2;
                renderHelper2.checkCondition(mX, mY, button);
                return;
            }
            renderHelper22 = null;
        }
        if (__UNDEF_KEY__ >= 0 && !(__UNDEF_KEY__)) {
        }
        if (enabledFlag) {
            macrosRenderHelper2Impl2 = ((MacrosRenderHelper2Impl) renderHelper23);
            return;
        }
        if (!(__UNDEF_KEY__)) {
            if (!(((MacrosRenderHelper2Impl) renderHelper23).getContract8().isActive())) {
            } else {
            }
        }
        this.updateValue(false);
        if (__UNDEF_KEY__ >= 0) {
            macrosRenderHelper2Impl = ((MacrosRenderHelper2Impl) renderHelper23);
            suggestionsRenderHelper2Impl.executeAction(macrosRenderHelper2Impl.getContract8().getString());
        }
        if (__UNDEF_KEY__ >= 0) {
            if (!(__UNDEF_KEY__)) {
                if (macrosRenderHelper2Impl.getContract8() instanceof IdRecord9) {
                    suggestionsRenderHelper2Impl2.executeAction(((IdRecord9) macrosRenderHelper2Impl.getContract8()).getString());
                }
            }
        }
        if (__UNDEF_KEY__ > 0 && !(__UNDEF_KEY__)) {
            if (macrosRenderHelper2Impl.getContract8() instanceof IdRecord) {
                suggestionsRenderHelper2Impl3.executeAction(((IdRecord) macrosRenderHelper2Impl.getContract8()).getString());
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            if (macrosRenderHelper2Impl.getContract8() instanceof IdRecord11) {
                suggestionsRenderHelper2Impl4.executeAction(((IdRecord11) macrosRenderHelper2Impl.getContract8()).getString());
                suggestionsRenderHelper2Impl5.executeAction(((IdRecord11) macrosRenderHelper2Impl.getContract8()).getString2());
                suggestionsRenderHelper2Impl6.executeAction(((IdRecord11) macrosRenderHelper2Impl.getContract8()).getString3());
                suggestionsRenderHelper2Impl7.executeAction(((IdRecord11) macrosRenderHelper2Impl.getContract8()).getString4());
            }
            easingServiceComponent.updateValue2(0.0F);
            if (__UNDEF_KEY__ > 0) {
                macrosRenderHelper2Impl2 = ((MacrosRenderHelper2Impl) renderHelper23);
            }
        }
    }

    public void executeAction(double mouseX, double mouseY, double amount) {
        float factor = this.getNumericValue();
        if (__UNDEF_KEY__ >= 0L) {
            if (!(__UNDEF_KEY__)) {
                if (mouseX <= (this.getNumericValue() + 76.0F)) {
                    if (!(__UNDEF_KEY__)) {
                        if (factor <= mouseX) {
                        }
                    }
                } else {
                }
            }
        }
        factor = this.getNumericValue2();
        if (__UNDEF_KEY__ >= 0L) {
            if (!(__UNDEF_KEY__)) {
                if (mouseY <= ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)) {
                    if (!(__UNDEF_KEY__)) {
                        if (factor <= mouseY) {
                        }
                    }
                } else {
                }
            }
        }
        factorValue = (factorValue + (amount * 7.0F));
        factorValue = Math.clamp(factorValue, (itemList.size() * -29.0F), 0.0F);
    }

    private static Unit resolveUnit(SuggestionsRenderHelper2Impl arg0) {
        if (macrosRenderHelper2Impl != null && macrosRenderHelper2Impl.getContract8() != null) {
            macrosRenderHelper2Impl.getContract8().executeAction(arg0.getString2());
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(SuggestionsRenderHelper2Impl arg0) {
        if (!(__UNDEF_KEY__)) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        if (!(null instanceof IdRecord9)) {
            return Unit.INSTANCE;
        }
        if (!(__UNDEF_KEY__)) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        ((IdRecord9) null).executeAction(arg0.getString2());
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit3(SuggestionsRenderHelper2Impl arg0) {
        if (__UNDEF_KEY__) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        if (!(null instanceof IdRecord)) {
            return Unit.INSTANCE;
        }
        if (__UNDEF_KEY__) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        ((IdRecord) null).executeAction(arg0.getString2());
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit4(SuggestionsRenderHelper2Impl arg0) {
        if (__UNDEF_KEY__) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        if (!(null instanceof IdRecord11)) {
            return Unit.INSTANCE;
        }
        if (__UNDEF_KEY__) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        ((IdRecord11) null).executeAction(arg0.getString2());
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit5(SuggestionsRenderHelper2Impl arg0) {
        if (__UNDEF_KEY__) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        if (!(null instanceof IdRecord11)) {
            return Unit.INSTANCE;
        }
        if (__UNDEF_KEY__) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        IdRecord11 idRecord11 = ((IdRecord11) null);
        Iterable iterable = ((Iterable) EnabledServiceComponent.INSTANCE.getArrayList2());
        SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl = arg0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Module module = ((Module) element);
            int index = 0;
        }
        Module module2 = ((Module) null);
        if (__UNDEF_KEY__) {
            if (module2 != null) {
                iterable = module2.getList();
                if (__UNDEF_KEY__) {
                    if (iterable != null) {
                        iterator = ((Iterable) iterable);
                        element = 0;
                        module = iterator;
                        index = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterator, 10)));
                        Iterator iterator2 = module.iterator();
                        while (iterator2.hasNext()) {
                            Object element2 = iterator2.next();
                            VisibleSettingProperty visibleSettingProperty = ((VisibleSettingProperty) element2);
                            if (__UNDEF_KEY__) {
                                index.add(visibleSettingProperty.getString());
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        }
        List list = CollectionsKt.emptyList();
        index.executeAction(new SuggestionsServiceComponent(list));
        idRecord11.executeAction2(arg0.getString2());
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit6(SuggestionsRenderHelper2Impl arg0) {
        if (!(__UNDEF_KEY__)) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        if (!(null instanceof IdRecord11)) {
            return Unit.INSTANCE;
        }
        if (!(__UNDEF_KEY__)) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        ((IdRecord11) null).executeAction(arg0.getString2());
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit7(SuggestionsRenderHelper2Impl arg0) {
        if (!(__UNDEF_KEY__)) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        if (!(null instanceof IdRecord11)) {
            return Unit.INSTANCE;
        }
        if (!(__UNDEF_KEY__)) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        ((IdRecord11) null).executeAction3(arg0.getString2());
        return Unit.INSTANCE;
    }

    private static Unit getUnit() {
        MacroServiceComponent.INSTANCE.checkCondition(macrosRenderHelper2Impl.getContract8());
        Collection collection = ((Collection) itemList);
        TypeIntrinsics.asMutableCollection(collection).remove(macrosRenderHelper2Impl);
        macrosRenderHelper2Impl = null;
        return Unit.INSTANCE;
    }

    static {
        INSTANCE = new MacroPanelRenderHelper3Impl();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        easingServiceComponent3 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        suggestionsRenderHelper2Impl = new SuggestionsRenderHelper2Impl("Name", INSTANCE.getNumericValue3(), null, this::resolveUnit);
        suggestionsRenderHelper2Impl2 = new SuggestionsRenderHelper2Impl("Text", INSTANCE.getNumericValue3(), null, this::resolveUnit2);
        List list = new ArrayList();
        List list2 = list;
        float factor = INSTANCE.getNumericValue3();
        String text = "Item";
        int index = 0;
        Iterable iterable = ((Iterable) class_7923.field_41175);
        List list3 = list2;
        int index2 = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Block block = ((Block) element);
            Collection collection2 = collection;
            collection2.add(StringsKt.replace$default(block.method_63499(), "block.minecraft.", "", false));
        }
        list3.addAll(((Collection) collection));
        iterable = ((Iterable) class_7923.field_41178);
        list3 = list2;
        index2 = 0;
        iterable2 = iterable;
        collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            block = ((Item) element);
            collection2 = collection;
            collection2.add(StringsKt.replace$default(block.method_7876(), "item.minecraft.", "", false));
        }
        list3.addAll(((Collection) collection));
        Unit unit = Unit.INSTANCE;
        Function1 function1 = this::resolveUnit3;
        SuggestionsServiceComponent suggestionsServiceComponent = new SuggestionsServiceComponent(list);
        suggestionsRenderHelper2Impl3 = new SuggestionsRenderHelper2Impl(text, factor, suggestionsServiceComponent, function1);
        list = ((Iterable) EnabledServiceComponent.INSTANCE.getArrayList2());
        factor = INSTANCE.getNumericValue3();
        text = "Module";
        list2 = 0;
        index = list;
        iterable = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10)));
        list3 = 0;
        index2 = index.iterator();
        while (index2.hasNext()) {
            iterable2 = index2.next();
            collection = ((Module) iterable2);
            unit = iterable;
            unit.add(collection.getString());
        }
        unit = iterable;
        Function1 function12 = this::resolveUnit4;
        SuggestionsServiceComponent suggestionsServiceComponent2 = new SuggestionsServiceComponent(unit);
        suggestionsRenderHelper2Impl4 = new SuggestionsRenderHelper2Impl(text, factor, suggestionsServiceComponent2, function12);
        suggestionsRenderHelper2Impl5 = new SuggestionsRenderHelper2Impl("Setting", INSTANCE.getNumericValue3(), null, this::resolveUnit5);
        suggestionsRenderHelper2Impl6 = new SuggestionsRenderHelper2Impl("Press", INSTANCE.getNumericValue3(), null, this::resolveUnit6);
        suggestionsRenderHelper2Impl7 = new SuggestionsRenderHelper2Impl("Release", INSTANCE.getNumericValue3(), null, this::resolveUnit7);
        INSTANCE.updateValue();
        INSTANCE.updateValue2(240.0F);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
