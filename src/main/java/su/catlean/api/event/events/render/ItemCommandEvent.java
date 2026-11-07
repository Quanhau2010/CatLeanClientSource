package su.catlean.api.event.events.render;

import net.minecraft.class_4597;
import su.catlean.api.event.Event;

public class ItemCommandEvent extends Event {

    public static final ItemCommandEvent INSTANCE;
    private static class_4597 provider;

    private ItemCommandEvent() {
        super();
    }

    public class_4597 getProvider() {
        return provider;
    }

    public void setProvider(class_4597 value) {
        provider = value;
    }

    static {
        INSTANCE = new ItemCommandEvent();
    }

}
