package su.catlean.api.event.events.player;

public class PreSyncEvent extends SyncEvent {

    public static final PreSyncEvent INSTANCE;

    private PreSyncEvent() {
        super();
    }

    static {
        INSTANCE = new PreSyncEvent();
    }

}
