package su.catlean.client.services.network;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1303;
import net.minecraft.class_1542;
import net.minecraft.class_1661;
import net.minecraft.class_1675;
import net.minecraft.class_1922;
import net.minecraft.class_2237;
import net.minecraft.class_2269;
import net.minecraft.class_2323;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_239.class_240;
import net.minecraft.class_2401;
import net.minecraft.class_2533;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2879;
import net.minecraft.class_2885;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_7202;
import net.minecraft.class_7204;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.BlockPlacementInteractMode;
import su.catlean.client.features.modules.BlockPlacementPlaceMode;
import su.catlean.client.features.modules.BlockPlacementSwitchMode;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.player.BoxShrinkerModule;
import su.catlean.client.services.client.DirServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.PositionServiceComponent;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.RotationRotationServiceComponent4Impl2;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.ServiceComponent18;
import su.catlean.client.services.client.ServiceComponent45;
import su.catlean.client.services.client.ServiceComponent9;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.ViafabricplusServiceComponent;
import su.catlean.client.services.player.EntityHelper;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.types.OptionMode15;
import su.catlean.client.types.mappings.BlockPlacementSwitchModeWhenMappings;

public class VecPacketHelper implements Contract9 {

    public static final VecPacketHelper INSTANCE;
    private static final Map lookupMap;
    private static final Map lookupMap2;
    private static Vec3d vec3d;
    private static int[] countValueArray;

    private VecPacketHelper() {
    }

