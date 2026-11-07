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
        if ((arg3 & 2)) {
            arg2 = 150;
        }
        arg0.executeAction(arg1, arg2);
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(boolean clientSide) {
        Iterable var15 = (Iterable) arrayList;
        int var16 = 0;
        Iterator iterator = var15.iterator();
        if (!(iterator.hasNext())) {
        } else {
            Object var18 = iterator.next();
            if (!(iterator.hasNext())) {
            } else {
                RotationServiceComponent4 var19 = (RotationServiceComponent4) var18;
                int var20 = 0;
                var19 = var19.getNumericValue();
                var20 = iterator.next();
                RotationServiceComponent4 var21 = (RotationServiceComponent4) var20;
                int var22 = 0;
                var21 = var21.getNumericValue();
                if (var19 < var21) {
                    var18 = var20;
                    var19 = var21;
                }
            }
        }
        if ((RotationServiceComponent4) var18 != null && (RotationServiceComponent4) var18.getMoveFixServiceComponent() != null) {
            if ((RotationServiceComponent4) var18.getMoveFixServiceComponent().resolveMoveFixServiceComponent() == null) {
            }
        }
        return new MoveFixServiceComponent(EventPacketHelper2.INSTANCE.computeValue(), EventPacketHelper2.INSTANCE.computeValue2());
    }

    public static MoveFixServiceComponent resolveMoveFixServiceComponent(SequenceServiceComponent arg0, boolean arg1, int arg2, Object arg3) {
        if ((arg2 & 1)) {
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
        Iterable var11 = (Iterable) arrayList;
        int var12 = 0;
        Iterator iterator = var11.iterator();
        if (!(iterator.hasNext())) {
        } else {
            Object var14 = iterator.next();
            if (!(iterator.hasNext())) {
            } else {
                RotationServiceComponent4 var15 = (RotationServiceComponent4) var14;
                int var16 = 0;
                var15 = var15.getNumericValue();
                var16 = iterator.next();
                RotationServiceComponent4 var17 = (RotationServiceComponent4) var16;
                int var18 = 0;
                var17 = var17.getNumericValue();
                if (var15 < var17) {
                    var14 = var16;
                    var15 = var17;
                }
            }
        }
        rotationServiceComponent4 = (RotationServiceComponent4) var14;
        moveFixServiceComponent2 = rotationServiceComponent4.getMoveFixServiceComponent();
        if (moveFixServiceComponent2.getNumericValue() == SharedKt.getPlayer().method_36454() && moveFixServiceComponent2.getNumericValue2() == SharedKt.getPlayer().method_36455()) {
            var12 = (Iterable) arrayList;
            iterator = 0;
            var14 = var12;
            var15 = (Collection) new ArrayList();
            var16 = 0;
            var17 = var14.iterator();
            while (var17.hasNext()) {
                var18 = var17.next();
                RotationServiceComponent4 var19 = (RotationServiceComponent4) var18;
                int var20 = 0;
                var15.add();
            }
            var12 = (Iterable) var15;
            iterator = 0;
            var14 = var12.iterator();
            if (!(var14.hasNext())) {
            } else {
                var15 = var14.next();
                if (!(var14.hasNext())) {
                } else {
                    var16 = (RotationServiceComponent4) var15;
                    var17 = 0;
                    var16 = var16.getNumericValue();
                    var17 = var14.next();
                    var18 = (RotationServiceComponent4) var17;
                    var19 = 0;
                    var18 = var18.getNumericValue();
                    if (var16 < var18) {
                        var15 = var17;
                        var16 = var18;
                    }
                }
            }
            if ((RotationServiceComponent4) var15 != null) {
                iterator = (RotationServiceComponent4) var15;
                var14 = 0;
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
        moveFixServiceComponent = new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455());
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
        if (var12 == null) {
            if (!(this.checkCondition())) {
            }
            arg0.setYaw(this.computeValue());
        }
        arg0.cancel();
    }

    private void onFixVelocityEvent(FixVelocityEvent arg0) {
        if (var11 == null) {
            arg0.setVelocity(this.resolveMinecraftObject(this.computeValue(), arg0.getMovementInput(), arg0.getSpeed()));
        }
        arg0.cancel();
    }

    private void onKeyboardInputEvent(KeyboardInputEvent arg0) {
        float var9 = SharedKt.getPlayer().field_3913.method_3128().field_1342;
        float var10 = SharedKt.getPlayer().field_3913.method_3128().field_1343;
        float var11 = SharedKt.getPlayer().method_36454();
        float var12 = ((var11 - moveFixServiceComponent2.getNumericValue()) * 0.017453292F);
        double var13 = Math.cos();
        double var14 = Math.sin();
        int var15 = MathKt.roundToInt(((var9 * var13) + (var10 * var14)));
        int var16 = MathKt.roundToInt(((var10 * var13) - (var9 * var14)));
        (ClientInputAccessor) SharedKt.getPlayer().field_3913.setMoveVector(new class_241());
        SharedKt.getPlayer().field_3913.field_54155 = new class_10185(var15 > 0.0F, var15 < 0.0F, var16 > 0.0F, var16 < 0.0F, SharedKt.getPlayer().field_3913.field_54155.comp_3163(), SharedKt.getPlayer().field_3913.field_54155.comp_3164(), !(RotationServiceComponent2.INSTANCE.isActive()));
    }

    private void onPreInteractItemEvent(PreInteractItemEvent arg0) {
        factorValue2 = SharedKt.getPlayer().method_36454();
        factorValue3 = SharedKt.getPlayer().method_36455();
        MoveFixServiceComponent var8 = this.resolveMoveFixServiceComponent(1);
        SharedKt.getPlayer().method_36456(var8.getNumericValue());
        SharedKt.getPlayer().method_36457(var8.getNumericValue2());
    }

    private void onPostInteractItemEvent(PostInteractItemEvent arg0) {
        SharedKt.getPlayer().method_36456(factorValue2);
        SharedKt.getPlayer().method_36457(factorValue3);
    }

    private boolean checkCondition(int arg0, char arg1, int arg2) {
        if (arg1 >= 0) {
            if (var12 == null) {
            }
        }
        if (arg2 >= 0) {
            if (var12 == null) {
            }
        }
        if (arg2 > 0) {
            if (var12 == null) {
            }
        }
        if (arg0 > 0) {
            if (var12 == null) {
            }
        }
        if (var12 == null) {
            if (moveFixServiceComponent2 != null && MoveFixModule.INSTANCE.getEnabled() && moveFixServiceComponent2.getOptionMode18() != OptionMode18.FORCE && MoveFixModule.INSTANCE.getMode() != MoveFixMode.FOCUS && !(SharedKt.getPlayer().method_3144()) && !(SharedKt.getPlayer().method_5681()) && !(FreeCamModule.INSTANCE.getEnabled()) && !(FreeLookModule.INSTANCE.getEnabled()) && !(ElytraRecastModule.INSTANCE.getEnabled())) {
            }
        } else {
        }
        return false;
    }

    private boolean checkCondition(int arg0, byte arg1, int arg2) {
        if (arg0 >= 0) {
            if (!(MoveFixModule.INSTANCE.getEnabled())) {
                if (arg2 > 0) {
                    if (var12 == null) {
                        if (arg0 >= 0) {
                            if (MoveFixModule.INSTANCE.getEnabled()) {
                                if (MoveFixModule.INSTANCE.getMode() != MoveFixMode.FOCUS) {
                                }
                            }
                        }
                    }
                    if (!(ElytraTargetModule.INSTANCE.getEnabled())) {
                        if (arg0 >= 0) {
                            if (!(MaceElytraTargetModule.INSTANCE.getEnabled())) {
                                if (moveFixServiceComponent2.getOptionMode18() != OptionMode18.FORCE) {
                                    if (arg0 > 0) {
                                        if (!(SharedKt.getPlayer().method_3144())) {
                                            if (arg1 > 0) {
                                                if (!(SharedKt.getPlayer().isFallFlying())) {
                                                    if (arg1 > 0) {
                                                        if (var12 == null) {
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
            if (var12 == null) {
            }
        }
        if (arg1 > 0) {
            if (var12 == null) {
            }
        }
        return !(ElytraRecastModule.INSTANCE.getEnabled());
    }

    private void onEventPlayerTravel(EventPlayerTravel arg0) {
        if (var11 == null) {
            moveFixServiceComponent5 = new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455());
        }
        if (var11 == null) {
            if (moveFixServiceComponent2 != null) {
            } else {
                moveFixServiceComponent2.getNumericValue();
            }
        }
        SharedKt.getPlayer().method_36456(0.0F);
        if (var11 == null) {
            if (moveFixServiceComponent2 != null) {
            } else {
                moveFixServiceComponent2.getNumericValue2();
            }
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
        MoveFixServiceComponent var14 = moveFixServiceComponent3;
        MoveFixServiceComponent var15 = moveFixServiceComponent4;
        SharedKt.getPlayer().method_36456(PolygonShaderComponent.INSTANCE.computeValue(var15.getNumericValue(), var14.getNumericValue(), TextShaderComponent2.INSTANCE.computeValue()));
        SharedKt.getPlayer().method_36457(PolygonShaderComponent.INSTANCE.computeValue(var15.getNumericValue2(), var14.getNumericValue2(), TextShaderComponent2.INSTANCE.computeValue()));
    }

    public float computeValue() {
        if (var3 == null) {
            if (moveFixServiceComponent2 != null) {
            } else {
                moveFixServiceComponent2.getNumericValue();
            }
        }
        return 0.0F;
    }

    public void executeAction(float yaw, float pitch) {
        ClientPlayerEntity player = SharedKt.getPlayer();
        int var8 = 0;
        player.field_3944.method_52787((Packet) new class_2830(player.getX(), player.getY(), player.getZ(), yaw, pitch, player.isOnGround(), player.field_5976));
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Vec3d to) {
        double var15 = class_3532.method_15338(((Math.toDegrees(Math.atan2((to.field_1350 - SharedKt.getPlayer().getZ()), (to.field_1352 - SharedKt.getPlayer().getX()))) - 90) - EventPacketHelper2.INSTANCE.computeValue()));
        double var17 = (Math.toDegrees(Math.atan2((to.field_1351 - (AntiKnockBackModule.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((to.field_1352 - SharedKt.getPlayer().getX()), (to.field_1350 - SharedKt.getPlayer().getZ())))) - EventPacketHelper2.INSTANCE.computeValue2());
        float var19 = (EventPacketHelper2.INSTANCE.computeValue() + var15);
        float var21 = (EventPacketHelper2.INSTANCE.computeValue2() + var17);
        return new MoveFixServiceComponent();
    }

    private Vec3d resolveMinecraftObject(float arg0, Vec3d arg1, float arg2) {
        double var7 = arg1.method_1027();
        if (var7 < 1.0E-7D) {
            return Vec3d.ZERO;
        }
        if (var7 > 1.0D) {
        } else {
        }
        Vec3d vec = arg1.method_1021(arg2);
        double var10 = Math.sin((arg0 * 0.017453292F));
        double var11 = Math.cos((arg0 * 0.017453292F));
        return new Vec3d(((vec.field_1352 * var11) - (vec.field_1350 * var10)), vec.field_1351, ((vec.field_1350 * var11) + (vec.field_1352 * var10)));
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
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        INSTANCE = new SequenceServiceComponent();
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        moveFixServiceComponent = new MoveFixServiceComponent(0.0F, 0.0F);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
