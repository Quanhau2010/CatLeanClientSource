package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KMutableProperty0;
import net.minecraft.class_3532;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;

public class SettingRenderHelper4 {

    private KMutableProperty0 kMutableProperty0;
    private float factorValue;
    private float factorValue2;
    private final int countValue;
    private boolean enabledFlag;
    private String textValue;

    public SettingRenderHelper4(KMutableProperty0 setting, float x, float y, int index) {
        this.kMutableProperty0 = setting;
        this.factorValue = x;
        this.factorValue2 = y;
        this.countValue = index;
        this.textValue = "-";
    }

    public KMutableProperty0 getKMutableProperty0() {
        return this.kMutableProperty0;
    }

    public void setValue(KMutableProperty0 value) {
        this.kMutableProperty0 = value;
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

    public int getNumericValue() {
        return this.countValue;
    }

    public void render(Matrix3x2fStack m, DrawContext context) {
        StackShaderComponent2.executeAction(context.method_51448(), (this.factorValue + 40.0F), ((this.factorValue2 + 10.0F) + (this.countValue * 10.0F)), 15.0F, 8.0F, 2.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor9(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper4().render(context, String.valueOf("RGBA".charAt(this.countValue)), (this.factorValue + 34.0F), ((this.factorValue2 + 13.5F) + (this.countValue * 10.0F)), NewThemeRenderHelper.INSTANCE.getColor7());
        if (this.enabledFlag) {
        } else {
            Integer[] var20 = new Integer[4];
            var20[0] = Integer.valueOf((Color) this.kMutableProperty0.get().getRed());
            var20[1] = Integer.valueOf((Color) this.kMutableProperty0.get().getGreen());
            var20[2] = Integer.valueOf((Color) this.kMutableProperty0.get().getBlue());
            var20[3] = Integer.valueOf((Color) this.kMutableProperty0.get().getAlpha());
        }
        if (this.enabledFlag) {
        } else {
        }
        float var18 = 1.0F;
        this.textValue.render(String.valueOf((Number) CollectionsKt.listOf().get(this.countValue)), (this.factorValue + 47.0F), ((this.factorValue2 + 13.0F) + (this.countValue * 10.0F)), PolygonShaderComponent.INSTANCE, NewThemeRenderHelper.INSTANCE.getColor8().resolveColor((Math.sin((System.currentTimeMillis() / 50.0D)) + 0.5F)));
    }

    public void setValue(int mouseX, int mouseY) {
        float var6 = (this.factorValue + 40.0F);
        float var7 = (this.factorValue + 55.0F);
        int var8 = mouseX;
        if (var6 <= var8) {
        } else {
        }
        var6 = ((this.factorValue2 + 10.0F) + (this.countValue * 10.0F));
        var7 = ((this.factorValue2 + 18.0F) + (this.countValue * 10.0F));
        var8 = mouseY;
        if (var6 <= var8) {
        } else {
        }
        this.enabledFlag = !(this.enabledFlag);
        var6 = new Integer[4];
        var6[0] = Integer.valueOf((Color) this.kMutableProperty0.get().getRed());
        var6[1] = Integer.valueOf((Color) this.kMutableProperty0.get().getGreen());
        var6[2] = Integer.valueOf((Color) this.kMutableProperty0.get().getBlue());
        var6[3] = Integer.valueOf((Color) this.kMutableProperty0.get().getAlpha());
        this.textValue = String.valueOf((Number) CollectionsKt.listOf().get(this.countValue));
    }

    public void setValue(char char) {
        this.textValue = (this.textValue + char);
    }

    public void setValue(int key) {
        if (var4 != null) {
        }
        if (var4 != null) {
            this.enabledFlag = 0;
        }
        int var5 = class_3532.method_15340(Integer.parseInt(this.textValue), 0, 255);
        Color var6 = (Color) this.kMutableProperty0.get();
        if (!(this.countValue)) {
        }
        if (this.countValue == 1) {
        } else {
        }
        if (this.countValue == 2) {
        } else {
        }
        if (this.countValue == 3) {
        } else {
        }
        var6.getGreen().<init>(var6.getBlue(), var6.getAlpha());
        var6.getRed().set();
        if (var4 != null) {
            if ((CharSequence) this.textValue.length() > 0) {
            }
        } else {
        }
        this.textValue = this.textValue.substring(0, (this.textValue.length() - 1));
    }

    public void setValue(double mouseX, double mouseY, double verticalAmount) {
        float var10 = (this.factorValue + 40.0F);
        float var11 = (this.factorValue + 55.0F);
        double var12 = mouseX;
        if (var10 <= var12) {
        } else {
        }
        var10 = ((this.factorValue2 + 10.0F) + (this.countValue * 10.0F));
        var11 = ((this.factorValue2 + 18.0F) + (this.countValue * 10.0F));
        var12 = mouseY;
        if (var10 <= var12) {
        } else {
        }
        var11 = new Integer[4];
        var11[0] = Integer.valueOf((Color) this.kMutableProperty0.get().getRed());
        var11[1] = Integer.valueOf((Color) this.kMutableProperty0.get().getGreen());
        var11[2] = Integer.valueOf((Color) this.kMutableProperty0.get().getBlue());
        var11[3] = Integer.valueOf((Color) this.kMutableProperty0.get().getAlpha());
        var10 = CollectionsKt.listOf();
        var12 = (Iterable) var10;
        int var13 = 0;
        Object var14 = var12;
        Collection var15 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var16 = 0;
        int var17 = 0;
        Iterator iterator = var14.iterator();
        while (iterator.hasNext()) {
            Object var19 = iterator.next();
            int var20 = var17;
            if (var20 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int var21 = (Number) var19;
            int var22 = var20;
            Object var24 = var15;
            int var23 = 0;
            if (var22 == this.countValue) {
            } else {
            }
            var24.add(Integer.valueOf());
        }
        var11 = var15;
        this.kMutableProperty0.set(new Color((Number) var11.get(0), (Number) var11.get(1), (Number) var11.get(2), (Number) var11.get(3)));
    }

}