    public Map getMap() {
        return lookupMap2;
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        Map map = ((Map) new HashMap(lookupMap2));
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            BlockPos blockPos = ((BlockPos) entry.getKey());
            long time = ((Number) entry.getValue()).longValue();
            if (__UNDEF_KEY__ == null) {
                if ((System.currentTimeMillis() - time) > (TheNetherPacketHelper.f() * 2.0F)) {
                    lookupMap2.remove(blockPos);
                }
            }
        }
        vec3d = SharedKt.getPlayer().getEyePos();
    }

    public boolean checkCondition(Vec3d vec) {
        return ExplosionPosEntityHelper.resolveMinecraftObject(vec3d, vec, false, null, false) == null;
    }

    public Vec3d resolveMinecraftObject(Entity entity) {
        if (__UNDEF_KEY__ == null) {
            if (Intrinsics.areEqual(entity, SharedKt.getPlayer())) {
                return vec3d;
            }
        }
        return entity.getEyePos();
    }

    public RotationServiceComponent4 resolveRotationServiceComponent4(BlockPos bp, int slot, BlockPlacementInteractMode interact, BlockPlacementPlaceMode mode, OptionMode15 ignore, float range, float wallRange, int priority, BlockPlacementSwitchMode switchParam, List calcGhost, boolean grim) {
        if (__UNDEF_KEY__ == null) {
            if (this.resolveMinecraftObject(bp, slot, interact, ignore, range, wallRange, calcGhost) == null) {
                this.resolveMinecraftObject(bp, slot, interact, ignore, range, wallRange, calcGhost);
                return null;
            }
        }
        Function0 function0 = this::resolveUnit;
        if (interact == BlockPlacementInteractMode.GRIM) {
        }
        return new RotationServiceComponent4(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(this.method_17784()).resolveMoveFixServiceComponent(grim), priority, function0);
    }

    public static RotationServiceComponent4 resolveRotationServiceComponent4(VecPacketHelper arg0, BlockPos arg1, int arg2, BlockPlacementInteractMode arg3, BlockPlacementPlaceMode arg4, OptionMode15 arg5, float arg6, float arg7, int arg8, BlockPlacementSwitchMode arg9, List arg10, boolean arg11, int arg12, Object arg13) {
        if ((arg12 & 512) != 0) {
            arg10 = new ArrayList();
        }
        if ((arg12 & 1024) != 0) {
            arg11 = 0;
        }
        return arg0.resolveRotationServiceComponent4(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public boolean checkCondition(BlockPos bp, BlockPlacementInteractMode interact, OptionMode15 ignore, float range, float wallRange) {
        if (__UNDEF_KEY__ == null) {
            if (lookupMap2.containsKey(bp)) {
                return false;
            }
        }
        return resolveMinecraftObject(this, bp, -1, interact, ignore, range, wallRange) != null;
    }

    public void executeAction(class_7204 packetCreator) {
        AutoCloseable autoCloseable = ((AutoCloseable) SharedKt.getWorld().method_41925().method_41937());
        class_7202 class7202 = ((class_7202) autoCloseable);
        int index = 0;
        SharedKt.getPlayer().field_3944.method_52787(packetCreator.predict(class7202.method_41942()));
        class7202 = Unit.INSTANCE;
        AutoCloseableKt.closeFinally(autoCloseable);
        int index2 = index;
        AutoCloseableKt.closeFinally(autoCloseable, index2);
    }

    public class_3965 resolveMinecraftObject(BlockPos bp, int slot, BlockPlacementInteractMode interact, OptionMode15 ignore, float range, float wallRange, List calcGhost) {
        if (ServiceComponent45.INSTANCE.checkCondition(bp)) {
            return null;
        }
        if (BoxShrinkerModule.INSTANCE.getEnabled()) {
        }
        List<BlockPos> list = Lists.newArrayList(((Iterable) Entity.class.method_18467(new Box(bp).method_1009(-1.0E-12D, 0.0D, -1.0E-12D), new Box(bp))));
        if (__UNDEF_KEY__ == null) {
            if (ignore == OptionMode15.ALL) {
                Iterable iterable = ((Iterable) list);
                int index = 0;
                Iterable iterable2 = iterable;
                Collection collection = ((Collection) new ArrayList());
                int index2 = 0;
                Iterator iterator = iterable2.iterator();
                while (iterator.hasNext()) {
                    Object element = iterator.next();
                    Entity entity = element;
                    if (__UNDEF_KEY__ == null) {
                        if (__UNDEF_KEY__ == null) {
                        }
                        if (__UNDEF_KEY__ == null) {
                            if (!(entity instanceof class_1542) && !(entity instanceof class_1303)) {
                            } else {
                            }
                        }
                        collection.add(element);
                        Iterator iterator2 = collection.iterator();
                        if (__UNDEF_KEY__ == null) {
                            while (iterator2.hasNext()) {
                                iterable = iterator2.next();
                                return null;
                            }
                        }
                        if (ignore == OptionMode15.ONLY_CRYSTALS) {
                            iterable = ((Iterable) list);
                            index = 0;
                            iterable2 = iterable;
                            collection = ((Collection) new ArrayList());
                            index2 = 0;
                            iterator = iterable2.iterator();
                            while (iterator.hasNext()) {
                                element = iterator.next();
                                entity = element;
                                if (__UNDEF_KEY__ == null) {
                                    if (__UNDEF_KEY__ == null) {
                                    }
                                    if (__UNDEF_KEY__ == null) {
                                    }
                                    if (__UNDEF_KEY__ == null) {
                                        if (!(entity instanceof EndCrystalEntity) && !(entity instanceof class_1542) && !(entity instanceof class_1303)) {
                                        } else {
                                        }
                                    }
                                    collection.add(element);
                                    iterator2 = collection.iterator();
                                    if (__UNDEF_KEY__ == null) {
                                        while (iterator2.hasNext()) {
                                            iterable = iterator2.next();
                                            return null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        iterator2 = SharedKt.getWorld().getBlockState(bp);
        if (!(iterator2.method_45474())) {
            return null;
        }
        if (interact == BlockPlacementInteractMode.AirPlace) {
            return resolveMinecraftObject(this, new class_3959(this.resolveMinecraftObject(SharedKt.getPlayer()), bp.toCenterPos(), class_3960.field_17558, class_242.field_1348, SharedKt.getPlayer()), bp);
        }
        iterable = this.resolveList(bp, calcGhost);
        if (__UNDEF_KEY__ == null) {
            if (0 <= slot) {
                if (__UNDEF_KEY__ == null) {
                    if (slot < 9) {
                    }
                }
            } else {
            }
        }
        if (0) {
        }
        iterable2 = Items.field_8281;
        index = iterable2;
        if (__UNDEF_KEY__ == null) {
            if (Intrinsics.areEqual(index, Items.field_8143)) {
                iterable.removeIf(this::checkCondition);
            }
        }
        if (Intrinsics.areEqual(index, Items.field_17523)) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (Intrinsics.areEqual(iterator2.getBlock(), Blocks.field_10597)) {
                    return null;
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (Intrinsics.areEqual(index, Items.field_8121)) {
                iterable.removeIf(this::checkCondition2);
            }
        }
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = ((PositionServiceComponent) iterable2.next());
            if (__UNDEF_KEY__ == null) {
                if (interact != BlockPlacementInteractMode.Strict) {
                    if (interact == BlockPlacementInteractMode.GRIM) {
                        index2 = this.resolveList(collection.getMinecraftObject());
                        if (__UNDEF_KEY__ == null) {
                            if (index2.isEmpty()) {
                                return null;
                            }
                        }
                        if (!(index2.contains(collection.getMinecraftObject()))) {
                        }
                    }
                }
            }
            boolean flag = interact == BlockPlacementInteractMode.GRIM;
            index2 = this.resolveMinecraftObject(collection.getMinecraftObject(), collection.getMinecraftObject(), wallRange, range, flag);
            return new class_3965(index2, collection.getMinecraftObject(), collection.getMinecraftObject(), false);
        }
        return null;
    }

    public static class_3965 resolveMinecraftObject(VecPacketHelper arg0, BlockPos arg1, int arg2, BlockPlacementInteractMode arg3, OptionMode15 arg4, float arg5, float arg6, List arg7, int arg8, Object arg9) {
        if ((arg8 & 64) != 0) {
            arg7 = new ArrayList();
        }
        return arg0.resolveMinecraftObject(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public List resolveList(BlockPos bp, List calcGhost) {
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = lookupMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            Direction direction = ((Direction) entry.getKey());
            BlockPos blockPos = ((BlockPos) entry.getValue());
            BlockPos blockPos2 = bp.method_10081(((class_2382) blockPos));
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                }
                if (__UNDEF_KEY__ == null) {
                    if (SharedKt.getWorld().getBlockState(blockPos2).method_45474() && !(lookupMap2.containsKey(blockPos2))) {
                        if (calcGhost.contains(blockPos2)) {
                        }
                    }
                }
                if (null != null) {
                    collection.add();
                } else {
                }
            }
        }
        return CollectionsKt.toMutableList(((Collection) collection));
    }

    public PositionServiceComponent resolvePositionServiceComponent(BlockPos blockPos) {
        Iterator iterator = lookupMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            Direction direction = ((Direction) entry.getKey());
            BlockPos blockPos2 = ((BlockPos) entry.getValue());
            BlockPos blockPos3 = blockPos.method_10081(((class_2382) blockPos2));
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                    if (!(SharedKt.getWorld().getBlockState(blockPos3).method_45474())) {
                        return new PositionServiceComponent(blockPos3, direction);
                    }
                }
            }
        }
        return null;
    }

    public float computeValue(Vec3d vec) {
        return vec.method_1025(SharedKt.getPlayer().getEyePos());
    }

    public float computeValue(Vec3d vec) {
        double offset = (vec.field_1352 - SharedKt.getPlayer().getX());
        double offset2 = (vec.field_1350 - SharedKt.getPlayer().getZ());
        return ((offset * offset) + (offset2 * offset2));
    }

    public ServiceComponent18 resolveServiceComponent18(BlockPos bp) {
        Vec3d vec = bp.toCenterPos();
        return new ServiceComponent18((this.resolveMinecraftObject(SharedKt.getPlayer()).field_1352 - vec.method_1031(0.5D, 0.0D, 0.0D).field_1352), (this.resolveMinecraftObject(SharedKt.getPlayer()).field_1352 - vec.method_1031(-0.5D, 0.0D, 0.0D).field_1352), (this.resolveMinecraftObject(SharedKt.getPlayer()).field_1350 - vec.method_1031(0.0D, 0.0D, 0.5D).field_1350), (this.resolveMinecraftObject(SharedKt.getPlayer()).field_1350 - vec.method_1031(0.0D, 0.0D, -0.5D).field_1350), (this.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 - vec.method_1031(0.0D, 0.5D, 0.0D).field_1351), (this.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 - vec.method_1031(0.0D, -0.5D, 0.0D).field_1351));
    }

    public boolean checkCondition(BlockPos bp) {
        if (SharedKt.getWorld().getBlockState(bp).method_45474()) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (lookupMap2.containsKey(bp)) {
                } else {
                }
            }
        }
        return false;
    }

    public List resolveList(BlockPos bp) {
        List list = new ArrayList();
        ServiceComponent18 serviceComponent18 = this.resolveServiceComponent18(bp);
        if (serviceComponent18.getNumericValue() > 0.0D) {
            if (__UNDEF_KEY__ > 0) {
                if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                    if (SharedKt.getWorld().getBlockState(bp.method_10078()).method_45474()) {
                        list.add(Direction.NORTH);
                    }
                }
            }
        }
        if (serviceComponent18.getNumericValue2() < 0.0D) {
            if (__UNDEF_KEY__ < 0) {
                if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                    if (SharedKt.getWorld().getBlockState(bp.method_10067()).method_45474()) {
                        list.add(Direction.WEST);
                    }
                }
            }
        }
        if (serviceComponent18.getNumericValue3() > 0.0D) {
            if (__UNDEF_KEY__ <= 0) {
                if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                    if (SharedKt.getWorld().getBlockState(bp.method_10072()).method_45474()) {
                        list.add(Direction.SOUTH);
                    }
                }
            }
        }
        if (serviceComponent18.getNumericValue4() < 0.0D) {
            if (__UNDEF_KEY__ > 0) {
                if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                    if (SharedKt.getWorld().getBlockState(bp.method_10095()).method_45474()) {
                        list.add(Direction.EAST);
                    }
                }
            }
        }
        if (serviceComponent18.getNumericValue5() > 0.0D) {
            if (__UNDEF_KEY__ <= 0) {
                if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                    if (SharedKt.getWorld().getBlockState(bp.up()).method_45474()) {
                        list.add(Direction.UP);
                    }
                }
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (serviceComponent18.getNumericValue6() < 0.0D && SharedKt.getWorld().getBlockState(bp.down()).method_45474()) {
                list.add(Direction.DOWN);
            }
        }
        return list;
    }

    public DirServiceComponent resolveDirServiceComponent(BlockPos bp, BlockPlacementInteractMode interact) {
        if (__UNDEF_KEY__ == null) {
            if (interact == BlockPlacementInteractMode.Vanilla) {
                return new DirServiceComponent(Direction.UP, bp.toCenterPos().method_1031(0.0D, 0.5D, 0.0D));
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (interact != BlockPlacementInteractMode.Strict) {
                if (interact == BlockPlacementInteractMode.GRIM) {
                    float factor = 999.0F;
                    Direction direction = Direction.UP;
                    Iterator iterator = ServiceComponent9.enumEntries.iterator();
                    while (iterator.hasNext()) {
                        Direction direction2 = ((Direction) iterator.next());
                        int index = (direction2.method_62675().method_10263() * 0.5D);
                        int index2 = (direction2.method_62675().method_10264() * 0.5D);
                        int index3 = (direction2.method_62675().method_10260() * 0.5D);
                        if (__UNDEF_KEY__ == null) {
                            if (__UNDEF_KEY__ == null) {
                                if (Math.abs(index) == 0.5D) {
                                } else {
                                }
                            }
                            if (0) {
                            }
                            if (__UNDEF_KEY__ == null) {
                                if (Math.abs(index2) == 0.5D) {
                                } else {
                                }
                            }
                            if (0) {
                            }
                            if (__UNDEF_KEY__ == null) {
                                if (Math.abs(index3) == 0.5D) {
                                } else {
                                }
                            }
                            if (0) {
                            }
                            Vec3d vec = RangeServiceComponent.k(((ClosedRange) RangesKt.rangeTo(-0.1D, 0.1D)), false).method_1031(1, index3, RangeServiceComponent.k(((ClosedRange) RangesKt.rangeTo(-0.1D, 0.1D)), false));
                            float factor2 = this.computeValue(vec);
                            if (__UNDEF_KEY__ == null) {
                                direction = direction2;
                                Vec3d vec2 = vec;
                            }
                            factor = factor2;
                        }
                    }
                    if (vec2 == null) {
                        return null;
                    }
                    return new DirServiceComponent(direction, vec2);
                }
            }
        }
        return null;
    }

    public Vec3d resolveMinecraftObject(Direction dir, BlockPos bp, float wallRange, float range, boolean random) {
        Box box = this.resolveMinecraftObject(dir);
        List list = new ArrayList();
        if (__UNDEF_KEY__ == null) {
            if ((box.field_1320 - box.field_1323) == 0.0D) {
            } else {
            }
        }
        if (0) {
            double offset = box.field_1322;
            if (offset < box.field_1325) {
                if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ == null) {
                    double offset2 = box.field_1321;
                    if (offset2 < box.field_1324) {
                        Vec3d vec = new Vec3d((bp.method_10263() + box.field_1323), (bp.method_10264() + offset), (bp.method_10260() + offset2));
                        if (__UNDEF_KEY__ >= 0) {
                            if (__UNDEF_KEY__ == null) {
                                if (__UNDEF_KEY__ > 0) {
                                    if (__UNDEF_KEY__ > 0) {
                                        if (!(this.checkCondition(vec, bp, wallRange, range))) {
                                        }
                                    }
                                    offset2 = (offset2 + 0.1D);
                                    offset = (offset + 0.1D);
                                    if (__UNDEF_KEY__ >= 0) {
                                        if (__UNDEF_KEY__ >= 0) {
                                        }
                                        if (__UNDEF_KEY__ == null) {
                                            if ((box.field_1325 - box.field_1322) == 0.0D) {
                                            } else {
                                            }
                                        }
                                        if (0) {
                                            offset = box.field_1323;
                                            if (offset < box.field_1320) {
                                                if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ == null) {
                                                    offset2 = box.field_1321;
                                                    if (offset2 < box.field_1324) {
                                                        vec = new Vec3d((bp.method_10263() + offset), (bp.method_10264() + box.field_1322), (bp.method_10260() + offset2));
                                                        if (__UNDEF_KEY__ > 0) {
                                                            if (__UNDEF_KEY__ == null) {
                                                                if (__UNDEF_KEY__ > 0) {
                                                                    if (__UNDEF_KEY__ >= 0) {
                                                                        if (!(this.checkCondition(vec, bp, wallRange, range))) {
                                                                        }
                                                                    }
                                                                    offset2 = (offset2 + 0.1D);
                                                                    offset = (offset + 0.1D);
                                                                    if (__UNDEF_KEY__ >= 0) {
                                                                        if (__UNDEF_KEY__ > 0) {
                                                                        }
                                                                        if (__UNDEF_KEY__ == null) {
                                                                            if ((box.field_1324 - box.field_1321) == 0.0D) {
                                                                            } else {
                                                                            }
                                                                        }
                                                                        if (0) {
                                                                            offset = box.field_1323;
                                                                            if (offset < box.field_1320) {
                                                                                if (__UNDEF_KEY__ == null) {
                                                                                    offset2 = box.field_1322;
                                                                                    if (offset2 < box.field_1325) {
                                                                                        vec = new Vec3d((bp.method_10263() + offset), (bp.method_10264() + offset2), (bp.method_10260() + box.field_1321));
                                                                                        if (__UNDEF_KEY__ > 0) {
                                                                                            if (__UNDEF_KEY__ == null) {
                                                                                                if (__UNDEF_KEY__ > 0) {
                                                                                                    if (!(this.checkCondition(vec, bp, wallRange, range))) {
                                                                                                    }
                                                                                                }
                                                                                                offset2 = (offset2 + 0.1D);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    offset = (offset + 0.1D);
                                                                                    if (__UNDEF_KEY__ >= 0) {
                                                                                        if (__UNDEF_KEY__ > 0) {
                                                                                            if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__ == null) {
                                                                                                if (list.isEmpty()) {
                                                                                                    return null;
                                                                                                }
                                                                                            }
                                                                                            if (random) {
                                                                                            } else {
                                                                                                offset = ((Iterable) list);
                                                                                                offset2 = offset.iterator();
                                                                                                if (__UNDEF_KEY__ == null) {
                                                                                                    if (!(offset2.hasNext())) {
                                                                                                    }
                                                                                                }
                                                                                                Object element = offset2.next();
                                                                                                if (__UNDEF_KEY__ == null) {
                                                                                                    if (!(offset2.hasNext())) {
                                                                                                    }
                                                                                                }
                                                                                                vec = ((Vec3d) element);
                                                                                                int index = 0;
                                                                                                vec = SharedKt.getPlayer().getEyePos().method_1025(vec);
                                                                                                index = offset2.next();
                                                                                                Vec3d vec2 = ((Vec3d) index);
                                                                                                vec2 = SharedKt.getPlayer().getEyePos().method_1025(vec2);
                                                                                                if (Double.compare(vec, vec2) > 0) {
                                                                                                    element = index;
                                                                                                    vec = vec2;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ((Vec3d) element);
    }

    public Box resolveMinecraftObject(Direction dir) {
        return new NoWhenBranchMatchedException();
    }

    public boolean checkCondition(Vec3d point, BlockPos bp, float wallRange, float range) {
        class_3959 class3959 = new class_3959(this.resolveMinecraftObject(SharedKt.getPlayer()), point, class_3960.field_17558, class_242.field_1348, SharedKt.getPlayer());
        class_3965 class3965 = SharedKt.getWorld().method_17742(class3959);
        float factor = this.computeValue(point);
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
            if (__UNDEF_KEY__ == null) {
                if (class3965.method_17783() == class_240.field_1332 && !(Intrinsics.areEqual(class3965.method_17777(), bp)) && factor > (wallRange * wallRange)) {
                    return true;
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (factor > (range * range)) {
            } else {
            }
        }
        return false;
    }

    public boolean checkCondition(Block b) {
        if (!(b instanceof class_2237)) {
            if (!(Intrinsics.areEqual(b, Blocks.field_9980))) {
                if (!(b instanceof class_2533)) {
                    if (!(b instanceof class_2401)) {
                        if (!(b instanceof class_2269)) {
                            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                                if (b instanceof class_2323) {
                                } else {
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean checkCondition(Vec3d pos, int fov) {
        double offset = (pos.method_10216() - SharedKt.getPlayer().getX());
        double offset2 = (pos.method_10215() - SharedKt.getPlayer().getZ());
        float factor = class_3532.method_15393((class_3532.method_15338((Math.toDegrees(Math.atan2(offset2, offset)) - 90.0D)) - class_3532.method_15393(SharedKt.getPlayer().method_36454())));
        if (__UNDEF_KEY__ == null) {
            if (Math.abs(factor) <= fov) {
            } else {
            }
        }
        return false;
    }

    public class_3965 resolveMinecraftObject(class_3959 context, BlockPos block, BlockState state) {
        return ((class_3965) class_1922.method_17744(context.method_17750(), context.method_17747(), context, this::resolveMinecraftObject, this::resolveMinecraftObject));
    }

    public static class_3965 resolveMinecraftObject(VecPacketHelper arg0, class_3959 arg1, BlockPos arg2, BlockState arg3, int arg4, Object arg5) {
        if ((arg4 & 4) != 0) {
            arg3 = Blocks.OBSIDIAN.method_9564();
        }
        return arg0.resolveMinecraftObject(arg1, arg2, arg3);
    }

    public boolean checkCondition(Entity entity, MoveFixServiceComponent rotation, float distance, boolean rayTrace) {
        float factor = distance;
        double offset = class_3532.method_33723(factor);
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).method_1031(0.0D, SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()), 0.0D);
        double offset2 = 0.0D;
        if (rayTrace) {
            class_239 class239 = EventPacketHelper2.INSTANCE.resolveMinecraftObject(distance, rotation.getNumericValue(), rotation.getNumericValue2());
            if (__UNDEF_KEY__ == null) {
                offset2 = class239.method_17784().method_1025(vec);
                if (class239.method_17783() != class_240.field_1333) {
                    offset = offset2;
                    factor = Math.sqrt(offset2);
                }
            }
        } else {
        }
        Vec3d vec2 = EventPacketHelper2.INSTANCE.resolveMinecraftObject(rotation.getNumericValue2(), rotation.getNumericValue());
        Vec3d vec3 = vec.method_1031((vec2.field_1352 * factor), (vec2.field_1351 * factor), (vec2.field_1350 * factor));
        Box box = SharedKt.getPlayer().method_5829().method_18804(vec2.method_1021(factor)).method_1009(1.0D, 1.0D, 1.0D);
        class_3966 class3966 = class_1675.method_18075(SharedKt.getPlayer(), vec, vec3, box, this::checkCondition, offset);
        if (class3966 == null) {
            return false;
        }
        if (class239 != null) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (class3966.method_17784().method_1025(vec) < offset2) {
                } else {
                }
            }
        }
        class_239 class2392 = ((class_239) class3966).resolveMinecraftObject(class239, vec, distance);
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
            if (class2392 instanceof class_3966 && Intrinsics.areEqual(((class_3966) class2392).method_17782(), entity)) {
            } else {
            }
        }
        if (0 != null) {
        }
        return true;
    }

    private class_239 resolveMinecraftObject(class_239 arg0, Vec3d arg1, float arg2) {
        if (!(arg0.method_17784().method_24802(arg1, arg2))) {
            Vec3d vec = arg0.method_17784();
            return ((class_239) class_3965.method_17778(vec, Direction.method_10142((vec.field_1352 - arg1.field_1352), (vec.field_1351 - arg1.field_1351), (vec.field_1350 - arg1.field_1350)), BlockPos.ofFloored(vec)));
        }
        return arg0;
    }

    public List resolveList() {
        BlockPos blockPos = BlockPos.ofFloored(SharedKt.getPlayer().getEyePos());
        double offset = Math.ceil(SharedKt.getPlayer().method_55754());
        Iterable iterable = ((Iterable) new IntRange((blockPos.method_10263() - offset), (blockPos.method_10263() + offset)));
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            int index = ((IntIterator) iterator).nextInt();
            int index2 = index;
            Iterable iterable2 = ((Iterable) new IntRange((blockPos.method_10264() - offset), (blockPos.method_10264() + offset)));
            if (__UNDEF_KEY__ == null) {
                Collection collection2 = ((Collection) new ArrayList());
                Iterator iterator2 = iterable2.iterator();
                while (iterator2.hasNext()) {
                    int index3 = ((IntIterator) iterator2).nextInt();
                    Iterable iterable3 = ((Iterable) new IntRange((blockPos.method_10260() - offset), (blockPos.method_10260() + offset)));
                    Collection collection3 = ((Collection) new ArrayList());
                    Iterator iterator3 = iterable3.iterator();
                    while (iterator3.hasNext()) {
                        int index4 = ((IntIterator) iterator3).nextInt();
                        BlockPos blockPos2 = new BlockPos(index2, index3, index4);
                        collection3.add(blockPos2);
                        if (__UNDEF_KEY__ == null) {
                        }
                    }
                    Iterable iterable4 = ((Iterable) collection3);
                    CollectionsKt.addAll(collection2, iterable4);
                }
                index2 = ((Iterable) collection2);
                CollectionsKt.addAll(collection, index2);
            }
        }
        return collection;
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Direction direction) {
        float factor = 0.0F;
        float factor2 = -10.0F;
        float factor3 = (EventPacketHelper2.INSTANCE.computeValue() / 360.0F);
        return new MoveFixServiceComponent((factor + (factor3 * 360)), factor2, false);
    }

    private static Packet resolveMinecraftObject(class_3965 arg0, int arg1) {
        return ((Packet) new class_2885(Hand.field_5808, arg0, arg1));
    }

    private static Unit resolveUnit(int arg0, BlockPlacementSwitchMode arg1, class_3965 arg2, BlockPlacementPlaceMode arg3, BlockPos arg4) {
        int index = SharedKt.getPlayer().method_31548().method_67532();
        if (__UNDEF_KEY__ == null) {
            ItemPacketHelper.INSTANCE.executeAction(arg0);
            ItemPacketHelper.INSTANCE.executeAction2(arg0);
            if (arg0 != -1 && __UNDEF_KEY__ != null && __UNDEF_KEY__ != null) {
            }
        }
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
            if (INSTANCE.checkCondition(SharedKt.getWorld().getBlockState(arg2.method_17777()).getBlock()) && !(SharedKt.getPlayer().method_5715())) {
            } else {
            }
        }
        int index2 = 0;
        if (index2) {
            ViafabricplusServiceComponent.INSTANCE.executeAction(true);
        }
        if (arg3 == BlockPlacementPlaceMode.Normal) {
        }
        INSTANCE.executeAction(this::resolveMinecraftObject);
        PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5808)));
        lookupMap2.put(arg4, Long.valueOf(SharedKt.getNumericValue()));
        if (__UNDEF_KEY__ == null) {
            if (index2) {
                ViafabricplusServiceComponent.INSTANCE.executeAction(false);
            }
        }
        if (__UNDEF_KEY__ == null) {
        }
        ItemPacketHelper.INSTANCE.executeAction(index);
        if (index != -1 && __UNDEF_KEY__ != null) {
            ItemPacketHelper.INSTANCE.executeAction2(arg0);
        }
        return Unit.INSTANCE;
    }

    private static boolean checkCondition(PositionServiceComponent arg0) {
        if (__UNDEF_KEY__ == null) {
            if (arg0.getMinecraftObject() != Direction.UP) {
                if (arg0.getMinecraftObject() == Direction.DOWN) {
                }
            }
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static boolean checkCondition(ArrayList arg0, PositionServiceComponent arg1) {
        Iterable iterable = ((Iterable) arg0);
        if (iterable instanceof Collection) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (((Collection) iterable).isEmpty()) {
                }
            }
        }
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (__UNDEF_KEY__ == null) {
                if (element.method_5707(arg1.getMinecraftObject().toCenterPos().method_43206(arg1.getMinecraftObject(), 0.5D)) < 0.5D) {
                } else {
                }
            }
        }
        return false;
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static class_3965 resolveMinecraftObject(BlockPos arg0, BlockState arg1, class_3959 arg2, BlockPos arg3) {
        if (!(arg3.equals(arg0))) {
        }
        BlockState state = arg1;
        state = arg2.method_17750();
        Vec3d vec = arg2.method_17747();
        class_265 class265 = arg2.method_17748(state, ((class_1922) SharedKt.getWorld()), arg3);
        class_3965 class3965 = SharedKt.getWorld().method_17745(state, vec, arg3, class265, state);
        class_265 class2652 = class_259.method_1073();
        class_3965 class39652 = class2652.method_1092(state, vec, arg3);
        if (class3965 == null) {
        }
        double offset = arg2.method_17750().method_1025(class3965.method_17784());
        if (class39652 == null) {
        }
        double offset2 = arg2.method_17750().method_1025(class39652.method_17784());
        if (offset <= offset2) {
        }
        return class39652;
    }

    private static class_3965 resolveMinecraftObject(class_3959 arg0) {
        Vec3d vec = arg0.method_17750().method_1020(arg0.method_17747());
        return class_3965.method_17778(arg0.method_17747(), Direction.method_10142(vec.field_1352, vec.field_1351, vec.field_1350), BlockPos.ofFloored(arg0.method_17747()));
    }

    private static boolean checkCondition(Entity arg0, Entity arg1) {
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
            if (arg1.method_5863() && Intrinsics.areEqual(arg1, arg0)) {
            } else {
            }
        }
        return false;
    }

    static {
        INSTANCE = new VecPacketHelper();
        Pair[] items = new Pair[6];
        items[0] = TuplesKt.to(Direction.UP, new BlockPos(0, -1, 0));
        items[1] = TuplesKt.to(Direction.DOWN, new BlockPos(0, 1, 0));
        items[2] = TuplesKt.to(Direction.NORTH, new BlockPos(-1, 0, 0));
        items[3] = TuplesKt.to(Direction.WEST, new BlockPos(1, 0, 0));
        items[4] = TuplesKt.to(Direction.EAST, new BlockPos(0, 0, 1));
        items[5] = TuplesKt.to(Direction.SOUTH, new BlockPos(0, 0, -1));
        lookupMap = MapsKt.mapOf(items);
        lookupMap2 = ((Map) new LinkedHashMap());
        vec3d = Vec3d.ZERO;
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
