package su.catlean.client.services.render;

import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import net.minecraft.class_1041;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;

public class TestRenderHelper extends Screen {

    private final float factorValue;
    private final float factorValue2;
    private TpYawSmootherMode tpYawSmootherMode;
    private boolean enabledFlag;
    private boolean enabledFlag2;
    private int countValue;
    private final Color colorValue;
    private final Color colorValue2;
    private final Color colorValue3;
    private final Color colorValue4;
    private final Color colorValue5;
    private final Color colorValue6;
    private final Color colorValue7;
    private long timestampValue2;
    private final List itemList;
    private static final long timestampValue3;

    public TestRenderHelper() {
        super(class_2561.method_30163("test"));
        this.factorValue = 210.0F;
        this.factorValue2 = 8.0F;
        this.tpYawSmootherMode = TpYawSmootherMode.LINEAR;
        this.timestampValue = timestampValue3;
        this.enabledFlag = true;
        this.enabledFlag2 = true;
        this.countValue = 120;
        this.colorValue = new Color(-15724528);
        this.colorValue2 = new Color(-15329770);
        this.colorValue3 = new Color(-1);
        this.colorValue4 = new Color(-5197648);
        this.colorValue5 = new Color(-14013910);
        this.colorValue6 = new Color(-14737633);
        this.colorValue7 = new Color(-13882324);
        this.itemList = CollectionsKt.toList(((Iterable) TpYawSmootherMode.getEnumEntries()));
    }

    public TpYawSmootherMode getTpYawSmootherMode() {
        return this.tpYawSmootherMode;
    }

    public long getNumericValue() {
        return this.timestampValue;
    }

    public void updateValue(long value) {
        this.timestampValue = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public boolean isActive2() {
        return this.enabledFlag2;
    }

    public void updateValue2(boolean value) {
        this.enabledFlag2 = value;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public Color getColor2() {
        return this.colorValue2;
    }

    public Color getColor3() {
        return this.colorValue3;
    }

    public Color getColor4() {
        return this.colorValue4;
    }

    public Color getColor5() {
        return this.colorValue5;
    }

    public Color getColor6() {
        return this.colorValue6;
    }

    public Color getColor7() {
        return this.colorValue7;
    }

    protected void method_57734(DrawContext context) {
    }

    public void method_25420(DrawContext context, float deltaTicks) {
    }

    public void method_25394(DrawContext context, float delta) {
        this.timestampValue2 = SharedKt.getNumericValue();
        if (!(this.enabledFlag)) {
            this.timestampValue2 = Math.min(this.timestampValue2, this.timestampValue);
        }
        int index = SharedKt.getMc().method_22683().method_4486();
        int index2 = SharedKt.getMc().method_22683().method_4502();
        Matrix3x2fStack matrix3x2fStack = context.method_51448();
        Color[] items = new Color[1];
        items[0] = this.colorValue;
        PolygonShaderComponent.INSTANCE.executeAction(matrix3x2fStack, 0.0F, 0.0F, index, index2, items);
        items = new Color[1];
        items[0] = this.colorValue2;
        PolygonShaderComponent.INSTANCE.executeAction(matrix3x2fStack, 0.0F, 0.0F, this.factorValue, index2, items);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "EASING DEBUG", this.factorValue2, this.factorValue2, this.colorValue3);
        items = (this.factorValue2 + 18);
        this.render(SFMServiceComponent.resolveFontRenderHelper(), (context + this.timestampValue + "ms"), this.factorValue2, items, this.colorValue4);
        items = (items + 14);
        SFMServiceComponent.resolveFontRenderHelper().render(context, ("loop: " + this.enabledFlag), this.factorValue2, items, this.colorValue4);
        items = (items + 14);
        SFMServiceComponent.resolveFontRenderHelper().render(context, ("pingPong: " + this.enabledFlag2), this.factorValue2, items, this.colorValue4);
        items = (items + 14);
        SFMServiceComponent.resolveFontRenderHelper().render(context, ("samples: " + this.countValue), this.factorValue2, items, this.colorValue4);
        items = (items + 18);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "Easings:", this.factorValue2, items, this.colorValue3);
        items = (items + 14);
        float factor = 14.0F;
        Iterator iterator = ((Iterable) this.itemList).iterator();
        int index3 = 0;
        while (iterator.hasNext()) {
            int index4 = index3;
            index3 = (index3 + 1);
            TpYawSmootherMode tpYawSmootherMode = ((TpYawSmootherMode) iterator.next());
            Color[] items2 = (items + (index4 * factor));
            if ((items2 + factor) <= (index2 - this.factorValue2)) {
                Color[] items3 = new Color[1];
                items3[0] = this.colorValue5;
                PolygonShaderComponent.INSTANCE.executeAction(matrix3x2fStack, 2.0F, (items2 - 1.0F), (this.factorValue - 4.0F), factor, items3);
                Color color = this.colorValue4;
                Color color2 = this.colorValue3;
                context.render(tpYawSmootherMode.name(), this.factorValue2, items2, color2, color);
            }
        }
        iterator = (this.factorValue + this.factorValue2);
        index3 = ((index - iterator) - this.factorValue2);
        index4 = ((index2 - this.factorValue2) - this.factorValue2);
        tpYawSmootherMode = (index4 * 0.62F);
        int index5 = ((index4 - tpYawSmootherMode) - this.factorValue2);
        this.render(context, iterator, this.factorValue2, index3, tpYawSmootherMode);
        this.render(context, iterator, ((this.factorValue2 + tpYawSmootherMode) + this.factorValue2), index3, index5);
    }

