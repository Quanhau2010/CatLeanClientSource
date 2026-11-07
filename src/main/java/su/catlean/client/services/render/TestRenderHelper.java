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
        this.enabledFlag = 1;
        this.enabledFlag2 = 1;
        this.countValue = 120;
        this.colorValue = new Color(-15724528);
        this.colorValue2 = new Color(-15329770);
        this.colorValue3 = new Color(-1);
        this.colorValue4 = new Color(-5197648);
        this.colorValue5 = new Color(-14013910);
        this.colorValue6 = new Color(-14737633);
        this.colorValue7 = new Color(-13882324);
        this.itemList = CollectionsKt.toList((Iterable) TpYawSmootherMode.getEnumEntries());
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
        int var23 = SharedKt.getMc().method_22683().method_4486();
        int var24 = SharedKt.getMc().method_22683().method_4502();
        Matrix3x2fStack var25 = context.method_51448();
        Color[] var26 = new Color[1];
        var26[0] = this.colorValue;
        PolygonShaderComponent.INSTANCE.executeAction(0.0F, 0.0F);
        var26 = new Color[1];
        var26[0] = this.colorValue2;
        PolygonShaderComponent.INSTANCE.executeAction(0.0F, 0.0F, this.factorValue);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "EASING DEBUG", this.factorValue2, this.factorValue2, this.colorValue3);
        var26 = (this.factorValue2 + 18);
        this.render(SFMServiceComponent.resolveFontRenderHelper(), (context + this.timestampValue + "ms"), this.factorValue2, this.colorValue4);
        var26 = (var26 + 14);
        SFMServiceComponent.resolveFontRenderHelper().render(context, ("loop: " + this.enabledFlag), this.factorValue2, this.colorValue4);
        var26 = (var26 + 14);
        SFMServiceComponent.resolveFontRenderHelper().render(context, ("pingPong: " + this.enabledFlag2), this.factorValue2, this.colorValue4);
        var26 = (var26 + 14);
        SFMServiceComponent.resolveFontRenderHelper().render(context, ("samples: " + this.countValue), this.factorValue2, this.colorValue4);
        var26 = (var26 + 18);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "Easings:", this.factorValue2, this.colorValue3);
        var26 = (var26 + 14);
        float var27 = 14.0F;
        Iterator iterator = (Iterable) this.itemList.iterator();
        int var29 = 0;
        while (iterator.hasNext()) {
            int var30 = var29;
            var29 = (var29 + 1);
            TpYawSmootherMode var31 = (TpYawSmootherMode) iterator.next();
            float var33 = (var26 + (var30 * var27));
            if ((var33 + var27) <= (var24 - this.factorValue2)) {
                Color[] var34 = new Color[1];
                var34[0] = this.colorValue5;
                PolygonShaderComponent.INSTANCE.executeAction(2.0F, (var33 - 1.0F), (this.factorValue - 4.0F));
                Color var19 = this.colorValue4;
                Color var20 = this.colorValue3;
                float var21 = var33;
                context.render(var31.name(), this.factorValue2);
            }
        }
        iterator = (this.factorValue + this.factorValue2);
        var29 = ((var23 - iterator) - this.factorValue2);
        var30 = ((var24 - this.factorValue2) - this.factorValue2);
        var31 = (var30 * 0.62F);
        float var32 = ((var30 - var31) - this.factorValue2);
        this.render(context, iterator, this.factorValue2);
        this.render(context, iterator, ((this.factorValue2 + var31) + this.factorValue2));
    }

    private void render(DrawContext arg0, float arg1, float arg2, float arg3, float arg4) {
        Matrix3x2fStack var20 = arg0.method_51448();
        Color[] var21 = new Color[1];
        var21[0] = new Color(-15461356);
        PolygonShaderComponent.INSTANCE.executeAction(arg1, arg2, arg3, arg4);
        var21 = new Color[1];
        var21[0] = this.colorValue7;
        PolygonShaderComponent.INSTANCE.executeAction(arg1, arg2, arg3, 1.0F);
        var21 = new Color[1];
        var21[0] = this.colorValue7;
        PolygonShaderComponent.INSTANCE.executeAction(arg1, ((arg2 + arg4) - 1.0F), arg3, 1.0F);
        var21 = new Color[1];
        var21[0] = this.colorValue7;
        PolygonShaderComponent.INSTANCE.executeAction(arg1, arg2, 1.0F, arg4);
        var21 = new Color[1];
        var21[0] = this.colorValue7;
        PolygonShaderComponent.INSTANCE.executeAction(((arg1 + arg3) - 1.0F), arg2, 1.0F, arg4);
        SFMServiceComponent.resolveFontRenderHelper().render(arg0, ("Curve: " + this.tpYawSmootherMode.name()), (arg1 + this.factorValue2), (arg2 + this.factorValue2), this.colorValue3);
        var21 = (arg1 + this.factorValue2);
        float var22 = ((arg2 + this.factorValue2) + 16);
        float var23 = (arg3 - (this.factorValue2 * 2));
        float var24 = (arg4 - ((this.factorValue2 * 2) + 16));
        int var25 = 0;
        if (var25 < 11) {
            float var26 = (var21 + (var23 * (var25 / 10.0F)));
            float var27 = (var22 + (var24 * (var25 / 10.0F)));
            PolygonShaderComponent.executeAction((var22 + var24), this.colorValue6);
            PolygonShaderComponent.executeAction((var21 + var23), this.colorValue6);
            if (var19 != null) {
            }
            PolygonShaderComponent.executeAction((var22 + var24), (var21 + var23), (var22 + var24), new Color(-12961222));
            PolygonShaderComponent.executeAction((var22 + var24), new Color(-12961222));
            var25 = Math.max(16, this.countValue);
            var26 = var21;
            var27 = (var22 + var24);
        }
        int var28 = 0;
        if (var19 != null) {
            if (var28 <= var25) {
                int var29 = (var28 / var25);
                double var31 = this.computeValue((Number) this.tpYawSmootherMode.getFunction1().invoke(Double.valueOf()));
                float var33 = (var21 + (var29 * var23));
                float var34 = (var22 + ((1.0D - var31) * var24));
                if (var28 > 0) {
                    PolygonShaderComponent.executeAction(new Color(-7613441));
                }
                var26 = var33;
                var27 = var34;
                if (var19 != null) {
                    if (var28 != var25) {
                    }
                }
                SFMServiceComponent.resolveFontRenderHelper().render(arg0, "0.0", ((var22 + var24) + 2), new Color(-8355712));
            }
        }
        var28 = SFMServiceComponent.resolveFontRenderHelper().computeValue("1.0");
        SFMServiceComponent.resolveFontRenderHelper().render(arg0, "1.0", ((var21 + var23) - var28), ((var22 + var24) + 2), new Color(-8355712));
    }

    private void render(DrawContext arg0, float arg1, float arg2, float arg3, float arg4) {
        Matrix3x2fStack var18 = arg0.method_51448();
        Color[] var19 = new Color[1];
        var19[0] = new Color(-15461356);
        PolygonShaderComponent.INSTANCE.executeAction(arg1, arg2, arg3, arg4);
        SFMServiceComponent.resolveFontRenderHelper().render(arg0, "Preview (loop)", (arg1 + this.factorValue2), (arg2 + this.factorValue2), this.colorValue3);
        var19 = (arg1 + this.factorValue2);
        float var20 = (arg2 + (arg4 / 2));
        float var21 = (arg3 - (this.factorValue2 * 2));
        PolygonShaderComponent.executeAction((var19 + var21), new Color(-12961222));
        if (var17 != null) {
            if (this.timestampValue <= 0L) {
            } else {
            }
        }
        if (!(this.enabledFlag2)) {
        } else {
            double var26 = (var22 * 2.0D);
            if (var17 != null) {
                if (var26 <= 1.0D) {
                } else {
                }
            }
        }
        double var24 = (2.0D - var26);
        var26 = this.computeValue((Number) this.tpYawSmootherMode.getFunction1().invoke(Double.valueOf()));
        float var28 = (var19 + (var26 * var21));
        Color[] var29 = new Color[1];
        var29[0] = new Color(-11930);
        PolygonShaderComponent.INSTANCE.executeAction((var28 - 1.0F), (var20 - 1.0F), 2.0F, 2.0F);
        var26.render(SFMServiceComponent.resolveFontRenderHelper(), (arg0 + this.resolveString() + "  eased=" + this.resolveString()), (arg1 + this.factorValue2), (((arg2 + arg4) - this.factorValue2) - 12), this.colorValue4);
    }

    public boolean method_25402(class_11909 click, boolean doubled) {
        double var6 = click.comp_4798();
        double var7 = click.comp_4799();
        float var8 = (((this.factorValue2 + 18) + 56) + 18);
        int var9 = 14;
        if (0 <= var6) {
        } else {
        }
        if (var6 < this.factorValue && var7 >= var8) {
            int var10 = ((var7 - var8) / var9);
            if (0 <= var10) {
            } else {
            }
            if (var10 < (Collection) this.itemList.size()) {
                this.tpYawSmootherMode = (TpYawSmootherMode) this.itemList.get();
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
