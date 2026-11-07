package su.catlean.client.services.network;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.BlockState;
import net.minecraft.class_1661;
import net.minecraft.class_2846;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_2879;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.features.modules.utility.player.SpeedMineDoubleMinePacketOrderMode;
import su.catlean.client.features.modules.utility.player.SpeedMineMode;
import su.catlean.client.features.modules.utility.player.SpeedMineModule;
import su.catlean.client.features.modules.utility.player.SpeedMinePauseEatMode;
import su.catlean.client.features.modules.utility.player.SpeedMineRebreakMode;
import su.catlean.client.features.modules.utility.player.SpeedMineStartMode;
import su.catlean.client.features.modules.utility.player.SpeedMineSwapTimingMode;
import su.catlean.client.features.modules.utility.player.SpeedMineTimingMode;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationRotationServiceComponent4Impl;
import su.catlean.client.services.client.RotationRotationServiceComponent4Impl2;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.RunnableServiceComponent2;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent45;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.types.OptionMode9;
import su.catlean.client.types.mappings.SpeedMineTimingModeWhenMappings;

public class ReasonPacketHelper {

    private final BlockPos blockPos;
    private float factorValue;
    private float factorValue2;
    private final ArrayDeque arrayDeque;
    private int countValue;
    private final ServiceComponent10 serviceComponent10;
    private static int countValue2;

    public ReasonPacketHelper(BlockPos pos, Direction direction) {
        this.blockPos = pos;
        this.arrayDeque = new ArrayDeque();
        this.serviceComponent10 = new ServiceComponent10();
        this.executeAction(direction);
    }

