package su.catlean.api.event.events.render;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_703;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class RenderParticleEvent extends Event {

    public static final RenderParticleEvent INSTANCE;
    private static class_703 particle;

    private RenderParticleEvent() {
        super();
    }

    public class_703 getParticle() {
        if (particle != null) {
            return particle;
        }
        Intrinsics.throwUninitializedPropertyAccessException("particle");
        return null;
    }

    public boolean call(class_703 particle) {
        this.setCancelled(0);
        particle = particle;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new RenderParticleEvent();
    }

}
