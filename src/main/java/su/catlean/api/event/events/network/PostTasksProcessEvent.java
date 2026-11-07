package su.catlean.api.event.events.network;

import su.catlean.api.event.Event;

public class PostTasksProcessEvent extends Event {

    public static final PostTasksProcessEvent INSTANCE;

    private PostTasksProcessEvent() {
        super();
    }

    static {
        INSTANCE = new PostTasksProcessEvent();
    }

}
