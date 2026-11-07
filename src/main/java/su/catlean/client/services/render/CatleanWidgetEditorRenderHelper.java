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
        int var28 = SharedKt.getMc().method_22683().method_4486();
        int var29 = SharedKt.getMc().method_22683().method_4502();
        if (enabledFlag3) {
            factorValue3 = (mouseX - factorValue);
            factorValue4 = (mouseY - factorValue2);
        }
        float var30 = (factorValue3 - 4.0F);
        float var31 = ((factorValue3 - 4.0F) + 100.0F);
        int var32 = mouseX;
        if (var30 <= var32) {
        } else {
        }
        if (var32 <= var31) {
            var30 = (factorValue4 - 8.0F);
            var31 = (factorValue4 - 5.0F);
            var32 = mouseY;
            if (var30 <= var32) {
            } else {
            }
        } else {
        }
        enabledFlag2 = var32 <= var31;
        if (enabledFlag2) {
        } else {
        }
        1.0F.executeAction(0.0F);
        if (factorValue3 == -1.0F && factorValue4 == -1.0F) {
            factorValue3 = ((var28 / 2.0F) - 58);
            factorValue4 = 50.0F;
        }
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), 5.0F, 5.0F, (var28 - 10.0F), (var29 - 10.0F), Color.WHITE);
        if (Math.abs((mouseX - factorValue5)) > 1.0F && Math.abs((mouseY - factorValue6)) > 1.0F && enabledFlag && POSITIONCOLORRenderHelper.INSTANCE.getCheckRenderHelper() == null && !(enabledFlag3)) {
            var30 = Math.min(factorValue5, mouseX);
            var31 = Math.min(factorValue6, mouseY);
            var32 = Math.abs((factorValue5 - mouseX));
            float var33 = Math.abs((factorValue6 - mouseY));
            PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), Color.WHITE);
        }
        StackShaderComponent2.executeAction(context.method_51448(), (factorValue3 - 4.0F), (factorValue4 - 14.0F), 116.0F, ((arrayList.size() * 15.0F) + 15.0F), 7.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        var30 = PolygonShaderComponent.INSTANCE.resolveColor(new Color(1157627903, 1), PolygonShaderComponent.INSTANCE.resolveColor(Color.white, 0.5F), easingServiceComponent.getNumericValue());
        ColorValue1RenderHelper.executeAction((factorValue3 + 4.0F), (factorValue4 - 8.0F), 100.0F, 3.0F, 1.5F, context.method_51448(), 0.0F);
        var31 = 0.0F;
        var32 = (Iterable) arrayList;
        var33 = 0;
        Iterator iterator = var32.iterator();
        while (iterator.hasNext()) {
            Object var35 = iterator.next();
            WidgetRenderHelper var36 = (WidgetRenderHelper) var35;
            int var37 = 0;
            var36.render(context, mouseX, mouseY, factorValue3, (factorValue4 + var31));
            var31 = (var31 + 15.0F);
        }
        BackRenderHelper.INSTANCE.render(context, mouseX, mouseY);
    }

    public boolean method_25402(class_11909 click, boolean doubled) {
        double var10 = click.comp_4798();
        double var12 = click.comp_4799();
        int var14 = click.method_74245();
        BackRenderHelper.INSTANCE.checkCondition();
        enabledFlag = 1;
        factorValue5 = var10;
        factorValue6 = var12;
        enabledFlag3 = enabledFlag2;
        factorValue = (var10 - factorValue3);
        factorValue2 = (var12 - factorValue4);
        Iterable var15 = (Iterable) arrayList;
        int var16 = 0;
        Iterator iterator = var15.iterator();
        while (iterator.hasNext()) {
            Object var18 = iterator.next();
            WidgetRenderHelper var19 = (WidgetRenderHelper) var18;
            int var20 = 0;
            var19.executeAction();
        }
        if (this.method_25402(click, doubled) != null) {
        }
        return null;
    }

    public boolean method_25406(class_11909 click) {
        double var6 = click.comp_4798();
        double var8 = click.comp_4799();
        int var10 = click.method_74245();
        enabledFlag = 0;
        enabledFlag3 = 0;
        BackRenderHelper.INSTANCE.executeAction();
        return this.method_25406(click);
    }

    public boolean method_25400(class_11905 input) {
        if (var6 != null) {
            if (ArraysKt.firstOrNull(input.method_74226().toCharArray()) != null) {
            } else {
                ArraysKt.firstOrNull(input.method_74226().toCharArray()).charValue();
            }
            return this.method_25400(input);
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
        Iterable var36 = (Iterable) POSITIONCOLORRenderHelper.INSTANCE.getList();
        int var37 = 0;
        Iterator iterator = var36.iterator();
        if (iterator.hasNext()) {
            Object var39 = iterator.next();
            CheckRenderHelper var40 = (CheckRenderHelper) var39;
            int var41 = 0;
            arrayList.add(new WidgetRenderHelper());
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
