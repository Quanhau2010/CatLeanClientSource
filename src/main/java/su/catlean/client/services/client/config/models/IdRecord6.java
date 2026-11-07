package su.catlean.client.services.client.config.models;

import java.awt.Color;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent3;
import su.catlean.client.services.render.ColorRenderHelper4;

public class IdRecord6 {

    public static final ServiceComponent3 serviceComponent3;
    private final String textValue;
    private Color colorValue;
    private Color colorValue2;
    private Color colorValue3;
    private Color colorValue4;
    private Color colorValue5;
    private Color colorValue6;
    private Color colorValue7;
    private Color colorValue8;
    private Color colorValue9;
    private Color colorValue10;
    private Color colorValue11;
    private Color colorValue12;
    private static final Lazy[] lazyArray;
    private static String[] textValueArray;

    public IdRecord6(String id, Color primaryColor, Color secondaryColor, Color blurColor, Color widgetBlurColor, Color outlineColor, Color textColor, Color nonactiveTextColor, Color slidersColor, Color nonActiveModuleColor, Color moduleColor, Color moduleOutlineColor, Color nonActiveOutlineModuleColor) {
        this.textValue = id;
        this.colorValue = primaryColor;
        this.colorValue2 = secondaryColor;
        this.colorValue3 = blurColor;
        this.colorValue4 = widgetBlurColor;
        this.colorValue5 = outlineColor;
        this.colorValue6 = textColor;
        this.colorValue7 = nonactiveTextColor;
        this.colorValue8 = slidersColor;
        this.colorValue9 = nonActiveModuleColor;
        this.colorValue10 = moduleColor;
        this.colorValue11 = moduleOutlineColor;
        this.colorValue12 = nonActiveOutlineModuleColor;
    }

