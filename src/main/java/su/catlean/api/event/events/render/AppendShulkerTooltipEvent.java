package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class AppendShulkerTooltipEvent extends Event {

    public static final AppendShulkerTooltipEvent INSTANCE;

    private AppendShulkerTooltipEvent() {
        super();
    }

    static {
        INSTANCE = new AppendShulkerTooltipEvent();
    }

}
