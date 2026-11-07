package su.catlean.client.features.modules.movement.rage;

import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1747;
import net.minecraft.class_1922;
import net.minecraft.class_2346;
import net.minecraft.class_2382;
import net.minecraft.class_2547;
import net.minecraft.class_2629;
import net.minecraft.class_2708;
import net.minecraft.class_2749;
import net.minecraft.class_2761;
import net.minecraft.class_2767;
import net.minecraft.class_2770;
import net.minecraft.class_2797;
import net.minecraft.class_2828.class_2830;
import net.minecraft.class_2846;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_2879;
import net.minecraft.class_2885;
import net.minecraft.class_2886;
import net.minecraft.class_3965;
import net.minecraft.class_5894;
import net.minecraft.class_7439;
import net.minecraft.class_7472;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3fc;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.PostTasksProcessEvent;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.player.AirPlaceModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.PositionServiceComponent;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.RotationRotationServiceComponent4Impl;
import su.catlean.client.services.client.RotationRotationServiceComponent4Impl2;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent109;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.ViafabricplusServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper2;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class ScaffoldModule extends Module {

    public static final ScaffoldModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 timingSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 autoSwitchSetting;
    private static final VisibleVisibleSettingPropertyImpl towerSetting;
    private static final VisibleVisibleSettingPropertyImpl safeWalkSetting;
    private static final VisibleVisibleSettingPropertyImpl allowShiftSetting;
    private static final VisibleVisibleSettingPropertyImpl legitSetting;
    private static final VisibleVisibleSettingPropertyImpl saveAnglesSetting;
    private static final VisibleVisibleSettingPropertyImpl tellySetting;
    private static final VisibleVisibleSettingPropertyImpl clampSetting;
    private static final VisibleVisibleSettingPropertyImpl airPlaceSetting;
    private static final VisibleVisibleSettingPropertyImpl grimDelaySetting;
    private static final VisibleVisibleSettingPropertyImpl keepYSetting;
    private static final VisibleVisibleSettingPropertyImpl rotateSetting;
    private static final VisibleVisibleSettingPropertyImpl grimSilentSetting;
    private static final ServiceComponent10 serviceComponent10;
    private static PositionServiceComponent positionServiceComponent;
    private static int countValue;
    private static MoveFixServiceComponent moveFixServiceComponent;
    private static boolean enabledFlag;
    private static final ConcurrentLinkedQueue concurrentLinkedQueue;
    private static final ConcurrentLinkedQueue concurrentLinkedQueue2;
    private static final ServiceComponent10 serviceComponent102;
    private static final BlockPos[] blockPosArray;

    private ScaffoldModule() {
        super("scaffold", SubCategoriesKt.getRageMovementCategory());
    }

    private ScaffoldTimingMode getTiming() {
        return ((ScaffoldTimingMode) timingSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private ScaffoldAutoSwitchMode getAutoSwitch() {
        return ((ScaffoldAutoSwitchMode) autoSwitchSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getTower() {
        return ((Boolean) towerSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getSafeWalk() {
        return ((Boolean) safeWalkSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getAllowShift() {
        return ((Boolean) allowShiftSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getLegit() {
        return ((Boolean) legitSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getSaveAngles() {
        return ((Boolean) saveAnglesSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getTelly() {
        return ((Boolean) tellySetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private boolean getClamp() {
        return ((Boolean) clampSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private boolean getAirPlace() {
        return ((Boolean) airPlaceSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private boolean getGrimDelay() {
        return ((Boolean) grimDelaySetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private boolean getKeepY() {
        return ((Boolean) keepYSetting.getValue(this, DELEGATED_PROPERTIES[11]));
    }

    private boolean getRotate() {
        return ((Boolean) rotateSetting.getValue(this, DELEGATED_PROPERTIES[12]));
    }

    private boolean getGrimSilent() {
        return ((Boolean) grimSilentSetting.getValue(this, DELEGATED_PROPERTIES[13]));
    }

    public void updateValue() {
        countValue = -999;
    }

    public void updateValue2() {
        if (enabledFlag && !(ServiceComponent13.checkCondition(340))) {
            SharedKt.getMc().options.field_1832.method_23481(false);
        }
        this.executeAction();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        this.updateValue();
    }

    private void updateValue() {
        if (SharedKt.getMc().options.field_1903.method_1434() && EventPacketHelper2.INSTANCE.getNumericValue() <= 0.0D && this.getTelly()) {
            return;
        }
        positionServiceComponent = null;
        int index = this.computeValue(false);
        if (!(this.getSafeWalk()) && SharedKt.getPlayer().method_5715()) {
        }
        if (!(this.getAllowShift()) || index == -1) {
            return;
        }
        if (SharedKt.getMc().options.field_1903.method_1434() && !(EventPacketHelper2.INSTANCE.checkCondition())) {
            countValue = Math.floor((SharedKt.getPlayer().getY() - 1));
        }
        if (this.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 < countValue) {
            countValue = -999;
        }
        boolean flag = this.checkCondition(index);
        if (flag) {
        }
        double offset = Math.ceil(SharedKt.getPlayer().getY());
        if (!(this.getKeepY())) {
        }
        if (this.getTelly() && countValue != -999) {
        }
        BlockPos blockPos = BlockPos.method_49637(SharedKt.getPlayer().getX(), offset, SharedKt.getPlayer().getZ()).down();
        if (this.getAirPlace()) {
        }
        positionServiceComponent = this.resolvePositionServiceComponent(blockPos);
        if (this.getSafeWalk() && EventPacketHelper2.INSTANCE.checkCondition()) {
            if (!(SharedKt.getPlayer().method_5715()) && SharedKt.getWorld().getBlockState(blockPos).method_45474()) {
                SharedKt.getMc().options.field_1832.method_23481(true);
                enabledFlag = 1;
            }
            if (SharedKt.getPlayer().method_5715() && !(SharedKt.getWorld().getBlockState(blockPos).method_45474())) {
                SharedKt.getMc().options.field_1832.method_23481(false);
                enabledFlag = 0;
            }
        }
        if (this.getTiming() == ScaffoldTimingMode.VANILLA) {
        }
        blockPos = -0.25D;
        if (this.getLegit()) {
            if (positionServiceComponent != null && !(SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_1009(blockPos, 0.0D, blockPos).method_989(0.0D, -0.1D, 0.0D)).iterator().hasNext())) {
                BlockPos blockPos2 = positionServiceComponent.getMinecraftObject();
                Direction direction = positionServiceComponent.getMinecraftObject();
                ObjectRef objectRef = new ObjectRef();
                objectRef.element = new class_3965(blockPos2.toCenterPos().method_1019(new Vec3d(((Vector3fc) direction.method_23955())).method_1021(0.5D)), direction, blockPos2, false);
                if (0) {
                }
                double offset2 = (0.82D + RangeServiceComponent.k(((ClosedRange) RangesKt.rangeTo(0.0D, 0.16D)), false));
                if (this.getClamp()) {
                }
                double offset3 = ((class_3965) objectRef.element).method_17784().field_1352;
                if (this.getClamp()) {
                }
                double offset4 = ((class_3965) objectRef.element).method_17784().field_1350;
                objectRef.element = new class_3965(direction, blockPos2, false);
                MoveFixServiceComponent moveFixServiceComponent = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(((class_3965) objectRef.element).method_17784());
                if (this.getRotate() && this.getGrimSilent()) {
                    PacketPacketHelper.handlePacket(((Packet) new class_2830(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), moveFixServiceComponent.getNumericValue(), moveFixServiceComponent.getNumericValue2(), SharedKt.getPlayer().isOnGround(), SharedKt.getPlayer().field_5976)));
                }
                if (this.getRotate()) {
                    if (this.getGrimSilent()) {
                    }
                }
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                SequenceServiceComponent.INSTANCE.executeAction(noWhenBranchMatchedException);
                moveFixServiceComponent = moveFixServiceComponent;
            }
        }
        if (this.getRotate() && !(this.getGrimSilent())) {
        }
        int index2 = 2;
        int index3 = 0;
        MoveFixServiceComponent moveFixServiceComponent2 = new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455(), false);
        SequenceServiceComponent.executeAction(moveFixServiceComponent, moveFixServiceComponent2, index3, index2);
    }

    private boolean checkCondition(int arg0) {
        if (arg0 == -2) {
            return Block.method_9614(((class_1747) SharedKt.getPlayer().method_6079().getItem()).method_7711().method_9564().method_26220(((class_1922) SharedKt.getWorld()), BlockPos.field_10980));
        }
        if (SharedKt.getPlayer().method_6079().getItem() instanceof class_1747 && 0 != arg0 && SharedKt.getPlayer().method_31548().method_5438(arg0).getItem() instanceof class_1747) {
            return Block.method_9614(((class_1747) SharedKt.getPlayer().method_31548().method_5438(arg0).getItem()).method_7711().method_9564().method_26220(((class_1922) SharedKt.getWorld()), BlockPos.field_10980));
        }
        return true;
    }

    private void executeAction(class_3965 arg0) {
        if (SharedKt.getMc().options.field_1903.method_1434() && EventPacketHelper2.INSTANCE.getNumericValue() <= 0.0D && this.getTelly()) {
            return;
        }
        int index = this.computeValue(true);
        if (SharedKt.getMc().options.field_1903.method_1434() && !(EventPacketHelper2.INSTANCE.checkCondition()) && this.getTower()) {
            if (serviceComponent10.checkCondition2(1500)) {
            }
            SharedKt.getPlayer().method_18798().field_1352.method_18800(-0.28D, 0.42D, SharedKt.getPlayer().method_18798().field_1350);
        }
        serviceComponent10.executeAction();
        if (VecPacketHelper.INSTANCE.checkCondition(SharedKt.getWorld().getBlockState(arg0.method_17777()).getBlock())) {
        } else {
        }
        int index2 = 0;
        if (index2) {
            ViafabricplusServiceComponent.INSTANCE.executeAction(true);
        }
        if (index != -2) {
        } else {
        }
        int index3 = 0;
        if (this.getAirPlace() && AirPlaceModule.INSTANCE.getEnabled() && AirPlaceModule.INSTANCE.getBypass()) {
            if (index3) {
            }
            HandServiceComponent.K(Hand.field_5810, 0.0F, 0.0F);
            PacketPacketHelper.executeAction(this::resolveMinecraftObject);
            PacketPacketHelper.handlePacket(((Packet) new class_2846(class_2847.field_12969, BlockPos.field_10980, Direction.DOWN)));
            PacketPacketHelper.executeAction(this::resolveMinecraftObject);
            if (index3) {
            }
            Hand.field_5808.method_6104(Hand.field_5810);
            PacketPacketHelper.handlePacket(((Packet) new class_2846(class_2847.field_12969, BlockPos.field_10980, Direction.DOWN)));
            if (index3) {
            }
            Hand.field_5808.method_6104(Hand.field_5810);
        }
        int index4 = SharedKt.getPlayer().method_6047().method_7947();
        if (this.getGrimDelay()) {
            PacketPacketHelper.handlePacket(((Packet) new class_2846(class_2847.field_12969, BlockPos.field_10980, Direction.DOWN)));
        }
        if (index3) {
        }
        SharedKt.getPlayer().method_2896(Hand.field_5808, Hand.field_5810, arg0);
        if (index3) {
        }
        PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5810)));
        if (this.getGrimDelay()) {
            PacketPacketHelper.handlePacket(((Packet) new class_2846(class_2847.field_12969, BlockPos.field_10980, Direction.DOWN)));
            SharedKt.getPlayer().method_6047().method_7939(index4);
        }
        serviceComponent102.executeAction();
        countValue = arg0.method_17777().method_10264();
        if (index2) {
            ViafabricplusServiceComponent.INSTANCE.executeAction(false);
        }
        this.executeAction(index);
        PacketPacketHelper.handlePacket(((Packet) new class_2830(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455(), SharedKt.getPlayer().isOnGround(), SharedKt.getPlayer().field_5976)));
    }

    private PositionServiceComponent resolvePositionServiceComponent(BlockPos arg0) {
        if (!(SharedKt.getWorld().getBlockState(arg0).method_45474())) {
            return null;
        }
        int index = 0;
        if (index < blockPosArray) {
            Object element = blockPosArray[index];
            PositionServiceComponent positionServiceComponent = VecPacketHelper.INSTANCE.resolvePositionServiceComponent(arg0.method_10081(((class_2382) element)));
            if (positionServiceComponent != null) {
                return positionServiceComponent;
            }
        }
        return null;
    }

    private boolean checkCondition(ItemStack arg0) {
        if (arg0.getItem() instanceof class_1747 && !(((class_1747) arg0.getItem()).method_7711().method_9564().method_45474())) {
        } else {
        }
        return false;
    }

    private int computeValue(long arg0, boolean arg1, char arg2) {
        int index = -1;
        if (__UNDEF_KEY__ != null) {
            if (this.checkCondition(SharedKt.getPlayer().method_6079())) {
                return -2;
            }
        }
        if (__UNDEF_KEY__ != null) {
            if (this.checkCondition(SharedKt.getPlayer().method_6047())) {
                return SharedKt.getPlayer().method_31548().method_67532();
            }
        }
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition);
        StackServiceComponent2 stackServiceComponent22 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition2);
        if (arg2 >= 0) {
            if (__UNDEF_KEY__ != null) {
                if (arg1) {
                    if (arg0 > 0L) {
                        if (__UNDEF_KEY__ != null) {
                            if (arg2 > 0) {
                            }
                        }
                    }
                    if (__UNDEF_KEY__ != null) {
                        if (stackServiceComponent22.isActive()) {
                            HandServiceComponent.executeAction(stackServiceComponent22.getNumericValue(), index, class_1713.field_7791, true);
                            index = SharedKt.getPlayer().method_31548().method_67532();
                            if (arg2 > 0) {
                            }
                            if (__UNDEF_KEY__ != null) {
                                if (__UNDEF_KEY__ == null && stackServiceComponent2.isActive()) {
                                    index = SharedKt.getPlayer().method_31548().method_67532();
                                    stackServiceComponent2.updateValue();
                                    if (__UNDEF_KEY__ != null) {
                                        if (__UNDEF_KEY__ != null) {
                                            if (__UNDEF_KEY__ == null && stackServiceComponent22.isActive()) {
                                                index = SharedKt.getPlayer().method_31548().method_67532();
                                                if (arg0 >= 0L) {
                                                }
                                                if (__UNDEF_KEY__ != null) {
                                                    if (__UNDEF_KEY__ == null && stackServiceComponent2.isActive()) {
                                                        index = SharedKt.getPlayer().method_31548().method_67532();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return index;
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (!(this.getGrimDelay())) {
            return;
        }
        Packet packet = arg0.getPacket();
        if (packet instanceof class_2797 || packet instanceof class_7439 || packet instanceof class_2761 || packet instanceof class_7472 || packet instanceof class_2767 || packet instanceof class_2770 || packet instanceof class_5894 || packet instanceof class_2749 || !(packet instanceof class_2708)) {
            return;
        }
        this.executeAction();
        concurrentLinkedQueue.add(new PacketPacketHelper2(arg0.getPacket(), SharedKt.getNumericValue()));
        arg0.cancel();
    }

    private void onPostTasksProcessEvent(PostTasksProcessEvent arg0) {
        if (SharedKt.getMc().world != null) {
            if (SharedKt.getMc().player == null) {
                concurrentLinkedQueue.clear();
                return;
            }
        }
        executeAction(this, false);
        concurrentLinkedQueue2.removeIf(this::checkCondition);
    }

    private void updateValue(boolean arg0) {
        concurrentLinkedQueue.removeIf(this::checkCondition2);
    }

    private static void executeAction(ScaffoldModule arg0, boolean arg1, int arg2, Object arg3) {
        arg1 = 0;
        arg0.updateValue(arg1);
    }

    private void executeAction() {
        concurrentLinkedQueue.removeIf(this::checkCondition3);
    }

    private void executeAction(int arg0) {
        HandServiceComponent.executeAction(arg0, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, true);
        ItemPacketHelper.INSTANCE.executeAction(arg0);
    }

    private static boolean isActive() {
        return false;
    }

    private static Unit resolveUnit(ObjectRef arg0) {
        INSTANCE.executeAction(((class_3965) arg0.element));
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(ObjectRef arg0) {
        INSTANCE.executeAction(((class_3965) arg0.element));
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit3(ObjectRef arg0) {
        INSTANCE.executeAction(((class_3965) arg0.element));
        return Unit.INSTANCE;
    }

    private static Packet resolveMinecraftObject(boolean arg0, int arg1) {
        if (arg0) {
        }
        return ((Packet) new class_2886(Hand.field_5810, arg1, EventPacketHelper2.INSTANCE.computeValue(), EventPacketHelper2.INSTANCE.computeValue2()));
    }

    private static Packet resolveMinecraftObject(boolean arg0, class_3965 arg1, int arg2) {
        if (arg0) {
        }
        return ((Packet) new class_2885(Hand.field_5810, arg1, arg2));
    }

    private static boolean checkCondition(ItemStack arg0) {
        return INSTANCE.checkCondition(arg0);
    }

    private static boolean checkCondition2(ItemStack arg0) {
        return INSTANCE.checkCondition(arg0);
    }

    private static boolean handlePacket(Packet arg0) {
        int index = 0;
        arg0.method_65081(((class_2547) SharedKt.getNetwork()));
        return true;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static boolean checkCondition(boolean arg0, PacketPacketHelper2 arg1) {
        if (!(arg0)) {
            if (arg1.getNumericValue() <= (SharedKt.getNumericValue() - 500)) {
            } else {
            }
        }
        int index = 0;
        if (index) {
            concurrentLinkedQueue2.add(arg1.getMinecraftObject());
        }
        return index;
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static boolean checkCondition(PacketPacketHelper2 arg0) {
        int index = 0;
        arg0.getMinecraftObject().method_65081(((class_2547) SharedKt.getNetwork()));
        return true;
    }

    private static boolean checkCondition3(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        KProperty[] items = new KProperty[14];
        INSTANCE = new ScaffoldModule();
        timingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timing", ScaffoldTimingMode.GRIM);
        autoSwitchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", ScaffoldAutoSwitchMode.Silent);
        towerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "tower", true);
        safeWalkSetting = VisibleRenderHelper.registerSetting(INSTANCE, "safe-walk", false);
        allowShiftSetting = VisibleRenderHelper.registerSetting(INSTANCE, "allow-shift", false, null, this::isActive);
        legitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "legit", true);
        saveAnglesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "save-angles", true);
        tellySetting = VisibleRenderHelper.registerSetting(INSTANCE, "telly", false);
        clampSetting = VisibleRenderHelper.registerSetting(INSTANCE, "clamp", true);
        airPlaceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "air-place", false);
        grimDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "grim-block-fly", false);
        keepYSetting = VisibleRenderHelper.registerSetting(INSTANCE, "keep-height", false);
        rotateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotate", true);
        grimSilentSetting = VisibleRenderHelper.registerSetting(INSTANCE, "grim-silent", false);
        serviceComponent10 = new ServiceComponent10();
        concurrentLinkedQueue = Queues.newConcurrentLinkedQueue();
        concurrentLinkedQueue2 = Queues.newConcurrentLinkedQueue();
        serviceComponent102 = new ServiceComponent10();
        items = new BlockPos[14];
        items[0] = new BlockPos(0, 0, 0);
        items[1] = new BlockPos(-1, 0, 0);
        items[2] = new BlockPos(1, 0, 0);
        items[3] = new BlockPos(0, 0, 1);
        items[4] = new BlockPos(0, 0, -1);
        items[5] = new BlockPos(-2, 0, 0);
        items[6] = new BlockPos(2, 0, 0);
        items[7] = new BlockPos(0, 0, 2);
        items[8] = new BlockPos(0, 0, -2);
        items[9] = new BlockPos(0, -1, 0);
        items[10] = new BlockPos(1, -1, 0);
        items[11] = new BlockPos(-1, -1, 0);
        items[12] = new BlockPos(0, -1, 1);
        items[13] = new BlockPos(0, -1, -1);
        blockPosArray = items;
    }

}
