package su.catlean.client.services.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import net.minecraft.class_10185;
import net.minecraft.class_241;
import net.minecraft.class_2828.class_2830;
import net.minecraft.class_3532;
import net.minecraft.class_744;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.player.EventPlayerTravel;
import su.catlean.api.event.events.player.EventPostPlayerTravel;
import su.catlean.api.event.events.player.FixVelocityEvent;
import su.catlean.api.event.events.player.JumpEvent;
import su.catlean.api.event.events.player.KeyboardInputEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PostInteractItemEvent;
import su.catlean.api.event.events.player.PostSyncEvent;
import su.catlean.api.event.events.player.PreInteractItemEvent;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.event.events.render.LookRenderEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.world.FireWorkVectorEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.AntiKnockBackModule;
import su.catlean.client.features.modules.movement.basic.ElytraRecastModule;
import su.catlean.client.features.modules.movement.basic.MoveFixMode;
import su.catlean.client.features.modules.movement.basic.MoveFixModule;
import su.catlean.client.features.modules.movement.rage.ElytraTargetModule;
import su.catlean.client.features.modules.movement.rage.MaceElytraTargetModule;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.render.cosmetic.FreeLookModule;
import su.catlean.client.features.modules.render.world.FreeCamModule;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.player.TargetEntityHelper10;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.types.OptionMode18;
import su.catlean.mixins.accessors.ClientInputAccessor;

public class SequenceServiceComponent implements Contract9 {

    public static final SequenceServiceComponent INSTANCE;
    private static ArrayList arrayList;
    private static ArrayList arrayList2;
    private static MoveFixServiceComponent moveFixServiceComponent;
    private static MoveFixServiceComponent moveFixServiceComponent2;
    private static MoveFixServiceComponent moveFixServiceComponent3;
    private static MoveFixServiceComponent moveFixServiceComponent4;
    private static MoveFixServiceComponent moveFixServiceComponent5;
    private static RotationServiceComponent4 rotationServiceComponent4;
    private static RotationServiceComponent4 rotationServiceComponent42;
    private static float factorValue;
    private static float factorValue2;
    private static float factorValue3;
    private static Module[] moduleArray;

    private SequenceServiceComponent() {
    }

    public MoveFixServiceComponent getMoveFixServiceComponent() {
        return moveFixServiceComponent3;
    }

    public void updateValue(MoveFixServiceComponent value) {
        moveFixServiceComponent3 = value;
    }

    public MoveFixServiceComponent getMoveFixServiceComponent2() {
        return moveFixServiceComponent4;
    }

    public void updateValue2(MoveFixServiceComponent value) {
        moveFixServiceComponent4 = value;
    }

    public void executeAction(RotationServiceComponent4 sequence) {
        AntiKnockBackModule.INSTANCE.executeAction();
        arrayList.add(sequence);
    }

    public void executeAction(RotationServiceComponent4 sequence) {
        AntiKnockBackModule.INSTANCE.executeAction();
        arrayList2.add(sequence);
    }

    public void executeAction(MoveFixServiceComponent rotation, int priority) {
        AntiKnockBackModule.INSTANCE.executeAction();
        arrayList.add(new RotationServiceComponent4(rotation, priority, this::getUnit));
    }

