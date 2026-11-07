package su.catlean.api.event.events.player;

import net.minecraft.util.Hand;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class PreInteractItemEvent extends Event {

    public static final PreInteractItemEvent INSTANCE;
    private static Hand hand;

    private PreInteractItemEvent() {
        super();
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand value) {
        hand = value;
    }

    public boolean call(Hand hand) {
        hand = hand;
        this.setCancelled(false);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new PreInteractItemEvent();
        hand = Hand.field_5808;
    }

}
