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
        Box box = target.method_5829();
        double offset = (box.method_1005().method_1031(0.0D, (box.method_17940() / 2.0D), 0.0D).method_1022(explosionPos) / 12.0D);
        if (SharedKt.getWorld().method_8407() != class_1267.field_5801 && offset <= 1.0D) {
            if (target.method_68878()) {
                return 0.0F;
            }
        }
        return this.computeValue(target, offset, this.computeValue(explosionPos, box, ignoreTerrain, ghost, solid));
    }

    public static float computeValue(ExplosionPosEntityHelper arg0, Vec3d arg1, PlayerEntity arg2, int arg3, boolean arg4, List arg5, boolean arg6, int arg7, Object arg8) {
        if ((arg7 & 2) != 0) {
            arg2 = ((PlayerEntity) SharedKt.getPlayer());
        }
        if ((arg7 & 4) != 0) {
            arg3 = 0;
        }
        if ((arg7 & 8) != 0) {
            arg4 = 0;
        }
        if ((arg7 & 16) != 0) {
            arg5 = CollectionsKt.emptyList();
        }
        if ((arg7 & 32) != 0) {
            arg6 = 0;
        }
        return arg0.computeValue(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private float computeValue(PlayerEntity arg0, double arg1, double arg2) {
        if (minecraftRef2 == null) {
            minecraftRef2 = new class_1282(((class_6880) SharedKt.getWorld().method_48963().field_42296.method_46747(class_8111.field_42331)), null, null);
        }
        float factor = this.computeValue(arg1, arg2);
        if (SharedKt.getWorld().method_8407() == class_1267.field_5805) {
            factor = Math.min(((factor / 2.0D) + 1.0D), factor);
        } else {
            if (SharedKt.getWorld().method_8407() == class_1267.field_5807) {
                factor = (factor * 1.5F);
            }
        }
        factor = class_1280.method_5496(((LivingEntity) arg0), factor, minecraftRef2, arg0.method_6096(), arg0.method_5996(class_5134.field_23725).method_6194());
        if (arg0.method_6059(class_1294.field_5907)) {
            int index = (25 - ((arg0.method_6112(class_1294.field_5907).method_5578() + 1) * 5));
            factor = Math.max(((factor * index) / 25.0F), 0.0D);
        }
        if (factor <= 0.0F) {
            factor = 0.0F;
        } else {
            if (AutoCrystalModule.INSTANCE.getAssumeBestArmor() && !(Intrinsics.areEqual(arg0, SharedKt.getPlayer()))) {
            } else {
            }
            index = this.computeValue(((Iterable) EntityHelper2.resolveList(arg0)));
            if (index > 0.0F) {
                factor = class_1280.method_5497(factor, index);
            }
        }
        return factor;
    }

    private float computeValue(Iterable arg0) {
        float factor = 0.0F;
        Iterator iterator = arg0.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ItemStack stack = ((ItemStack) element);
            if (!(stack.isEmpty())) {
                factor = (factor + 8.0F);
            }
        }
        return factor;
    }

    private float computeValue(double arg0, double arg1) {
        double offset = ((1.0D - arg0) * arg1);
        return ((((((offset * offset) + offset) / 2.0D) * 7.0D) * 12.0D) + 1.0D);
    }

    private float computeValue(Vec3d arg0, Box arg1, boolean arg2, List arg3, boolean arg4) {
        Pair pair = this.resolvePair(arg0, arg1, arg2, arg3, arg4);
        if ((((Number) pair.getFirst()) / ((Number) pair.getSecond())) == 1.0F) {
            return 1.0F;
        }
        if ((((Number) pair.getFirst()) / ((Number) pair.getSecond())) == 0.0F) {
            return 0.0F;
        }
        double offset = (1.0D / (((arg1.field_1320 - arg1.field_1323) * 2.0D) + 1.0D));
        double offset2 = (1.0D / (((arg1.field_1325 - arg1.field_1322) * 2.0D) + 1.0D));
        double offset3 = (1.0D / (((arg1.field_1324 - arg1.field_1321) * 2.0D) + 1.0D));
        double offset4 = ((1.0D - (Math.floor((1.0D / offset)) * offset)) / 2.0D);
        double offset5 = ((1.0D - (Math.floor((1.0D / offset3)) * offset3)) / 2.0D);
        if (offset >= 0.0D && offset2 >= 0.0D && offset3 >= 0.0D) {
            int index = ((Number) pair.getFirst());
            int index2 = ((Number) pair.getSecond());
            double offset6 = 0.0D;
            if (offset6 <= 1.0D) {
                double offset7 = 0.0D;
                if (offset7 <= 1.0D) {
                    double offset8 = 0.0D;
                    if (offset8 <= 1.0D) {
                        double offset9 = class_3532.method_16436(offset6, arg1.field_1323, arg1.field_1320);
                        double offset10 = class_3532.method_16436(offset7, arg1.field_1322, arg1.field_1325);
                        double offset11 = class_3532.method_16436(offset8, arg1.field_1321, arg1.field_1324);
                        if (!(this.checkCondition(offset6, offset7, offset8))) {
                            if (this.resolveMinecraftObject(new Vec3d((offset9 + offset4), offset10, (offset11 + offset5)), arg0, arg2, arg3, arg4) == null) {
                            }
                        }
                        offset8 = (offset8 + offset3);
                    }
                    offset7 = (offset7 + offset2);
                }
                offset6 = (offset6 + offset);
            }
            return (index / index2);
        }
        return 0.0F;
    }

    private static float computeValue(ExplosionPosEntityHelper arg0, Vec3d arg1, Box arg2, boolean arg3, List arg4, boolean arg5, int arg6, Object arg7) {
        if ((arg6 & 8) != 0) {
            arg4 = CollectionsKt.emptyList();
        }
        return arg0.computeValue(arg1, arg2, arg3, arg4, arg5);
    }

    private boolean checkCondition(double arg0, double arg1, double arg2) {
        int index = 0;
        if (index < 2) {
            int index2 = 0;
            if (index2 < 2) {
                int index3 = 0;
                if (index3 < 2) {
                    if (arg0 == index && arg1 == index2 && arg2 == index3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Pair resolvePair(Vec3d arg0, Box arg1, boolean arg2, List arg3, boolean arg4) {
        double offset = (1.0D / (((arg1.field_1320 - arg1.field_1323) * 2.0D) + 1.0D));
        double offset2 = (1.0D / (((arg1.field_1324 - arg1.field_1321) * 2.0D) + 1.0D));
        double offset3 = ((1.0D - (Math.floor((1.0D / offset)) * offset)) / 2.0D);
        double offset4 = ((1.0D - (Math.floor((1.0D / offset2)) * offset2)) / 2.0D);
        int index = 0;
        int index2 = 0;
        double offset5 = 0.0D;
        if (offset5 <= 1.0D) {
            double offset6 = 0.0D;
            if (offset6 <= 1.0D) {
                double offset7 = 0.0D;
                if (offset7 <= 1.0D) {
                    double offset8 = class_3532.method_16436(offset5, arg1.field_1323, arg1.field_1320);
                    double offset9 = class_3532.method_16436(offset6, arg1.field_1322, arg1.field_1325);
                    double offset10 = class_3532.method_16436(offset7, arg1.field_1321, arg1.field_1324);
                    Vec3d vec = new Vec3d((offset8 + offset3), offset9, (offset10 + offset4));
                    if (this.resolveMinecraftObject(vec, arg0, arg2, arg3, arg4) == null) {
                    }
                    offset7 = (offset7 + 1.0D);
                }
                offset6 = (offset6 + 1.0D);
            }
            offset5 = (offset5 + 1.0D);
        }
        return new Pair(Integer.valueOf(index), Integer.valueOf(index2));
    }

    private static Pair resolvePair(ExplosionPosEntityHelper arg0, Vec3d arg1, Box arg2, boolean arg3, List arg4, boolean arg5, int arg6, Object arg7) {
        if ((arg6 & 8) != 0) {
            arg4 = CollectionsKt.emptyList();
        }
        return arg0.resolvePair(arg1, arg2, arg3, arg4, arg5);
    }

    private class_3965 resolveMinecraftObject(BlockPos arg0, Vec3d arg1, Vec3d arg2, boolean arg3, List arg4, boolean arg5) {
        float factor = 0.0F;
        if (arg4.contains(arg0)) {
            return null;
        }
        long time = arg0.method_10063();
        if (enabledFlag) {
            class_265 class265 = this.resolveMinecraftObject();
            factor = this.computeValue();
        } else {
            BlockState state = SharedKt.getWorld().getBlockState(arg0);
            class265 = state.method_26220(((class_1922) SharedKt.getWorld()), arg0);
            factor = state.getBlock().method_9520();
            if (!(class265.method_1110()) && !(Intrinsics.areEqual(state.getBlock(), Blocks.ENDER_CHEST))) {
                if (Intrinsics.areEqual(class265, class_259.method_1077())) {
                    Map map = ((Map) long2ByteOpenHashMap);
                    Long value = Long.valueOf(time);
                    Byte value2 = Byte.valueOf(this.process(state.getBlock(), class265.method_1110()));
                    map.put(value, value2);
                }
            }
        }
        if (factor < 600.0F) {
            return null;
        }
        return class265.method_1092(arg1, arg2, arg0);
    }

    private static class_3965 resolveMinecraftObject(ExplosionPosEntityHelper arg0, BlockPos arg1, Vec3d arg2, Vec3d arg3, boolean arg4, List arg5, boolean arg6, int arg7, Object arg8) {
        if ((arg7 & 8) != 0) {
            arg4 = 0;
        }
        if ((arg7 & 16) != 0) {
            arg5 = CollectionsKt.emptyList();
        }
        if ((arg7 & 32) != 0) {
            arg6 = 1;
        }
        return arg0.resolveMinecraftObject(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private float computeValue(byte arg0) {
        if (arg0 != 1) {
            if (arg0 == 2) {
            } else {
            }
        }
        return 600.0F;
    }

    private class_265 resolveMinecraftObject(byte arg0) {
        if (arg0 == 1) {
        } else {
            if (arg0 == 4) {
            } else {
            }
        }
        class_265 class265 = class_259.method_1077();
        return class265;
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
        double offset = class_3532.method_16436(-1.0E-7D, end.field_1352, start.field_1352);
        double offset2 = class_3532.method_16436(-1.0E-7D, end.field_1351, start.field_1351);
        double offset3 = class_3532.method_16436(-1.0E-7D, end.field_1350, start.field_1350);
        double offset4 = class_3532.method_16436(-1.0E-7D, start.field_1352, end.field_1352);
        double offset5 = class_3532.method_16436(-1.0E-7D, start.field_1351, end.field_1351);
        double offset6 = class_3532.method_16436(-1.0E-7D, start.field_1350, end.field_1350);
        int index = class_3532.method_15357(offset4);
        int index2 = class_3532.method_15357(offset5);
        int index3 = class_3532.method_15357(offset6);
        class_2339 class2339 = new class_2339(index, index2, index3);
        return __UNDEF_KEY__;
        double offset7 = (offset - offset4);
        double offset8 = (offset2 - offset5);
        double offset9 = (offset3 - offset6);
        if (__UNDEF_KEY__ > 1.0D && __UNDEF_KEY__ > 1.0D) {
            if (__UNDEF_KEY__ <= 1.0D) {
                if (__UNDEF_KEY__ < __UNDEF_KEY__) {
                    if (__UNDEF_KEY__ < __UNDEF_KEY__) {
                    } else {
                        if (__UNDEF_KEY__ < __UNDEF_KEY__) {
                        } else {
                        }
                    }
                } else {
                }
                class_3965 class3965 = this.resolveMinecraftObject(((BlockPos) class2339.method_10103(index, index2, index3)), start, end, ignoreTerrain, ghost, solid);
                return class3965;
            }
        }
        return null;
    }

    public static class_3965 resolveMinecraftObject(ExplosionPosEntityHelper arg0, Vec3d arg1, Vec3d arg2, boolean arg3, List arg4, boolean arg5, int arg6, Object arg7) {
        if ((arg6 & 4) != 0) {
            arg3 = 0;
        }
        if ((arg6 & 8) != 0) {
            arg4 = CollectionsKt.emptyList();
        }
        if ((arg6 & 16) != 0) {
            arg5 = 1;
        }
        return arg0.resolveMinecraftObject(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean checkCondition(Vec3d point) {
        if (resolveMinecraftObject(this, VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()), point, false, null, false) != null) {
            if (resolveMinecraftObject(this, VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()), point, false, null, false).method_17783() == null) {
                resolveMinecraftObject(this, VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()), point, false, null, false).method_17783();
            }
        }
        return class_240.field_1333 == class_240.field_1333;
    }

    private int computeValue(Iterable arg0) {
        int index = 0;
        Iterator iterator = arg0.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ItemStack stack = ((ItemStack) element);
            index = (index + INSTANCE.computeValue(stack));
        }
        return index;
    }

    private int computeValue(ItemStack arg0) {
        if (arg0 != null) {
            if (arg0.isEmpty()) {
                return 0;
            }
        }
        int index = StackServiceComponent3.computeValue(arg0, class_1893.field_9107);
        int index2 = StackServiceComponent3.computeValue(arg0, class_1893.field_9111);
        return ((index * 2) + index2);
    }

    static {
        INSTANCE = new ExplosionPosEntityHelper();
        long2ByteOpenHashMap = new Long2ByteOpenHashMap();
        minecraftRef = Block.method_66404(14.0D, 0.0D, 14.0D);
        enabledFlag = 1;
    }

}
