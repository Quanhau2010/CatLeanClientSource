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
        return (PhaseMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getOnlyOnGround() {
        return (Boolean) onlyOnGroundSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getAutoDisable() {
        return (Boolean) autoDisableSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getAntiSwim() {
        return (Boolean) antiSwimSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getFill() {
        return (Boolean) fillSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getGrim() {
        return (Boolean) grimSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private WindHopSwitchMode getSwitchMode() {
        return (WindHopSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[6]);
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

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 32978412894279L);
        long var5 = ((arg0 ^ 22016185369135L) >>> 32);
        long var6 = (((arg0 ^ 22016185369135L) << 32) >>> 40);
        long var7 = (((arg0 ^ 22016185369135L) << 56) >>> 56);
        long var8 = ((arg0 ^ 93374518548743L) >>> 48);
        long var9 = (((arg0 ^ 93374518548743L) << 16) >>> 48);
        long var10 = (((arg0 ^ 93374518548743L) << 32) >>> 32);
        long var11 = (arg0 ^ 6620550408232L);
        long var13 = (arg0 ^ 68640045030270L);
        long var15 = (arg0 ^ 67109487395364L);
        long var17 = (arg0 ^ 67464996320865L);
        double[] var20 = EventPacketHelper2.INSTANCE.process(0.44D);
        int var22 = 90;
        if (arg0 > 0L && var19 == null) {
            if (35.0F <= var22) {
            }
        } else {
        }
        boolean var21 = var22 <= 55.0F;
        PacketPacketHelper.handlePacket((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12981));
        if (var21) {
            double[] var23 = EventPacketHelper2.INSTANCE.process(0.51D);
            int var24 = 0;
            INSTANCE.executeAction();
            INSTANCE.executeAction();
            if (arg0 > 0L) {
            } else {
                var23 = EventPacketHelper2.INSTANCE.process(0.57D);
                var24 = 0;
                INSTANCE.executeAction();
                SharedKt.getPlayer().method_5814((SharedKt.getPlayer().getX() + var23[0]), SharedKt.getPlayer().getY(), (SharedKt.getPlayer().getZ() + var23[1]));
                PacketPacketHelper.handlePacket((Packet) new class_2829(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), 1, SharedKt.getPlayer().field_5976));
                INSTANCE.executeAction();
            }
        }
    }

    private void executeAction(double[] arg0, double[] arg1) {
        if (ExplosionPosEntityHelper.resolveMinecraftObject(SharedKt.getPlayer().getEyePos(), SharedKt.getPlayer().getEyePos().method_1031(arg0[0], 0.0D, arg0[1])) != null) {
        } else {
        }
        boolean var12 = ExplosionPosEntityHelper.resolveMinecraftObject(SharedKt.getPlayer().getEyePos(), SharedKt.getPlayer().getEyePos().method_1031(arg0[0], 0.0D, arg0[1])).equals(class_240.field_1333) == 1;
        SharedKt.getPlayer().method_5814((SharedKt.getPlayer().getX() + arg1[0]), (SharedKt.getPlayer().getY() + var12), (SharedKt.getPlayer().getZ() + arg1[1]));
        PacketPacketHelper.handlePacket((Packet) new class_2829(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), 1, SharedKt.getPlayer().field_5976));
    }

    private void executeAction(double[] arg0, double[] arg1) {
        if (SharedKt.getWorld().method_22347(BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()).method_1031(arg0[0], -2.0D, arg0[1])))) {
        } else {
        }
        int var15 = 1;
        SharedKt.getPlayer().method_5814((SharedKt.getPlayer().getX() + arg1[0]), (SharedKt.getPlayer().getY() - var15), (SharedKt.getPlayer().getZ() + arg1[1]));
        PacketPacketHelper.handlePacket((Packet) new class_2829(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), 1, SharedKt.getPlayer().field_5976));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (this.getMode() != PhaseMode.PEARL) {
            return;
        }
        boolean var45 = SharedKt.getPlayer().method_18376() == class_4050.field_18079;
        if (serviceComponent10.checkCondition(500)) {
            if (!(SharedKt.getPlayer().method_7357().method_7904(Items.field_8634.method_7854()))) {
            }
        } else {
        }
        }
        boolean var46 = SharedKt.getPlayer().field_6012 > 60;
        if (SharedKt.getPlayer().isOnGround()) {
            if (var45) {
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
        double[] var47 = EventPacketHelper2.process(0.5F, 1, 0.0F, 0.0F, 0.0F);
        BlockPos blockPos = BlockPos.method_49637((SharedKt.getPlayer().getX() + var47[0]), SharedKt.getPlayer().getY(), (SharedKt.getPlayer().getZ() + var47[1]));
        if (SharedKt.getMc().options.field_1832.method_1434()) {
            return;
        }
        ObjectRef var49 = new ObjectRef();
        var49.element = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(blockPos.toCenterPos());
        var49.element = new MoveFixServiceComponent((MoveFixServiceComponent) var49.element.getNumericValue(), this.computeValue());
        StackServiceComponent2 var50 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode());
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4((MoveFixServiceComponent) var49.element, 201, this::resolveUnit));
    }

    private void executeAction(BlockPos arg0) {
        BlockState state = SharedKt.getWorld().getBlockState(arg0);
        StackServiceComponent2 var26 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition2, this.getSwitchMode());
        if (this.getGrim()) {
        } else {
        }
        int var19 = 64;
        double var21 = SharedKt.getPlayer().method_55754();
        double var22 = SharedKt.getPlayer().method_55754();
        OptionMode15 var23 = OptionMode15.ALL;
        BlockPlacementInteractMode var24 = BlockPlacementInteractMode.Strict;
        class_3965 var27 = VecPacketHelper.resolveMinecraftObject(arg0, -1, BlockPlacementInteractMode.GRIM);
        ItemPacketHelper.INSTANCE.executeAction(var26.getNumericValue(), this.getSwitchMode(), this::resolveUnit);
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
        boolean var11 = !(Intrinsics.areEqual(state.method_26220((class_1922) SharedKt.getWorld(), blockPos), class_259.method_1073()));
        boolean var12 = !(Intrinsics.areEqual(state2.method_26220((class_1922) SharedKt.getWorld(), blockPos.up()), class_259.method_1073()));
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
        PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(BlockPos arg0, ObjectRef arg1, StackServiceComponent2 arg2) {
        if (INSTANCE.getFill()) {
            INSTANCE.executeAction(arg0.down());
            INSTANCE.executeAction(arg0);
        }
        if (EventPacketHelper2.INSTANCE.resolveMinecraftObject((MoveFixServiceComponent) arg1.element.getNumericValue(), (MoveFixServiceComponent) arg1.element.getNumericValue2(), 3.0F, 0, 0) != null) {
            Entity entity = EventPacketHelper2.INSTANCE.resolveMinecraftObject((MoveFixServiceComponent) arg1.element.getNumericValue(), (MoveFixServiceComponent) arg1.element.getNumericValue2(), 3.0F, 0, 0);
            int var29 = 0;
            if (entity instanceof class_1533 && !((class_1533) entity.method_6940().isEmpty())) {
                SharedKt.getInteractionManager().method_2918((PlayerEntity) SharedKt.getPlayer(), entity);
                PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
            }
            if (!(entity instanceof class_1533)) {
                if (entity instanceof EndCrystalEntity) {
                }
                SharedKt.getInteractionManager().method_2918((PlayerEntity) SharedKt.getPlayer(), entity);
                PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
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
        KProperty[] var29 = new KProperty[7];
        INSTANCE = new PhaseModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", PhaseMode.VANILLA);
        onlyOnGroundSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-on-ground", 0, null, this::isActive);
        autoDisableSetting = VisibleRenderHelper.registerSetting(INSTANCE, "auto-disable", 0, null, this::isActive2);
        antiSwimSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-swim", 1, null, this::isActive3);
        fillSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill", 1, null, this::isActive4);
        grimSetting = VisibleRenderHelper.registerSetting(INSTANCE, "grim", 1, null, this::isActive5);
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL, null, this::isActive6);
        serviceComponent10 = new ServiceComponent10();
    }

}
