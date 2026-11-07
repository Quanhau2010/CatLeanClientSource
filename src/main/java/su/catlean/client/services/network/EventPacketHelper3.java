package su.catlean.client.services.network;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1713;
import net.minecraft.class_2767;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_3417;
import net.minecraft.class_4050;
import net.minecraft.class_6880;
import net.minecraft.class_9323;
import net.minecraft.class_9334;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.item.Item;
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
import su.catlean.api.event.events.world.FireWorkVectorEvent;
import su.catlean.api.event.events.world.FireWorkVelocityEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.features.modules.movement.rage.BlinkModule;
import su.catlean.client.features.modules.movement.rage.ElytraPlusModule;
import su.catlean.client.features.modules.movement.rage.ElytraPlusStopMoveMode;
import su.catlean.client.features.modules.movement.rage.ElytraTargetModule;
import su.catlean.client.features.modules.utility.equip.ElytraSwapModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent2;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.types.OptionMode18;

public class EventPacketHelper3 implements Contract6 {

    public static final EventPacketHelper3 INSTANCE;
    private static float factorValue;
    private static float factorValue2;
    private static final ServiceComponent38 serviceComponent38;
    private static final ServiceComponent38 serviceComponent382;
    private static HashMap hashMap;

    private EventPacketHelper3() {
    }

    public void executeAction(PreSyncEvent e) {
    }

    public void executeAction(PreElytraEvent e) {
        long var4 = (0L ^ 11101687657869L);
        long var6 = (0L ^ 139945243846052L);
        long var8 = (0L ^ 79805115683167L);
        long var10 = ((0L ^ 56085832421177L) >>> 48);
        long var11 = (((0L ^ 56085832421177L) << 16) >>> 32);
        long var12 = (((0L ^ 56085832421177L) << 48) >>> 48);
        factorValue = SharedKt.getPlayer().method_36454();
        factorValue2 = SharedKt.getPlayer().method_36455();
        SharedKt.getPlayer().method_36456(this.computeValue());
        if (!(ElytraPlusModule.INSTANCE.getPitchControl())) {
            SharedKt.getPlayer().method_36457(0.0F);
        }
        SharedKt.getPlayer().method_36457(this.computeValue());
    }

    public void executeAction(AfterElytraEvent e) {
        long var4 = (0L ^ 18213801518595L);
        SharedKt.getPlayer().method_36456(factorValue);
        SharedKt.getPlayer().method_36457(factorValue2);
    }

    public void executeAction(MoveEvent e) {
    }

    public void executeAction(AfterSendPacket event) {
    }

    public void executeAction(ReceivePacket e) {
    }

