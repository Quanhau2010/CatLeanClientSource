package su.catlean.client.services.network;

import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import net.minecraft.class_7202;
import net.minecraft.class_7204;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;

public class PacketPacketHelper {

    private static int countValue;

    public static void handlePacket(Packet packet) {
        SharedKt.getNetwork().method_52787(packet);
    }

    public static void executeAction(Packet[] packet) {
        int index = 0;
        if (index < packet) {
            Object element = packet[index];
            SharedKt.getNetwork().method_52787(element);
            if (__UNDEF_KEY__ >= 0) {
            }
        }
    }

    public static void executeAction(class_7204 packetCreator) {
        AutoCloseable autoCloseable = ((AutoCloseable) SharedKt.getWorld().method_41925().method_41937());
        class_7202 class7202 = ((class_7202) autoCloseable);
        int index = 0;
        handlePacket(packetCreator.predict(class7202.method_41942()));
        class7202 = Unit.INSTANCE;
        AutoCloseableKt.closeFinally(autoCloseable);
        int index2 = index;
        AutoCloseableKt.closeFinally(autoCloseable, index2);
    }

    public static void executeAction(String command) {
        SharedKt.getNetwork().method_45730(command);
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 122;
        return 0;
    }

}
