package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class WeatherRenderEvent extends Event {

    public static final WeatherRenderEvent INSTANCE;

    private WeatherRenderEvent() {
        super();
    }

    static {
        INSTANCE = new WeatherRenderEvent();
    }

}
