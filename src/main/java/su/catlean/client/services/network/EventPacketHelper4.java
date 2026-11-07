package su.catlean.client.services.network;

import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_241;
import net.minecraft.class_2708;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_744;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
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
import su.catlean.client.features.modules.movement.rage.ElytraPlusAntiKickMode;
import su.catlean.client.features.modules.movement.rage.ElytraPlusMode;
import su.catlean.client.features.modules.movement.rage.ElytraPlusModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.player.EntityHelper;
import su.catlean.client.types.mappings.ElytraPlusAntiKickModeWhenMappings;
import su.catlean.mixins.accessors.ClientInputAccessor;

public class EventPacketHelper4 implements Contract6 {

    public static final EventPacketHelper4 INSTANCE;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static float factorValue;
    private static ItemStack itemStack;
    private static ItemStack itemStack2;
    private static Item minecraftRef;
    private static Item minecraftRef2;
    private static int countValue;
    private static int countValue2;

    private EventPacketHelper4() {
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public boolean isActive2() {
        return enabledFlag2;
    }

    public void updateValue2(boolean value) {
        enabledFlag2 = value;
    }

    public float getNumericValue() {
        return factorValue;
    }

    public void updateValue(float value) {
        factorValue = value;
    }

    public ItemStack getMinecraftObject() {
        return itemStack;
    }

    public void updateValue(ItemStack value) {
        itemStack = value;
    }

    public ItemStack getMinecraftObject2() {
        return itemStack2;
    }

    public void updateValue2(ItemStack value) {
        itemStack2 = value;
    }

    public Item getMinecraftObject() {
        return minecraftRef;
    }

    public void executeAction(Item value) {
        minecraftRef = value;
    }

    public Item getMinecraftObject2() {
        return minecraftRef2;
    }

    public void executeAction(Item value) {
        minecraftRef2 = value;
    }

    public int getNumericValue() {
        return countValue;
    }

    public void updateValue(int value) {
        countValue = value;
    }

    public int getNumericValue2() {
        return countValue2;
    }

    public void updateValue2(int value) {
        countValue2 = value;
    }

    public long getNumericValue() {
        return timestampValue;
    }

    public void updateValue(long value) {
        timestampValue = value;
    }

    public void executeAction(PreSyncEvent e) {
        if (__UNDEF_KEY__ == null) {
            if (ElytraPlusModule.INSTANCE.getRotate()) {
                if (SharedKt.getMc().options.field_1903.method_1434()) {
                    if (SharedKt.getPlayer().isFallFlying()) {
                        if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                            if (enabledFlag) {
                                SharedKt.getPlayer().method_36457(-45.0F);
                            }
                        }
                    }
                }
                if (__UNDEF_KEY__ == null) {
                    if (__UNDEF_KEY__ == null) {
                        if (SharedKt.getMc().options.field_1832.method_1434() && SharedKt.getPlayer().isFallFlying() && enabledFlag) {
                            SharedKt.getPlayer().method_36457(45.0F);
                        }
                    }
                }
                SharedKt.getPlayer().method_36456(EventPacketHelper2.INSTANCE.computeValue());
            }
        }
        if (!(EventPacketHelper2.INSTANCE.checkCondition())) {
            if (SharedKt.getMc().options.field_1903.method_1434()) {
                if (SharedKt.getPlayer().isFallFlying()) {
                    if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                        if (enabledFlag) {
                            SharedKt.getPlayer().method_36457(-90.0F);
                        }
                    }
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        SharedKt.getPlayer().method_36457(-45.0F);
    }

    public void executeAction(PreElytraEvent e) {
        if (__UNDEF_KEY__ == null) {
            ElytraPlusModule.INSTANCE.updateValue3(SharedKt.getPlayer().method_36455());
        }
        SharedKt.getPlayer().method_36457(-45.0F);
    }

    public void executeAction(AfterElytraEvent e) {
        SharedKt.getPlayer().method_36457(ElytraPlusModule.INSTANCE.getNumericValue3());
    }

    public void executeAction(MoveEvent e) {
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
            if (!(SharedKt.getPlayer().field_5976)) {
                if (__UNDEF_KEY__ == null) {
                    if (SharedKt.getPlayer().field_5992) {
                        ElytraPlusModule.INSTANCE.updateValue(0.0F);
                        factorValue = 0.0F;
                    }
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (EventPacketHelper2.INSTANCE.getNumericValue() < 4) {
                e.setY(0.2D);
                e.cancel();
                return;
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (SharedKt.getMc().options.field_1903.method_1434()) {
                int index = 9;
                float factor = ElytraPlusModule.INSTANCE.getYSpeed();
                MoveEvent moveEvent = e;
                int index2 = 0;
                factorValue = (factorValue + index);
                float factor2 = factorValue;
                float factor3 = (factor2 / 100.0F);
                index2 = 1.0D;
                moveEvent.setY((factor * Math.min(factor3, index2)));
                if (__UNDEF_KEY__ != null) {
                    if (__UNDEF_KEY__ == null) {
                        if (SharedKt.getMc().options.field_1832.method_1434()) {
                            index = 9;
                            factor = ElytraPlusModule.INSTANCE.getYSpeed();
                            moveEvent = e;
                            index2 = 0;
                            factorValue = (factorValue + index);
                            factor2 = factorValue;
                            factor3 = (factor2 / 100.0F);
                            index2 = 1.0D;
                            moveEvent.setY((factor * Math.min(factor3, index2)));
                        }
                    }
                    if (!((SharedKt.getPlayer().field_6012 % 2))) {
                    }
                    this.setY(-0.08D);
                    e.setY(-0.08D);
                    e.setY(0.0D);
                    if (__UNDEF_KEY__ != null && __UNDEF_KEY__ != null && __UNDEF_KEY__ != null && __UNDEF_KEY__ != null) {
                    }
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (!(EventPacketHelper2.INSTANCE.checkCondition())) {
                ElytraPlusModule.INSTANCE.updateValue(0.0F);
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (SharedKt.getPlayer().field_3913.method_3128().field_1343 > 0.0F) {
                ((ClientInputAccessor) SharedKt.getPlayer().field_3913).setMoveVector(new class_241(1.0F, SharedKt.getPlayer().field_3913.method_3128().field_1342));
            }
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ != null && SharedKt.getPlayer().field_3913.method_3128().field_1343 < 0.0F) {
                    ((ClientInputAccessor) SharedKt.getPlayer().field_3913).setMoveVector(new class_241(-1.0F, SharedKt.getPlayer().field_3913.method_3128().field_1342));
                }
            }
        }
        index = 9;
        float factor4 = ElytraPlusModule.INSTANCE.getXzSpeed();
        factor = e;
        moveEvent = EventPacketHelper2.INSTANCE;
        index2 = 0;
        ElytraPlusModule.INSTANCE.updateValue((ElytraPlusModule.INSTANCE.getNumericValue() + index));
        float factor5 = ElytraPlusModule.INSTANCE.getNumericValue();
        factor3 = (factor5 / 100.0F);
        index2 = 1.0D;
        new NoWhenBranchMatchedException().executeAction(moveEvent, factor, (factor4 * Math.min(factor3, index2)));
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
        }
        if (ElytraPlusModule.INSTANCE.getStayMad() && !(this.checkCondition2()) && EventPacketHelper2.INSTANCE.getNumericValue() > 10) {
            e.setY(0.42D);
        }
        e.cancel();
    }

    public void executeAction(AfterSendPacket event) {
        this.executeAction(false);
    }

    private void executeAction(boolean arg0) {
        if (arg0 && (System.currentTimeMillis() - timestampValue) < (ElytraPlusModule.INSTANCE.getFireDelay() * 1000.0F)) {
            return;
        }
        if (arg0 && !(SharedKt.getPlayer().isFallFlying())) {
            return;
        }
        if (!(arg0) && EventPacketHelper2.INSTANCE.getNumericValue() > 1) {
            return;
        }
        int index = this.computeValue();
        if (index == -1) {
            countValue2 = -1;
            return;
        }
        countValue2 = index;
        boolean flag = Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.FIREWORK_ROCKET);
        int index2 = SharedKt.getPlayer().method_31548().method_67532();
        if (!(flag) && index2 != index) {
            ItemPacketHelper.INSTANCE.executeAction(index);
        }
        if (flag) {
        }
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        if (!(flag) && index2 != index) {
            ItemPacketHelper.INSTANCE.executeAction(index2);
        }
        enabledFlag = 1;
        timestampValue = System.currentTimeMillis();
    }

    public void executeAction(ReceivePacket e) {
        if (__UNDEF_KEY__ == null) {
            ElytraPlusModule.INSTANCE.updateValue(0.0F);
            factorValue = 0.0F;
            if (__UNDEF_KEY__ >= 0) {
                if (__UNDEF_KEY__ == null) {
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
        }
        ElytraPlusModule.INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("modules.common.flag-disable", new Object[0]));
    }

    public void executeAction(PlayerUpdateEvent e) {
        boolean flag = SharedKt.getWorld().method_22347(BlockPos.ofFloored(EntityHelper.resolveMinecraftObject(SharedKt.getPlayer())));
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (this.checkCondition3() && flag && SharedKt.getPlayer().method_18798().method_10214() < 0.0D) {
            } else {
            }
        }
        int index = 0;
        if (EventPacketHelper2.INSTANCE.getNumericValue() > 0.0D) {
            if (__UNDEF_KEY__ > 0) {
                if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                    if (!(flag)) {
                        if (__UNDEF_KEY__ >= 0) {
                            if (__UNDEF_KEY__ == null) {
                                if (index) {
                                    this.updateValue5();
                                }
                            }
                        }
                    }
                }
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ != null && SharedKt.getPlayer().isOnGround()) {
                    enabledFlag2 = 0;
                    return;
                }
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ == null) {
                if (!(EventPacketHelper2.INSTANCE.checkCondition())) {
                    ElytraPlusModule.INSTANCE.updateValue(0.0F);
                }
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ == null) {
                if (!(this.checkCondition())) {
                    return;
                }
            }
        }
        if (!(SharedKt.getPlayer().isFallFlying())) {
            if (!(enabledFlag2)) {
                if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ > 0 && __UNDEF_KEY__ == null) {
                    if (SharedKt.getPlayer().method_18798().method_10214() < 0.0D) {
                        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
                        enabledFlag2 = 1;
                    }
                }
            }
        }
        if (EventPacketHelper2.INSTANCE.getNumericValue() < 4) {
            SharedKt.getMc().options.field_1903.method_23481(false);
        }
        this.executeAction(true);
    }

