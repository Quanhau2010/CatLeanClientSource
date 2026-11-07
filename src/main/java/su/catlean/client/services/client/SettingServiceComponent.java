package su.catlean.client.services.client;

import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.services.render.SettingRenderHelper6;

public class SettingServiceComponent extends SettingRenderHelper6 {

    public SettingServiceComponent(VisibleSettingProperty setting) {
        super(setting);
    }

    public void setValue(int mouseX) {
        float factor = Math.clamp(((mouseX - this.getNumericValue()) / (this.getNumericValue3() - 7.0F)), 0.0F, 1.0F);
        this.getVisibleSettingProperty().updateValue(Integer.valueOf(MathKt.roundToInt((this.resolveIntRange().getFirst() + ((this.resolveIntRange().getLast() - this.resolveIntRange().getFirst()) * factor)))));
    }

    public float computeValue() {
        return Math.clamp(((((Number) this.getVisibleSettingProperty().getObject2()) - this.resolveIntRange().getFirst()) / (this.resolveIntRange().getLast() - this.resolveIntRange().getFirst())), 0.0F, 1.0F);
    }

    public Integer resolveInteger(String value) {
        return Integer.valueOf(Integer.parseInt(value));
    }

    public Integer resolveInteger(int current, int step) {
        return Integer.valueOf(RangesKt.coerceIn((current + step), this.resolveIntRange().getFirst(), this.resolveIntRange().getLast()));
    }

    public void setValue() {
        this.updateValue(false);
    }

    public Number resolveNumber(String value) {
        return ((Number) this.resolveInteger(value));
    }

    public Number resolveNumber(Number current, int step) {
        return ((Number) this.resolveInteger(current, step));
    }

}
