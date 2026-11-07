package su.catlean.api.event.events.network;

import net.minecraft.entity.player.PlayerEntity;
import su.catlean.api.event.Event;

public class PlayerEntityDeathEvent extends Event {

    public static final PlayerEntityDeathEvent INSTANCE;
    private static PlayerEntity player;
    private static int totemsPopped;

    private PlayerEntityDeathEvent() {
        super();
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity value) {
        player = value;
    }

    public int getTotemsPopped() {
        return totemsPopped;
    }

    public void setTotemsPopped(int value) {
        totemsPopped = value;
    }

    static {
        INSTANCE = new PlayerEntityDeathEvent();
    }

}
