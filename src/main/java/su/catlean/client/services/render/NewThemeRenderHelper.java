package su.catlean.client.services.render;

import java.awt.Color;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.CatLeanServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl;
import su.catlean.client.services.client.JsonServiceComponent4;
import su.catlean.client.services.client.config.models.IdRecord6;
import su.catlean.client.services.client.config.models.ModulesConfigRecord;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class NewThemeRenderHelper {

    public static final NewThemeRenderHelper INSTANCE;
    private static IdRecord6 idRecord6;
    private static final EasingServiceComponent easingServiceComponent;
    private static Color colorValue;
    private static Color colorValue2;
    private static Color colorValue3;
    private static Color colorValue4;
    private static Color colorValue5;
    private static Color colorValue6;
    private static Color colorValue7;
    private static Color colorValue8;
    private static Color colorValue9;
    private static Color colorValue10;
    private static Color colorValue11;
    private static Color colorValue12;
    private static Color colorValue13;
    private static boolean enabledFlag;

    private NewThemeRenderHelper() {
    }

    public Color getColor() {
        return colorValue;
    }

    public void executeAction(Color value) {
        colorValue = value;
    }

    public Color getColor2() {
        return colorValue2;
    }

    public void executeAction2(Color value) {
        colorValue2 = value;
    }

    public Color getColor3() {
        return colorValue3;
    }

    public void executeAction(Color value) {
        colorValue3 = value;
    }

    public Color getColor4() {
        return colorValue4;
    }

    public void executeAction(Color value) {
        colorValue4 = value;
    }

    public Color getColor5() {
        return colorValue5;
    }

    public void executeAction(Color value) {
        colorValue5 = value;
    }

    public Color getColor6() {
        return colorValue6;
    }

    public void executeAction3(Color value) {
        colorValue6 = value;
    }

    public Color getColor7() {
        return colorValue7;
    }

    public void executeAction4(Color value) {
        colorValue7 = value;
    }

    public Color getColor8() {
        return colorValue8;
    }

    public void executeAction5(Color value) {
        colorValue8 = value;
    }

    public Color getColor9() {
        return colorValue9;
    }

    public void executeAction2(Color value) {
        colorValue9 = value;
    }

    public Color getColor10() {
        return colorValue10;
    }

    public void executeAction6(Color value) {
        colorValue10 = value;
    }

    public Color getColor11() {
        return colorValue11;
    }

    public void executeAction3(Color value) {
        colorValue11 = value;
    }

    public Color getColor12() {
        return colorValue12;
    }

    public void executeAction4(Color value) {
        colorValue12 = value;
    }

    public Color getColor13() {
        return colorValue13;
    }

    public void executeAction5(Color value) {
        colorValue13 = value;
    }

    public void executeAction(IdRecord6 newTheme) {
        idRecord6 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6();
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().executeAction(newTheme);
        ProxyGuiElement.INSTANCE.getJsonServiceComponent4().resolveModulesConfigRecord().executeAction2(newTheme.getString());
        easingServiceComponent.updateValue2(0.0F);
    }

    public void updateValue() {
        easingServiceComponent.executeAction(1.0F);
        IdRecord6 var10 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6();
        float var11 = easingServiceComponent.getNumericValue();
        colorValue2 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor(), var10.getColor());
        colorValue3 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor2(), var10.getColor2());
        colorValue4 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor3(), var10.getColor3());
        colorValue5 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor4(), var10.getColor4());
        colorValue6 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor5(), var10.getColor5());
        colorValue7 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor6(), var10.getColor6());
        colorValue8 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor7(), var10.getColor7());
        colorValue9 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor8(), var10.getColor8());
        colorValue10 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor9(), var10.getColor9());
        colorValue11 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor10(), var10.getColor10());
        colorValue12 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor11(), var10.getColor11());
        colorValue13 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor12(), var10.getColor12());
    }

    public Color resolveColor(int offset) {
        int var7 = 360;
        if (var7 >= 180) {
        } else {
        }
        return PolygonShaderComponent.INSTANCE.resolveColor(colorValue2, colorValue3, (var7 / 360.0F));
    }

    public Map resolveMap(IdRecord6 theme) {
        Object var5 = theme;
        int var6 = 0;
        Pair[] var7 = new Pair[12];
        var7[0] = TuplesKt.to("primary", var5.getColor());
        var7[1] = TuplesKt.to("secondary", var5.getColor2());
        var7[2] = TuplesKt.to("blur", var5.getColor3());
        var7[3] = TuplesKt.to("widget-blur", var5.getColor4());
        var7[4] = TuplesKt.to("outline", var5.getColor5());
        var7[5] = TuplesKt.to("text", var5.getColor6());
        var7[6] = TuplesKt.to("inactive-text", var5.getColor7());
        var7[7] = TuplesKt.to("sliders", var5.getColor8());
        var7[8] = TuplesKt.to("inactive-module", var5.getColor9());
        var7[9] = TuplesKt.to("module", var5.getColor10());
        var7[10] = TuplesKt.to("module-outline", var5.getColor11());
        var7[11] = TuplesKt.to("inactive-module-outline", var5.getColor12());
        if (var4 == null) {
        }
        return MapsKt.mapOf();
    }

    static {
        INSTANCE = new NewThemeRenderHelper();
        idRecord6 = CatLeanServiceComponent.getIdRecord6();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_EXPO);
        colorValue = Color.WHITE;
        colorValue2 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6().getColor();
        colorValue3 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6().getColor2();
        colorValue4 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6().getColor3();
        colorValue5 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6().getColor4();
        colorValue6 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6().getColor5();
        colorValue7 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6().getColor6();
        colorValue8 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6().getColor7();
        colorValue9 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6().getColor8();
        colorValue10 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6().getColor9();
        colorValue11 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6().getColor10();
        colorValue12 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6().getColor11();
        colorValue13 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6().getColor12();
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
