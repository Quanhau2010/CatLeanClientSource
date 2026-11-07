package su.catlean.client.services.client;

public class ServiceComponent46 {

    public static final ServiceComponent46 INSTANCE;

    private ServiceComponent46() {
    }

    public float computeValue(float endPoint, float current, float speed) {
        float factor = speed;
        if (factor < 0.0F) {
            if (__UNDEF_KEY__ >= 0) {
                factor = 0.0F;
                if (factor > 1.0F) {
                    factor = 1.0F;
                }
            }
        } else {
        }
        double offset = (Math.max(endPoint, current) - Math.min(endPoint, current));
        double offset2 = (offset * factor);
        return (offset2 + offset2);
    }

    public double computeValue() {
        return Math.sqrt((1.0D - ((this - 1.0D) * (this - 1.0D))));
    }

    public double computeValue2(Number x) {
        return (1.0D - ((0.5D * Math.sin(((3.141592653589793D * x) + 1.5707963267948966D))) + 0.5D));
    }

    static {
        INSTANCE = new ServiceComponent46();
    }

}
