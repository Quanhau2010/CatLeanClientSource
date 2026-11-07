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
        if (var6 == null) {
            if (clearedList.isEmpty()) {
                return null;
            }
        }
        Iterable var8 = (Iterable) clearedList;
        int var9 = 0;
        Iterator iterator = var8.iterator();
        if (var6 == null) {
            if (!(iterator.hasNext())) {
            }
        }
        Object var11 = iterator.next();
        if (var6 == null) {
            if (!(iterator.hasNext())) {
            }
        }
        DamageDataServiceComponent var12 = (DamageDataServiceComponent) var11;
        int var13 = 0;
        var12 = var12.getServiceComponent95().getNumericValue();
        var13 = iterator.next();
        DamageDataServiceComponent var14 = (DamageDataServiceComponent) var13;
        int var15 = 0;
        var14 = var14.getServiceComponent95().getNumericValue();
        if (Float.compare() < 0) {
            var11 = var13;
            var12 = var14;
        }
        DamageDataServiceComponent var7 = (DamageDataServiceComponent) var11;
        if (configState.isActive6()) {
            if (var6 == null && var6 == null) {
                if (clearedList.size() > 1) {
                    var8 = clearedList.iterator();
                    if (var8.hasNext()) {
                        var9 = (DamageDataServiceComponent) var8.next();
                        if (var6 == null) {
                            if (var6 == null) {
                                if (Intrinsics.areEqual()) {
                                }
                            }
                            iterator = (var7.getServiceComponent95().getNumericValue() - var9.getServiceComponent95().getNumericValue());
                            var11 = (var7.getServiceComponent95().getNumericValue2() - var9.getServiceComponent95().getNumericValue2());
                            if (var6 == null) {
                                if (var7.getServiceComponent95().getNumericValue2() > var9.getServiceComponent95().getNumericValue2()) {
                                }
                            } else {
                            }
                            var12 = 0;
                            if (var6 == null) {
                            }
                            if (var6 == null) {
                            }
                            if (iterator > configState.getNumericValue8()) {
                                if (var6 == null && var6 == null) {
                                }
                            }
                            if (var7.getServiceComponent95().isActive2()) {
                                if (var6 == null && var6 == null) {
                                }
                            }
                            var7 = var9;
                        }
                    }
                }
                if (var6 == null) {
                }
            }
            if (var6 == null) {
                if (var7.getObject() instanceof class_3965 && clearedList.size() > 1) {
                }
                var8 = (class_3965) var7.getObject().method_17777();
                var9 = SpeedMineModule.resolveList();
                iterator = configState.getMinecraftObject().method_24515();
                if (var8.method_10263() == iterator.method_10263()) {
                    if (var6 == null && var6 == null) {
                        if (var8.method_10260() != iterator.method_10260()) {
                        }
                    }
                } else {
                }
                var11 = 0;
                if (var6 == null) {
                }
                if (var9.contains() && var11) {
                    var13 = (Iterable) clearedList;
                    var14 = 0;
                    var15 = var13;
                    Collection var16 = (Collection) new ArrayList();
                    int var17 = 0;
                    Iterator iterator2 = var15.iterator();
                    if (iterator2.hasNext()) {
                        Object var19 = iterator2.next();
                        DamageDataServiceComponent var20 = (DamageDataServiceComponent) var19;
                        int var21 = 0;
                        if (var6 == null) {
                            if (var6 == null) {
                            }
                            if (var6 == null) {
                                if (var20.getObject() instanceof class_3965 && !(var9.contains((class_3965) var20.getObject().method_17777()))) {
                                }
                            } else {
                            }
                            var16.add();
                        }
                        var13 = (Iterable) var16;
                    }
                    var14 = 0;
                    var15 = var13.iterator();
                    if (var6 == null) {
                        if (!(var15.hasNext())) {
                        }
                        var16 = var15.next();
                        if (var6 == null) {
                        }
                        if (!(var15.hasNext())) {
                        }
                    }
                    var17 = (DamageDataServiceComponent) var16;
                    iterator2 = 0;
                    var17 = var17.getServiceComponent95().getNumericValue();
                    iterator2 = var15.next();
                    var19 = (DamageDataServiceComponent) iterator2;
                    var20 = 0;
                    var19 = var19.getServiceComponent95().getNumericValue();
                    if (Float.compare() < 0) {
                        var16 = iterator2;
                        var17 = var19;
                    }
                    var12 = (DamageDataServiceComponent) var16;
                    if (var6 == null) {
                        if (var12 != null) {
                            return var12;
                        }
                    }
                }
            }
        }
        return var7;
    }

    private static boolean checkCondition(float arg0, float arg1, EntitiesEntityHelper arg2) {
        if (var7 == null) {
            if (arg2.isActive2()) {
                float var8 = (arg2.getMinecraftObject().method_6032() + arg2.getMinecraftObject().method_6067());
                float var9 = (SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067());
                if (var7 == null) {
                    if ((arg0 * arg2.getNumericValue()) > var8) {
                    }
                } else {
                }
                int var10 = 0;
                if (var7 == null) {
                    if (arg1 < var9) {
                    }
                } else {
                }
                int var11 = 0;
                if (var7 == null) {
                }
                if (var7 == null) {
                }
                if (var7 == null) {
                    if (arg1 > arg2.getNumericValue3() && var10 && var11) {
                    }
                } else {
                }
                return false;
            }
        }
        return false;
    }

    private static boolean checkCondition(float arg0, EntitiesEntityHelper arg1) {
        float var17 = (arg1.getMinecraftObject().method_6032() + arg1.getMinecraftObject().method_6067());
        if (var16 == null) {
            if (arg0 >= 0.6D) {
                if (var16 == null) {
                    if (!(arg1.isActive13())) {
                    }
                }
                return false;
            }
        }
        if (var16 == null) {
        }
        if (var16 == null) {
            if (arg0 <= 4.0F) {
                if (var16 == null) {
                    if ((arg0 * arg1.getNumericValue()) > var17 && !(AuraModule.INSTANCE.checkCondition())) {
                    }
                }
            }
            return true;
        }
        Iterator iterator = EntityHelper2.resolveList(arg1.getMinecraftObject()).iterator();
        if (iterator.hasNext()) {
            ItemStack stack = (ItemStack) iterator.next();
            if (var16 == null) {
            }
            return true;
        }
        if (arg1.isActive11()) {
            if (var16 == null && var16 == null) {
                if (Intrinsics.areEqual(SharedKt.getWorld().getBlockState(BlockPos.ofFloored(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(arg1.getMinecraftObject()))).getBlock(), Blocks.field_10316)) {
                    return true;
                }
            }
        }
        if (arg1.isActive10()) {
            if (var16 == null && var16 == null) {
                if (AutoCrystalModule.INSTANCE.checkCondition()) {
                    return true;
                }
            }
        }
        if (arg1.isActive12()) {
            if (var16 == null && var16 == null) {
                if (arg1.getMinecraftObject().method_24518(Items.field_8102)) {
                    iterator = (Iterable) arg1.getList();
                    stack = 0;
                    Object var20 = iterator;
                    Collection var21 = (Collection) new ArrayList();
                    int var22 = 0;
                    Iterator iterator2 = var20.iterator();
                    if (iterator2.hasNext()) {
                        Object var24 = iterator2.next();
                        if (var16 == null) {
                            if (var16 == null) {
                            }
                            var21.add();
                        }
                        iterator = (Iterable) var21;
                        stack = 0;
                    }
                    if (iterator instanceof Collection) {
                        if (var16 == null && var16 == null) {
                            if ((Collection) iterator.isEmpty()) {
                            }
                        }
                    }
                    var20 = iterator.iterator();
                    if (var20.hasNext()) {
                        var21 = var20.next();
                        var22 = (class_1667) var21;
                        iterator2 = 0;
                        if (var16 == null) {
                        }
                        if (var16 == null) {
                        }
                        if (var16 == null) {
                            if (var22.field_6012 < 5 && AntiKnockBackModule.INSTANCE.resolveMinecraftObject().field_1351 > arg1.getMinecraftObject().getY() && arg1.getMinecraftObject().getEyePos().method_1025(AntiKnockBackModule.INSTANCE.resolveMinecraftObject()) < 9.0D) {
                            }
                        } else {
                        }
                    } else {
                    }
                    if (0) {
                        return true;
                    }
                }
            }
        }
        if (var16 == null) {
        }
        if (var16 == null) {
            if (var17 <= arg1.getNumericValue6() && !(AuraModule.INSTANCE.checkCondition())) {
            }
        } else {
        }
        return false;
    }

    public static ServiceComponent95 resolveServiceComponent95(AutoCrystalModule receiver, BlockPos pos, EntitiesEntityHelper configState, boolean ignoreMinDamage, boolean place, boolean basePlace) {
        Vec3d vec = pos.toCenterPos().method_1031(0.0D, 0.5D, 0.0D);
        if (place) {
        }
        List positions = CollectionsKt.emptyList();
        if (basePlace) {
        }
        Object var34 = positions;
        if (var31 == null) {
            if (place) {
            }
        } else {
        }
        float var35 = vec.computeValue(configState.getMinecraftObject(), receiver.computeValue(), 0, configState.isActive5(), basePlace);
        if (!(checkCondition(configState))) {
            if (var31 == null && var31 == null) {
                if (var35 > configState.getNumericValue4()) {
                }
            }
        } else {
        }
        int var36 = 0;
        if (0L > 0L && var31 == null) {
        }
        if (!(var36) && !(ignoreMinDamage)) {
            return null;
        }
        float var37 = DamageSyncServiceComponent.INSTANCE.computeValue(ExplosionPosEntityHelper.INSTANCE.computeValue(vec, (PlayerEntity) SharedKt.getPlayer(), receiver.computeValue(place), configState.isActive5(), basePlace));
        boolean var38 = checkCondition(configState);
        if (var31 == null) {
            if (configState.getAutoCrystalFriendProtectionMode() != AutoCrystalFriendProtectionMode.NONE) {
            }
            Iterable var40 = (Iterable) configState.getList();
            int var41 = 0;
            Object var42 = var40;
            Collection var43 = (Collection) new ArrayList();
            int var44 = 0;
            Iterator iterator = var42.iterator();
            if (iterator.hasNext()) {
                Object var46 = iterator.next();
                if (0L >= 0L) {
                    if (var31 == null) {
                        if (var31 == null) {
                        }
                        var43.add();
                    }
                    var40 = (Iterable) var43;
                    var41 = 0;
                    var42 = var40;
                    var43 = (Collection) new ArrayList();
                    if (0L > 0L) {
                    }
                    var44 = 0;
                }
            }
            iterator = var42.iterator();
            if (iterator.hasNext()) {
                var46 = iterator.next();
                PlayerEntity player = (PlayerEntity) var46;
                int var48 = 0;
                if (0L >= 0L) {
                    if (var31 == null) {
                        if (0L >= 0) {
                            if (var31 == null) {
                            }
                        }
                        if (var31 == null) {
                            if (player.isAlive() && EntityHelper4.isFriend(player)) {
                            }
                        } else {
                        }
                        var43.add();
                    }
                    Iterator iterator2 = var43.iterator();
                    if (iterator2.hasNext()) {
                        var40 = (PlayerEntity) iterator2.next();
                        if (var31 == null) {
                            if (place) {
                            }
                        } else {
                        }
                        var41 = vec.computeValue(receiver.computeValue(), 0, configState.isActive5(), basePlace);
                        if (0L >= 0) {
                            if (var31 == null) {
                                if (configState.getAutoCrystalFriendProtectionMode() == AutoCrystalFriendProtectionMode.ONLY_LETHAL) {
                                    if (var31 == null) {
                                        return null;
                                    }
                                    var37 = Math.max();
                                }
                            }
                        }
                    }
                }
            }
            if (0L >= 0) {
                if (var31 == null) {
                    if (!(checkCondition(configState))) {
                        return null;
                    }
                }
            }
            if (var31 == null) {
            }
            if (var37 > configState.getNumericValue3() && !(var38)) {
            }
            return null;
        }
        return new ServiceComponent95(var35 >= (configState.getMinecraftObject().method_6032() + configState.getMinecraftObject().method_6067()));
    }

    private static boolean checkCondition(float arg0, float arg1, boolean arg2, EntitiesEntityHelper arg3, char arg4) {
        if (var11 == null) {
            if (arg2) {
                return true;
            }
        }
        if (arg4 > 0) {
            if (var11 == null) {
                if (arg1 > (SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067())) {
                    return false;
                }
            }
        }
        if (var11 == null) {
            if ((arg0 / arg1) >= arg3.getNumericValue7()) {
            }
        } else {
        }
        return false;
    }

}
