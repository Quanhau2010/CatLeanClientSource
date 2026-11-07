package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class TridentWeatherEvent extends Event {

    public static final TridentWeatherEvent INSTANCE;

    private TridentWeatherEvent() {
        super();
    }

    static {
        INSTANCE = new TridentWeatherEvent();
    }

}
