package su.catlean.api.event.events.network;

import net.minecraft.network.packet.Packet;
import su.catlean.api.event.Event;

public class AfterSendPacket extends Event {

    private final Packet packet;

    public AfterSendPacket(Packet packet) {
        super();
        this.packet = packet;
    }

    public Packet getPacket() {
        return this.packet;
    }

}
