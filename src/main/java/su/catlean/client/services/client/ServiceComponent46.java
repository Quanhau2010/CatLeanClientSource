package su.catlean.client.services.client;

public class ServiceComponent46 {

    public static final ServiceComponent46 INSTANCE;

    private ServiceComponent46() {
    }

    public float computeValue(float endPoint, float current, float speed) {
        float var10 = speed;
        if (var10 < 0.0F) {
            if (0L >= 0) {
                var10 = 0.0F;
            } else {
                if (var10 > 1.0F) {
                    var10 = 1.0F;
                }
            }
        }
        double var12 = (Math.max(endPoint, current) - Math.min(endPoint, current));
        float var13 = (var12 * var10);
        return (var13 + var13);
    }

    public double computeValue() {
        return Math.sqrt((1.0D - ((0L - 1.0D) * (0L - 1.0D))));
    }

    public double computeValue2(Number x) {
        return (1.0D - ((0.5D * Math.sin(((3.141592653589793D * x) + 1.5707963267948966D))) + 0.5D));
    }

    static {
        INSTANCE = new ServiceComponent46();
    }

}
