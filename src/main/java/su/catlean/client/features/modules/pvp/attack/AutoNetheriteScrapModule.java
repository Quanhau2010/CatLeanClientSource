package su.catlean.client.features.modules.pvp.attack;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.BlockPlacementInteractMode;
import su.catlean.client.features.modules.BlockPlacementPlaceMode;
import su.catlean.client.features.modules.BlockPlacementSwitchMode;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.RunnableServiceComponent2;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EntityPacketHelper;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode15;

public class AutoNetheriteScrapModule extends Module {

    public static final AutoNetheriteScrapModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl2 placeWithRegionSetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 placeNormalSetting;
    private static final VisibleVisibleSettingPropertyImpl privateOthersSetting;
    private static final VisibleVisibleSettingPropertyImpl checkRangeSetting;
    private static ServiceComponent10 serviceComponent10;
    private static ServiceComponent10 serviceComponent102;
    private static boolean enabledFlag;
    private static List itemList;

    private AutoNetheriteScrapModule() {
        super("auto-netherite-scrap", SubCategoriesKt.getAttackCategory());
    }

    private KeyRecord getPlaceWithRegion() {
        return (KeyRecord) placeWithRegionSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private KeyRecord getPlaceNormal() {
        return (KeyRecord) placeNormalSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getPrivateOthers() {
        return (Boolean) privateOthersSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getCheckRange() {
        return (Boolean) checkRangeSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void onInputEvent(InputEvent arg0) {
        if (arg0.getKey() != this.getPlaceWithRegion().getNumericValue()) {
        }
        if (arg0.getKey() != this.getPlaceNormal().getNumericValue() || arg0.getAction() != Action.Press || SharedKt.getMc().currentScreen != null) {
            return;
        }
        if (!(serviceComponent10.checkCondition(50000))) {
            MessageServiceComponent.S(this, MessageServiceComponent.Z(this, "delay", new Object[0]));
            return;
        }
        if (this.getCheckRange() && EntityPacketHelper.findTarget(1.5F, AutoCrystalTargetSortMode.DISTANCE) == null) {
            MessageServiceComponent.S(this, MessageServiceComponent.Z(this, "distance", new Object[0]));
            return;
        }
        if (arg0.getKey() == this.getPlaceWithRegion().getNumericValue()) {
            this.updateValue();
        }
        this.executeAction();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (!(enabledFlag)) {
        }
        BlockPos blockPos = BlockPos.ofFloored(SharedKt.getPlayer().getEyePos()).up();
        int var23 = this.computeValue();
        if (var23 == -1) {
            return;
        }
        RotationServiceComponent4 var24 = VecPacketHelper.resolveRotationServiceComponent4(blockPos, BlockPlacementInteractMode.Strict, BlockPlacementPlaceMode.Normal, OptionMode15.NONE, 4.0F, 0.0F, 200, BlockPlacementSwitchMode.Alternative);
        if (var24 != null) {
            Object var25 = var24;
            int var26 = 0;
            SequenceServiceComponent.INSTANCE.executeAction();
            serviceComponent102.executeAction();
            enabledFlag = 0;
        } else {
        }
    }

    private int computeValue() {
        StackServiceComponent2 var7 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(itemList);
        if (var7.isActive()) {
            return var7.getNumericValue();
        }
        return -1;
    }

    private boolean checkCondition() {
        BlockPos blockPos = BlockPos.ofFloored(SharedKt.getPlayer().getEyePos()).up();
        int var9 = -5;
        if (var9 < 6) {
            if (var7 != null) {
                int var10 = -5;
                if (var10 < 6) {
                    int var11 = -5;
                    if (var11 < 6) {
                        if (var7 != null) {
                            if (itemList.contains(SharedKt.getWorld().getBlockState(blockPos.method_10069()).getBlock())) {
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void updateValue() {
        this.executeAction();
        enabledFlag = 1;
        RunnableServiceComponent2.executeAction(10, 0, 0, this::executeAction);
    }

    private void executeAction(long arg0) {
        StackServiceComponent2 var22 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition);
        if (var22.isActive()) {
            ItemPacketHelper.INSTANCE.executeAction(var22.getNumericValue());
            HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            ItemPacketHelper.INSTANCE.updateValue2();
            serviceComponent10.executeAction();
            return;
        }
        StackServiceComponent2 var23 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition2);
        if (arg0 > 0L) {
            GuiMoveModule.INSTANCE.updateValue(1);
            HandServiceComponent.e(var23.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791);
            HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            HandServiceComponent.e(var23.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791);
            GuiMoveModule.INSTANCE.updateValue(0);
        }
        serviceComponent10.executeAction();
    }

    private static void executeAction() {
        enabledFlag = 0;
    }

    private static boolean checkCondition(ItemStack arg0) {
        return Intrinsics.areEqual(arg0.getItem(), Items.field_22021);
    }

    private static boolean checkCondition2(ItemStack arg0) {
        return Intrinsics.areEqual(arg0.getItem(), Items.field_22021);
    }

    static {
        KProperty[] var32 = new KProperty[4];
        INSTANCE = new AutoNetheriteScrapModule();
        placeWithRegionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "place-with-region", new KeyRecord());
        placeNormalSetting = VisibleRenderHelper.registerSetting(INSTANCE, "place-normal", new KeyRecord());
        privateOthersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "private-others");
        checkRangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "check-range");
        serviceComponent10 = new ServiceComponent10();
        serviceComponent102 = new ServiceComponent10();
        var32 = new Block[5];
        var32[0] = Blocks.field_10381;
        var32[1] = Blocks.field_10442;
        var32[2] = Blocks.field_10201;
        var32[3] = Blocks.field_10013;
        var32[4] = Blocks.NETHERITE_BLOCK;
        itemList = CollectionsKt.listOf();
    }

}
