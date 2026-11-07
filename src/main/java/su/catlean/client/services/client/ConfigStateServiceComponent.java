package su.catlean.client.services.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.movement.basic.MoveFixModule;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.player.ConfigStateEntityHelper;
import su.catlean.client.services.player.EntitiesEntityHelper;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.tools.comparators.Comparator6;

public class ConfigStateServiceComponent {

    public static final ConfigStateServiceComponent INSTANCE;
    private static EndCrystalEntity minecraftRef;

    private ConfigStateServiceComponent() {
    }

    public EndCrystalEntity getMinecraftObject() {
        return minecraftRef;
    }

    public void updateValue(EndCrystalEntity value) {
        minecraftRef = value;
    }

    public CrystalServiceComponent resolveCrystalServiceComponent(AutoCrystalModule receiver, EntitiesEntityHelper configState) {
        if (__UNDEF_KEY__) {
            if (minecraftRef != null) {
                minecraftRef = null;
                if (this.resolveServiceComponent95(receiver, receiver.resolveMinecraftObject(minecraftRef), configState, true, minecraftRef.field_6012) != null) {
                    return new CrystalServiceComponent(minecraftRef, true);
                }
            }
        }
        if (__UNDEF_KEY__) {
        }
        if (ConfigStateServiceComponent2.resolveDamageDataServiceComponent(configState, this.resolveList(receiver, configState)) != null && ((EndCrystalEntity) ConfigStateServiceComponent2.resolveDamageDataServiceComponent(configState, this.resolveList(receiver, configState)).getObject()) != null) {
            EndCrystalEntity entity = ((EndCrystalEntity) ConfigStateServiceComponent2.resolveDamageDataServiceComponent(configState, this.resolveList(receiver, configState)).getObject());
            if (!(__UNDEF_KEY__)) {
            }
        }
        return null;
    }

