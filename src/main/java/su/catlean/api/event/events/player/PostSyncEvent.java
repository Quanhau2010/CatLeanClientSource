package su.catlean.api.event.events.player;

public class PostSyncEvent extends SyncEvent {

    public static final PostSyncEvent INSTANCE;

    private PostSyncEvent() {
        super();
    }

    static {
        INSTANCE = new PostSyncEvent();
    }

}
