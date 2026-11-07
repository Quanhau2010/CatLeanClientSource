package su.catlean.client.services.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_2382;
import net.minecraft.class_2791;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.movement.basic.AntiKnockBackModule;
import su.catlean.client.features.modules.movement.basic.HoleAnchorModule;
import su.catlean.client.features.modules.render.esp.HoleEspModule;
import su.catlean.client.types.OptionMode12;
import su.catlean.client.types.OptionMode17;

public class ServiceComponent102 implements Contract9 {

    public static final ServiceComponent102 INSTANCE;
    private static final ExecutorService executorService;
    private static Future future;
    private static final ServiceComponent10 serviceComponent10;
    private static final Set itemSet;
    private static final Set itemSet2;
    private static List itemList;
    private static final List itemList2;
    private static final List itemList3;
    private static final List itemList4;

    private ServiceComponent102() {
    }

    private int computeValue() {
        return Math.min(32, Math.max(HoleAnchorModule.INSTANCE.getHRange(), HoleEspModule.INSTANCE.getRangeXZ()));
    }

    private int computeValue() {
        return Math.min(32, Math.max(HoleAnchorModule.INSTANCE.getVRange(), HoleEspModule.INSTANCE.getRangeY()));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (serviceComponent10.checkCondition(1000)) {
            itemList = CollectionsKt.emptyList();
            return;
        }
        future = ((Future) CompletableFuture.supplyAsync(this::getList, ((Executor) executorService)).exceptionally(this::resolveList));
    }

    public List resolveList() {
        serviceComponent10.executeAction();
        if (future != null) {
        } else {
            if (future.isDone() == 1) {
                itemList = future.get();
            }
        }
        return itemList;
    }

    public boolean checkCondition(BlockPos pos) {
        serviceComponent10.executeAction();
        Iterator iterator = this.resolveList().iterator();
        while (iterator.hasNext()) {
            SafetyServiceComponent safetyServiceComponent = ((SafetyServiceComponent) iterator.next());
            if (Intrinsics.areEqual(pos, safetyServiceComponent.getMinecraftObject())) {
                return true;
            }
            if (safetyServiceComponent.getOptionMode17() == OptionMode17.DOUBLE_X && Intrinsics.areEqual(pos, safetyServiceComponent.getMinecraftObject().method_10069(1, 0, 0))) {
                return true;
            }
            if (safetyServiceComponent.getOptionMode17() == OptionMode17.DOUBLE_Z && Intrinsics.areEqual(pos, safetyServiceComponent.getMinecraftObject().method_10069(0, 0, 1))) {
                return true;
            }
            if (!(Intrinsics.areEqual(pos, safetyServiceComponent.getMinecraftObject().method_10069(0, 0, 1))) && !(Intrinsics.areEqual(pos, safetyServiceComponent.getMinecraftObject().method_10069(1, 0, 1)))) {
            }
            return true;
        }
        return false;
    }

    public BlockState resolveMinecraftObject(int i, int j, int k) {
        class_2818 class2818 = SharedKt.getWorld().method_8497((i >> 4), (k >> 4));
        int index = SharedKt.getWorld().method_31602(j);
        if (__UNDEF_KEY__ > 0) {
        }
        if (index < class2818.method_12006() && !(class2818.method_12006()[index].method_38292())) {
            return class2818.method_12006()[index].method_12254((i & 15), (j & 15), (k & 15));
        }
        return Blocks.AIR.method_9564();
        class2818 = index;
        return Blocks.AIR.method_9564();
    }

    private BlockState resolveMinecraftObject(int arg0, int arg1, int arg2) {
        return this.resolveMinecraftObject(arg0, arg1, arg2);
    }

    private boolean checkCondition(int arg0, int arg1, int arg2) {
        return this.resolveMinecraftObject(arg0, arg1, arg2).method_45474();
    }

    private boolean checkCondition(class_2791 arg0, int arg1, int arg2, int arg3) {
        Block block = this.resolveMinecraftObject(arg1, arg2, arg3).getBlock();
        if (!(itemSet2.contains(block))) {
            if (itemSet.contains(block)) {
            } else {
            }
        }
        return false;
    }

