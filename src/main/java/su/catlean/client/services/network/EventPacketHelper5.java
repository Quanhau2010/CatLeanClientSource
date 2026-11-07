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
        long var4 = (0L ^ 316164599882L);
        long var6 = (0L ^ 101871953768817L);
        long var8 = (0L ^ 2350125969345L);
        long var10 = ((0L ^ 28393686283084L) >>> 48);
        long var11 = (((0L ^ 28393686283084L) << 16) >>> 48);
        long var12 = (((0L ^ 28393686283084L) << 32) >>> 32);
        long var13 = ((0L ^ 34895964612476L) >>> 48);
        long var14 = (((0L ^ 34895964612476L) << 16) >>> 32);
        long var15 = (((0L ^ 34895964612476L) << 48) >>> 48);
        long var16 = (0L ^ 95174287896623L);
        long var18 = (0L ^ 43766790553018L);
        long var20 = (0L ^ 92960854389321L);
        long var22 = (0L ^ 95510200616042L);
        if (ElytraPlusModule.INSTANCE.getTwoBee() && ElytraPlusModule.INSTANCE.getMode() == ElytraPlusMode.BOOST) {
            return;
        }
        if (0L >= 0L) {
            if (var24 == null) {
                if (SharedKt.getPlayer().isOnGround()) {
                    ElytraPlusModule.INSTANCE.updateValue(1);
                }
            }
        }
        if (0L >= 0L) {
            if (var24 == null) {
                if (!(ElytraPlusModule.INSTANCE.getCruiseControl())) {
                    ElytraPlusModule.INSTANCE.updateValue2(SharedKt.getPlayer().getY());
                }
            }
        }
        if (0L >= 0L) {
            if (var24 == null) {
            }
        }
        if (0L >= 0L && var24 == null) {
        }
        if (0L > 0L) {
            if (var24 == null) {
                if (ElytraPlusModule.INSTANCE.isActive() && !(SharedKt.getPlayer().isOnGround()) && EventPacketHelper2.INSTANCE.getNumericValue() > 0.0D && ElytraPlusModule.INSTANCE.getInstantFly()) {
                    ServiceComponent98.INSTANCE.updateValue2(0.3F);
                }
            }
        }
        if (0L >= 0L) {
            if (var24 == null) {
            }
        }
        if (0L > 0L && var24 == null) {
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
        long var6 = ((0L ^ 45640722348789L) >>> 48);
        long var7 = (((0L ^ 45640722348789L) << 16) >>> 32);
        long var8 = (((0L ^ 45640722348789L) << 48) >>> 48);
        long var9 = (0L ^ 8153721749621L);
        long var11 = (0L ^ 83534144421380L);
        long var13 = ((0L ^ 112939991536544L) >>> 48);
        long var14 = (((0L ^ 112939991536544L) << 16) >>> 48);
        long var15 = (((0L ^ 112939991536544L) << 32) >>> 32);
        long var16 = ((0L ^ 74526778099768L) >>> 48);
        long var17 = (((0L ^ 74526778099768L) << 16) >>> 32);
        long var18 = (((0L ^ 74526778099768L) << 48) >>> 48);
        long var19 = ((0L ^ 77382798385104L) >>> 48);
        long var20 = (((0L ^ 77382798385104L) << 16) >>> 32);
        long var21 = (((0L ^ 77382798385104L) << 48) >>> 48);
        long var22 = (0L ^ 138622479516950L);
        long var24 = (0L ^ 1499376952107L);
        long var26 = (0L ^ 102964656663895L);
        long var28 = (0L ^ 74919611406377L);
        long var30 = (0L ^ 16494758083782L);
        long var32 = (0L ^ 102974922985851L);
        long var34 = (0L ^ 101150267987821L);
        long var36 = (0L ^ 44928523577151L);
        long var38 = (0L ^ 138581660526325L);
        long var40 = (0L ^ 16847851849859L);
        long var42 = (0L ^ 61288314464010L);
        long var44 = (0L ^ 14645520927461L);
        if (0L > 0L && var46 == null) {
        }
        if (!(Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA)) || !(SharedKt.getPlayer().isFallFlying()) || SharedKt.getPlayer().method_5799() || SharedKt.getPlayer().method_5771()) {
            return;
        }
        float var47 = SharedKt.getPlayer().field_3913.method_3128().field_1342;
        if (0L >= 0L) {
            if (var46 == null) {
                if (ElytraPlusModule.INSTANCE.getCruiseControl()) {
                    if (0L >= 0L) {
                        if (var46 == null) {
                            if (SharedKt.getMc().options.field_1903.method_1434()) {
                                float var48 = ElytraPlusModule.INSTANCE.getNumericValue2();
                                if (0L > 0L) {
                                    ElytraPlusModule.INSTANCE.updateValue2((var48 + 1.0F));
                                } else {
                                }
                            }
                            if (0L >= 0L) {
                                if (var46 == null) {
                                    if (SharedKt.getMc().options.field_1832.method_1434()) {
                                        var48 = ElytraPlusModule.INSTANCE.getNumericValue2();
                                        ElytraPlusModule.INSTANCE.updateValue2((var48 + -1.0F));
                                    }
                                }
                            }
                        }
                    }
                    if (0L > 0L && var46 == null) {
                        if (ElytraPlusModule.INSTANCE.getForceHeight()) {
                            ElytraPlusModule.INSTANCE.updateValue2(ElytraPlusModule.INSTANCE.getManualHeight());
                        }
                    }
                    if (ElytraPlusModule.INSTANCE.getTwoBee()) {
                        if (0L >= 0L) {
                            if (EventPacketHelper2.INSTANCE.getNumericValue() >= ElytraPlusModule.INSTANCE.getMinUpSpeed()) {
                                SharedKt.getPlayer().method_36457(class_3532.method_15350(class_3532.method_15338(Math.toDegrees(Math.atan2(((ElytraPlusModule.INSTANCE.getNumericValue2() - SharedKt.getPlayer().getY()) * -1.0D), 10.0D))), -50.0D, 50.0D));
                            } else {
                                SharedKt.getPlayer().method_36457(0.25F);
                            }
                        } else {
                            var48 = (1 - Math.sqrt(class_3532.method_15350((EventPacketHelper2.INSTANCE.getNumericValue() / 1.7D), 0.0D, 1.0D)));
                            if (EventPacketHelper2.INSTANCE.getNumericValue() >= ElytraPlusModule.INSTANCE.getMinUpSpeed() && ElytraPlusModule.INSTANCE.getServiceComponent10().checkCondition((2000 * ElytraPlusModule.INSTANCE.getRedeployInterval()))) {
                                double var50 = ((44.4D * var48) + 0.6D);
                                if (0L > 0L) {
                                    float var52 = (((ElytraPlusModule.INSTANCE.getNumericValue2() + 1) - SharedKt.getPlayer().getY()) * 2);
                                    double var54 = (Math.toDegrees(Math.atan2(Math.abs(), (EventPacketHelper2.INSTANCE.getNumericValue() * 30.0D))) * Math.signum());
                                    SharedKt.getPlayer().method_36457((var50 + ((var54 - var50) * class_3532.method_15350(Math.abs(), 0.0D, 1.0D))));
                                } else {
                                    SharedKt.getPlayer().method_36457(0.25F);
                                    var47 = 1.0F;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (0L > 0L) {
            if (var46 == null) {
                if (ElytraPlusModule.INSTANCE.getTwoBee()) {
                }
            }
            if (0L > 0L && var46 == null) {
            }
            if (!(SharedKt.getMc().options.field_1903.method_1434()) && ElytraPlusModule.INSTANCE.getOnlySpace()) {
                if (ElytraPlusModule.INSTANCE.getCruiseControl()) {
                }
                var48 = this.process(null, EventPacketHelper2.INSTANCE, (ElytraPlusModule.INSTANCE.getFactor() / 10.0D));
                e.setX((e.getX() + var48[0]));
                e.setZ((e.getZ() + var48[1]));
                if (0L >= 0L) {
                    e.setY((e.getY() + 0.003D));
                } else {
                    var48 = SharedKt.getPlayer().method_5828(PolygonShaderComponent.INSTANCE.computeValue());
                    double var49 = Math.hypot(var48.field_1352, var48.field_1350);
                    double var51 = Math.hypot(e.getX(), e.getZ());
                    double var53 = (Math.pow(Math.cos(Math.toRadians(SharedKt.getPlayer().method_36455())), 2.0D) * Math.min(1.0D, (var48.method_1033() / 0.4D)));
                    e.setY((e.getY() + (-0.08D + (var53 * 0.06D))));
                    if (0L > 0L) {
                        if (var46 == null) {
                            if (e.getY() < 0.0D && var49 > 0.0D) {
                                var54 = ((e.getY() * -0.1D) * var53);
                                e.setY((e.getY() + var54));
                                e.setX((e.getX() + ((var48.field_1352 * var54) / var49)));
                                e.setZ((e.getZ() + ((var48.field_1350 * var54) / var49)));
                            }
                        }
                    }
                    if (0L >= 0L) {
                        if (var46 == null) {
                            if (SharedKt.getPlayer().method_36455() < 0.0F) {
                                var54 = ((var51 * Math.sin(Math.toRadians(SharedKt.getPlayer().method_36455()))) * 0.04D);
                                e.setY((e.getY() + (var54 * 3.2D)));
                                e.setX((e.getX() - ((var48.field_1352 * var54) / var49)));
                                e.setZ((e.getZ() - ((var48.field_1350 * var54) / var49)));
                            }
                        }
                    }
                    if (0L > 0L) {
                        if (var46 == null) {
                            if (var49 > 0.0D) {
                                e.setX((e.getX() + ((((var48.field_1352 / var49) * var51) - e.getX()) * 0.1D)));
                                e.setZ((e.getZ() + ((((var48.field_1350 / var49) * var51) - e.getZ()) * 0.1D)));
                            }
                        }
                        if (0L >= 0L) {
                        }
                        if (0L > 0L) {
                        }
                        if (0L >= 0L) {
                        }
                        if (0L > 0L) {
                            if (var46 == null) {
                            }
                        }
                        if (0L >= 0L) {
                            if (var47 != 0.0F) {
                            }
                            if (ElytraPlusModule.INSTANCE.getServiceComponent10().checkCondition((2000 * ElytraPlusModule.INSTANCE.getRedeployInterval()))) {
                                if (0L >= 0L) {
                                    if (serviceComponent10.checkCondition((1000 * ElytraPlusModule.INSTANCE.getRedeployTimeOut()))) {
                                        if (0L > 0L) {
                                            if (ElytraPlusModule.INSTANCE.getStopMotion()) {
                                                e.setX(0.0D);
                                                e.setZ(0.0D);
                                            }
                                        }
                                        ElytraPlusModule.INSTANCE.getServiceComponent10().executeAction();
                                        PacketPacketHelper.handlePacket((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982));
                                        if (0L > 0L) {
                                        }
                                    }
                                }
                            } else {
                            }
                            if (SharedKt.getPlayer().method_36455() > 0.0F && e.getY() < 0.0D && ElytraPlusModule.INSTANCE.checkCondition() && !(ElytraPlusModule.INSTANCE.getServiceComponent10().checkCondition((2000 * ElytraPlusModule.INSTANCE.getRedeployInterval())))) {
                                e.setX((e.getX() - (((var47 * Math.sin(Math.toRadians(SharedKt.getPlayer().method_36454()))) * ElytraPlusModule.INSTANCE.getFactor()) / 20.0F)));
                                e.setZ((e.getZ() + (((var47 * Math.cos(Math.toRadians(SharedKt.getPlayer().method_36454()))) * ElytraPlusModule.INSTANCE.getFactor()) / 20.0F)));
                                serviceComponent10.executeAction();
                            }
                        }
                    }
                }
            }
        }
        }
        }
        }
        var48 = Math.hypot(e.getX(), e.getZ());
        if (ElytraPlusModule.INSTANCE.getSpeedLimit() && var48 > ElytraPlusModule.INSTANCE.getMaxSpeed()) {
            e.setX(((e.getX() * ElytraPlusModule.INSTANCE.getMaxSpeed()) / var48));
            e.setZ(((e.getZ() * ElytraPlusModule.INSTANCE.getMaxSpeed()) / var48));
        }
        SharedKt.getPlayer().method_18800(e.getX(), e.getY(), e.getZ());
        e.cancel();
    }

    public void executeAction(AfterSendPacket event) {
    }

    public void executeAction(ReceivePacket e) {
    }

    public void executeAction(PlayerUpdateEvent e) {
        int var5 = (((0L << 32) | ((0L << 48) >>> 32)) | ((0L << 48) >>> 48));
        long var7 = ((var5 ^ 15077302398524L) >>> 48);
        long var8 = (((var5 ^ 15077302398524L) << 16) >>> 32);
        long var9 = (((var5 ^ 15077302398524L) << 48) >>> 48);
        long var10 = (var5 ^ 75341532821871L);
        long var12 = ((var5 ^ 129924746353958L) >>> 48);
        long var13 = (((var5 ^ 129924746353958L) << 16) >>> 32);
        long var14 = (((var5 ^ 129924746353958L) << 48) >>> 48);
        long var15 = (var5 ^ 50723236875816L);
        long var17 = (var5 ^ 75690733423914L);
        if (0L >= 0) {
            if (var19 == null) {
            }
            if (0L > 0) {
            }
            if (ElytraPlusModule.INSTANCE.getTwoBee() && ServiceComponent13.checkCondition(ElytraPlusModule.INSTANCE.getLift().getNumericValue()) && EventPacketHelper2.INSTANCE.getNumericValue() > 0.0D) {
            }
            if (!(SharedKt.getPlayer().isFallFlying())) {
                ElytraSwapModule.INSTANCE.updateValue(1);
                PacketPacketHelper.handlePacket((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982));
                SharedKt.getPlayer().startFallFlying();
            }
            double var20 = (0.05D * Math.min(((SharedKt.getNumericValue() - serviceComponent102.getNumericValue()) / 100.0F), 1.0F));
            SharedKt.getPlayer().method_18800(0.0D, Math.min((SharedKt.getPlayer().method_18798().field_1351 + var20), 1.0D), 0.0D);
        } else {
            serviceComponent102.executeAction();
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
        long var4 = ((0L ^ 59472532531468L) >>> 48);
        long var5 = (((0L ^ 59472532531468L) << 16) >>> 32);
        long var6 = (((0L ^ 59472532531468L) << 48) >>> 48);
        long var7 = (0L ^ 121069188053506L);
        long var9 = (0L ^ 5404917577984L);
        if (0L >= 0L) {
            if (var11 == null) {
            }
        }
        if (0L >= 0L && var11 == null) {
        }
        e.cancel();
    }

    static {
        INSTANCE = new EventPacketHelper5();
        serviceComponent10 = new ServiceComponent10();
        serviceComponent102 = new ServiceComponent10();
    }

}
