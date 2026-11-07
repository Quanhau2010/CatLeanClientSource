package su.catlean.client.features.modules.render.world;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_239;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.BlockPlacementInteractMode;
import su.catlean.client.features.modules.BlockPlacementPlaceMode;
import su.catlean.client.features.modules.BlockPlacementRenderAnimationMode;
import su.catlean.client.features.modules.BlockPlacementRenderMode;
import su.catlean.client.features.modules.BlockPlacementSwitchMode;
import su.catlean.client.features.modules.BlockPlacementTimingMode;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent64;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.MatrixStackRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.OptionMode15;

public class AutoWitherModule extends Module {

    public static final AutoWitherModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 timingSetting;
    private static final RangeVisibleSettingPropertyImpl blocksPerActionSetting;
    private static final RangeVisibleSettingPropertyImpl delayPerActionSetting;
    private static final VisibleVisibleSettingPropertyImpl rotateSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 placeModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 interactSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 switchSetting;
    private static final RangeVisibleSettingPropertyImpl2 rangeSetting;
    private static final RangeVisibleSettingPropertyImpl2 wallRangeSetting;
    private static final VisibleVisibleSettingPropertyImpl renderSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 poseSetting;
    private static final List itemList;
    private static int countValue;
    private static ServiceComponent10 serviceComponent10;

    private AutoWitherModule() {
        super("auto-wither", SubCategoriesKt.getWorldRenderCategory());
    }

