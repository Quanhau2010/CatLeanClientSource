package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import su.catlean.SharedKt;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.AnimationServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.EnabledServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.ui.clickgui.CatleanPanelScreenGuiElement;
import su.catlean.client.ui.clickgui.REDGuiElement;

public class BackRenderHelper {

    public static final BackRenderHelper INSTANCE;
    private static AnimationServiceComponent animationServiceComponent;
    private static AnimationServiceComponent animationServiceComponent2;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static final List itemList;
    private static final EasingServiceComponent easingServiceComponent;
    private static String textValue;
    private static Function0 function0;
    private static final String textValue2;
    private static final String textValue3;
    private static String textValue4;

    private BackRenderHelper() {
    }

    public boolean isActive() {
        return enabledFlag2;
    }

    public void updateValue(boolean value) {
        enabledFlag2 = value;
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        if (!(Intrinsics.areEqual(SharedKt.getMc().currentScreen, CatleanInterfaceRenderHelper.INSTANCE))) {
            enabledFlag2 = 0;
        }
        if (enabledFlag2) {
        } else {
        }
        this.executeAction(0.0F);
        int index = (SharedKt.getMc().method_22683().method_4486() / 2.0F);
        float factor = 5.0F;
        float factor2 = 220.0F;
        float factor3 = 16.0F;
        StackShaderComponent2.executeAction(context.method_51448(), (index - (factor2 / 2.0F)), factor, factor2, factor3, 5.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        Iterable iterable = ((Iterable) itemList);
        int index2 = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (index2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AnimationServiceComponent animationServiceComponent = ((AnimationServiceComponent) element);
            this.executeAction(0.0F);
            int index3 = (((index - (factor2 / 2.0F)) + animationServiceComponent.getNumericValue()) + 2.0F);
            if (index2 == 4) {
            } else {
            }
            float factor4 = (1.0F - easingServiceComponent.getNumericValue());
            StackShaderComponent2.executeAction(context.method_51448(), index3, (factor + 2), 40.0F, (factor3 - 4.0F), 4.0F, (2.0F * animationServiceComponent.getEasingServiceComponent().getNumericValue()), (animationServiceComponent.getEasingServiceComponent().getNumericValue() / 5.0F), factor4, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            if (index2 == 4 && enabledFlag2) {
            } else {
            }
            if (Intrinsics.areEqual(animationServiceComponent.getString(), "Search") && !(Intrinsics.areEqual(SharedKt.getMc().currentScreen, CatleanInterfaceRenderHelper.INSTANCE))) {
            } else {
            }
            "Back".render(animationServiceComponent.getString(), (index3 + 20.0F), (factor + 7.0F), PolygonShaderComponent.INSTANCE, Color.WHITE.resolveColor(0.3F, factor4));
        }
        this.render(context, mouseX, mouseY, index, factor, factor2, factor3);
        REDGuiElement.INSTANCE.render(context, mouseX, mouseY);
    }

    private void render(DrawContext arg0, int arg1, int arg2, float arg3, float arg4, float arg5, float arg6) {
        function0 = null;
        if (1000.0D > 500.0D) {
        } else {
        }
        textValue.render(System.currentTimeMillis(), ("" + "_"), ((arg3 - (arg5 / 2.0F)) + 6.0F), (arg4 + 2.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, easingServiceComponent.getNumericValue()));
        Map map = this.resolveMap();
        StackShaderComponent2.executeAction(arg0.method_51448(), (arg3 - (arg5 / 2.0F)), ((arg4 + arg6) + 4.0F), arg5, ((map.size() * 14.0F) + 4.0F), 5.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        Iterable iterable = CollectionsKt.withIndex(((Iterable) map.entrySet()));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IndexedValue indexedValue = ((IndexedValue) element);
            int index = indexedValue.component1();
            Entry entry = ((Entry) indexedValue.component2());
            String text = ((String) entry.getKey());
            Function0 function0 = ((Function0) entry.getValue());
            float factor = ((arg3 - (arg5 / 2.0F)) + 6.0F);
            float factor2 = (((arg4 + arg6) + 6.0F) + (14.0F * index));
            float factor3 = (factor - 2.0F);
            float factor4 = ((factor + arg5) - 4.0F);
            int index2 = arg1;
            if (factor3 <= index2) {
            } else {
                if (index2 <= factor4) {
                    factor3 = (factor2 - 2.0F);
                    factor4 = (factor2 + 11.0F);
                    index2 = arg2;
                    if (factor3 <= index2) {
                    } else {
                        if (index2 <= factor4) {
                            StackShaderComponent2.executeAction(arg0.method_51448(), (factor - 4.0F), factor2, (arg5 - 4.0F), 14.0F, 4.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
                            function0 = function0;
                        }
                    }
                }
            }
            SFMServiceComponent.resolveFontRenderHelper3().render(arg0, text, factor, (factor2 + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, easingServiceComponent.getNumericValue()));
        }
    }

    private Map resolveMap() {
        Map map = ((Map) new LinkedHashMap());
        if (!(((CharSequence) textValue).length())) {
            return map;
        }
        String text = StringsKt.replace$default(textValue, " ", "-", false).toLowerCase(Locale.ROOT);
        String text2 = text;
        int index = 0;
        int index2 = text2.length();
        if (index < index2) {
            char ch = text2.charAt(index);
            if (StringsKt.contains$default(((CharSequence) "\u0439\u0446\u0443\u043a\u0435\u043d\u0433\u0448\u0449\u0437\u0445\u044a\u0444\u044b\u0432\u0430\u043f\u0440\u043e\u043b\u0434\u0436\u044d\u044f\u0447\u0441\u043c\u0438\u0442\u044c\u0431\u044e"), ch, false)) {
                text = StringsKt.replace$default(text, ch, "qwertyuiop[]asdfghjkl;'zxcvbnm,.".charAt(StringsKt.indexOf$default(((CharSequence) "\u0439\u0446\u0443\u043a\u0435\u043d\u0433\u0448\u0449\u0437\u0445\u044a\u0444\u044b\u0432\u0430\u043f\u0440\u043e\u043b\u0434\u0436\u044d\u044f\u0447\u0441\u043c\u0438\u0442\u044c\u0431\u044e"), ch, 0, false)), false);
            }
        }
        text2 = EnabledServiceComponent.INSTANCE.getArrayList2().iterator();
        while (text2.hasNext()) {
            index = ((Module) text2.next());
            if (map.size() < 10) {
                index2 = ((Iterable) index.getList());
                Map map2 = map;
                ch = 0;
                int index3 = index2;
                Collection collection = ((Collection) new ArrayList());
                int index4 = 0;
                Iterator iterator = index3.iterator();
                while (iterator.hasNext()) {
                    Object element = iterator.next();
                    VisibleSettingProperty visibleSettingProperty = ((VisibleSettingProperty) element);
                    if (!(StringsKt.contains$default(((CharSequence) visibleSettingProperty.getString()), ((CharSequence) text), false))) {
                        if (StringsKt.contains$default(((CharSequence) StringsKt.replace$default(visibleSettingProperty.getString(), "-", "", false)), ((CharSequence) text), false)) {
                        } else {
                        }
                    }
                    collection.add(element);
                }
                index2 = ((Iterable) collection);
                ch = 0;
                index3 = index2;
                collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(index2, 10)));
                index4 = 0;
                iterator = index3.iterator();
                while (iterator.hasNext()) {
                    element = iterator.next();
                    visibleSettingProperty = ((VisibleSettingProperty) element);
                    collection.add(TuplesKt.to((index.getString2() + " \u2192 " + visibleSettingProperty.getString2()), this::resolveUnit));
                }
                MapsKt.putAll(map2, ((Iterable) collection));
                ch = ((Iterable) index.getList());
                index3 = 0;
                collection = ch.iterator();
                while (collection.hasNext()) {
                    index4 = collection.next();
                    iterator = ((String) index4);
                    element = 0;
                }
                index2 = ((String) null);
                if (!(StringsKt.contains$default(((CharSequence) index.getString()), ((CharSequence) text), false)) && index2 == null) {
                }
                if (index2 == null) {
                } else {
                }
                index.getString2().put((index.getString2() + " (" + index2 + ")"), this::resolveUnit2);
            }
        }
        return map;
    }

    public boolean checkCondition(double mouseX, double mouseY, int button) {
        int index = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - 108.0F);
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            AnimationServiceComponent animationServiceComponent = ((AnimationServiceComponent) element);
            if (enabledFlag2) {
                if (Intrinsics.areEqual(animationServiceComponent.getString(), "Search")) {
                    int index2 = (index + animationServiceComponent.getNumericValue());
                    if (index2 <= mouseX) {
                    } else {
                    }
                    if (7.0D <= mouseY) {
                    } else {
                        if (mouseX <= (index2 + 40.0F) && mouseY <= 19.0D) {
                            animationServiceComponent.getFunction0().invoke();
                            return true;
                        }
                    }
                }
            }
        }
        if (function0 == null) {
            enabledFlag2 = 0;
        } else {
            if (function0 != null) {
                function0.invoke();
            } else {
            }
            return true;
        }
        if (enabledFlag) {
            REDGuiElement.INSTANCE.executeAction(mouseX, mouseY, button);
        }
        return false;
    }

    public void executeAction(double mouseX, double mouseY, int button) {
        REDGuiElement.INSTANCE.executeAction(mouseX, mouseY, button);
    }

    public void executeAction(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 70 && ServiceComponent13.checkCondition(341)) {
            enabledFlag2 = !(enabledFlag2);
        }
        if (enabledFlag2 && keyCode == 256) {
            enabledFlag2 = 0;
        }
        if (enabledFlag2 && keyCode == 259) {
            textValue = StringsKt.dropLast(textValue, 1);
        } else {
            REDGuiElement.INSTANCE.executeAction(keyCode, scanCode, modifiers);
        }
    }

    public void executeAction(char chr) {
        if (enabledFlag2 && textValue.length() < 20) {
            textValue = (textValue + chr);
        } else {
            REDGuiElement.INSTANCE.executeAction(chr);
        }
    }

    public boolean checkCondition(double mX, double mY, double amount) {
        if (enabledFlag) {
            return REDGuiElement.INSTANCE.checkCondition(mX, mY, amount);
        }
        return false;
    }

    private static Unit getUnit() {
        SharedKt.getMc().method_1507(((Screen) CatleanInterfaceRenderHelper.INSTANCE));
        return Unit.INSTANCE;
    }

    private static Unit getUnit2() {
        SharedKt.getMc().method_1507(((Screen) CatleanPanelScreenGuiElement.INSTANCE));
        return Unit.INSTANCE;
    }

    private static Unit getUnit3() {
        SharedKt.getMc().method_1507(((Screen) CatleanWidgetEditorRenderHelper.INSTANCE));
        return Unit.INSTANCE;
    }

    private static Unit getUnit4() {
        enabledFlag = !(enabledFlag);
        return Unit.INSTANCE;
    }

    private static Unit getUnit5() {
        enabledFlag2 = !(enabledFlag2);
        textValue = "";
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(Module arg0) {
        CatleanInterfaceRenderHelper.INSTANCE.executeAction(arg0);
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(Module arg0) {
        CatleanInterfaceRenderHelper.INSTANCE.executeAction2(arg0);
        return Unit.INSTANCE;
    }

    static {
        textValue3 = "\u0439\u0446\u0443\u043a\u0435\u043d\u0433\u0448\u0449\u0437\u0445\u044a\u0444\u044b\u0432\u0430\u043f\u0440\u043e\u043b\u0434\u0436\u044d\u044f\u0447\u0441\u043c\u0438\u0442\u044c\u0431\u044e";
        textValue2 = "qwertyuiop[]asdfghjkl;'zxcvbnm,.";
        INSTANCE = new BackRenderHelper();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_EXPO);
        textValue = "";
        AnimationServiceComponent[] items = new AnimationServiceComponent[5];
        items[0] = new AnimationServiceComponent(0.0F, "UI", null, this::getUnit);
        items[1] = new AnimationServiceComponent(44.0F, "Windows", null, this::getUnit2);
        items[2] = new AnimationServiceComponent(88.0F, "Hud", null, this::getUnit3);
        items[3] = new AnimationServiceComponent(132.0F, "Theme", null, this::getUnit4);
        items[4] = new AnimationServiceComponent(176.0F, "Search", null, this::getUnit5);
        itemList = CollectionsKt.mutableListOf(items);
        animationServiceComponent = ((AnimationServiceComponent) itemList.get(0));
        animationServiceComponent2 = animationServiceComponent;
    }

    public static void updateValue(String arg0) {
        textValue4 = arg0;
    }

    public static String getString() {
        return textValue4;
    }

}
