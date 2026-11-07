package su.catlean.client.services.render;

import net.minecraft.client.gui.DrawContext;
import su.catlean.api.setting.VisibleSettingProperty;

public abstract class SettingRenderHelper16 {

    private final VisibleSettingProperty visibleSettingProperty;
    private float factorValue;
    private float factorValue2;
    private float factorValue3;
    private float factorValue4;
    private static boolean enabledFlag;

    public SettingRenderHelper16(VisibleSettingProperty setting) {
        this.visibleSettingProperty = setting;
        this.factorValue3 = 116.0F;
        this.factorValue4 = 13.0F;
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
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

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public void updateValue3(float value) {
        this.factorValue3 = value;
    }

    public float getNumericValue4() {
        return this.factorValue4;
    }

    public void updateValue4(float value) {
        this.factorValue4 = value;
    }

    public void render(DrawContext arg0, float arg1) {
    }

    public void setValue(double arg0, double arg1) {
    }

    public void setValue(double arg0, double arg1) {
    }

    public void setValue() {
    }

    public void setValue() {
    }

    public boolean checkCondition(double arg0, double arg1, double arg2) {
    }

    public void setValue() {
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