    public void executeAction(short arg0) {
        factorValue = 0.0F;
        countValue2 = -1;
        minecraftRef2 = Items.field_8162;
        itemStack2 = null;
        enabledFlag = 0;
        if (!(Intrinsics.areEqual(SharedKt.getPlayer().getEquippedStack(EquipmentSlot.CHEST).getItem(), Items.ELYTRA))) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (arg0 <= 0) {
                    if (__UNDEF_KEY__ == null) {
                        if (!(Intrinsics.areEqual(SharedKt.getPlayer().field_7512.method_34255().getItem(), Items.ELYTRA)) && ItemPacketHelper.INSTANCE.computeValue() == -1) {
                            this.updateValue2();
                            return;
                        }
                    }
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (this.computeValue(false) == -1) {
                this.executeAction();
                return;
            }
        }
        if (this.computeValue(true) != -1) {
            return;
        }
        itemStack2 = SharedKt.getPlayer().method_31548().method_5438((ElytraPlusModule.INSTANCE.getFireSlot() - 1)).method_7972();
        minecraftRef2 = SharedKt.getPlayer().method_31548().method_5438((ElytraPlusModule.INSTANCE.getFireSlot() - 1)).getItem();
        if (arg0 <= 0) {
        }
    }

    public void updateValue() {
        enabledFlag2 = 0;
        if (ElytraPlusModule.INSTANCE.getKeepFlying()) {
            return;
        }
        SharedKt.getPlayer().method_18800(0.0D, SharedKt.getPlayer().method_18798().method_10214(), 0.0D);
        new Thread(this::executeAction).start();
    }

