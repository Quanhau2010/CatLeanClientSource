package su.catlean.client.features.modules.pvp.attack;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_2533;
import net.minecraft.class_2760;
import net.minecraft.class_2769;
import net.minecraft.class_2885;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.BlockPlacementInteractMode;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.WindHopSwitchMode;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.ViafabricplusServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode15;

public class AutoDripstopeModule extends Module {

    public static final AutoDripstopeModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 switchModeSetting;
    private static final VisibleVisibleSettingPropertyImpl fastOpenSetting;
    private static ServiceComponent38 serviceComponent38;
    private static ServiceComponent38 serviceComponent382;

    private AutoDripstopeModule() {
        super("auto-dripstope", SubCategoriesKt.getAttackCategory());
    }

    private int getDelay() {
        return ((Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setDelay(int value) {
        delaySetting.setValue(this, DELEGATED_PROPERTIES[0], Integer.valueOf(value));
    }

    private WindHopSwitchMode getSwitchMode() {
        return ((WindHopSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setSwitchMode(WindHopSwitchMode value) {
        switchModeSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private boolean getFastOpen() {
        return ((Boolean) fastOpenSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setFastOpen(boolean value) {
        fastOpenSetting.setValue(this, DELEGATED_PROPERTIES[2], Boolean.valueOf(value));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (!(serviceComponent38.checkCondition(this.getDelay()))) {
            return;
        }
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        double offset = Math.ceil(SharedKt.getPlayer().method_55754());
        Map map = ((Map) new LinkedHashMap());
        double offset2 = offset;
        if (offset2 <= offset) {
            double offset3 = offset;
            if (offset3 <= offset) {
                double offset4 = offset;
                if (offset4 <= offset) {
                    BlockPos blockPos2 = blockPos.method_10069(offset2, offset3, offset4);
                    BlockState state = SharedKt.getWorld().getBlockState(blockPos2);
                    BlockState state2 = SharedKt.getWorld().getBlockState(blockPos2.down());
                    if (!(state2.method_26215())) {
                        if (state.getBlock() instanceof class_2533 && state.method_11654(((class_2769) class_2533.field_11625)) == class_2760.field_12617 && Intrinsics.areEqual(state2.getBlock(), Blocks.field_28048)) {
                            Vec3d vec = blockPos2.toCenterPos();
                            Iterable iterable = SharedKt.getWorld().method_18112();
                            if (iterable instanceof Collection && ((Collection) iterable).isEmpty()) {
                            } else {
                                Iterator iterator = iterable.iterator();
                                while (iterator.hasNext()) {
                                    Object element = iterator.next();
                                }
                            }
                            if (0) {
                                map.put(blockPos2, state);
                            }
                        }
                    }
                    if (offset4 != offset) {
                    }
                }
                if (offset3 != offset) {
                }
            }
            if (offset2 != offset) {
            }
        }
        offset4 = ((Iterable) map.entrySet());
        blockPos2 = offset4.iterator();
        if (!(blockPos2.hasNext())) {
        } else {
            state = blockPos2.next();
            if (!(blockPos2.hasNext())) {
            } else {
                state2 = ((Entry) state);
                vec = 0;
                state2 = INSTANCE.computeValue(((BlockPos) state2.getKey()));
                vec = blockPos2.next();
                iterable = ((Entry) vec);
                iterable = INSTANCE.computeValue(((BlockPos) iterable.getKey()));
                if (Float.compare(state2, iterable) > 0) {
                    state = vec;
                    state2 = iterable;
                }
            }
        }
        offset2 = ((Entry) state);
        if (!(((Boolean) ((BlockState) offset2.getValue()).method_11654(((class_2769) class_2533.field_11631))))) {
            if (!(SharedKt.getWorld().getBlockState(((BlockPos) offset2.getKey()).down()).method_26215())) {
                offset3 = ((Random.Default.nextDouble() / 10.0D) + 0.5D);
                blockPos2 = new Vec3d((((BlockPos) offset2.getKey()).method_10263() + offset3), ((BlockPos) offset2.getKey()).method_10264(), (((BlockPos) offset2.getKey()).method_10260() + offset3));
                if (serviceComponent382.checkCondition(5)) {
                    SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(blockPos2), 100, this::resolveUnit));
                }
                serviceComponent38.updateValue();
            } else {
                serviceComponent38.updateValue();
            }
        }
    }

    private boolean checkCondition(BlockPos arg0) {
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode());
        if (stackServiceComponent2.isActive()) {
            class_3965 class3965 = VecPacketHelper.resolveMinecraftObject(arg0.down(), -1, BlockPlacementInteractMode.Strict, OptionMode15.ALL, SharedKt.getPlayer().method_55754(), SharedKt.getPlayer().method_55754());
            if (class3965 != null) {
                SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(class3965.method_17784()), 100, this::resolveUnit));
            }
        }
        return true;
    }

    private void executeAction(BlockPos arg0) {
        double offset = ((Random.Default.nextDouble() / 10.0D) + 0.5D);
        class_3965 class3965 = new class_3965(Direction.DOWN, arg0, false);
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, class3965);
        SharedKt.getPlayer().method_6104(Hand.field_5808);
    }

    public float computeValue(BlockPos pos) {
        if (__UNDEF_KEY__ == null) {
        }
        return Math.abs((class_3532.method_15338((Math.toDegrees(Math.atan2((pos.toCenterPos().field_1350 - SharedKt.getPlayer().getZ()), (pos.toCenterPos().field_1352 - SharedKt.getPlayer().getX()))) - 90.0D)) - class_3532.method_15393(SharedKt.getPlayer().method_36454())));
    }

    private static Unit resolveUnit(Entry arg0) {
        INSTANCE.executeAction(((BlockPos) arg0.getKey()));
        return Unit.INSTANCE;
    }

    private static boolean checkCondition(ItemStack arg0) {
        return Intrinsics.areEqual(arg0.getItem(), Items.field_28042);
    }

    private static Packet resolveMinecraftObject(class_3965 arg0, int arg1) {
        return ((Packet) new class_2885(Hand.field_5808, arg0, arg1));
    }

    private static Unit resolveUnit(BlockPos arg0, class_3965 arg1) {
        ViafabricplusServiceComponent.INSTANCE.executeAction(true);
        PacketPacketHelper.executeAction(this::resolveMinecraftObject);
        SharedKt.getPlayer().method_6104(Hand.field_5808);
        ViafabricplusServiceComponent.INSTANCE.executeAction(false);
        INSTANCE.executeAction(arg0);
        if (__UNDEF_KEY__ != null) {
            if (INSTANCE.getFastOpen()) {
                INSTANCE.executeAction(arg0);
            }
            serviceComponent382.updateValue();
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(StackServiceComponent2 arg0, BlockPos arg1, class_3965 arg2) {
        ItemPacketHelper.INSTANCE.executeAction(arg0.getNumericValue(), INSTANCE.getSwitchMode(), this::resolveUnit);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] items = new KProperty[3];
        INSTANCE = new AutoDripstopeModule();
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 0, new IntRange(0, 15));
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
        fastOpenSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fast-open", true);
        serviceComponent38 = new ServiceComponent38();
        serviceComponent382 = new ServiceComponent38();
    }

}
