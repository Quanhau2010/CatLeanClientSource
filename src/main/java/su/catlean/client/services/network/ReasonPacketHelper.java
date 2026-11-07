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
        if (direction == null) {
        }
        Direction direction2 = SharedKt.getPlayer().method_5735();
        int index = SharedKt.getPlayer().method_31548().method_67532();
        int index2 = SpeedMineModule.computeValue(this.blockPos);
        if (SpeedMineModule.resolveSpeedMineSwapTimingMode() == SpeedMineSwapTimingMode.ALWAYS) {
            if (index2 == -1) {
                return;
            }
            SpeedMineModule.executeAction(index2, -1);
        }
        if (SpeedMineModule.INSTANCE.getDoubleMine()) {
            if (SpeedMineModule.resolveSpeedMineDoubleMinePacketOrderMode() == SpeedMineDoubleMinePacketOrderMode.NEW) {
                PacketPacketHelper.executeAction(this::resolveMinecraftObject);
                PacketPacketHelper.handlePacket(((Packet) new class_2846(class_2847.field_12971, this.blockPos.method_10069(0, 500, 0), Direction.DOWN)));
            }
            PacketPacketHelper.executeAction(this::resolveMinecraftObject2);
            PacketPacketHelper.executeAction(this::resolveMinecraftObject3);
            PacketPacketHelper.executeAction(this::resolveMinecraftObject4);
        } else {
            PacketPacketHelper.executeAction(this::resolveMinecraftObject5);
            if (SpeedMineModule.resolveSpeedMineStartMode() != SpeedMineStartMode.NONE) {
                if (SpeedMineModule.resolveSpeedMineStartMode() == SpeedMineStartMode.ABORT) {
                    PacketPacketHelper.handlePacket(((Packet) new class_2846(class_2847.field_12971, this.blockPos, Direction.DOWN)));
                }
                PacketPacketHelper.executeAction(this::resolveMinecraftObject6);
            }
        }
        SpeedMineModule.INSTANCE.getAtomicBoolean().set(true);
        if (SpeedMineModule.checkCondition()) {
            RunnableServiceComponent2.executeAction(1, 0, false, this::executeAction);
        }
        SpeedMineModule.executeAction(index, index2);
    }

    public boolean checkCondition(boolean async) {
        if (((Direction) CollectionsKt.firstOrNull(VecPacketHelper.INSTANCE.resolveList(this.blockPos))) == null) {
        }
        Direction direction = SharedKt.getPlayer().method_5735();
        Iterable iterable = ((Iterable) SpeedMineModule.INSTANCE.getLinkedList());
        int index = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ReasonPacketHelper reasonPacketHelper = ((ReasonPacketHelper) element);
            int index2 = 0;
        }
        ReasonPacketHelper reasonPacketHelper2 = ((ReasonPacketHelper) null);
        iterable = this.checkCondition();
        index = SpeedMineModule.computeValue(this.blockPos);
        if (this.countValue > 0 && SpeedMineModule.INSTANCE.getDoubleMine() && !(Intrinsics.areEqual(this.blockPos, SpeedMineModule.getMinecraftObject()))) {
            this.executeAction();
            return true;
        }
        if (!(SpeedMineModule.checkCondition(this.blockPos))) {
            this.executeAction();
            return true;
        }
        if (SharedKt.getWorld().method_22347(this.blockPos)) {
            this.factorValue = 0.0F;
            this.factorValue2 = -1.0F;
            this.arrayDeque.add(Boolean.valueOf(SharedKt.getPlayer().isOnGround()));
            if (!(Intrinsics.areEqual(this.blockPos, SpeedMineModule.getMinecraftObject())) && SpeedMineModule.INSTANCE.getLinkedList().size() > 1) {
            } else {
            }
            return false;
        }
        if (this.factorValue2 == -1.0F) {
        } else {
        }
        if (this.countValue > 0) {
            if (SpeedMineModule.INSTANCE.getRebreak() == SpeedMineRebreakMode.GRIM) {
                if (0 && 0 && SpeedMineModule.INSTANCE.getMode() == SpeedMineMode.PACKET && this.serviceComponent10.checkCondition2(500) && !(Intrinsics.areEqual(this.blockPos, SpeedMineModule.getMinecraftObject())) && SpeedMineModule.INSTANCE.getLinkedList().size() > 1) {
                    if (!(this.arrayDeque.isEmpty())) {
                        if (SpeedMineModule.INSTANCE.getRebreak() != SpeedMineRebreakMode.NCP_AIR) {
                            this.executeAction(direction);
                            SharedKt.getPlayer().method_6104(Hand.field_5808);
                        }
                    }
                    if (0) {
                        iterator = ((Iterable) this.arrayDeque);
                        element = 0;
                        reasonPacketHelper = iterator.iterator();
                        while (reasonPacketHelper.hasNext()) {
                            index2 = reasonPacketHelper.next();
                            Boolean value = ((Boolean) index2);
                            int index3 = 0;
                            this.factorValue2 = this.factorValue;
                            this.factorValue = (this.factorValue + SpeedMineModule.computeValue(SharedKt.getWorld().getBlockState(this.blockPos), this.blockPos, index, value));
                        }
                    }
                    return false;
                }
            }
        }
        if (1 == index) {
            return false;
        }
        if (SharedKt.getPlayer().method_6115() && SpeedMineModule.resolveSpeedMinePauseEatMode() == SpeedMinePauseEatMode.GRIM) {
            this.factorValue2 = this.factorValue;
            this.factorValue = (this.factorValue + SpeedMineModule.computeValue(SharedKt.getWorld().getBlockState(this.blockPos), this.blockPos, index, SharedKt.getPlayer().isOnGround()));
            return false;
        }
        if (this < 0) {
            if (iterable) {
                if (Intrinsics.areEqual(reasonPacketHelper2, this)) {
                    iterator = ((Iterable) SpeedMineModule.INSTANCE.getLinkedList());
                    element = 0;
                    if (iterator instanceof Collection && ((Collection) iterator).isEmpty()) {
                    }
                    reasonPacketHelper = 0;
                    index2 = iterator.iterator();
                    while (index2.hasNext()) {
                        value = index2.next();
                        index3 = ((ReasonPacketHelper) value);
                        if (!(SharedKt.getWorld().method_22347(index3.blockPos))) {
                        } else {
                        }
                        CollectionsKt.throwCountOverflow();
                    }
                    if (reasonPacketHelper != 2) {
                        iterator = SharedKt.getWorld().getBlockState(this.blockPos);
                        if (SpeedMineModule.getConcurrentHashMap().containsKey(this.blockPos)) {
                            if (!(iterator.method_26215()) && !(iterator.method_51176()) && !(SpeedMineModule.checkCondition2())) {
                                element = this::resolveUnit;
                                reasonPacketHelper = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(this.blockPos.toCenterPos().method_1031(0.0D, 0.5D, 0.0D));
                                index2 = new NoWhenBranchMatchedException();
                                SequenceServiceComponent.INSTANCE.executeAction(index2);
                                if (!(async)) {
                                    if (!(SpeedMineModule.checkCondition())) {
                                        this.executeAction(index, SharedKt.getPlayer().method_31548().method_67532(), direction);
                                        this.factorValue2 = this.factorValue;
                                        this.factorValue = (this.factorValue + SpeedMineModule.computeValue(SharedKt.getWorld().getBlockState(this.blockPos), this.blockPos, index, SharedKt.getPlayer().isOnGround()));
                                    }
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
        arg1 = 0;
        return arg0.checkCondition(arg1);
    }

    public boolean checkCondition(short arg0, int arg1) {
        if (arg1 > 0) {
        }
        if (SpeedMineModule.checkCondition(this.blockPos)) {
            if (arg1 >= 0) {
                if (SpeedMineModule.checkCondition3()) {
                    if (arg0 >= 0) {
                        if (__UNDEF_KEY__) {
                        }
                    }
                }
            }
        }
        if (!(Intrinsics.areEqual(this.blockPos, SpeedMineModule.getMinecraftObject()))) {
            if (this.countValue > 0 && SpeedMineModule.INSTANCE.getRebreak() == SpeedMineRebreakMode.GRIM && ServiceComponent45.INSTANCE.checkCondition(this.blockPos) && SpeedMineModule.INSTANCE.getLinkedList().size() <= 1) {
            } else {
            }
        }
        return false;
    }

    private void executeAction(int arg0, int arg1, Direction arg2) {
        SpeedMineModule.executeAction(arg0, -1);
        SpeedMineModule.INSTANCE.getAtomicBoolean().set(true);
        PacketPacketHelper.executeAction(this::resolveMinecraftObject7);
        if (__UNDEF_KEY__) {
            if (SpeedMineModule.INSTANCE.getRebreak() == SpeedMineRebreakMode.NCP_AIR) {
                PacketPacketHelper.handlePacket(((Packet) new class_2846(class_2847.field_12971, this.blockPos, Direction.DOWN)));
                PacketPacketHelper.executeAction(this::resolveMinecraftObject8);
                PacketPacketHelper.executeAction(this::resolveMinecraftObject9);
            }
        }
        AutoCrystalModule.INSTANCE.getMap().put(this.blockPos, Long.valueOf(SharedKt.getNumericValue()));
        this.arrayDeque.clear();
        PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5808)));
        if (__UNDEF_KEY__) {
            if (SpeedMineModule.INSTANCE.getDoubleMine()) {
                if (this.countValue >= 1) {
                    if (__UNDEF_KEY__ && __UNDEF_KEY__) {
                        if (SpeedMineModule.checkCondition()) {
                        } else {
                        }
                    }
                }
            }
        }
        int index = 0;
        if (__UNDEF_KEY__) {
            if (index) {
                RunnableServiceComponent2.executeAction(index, 0, false, this::executeAction2);
                if (!(__UNDEF_KEY__)) {
                    SpeedMineModule.executeAction(arg1, arg0);
                }
            }
        }
        SpeedMineModule.getServiceComponent10().executeAction();
        SpeedMineModule.updateValue(this.blockPos);
        int index2 = this.countValue;
        this.countValue = (index2 + 1);
        this.factorValue2 = 0.0F;
        this.factorValue = this.factorValue2;
    }

    public void executeAction(OptionMode9 reason) {
        this.arrayDeque.clear();
        if (__UNDEF_KEY__) {
            if (((Direction) CollectionsKt.firstOrNull(VecPacketHelper.INSTANCE.resolveList(this.blockPos))) == null) {
            }
        }
        Direction direction = SharedKt.getPlayer().method_5735();
        if (__UNDEF_KEY__) {
            if (reason == OptionMode9.SWITCH && SpeedMineModule.INSTANCE.getRebreak() == SpeedMineRebreakMode.NCP_AIR && SharedKt.getWorld().method_22347(this.blockPos)) {
                this.factorValue = 0.0F;
                this.factorValue2 = this.factorValue;
                PacketPacketHelper.executeAction(this::resolveMinecraftObject10);
                return;
            }
        }
        if (__UNDEF_KEY__) {
            if (this.factorValue == 0.0F) {
            } else {
            }
        }
        if (0) {
            return;
        }
        this.factorValue = 0.0F;
        this.factorValue2 = this.factorValue;
        PacketPacketHelper.handlePacket(((Packet) new class_2846(class_2847.field_12971, this.blockPos, Direction.DOWN)));
        this.executeAction(direction);
    }

    public void executeAction() {
        this.arrayDeque.clear();
        if (__UNDEF_KEY__) {
            if (this.factorValue == 0.0F) {
            } else {
            }
        }
        PacketPacketHelper.handlePacket(((Packet) new class_2846(class_2847.field_12971, this.blockPos, Direction.DOWN)));
    }

    private static Packet resolveMinecraftObject(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return ((Packet) new class_2846(class_2847.field_12968, arg0.blockPos, arg1, arg2));
    }

    private static Packet resolveMinecraftObject2(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return ((Packet) new class_2846(class_2847.field_12973, arg0.blockPos, arg1, arg2));
    }

    private static Packet resolveMinecraftObject3(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return ((Packet) new class_2846(class_2847.field_12968, arg0.blockPos, arg1, arg2));
    }

    private static Packet resolveMinecraftObject4(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return ((Packet) new class_2846(class_2847.field_12973, arg0.blockPos, arg1, arg2));
    }

    private static Packet resolveMinecraftObject5(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return ((Packet) new class_2846(class_2847.field_12968, arg0.blockPos, arg1, arg2));
    }

    private static Packet resolveMinecraftObject6(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return ((Packet) new class_2846(class_2847.field_12973, arg0.blockPos, arg1, arg2));
    }

    private static void executeAction(int arg0, int arg1) {
        SpeedMineModule.executeAction(arg0, arg1);
        SpeedMineModule.INSTANCE.getAtomicBoolean().set(false);
    }

    private static Unit resolveUnit(boolean arg0, ReasonPacketHelper arg1, int arg2, Direction arg3) {
        if (!(arg0)) {
            arg1.executeAction(arg2, SharedKt.getPlayer().method_31548().method_67532(), arg3);
        }
        return Unit.INSTANCE;
    }

    private static Packet resolveMinecraftObject7(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return ((Packet) new class_2846(class_2847.field_12973, arg0.blockPos, arg1, arg2));
    }

    private static Packet resolveMinecraftObject8(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return ((Packet) new class_2846(class_2847.field_12973, arg0.blockPos, arg1, arg2));
    }

    private static Packet resolveMinecraftObject9(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return ((Packet) new class_2846(class_2847.field_12968, arg0.blockPos, arg1, arg2));
    }

    private static void executeAction2(int arg0, int arg1) {
        SpeedMineModule.executeAction(arg0, arg1);
    }

    private static Packet resolveMinecraftObject10(ReasonPacketHelper arg0, Direction arg1, int arg2) {
        return ((Packet) new class_2846(class_2847.field_12968, arg0.blockPos, arg1, arg2));
    }

    public static void updateValue2(int arg0) {
        countValue2 = arg0;
    }

    public static int getNumericValue2() {
        return countValue2;
    }

    public static int getNumericValue3() {
        int index = getNumericValue2();
        if (!(index)) {
            return 114;
        }
        return 0;
    }

}
