package su.catlean.client.services.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1308;
import net.minecraft.class_1429;
import net.minecraft.class_1451;
import net.minecraft.class_1493;
import net.minecraft.class_1531;
import net.minecraft.class_1560;
import net.minecraft.class_1588;
import net.minecraft.class_1590;
import net.minecraft.class_1646;
import net.minecraft.class_1674;
import net.minecraft.class_1676;
import net.minecraft.class_1678;
import net.minecraft.class_3532;
import net.minecraft.class_745;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.rage.ElytraTargetModule;
import su.catlean.client.features.modules.movement.rage.MaceElytraTargetModule;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.AuraRotationMode;
import su.catlean.client.features.modules.pvp.attack.AuraSortMode;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.types.mappings.AuraSortModeWhenMappings;
import su.catlean.interfaces.Resolvable;

public class ActionEntityHelper {

    public static final ActionEntityHelper INSTANCE;
    private static final Set itemSet;

    private ActionEntityHelper() {
    }

    public Set getSet() {
        return itemSet;
    }

    public Entity resolveMinecraftObject(Entity currentTraget) {
        Entity entity = this.resolveMinecraftObject();
        if (currentTraget != null) {
            if (AuraModule.INSTANCE.getSort() != AuraSortMode.FOV) {
                if (var14 && var14) {
                    if (0L > 0) {
                        if (!(entity instanceof class_1676)) {
                            if (this.checkCondition(currentTraget)) {
                            }
                        }
                    }
                }
            }
            return entity;
        }
        return currentTraget;
    }

    private Entity resolveMinecraftObject() {
        List positions = new ArrayList();
        Iterator iterator = SharedKt.getWorld().method_18112().iterator();
        if (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (!(var20)) {
                if (!(var20)) {
                    if (!(entity instanceof class_1678)) {
                        if (entity instanceof class_1674) {
                        }
                    }
                    if ((class_1676) entity.isAlive()) {
                        if (this.checkCondition2(entity)) {
                            if (!(var20) && !(var20) && !(var20) && !(var20)) {
                                if (AuraModule.INSTANCE.getProjectiles()) {
                                    return entity;
                                }
                            }
                        }
                    }
                }
                if (!(var20)) {
                }
                if (!(var20)) {
                }
                positions.add(entity);
            }
        }
        Iterable var24 = (Iterable) positions;
        int var25 = 0;
        Iterator iterator2 = var24.iterator();
        if (!(var20)) {
            if (!(iterator2.hasNext())) {
            }
        }
        Object var27 = iterator2.next();
        if (!(var20)) {
            if (!(iterator2.hasNext())) {
            }
        }
        LivingEntity entity2 = (LivingEntity) var27;
        int var30 = 0;
        entity2 = SharedKt.getPlayer().method_5707(EntityHelper.resolveMinecraftObject(entity2));
        var30 = iterator2.next();
        LivingEntity entity3 = (LivingEntity) var30;
        int var33 = 0;
        entity3 = SharedKt.getPlayer().method_5707(EntityHelper.resolveMinecraftObject(entity3));
        if (Double.compare(entity2, entity3) > 0) {
            var27 = var30;
            entity2 = entity3;
        }
        var24 = (Iterable) positions;
        var25 = 0;
        iterator2 = var24.iterator();
        if (!(var20)) {
            if (!(iterator2.hasNext())) {
            }
        }
        var27 = iterator2.next();
        if (!(var20)) {
            if (!(iterator2.hasNext())) {
            }
        }
        entity2 = (LivingEntity) var27;
        var30 = 0;
        entity2 = INSTANCE.computeValue(entity2);
        var30 = iterator2.next();
        entity3 = (LivingEntity) var30;
        var33 = 0;
        entity3 = INSTANCE.computeValue(entity3);
        if (Float.compare(entity2, entity3) > 0) {
            var27 = var30;
            entity2 = entity3;
        }
        var24 = (Iterable) positions;
        var25 = 0;
        iterator2 = var24.iterator();
        if (!(var20)) {
            if (!(iterator2.hasNext())) {
            }
        }
        var27 = iterator2.next();
        if (!(var20)) {
            if (!(iterator2.hasNext())) {
            }
        }
        entity2 = (LivingEntity) var27;
        var30 = 0;
        entity2 = (entity2.method_6032() + entity2.method_6067());
        var30 = iterator2.next();
        entity3 = (LivingEntity) var30;
        var33 = 0;
        entity3 = (entity3.method_6032() + entity3.method_6067());
        if (Float.compare(entity2, entity3) > 0) {
            var27 = var30;
            entity2 = entity3;
        }
        return new NoWhenBranchMatchedException();
    }