    public static void executeAction(SequenceServiceComponent arg0, MoveFixServiceComponent arg1, int arg2, int arg3, Object arg4) {
        if ((arg3 & 2) != 0) {
            arg2 = 150;
        }
        arg0.executeAction(arg1, arg2);
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(boolean clientSide) {
        Iterable iterable = ((Iterable) arrayList);
        Iterator iterator = iterable.iterator();
        if (!(iterator.hasNext())) {
        } else {
            Object element = iterator.next();
            if (!(iterator.hasNext())) {
            } else {
                RotationServiceComponent4 rotationServiceComponent4 = ((RotationServiceComponent4) element);
                int index = 0;
                rotationServiceComponent4 = rotationServiceComponent4.getNumericValue();
                index = iterator.next();
                RotationServiceComponent4 rotationServiceComponent42 = ((RotationServiceComponent4) index);
                rotationServiceComponent42 = rotationServiceComponent42.getNumericValue();
                if (rotationServiceComponent4 < rotationServiceComponent42) {
                    element = index;
                    rotationServiceComponent4 = rotationServiceComponent42;
                }
            }
        }
        if (((RotationServiceComponent4) element) != null && ((RotationServiceComponent4) element).getMoveFixServiceComponent() != null) {
            if (((RotationServiceComponent4) element).getMoveFixServiceComponent().resolveMoveFixServiceComponent() == null) {
            }
        }
        return new MoveFixServiceComponent(EventPacketHelper2.INSTANCE.computeValue(), EventPacketHelper2.INSTANCE.computeValue2(), false);
    }

    public static MoveFixServiceComponent resolveMoveFixServiceComponent(SequenceServiceComponent arg0, boolean arg1, int arg2, Object arg3) {
        if ((arg2 & 1) != 0) {
            arg1 = 0;
        }
        return arg0.resolveMoveFixServiceComponent(arg1);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        rotationServiceComponent42.getFunction0().invoke();
        rotationServiceComponent42 = null;
    }

    private void onPlayerUpdateEvent2(PlayerUpdateEvent arg0) {
        arrayList2.removeIf(this::checkCondition);
        Iterable iterable = ((Iterable) arrayList);
        int index = 0;
        Iterator iterator = iterable.iterator();
        if (!(iterator.hasNext())) {
        } else {
            Object element = iterator.next();
            if (!(iterator.hasNext())) {
            } else {
                RotationServiceComponent4 rotationServiceComponent4 = ((RotationServiceComponent4) element);
                int index2 = 0;
                rotationServiceComponent4 = rotationServiceComponent4.getNumericValue();
                index2 = iterator.next();
                RotationServiceComponent4 rotationServiceComponent42 = ((RotationServiceComponent4) index2);
                int index3 = 0;
                rotationServiceComponent42 = rotationServiceComponent42.getNumericValue();
                if (rotationServiceComponent4 < rotationServiceComponent42) {
                    element = index2;
                    rotationServiceComponent4 = rotationServiceComponent42;
                }
            }
        }
        rotationServiceComponent4 = ((RotationServiceComponent4) element);
        moveFixServiceComponent2 = rotationServiceComponent4.getMoveFixServiceComponent();
        if (moveFixServiceComponent2.getNumericValue() == SharedKt.getPlayer().method_36454() && moveFixServiceComponent2.getNumericValue2() == SharedKt.getPlayer().method_36455()) {
            index = ((Iterable) arrayList);
            iterator = 0;
            element = index;
            rotationServiceComponent4 = ((Collection) new ArrayList());
            index2 = 0;
            rotationServiceComponent42 = element.iterator();
            while (rotationServiceComponent42.hasNext()) {
                index3 = rotationServiceComponent42.next();
                RotationServiceComponent4 rotationServiceComponent43 = ((RotationServiceComponent4) index3);
                rotationServiceComponent4.add(index3);
            }
            index = ((Iterable) rotationServiceComponent4);
            iterator = 0;
            element = index.iterator();
            if (!(element.hasNext())) {
            } else {
                rotationServiceComponent4 = element.next();
                if (!(element.hasNext())) {
                } else {
                    index2 = ((RotationServiceComponent4) rotationServiceComponent4);
                    rotationServiceComponent42 = 0;
                    index2 = index2.getNumericValue();
                    rotationServiceComponent42 = element.next();
                    index3 = ((RotationServiceComponent4) rotationServiceComponent42);
                    rotationServiceComponent43 = 0;
                    index3 = index3.getNumericValue();
                    if (index2 < index3) {
                        rotationServiceComponent4 = rotationServiceComponent42;
                        index2 = index3;
                    }
                }
            }
            if (((RotationServiceComponent4) rotationServiceComponent4) != null) {
                iterator = ((RotationServiceComponent4) rotationServiceComponent4);
                element = 0;
                moveFixServiceComponent2 = iterator.getMoveFixServiceComponent();
            } else {
            }
        }
        moveFixServiceComponent2 = moveFixServiceComponent2.resolveMoveFixServiceComponent();
        if (rotationServiceComponent4 instanceof RotationRotationServiceComponent4Impl) {
            rotationServiceComponent4.getFunction0().invoke();
            rotationServiceComponent4 = null;
        }
        if (rotationServiceComponent4 instanceof RotationRotationServiceComponent4Impl2) {
            rotationServiceComponent42 = new RotationServiceComponent4(rotationServiceComponent4.getMoveFixServiceComponent(), rotationServiceComponent4.getNumericValue(), rotationServiceComponent4.getFunction0());
            rotationServiceComponent4 = null;
        }
        arrayList.clear();
    }

    private void onPreSyncEvent(PreSyncEvent arg0) {
        moveFixServiceComponent = new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455(), false);
        moveFixServiceComponent4 = moveFixServiceComponent3;
        moveFixServiceComponent3 = null;
        SharedKt.getPlayer().method_36456(moveFixServiceComponent2.getNumericValue());
        SharedKt.getPlayer().method_36457(moveFixServiceComponent2.getNumericValue2());
        moveFixServiceComponent3 = moveFixServiceComponent2;
        moveFixServiceComponent2 = null;
    }

