package su.catlean.api.event;

public class GetFogBufferEvent extends Event {

    public static final GetFogBufferEvent INSTANCE;

    private GetFogBufferEvent() {
        super();
    }

    static {
        INSTANCE = new GetFogBufferEvent();
    }

}
