package su.catlean.api.event.events.player;

import net.minecraft.util.math.Vec3d;
import su.catlean.gofra.Gofra;

public class AfterElytraEvent extends ElytraEvent {

    public static final AfterElytraEvent INSTANCE;

    private AfterElytraEvent() {
        super();
    }

    public boolean call(Vec3d vec) {
        this.setCancelled(false);
        this.setVec(vec);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new AfterElytraEvent();
    }

}
