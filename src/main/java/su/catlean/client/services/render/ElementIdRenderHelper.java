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
import kotlin.jvm.internal.DefaultConstructorMarker;
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
        if (var14 != null) {
            if (this.optionMode7 == OptionMode7.Config) {
                ActionServiceComponent3[] var15 = new ActionServiceComponent3[3];
                var15[0] = new ActionServiceComponent3(KeyServiceComponent.INSTANCE.resolveString("windows.config.load", new Object[0]), this::resolveUnit);
                var15[1] = new ActionServiceComponent3(KeyServiceComponent.INSTANCE.resolveString("windows.config.open-in-explorer", new Object[0]), this::resolveUnit2);
                var15[2] = new ActionServiceComponent3(KeyServiceComponent.INSTANCE.resolveString("windows.config.delete", new Object[0]), this::resolveUnit3);
            } else {
            }
        }
        this.itemList.add(new ActionServiceComponent3(KeyServiceComponent.INSTANCE.resolveString("windows.config.save", new Object[0]), this::resolveUnit4));
    }

    public ElementIdRenderHelper(OptionMode7 arg0, float arg1, float arg2, String arg3, OptionMode8 arg4, int arg5, DefaultConstructorMarker arg6) {
        if ((arg5 & 2)) {
            arg1 = 0.0F;
        }
        if ((arg5 & 4)) {
            arg2 = 0.0F;
        }
        if ((arg5 & 8)) {
            arg3 = "";
        }
        if ((arg5 & 16)) {
            arg4 = OptionMode8.MODULES;
        }
        this(arg0, arg1, arg2, arg3, arg4);
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
        int var20 = ((this.itemList.size() * 14.0F) + 2.0F);
        StackShaderComponent2.executeAction(context.method_51448(), this.factorValue, this.factorValue2, this.factorValue3, 4.0F, 1.0F, 0.07F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5().darker(), NewThemeRenderHelper.INSTANCE.getColor6().darker(), 0.0F, 0.0F, 0.0F);
        int var21 = 0;
        Iterable var22 = (Iterable) this.itemList;
        int var23 = 0;
        Iterator iterator = var22.iterator();
        while (iterator.hasNext()) {
            Object var25 = iterator.next();
            ActionServiceComponent3 var26 = (ActionServiceComponent3) var25;
            int var27 = 0;
            float var28 = this.factorValue;
            float var29 = (this.factorValue + this.factorValue3);
            int var30 = mouseX;
            if (0L >= 0 && var19 != null) {
                if (var28 <= var30) {
                }
            } else {
            }
            if (var30 <= var29) {
                var28 = ((this.factorValue2 + 2) + (var21 * 14));
                var29 = ((this.factorValue2 + 14) + (var21 * 14));
                var30 = mouseY;
                if (0L > 0 && var19 != null) {
                    if (var28 <= var30) {
                    }
                } else {
                }
                if (var30 <= var29) {
                    StackShaderComponent2.executeAction(context.method_51448(), (this.factorValue + 2), ((this.factorValue2 + 2) + (var21 * 14)), (this.factorValue3 - 4), 12.0F, 2.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
                }
            }
            if (0L > 0) {
            }
            if (var21 == (this.itemList.size() - 1) && this.itemList.size() > 1) {
            } else {
            }
            var28 = Color.WHITE;
            Object var16 = var28;
            Color var17 = new Color(255, 0, 0, 170);
            float var18 = ((this.factorValue2 + 2) + (var21 * 14));
            context.render(var26.getString(), (this.factorValue + 5));
            var21 = (var21 + 1);
        }
    }

    public void executeAction(float mX, float mY) {
        int var10 = 0;
        Iterable var11 = (Iterable) this.itemList;
        int var12 = 0;
        Iterator iterator = var11.iterator();
        if (iterator.hasNext()) {
            Object var14 = iterator.next();
            ActionServiceComponent3 var15 = (ActionServiceComponent3) var14;
            int var16 = 0;
            float var17 = this.factorValue;
            if (0L >= 0) {
                if (var9 != null) {
                    if (mX <= (this.factorValue + this.factorValue3)) {
                    }
                }
                if (var9 != null) {
                }
            } else {
            }
            if (var17 <= mX) {
                var17 = ((this.factorValue2 + 2) + (var10 * 14));
                if (0L >= 0) {
                    if (var9 != null) {
                        if (mY <= ((this.factorValue2 + 14) + (var10 * 14))) {
                        }
                    }
                    if (var9 != null) {
                    }
                } else {
                }
                if (0L > 0) {
                    if (var17 <= mY) {
                        var15.getFunction1().invoke(this.textValue);
                    }
                }
            }
            var10 = (var10 + 1);
        }
    }

    private static Unit resolveUnit(ElementIdRenderHelper arg0, String arg1) {
        if (!(StringsKt.isBlank((CharSequence) arg0.textValue))) {
            DefaultServiceComponent.executeAction(arg0.textValue, arg0.optionMode8);
        }
        StartupServiceComponent.INSTANCE.getVecServiceComponent15().updateValue();
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(ElementIdRenderHelper arg0, String arg1) {
        if (!(StringsKt.isBlank((CharSequence) arg0.textValue))) {
            if (arg0.optionMode8 == OptionMode8.MODULES) {
                File var5 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().getFile();
                Object var6 = var5;
                class_158 var8 = class_156.method_668();
                int var7 = 0;
                if (!(var6.exists())) {
                    var6.createNewFile();
                }
                var8.method_672();
            } else {
                var5 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().getFile();
                var6 = var5;
                var8 = class_156.method_668();
                var7 = 0;
                if (!(var6.exists())) {
                    var6.createNewFile();
                }
                var8.method_672();
            }
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit3(ElementIdRenderHelper arg0, String arg1) {
        if (!(StringsKt.isBlank((CharSequence) arg0.textValue))) {
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
