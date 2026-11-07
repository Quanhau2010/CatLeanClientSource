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
        long var4 = (0L ^ 82773164258250L);
        float var7 = Math.clamp(((mouseX - this.getNumericValue()) / (this.getNumericValue3() - 7.0F)), 0.0F, 1.0F);
        float var8 = ((Number) this.resolveClosedFloatingPointRange().getStart() + (((Number) this.resolveClosedFloatingPointRange().getEndInclusive() - (Number) this.resolveClosedFloatingPointRange().getStart()) * var7));
        if ((Number) this.resolveClosedFloatingPointRange().getEndInclusive() > 1.0F) {
        } else {
        }
        float var9 = 100.0F;
        this.getVisibleSettingProperty().updateValue(Float.valueOf((MathKt.roundToInt((var8 * var9)) / var9)));
    }

    public float computeValue(char arg0, long arg1) {
        int var4 = ((arg0 << 48) | ((arg1 << 16) >>> 16));
        long var6 = (var4 ^ 106285934015789L);
        return Math.clamp((((Number) this.getVisibleSettingProperty().getObject2() - (Number) this.resolveClosedFloatingPointRange().getStart()) / ((Number) this.resolveClosedFloatingPointRange().getEndInclusive() - (Number) this.resolveClosedFloatingPointRange().getStart())), 0.0F, 1.0F);
    }

    public Float resolveFloat(String value) {
        return Float.valueOf(Float.parseFloat(value));
    }

    public void setValue() {
        this.updateValue(0);
    }

    public Float resolveFloat(float current, int step) {
        return Float.valueOf(new BigDecimal(String.valueOf((step * 0.1D))).add(new BigDecimal(String.valueOf((Number) this.getVisibleSettingProperty().getObject2()))));
    }

    public Number resolveNumber(String value) {
        int var5 = (((0L << 32) | ((0L << 48) >>> 32)) | ((0L << 48) >>> 48));
        long var7 = (var5 ^ 50856965502212L);
        return (Number) this.resolveFloat(value);
    }

    public Number resolveNumber(Number current, int step) {
        return (Number) this.resolveFloat(current, step);
    }

}
