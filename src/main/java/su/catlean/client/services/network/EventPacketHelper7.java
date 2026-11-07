package su.catlean.client.services.network;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1656;
import net.minecraft.class_1661;
import net.minecraft.class_2739;
import net.minecraft.class_2848.class_2849;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.math.Box;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract6;
import su.catlean.api.event.events.network.AfterSendPacket;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.AfterElytraEvent;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PreElytraEvent;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.event.events.player.SetPoseEvent;
import su.catlean.api.event.events.world.FireWorkVelocityEvent;
import su.catlean.client.features.modules.movement.rage.ElytraPlusModule;
import su.catlean.client.features.modules.movement.rage.ElytraPlusNcpStrictMode;
import su.catlean.client.features.modules.utility.equip.ElytraSwapModule;
import su.catlean.client.types.mappings.ElytraPlusNcpStrictModeWhenMappings;

public class EventPacketHelper7 implements Contract6 {

    public static final EventPacketHelper7 INSTANCE;
    private static String[] textValueArray;

    private EventPacketHelper7() {
    }

    public void executeAction(PreSyncEvent e) {
        if (this.checkCondition()) {
        }
        if (!(ElytraPlusModule.INSTANCE.getInfDurability())) {
            if (!(SharedKt.getPlayer().isFallFlying())) {
                ElytraSwapModule.INSTANCE.updateValue(true);
                PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
            }
        }
        e.cancel();
    }

    public void executeAction(PreElytraEvent e) {
    }

    public void executeAction(AfterElytraEvent e) {
    }

    public void executeAction(MoveEvent e) {
        SharedKt.getPlayer().method_31549().field_7479 = false;
        SharedKt.getPlayer().method_31549().method_7248(0.05F);
        if (this.checkCondition()) {
        }
        if (ElytraPlusModule.INSTANCE.getStopOnGround() || !(Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA))) {
            return;
        }
        SharedKt.getPlayer().method_31549().field_7479 = true;
        if (ElytraPlusModule.INSTANCE.getAccelerate()) {
            float factor = ElytraPlusModule.INSTANCE.getAccelerateFactor();
            float factor2 = (ElytraPlusModule.INSTANCE.getXzSpeed() / 15.0F);
            class_1656 class1656 = SharedKt.getPlayer().method_31549();
            int index = 0;
            ElytraPlusModule.INSTANCE.updateValue((ElytraPlusModule.INSTANCE.getNumericValue() + factor));
            float factor3 = ElytraPlusModule.INSTANCE.getNumericValue();
            float factor4 = (factor3 / 100.0D);
            index = 1.0D;
        } else {
        }
        factor2.method_7248((Math.min(factor4, index) * 1.0D));
        e.cancel();
        if (!((SharedKt.getPlayer().field_6012 % 3)) && ElytraPlusModule.INSTANCE.getNcpStrictMode() == ElytraPlusNcpStrictMode.Motion) {
            e.setX(0.0D);
            e.setY(0.0D);
            e.setZ(0.0D);
            return;
        }
        if (Math.abs(e.getX()) < 0.05D) {
            e.setX(0.0D);
        }
        if (Math.abs(e.getZ()) < 0.05D) {
            e.setZ(0.0D);
        }
        if (ElytraPlusModule.INSTANCE.getVertical()) {
            if (SharedKt.getMc().options.field_1903.method_1434()) {
            } else {
                if (SharedKt.getMc().options.field_1832.method_1434()) {
                } else {
                }
            }
        } else {
        }
        this.setY(0.0D);
        e.setY(-1.000088900582341E-12D);
        e.setY(-4.000355602329364E-12D);
        if (!((SharedKt.getPlayer().field_6012 % 2))) {
        } else {
        }
        2.0E-4D.setY(((0.0D - 1.0E-6D) + (Math.random() * 9.0E-7D)));
        if (ElytraPlusModule.INSTANCE.getNcpStrictMode() != ElytraPlusNcpStrictMode.New) {
        }
        if (SharedKt.getPlayer().field_5976 && ElytraPlusModule.INSTANCE.getNcpStrictMode() == ElytraPlusNcpStrictMode.Motion && !((SharedKt.getPlayer().field_6012 % 2))) {
            e.setY(-0.07840000152587923D);
        }
        if (!(ElytraPlusModule.INSTANCE.getInfDurability())) {
        }
        factor4 = Math.toRadians((4.5D * (SharedKt.getPlayer().field_6012 % 80)));
        e.setX((Math.sin(factor4) * 0.12D));
        e.setZ((Math.cos(factor4) * 0.12D));
    }

    public void executeAction(AfterSendPacket event) {
    }

    public void executeAction(ReceivePacket e) {
        if (__UNDEF_KEY__ == null) {
        }
        class_2739 class2739 = ((class_2739) e.getPacket());
        if (__UNDEF_KEY__ == null) {
        }
        if (class2739.comp_1128().isEmpty()) {
            return;
        }
        e.cancel();
    }

    public void executeAction(PlayerUpdateEvent e) {
    }

    public void executeAction() {
    }

    public void updateValue() {
        SharedKt.getPlayer().method_31549().field_7479 = false;
        SharedKt.getPlayer().method_31549().method_7248(0.05F);
    }

    public void executeAction(FireWorkVelocityEvent e) {
    }

    public void onSetPoseEvent(SetPoseEvent e) {
    }

    public void executeAction(ReceivePacket e) {
    }

    public boolean checkCondition() {
        return SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_1009(-0.25D, 0.0D, -0.25D).method_989(0.0D, -0.3D, 0.0D)).iterator().hasNext();
    }

    static {
        INSTANCE = new EventPacketHelper7();
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