    private boolean checkCondition(Entity arg0, long arg1, byte arg2) {
        if (!(var34)) {
            if (this.checkCondition(arg0)) {
                return false;
            }
        }
        if (arg1 >= 0L) {
            if (!(var34)) {
                if (!(arg0 instanceof LivingEntity)) {
                    return true;
                }
            }
        }
        if (!(var34)) {
            if (!((LivingEntity) arg0.method_29504())) {
                if (arg2 >= 0) {
                    if (!(var34)) {
                        if (!((LivingEntity) arg0.isAlive())) {
                        }
                    }
                    return true;
                }
            }
        }
        if (arg2 > 0) {
            if (!(var34)) {
                if (arg0 instanceof class_1531) {
                    return true;
                }
            }
        }
        if (arg2 >= 0) {
            if (!(var34)) {
                if (arg0 instanceof class_1451) {
                    return true;
                }
            }
        }
        if (!(var34)) {
            if (arg0.field_6012 < 0) {
            }
            return true;
        }
        if (!(var34)) {
            if (AuraModule.INSTANCE.getFov() == 1) {
            }
        }
        if (arg1 > 0L) {
            if (!(var34)) {
                if (!(EntityHelper.resolveMinecraftObject(arg0).checkCondition(180, AuraModule.INSTANCE.getFov()))) {
                    return true;
                }
            }
        }
        if (arg2 >= 0) {
            if (!(var34)) {
                if (this.checkCondition(arg0)) {
                    return true;
                }
            }
        }
        if (arg0 instanceof PlayerEntity) {
            if (!(var34)) {
                if (!(Intrinsics.areEqual(arg0, SharedKt.getPlayer()))) {
                    if (arg2 > 0) {
                        if (!(var34)) {
                            if (EntityHelper4.isFriend((PlayerEntity) arg0)) {
                            }
                        }
                        return true;
                    }
                }
            }
            if (!(var34)) {
                if ((PlayerEntity) arg0.method_68878()) {
                    if (arg2 > 0) {
                        if (!(var34)) {
                            if (AuraModule.INSTANCE.getIgnoreCreative()) {
                                return true;
                            }
                        }
                    }
                }
            }
            if (!(var34)) {
                if (!((PlayerEntity) arg0.method_6096())) {
                    if (arg1 > 0L) {
                        if (!(var34)) {
                            if (AuraModule.INSTANCE.getIgnoreNaked()) {
                                return true;
                            }
                        }
                    }
                }
            }
            if (!(var34)) {
                if ((PlayerEntity) arg0.method_5767()) {
                    if (arg2 > 0) {
                        if (!(var34)) {
                            if (AuraModule.INSTANCE.getIgnoreInvisible()) {
                                return true;
                            }
                        }
                    }
                }
            }
            if (arg2 > 0) {
            }
            if ((PlayerEntity) arg0.method_22861() == SharedKt.getPlayer().method_22861()) {
                if (AuraModule.INSTANCE.getIgnoreTeam()) {
                    if (arg2 >= 0) {
                        if (!(var34) && !(var34) && !(var34) && !(var34)) {
                            if (SharedKt.getPlayer().method_22861() != 16777215) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        if (this.checkCondition2(arg0)) {
            if (arg1 >= 0L) {
                if (!(var34)) {
                    if (arg0.method_16914()) {
                    }
                }
                if (!(var34) && !(var34)) {
                    if (AuraModule.INSTANCE.getIgnoreNamed()) {
                    }
                }
            }
        } else {
        }
        }
        return false;
    }

    private boolean checkCondition(Entity arg0) {
        if (!(arg0 instanceof class_1678)) {
            if (!(var13) && !(var13)) {
            }
        }
        if (!(var13)) {
        }
        if (!(var13)) {
        }
        if (!(var13)) {
            if (arg0 instanceof class_1674 && (class_1676) arg0.isAlive() && EventPacketHelper2.INSTANCE.computeValue(EntityHelper.resolveMinecraftObject(arg0)) < this.computeValue() && AuraModule.INSTANCE.getProjectiles()) {
            }
        } else {
        }
        return false;
    }

    private boolean checkCondition(Entity arg0) {
        if (arg0 instanceof class_1588) {
            if (!(var23) && !(var23)) {
                if (!(AuraModule.INSTANCE.getHostiles())) {
                    return true;
                }
            }
        }
        if (AuraModule.INSTANCE.getOnlyAngry()) {
            if (!(var23)) {
                if (arg0 instanceof class_1560) {
                    if (!(var23)) {
                        if (!((class_1560) arg0.method_7028())) {
                            return true;
                        }
                    }
                }
            }
            if (!(var23)) {
                if (arg0 instanceof class_1590) {
                    if (!(var23)) {
                        if (!((class_1590) arg0.method_6510())) {
                            return true;
                        }
                    }
                }
            }
            if (arg0 instanceof class_1493) {
                if (!(var23) && !(var23) && !(var23)) {
                    if (!((class_1493) arg0.method_6510())) {
                        return true;
                    }
                }
            }
        }
        if (arg0 instanceof PlayerEntity) {
            if (!(var23) && !(var23)) {
                if (!(AuraModule.INSTANCE.getPlayers())) {
                    return true;
                }
            }
        }
        if (arg0 instanceof PlayerEntity) {
            if (AuraModule.INSTANCE.getAntibot()) {
                if (!(var23) && !(var23) && !(var23)) {
                    if (this.checkCondition((PlayerEntity) arg0)) {
                        return true;
                    }
                }
            }
        }
        if (arg0 instanceof class_1646) {
            if (!(var23) && !(var23)) {
                if (!(AuraModule.INSTANCE.getVillagers())) {
                    return true;
                }
            }
        }
        if (arg0 instanceof class_1308) {
            if (!(var23) && !(var23)) {
                if (!(AuraModule.INSTANCE.getMobs())) {
                    return true;
                }
            }
        }
        if (!(var23)) {
        }
        if (!(var23)) {
            if (arg0 instanceof class_1429 && !(AuraModule.INSTANCE.getAnimals())) {
            }
        } else {
        }
        return false;
    }

    private boolean checkCondition2(Entity arg0) {
        if (var13) {
            if (EventPacketHelper2.INSTANCE.computeValue(AuraModule.INSTANCE.getRotationMode().getZEROEntityHelper().resolveMinecraftObject(arg0)) <= this.computeValue()) {
            }
        } else {
        }
        return false;
    }

    private float computeValue(LivingEntity arg0) {
        return Math.abs((class_3532.method_15338((Math.toDegrees(Math.atan2((arg0.getZ() - SharedKt.getPlayer().getZ()), (arg0.getX() - SharedKt.getPlayer().getX()))) - 90.0D)) - class_3532.method_15393(SharedKt.getPlayer().method_36454())));
    }

    private float computeValue() {
        float var12 = (AuraModule.INSTANCE.getAttackRange() + 2.0F);
        if (!(var11)) {
            if (!(SharedKt.getPlayer().isFallFlying())) {
            }
            if (!(var11)) {
                if (MaceElytraTargetModule.INSTANCE.getEnabled()) {
                }
                var12 = (var12 + 64.0F);
            }
            if (!(var11)) {
            }
            if (!(AuraModule.INSTANCE.resolveAuraRotationMode().getZEROEntityHelper().isActive2())) {
            }
            var12 = AuraModule.INSTANCE.getAttackRange();
        }
        return var12;
    }

    public void executeAction(Function0 action) {
        Iterable var12 = (Iterable) SharedKt.getWorld().getPlayers();
        int var13 = 0;
        Object var14 = var12;
        Collection var15 = (Collection) new ArrayList();
        int var16 = 0;
        Iterator iterator = var14.iterator();
        if (iterator.hasNext()) {
            Object var18 = iterator.next();
            if (var10) {
            }
            var15.add();
        }
        List positions = var15;
        var12 = (Iterable) positions;
        var13 = 0;
        var14 = var12.iterator();
        if (var14.hasNext()) {
            var15 = var14.next();
            var16 = (class_745) var15;
            iterator = 0;
            INSTANCE.executeAction((PlayerEntity) var16);
            if (var10) {
            }
            action.invoke();
            var12 = (Iterable) positions;
            var13 = 0;
        }
        var14 = var12.iterator();
        if (var14.hasNext()) {
            var15 = var14.next();
            var16 = (class_745) var15;
            iterator = 0;
            INSTANCE.executeAction2((PlayerEntity) var16);
        }
    }

    private void executeAction(PlayerEntity arg0) {
        if (var14) {
            if (!(this.checkCondition(arg0))) {
                (Resolvable) arg0.savePosition(Vec3d.ZERO);
                ElytraTargetModule.INSTANCE.executeAction(arg0.method_5829());
                return;
            }
            (Resolvable) arg0.savePosition(EntityHelper.resolveMinecraftObject(arg0));
        }
        if (!(Intrinsics.areEqual(AuraModule.INSTANCE.getTarget(), arg0)) || var14) {
            return;
        }
        if (var14) {
            if (var14) {
            }
        }
        float var15 = ElytraTargetModule.INSTANCE.computeValue();
        double var16 = (arg0.getX() + ((arg0.getX() - arg0.field_6014) * var15));
        double var18 = (arg0.getY() + ((arg0.getY() - arg0.field_6036) * var15));
        double var20 = (arg0.getZ() + ((arg0.getZ() - arg0.field_5969) * var15));
        arg0.method_5814();
        ElytraTargetModule.INSTANCE.executeAction(new Box((var16 - 0.3D), (var18 + 0.0D), (var20 - 0.3D), (var16 + 0.3D), (var18 + 0.6D), (var20 + 0.3D)));
    }

    private void executeAction2(PlayerEntity arg0) {
        if (var4) {
            arg0.method_33574((Resolvable) arg0.getSavedPosition());
        }
        (Resolvable) arg0.savePosition(Vec3d.ZERO);
    }

    private boolean checkCondition(PlayerEntity arg0) {
        if (var8) {
            if (Intrinsics.areEqual(arg0, SharedKt.getPlayer())) {
                return false;
            }
        }
        List positions = CollectionsKt.toList((Iterable) EntityHelper2.resolveList(arg0));
        Iterable var11 = (Iterable) positions;
        int var12 = 0;
        if (var11 instanceof Collection) {
            if (var8 && var8) {
                if ((Collection) var11.isEmpty()) {
                }
            }
        }
        Iterator iterator = var11.iterator();
        if (iterator.hasNext()) {
            Object var14 = iterator.next();
            ItemStack stack = (ItemStack) var14;
            int var16 = 0;
            if (var8) {
            }
            if (var8) {
                if (!(Intrinsics.areEqual(stack.getItem(), Items.field_8162)) && !(stack.method_7986())) {
                }
            } else {
            }
        } else {
        }
        int var10 = 1;
        var12 = (Iterable) positions;
        iterator = 0;
        if (var12 instanceof Collection) {
            if (var8 && var8) {
                if ((Collection) var12.isEmpty()) {
                }
            }
        }
        var14 = var12.iterator();
        if (var14.hasNext()) {
            stack = var14.next();
            var16 = (ItemStack) stack;
            int var17 = 0;
        } else {
        }
        var11 = 1;
        var12 = Intrinsics.areEqual(arg0.method_6079().getItem(), Items.field_8162);
        var14 = (Iterable) positions;
        stack = 0;
        if (var14 instanceof Collection) {
            if (var8 && var8) {
                if ((Collection) var14.isEmpty()) {
                }
            }
        }
        var16 = var14.iterator();
        if (var16.hasNext()) {
            var17 = var16.next();
            ItemStack stack2 = (ItemStack) var17;
            int var19 = 0;
        } else {
        }
        iterator = 0;
        if (var8) {
            if (!(Intrinsics.areEqual(arg0.method_6047().getItem(), Items.field_8162))) {
            }
        } else {
        }
        var14 = 0;
        if (var8) {
        }
        if (var8) {
        }
        if (var8) {
        }
        if (var8) {
        }
        if (var8) {
            if (var10 && var11 && var12 && iterator && var14) {
            }
        } else {
        }
        return false;
    }

    public boolean checkCondition(PlayerEntity player) {
        if (!(var4)) {
            if (player.getX() == player.field_6014) {
            }
        } else {
        }
        if (!(var4)) {
            if (player.getY() == player.field_6036) {
            }
        } else {
        }
        if (0 && 0) {
            if (!(var4)) {
                if (player.getZ() == player.field_5969) {
                }
            } else {
            }
            if (!(0)) {
            }
        }
        if (0 != null) {
            if (var4) {
            }
        }
        return false;
    }

    static {
        INSTANCE = new ActionEntityHelper();
        Item[] var22 = new Item[8];
        var22[0] = Items.field_8370;
        var22[1] = Items.field_8570;
        var22[2] = Items.LEATHER_CHESTPLATE;
        var22[3] = Items.field_8267;
        var22[4] = Items.field_8660;
        var22[5] = Items.field_8396;
        var22[6] = Items.IRON_CHESTPLATE;
        var22[7] = Items.field_8743;
        itemSet = SetsKt.setOf();
    }

}
