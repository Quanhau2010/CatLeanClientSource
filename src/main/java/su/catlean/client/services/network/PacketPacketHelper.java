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
        Object var9 = packet;
        int var10 = 0;
        int var11 = 0;
        Object var12 = var9;
        if (var11 < var12) {
            Object var13 = var9[var11];
            Object var14 = var13;
            int var15 = 0;
            SharedKt.getNetwork().method_52787();
            if (0L >= 0) {
            }
        }
    }

    public static void executeAction(class_7204 packetCreator) {
        AutoCloseable var8 = (AutoCloseable) SharedKt.getWorld().method_41925().method_41937();
        class_7202 var10 = (class_7202) var8;
        int var11 = 0;
        handlePacket(packetCreator.predict(var10.method_41942()));
        var10 = Unit.INSTANCE;
        AutoCloseableKt.closeFinally();
        Object var9 = var11;
        AutoCloseableKt.closeFinally();
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
