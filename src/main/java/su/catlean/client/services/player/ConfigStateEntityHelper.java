package su.catlean.client.services.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1303;
import net.minecraft.class_1542;
import net.minecraft.class_2382;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.AntiKnockBackModule;
import su.catlean.client.features.modules.movement.basic.MoveFixModule;
import su.catlean.client.features.modules.pvp.attack.AutoBasePlaceModule;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.services.client.ConfigStateServiceComponent;
import su.catlean.client.services.client.ConfigStateServiceComponent2;
import su.catlean.client.services.client.CrystalServiceComponent2;
import su.catlean.client.services.client.DamageDataServiceComponent;
import su.catlean.client.services.client.InteractVecServiceComponent;
import su.catlean.client.services.client.ServiceComponent119;
import su.catlean.client.services.client.ServiceComponent95;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;

public class ConfigStateEntityHelper {

    private static final double preciseValue = 0.05D;
    private static final double preciseValue2 = 0.95D;
    private static final double preciseValue3 = 0.5D;
    private static final Map lookupMap;
    private static final List itemList;
    private static boolean enabledFlag;

    public static Map getMap() {
        return lookupMap;
    }

    public static List getList() {
        return itemList;
    }

    public static DamageDataServiceComponent resolveDamageDataServiceComponent(AutoCrystalModule receiver, EntitiesEntityHelper configState) {
        int var9 = 0;
        long var10 = SharedKt.getNumericValue();
        int var12 = 0;
        Pair var8 = TuplesKt.to(ConfigStateServiceComponent2.resolveDamageDataServiceComponent(configState, resolveList(receiver, configState)), Long.valueOf((SharedKt.getNumericValue() - var10)));
        var9 = (DamageDataServiceComponent) var8.component1();
        var10 = (Number) var8.component2().longValue();
        receiver.updateValue2();
        return var9;
    }

    public static class_3965 resolveMinecraftObject(AutoCrystalModule receiver, boolean onlyNoPositions, boolean sponges) {
        float var12 = 0.0F;
        float var13 = 0.0F;
        EntitiesEntityHelper var14 = receiver.resolveEntitiesEntityHelper();
        if (!(var11)) {
            if (ConfigStateServiceComponent2.resolveDamageDataServiceComponent(resolveList(receiver, 0, sponges)) != null) {
                DamageDataServiceComponent var16 = ConfigStateServiceComponent2.resolveDamageDataServiceComponent(resolveList(receiver, 0, sponges));
                Object var17 = var16;
                int var18 = 0;
                var13 = var17.getServiceComponent95().getNumericValue();
            } else {
            }
        }
        if (!(var11)) {
        }
        if (!(var11)) {
            if (var13 == 0.0F) {
            }
        } else {
        }
        if (onlyNoPositions && !(0)) {
            return null;
        }
        if (ConfigStateServiceComponent2.resolveDamageDataServiceComponent(resolveList(receiver, 1, sponges)) != null) {
            var18 = ConfigStateServiceComponent2.resolveDamageDataServiceComponent(resolveList(receiver, 1, sponges));
            Object var19 = var18;
            int var20 = 0;
            var12 = var19.getServiceComponent95().getNumericValue();
        } else {
        }
        if (!(var11)) {
            if ((DamageDataServiceComponent) receiver.getAtomicReference().get() != null && (DamageDataServiceComponent) receiver.getAtomicReference().get().getServiceComponent95() != null) {
            }
        }
        if (!(var11)) {
        }
        if (!(var11)) {
            if (var12 > 0.0F && var13 < var12) {
            }
            if (Math.abs((var12 - var13)) <= 1.0F) {
            }
            return null;
        }
        return var15;
    }