    private void onPostSyncEvent(PostSyncEvent arg0) {
        if (rotationServiceComponent4 != null) {
            rotationServiceComponent4.getFunction0().invoke();
            rotationServiceComponent4 = null;
        }
        SharedKt.getPlayer().method_36456(moveFixServiceComponent.getNumericValue());
        SharedKt.getPlayer().method_36457(moveFixServiceComponent.getNumericValue2());
    }

    private void onLookRenderEvent(LookRenderEvent arg0) {
        factorValue = arg0.getBodyYaw();
        arg0.setBodyYaw(class_3532.method_15393(PolygonShaderComponent.INSTANCE.computeValue(moveFixServiceComponent4.getNumericValue(), moveFixServiceComponent3.getNumericValue(), TextShaderComponent2.INSTANCE.computeValue())));
        arg0.setYaw(0.0F);
        arg0.setPitch(class_3532.method_15393(PolygonShaderComponent.INSTANCE.computeValue(moveFixServiceComponent4.getNumericValue2(), moveFixServiceComponent3.getNumericValue2(), TextShaderComponent2.INSTANCE.computeValue())));
    }

    private void onJumpEvent(JumpEvent arg0) {
        if (!(this.checkCondition())) {
        }
        arg0.setYaw(this.computeValue());
        arg0.cancel();
    }

    private void onFixVelocityEvent(FixVelocityEvent arg0) {
        arg0.setVelocity(this.resolveMinecraftObject(this.computeValue(), arg0.getMovementInput(), arg0.getSpeed()));
        arg0.cancel();
    }

    private void onKeyboardInputEvent(KeyboardInputEvent arg0) {
        float factor = SharedKt.getPlayer().field_3913.method_3128().field_1342;
        float factor2 = SharedKt.getPlayer().field_3913.method_3128().field_1343;
        float factor3 = SharedKt.getPlayer().method_36454();
        float factor4 = ((factor3 - moveFixServiceComponent2.getNumericValue()) * 0.017453292F);
        double offset = Math.cos(factor4);
        double offset2 = Math.sin(factor4);
        int index = MathKt.roundToInt(((factor * offset) + (factor2 * offset2)));
        int index2 = MathKt.roundToInt(((factor2 * offset) - (factor * offset2)));
        ((ClientInputAccessor) SharedKt.getPlayer().field_3913).setMoveVector(new class_241(index2, index));
        SharedKt.getPlayer().field_3913.field_54155 = new class_10185(index > 0.0F, index < 0.0F, index2 > 0.0F, index2 < 0.0F, SharedKt.getPlayer().field_3913.field_54155.comp_3163(), SharedKt.getPlayer().field_3913.field_54155.comp_3164(), !(RotationServiceComponent2.INSTANCE.isActive()));
    }

    private void onPreInteractItemEvent(PreInteractItemEvent arg0) {
        factorValue2 = SharedKt.getPlayer().method_36454();
        factorValue3 = SharedKt.getPlayer().method_36455();
        MoveFixServiceComponent moveFixServiceComponent = this.resolveMoveFixServiceComponent(true);
        SharedKt.getPlayer().method_36456(moveFixServiceComponent.getNumericValue());
        SharedKt.getPlayer().method_36457(moveFixServiceComponent.getNumericValue2());
    }

    private void onPostInteractItemEvent(PostInteractItemEvent arg0) {
        SharedKt.getPlayer().method_36456(factorValue2);
        SharedKt.getPlayer().method_36457(factorValue3);
    }

    private boolean checkCondition(int arg0, char arg1, int arg2) {
        if (arg1 >= 0) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (arg2 >= 0) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (arg2 > 0) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (arg0 > 0) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        return !(ElytraRecastModule.INSTANCE.getEnabled());
    }