    public void executeAction(PlayerUpdateEvent e) {
        int var5 = (((0L << 32) | ((0L << 48) >>> 32)) | ((0L << 48) >>> 48));
        long var7 = (var5 ^ 110443321443084L);
        long var9 = (var5 ^ 50328728142976L);
        long var11 = ((var5 ^ 41345190240954L) >>> 32);
        long var12 = (((var5 ^ 41345190240954L) << 32) >>> 48);
        long var13 = (((var5 ^ 41345190240954L) << 48) >>> 48);
        long var14 = (var5 ^ 63995293181256L);
        long var16 = (var5 ^ 114086189244075L);
        long var18 = (var5 ^ 25966103532184L);
        long var20 = (var5 ^ 21941179117163L);
        long var22 = (var5 ^ 126467566025169L);
        long var24 = (var5 ^ 119142936620191L);
        long var26 = (var5 ^ 75690733423914L);
        long var28 = (var5 ^ 18593605143838L);
        long var30 = ((var5 ^ 69546472592204L) >>> 48);
        long var31 = (((var5 ^ 69546472592204L) << 16) >>> 32);
        long var32 = (((var5 ^ 69546472592204L) << 48) >>> 48);
        long var33 = (var5 ^ 10219090097811L);
        long var35 = (var5 ^ 17349872559412L);
        long var37 = (var5 ^ 102152613699867L);
        long var39 = (var5 ^ 113945537659848L);
        long var41 = ((var5 ^ 32884685514560L) >>> 48);
        long var42 = (((var5 ^ 32884685514560L) << 16) >>> 16);
        long var44 = (var5 ^ 95440221422403L);
        long var46 = (var5 ^ 70964958371721L);
        long var48 = (var5 ^ 75341532821871L);
        long var50 = (var5 ^ 136402819029944L);
        long var52 = (var5 ^ 89099754289359L);
        if (!(this.checkCondition())) {
            if (0L >= 0) {
                if (ElytraPlusModule.INSTANCE.getStopMove() == ElytraPlusStopMoveMode.BLOCK) {
                    e.cancel();
                    return;
                }
            }
            if (ElytraPlusModule.INSTANCE.getStopMove() == ElytraPlusStopMoveMode.TIMER) {
                ServiceComponent98.INSTANCE.updateValue2(0.05F);
            }
        }
        int var60 = ItemPacketHelper.INSTANCE.computeValue();
        Item[] var62 = new Item[1];
        var62[0] = Items.FIREWORK_ROCKET;
        StackServiceComponent2 var61 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        if (0L > 0) {
            if (var59 == null) {
            }
        }
        if (0L > 0) {
            if (var59 == null) {
            }
        }
        if (0L > 0) {
            if (var59 == null) {
            }
        }
        if (var60 < 0 || !(var61.isActive()) || SharedKt.getPlayer().method_5799() || 0L > 0) {
            return;
        }
        if (0L >= 0) {
            if (var59 == null) {
            }
        }
        if (SharedKt.getPlayer().method_6047().method_57353().method_57832(class_9334.field_50075) || 0L >= 0) {
            return;
        }
        if (0L > 0) {
            if (var59 == null) {
                if (SharedKt.getPlayer().method_6047().method_57353().method_57832(class_9334.field_49651)) {
                    if (0L > 0) {
                        SharedKt.getMc().options.field_1903.method_23481(1);
                    }
                    RunnableServiceComponent2.executeAction(3, 0, 0, this::executeAction);
                    return;
                }
            }
        }
        if (SharedKt.getMc().options.field_1903.method_1434() || 0L >= 0) {
            return;
        }
        if (var59) {
            if (var60 >= 36) {
                GuiMoveModule.INSTANCE.updateValue(1);
                var62 = (var60 - 36);
                HandServiceComponent.executeAction(6, class_1713.field_7791, 1);
                ElytraSwapModule.INSTANCE.updateValue(1);
                SharedKt.getPlayer().startFallFlying();
                PacketPacketHelper.handlePacket((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982));
                if (0L > 0) {
                    if (serviceComponent38.checkCondition(ElytraPlusModule.INSTANCE.getFireworkDelay())) {
                        ElytraTargetModule.INSTANCE.executeAction(ElytraPlusModule.INSTANCE.getOffHandFirework(), ElytraPlusModule.INSTANCE.getAlternativeFireworkSwap());
                    }
                    HandServiceComponent.executeAction(6, class_1713.field_7791, 1);
                    GuiMoveModule.INSTANCE.updateValue(0);
                }
            } else {
                GuiMoveModule.INSTANCE.updateValue(1);
                HandServiceComponent.e();
                int var55 = 14;
                int var56 = 0;
                int var58 = 0;
                HandServiceComponent.e();
                if (0L >= 0) {
                    if (var59 == null) {
                        if (!(ElytraPlusModule.INSTANCE.getMinimizeClicks())) {
                            HandServiceComponent.e();
                        }
                        ElytraSwapModule.INSTANCE.updateValue(1);
                        SharedKt.getPlayer().startFallFlying();
                        PacketPacketHelper.handlePacket((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982));
                    }
                }
                if (0L > 0) {
                    if (var59 == null) {
                        if (serviceComponent38.checkCondition(ElytraPlusModule.INSTANCE.getFireworkDelay())) {
                            ElytraTargetModule.INSTANCE.executeAction(ElytraPlusModule.INSTANCE.getOffHandFirework(), ElytraPlusModule.INSTANCE.getAlternativeFireworkSwap());
                        }
                    }
                }
                if (!(ElytraPlusModule.INSTANCE.getMinimizeClicks())) {
                    HandServiceComponent.e();
                }
                HandServiceComponent.e();
                HandServiceComponent.e();
                GuiMoveModule.INSTANCE.updateValue(0);
            }
        }
        SequenceServiceComponent.INSTANCE.executeAction(new MoveFixServiceComponent(this.computeValue(), this.computeValue(), 0, OptionMode18.FORCE), 0);
    }

    public void executeAction() {
    }

    public void updateValue() {
    }

    private boolean checkCondition() {
        if (!(SharedKt.getMc().options.field_1894.method_1434()) && !(SharedKt.getMc().options.field_1913.method_1434()) && !(SharedKt.getMc().options.field_1849.method_1434()) && !(SharedKt.getMc().options.field_1881.method_1434()) && !(SharedKt.getMc().options.field_1903.method_1434())) {
            if (SharedKt.getMc().options.field_1832.method_1434()) {
            }
        } else {
        }
        return false;
    }