    private BlockPlacementTimingMode getTiming() {
        return ((BlockPlacementTimingMode) timingSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setTiming(BlockPlacementTimingMode value) {
        timingSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private int getBlocksPerAction() {
        return ((Number) blocksPerActionSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setBlocksPerAction(int value) {
        blocksPerActionSetting.setValue(this, DELEGATED_PROPERTIES[1], Integer.valueOf(value));
    }

    private int getDelayPerAction() {
        return ((Number) delayPerActionSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setDelayPerAction(int value) {
        delayPerActionSetting.setValue(this, DELEGATED_PROPERTIES[2], Integer.valueOf(value));
    }

    private boolean getRotate() {
        return ((Boolean) rotateSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setRotate(boolean value) {
        rotateSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private BlockPlacementPlaceMode getPlaceMode() {
        return ((BlockPlacementPlaceMode) placeModeSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void setPlaceMode(BlockPlacementPlaceMode value) {
        placeModeSetting.setValue(this, DELEGATED_PROPERTIES[4], value);
    }

    private BlockPlacementInteractMode getInteract() {
        return ((BlockPlacementInteractMode) interactSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private void setInteract(BlockPlacementInteractMode value) {
        interactSetting.setValue(this, DELEGATED_PROPERTIES[5], value);
    }

    private BlockPlacementSwitchMode getSwitch() {
        return ((BlockPlacementSwitchMode) switchSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private void setSwitch(BlockPlacementSwitchMode value) {
        switchSetting.setValue(this, DELEGATED_PROPERTIES[6], value);
    }

    private float getRange() {
        return ((Number) rangeSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private void setRange(float value) {
        rangeSetting.setValue(this, DELEGATED_PROPERTIES[7], Float.valueOf(value));
    }

    private float getWallRange() {
        return ((Number) wallRangeSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private void setWallRange(float value) {
        wallRangeSetting.setValue(this, DELEGATED_PROPERTIES[8], Float.valueOf(value));
    }

    private boolean getRender() {
        return ((Boolean) renderSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private void setRender(boolean value) {
        renderSetting.setValue(this, DELEGATED_PROPERTIES[9], Boolean.valueOf(value));
    }

    private AutoWitherPoseMode getPose() {
        return ((AutoWitherPoseMode) poseSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private void setPose(AutoWitherPoseMode value) {
        poseSetting.setValue(this, DELEGATED_PROPERTIES[10], value);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getMc().options.field_1904.method_1434() && serviceComponent10.checkCondition2(250) && Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8067)) {
            itemList.clear();
            if (SharedKt.getMc().field_1765 == null) {
                return;
            }
            if (this.method_17783() != class_240.field_1332 || !(__UNDEF_KEY__ instanceof class_3965)) {
                return;
            }
            this.executeAction(this.method_17777().offset(this.method_17780()));
        }
        if (countValue > 0) {
            int index = countValue;
            countValue = (index + -1);
            return;
        }
        if (itemList.isEmpty()) {
            return;
        }
        index = 0;
        index = this.getBlocksPerAction();
        Iterator iterator = itemList.iterator();
        while (iterator.hasNext()) {
            Pair pair = ((Pair) iterator.next());
            if (index <= 0) {
            } else {
                if (((Boolean) pair.getSecond())) {
                } else {
                }
                Item item = Items.field_8791;
                0[Items.field_8067] = item;
                int index2 = this.resolveStackServiceComponent2().getNumericValue();
                if (index2 == -1) {
                }
                INSTANCE.executeAction(((BlockPos) pair.getFirst()));
                iterator.remove();
                if (INSTANCE.getTiming() == BlockPlacementTimingMode.Instant) {
                    index = (index + -1);
                    countValue = INSTANCE.getDelayPerAction();
                } else {
                }
            }
        }
    }

    private void executeAction(BlockPos arg0) {
        boolean flag = this.getPose() == AutoWitherPoseMode.STANDING;
        if (flag) {
            itemList.add(TuplesKt.to(arg0.up(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.up().method_10072(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.up().method_10095(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.up().up(), Boolean.valueOf(false)));
            itemList.add(TuplesKt.to(arg0.up().up().method_10072(), Boolean.valueOf(false)));
        } else {
            itemList.add(TuplesKt.to(arg0.method_10067(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.method_10067().method_10072(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.method_10067().method_10095(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.method_10067().method_10067().method_10072(), Boolean.valueOf(false)));
            itemList.add(TuplesKt.to(arg0.method_10067().method_10067().method_10095(), Boolean.valueOf(false)));
        }
        itemList.add(TuplesKt.to(arg0.method_10067().method_10067(), Boolean.valueOf(false)));
        if (flag) {
            itemList.add(TuplesKt.to(arg0.up(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.up().method_10078(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.up().method_10067(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.up().up(), Boolean.valueOf(false)));
            itemList.add(TuplesKt.to(arg0.up().up().method_10078(), Boolean.valueOf(false)));
        } else {
            itemList.add(TuplesKt.to(arg0.method_10072(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.method_10072().method_10078(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.method_10072().method_10067(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.method_10072().method_10072().method_10078(), Boolean.valueOf(false)));
            itemList.add(TuplesKt.to(arg0.method_10072().method_10072().method_10067(), Boolean.valueOf(false)));
        }
        itemList.add(TuplesKt.to(arg0.method_10072().method_10072(), Boolean.valueOf(false)));
        if (flag) {
            itemList.add(TuplesKt.to(arg0.up(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.up().method_10067(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.up().method_10078(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.up().up(), Boolean.valueOf(false)));
            itemList.add(TuplesKt.to(arg0.up().up().method_10067(), Boolean.valueOf(false)));
        } else {
            itemList.add(TuplesKt.to(arg0.method_10095(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.method_10095().method_10078(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.method_10095().method_10067(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.method_10095().method_10095().method_10078(), Boolean.valueOf(false)));
            itemList.add(TuplesKt.to(arg0.method_10095().method_10095().method_10067(), Boolean.valueOf(false)));
        }
        itemList.add(TuplesKt.to(arg0.method_10095().method_10095(), Boolean.valueOf(false)));
        if (flag) {
            itemList.add(TuplesKt.to(arg0.up(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.up().method_10095(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.up().method_10072(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.up().up(), Boolean.valueOf(false)));
            itemList.add(TuplesKt.to(arg0.up().up().method_10095(), Boolean.valueOf(false)));
        } else {
            itemList.add(TuplesKt.to(arg0.method_10078(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.method_10078().method_10072(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.method_10078().method_10095(), Boolean.valueOf(true)));
            itemList.add(TuplesKt.to(arg0.method_10078().method_10078().method_10072(), Boolean.valueOf(false)));
            itemList.add(TuplesKt.to(arg0.method_10078().method_10078().method_10095(), Boolean.valueOf(false)));
        }
        itemList.add(TuplesKt.to(arg0.method_10078().method_10078(), Boolean.valueOf(false)));
    }

    private void executeAction(BlockPos arg0, RotationServiceComponent4 arg1) {
        if (!(__UNDEF_KEY__)) {
            if (INSTANCE.getRotate()) {
                if (INSTANCE.getTiming() == BlockPlacementTimingMode.Instant) {
                    SequenceServiceComponent.INSTANCE.executeAction(arg1);
                }
                SequenceServiceComponent.INSTANCE.executeAction(arg1);
                if (__UNDEF_KEY__ && __UNDEF_KEY__) {
                    arg1.getFunction0().invoke();
                    arg1.executeAction(this::getUnit);
                }
            }
        }
        if (INSTANCE.getRender()) {
            MatrixStackRenderHelper.INSTANCE.executeAction(arg0, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 1.0F), BlockPlacementRenderAnimationMode.Fade, BlockPlacementRenderMode.BOTH);
        }
    }

    private static boolean isActive() {
        return INSTANCE.getTiming() == BlockPlacementTimingMode.Instant;
    }

    private static boolean isActive2() {
        return INSTANCE.getTiming() == BlockPlacementTimingMode.Instant;
    }

    private static Unit getUnit() {
        return Unit.INSTANCE;
    }

    static {
        KProperty[] items = new KProperty[11];
        INSTANCE = new AutoWitherModule();
        timingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timing", BlockPlacementTimingMode.Vanilla);
        blocksPerActionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blocks-per-action", 6, new IntRange(2, 6), null, this::isActive);
        delayPerActionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay-per-action", 0, new IntRange(0, 10), null, this::isActive2);
        rotateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotate", true);
        placeModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "place-mode", BlockPlacementPlaceMode.Normal);
        interactSetting = VisibleRenderHelper.registerSetting(INSTANCE, "interact", BlockPlacementInteractMode.Strict);
        switchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", BlockPlacementSwitchMode.Silent);
        rangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range", 4.0F, RangesKt.rangeTo(2.0F, 10.0F));
        wallRangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "wall-range", 4.0F, RangesKt.rangeTo(2.0F, 10.0F));
        renderSetting = VisibleRenderHelper.registerSetting(INSTANCE, "render", true);
        poseSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pose", AutoWitherPoseMode.LYING);
        itemList = new ArrayList();
        serviceComponent10 = new ServiceComponent10();
    }

}