    private static List resolveList(AutoCrystalModule arg0, EntitiesEntityHelper arg1, boolean arg2, boolean arg3) {
        BlockPos blockPos = BlockPos.ofFloored(SharedKt.getPlayer().getEyePos());
        Vec3d vec = PlayerEntityHelper2.INSTANCE.predictPosition((PlayerEntity) SharedKt.getPlayer(), 1);
        double var21 = Math.ceil(arg1.getNumericValue());
        IntRange var22 = new IntRange((blockPos.method_10263() - var21), (blockPos.method_10263() + var21));
        IntRange var23 = new IntRange((blockPos.method_10264() - var21), (blockPos.method_10264() + var21));
        IntRange var24 = new IntRange((blockPos.method_10260() - var21), (blockPos.method_10260() + var21));
        Iterable var25 = (Iterable) var22;
        int var26 = 0;
        Object var27 = var25;
        Collection var28 = (Collection) new ArrayList();
        int var29 = 0;
        Iterator iterator = var27.iterator();
        if (iterator.hasNext()) {
            int var31 = (IntIterator) iterator.nextInt();
            int var32 = var31;
            int var33 = 0;
            Iterable var34 = (Iterable) var23;
            int var35 = 0;
            Object var36 = var34;
            if (!(var18)) {
                Collection var37 = (Collection) new ArrayList();
                int var38 = 0;
                Iterator iterator2 = var36.iterator();
                if (iterator2.hasNext()) {
                    int var40 = (IntIterator) iterator2.nextInt();
                    int var41 = var40;
                    int var42 = 0;
                    Iterable var43 = (Iterable) var24;
                    int var44 = 0;
                    Object var45 = var43;
                    Collection var46 = (Collection) new ArrayList();
                    int var47 = 0;
                    Object var48 = var45;
                    int var49 = 0;
                    Iterator iterator3 = var48.iterator();
                    if (iterator3.hasNext()) {
                        int var51 = (IntIterator) iterator3.nextInt();
                        int var52 = var51;
                        int var53 = 0;
                        int var54 = var52;
                        int var55 = 0;
                        if (!(var18)) {
                            int var13 = arg3;
                            int var14 = arg2;
                            Object var15 = arg1;
                            Object var16 = vec;
                            BlockPos blockPos2 = new BlockPos();
                            if (resolveDamageDataServiceComponent(arg0, blockPos2) != null) {
                                DamageDataServiceComponent var56 = resolveDamageDataServiceComponent(arg0, blockPos2);
                                int var57 = 0;
                                var46.add();
                            } else {
                            }
                        }
                    }
                    Iterable var58 = (Iterable) var46;
                    CollectionsKt.addAll();
                }
                Iterable var59 = (Iterable) var37;
                CollectionsKt.addAll();
            }
        }
        return var28;
    }

    private static List resolveList(AutoCrystalModule arg0, EntitiesEntityHelper arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        if (!(var10)) {
            if ((arg4 & 2)) {
                arg2 = 0;
            }
        }
        if (!(var10)) {
            if ((arg4 & 4)) {
            }
            arg3 = 0;
        }
        return resolveList(arg0, arg1, arg2, arg3);
    }