    private void render(DrawContext arg0, float arg1, float arg2, float arg3, float arg4) {
        Matrix3x2fStack matrix3x2fStack = arg0.method_51448();
        Color[] items = new Color[1];
        items[0] = new Color(-15461356);
        PolygonShaderComponent.INSTANCE.executeAction(matrix3x2fStack, arg1, arg2, arg3, arg4, items);
        items = new Color[1];
        items[0] = this.colorValue7;
        PolygonShaderComponent.INSTANCE.executeAction(matrix3x2fStack, arg1, arg2, arg3, 1.0F, items);
        items = new Color[1];
        items[0] = this.colorValue7;
        PolygonShaderComponent.INSTANCE.executeAction(matrix3x2fStack, arg1, ((arg2 + arg4) - 1.0F), arg3, 1.0F, items);
        items = new Color[1];
        items[0] = this.colorValue7;
        PolygonShaderComponent.INSTANCE.executeAction(matrix3x2fStack, arg1, arg2, 1.0F, arg4, items);
        items = new Color[1];
        items[0] = this.colorValue7;
        PolygonShaderComponent.INSTANCE.executeAction(matrix3x2fStack, ((arg1 + arg3) - 1.0F), arg2, 1.0F, arg4, items);
        SFMServiceComponent.resolveFontRenderHelper().render(arg0, ("Curve: " + this.tpYawSmootherMode.name()), (arg1 + this.factorValue2), (arg2 + this.factorValue2), this.colorValue3);
        items = (arg1 + this.factorValue2);
        float factor = ((arg2 + this.factorValue2) + 16);
        float factor2 = (arg3 - (this.factorValue2 * 2));
        float factor3 = (arg4 - ((this.factorValue2 * 2) + 16));
        int index = 0;
        if (index < 11) {
            Color[] items2 = (items + (factor2 * (index / 10.0F)));
            float factor4 = (factor + (factor3 * (index / 10.0F)));
            PolygonShaderComponent.executeAction(matrix3x2fStack, items2, factor, items2, (factor + factor3), this.colorValue6);
            PolygonShaderComponent.executeAction(matrix3x2fStack, items, factor4, (items + factor2), factor4, this.colorValue6);
            if (__UNDEF_KEY__ != null) {
                PolygonShaderComponent.executeAction(matrix3x2fStack, items, (factor + factor3), (items + factor2), (factor + factor3), new Color(-12961222));
                PolygonShaderComponent.executeAction(matrix3x2fStack, items, factor, items, (factor + factor3), new Color(-12961222));
                index = Math.max(16, this.countValue);
                items2 = items;
                factor4 = (factor + factor3);
            }
        }
        int index2 = 0;
        if (__UNDEF_KEY__ != null) {
            if (index2 <= index) {
                int index3 = (index2 / index);
                double offset = this.computeValue(((Number) this.tpYawSmootherMode.getFunction1().invoke(Double.valueOf(index3))));
                Color[] items3 = (items + (index3 * factor2));
                float factor5 = (factor + ((1.0D - offset) * factor3));
                if (index2 > 0) {
                    PolygonShaderComponent.executeAction(matrix3x2fStack, items2, factor4, items3, factor5, new Color(-7613441));
                }
                items2 = items3;
                factor4 = factor5;
                if (__UNDEF_KEY__ != null) {
                    if (index2 != index) {
                    }
                    SFMServiceComponent.resolveFontRenderHelper().render(arg0, "0.0", items, ((factor + factor3) + 2), new Color(-8355712));
                }
            }
        }
        index2 = SFMServiceComponent.resolveFontRenderHelper().computeValue("1.0");
        SFMServiceComponent.resolveFontRenderHelper().render(arg0, "1.0", ((items + factor2) - index2), ((factor + factor3) + 2), new Color(-8355712));
    }

