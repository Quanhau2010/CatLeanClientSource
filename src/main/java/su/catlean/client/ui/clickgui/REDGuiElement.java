package su.catlean.client.ui.clickgui;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.class_1041;
import net.minecraft.class_156;
import net.minecraft.class_156.class_158;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2f;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.client.config.models.IdRecord6;
import su.catlean.client.services.render.ColorValue1RenderHelper;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.MissingnoRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.ThemeRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class REDGuiElement {

    public static final REDGuiElement INSTANCE;
    private static float factorValue;
    private static float factorValue2;
    private static float factorValue3;
    private static float factorValue4;
    private static IdRecord6 idRecord6;
    private static IdRecord6 idRecord62;
    private static List itemList;
    private static float factorValue5;
    private static String textValue;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static final EasingServiceComponent easingServiceComponent;
    private static final EasingServiceComponent easingServiceComponent2;
    private static final EasingServiceComponent easingServiceComponent3;
    private static final MissingnoRenderHelper missingnoRenderHelper;
    private static final MissingnoRenderHelper missingnoRenderHelper2;
    private static Module[] moduleArray;

    private REDGuiElement() {
    }

    public float getNumericValue() {
        return factorValue;
    }

    public void updateValue(float value) {
        factorValue = value;
    }

    public float getNumericValue2() {
        return factorValue2;
    }

    public void updateValue2(float value) {
        factorValue2 = value;
    }

    public MissingnoRenderHelper getMissingnoRenderHelper() {
        return missingnoRenderHelper2;
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        if (enabledFlag) {
        } else {
        }
        1.0F.executeAction(0.0F);
        float var66 = ((factorValue3 + factorValue) - 21.0F);
        float var67 = ((factorValue3 + factorValue) - 7.0F);
        int var68 = mouseX;
        if (var66 <= var68) {
        } else {
        }
        if (var68 <= var67) {
            var66 = (factorValue4 + 31.0F);
            var67 = (factorValue4 + 45.0F);
            var68 = mouseY;
            if (var66 <= var68) {
            } else {
            }
            if (var68 <= var67 && enabledFlag && idRecord62 == null) {
            }
        } else {
        }
        }
        1.0F.executeAction(0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), factorValue3, factorValue4, factorValue, factorValue2, 5.0F, 0.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        var67 = (factorValue3 + 5.0F);
        var68 = (factorValue3 + 20.0F);
        int var69 = mouseX;
        if (var67 <= var69) {
        } else {
        }
        if (var69 <= var68) {
            var67 = (factorValue4 + 6.0F);
            var68 = (factorValue4 + 21.0F);
            var69 = mouseY;
            if (var67 <= var69) {
            } else {
            }
            if (var69 <= var68) {
            }
        } else {
        }
        }
        var66 = NewThemeRenderHelper.INSTANCE.getColor6().brighter();
        int var51 = 14336;
        float var52 = 0.0F;
        float var53 = 0.0F;
        float var54 = 0.0F;
        Color var55 = NewThemeRenderHelper.INSTANCE.getColor6().brighter();
        Object var56 = var66;
        Color var57 = NewThemeRenderHelper.INSTANCE.getColor4().brighter().brighter().brighter().brighter().brighter();
        float var58 = 1.0F;
        float var59 = 0.0F;
        float var60 = 1.0F;
        float var61 = 3.0F;
        float var62 = 15.0F;
        float var63 = 15.0F;
        float var64 = (factorValue4 + 6.0F);
        StackShaderComponent2.executeAction((factorValue3 + 5.0F));
        MissingnoRenderHelper.executeAction(missingnoRenderHelper, (Matrix3x2f) context.method_51448(), (factorValue3 + 7.5D), (factorValue4 + 7.5D), 0.0F, 0.0F, null, null, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper9().render(context, "Theme Editor", (factorValue3 + (factorValue / 2.0F)), (factorValue4 + 5), 10);
        var66 = new Color[1];
        var66[0] = new Color(1157627903, 1);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (factorValue3 + 6), (factorValue4 + 24), (factorValue - 12), 0.5F);
        idRecord6 = null;
        if (idRecord62 == null) {
            StackShaderComponent2.executeAction(context.method_51448(), (factorValue3 + 4.0F), (factorValue4 + 28.0F), (factorValue - 8.0F), 20.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            StackShaderComponent2.executeAction(context.method_51448(), ((factorValue3 + factorValue) - 21.0F), (factorValue4 + 31.0F), 14.0F, 14.0F, 3.0F, 0.0F, (0.2F + (easingServiceComponent2.getNumericValue() / 10.0F)), 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            var66 = new Color[1];
            var66[0] = NewThemeRenderHelper.INSTANCE.getColor8();
            PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), ((factorValue3 + factorValue) - 14.0F), (factorValue4 + 35.0F), 1.0F, 6.0F);
            var66 = new Color[1];
            var66[0] = NewThemeRenderHelper.INSTANCE.getColor8();
            PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), ((factorValue3 + factorValue) - 16.5F), (factorValue4 + 37.5F), 6.0F, 1.0F);
            if ((System.currentTimeMillis() % 1000) > 500L && enabledFlag) {
            } else {
            }
            context.render(textValue, ("_" + ""), (factorValue3 + 10.0F), (factorValue4 + 31.5F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor8(), NewThemeRenderHelper.INSTANCE.getColor7(), easingServiceComponent3.getNumericValue()));
            factorValue2 = ((ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveList().size() * 24) + 52.0F);
            var66 = (Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveList();
            var67 = 0;
            var68 = 0;
            var69 = var66.iterator();
            while (var69.hasNext()) {
                Object var70 = var69.next();
                int var71 = var68;
                if (var71 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                IdRecord6 var72 = (IdRecord6) var70;
                int var73 = var71;
                int var74 = 0;
                float var75 = (factorValue3 + 4.0F);
                float var76 = (((factorValue3 + 4.0F) + factorValue) - 8.0F);
                int var77 = mouseX;
                if (var75 <= var77) {
                } else {
                }
                if (var77 <= var76) {
                    var75 = ((factorValue4 + 52.0F) + (var73 * 24));
                    var76 = ((factorValue4 + 72.0F) + (var73 * 24));
                    var77 = mouseY;
                    if (var75 <= var77) {
                    } else {
                    }
                    if (var77 <= var76) {
                        idRecord6 = var72;
                    }
                }
                StackShaderComponent2.executeAction(context.method_51448(), (factorValue3 + 4.0F), ((factorValue4 + 52.0F) + (var73 * 24)), (factorValue - 8.0F), 20.0F, 4.0F, 2.0F, 0.0F, 1.0F, var72.getColor3(), var72.getColor5(), 0.0F, 0.0F, 0.0F);
                if (Intrinsics.areEqual(ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6())) {
                } else {
                    if (Intrinsics.areEqual(idRecord6)) {
                    } else {
                    }
                }
                var75 = 0.4F;
                ColorValue1RenderHelper.executeAction((factorValue3 + 4.0F), ((factorValue4 + 52.0F) + (var73 * 24)), (factorValue - 8.0F), 20.0F, 4.0F, PolygonShaderComponent.INSTANCE.resolveColor(var72.getColor()), PolygonShaderComponent.INSTANCE.resolveColor(var72.getColor2()), PolygonShaderComponent.INSTANCE.resolveColor(var72.getColor3()), PolygonShaderComponent.INSTANCE.resolveColor(var72.getColor5()), context.method_51448(), 0.0F);
                SFMServiceComponent.resolveFontRenderHelper2().render(context, var72.getString(), ((factorValue3 + 4.0F) + ((factorValue / 2.0F) - 4.0F)), ((factorValue4 + 61.0F) + (var73 * 24)), var72.getColor6());
            }
        } else {
            StackShaderComponent2.executeAction(context.method_51448(), (factorValue3 + 4.0F), (factorValue4 + 28.0F), (factorValue - 8.0F), 20.0F, 4.0F, 0.0F, 0.1F, 1.0F, idRecord62.getColor3(), idRecord62.getColor5(), 0.0F, 0.0F, 0.0F);
            SFMServiceComponent.resolveFontRenderHelper2().render(context, idRecord62.getString(), (factorValue3 + 10.0F), (factorValue4 + 31.5F), PolygonShaderComponent.INSTANCE.resolveColor(idRecord62.getColor(), 0.5F));
            StackShaderComponent2.executeAction(context.method_51448(), ((factorValue3 + factorValue) - 19.0F), (factorValue4 + 33.0F), 10.5F, 10.5F, 2.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            MissingnoRenderHelper.executeAction(missingnoRenderHelper2, (Matrix3x2f) context.method_51448(), ((factorValue3 + factorValue) - 19.0D), (factorValue4 + 32.0D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor7(), null, 0.0F);
            PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(factorValue3, (factorValue4 + 52), (factorValue3 + factorValue), (factorValue4 + factorValue2)));
            var66 = 0.0F;
            var67 = (Iterable) itemList;
            var68 = 0;
            var69 = var67.iterator();
            while (var69.hasNext()) {
                var70 = var69.next();
                var71 = (ThemeRenderHelper) var70;
                var72 = 0;
                var71.updateValue((factorValue3 + 5.0F));
                var71.updateValue2((((factorValue4 + 52.0F) + var66) + factorValue5));
                var71.render(context, mouseX, mouseY);
                var66 = (var66 + (var71.getNumericValue4() + 2.0F));
            }
            var67 = (factorValue3 + 5.0F);
            var68 = (factorValue3 + 115.0F);
            var69 = mouseX;
            if (var67 <= var69) {
            } else {
            }
            if (var69 <= var68) {
                var67 = (((factorValue4 + 52.0F) + var66) + factorValue5);
                var68 = (((factorValue4 + 64.0F) + var66) + factorValue5);
                var69 = mouseY;
                if (var67 <= var69) {
                } else {
                }
            } else {
            }
            enabledFlag2 = var69 <= var68;
            if (enabledFlag2) {
            } else {
            }
            1.0F.executeAction(0.0F);
            StackShaderComponent2.executeAction(context.method_51448(), (factorValue3 + 5.0F), (((factorValue4 + 52.0F) + var66) + factorValue5), 110.0F, 12.0F, 3.0F, 2.0F, 0.4F, 1.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, (0.5F + (easingServiceComponent.getNumericValue() / 5.0F))), Color.RED, 0.0F, 0.0F, 0.0F);
            SFMServiceComponent.resolveFontRenderHelper3().render(context, KeyServiceComponent.INSTANCE.resolveString("hub.theme-editor.delete", new Object[0]), ((factorValue3 + 5.0F) + 55.0F), (((factorValue4 + 57.0F) + var66) + factorValue5), NewThemeRenderHelper.INSTANCE.getColor7());
            var66 = (var66 + 16.0F);
            PolygonShaderComponent.INSTANCE.render(context);
            if (var66 != 0.0F) {
                factorValue5 = Math.clamp(factorValue5, (var66 + 206), 0.0F);
            }
            factorValue2 = 262.0F;
        }
        factorValue3 = ((SharedKt.getMc().method_22683().method_4486() - factorValue) - 5.0F);
        factorValue4 = ((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (factorValue2 / 2.0F));
    }

    public void executeAction(double mouseX, double mouseY, int button) {
        if (idRecord62 != null && enabledFlag2) {
            ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveList().remove(idRecord62);
            idRecord62 = null;
            return;
        }
        float var23 = (factorValue3 + 5.0F);
        float var24 = (factorValue3 + 20.0F);
        double var25 = mouseX;
        if (var23 <= var25) {
        } else {
        }
        if (var25 <= var24) {
            var23 = (factorValue4 + 6.0F);
            var24 = (factorValue4 + 21.0F);
            var25 = mouseY;
            if (var23 <= var25) {
            } else {
            }
            if (var25 <= var24) {
                var23 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().getFile();
                var24 = var23;
                class_158 var34 = class_156.method_668();
                var25 = 0;
                if (!(var24.exists())) {
                    var24.createNewFile();
                }
                var34.method_672();
            }
        }
        var23 = ((factorValue3 + factorValue) - 21.0F);
        if (mouseX <= ((factorValue3 + factorValue) - 7.0F)) {
        } else {
        }
        if (var23 <= mouseX) {
            var23 = (factorValue4 + 31.0F);
            if (mouseY <= (factorValue4 + 45.0F)) {
            } else {
            }
            if (var23 <= mouseY && enabledFlag && idRecord62 == null) {
                this.updateValue();
                return;
            }
        }
        var23 = (factorValue3 + 4.0F);
        if (mouseX <= (((factorValue3 + 4.0F) + factorValue) - 8.0F)) {
        } else {
        }
        if (var23 <= mouseX) {
            var23 = (factorValue4 + 28.0F);
            if (mouseY <= (factorValue4 + 48.0F)) {
            } else {
            }
            if (var23 <= mouseY) {
                var23 = idRecord62;
                if (var23 != null) {
                    var25 = var23;
                    int var26 = 0;
                    idRecord62 = null;
                    return;
                }
                if (enabledFlag) {
                    enabledFlag = 0;
                    textValue = "Enter name";
                } else {
                    enabledFlag = 1;
                    textValue = "";
                }
                return;
            }
        }
        var23 = (Iterable) itemList;
        var24 = 0;
        var25 = var23.iterator();
        while (var25.hasNext()) {
            var26 = var25.next();
            ThemeRenderHelper var27 = (ThemeRenderHelper) var26;
            int var28 = 0;
            var27.executeAction(mouseX, mouseY, button);
        }
        if (!(button)) {
            if (idRecord6 != null) {
                var25 = idRecord6;
                var26 = 0;
                NewThemeRenderHelper.INSTANCE.executeAction();
            } else {
            } else {
                if (idRecord6 != null) {
                    var25 = idRecord6;
                    var26 = 0;
                    itemList.clear();
                    idRecord62 = idRecord6;
                    var27 = 0;
                    var28 = NewThemeRenderHelper.INSTANCE.resolveMap(idRecord62);
                    int var29 = 0;
                    Iterator iterator = var28.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Entry var31 = (Entry) iterator.next();
                        Object var32 = var31;
                        int var33 = 0;
                        itemList.add(new ThemeRenderHelper((String) var32.getKey(), idRecord62, (factorValue3 + 4.0F), ((factorValue4 + 55.0F) + (var27 * 16.0F)), (Color) var32.getValue()));
                        var27 = (var27 + 1);
                    }
                } else {
                }
            }
        }
    }

    public void executeAction(double mouseX, double mouseY) {
        Iterable var12 = (Iterable) itemList;
        int var13 = 0;
        Iterator iterator = var12.iterator();
        if (iterator.hasNext()) {
            Object var15 = iterator.next();
            ThemeRenderHelper var16 = (ThemeRenderHelper) var15;
            int var17 = 0;
            var16.executeAction();
            if (0L < 0) {
            }
        }
    }

    public void executeAction(int keyCode) {
        Iterable var11 = (Iterable) itemList;
        int var12 = 0;
        Iterator iterator = var11.iterator();
        while (iterator.hasNext()) {
            Object var14 = iterator.next();
            ThemeRenderHelper var15 = (ThemeRenderHelper) var14;
            int var16 = 0;
            var15.executeAction(keyCode);
        }
        textValue = StringsKt.dropLast(textValue, 1);
        this.updateValue();
        enabledFlag = 0;
        textValue = "Enter name";
    }

    private void updateValue(long arg0) {
        if (StringsKt.isBlank((CharSequence) textValue)) {
            enabledFlag = 0;
            textValue = "Enter name";
            return;
        }
        NewThemeRenderHelper var10 = NewThemeRenderHelper.INSTANCE;
        int var11 = 0;
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveList().add(new IdRecord6(textValue, var10.getColor2(), var10.getColor3(), var10.getColor4(), var10.getColor5(), var10.getColor6(), var10.getColor7(), var10.getColor8(), var10.getColor9(), var10.getColor10(), var10.getColor11(), var10.getColor12(), var10.getColor13()));
        enabledFlag = 0;
        textValue = "Enter name";
    }

    public void executeAction(char chr) {
        Iterable var7 = (Iterable) itemList;
        int var8 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var10 = iterator.next();
            ThemeRenderHelper var11 = (ThemeRenderHelper) var10;
            int var12 = 0;
            var11.executeAction(chr);
            if (var6 != null) {
            }
        }
        textValue = (textValue + chr);
    }

    public boolean checkCondition(double mX, double mY, double amount) {
        float var13 = factorValue3;
        if (mX <= (factorValue3 + factorValue)) {
        } else {
        }
        if (var13 <= mX) {
            var13 = factorValue4;
            if (0L > 0L && var12 != null) {
                if (mY <= (factorValue4 + factorValue2)) {
                }
            } else {
            }
            if (var13 <= mY) {
                factorValue5 = (factorValue5 + (amount * 10.0F));
                var13 = 0.0F;
                var13 = 14.0F;
                Iterable var14 = (Iterable) itemList;
                int var15 = 0;
                Iterator iterator = var14.iterator();
                while (iterator.hasNext()) {
                    Object var17 = iterator.next();
                    ThemeRenderHelper var18 = (ThemeRenderHelper) var17;
                    int var19 = 0;
                    var13 = (var13 + (var18.getNumericValue4() + 2.0F));
                    if (0L >= 0) {
                    }
                }
                if (0L >= 0) {
                    if (var13 == 14.0F) {
                        return false;
                    }
                    factorValue5 = Math.clamp(factorValue5, (var13 + 206), 0.0F);
                }
                return true;
            }
        }
        return false;
    }

    static {
        INSTANCE = new REDGuiElement();
        factorValue = 120.0F;
        factorValue2 = 270.0F;
        factorValue3 = ((SharedKt.getMc().method_22683().method_4486() - factorValue) - 5.0F);
        factorValue4 = ((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (factorValue2 / 2.0F));
        itemList = new ArrayList();
        textValue = "Enter name";
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        easingServiceComponent3 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        missingnoRenderHelper = new MissingnoRenderHelper("panels/folder", 10, 10);
        missingnoRenderHelper2 = new MissingnoRenderHelper("back", 10, 10);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
