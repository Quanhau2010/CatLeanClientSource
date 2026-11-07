package su.catlean.client.services.player;

import it.unimi.dsi.fastutil.longs.Long2ByteOpenHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1267;
import net.minecraft.class_1280;
import net.minecraft.class_1282;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1324;
import net.minecraft.class_1893;
import net.minecraft.class_1922;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_2378;
import net.minecraft.class_239.class_240;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_5134;
import net.minecraft.class_6880;
import net.minecraft.class_8111;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.network.PostTasksProcessEvent;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.services.client.StackServiceComponent3;
import su.catlean.client.services.network.VecPacketHelper;

public class ExplosionPosEntityHelper implements Contract9 {

    public static final ExplosionPosEntityHelper INSTANCE;
    public static final double preciseValue = -1.0E-7D;
    private static final Long2ByteOpenHashMap long2ByteOpenHashMap;
    private static final class_265 minecraftRef;
    private static class_1282 minecraftRef2;
    private static boolean enabledFlag;

    private ExplosionPosEntityHelper() {
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    private void onPostTasksProcessEvent(PostTasksProcessEvent arg0) {
        long2ByteOpenHashMap.clear();
    }

    public float computeValue(Vec3d explosionPos, PlayerEntity target, int predictTicks, boolean ignoreTerrain, List ghost, boolean solid) {
        if (predictTicks > 0) {
        } else {
        }
        Box var18 = target.method_5829();
        double var19 = (var18.method_1005().method_1031(0.0D, (var18.method_17940() / 2.0D), 0.0D).method_1022(explosionPos) / 12.0D);
        if (SharedKt.getWorld().method_8407() != class_1267.field_5801 && var19 <= 1.0D) {
            if (target.method_68878()) {
            }
            return 0.0F;
        }
        return this.computeValue(target, this.computeValue(explosionPos, ignoreTerrain, ghost, solid));
    }

    public static float computeValue(ExplosionPosEntityHelper arg0, Vec3d arg1, PlayerEntity arg2, int arg3, boolean arg4, List arg5, boolean arg6, int arg7, Object arg8) {
        if ((arg7 & 2)) {
            arg2 = (PlayerEntity) SharedKt.getPlayer();
        }
        if ((arg7 & 4)) {
            arg3 = 0;
        }
        if ((arg7 & 8)) {
            arg4 = 0;
        }
        if ((arg7 & 16)) {
            arg5 = CollectionsKt.emptyList();
        }
        if ((arg7 & 32)) {
            arg6 = 0;
        }
        return arg0.computeValue(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private float computeValue(PlayerEntity arg0, double arg1, double arg2) {
        if (minecraftRef2 == null) {
            minecraftRef2 = new class_1282((class_6880) SharedKt.getWorld().method_48963().field_42296.method_46747(class_8111.field_42331), null, null);
        }
        float var18 = this.computeValue(arg1, arg2);
        if (SharedKt.getWorld().method_8407() == class_1267.field_5805) {
            var18 = Math.min(((var18 / 2.0D) + 1.0D));
        } else {
            if (SharedKt.getWorld().method_8407() == class_1267.field_5807) {
                var18 = (var18 * 1.5F);
            }
        }
        var18 = class_1280.method_5496((LivingEntity) arg0, minecraftRef2, arg0.method_6096(), arg0.method_5996(class_5134.field_23725).method_6194());
        if (arg0.method_6059(class_1294.field_5907)) {
            int var19 = (25 - ((arg0.method_6112(class_1294.field_5907).method_5578() + 1) * 5));
            var18 = Math.max(((var18 * var19) / 25.0F), 0.0D);
        }
        if (var18 <= 0.0F) {
            var18 = 0.0F;
        } else {
            if (AutoCrystalModule.INSTANCE.getAssumeBestArmor() && !(Intrinsics.areEqual(arg0, SharedKt.getPlayer()))) {
            } else {
            }
            var19 = this.computeValue((Iterable) EntityHelper2.resolveList(arg0));
            if (var19 > 0.0F) {
                var18 = class_1280.method_5497();
            }
        }
        return var18;
    }

    private float computeValue(Iterable arg0) {
        float var2 = 0.0F;
        Object var3 = arg0;
        int var4 = 0;
        Iterator iterator = var3.iterator();
        while (iterator.hasNext()) {
            Object var6 = iterator.next();
            ItemStack stack = (ItemStack) var6;
            int var8 = 0;
            if (!(stack.isEmpty())) {
                var2 = (var2 + 8.0F);
            }
        }
        return var2;
    }

    private float computeValue(double arg0, double arg1) {
        double var5 = ((1.0D - arg0) * arg1);
        return ((((((var5 * var5) + var5) / 2.0D) * 7.0D) * 12.0D) + 1.0D);
    }

    private float computeValue(Vec3d arg0, Box arg1, boolean arg2, List arg3, boolean arg4) {
        Pair var15 = this.resolvePair(arg0, arg1, arg2, arg3, arg4);
        if (((Number) var15.getFirst() / (Number) var15.getSecond()) == 1.0F) {
            return 1.0F;
        }
        if (((Number) var15.getFirst() / (Number) var15.getSecond()) == 0.0F) {
            return 0.0F;
        }
        double var16 = (1.0D / (((arg1.field_1320 - arg1.field_1323) * 2.0D) + 1.0D));
        double var18 = (1.0D / (((arg1.field_1325 - arg1.field_1322) * 2.0D) + 1.0D));
        double var20 = (1.0D / (((arg1.field_1324 - arg1.field_1321) * 2.0D) + 1.0D));
        double var22 = ((1.0D - (Math.floor((1.0D / var16)) * var16)) / 2.0D);
        double var24 = ((1.0D - (Math.floor((1.0D / var20)) * var20)) / 2.0D);
        if (var16 >= 0.0D && var18 >= 0.0D && var20 >= 0.0D) {
            int var26 = (Number) var15.getFirst();
            int var27 = (Number) var15.getSecond();
            double var28 = 0.0D;
            if (var28 <= 1.0D) {
                double var30 = 0.0D;
                if (var30 <= 1.0D) {
                    double var32 = 0.0D;
                    if (var32 <= 1.0D) {
                        double var34 = class_3532.method_16436(arg1.field_1323, arg1.field_1320);
                        double var36 = class_3532.method_16436(arg1.field_1322, arg1.field_1325);
                        double var38 = class_3532.method_16436(arg1.field_1321, arg1.field_1324);
                        if (!(this.checkCondition())) {
                            if (this.resolveMinecraftObject(new Vec3d((var34 + var22), (var38 + var24)), arg0, arg2, arg3, arg4) == null) {
                            }
                        }
                        var32 = (var32 + var20);
                    }
                    var30 = (var30 + var18);
                }
                var28 = (var28 + var16);
            }
            return (var26 / var27);
        }
        return 0.0F;
    }

    private static float computeValue(ExplosionPosEntityHelper arg0, Vec3d arg1, Box arg2, boolean arg3, List arg4, boolean arg5, int arg6, Object arg7) {
        if ((arg6 & 8)) {
            arg4 = CollectionsKt.emptyList();
        }
        return arg0.computeValue(arg1, arg2, arg3, arg4, arg5);
    }

    private boolean checkCondition(double arg0, double arg1, double arg2) {
        int var7 = 0;
        if (var7 < 2) {
            int var8 = 0;
            if (var8 < 2) {
                int var9 = 0;
                if (var9 < 2) {
                    if (arg0 == var7 && arg1 == var8 && arg2 == var9) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Pair resolvePair(Vec3d arg0, Box arg1, boolean arg2, List arg3, boolean arg4) {
        double var10 = (1.0D / (((arg1.field_1320 - arg1.field_1323) * 2.0D) + 1.0D));
        double var12 = (1.0D / (((arg1.field_1324 - arg1.field_1321) * 2.0D) + 1.0D));
        double var14 = ((1.0D - (Math.floor((1.0D / var10)) * var10)) / 2.0D);
        double var16 = ((1.0D - (Math.floor((1.0D / var12)) * var12)) / 2.0D);
        int var18 = 0;
        int var19 = 0;
        double var20 = 0.0D;
        if (var20 <= 1.0D) {
            double var22 = 0.0D;
            if (var22 <= 1.0D) {
                double var24 = 0.0D;
                if (var24 <= 1.0D) {
                    double var26 = class_3532.method_16436(arg1.field_1323, arg1.field_1320);
                    double var28 = class_3532.method_16436(arg1.field_1322, arg1.field_1325);
                    double var30 = class_3532.method_16436(arg1.field_1321, arg1.field_1324);
                    Vec3d vec = new Vec3d((var26 + var14), (var30 + var16));
                    if (this.resolveMinecraftObject(vec, arg0, arg2, arg3, arg4) == null) {
                    }
                    var24 = (var24 + 1.0D);
                }
                var22 = (var22 + 1.0D);
            }
            var20 = (var20 + 1.0D);
        }
        return new Pair(Integer.valueOf(), Integer.valueOf());
    }

    private static Pair resolvePair(ExplosionPosEntityHelper arg0, Vec3d arg1, Box arg2, boolean arg3, List arg4, boolean arg5, int arg6, Object arg7) {
        if ((arg6 & 8)) {
            arg4 = CollectionsKt.emptyList();
        }
        return arg0.resolvePair(arg1, arg2, arg3, arg4, arg5);
    }

    private class_3965 resolveMinecraftObject(BlockPos arg0, Vec3d arg1, Vec3d arg2, boolean arg3, List arg4, boolean arg5) {
        float var12 = 0.0F;
        if (arg4.contains(arg0)) {
            return null;
        }
        long var13 = arg0.method_10063();
        if (enabledFlag) {
            class_265 var11 = this.resolveMinecraftObject();
            var12 = this.computeValue();
        } else {
            BlockState state = SharedKt.getWorld().getBlockState(arg0);
            var11 = state.method_26220((class_1922) SharedKt.getWorld(), arg0);
            var12 = state.getBlock().method_9520();
            if (!(var11.method_1110()) && !(Intrinsics.areEqual(state.getBlock(), Blocks.ENDER_CHEST))) {
                if (Intrinsics.areEqual(class_259.method_1077())) {
                }
                Map var17 = (Map) long2ByteOpenHashMap;
                Long var18 = Long.valueOf();
                Byte var19 = Byte.valueOf(this.process(state.getBlock(), var11.method_1110()));
                var17.put();
            }
        }
        if (var12 < 600.0F) {
            return null;
        }
        return var11.method_1092(arg1, arg2, arg0);
    }

    private static class_3965 resolveMinecraftObject(ExplosionPosEntityHelper arg0, BlockPos arg1, Vec3d arg2, Vec3d arg3, boolean arg4, List arg5, boolean arg6, int arg7, Object arg8) {
        if ((arg7 & 8)) {
            arg4 = 0;
        }
        if ((arg7 & 16)) {
            arg5 = CollectionsKt.emptyList();
        }
        if ((arg7 & 32)) {
            arg6 = 1;
        }
        return arg0.resolveMinecraftObject(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private float computeValue(byte arg0) {
        int var2 = arg0;
        if (var2 != 1) {
            if (var2 == 2) {
            }
        } else {
        }
        return 600.0F;
    }

    private class_265 resolveMinecraftObject(byte arg0) {
        int var3 = arg0;
        if (var3 == 1) {
        } else {
            if (var3 == 4) {
            } else {
            }
        }
        class_265 var2 = class_259.method_1077();
        return var2;
    }

    private byte process(Block arg0, boolean arg1) {
        return 1;
        if (Intrinsics.areEqual(arg0, Blocks.ENDER_CHEST)) {
            return 4;
        }
        if (arg0.method_9520() >= 600.0F) {
            return 3;
        }
        return 2;
    }

    public class_3965 resolveMinecraftObject(Vec3d start, Vec3d end, boolean ignoreTerrain, List ghost, boolean solid) {
        if (Intrinsics.areEqual(start, end)) {
            return null;
        }
        double var10 = class_3532.method_16436(-1.0E-7D, end.field_1352, start.field_1352);
        double var12 = class_3532.method_16436(-1.0E-7D, end.field_1351, start.field_1351);
        double var14 = class_3532.method_16436(-1.0E-7D, end.field_1350, start.field_1350);
        double var16 = class_3532.method_16436(-1.0E-7D, start.field_1352, end.field_1352);
        double var18 = class_3532.method_16436(-1.0E-7D, start.field_1351, end.field_1351);
        double var20 = class_3532.method_16436(-1.0E-7D, start.field_1350, end.field_1350);
        int var22 = class_3532.method_15357();
        int var23 = class_3532.method_15357();
        int var24 = class_3532.method_15357();
        class_2339 var25 = new class_2339();
        return var26;
        double var27 = (var10 - var16);
        double var29 = (var12 - var18);
        double var31 = (var14 - var20);
        int var36 = (var33 / var27);
        int var38 = (var34 / var29);
        int var40 = (var35 / var31);
        double var42 = (var36 * class_3532.method_15385());
        double var44 = (var38 * class_3532.method_15385());
        double var46 = (var40 * class_3532.method_15385());
        if (var42 > 1.0D && var44 > 1.0D) {
            if (var46 <= 1.0D) {
            }
            if (var42 < var44) {
                if (var42 < var46) {
                    var22 = (var22 + var33);
                    var42 = (var42 + var36);
                } else {
                    var24 = (var24 + var35);
                    var46 = (var46 + var40);
                } else {
                    if (var44 < var46) {
                        var23 = (var23 + var34);
                        var44 = (var44 + var38);
                    } else {
                        var24 = (var24 + var35);
                        var46 = (var46 + var40);
                    }
                }
            }
            class_3965 var48 = this.resolveMinecraftObject((BlockPos) var25.method_10103(), start, end, ignoreTerrain, ghost, solid);
            Object var49 = var48;
            int var50 = 0;
            return var49;
        }
        return null;
    }

    public static class_3965 resolveMinecraftObject(ExplosionPosEntityHelper arg0, Vec3d arg1, Vec3d arg2, boolean arg3, List arg4, boolean arg5, int arg6, Object arg7) {
        if ((arg6 & 4)) {
            arg3 = 0;
        }
        if ((arg6 & 8)) {
            arg4 = CollectionsKt.emptyList();
        }
        if ((arg6 & 16)) {
            arg5 = 1;
        }
        return arg0.resolveMinecraftObject(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean checkCondition(Vec3d point) {
        if (resolveMinecraftObject(this, VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()), point) != null) {
            if (resolveMinecraftObject(this, VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()), point).method_17783() == null) {
            }
            resolveMinecraftObject(this, VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()), point).method_17783();
        }
        return class_240.field_1333 == class_240.field_1333;
    }

    private int computeValue(Iterable arg0) {
        int var6 = 0;
        Object var7 = arg0;
        int var8 = 0;
        Iterator iterator = var7.iterator();
        while (iterator.hasNext()) {
            Object var10 = iterator.next();
            ItemStack stack = (ItemStack) var10;
            int var12 = 0;
            var6 = (var6 + INSTANCE.computeValue(stack));
        }
        return var6;
    }

    private int computeValue(ItemStack arg0) {
        if (arg0 != null) {
            if (arg0.isEmpty()) {
            }
            return 0;
        }
        int var6 = StackServiceComponent3.computeValue(arg0, class_1893.field_9107);
        int var7 = StackServiceComponent3.computeValue(arg0, class_1893.field_9111);
        return ((var6 * 2) + var7);
    }

    static {
        INSTANCE = new ExplosionPosEntityHelper();
        long2ByteOpenHashMap = new Long2ByteOpenHashMap();
        minecraftRef = Block.method_66404(14.0D, 0.0D, 14.0D);
        enabledFlag = 1;
    }

}
