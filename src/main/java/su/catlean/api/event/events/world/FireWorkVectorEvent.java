package su.catlean.api.event.events.world;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.Vec3d;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class FireWorkVectorEvent extends Event {

    public static final FireWorkVectorEvent INSTANCE;
    public static Vec3d vector;

    private FireWorkVectorEvent() {
        super();
    }

    public Vec3d getVector() {
        if (vector != null) {
            return vector;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vector");
        return null;
    }

    public void setVector(Vec3d value) {
        vector = value;
    }

    public boolean call(Vec3d vec) {
        this.setVector(vec);
        this.setCancelled(0);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new FireWorkVectorEvent();
    }

}
