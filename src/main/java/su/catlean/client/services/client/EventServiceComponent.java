package su.catlean.client.services.client;

import kotlin.collections.ArrayDeque;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.render.Render3DEvent;

public class EventServiceComponent implements Contract9 {

    public static final EventServiceComponent INSTANCE;
    private static final ArrayDeque arrayDeque;
    private static int countValue;
    private static String textValue;

    private EventServiceComponent() {
    }

    public int getNumericValue() {
        return countValue;
    }

    public void updateValue(int value) {
        countValue = value;
    }

    public void onRender3DEvent(Render3DEvent event) {
        long time = SharedKt.getNumericValue();
        arrayDeque.addLast(Long.valueOf(time));
        if (((Long) arrayDeque.firstOrNull()) != null) {
            long time2 = ((Number) ((Long) arrayDeque.firstOrNull())).longValue();
        } else {
            if ((time2 + 1000) < time == 1) {
                arrayDeque.removeFirst();
            }
        }
        countValue = Math.max(arrayDeque.size(), 4);
    }

    static {
        INSTANCE = new EventServiceComponent();
        arrayDeque = new ArrayDeque();
        countValue = 5;
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