    public static DamageDataServiceComponent resolveDamageDataServiceComponent(AutoCrystalModule receiver, BlockPos bp, Vec3d predictedPlayerPos, EntitiesEntityHelper configState, boolean basePlace, boolean sponges) {
        if (!(var42)) {
            if (CrystalServiceComponent2.INSTANCE.checkCondition(bp)) {
                return null;
            }
        }
        if (configState.isActive7()) {
            if (!(var42) && 0L >= 0 && !(var42)) {
                if (checkCondition(bp, configState.getMinecraftObject())) {
                    return null;
                }
            }
        }
        if (receiver.resolveMinecraftObject(configState.getMinecraftObject()).method_1022(bp.toCenterPos().method_1031(0.0D, 0.5D, 0.0D)) > 12.0D) {
            return null;
        }
        BlockState state = SharedKt.getWorld().getBlockState(bp);
        Block var44 = state.getBlock();
        if (!(Intrinsics.areEqual(Blocks.OBSIDIAN))) {
            if (!(Intrinsics.areEqual(Blocks.field_9987))) {
                if (0L > 0) {
                    if (!(var42) && !(var42) && !(var42)) {
                        if (!(basePlace)) {
                            return null;
                        }
                    }
                }
            }
        }
        if (basePlace) {
            if (0L >= 0) {
                if (!(var42) && !(var42)) {
                    if (!(state.method_45474())) {
                        return null;
                    }
                }
            }
        }
        if (0L > 0 && !(var42)) {
        }
        if (basePlace && !(AutoBasePlaceModule.INSTANCE.checkCondition(bp))) {
            return null;
        }
        BlockState state2 = SharedKt.getWorld().getBlockState(bp.up());
        int var46 = 0;
        if (configState.isActive8()) {
            if (0L >= 0) {
                if (!(var42)) {
                    if (!(Intrinsics.areEqual(state2.getBlock(), Blocks.field_10164))) {
                    }
                }
                if (0L < 0) {
                    if (!(var42)) {
                        if (!(Intrinsics.areEqual(state2.getBlock(), Blocks.field_10589))) {
                        }
                    }
                    if (0L <= 0) {
                        if (!(var42)) {
                            if (!(Intrinsics.areEqual(state2.getBlock(), Blocks.field_10091))) {
                            }
                        }
                        if (0L < 0) {
                            if (!(var42) && !(var42)) {
                                if (Intrinsics.areEqual(state2.getBlock(), Blocks.field_10336)) {
                                }
                            }
                        }
                        Item[] var48 = new Item[1];
                        var48[0] = Items.field_8276;
                        StackServiceComponent2 var47 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
                        Item[] var49 = new Item[1];
                        var49[0] = Items.field_8725;
                        var48 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
                        Item[] var50 = new Item[1];
                        var50[0] = Items.field_8810;
                        var49 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
                        if (!(var42)) {
                            if (var47.isActive()) {
                            }
                            if (!(var42)) {
                            }
                            if (var48.isActive()) {
                            }
                        } else {
                        }
                        var50 = var49;
                        var46 = var50.isActive();
                    }
                }
            }
        }
        if (!(state2.method_26215())) {
            if (0L > 0) {
                if (!(var42)) {
                    if (Intrinsics.areEqual(state2.getBlock(), Blocks.field_10036)) {
                        if (!(configState.isActive4())) {
                        }
                    }
                }
                if (0L < 0) {
                    if (!(var42)) {
                        if (sponges) {
                            if (!(Intrinsics.areEqual(state2.getBlock(), Blocks.BEDROCK))) {
                            }
                        }
                    }
                    if (!(var42) && !(var42) && !(var42) && !(var42)) {
                        if (var46) {
                        }
                    }
                }
            }
        } else {
        }
        var47 = 0;
        if (0L < 0) {
            if (!(var42)) {
                if (var47) {
                }
            }
            if (configState.isActive()) {
                if (!(var42) && 0L >= 0 && !(var42)) {
                    if (!(SharedKt.getWorld().method_22347(bp.method_10086(2)))) {
                    }
                    return null;
                }
            }
            if (0L >= 0) {
                if (!(var42)) {
                }
                Object var36 = configState;
                int var37 = 1;
                Object var38 = bp;
            }
            if (checkCondition(receiver)) {
                return null;
            }
        }
        var36 = basePlace;
        var37 = 1;
        var38 = 0;
        Object var39 = configState;
        Object var40 = bp;
        Object var41 = receiver;
        if (0L >= 0) {
            if (ConfigStateServiceComponent2.resolveServiceComponent95() == null) {
                ConfigStateServiceComponent2.resolveServiceComponent95();
            }
            return null;
        }
        var48 = 1;
        if (0L >= 0) {
            if (!(var42)) {
            }
            if (resolveMinecraftObject(bp, configState, basePlace) == null) {
                resolveMinecraftObject(bp, configState, basePlace);
            }
            return null;
        }
        var49 = var48;
        if (!(checkCondition(var49.method_17784(), bp, predictedPlayerPos, configState))) {
            return null;
        }
        return new DamageDataServiceComponent();
    }

