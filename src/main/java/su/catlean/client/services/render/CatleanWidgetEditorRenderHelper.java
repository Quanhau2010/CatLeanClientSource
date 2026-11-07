package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import net.minecraft.class_1041;
import net.minecraft.class_11905;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class CatleanWidgetEditorRenderHelper extends Screen {

    public static final CatleanWidgetEditorRenderHelper INSTANCE;
    private static final EasingServiceComponent easingServiceComponent;
    private static float factorValue;
    private static float factorValue2;
    private static float factorValue3;
    private static float factorValue4;
    private static boolean enabledFlag;
    private static float factorValue5;
    private static float factorValue6;
    private static boolean enabledFlag2;
    private static boolean enabledFlag3;
    private static ArrayList arrayList;
    private static boolean enabledFlag4;

    private CatleanWidgetEditorRenderHelper() {
        super(class_2561.method_30163("catlean-widget-editor"));
    }

    public void method_25394(DrawContext context, int mouseX, int mouseY, float delta) {
        if (SharedKt.getMc().world == null) {
            CatleanInterfaceRenderHelper.INSTANCE.method_25420(context, mouseX, mouseY, delta);
        }
        this.method_25394(context, mouseX, mouseY, delta);
        int index = SharedKt.getMc().method_22683().method_4486();
        int index2 = SharedKt.getMc().method_22683().method_4502();
        if (enabledFlag3) {
            factorValue3 = (mouseX - factorValue);
            factorValue4 = (mouseY - factorValue2);
        }
        float factor = (factorValue3 - 4.0F);
        float factor2 = ((factorValue3 - 4.0F) + 100.0F);
        int index3 = mouseX;
        if (factor <= index3) {
        } else {
            if (index3 <= factor2) {
                factor = (factorValue4 - 8.0F);
                factor2 = (factorValue4 - 5.0F);
                index3 = mouseY;
                if (factor <= index3) {
                } else {
                }
            } else {
                enabledFlag2 = index3 <= factor2;
            }
        }
        if (enabledFlag2) {
        } else {
        }
        this.executeAction(0.0F);
        if (factorValue3 == -1.0F && factorValue4 == -1.0F) {
            factorValue3 = ((index / 2.0F) - 58);
            factorValue4 = 50.0F;
        }
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), 5.0F, 5.0F, (index - 10.0F), (index2 - 10.0F), Color.WHITE);
        if (Math.abs((mouseX - factorValue5)) > 1.0F && Math.abs((mouseY - factorValue6)) > 1.0F && enabledFlag && POSITIONCOLORRenderHelper.INSTANCE.getCheckRenderHelper() == null && !(enabledFlag3)) {
            factor = Math.min(factorValue5, mouseX);
            factor2 = Math.min(factorValue6, mouseY);
            index3 = Math.abs((factorValue5 - mouseX));
            float factor3 = Math.abs((factorValue6 - mouseY));
            PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), factor, factor2, index3, factor3, Color.WHITE);
        }
        StackShaderComponent2.executeAction(context.method_51448(), (factorValue3 - 4.0F), (factorValue4 - 14.0F), 116.0F, ((arrayList.size() * 15.0F) + 15.0F), 7.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        factor = PolygonShaderComponent.INSTANCE.resolveColor(new Color(1157627903, true), PolygonShaderComponent.INSTANCE.resolveColor(Color.white, 0.5F), easingServiceComponent.getNumericValue());
        ColorValue1RenderHelper.executeAction((factorValue3 + 4.0F), (factorValue4 - 8.0F), 100.0F, 3.0F, 1.5F, factor, factor, factor, factor, context.method_51448(), 0.0F);
        factor2 = 0.0F;
        index3 = ((Iterable) arrayList);
        factor3 = 0;
        Iterator iterator = index3.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            WidgetRenderHelper widgetRenderHelper = ((WidgetRenderHelper) element);
            widgetRenderHelper.render(context, mouseX, mouseY, factorValue3, (factorValue4 + factor2));
            factor2 = (factor2 + 15.0F);
        }
        BackRenderHelper.INSTANCE.render(context, mouseX, mouseY);
    }

    public boolean method_25402(class_11909 click, boolean doubled) {
        double offset = click.comp_4798();
        double offset2 = click.comp_4799();
        int index = click.method_74245();
        BackRenderHelper.INSTANCE.checkCondition(offset, offset2, index);
        enabledFlag = 1;
        factorValue5 = offset;
        factorValue6 = offset2;
        enabledFlag3 = enabledFlag2;
        factorValue = (offset - factorValue3);
        factorValue2 = (offset2 - factorValue4);
        Iterable iterable = ((Iterable) arrayList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            WidgetRenderHelper widgetRenderHelper = ((WidgetRenderHelper) element);
            widgetRenderHelper.executeAction(offset, offset2);
        }
        if (this.method_25402(click, doubled) != null) {
        }
        return null;
    }

    public boolean method_25406(class_11909 click) {
        double offset = click.comp_4798();
        double offset2 = click.comp_4799();
        int index = click.method_74245();
        enabledFlag = 0;
        enabledFlag3 = 0;
        BackRenderHelper.INSTANCE.executeAction(offset, offset2, index);
        return this.method_25406(click);
    }

    public boolean method_25400(class_11905 input) {
        if (__UNDEF_KEY__ != null) {
            if (ArraysKt.firstOrNull(input.method_74226().toCharArray()) != null) {
            } else {
                ArraysKt.firstOrNull(input.method_74226().toCharArray()).charValue();
                return this.method_25400(input);
            }
        }
        BackRenderHelper.INSTANCE.executeAction();
        return this.method_25400(input);
    }

    public boolean method_25421() {
        return false;
    }

    protected void method_57734(DrawContext context) {
    }

    public void method_25420(DrawContext context, float deltaTicks) {
    }

    static {
        INSTANCE = new CatleanWidgetEditorRenderHelper();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        factorValue3 = -1.0F;
        factorValue4 = -1.0F;
        factorValue5 = -1.0F;
        factorValue6 = -1.0F;
        arrayList = new ArrayList();
        Iterable iterable = ((Iterable) POSITIONCOLORRenderHelper.INSTANCE.getList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CheckRenderHelper checkRenderHelper = ((CheckRenderHelper) element);
            arrayList.add(new WidgetRenderHelper(checkRenderHelper));
        }
    }

    public static void updateValue(boolean arg0) {
        enabledFlag4 = arg0;
    }

    public static boolean isActive() {
        return enabledFlag4;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