    private void render(DrawContext arg0, float arg1, float arg2, float arg3, float arg4) {
        Matrix3x2fStack matrix3x2fStack = arg0.method_51448();
        Color[] items = new Color[1];
        items[0] = new Color(-15461356);
        PolygonShaderComponent.INSTANCE.executeAction(matrix3x2fStack, arg1, arg2, arg3, arg4, items);
        SFMServiceComponent.resolveFontRenderHelper().render(arg0, "Preview (loop)", (arg1 + this.factorValue2), (arg2 + this.factorValue2), this.colorValue3);
        items = (arg1 + this.factorValue2);
        float factor = (arg2 + (arg4 / 2));
        float factor2 = (arg3 - (this.factorValue2 * 2));
        PolygonShaderComponent.executeAction(matrix3x2fStack, items, factor, (items + factor2), factor, new Color(-12961222));
        if (__UNDEF_KEY__ != null) {
            if (this.timestampValue <= 0L) {
            } else {
            }
        }
        if (!(this.enabledFlag2)) {
        } else {
            if (__UNDEF_KEY__ != null) {
                if (__UNDEF_KEY__ <= 1.0D) {
                } else {
                }
            }
        }
        double offset = this.computeValue(((Number) this.tpYawSmootherMode.getFunction1().invoke(Double.valueOf())));
        Color[] items2 = (items + (offset * factor2));
        Color[] items3 = new Color[1];
        items3[0] = new Color(-11930);
        PolygonShaderComponent.INSTANCE.executeAction(matrix3x2fStack, (items2 - 1.0F), (factor - 1.0F), 2.0F, 2.0F, items3);
        this.render(SFMServiceComponent.resolveFontRenderHelper(), (arg0 + this.resolveString() + "  eased=" + this.resolveString(offset)), (arg1 + this.factorValue2), (((arg2 + arg4) - this.factorValue2) - 12), this.colorValue4);
    }

    public boolean method_25402(class_11909 click, boolean doubled) {
        double offset = click.comp_4798();
        double offset2 = click.comp_4799();
        float factor = (((this.factorValue2 + 18) + 56) + 18);
        int index = 14;
        if (0 <= offset) {
        } else {
        }
        if (offset < this.factorValue && offset2 >= factor) {
            double offset3 = ((offset2 - factor) / index);
            if (0 <= offset3) {
            } else {
                if (offset3 < ((Collection) this.itemList).size()) {
                    this.tpYawSmootherMode = ((TpYawSmootherMode) this.itemList.get(offset3));
                }
            }
        }
        return this.method_25402(click, doubled);
    }

    private double computeValue(double arg0) {
        return arg0;
    }

    private String resolveString(double arg0) {
        return String.valueOf((MathKt.roundToInt((arg0 * 1000.0D)) / 1000.0D));
    }

}
