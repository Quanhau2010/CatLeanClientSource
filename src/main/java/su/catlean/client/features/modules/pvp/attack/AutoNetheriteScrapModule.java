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
        return ((KeyRecord) placeWithRegionSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private KeyRecord getPlaceNormal() {
        return ((KeyRecord) placeNormalSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getPrivateOthers() {
        return ((Boolean) privateOthersSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getCheckRange() {
        return ((Boolean) checkRangeSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void onInputEvent(InputEvent arg0) {
        if (arg0.getKey() != this.getPlaceWithRegion().getNumericValue()) {
        }
        if (arg0.getKey() != this.getPlaceNormal().getNumericValue() || arg0.getAction() != Action.Press || SharedKt.getMc().currentScreen != null) {
            return;
        }
        if (!(serviceComponent10.checkCondition(50000))) {
            MessageServiceComponent.S(this, MessageServiceComponent.Z(this, "delay", new Object[0], false), false);
            return;
        }
        if (this.getCheckRange() && EntityPacketHelper.findTarget(1.5F, AutoCrystalTargetSortMode.DISTANCE, false, false) == null) {
            MessageServiceComponent.S(this, MessageServiceComponent.Z(this, "distance", new Object[0], false), false);
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
        int index = this.computeValue();
        if (index == -1) {
            return;
        }
        RotationServiceComponent4 rotationServiceComponent4 = VecPacketHelper.resolveRotationServiceComponent4(blockPos, index, BlockPlacementInteractMode.Strict, BlockPlacementPlaceMode.Normal, OptionMode15.NONE, 4.0F, 0.0F, 200, BlockPlacementSwitchMode.Alternative, null, false);
        if (rotationServiceComponent4 != null) {
            SequenceServiceComponent.INSTANCE.executeAction(rotationServiceComponent4);
            serviceComponent102.executeAction();
            enabledFlag = 0;
        } else {
        }
    }

    private int computeValue() {
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(itemList);
        if (stackServiceComponent2.isActive()) {
            return stackServiceComponent2.getNumericValue();
        }
        return -1;
    }

    private boolean checkCondition() {
        BlockPos blockPos = BlockPos.ofFloored(SharedKt.getPlayer().getEyePos()).up();
        int index = -5;
        if (index < 6) {
            if (__UNDEF_KEY__ != null) {
                int index2 = -5;
                if (index2 < 6) {
                    int index3 = -5;
                    if (index3 < 6) {
                        if (__UNDEF_KEY__ != null) {
                            if (itemList.contains(SharedKt.getWorld().getBlockState(blockPos.method_10069(index, index2, index3)).getBlock())) {
                                return true;
                            }
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
        RunnableServiceComponent2.executeAction(10, 0, false, this::executeAction);
    }

    private void executeAction(long arg0) {
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition);
        if (stackServiceComponent2.isActive()) {
            ItemPacketHelper.INSTANCE.executeAction(stackServiceComponent2.getNumericValue());
            HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            ItemPacketHelper.INSTANCE.updateValue2();
            serviceComponent10.executeAction();
            return;
        }
        StackServiceComponent2 stackServiceComponent22 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition2);
        if (arg0 > 0L) {
            GuiMoveModule.INSTANCE.updateValue(true);
            HandServiceComponent.e(stackServiceComponent22.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, false);
            HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            HandServiceComponent.e(stackServiceComponent22.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, false);
            GuiMoveModule.INSTANCE.updateValue(false);
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
        KProperty[] items = new KProperty[4];
        INSTANCE = new AutoNetheriteScrapModule();
        placeWithRegionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "place-with-region", new KeyRecord(0, false, false));
        placeNormalSetting = VisibleRenderHelper.registerSetting(INSTANCE, "place-normal", new KeyRecord(0, false, false));
        privateOthersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "private-others", true);
        checkRangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "check-range", false);
        serviceComponent10 = new ServiceComponent10();
        serviceComponent102 = new ServiceComponent10();
        items = new Block[5];
        items[0] = Blocks.field_10381;
        items[1] = Blocks.field_10442;
        items[2] = Blocks.field_10201;
        items[3] = Blocks.field_10013;
        items[4] = Blocks.NETHERITE_BLOCK;
        itemList = CollectionsKt.listOf(items);
    }

}
