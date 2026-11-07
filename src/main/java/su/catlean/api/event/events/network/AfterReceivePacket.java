package su.catlean.api.event.events.network;

import net.minecraft.network.packet.Packet;
import su.catlean.api.event.Event;

public class AfterReceivePacket extends Event {

    private final Packet packet;

    public AfterReceivePacket(Packet packet) {
        super();
        this.packet = packet;
    }

    public Packet getPacket() {
        return this.packet;
    }

}
