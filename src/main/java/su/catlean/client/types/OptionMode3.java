package su.catlean.client.types;

import kotlin.jvm.functions.Function1;
import net.minecraft.class_591;
import net.minecraft.class_630;

public enum OptionMode3 {

    HEAD,
    BODY,
    LEFT_ARM,
    RIGHT_ARM,
    LEFT_LEG,
    RIGHT_LEG;

    private final Function1 function1;
    private final Function1 function12;
    private final double preciseValue;
    private final double preciseValue2;
    private static String textValue;

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
