package su.catlean.api.event.events.client;

import su.catlean.api.event.Event;

public class PostTitleScreenInitEvent extends Event {

    public static final PostTitleScreenInitEvent INSTANCE;

    private PostTitleScreenInitEvent() {
        super();
    }

    static {
        INSTANCE = new PostTitleScreenInitEvent();
    }

}
