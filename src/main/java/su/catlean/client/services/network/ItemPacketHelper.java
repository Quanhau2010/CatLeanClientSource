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
        if (var4 == null) {
        }
        countValue = (class_2868) arg0.getPacket().method_12442();
    }

    public int computeValue(Item item, boolean offHand) {
        int var10 = 0;
        int var11 = 0;
        if (var11 < 45) {
            ItemStack stack = SharedKt.getMc().player.method_31548().method_5438();
            if (var9 == null) {
                if (var9 == null) {
                    if (Intrinsics.areEqual(stack.getItem(), item)) {
                        var10 = (var10 + stack.method_7947());
                    }
                }
            }
        }
        if (var9 == null) {
            if (Intrinsics.areEqual(SharedKt.getPlayer().field_7512.method_34255().getItem(), item)) {
                countValue2 = (countValue2 + 1);
            }
        }
        if (offHand) {
            if (var9 == null && var9 == null) {
                if (Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), item)) {
                    var10 = (var10 + SharedKt.getPlayer().method_6079().method_7947());
                }
            }
        }
        return var10;
    }

    public static int computeValue(ItemPacketHelper arg0, Item arg1, boolean arg2, int arg3, Object arg4) {
        if (var9 == null) {
            if ((arg3 & 2)) {
                arg2 = 0;
            }
        }
        return arg0.computeValue(arg1, arg2);
    }

    public int computeValue(Item item) {
        int var10 = 0;
        int var11 = 0;
        int var12 = SharedKt.getPlayer().field_7512.field_7761.size();
        if (var11 < var12) {
            ItemStack stack = SharedKt.getPlayer().field_7512.method_7611().method_7677();
            if (0L >= 0) {
                if (var9 == null) {
                    if (0L > 0) {
                        if (var9 == null) {
                            if (Intrinsics.areEqual(stack.getItem(), item)) {
                            }
                        }
                    }
                }
            }
        }
        if (var9 == null) {
            if (Intrinsics.areEqual(SharedKt.getPlayer().field_7512.method_34255().getItem(), item)) {
            }
        }
        return var10;
    }

    public int computeValue(Contract7 searcher) {
        int var7 = 0;
        int var8 = 0;
        if (var8 < 45) {
            ItemStack stack = SharedKt.getPlayer().method_31548().method_5438();
            if (var6 == null) {
                if (var6 == null) {
                    if (searcher.checkCondition(stack)) {
                        var7 = (var7 + stack.method_7947());
                    }
                }
            }
        }
        return var7;
    }

    public StackServiceComponent2 resolveStackServiceComponent2(Contract7 searcher) {
        int var9 = 0;
        if (var9 < 9) {
            if (SharedKt.getMc().player != null && SharedKt.getMc().player.method_31548() != null) {
            }
            SharedKt.getMc().player.method_31548().method_5438();
            if (var8 == null) {
                if (var10 != null && searcher.checkCondition()) {
                    return new StackServiceComponent2(1);
                }
            }
        }
        return StackServiceComponent2.stackServiceComponent.getStackServiceComponent2();
    }

    public StackServiceComponent2 resolveStackServiceComponent2(Contract7 searcher) {
        int var12 = 36;
        if (var12 >= 0) {
            if (0L > 0) {
                if (SharedKt.getMc().player != null && SharedKt.getMc().player.method_31548() != null) {
                }
                SharedKt.getMc().player.method_31548().method_5438();
            }
            if (0L >= 0) {
                if (var11 == null) {
                    if (0L >= 0) {
                        if (var11 == null) {
                            if (var13 != null && searcher.checkCondition()) {
                            }
                        }
                        if (var12 < 9) {
                        }
                        return new StackServiceComponent2(1);
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
        Iterable var7 = (Iterable) blocks;
        Object var16 = this;
        int var8 = 0;
        Object var9 = var7;
        Collection var10 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var11 = 0;
        Iterator iterator = var9.iterator();
        if (iterator.hasNext()) {
            Object var13 = iterator.next();
            Block var14 = (Block) var13;
            if (var6 == null) {
                Object var17 = var10;
                int var15 = 0;
                var17.add(var14.method_8389());
            }
        }
        return var16.resolveStackServiceComponent2();
    }

    public StackServiceComponent2 resolveStackServiceComponent2(Block[] blocks) {
        Object var7 = blocks;
        Object var17 = this;
        int var8 = 0;
        Object var9 = var7;
        Collection var10 = (Collection) new ArrayList();
        int var11 = 0;
        int var12 = 0;
        Object var13 = var9;
        if (var12 < var13) {
            Object var14 = var9[var12];
            Object var15 = var14;
            if (var6 == null) {
                Object var18 = var10;
                int var16 = 0;
                var18.add(var15.method_8389());
            }
        }
        return var17.resolveStackServiceComponent2();
    }

    public StackServiceComponent2 resolveStackServiceComponent2(List blocks) {
        Iterable var11 = (Iterable) blocks;
        Object var20 = this;
        int var12 = 0;
        Object var13 = var11;
        Collection var14 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var15 = 0;
        Iterator iterator = var13.iterator();
        if (iterator.hasNext()) {
            Object var17 = iterator.next();
            Block var18 = (Block) var17;
            if (var10 == null) {
                Object var21 = var14;
                int var19 = 0;
                var21.add(var18.method_8389());
            }
        }
        return var20.resolveStackServiceComponent2();
    }

    public StackServiceComponent2 resolveStackServiceComponent2(Block[] blocks) {
        Object var11 = blocks;
        Object var21 = this;
        int var12 = 0;
        Object var13 = var11;
        Collection var14 = (Collection) new ArrayList();
        int var15 = 0;
        int var16 = 0;
        Object var17 = var13;
        if (var16 < var17) {
            Object var18 = var13[var16];
            Object var19 = var18;
            if (var10 == null) {
                Object var22 = var14;
                int var20 = 0;
                var22.add(var19.method_8389());
            }
            if (0L >= 0) {
            }
        }
        return var21.resolveStackServiceComponent2();
    }

    public void updateValue() {
        countValue2 = SharedKt.getPlayer().method_31548().method_67532();
    }

    public void updateValue2() {
        if (var5 == null) {
            if (countValue2 != -1) {
                this.executeAction(countValue2);
            }
        }
        countValue2 = -1;
    }

    public void executeAction(int slot) {
        this.updateValue();
        this.executeAction(slot);
    }

    public StackServiceComponent2 resolveStackServiceComponent2(Contract7 searcher, WindHopSwitchMode mode) {
        StackServiceComponent2 var11 = this.resolveStackServiceComponent2(searcher);
        if (var10 == null) {
            if (var11.isActive()) {
            }
        }
        return new NoWhenBranchMatchedException();
    }

    public boolean checkCondition(Contract7 searcher, WindHopSwitchMode mode, Function0 action) {
        StackServiceComponent2 var14 = this.resolveStackServiceComponent2(searcher);
        if (var13 == null) {
            if (!(var14.isActive())) {
                return false;
            }
            this.executeAction(var14.getNumericValue(), mode, action);
        }
        return true;
        var14 = this.resolveStackServiceComponent2(searcher);
        if (var13 == null) {
            if (!(var14.isActive())) {
                return false;
            }
            this.executeAction(var14.getNumericValue(), mode, action);
        }
        return true;
        var14 = this.resolveStackServiceComponent2(searcher);
        if (var13 == null) {
            if (var14.isActive()) {
                this.executeAction(var14.getNumericValue(), mode, action);
                return true;
            }
        }
        StackServiceComponent2 var15 = this.resolveStackServiceComponent2(searcher);
        if (var13 == null) {
            if (!(var15.isActive())) {
                return false;
            }
            this.executeAction(var15.getNumericValue(), mode, action);
        }
        return true;
    }

    public boolean checkCondition(Item item, WindHopSwitchMode mode, Function0 action) {
        Item[] var16 = new Item[1];
        var16[0] = item;
        StackServiceComponent2 var15 = this.resolveStackServiceComponent2();
        if (var14 == null) {
            if (!(var15.isActive())) {
                return false;
            }
            this.executeAction(var15.getNumericValue(), mode, action);
        }
        return true;
        var16 = new Item[1];
        var16[0] = item;
        var15 = this.resolveStackServiceComponent2();
        if (var14 == null) {
            if (!(var15.isActive())) {
                return false;
            }
            this.executeAction(var15.getNumericValue(), mode, action);
        }
        return true;
        var16 = new Item[1];
        var16[0] = item;
        var15 = this.resolveStackServiceComponent2();
        if (var14 == null) {
            if (var15.isActive()) {
                this.executeAction(var15.getNumericValue(), mode, action);
            }
            return true;
        }
        Item[] var17 = new Item[1];
        var17[0] = item;
        var16 = this.resolveStackServiceComponent2();
        if (var14 == null) {
            if (!(var16.isActive())) {
                return false;
            }
            this.executeAction(var16.getNumericValue(), mode, action);
        }
        return true;
    }

    public void executeAction(int slot, WindHopSwitchMode mode, Function0 action) {
        GuiMoveModule.INSTANCE.updateValue(1);
        if (var18 == null) {
            if (var18 == null) {
            }
            if (SharedKt.getPlayer().method_31548().method_67532() != slot) {
                this.executeAction(slot);
            }
        }
        action.invoke();
        if (var18 != null) {
            int var19 = SharedKt.getPlayer().method_31548().method_67532();
            if (var18 == null) {
                if (countValue != slot) {
                    this.executeAction(slot);
                }
                action.invoke();
            }
            this.executeAction();
            SharedKt.getInteractionManager().method_2906(SharedKt.getPlayer().field_7512.field_7763, slot, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, (PlayerEntity) SharedKt.getPlayer());
            action.invoke();
            SharedKt.getInteractionManager().method_2906(SharedKt.getPlayer().field_7512.field_7763, slot, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, (PlayerEntity) SharedKt.getPlayer());
            action.invoke();
            SharedKt.getInteractionManager().method_2906(SharedKt.getPlayer().field_7512.field_7763, slot, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, (PlayerEntity) SharedKt.getPlayer());
            if (countValue != var19 && var18 != null && var18 != null && var18 != null) {
                if (slot >= 9) {
                }
                Object var15 = action;
                WindHopSwitchMode var16 = WindHopSwitchMode.SILENT;
                WindHopSwitchMode var17 = WindHopSwitchMode.INVENTORY_SILENT;
                slot.executeAction();
                if (var18 != null) {
                    if (slot >= 9) {
                    }
                    var15 = action;
                    var16 = WindHopSwitchMode.NORMAL;
                    var17 = WindHopSwitchMode.INVENTORY_NORMAL;
                    slot.executeAction();
                    if (var18 != null) {
                    }
                }
            }
        }
        GuiMoveModule.INSTANCE.updateValue(0);
    }

    public void executeAction2(int slot) {
        if (var9 == null) {
            if (slot < 9) {
            }
        } else {
        }
        SharedKt.getPlayer().field_7512.field_7763.method_2906((slot + 36), slot, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, (PlayerEntity) SharedKt.getPlayer());
    }

    public void executeAction(int slot) {
        if (var10 == null) {
            if (0 <= slot) {
                if (var10 == null) {
                }
                if (slot < 9) {
                }
            }
        } else {
        }
        if (var10 == null) {
        }
        SharedKt.getPlayer().method_31548().method_61496(slot);
        (InteractionManagerAccessor) SharedKt.getMc().interactionManager.setCarriedIndex(slot);
        this.executeAction2(slot);
    }

    public void executeAction2(int slot) {
        if (SharedKt.getMc().method_1562() != null) {
            SharedKt.getMc().method_1562().method_52787((Packet) new class_2868(slot));
        }
    }

    public int computeValue() {
        Iterator iterator = EntityHelper2.resolveList(SharedKt.getPlayer()).iterator();
        if (iterator.hasNext()) {
            ItemStack stack = (ItemStack) iterator.next();
            if (var7 == null) {
            }
            return -2;
        }
        iterator = -1;
        stack = 0;
        if (stack < 36) {
            ItemStack stack2 = SharedKt.getPlayer().method_31548().method_5438(stack);
            if (var7 == null) {
                if (var7 == null) {
                    if (var7 == null) {
                        if (Intrinsics.areEqual(stack2.getItem(), Items.ELYTRA) && stack2.method_7919() < 430) {
                        }
                        iterator = stack;
                        if (var7 != null) {
                        }
                    }
                }
            }
        }
        if (iterator < 9) {
            if (var7 == null && var7 == null) {
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
        int var14 = -1;
        float var15 = 1.0F;
        int var16 = 0;
        if (var16 < 9) {
            if (var13 == null) {
                if (SharedKt.getMc().player != null && SharedKt.getMc().player.method_31548() != null) {
                }
                SharedKt.getMc().player.method_31548().method_5438();
                if (var13 == null) {
                    if (var13 == null) {
                        if (var17 != null && ItemServiceComponent4.checkCondition()) {
                        }
                        int var18 = (Number) var17.getItem().method_57347().method_58694(class_9334.field_50072);
                        var18 = (var18 + class_1890.method_8225((class_6880) (class_2378) SharedKt.getWorld().method_30349().method_46759(class_1893.field_9118.method_58273()).get().method_10223(class_1893.field_9118.method_29177()).get()));
                        if (var13 == null) {
                            if (var18 > var15) {
                                var15 = var18;
                                var14 = var16;
                            }
                        }
                    }
                }
            }
            if (var14 == -1) {
                return StackServiceComponent2.stackServiceComponent.getStackServiceComponent2();
            }
        }
        return new StackServiceComponent2(1, SharedKt.getPlayer().method_31548().method_5438());
    }

    public StackServiceComponent2 resolveStackServiceComponent22() {
        if (var13 == null) {
            if (SharedKt.getMc().player == null) {
                return StackServiceComponent2.stackServiceComponent.getStackServiceComponent2();
            }
        }
        ItemStack stack = SharedKt.getMc().player.method_6047();
        if (var13 == null) {
        }
        if (var13 == null) {
        }
        if (var13 == null) {
            if (!(ItemServiceComponent4.checkCondition(stack)) && !(ItemServiceComponent4.checkCondition2(stack)) && !(stack.getItem() instanceof class_1743)) {
            }
            if (stack.getItem() instanceof class_1821) {
            }
            return new StackServiceComponent2(SharedKt.getMc().player.method_31548().method_67532(), 1, SharedKt.getMc().player.method_6047());
        }
        return this.resolveStackServiceComponent2(this::checkCondition);
    }

    public StackServiceComponent2 resolveStackServiceComponent23() {
        if (SharedKt.getMc().player == null) {
            return StackServiceComponent2.stackServiceComponent.getStackServiceComponent2();
        }
        int var10 = -1;
        float var11 = 1.0F;
        int var12 = 0;
        if (var12 < 9) {
            if (var9 == null) {
                if (SharedKt.getMc().player != null && SharedKt.getMc().player.method_31548() != null) {
                }
                SharedKt.getMc().player.method_31548().method_5438();
                if (var9 == null) {
                    if (var9 == null) {
                        if (var13 != null && var13.getItem() instanceof class_1743) {
                        }
                        class_1743 var14 = (class_1743) var13.getItem();
                        if (var9 == null) {
                            if ((Integer) var14.method_57347().method_58694(class_9334.field_50072) != null) {
                            }
                        }
                        int var15 = (0 + class_1890.method_8225((class_6880) SharedKt.getWorld().method_30349().method_58561(class_1893.field_9118).get()));
                        if (var9 == null) {
                            if (var15 > var11) {
                                var11 = var15;
                                var10 = var12;
                            }
                        }
                    }
                }
            }
            if (var10 == -1) {
                return StackServiceComponent2.stackServiceComponent.getStackServiceComponent2();
            }
        }
        return new StackServiceComponent2(1, SharedKt.getMc().player.method_31548().method_5438());
    }

    public void executeAction(int slot, int factor) {
        int var14 = SharedKt.getPlayer().method_31548().method_67532();
        if (var13 == null) {
            this.executeAction(slot);
        }
        if (var13 == null) {
            if (Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(slot).getItem(), Items.field_8287)) {
            }
            int var15 = 1;
            if (var15 <= factor) {
                HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
                if (var15 != factor) {
                    if (var13 == null && var13 == null) {
                    }
                    HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
                }
            }
            PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
        }
        this.executeAction();
    }

    public static void executeAction(ItemPacketHelper arg0, int arg1, int arg2, int arg3, Object arg4) {
        if (var9 == null) {
            if ((arg3 & 2)) {
            }
            arg2 = 1;
        }
        arg0.executeAction(arg1, arg2);
    }

    public void executeAction(int slot) {
        GuiMoveModule.INSTANCE.updateValue(1);
        if (slot != -1) {
            HandServiceComponent.e(slot, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791);
            HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
            PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
            HandServiceComponent.e(slot, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791);
        }
        GuiMoveModule.INSTANCE.updateValue(0);
    }

    public void executeAction(int from, int to) {
        int var14 = ((SharedKt.getPlayer().method_31548().method_67532() % 8) + 1);
        if (!(SharedKt.getMc().currentScreen instanceof class_495)) {
            if (var13 == null && var13 == null) {
                if (SharedKt.getMc().currentScreen instanceof class_476) {
                }
            }
        } else {
        }
        int var15 = 0;
        HandServiceComponent.e(from, class_1713.field_7791);
        HandServiceComponent.e(to, class_1713.field_7791);
        if (var13 == null) {
            if (!(var15)) {
            }
        } else {
        }
        HandServiceComponent.executeAction(class_1713.field_7791, 1, 0);
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
                    if (var7 == null && var7 == null && var7 == null && var7 == null) {
                        if (arg0.getItem() instanceof class_1821) {
                        }
                    }
                }
            }
        } else {
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
        int var0 = getNumericValue();
        if (!(var0)) {
            return 96;
        }
        return 0;
    }

}
