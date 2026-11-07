package su.catlean.client.services.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1667;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.movement.basic.AntiKnockBackModule;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalFriendProtectionMode;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.features.modules.utility.player.SpeedMineModule;
import su.catlean.client.services.player.EntitiesEntityHelper;
import su.catlean.client.services.player.EntityHelper2;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.player.ExplosionPosEntityHelper;

public class ConfigStateServiceComponent2 {

    public static DamageDataServiceComponent resolveDamageDataServiceComponent(EntitiesEntityHelper configState, List clearedList) {
        if (__UNDEF_KEY__ == null) {
            if (clearedList.isEmpty()) {
                return null;
            }
        }
        Iterable iterable = ((Iterable) clearedList);
        int index = 0;
        Iterator iterator = iterable.iterator();
        if (__UNDEF_KEY__ == null) {
            if (!(iterator.hasNext())) {
            }
        }
        Object element = iterator.next();
        if (__UNDEF_KEY__ == null) {
            if (!(iterator.hasNext())) {
            }
        }
        DamageDataServiceComponent damageDataServiceComponent = ((DamageDataServiceComponent) element);
        int index2 = 0;
        damageDataServiceComponent = damageDataServiceComponent.getServiceComponent95().getNumericValue();
        index2 = iterator.next();
        DamageDataServiceComponent damageDataServiceComponent2 = ((DamageDataServiceComponent) index2);
        int index3 = 0;
        damageDataServiceComponent2 = damageDataServiceComponent2.getServiceComponent95().getNumericValue();
        if (Float.compare(damageDataServiceComponent, damageDataServiceComponent2) < 0) {
            element = index2;
            damageDataServiceComponent = damageDataServiceComponent2;
        }
        DamageDataServiceComponent damageDataServiceComponent3 = ((DamageDataServiceComponent) element);
        if (configState.isActive6()) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (clearedList.size() > 1) {
                    iterable = clearedList.iterator();
                    while (iterable.hasNext()) {
                        index = ((DamageDataServiceComponent) iterable.next());
                        if (__UNDEF_KEY__ == null) {
                            if (__UNDEF_KEY__ == null) {
                                if (Intrinsics.areEqual(index, damageDataServiceComponent3)) {
                                }
                                iterator = (damageDataServiceComponent3.getServiceComponent95().getNumericValue() - index.getServiceComponent95().getNumericValue());
                                element = (damageDataServiceComponent3.getServiceComponent95().getNumericValue2() - index.getServiceComponent95().getNumericValue2());
                                if (__UNDEF_KEY__ == null) {
                                    if (damageDataServiceComponent3.getServiceComponent95().getNumericValue2() > index.getServiceComponent95().getNumericValue2()) {
                                    } else {
                                    }
                                }
                                damageDataServiceComponent = 0;
                                if (__UNDEF_KEY__ == null) {
                                }
                                if (__UNDEF_KEY__ == null) {
                                }
                                if (iterator > configState.getNumericValue8()) {
                                    if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                                    }
                                }
                                if (damageDataServiceComponent3.getServiceComponent95().isActive2()) {
                                    if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                                    }
                                }
                                damageDataServiceComponent3 = index;
                                if (__UNDEF_KEY__ == null) {
                                    if (__UNDEF_KEY__ == null) {
                                        if (damageDataServiceComponent3.getObject() instanceof class_3965 && clearedList.size() > 1) {
                                            iterable = ((class_3965) damageDataServiceComponent3.getObject()).method_17777();
                                            index = SpeedMineModule.resolveList(false);
                                            iterator = configState.getMinecraftObject().method_24515();
                                            if (iterable.method_10263() == iterator.method_10263()) {
                                                if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                                                    if (iterable.method_10260() != iterator.method_10260()) {
                                                    } else {
                                                    }
                                                }
                                            }
                                            element = 0;
                                            if (__UNDEF_KEY__ == null) {
                                            }
                                            if (index.contains(iterable) && element) {
                                                index2 = ((Iterable) clearedList);
                                                damageDataServiceComponent2 = 0;
                                                index3 = index2;
                                                Collection collection = ((Collection) new ArrayList());
                                                int index4 = 0;
                                                Iterator iterator2 = index3.iterator();
                                                while (iterator2.hasNext()) {
                                                    Object element2 = iterator2.next();
                                                    DamageDataServiceComponent damageDataServiceComponent4 = ((DamageDataServiceComponent) element2);
                                                    if (__UNDEF_KEY__ == null) {
                                                        if (__UNDEF_KEY__ == null) {
                                                        }
                                                        if (__UNDEF_KEY__ == null) {
                                                            if (damageDataServiceComponent4.getObject() instanceof class_3965 && !(index.contains(((class_3965) damageDataServiceComponent4.getObject()).method_17777()))) {
                                                            } else {
                                                            }
                                                        }
                                                        collection.add(element2);
                                                        index2 = ((Iterable) collection);
                                                    }
                                                }
                                                damageDataServiceComponent2 = 0;
                                                index3 = index2.iterator();
                                                if (__UNDEF_KEY__ == null) {
                                                    if (!(index3.hasNext())) {
                                                    }
                                                    collection = index3.next();
                                                    if (__UNDEF_KEY__ == null) {
                                                        if (!(index3.hasNext())) {
                                                        }
                                                    }
                                                }
                                                index4 = ((DamageDataServiceComponent) collection);
                                                iterator2 = 0;
                                                index4 = index4.getServiceComponent95().getNumericValue();
                                                iterator2 = index3.next();
                                                element2 = ((DamageDataServiceComponent) iterator2);
                                                damageDataServiceComponent4 = 0;
                                                element2 = element2.getServiceComponent95().getNumericValue();
                                                if (Float.compare(index4, element2) < 0) {
                                                    collection = iterator2;
                                                    index4 = element2;
                                                }
                                                damageDataServiceComponent = ((DamageDataServiceComponent) collection);
                                                if (__UNDEF_KEY__ == null) {
                                                    if (damageDataServiceComponent != null) {
                                                        return damageDataServiceComponent;
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
        return damageDataServiceComponent3;
    }

    private static boolean checkCondition(float arg0, float arg1, EntitiesEntityHelper arg2) {
        if (arg2.isActive2()) {
            float factor = (arg2.getMinecraftObject().method_6032() + arg2.getMinecraftObject().method_6067());
            float factor2 = (SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067());
            if ((arg0 * arg2.getNumericValue()) > factor) {
            } else {
            }
            int index = 0;
            if (arg1 < factor2) {
            } else {
            }
            int index2 = 0;
            if (arg1 > arg2.getNumericValue3() && index && index2) {
            } else {
            }
            return false;
        }
        return false;
    }

    private static boolean checkCondition(float arg0, EntitiesEntityHelper arg1) {
        float factor = (arg1.getMinecraftObject().method_6032() + arg1.getMinecraftObject().method_6067());
        if (__UNDEF_KEY__ == null) {
            if (arg0 >= 0.6D) {
                if (__UNDEF_KEY__ == null) {
                    if (!(arg1.isActive13())) {
                        return false;
                    }
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
            if (arg0 <= 4.0F) {
                if (__UNDEF_KEY__ == null) {
                    if ((arg0 * arg1.getNumericValue()) > factor && !(AuraModule.INSTANCE.checkCondition())) {
                        return true;
                    }
                }
            }
        }
        Iterator iterator = EntityHelper2.resolveList(arg1.getMinecraftObject()).iterator();
        while (iterator.hasNext()) {
            ItemStack stack = ((ItemStack) iterator.next());
            if (__UNDEF_KEY__ == null) {
            }
            return true;
        }
        if (arg1.isActive11()) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (Intrinsics.areEqual(SharedKt.getWorld().getBlockState(BlockPos.ofFloored(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(arg1.getMinecraftObject()))).getBlock(), Blocks.field_10316)) {
                    return true;
                }
            }
        }
        if (arg1.isActive10()) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (AutoCrystalModule.INSTANCE.checkCondition()) {
                    return true;
                }
            }
        }
        if (arg1.isActive12()) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (arg1.getMinecraftObject().method_24518(Items.field_8102)) {
                    iterator = ((Iterable) arg1.getList());
                    stack = 0;
                    Iterator iterator2 = iterator;
                    Collection collection = ((Collection) new ArrayList());
                    int index = 0;
                    Iterator iterator3 = iterator2.iterator();
                    while (iterator3.hasNext()) {
                        Object element = iterator3.next();
                        if (__UNDEF_KEY__ == null) {
                            if (__UNDEF_KEY__ == null) {
                            }
                            collection.add(element);
                            iterator = ((Iterable) collection);
                            stack = 0;
                        }
                    }
                    if (iterator instanceof Collection) {
                        if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                            if (((Collection) iterator).isEmpty()) {
                            }
                        }
                    }
                    iterator2 = iterator.iterator();
                    while (iterator2.hasNext()) {
                        collection = iterator2.next();
                        index = ((class_1667) collection);
                        iterator3 = 0;
                        if (__UNDEF_KEY__ == null) {
                        }
                        if (__UNDEF_KEY__ == null) {
                        }
                        if (__UNDEF_KEY__ == null) {
                            if (index.field_6012 < 5 && AntiKnockBackModule.INSTANCE.resolveMinecraftObject(index).field_1351 > arg1.getMinecraftObject().getY() && arg1.getMinecraftObject().getEyePos().method_1025(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(index)) < 9.0D) {
                            } else {
                            }
                        }
                    }
                    if (0) {
                        return true;
                    }
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
            if (factor <= arg1.getNumericValue6() && !(AuraModule.INSTANCE.checkCondition())) {
            } else {
            }
        }
        return false;
    }

    public static ServiceComponent95 resolveServiceComponent95(AutoCrystalModule receiver, BlockPos pos, EntitiesEntityHelper configState, boolean ignoreMinDamage, boolean place, boolean basePlace) {
        Vec3d vec = pos.toCenterPos().method_1031(0.0D, 0.5D, 0.0D);
        if (place) {
        }
        List list = CollectionsKt.emptyList();
        if (basePlace) {
        }
        if (__UNDEF_KEY__ == null) {
            if (place) {
            } else {
            }
        }
        float factor = vec.computeValue(configState.getMinecraftObject(), receiver.computeValue(), 0, configState.isActive5(), list, basePlace);
        if (!(checkCondition(factor, configState))) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (factor > configState.getNumericValue4()) {
                } else {
                }
            }
        }
        int index = 0;
        if (__UNDEF_KEY__ > 0L && __UNDEF_KEY__ == null) {
        }
        if (!(index) && !(ignoreMinDamage)) {
            return null;
        }
        float factor2 = DamageSyncServiceComponent.INSTANCE.computeValue(ExplosionPosEntityHelper.INSTANCE.computeValue(vec, ((PlayerEntity) SharedKt.getPlayer()), receiver.computeValue(place), configState.isActive5(), list, basePlace));
        boolean flag = checkCondition(factor, factor2, configState);
        if (__UNDEF_KEY__ == null) {
            if (configState.getAutoCrystalFriendProtectionMode() != AutoCrystalFriendProtectionMode.NONE) {
                Iterable iterable = ((Iterable) configState.getList());
                int index2 = 0;
                Iterable iterable2 = iterable;
                Collection collection = ((Collection) new ArrayList());
                Iterator iterator = iterable2.iterator();
                while (iterator.hasNext()) {
                    Object element = iterator.next();
                    if (__UNDEF_KEY__ >= 0L) {
                        if (__UNDEF_KEY__ == null) {
                            if (__UNDEF_KEY__ == null) {
                            }
                            collection.add(element);
                            iterable = ((Iterable) collection);
                            index2 = 0;
                            iterable2 = iterable;
                            collection = ((Collection) new ArrayList());
                            if (__UNDEF_KEY__ > 0L) {
                            }
                        }
                    }
                }
                iterator = iterable2.iterator();
                while (iterator.hasNext()) {
                    element = iterator.next();
                    PlayerEntity player = ((PlayerEntity) element);
                    if (__UNDEF_KEY__ >= 0L) {
                        if (__UNDEF_KEY__ == null) {
                            if (__UNDEF_KEY__ >= 0) {
                                if (__UNDEF_KEY__ == null) {
                                }
                            }
                            if (__UNDEF_KEY__ == null) {
                                if (player.isAlive() && EntityHelper4.isFriend(player)) {
                                } else {
                                }
                            }
                            collection.add(element);
                            Iterator iterator2 = collection.iterator();
                            while (iterator2.hasNext()) {
                                iterable = ((PlayerEntity) iterator2.next());
                                if (__UNDEF_KEY__ == null) {
                                    if (place) {
                                    } else {
                                    }
                                }
                                index2 = vec.computeValue(iterable, receiver.computeValue(), 0, configState.isActive5(), list, basePlace);
                                if (__UNDEF_KEY__ >= 0) {
                                    if (__UNDEF_KEY__ == null) {
                                        if (configState.getAutoCrystalFriendProtectionMode() == AutoCrystalFriendProtectionMode.ONLY_LETHAL) {
                                            if (__UNDEF_KEY__ == null) {
                                                return null;
                                                factor2 = Math.max(factor2, index2);
                                                if (__UNDEF_KEY__ >= 0) {
                                                    if (__UNDEF_KEY__ == null) {
                                                        if (!(checkCondition(factor, factor2, flag, configState))) {
                                                            return null;
                                                        }
                                                    }
                                                }
                                                if (__UNDEF_KEY__ == null) {
                                                }
                                                if (factor2 > configState.getNumericValue3() && !(flag)) {
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
            }
        }
        return new ServiceComponent95(factor, factor2, flag, factor >= (configState.getMinecraftObject().method_6032() + configState.getMinecraftObject().method_6067()));
    }

    private static boolean checkCondition(float arg0, float arg1, boolean arg2, EntitiesEntityHelper arg3, char arg4) {
        if (arg2) {
            return true;
        }
        if (arg4 > 0 && __UNDEF_KEY__ == null) {
            if (arg1 > (SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067())) {
                return false;
            }
        }
        if ((arg0 / arg1) >= arg3.getNumericValue7()) {
        } else {
        }
        return false;
    }

}
