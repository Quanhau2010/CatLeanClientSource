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
                if (__UNDEF_KEY__ && __UNDEF_KEY__) {
                    if (__UNDEF_KEY__ > 0) {
                        if (!(entity instanceof class_1676)) {
                            if (this.checkCondition(currentTraget)) {
                                return entity;
                            }
                        }
                    }
                }
            }
        }
        return currentTraget;
    }

    private Entity resolveMinecraftObject() {
        List list = new ArrayList();
        Iterator iterator = SharedKt.getWorld().method_18112().iterator();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (!(__UNDEF_KEY__)) {
                if (!(__UNDEF_KEY__)) {
                    if (!(entity instanceof class_1678)) {
                        if (entity instanceof class_1674) {
                            if (((class_1676) entity).isAlive()) {
                                if (this.checkCondition2(entity)) {
                                    if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__) && !(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                                        if (AuraModule.INSTANCE.getProjectiles()) {
                                            return entity;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (!(__UNDEF_KEY__)) {
                }
                if (!(__UNDEF_KEY__)) {
                }
                list.add(entity);
            }
        }
        Iterable iterable = ((Iterable) list);
        Iterator iterator2 = iterable.iterator();
        if (!(__UNDEF_KEY__)) {
            if (!(iterator2.hasNext())) {
            }
        }
        Object element = iterator2.next();
        if (!(__UNDEF_KEY__)) {
            if (!(iterator2.hasNext())) {
            }
        }
        LivingEntity entity2 = ((LivingEntity) element);
        int index = 0;
        entity2 = SharedKt.getPlayer().method_5707(EntityHelper.resolveMinecraftObject(entity2));
        index = iterator2.next();
        LivingEntity entity3 = ((LivingEntity) index);
        entity3 = SharedKt.getPlayer().method_5707(EntityHelper.resolveMinecraftObject(entity3));
        if (Double.compare(entity2, entity3) > 0) {
            element = index;
            entity2 = entity3;
        }
        iterable = ((Iterable) list);
        iterator2 = iterable.iterator();
        if (!(__UNDEF_KEY__)) {
            if (!(iterator2.hasNext())) {
            }
        }
        element = iterator2.next();
        if (!(__UNDEF_KEY__)) {
            if (!(iterator2.hasNext())) {
            }
        }
        entity2 = ((LivingEntity) element);
        index = 0;
        entity2 = INSTANCE.computeValue(entity2);
        index = iterator2.next();
        entity3 = ((LivingEntity) index);
        entity3 = INSTANCE.computeValue(entity3);
        if (Float.compare(entity2, entity3) > 0) {
            element = index;
            entity2 = entity3;
        }
        iterable = ((Iterable) list);
        iterator2 = iterable.iterator();
        if (!(__UNDEF_KEY__)) {
            if (!(iterator2.hasNext())) {
            }
        }
        element = iterator2.next();
        if (!(__UNDEF_KEY__)) {
            if (!(iterator2.hasNext())) {
            }
        }
        entity2 = ((LivingEntity) element);
        index = 0;
        entity2 = (entity2.method_6032() + entity2.method_6067());
        index = iterator2.next();
        entity3 = ((LivingEntity) index);
        entity3 = (entity3.method_6032() + entity3.method_6067());
        if (Float.compare(entity2, entity3) > 0) {
            element = index;
            entity2 = entity3;
        }
        return new NoWhenBranchMatchedException();
    }

    private boolean checkCondition(Entity arg0, long arg1, byte arg2) {
        if (this.checkCondition(arg0)) {
            return false;
        }
        if (arg1 >= 0L && !(__UNDEF_KEY__)) {
            if (!(arg0 instanceof LivingEntity)) {
                return true;
            }
        }
        if (!(((LivingEntity) arg0).method_29504())) {
            if (arg2 >= 0) {
                if (!(__UNDEF_KEY__)) {
                    if (!(((LivingEntity) arg0).isAlive())) {
                        return true;
                    }
                }
            }
        }
        if (arg2 > 0) {
            if (!(__UNDEF_KEY__)) {
                if (arg0 instanceof class_1531) {
                    return true;
                }
            }
        }
        if (arg2 >= 0 && !(__UNDEF_KEY__)) {
            if (arg0 instanceof class_1451) {
                return true;
            }
        }
        if (arg0.field_6012 < 0) {
            return true;
        }
        if (AuraModule.INSTANCE.getFov() == 1) {
        }
        if (arg1 > 0L) {
            if (!(__UNDEF_KEY__)) {
                if (!(EntityHelper.resolveMinecraftObject(arg0).checkCondition(180, AuraModule.INSTANCE.getFov()))) {
                    return true;
                }
            }
        }
        if (arg2 >= 0 && !(__UNDEF_KEY__)) {
            if (this.checkCondition(arg0)) {
                return true;
            }
        }
        if (!(Intrinsics.areEqual(arg0, SharedKt.getPlayer()))) {
            if (arg2 > 0) {
                if (!(__UNDEF_KEY__)) {
                    if (EntityHelper4.isFriend(((PlayerEntity) arg0))) {
                        return true;
                    }
                }
            }
        }
        if (((PlayerEntity) arg0).method_68878()) {
            if (arg2 > 0) {
                if (!(__UNDEF_KEY__)) {
                    if (AuraModule.INSTANCE.getIgnoreCreative()) {
                        return true;
                    }
                }
            }
        }
        if (!(((PlayerEntity) arg0).method_6096())) {
            if (arg1 > 0L) {
                if (!(__UNDEF_KEY__)) {
                    if (AuraModule.INSTANCE.getIgnoreNaked()) {
                        return true;
                    }
                }
            }
        }
        if (((PlayerEntity) arg0).method_5767()) {
            if (arg2 > 0) {
                if (!(__UNDEF_KEY__)) {
                    if (AuraModule.INSTANCE.getIgnoreInvisible()) {
                        return true;
                    }
                }
            }
        }
        if (arg2 > 0) {
            if (!(__UNDEF_KEY__)) {
                if (arg2 >= 0) {
                    if (!(__UNDEF_KEY__)) {
                        if (arg0 instanceof PlayerEntity && ((PlayerEntity) arg0).method_22861() == SharedKt.getPlayer().method_22861() && AuraModule.INSTANCE.getIgnoreTeam() && SharedKt.getPlayer().method_22861() != 16777215) {
                            return true;
                        }
                    }
                }
            }
        }
        if (this.checkCondition2(arg0)) {
            if (arg1 >= 0L && !(__UNDEF_KEY__)) {
            }
            if (arg0.method_16914() && AuraModule.INSTANCE.getIgnoreNamed()) {
            } else {
            }
        }
        return false;
    }

    private boolean checkCondition(Entity arg0) {
        if (!(arg0 instanceof class_1678)) {
        }
        if (arg0 instanceof class_1674 && ((class_1676) arg0).isAlive() && EventPacketHelper2.INSTANCE.computeValue(EntityHelper.resolveMinecraftObject(arg0)) < this.computeValue() && AuraModule.INSTANCE.getProjectiles()) {
        } else {
        }
        return false;
    }

    private boolean checkCondition(Entity arg0) {
        if (arg0 instanceof class_1588 && !(AuraModule.INSTANCE.getHostiles())) {
            return true;
        }
        if (arg0 instanceof class_1560) {
            if (!(((class_1560) arg0).method_7028())) {
                return true;
            }
        }
        if (arg0 instanceof class_1590) {
            if (!(((class_1590) arg0).method_6510())) {
                return true;
            }
        }
        if (AuraModule.INSTANCE.getOnlyAngry() && arg0 instanceof class_1493 && !(((class_1493) arg0).method_6510())) {
            return true;
        }
        if (arg0 instanceof PlayerEntity && !(AuraModule.INSTANCE.getPlayers())) {
            return true;
        }
        if (arg0 instanceof PlayerEntity && AuraModule.INSTANCE.getAntibot() && this.checkCondition(((PlayerEntity) arg0))) {
            return true;
        }
        if (arg0 instanceof class_1646 && !(AuraModule.INSTANCE.getVillagers())) {
            return true;
        }
        if (arg0 instanceof class_1308 && !(AuraModule.INSTANCE.getMobs())) {
            return true;
        }
        if (arg0 instanceof class_1429 && !(AuraModule.INSTANCE.getAnimals())) {
        } else {
        }
        return false;
    }

    private boolean checkCondition2(Entity arg0) {
        return false;
    }

    private float computeValue(LivingEntity arg0) {
        return Math.abs((class_3532.method_15338((Math.toDegrees(Math.atan2((arg0.getZ() - SharedKt.getPlayer().getZ()), (arg0.getX() - SharedKt.getPlayer().getX()))) - 90.0D)) - class_3532.method_15393(SharedKt.getPlayer().method_36454())));
    }

    private float computeValue() {
        float factor = (AuraModule.INSTANCE.getAttackRange() + 2.0F);
        if (!(__UNDEF_KEY__)) {
            if (!(SharedKt.getPlayer().isFallFlying())) {
                if (!(__UNDEF_KEY__)) {
                    if (MaceElytraTargetModule.INSTANCE.getEnabled()) {
                        factor = (factor + 64.0F);
                    }
                    if (!(__UNDEF_KEY__)) {
                        if (!(AuraModule.INSTANCE.resolveAuraRotationMode().getZEROEntityHelper().isActive2())) {
                            factor = AuraModule.INSTANCE.getAttackRange();
                        }
                    }
                }
            }
        }
        return factor;
    }

    public void executeAction(Function0 action) {
        Iterable iterable = ((Iterable) SharedKt.getWorld().getPlayers());
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (__UNDEF_KEY__) {
            }
            collection.add(element);
        }
        iterable = ((Iterable) collection);
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index = ((class_745) collection);
            iterator = 0;
            INSTANCE.executeAction(((PlayerEntity) index));
            if (__UNDEF_KEY__) {
                action.invoke();
                iterable = ((Iterable) collection);
            }
        }
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index = ((class_745) collection);
            iterator = 0;
            INSTANCE.executeAction2(((PlayerEntity) index));
        }
    }

    private void executeAction(PlayerEntity arg0) {
        if (!(this.checkCondition(arg0))) {
            ((Resolvable) arg0).savePosition(Vec3d.ZERO);
            ElytraTargetModule.INSTANCE.executeAction(arg0.method_5829());
            return;
        }
        ((Resolvable) arg0).savePosition(EntityHelper.resolveMinecraftObject(arg0));
        float factor = ElytraTargetModule.INSTANCE.computeValue();
        double offset = (arg0.getX() + ((arg0.getX() - arg0.field_6014) * factor));
        double offset2 = (arg0.getY() + ((arg0.getY() - arg0.field_6036) * factor));
        double offset3 = (arg0.getZ() + ((arg0.getZ() - arg0.field_5969) * factor));
        arg0.method_5814(offset, offset2, offset3);
        ElytraTargetModule.INSTANCE.executeAction(new Box((offset - 0.3D), (offset2 + 0.0D), (offset3 - 0.3D), (offset + 0.3D), (offset2 + 0.6D), (offset3 + 0.3D)));
    }

    private void executeAction2(PlayerEntity arg0) {
        if (__UNDEF_KEY__) {
            arg0.method_33574(((Resolvable) arg0).getSavedPosition());
        }
        ((Resolvable) arg0).savePosition(Vec3d.ZERO);
    }

    private boolean checkCondition(PlayerEntity arg0) {
        if (Intrinsics.areEqual(arg0, SharedKt.getPlayer())) {
            return false;
        }
        List list = CollectionsKt.toList(((Iterable) EntityHelper2.resolveList(arg0)));
        Iterable iterable = ((Iterable) list);
        int index = 0;
        if (iterable instanceof Collection && ((Collection) iterable).isEmpty()) {
        }
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ItemStack stack = ((ItemStack) element);
            int index2 = 0;
            if (!(Intrinsics.areEqual(stack.getItem(), Items.field_8162))) {
            } else {
            }
        }
        int index3 = 1;
        index = ((Iterable) list);
        iterator = 0;
        if (index instanceof Collection && ((Collection) index).isEmpty()) {
        }
        element = index.iterator();
        while (element.hasNext()) {
            stack = element.next();
            index2 = ((ItemStack) stack);
            int index4 = 0;
        }
        iterable = 1;
        index = Intrinsics.areEqual(arg0.method_6079().getItem(), Items.field_8162);
        element = ((Iterable) list);
        stack = 0;
        if (element instanceof Collection && ((Collection) element).isEmpty()) {
        }
        index2 = element.iterator();
        while (index2.hasNext()) {
            index4 = index2.next();
            ItemStack stack2 = ((ItemStack) index4);
        }
        iterator = 0;
        element = 0;
        return false;
    }

    public boolean checkCondition(PlayerEntity player) {
        if (!(__UNDEF_KEY__)) {
            if (player.getX() == player.field_6014) {
            } else {
            }
        }
        if (!(__UNDEF_KEY__)) {
            if (player.getY() == player.field_6036) {
            } else {
            }
        }
        if (0 && 0) {
            if (!(__UNDEF_KEY__)) {
                if (player.getZ() == player.field_5969) {
                } else {
                }
            }
            if (!(0)) {
            }
        }
        if (0 != null) {
            if (__UNDEF_KEY__) {
            }
        }
        return false;
    }

    static {
        INSTANCE = new ActionEntityHelper();
        Item[] items = new Item[8];
        items[0] = Items.field_8370;
        items[1] = Items.field_8570;
        items[2] = Items.LEATHER_CHESTPLATE;
        items[3] = Items.field_8267;
        items[4] = Items.field_8660;
        items[5] = Items.field_8396;
        items[6] = Items.IRON_CHESTPLATE;
        items[7] = Items.field_8743;
        itemSet = SetsKt.setOf(items);
    }

}