    public String getString() {
        return this.textValue;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public void executeAction(Color value) {
        this.colorValue = value;
    }

    public Color getColor2() {
        return this.colorValue2;
    }

    public void executeAction(Color value) {
        this.colorValue2 = value;
    }

    public Color getColor3() {
        return this.colorValue3;
    }

    public void executeAction2(Color value) {
        this.colorValue3 = value;
    }

    public Color getColor4() {
        return this.colorValue4;
    }

    public void executeAction3(Color value) {
        this.colorValue4 = value;
    }

    public Color getColor5() {
        return this.colorValue5;
    }

    public void executeAction2(Color value) {
        this.colorValue5 = value;
    }

    public Color getColor6() {
        return this.colorValue6;
    }

    public void executeAction4(Color value) {
        this.colorValue6 = value;
    }

    public Color getColor7() {
        return this.colorValue7;
    }

    public void executeAction5(Color value) {
        this.colorValue7 = value;
    }

    public Color getColor8() {
        return this.colorValue8;
    }

    public void executeAction(Color value) {
        this.colorValue8 = value;
    }

    public Color getColor9() {
        return this.colorValue9;
    }

    public void executeAction3(Color value) {
        this.colorValue9 = value;
    }

    public Color getColor10() {
        return this.colorValue10;
    }

    public void executeAction(Color value) {
        this.colorValue10 = value;
    }

    public Color getColor11() {
        return this.colorValue11;
    }

    public void executeAction4(Color value) {
        this.colorValue11 = value;
    }

    public Color getColor12() {
        return this.colorValue12;
    }

    public void executeAction6(Color value) {
        this.colorValue12 = value;
    }

    public String getString2() {
        return this.textValue;
    }

    public Color getColor13() {
        return this.colorValue;
    }

    public Color getColor14() {
        return this.colorValue2;
    }

    public Color getColor15() {
        return this.colorValue3;
    }

    public Color getColor16() {
        return this.colorValue4;
    }

    public Color getColor17() {
        return this.colorValue5;
    }

    public Color getColor18() {
        return this.colorValue6;
    }

    public Color getColor19() {
        return this.colorValue7;
    }

    public Color getColor20() {
        return this.colorValue8;
    }

    public Color getColor21() {
        return this.colorValue9;
    }

    public Color getColor22() {
        return this.colorValue10;
    }

    public Color getColor23() {
        return this.colorValue11;
    }

    public Color getColor24() {
        return this.colorValue12;
    }

    public IdRecord6 resolveIdRecord6(String id, Color primaryColor, Color secondaryColor, Color blurColor, Color widgetBlurColor, Color outlineColor, Color textColor, Color nonactiveTextColor, Color slidersColor, Color nonActiveModuleColor, Color moduleColor, Color moduleOutlineColor, Color nonActiveOutlineModuleColor) {
        return new IdRecord6(id, primaryColor, secondaryColor, blurColor, widgetBlurColor, outlineColor, textColor, nonactiveTextColor, slidersColor, nonActiveModuleColor, moduleColor, moduleOutlineColor, nonActiveOutlineModuleColor);
    }

    public static IdRecord6 resolveIdRecord6(IdRecord6 arg0, String arg1, Color arg2, Color arg3, Color arg4, Color arg5, Color arg6, Color arg7, Color arg8, Color arg9, Color arg10, Color arg11, Color arg12, Color arg13, int arg14, Object arg15) {
        if ((arg14 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg14 & 2)) {
            arg2 = arg0.colorValue;
        }
        if ((arg14 & 4)) {
            arg3 = arg0.colorValue2;
        }
        if ((arg14 & 8)) {
            arg4 = arg0.colorValue3;
        }
        if ((arg14 & 16)) {
            arg5 = arg0.colorValue4;
        }
        if ((arg14 & 32)) {
            arg6 = arg0.colorValue5;
        }
        if ((arg14 & 64)) {
            arg7 = arg0.colorValue6;
        }
        if ((arg14 & 128)) {
            arg8 = arg0.colorValue7;
        }
        if ((arg14 & 256)) {
            arg9 = arg0.colorValue8;
        }
        if ((arg14 & 512)) {
            arg10 = arg0.colorValue9;
        }
        if ((arg14 & 1024)) {
            arg11 = arg0.colorValue10;
        }
        if ((arg14 & 2048)) {
            arg12 = arg0.colorValue11;
        }
        if ((arg14 & 4096)) {
            arg13 = arg0.colorValue12;
        }
        return arg0.resolveIdRecord6(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public String toString() {
        Color var3 = this.colorValue12;
        Color var4 = this.colorValue11;
        Color var5 = this.colorValue10;
        Color var6 = this.colorValue9;
        Color var7 = this.colorValue8;
        Color var8 = this.colorValue7;
        Color var9 = this.colorValue6;
        Color var10 = this.colorValue5;
        Color var11 = this.colorValue4;
        Color var12 = this.colorValue3;
        Color var13 = this.colorValue2;
        Color var14 = this.colorValue;
        String var15 = this.textValue;
        return ("ThemeConfig(id=" + var15 + ", primaryColor=" + var14 + ", secondaryColor=" + var13 + ", blurColor=" + var12 + ", widgetBlurColor=" + var11 + ", outlineColor=" + var10 + ", textColor=" + var9 + ", nonactiveTextColor=" + var8 + ", slidersColor=" + var7 + ", nonActiveModuleColor=" + var6 + ", moduleColor=" + var5 + ", moduleOutlineColor=" + var4 + ", nonActiveOutlineModuleColor=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = this.textValue.hashCode();
        var4 = ((var4 * 31) + this.colorValue.hashCode());
        var4 = ((var4 * 31) + this.colorValue2.hashCode());
        var4 = ((var4 * 31) + this.colorValue3.hashCode());
        var4 = ((var4 * 31) + this.colorValue4.hashCode());
        var4 = ((var4 * 31) + this.colorValue5.hashCode());
        var4 = ((var4 * 31) + this.colorValue6.hashCode());
        var4 = ((var4 * 31) + this.colorValue7.hashCode());
        var4 = ((var4 * 31) + this.colorValue8.hashCode());
        var4 = ((var4 * 31) + this.colorValue9.hashCode());
        var4 = ((var4 * 31) + this.colorValue10.hashCode());
        var4 = ((var4 * 31) + this.colorValue11.hashCode());
        var4 = ((var4 * 31) + this.colorValue12.hashCode());
        if (var4 != null) {
        }
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord6)) {
            return false;
        }
        IdRecord6 var5 = (IdRecord6) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue, var5.colorValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue2, var5.colorValue2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue3, var5.colorValue3))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue4, var5.colorValue4))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue5, var5.colorValue5))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue6, var5.colorValue6))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue7, var5.colorValue7))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue8, var5.colorValue8))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue9, var5.colorValue9))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue10, var5.colorValue10))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue11, var5.colorValue11))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue12, var5.colorValue12))) {
            return false;
        }
        return true;
    }

    public static void executeAction(IdRecord6 self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] var6 = lazyArray;
        output.encodeStringElement(serialDesc, 0, self.textValue);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) var6[1].getValue(), self.colorValue);
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) var6[2].getValue(), self.colorValue2);
        output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy) var6[3].getValue(), self.colorValue3);
        output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy) var6[4].getValue(), self.colorValue4);
        output.encodeSerializableElement(serialDesc, 5, (SerializationStrategy) var6[5].getValue(), self.colorValue5);
        output.encodeSerializableElement(serialDesc, 6, (SerializationStrategy) var6[6].getValue(), self.colorValue6);
        output.encodeSerializableElement(serialDesc, 7, (SerializationStrategy) var6[7].getValue(), self.colorValue7);
        output.encodeSerializableElement(serialDesc, 8, (SerializationStrategy) var6[8].getValue(), self.colorValue8);
        output.encodeSerializableElement(serialDesc, 9, (SerializationStrategy) var6[9].getValue(), self.colorValue9);
        output.encodeSerializableElement(serialDesc, 10, (SerializationStrategy) var6[10].getValue(), self.colorValue10);
        output.encodeSerializableElement(serialDesc, 11, (SerializationStrategy) var6[11].getValue(), self.colorValue11);
        output.encodeSerializableElement(serialDesc, 12, (SerializationStrategy) var6[12].getValue(), self.colorValue12);
    }

    public IdRecord6(int seen0, String id, Color primaryColor, Color secondaryColor, Color blurColor, Color widgetBlurColor, Color outlineColor, Color textColor, Color nonactiveTextColor, Color slidersColor, Color nonActiveModuleColor, Color moduleColor, Color moduleOutlineColor, Color nonActiveOutlineModuleColor, SerializationConstructorMarker serializationConstructorMarker) {
        if (8191 != (8191 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 8191, IdRecord6Serializer.INSTANCE.getDescriptor());
        }
        this.textValue = id;
        this.colorValue = primaryColor;
        this.colorValue2 = secondaryColor;
        this.colorValue3 = blurColor;
        this.colorValue4 = widgetBlurColor;
        this.colorValue5 = outlineColor;
        this.colorValue6 = textColor;
        this.colorValue7 = nonactiveTextColor;
        this.colorValue8 = slidersColor;
        this.colorValue9 = nonActiveModuleColor;
        this.colorValue10 = moduleColor;
        this.colorValue11 = moduleOutlineColor;
        this.colorValue12 = nonActiveOutlineModuleColor;
    }

    private static KSerializer getKSerializer() {
        return (KSerializer) new ColorRenderHelper4();
    }

    private static KSerializer getKSerializer2() {
        return (KSerializer) new ColorRenderHelper4();
    }

    private static KSerializer getKSerializer3() {
        return (KSerializer) new ColorRenderHelper4();
    }

    private static KSerializer getKSerializer4() {
        return (KSerializer) new ColorRenderHelper4();
    }

    private static KSerializer getKSerializer5() {
        return (KSerializer) new ColorRenderHelper4();
    }

    private static KSerializer getKSerializer6() {
        return (KSerializer) new ColorRenderHelper4();
    }

    private static KSerializer getKSerializer7() {
        return (KSerializer) new ColorRenderHelper4();
    }

    private static KSerializer getKSerializer8() {
        return (KSerializer) new ColorRenderHelper4();
    }

    private static KSerializer getKSerializer9() {
        return (KSerializer) new ColorRenderHelper4();
    }

    private static KSerializer getKSerializer10() {
        return (KSerializer) new ColorRenderHelper4();
    }

    private static KSerializer getKSerializer11() {
        return (KSerializer) new ColorRenderHelper4();
    }

    private static KSerializer getKSerializer12() {
        return (KSerializer) new ColorRenderHelper4();
    }

    public static Lazy[] process() {
        return lazyArray;
    }

    static {
        serviceComponent3 = new ServiceComponent3();
        Lazy[] var22 = new Lazy[13];
        var22[0] = null;
        var22[1] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        var22[2] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer2);
        var22[3] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer3);
        var22[4] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer4);
        var22[5] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer5);
        var22[6] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer6);
        var22[7] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer7);
        var22[8] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer8);
        var22[9] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer9);
        var22[10] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer10);
        var22[11] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer11);
        var22[12] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer12);
        lazyArray = var22;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