    private float computeValue() {
        return EventPacketHelper2.INSTANCE.computeValue();
    }

    private float computeValue() {
        if (SharedKt.getMc().options.field_1903.method_1434()) {
        } else {
            if (SharedKt.getMc().options.field_1832.method_1434()) {
            } else {
                if (!(ElytraPlusModule.INSTANCE.getPitchControl())) {
                } else {
                }
            }
        }
        return SharedKt.getPlayer().method_36455();
    }

    public void executeAction(FireWorkVelocityEvent e) {
        long var4 = (0L ^ 41654020828972L);
        long var6 = (0L ^ 42411159857622L);
        long var8 = (0L ^ 10903048792458L);
        long var10 = (0L ^ 49306664467385L);
        long var12 = (0L ^ 87862280744679L);
        e.cancel();
        if (var14 == null) {
            if (FireWorkVectorEvent.INSTANCE.call(SharedKt.getPlayer().method_5720())) {
            }
        } else {
        }
        Vec3d vec = SharedKt.getPlayer().method_5720();
        if (0L > 0L && ElytraPlusModule.INSTANCE.getCustomSpeed()) {
            this.updateValue();
        }
        float var16 = Math.abs(Math.toDegrees(Math.atan2(vec.field_1351, Math.hypot(vec.field_1352, vec.field_1350))));
        if (0L >= 0L) {
            if (var14 == null) {
                if (!(BlinkModule.INSTANCE.getEnabled())) {
                }
            }
            if (0L > 0L && var14 == null) {
                if (!(ElytraPlusModule.INSTANCE.getBoost())) {
                }
            } else {
            }
            if (ElytraPlusModule.INSTANCE.getCustomSpeed()) {
            } else {
            }
            Iterable var19 = (Iterable) (Map) ElytraTargetModule.INSTANCE.getHashMap().entrySet();
            Iterator iterator = var19.iterator();
            if (var14 == null) {
                if (!(iterator.hasNext())) {
                } else {
                }
                Object var21 = iterator.next();
                if (var14 == null) {
                    if (!(iterator.hasNext())) {
                    } else {
                    }
                    Entry var22 = (Entry) var21;
                    int var23 = 0;
                    var22 = Math.abs((var16 - (Number) var22.getKey()));
                    var23 = iterator.next();
                    Entry var24 = (Entry) var23;
                    int var25 = 0;
                    var24 = Math.abs((var16 - (Number) var24.getKey()));
                    if (Float.compare() > 0) {
                        var21 = var23;
                        var22 = var24;
                    }
                }
            }
            if (var14 == null) {
                if ((Entry) var21 != null) {
                }
            } else {
            }
        }
        float var17 = 0.1F;
        float var18 = 1.5F;
        e.setVelocity(SharedKt.getPlayer().method_18798().method_1031(((vec.field_1352 * var17) + (((vec.field_1352 * var18) - SharedKt.getPlayer().method_18798().field_1352) * 0.5D)), ((vec.field_1351 * var17) + (((vec.field_1351 * var18) - SharedKt.getPlayer().method_18798().field_1351) * 0.5D)), ((vec.field_1350 * var17) + (((vec.field_1350 * var18) - SharedKt.getPlayer().method_18798().field_1350) * 0.5D))));
    }

    public void onSetPoseEvent(SetPoseEvent e) {
        e.cancel();
        e.setPose(class_4050.field_18076);
    }

    public void executeAction(ReceivePacket e) {
        if (var4 == null) {
        }
        class_6880 var5 = (class_2767) e.getPacket().method_11894();
        if (0L >= 0L) {
            if (var4 == null) {
            }
        }
        if (0L >= 0L) {
            if (var4 == null) {
            }
        }
        if (0L > 0L) {
            if (var4 == null) {
            }
        }
        if (0L > 0L) {
            if (var4 == null) {
            }
        }
        if (0L > 0L) {
            if (var4 == null) {
            }
        }
        if (0L >= 0L) {
            if (var4 == null) {
            }
            if (0L > 0L) {
            }
            if (var4 == null) {
                if (!(Intrinsics.areEqual(class_3417.field_14966)) && !(Intrinsics.areEqual(class_3417.field_21866)) && !(Intrinsics.areEqual(class_3417.field_15103)) && !(Intrinsics.areEqual(class_3417.field_14761)) && !(Intrinsics.areEqual(class_3417.field_14862)) && !(Intrinsics.areEqual(class_3417.field_14883)) && !(Intrinsics.areEqual(class_3417.field_15191))) {
                }
            }
        }
        e.cancel();
    }