    public void executeAction(FireWorkVelocityEvent e) {
    }

    public void onSetPoseEvent(SetPoseEvent e) {
    }

    public void executeAction(ReceivePacket e) {
    }

    private int computeValue(boolean arg0) {
        if (arg0) {
            Item[] items = new Item[1];
            items[0] = Items.FIREWORK_ROCKET;
        } else {
            items = new Item[1];
            items[0] = Items.FIREWORK_ROCKET;
        }
        return ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items).getNumericValue();
    }

    private void executeAction() {
        ElytraPlusModule.INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("modules.common.no-fireworks", new Object[0]));
        enabledFlag = 0;
    }

    private void updateValue2() {
        ElytraPlusModule.INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("modules.common.no-elytra", new Object[0]));
        enabledFlag = 0;
    }

    private void executeAction(int arg0) {
        HandServiceComponent.e(arg0, 0, null, false);
        HandServiceComponent.e(((ElytraPlusModule.INSTANCE.getFireSlot() - 1) + 36), 0, null, false);
        HandServiceComponent.e(arg0, 0, null, true);
    }

    private void updateValue3() {
        if (countValue2 == -1 || itemStack2 == null || Intrinsics.areEqual(minecraftRef2, Items.FIREWORK_ROCKET) || Intrinsics.areEqual(minecraftRef2, Items.field_8162)) {
            return;
        }
        int index = this.computeValue(itemStack2, minecraftRef2);
        if (index < 9 && index != -1) {
        } else {
        }
        HandServiceComponent.e(index, 0, null, false);
        HandServiceComponent.e(((ElytraPlusModule.INSTANCE.getFireSlot() - 1) + 36), 0, null, false);
        HandServiceComponent.e(index, 0, null, false);
    }

    private void updateValue4() {
        countValue = -1;
        minecraftRef = Items.field_8162;
        itemStack = null;
    }

    private int computeValue(ItemStack arg0, Item arg1) {
        if (arg0 == null) {
            return -1;
        }
        int index = 0;
        if (index < 45) {
            ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(index);
            if (ItemStack.method_7984(stack, arg0)) {
                if (!(Intrinsics.areEqual(stack.getItem(), arg1))) {
                } else {
                    return index;
                }
            }
        }
        return -1;
    }

    private int computeValue(short arg0, long arg1) {
        if (Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.FIREWORK_ROCKET)) {
            return -2;
        }
        int index = this.computeValue(true);
        int index2 = this.computeValue(false);
        if (arg1 >= 0L) {
            if (index2 == -1) {
                this.executeAction();
                return -1;
            }
        }
        if (index == -1) {
            if (arg0 >= 0) {
                if (!(ElytraPlusModule.INSTANCE.getAllowFireSwap())) {
                    ElytraPlusModule.INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("modules.common.no-fireworks", new Object[0]));
                    return (ElytraPlusModule.INSTANCE.getFireSlot() - 1);
                }
                this.executeAction(index2);
            }
            return (ElytraPlusModule.INSTANCE.getFireSlot() - 1);
        }
        return index;
    }

    private boolean checkCondition() {
        if (this.checkCondition()) {
            return false;
        }
        if (this.computeValue() != -1) {
        } else {
        }
        return false;
    }

    private boolean checkCondition() {
        ItemStack stack = SharedKt.getPlayer().getEquippedStack(EquipmentSlot.CHEST);
        if (Intrinsics.areEqual(stack.getItem(), Items.ELYTRA)) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (!(ElytraPlusModule.INSTANCE.checkCondition(stack))) {
                } else {
                }
            }
        }
        return false;
    }

    private void updateValue5() {
        int index = ItemPacketHelper.INSTANCE.computeValue();
        if (index == -1) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (!(Intrinsics.areEqual(SharedKt.getPlayer().field_7512.method_34255().getItem(), Items.ELYTRA))) {
                    this.updateValue2();
                    return;
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (!(this.checkCondition())) {
                return;
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (countValue == -1) {
                ItemStack stack = SharedKt.getPlayer().getEquippedStack(EquipmentSlot.CHEST);
                countValue = index;
                minecraftRef = stack.getItem();
                itemStack = stack.method_7972();
            }
            HandServiceComponent.e(index, 0, null, false);
            HandServiceComponent.e(6, 0, null, false);
        }
        if (countValue != -1) {
            HandServiceComponent.e(countValue, 0, null, false);
        }
        ElytraPlusModule.INSTANCE.updateValue2(true);
    }

    private void updateValue6() {
        if (countValue != -1 && !(Intrinsics.areEqual(minecraftRef, Items.field_8162))) {
            if (!(ElytraPlusModule.INSTANCE.isActive2())) {
                return;
            }
            ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(countValue);
            if (!(Intrinsics.areEqual(stack, ItemStack.field_8037)) && !(ItemStack.method_7984(stack, itemStack))) {
            } else {
            }
            int index = 0;
            int index2 = this.computeValue(itemStack, minecraftRef);
            if (index2 < 9 && index2 != -1) {
            } else {
            }
            if (!(Intrinsics.areEqual(SharedKt.getPlayer().field_7512.method_34255().getItem(), Items.field_8162))) {
                HandServiceComponent.e(6, 0, null, false);
                int index3 = 14;
                int index4 = 0;
                int index5 = 0;
                HandServiceComponent.e(countValue, index5, index4, index3);
                return;
            }
            if (countValue == -1 || index2 == -1) {
                return;
            }
            HandServiceComponent.e(index2, 0, null, false);
            index3 = 14;
            index4 = 0;
            index5 = 0;
            HandServiceComponent.e(6, index5, index4, index3);
            if (!(index)) {
                HandServiceComponent.e(index2, 0, null, false);
            }
            int index6 = this.computeValue();
            if (index6 != -1) {
                HandServiceComponent.e(index6, 0, null, false);
            }
        }
        this.updateValue4();
    }

    private int computeValue() {
        int index = 9;
        if (index < 45) {
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                    if (SharedKt.getPlayer().method_31548().method_5438(index).isEmpty()) {
                        return index;
                    }
                }
            }
        }
        return -1;
    }

    public boolean checkCondition2() {
        if (SharedKt.getPlayer().getY() < 0.0D) {
            return false;
        }
        if (!(SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_989(0.0D, -3.0D, 0.0D)).iterator().hasNext())) {
        } else {
        }
        return false;
    }

    public boolean checkCondition3() {
        return SharedKt.getWorld().getBlockState(BlockPos.method_49637(SharedKt.getPlayer().getX(), (SharedKt.getPlayer().getY() - 0.1D), SharedKt.getPlayer().getZ())).getBlock() instanceof FluidBlock;
    }

    private static void executeAction() {
        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
        INSTANCE.updateValue3();
        countValue2 = -1;
        minecraftRef2 = Items.field_8162;
        itemStack2 = null;
        INSTANCE.updateValue6();
        INSTANCE.updateValue4();
    }

    static {
        INSTANCE = new EventPacketHelper4();
        minecraftRef = Items.field_8162;
        minecraftRef2 = Items.field_8162;
        countValue = -1;
        countValue2 = -1;
    }

}
