package su.catlean.client.types;

import kotlin.jvm.functions.Function1;
import net.minecraft.class_591;
import net.minecraft.class_630;

public enum OptionMode3 {

    private final Function1 function1;
    private final Function1 function12;
    private final double preciseValue;
    private final double preciseValue2;
    public static final OptionMode3 HEAD;
    public static final OptionMode3 BODY;
    public static final OptionMode3 LEFT_ARM;
    public static final OptionMode3 RIGHT_ARM;
    public static final OptionMode3 LEFT_LEG;
    public static final OptionMode3 RIGHT_LEG;
    private static String textValue;

    OptionMode3(String arg0, int arg1, Function1 arg2, Function1 arg3, double arg4, double arg5) {
        super(arg0, arg1);
        this.function1 = arg2;
        this.function12 = arg3;
        this.preciseValue = arg4;
        this.preciseValue2 = arg5;
    }

    public Function1 getFunction1() {
        return this.function1;
    }

    public Function1 getFunction12() {
        return this.function12;
    }

    public double getNumericValue() {
        return this.preciseValue;
    }

    public double getNumericValue2() {
        return this.preciseValue2;
    }

    private static class_630 resolveMinecraftObject(class_591 arg0) {
        return arg0.field_3398;
    }

    private static class_630 resolveMinecraftObject2(class_591 arg0) {
        return arg0.field_3394;
    }

    private static class_630 resolveMinecraftObject3(class_591 arg0) {
        return arg0.field_3391;
    }

    private static class_630 resolveMinecraftObject4(class_591 arg0) {
        return arg0.field_3483;
    }

    private static class_630 resolveMinecraftObject5(class_591 arg0) {
        return arg0.field_27433;
    }

    private static class_630 resolveMinecraftObject6(class_591 arg0) {
        return arg0.field_3484;
    }

    private static class_630 resolveMinecraftObject7(class_591 arg0) {
        return arg0.field_3401;
    }

    private static class_630 resolveMinecraftObject8(class_591 arg0) {
        return arg0.field_3486;
    }

    private static class_630 resolveMinecraftObject9(class_591 arg0) {
        return arg0.field_3397;
    }

    private static class_630 resolveMinecraftObject10(class_591 arg0) {
        return arg0.field_3482;
    }

    private static class_630 resolveMinecraftObject11(class_591 arg0) {
        return arg0.field_3392;
    }

    private static class_630 resolveMinecraftObject12(class_591 arg0) {
        return arg0.field_3479;
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
