package su.catlean.client.features.modules.movement.rage;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1533;
import net.minecraft.class_1796;
import net.minecraft.class_1922;
import net.minecraft.class_239.class_240;
import net.minecraft.class_259;
import net.minecraft.class_2828.class_2829;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_2879;
import net.minecraft.class_3736;
import net.minecraft.class_3965;
import net.minecraft.class_4050;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.CollisionEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.BlockPlacementInteractMode;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.WindHopSwitchMode;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode15;

public class PhaseModule extends Module {

    public static final PhaseModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final VisibleVisibleSettingPropertyImpl onlyOnGroundSetting;
    private static final VisibleVisibleSettingPropertyImpl autoDisableSetting;
    private static final VisibleVisibleSettingPropertyImpl antiSwimSetting;
    private static final VisibleVisibleSettingPropertyImpl fillSetting;
    private static final VisibleVisibleSettingPropertyImpl grimSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 switchModeSetting;
    private static final ServiceComponent10 serviceComponent10;

    private PhaseModule() {
        super("phase", SubCategoriesKt.getRageMovementCategory());
    }

    private PhaseMode getMode() {
        return ((PhaseMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getOnlyOnGround() {
        return ((Boolean) onlyOnGroundSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getAutoDisable() {
        return ((Boolean) autoDisableSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getAntiSwim() {
        return ((Boolean) antiSwimSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getFill() {
        return ((Boolean) fillSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getGrim() {
        return ((Boolean) grimSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private WindHopSwitchMode getSwitchMode() {
        return ((WindHopSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private void setSwitchMode(WindHopSwitchMode value) {
        switchModeSetting.setValue(this, DELEGATED_PROPERTIES[6], value);
    }

    private void onCollisionEvent(CollisionEvent arg0) {
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        if (Intrinsics.areEqual(arg0.getPos(), blockPos.down())) {
        }
        arg0.setState(Blocks.AIR.method_9564());
    }

    public void updateValue() {
        double[] items = EventPacketHelper2.INSTANCE.process(0.44D);
        int index = 90;
        if (35.0F <= index) {
        } else {
            boolean flag = index <= 55.0F;
        }
        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12981)));
        if (flag) {
            double[] items2 = EventPacketHelper2.INSTANCE.process(0.51D);
            INSTANCE.executeAction(items, items2);
            INSTANCE.executeAction(items, items2);
        } else {
            items2 = EventPacketHelper2.INSTANCE.process(0.57D);
            INSTANCE.executeAction(items, items2);
            SharedKt.getPlayer().method_5814((SharedKt.getPlayer().getX() + items2[0]), SharedKt.getPlayer().getY(), (SharedKt.getPlayer().getZ() + items2[1]));
            PacketPacketHelper.handlePacket(((Packet) new class_2829(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), true, SharedKt.getPlayer().field_5976)));
            INSTANCE.executeAction(items, items2);
        }
    }

    private void executeAction(double[] arg0, double[] arg1) {
        if (ExplosionPosEntityHelper.resolveMinecraftObject(SharedKt.getPlayer().getEyePos(), SharedKt.getPlayer().getEyePos().method_1031(arg0[0], 0.0D, arg0[1]), false, null, false) != null) {
        } else {
        }
        boolean flag = ExplosionPosEntityHelper.resolveMinecraftObject(SharedKt.getPlayer().getEyePos(), SharedKt.getPlayer().getEyePos().method_1031(arg0[0], 0.0D, arg0[1]), false, null, false).equals(class_240.field_1333) == 1;
        SharedKt.getPlayer().method_5814((SharedKt.getPlayer().getX() + arg1[0]), (SharedKt.getPlayer().getY() + flag), (SharedKt.getPlayer().getZ() + arg1[1]));
        PacketPacketHelper.handlePacket(((Packet) new class_2829(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), true, SharedKt.getPlayer().field_5976)));
    }

    private void executeAction(double[] arg0, double[] arg1) {
        if (SharedKt.getWorld().method_22347(BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()).method_1031(arg0[0], -2.0D, arg0[1])))) {
        } else {
        }
        int index = 1;
        SharedKt.getPlayer().method_5814((SharedKt.getPlayer().getX() + arg1[0]), (SharedKt.getPlayer().getY() - index), (SharedKt.getPlayer().getZ() + arg1[1]));
        PacketPacketHelper.handlePacket(((Packet) new class_2829(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), true, SharedKt.getPlayer().field_5976)));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (this.getMode() != PhaseMode.PEARL) {
            return;
        }
        boolean flag = SharedKt.getPlayer().method_18376() == class_4050.field_18079;
        if (serviceComponent10.checkCondition(500)) {
            if (!(SharedKt.getPlayer().method_7357().method_7904(Items.field_8634.method_7854()))) {
            } else {
                boolean flag2 = SharedKt.getPlayer().field_6012 > 60;
            }
        } else {
        }
        if (SharedKt.getPlayer().isOnGround()) {
            if (flag) {
                SharedKt.getPlayer().method_6043();
            }
        }
        if (EventPacketHelper2.INSTANCE.getNumericValue() <= 0.0D) {
        }
        if (!(SharedKt.getPlayer().isOnGround())) {
            if (this.getOnlyOnGround()) {
            }
        }
        if (SharedKt.getWorld().getBlockState(BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()))).getBlock() instanceof class_3736) {
            SharedKt.getInteractionManager().method_2910(BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer())), Direction.UP);
        }
        double[] items = EventPacketHelper2.process(0.5F, true, 0.0F, 0.0F, 0.0F);
        BlockPos blockPos = BlockPos.method_49637((SharedKt.getPlayer().getX() + items[0]), SharedKt.getPlayer().getY(), (SharedKt.getPlayer().getZ() + items[1]));
        if (SharedKt.getMc().options.field_1832.method_1434()) {
            return;
        }
        ObjectRef objectRef = new ObjectRef();
        objectRef.element = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(blockPos.toCenterPos());
        objectRef.element = new MoveFixServiceComponent(((MoveFixServiceComponent) objectRef.element).getNumericValue(), this.computeValue(), false);
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode());
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(((MoveFixServiceComponent) objectRef.element), 201, this::resolveUnit));
    }

    private void executeAction(BlockPos arg0) {
        BlockState state = SharedKt.getWorld().getBlockState(arg0);
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition2, this.getSwitchMode());
        if (this.getGrim()) {
        } else {
        }
        int index = 64;
        double offset = SharedKt.getPlayer().method_55754();
        double offset2 = SharedKt.getPlayer().method_55754();
        OptionMode15 optionMode15 = OptionMode15.ALL;
        BlockPlacementInteractMode blockPlacementInteractMode = BlockPlacementInteractMode.Strict;
        class_3965 class3965 = VecPacketHelper.resolveMinecraftObject(arg0, -1, BlockPlacementInteractMode.GRIM, blockPlacementInteractMode, optionMode15, offset2, offset, index);
        ItemPacketHelper.INSTANCE.executeAction(stackServiceComponent2.getNumericValue(), this.getSwitchMode(), this::resolveUnit);
    }

    private float computeValue() {
        if ((Math.abs(SharedKt.getPlayer().getY()) - Math.floor(SharedKt.getPlayer().getY())) > 0.1D) {
            return 81.0F;
        }
        if (Intrinsics.areEqual(SharedKt.getWorld().getBlockState(BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()))), Blocks.field_9983)) {
            return 80.0F;
        }
        return 85.0F;
    }

    private boolean checkCondition() {
        BlockPos blockPos = BlockPos.method_49637(SharedKt.getPlayer().getX(), MathKt.roundToInt(SharedKt.getPlayer().getY()), SharedKt.getPlayer().getZ());
        BlockState state = SharedKt.getWorld().getBlockState(blockPos);
        BlockState state2 = SharedKt.getWorld().getBlockState(blockPos);
        boolean flag = !(Intrinsics.areEqual(state.method_26220(((class_1922) SharedKt.getWorld()), blockPos), class_259.method_1073()));
        boolean flag2 = !(Intrinsics.areEqual(state2.method_26220(((class_1922) SharedKt.getWorld()), blockPos.up()), class_259.method_1073()));
        return !(Intrinsics.areEqual(state.getBlock(), Blocks.field_9983));
    }

    private static boolean isActive() {
        return INSTANCE.getMode() == PhaseMode.PEARL;
    }

    private static boolean isActive2() {
        return INSTANCE.getMode() == PhaseMode.PEARL;
    }

    private static boolean isActive3() {
        return INSTANCE.getMode() == PhaseMode.PEARL;
    }

    private static boolean isActive4() {
        return INSTANCE.getMode() == PhaseMode.PEARL;
    }

    private static boolean isActive5() {
        return INSTANCE.getFill();
    }

    private static boolean isActive6() {
        return INSTANCE.getMode() == PhaseMode.PEARL;
    }

    private static boolean checkCondition(ItemStack arg0) {
        return Intrinsics.areEqual(arg0.getItem(), Items.field_8634);
    }

    private static Unit getUnit() {
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5808)));
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(BlockPos arg0, ObjectRef arg1, StackServiceComponent2 arg2) {
        if (INSTANCE.getFill()) {
            INSTANCE.executeAction(arg0.down());
            INSTANCE.executeAction(arg0);
        }
        if (EventPacketHelper2.INSTANCE.resolveMinecraftObject(((MoveFixServiceComponent) arg1.element).getNumericValue(), ((MoveFixServiceComponent) arg1.element).getNumericValue2(), 3.0F, false, false) != null) {
            Entity entity = EventPacketHelper2.INSTANCE.resolveMinecraftObject(((MoveFixServiceComponent) arg1.element).getNumericValue(), ((MoveFixServiceComponent) arg1.element).getNumericValue2(), 3.0F, false, false);
            if (entity instanceof class_1533 && !(((class_1533) entity).method_6940().isEmpty())) {
                SharedKt.getInteractionManager().method_2918(((PlayerEntity) SharedKt.getPlayer()), entity);
                PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5808)));
            }
            if (!(entity instanceof class_1533)) {
                if (entity instanceof EndCrystalEntity) {
                    SharedKt.getInteractionManager().method_2918(((PlayerEntity) SharedKt.getPlayer()), entity);
                    PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5808)));
                }
            }
        } else {
        }
        ItemPacketHelper.INSTANCE.executeAction(arg2.getNumericValue(), INSTANCE.getSwitchMode(), this::getUnit);
        if (INSTANCE.getAutoDisable()) {
            INSTANCE.updateValue2();
        }
        serviceComponent10.executeAction();
        return Unit.INSTANCE;
    }

    private static boolean checkCondition2(ItemStack arg0) {
        return Intrinsics.areEqual(arg0.getItem(), Items.field_8281);
    }

    private static Unit resolveUnit(class_3965 arg0) {
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, arg0);
        SharedKt.getPlayer().method_6104(Hand.field_5808);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] items = new KProperty[7];
        INSTANCE = new PhaseModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", PhaseMode.VANILLA);
        onlyOnGroundSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-on-ground", false, null, this::isActive);
        autoDisableSetting = VisibleRenderHelper.registerSetting(INSTANCE, "auto-disable", false, null, this::isActive2);
        antiSwimSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-swim", true, null, this::isActive3);
        fillSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill", true, null, this::isActive4);
        grimSetting = VisibleRenderHelper.registerSetting(INSTANCE, "grim", true, null, this::isActive5);
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL, null, this::isActive6);
        serviceComponent10 = new ServiceComponent10();
    }

}
