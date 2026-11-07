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
        factorValue = SharedKt.getPlayer().method_36454();
        factorValue2 = SharedKt.getPlayer().method_36455();
        SharedKt.getPlayer().method_36456(this.computeValue());
        if (!(ElytraPlusModule.INSTANCE.getPitchControl())) {
            SharedKt.getPlayer().method_36457(0.0F);
        }
        SharedKt.getPlayer().method_36457(this.computeValue());
    }

    public void executeAction(AfterElytraEvent e) {
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
        if (!(this.checkCondition())) {
            if (__UNDEF_KEY__ >= 0) {
                if (ElytraPlusModule.INSTANCE.getStopMove() == ElytraPlusStopMoveMode.BLOCK) {
                    e.cancel();
                    return;
                }
            }
            if (ElytraPlusModule.INSTANCE.getStopMove() == ElytraPlusStopMoveMode.TIMER) {
                ServiceComponent98.INSTANCE.updateValue2(0.05F);
            }
        }
        int index = ItemPacketHelper.INSTANCE.computeValue();
        Item[] items = new Item[1];
        items[0] = Items.FIREWORK_ROCKET;
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
        if (__UNDEF_KEY__ > 0) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (__UNDEF_KEY__ > 0) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (__UNDEF_KEY__ > 0) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (index < 0 || !(stackServiceComponent2.isActive()) || SharedKt.getPlayer().method_5799() || __UNDEF_KEY__ > 0) {
            return;
        }
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (SharedKt.getPlayer().method_6047().method_57353().method_57832(class_9334.field_50075) || __UNDEF_KEY__ >= 0) {
            return;
        }
        if (__UNDEF_KEY__ > 0) {
            if (__UNDEF_KEY__ == null) {
                if (SharedKt.getPlayer().method_6047().method_57353().method_57832(class_9334.field_49651)) {
                    if (__UNDEF_KEY__ > 0) {
                        SharedKt.getMc().options.field_1903.method_23481(true);
                    }
                    RunnableServiceComponent2.executeAction(3, 0, false, this::executeAction);
                    return;
                }
            }
        }
        if (SharedKt.getMc().options.field_1903.method_1434() || __UNDEF_KEY__ >= 0) {
            return;
        }
        if (__UNDEF_KEY__) {
            if (index >= 36) {
                GuiMoveModule.INSTANCE.updateValue(true);
                items = (index - 36);
                HandServiceComponent.executeAction(6, items, class_1713.field_7791, true);
                ElytraSwapModule.INSTANCE.updateValue(true);
                SharedKt.getPlayer().startFallFlying();
                PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
                if (__UNDEF_KEY__ > 0) {
                    if (serviceComponent38.checkCondition(ElytraPlusModule.INSTANCE.getFireworkDelay())) {
                        ElytraTargetModule.INSTANCE.executeAction(ElytraPlusModule.INSTANCE.getOffHandFirework(), ElytraPlusModule.INSTANCE.getAlternativeFireworkSwap());
                    }
                    HandServiceComponent.executeAction(6, items, class_1713.field_7791, true);
                    GuiMoveModule.INSTANCE.updateValue(false);
                }
            } else {
                GuiMoveModule.INSTANCE.updateValue(true);
                HandServiceComponent.e(index, 0, null, false);
                int index2 = 14;
                int index3 = 0;
                int index4 = 0;
                HandServiceComponent.e(6, index4, index3, index2);
                if (__UNDEF_KEY__ >= 0) {
                    if (__UNDEF_KEY__ == null) {
                        if (!(ElytraPlusModule.INSTANCE.getMinimizeClicks())) {
                            HandServiceComponent.e(index, 0, null, true);
                        }
                        ElytraSwapModule.INSTANCE.updateValue(true);
                        SharedKt.getPlayer().startFallFlying();
                        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
                    }
                }
                if (__UNDEF_KEY__ > 0) {
                    if (__UNDEF_KEY__ == null) {
                        if (serviceComponent38.checkCondition(ElytraPlusModule.INSTANCE.getFireworkDelay())) {
                            ElytraTargetModule.INSTANCE.executeAction(ElytraPlusModule.INSTANCE.getOffHandFirework(), ElytraPlusModule.INSTANCE.getAlternativeFireworkSwap());
                        }
                    }
                }
                if (!(ElytraPlusModule.INSTANCE.getMinimizeClicks())) {
                    HandServiceComponent.e(index, 0, null, false);
                }
                HandServiceComponent.e(6, 0, null, false);
                HandServiceComponent.e(index, 0, null, true);
                GuiMoveModule.INSTANCE.updateValue(false);
            }
        }
        SequenceServiceComponent.INSTANCE.executeAction(new MoveFixServiceComponent(this.computeValue(), this.computeValue(), false, OptionMode18.FORCE), 0);
    }

    public void executeAction() {
    }

    public void updateValue() {
    }

    private boolean checkCondition() {
        if (!(SharedKt.getMc().options.field_1894.method_1434()) && !(SharedKt.getMc().options.field_1913.method_1434()) && !(SharedKt.getMc().options.field_1849.method_1434()) && !(SharedKt.getMc().options.field_1881.method_1434()) && !(SharedKt.getMc().options.field_1903.method_1434())) {
            if (SharedKt.getMc().options.field_1832.method_1434()) {
            } else {
            }
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
        e.cancel();
        if (__UNDEF_KEY__ == null) {
            if (FireWorkVectorEvent.INSTANCE.call(SharedKt.getPlayer().method_5720())) {
            } else {
            }
        }
        Vec3d vec = SharedKt.getPlayer().method_5720();
        if (ElytraPlusModule.INSTANCE.getCustomSpeed()) {
            this.updateValue();
        }
        float factor = Math.abs(Math.toDegrees(Math.atan2(vec.field_1351, Math.hypot(vec.field_1352, vec.field_1350))));
        if (__UNDEF_KEY__ == null) {
            if (!(BlinkModule.INSTANCE.getEnabled())) {
                if (__UNDEF_KEY__ == null) {
                    if (!(ElytraPlusModule.INSTANCE.getBoost())) {
                    } else {
                        if (ElytraPlusModule.INSTANCE.getCustomSpeed()) {
                        } else {
                        }
                        Iterable iterable = ((Iterable) ((Map) ElytraTargetModule.INSTANCE.getHashMap()).entrySet());
                        Iterator iterator = iterable.iterator();
                        if (__UNDEF_KEY__ == null) {
                            if (!(iterator.hasNext())) {
                            } else {
                                Object element = iterator.next();
                                if (__UNDEF_KEY__ == null) {
                                    if (!(iterator.hasNext())) {
                                    } else {
                                        Entry entry = ((Entry) element);
                                        int index = 0;
                                        entry = Math.abs((factor - ((Number) entry.getKey())));
                                        index = iterator.next();
                                        Entry entry2 = ((Entry) index);
                                        entry2 = Math.abs((factor - ((Number) entry2.getKey())));
                                        if (Float.compare(entry, entry2) > 0) {
                                            element = index;
                                            entry = entry2;
                                        }
                                    }
                                }
                            }
                        }
                        if (__UNDEF_KEY__ == null) {
                            if (((Entry) element) != null) {
                            } else {
                            }
                        }
                    }
                }
            }
        }
        float factor2 = 0.1F;
        float factor3 = 1.5F;
        e.setVelocity(SharedKt.getPlayer().method_18798().method_1031(((vec.field_1352 * factor2) + (((vec.field_1352 * factor3) - SharedKt.getPlayer().method_18798().field_1352) * 0.5D)), ((vec.field_1351 * factor2) + (((vec.field_1351 * factor3) - SharedKt.getPlayer().method_18798().field_1351) * 0.5D)), ((vec.field_1350 * factor2) + (((vec.field_1350 * factor3) - SharedKt.getPlayer().method_18798().field_1350) * 0.5D))));
    }

    public void onSetPoseEvent(SetPoseEvent e) {
        e.cancel();
        e.setPose(class_4050.field_18076);
    }

    public void executeAction(ReceivePacket e) {
        if (__UNDEF_KEY__ == null) {
        }
        class_6880 class6880 = ((class_2767) e.getPacket()).method_11894();
        if (__UNDEF_KEY__ >= 0L) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (__UNDEF_KEY__ >= 0L) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (__UNDEF_KEY__ > 0L) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (__UNDEF_KEY__ > 0L) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (__UNDEF_KEY__ > 0L) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (__UNDEF_KEY__ >= 0L) {
            if (__UNDEF_KEY__ == null) {
            }
            if (__UNDEF_KEY__ > 0L) {
                if (__UNDEF_KEY__ == null) {
                    if (!(Intrinsics.areEqual(class6880, class_3417.field_14966)) && !(Intrinsics.areEqual(class6880, class_3417.field_21866)) && !(Intrinsics.areEqual(class6880, class_3417.field_15103)) && !(Intrinsics.areEqual(class6880, class_3417.field_14761)) && !(Intrinsics.areEqual(class6880, class_3417.field_14862)) && !(Intrinsics.areEqual(class6880, class_3417.field_14883)) && !(Intrinsics.areEqual(class6880, class_3417.field_15191))) {
                    }
                }
            }
        }
        e.cancel();
    }

    private void updateValue() {
        Pair[] items = new Pair[19];
        items[0] = TuplesKt.to(Float.valueOf(0.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees0()));
        items[1] = TuplesKt.to(Float.valueOf(5.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees5()));
        items[2] = TuplesKt.to(Float.valueOf(10.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees10()));
        items[3] = TuplesKt.to(Float.valueOf(15.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees15()));
        items[4] = TuplesKt.to(Float.valueOf(20.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees20()));
        items[5] = TuplesKt.to(Float.valueOf(25.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees25()));
        items[6] = TuplesKt.to(Float.valueOf(30.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees30()));
        items[7] = TuplesKt.to(Float.valueOf(35.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees35()));
        items[8] = TuplesKt.to(Float.valueOf(40.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees40()));
        items[9] = TuplesKt.to(Float.valueOf(45.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees45()));
        items[10] = TuplesKt.to(Float.valueOf(50.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees50()));
        items[11] = TuplesKt.to(Float.valueOf(55.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees55()));
        items[12] = TuplesKt.to(Float.valueOf(60.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees60()));
        items[13] = TuplesKt.to(Float.valueOf(65.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees65()));
        items[14] = TuplesKt.to(Float.valueOf(70.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees70()));
        items[15] = TuplesKt.to(Float.valueOf(75.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees75()));
        items[16] = TuplesKt.to(Float.valueOf(80.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees80()));
        items[17] = TuplesKt.to(Float.valueOf(85.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees85()));
        items[18] = TuplesKt.to(Float.valueOf(90.0F), Float.valueOf(ElytraPlusModule.INSTANCE.getDegrees90()));
        hashMap = MapsKt.hashMapOf(items);
    }

    private static void executeAction() {
        SharedKt.getMc().options.field_1903.method_23481(false);
    }

    static {
        INSTANCE = new EventPacketHelper3();
        serviceComponent38 = new ServiceComponent38();
        serviceComponent382 = new ServiceComponent38();
        Pair[] items = new Pair[19];
        items[0] = TuplesKt.to(Float.valueOf(0.0F), Float.valueOf(0.155F));
        items[1] = TuplesKt.to(Float.valueOf(5.0F), Float.valueOf(0.16F));
        items[2] = TuplesKt.to(Float.valueOf(10.0F), Float.valueOf(0.19F));
        items[3] = TuplesKt.to(Float.valueOf(15.0F), Float.valueOf(0.22F));
        items[4] = TuplesKt.to(Float.valueOf(20.0F), Float.valueOf(0.22F));
        items[5] = TuplesKt.to(Float.valueOf(25.0F), Float.valueOf(0.27F));
        items[6] = TuplesKt.to(Float.valueOf(30.0F), Float.valueOf(0.28F));
        items[7] = TuplesKt.to(Float.valueOf(35.0F), Float.valueOf(0.34F));
        items[8] = TuplesKt.to(Float.valueOf(40.0F), Float.valueOf(0.37F));
        items[9] = TuplesKt.to(Float.valueOf(45.0F), Float.valueOf(0.37F));
        items[10] = TuplesKt.to(Float.valueOf(50.0F), Float.valueOf(0.34F));
        items[11] = TuplesKt.to(Float.valueOf(55.0F), Float.valueOf(0.34F));
        items[12] = TuplesKt.to(Float.valueOf(60.0F), Float.valueOf(0.2F));
        items[13] = TuplesKt.to(Float.valueOf(65.0F), Float.valueOf(0.18F));
        items[14] = TuplesKt.to(Float.valueOf(70.0F), Float.valueOf(0.16F));
        items[15] = TuplesKt.to(Float.valueOf(75.0F), Float.valueOf(0.16F));
        items[16] = TuplesKt.to(Float.valueOf(80.0F), Float.valueOf(0.13F));
        items[17] = TuplesKt.to(Float.valueOf(85.0F), Float.valueOf(0.13F));
        items[18] = TuplesKt.to(Float.valueOf(90.0F), Float.valueOf(0.13F));
        hashMap = MapsKt.hashMapOf(items);
    }

}