    private boolean checkCondition(int arg0, int arg1, int arg2) {
        return itemSet2.contains(this.resolveMinecraftObject(arg0, arg1, arg2).getBlock());
    }

    private boolean checkCondition(int arg0, int arg1, int arg2) {
        return itemSet.contains(this.resolveMinecraftObject(arg0, arg1, arg2).getBlock());
    }

    private SafetyServiceComponent resolveSafetyServiceComponent(int arg0, int arg1, int arg2) {
        int index = 0;
        int index2 = 0;
        if (this.checkCondition((arg0 - 1), arg1, arg2)) {
        } else {
            if (this.checkCondition((arg0 - 1), arg1, arg2)) {
            }
        }
        if (this.checkCondition(arg0, arg1, (arg2 - 1))) {
        } else {
            if (this.checkCondition(arg0, arg1, (arg2 - 1))) {
            }
        }
        if ((index + index2) < 2) {
            return null;
        }
        boolean flag = this.resolveMinecraftObject(arg0, arg1, (arg2 + 1)).method_26215();
        boolean flag2 = this.resolveMinecraftObject((arg0 + 1), arg1, arg2).method_26215();
        if (flag && flag2) {
            if (!(this.resolveMinecraftObject((arg0 + 1), arg1, (arg2 + 1)).method_26215())) {
                return null;
            }
            Iterator iterator = itemList2.iterator();
            while (iterator.hasNext()) {
                class_2382 class2382 = ((class_2382) iterator.next());
                if (this.checkCondition((arg0 + class2382.method_10263()), (arg1 + class2382.method_10264()), (arg2 + class2382.method_10260()))) {
                }
            }
            if (index != 8 && index2 != 8 && (index + index2) != 8) {
                return null;
            }
            if (index2 == 8) {
            } else {
            }
            return new SafetyServiceComponent(OptionMode12.SAFE, OptionMode12.UNSAFE, OptionMode17.QUAD);
        }
        if (flag && this.checkCondition(arg0, arg1, (arg2 + 1))) {
            iterator = itemList3.iterator();
            while (iterator.hasNext()) {
                class2382 = ((class_2382) iterator.next());
                if (this.checkCondition((arg0 + class2382.method_10263()), (arg1 + class2382.method_10264()), (arg2 + class2382.method_10260()))) {
                }
            }
            if (index != 6 && index2 != 6 && (index + index2) != 6) {
                return null;
            }
            if (index2 == 6) {
            } else {
            }
            return new SafetyServiceComponent(OptionMode12.SAFE, OptionMode12.UNSAFE, OptionMode17.DOUBLE_Z);
        }
        if (flag2 && this.checkCondition((arg0 + 1), arg1, arg2)) {
            iterator = itemList4.iterator();
            while (iterator.hasNext()) {
                class2382 = ((class_2382) iterator.next());
                if (this.checkCondition((arg0 + class2382.method_10263()), (arg1 + class2382.method_10264()), (arg2 + class2382.method_10260()))) {
                }
            }
            if (index != 6 && index2 != 6 && (index + index2) != 6) {
                return null;
            }
            if (index2 == 6) {
            } else {
            }
            return new SafetyServiceComponent(OptionMode12.SAFE, OptionMode12.UNSAFE, OptionMode17.DOUBLE_X);
        }
        if (this.checkCondition(arg0, arg1, (arg2 + 1))) {
        } else {
            if (this.checkCondition(arg0, arg1, (arg2 + 1))) {
            }
        }
        if (this.checkCondition((arg0 + 1), arg1, arg2)) {
        } else {
            if (this.checkCondition((arg0 + 1), arg1, arg2)) {
            }
        }
        if (index != 4 && index2 != 4 && (index + index2) != 4) {
            return null;
        }
        if (index2 == 4) {
        } else {
        }
        return new SafetyServiceComponent(OptionMode12.SAFE, OptionMode12.UNSAFE, OptionMode17.SINGLE);
    }

