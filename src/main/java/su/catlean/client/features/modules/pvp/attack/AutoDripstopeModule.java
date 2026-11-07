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
import net.minecraft.entity.Entity;
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
        return (Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setDelay(int value) {
        delaySetting.setValue(this, DELEGATED_PROPERTIES[0], Integer.valueOf(value));
    }

    private WindHopSwitchMode getSwitchMode() {
        return (WindHopSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setSwitchMode(WindHopSwitchMode value) {
        switchModeSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private boolean getFastOpen() {
        return (Boolean) fastOpenSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setFastOpen(boolean value) {
        fastOpenSetting.setValue(this, DELEGATED_PROPERTIES[2], Boolean.valueOf(value));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (!(serviceComponent38.checkCondition(this.getDelay()))) {
            return;
        }
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        double var31 = Math.ceil(SharedKt.getPlayer().method_55754());
        Map var32 = (Map) new LinkedHashMap();
        int var33 = var31;
        if (var33 <= var31) {
            int var34 = var31;
            if (var34 <= var31) {
                int var35 = var31;
                if (var35 <= var31) {
                    BlockPos blockPos2 = blockPos.method_10069();
                    BlockState state = SharedKt.getWorld().getBlockState(blockPos2);
                    BlockState state2 = SharedKt.getWorld().getBlockState(blockPos2.down());
                    if (!(state2.method_26215())) {
                        if (state.getBlock() instanceof class_2533 && state.method_11654((class_2769) class_2533.field_11625) == class_2760.field_12617 && Intrinsics.areEqual(state2.getBlock(), Blocks.field_28048)) {
                        }
                        Vec3d vec = blockPos2.toCenterPos();
                        Iterable var40 = SharedKt.getWorld().method_18112();
                        int var41 = 0;
                        if (var40 instanceof Collection && (Collection) var40.isEmpty()) {
                        } else {
                            Iterator iterator = var40.iterator();
                            if (iterator.hasNext()) {
                                Object var43 = iterator.next();
                                Entity entity = var43;
                                int var45 = 0;
                            } else {
                            }
                        }
                        if (0) {
                            var32.put(blockPos2, state);
                        }
                    }
                    if (var35 != var31) {
                    }
                }
                if (var34 != var31) {
                }
            }
            if (var33 != var31) {
            }
        }
        var35 = (Iterable) var32.entrySet();
        blockPos2 = var35.iterator();
        if (!(blockPos2.hasNext())) {
        } else {
            state = blockPos2.next();
            if (!(blockPos2.hasNext())) {
            } else {
                state2 = (Entry) state;
                vec = 0;
                state2 = INSTANCE.computeValue((BlockPos) state2.getKey());
                vec = blockPos2.next();
                var40 = (Entry) vec;
                var41 = 0;
                var40 = INSTANCE.computeValue((BlockPos) var40.getKey());
                if (Float.compare(state2) > 0) {
                    state = vec;
                    state2 = var40;
                }
            }
        }
        var33 = (Entry) state;
        if (!((Boolean) (BlockState) var33.getValue().method_11654((class_2769) class_2533.field_11631))) {
            if (!(SharedKt.getWorld().getBlockState((BlockPos) var33.getKey().down()).method_26215())) {
            }
            var34 = ((Random.Default.nextDouble() / 10.0D) + 0.5D);
            blockPos2 = new Vec3d(((BlockPos) var33.getKey().method_10263() + var34), (BlockPos) var33.getKey().method_10264(), ((BlockPos) var33.getKey().method_10260() + var34));
            if (serviceComponent382.checkCondition(5)) {
                SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(blockPos2), 100, this::resolveUnit));
            }
            serviceComponent38.updateValue();
        } else {
            serviceComponent38.updateValue();
        }
    }

    private boolean checkCondition(BlockPos arg0) {
        StackServiceComponent2 var19 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode());
        if (var19.isActive()) {
            class_3965 var20 = VecPacketHelper.resolveMinecraftObject(arg0.down(), -1, BlockPlacementInteractMode.Strict, OptionMode15.ALL, SharedKt.getPlayer().method_55754(), SharedKt.getPlayer().method_55754());
            if (var20 != null) {
                SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(var20.method_17784()), 100, this::resolveUnit));
            }
        }
        return true;
    }

    private void executeAction(BlockPos arg0) {
        double var9 = ((Random.Default.nextDouble() / 10.0D) + 0.5D);
        class_3965 var11 = new class_3965(new Vec3d((arg0.method_10263() + var9), arg0.method_10264(), (arg0.method_10260() + var9)), Direction.DOWN, arg0, 0);
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808);
        SharedKt.getPlayer().method_6104(Hand.field_5808);
    }

    public float computeValue(BlockPos pos) {
        if (var9 == null) {
        }
        return Math.abs((class_3532.method_15338((Math.toDegrees(Math.atan2((pos.toCenterPos().field_1350 - SharedKt.getPlayer().getZ()), (pos.toCenterPos().field_1352 - SharedKt.getPlayer().getX()))) - 90.0D)) - class_3532.method_15393(SharedKt.getPlayer().method_36454())));
    }

    private static Unit resolveUnit(Entry arg0) {
        INSTANCE.executeAction((BlockPos) arg0.getKey());
        return Unit.INSTANCE;
    }

    private static boolean checkCondition(ItemStack arg0) {
        return Intrinsics.areEqual(arg0.getItem(), Items.field_28042);
    }

    private static Packet resolveMinecraftObject(class_3965 arg0, int arg1) {
        return (Packet) new class_2885(Hand.field_5808, arg0, arg1);
    }

    private static Unit resolveUnit(BlockPos arg0, class_3965 arg1) {
        ViafabricplusServiceComponent.INSTANCE.executeAction(1);
        PacketPacketHelper.executeAction(this::resolveMinecraftObject);
        SharedKt.getPlayer().method_6104(Hand.field_5808);
        ViafabricplusServiceComponent.INSTANCE.executeAction(0);
        INSTANCE.executeAction(arg0);
        if (var17 != null) {
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
        KProperty[] var32 = new KProperty[3];
        INSTANCE = new AutoDripstopeModule();
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 0, new IntRange(0, 15));
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
        fastOpenSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fast-open");
        serviceComponent38 = new ServiceComponent38();
        serviceComponent382 = new ServiceComponent38();
    }

}
