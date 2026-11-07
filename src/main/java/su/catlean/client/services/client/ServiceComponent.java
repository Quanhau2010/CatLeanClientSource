package su.catlean.client.services.client;

import kotlin.collections.ArrayDeque;
import su.catlean.SharedKt;

public class ServiceComponent {

    public static final ServiceComponent INSTANCE;
    private static final ArrayDeque arrayDeque;
    private static int countValue;

    private ServiceComponent() {
    }

    public int getNumericValue() {
        return countValue;
    }

    public void updateValue() {
        long time = SharedKt.getNumericValue();
        arrayDeque.addLast(Long.valueOf(time));
        if (((Long) arrayDeque.firstOrNull()) != null) {
            long time2 = ((Number) ((Long) arrayDeque.firstOrNull())).longValue();
        } else {
            if ((time2 + 1000) < time == 1) {
                arrayDeque.removeFirst();
            }
        }
        countValue = arrayDeque.size();
    }

    static {
        INSTANCE = new ServiceComponent();
        arrayDeque = new ArrayDeque();
    }

}
