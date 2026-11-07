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
        this.executeAction(0.0F);
        float factor = ((factorValue3 + factorValue) - 21.0F);
        float factor2 = ((factorValue3 + factorValue) - 7.0F);
        int index = mouseX;
        if (factor <= index) {
        } else {
            if (index <= factor2) {
                factor = (factorValue4 + 31.0F);
                factor2 = (factorValue4 + 45.0F);
                index = mouseY;
                if (factor <= index) {
                } else {
                }
                if (index <= factor2 && enabledFlag && idRecord62 == null) {
                } else {
                }
            } else {
            }
        }
        this.executeAction(0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), factorValue3, factorValue4, factorValue, factorValue2, 5.0F, 0.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        factor2 = (factorValue3 + 5.0F);
        index = (factorValue3 + 20.0F);
        int index2 = mouseX;
        if (factor2 <= index2) {
        } else {
            if (index2 <= index) {
                factor2 = (factorValue4 + 6.0F);
                index = (factorValue4 + 21.0F);
                index2 = mouseY;
                if (factor2 <= index2) {
                } else {
                    if (index2 <= index) {
                    } else {
                    }
                }
            } else {
            }
        }
        factor = NewThemeRenderHelper.INSTANCE.getColor6().brighter();
        int index3 = 14336;
        float factor3 = 0.0F;
        float factor4 = 0.0F;
        float factor5 = 0.0F;
        Color color = NewThemeRenderHelper.INSTANCE.getColor6().brighter();
        Color color2 = NewThemeRenderHelper.INSTANCE.getColor4().brighter().brighter().brighter().brighter().brighter();
        float factor6 = 1.0F;
        float factor7 = 0.0F;
        float factor8 = 1.0F;
        float factor9 = 3.0F;
        float factor10 = 15.0F;
        float factor11 = 15.0F;
        float factor12 = (factorValue4 + 6.0F);
        StackShaderComponent2.executeAction((factorValue3 + 5.0F), factor12, factor11, factor10, factor9, factor8, factor7, factor6, color2, factor, color, factor5, factor4, factor3, index3);
        MissingnoRenderHelper.executeAction(missingnoRenderHelper, ((Matrix3x2f) context.method_51448()), (factorValue3 + 7.5D), (factorValue4 + 7.5D), 0.0F, 0.0F, null, null, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper9().render(context, "Theme Editor", (factorValue3 + (factorValue / 2.0F)), (factorValue4 + 5), 10);
        factor = new Color[1];
        factor[0] = new Color(1157627903, true);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (factorValue3 + 6), (factorValue4 + 24), (factorValue - 12), 0.5F, factor);
        idRecord6 = null;
        if (idRecord62 == null) {
            StackShaderComponent2.executeAction(context.method_51448(), (factorValue3 + 4.0F), (factorValue4 + 28.0F), (factorValue - 8.0F), 20.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            StackShaderComponent2.executeAction(context.method_51448(), ((factorValue3 + factorValue) - 21.0F), (factorValue4 + 31.0F), 14.0F, 14.0F, 3.0F, 0.0F, (0.2F + (easingServiceComponent2.getNumericValue() / 10.0F)), 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            factor = new Color[1];
            factor[0] = NewThemeRenderHelper.INSTANCE.getColor8();
            PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), ((factorValue3 + factorValue) - 14.0F), (factorValue4 + 35.0F), 1.0F, 6.0F, factor);
            factor = new Color[1];
            factor[0] = NewThemeRenderHelper.INSTANCE.getColor8();
            PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), ((factorValue3 + factorValue) - 16.5F), (factorValue4 + 37.5F), 6.0F, 1.0F, factor);
            if ((System.currentTimeMillis() % 1000) > 500L && enabledFlag) {
            } else {
            }
            context.render(textValue, ("_" + ""), (factorValue3 + 10.0F), (factorValue4 + 31.5F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor8(), NewThemeRenderHelper.INSTANCE.getColor7(), easingServiceComponent3.getNumericValue()));
            factorValue2 = ((ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveList().size() * 24) + 52.0F);
            factor = ((Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveList());
            factor2 = 0;
            index = 0;
            index2 = factor.iterator();
            while (index2.hasNext()) {
                Object element = index2.next();
                int index4 = index;
                if (index4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                IdRecord6 idRecord6 = ((IdRecord6) element);
                float factor13 = (factorValue3 + 4.0F);
                float factor14 = (((factorValue3 + 4.0F) + factorValue) - 8.0F);
                int index5 = mouseX;
                if (factor13 <= index5) {
                } else {
                    if (index5 <= factor14) {
                        factor13 = ((factorValue4 + 52.0F) + (index4 * 24));
                        factor14 = ((factorValue4 + 72.0F) + (index4 * 24));
                        index5 = mouseY;
                        if (factor13 <= index5) {
                        } else {
                            if (index5 <= factor14) {
                                idRecord6 = idRecord6;
                            }
                        }
                    }
                }
                StackShaderComponent2.executeAction(context.method_51448(), (factorValue3 + 4.0F), ((factorValue4 + 52.0F) + (index4 * 24)), (factorValue - 8.0F), 20.0F, 4.0F, 2.0F, 0.0F, 1.0F, idRecord6.getColor3(), idRecord6.getColor5(), 0.0F, 0.0F, 0.0F);
                if (Intrinsics.areEqual(ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6(), idRecord6)) {
                } else {
                    if (Intrinsics.areEqual(idRecord6, idRecord6)) {
                    } else {
                    }
                }
                factor13 = 0.4F;
                ColorValue1RenderHelper.executeAction((factorValue3 + 4.0F), ((factorValue4 + 52.0F) + (index4 * 24)), (factorValue - 8.0F), 20.0F, 4.0F, PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor(), factor13), PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor2(), factor13), PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor3(), factor13), PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor5(), factor13), context.method_51448(), 0.0F);
                SFMServiceComponent.resolveFontRenderHelper2().render(context, idRecord6.getString(), ((factorValue3 + 4.0F) + ((factorValue / 2.0F) - 4.0F)), ((factorValue4 + 61.0F) + (index4 * 24)), idRecord6.getColor6());
            }
        } else {
            StackShaderComponent2.executeAction(context.method_51448(), (factorValue3 + 4.0F), (factorValue4 + 28.0F), (factorValue - 8.0F), 20.0F, 4.0F, 0.0F, 0.1F, 1.0F, idRecord62.getColor3(), idRecord62.getColor5(), 0.0F, 0.0F, 0.0F);
            SFMServiceComponent.resolveFontRenderHelper2().render(context, idRecord62.getString(), (factorValue3 + 10.0F), (factorValue4 + 31.5F), PolygonShaderComponent.INSTANCE.resolveColor(idRecord62.getColor(), 0.5F));
            StackShaderComponent2.executeAction(context.method_51448(), ((factorValue3 + factorValue) - 19.0F), (factorValue4 + 33.0F), 10.5F, 10.5F, 2.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            MissingnoRenderHelper.executeAction(missingnoRenderHelper2, ((Matrix3x2f) context.method_51448()), ((factorValue3 + factorValue) - 19.0D), (factorValue4 + 32.0D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor7(), null, 0.0F);
            PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(factorValue3, (factorValue4 + 52), (factorValue3 + factorValue), (factorValue4 + factorValue2)));
            factor = 0.0F;
            factor2 = ((Iterable) itemList);
            index = 0;
            index2 = factor2.iterator();
            while (index2.hasNext()) {
                element = index2.next();
                index4 = ((ThemeRenderHelper) element);
                idRecord6 = 0;
                index4.updateValue((factorValue3 + 5.0F));
                index4.updateValue2((((factorValue4 + 52.0F) + factor) + factorValue5));
                index4.render(context, mouseX, mouseY);
                factor = (factor + (index4.getNumericValue4() + 2.0F));
            }
            factor2 = (factorValue3 + 5.0F);
            index = (factorValue3 + 115.0F);
            index2 = mouseX;
            if (factor2 <= index2) {
            } else {
                if (index2 <= index) {
                    factor2 = (((factorValue4 + 52.0F) + factor) + factorValue5);
                    index = (((factorValue4 + 64.0F) + factor) + factorValue5);
                    index2 = mouseY;
                    if (factor2 <= index2) {
                    } else {
                    }
                } else {
                    enabledFlag2 = index2 <= index;
                }
            }
            if (enabledFlag2) {
            } else {
            }
            this.executeAction(0.0F);
            StackShaderComponent2.executeAction(context.method_51448(), (factorValue3 + 5.0F), (((factorValue4 + 52.0F) + factor) + factorValue5), 110.0F, 12.0F, 3.0F, 2.0F, 0.4F, 1.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, (0.5F + (easingServiceComponent.getNumericValue() / 5.0F))), Color.RED, 0.0F, 0.0F, 0.0F);
            SFMServiceComponent.resolveFontRenderHelper3().render(context, KeyServiceComponent.INSTANCE.resolveString("hub.theme-editor.delete", new Object[0]), ((factorValue3 + 5.0F) + 55.0F), (((factorValue4 + 57.0F) + factor) + factorValue5), NewThemeRenderHelper.INSTANCE.getColor7());
            factor = (factor + 16.0F);
            PolygonShaderComponent.INSTANCE.render(context);
            if (factor != 0.0F) {
                factorValue5 = Math.clamp(factorValue5, (factor + 206), 0.0F);
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
        float factor = (factorValue3 + 5.0F);
        float factor2 = (factorValue3 + 20.0F);
        double offset = mouseX;
        if (factor <= offset) {
        } else {
            if (offset <= factor2) {
                factor = (factorValue4 + 6.0F);
                factor2 = (factorValue4 + 21.0F);
                offset = mouseY;
                if (factor <= offset) {
                } else {
                    if (offset <= factor2) {
                        factor = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().getFile();
                        factor2 = factor;
                        class_158 class158 = class_156.method_668();
                        offset = 0;
                        if (!(factor2.exists())) {
                            factor2.createNewFile();
                        }
                        class158.method_672(factor);
                    }
                }
            }
        }
        factor = ((factorValue3 + factorValue) - 21.0F);
        if (mouseX <= ((factorValue3 + factorValue) - 7.0F)) {
        } else {
            if (factor <= mouseX) {
                factor = (factorValue4 + 31.0F);
                if (mouseY <= (factorValue4 + 45.0F)) {
                } else {
                }
                if (factor <= mouseY && enabledFlag && idRecord62 == null) {
                    this.updateValue();
                    return;
                }
            }
        }
        factor = (factorValue3 + 4.0F);
        if (mouseX <= (((factorValue3 + 4.0F) + factorValue) - 8.0F)) {
        } else {
            if (factor <= mouseX) {
                factor = (factorValue4 + 28.0F);
                if (mouseY <= (factorValue4 + 48.0F)) {
                } else {
                    if (factor <= mouseY) {
                        factor = idRecord62;
                        if (factor != null) {
                            offset = factor;
                            int index = 0;
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
            }
        }
        factor = ((Iterable) itemList);
        factor2 = 0;
        offset = factor.iterator();
        while (offset.hasNext()) {
            index = offset.next();
            ThemeRenderHelper themeRenderHelper = ((ThemeRenderHelper) index);
            int index2 = 0;
            themeRenderHelper.executeAction(mouseX, mouseY, button);
        }
        if (!(button)) {
            if (idRecord6 != null) {
                offset = idRecord6;
                index = 0;
                NewThemeRenderHelper.INSTANCE.executeAction(offset);
            } else {
                if (idRecord6 != null) {
                    offset = idRecord6;
                    index = 0;
                    itemList.clear();
                    idRecord62 = idRecord6;
                    themeRenderHelper = 0;
                    index2 = NewThemeRenderHelper.INSTANCE.resolveMap(idRecord62);
                    Iterator iterator = index2.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Entry entry = ((Entry) iterator.next());
                        itemList.add(new ThemeRenderHelper(((String) entry.getKey()), idRecord62, (factorValue3 + 4.0F), ((factorValue4 + 55.0F) + (themeRenderHelper * 16.0F)), ((Color) entry.getValue())));
                        themeRenderHelper = (themeRenderHelper + 1);
                    }
                } else {
                }
            }
        } else {
        }
    }

    public void executeAction(double mouseX, double mouseY) {
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ThemeRenderHelper themeRenderHelper = ((ThemeRenderHelper) element);
            themeRenderHelper.executeAction();
            if (__UNDEF_KEY__ < 0) {
            }
        }
    }

    public void executeAction(int keyCode) {
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ThemeRenderHelper themeRenderHelper = ((ThemeRenderHelper) element);
            themeRenderHelper.executeAction(keyCode);
        }
        textValue = StringsKt.dropLast(textValue, 1);
        this.updateValue();
        enabledFlag = 0;
        textValue = "Enter name";
    }

    private void updateValue(long arg0) {
        if (StringsKt.isBlank(((CharSequence) textValue))) {
            enabledFlag = 0;
            textValue = "Enter name";
            return;
        }
        NewThemeRenderHelper newThemeRenderHelper = NewThemeRenderHelper.INSTANCE;
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveList().add(new IdRecord6(textValue, newThemeRenderHelper.getColor2(), newThemeRenderHelper.getColor3(), newThemeRenderHelper.getColor4(), newThemeRenderHelper.getColor5(), newThemeRenderHelper.getColor6(), newThemeRenderHelper.getColor7(), newThemeRenderHelper.getColor8(), newThemeRenderHelper.getColor9(), newThemeRenderHelper.getColor10(), newThemeRenderHelper.getColor11(), newThemeRenderHelper.getColor12(), newThemeRenderHelper.getColor13()));
        enabledFlag = 0;
        textValue = "Enter name";
    }

    public void executeAction(char chr) {
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ThemeRenderHelper themeRenderHelper = ((ThemeRenderHelper) element);
            themeRenderHelper.executeAction(chr);
            if (__UNDEF_KEY__ != null) {
            }
        }
        textValue = (textValue + chr);
    }

    public boolean checkCondition(double mX, double mY, double amount) {
        float factor = factorValue3;
        if (mX <= (factorValue3 + factorValue)) {
        } else {
            if (factor <= mX) {
                factor = factorValue4;
                if (__UNDEF_KEY__ > 0L && __UNDEF_KEY__ != null) {
                    if (mY <= (factorValue4 + factorValue2)) {
                    } else {
                        if (factor <= mY) {
                            factorValue5 = (factorValue5 + (amount * 10.0F));
                            factor = 0.0F;
                            factor = 14.0F;
                            Iterable iterable = ((Iterable) itemList);
                            Iterator iterator = iterable.iterator();
                            while (iterator.hasNext()) {
                                Object element = iterator.next();
                                ThemeRenderHelper themeRenderHelper = ((ThemeRenderHelper) element);
                                factor = (factor + (themeRenderHelper.getNumericValue4() + 2.0F));
                                if (__UNDEF_KEY__ >= 0) {
                                }
                            }
                            if (__UNDEF_KEY__ >= 0) {
                                if (factor == 14.0F) {
                                    return false;
                                }
                                factorValue5 = Math.clamp(factorValue5, (factor + 206), 0.0F);
                            }
                            return true;
                        }
                    }
                }
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
