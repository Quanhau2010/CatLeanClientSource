package su.catlean.client.services.network;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.packet.Packet;

public class PacketPacketHelper2 {

    private final Packet minecraftRef;

    public PacketPacketHelper2(Packet packet, long timestamp) {
        this.minecraftRef = packet;
        this.timestampValue = timestamp;
    }

    public Packet getMinecraftObject() {
        return this.minecraftRef;
    }

    public long getNumericValue() {
        return this.timestampValue;
    }

    public Packet getMinecraftObject2() {
        return this.minecraftRef;
    }

    public long getNumericValue2() {
        return this.timestampValue;
    }

    public PacketPacketHelper2 handlePacket(Packet packet, long timestamp) {
        return new PacketPacketHelper2(packet, timestamp);
    }

    public static PacketPacketHelper2 handlePacket(PacketPacketHelper2 arg0, Packet arg1, long arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = arg0.minecraftRef;
        }
        if ((arg3 & 2)) {
        }
        return arg0.handlePacket(arg1, arg2);
    }

    public String toString() {
        Packet var5 = this.minecraftRef;
        return ("BTPacket(packet=" + var5 + ", timestamp=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.minecraftRef.hashCode();
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketPacketHelper2)) {
            return false;
        }
        PacketPacketHelper2 var5 = (PacketPacketHelper2) other;
        if (!(Intrinsics.areEqual(this.minecraftRef, var5.minecraftRef))) {
            return false;
        }
        if (this.timestampValue != var5.timestampValue) {
            return false;
        }
        return true;
    }

}
