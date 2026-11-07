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
        return (AutoPotionBrewMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private int getDelay() {
        return (Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getAddGunpowder() {
        return (Boolean) addGunpowderSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private AutoPotionBrewAfterCompleteMode getAfterComplete() {
        return (AutoPotionBrewAfterCompleteMode) afterCompleteSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getOpen() {
        return (Boolean) openSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getPlayer().field_7512 instanceof class_1708) {
            class_1708 var47 = (class_1708) SharedKt.getPlayer().field_7512;
            if (this.checkCondition2()) {
                int var41 = 4;
                Item var42 = Items.field_8183;
                this.executeAction();
                return;
            }
            int var48 = 0;
            if (this.computeValue(Items.field_8183) == -1 || var48 < 3) {
                return;
            }
            if (this.checkCondition((class_1842) class_1847.field_8991.comp_349()) && this.computeValue(Items.field_8790) != -1 && !(Intrinsics.areEqual((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(3).method_7677().getItem(), Items.field_8790))) {
                var41 = 3;
                var42 = Items.field_8790;
                this.executeAction();
                return;
            }
            if (this.checkCondition((class_1842) class_1847.field_8999.comp_349()) && this.computeValue(this.getMode().getMinecraftObject()) != -1 && !(Intrinsics.areEqual((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(3).method_7677().getItem(), this.getMode().getMinecraftObject()))) {
                this.executeAction(this.getMode().getMinecraftObject(), 3);
                return;
            }
            if (this.checkCondition((class_1842) class_1847.field_8968.comp_349()) && !(Intrinsics.areEqual(this.getMode().getMinecraftObject2(), Items.field_8162)) && this.computeValue(this.getMode().getMinecraftObject2()) != -1 && !(Intrinsics.areEqual((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(3).method_7677().getItem(), this.getMode().getMinecraftObject2()))) {
                this.executeAction(this.getMode().getMinecraftObject2(), 3);
                return;
            }
            if (!(this.checkCondition((class_1842) class_1847.field_8978.comp_349())) && !(this.checkCondition((class_1842) class_1847.field_9005.comp_349())) && !(this.checkCondition((class_1842) class_1847.field_9005.comp_349()))) {
                if (this.checkCondition((class_1842) class_1847.field_8997.comp_349())) {
                }
            } else {
            }
            var48 = 0;
            int var49 = 1;
            if (var48 && !(Intrinsics.areEqual((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(3).method_7677().getItem(), this.getMode().getMinecraftObject3()))) {
                if (this.computeValue(this.getMode().getMinecraftObject3()) != -1) {
                    this.executeAction(this.getMode().getMinecraftObject3(), 3);
                    return;
                }
                var49 = 0;
            }
            if (!(this.checkCondition((class_1842) class_1847.field_8993.comp_349())) && !(this.checkCondition((class_1842) class_1847.field_8966.comp_349())) && !(this.checkCondition((class_1842) class_1847.field_8969.comp_349()))) {
                if (this.checkCondition((class_1842) class_1847.field_9000.comp_349())) {
                }
            } else {
            }
            int var50 = 0;
            if (var48 && !(var49)) {
                var50 = 1;
            }
            if (this.getAddGunpowder()) {
                if (this.computeValue(Items.field_8054) != -1) {
                    if (!(this.checkCondition())) {
                        if (var50 && !(Intrinsics.areEqual((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(3).method_7677().getItem(), Items.field_8054))) {
                            var41 = 3;
                            var42 = Items.field_8054;
                            this.executeAction();
                            return;
                        }
                    }
                }
                this.updateValue();
                return;
            }
            SharedKt.getPlayer().method_7346();
            lookupMap.put(blockPos, Integer.valueOf((SharedKt.getPlayer().field_6012 + var47.method_17378())));
        } else {
            var47 = TheNetherPacketHelper.INSTANCE.getList().iterator();
            while (var47.hasNext()) {
                var48 = (class_2586) var47.next();
                if (lookupMap.get((class_2589) var48.method_11016()) != null) {
                }
                var49 = new class_3965(new Vec3d(((class_2589) var48.method_11016().method_10263() + 0.5F), ((class_2589) var48.method_11016().method_10264() + 0.125D), ((class_2589) var48.method_11016().method_10260() + 0.5F)), Direction.UP, (class_2589) var48.method_11016(), 0);
                SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(var49.method_17784()), 0, this::resolveUnit));
            }
        }
    }

    private void updateValue() {
        int var13 = 0;
        if (this.getAfterComplete() == AutoPotionBrewAfterCompleteMode.TAKE) {
            HandServiceComponent.e(0, class_1713.field_7794);
        } else {
            if (serviceComponent10.checkCondition(this.getDelay()) && this.getAfterComplete() == AutoPotionBrewAfterCompleteMode.THROW) {
                HandServiceComponent.e(0, class_1713.field_7795);
            }
        }
    }

    private boolean checkCondition() {
        int var6 = 0;
        if (var6 < 3) {
            if (var5) {
                if (var5) {
                    if (!(Intrinsics.areEqual((class_1735) SharedKt.getPlayer().field_7512.field_7761.get().method_7677().getItem(), Items.field_8436))) {
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkCondition(class_1842 arg0) {
        int var7 = 0;
        if (var7 < 3) {
            ItemStack stack = (class_1735) SharedKt.getPlayer().field_7512.field_7761.get().method_7677();
            class_1844 var9 = (class_1844) stack.method_58694(class_9334.field_49651);
            if (var9 != null && var9.comp_2378().isPresent()) {
                class_1842 var10 = (class_1842) (class_6880) var9.comp_2378().get().comp_349();
                if (!(Intrinsics.areEqual(arg0))) {
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    private int computeValue(class_1842 arg0) {
        int var7 = 5;
        if (var7 < 41) {
            ItemStack stack = (class_1735) SharedKt.getPlayer().field_7512.field_7761.get().method_7677();
            if (var9.comp_2378().isPresent()) {
                class_1842 var10 = (class_1842) (class_6880) var9.comp_2378().get().comp_349();
                if (Intrinsics.areEqual(arg0)) {
                    return var7;
                }
            }
        }
        return -1;
    }

    private void executeAction(Item arg0, int arg1) {
        int var23 = this.computeValue(arg0);
        HandServiceComponent.e();
        HandServiceComponent.e(arg1);
        int var18 = 14;
        int var19 = 0;
        int var21 = 0;
        HandServiceComponent.e();
        serviceComponent10.executeAction();
    }

    private boolean checkCondition2() {
        return (class_1735) SharedKt.getPlayer().field_7512.field_7761.get(4).method_7677().getItem() instanceof class_1739;
    }

    private int computeValue(Item arg0) {
        int var7 = 5;
        if (var7 < 41) {
            if (!(var6)) {
                if (!(var6)) {
                    if (Intrinsics.areEqual((class_1735) SharedKt.getPlayer().field_7512.field_7761.get().method_7677().getItem(), arg0)) {
                    }
                    return var7;
                }
            }
        }
        return -1;
    }

    private static Unit resolveUnit(class_3965 arg0, class_2586 arg1) {
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, arg0);
        blockPos = (class_2589) arg1.method_11016();
        return Unit.INSTANCE;
    }

    static {
        KProperty[] var30 = new KProperty[5];
        INSTANCE = new AutoPotionBrewModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "potion", AutoPotionBrewMode.STRENGTH);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 100, new IntRange(0, 1000));
        addGunpowderSetting = VisibleRenderHelper.registerSetting(INSTANCE, "throwable");
        afterCompleteSetting = VisibleRenderHelper.registerSetting(INSTANCE, "after-complete", AutoPotionBrewAfterCompleteMode.TAKE);
        openSetting = VisibleRenderHelper.registerSetting(INSTANCE, "open");
        serviceComponent10 = new ServiceComponent10();
        lookupMap = (Map) new LinkedHashMap();
    }

}