    private List resolveList(AutoCrystalModule arg0, short arg1, EntitiesEntityHelper arg2, char arg3, int arg4) {
        Iterable iterable = ((Iterable) arg2.getList());
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (arg4 >= 0) {
                if (!(__UNDEF_KEY__)) {
                    if (!(__UNDEF_KEY__)) {
                    }
                    collection.add(element);
                    iterable = ((Iterable) collection);
                    iterable2 = iterable;
                    collection = ((Collection) new ArrayList());
                    if (arg4 >= 0) {
                    }
                }
            }
        }
        iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            EndCrystalEntity entity = ((EndCrystalEntity) element);
            int index = 0;
            if (arg3 > 0) {
                if (!(__UNDEF_KEY__)) {
                    if (arg4 >= 0) {
                        if (!(__UNDEF_KEY__)) {
                        }
                    }
                    if (arg3 >= 0) {
                        if (!(__UNDEF_KEY__)) {
                        }
                    }
                    if (arg1 >= 0) {
                        if (!(__UNDEF_KEY__)) {
                        }
                    }
                    if (!(__UNDEF_KEY__)) {
                        if (!(entity.method_31481()) && !(CrystalServiceComponent2.INSTANCE.checkCondition(entity.method_5628())) && !(CrystalServiceComponent2.INSTANCE.checkCondition(entity.method_5628())) && arg0.resolveMinecraftObject(SharedKt.getPlayer()).method_1025(arg0.resolveMinecraftObject(entity)) <= 49.0D) {
                        } else {
                        }
                    }
                    collection.add(element);
                    iterable = ((Iterable) collection);
                    iterable2 = iterable;
                    collection = ((Collection) new ArrayList());
                    if (arg4 > 0) {
                    }
                }
            }
        }
        iterator = iterable2;
        element = 0;
        entity = iterator.iterator();
        while (entity.hasNext()) {
            index = entity.next();
            EndCrystalEntity entity2 = ((EndCrystalEntity) index);
            if (arg3 > 0) {
                if (!(__UNDEF_KEY__)) {
                    if (!(__UNDEF_KEY__)) {
                        if (INSTANCE.resolveServiceComponent95(arg0, arg0.resolveMinecraftObject(entity2), arg2, false, entity2.field_6012) != null) {
                            ServiceComponent95 serviceComponent95 = INSTANCE.resolveServiceComponent95(arg0, arg0.resolveMinecraftObject(entity2), arg2, false, entity2.field_6012);
                        } else {
                        }
                    }
                    if (null != null) {
                        collection.add();
                    } else {
                    }
                    if (arg1 >= 0) {
                    }
                }
            }
        }
        return collection;
    }

    public Vec3d resolveMinecraftObject(Vec3d vec, EntitiesEntityHelper configState, Vec3d eyes) {
        if (!(__UNDEF_KEY__)) {
            if (!(configState.isActive3())) {
                return new Vec3d(RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1352, (vec.field_1352 - 1.0D), (vec.field_1352 + 1.0D)), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1351, vec.field_1351, (vec.field_1351 + 2.0D)), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1350, (vec.field_1350 - 1.0D), (vec.field_1350 + 1.0D)));
            }
        }
        List<BlockPos> list = new ArrayList();
        Vec3d vec2 = vec.method_1031(-1.0D, 0.0D, -1.0D);
        int index = 0;
        if (index < 3) {
            int index2 = 0;
            if (index2 < 3) {
                int index3 = 0;
                if (index3 < 3) {
                    list.add(new Vec3d((vec2.field_1352 + index), (vec2.field_1351 + index2), (vec2.field_1350 + index3)));
                    if (!(__UNDEF_KEY__)) {
                    }
                }
            }
        }
        index2 = ((Iterable) list);
        index3 = 0;
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = index2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Vec3d vec3 = ((Vec3d) element);
            if (!(__UNDEF_KEY__)) {
                if (!(__UNDEF_KEY__)) {
                    if (configState.isActive9()) {
                    }
                }
                if (!(__UNDEF_KEY__)) {
                    if (eyes.method_1022(vec3) <= configState.getNumericValue2()) {
                    } else {
                    }
                }
                if (!(__UNDEF_KEY__)) {
                }
                collection.add(element);
                index2 = ((Iterable) collection);
            }
        }
        index3 = 0;
        index = CollectionsKt.sortedWith(index2, ((Comparator) new Comparator6(eyes))).iterator();
        while (index.hasNext()) {
            index2 = ((Vec3d) index.next());
            return index2;
        }
        if (null != null) {
            if (__UNDEF_KEY__) {
            }
        }
        return 0;
    }

    public ServiceComponent95 resolveServiceComponent95(AutoCrystalModule receiver, Vec3d pos, EntitiesEntityHelper configState, boolean secondaryCrystal, int age) {
        BlockPos blockPos = BlockPos.ofFloored(pos.method_1031(0.0D, -0.1D, 0.0D));
        if (!(__UNDEF_KEY__)) {
            if (!(__UNDEF_KEY__)) {
                if (!((receiver.getNumericValue() % 4))) {
                }
            }
            if (receiver.getRandomizeDelay() && 2 < RangeServiceComponent.P(0, 1, false)) {
                return null;
            }
        }
        if (!(__UNDEF_KEY__)) {
            if (!(configState.isActive3())) {
                if (!(__UNDEF_KEY__)) {
                    if (MoveFixModule.INSTANCE.getEnabled()) {
                    } else {
                    }
                }
                int index = blockPos.method_10264();
                Vec3d vec = pos;
                if (!(__UNDEF_KEY__)) {
                    if (SharedKt.getPlayer().getEyePos().field_1351 > index) {
                        Iterable iterable = ((Iterable) ConfigStateEntityHelper.getList());
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
                        Vec3d vec2 = ((Vec3d) element);
                        int index2 = 0;
                        Vec3d vec3 = new Vec3d((blockPos.method_10263() + vec2.field_1352), ((blockPos.method_10264() + vec2.field_1351) + 1.0D), (blockPos.method_10260() + vec2.field_1350));
                        vec2 = EventPacketHelper2.INSTANCE.computeValue(vec3);
                        index2 = iterator.next();
                        Vec3d vec4 = ((Vec3d) index2);
                        vec3 = new Vec3d((blockPos.method_10263() + vec4.field_1352), ((blockPos.method_10264() + vec4.field_1351) + 1.0D), (blockPos.method_10260() + vec4.field_1350));
                        vec4 = EventPacketHelper2.INSTANCE.computeValue(vec3);
                        if (Float.compare(vec2, vec4) > 0) {
                            element = index2;
                            vec2 = vec4;
                        }
                        Vec3d vec5 = ((Vec3d) element);
                        vec = new Vec3d((blockPos.method_10263() + vec5.field_1352), (blockPos.method_10264() + 1.0D), (blockPos.method_10260() + vec5.field_1350));
                    }
                }
                if (!(__UNDEF_KEY__)) {
                    if (configState.isActive9()) {
                        return null;
                    }
                }
                return null;
            }
        }
        if (!(InteractVecServiceComponent.INSTANCE.checkCondition(pos, vec)) && vec.method_1025(VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer())) > (configState.getNumericValue() * configState.getNumericValue()) && E(this, pos, configState) == null) {
            return null;
        }
        return ConfigStateServiceComponent2.resolveServiceComponent95(receiver, blockPos, configState, secondaryCrystal, false, false);
    }

    static {
        INSTANCE = new ConfigStateServiceComponent();
    }

}
