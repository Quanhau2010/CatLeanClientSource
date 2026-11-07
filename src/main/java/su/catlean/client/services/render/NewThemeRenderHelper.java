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
        IdRecord6 idRecord6 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl().resolveIdRecord6();
        float factor = easingServiceComponent.getNumericValue();
        colorValue2 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor(), idRecord6.getColor(), factor);
        colorValue3 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor2(), idRecord6.getColor2(), factor);
        colorValue4 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor3(), idRecord6.getColor3(), factor);
        colorValue5 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor4(), idRecord6.getColor4(), factor);
        colorValue6 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor5(), idRecord6.getColor5(), factor);
        colorValue7 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor6(), idRecord6.getColor6(), factor);
        colorValue8 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor7(), idRecord6.getColor7(), factor);
        colorValue9 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor8(), idRecord6.getColor8(), factor);
        colorValue10 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor9(), idRecord6.getColor9(), factor);
        colorValue11 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor10(), idRecord6.getColor10(), factor);
        colorValue12 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor11(), idRecord6.getColor11(), factor);
        colorValue13 = PolygonShaderComponent.INSTANCE.resolveColor(idRecord6.getColor12(), idRecord6.getColor12(), factor);
    }

    public Color resolveColor(int offset) {
        int index = 360;
        if (index >= 180) {
        } else {
        }
        return PolygonShaderComponent.INSTANCE.resolveColor(colorValue2, colorValue3, (index / 360.0F));
    }

    public Map resolveMap(IdRecord6 theme) {
        Pair[] items = new Pair[12];
        items[0] = TuplesKt.to("primary", theme.getColor());
        items[1] = TuplesKt.to("secondary", theme.getColor2());
        items[2] = TuplesKt.to("blur", theme.getColor3());
        items[3] = TuplesKt.to("widget-blur", theme.getColor4());
        items[4] = TuplesKt.to("outline", theme.getColor5());
        items[5] = TuplesKt.to("text", theme.getColor6());
        items[6] = TuplesKt.to("inactive-text", theme.getColor7());
        items[7] = TuplesKt.to("sliders", theme.getColor8());
        items[8] = TuplesKt.to("inactive-module", theme.getColor9());
        items[9] = TuplesKt.to("module", theme.getColor10());
        items[10] = TuplesKt.to("module-outline", theme.getColor11());
        items[11] = TuplesKt.to("inactive-module-outline", theme.getColor12());
        if (__UNDEF_KEY__ == null) {
        }
        return MapsKt.mapOf(items);
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
