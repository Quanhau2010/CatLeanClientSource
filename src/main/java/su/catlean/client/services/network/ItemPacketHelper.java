package su.catlean.client.services.network;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1743;
import net.minecraft.class_1821;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_2371;
import net.minecraft.class_2378;
import net.minecraft.class_2868;
import net.minecraft.class_2879;
import net.minecraft.class_476;
import net.minecraft.class_495;
import net.minecraft.class_5321;
import net.minecraft.class_5455;
import net.minecraft.class_6880;
import net.minecraft.class_9323;
import net.minecraft.class_9334;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract7;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.features.modules.movement.basic.WindHopSwitchMode;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.ItemServiceComponent4;
import su.catlean.client.services.client.StackServiceComponent;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.player.EntityHelper2;
import su.catlean.client.types.mappings.WindHopSwitchModeWhenMappings;
import su.catlean.mixins.accessors.InteractionManagerAccessor;

public class ItemPacketHelper implements Contract9 {

    public static final ItemPacketHelper INSTANCE;
    private static int countValue;
    private static int countValue2;
    private static int countValue3;

    private ItemPacketHelper() {
    }

    private void onSendPacket(SendPacket arg0) {
        countValue = ((class_2868) arg0.getPacket()).method_12442();
    }

    public int computeValue(Item item, boolean offHand) {
        int index = 0;
        int index2 = 0;
        if (index2 < 45) {
            ItemStack stack = SharedKt.getMc().player.method_31548().method_5438(index2);
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                    if (Intrinsics.areEqual(stack.getItem(), item)) {
                        index = (index + stack.method_7947());
                    }
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (Intrinsics.areEqual(SharedKt.getPlayer().field_7512.method_34255().getItem(), item)) {
                countValue2 = (countValue2 + 1);
            }
        }
        if (offHand) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), item)) {
                    index = (index + SharedKt.getPlayer().method_6079().method_7947());
                }
            }
        }
        return index;
    }

    public static int computeValue(ItemPacketHelper arg0, Item arg1, boolean arg2, int arg3, Object arg4) {
        if ((arg3 & 2) != 0) {
            arg2 = 0;
        }
        return arg0.computeValue(arg1, arg2);
    }

    public int computeValue(Item item) {
        int index = 0;
        int index2 = 0;
        int index3 = SharedKt.getPlayer().field_7512.field_7761.size();
        if (index2 < index3) {
            ItemStack stack = SharedKt.getPlayer().field_7512.method_7611(index2).method_7677();
            if (__UNDEF_KEY__ >= 0) {
                if (__UNDEF_KEY__ == null) {
                    if (__UNDEF_KEY__ > 0) {
                        if (__UNDEF_KEY__ == null) {
                            if (Intrinsics.areEqual(stack.getItem(), item)) {
                            }
                        }
                    }
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (Intrinsics.areEqual(SharedKt.getPlayer().field_7512.method_34255().getItem(), item)) {
            }
        }
        return index;
    }

    public int computeValue(Contract7 searcher) {
        int index = 0;
        int index2 = 0;
        if (index2 < 45) {
            ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(index2);
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                    if (searcher.checkCondition(stack)) {
                        index = (index + stack.method_7947());
                    }
                }
            }
        }
        return index;
    }

    public StackServiceComponent2 resolveStackServiceComponent2(Contract7 searcher) {
        int index = 0;
        if (index < 9) {
            if (SharedKt.getMc().player != null && SharedKt.getMc().player.method_31548() != null) {
            }
            SharedKt.getMc().player.method_31548().method_5438(index);
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ != null && searcher.checkCondition()) {
                    return new StackServiceComponent2(index, true);
                }
            }
        }
        return StackServiceComponent2.stackServiceComponent.getStackServiceComponent2();
    }

    public StackServiceComponent2 resolveStackServiceComponent2(Contract7 searcher) {
        int index = 36;
        if (index >= 0) {
            if (__UNDEF_KEY__ > 0) {
                if (SharedKt.getMc().player != null && SharedKt.getMc().player.method_31548() != null) {
                }
                SharedKt.getMc().player.method_31548().method_5438(index);
            }
            if (__UNDEF_KEY__ >= 0) {
                if (__UNDEF_KEY__ == null) {
                    if (__UNDEF_KEY__ >= 0) {
                        if (__UNDEF_KEY__ == null) {
                            if (__UNDEF_KEY__ != null && searcher.checkCondition()) {
                                if (index < 9) {
                                }
                                return new StackServiceComponent2(index, true);
                            }
                        }
                    }
                }
            }
        }
        return StackServiceComponent2.stackServiceComponent.getStackServiceComponent2();
    }

    public StackServiceComponent2 resolveStackServiceComponent2(List items) {
        return this.resolveStackServiceComponent2(this::checkCondition);
    }

    public StackServiceComponent2 resolveStackServiceComponent2(Item[] items) {
        return this.resolveStackServiceComponent2(this::checkCondition);
    }

    public StackServiceComponent2 resolveStackServiceComponent2(List items) {
        return this.resolveStackServiceComponent2(this::checkCondition2);
    }

    public StackServiceComponent2 resolveStackServiceComponent2(Item[] items) {
        return this.resolveStackServiceComponent2(this::checkCondition2);
    }

    public StackServiceComponent2 resolveStackServiceComponent22(List blocks) {
        Iterable iterable = ((Iterable) blocks);
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Block block = ((Block) element);
            if (__UNDEF_KEY__ == null) {
                collection.add(block.method_8389());
            }
        }
        return this.resolveStackServiceComponent2(collection);
    }

    public StackServiceComponent2 resolveStackServiceComponent2(Block[] blocks) {
        Collection collection = ((Collection) new ArrayList(blocks));
        int index = 0;
        if (index < blocks) {
            Object element = blocks[index];
            if (__UNDEF_KEY__ == null) {
                collection.add(element.method_8389());
            }
        }
        return this.resolveStackServiceComponent2(collection);
    }

    public StackServiceComponent2 resolveStackServiceComponent2(List blocks) {
        Iterable iterable = ((Iterable) blocks);
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Block block = ((Block) element);
            if (__UNDEF_KEY__ == null) {
                collection.add(block.method_8389());
            }
        }
        return this.resolveStackServiceComponent2(collection);
    }

    public StackServiceComponent2 resolveStackServiceComponent2(Block[] blocks) {
        Collection collection = ((Collection) new ArrayList(blocks));
        int index = 0;
        if (index < blocks) {
            Object element = blocks[index];
            if (__UNDEF_KEY__ == null) {
                collection.add(element.method_8389());
                if (__UNDEF_KEY__ >= 0) {
                }
            }
        }
        return this.resolveStackServiceComponent2(collection);
    }

    public void updateValue() {
        countValue2 = SharedKt.getPlayer().method_31548().method_67532();
    }

    public void updateValue2() {
        if (countValue2 != -1) {
            this.executeAction(countValue2);
        }
        countValue2 = -1;
    }

    public void executeAction(int slot) {
        this.updateValue();
        this.executeAction(slot);
    }

    public StackServiceComponent2 resolveStackServiceComponent2(Contract7 searcher, WindHopSwitchMode mode) {
        StackServiceComponent2 stackServiceComponent2 = this.resolveStackServiceComponent2(searcher);
        if (__UNDEF_KEY__ == null) {
            if (stackServiceComponent2.isActive()) {
            }
        }
        return new NoWhenBranchMatchedException();
    }

    public boolean checkCondition(Contract7 searcher, WindHopSwitchMode mode, Function0 action) {
        StackServiceComponent2 stackServiceComponent2 = this.resolveStackServiceComponent2(searcher);
        if (__UNDEF_KEY__ == null) {
            if (!(stackServiceComponent2.isActive())) {
                return false;
            }
            this.executeAction(stackServiceComponent2.getNumericValue(), mode, action);
        }
        return true;
        stackServiceComponent2 = this.resolveStackServiceComponent2(searcher);
        if (__UNDEF_KEY__ == null) {
            if (!(stackServiceComponent2.isActive())) {
                return false;
            }
            this.executeAction(stackServiceComponent2.getNumericValue(), mode, action);
        }
        return true;
        stackServiceComponent2 = this.resolveStackServiceComponent2(searcher);
        if (__UNDEF_KEY__ == null) {
            if (stackServiceComponent2.isActive()) {
                this.executeAction(stackServiceComponent2.getNumericValue(), mode, action);
                return true;
            }
        }
        StackServiceComponent2 stackServiceComponent22 = this.resolveStackServiceComponent2(searcher);
        if (__UNDEF_KEY__ == null) {
            if (!(stackServiceComponent22.isActive())) {
                return false;
            }
            this.executeAction(stackServiceComponent22.getNumericValue(), mode, action);
        }
        return true;
    }

    public boolean checkCondition(Item item, WindHopSwitchMode mode, Function0 action) {
        Item[] items = new Item[1];
        items[0] = item;
        StackServiceComponent2 stackServiceComponent2 = this.resolveStackServiceComponent2(items);
        if (__UNDEF_KEY__ == null) {
            if (!(stackServiceComponent2.isActive())) {
                return false;
            }
            this.executeAction(stackServiceComponent2.getNumericValue(), mode, action);
        }
        return true;
        items = new Item[1];
        items[0] = item;
        stackServiceComponent2 = this.resolveStackServiceComponent2(items);
        if (__UNDEF_KEY__ == null) {
            if (!(stackServiceComponent2.isActive())) {
                return false;
            }
            this.executeAction(stackServiceComponent2.getNumericValue(), mode, action);
        }
        return true;
        items = new Item[1];
        items[0] = item;
        stackServiceComponent2 = this.resolveStackServiceComponent2(items);
        if (__UNDEF_KEY__ == null) {
            if (stackServiceComponent2.isActive()) {
                this.executeAction(stackServiceComponent2.getNumericValue(), mode, action);
                return true;
            }
        }
        Item[] items2 = new Item[1];
        items2[0] = item;
        items = this.resolveStackServiceComponent2(items2);
        if (__UNDEF_KEY__ == null) {
            if (!(items.isActive())) {
                return false;
            }
            this.executeAction(items.getNumericValue(), mode, action);
        }
        return true;
    }

    public void executeAction(int slot, WindHopSwitchMode mode, Function0 action) {
        GuiMoveModule.INSTANCE.updateValue(true);
        if (__UNDEF_KEY__ == null) {
            if (__UNDEF_KEY__ == null) {
                if (SharedKt.getPlayer().method_31548().method_67532() != slot) {
                    this.executeAction(slot);
                }
            }
        }
        action.invoke();
        if (__UNDEF_KEY__ != null) {
            int index = SharedKt.getPlayer().method_31548().method_67532();
            if (__UNDEF_KEY__ == null) {
                if (countValue != slot) {
                    this.executeAction(slot);
                }
                action.invoke();
            }
            this.executeAction(index);
            SharedKt.getInteractionManager().method_2906(SharedKt.getPlayer().field_7512.field_7763, slot, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, ((PlayerEntity) SharedKt.getPlayer()));
            action.invoke();
            SharedKt.getInteractionManager().method_2906(SharedKt.getPlayer().field_7512.field_7763, slot, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, ((PlayerEntity) SharedKt.getPlayer()));
            action.invoke();
            SharedKt.getInteractionManager().method_2906(SharedKt.getPlayer().field_7512.field_7763, slot, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, ((PlayerEntity) SharedKt.getPlayer()));
            if (countValue != index && __UNDEF_KEY__ != null && __UNDEF_KEY__ != null && __UNDEF_KEY__ != null) {
                if (slot >= 9) {
                }
                Function0 function0 = action;
                WindHopSwitchMode windHopSwitchMode = WindHopSwitchMode.SILENT;
                WindHopSwitchMode windHopSwitchMode2 = WindHopSwitchMode.INVENTORY_SILENT;
                slot.executeAction(windHopSwitchMode2, windHopSwitchMode, function0);
                if (__UNDEF_KEY__ != null) {
                    if (slot >= 9) {
                    }
                    function0 = action;
                    windHopSwitchMode = WindHopSwitchMode.NORMAL;
                    windHopSwitchMode2 = WindHopSwitchMode.INVENTORY_NORMAL;
                    slot.executeAction(windHopSwitchMode2, windHopSwitchMode, function0);
                    if (__UNDEF_KEY__ != null) {
                    }
                }
            }
        }
        GuiMoveModule.INSTANCE.updateValue(false);
    }

    public void executeAction2(int slot) {
        if (slot < 9) {
        } else {
        }
        SharedKt.getPlayer().field_7512.field_7763.method_2906((slot + 36), slot, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, ((PlayerEntity) SharedKt.getPlayer()));
    }

    public void executeAction(int slot) {
        if (0 <= slot) {
        } else {
        }
        SharedKt.getPlayer().method_31548().method_61496(slot);
        ((InteractionManagerAccessor) SharedKt.getMc().interactionManager).setCarriedIndex(slot);
        this.executeAction2(slot);
    }

    public void executeAction2(int slot) {
        if (SharedKt.getMc().method_1562() != null) {
            SharedKt.getMc().method_1562().method_52787(((Packet) new class_2868(slot)));
        }
    }

    public int computeValue() {
        Iterator iterator = EntityHelper2.resolveList(SharedKt.getPlayer()).iterator();
        while (iterator.hasNext()) {
            ItemStack stack = ((ItemStack) iterator.next());
            if (__UNDEF_KEY__ == null) {
            }
            return -2;
        }
        iterator = -1;
        stack = 0;
        if (stack < 36) {
            ItemStack stack2 = SharedKt.getPlayer().method_31548().method_5438(stack);
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                    if (__UNDEF_KEY__ == null) {
                        if (Intrinsics.areEqual(stack2.getItem(), Items.ELYTRA) && stack2.method_7919() < 430) {
                            iterator = stack;
                            if (__UNDEF_KEY__ != null) {
                            }
                        }
                    }
                }
            }
        }
        if (iterator < 9) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (iterator != -1) {
                }
            }
        }
        return iterator;
    }

    public StackServiceComponent2 resolveStackServiceComponent2() {
        if (SharedKt.getMc().player == null) {
            return StackServiceComponent2.stackServiceComponent.getStackServiceComponent2();
        }
        int index = -1;
        float factor = 1.0F;
        int index2 = 0;
        if (index2 < 9) {
            if (SharedKt.getMc().player != null && SharedKt.getMc().player.method_31548() != null) {
            }
            SharedKt.getMc().player.method_31548().method_5438(index2);
            if (__UNDEF_KEY__ != null && ItemServiceComponent4.checkCondition()) {
                int index3 = ((Number) this.getItem().method_57347().method_58694(class_9334.field_50072));
                index3 = (index3 + class_1890.method_8225(((class_6880) ((class_2378) SharedKt.getWorld().method_30349().method_46759(class_1893.field_9118.method_58273()).get()).method_10223(class_1893.field_9118.method_29177()).get())));
                if (index3 > factor) {
                    factor = index3;
                    index = index2;
                }
            }
        }
        if (index == -1) {
            return StackServiceComponent2.stackServiceComponent.getStackServiceComponent2();
        }
        return new StackServiceComponent2(index, true, SharedKt.getPlayer().method_31548().method_5438(index));
    }

    public StackServiceComponent2 resolveStackServiceComponent22() {
        if (SharedKt.getMc().player == null) {
            return StackServiceComponent2.stackServiceComponent.getStackServiceComponent2();
        }
        ItemStack stack = SharedKt.getMc().player.method_6047();
        if (!(ItemServiceComponent4.checkCondition(stack)) && !(ItemServiceComponent4.checkCondition2(stack)) && !(stack.getItem() instanceof class_1743)) {
            if (stack.getItem() instanceof class_1821) {
                return new StackServiceComponent2(SharedKt.getMc().player.method_31548().method_67532(), true, SharedKt.getMc().player.method_6047());
            }
        }
        return this.resolveStackServiceComponent2(this::checkCondition);
    }

    public StackServiceComponent2 resolveStackServiceComponent23() {
        if (SharedKt.getMc().player == null) {
            return StackServiceComponent2.stackServiceComponent.getStackServiceComponent2();
        }
        int index = -1;
        float factor = 1.0F;
        int index2 = 0;
        if (index2 < 9) {
            if (SharedKt.getMc().player != null && SharedKt.getMc().player.method_31548() != null) {
            }
            SharedKt.getMc().player.method_31548().method_5438(index2);
            if (__UNDEF_KEY__ != null && this.getItem() instanceof class_1743) {
                class_1743 class1743 = ((class_1743) this.getItem());
                if (((Integer) class1743.method_57347().method_58694(class_9334.field_50072)) != null) {
                }
                int index3 = (0 + class_1890.method_8225(((class_6880) SharedKt.getWorld().method_30349().method_58561(class_1893.field_9118).get())));
                if (index3 > factor) {
                    factor = index3;
                    index = index2;
                }
            }
        }
        if (index == -1) {
            return StackServiceComponent2.stackServiceComponent.getStackServiceComponent2();
        }
        return new StackServiceComponent2(index, true, SharedKt.getMc().player.method_31548().method_5438(index));
    }

    public void executeAction(int slot, int factor) {
        int index = SharedKt.getPlayer().method_31548().method_67532();
        if (__UNDEF_KEY__ == null) {
            this.executeAction(slot);
        }
        if (__UNDEF_KEY__ == null) {
            if (Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(slot).getItem(), Items.field_8287)) {
                int index2 = 1;
                if (index2 <= factor) {
                    HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
                    if (index2 != factor) {
                        if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                            HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
                            PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5808)));
                        }
                    }
                }
            }
        }
        this.executeAction(index);
    }

    public static void executeAction(ItemPacketHelper arg0, int arg1, int arg2, int arg3, Object arg4) {
        if ((arg3 & 2) != 0) {
            arg2 = 1;
        }
        arg0.executeAction(arg1, arg2);
    }

    public void executeAction(int slot) {
        GuiMoveModule.INSTANCE.updateValue(true);
        if (slot != -1) {
            HandServiceComponent.e(slot, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, false);
            HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
            PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5808)));
            HandServiceComponent.e(slot, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, false);
        }
        GuiMoveModule.INSTANCE.updateValue(false);
    }

    public void executeAction(int from, int to) {
        int index = ((SharedKt.getPlayer().method_31548().method_67532() % 8) + 1);
        if (!(SharedKt.getMc().currentScreen instanceof class_495)) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (SharedKt.getMc().currentScreen instanceof class_476) {
                } else {
                }
            }
        }
        int index2 = 0;
        HandServiceComponent.e(from, index, class_1713.field_7791, false);
        HandServiceComponent.e(to, index, class_1713.field_7791, false);
        if (__UNDEF_KEY__ == null) {
            if (!(index2)) {
            } else {
            }
        }
        HandServiceComponent.executeAction(index, class_1713.field_7791, 1, false);
    }

    private static boolean checkCondition(List arg0, ItemStack arg1) {
        return arg0.contains(arg1.getItem());
    }

    private static boolean checkCondition(Item[] arg0, ItemStack arg1) {
        return ArraysKt.contains(arg0, arg1.getItem());
    }

    private static boolean checkCondition2(List arg0, ItemStack arg1) {
        return arg0.contains(arg1.getItem());
    }

    private static boolean checkCondition2(Item[] arg0, ItemStack arg1) {
        return ArraysKt.contains(arg0, arg1.getItem());
    }

    private static boolean checkCondition(ItemStack arg0) {
        if (!(ItemServiceComponent4.checkCondition(arg0))) {
            if (!(ItemServiceComponent4.checkCondition2(arg0))) {
                if (!(arg0.getItem() instanceof class_1743)) {
                    if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                        if (arg0.getItem() instanceof class_1821) {
                        } else {
                        }
                    }
                }
            }
        }
        return false;
    }

    static {
        INSTANCE = new ItemPacketHelper();
        countValue = -1;
        countValue2 = -1;
    }

    public static void updateValue(int arg0) {
        countValue3 = arg0;
    }

    public static int getNumericValue() {
        return countValue3;
    }

    public static int getNumericValue2() {
        int index = getNumericValue();
        if (!(index)) {
            return 96;
        }
        return 0;
    }

}
