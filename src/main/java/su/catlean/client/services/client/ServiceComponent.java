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
        long var4 = SharedKt.getNumericValue();
        arrayDeque.addLast(Long.valueOf());
        if ((Long) arrayDeque.firstOrNull() != null) {
            long var6 = (Number) (Long) arrayDeque.firstOrNull().longValue();
            int var8 = 0;
        } else {
        }
        if ((var6 + -7051340584878865432L) < var4 == 1) {
            arrayDeque.removeFirst();
        }
        countValue = arrayDeque.size();
    }

    static {
        INSTANCE = new ServiceComponent();
        arrayDeque = new ArrayDeque();
    }

}