    public static DamageDataServiceComponent resolveDamageDataServiceComponent(AutoCrystalModule arg0, BlockPos arg1, Vec3d arg2, EntitiesEntityHelper arg3, boolean arg4, boolean arg5, int arg6, Object arg7) {
        if (var13) {
            if ((arg6 & 8)) {
                arg4 = 0;
            }
        }
        if (var13) {
            if ((arg6 & 16)) {
            }
            arg5 = 0;
        }
        return resolveDamageDataServiceComponent(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static class_3965 resolveMinecraftObject(BlockPos bp, EntitiesEntityHelper configState, boolean basePlace) {
        if (var11) {
            if (configState.isActive3()) {
            }
        }
        return resolveMinecraftObject(bp, configState);
    }

    public static class_3965 resolveMinecraftObject(BlockPos arg0, EntitiesEntityHelper arg1, boolean arg2, int arg3, Object arg4) {
        if (!(var12)) {
            if ((arg3 & 4)) {
            }
            arg2 = 0;
        }
        return resolveMinecraftObject(arg0, arg1, arg2);
    }

    private static class_3965 resolveMinecraftObject(BlockPos arg0, EntitiesEntityHelper arg1) {
        float var20 = arg1.getNumericValue();
        if (!(var19)) {
            if (MoveFixModule.INSTANCE.getEnabled()) {
            }
        } else {
        }
        int var22 = arg0.method_10264();
        if (!(var19)) {
            if (SharedKt.getPlayer().getEyePos().field_1351 > var22) {
                Iterable var24 = (Iterable) itemList;
                int var25 = 0;
                Iterator iterator = var24.iterator();
                if (!(var19)) {
                    if (!(iterator.hasNext())) {
                    }
                }
                Object var27 = iterator.next();
                if (!(var19)) {
                    if (!(iterator.hasNext())) {
                    }
                }
                Vec3d vec = (Vec3d) var27;
                int var29 = 0;
                Vec3d vec2 = new Vec3d((arg0.method_10263() + vec.field_1352), ((arg0.method_10264() + vec.field_1351) + 1.0D), (arg0.method_10260() + vec.field_1350));
                vec = EventPacketHelper2.INSTANCE.computeValue(vec2);
                var29 = iterator.next();
                Vec3d vec3 = (Vec3d) var29;
                int var31 = 0;
                vec2 = new Vec3d((arg0.method_10263() + vec3.field_1352), ((arg0.method_10264() + vec3.field_1351) + 1.0D), (arg0.method_10260() + vec3.field_1350));
                vec3 = EventPacketHelper2.INSTANCE.computeValue(vec2);
                if (Float.compare(vec, vec3) > 0) {
                    var27 = var29;
                    vec = vec3;
                }
                Vec3d vec4 = (Vec3d) var27;
                var24 = new Vec3d((arg0.method_10263() + vec4.field_1352), (arg0.method_10264() + 1.0D), (arg0.method_10260() + vec4.field_1350));
                if (!(var19)) {
                    if (var24.method_1025(VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer())) <= (arg1.getNumericValue() * arg1.getNumericValue())) {
                        return new class_3965(Direction.UP, arg0, 0);
                    }
                }
            }
        }
        if (!(var19)) {
        }
        if (SharedKt.getPlayer().getEyePos().field_1351 < arg0.method_10264() && SharedKt.getWorld().method_22347(arg0.down())) {
            var24 = (Iterable) itemList;
            var25 = 0;
            iterator = var24.iterator();
            if (!(var19)) {
                if (!(iterator.hasNext())) {
                }
            }
            var27 = iterator.next();
            if (!(var19)) {
                if (!(iterator.hasNext())) {
                }
            }
            vec = (Vec3d) var27;
            var29 = 0;
            vec2 = new Vec3d((arg0.method_10263() + vec.field_1352), (arg0.method_10264() + vec.field_1351), (arg0.method_10260() + vec.field_1350));
            vec = EventPacketHelper2.INSTANCE.computeValue(vec2);
            var29 = iterator.next();
            vec3 = (Vec3d) var29;
            var31 = 0;
            vec2 = new Vec3d((arg0.method_10263() + vec3.field_1352), (arg0.method_10264() + vec3.field_1351), (arg0.method_10260() + vec3.field_1350));
            vec3 = EventPacketHelper2.INSTANCE.computeValue(vec2);
            if (Float.compare(vec, vec3) > 0) {
                var27 = var29;
                vec = vec3;
            }
            vec4 = (Vec3d) var27;
            var24 = new Vec3d((arg0.method_10263() + vec4.field_1352), arg0.method_10264(), (arg0.method_10260() + vec4.field_1350));
            if (var24.method_1025(VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer())) <= (arg1.getNumericValue() * arg1.getNumericValue())) {
                return new class_3965(Direction.DOWN, arg0, 0);
            }
        }
        vec4 = VecPacketHelper.INSTANCE.resolveList(arg0).iterator();
        if (vec4.hasNext()) {
            var24 = (Direction) vec4.next();
            if (!(var19)) {
                if (!(var19)) {
                }
                if (var24 == Direction.DOWN) {
                }
                var25 = new Vec3d(((arg0.method_10263() + 0.5D) + (var24.method_62675().method_10263() * 0.5D)), (arg0.method_10264() + 0.99D), ((arg0.method_10260() + 0.5D) + (var24.method_62675().method_10260() * 0.5D)));
                iterator = EventPacketHelper2.INSTANCE.computeValue();
                if (!(var19)) {
                    Object var21 = var24;
                }
                var20 = iterator;
            }
        }
        if (var21 == null) {
            return null;
        }
        vec4 = arg0.toCenterPos().method_1031((var21.method_62675().method_10263() * 0.5D), (var21.method_62675().method_10264() * 0.5D), (var21.method_62675().method_10260() * 0.5D));
        return new class_3965(vec4, arg0, 0);
    }

