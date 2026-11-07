package su.catlean.client.features.modules.utility.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.class_1542;
import net.minecraft.class_1893;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.services.client.DamageDataServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent102;
import su.catlean.client.services.client.ServiceComponent95;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.StackServiceComponent3;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.player.EntityHelper2;
import su.catlean.client.services.player.PlayerEntityHelper2;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode14;

public class AutoMendModule extends Module {

    public static final AutoMendModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl minDurabilitySetting;
    private static final RangeVisibleSettingPropertyImpl maxDurabilitySetting;
    private static final VisibleVisibleSettingPropertyImpl overrideOnLootSetting;
    private static final RangeVisibleSettingPropertyImpl xpFactorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 pauseGroupSetting;
    private static final VisibleVisibleSettingPropertyImpl ifMoveSetting;
    private static final VisibleVisibleSettingPropertyImpl ifMiningSetting;
    private static final VisibleVisibleSettingPropertyImpl ifEatingSetting;
    private static final VisibleVisibleSettingPropertyImpl ifNotInHoleSetting;
    private static final ServiceComponent10 serviceComponent10;
    private static boolean enabledFlag;

    private AutoMendModule() {
        super("auto-mend", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private int getMinDurability() {
        return (Number) minDurabilitySetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private int getMaxDurability() {
        return (Number) maxDurabilitySetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getOverrideOnLoot() {
        return (Boolean) overrideOnLootSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private int getXpFactor() {
        return (Number) xpFactorSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private SettingGroup getPauseGroup() {
        return (SettingGroup) pauseGroupSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getIfMove() {
        return (Boolean) ifMoveSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getIfMining() {
        return (Boolean) ifMiningSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getIfEating() {
        return (Boolean) ifEatingSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private boolean getIfNotInHole() {
        return (Boolean) ifNotInHoleSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    public ServiceComponent10 getServiceComponent10() {
        return serviceComponent10;
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public void updateValue2() {
        enabledFlag = 0;
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Item[] var62 = new Item[1];
        var62[0] = Items.field_8287;
        StackServiceComponent2 var61 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        if (this.getIfMining() && !((Collection) SpeedMineModule.INSTANCE.getLinkedList().isEmpty())) {
        }
        if (SharedKt.getInteractionManager().method_2923() || SpeedMineModule.INSTANCE.getResetOnSwitch() || !(serviceComponent10.checkCondition(500))) {
            return;
        }
        if (this.getIfMove() && EventPacketHelper2.INSTANCE.checkCondition()) {
            return;
        }
        if (this.getIfEating() && SharedKt.getPlayer().method_6115()) {
            return;
        }
        if (this.getIfNotInHole() && !(ServiceComponent102.INSTANCE.checkCondition(BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()))))) {
            return;
        }
        if (AutoCrystalModule.INSTANCE.getEnabled() && AutoCrystalModule.INSTANCE.getTarget() != null && AutoCrystalModule.INSTANCE.getAtomicReference().get() != null && (DamageDataServiceComponent) AutoCrystalModule.INSTANCE.getAtomicReference().get().getServiceComponent95().getNumericValue() > 4.0F) {
            enabledFlag = 0;
            return;
        }
        Iterable var63 = SharedKt.getWorld().method_18112();
        int var64 = 0;
        Object var65 = var63;
        Collection var66 = (Collection) new ArrayList();
        int var67 = 0;
        Iterator iterator = var65.iterator();
        while (iterator.hasNext()) {
            Object var69 = iterator.next();
            var66.add();
        }
        var63 = (Iterable) var66;
        var64 = 0;
        if (var63 instanceof Collection && (Collection) var63.isEmpty()) {
        } else {
            var65 = var63.iterator();
            if (var65.hasNext()) {
                var66 = var65.next();
                var67 = (class_1542) var66;
                iterator = 0;
            } else {
            }
        }
        var62 = 0;
        if (var62) {
            if (this.getOverrideOnLoot()) {
            }
        } else {
        }
        }
        var63 = this.getMaxDurability();
        if (var62) {
            if (this.getOverrideOnLoot()) {
            }
        } else {
        }
        }
        var64 = this.getMinDurability();
        var66 = (Iterable) EntityHelper2.resolveList(SharedKt.getPlayer());
        var67 = 0;
        iterator = var66;
        var69 = (Collection) new ArrayList();
        int var70 = 0;
        Iterator iterator2 = iterator.iterator();
        while (iterator2.hasNext()) {
            Object var72 = iterator2.next();
            ItemStack stack = (ItemStack) var72;
            int var74 = 0;
            var69.add();
        }
        var65 = var69;
        if (!(enabledFlag)) {
            iterator = (Iterable) var65.iterator();
            if (!(iterator.hasNext())) {
            } else {
                var69 = (ItemStack) iterator.next();
                var70 = 0;
                var69 = INSTANCE.computeValue();
                while (iterator.hasNext()) {
                    var70 = (ItemStack) iterator.next();
                    iterator2 = 0;
                    var70 = INSTANCE.computeValue();
                    var69 = Math.min();
                }
            }
            if (Float.valueOf() != null) {
            } else {
                Float.valueOf();
            }
            if (100.0F < var64) {
                enabledFlag = 1;
            }
        }
        if (enabledFlag) {
            iterator = (Iterable) var65.iterator();
            if (!(iterator.hasNext())) {
            } else {
                var69 = (ItemStack) iterator.next();
                var70 = 0;
                var69 = INSTANCE.computeValue();
                while (iterator.hasNext()) {
                    var70 = (ItemStack) iterator.next();
                    iterator2 = 0;
                    var70 = INSTANCE.computeValue();
                    var69 = Math.min();
                }
            }
            if (Float.valueOf() != null) {
            } else {
                Float.valueOf();
            }
            if (100.0F >= var63) {
                enabledFlag = 0;
            }
        }
        if (!(SharedKt.getPlayer().isFallFlying())) {
            if (SharedKt.getWorld().getBlockState(BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer())).down()).method_45474()) {
                if (!(SharedKt.getWorld().getBlockState(BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer())).method_10087(2)).method_45474())) {
                }
                if (!(var61.isActive())) {
                }
            }
            enabledFlag = 0;
        }
        var66 = PlayerEntityHelper2.INSTANCE.predictPosition((PlayerEntity) SharedKt.getPlayer(), Math.ceil((TheNetherPacketHelper.f() / 50.0F)));
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(), 150, this::resolveUnit));
    }

    private float computeValue(ItemStack arg0) {
        if (!(arg0.isEmpty())) {
            if (!(arg0.method_7936())) {
            }
            return 100.0F;
        }
        return (((arg0.method_7936() - arg0.method_7919()) / arg0.method_7936()) * 100.0F);
    }

    private static Unit resolveUnit(StackServiceComponent2 arg0) {
        ItemPacketHelper.INSTANCE.executeAction(arg0.getNumericValue(), INSTANCE.getXpFactor());
        return Unit.INSTANCE;
    }

    static {
        KProperty[] var33 = new KProperty[9];
        INSTANCE = new AutoMendModule();
        minDurabilitySetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-durability", 30, new IntRange(0, 100));
        maxDurabilitySetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-durability", 90, new IntRange(0, 100));
        overrideOnLootSetting = VisibleRenderHelper.registerSetting(INSTANCE, "override-on-loot");
        xpFactorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "xp-factor", 1, new IntRange(1, 16));
        pauseGroupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause", OptionMode14.BOOLS);
        ifMoveSetting = VisibleRenderHelper.registerSetting(INSTANCE, "if-move", 1, INSTANCE.getPauseGroup());
        ifMiningSetting = VisibleRenderHelper.registerSetting(INSTANCE, "if-mining", 0, INSTANCE.getPauseGroup());
        ifEatingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "if-eating", 0, INSTANCE.getPauseGroup());
        ifNotInHoleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "if-not-in-hole", 0, INSTANCE.getPauseGroup());
        serviceComponent10 = new ServiceComponent10();
    }

}
