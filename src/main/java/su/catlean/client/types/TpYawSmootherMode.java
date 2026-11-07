package su.catlean.client.types;

import kotlin.jvm.functions.Function1;

public enum TpYawSmootherMode {

    LINEAR,
    IN_QUAD,
    OUT_QUAD,
    IN_OUT_QUAD,
    IN_CUBIC,
    OUT_CUBIC,
    IN_QUART,
    OUT_QUART,
    IN_OUT_QUART,
    IN_QUINT,
    OUT_QUINT,
    IN_OUT_QUINT,
    IN_SINE,
    OUT_SINE,
    IN_OUT_SINE,
    IN_EXPO,
    OUT_EXPO,
    IN_OUT_EXPO,
    IN_CIRC,
    OUT_CIRC,
    IN_OUT_CIRC,
    SIGMOID,
    SIGMOID_2,
    SIGMOID_3,
    SIGMOID_4,
    SIGMOID_5,
    SIGMOID_6,
    SIGMOID_7,
    OUT_ELASTIC,
    IN_BACK,
    OUT_BACK,
    DECELERATE,
    IN_OUT_CUBIC;

    private final Function1 function1;
    private static int countValue;

    public Function1 getFunction1() {
        return this.function1;
    }

    private static double computeValue(double arg0) {
        return arg0;
    }

    private static double computeValue2(double arg0) {
        return Math.pow(arg0, 2);
    }

    private static double computeValue3(double arg0) {
        return (arg0 * (2 - arg0));
    }

    private static double computeValue4(double arg0) {
        if (arg0 < 0.5D) {
        } else {
        }
        return (-1 + ((4 - (2 * arg0)) * arg0));
    }

    private static double computeValue5(double arg0) {
        return Math.pow(arg0, 3);
    }

    private static double computeValue6(double arg0) {
        return (Math.pow((arg0 - 1), 3) + 1);
    }

    private static double computeValue7(double arg0) {
        return Math.pow(arg0, 4);
    }

    private static double computeValue8(double arg0) {
        return (1 - Math.pow((arg0 - 1), 4));
    }

    private static double computeValue9(double arg0) {
        if (arg0 < 0.5D) {
        } else {
        }
        return (1.0F - (Math.pow(((-2.0F * arg0) + 2.0F), 4) / 2.0F));
    }

    private static double computeValue10(double arg0) {
        return Math.pow(arg0, 5);
    }

    private static double computeValue11(double arg0) {
        return (1 + Math.pow((arg0 - 1), 5));
    }

    private static double computeValue12(double arg0) {
        if (arg0 < 0.5D) {
        } else {
        }
        return (1.0F - (Math.pow(((-2.0F * arg0) + 2.0F), 5) / 2.0F));
    }

    private static double computeValue13(double arg0) {
        return (1 - Math.cos(((arg0 * 3.141592653589793D) / 2)));
    }

    private static double computeValue14(double arg0) {
        return Math.sin(((arg0 * 3.141592653589793D) / 2));
    }

    private static double computeValue15(double arg0) {
        return (1 - Math.cos(((3.141592653589793D * arg0) / 2)));
    }

    private static double computeValue16(double arg0) {
        if (arg0 == 0.0D) {
        } else {
        }
        return Math.pow(2.0D, ((10 * arg0) - 10));
    }

    private static double computeValue17(double arg0) {
        if (arg0 == 1.0D) {
        } else {
        }
        return (1 - Math.pow(2.0D, (-10 * arg0)));
    }

    private static double computeValue18(double arg0) {
        if (arg0 != 0.0D) {
            if (arg0 == 1.0D) {
            } else {
                if (arg0 < 0.5D) {
                } else {
                }
            }
        }
        return ((2 - Math.pow(2.0D, ((-20 * arg0) + 10))) / 2);
    }

    private static double computeValue19(double arg0) {
        return (1 - Math.sqrt((1 - Math.pow(arg0, 2))));
    }

    private static double computeValue20(double arg0) {
        return Math.sqrt((1 - Math.pow((arg0 - 1), 2)));
    }

    private static double computeValue21(double arg0) {
        if (arg0 < 0.5D) {
            float factor = (2.0F * arg0);
        } else {
            factor = ((-2.0F * arg0) + 2.0F);
        }
        return ((Math.sqrt((1.0F - (factor * factor))) + 1.0F) / 2.0F);
    }

    private static double computeValue22(double arg0) {
        double offset = 10.0D;
        return (1 / (1 + Math.exp((offset * (arg0 - 0.5D)))));
    }

    private static double computeValue23(double arg0) {
        double offset = 8.0D;
        return (1 / (1 + Math.exp((offset * (arg0 - 0.5D)))));
    }

    private static double computeValue24(double arg0) {
        double offset = 12.0D;
        return (1 / (1 + Math.exp((offset * (arg0 - 0.5D)))));
    }

    private static double computeValue25(double arg0) {
        double offset = 6.0D;
        return (1 / (1 + Math.exp((offset * (arg0 - 0.5D)))));
    }

    private static double computeValue26(double arg0) {
        double offset = 14.0D;
        return (1 / (1 + Math.exp((offset * (arg0 - 0.5D)))));
    }

    private static double computeValue27(double arg0) {
        double offset = 4.0D;
        return (1 / (1 + Math.exp((offset * (arg0 - 0.5D)))));
    }

    private static double computeValue28(double arg0) {
        double offset = 16.0D;
        return (1 / (1 + Math.exp((offset * (arg0 - 0.5D)))));
    }

    private static double computeValue29(double arg0) {
        if (arg0 == 0.0D) {
        } else {
            if (arg0 == 1.0D) {
            } else {
            }
        }
        return (((Math.pow(2.0D, (-10 * arg0)) * Math.sin((((arg0 * 10) - 0.75D) * 2.0943951023931953D))) * 0.5D) + 1);
    }

    private static double computeValue30(double arg0) {
        return ((2.70158D * Math.pow(arg0, 3)) - (1.70158D * Math.pow(arg0, 2)));
    }

    private static double computeValue31(double arg0) {
        return ((1 + (2.70158D * Math.pow((arg0 - 1), 3))) + (1.70158D * Math.pow((arg0 - 1), 2)));
    }

    private static double computeValue32(double arg0) {
        return (1 - Math.pow((arg0 - 1), 2));
    }

    private static double computeValue33(double arg0) {
        if (arg0 < 0.5D) {
        } else {
        }
        return (1.0F - (Math.pow(((-2.0F * arg0) + 2.0F), 3) / 2.0F));
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 122;
        return 0;
    }

}
