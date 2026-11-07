package su.catlean.client.services.render;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import net.minecraft.class_156;
import net.minecraft.class_156.class_158;
import net.minecraft.client.gui.DrawContext;
import su.catlean.client.services.client.ActionServiceComponent3;
import su.catlean.client.services.client.DefaultServiceComponent;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl2;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl4;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.StartupServiceComponent;
import su.catlean.client.services.client.VecServiceComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.OptionMode7;
import su.catlean.client.types.OptionMode8;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class ElementIdRenderHelper {

    private OptionMode7 optionMode7;
    private float factorValue;
    private float factorValue2;
    private String textValue;
    private OptionMode8 optionMode8;
    private final List itemList;
    private float factorValue3;

    public ElementIdRenderHelper(OptionMode7 type, float x, float y, String elementId, OptionMode8 configType) {
        this.optionMode7 = type;
        this.factorValue = x;
        this.factorValue2 = y;
        this.textValue = elementId;
        this.optionMode8 = configType;
        this.itemList = new ArrayList();
        this.factorValue3 = 62.0F;
        if (__UNDEF_KEY__ != null) {
            if (this.optionMode7 == OptionMode7.Config) {
                ActionServiceComponent3[] items = new ActionServiceComponent3[3];
                items[0] = new ActionServiceComponent3(KeyServiceComponent.INSTANCE.resolveString("windows.config.load", new Object[0]), this::resolveUnit);
                items[1] = new ActionServiceComponent3(KeyServiceComponent.INSTANCE.resolveString("windows.config.open-in-explorer", new Object[0]), this::resolveUnit2);
                items[2] = new ActionServiceComponent3(KeyServiceComponent.INSTANCE.resolveString("windows.config.delete", new Object[0]), this::resolveUnit3);
            } else {
            }
        }
        this.itemList.add(new ActionServiceComponent3(KeyServiceComponent.INSTANCE.resolveString("windows.config.save", new Object[0]), this::resolveUnit4));
    }

    public OptionMode7 getOptionMode7() {
        return this.optionMode7;
    }

    public void executeAction(OptionMode7 value) {
        this.optionMode7 = value;
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

    public OptionMode8 getOptionMode8() {
        return this.optionMode8;
    }

    public void executeAction(OptionMode8 value) {
        this.optionMode8 = value;
    }

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public void updateValue3(float value) {
        this.factorValue3 = value;
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        int index = ((this.itemList.size() * 14.0F) + 2.0F);
        StackShaderComponent2.executeAction(context.method_51448(), this.factorValue, this.factorValue2, this.factorValue3, index, 4.0F, 1.0F, 0.07F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5().darker(), NewThemeRenderHelper.INSTANCE.getColor6().darker(), 0.0F, 0.0F, 0.0F);
        int index2 = 0;
        Iterable iterable = ((Iterable) this.itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ActionServiceComponent3 actionServiceComponent3 = ((ActionServiceComponent3) element);
            float factor = this.factorValue;
            float factor2 = (this.factorValue + this.factorValue3);
            int index3 = mouseX;
            if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ != null) {
                if (factor <= index3) {
                } else {
                    if (index3 <= factor2) {
                        factor = ((this.factorValue2 + 2) + (index2 * 14));
                        factor2 = ((this.factorValue2 + 14) + (index2 * 14));
                        index3 = mouseY;
                        if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__ != null) {
                            if (factor <= index3) {
                            } else {
                                if (index3 <= factor2) {
                                    StackShaderComponent2.executeAction(context.method_51448(), (this.factorValue + 2), ((this.factorValue2 + 2) + (index2 * 14)), (this.factorValue3 - 4), 12.0F, 2.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
                                }
                            }
                        }
                    }
                }
            }
            if (__UNDEF_KEY__ > 0) {
            }
            if (index2 == (this.itemList.size() - 1) && this.itemList.size() > 1) {
            } else {
            }
            factor = Color.WHITE;
            Color color = new Color(255, 0, 0, 170);
            float factor3 = ((this.factorValue2 + 2) + (index2 * 14));
            context.render(actionServiceComponent3.getString(), (this.factorValue + 5), factor3, color, factor);
            index2 = (index2 + 1);
        }
    }

    public void executeAction(float mX, float mY) {
        int index = 0;
        Iterable iterable = ((Iterable) this.itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ActionServiceComponent3 actionServiceComponent3 = ((ActionServiceComponent3) element);
            float factor = this.factorValue;
            if (__UNDEF_KEY__ >= 0) {
                if (__UNDEF_KEY__ != null) {
                    if (mX <= (this.factorValue + this.factorValue3)) {
                        if (__UNDEF_KEY__ != null) {
                        }
                    } else {
                        if (factor <= mX) {
                            factor = ((this.factorValue2 + 2) + (index * 14));
                            if (__UNDEF_KEY__ >= 0) {
                                if (__UNDEF_KEY__ != null) {
                                    if (mY <= ((this.factorValue2 + 14) + (index * 14))) {
                                        if (__UNDEF_KEY__ != null) {
                                        }
                                    } else {
                                    }
                                }
                            }
                            if (__UNDEF_KEY__ > 0) {
                                if (factor <= mY) {
                                    actionServiceComponent3.getFunction1().invoke(this.textValue);
                                }
                            }
                        }
                    }
                }
            }
            index = (index + 1);
        }
    }

    private static Unit resolveUnit(ElementIdRenderHelper arg0, String arg1) {
        if (!(StringsKt.isBlank(((CharSequence) arg0.textValue)))) {
            DefaultServiceComponent.executeAction(arg0.textValue, arg0.optionMode8);
        }
        StartupServiceComponent.INSTANCE.getVecServiceComponent15().updateValue();
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(ElementIdRenderHelper arg0, String arg1) {
        if (!(StringsKt.isBlank(((CharSequence) arg0.textValue)))) {
            if (arg0.optionMode8 == OptionMode8.MODULES) {
                File file = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().getFile();
                File file2 = file;
                class_158 class158 = class_156.method_668();
                if (!(file2.exists())) {
                    file2.createNewFile();
                }
                class158.method_672(file);
            } else {
                file = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().getFile();
                file2 = file;
                class158 = class_156.method_668();
                if (!(file2.exists())) {
                    file2.createNewFile();
                }
                class158.method_672(file);
            }
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit3(ElementIdRenderHelper arg0, String arg1) {
        if (!(StringsKt.isBlank(((CharSequence) arg0.textValue)))) {
            DefaultServiceComponent.executeAction(arg1, arg0.optionMode8);
            ConfigPanelRenderHelper3Impl.INSTANCE.updateValue(null);
            ConfigPanelRenderHelper3Impl.INSTANCE.updateValue();
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit4(ElementIdRenderHelper arg0, String arg1) {
        ConfigPanelRenderHelper3Impl.INSTANCE.updateValue(null);
        ConfigPanelRenderHelper3Impl.INSTANCE.updateValue(new CancelRenderHelper2(arg0.optionMode8));
        return Unit.INSTANCE;
    }

}
