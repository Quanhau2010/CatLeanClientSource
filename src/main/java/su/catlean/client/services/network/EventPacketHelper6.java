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
        long var4 = (0L ^ 316164599882L);
        long var6 = (0L ^ 2350125969345L);
        long var8 = ((0L ^ 28393686283084L) >>> 48);
        long var9 = (((0L ^ 28393686283084L) << 16) >>> 48);
        long var10 = (((0L ^ 28393686283084L) << 32) >>> 32);
        long var11 = (0L ^ 95174287896623L);
        long var13 = (0L ^ 43766790553018L);
        long var15 = (0L ^ 95510200616042L);
        if (SharedKt.getPlayer().isOnGround()) {
            ElytraPlusModule.INSTANCE.updateValue(1);
        }
        if (0L >= 0L) {
            if (var17 == null) {
            }
        }
        if (0L >= 0L && var17 == null) {
        }
        if (0L >= 0L) {
            if (var17 == null) {
                if (ElytraPlusModule.INSTANCE.isActive() && !(SharedKt.getPlayer().isOnGround()) && EventPacketHelper2.INSTANCE.getNumericValue() > 0.0D && ElytraPlusModule.INSTANCE.getInstantFly()) {
                    ServiceComponent98.INSTANCE.updateValue2(0.3F);
                }
            }
        }
        if (0L > 0L) {
            if (var17 == null) {
            }
        }
        if (0L > 0L && var17 == null) {
        }
        if (!(ElytraPlusModule.INSTANCE.getServiceComponent10().checkCondition((1000 * ElytraPlusModule.INSTANCE.getRedeployDelay())))) {
            return;
        }
        ElytraPlusModule.INSTANCE.getServiceComponent10().executeAction();
        ElytraSwapModule.INSTANCE.updateValue(1);
        PacketPacketHelper.handlePacket((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982));
        ElytraPlusModule.INSTANCE.updateValue(0);
        ElytraPlusModule.INSTANCE.getServiceComponent102().executeAction();
    }

    public void executeAction(PreElytraEvent e) {
    }

    public void executeAction(AfterElytraEvent e) {
    }

    public void executeAction(MoveEvent e) {
        long var4 = (0L ^ 52389835191008L);
        long var6 = (0L ^ 4452337967885L);
        long var8 = (0L ^ 49448490245388L);
        long var10 = (0L ^ 123833832724325L);
        long var12 = (0L ^ 61376565249967L);
        long var14 = (0L ^ 85271198980116L);
        long var16 = (0L ^ 46640431346444L);
        long var18 = (0L ^ 119169530931175L);
        long var20 = (0L ^ 28734862241446L);
        long var22 = (0L ^ 131128708503632L);
        long var24 = (0L ^ 16494758083782L);
        if (!(Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA)) || !(SharedKt.getPlayer().isFallFlying())) {
            return;
        }
        if (ElytraPlusModule.INSTANCE.getAccelerate()) {
            float var29 = ElytraPlusModule.INSTANCE.getAccelerateFactor();
            float var33 = ElytraPlusModule.INSTANCE.getXzSpeed();
            EventPacketHelper2 var32 = EventPacketHelper2.INSTANCE;
            int var30 = 0;
            ElytraPlusModule.INSTANCE.updateValue((ElytraPlusModule.INSTANCE.getNumericValue() + var29));
            float var34 = ElytraPlusModule.INSTANCE.getNumericValue();
            float var28 = (var34 / 100.0F);
            var30 = 1.0D;
        } else {
        }
        double[] var27 = EventPacketHelper2.process((Math.min() * 1.0D), 0, 0.0F, 0.0F, 0.0F);
        e.setX(var27[0]);
        if (0L >= 0L) {
            if (var26 == null) {
                if (SharedKt.getMc().options.field_1903.method_1434()) {
                } else {
                }
            }
            if (0L > 0L) {
                if (var26 == null) {
                    if (SharedKt.getMc().options.field_1832.method_1434()) {
                    } else {
                    }
                    if (0L > 0L) {
                    }
                }
                if (ElytraPlusModule.INSTANCE.getPitchControl() && EventPacketHelper2.INSTANCE.checkCondition()) {
                } else {
                }
            }
        }
        (((SharedKt.getPlayer().method_36455() / 90.0D) * ElytraPlusModule.INSTANCE.getUpSpeed()) * Math.signum(SharedKt.getPlayer().field_3913.method_3128().field_1342)).setY((0.0D - (0.08D * ElytraPlusModule.INSTANCE.getDownFactor())));
        e.setZ(var27[1]);
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
