package su.catlean.client.services.render;

import java.math.BigDecimal;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import su.catlean.api.setting.VisibleSettingProperty;

public class SettingSettingRenderHelper6Impl extends SettingRenderHelper6 {

    public SettingSettingRenderHelper6Impl(VisibleSettingProperty setting) {
        super(setting);
    }

    public void setValue(int mouseX) {
        float factor = Math.clamp(((mouseX - this.getNumericValue()) / (this.getNumericValue3() - 7.0F)), 0.0F, 1.0F);
        float factor2 = (((Number) this.resolveClosedFloatingPointRange().getStart()) + ((((Number) this.resolveClosedFloatingPointRange().getEndInclusive()) - ((Number) this.resolveClosedFloatingPointRange().getStart())) * factor));
        if (((Number) this.resolveClosedFloatingPointRange().getEndInclusive()) > 1.0F) {
        } else {
        }
        float factor3 = 100.0F;
        this.getVisibleSettingProperty().updateValue(Float.valueOf((MathKt.roundToInt((factor2 * factor3)) / factor3)));
    }

    public float computeValue() {
        return Math.clamp(((((Number) this.getVisibleSettingProperty().getObject2()) - ((Number) this.resolveClosedFloatingPointRange().getStart())) / (((Number) this.resolveClosedFloatingPointRange().getEndInclusive()) - ((Number) this.resolveClosedFloatingPointRange().getStart()))), 0.0F, 1.0F);
    }

    public Float resolveFloat(String value) {
        return Float.valueOf(Float.parseFloat(value));
    }

    public void setValue() {
        this.updateValue(false);
    }

    public Float resolveFloat(float current, int step) {
        return Float.valueOf(new BigDecimal(String.valueOf((step * 0.1D))).add(new BigDecimal(String.valueOf(((Number) this.getVisibleSettingProperty().getObject2())))));
    }

    public Number resolveNumber(String value) {
        return ((Number) this.resolveFloat(value));
    }

    public Number resolveNumber(Number current, int step) {
        return ((Number) this.resolveFloat(current, step));
    }

}
