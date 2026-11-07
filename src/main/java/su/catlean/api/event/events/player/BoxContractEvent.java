package su.catlean.api.event.events.player;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.Box;
import su.catlean.api.event.Event;

public class BoxContractEvent extends Event {

    public static final BoxContractEvent INSTANCE;
    public static Box value;

    private BoxContractEvent() {
        super();
    }

    public Box getValue() {
        if (value != null) {
            return value;
        }
        Intrinsics.throwUninitializedPropertyAccessException("value");
        return null;
    }

    public void setValue(Box value) {
        value = value;
    }

    static {
        INSTANCE = new BoxContractEvent();
    }

}
