package su.catlean.client.services.client;

import java.util.Random;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedRange;

public class RangeServiceComponent {

    private static final Random random;
    private static String textValue;

    public static Random getRandom() {
        return random;
    }

    public static int computeValue(int from, int to, boolean normalDistribution) {
        return MathKt.roundToInt((from + ((to - from) * computeValue(normalDistribution))));
    }

    public static float computeValue(float from, float to, boolean normalDistribution) {
        return (from + ((to - from) * computeValue(normalDistribution)));
    }

    public static double computeValue(double from, double to, boolean normalDistribution) {
        return (from + ((to - from) * computeValue(normalDistribution)));
    }

    public static double computeValue(ClosedRange range, boolean normalDistribution) {
        return computeValue((Number) range.getStart(), (Number) range.getEndInclusive(), normalDistribution);
    }

    public static float computeValue(ClosedRange range, boolean normalDistribution) {
        return computeValue((Number) range.getStart(), (Number) range.getEndInclusive(), normalDistribution);
    }

    public static int computeValue(ClosedRange range, boolean normalDistribution) {
        if (computeValue((Number) range.getStart(), (Number) range.getEndInclusive(), normalDistribution) != null) {
        }
        return null;
    }

    public static double computeValue(boolean normalDistribution) {
        return random.nextDouble();
    }

    public static double getNumericValue() {
        return random.nextGaussian();
    }

    static {
        random = new Random();
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
