package su.catlean.client.features.modules.utility.misc;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_1708;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1739;
import net.minecraft.class_1842;
import net.minecraft.class_1844;
import net.minecraft.class_1847;
import net.minecraft.class_2371;
import net.minecraft.class_2586;
import net.minecraft.class_2589;
import net.minecraft.class_3965;
import net.minecraft.class_6880;
import net.minecraft.class_9334;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AutoPotionBrewModule extends Module {

    public static final AutoPotionBrewModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final VisibleVisibleSettingPropertyImpl addGunpowderSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 afterCompleteSetting;
    private static final VisibleVisibleSettingPropertyImpl openSetting;
    private static final ServiceComponent10 serviceComponent10;
    private static final Map lookupMap;
    private static BlockPos blockPos;

    private AutoPotionBrewModule() {
        super("auto-potion-brew", SubCategoriesKt.getMiscUtilityCategory());
    }

    private AutoPotionBrewMode getMode() {
        return ((AutoPotionBrewMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private int getDelay() {
        return ((Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getAddGunpowder() {
        return ((Boolean) addGunpowderSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private AutoPotionBrewAfterCompleteMode getAfterComplete() {
        return ((AutoPotionBrewAfterCompleteMode) afterCompleteSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getOpen() {
        return ((Boolean) openSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getPlayer().field_7512 instanceof class_1708) {
            class_1708 class1708 = ((class_1708) SharedKt.getPlayer().field_7512);
            if (this.checkCondition2()) {
                int index = 4;
                Item item = Items.field_8183;
                this.executeAction(item, index);
                return;
            }
            int index2 = 0;
            if (this.computeValue(Items.field_8183) == -1 || index2 < 3) {
                return;
            }
            if (this.checkCondition(((class_1842) class_1847.field_8991.comp_349())) && this.computeValue(Items.field_8790) != -1 && !(Intrinsics.areEqual(((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(3)).method_7677().getItem(), Items.field_8790))) {
                index = 3;
                item = Items.field_8790;
                this.executeAction(item, index);
                return;
            }
            if (this.checkCondition(((class_1842) class_1847.field_8999.comp_349())) && this.computeValue(this.getMode().getMinecraftObject()) != -1 && !(Intrinsics.areEqual(((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(3)).method_7677().getItem(), this.getMode().getMinecraftObject()))) {
                this.executeAction(this.getMode().getMinecraftObject(), 3);
                return;
            }
            if (this.checkCondition(((class_1842) class_1847.field_8968.comp_349())) && !(Intrinsics.areEqual(this.getMode().getMinecraftObject2(), Items.field_8162)) && this.computeValue(this.getMode().getMinecraftObject2()) != -1 && !(Intrinsics.areEqual(((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(3)).method_7677().getItem(), this.getMode().getMinecraftObject2()))) {
                this.executeAction(this.getMode().getMinecraftObject2(), 3);
                return;
            }
            if (!(this.checkCondition(((class_1842) class_1847.field_8978.comp_349()))) && !(this.checkCondition(((class_1842) class_1847.field_9005.comp_349()))) && !(this.checkCondition(((class_1842) class_1847.field_9005.comp_349())))) {
                if (this.checkCondition(((class_1842) class_1847.field_8997.comp_349()))) {
                } else {
                }
            }
            index2 = 0;
            int index3 = 1;
            if (index2 && !(Intrinsics.areEqual(((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(3)).method_7677().getItem(), this.getMode().getMinecraftObject3()))) {
                if (this.computeValue(this.getMode().getMinecraftObject3()) != -1) {
                    this.executeAction(this.getMode().getMinecraftObject3(), 3);
                    return;
                }
                index3 = 0;
            }
            if (!(this.checkCondition(((class_1842) class_1847.field_8993.comp_349()))) && !(this.checkCondition(((class_1842) class_1847.field_8966.comp_349()))) && !(this.checkCondition(((class_1842) class_1847.field_8969.comp_349())))) {
                if (this.checkCondition(((class_1842) class_1847.field_9000.comp_349()))) {
                } else {
                }
            }
            int index4 = 0;
            if (index2 && !(index3)) {
                index4 = 1;
            }
            if (this.getAddGunpowder()) {
                if (this.computeValue(Items.field_8054) != -1) {
                    if (!(this.checkCondition())) {
                        if (index4 && !(Intrinsics.areEqual(((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(3)).method_7677().getItem(), Items.field_8054))) {
                            index = 3;
                            item = Items.field_8054;
                            this.executeAction(item, index);
                            return;
                            this.updateValue();
                            return;
                        }
                    }
                }
            }
            SharedKt.getPlayer().method_7346();
            lookupMap.put(blockPos, Integer.valueOf((SharedKt.getPlayer().field_6012 + class1708.method_17378())));
        } else {
            class1708 = TheNetherPacketHelper.INSTANCE.getList().iterator();
            while (class1708.hasNext()) {
                index2 = ((class_2586) class1708.next());
                if (lookupMap.get(((class_2589) index2).method_11016()) != null) {
                }
                index3 = new class_3965(Direction.UP, ((class_2589) index2).method_11016(), false);
                SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(index3.method_17784()), 0, this::resolveUnit));
            }
        }
    }

    private void updateValue() {
        int index = 0;
        if (this.getAfterComplete() == AutoPotionBrewAfterCompleteMode.TAKE) {
            HandServiceComponent.e(index, 0, class_1713.field_7794, false);
        } else {
            if (serviceComponent10.checkCondition(this.getDelay()) && this.getAfterComplete() == AutoPotionBrewAfterCompleteMode.THROW) {
                HandServiceComponent.e(index, 0, class_1713.field_7795, false);
            }
        }
    }

    private boolean checkCondition() {
        int index = 0;
        if (index < 3) {
            if (!(Intrinsics.areEqual(((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(index)).method_7677().getItem(), Items.field_8436))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCondition(class_1842 arg0) {
        int index = 0;
        if (index < 3) {
            ItemStack stack = ((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(index)).method_7677();
            class_1844 class1844 = ((class_1844) stack.method_58694(class_9334.field_49651));
            if (class1844 != null && class1844.comp_2378().isPresent()) {
                class_1842 class1842 = ((class_1842) ((class_6880) class1844.comp_2378().get()).comp_349());
                if (!(Intrinsics.areEqual(class1842, arg0))) {
                    return false;
                    return false;
                }
            }
        }
        return true;
    }

    private int computeValue(class_1842 arg0) {
        int index = 5;
        if (index < 41) {
            ItemStack stack = ((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(index)).method_7677();
            if (this.comp_2378().isPresent()) {
                class_1842 class1842 = ((class_1842) ((class_6880) this.comp_2378().get()).comp_349());
                if (Intrinsics.areEqual(class1842, arg0)) {
                    return index;
                }
            }
        }
        return -1;
    }

    private void executeAction(Item arg0, int arg1) {
        int index = this.computeValue(arg0);
        HandServiceComponent.e(index, 0, null, false);
        HandServiceComponent.e(arg1, 1, null, false);
        int index2 = 14;
        int index3 = 0;
        int index4 = 0;
        HandServiceComponent.e(index, index4, index3, index2);
        serviceComponent10.executeAction();
    }

    private boolean checkCondition2() {
        return ((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(4)).method_7677().getItem() instanceof class_1739;
    }

    private int computeValue(Item arg0) {
        int index = 5;
        if (index < 41) {
            if (Intrinsics.areEqual(((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(index)).method_7677().getItem(), arg0)) {
                return index;
            }
        }
        return -1;
    }

    private static Unit resolveUnit(class_3965 arg0, class_2586 arg1) {
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, arg0);
        blockPos = ((class_2589) arg1).method_11016();
        return Unit.INSTANCE;
    }

    static {
        KProperty[] items = new KProperty[5];
        INSTANCE = new AutoPotionBrewModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "potion", AutoPotionBrewMode.STRENGTH);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 100, new IntRange(0, 1000));
        addGunpowderSetting = VisibleRenderHelper.registerSetting(INSTANCE, "throwable", true);
        afterCompleteSetting = VisibleRenderHelper.registerSetting(INSTANCE, "after-complete", AutoPotionBrewAfterCompleteMode.TAKE);
        openSetting = VisibleRenderHelper.registerSetting(INSTANCE, "open", true);
        serviceComponent10 = new ServiceComponent10();
        lookupMap = ((Map) new LinkedHashMap());
    }

}
