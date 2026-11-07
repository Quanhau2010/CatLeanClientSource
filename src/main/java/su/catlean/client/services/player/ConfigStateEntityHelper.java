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
        int index = 0;
        long time = SharedKt.getNumericValue();
        Pair pair = TuplesKt.to(ConfigStateServiceComponent2.resolveDamageDataServiceComponent(configState, resolveList(receiver, configState, false, false)), Long.valueOf((SharedKt.getNumericValue() - time)));
        index = ((DamageDataServiceComponent) pair.component1());
        time = ((Number) pair.component2()).longValue();
        receiver.updateValue2(time);
        return index;
    }

    public static class_3965 resolveMinecraftObject(AutoCrystalModule receiver, boolean onlyNoPositions, boolean sponges) {
        float factor = 0.0F;
        float factor2 = 0.0F;
        EntitiesEntityHelper entitiesEntityHelper = receiver.resolveEntitiesEntityHelper();
        if (!(__UNDEF_KEY__)) {
            if (ConfigStateServiceComponent2.resolveDamageDataServiceComponent(entitiesEntityHelper, resolveList(receiver, entitiesEntityHelper, false, sponges)) != null) {
                DamageDataServiceComponent damageDataServiceComponent = ConfigStateServiceComponent2.resolveDamageDataServiceComponent(entitiesEntityHelper, resolveList(receiver, entitiesEntityHelper, false, sponges));
                int index = 0;
                factor2 = damageDataServiceComponent.getServiceComponent95().getNumericValue();
            } else {
            }
        }
        if (!(__UNDEF_KEY__)) {
        }
        if (!(__UNDEF_KEY__)) {
            if (factor2 == 0.0F) {
            } else {
            }
        }
        if (onlyNoPositions && !(0)) {
            return null;
        }
        if (ConfigStateServiceComponent2.resolveDamageDataServiceComponent(entitiesEntityHelper, resolveList(receiver, entitiesEntityHelper, true, sponges)) != null) {
            index = ConfigStateServiceComponent2.resolveDamageDataServiceComponent(entitiesEntityHelper, resolveList(receiver, entitiesEntityHelper, true, sponges));
            factor = index.getServiceComponent95().getNumericValue();
        } else {
        }
        if (!(__UNDEF_KEY__)) {
            if (((DamageDataServiceComponent) receiver.getAtomicReference().get()) != null && ((DamageDataServiceComponent) receiver.getAtomicReference().get()).getServiceComponent95() != null) {
            }
        }
        if (!(__UNDEF_KEY__)) {
        }
        if (!(__UNDEF_KEY__)) {
            if (factor > 0.0F && factor2 < factor) {
                if (Math.abs((factor - factor2)) <= 1.0F) {
                    return null;
                }
            }
        }
        return __UNDEF_KEY__;
    }

    private static List resolveList(AutoCrystalModule arg0, EntitiesEntityHelper arg1, boolean arg2, boolean arg3) {
        BlockPos blockPos = BlockPos.ofFloored(SharedKt.getPlayer().getEyePos());
        Vec3d vec = PlayerEntityHelper2.INSTANCE.predictPosition(((PlayerEntity) SharedKt.getPlayer()), 1);
        double offset = Math.ceil(arg1.getNumericValue());
        IntRange intRange = new IntRange((blockPos.method_10263() - offset), (blockPos.method_10263() + offset));
        IntRange intRange2 = new IntRange((blockPos.method_10264() - offset), (blockPos.method_10264() + offset));
        IntRange intRange3 = new IntRange((blockPos.method_10260() - offset), (blockPos.method_10260() + offset));
        Iterable iterable = ((Iterable) intRange);
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            int index = ((IntIterator) iterator).nextInt();
            Iterable iterable2 = ((Iterable) intRange2);
            if (!(__UNDEF_KEY__)) {
                Collection collection2 = ((Collection) new ArrayList());
                Iterator iterator2 = iterable2.iterator();
                while (iterator2.hasNext()) {
                    int index2 = ((IntIterator) iterator2).nextInt();
                    Iterable iterable3 = ((Iterable) intRange3);
                    Collection collection3 = ((Collection) new ArrayList());
                    Iterator iterator3 = iterable3.iterator();
                    while (iterator3.hasNext()) {
                        int index3 = ((IntIterator) iterator3).nextInt();
                        if (!(__UNDEF_KEY__)) {
                            BlockPos blockPos2 = new BlockPos(index, index2, index3);
                            if (resolveDamageDataServiceComponent(arg0, blockPos2, vec, arg1, arg2, arg3) != null) {
                                DamageDataServiceComponent damageDataServiceComponent = resolveDamageDataServiceComponent(arg0, blockPos2, vec, arg1, arg2, arg3);
                                collection3.add(damageDataServiceComponent);
                            } else {
                            }
                        }
                    }
                    Iterable iterable4 = ((Iterable) collection3);
                    CollectionsKt.addAll(collection2, iterable4);
                }
                Iterable iterable5 = ((Iterable) collection2);
                CollectionsKt.addAll(collection, iterable5);
            }
        }
        return collection;
    }

    private static List resolveList(AutoCrystalModule arg0, EntitiesEntityHelper arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        if ((arg4 & 2) != 0) {
            arg2 = 0;
        }
        if ((arg4 & 4) != 0) {
            arg3 = 0;
        }
        return resolveList(arg0, arg1, arg2, arg3);
    }

    public static DamageDataServiceComponent resolveDamageDataServiceComponent(AutoCrystalModule receiver, BlockPos bp, Vec3d predictedPlayerPos, EntitiesEntityHelper configState, boolean basePlace, boolean sponges) {
        if (!(__UNDEF_KEY__)) {
            if (CrystalServiceComponent2.INSTANCE.checkCondition(bp)) {
                return null;
            }
        }
        if (configState.isActive7()) {
            if (!(__UNDEF_KEY__) && __UNDEF_KEY__ >= 0 && !(__UNDEF_KEY__)) {
                if (checkCondition(bp, configState.getMinecraftObject())) {
                    return null;
                }
            }
        }
        if (receiver.resolveMinecraftObject(configState.getMinecraftObject()).method_1022(bp.toCenterPos().method_1031(0.0D, 0.5D, 0.0D)) > 12.0D) {
            return null;
        }
        BlockState state = SharedKt.getWorld().getBlockState(bp);
        Block block = state.getBlock();
        if (!(Intrinsics.areEqual(block, Blocks.OBSIDIAN))) {
            if (!(Intrinsics.areEqual(block, Blocks.field_9987))) {
                if (__UNDEF_KEY__ > 0) {
                    if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                        if (!(basePlace)) {
                            return null;
                        }
                    }
                }
            }
        }
        if (basePlace) {
            if (__UNDEF_KEY__ >= 0) {
                if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                    if (!(state.method_45474())) {
                        return null;
                    }
                }
            }
        }
        if (__UNDEF_KEY__ > 0 && !(__UNDEF_KEY__)) {
        }
        if (basePlace && !(AutoBasePlaceModule.INSTANCE.checkCondition(bp))) {
            return null;
        }
        BlockState state2 = SharedKt.getWorld().getBlockState(bp.up());
        int index = 0;
        if (configState.isActive8()) {
            if (__UNDEF_KEY__ >= 0) {
                if (!(__UNDEF_KEY__)) {
                    if (!(Intrinsics.areEqual(state2.getBlock(), Blocks.field_10164))) {
                        if (__UNDEF_KEY__ < 0) {
                            if (!(__UNDEF_KEY__)) {
                                if (!(Intrinsics.areEqual(state2.getBlock(), Blocks.field_10589))) {
                                    if (__UNDEF_KEY__ <= 0) {
                                        if (!(__UNDEF_KEY__)) {
                                            if (!(Intrinsics.areEqual(state2.getBlock(), Blocks.field_10091))) {
                                                if (__UNDEF_KEY__ < 0) {
                                                    if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                                                        if (Intrinsics.areEqual(state2.getBlock(), Blocks.field_10336)) {
                                                            Item[] items = new Item[1];
                                                            items[0] = Items.field_8276;
                                                            StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
                                                            Item[] items2 = new Item[1];
                                                            items2[0] = Items.field_8725;
                                                            items = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items2);
                                                            Item[] items3 = new Item[1];
                                                            items3[0] = Items.field_8810;
                                                            items2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items3);
                                                            if (!(__UNDEF_KEY__)) {
                                                                if (stackServiceComponent2.isActive()) {
                                                                }
                                                                if (!(__UNDEF_KEY__)) {
                                                                    if (items.isActive()) {
                                                                    } else {
                                                                    }
                                                                }
                                                            }
                                                            items3 = items2;
                                                            index = items3.isActive();
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
        if (!(state2.method_26215())) {
            if (__UNDEF_KEY__ > 0) {
                if (!(__UNDEF_KEY__)) {
                    if (Intrinsics.areEqual(state2.getBlock(), Blocks.field_10036)) {
                        if (!(configState.isActive4())) {
                            if (__UNDEF_KEY__ < 0) {
                                if (!(__UNDEF_KEY__)) {
                                    if (sponges) {
                                        if (!(Intrinsics.areEqual(state2.getBlock(), Blocks.BEDROCK))) {
                                            if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__) && !(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                                                if (index) {
                                                } else {
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
        stackServiceComponent2 = 0;
        if (__UNDEF_KEY__ < 0) {
            if (!(__UNDEF_KEY__)) {
                if (stackServiceComponent2) {
                    if (configState.isActive()) {
                        if (!(__UNDEF_KEY__) && __UNDEF_KEY__ >= 0 && !(__UNDEF_KEY__)) {
                            if (!(SharedKt.getWorld().method_22347(bp.method_10086(2)))) {
                                return null;
                            }
                            if (__UNDEF_KEY__ >= 0) {
                                if (!(__UNDEF_KEY__)) {
                                    EntitiesEntityHelper entitiesEntityHelper = configState;
                                    int index2 = 1;
                                    BlockPos blockPos = bp;
                                    if (checkCondition(receiver, blockPos, index2, entitiesEntityHelper)) {
                                        return null;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        entitiesEntityHelper = basePlace;
        index2 = 1;
        blockPos = 0;
        if (__UNDEF_KEY__ >= 0) {
            if (ConfigStateServiceComponent2.resolveServiceComponent95(receiver, bp, configState, blockPos, index2, entitiesEntityHelper) == null) {
                ConfigStateServiceComponent2.resolveServiceComponent95(receiver, bp, configState, blockPos, index2, entitiesEntityHelper);
                return null;
            }
        }
        items = 1;
        if (__UNDEF_KEY__ >= 0) {
            if (!(__UNDEF_KEY__)) {
                if (resolveMinecraftObject(bp, configState, basePlace) == null) {
                    resolveMinecraftObject(bp, configState, basePlace);
                    return null;
                }
            }
        }
        items2 = items;
        if (!(checkCondition(items2.method_17784(), bp, predictedPlayerPos, configState))) {
            return null;
        }
        return new DamageDataServiceComponent(items2, items);
    }

    public static DamageDataServiceComponent resolveDamageDataServiceComponent(AutoCrystalModule arg0, BlockPos arg1, Vec3d arg2, EntitiesEntityHelper arg3, boolean arg4, boolean arg5, int arg6, Object arg7) {
        arg4 = 0;
        arg5 = 0;
        return resolveDamageDataServiceComponent(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static class_3965 resolveMinecraftObject(BlockPos bp, EntitiesEntityHelper configState, boolean basePlace) {
        if (configState.isActive3()) {
        }
        return resolveMinecraftObject(bp, configState);
    }

    public static class_3965 resolveMinecraftObject(BlockPos arg0, EntitiesEntityHelper arg1, boolean arg2, int arg3, Object arg4) {
        if ((arg3 & 4) != 0) {
            arg2 = 0;
        }
        return resolveMinecraftObject(arg0, arg1, arg2);
    }

    private static class_3965 resolveMinecraftObject(BlockPos arg0, EntitiesEntityHelper arg1) {
        float factor = arg1.getNumericValue();
        if (!(__UNDEF_KEY__)) {
            if (MoveFixModule.INSTANCE.getEnabled()) {
            } else {
            }
        }
        int index = arg0.method_10264();
        if (!(__UNDEF_KEY__)) {
            if (SharedKt.getPlayer().getEyePos().field_1351 > index) {
                Iterable iterable = ((Iterable) itemList);
                int index2 = 0;
                Iterator iterator = iterable.iterator();
                if (!(__UNDEF_KEY__)) {
                    if (!(iterator.hasNext())) {
                    }
                }
                Object element = iterator.next();
                if (!(__UNDEF_KEY__)) {
                    if (!(iterator.hasNext())) {
                    }
                }
                Vec3d vec = ((Vec3d) element);
                int index3 = 0;
                Vec3d vec2 = new Vec3d((arg0.method_10263() + vec.field_1352), ((arg0.method_10264() + vec.field_1351) + 1.0D), (arg0.method_10260() + vec.field_1350));
                vec = EventPacketHelper2.INSTANCE.computeValue(vec2);
                index3 = iterator.next();
                Vec3d vec3 = ((Vec3d) index3);
                vec2 = new Vec3d((arg0.method_10263() + vec3.field_1352), ((arg0.method_10264() + vec3.field_1351) + 1.0D), (arg0.method_10260() + vec3.field_1350));
                vec3 = EventPacketHelper2.INSTANCE.computeValue(vec2);
                if (Float.compare(vec, vec3) > 0) {
                    element = index3;
                    vec = vec3;
                }
                Vec3d vec4 = ((Vec3d) element);
                iterable = new Vec3d((arg0.method_10263() + vec4.field_1352), (arg0.method_10264() + 1.0D), (arg0.method_10260() + vec4.field_1350));
                if (!(__UNDEF_KEY__)) {
                    if (iterable.method_1025(VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer())) <= (arg1.getNumericValue() * arg1.getNumericValue())) {
                        return new class_3965(iterable, Direction.UP, arg0, false);
                    }
                }
            }
        }
        if (!(__UNDEF_KEY__)) {
        }
        if (SharedKt.getPlayer().getEyePos().field_1351 < arg0.method_10264() && SharedKt.getWorld().method_22347(arg0.down())) {
            iterable = ((Iterable) itemList);
            index2 = 0;
            iterator = iterable.iterator();
            if (!(__UNDEF_KEY__)) {
                if (!(iterator.hasNext())) {
                }
            }
            element = iterator.next();
            if (!(__UNDEF_KEY__)) {
                if (!(iterator.hasNext())) {
                }
            }
            vec = ((Vec3d) element);
            index3 = 0;
            vec2 = new Vec3d((arg0.method_10263() + vec.field_1352), (arg0.method_10264() + vec.field_1351), (arg0.method_10260() + vec.field_1350));
            vec = EventPacketHelper2.INSTANCE.computeValue(vec2);
            index3 = iterator.next();
            vec3 = ((Vec3d) index3);
            vec2 = new Vec3d((arg0.method_10263() + vec3.field_1352), (arg0.method_10264() + vec3.field_1351), (arg0.method_10260() + vec3.field_1350));
            vec3 = EventPacketHelper2.INSTANCE.computeValue(vec2);
            if (Float.compare(vec, vec3) > 0) {
                element = index3;
                vec = vec3;
            }
            vec4 = ((Vec3d) element);
            iterable = new Vec3d((arg0.method_10263() + vec4.field_1352), arg0.method_10264(), (arg0.method_10260() + vec4.field_1350));
            if (iterable.method_1025(VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer())) <= (arg1.getNumericValue() * arg1.getNumericValue())) {
                return new class_3965(iterable, Direction.DOWN, arg0, false);
            }
        }
        vec4 = VecPacketHelper.INSTANCE.resolveList(arg0).iterator();
        while (vec4.hasNext()) {
            iterable = ((Direction) vec4.next());
            if (!(__UNDEF_KEY__)) {
                if (!(__UNDEF_KEY__)) {
                }
                if (iterable == Direction.DOWN) {
                }
                index2 = new Vec3d(((arg0.method_10263() + 0.5D) + (iterable.method_62675().method_10263() * 0.5D)), (arg0.method_10264() + 0.99D), ((arg0.method_10260() + 0.5D) + (iterable.method_62675().method_10260() * 0.5D)));
                iterator = EventPacketHelper2.INSTANCE.computeValue(index2);
                if (!(__UNDEF_KEY__)) {
                    Iterable iterable2 = iterable;
                }
                factor = iterator;
            }
        }
        if (iterable2 == null) {
            return null;
        }
        vec4 = arg0.toCenterPos().method_1031((iterable2.method_62675().method_10263() * 0.5D), (iterable2.method_62675().method_10264() * 0.5D), (iterable2.method_62675().method_10260() * 0.5D));
        return new class_3965(vec4, iterable2, arg0, false);
    }

    private static class_3965 resolveMinecraftObject(BlockPos arg0, EntitiesEntityHelper arg1, boolean arg2) {
        Iterator iterator = ((Map) MapsKt.toSortedMap(lookupMap, Comparator.comparing(this::resolveFloat))).entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            Vec3d vec = new Vec3d((arg0.method_10263() + ((Vec3d) entry.getKey()).field_1352), ((arg0.method_10264() + ((Vec3d) entry.getKey()).field_1351) - 0.01D), (arg0.method_10260() + ((Vec3d) entry.getKey()).field_1350));
            if (EventPacketHelper2.INSTANCE.computeValue(vec) > arg1.getNumericValue()) {
            }
            if (arg2) {
            }
            class_3965 class3965 = VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).resolveMinecraftObject(vec, 0, CollectionsKt.listOf(arg0), CollectionsKt.emptyList(), arg2);
            if (__UNDEF_KEY__) {
            }
            if (__UNDEF_KEY__) {
                if (class3965 != null && class3965.method_17783() == class_240.field_1332) {
                    if (__UNDEF_KEY__) {
                        if (!(Intrinsics.areEqual(class3965.method_17777(), arg0))) {
                        }
                    }
                }
            }
            return class3965;
        }
        return null;
    }

    private static boolean checkCondition(Vec3d arg0, BlockPos arg1, Vec3d arg2, EntitiesEntityHelper arg3) {
        Vec3d vec = arg2.method_1031(0.0D, SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()), 0.0D);
        if (!(__UNDEF_KEY__)) {
            if (arg3.isActive3()) {
                if (ConfigStateServiceComponent.INSTANCE.resolveMinecraftObject(arg1.toCenterPos().method_1031(0.0D, 0.5D, 0.0D), arg3, vec) != null) {
                }
            } else {
                if (!(__UNDEF_KEY__)) {
                    if (arg3.isActive9()) {
                    }
                }
                if (!(__UNDEF_KEY__)) {
                    if (vec.method_1022(arg0) <= arg3.getNumericValue2()) {
                    } else {
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkCondition(AutoCrystalModule receiver, BlockPos base, boolean calcPhase, EntitiesEntityHelper configState) {
        if (!(__UNDEF_KEY__)) {
            if (SharedKt.getNetwork().method_45734() != null) {
                if (!(StringsKt.contains$default(((CharSequence) SharedKt.getNetwork().method_45734().field_3761), ((CharSequence) "crystalpvp.cc"), false))) {
                }
            }
        }
        Box box = new Box(base.up());
        if (receiver.getAtomicReference().get() != null) {
            Iterable iterable = ((Iterable) ServiceComponent119.enumEntries);
            int index = 0;
            if (iterable instanceof Collection) {
                if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                    if (((Collection) iterable).isEmpty()) {
                    }
                }
            }
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                Direction direction = ((Direction) element);
                if (!(__UNDEF_KEY__)) {
                    if (((DamageDataServiceComponent) receiver.getAtomicReference().get()) != null && ((class_3965) ((DamageDataServiceComponent) receiver.getAtomicReference().get()).getObject()) != null) {
                        if (!(__UNDEF_KEY__)) {
                            if (((class_3965) ((DamageDataServiceComponent) receiver.getAtomicReference().get()).getObject()).method_17777() == null) {
                            }
                        }
                    }
                }
            }
            if (!(0)) {
                iterable = ((Iterable) ServiceComponent119.enumEntries);
                index = 0;
                if (iterable instanceof Collection) {
                    if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                        if (((Collection) iterable).isEmpty()) {
                        }
                    }
                }
                iterator = iterable.iterator();
                while (iterator.hasNext()) {
                    element = iterator.next();
                    direction = ((Direction) element);
                }
                if (0) {
                }
            }
        }
        box = 0;
        if (!(__UNDEF_KEY__)) {
        }
        if (!(__UNDEF_KEY__)) {
            if (receiver.getMap().containsKey(base.up()) && !(box)) {
                return true;
            }
        }
        iterable = configState.getList().iterator();
        while (iterable.hasNext()) {
            index = iterable.next();
            if (!(__UNDEF_KEY__)) {
            }
            if (!(__UNDEF_KEY__)) {
                if (index != null && index.isAlive()) {
                    if (!(__UNDEF_KEY__)) {
                        if (index.method_5649((base.method_10263() + 0.5D), (base.method_10264() + 0.5D), (base.method_10260() + 0.5D)) > 16.0D) {
                        }
                    }
                }
            }
            if (!(__UNDEF_KEY__)) {
                if (index instanceof PlayerEntity) {
                    iterator = 0;
                    element = receiver.computeValue();
                    if (iterator <= element) {
                        if (PlayerEntityHelper2.INSTANCE.predictPosition(((PlayerEntity) index), iterator).method_994(box)) {
                            if (!(__UNDEF_KEY__)) {
                                return true;
                            }
                        }
                        if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                            if (iterator != element) {
                            }
                        }
                    }
                }
            }
            if (!(__UNDEF_KEY__)) {
            }
            if (!(__UNDEF_KEY__)) {
                if (index instanceof class_1303) {
                }
            }
            if (index instanceof class_1542) {
                if (!(__UNDEF_KEY__)) {
                    if (!(((class_1542) index).method_5809())) {
                        if (!(__UNDEF_KEY__)) {
                            if (!(CrystalServiceComponent2.INSTANCE.checkCondition(((class_1542) index).method_5628()))) {
                                if (!(__UNDEF_KEY__)) {
                                    if (!(receiver.getMap().containsKey(base.up()))) {
                                        if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                                            if (Intrinsics.areEqual(((class_1542) index).method_6983().getItem(), Items.field_8276)) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (index instanceof EndCrystalEntity) {
                if (!(__UNDEF_KEY__)) {
                    if (CrystalServiceComponent2.INSTANCE.checkCondition(((EndCrystalEntity) index).method_5628())) {
                    }
                }
                if (!(__UNDEF_KEY__)) {
                    if (CrystalServiceComponent2.INSTANCE.checkCondition(((EndCrystalEntity) index).method_5628())) {
                        return true;
                    }
                }
                if (!(__UNDEF_KEY__)) {
                    if (calcPhase) {
                        if (ConfigStateServiceComponent.INSTANCE.resolveServiceComponent95(receiver, receiver.resolveMinecraftObject(index), configState, true, ((EndCrystalEntity) index).field_6012) != null) {
                            if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                                if (receiver.resolveMinecraftObject(index).method_1025(box.method_1005()) > 0.3D) {
                                    ConfigStateServiceComponent.INSTANCE.updateValue(((EndCrystalEntity) index));
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean checkCondition(BlockPos bp, PlayerEntity target) {
        if (!(__UNDEF_KEY__)) {
            if (!(target.method_6115())) {
                return false;
            }
        }
        if (!(Intrinsics.areEqual(target.method_6079().getItem(), Items.field_8255))) {
            if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                if (!(Intrinsics.areEqual(target.method_6047().getItem(), Items.field_8255))) {
                    return false;
                }
            }
        }
        Vec3d vec = target.method_5631(0.0F, target.field_6241);
        Vec3d vec2 = bp.toCenterPos().method_1031(0.0D, 0.5D, 0.0D).method_1035(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(target));
        if (!(__UNDEF_KEY__)) {
            if (new Vec3d(vec2.field_1352, 0.0D, vec2.field_1350).method_1029().method_1026(vec) < 0.0D) {
            } else {
            }
        }
        return false;
    }

    private static Float resolveFloat(BlockPos arg0, Vec3d arg1) {
        Vec3d vec = new Vec3d((arg0.method_10263() + arg1.field_1352), (arg0.method_10264() + arg1.field_1351), (arg0.method_10260() + arg1.field_1350));
        return Float.valueOf(EventPacketHelper2.INSTANCE.computeValue(vec));
    }

    private static Float resolveFloat(Function1 arg0, Object arg1) {
        return ((Float) arg0.invoke(arg1));
    }

    static {
        Pair[] items = new Pair[14];
        items[0] = TuplesKt.to(new Vec3d(0.5D, 1.0D, 0.5D), Boolean.valueOf(true));
        items[1] = TuplesKt.to(new Vec3d(0.5D, 0.0D, 0.5D), Boolean.valueOf(true));
        items[2] = TuplesKt.to(new Vec3d(0.5D, 0.5D, 0.0D), Boolean.valueOf(true));
        items[3] = TuplesKt.to(new Vec3d(0.5D, 0.5D, 1.0D), Boolean.valueOf(true));
        items[4] = TuplesKt.to(new Vec3d(0.0D, 0.5D, 0.5D), Boolean.valueOf(true));
        items[5] = TuplesKt.to(new Vec3d(1.0D, 0.5D, 0.5D), Boolean.valueOf(true));
        items[6] = TuplesKt.to(new Vec3d(0.05D, 0.05D, 0.05D), Boolean.valueOf(false));
        items[7] = TuplesKt.to(new Vec3d(0.05D, 0.05D, 0.95D), Boolean.valueOf(false));
        items[8] = TuplesKt.to(new Vec3d(0.05D, 0.95D, 0.05D), Boolean.valueOf(false));
        items[9] = TuplesKt.to(new Vec3d(0.05D, 0.95D, 0.95D), Boolean.valueOf(false));
        items[10] = TuplesKt.to(new Vec3d(0.95D, 0.05D, 0.05D), Boolean.valueOf(false));
        items[11] = TuplesKt.to(new Vec3d(0.95D, 0.05D, 0.95D), Boolean.valueOf(false));
        items[12] = TuplesKt.to(new Vec3d(0.95D, 0.95D, 0.05D), Boolean.valueOf(false));
        items[13] = TuplesKt.to(new Vec3d(0.95D, 0.95D, 0.95D), Boolean.valueOf(false));
        lookupMap = MapsKt.mapOf(items);
        items = new Vec3d[9];
        items[0] = new Vec3d(0.51D, 0.0D, 0.49D);
        items[1] = new Vec3d(0.05D, 0.0D, 0.05D);
        items[2] = new Vec3d(0.05D, 0.0D, 0.95D);
        items[3] = new Vec3d(0.95D, 0.0D, 0.05D);
        items[4] = new Vec3d(0.95D, 0.0D, 0.95D);
        items[5] = new Vec3d(0.475D, 0.0D, 0.95D);
        items[6] = new Vec3d(0.475D, 0.0D, 0.05D);
        items[7] = new Vec3d(0.95D, 0.0D, 0.025D);
        items[8] = new Vec3d(0.05D, 0.0D, 0.475D);
        itemList = CollectionsKt.listOf(items);
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        boolean flag = isActive();
        if (!(flag)) {
            return true;
        }
        return false;
    }

}