    private boolean checkCondition(int arg0, byte arg1, int arg2) {
        if (arg0 >= 0) {
            if (!(MoveFixModule.INSTANCE.getEnabled())) {
                if (arg2 > 0) {
                    if (__UNDEF_KEY__ == null) {
                        if (arg0 >= 0) {
                            if (MoveFixModule.INSTANCE.getEnabled()) {
                                if (MoveFixModule.INSTANCE.getMode() != MoveFixMode.FOCUS) {
                                    if (!(ElytraTargetModule.INSTANCE.getEnabled())) {
                                        if (arg0 >= 0) {
                                            if (!(MaceElytraTargetModule.INSTANCE.getEnabled())) {
                                                if (moveFixServiceComponent2.getOptionMode18() != OptionMode18.FORCE) {
                                                    if (arg0 > 0) {
                                                        if (!(SharedKt.getPlayer().method_3144())) {
                                                            if (arg1 > 0) {
                                                                if (!(SharedKt.getPlayer().isFallFlying())) {
                                                                    if (arg1 > 0) {
                                                                        if (__UNDEF_KEY__ == null) {
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
                        }
                    }
                }
            }
        }
        if (arg2 > 0) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        if (arg1 > 0) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        return !(ElytraRecastModule.INSTANCE.getEnabled());
    }

    private void onEventPlayerTravel(EventPlayerTravel arg0) {
        moveFixServiceComponent5 = new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455(), false);
        if (moveFixServiceComponent2 != null) {
        } else {
            moveFixServiceComponent2.getNumericValue();
        }
        SharedKt.getPlayer().method_36456(0.0F);
        if (moveFixServiceComponent2 != null) {
        } else {
            moveFixServiceComponent2.getNumericValue2();
        }
        SharedKt.getPlayer().method_36457(0.0F);
    }

    private void onEventPostPlayerTravel(EventPostPlayerTravel arg0) {
        SharedKt.getPlayer().method_36456(moveFixServiceComponent5.getNumericValue());
        SharedKt.getPlayer().method_36457(moveFixServiceComponent5.getNumericValue2());
    }

    private void onFireWorkVectorEvent(FireWorkVectorEvent arg0) {
        if (!(MoveFixModule.INSTANCE.getEnabled()) && !(ElytraTargetModule.INSTANCE.getEnabled())) {
        }
        if (!(SharedKt.getPlayer().method_3144()) && !(SharedKt.getPlayer().isFallFlying())) {
        }
        arg0.cancel();
        arg0.setVector(EventPacketHelper2.INSTANCE.resolveMinecraftObject(EventPacketHelper2.INSTANCE.computeValue2(), EventPacketHelper2.INSTANCE.computeValue()));
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        SharedKt.getPlayer().method_36456(PolygonShaderComponent.INSTANCE.computeValue(moveFixServiceComponent4.getNumericValue(), moveFixServiceComponent3.getNumericValue(), TextShaderComponent2.INSTANCE.computeValue()));
        SharedKt.getPlayer().method_36457(PolygonShaderComponent.INSTANCE.computeValue(moveFixServiceComponent4.getNumericValue2(), moveFixServiceComponent3.getNumericValue2(), TextShaderComponent2.INSTANCE.computeValue()));
    }

    public float computeValue() {
        if (moveFixServiceComponent2 != null) {
        } else {
            moveFixServiceComponent2.getNumericValue();
        }
        return 0.0F;
    }

    public void executeAction(float yaw, float pitch) {
        ClientPlayerEntity player = SharedKt.getPlayer();
        player.field_3944.method_52787(((Packet) new class_2830(player.getX(), player.getY(), player.getZ(), yaw, pitch, player.isOnGround(), player.field_5976)));
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Vec3d to) {
        double offset = class_3532.method_15338(((Math.toDegrees(Math.atan2((to.field_1350 - SharedKt.getPlayer().getZ()), (to.field_1352 - SharedKt.getPlayer().getX()))) - 90) - EventPacketHelper2.INSTANCE.computeValue()));
        double offset2 = (Math.toDegrees(Math.atan2((to.field_1351 - (AntiKnockBackModule.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((to.field_1352 - SharedKt.getPlayer().getX()), (to.field_1350 - SharedKt.getPlayer().getZ())))) - EventPacketHelper2.INSTANCE.computeValue2());
        float factor = (EventPacketHelper2.INSTANCE.computeValue() + offset);
        float factor2 = (EventPacketHelper2.INSTANCE.computeValue2() + offset2);
        return new MoveFixServiceComponent(factor, factor2, false);
    }

    private Vec3d resolveMinecraftObject(float arg0, Vec3d arg1, float arg2) {
        double offset = arg1.method_1027();
        if (offset < 1.0E-7D) {
            return Vec3d.ZERO;
        }
        if (offset > 1.0D) {
        } else {
        }
        Vec3d vec = arg1.method_1021(arg2);
        double offset2 = Math.sin((arg0 * 0.017453292F));
        double offset3 = Math.cos((arg0 * 0.017453292F));
        return new Vec3d(((vec.field_1352 * offset3) - (vec.field_1350 * offset2)), vec.field_1351, ((vec.field_1350 * offset3) + (vec.field_1352 * offset2)));
    }

    private static Unit getUnit() {
        return Unit.INSTANCE;
    }

    private static boolean checkCondition(RotationServiceComponent4 arg0) {
        INSTANCE.executeAction(arg0.getMoveFixServiceComponent().getNumericValue(), arg0.getMoveFixServiceComponent().getNumericValue2());
        arg0.getFunction0().invoke();
        if (arg0.getMoveFixServiceComponent().isActive()) {
            INSTANCE.executeAction(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455());
        }
        return true;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        INSTANCE = new SequenceServiceComponent();
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        moveFixServiceComponent = new MoveFixServiceComponent(0.0F, 0.0F, false);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
