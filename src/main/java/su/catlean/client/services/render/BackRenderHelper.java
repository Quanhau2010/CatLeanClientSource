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
        1.0F.executeAction(0.0F);
        int var26 = (SharedKt.getMc().method_22683().method_4486() / 2.0F);
        float var27 = 5.0F;
        float var28 = 220.0F;
        float var29 = 16.0F;
        StackShaderComponent2.executeAction(context.method_51448(), (var26 - (var28 / 2.0F)), 5.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        Iterable var30 = (Iterable) itemList;
        int var31 = 0;
        int var32 = 0;
        Iterator iterator = var30.iterator();
        while (iterator.hasNext()) {
            Object var34 = iterator.next();
            int var35 = var32;
            if (var35 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AnimationServiceComponent var36 = (AnimationServiceComponent) var34;
            int var37 = var35;
            int var38 = 0;
            1.0F.executeAction(0.0F);
            float var40 = (((var26 - (var28 / 2.0F)) + var36.getNumericValue()) + 2.0F);
            if (var37 == 4) {
            } else {
            }
            float var41 = (1.0F - easingServiceComponent.getNumericValue());
            StackShaderComponent2.executeAction(context.method_51448(), (var27 + 2), 40.0F, (var29 - 4.0F), 4.0F, (2.0F * var36.getEasingServiceComponent().getNumericValue()), (var36.getEasingServiceComponent().getNumericValue() / 5.0F), NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            if (var37 == 4 && enabledFlag2) {
            } else {
            }
            if (Intrinsics.areEqual(var36.getString(), "Search") && !(Intrinsics.areEqual(SharedKt.getMc().currentScreen, CatleanInterfaceRenderHelper.INSTANCE))) {
            } else {
            }
            float var24 = var41;
            "Back".render(var36.getString(), (var40 + 20.0F), (var27 + 7.0F), PolygonShaderComponent.INSTANCE, Color.WHITE.resolveColor(0.3F));
        }
        this.render(context, mouseX, mouseY);
        REDGuiElement.INSTANCE.render(context, mouseX, mouseY);
    }

    private void render(DrawContext arg0, int arg1, int arg2, float arg3, float arg4, float arg5, float arg6) {
        function0 = null;
        if (1000.0D > 500.0D) {
        } else {
        }
        textValue.render(System.currentTimeMillis(), ("" + "_"), ((arg3 - (arg5 / 2.0F)) + 6.0F), (arg4 + 2.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, easingServiceComponent.getNumericValue()));
        Map var23 = this.resolveMap();
        StackShaderComponent2.executeAction(arg0.method_51448(), (arg3 - (arg5 / 2.0F)), ((arg4 + arg6) + 4.0F), arg5, ((var23.size() * 14.0F) + 4.0F), 5.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        Iterable var24 = CollectionsKt.withIndex((Iterable) var23.entrySet());
        int var25 = 0;
        Iterator iterator = var24.iterator();
        while (iterator.hasNext()) {
            Object var27 = iterator.next();
            IndexedValue var28 = (IndexedValue) var27;
            int var29 = 0;
            int var30 = var28.component1();
            Entry var31 = (Entry) var28.component2();
            String var32 = (String) var31.getKey();
            Function0 var33 = (Function0) var31.getValue();
            float var34 = ((arg3 - (arg5 / 2.0F)) + 6.0F);
            float var35 = (((arg4 + arg6) + 6.0F) + (14.0F * var30));
            float var36 = (var34 - 2.0F);
            float var37 = ((var34 + arg5) - 4.0F);
            int var38 = arg1;
            if (var36 <= var38) {
            } else {
            }
            if (var38 <= var37) {
                var36 = (var35 - 2.0F);
                var37 = (var35 + 11.0F);
                var38 = arg2;
                if (var36 <= var38) {
                } else {
                }
                if (var38 <= var37) {
                    StackShaderComponent2.executeAction(arg0.method_51448(), (var34 - 4.0F), (arg5 - 4.0F), 14.0F, 4.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
                    function0 = var33;
                }
            }
            SFMServiceComponent.resolveFontRenderHelper3().render(arg0, (var35 + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, easingServiceComponent.getNumericValue()));
        }
    }

    private Map resolveMap() {
        Map var4 = (Map) new LinkedHashMap();
        if (!((CharSequence) textValue.length())) {
            return var4;
        }
        String var5 = StringsKt.replace$default(textValue, " ", "-").toLowerCase(Locale.ROOT);
        Object var6 = var5;
        int var7 = 0;
        int var8 = var6.length();
        if (var7 < var8) {
            char var9 = var6.charAt();
            if (StringsKt.contains$default((CharSequence) "\u0439\u0446\u0443\u043a\u0435\u043d\u0433\u0448\u0449\u0437\u0445\u044a\u0444\u044b\u0432\u0430\u043f\u0440\u043e\u043b\u0434\u0436\u044d\u044f\u0447\u0441\u043c\u0438\u0442\u044c\u0431\u044e")) {
                var5 = StringsKt.replace$default("qwertyuiop[]asdfghjkl;'zxcvbnm,.".charAt(StringsKt.indexOf$default((CharSequence) "\u0439\u0446\u0443\u043a\u0435\u043d\u0433\u0448\u0449\u0437\u0445\u044a\u0444\u044b\u0432\u0430\u043f\u0440\u043e\u043b\u0434\u0436\u044d\u044f\u0447\u0441\u043c\u0438\u0442\u044c\u0431\u044e")));
            }
        }
        var6 = EnabledServiceComponent.INSTANCE.getArrayList2().iterator();
        while (var6.hasNext()) {
            var7 = (Module) var6.next();
            if (var4.size() < 10) {
                var8 = (Iterable) var7.getList();
                Object var17 = var4;
                var9 = 0;
                Object var10 = var8;
                Collection var11 = (Collection) new ArrayList();
                int var12 = 0;
                Iterator iterator = var10.iterator();
                while (iterator.hasNext()) {
                    Object var14 = iterator.next();
                    VisibleSettingProperty var15 = (VisibleSettingProperty) var14;
                    int var16 = 0;
                    if (!(StringsKt.contains$default((CharSequence) var15.getString(), (CharSequence) var5))) {
                        if (StringsKt.contains$default((CharSequence) StringsKt.replace$default(var15.getString(), "-", ""), (CharSequence) var5)) {
                        }
                    } else {
                    }
                    var11.add();
                }
                var8 = (Iterable) var11;
                var9 = 0;
                var10 = var8;
                var11 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
                var12 = 0;
                iterator = var10.iterator();
                while (iterator.hasNext()) {
                    var14 = iterator.next();
                    var15 = (VisibleSettingProperty) var14;
                    Object var18 = var11;
                    var16 = 0;
                    var18.add(TuplesKt.to((var7.getString2() + " \u2192 " + var15.getString2()), this::resolveUnit));
                }
                MapsKt.putAll((Iterable) var11);
                var9 = (Iterable) var7.getList();
                var10 = 0;
                var11 = var9.iterator();
                if (var11.hasNext()) {
                    var12 = var11.next();
                    iterator = (String) var12;
                    var14 = 0;
                } else {
                }
                var8 = (String) null;
                if (!(StringsKt.contains$default((CharSequence) var7.getString(), (CharSequence) var5)) && var8 == null) {
                }
                if (var8 == null) {
                } else {
                }
                var7.getString2().put((var7.getString2() + " (" + var8 + ")"), this::resolveUnit2);
            }
        }
        return var4;
    }

    public boolean checkCondition(double mouseX, double mouseY, int button) {
        int var13 = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - 108.0F);
        Iterable var14 = (Iterable) itemList;
        int var15 = 0;
        Iterator iterator = var14.iterator();
        if (iterator.hasNext()) {
            Object var17 = iterator.next();
            AnimationServiceComponent var18 = (AnimationServiceComponent) var17;
            int var19 = 0;
            if (enabledFlag2) {
                if (Intrinsics.areEqual(var18.getString(), "Search")) {
                }
                float var20 = (var13 + var18.getNumericValue());
                if (var20 <= mouseX) {
                } else {
                }
                if (7.0D <= mouseY) {
                } else {
                }
                if (mouseX <= (var20 + 40.0F) && mouseY <= 19.0D) {
                    var18.getFunction0().invoke();
                    return true;
                }
            }
        }
        if (function0 == null) {
            enabledFlag2 = 0;
        }
        if (function0 != null) {
            function0.invoke();
        } else {
        }
        return true;
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
        SharedKt.getMc().method_1507((Screen) CatleanInterfaceRenderHelper.INSTANCE);
        return Unit.INSTANCE;
    }

    private static Unit getUnit2() {
        SharedKt.getMc().method_1507((Screen) CatleanPanelScreenGuiElement.INSTANCE);
        return Unit.INSTANCE;
    }

    private static Unit getUnit3() {
        SharedKt.getMc().method_1507((Screen) CatleanWidgetEditorRenderHelper.INSTANCE);
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
        AnimationServiceComponent[] var33 = new AnimationServiceComponent[5];
        var33[0] = new AnimationServiceComponent(0.0F, "UI", null, this::getUnit);
        var33[1] = new AnimationServiceComponent(44.0F, "Windows", null, this::getUnit2);
        var33[2] = new AnimationServiceComponent(88.0F, "Hud", null, this::getUnit3);
        var33[3] = new AnimationServiceComponent(132.0F, "Theme", null, this::getUnit4);
        var33[4] = new AnimationServiceComponent(176.0F, "Search", null, this::getUnit5);
        itemList = CollectionsKt.mutableListOf();
        animationServiceComponent = (AnimationServiceComponent) itemList.get(0);
        animationServiceComponent2 = animationServiceComponent;
    }

    public static void updateValue(String arg0) {
        textValue4 = arg0;
    }

    public static String getString() {
        return textValue4;
    }

}