    private void updateValue() {
        Pair[] var47 = new Pair[19];
        var47[0] = TuplesKt.to(Float.valueOf(0.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees0()));
        var47[1] = TuplesKt.to(Float.valueOf(5.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees5()));
        var47[2] = TuplesKt.to(Float.valueOf(10.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees10()));
        var47[3] = TuplesKt.to(Float.valueOf(15.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees15()));
        var47[4] = TuplesKt.to(Float.valueOf(20.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees20()));
        var47[5] = TuplesKt.to(Float.valueOf(25.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees25()));
        var47[6] = TuplesKt.to(Float.valueOf(30.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees30()));
        var47[7] = TuplesKt.to(Float.valueOf(35.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees35()));
        var47[8] = TuplesKt.to(Float.valueOf(40.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees40()));
        var47[9] = TuplesKt.to(Float.valueOf(45.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees45()));
        var47[10] = TuplesKt.to(Float.valueOf(50.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees50()));
        var47[11] = TuplesKt.to(Float.valueOf(55.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees55()));
        var47[12] = TuplesKt.to(Float.valueOf(60.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees60()));
        var47[13] = TuplesKt.to(Float.valueOf(65.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees65()));
        var47[14] = TuplesKt.to(Float.valueOf(70.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees70()));
        var47[15] = TuplesKt.to(Float.valueOf(75.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees75()));
        var47[16] = TuplesKt.to(Float.valueOf(80.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees80()));
        var47[17] = TuplesKt.to(Float.valueOf(85.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees85()));
        var47[18] = TuplesKt.to(Float.valueOf(90.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees90()));
        hashMap = MapsKt.hashMapOf();
    }

    private static void executeAction() {
        SharedKt.getMc().options.field_1903.method_23481(0);
    }

    static {
        INSTANCE = new EventPacketHelper3();
        serviceComponent38 = new ServiceComponent38();
        serviceComponent382 = new ServiceComponent38();
        Pair[] var24 = new Pair[19];
        var24[0] = TuplesKt.to(Float.valueOf(0.0F), Float.valueOf(0.155F));
        var24[1] = TuplesKt.to(Float.valueOf(5.0F), Float.valueOf(0.16F));
        var24[2] = TuplesKt.to(Float.valueOf(10.0F), Float.valueOf(0.19F));
        var24[3] = TuplesKt.to(Float.valueOf(15.0F), Float.valueOf(0.22F));
        var24[4] = TuplesKt.to(Float.valueOf(20.0F), Float.valueOf(0.22F));
        var24[5] = TuplesKt.to(Float.valueOf(25.0F), Float.valueOf(0.27F));
        var24[6] = TuplesKt.to(Float.valueOf(30.0F), Float.valueOf(0.28F));
        var24[7] = TuplesKt.to(Float.valueOf(35.0F), Float.valueOf(0.34F));
        var24[8] = TuplesKt.to(Float.valueOf(40.0F), Float.valueOf(0.37F));
        var24[9] = TuplesKt.to(Float.valueOf(45.0F), Float.valueOf(0.37F));
        var24[10] = TuplesKt.to(Float.valueOf(50.0F), Float.valueOf(0.34F));
        var24[11] = TuplesKt.to(Float.valueOf(55.0F), Float.valueOf(0.34F));
        var24[12] = TuplesKt.to(Float.valueOf(60.0F), Float.valueOf(0.2F));
        var24[13] = TuplesKt.to(Float.valueOf(65.0F), Float.valueOf(0.18F));
        var24[14] = TuplesKt.to(Float.valueOf(70.0F), Float.valueOf(0.16F));
        var24[15] = TuplesKt.to(Float.valueOf(75.0F), Float.valueOf(0.16F));
        var24[16] = TuplesKt.to(Float.valueOf(80.0F), Float.valueOf(0.13F));
        var24[17] = TuplesKt.to(Float.valueOf(85.0F), Float.valueOf(0.13F));
        var24[18] = TuplesKt.to(Float.valueOf(90.0F), Float.valueOf(0.13F));
        hashMap = MapsKt.hashMapOf();
    }

}
