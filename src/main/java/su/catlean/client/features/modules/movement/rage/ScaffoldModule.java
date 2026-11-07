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
import net.minecraft.class_2661;
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
        return (ScaffoldTimingMode) timingSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private ScaffoldAutoSwitchMode getAutoSwitch() {
        return (ScaffoldAutoSwitchMode) autoSwitchSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getTower() {
        return (Boolean) towerSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getSafeWalk() {
        return (Boolean) safeWalkSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getAllowShift() {
        return (Boolean) allowShiftSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getLegit() {
        return (Boolean) legitSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getSaveAngles() {
        return (Boolean) saveAnglesSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getTelly() {
        return (Boolean) tellySetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private boolean getClamp() {
        return (Boolean) clampSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private boolean getAirPlace() {
        return (Boolean) airPlaceSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private boolean getGrimDelay() {
        return (Boolean) grimDelaySetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private boolean getKeepY() {
        return (Boolean) keepYSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private boolean getRotate() {
        return (Boolean) rotateSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private boolean getGrimSilent() {
        return (Boolean) grimSilentSetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    public void updateValue() {
        countValue = -999;
    }

    public void updateValue2(long arg0) {
        long var3 = (arg0 ^ 64129331416845L);
        long var5 = ((arg0 ^ 44030506242343L) >>> 48);
        long var6 = (((arg0 ^ 44030506242343L) << 16) >>> 32);
        long var7 = (((arg0 ^ 44030506242343L) << 48) >>> 48);
        if (enabledFlag && !(ServiceComponent13.checkCondition(340))) {
            SharedKt.getMc().options.field_1832.method_23481(0);
        }
        this.executeAction();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        this.updateValue();
    }

    private void updateValue() {
        if (SharedKt.getMc().options.field_1903.method_1434()) {
            if (EventPacketHelper2.INSTANCE.getNumericValue() <= 0.0D) {
                if (var71 != null && var71 != null && var71 != null) {
                    if (this.getTelly()) {
                        return;
                    }
                }
            }
            positionServiceComponent = null;
        }
        int var72 = this.computeValue(0);
        if (!(this.getSafeWalk())) {
            if (SharedKt.getPlayer().method_5715()) {
                if (var71 != null && var71 != null && var71 != null) {
                }
            }
        }
        if (!(this.getAllowShift()) || var71 != null) {
            return;
        }
        if (var72) {
            if (var71 != null && var71 != null) {
                if (!(EventPacketHelper2.INSTANCE.checkCondition())) {
                    countValue = Math.floor((SharedKt.getPlayer().getY() - 1));
                }
            }
        }
        if (var71 != null) {
            if (this.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 < countValue) {
                countValue = -999;
            }
        }
        boolean var73 = this.checkCondition();
        if (var73) {
        }
        double var74 = Math.ceil(SharedKt.getPlayer().getY());
        if (!(this.getKeepY())) {
            if (var71 != null && var71 != null) {
            }
        }
        if (this.getTelly() && countValue != -999) {
        }
        BlockPos blockPos = BlockPos.method_49637(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getZ()).down();
        Object var76 = blockPos;
        if (var71 != null) {
            if (this.getAirPlace()) {
            }
        }
        positionServiceComponent = this.resolvePositionServiceComponent();
        if (var71 != null) {
            if (var71 != null) {
                if (this.getSafeWalk() && EventPacketHelper2.INSTANCE.checkCondition()) {
                }
                if (!(SharedKt.getPlayer().method_5715())) {
                    if (var71 != null && var71 != null) {
                        if (SharedKt.getWorld().getBlockState().method_45474()) {
                            SharedKt.getMc().options.field_1832.method_23481(1);
                            enabledFlag = 1;
                        }
                    }
                }
                if (var71 != null) {
                }
                if (var71 != null) {
                    if (SharedKt.getPlayer().method_5715() && !(SharedKt.getWorld().getBlockState().method_45474())) {
                        SharedKt.getMc().options.field_1832.method_23481(0);
                    }
                    enabledFlag = 0;
                }
            }
        }
        if (this.getTiming() == ScaffoldTimingMode.VANILLA) {
        }
        blockPos = -0.25D;
        PositionServiceComponent var79 = positionServiceComponent;
        if (var71 != null) {
            if (this.getLegit()) {
            }
            if (var79 != null && !(SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_1009(blockPos, 0.0D, blockPos).method_989(0.0D, -0.1D, 0.0D)).iterator().hasNext())) {
            }
            BlockPos blockPos2 = var79.getMinecraftObject();
            Direction var81 = var79.getMinecraftObject();
            ObjectRef var82 = new ObjectRef();
            var82.element = new class_3965(blockPos2.toCenterPos().method_1019(new Vec3d((Vector3fc) var81.method_23955()).method_1021(0.5D)), blockPos2, 0);
            if (var71 != null) {
                if ((SharedKt.getPlayer().getY() - Math.floor(SharedKt.getPlayer().getY())) == 0.5D) {
                }
            } else {
            }
            if (0) {
            }
            double var83 = (0.82D + RangeServiceComponent.k((ClosedRange) RangesKt.rangeTo(0.0D, 0.16D)));
            if (var71 != null) {
                if (this.getClamp()) {
                }
            }
            double var85 = (class_3965) var82.element.method_17784().field_1352;
            if (var71 != null) {
                if (this.getClamp()) {
                }
            }
            double var87 = (class_3965) var82.element.method_17784().field_1350;
            var82.element = new class_3965(new Vec3d((blockPos2.method_10264() + var83)), blockPos2, 0);
            MoveFixServiceComponent var89 = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent((class_3965) var82.element.method_17784());
            if (this.getRotate()) {
                if (var71 != null && var71 != null) {
                    if (this.getGrimSilent()) {
                        PacketPacketHelper.handlePacket((Packet) new class_2830(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), var89.getNumericValue(), var89.getNumericValue2(), SharedKt.getPlayer().isOnGround(), SharedKt.getPlayer().field_5976));
                    }
                }
            }
            if (var71 != null) {
                if (this.getRotate()) {
                }
                if (this.getGrimSilent()) {
                }
            }
            Object var90 = var89;
            NoWhenBranchMatchedException var91 = new NoWhenBranchMatchedException();
            SequenceServiceComponent.INSTANCE.executeAction();
            moveFixServiceComponent = var89;
        }
        if (var71 != null) {
        }
        if (this.getRotate() && !(this.getGrimSilent())) {
        }
        int var67 = 2;
        int var68 = 0;
        MoveFixServiceComponent var69 = new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455());
        MoveFixServiceComponent var70 = moveFixServiceComponent;
        SequenceServiceComponent.executeAction();
    }

    private boolean checkCondition(int arg0) {
        if (var11 != null) {
            if (arg0 == -2) {
                if (SharedKt.getPlayer().method_6079().getItem() instanceof class_1747) {
                    return Block.method_9614((class_1747) SharedKt.getPlayer().method_6079().getItem().method_7711().method_9564().method_26220((class_1922) SharedKt.getWorld(), BlockPos.field_10980));
                }
            }
            if (arg0 != -1) {
                if (var11 != null && var11 != null && var11 != null) {
                    if (SharedKt.getPlayer().method_31548().method_5438(arg0).getItem() instanceof class_1747) {
                        return Block.method_9614((class_1747) SharedKt.getPlayer().method_31548().method_5438(arg0).getItem().method_7711().method_9564().method_26220((class_1922) SharedKt.getWorld(), BlockPos.field_10980));
                    }
                }
            }
        }
        return true;
    }

    private void executeAction(class_3965 arg0) {
        if (SharedKt.getMc().options.field_1903.method_1434()) {
            if (EventPacketHelper2.INSTANCE.getNumericValue() <= 0.0D) {
                if (var50 != null && var50 != null && var50 != null) {
                    if (this.getTelly()) {
                        return;
                    }
                }
            }
        }
        int var51 = this.computeValue(1);
        if (var50 != null) {
        }
        if (var50 != null) {
        }
        if (var50 != null) {
        }
        if (SharedKt.getMc().options.field_1903.method_1434() && !(EventPacketHelper2.INSTANCE.checkCondition()) && this.getTower()) {
            if (serviceComponent10.checkCondition2(1500)) {
            }
            SharedKt.getPlayer().method_18798().field_1352.method_18800(-0.28D, 0.42D, SharedKt.getPlayer().method_18798().field_1350);
            if (var50 == null) {
            }
            serviceComponent10.executeAction();
        }
        if (var50 != null) {
        }
        if (var50 != null) {
            if (VecPacketHelper.INSTANCE.checkCondition(SharedKt.getWorld().getBlockState(arg0.method_17777()).getBlock()) && !(SharedKt.getPlayer().method_5715())) {
            }
        } else {
        }
        int var52 = 0;
        if (var50 != null) {
            if (var52) {
                ViafabricplusServiceComponent.INSTANCE.executeAction(1);
            }
        }
        if (var50 != null) {
            if (var51 != -2) {
            }
        } else {
        }
        int var53 = 0;
        if (this.getAirPlace()) {
            if (AirPlaceModule.INSTANCE.getEnabled()) {
                if (var50 != null && var50 != null && var50 != null) {
                    if (AirPlaceModule.INSTANCE.getBypass()) {
                        if (var53) {
                        }
                        HandServiceComponent.K(Hand.field_5810, 0.0F, 0.0F);
                        PacketPacketHelper.executeAction(this::resolveMinecraftObject);
                        PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12969, BlockPos.field_10980, Direction.DOWN));
                        PacketPacketHelper.executeAction(this::resolveMinecraftObject);
                        if (var53) {
                        }
                        Hand.field_5808.method_6104(Hand.field_5810);
                        PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12969, BlockPos.field_10980, Direction.DOWN));
                        if (var53) {
                        }
                        Hand.field_5808.method_6104(Hand.field_5810);
                        if (var50 == null) {
                        }
                    }
                }
            }
            int var54 = SharedKt.getPlayer().method_6047().method_7947();
            if (this.getGrimDelay()) {
                PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12969, BlockPos.field_10980, Direction.DOWN));
            }
            if (var53) {
            }
            SharedKt.getPlayer().method_2896(Hand.field_5808, Hand.field_5810, arg0);
            if (var53) {
            }
            Hand.field_5808.<init>(Hand.field_5810);
            PacketPacketHelper.handlePacket((Packet) new class_2879);
            if (var50 != null) {
                if (this.getGrimDelay()) {
                    PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12969, BlockPos.field_10980, Direction.DOWN));
                    SharedKt.getPlayer().method_6047().method_7939();
                }
            }
            serviceComponent102.executeAction();
            countValue = arg0.method_17777().method_10264();
        }
        if (var50 != null) {
            if (var52) {
                ViafabricplusServiceComponent.INSTANCE.executeAction(0);
            }
            this.executeAction();
        }
        if (var50 != null) {
        }
        PacketPacketHelper.handlePacket((Packet) new class_2830(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455(), SharedKt.getPlayer().isOnGround(), SharedKt.getPlayer().field_5976));
    }

    private PositionServiceComponent resolvePositionServiceComponent(BlockPos arg0) {
        if (!(SharedKt.getWorld().getBlockState(arg0).method_45474())) {
            return null;
        }
        BlockPos[] var9 = blockPosArray;
        int var10 = 0;
        Object var11 = var9;
        if (var10 < var11) {
            Object var12 = var9[var10];
            PositionServiceComponent var13 = VecPacketHelper.INSTANCE.resolvePositionServiceComponent(arg0.method_10081((class_2382) var12));
            if (var8 != null) {
                if (var13 != null) {
                    return var13;
                }
            }
        }
        return null;
    }

    private boolean checkCondition(ItemStack arg0) {
        if (var4 != null) {
        }
        if (var4 != null) {
        }
        if (var4 != null) {
            if (arg0.getItem() instanceof class_1747 && !((class_1747) arg0.getItem().method_7711().method_9564().method_45474()) && !((class_1747) arg0.getItem().method_7711() instanceof class_2346)) {
            }
        } else {
        }
        return false;
    }

    private int computeValue(long arg0, boolean arg1, char arg2) {
        int var24 = -1;
        if (var23 != null) {
            if (this.checkCondition(SharedKt.getPlayer().method_6079())) {
                return -2;
            }
        }
        if (var23 != null) {
            if (this.checkCondition(SharedKt.getPlayer().method_6047())) {
            }
            return SharedKt.getPlayer().method_31548().method_67532();
        }
        StackServiceComponent2 var25 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition);
        StackServiceComponent2 var26 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition2);
        if (arg2 >= 0) {
            if (var23 != null) {
                if (arg1) {
                    if (arg0 > 0L) {
                        if (var23 != null) {
                            if (arg2 > 0) {
                            }
                        }
                    }
                    if (var23 != null) {
                        if (var26.isActive()) {
                            HandServiceComponent.executeAction(var26.getNumericValue(), class_1713.field_7791, 1);
                            var24 = SharedKt.getPlayer().method_31548().method_67532();
                            if (arg2 > 0) {
                            }
                            if (var23 != null) {
                                if (var23 == null && var25.isActive()) {
                                    var24 = SharedKt.getPlayer().method_31548().method_67532();
                                    var25.updateValue();
                                }
                            }
                        }
                        if (var23 != null) {
                            if (var23 != null) {
                                if (var23 == null && var26.isActive()) {
                                    var24 = SharedKt.getPlayer().method_31548().method_67532();
                                    if (arg0 >= 0L) {
                                    }
                                    if (var23 != null) {
                                        if (var23 == null && var25.isActive()) {
                                            var24 = SharedKt.getPlayer().method_31548().method_67532();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return var24;
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (!(this.getGrimDelay())) {
            return;
        }
        Packet var10 = arg0.getPacket();
        if (var9 != null) {
        }
        if (var9 != null) {
        }
        if (var9 != null) {
        }
        if (var9 != null) {
        }
        if (var9 != null) {
        }
        if (var9 != null) {
        }
        if (var9 != null) {
        }
        if (var9 != null) {
        }
        if (var10 instanceof class_2797 || var10 instanceof class_7439 || var10 instanceof class_2761 || var10 instanceof class_7472 || var10 instanceof class_2767 || var10 instanceof class_2770 || var10 instanceof class_5894 || var10 instanceof class_2749 || var9 != null) {
            return;
        }
        if (var9 != null) {
            if (!(var10 instanceof class_2629)) {
            }
            if (var9 != null) {
                if (var10 instanceof class_2661) {
                }
                this.executeAction();
                return;
            }
        }
        concurrentLinkedQueue.add(new PacketPacketHelper2(arg0.getPacket(), SharedKt.getNumericValue()));
        arg0.cancel();
    }

    private void onPostTasksProcessEvent(PostTasksProcessEvent arg0) {
        if (SharedKt.getMc().world != null) {
            if (var8 == null || SharedKt.getMc().player == null) {
                return;
            }
        }
        executeAction(this);
        concurrentLinkedQueue2.removeIf(this::checkCondition);
    }

    private void updateValue(boolean arg0) {
        concurrentLinkedQueue.removeIf(this::checkCondition2);
    }

    private static void executeAction(ScaffoldModule arg0, boolean arg1, int arg2, Object arg3) {
        if (var6 != null) {
            if ((arg2 & 1)) {
            }
            arg1 = 0;
        }
        arg0.updateValue(arg1);
    }

    private void executeAction() {
        concurrentLinkedQueue.removeIf(this::checkCondition3);
    }

    private void executeAction(int arg0) {
        if (var13 != null) {
            return;
        }
        if (var13 != null) {
        }
        HandServiceComponent.executeAction(arg0, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, 1);
        ItemPacketHelper.INSTANCE.executeAction(arg0);
    }

    private static boolean isActive() {
        if (var4 != null) {
            if (!(INSTANCE.getSafeWalk())) {
            }
        } else {
        }
        return false;
    }

    private static Unit resolveUnit(ObjectRef arg0) {
        INSTANCE.executeAction((class_3965) arg0.element);
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(ObjectRef arg0) {
        INSTANCE.executeAction((class_3965) arg0.element);
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit3(ObjectRef arg0) {
        INSTANCE.executeAction((class_3965) arg0.element);
        return Unit.INSTANCE;
    }

    private static Packet resolveMinecraftObject(boolean arg0, int arg1) {
        if (arg0) {
        }
        Hand.field_5808.<init>(Hand.field_5810, arg1, EventPacketHelper2.INSTANCE.computeValue(), EventPacketHelper2.INSTANCE.computeValue2());
        return (Packet) new class_2886;
    }

    private static Packet resolveMinecraftObject(boolean arg0, class_3965 arg1, int arg2) {
        if (arg0) {
        }
        Hand.field_5808.<init>(Hand.field_5810, arg1, arg2);
        return (Packet) new class_2885;
    }

    private static boolean checkCondition(ItemStack arg0) {
        return INSTANCE.checkCondition(arg0);
    }

    private static boolean checkCondition2(ItemStack arg0) {
        return INSTANCE.checkCondition(arg0);
    }

    private static boolean handlePacket(Packet arg0) {
        ScaffoldModule var5 = INSTANCE;
        Object var6 = var5;
        int var7 = 0;
        arg0.method_65081((class_2547) SharedKt.getNetwork());
        var6 = Result.constructor-impl(Unit.INSTANCE);
        var6 = Result.constructor-impl(ResultKt.createFailure());
        return true;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static boolean checkCondition(boolean arg0, PacketPacketHelper2 arg1) {
        if (!(arg0)) {
            if (var4 != null && var4 != null) {
                if (arg1.getNumericValue() <= (SharedKt.getNumericValue() - 500)) {
                }
            }
        } else {
        }
        int var5 = 0;
        int var6 = var5;
        int var7 = 0;
        if (var4 != null) {
            if (var6) {
                concurrentLinkedQueue2.add(arg1.getMinecraftObject());
            }
        }
        return var5;
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static boolean checkCondition(PacketPacketHelper2 arg0) {
        ScaffoldModule var5 = INSTANCE;
        Object var6 = var5;
        int var7 = 0;
        arg0.getMinecraftObject().method_65081((class_2547) SharedKt.getNetwork());
        var6 = Result.constructor-impl(Unit.INSTANCE);
        var6 = Result.constructor-impl(ResultKt.createFailure());
        return true;
    }

    private static boolean checkCondition3(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        KProperty[] var29 = new KProperty[14];
        INSTANCE = new ScaffoldModule();
        timingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timing", ScaffoldTimingMode.GRIM);
        autoSwitchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", ScaffoldAutoSwitchMode.Silent);
        towerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "tower");
        safeWalkSetting = VisibleRenderHelper.registerSetting(INSTANCE, "safe-walk");
        allowShiftSetting = VisibleRenderHelper.registerSetting(INSTANCE, "allow-shift", 0, null, this::isActive);
        legitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "legit");
        saveAnglesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "save-angles");
        tellySetting = VisibleRenderHelper.registerSetting(INSTANCE, "telly");
        clampSetting = VisibleRenderHelper.registerSetting(INSTANCE, "clamp");
        airPlaceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "air-place");
        grimDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "grim-block-fly");
        keepYSetting = VisibleRenderHelper.registerSetting(INSTANCE, "keep-height");
        rotateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotate");
        grimSilentSetting = VisibleRenderHelper.registerSetting(INSTANCE, "grim-silent");
        serviceComponent10 = new ServiceComponent10();
        concurrentLinkedQueue = Queues.newConcurrentLinkedQueue();
        concurrentLinkedQueue2 = Queues.newConcurrentLinkedQueue();
        serviceComponent102 = new ServiceComponent10();
        var29 = new BlockPos[14];
        var29[0] = new BlockPos(0, 0, 0);
        var29[1] = new BlockPos(-1, 0, 0);
        var29[2] = new BlockPos(1, 0, 0);
        var29[3] = new BlockPos(0, 0, 1);
        var29[4] = new BlockPos(0, 0, -1);
        var29[5] = new BlockPos(-2, 0, 0);
        var29[6] = new BlockPos(2, 0, 0);
        var29[7] = new BlockPos(0, 0, 2);
        var29[8] = new BlockPos(0, 0, -2);
        var29[9] = new BlockPos(0, -1, 0);
        var29[10] = new BlockPos(1, -1, 0);
        var29[11] = new BlockPos(-1, -1, 0);
        var29[12] = new BlockPos(0, -1, 1);
        var29[13] = new BlockPos(0, -1, -1);
        blockPosArray = var29;
    }

}
