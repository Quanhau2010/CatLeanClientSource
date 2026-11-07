package su.catlean.api.contracts;

import su.catlean.api.event.events.network.AfterSendPacket;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.AfterElytraEvent;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PreElytraEvent;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.event.events.player.SetPoseEvent;
import su.catlean.api.event.events.world.FireWorkVelocityEvent;

public interface Contract6 {

    public void executeAction(PreSyncEvent arg0);

    public void executeAction(PreElytraEvent arg0);

    public void executeAction(AfterElytraEvent arg0);

    public void executeAction(MoveEvent arg0);

    public void executeAction(AfterSendPacket arg0);

    public void executeAction(ReceivePacket arg0);

    public void executeAction(PlayerUpdateEvent arg0);

    public void executeAction();

    public void updateValue();

    public void executeAction(FireWorkVelocityEvent arg0);

    public void onSetPoseEvent(SetPoseEvent arg0);

    public void executeAction(ReceivePacket arg0);

}
