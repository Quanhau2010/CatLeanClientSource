package su.catlean.api.event.events.render;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_4604;
import su.catlean.api.event.Event;

public class FrustrumEvent extends Event {

    public static final FrustrumEvent INSTANCE;
    public static class_4604 frustrum;

    private FrustrumEvent() {
        super();
    }

    public class_4604 getFrustrum() {
        if (frustrum != null) {
            return frustrum;
        }
        Intrinsics.throwUninitializedPropertyAccessException("frustrum");
        return null;
    }

    public void setFrustrum(class_4604 value) {
        frustrum = value;
    }

    static {
        INSTANCE = new FrustrumEvent();
    }

}