    private static class_3965 resolveMinecraftObject(BlockPos arg0, EntitiesEntityHelper arg1, boolean arg2) {
        Iterator iterator = (Map) MapsKt.toSortedMap(lookupMap, Comparator.comparing(this::resolveFloat)).entrySet().iterator();
        if (iterator.hasNext()) {
            Entry var17 = (Entry) iterator.next();
            Vec3d vec = new Vec3d((arg0.method_10263() + (Vec3d) var17.getKey().field_1352), ((arg0.method_10264() + (Vec3d) var17.getKey().field_1351) - 0.01D), (arg0.method_10260() + (Vec3d) var17.getKey().field_1350));
            if (EventPacketHelper2.INSTANCE.computeValue(vec) > arg1.getNumericValue()) {
            }
            if (arg2) {
            }
            class_3965 var19 = VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).resolveMinecraftObject(vec, 0, CollectionsKt.listOf(arg0), CollectionsKt.emptyList(), arg2);
            if (var15) {
            }
            if (var15) {
                if (var19 != null && var19.method_17783() == class_240.field_1332) {
                }
                if (var15) {
                    if (!(Intrinsics.areEqual(var19.method_17777(), arg0))) {
                    }
                }
            }
            return var19;
        }
        return null;
    }

    private static boolean checkCondition(Vec3d arg0, BlockPos arg1, Vec3d arg2, EntitiesEntityHelper arg3) {
        Vec3d vec = arg2.method_1031(0.0D, SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()), 0.0D);
        if (!(var12)) {
            if (arg3.isActive3()) {
                if (ConfigStateServiceComponent.INSTANCE.resolveMinecraftObject(arg1.toCenterPos().method_1031(0.0D, 0.5D, 0.0D), arg3, vec) != null) {
                }
            } else {
            }
            if (!(var12)) {
                if (arg3.isActive9()) {
                }
            }
            if (!(var12)) {
                if (vec.method_1022(arg0) <= arg3.getNumericValue2()) {
                }
            } else {
            }
        }
        return false;
    }

    public static boolean checkCondition(AutoCrystalModule receiver, BlockPos base, boolean calcPhase, EntitiesEntityHelper configState) {
        if (!(var19)) {
            if (SharedKt.getNetwork().method_45734() != null) {
            }
            if (!(StringsKt.contains$default((CharSequence) SharedKt.getNetwork().method_45734().field_3761, (CharSequence) "crystalpvp.cc"))) {
            }
        }
        Box var21 = new Box(base.up());
        Object var20 = var21;
        if (receiver.getAtomicReference().get() != null) {
            Iterable var22 = (Iterable) ServiceComponent119.enumEntries;
            int var23 = 0;
            if (var22 instanceof Collection) {
                if (!(var19) && !(var19)) {
                    if ((Collection) var22.isEmpty()) {
                    }
                }
            }
            Iterator iterator = var22.iterator();
            if (iterator.hasNext()) {
                Object var25 = iterator.next();
                Direction var26 = (Direction) var25;
                int var27 = 0;
                if (!(var19)) {
                    if ((DamageDataServiceComponent) receiver.getAtomicReference().get() != null && (class_3965) (DamageDataServiceComponent) receiver.getAtomicReference().get().getObject() != null) {
                        if (!(var19)) {
                            if ((class_3965) (DamageDataServiceComponent) receiver.getAtomicReference().get().getObject().method_17777() == null) {
                            }
                        }
                    }
                }
            } else {
            }
            if (!(0)) {
            }
            var22 = (Iterable) ServiceComponent119.enumEntries;
            var23 = 0;
            if (var22 instanceof Collection) {
                if (!(var19) && !(var19)) {
                    if ((Collection) var22.isEmpty()) {
                    }
                }
            }
            iterator = var22.iterator();
            if (iterator.hasNext()) {
                var25 = iterator.next();
                var26 = (Direction) var25;
                var27 = 0;
            } else {
            }
            if (0) {
            }
        }
        var21 = 0;
        if (!(var19)) {
        }
        if (!(var19)) {
            if (receiver.getMap().containsKey(base.up()) && !(var21)) {
            }
            return true;
        }
        var22 = configState.getList().iterator();
        if (var22.hasNext()) {
            var23 = var22.next();
            if (!(var19)) {
            }
            if (!(var19)) {
                if (var23 != null && var23.isAlive()) {
                }
                if (!(var19)) {
                    if (var23.method_5649((base.method_10263() + 0.5D), (base.method_10264() + 0.5D), (base.method_10260() + 0.5D)) > 16.0D) {
                    }
                }
            }
            if (!(var19)) {
                if (var23 instanceof PlayerEntity) {
                    iterator = 0;
                    var25 = receiver.computeValue();
                    if (iterator <= var25) {
                        if (PlayerEntityHelper2.INSTANCE.predictPosition((PlayerEntity) var23, iterator).method_994()) {
                            if (!(var19)) {
                                return true;
                            }
                        }
                        if (!(var19) && !(var19)) {
                            if (iterator != var25) {
                            }
                        }
                    }
                }
            }
            if (!(var19)) {
            }
            if (!(var19)) {
                if (var23 instanceof class_1303) {
                }
            }
            if (var23 instanceof class_1542) {
                if (!(var19)) {
                    if (!((class_1542) var23.method_5809())) {
                    }
                    if (!(var19)) {
                        if (!(CrystalServiceComponent2.INSTANCE.checkCondition((class_1542) var23.method_5628()))) {
                        }
                        if (!(var19)) {
                            if (!(receiver.getMap().containsKey(base.up()))) {
                            }
                            if (!(var19) && !(var19)) {
                                if (Intrinsics.areEqual((class_1542) var23.method_6983().getItem(), Items.field_8276)) {
                                }
                            }
                        }
                    }
                }
            }
            if (var23 instanceof EndCrystalEntity) {
                if (!(var19)) {
                    if (CrystalServiceComponent2.INSTANCE.checkCondition((EndCrystalEntity) var23.method_5628())) {
                    }
                }
                if (!(var19)) {
                    if (CrystalServiceComponent2.INSTANCE.checkCondition((EndCrystalEntity) var23.method_5628())) {
                        return true;
                    }
                }
                if (!(var19)) {
                    if (calcPhase) {
                        if (ConfigStateServiceComponent.INSTANCE.resolveServiceComponent95(receiver, receiver.resolveMinecraftObject(), configState, 1, (EndCrystalEntity) var23.field_6012) != null) {
                        }
                    }
                    if (!(var19) && !(var19)) {
                        if (receiver.resolveMinecraftObject().method_1025(var20.method_1005()) > 0.3D) {
                            ConfigStateServiceComponent.INSTANCE.updateValue((EndCrystalEntity) var23);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean checkCondition(BlockPos bp, PlayerEntity target) {
        if (!(var7)) {
            if (!(target.method_6115())) {
                return false;
            }
        }
        if (!(Intrinsics.areEqual(target.method_6079().getItem(), Items.field_8255))) {
            if (!(var7) && !(var7)) {
                if (!(Intrinsics.areEqual(target.method_6047().getItem(), Items.field_8255))) {
                    return false;
                }
            }
        }
        Vec3d vec = target.method_5631(0.0F, target.field_6241);
        Vec3d vec2 = bp.toCenterPos().method_1031(0.0D, 0.5D, 0.0D).method_1035(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(target));
        if (!(var7)) {
            if (new Vec3d(vec2.field_1352, 0.0D, vec2.field_1350).method_1029().method_1026(vec) < 0.0D) {
            }
        } else {
        }
        return false;
    }

    private static Float resolveFloat(BlockPos arg0, Vec3d arg1) {
        Vec3d vec = new Vec3d((arg0.method_10263() + arg1.field_1352), (arg0.method_10264() + arg1.field_1351), (arg0.method_10260() + arg1.field_1350));
        return Float.valueOf(EventPacketHelper2.INSTANCE.computeValue(vec));
    }

    private static Float resolveFloat(Function1 arg0, Object arg1) {
        return (Float) arg0.invoke(arg1);
    }

    static {
        Pair[] var22 = new Pair[14];
        var22[0] = TuplesKt.to(new Vec3d(0.5D, 1.0D, 0.5D), Boolean.valueOf(1));
        var22[1] = TuplesKt.to(new Vec3d(0.5D, 0.0D, 0.5D), Boolean.valueOf(1));
        var22[2] = TuplesKt.to(new Vec3d(0.5D, 0.5D, 0.0D), Boolean.valueOf(1));
        var22[3] = TuplesKt.to(new Vec3d(0.5D, 0.5D, 1.0D), Boolean.valueOf(1));
        var22[4] = TuplesKt.to(new Vec3d(0.0D, 0.5D, 0.5D), Boolean.valueOf(1));
        var22[5] = TuplesKt.to(new Vec3d(1.0D, 0.5D, 0.5D), Boolean.valueOf(1));
        var22[6] = TuplesKt.to(new Vec3d(0.05D, 0.05D, 0.05D), Boolean.valueOf(0));
        var22[7] = TuplesKt.to(new Vec3d(0.05D, 0.05D, 0.95D), Boolean.valueOf(0));
        var22[8] = TuplesKt.to(new Vec3d(0.05D, 0.95D, 0.05D), Boolean.valueOf(0));
        var22[9] = TuplesKt.to(new Vec3d(0.05D, 0.95D, 0.95D), Boolean.valueOf(0));
        var22[10] = TuplesKt.to(new Vec3d(0.95D, 0.05D, 0.05D), Boolean.valueOf(0));
        var22[11] = TuplesKt.to(new Vec3d(0.95D, 0.05D, 0.95D), Boolean.valueOf(0));
        var22[12] = TuplesKt.to(new Vec3d(0.95D, 0.95D, 0.05D), Boolean.valueOf(0));
        var22[13] = TuplesKt.to(new Vec3d(0.95D, 0.95D, 0.95D), Boolean.valueOf(0));
        lookupMap = MapsKt.mapOf();
        var22 = new Vec3d[9];
        var22[0] = new Vec3d(0.51D, 0.0D, 0.49D);
        var22[1] = new Vec3d(0.05D, 0.0D, 0.05D);
        var22[2] = new Vec3d(0.05D, 0.0D, 0.95D);
        var22[3] = new Vec3d(0.95D, 0.0D, 0.05D);
        var22[4] = new Vec3d(0.95D, 0.0D, 0.95D);
        var22[5] = new Vec3d(0.475D, 0.0D, 0.95D);
        var22[6] = new Vec3d(0.475D, 0.0D, 0.05D);
        var22[7] = new Vec3d(0.95D, 0.0D, 0.025D);
        var22[8] = new Vec3d(0.05D, 0.0D, 0.475D);
        itemList = CollectionsKt.listOf();
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        boolean var0 = isActive();
        if (!(var0)) {
            return true;
        }
        return false;
    }

}
