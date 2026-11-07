package su.catlean.client.services.network;

import com.google.common.collect.Queues;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.class_10182;
import net.minecraft.class_10264;
import net.minecraft.class_2547;
import net.minecraft.class_2629;
import net.minecraft.class_2661;
import net.minecraft.class_2684;
import net.minecraft.class_2708;
import net.minecraft.class_2749;
import net.minecraft.class_2761;
import net.minecraft.class_2767;
import net.minecraft.class_2770;
import net.minecraft.class_2777;
import net.minecraft.class_2797;
import net.minecraft.class_5894;
import net.minecraft.class_7422;
import net.minecraft.class_7439;
import net.minecraft.class_7472;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.client.features.modules.movement.basic.AntiKnockBackModule;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class EventPacketHelper {

    public static final EventPacketHelper INSTANCE;
    private static final ConcurrentLinkedQueue concurrentLinkedQueue;
    private static final ConcurrentLinkedQueue concurrentLinkedQueue2;
    private static PlayerEntity playerEntity;
    private static Vec3d vec3d;
    private static Vec3d vec3d2;

    private EventPacketHelper() {
    }

    public PlayerEntity getMinecraftObject() {
        return playerEntity;
    }

    public void updateValue(PlayerEntity value) {
        playerEntity = value;
    }

    public void executeAction(Render3DEvent event) {
        Entity entity = playerEntity;
        if (playerEntity == null || vec3d == null || vec3d2 == null || AntiKnockBackModule.INSTANCE.resolveMinecraftObject(entity).method_1025(vec3d) < 1.0D) {
            return;
        }
        int var15 = 0;
        var15 = 360;
        if (var15 >= 180) {
        } else {
        }
        Vec3d vec = vec3d;
        Vec3d vec2 = vec3d2;
        Vec3d vec3 = TextShaderComponent2.INSTANCE.resolveMinecraftObject(vec2, vec, entity);
        int var17 = 0;
        TextShaderComponent2.INSTANCE.render(event.getStack(), vec3, playerEntity, (var15 / 360.0F), 1);
    }

    public void executeAction(ReceivePacket e) {
        if (playerEntity == null || !(playerEntity.isAlive())) {
            return;
        }
        Packet var15 = e.getPacket();
        Object var16 = var15;
        if (var16 instanceof class_2797 || var16 instanceof class_7439 || var16 instanceof class_2761 || var16 instanceof class_7472 || var16 instanceof class_2767 || var16 instanceof class_2770 || var16 instanceof class_5894 || var16 instanceof class_2749 || var16 instanceof class_2629) {
            return;
        }
        if (!(var16 instanceof class_2708)) {
            if (var16 instanceof class_2661) {
            }
            this.executeAction();
            return;
        }
        if (var15 instanceof class_2684) {
            class_7422 var17 = new class_7422();
            var17.method_43494(vec3d);
            var16 = var17.method_43489((class_2684) var15.method_36150(), (class_2684) var15.method_36151(), (class_2684) var15.method_36152());
            timestampValue = SharedKt.getNumericValue();
            return;
        }
        if (!(Intrinsics.areEqual((class_2684) var15.method_11645((World) SharedKt.getWorld()), playerEntity)) || var15 instanceof class_2777) {
            return;
        }
        if (var15 instanceof class_10264) {
            var17 = playerEntity;
            if (var17 != null) {
            } else {
            }
            var16 = (class_10264) var15.comp_3224().comp_3148();
            return;
        }
        if ((class_10264) var15.comp_3223() != var17.method_5628() || var16 != null) {
            return;
        }
        concurrentLinkedQueue.add(new PacketPacketHelper2(SharedKt.getNumericValue()));
        e.cancel();
    }

    public void updateValue() {
        if (!(var8)) {
        }
        if (!(var8)) {
        }
        if (!(var8)) {
            if (AuraModule.INSTANCE.getEnabled() && AuraModule.INSTANCE.getTarget() != null && AuraModule.INSTANCE.getTarget() instanceof PlayerEntity) {
            }
        } else {
        }
        if (!(var8)) {
            if (var9 == null) {
                this.executeAction();
                return;
            }
        }
        if (!(var8)) {
            if (!(Intrinsics.areEqual(playerEntity))) {
                this.executeAction();
                vec3d = AntiKnockBackModule.INSTANCE.resolveMinecraftObject();
            }
        }
        playerEntity = var9;
    }

    public void executeAction(short arg0, int arg1) {
        if (SharedKt.getMc().world != null) {
            if (var10 || arg1 >= 0) {
                return;
            }
        }
        if (!(var10)) {
        }
        if (arg1 >= 0) {
            if (SharedKt.getMc().player != null && playerEntity.isAlive()) {
                executeAction(this);
            }
            if (arg0 < 0) {
                if (var10) {
                }
                this.executeAction();
            }
        }
        concurrentLinkedQueue2.removeIf(this::checkCondition);
    }

    public void updateValue(boolean clear) {
        concurrentLinkedQueue.removeIf(this::checkCondition2);
    }

    public static void executeAction(EventPacketHelper arg0, boolean arg1, int arg2, Object arg3) {
        if ((arg2 & 1)) {
            arg1 = 0;
        }
        arg0.updateValue(arg1);
    }

    public void executeAction() {
        concurrentLinkedQueue.removeIf(this::checkCondition3);
        playerEntity = null;
        vec3d = null;
    }

    private static boolean handlePacket(Packet arg0) {
        EventPacketHelper var5 = INSTANCE;
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
            if (arg1.getNumericValue() <= (SharedKt.getNumericValue() - AuraModule.INSTANCE.getMoveDelay())) {
            }
        } else {
        }
        int var7 = 0;
        int var8 = var7;
        int var9 = 0;
        if (var8) {
            concurrentLinkedQueue2.add(arg1.getMinecraftObject());
        }
        return var7;
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static boolean checkCondition(PacketPacketHelper2 arg0) {
        EventPacketHelper var5 = INSTANCE;
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
        INSTANCE = new EventPacketHelper();
        concurrentLinkedQueue = Queues.newConcurrentLinkedQueue();
        concurrentLinkedQueue2 = Queues.newConcurrentLinkedQueue();
        timestampValue = SharedKt.getNumericValue();
    }

}