    private List resolveList(int arg0, char arg1, int arg2) {
        List list = new ArrayList();
        BlockPos blockPos = BlockPos.ofFloored(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()));
        int index = (blockPos.method_10263() - this.computeValue());
        int index2 = (blockPos.method_10263() + this.computeValue());
        int index3 = (blockPos.method_10264() - this.computeValue());
        int index4 = (blockPos.method_10264() + this.computeValue());
        int index5 = (blockPos.method_10260() - this.computeValue());
        int index6 = (blockPos.method_10260() + this.computeValue());
        int index7 = index;
        if (index7 <= index2) {
            int index8 = index3;
            if (arg2 >= 0) {
                if (index8 <= index4) {
                    int index9 = index5;
                    if (index9 <= index6) {
                        class_2818 class2818 = SharedKt.getWorld().method_8497((index7 >> 4), (index9 >> 4));
                        BlockState state = this.resolveMinecraftObject(index7, index8, index9);
                        if (!(state.method_45474())) {
                        } else {
                            if (arg2 >= 0) {
                                if (__UNDEF_KEY__ != null) {
                                    if (!(this.checkCondition(index7, (index8 + 1), index9))) {
                                    } else {
                                        if (arg2 > 0) {
                                            if (!(this.checkCondition(index7, (index8 + 2), index9))) {
                                            } else {
                                                if (!(this.checkCondition(((class_2791) class2818), index7, (index8 - 1), index9))) {
                                                    if (arg2 >= 0 && arg0 > 0 && arg2 > 0 && arg2 >= 0) {
                                                        if (this.resolveSafetyServiceComponent(index7, index8, index9) != null) {
                                                            SafetyServiceComponent safetyServiceComponent = this.resolveSafetyServiceComponent(index7, index8, index9);
                                                            list.add(safetyServiceComponent);
                                                        } else {
                                                        }
                                                    }
                                                } else {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (arg1 >= 0) {
                            if (__UNDEF_KEY__ != null) {
                                if (index9 != index6) {
                                }
                            }
                            if (arg2 > 0) {
                                if (index8 != index4) {
                                }
                            }
                        }
                    }
                }
            }
            if (index7 != index2) {
            }
        }
        return list;
    }

    private static List getList() {
        return INSTANCE.resolveList();
    }

    private static List resolveList(Throwable arg0) {
        return CollectionsKt.emptyList();
    }

    static {
        INSTANCE = new ServiceComponent102();
        executorService = Executors.newVirtualThreadPerTaskExecutor();
        serviceComponent10 = new ServiceComponent10();
        Block[] items = new Block[4];
        items[0] = Blocks.OBSIDIAN;
        items[1] = Blocks.ENDER_CHEST;
        items[2] = Blocks.NETHERITE_BLOCK;
        items[3] = Blocks.field_22108;
        itemSet = SetsKt.setOf(items);
        items = new Block[2];
        items[0] = Blocks.field_9987;
        items[1] = Blocks.field_10499;
        itemSet2 = SetsKt.setOf(items);
        itemList = CollectionsKt.emptyList();
        items = new class_2382[6];
        items[0] = new class_2382(-1, 0, 1);
        items[1] = new class_2382(0, 0, 2);
        items[2] = new class_2382(1, 0, 2);
        items[3] = new class_2382(2, 0, 1);
        items[4] = new class_2382(2, 0, 0);
        items[5] = new class_2382(1, 0, -1);
        itemList2 = CollectionsKt.listOf(items);
        items = new class_2382[4];
        items[0] = new class_2382(-1, 0, 1);
        items[1] = new class_2382(0, 0, 2);
        items[2] = new class_2382(1, 0, 1);
        items[3] = new class_2382(1, 0, 0);
        itemList3 = CollectionsKt.listOf(items);
        items = new class_2382[4];
        items[0] = new class_2382(0, 0, 1);
        items[1] = new class_2382(1, 0, 1);
        items[2] = new class_2382(2, 0, 0);
        items[3] = new class_2382(1, 0, -1);
        itemList4 = CollectionsKt.mutableListOf(items);
    }

}
