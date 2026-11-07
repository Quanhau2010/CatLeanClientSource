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
        Map var10 = (Map) new HashMap(lookupMap2);
        int var11 = 0;
        Iterator iterator = var10.entrySet().iterator();
        if (iterator.hasNext()) {
            Entry var13 = (Entry) iterator.next();
            Object var14 = var13;
            int var15 = 0;
            BlockPos blockPos = (BlockPos) var14.getKey();
            long var17 = (Number) var14.getValue().longValue();
            if (var9 == null) {
                if ((System.currentTimeMillis() - var17) > (TheNetherPacketHelper.f() * 2.0F)) {
                    lookupMap2.remove(blockPos);
                }
            }
        }
        vec3d = SharedKt.getPlayer().getEyePos();
    }

    public boolean checkCondition(Vec3d vec) {
        return ExplosionPosEntityHelper.resolveMinecraftObject(vec3d, vec) == null;
    }

    public Vec3d resolveMinecraftObject(Entity entity) {
        if (var9 == null) {
            if (Intrinsics.areEqual(entity, SharedKt.getPlayer())) {
                return vec3d;
            }
        }
        return entity.getEyePos();
    }

    public RotationServiceComponent4 resolveRotationServiceComponent4(BlockPos bp, int slot, BlockPlacementInteractMode interact, BlockPlacementPlaceMode mode, OptionMode15 ignore, float range, float wallRange, int priority, BlockPlacementSwitchMode switch, List calcGhost, boolean grim) {
        if (var26 == null) {
            if (this.resolveMinecraftObject(bp, slot, interact, ignore, range, wallRange, calcGhost) == null) {
                this.resolveMinecraftObject(bp, slot, interact, ignore, range, wallRange, calcGhost);
            }
            return null;
        }
        Function0 var28 = this::resolveUnit;
        if (interact == BlockPlacementInteractMode.GRIM) {
        }
        return new RotationServiceComponent4(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(var27.method_17784()).resolveMoveFixServiceComponent(grim), priority);
    }

    public static RotationServiceComponent4 resolveRotationServiceComponent4(VecPacketHelper arg0, BlockPos arg1, int arg2, BlockPlacementInteractMode arg3, BlockPlacementPlaceMode arg4, OptionMode15 arg5, float arg6, float arg7, int arg8, BlockPlacementSwitchMode arg9, List arg10, boolean arg11, int arg12, Object arg13) {
        if (var19 == null) {
            if ((arg12 & 512)) {
                arg10 = new ArrayList();
            }
        }
        if (var19 == null) {
            if ((arg12 & 1024)) {
            }
            arg11 = 0;
        }
        return arg0.resolveRotationServiceComponent4(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public boolean checkCondition(BlockPos bp, BlockPlacementInteractMode interact, OptionMode15 ignore, float range, float wallRange) {
        if (var10 == null) {
            if (lookupMap2.containsKey(bp)) {
            }
            return false;
        }
        return resolveMinecraftObject(this, bp, -1, interact, ignore, range, wallRange) != null;
    }

    public void executeAction(class_7204 packetCreator) {
        AutoCloseable var11 = (AutoCloseable) SharedKt.getWorld().method_41925().method_41937();
        class_7202 var13 = (class_7202) var11;
        int var14 = 0;
        SharedKt.getPlayer().field_3944.method_52787(packetCreator.predict(var13.method_41942()));
        var13 = Unit.INSTANCE;
        AutoCloseableKt.closeFinally();
        Object var12 = var14;
        AutoCloseableKt.closeFinally();
    }

    public class_3965 resolveMinecraftObject(BlockPos bp, int slot, BlockPlacementInteractMode interact, OptionMode15 ignore, float range, float wallRange, List calcGhost) {
        if (ServiceComponent45.INSTANCE.checkCondition(bp)) {
            return null;
        }
        if (BoxShrinkerModule.INSTANCE.getEnabled()) {
        }
        List<BlockPos> positions = Lists.newArrayList((Iterable) Entity.class.method_18467(new Box(bp).method_1009(-1.0E-12D, 0.0D, -1.0E-12D), new Box(bp)));
        if (var32 == null) {
            if (ignore == OptionMode15.ALL) {
                Iterable var35 = (Iterable) positions;
                int var36 = 0;
                Object var37 = var35;
                Collection var38 = (Collection) new ArrayList();
                int var39 = 0;
                Iterator iterator = var37.iterator();
                if (iterator.hasNext()) {
                    Object var41 = iterator.next();
                    Entity entity = var41;
                    int var43 = 0;
                    if (var32 == null) {
                        if (var32 == null) {
                        }
                        if (var32 == null) {
                            if (!(entity instanceof class_1542) && !(entity instanceof class_1303)) {
                            }
                        } else {
                        }
                        var38.add();
                    }
                    Iterator iterator2 = var38.iterator();
                    if (var32 == null) {
                        if (iterator2.hasNext()) {
                        }
                        var35 = iterator2.next();
                        return null;
                    }
                }
            }
            if (ignore == OptionMode15.ONLY_CRYSTALS) {
                var35 = (Iterable) positions;
                var36 = 0;
                var37 = var35;
                var38 = (Collection) new ArrayList();
            }
            var39 = 0;
            iterator = var37.iterator();
            if (iterator.hasNext()) {
                var41 = iterator.next();
                entity = var41;
                var43 = 0;
                if (var32 == null) {
                    if (var32 == null) {
                    }
                    if (var32 == null) {
                    }
                    if (var32 == null) {
                        if (!(entity instanceof EndCrystalEntity) && !(entity instanceof class_1542) && !(entity instanceof class_1303)) {
                        }
                    } else {
                    }
                    var38.add();
                }
                iterator2 = var38.iterator();
                if (var32 == null) {
                    if (iterator2.hasNext()) {
                    }
                    var35 = iterator2.next();
                    return null;
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
        var35 = this.resolveList(bp, calcGhost);
        if (var32 == null) {
            if (0 <= slot) {
                if (var32 == null) {
                }
                if (slot < 9) {
                }
            }
        } else {
        }
        if (0) {
        }
        var37 = Items.field_8281;
        var36 = var37;
        if (var32 == null) {
            if (Intrinsics.areEqual(Items.field_8143)) {
                var35.removeIf(this::checkCondition);
            }
        }
        if (Intrinsics.areEqual(Items.field_17523)) {
            if (var32 == null && var32 == null) {
                if (Intrinsics.areEqual(iterator2.getBlock(), Blocks.field_10597)) {
                    return null;
                }
            }
        }
        if (var32 == null) {
            if (Intrinsics.areEqual(Items.field_8121)) {
            }
            var35.removeIf(this::checkCondition2);
        }
        var37 = var35.iterator();
        if (var37.hasNext()) {
            var38 = (PositionServiceComponent) var37.next();
            if (var32 == null) {
                if (interact != BlockPlacementInteractMode.Strict) {
                }
                if (interact == BlockPlacementInteractMode.GRIM) {
                }
                var39 = this.resolveList(var38.getMinecraftObject());
                if (var32 == null) {
                    if (var39.isEmpty()) {
                        return null;
                    }
                }
                if (!(var39.contains(var38.getMinecraftObject()))) {
                }
            }
            boolean var30 = interact == BlockPlacementInteractMode.GRIM;
            float var31 = range;
            var39 = this.resolveMinecraftObject(var38.getMinecraftObject(), var38.getMinecraftObject(), wallRange);
            return new class_3965(var38.getMinecraftObject(), var38.getMinecraftObject(), 0);
        }
        return null;
    }

    public static class_3965 resolveMinecraftObject(VecPacketHelper arg0, BlockPos arg1, int arg2, BlockPlacementInteractMode arg3, OptionMode15 arg4, float arg5, float arg6, List arg7, int arg8, Object arg9) {
        if ((arg8 & 64)) {
            arg7 = new ArrayList();
        }
        return arg0.resolveMinecraftObject(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public List resolveList(BlockPos bp, List calcGhost) {
        Map var10 = lookupMap;
        int var11 = 0;
        Object var12 = var10;
        Collection var13 = (Collection) new ArrayList();
        int var14 = 0;
        Object var15 = var12;
        int var16 = 0;
        Iterator iterator = var15.entrySet().iterator();
        if (iterator.hasNext()) {
            Entry var18 = (Entry) iterator.next();
            Object var19 = var18;
            int var20 = 0;
            Object var21 = var19;
            int var22 = 0;
            Direction var23 = (Direction) var21.getKey();
            BlockPos blockPos = (BlockPos) var21.getValue();
            BlockPos blockPos2 = bp.method_10081((class_2382) blockPos);
            if (var9 == null) {
                if (var9 == null) {
                }
                if (var9 == null) {
                    if (SharedKt.getWorld().getBlockState(blockPos2).method_45474() && !(lookupMap2.containsKey(blockPos2))) {
                    }
                    if (calcGhost.contains(blockPos2)) {
                    }
                }
                if (null != null) {
                    int var27 = 0;
                    var13.add();
                } else {
                }
            }
        }
        return CollectionsKt.toMutableList((Collection) var13);
    }

    public PositionServiceComponent resolvePositionServiceComponent(BlockPos blockPos) {
        Map var9 = lookupMap;
        int var10 = 0;
        Iterator iterator = var9.entrySet().iterator();
        if (iterator.hasNext()) {
            Entry var12 = (Entry) iterator.next();
            Object var13 = var12;
            int var14 = 0;
            Direction var15 = (Direction) var13.getKey();
            BlockPos blockPos2 = (BlockPos) var13.getValue();
            BlockPos blockPos3 = blockPos.method_10081((class_2382) blockPos2);
            if (var8 == null) {
                if (var8 == null) {
                    if (!(SharedKt.getWorld().getBlockState(blockPos3).method_45474())) {
                        return new PositionServiceComponent(blockPos3);
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
        double var6 = (vec.field_1352 - SharedKt.getPlayer().getX());
        double var8 = (vec.field_1350 - SharedKt.getPlayer().getZ());
        return ((var6 * var6) + (var8 * var8));
    }

    public ServiceComponent18 resolveServiceComponent18(BlockPos bp) {
        Vec3d vec = bp.toCenterPos();
        return new ServiceComponent18((this.resolveMinecraftObject(SharedKt.getPlayer()).field_1352 - vec.method_1031(0.5D, 0.0D, 0.0D).field_1352), (this.resolveMinecraftObject(SharedKt.getPlayer()).field_1352 - vec.method_1031(-0.5D, 0.0D, 0.0D).field_1352), (this.resolveMinecraftObject(SharedKt.getPlayer()).field_1350 - vec.method_1031(0.0D, 0.0D, 0.5D).field_1350), (this.resolveMinecraftObject(SharedKt.getPlayer()).field_1350 - vec.method_1031(0.0D, 0.0D, -0.5D).field_1350), (this.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 - vec.method_1031(0.0D, 0.5D, 0.0D).field_1351), (this.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 - vec.method_1031(0.0D, -0.5D, 0.0D).field_1351));
    }

    public boolean checkCondition(BlockPos bp) {
        if (SharedKt.getWorld().getBlockState(bp).method_45474()) {
            if (var6 == null && var6 == null) {
                if (lookupMap2.containsKey(bp)) {
                }
            }
        } else {
        }
        return false;
    }

    public List resolveList(BlockPos bp) {
        List positions = new ArrayList();
        ServiceComponent18 var12 = this.resolveServiceComponent18(bp);
        int var13 = 0;
        if (var12.getNumericValue() > 0.0D) {
            if (0L > 0) {
                if (var10 == null && var10 == null) {
                    if (SharedKt.getWorld().getBlockState(bp.method_10078()).method_45474()) {
                        positions.add(Direction.NORTH);
                    }
                }
            }
        }
        if (var12.getNumericValue2() < 0.0D) {
            if (0L < 0) {
                if (var10 == null && var10 == null) {
                    if (SharedKt.getWorld().getBlockState(bp.method_10067()).method_45474()) {
                        positions.add(Direction.WEST);
                    }
                }
            }
        }
        if (var12.getNumericValue3() > 0.0D) {
            if (0L <= 0) {
                if (var10 == null && var10 == null) {
                    if (SharedKt.getWorld().getBlockState(bp.method_10072()).method_45474()) {
                        positions.add(Direction.SOUTH);
                    }
                }
            }
        }
        if (var12.getNumericValue4() < 0.0D) {
            if (0L > 0) {
                if (var10 == null && var10 == null) {
                    if (SharedKt.getWorld().getBlockState(bp.method_10095()).method_45474()) {
                        positions.add(Direction.EAST);
                    }
                }
            }
        }
        if (var12.getNumericValue5() > 0.0D) {
            if (0L <= 0) {
                if (var10 == null && var10 == null) {
                    if (SharedKt.getWorld().getBlockState(bp.up()).method_45474()) {
                        positions.add(Direction.UP);
                    }
                }
            }
        }
        if (0L >= 0) {
            if (var10 == null) {
            }
        }
        if (var10 == null) {
            if (var12.getNumericValue6() < 0.0D && SharedKt.getWorld().getBlockState(bp.down()).method_45474()) {
            }
            positions.add(Direction.DOWN);
        }
        return positions;
    }

    public DirServiceComponent resolveDirServiceComponent(BlockPos bp, BlockPlacementInteractMode interact) {
        if (var11 == null) {
            if (interact == BlockPlacementInteractMode.Vanilla) {
                return new DirServiceComponent(Direction.UP, bp.toCenterPos().method_1031(0.0D, 0.5D, 0.0D));
            }
        }
        if (var11 == null) {
            if (interact != BlockPlacementInteractMode.Strict) {
            }
            if (interact == BlockPlacementInteractMode.GRIM) {
            }
            float var12 = 999.0F;
            Direction var13 = Direction.UP;
            Iterator iterator = ServiceComponent9.enumEntries.iterator();
            if (iterator.hasNext()) {
                Direction var16 = (Direction) iterator.next();
                int var17 = (var16.method_62675().method_10263() * 0.5D);
                int var19 = (var16.method_62675().method_10264() * 0.5D);
                int var21 = (var16.method_62675().method_10260() * 0.5D);
                if (var11 == null) {
                    if (var11 == null) {
                        if (Math.abs() == 0.5D) {
                        }
                    } else {
                    }
                    if (0) {
                    }
                    if (var11 == null) {
                        if (Math.abs() == 0.5D) {
                        }
                    } else {
                    }
                    if (0) {
                    }
                    if (var11 == null) {
                        if (Math.abs() == 0.5D) {
                        }
                    } else {
                    }
                    if (0) {
                    }
                    Vec3d vec = RangeServiceComponent.k((ClosedRange) RangesKt.rangeTo(-0.1D, 0.1D)).method_1031(1, RangeServiceComponent.k((ClosedRange) RangesKt.rangeTo(-0.1D, 0.1D)));
                    float var24 = this.computeValue(vec);
                    if (var11 == null) {
                        var13 = var16;
                        Object var14 = vec;
                    }
                    var12 = var24;
                }
            }
            if (var14 == null) {
                return null;
            }
            return new DirServiceComponent();
        }
        return null;
    }

    public Vec3d resolveMinecraftObject(Direction dir, BlockPos bp, float wallRange, float range, boolean random) {
        Box var18 = this.resolveMinecraftObject(dir);
        List positions = new ArrayList();
        if (var17 == null) {
            if ((var18.field_1320 - var18.field_1323) == 0.0D) {
            }
        } else {
        }
        if (0) {
            double var20 = var18.field_1322;
            if (var20 < var18.field_1325) {
                if (0L >= 0 && var17 == null) {
                    double var22 = var18.field_1321;
                    if (var22 < var18.field_1324) {
                        Vec3d vec = new Vec3d((bp.method_10263() + var18.field_1323), (bp.method_10264() + var20), (bp.method_10260() + var22));
                        if (0L >= 0) {
                            if (var17 == null) {
                                if (0L > 0) {
                                    if (0L > 0) {
                                        if (!(this.checkCondition(vec, bp, wallRange, range))) {
                                        }
                                    }
                                    var22 = (var22 + 0.1D);
                                }
                            }
                        }
                        var20 = (var20 + 0.1D);
                        if (0L >= 0) {
                        }
                    }
                    if (0L >= 0) {
                    }
                }
            }
            if (var17 == null) {
                if ((var18.field_1325 - var18.field_1322) == 0.0D) {
                }
            } else {
            }
            if (0) {
                var20 = var18.field_1323;
                if (var20 < var18.field_1320) {
                    if (0L >= 0 && var17 == null) {
                        var22 = var18.field_1321;
                        if (var22 < var18.field_1324) {
                            vec = new Vec3d((bp.method_10263() + var20), (bp.method_10264() + var18.field_1322), (bp.method_10260() + var22));
                            if (0L > 0) {
                                if (var17 == null) {
                                    if (0L > 0) {
                                        if (0L >= 0) {
                                            if (!(this.checkCondition(vec, bp, wallRange, range))) {
                                            }
                                        }
                                        var22 = (var22 + 0.1D);
                                    }
                                }
                            }
                            var20 = (var20 + 0.1D);
                            if (0L >= 0) {
                            }
                        }
                        if (0L > 0) {
                        }
                    }
                }
                if (var17 == null) {
                    if ((var18.field_1324 - var18.field_1321) == 0.0D) {
                    }
                } else {
                }
                if (0) {
                    var20 = var18.field_1323;
                    if (var20 < var18.field_1320) {
                        if (var17 == null) {
                            var22 = var18.field_1322;
                            if (var22 < var18.field_1325) {
                                vec = new Vec3d((bp.method_10263() + var20), (bp.method_10264() + var22), (bp.method_10260() + var18.field_1321));
                                if (0L > 0) {
                                    if (var17 == null) {
                                        if (0L > 0) {
                                            if (!(this.checkCondition(vec, bp, wallRange, range))) {
                                            }
                                        }
                                        var22 = (var22 + 0.1D);
                                    }
                                }
                            }
                            var20 = (var20 + 0.1D);
                            if (0L >= 0) {
                            }
                        }
                        if (0L > 0) {
                            if (0L > 0 && var17 == null) {
                                if (positions.isEmpty()) {
                                    return null;
                                }
                            }
                            if (random) {
                            }
                        }
                    }
                }
            }
        } else {
            var20 = (Iterable) positions;
            int var21 = 0;
            var22 = var20.iterator();
            if (var17 == null) {
                if (!(var22.hasNext())) {
                }
            }
            Object var23 = var22.next();
            if (var17 == null) {
                if (!(var22.hasNext())) {
                }
            }
            vec = (Vec3d) var23;
            int var26 = 0;
            vec = SharedKt.getPlayer().getEyePos().method_1025(vec);
            var26 = var22.next();
            Vec3d vec2 = (Vec3d) var26;
            int var29 = 0;
            vec2 = SharedKt.getPlayer().getEyePos().method_1025(vec2);
            if (Double.compare(vec, vec2) > 0) {
                var23 = var26;
                vec = vec2;
            }
        }
        return (Vec3d) var23;
    }

    public Box resolveMinecraftObject(Direction dir) {
        return new NoWhenBranchMatchedException();
    }

    public boolean checkCondition(Vec3d point, BlockPos bp, float wallRange, float range) {
        class_3959 var17 = new class_3959(this.resolveMinecraftObject(SharedKt.getPlayer()), point, class_3960.field_17558, class_242.field_1348, SharedKt.getPlayer());
        class_3965 var18 = SharedKt.getWorld().method_17742();
        float var19 = this.computeValue(point);
        if (var16 == null) {
        }
        if (var16 == null) {
            if (var16 == null) {
                if (var18.method_17783() == class_240.field_1332 && !(Intrinsics.areEqual(var18.method_17777(), bp)) && var19 > (wallRange * wallRange)) {
                    return true;
                }
            }
        }
        if (var16 == null) {
            if (var19 > (range * range)) {
            }
        } else {
        }
        return false;
    }

    public boolean checkCondition(Block b) {
        if (!(b instanceof class_2237)) {
            if (!(Intrinsics.areEqual(b, Blocks.field_9980))) {
                if (!(b instanceof class_2533)) {
                    if (!(b instanceof class_2401)) {
                        if (!(b instanceof class_2269)) {
                            if (var4 == null && var4 == null && var4 == null && var4 == null && var4 == null && var4 == null) {
                                if (b instanceof class_2323) {
                                }
                            }
                        }
                    }
                }
            }
        } else {
        }
        return false;
    }

    public boolean checkCondition(Vec3d pos, int fov) {
        double var8 = (pos.method_10216() - SharedKt.getPlayer().getX());
        double var10 = (pos.method_10215() - SharedKt.getPlayer().getZ());
        float var12 = class_3532.method_15393((class_3532.method_15338((Math.toDegrees(Math.atan2()) - 90.0D)) - class_3532.method_15393(SharedKt.getPlayer().method_36454())));
        if (var7 == null) {
            if (Math.abs() <= fov) {
            }
        } else {
        }
        return false;
    }

    public class_3965 resolveMinecraftObject(class_3959 context, BlockPos block, BlockState state) {
        return (class_3965) class_1922.method_17744(context.method_17750(), context.method_17747(), context, this::resolveMinecraftObject, this::resolveMinecraftObject);
    }

    public static class_3965 resolveMinecraftObject(VecPacketHelper arg0, class_3959 arg1, BlockPos arg2, BlockState arg3, int arg4, Object arg5) {
        if ((arg4 & 4)) {
            arg3 = Blocks.OBSIDIAN.method_9564();
        }
        return arg0.resolveMinecraftObject(arg1, arg2, arg3);
    }

    public boolean checkCondition(Entity entity, MoveFixServiceComponent rotation, float distance, boolean rayTrace) {
        float var16 = distance;
        double var18 = class_3532.method_33723();
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).method_1031(0.0D, SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()), 0.0D);
        double var22 = 0.0D;
        if (rayTrace) {
            class_239 var21 = EventPacketHelper2.INSTANCE.resolveMinecraftObject(distance, rotation.getNumericValue(), rotation.getNumericValue2());
            if (var15 == null) {
                var22 = var21.method_17784().method_1025(vec);
                if (var21.method_17783() != class_240.field_1333) {
                    var18 = var22;
                    var16 = Math.sqrt();
                } else {
                }
            }
        }
        Vec3d vec2 = EventPacketHelper2.INSTANCE.resolveMinecraftObject(rotation.getNumericValue2(), rotation.getNumericValue());
        Vec3d vec3 = vec.method_1031((vec2.field_1352 * var16), (vec2.field_1351 * var16), (vec2.field_1350 * var16));
        Box var26 = SharedKt.getPlayer().method_5829().method_18804(vec2.method_1021()).method_1009(1.0D, 1.0D, 1.0D);
        class_3966 var27 = class_1675.method_18075(SharedKt.getPlayer(), vec, vec3, this::checkCondition);
        if (var27 == null) {
            return false;
        }
        if (var21 != null) {
            if (var15 == null && var15 == null) {
                if (var27.method_17784().method_1025(vec) < var22) {
                }
            }
        } else {
        }
        class_239 var28 = (class_239) var27.resolveMinecraftObject(vec, distance);
        if (var15 == null) {
        }
        if (var15 == null) {
            if (var28 instanceof class_3966 && Intrinsics.areEqual((class_3966) var28.method_17782(), entity)) {
            }
        } else {
        }
        if (0 != null) {
        }
        return true;
    }

    private class_239 resolveMinecraftObject(class_239 arg0, Vec3d arg1, float arg2) {
        if (var6 == null) {
            if (!(arg0.method_17784().method_24802(arg1, arg2))) {
                Vec3d vec = arg0.method_17784();
                return (class_239) class_3965.method_17778(vec, Direction.method_10142((vec.field_1352 - arg1.field_1352), (vec.field_1351 - arg1.field_1351), (vec.field_1350 - arg1.field_1350)), BlockPos.ofFloored(vec));
            }
        }
        return arg0;
    }

    public List resolveList() {
        BlockPos blockPos = BlockPos.ofFloored(SharedKt.getPlayer().getEyePos());
        double var7 = Math.ceil(SharedKt.getPlayer().method_55754());
        Iterable var8 = (Iterable) new IntRange((blockPos.method_10263() - var7), (blockPos.method_10263() + var7));
        int var9 = 0;
        Object var10 = var8;
        Collection var11 = (Collection) new ArrayList();
        int var12 = 0;
        Iterator iterator = var10.iterator();
        if (iterator.hasNext()) {
            int var14 = (IntIterator) iterator.nextInt();
            int var15 = var14;
            int var16 = 0;
            Iterable var17 = (Iterable) new IntRange((blockPos.method_10264() - var7), (blockPos.method_10264() + var7));
            int var18 = 0;
            Object var19 = var17;
            if (var5 == null) {
                Collection var20 = (Collection) new ArrayList();
                int var21 = 0;
                Iterator iterator2 = var19.iterator();
                if (iterator2.hasNext()) {
                    int var23 = (IntIterator) iterator2.nextInt();
                    int var24 = var23;
                    int var25 = 0;
                    Iterable var26 = (Iterable) new IntRange((blockPos.method_10260() - var7), (blockPos.method_10260() + var7));
                    int var27 = 0;
                    Object var28 = var26;
                    Collection var29 = (Collection) new ArrayList();
                    int var30 = 0;
                    Object var31 = var28;
                    int var32 = 0;
                    Iterator iterator3 = var31.iterator();
                    if (iterator3.hasNext()) {
                        int var34 = (IntIterator) iterator3.nextInt();
                        int var35 = var34;
                        int var36 = 0;
                        int var37 = var35;
                        int var38 = 0;
                        BlockPos blockPos2 = new BlockPos();
                        int var40 = 0;
                        var29.add(blockPos2);
                        if (var5 == null) {
                        }
                    }
                    Iterable var41 = (Iterable) var29;
                    CollectionsKt.addAll();
                }
                var15 = (Iterable) var20;
                CollectionsKt.addAll();
            }
        }
        return var11;
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Direction direction) {
        float var8 = 0.0F;
        float var9 = -10.0F;
        float var10 = (EventPacketHelper2.INSTANCE.computeValue() / 360.0F);
        return new MoveFixServiceComponent((var8 + (var10 * 360)));
    }

    private static Packet resolveMinecraftObject(class_3965 arg0, int arg1) {
        return (Packet) new class_2885(Hand.field_5808, arg0, arg1);
    }

    private static Unit resolveUnit(int arg0, BlockPlacementSwitchMode arg1, class_3965 arg2, BlockPlacementPlaceMode arg3, BlockPos arg4) {
        int var28 = SharedKt.getPlayer().method_31548().method_67532();
        if (var27 == null) {
            ItemPacketHelper.INSTANCE.executeAction(arg0);
            ItemPacketHelper.INSTANCE.executeAction2(arg0);
            if (arg0 != -1 && var27 != null && var27 != null) {
            }
        }
        if (var27 == null) {
        }
        if (var27 == null) {
            if (INSTANCE.checkCondition(SharedKt.getWorld().getBlockState(arg2.method_17777()).getBlock()) && !(SharedKt.getPlayer().method_5715())) {
            }
        } else {
        }
        int var29 = 0;
        if (var29) {
            ViafabricplusServiceComponent.INSTANCE.executeAction(1);
        }
        if (arg3 == BlockPlacementPlaceMode.Normal) {
        }
        INSTANCE.executeAction(this::resolveMinecraftObject);
        PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
        lookupMap2.put(arg4, Long.valueOf(SharedKt.getNumericValue()));
        if (var27 == null) {
            if (var29) {
                ViafabricplusServiceComponent.INSTANCE.executeAction(0);
            }
        }
        if (var27 == null) {
        }
        ItemPacketHelper.INSTANCE.executeAction();
        if (var28 != -1 && var27 != null) {
            ItemPacketHelper.INSTANCE.executeAction2(arg0);
        }
        return Unit.INSTANCE;
    }

    private static boolean checkCondition(PositionServiceComponent arg0) {
        if (var3 == null) {
            if (arg0.getMinecraftObject() != Direction.UP) {
            }
            if (arg0.getMinecraftObject() == Direction.DOWN) {
            }
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static boolean checkCondition(ArrayList arg0, PositionServiceComponent arg1) {
        Iterable var5 = (Iterable) arg0;
        int var6 = 0;
        if (var5 instanceof Collection) {
            if (var4 == null && var4 == null) {
                if ((Collection) var5.isEmpty()) {
                }
            }
        }
        Iterator iterator = var5.iterator();
        if (iterator.hasNext()) {
            Object var8 = iterator.next();
            Entity entity = var8;
            int var10 = 0;
            if (var4 == null) {
                if (entity.method_5707(arg1.getMinecraftObject().toCenterPos().method_43206(arg1.getMinecraftObject(), 0.5D)) < 0.5D) {
                }
            } else {
            }
        } else {
        }
        return false;
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static class_3965 resolveMinecraftObject(BlockPos arg0, BlockState arg1, class_3959 arg2, BlockPos arg3) {
        if (!(arg3.equals(arg0))) {
        }
        Object var9 = arg1;
        Object var8 = var9;
        var9 = arg2.method_17750();
        Vec3d vec = arg2.method_17747();
        class_265 var11 = arg2.method_17748((class_1922) SharedKt.getWorld(), arg3);
        class_3965 var12 = SharedKt.getWorld().method_17745(vec, arg3);
        class_265 var13 = class_259.method_1073();
        class_3965 var14 = var13.method_1092(vec, arg3);
        if (var12 == null) {
        }
        double var15 = arg2.method_17750().method_1025(var12.method_17784());
        if (var14 == null) {
        }
        double var17 = arg2.method_17750().method_1025(var14.method_17784());
        if (var15 <= var17) {
        }
        return var14;
    }

    private static class_3965 resolveMinecraftObject(class_3959 arg0) {
        Vec3d vec = arg0.method_17750().method_1020(arg0.method_17747());
        return class_3965.method_17778(arg0.method_17747(), Direction.method_10142(vec.field_1352, vec.field_1351, vec.field_1350), BlockPos.ofFloored(arg0.method_17747()));
    }

    private static boolean checkCondition(Entity arg0, Entity arg1) {
        if (var4 == null) {
        }
        if (var4 == null) {
            if (arg1.method_5863() && Intrinsics.areEqual(arg1, arg0)) {
            }
        } else {
        }
        return false;
    }

    static {
        INSTANCE = new VecPacketHelper();
        Pair[] var22 = new Pair[6];
        var22[0] = TuplesKt.to(Direction.UP, new BlockPos(0, -1, 0));
        var22[1] = TuplesKt.to(Direction.DOWN, new BlockPos(0, 1, 0));
        var22[2] = TuplesKt.to(Direction.NORTH, new BlockPos(-1, 0, 0));
        var22[3] = TuplesKt.to(Direction.WEST, new BlockPos(1, 0, 0));
        var22[4] = TuplesKt.to(Direction.EAST, new BlockPos(0, 0, 1));
        var22[5] = TuplesKt.to(Direction.SOUTH, new BlockPos(0, 0, -1));
        lookupMap = MapsKt.mapOf();
        lookupMap2 = (Map) new LinkedHashMap();
        vec3d = Vec3d.ZERO;
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
