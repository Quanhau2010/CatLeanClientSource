package su.catlean.client.services.network;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1661;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_744;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.math.Vec3d;
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
import su.catlean.client.features.modules.utility.equip.ElytraSwapModule;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent98;

public class EventPacketHelper6 implements Contract6 {

    public static final EventPacketHelper6 INSTANCE;

    private EventPacketHelper6() {
    }

    public void executeAction(PreSyncEvent e) {
        if (SharedKt.getPlayer().isOnGround()) {
            ElytraPlusModule.INSTANCE.updateValue(true);
        }
        if (ElytraPlusModule.INSTANCE.isActive() && !(SharedKt.getPlayer().isOnGround()) && EventPacketHelper2.INSTANCE.getNumericValue() > 0.0D && ElytraPlusModule.INSTANCE.getInstantFly()) {
            ServiceComponent98.INSTANCE.updateValue2(0.3F);
        }
        if (!(ElytraPlusModule.INSTANCE.getServiceComponent10().checkCondition((1000 * ElytraPlusModule.INSTANCE.getRedeployDelay())))) {
            return;
        }
        ElytraPlusModule.INSTANCE.getServiceComponent10().executeAction();
        ElytraSwapModule.INSTANCE.updateValue(true);
        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
        ElytraPlusModule.INSTANCE.updateValue(false);
        ElytraPlusModule.INSTANCE.getServiceComponent102().executeAction();
    }

    public void executeAction(PreElytraEvent e) {
    }

    public void executeAction(AfterElytraEvent e) {
    }

    public void executeAction(MoveEvent e) {
        if (!(Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA)) || !(SharedKt.getPlayer().isFallFlying())) {
            return;
        }
        if (ElytraPlusModule.INSTANCE.getAccelerate()) {
            float factor = ElytraPlusModule.INSTANCE.getAccelerateFactor();
            float factor2 = ElytraPlusModule.INSTANCE.getXzSpeed();
            EventPacketHelper2 eventPacketHelper2 = EventPacketHelper2.INSTANCE;
            int index = 0;
            ElytraPlusModule.INSTANCE.updateValue((ElytraPlusModule.INSTANCE.getNumericValue() + factor));
            float factor3 = ElytraPlusModule.INSTANCE.getNumericValue();
            float factor4 = (factor3 / 100.0F);
            index = 1.0D;
        } else {
        }
        double[] items = EventPacketHelper2.process(factor2, (Math.min(factor4, index) * 1.0D), false, 0.0F, 0.0F, 0.0F);
        e.setX(items[0]);
        if (SharedKt.getMc().options.field_1903.method_1434()) {
        } else {
            if (SharedKt.getMc().options.field_1832.method_1434()) {
            } else {
                if (ElytraPlusModule.INSTANCE.getPitchControl() && EventPacketHelper2.INSTANCE.checkCondition()) {
                } else {
                }
            }
        }
        (((SharedKt.getPlayer().method_36455() / 90.0D) * ElytraPlusModule.INSTANCE.getUpSpeed()) * Math.signum(SharedKt.getPlayer().field_3913.method_3128().field_1342)).setY((0.0D - (0.08D * ElytraPlusModule.INSTANCE.getDownFactor())));
        e.setZ(items[1]);
        if (!(EventPacketHelper2.INSTANCE.checkCondition())) {
            ElytraPlusModule.INSTANCE.updateValue(0.0F);
        }
        SharedKt.getPlayer().method_18800(e.getX(), e.getY(), e.getZ());
        e.cancel();
    }

    public void executeAction(AfterSendPacket event) {
    }

    public void executeAction(ReceivePacket e) {
    }

    public void executeAction(PlayerUpdateEvent e) {
    }

    public void executeAction() {
    }

    public void updateValue() {
    }

    public void executeAction(FireWorkVelocityEvent e) {
    }

    public void onSetPoseEvent(SetPoseEvent e) {
    }

    public void executeAction(ReceivePacket e) {
    }

    static {
        INSTANCE = new EventPacketHelper6();
    }

}
