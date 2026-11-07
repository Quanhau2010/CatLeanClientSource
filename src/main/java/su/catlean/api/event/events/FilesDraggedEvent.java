package su.catlean.api.event.events;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class FilesDraggedEvent extends Event {

    public static final FilesDraggedEvent INSTANCE;
    public static List paths;

    private FilesDraggedEvent() {
        super();
    }

    public List getPaths() {
        if (paths != null) {
            return paths;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paths");
        return null;
    }

    public void setPaths(List value) {
        paths = value;
    }

    public boolean call(List paths) {
        this.setPaths(paths);
        this.setCancelled(0);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new FilesDraggedEvent();
    }

}
