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
        long var4 = ((0L ^ 13989052645633L) >>> 32);
        long var5 = (((0L ^ 13989052645633L) << 32) >>> 48);
        long var6 = (((0L ^ 13989052645633L) << 48) >>> 48);
        float var8 = Math.clamp(((mouseX - this.getNumericValue()) / (this.getNumericValue3() - 7.0F)), 0.0F, 1.0F);
        this.getVisibleSettingProperty().updateValue(Integer.valueOf(MathKt.roundToInt((this.resolveIntRange().getFirst() + ((this.resolveIntRange().getLast() - this.resolveIntRange().getFirst()) * var8)))));
    }

    public float computeValue(char arg0, long arg1) {
        int var4 = ((arg0 << 48) | ((arg1 << 16) >>> 16));
        long var6 = ((var4 ^ 43274661890022L) >>> 32);
        long var7 = (((var4 ^ 43274661890022L) << 32) >>> 48);
        long var8 = (((var4 ^ 43274661890022L) << 48) >>> 48);
        return Math.clamp((((Number) this.getVisibleSettingProperty().getObject2() - this.resolveIntRange().getFirst()) / (this.resolveIntRange().getLast() - this.resolveIntRange().getFirst())), 0.0F, 1.0F);
    }

    public Integer resolveInteger(String value) {
        return Integer.valueOf(Integer.parseInt(value));
    }

    public Integer resolveInteger(int current, int step) {
        return Integer.valueOf(RangesKt.coerceIn((current + step), this.resolveIntRange().getFirst(), this.resolveIntRange().getLast()));
    }

    public void setValue() {
        this.updateValue(0);
    }

    public Number resolveNumber(String value) {
        int var5 = (((0L << 32) | ((0L << 48) >>> 32)) | ((0L << 48) >>> 48));
        long var7 = (var5 ^ 29274642336829L);
        return (Number) this.resolveInteger(value);
    }

    public Number resolveNumber(Number current, int step) {
        int var6 = (((0L << 32) | ((0L << 48) >>> 32)) | ((0L << 48) >>> 48));
        long var8 = (var6 ^ 74496559134582L);
        return (Number) this.resolveInteger(current, step);
    }

}