    public BlockPos getMinecraftObject() {
        return this.blockPos;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public void executeAction(Direction direction) {
        if (!(var28)) {
            if (direction == null) {
            }
        }
        Direction var29 = SharedKt.getPlayer().method_5735();
        int var30 = SharedKt.getPlayer().method_31548().method_67532();
        int var31 = SpeedMineModule.computeValue(this.blockPos);
        if (!(var28)) {
            if (SpeedMineModule.resolveSpeedMineSwapTimingMode() == SpeedMineSwapTimingMode.ALWAYS) {
                if (var31 == -1) {
                    return;
                }
                SpeedMineModule.executeAction(-1);
            }
        }
        if (!(var28)) {
            if (SpeedMineModule.INSTANCE.getDoubleMine()) {
                if (SpeedMineModule.resolveSpeedMineDoubleMinePacketOrderMode() == SpeedMineDoubleMinePacketOrderMode.NEW) {
                    PacketPacketHelper.executeAction(this::resolveMinecraftObject);
                    PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12971, this.blockPos.method_10069(0, 500, 0), Direction.DOWN));
                    if (var28) {
                    }
                    PacketPacketHelper.executeAction(this::resolveMinecraftObject2);
                    PacketPacketHelper.executeAction(this::resolveMinecraftObject3);
                }
                PacketPacketHelper.executeAction(this::resolveMinecraftObject4);
            }
            PacketPacketHelper.executeAction(this::resolveMinecraftObject5);
        }
        if (!(var28)) {
            if (SpeedMineModule.resolveSpeedMineStartMode() == SpeedMineStartMode.ABORT) {
                PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12971, this.blockPos, Direction.DOWN));
                if (var28 && SpeedMineModule.resolveSpeedMineStartMode() != SpeedMineStartMode.NONE && var28) {
                }
                PacketPacketHelper.executeAction(this::resolveMinecraftObject6);
            }
        }
        if (!(var28)) {
            SpeedMineModule.INSTANCE.getAtomicBoolean().set(1);
        }
        if (!(var28)) {
            if (SpeedMineModule.checkCondition()) {
                RunnableServiceComponent2.executeAction(1, 0, 0, this::executeAction);
            }
        }
        SpeedMineModule.executeAction();
    }

    public boolean checkCondition(boolean async) {
        if (var56) {
            if ((Direction) CollectionsKt.firstOrNull(VecPacketHelper.INSTANCE.resolveList(this.blockPos)) == null) {
            }
        }
        Direction var57 = SharedKt.getPlayer().method_5735();
        Iterable var59 = (Iterable) SpeedMineModule.INSTANCE.getLinkedList();
        int var60 = 0;
        Iterator iterator = var59.iterator();
        if (iterator.hasNext()) {
            Object var62 = iterator.next();
            ReasonPacketHelper var63 = (ReasonPacketHelper) var62;
            int var64 = 0;
            if (var56) {
                if (!(SharedKt.getWorld().method_22347(var63.blockPos))) {
                }
            } else {
            }
        } else {
        }
        ReasonPacketHelper var58 = (ReasonPacketHelper) null;
        var59 = this.checkCondition();
        var60 = SpeedMineModule.computeValue(this.blockPos);
        if (this.countValue > 0) {
            if (SpeedMineModule.INSTANCE.getDoubleMine()) {
                if (var56 && var56 && var56) {
                    if (!(Intrinsics.areEqual(this.blockPos, SpeedMineModule.getMinecraftObject()))) {
                        this.executeAction();
                        return true;
                    }
                }
            }
        }
        if (var56) {
            if (!(SpeedMineModule.checkCondition(this.blockPos))) {
                this.executeAction();
                return true;
            }
        }
        if (var56) {
            if (SharedKt.getWorld().method_22347(this.blockPos)) {
                this.factorValue = 0.0F;
                this.factorValue2 = -1.0F;
                this.arrayDeque.add(Boolean.valueOf(SharedKt.getPlayer().isOnGround()));
                if (var56) {
                }
                if (var56) {
                    if (!(Intrinsics.areEqual(this.blockPos, SpeedMineModule.getMinecraftObject())) && SpeedMineModule.INSTANCE.getLinkedList().size() > 1) {
                    }
                } else {
                }
                return false;
            }
        }
        if (var56) {
            if (this.factorValue == 0.0F) {
            }
        } else {
        }
        if (var56) {
            if (this.factorValue2 == -1.0F) {
            }
        } else {
        }
        if (var56) {
            if (var56) {
                if (this.countValue > 0) {
                    if (SpeedMineModule.INSTANCE.getRebreak() == SpeedMineRebreakMode.GRIM) {
                        if (var56) {
                            if (var56) {
                                if (0 && 0 && SpeedMineModule.INSTANCE.getMode() == SpeedMineMode.PACKET && this.serviceComponent10.checkCondition2(500) && !(Intrinsics.areEqual(this.blockPos, SpeedMineModule.getMinecraftObject())) && SpeedMineModule.INSTANCE.getLinkedList().size() > 1) {
                                }
                            }
                            if (var56) {
                            }
                            if (!(this.arrayDeque.isEmpty())) {
                                if (SpeedMineModule.INSTANCE.getRebreak() != SpeedMineRebreakMode.NCP_AIR) {
                                }
                            }
                            this.executeAction();
                            SharedKt.getPlayer().method_6104(Hand.field_5808);
                        }
                        if (var56) {
                            if (!((Collection) this.arrayDeque.isEmpty())) {
                            }
                        } else {
                        }
                        if (!(var56) && 0) {
                            iterator = (Iterable) this.arrayDeque;
                            var62 = 0;
                            var63 = iterator.iterator();
                            if (var63.hasNext()) {
                                var64 = var63.next();
                                Boolean var65 = (Boolean) var64;
                                int var66 = 0;
                                this.factorValue2 = this.factorValue;
                                this.factorValue = (this.factorValue + SpeedMineModule.computeValue(SharedKt.getWorld().getBlockState(this.blockPos), this.blockPos));
                                if (var56) {
                                }
                            }
                        }
                        return false;
                    }
                }
            }
            if (var56) {
            }
            if (var60 == -1) {
                return false;
            }
        }
        if (var56) {
            if (SharedKt.getPlayer().method_6115() && SpeedMineModule.resolveSpeedMinePauseEatMode() == SpeedMinePauseEatMode.GRIM) {
                this.factorValue2 = this.factorValue;
                this.factorValue = (this.factorValue + SpeedMineModule.computeValue(SharedKt.getWorld().getBlockState(this.blockPos), this.blockPos, SharedKt.getPlayer().isOnGround()));
                return false;
            }
            if (var56) {
            }
            if (this.factorValue < 1.0F) {
                if (var59) {
                }
            }
            if (var56) {
            }
            if (var58 != null && Intrinsics.areEqual(this)) {
                iterator = (Iterable) SpeedMineModule.INSTANCE.getLinkedList();
                var62 = 0;
                if (iterator instanceof Collection) {
                    if (var56 && var56) {
                        if ((Collection) iterator.isEmpty()) {
                        }
                    }
                }
                var63 = 0;
                var64 = iterator.iterator();
                if (var64.hasNext()) {
                    var65 = var64.next();
                    var66 = (ReasonPacketHelper) var65;
                    int var67 = 0;
                    if (var56) {
                        if (var56) {
                            if (!(SharedKt.getWorld().method_22347(var66.blockPos))) {
                            }
                        } else {
                        }
                        if (var56) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                if (var63 != 2) {
                }
                iterator = SharedKt.getWorld().getBlockState(this.blockPos);
                if (!(iterator.method_26215())) {
                    if (!(iterator.method_51176())) {
                        if (var56) {
                            if (SpeedMineModule.getConcurrentHashMap().containsKey(this.blockPos)) {
                                if (var56 && var56 && var56) {
                                    if (!(SpeedMineModule.checkCondition2())) {
                                    }
                                }
                                if (var56) {
                                    if (SpeedMineModule.checkCondition()) {
                                        var62 = this::resolveUnit;
                                        var63 = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(this.blockPos.toCenterPos().method_1031(0.0D, 0.5D, 0.0D));
                                        var64 = new NoWhenBranchMatchedException();
                                        SequenceServiceComponent.INSTANCE.executeAction();
                                    }
                                }
                                if (var56) {
                                    if (!(async)) {
                                    }
                                    if (var56) {
                                        if (!(SpeedMineModule.checkCondition())) {
                                        }
                                        this.executeAction(SharedKt.getPlayer().method_31548().method_67532());
                                    }
                                    this.factorValue2 = this.factorValue;
                                    this.factorValue = (this.factorValue + SpeedMineModule.computeValue(SharedKt.getWorld().getBlockState(this.blockPos), this.blockPos, SharedKt.getPlayer().isOnGround()));
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkCondition(ReasonPacketHelper arg0, boolean arg1, int arg2, Object arg3) {
        if (var11) {
            if ((arg2 & 1)) {
                arg1 = 0;
            }
        }
        return arg0.checkCondition(arg1);
    }

    public boolean checkCondition(short arg0, int arg1) {
        if (arg1 > 0) {
            if (var14) {
            }
        }
        if (var14) {
            if (SpeedMineModule.checkCondition(this.blockPos)) {
                if (var14) {
                    if (arg1 >= 0) {
                        if (SpeedMineModule.checkCondition3()) {
                            if (arg0 >= 0) {
                                if (var14) {
                                }
                            }
                        }
                    }
                }
            }
        }
        if (var14) {
            if (!(Intrinsics.areEqual(this.blockPos, SpeedMineModule.getMinecraftObject()))) {
                if (var14) {
                    if (this.countValue > 0 && SpeedMineModule.INSTANCE.getRebreak() == SpeedMineRebreakMode.GRIM && ServiceComponent45.INSTANCE.checkCondition(this.blockPos) && SpeedMineModule.INSTANCE.getLinkedList().size() <= 1) {
                    }
                }
            }
        } else {
        }
        return false;
    }

    private void executeAction(int arg0, int arg1, Direction arg2) {
        SpeedMineModule.executeAction(arg0, -1);
        SpeedMineModule.INSTANCE.getAtomicBoolean().set(1);
        PacketPacketHelper.executeAction(this::resolveMinecraftObject7);
        if (var21) {
            if (SpeedMineModule.INSTANCE.getRebreak() == SpeedMineRebreakMode.NCP_AIR) {
                PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12971, this.blockPos, Direction.DOWN));
                PacketPacketHelper.executeAction(this::resolveMinecraftObject8);
                PacketPacketHelper.executeAction(this::resolveMinecraftObject9);
            }
        }
        AutoCrystalModule.INSTANCE.getMap().put(this.blockPos, Long.valueOf(SharedKt.getNumericValue()));
        this.arrayDeque.clear();
        PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
        if (var21) {
            if (SpeedMineModule.INSTANCE.getDoubleMine()) {
                if (this.countValue >= 1) {
                }
            }
            if (var21 && var21) {
                if (SpeedMineModule.checkCondition()) {
                }
            }
        } else {
        }
        int var22 = 0;
        if (var21) {
            if (var22) {
                RunnableServiceComponent2.executeAction(0, 0, this::executeAction2);
            }
            if (!(var21)) {
            }
            SpeedMineModule.executeAction(arg1, arg0);
        }
        SpeedMineModule.getServiceComponent10().executeAction();
        SpeedMineModule.updateValue(this.blockPos);
        int var23 = this.countValue;
        this.countValue = (var23 + 1);
        this.factorValue2 = 0.0F;
        this.factorValue = this.factorValue2;
    }

    public void executeAction(OptionMode9 reason) {
        this.arrayDeque.clear();
        if (var18) {
            if ((Direction) CollectionsKt.firstOrNull(VecPacketHelper.INSTANCE.resolveList(this.blockPos)) == null) {
            }
        }
        Direction var19 = SharedKt.getPlayer().method_5735();
        if (var18) {
            if (reason == OptionMode9.SWITCH && SpeedMineModule.INSTANCE.getRebreak() == SpeedMineRebreakMode.NCP_AIR && SharedKt.getWorld().method_22347(this.blockPos)) {
                this.factorValue = 0.0F;
                this.factorValue2 = this.factorValue;
                PacketPacketHelper.executeAction(this::resolveMinecraftObject10);
                return;
            }
        }
        if (var18) {
            if (this.factorValue == 0.0F) {
            }
        } else {
        }
        if (0) {
            return;
        }
        this.factorValue = 0.0F;
        this.factorValue2 = this.factorValue;
        PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12971, this.blockPos, Direction.DOWN));
        this.executeAction();
    }

    public void executeAction() {
        this.arrayDeque.clear();
        if (var8) {
            if (this.factorValue == 0.0F) {
            }
        } else {
        }
        PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12971, this.blockPos, Direction.DOWN));
    }

    private static Packet resolveMinecraftObject(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return (Packet) new class_2846(class_2847.field_12968, arg0.blockPos, arg1, arg2);
    }

    private static Packet resolveMinecraftObject2(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return (Packet) new class_2846(class_2847.field_12973, arg0.blockPos, arg1, arg2);
    }

    private static Packet resolveMinecraftObject3(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return (Packet) new class_2846(class_2847.field_12968, arg0.blockPos, arg1, arg2);
    }

    private static Packet resolveMinecraftObject4(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return (Packet) new class_2846(class_2847.field_12973, arg0.blockPos, arg1, arg2);
    }

    private static Packet resolveMinecraftObject5(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return (Packet) new class_2846(class_2847.field_12968, arg0.blockPos, arg1, arg2);
    }

    private static Packet resolveMinecraftObject6(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return (Packet) new class_2846(class_2847.field_12973, arg0.blockPos, arg1, arg2);
    }

    private static void executeAction(int arg0, int arg1) {
        SpeedMineModule.executeAction(arg0, arg1);
        SpeedMineModule.INSTANCE.getAtomicBoolean().set(0);
    }

    private static Unit resolveUnit(boolean arg0, ReasonPacketHelper arg1, int arg2, Direction arg3) {
        if (!(arg0)) {
            arg1.executeAction(arg2, SharedKt.getPlayer().method_31548().method_67532(), arg3);
        }
        return Unit.INSTANCE;
    }

    private static Packet resolveMinecraftObject7(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return (Packet) new class_2846(class_2847.field_12973, arg0.blockPos, arg1, arg2);
    }

    private static Packet resolveMinecraftObject8(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return (Packet) new class_2846(class_2847.field_12973, arg0.blockPos, arg1, arg2);
    }

    private static Packet resolveMinecraftObject9(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return (Packet) new class_2846(class_2847.field_12968, arg0.blockPos, arg1, arg2);
    }

    private static void executeAction2(int arg0, int arg1) {
        SpeedMineModule.executeAction(arg0, arg1);
    }

    private static Packet resolveMinecraftObject10(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return (Packet) new class_2846(class_2847.field_12968, arg0.blockPos, arg1, arg2);
    }

    public static void updateValue2(int arg0) {
        countValue2 = arg0;
    }

    public static int getNumericValue2() {
        return countValue2;
    }

    public static int getNumericValue3() {
        int var0 = getNumericValue2();
        if (!(var0)) {
            return 114;
        }
        return 0;
    }

}
