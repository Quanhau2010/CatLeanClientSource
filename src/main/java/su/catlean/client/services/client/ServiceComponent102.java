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
        future = (Future) CompletableFuture.supplyAsync(this::getList, (Executor) executorService).exceptionally(this::resolveList);
    }

    public List resolveList() {
        serviceComponent10.executeAction();
        if (future != null) {
        } else {
        }
        if (future.isDone() == 1) {
            itemList = future.get();
        }
        return itemList;
    }

    public boolean checkCondition(BlockPos pos) {
        serviceComponent10.executeAction();
        Iterator iterator = this.resolveList().iterator();
        if (iterator.hasNext()) {
            SafetyServiceComponent var8 = (SafetyServiceComponent) iterator.next();
            if (Intrinsics.areEqual(pos, var8.getMinecraftObject())) {
                return true;
            }
            if (var8.getOptionMode17() == OptionMode17.DOUBLE_X && Intrinsics.areEqual(pos, var8.getMinecraftObject().method_10069(1, 0, 0))) {
                return true;
            }
            if (var8.getOptionMode17() == OptionMode17.DOUBLE_Z && Intrinsics.areEqual(pos, var8.getMinecraftObject().method_10069(0, 0, 1))) {
                return true;
            }
            if (!(Intrinsics.areEqual(pos, var8.getMinecraftObject().method_10069(0, 0, 1))) && !(Intrinsics.areEqual(pos, var8.getMinecraftObject().method_10069(1, 0, 1)))) {
            }
            return true;
        }
        return false;
    }

    public BlockState resolveMinecraftObject(int i, int j, int k) {
        class_2818 var12 = SharedKt.getWorld().method_8497((i >> 4), (k >> 4));
        int var13 = SharedKt.getWorld().method_31602(j);
        if (var11 != null) {
        }
        if (0L > 0) {
            if (var11 != null) {
                if (var11 != null) {
                }
            }
            if (var13 >= 0 && var13 < var12.method_12006() && !(var12.method_12006()[var13].method_38292())) {
            }
            return var12.method_12006()[var13].method_12254((i & 15), (j & 15), (k & 15));
        }
        return Blocks.AIR.method_9564();
        return Blocks.AIR.method_9564();
    }

    private BlockState resolveMinecraftObject(int arg0, int arg1, int arg2) {
        return this.resolveMinecraftObject(arg0, arg1, arg2);
    }

    private boolean checkCondition(int arg0, int arg1, int arg2) {
        return this.resolveMinecraftObject(arg0, arg1, arg2).method_45474();
    }

    private boolean checkCondition(class_2791 arg0, int arg1, int arg2, int arg3) {
        Block var11 = this.resolveMinecraftObject(arg1, arg2, arg3).getBlock();
        if (!(itemSet2.contains())) {
            if (itemSet.contains()) {
            }
        } else {
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
        int var19 = 0;
        int var20 = 0;
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
        if ((var19 + var20) < 2) {
            return null;
        }
        boolean var21 = this.resolveMinecraftObject(arg0, arg1, (arg2 + 1)).method_26215();
        boolean var22 = this.resolveMinecraftObject((arg0 + 1), arg1, arg2).method_26215();
        if (var21 && var22) {
            if (!(this.resolveMinecraftObject((arg0 + 1), arg1, (arg2 + 1)).method_26215())) {
                return null;
            }
            Iterator iterator = itemList2.iterator();
            while (iterator.hasNext()) {
                class_2382 var24 = (class_2382) iterator.next();
                if (this.checkCondition((arg0 + var24.method_10263()), (arg1 + var24.method_10264()), (arg2 + var24.method_10260()))) {
                }
            }
            if (var19 != 8 && var20 != 8 && (var19 + var20) != 8) {
                return null;
            }
            if (var20 == 8) {
            } else {
            }
            new BlockPos(arg0, arg1, arg2)(OptionMode12.SAFE, OptionMode12.UNSAFE, OptionMode17.QUAD);
            return new SafetyServiceComponent;
        }
        if (var21 && this.checkCondition(arg0, arg1, (arg2 + 1))) {
            iterator = itemList3.iterator();
            while (iterator.hasNext()) {
                var24 = (class_2382) iterator.next();
                if (this.checkCondition((arg0 + var24.method_10263()), (arg1 + var24.method_10264()), (arg2 + var24.method_10260()))) {
                }
            }
            if (var19 != 6 && var20 != 6 && (var19 + var20) != 6) {
                return null;
            }
            if (var20 == 6) {
            } else {
            }
            new BlockPos(arg0, arg1, arg2)(OptionMode12.SAFE, OptionMode12.UNSAFE, OptionMode17.DOUBLE_Z);
            return new SafetyServiceComponent;
        }
        if (var22 && this.checkCondition((arg0 + 1), arg1, arg2)) {
            iterator = itemList4.iterator();
            while (iterator.hasNext()) {
                var24 = (class_2382) iterator.next();
                if (this.checkCondition((arg0 + var24.method_10263()), (arg1 + var24.method_10264()), (arg2 + var24.method_10260()))) {
                }
            }
            if (var19 != 6 && var20 != 6 && (var19 + var20) != 6) {
                return null;
            }
            if (var20 == 6) {
            } else {
            }
            new BlockPos(arg0, arg1, arg2)(OptionMode12.SAFE, OptionMode12.UNSAFE, OptionMode17.DOUBLE_X);
            return new SafetyServiceComponent;
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
        if (var19 != 4 && var20 != 4 && (var19 + var20) != 4) {
            return null;
        }
        if (var20 == 4) {
        } else {
        }
        new BlockPos(arg0, arg1, arg2)(OptionMode12.SAFE, OptionMode12.UNSAFE, OptionMode17.SINGLE);
        return new SafetyServiceComponent;
    }

    private List resolveList(int arg0, char arg1, int arg2) {
        List positions = new ArrayList();
        BlockPos blockPos = BlockPos.ofFloored(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()));
        int var30 = (blockPos.method_10263() - this.computeValue());
        int var31 = (blockPos.method_10263() + this.computeValue());
        int var32 = (blockPos.method_10264() - this.computeValue());
        int var33 = (blockPos.method_10264() + this.computeValue());
        int var34 = (blockPos.method_10260() - this.computeValue());
        int var35 = (blockPos.method_10260() + this.computeValue());
        int var36 = var30;
        if (var36 <= var31) {
            int var37 = var32;
            if (arg2 >= 0) {
                if (var37 <= var33) {
                    int var38 = var34;
                    if (var38 <= var35) {
                        class_2818 var39 = SharedKt.getWorld().method_8497((var36 >> 4), (var38 >> 4));
                        BlockState state = this.resolveMinecraftObject();
                        if (!(state.method_45474())) {
                        } else {
                            if (arg2 >= 0) {
                                if (var27 != null) {
                                    if (!(this.checkCondition((var37 + 1)))) {
                                    } else {
                                    }
                                    if (arg2 > 0) {
                                    }
                                    if (!(this.checkCondition((var37 + 2)))) {
                                    } else {
                                    }
                                    if (!(this.checkCondition((class_2791) var39, (var37 - 1)))) {
                                        if (arg2 >= 0 && arg0 > 0 && arg2 > 0 && arg2 >= 0) {
                                        } else {
                                            if (this.resolveSafetyServiceComponent() != null) {
                                                SafetyServiceComponent var41 = this.resolveSafetyServiceComponent();
                                                int var42 = 0;
                                                positions.add();
                                            } else {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (arg1 >= 0) {
                            if (var27 != null) {
                                if (var38 != var35) {
                                }
                            }
                        }
                        if (arg2 > 0) {
                        }
                        if (var37 != var33) {
                        }
                    }
                }
            }
            if (var36 != var31) {
            }
        }
        return positions;
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
        Block[] var22 = new Block[4];
        var22[0] = Blocks.OBSIDIAN;
        var22[1] = Blocks.ENDER_CHEST;
        var22[2] = Blocks.NETHERITE_BLOCK;
        var22[3] = Blocks.field_22108;
        itemSet = SetsKt.setOf();
        var22 = new Block[2];
        var22[0] = Blocks.field_9987;
        var22[1] = Blocks.field_10499;
        itemSet2 = SetsKt.setOf();
        itemList = CollectionsKt.emptyList();
        var22 = new class_2382[6];
        var22[0] = new class_2382(-1, 0, 1);
        var22[1] = new class_2382(0, 0, 2);
        var22[2] = new class_2382(1, 0, 2);
        var22[3] = new class_2382(2, 0, 1);
        var22[4] = new class_2382(2, 0, 0);
        var22[5] = new class_2382(1, 0, -1);
        itemList2 = CollectionsKt.listOf();
        var22 = new class_2382[4];
        var22[0] = new class_2382(-1, 0, 1);
        var22[1] = new class_2382(0, 0, 2);
        var22[2] = new class_2382(1, 0, 1);
        var22[3] = new class_2382(1, 0, 0);
        itemList3 = CollectionsKt.listOf();
        var22 = new class_2382[4];
        var22[0] = new class_2382(0, 0, 1);
        var22[1] = new class_2382(1, 0, 1);
        var22[2] = new class_2382(2, 0, 0);
        var22[3] = new class_2382(1, 0, -1);
        itemList4 = CollectionsKt.mutableListOf();
    }

}
