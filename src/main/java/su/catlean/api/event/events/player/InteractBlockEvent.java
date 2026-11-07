package su.catlean.api.event.events.player;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_3965;
import net.minecraft.util.Hand;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class InteractBlockEvent extends Event {

    public static final InteractBlockEvent INSTANCE;
    public static Hand hand;
    public static class_3965 hitResult;

    private InteractBlockEvent() {
        super();
    }

    public Hand getHand() {
        if (hand != null) {
            return hand;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hand");
        return null;
    }

    public void setHand(Hand value) {
        hand = value;
    }

    public class_3965 getHitResult() {
        if (hitResult != null) {
            return hitResult;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hitResult");
        return null;
    }

    public void setHitResult(class_3965 value) {
        hitResult = value;
    }

    public boolean call(Hand hand, class_3965 hitResult) {
        this.setHand(hand);
        this.setHitResult(hitResult);
        this.setCancelled(false);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new InteractBlockEvent();
    }

}
