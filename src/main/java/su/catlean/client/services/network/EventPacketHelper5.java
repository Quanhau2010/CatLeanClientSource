package su.catlean.client.services.network;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1661;
import net.minecraft.class_2739;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_3532;
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
import su.catlean.client.features.modules.movement.rage.ElytraPlusMode;
import su.catlean.client.features.modules.movement.rage.ElytraPlusModule;
import su.catlean.client.features.modules.utility.equip.ElytraSwapModule;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class EventPacketHelper5 implements Contract6 {

    public static final EventPacketHelper5 INSTANCE;
    private static final ServiceComponent10 serviceComponent10;
    private static final ServiceComponent10 serviceComponent102;

    private EventPacketHelper5() {
    }

    public ServiceComponent10 getServiceComponent10() {
        return serviceComponent10;
    }

    public void executeAction(PreSyncEvent e) {
        if (ElytraPlusModule.INSTANCE.getTwoBee() && ElytraPlusModule.INSTANCE.getMode() == ElytraPlusMode.BOOST) {
            return;
        }
        if (SharedKt.getPlayer().isOnGround()) {
            ElytraPlusModule.INSTANCE.updateValue(true);
        }
        if (!(ElytraPlusModule.INSTANCE.getCruiseControl())) {
            ElytraPlusModule.INSTANCE.updateValue2(SharedKt.getPlayer().getY());
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
        if (!(Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA)) || !(SharedKt.getPlayer().isFallFlying()) || SharedKt.getPlayer().method_5799() || SharedKt.getPlayer().method_5771()) {
            return;
        }
        float factor = SharedKt.getPlayer().field_3913.method_3128().field_1342;
        if (ElytraPlusModule.INSTANCE.getCruiseControl()) {
            if (SharedKt.getMc().options.field_1903.method_1434()) {
                float factor2 = ElytraPlusModule.INSTANCE.getNumericValue2();
                ElytraPlusModule.INSTANCE.updateValue2((factor2 + 1.0F));
            } else {
                if (SharedKt.getMc().options.field_1832.method_1434()) {
                    factor2 = ElytraPlusModule.INSTANCE.getNumericValue2();
                    ElytraPlusModule.INSTANCE.updateValue2((factor2 + -1.0F));
                }
            }
            if (ElytraPlusModule.INSTANCE.getForceHeight()) {
                ElytraPlusModule.INSTANCE.updateValue2(ElytraPlusModule.INSTANCE.getManualHeight());
            }
            if (ElytraPlusModule.INSTANCE.getTwoBee()) {
                if (EventPacketHelper2.INSTANCE.getNumericValue() >= ElytraPlusModule.INSTANCE.getMinUpSpeed()) {
                    SharedKt.getPlayer().method_36457(class_3532.method_15350(class_3532.method_15338(Math.toDegrees(Math.atan2(((ElytraPlusModule.INSTANCE.getNumericValue2() - SharedKt.getPlayer().getY()) * -1.0D), 10.0D))), -50.0D, 50.0D));
                } else {
                    SharedKt.getPlayer().method_36457(0.25F);
                    factor2 = (1 - Math.sqrt(class_3532.method_15350((EventPacketHelper2.INSTANCE.getNumericValue() / 1.7D), 0.0D, 1.0D)));
                    if (EventPacketHelper2.INSTANCE.getNumericValue() >= ElytraPlusModule.INSTANCE.getMinUpSpeed() && ElytraPlusModule.INSTANCE.getServiceComponent10().checkCondition((2000 * ElytraPlusModule.INSTANCE.getRedeployInterval()))) {
                        double offset = ((44.4D * factor2) + 0.6D);
                        float factor3 = (((ElytraPlusModule.INSTANCE.getNumericValue2() + 1) - SharedKt.getPlayer().getY()) * 2);
                        double offset2 = (Math.toDegrees(Math.atan2(Math.abs(factor3), (EventPacketHelper2.INSTANCE.getNumericValue() * 30.0D))) * Math.signum(factor3));
                        SharedKt.getPlayer().method_36457((offset + ((offset2 - offset) * class_3532.method_15350(Math.abs(factor3), 0.0D, 1.0D))));
                    } else {
                        SharedKt.getPlayer().method_36457(0.25F);
                        factor = 1.0F;
                    }
                }
            } else {
            }
        }
        if (ElytraPlusModule.INSTANCE.getTwoBee()) {
            if (!(SharedKt.getMc().options.field_1903.method_1434()) && ElytraPlusModule.INSTANCE.getOnlySpace()) {
                if (ElytraPlusModule.INSTANCE.getCruiseControl()) {
                    factor2 = this.process(null, EventPacketHelper2.INSTANCE, (ElytraPlusModule.INSTANCE.getFactor() / 10.0D));
                    e.setX((e.getX() + factor2[0]));
                    e.setZ((e.getZ() + factor2[1]));
                    e.setY((e.getY() + 0.003D));
                    factor2 = SharedKt.getPlayer().method_5828(PolygonShaderComponent.INSTANCE.computeValue());
                    double offset3 = Math.hypot(factor2.field_1352, factor2.field_1350);
                    double offset4 = Math.hypot(e.getX(), e.getZ());
                    double offset5 = (Math.pow(Math.cos(Math.toRadians(SharedKt.getPlayer().method_36455())), 2.0D) * Math.min(1.0D, (factor2.method_1033() / 0.4D)));
                    e.setY((e.getY() + (-0.08D + (offset5 * 0.06D))));
                    if (e.getY() < 0.0D && offset3 > 0.0D) {
                        offset2 = ((e.getY() * -0.1D) * offset5);
                        e.setY((e.getY() + offset2));
                        e.setX((e.getX() + ((factor2.field_1352 * offset2) / offset3)));
                        e.setZ((e.getZ() + ((factor2.field_1350 * offset2) / offset3)));
                    }
                    if (SharedKt.getPlayer().method_36455() < 0.0F) {
                        offset2 = ((offset4 * Math.sin(Math.toRadians(SharedKt.getPlayer().method_36455()))) * 0.04D);
                        e.setY((e.getY() + (offset2 * 3.2D)));
                        e.setX((e.getX() - ((factor2.field_1352 * offset2) / offset3)));
                        e.setZ((e.getZ() - ((factor2.field_1350 * offset2) / offset3)));
                    }
                    if (offset3 > 0.0D) {
                        e.setX((e.getX() + ((((factor2.field_1352 / offset3) * offset4) - e.getX()) * 0.1D)));
                        e.setZ((e.getZ() + ((((factor2.field_1350 / offset3) * offset4) - e.getZ()) * 0.1D)));
                    }
                    if (factor != 0.0F) {
                        if (ElytraPlusModule.INSTANCE.getServiceComponent10().checkCondition((2000 * ElytraPlusModule.INSTANCE.getRedeployInterval()))) {
                            if (serviceComponent10.checkCondition((1000 * ElytraPlusModule.INSTANCE.getRedeployTimeOut()))) {
                                if (ElytraPlusModule.INSTANCE.getStopMotion()) {
                                    e.setX(0.0D);
                                    e.setZ(0.0D);
                                }
                                ElytraPlusModule.INSTANCE.getServiceComponent10().executeAction();
                                PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
                            } else {
                                if (SharedKt.getPlayer().method_36455() > 0.0F && e.getY() < 0.0D && ElytraPlusModule.INSTANCE.checkCondition() && !(ElytraPlusModule.INSTANCE.getServiceComponent10().checkCondition((2000 * ElytraPlusModule.INSTANCE.getRedeployInterval())))) {
                                    e.setX((e.getX() - (((factor * Math.sin(Math.toRadians(SharedKt.getPlayer().method_36454()))) * ElytraPlusModule.INSTANCE.getFactor()) / 20.0F)));
                                    e.setZ((e.getZ() + (((factor * Math.cos(Math.toRadians(SharedKt.getPlayer().method_36454()))) * ElytraPlusModule.INSTANCE.getFactor()) / 20.0F)));
                                    serviceComponent10.executeAction();
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                }
            }
        } else {
        }
        factor2 = Math.hypot(e.getX(), e.getZ());
        if (ElytraPlusModule.INSTANCE.getSpeedLimit() && factor2 > ElytraPlusModule.INSTANCE.getMaxSpeed()) {
            e.setX(((e.getX() * ElytraPlusModule.INSTANCE.getMaxSpeed()) / factor2));
            e.setZ(((e.getZ() * ElytraPlusModule.INSTANCE.getMaxSpeed()) / factor2));
        }
        SharedKt.getPlayer().method_18800(e.getX(), e.getY(), e.getZ());
        e.cancel();
    }

    public void executeAction(AfterSendPacket event) {
    }

    public void executeAction(ReceivePacket e) {
    }

    public void executeAction(PlayerUpdateEvent e) {
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ == null) {
            }
            if (__UNDEF_KEY__ > 0) {
                if (ElytraPlusModule.INSTANCE.getTwoBee() && ServiceComponent13.checkCondition(ElytraPlusModule.INSTANCE.getLift().getNumericValue()) && EventPacketHelper2.INSTANCE.getNumericValue() > 0.0D) {
                    if (!(SharedKt.getPlayer().isFallFlying())) {
                        ElytraSwapModule.INSTANCE.updateValue(true);
                        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
                        SharedKt.getPlayer().startFallFlying();
                    }
                    double offset = (0.05D * Math.min(((SharedKt.getNumericValue() - serviceComponent102.getNumericValue()) / 100.0F), 1.0F));
                    SharedKt.getPlayer().method_18800(0.0D, Math.min((SharedKt.getPlayer().method_18798().field_1351 + offset), 1.0D), 0.0D);
                } else {
                    serviceComponent102.executeAction();
                }
            }
        }
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
        e.cancel();
    }

    static {
        INSTANCE = new EventPacketHelper5();
        serviceComponent10 = new ServiceComponent10();
        serviceComponent102 = new ServiceComponent10();
    }

}
