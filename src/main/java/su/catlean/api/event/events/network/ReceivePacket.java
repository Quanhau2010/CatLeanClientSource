package su.catlean.api.event.events.network;

import net.minecraft.network.packet.Packet;
import su.catlean.api.event.Event;

public class ReceivePacket extends Event {

    private final Packet packet;

    public ReceivePacket(Packet packet) {
        super();
        this.packet = packet;
    }

    public Packet getPacket() {
        return this.packet;
    }

}
