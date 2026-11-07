package su.catlean.client.services.player;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.network.DisconnectEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.world.EntityRemove;
import su.catlean.client.features.modules.movement.basic.AntiKnockBackModule;

public class PlayerEntityHelper2 implements Contract9 {

    public static final PlayerEntityHelper2 INSTANCE;
    public static final double preciseValue = -0.0784D;
    public static final double preciseValue2 = 0.2837D;
    public static final double preciseValue3 = 0.08511D;
    public static final double preciseValue4 = 0.45392000000000005D;
    public static final double preciseValue5 = 0.056740000000000006D;
    private static final Map lookupMap;
    private static int[] countValueArray;

    private PlayerEntityHelper2() {
    }

    public Map getMap() {
        return lookupMap;
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        lookupMap.clear();
        Iterator iterator = SharedKt.getWorld().getPlayers().iterator();
        while (iterator.hasNext()) {
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) iterator.next();
            lookupMap.put(Integer.valueOf(player.method_5628()), new TargetEntityHelper12((PlayerEntity) player));
            if (var11 != null) {
                if ((TargetEntityHelper12) lookupMap.get(Integer.valueOf(player.method_5628())) != null) {
                    (TargetEntityHelper12) lookupMap.get(Integer.valueOf(player.method_5628())).executeAction();
                }
            }
        }
    }

    private void onEntityRemove(EntityRemove arg0) {
        Map var4 = lookupMap;
        Object var5 = var4;
        int var6 = 0;
        var6 = (TargetEntityHelper12) lookupMap.remove(Integer.valueOf(arg0.getEntity().method_5628()));
        Object var7 = var5;
    }

    private void onDisconnectEvent(DisconnectEvent arg0) {
        lookupMap.clear();
    }

    public Vec3d predictPosition(PlayerEntity player, int ticks) {
        return this.predictPosition(player, ticks).method_1005().method_1031(0.0D, (player.method_5829().method_17940() / 2.0D), 0.0D);
    }

    public Box predictPosition(PlayerEntity player, int ticks) {
        if (var5 != null) {
            if (lookupMap.containsKey(Integer.valueOf(player.method_5628()))) {
            }
        }
        return player.method_5829();
        if (var5 != null) {
            if ((TargetEntityHelper12) lookupMap.get(Integer.valueOf(player.method_5628())) != null && (TargetEntityHelper12) lookupMap.get(Integer.valueOf(player.method_5628())).getArrayList() != null) {
            }
            if (var5 == null) {
            }
        }
        List positions = CollectionsKt.emptyList();
        if (var5 != null) {
            if (positions.isEmpty()) {
                return player.method_5829();
            }
        }
        return (Box) positions.get(Math.min(ticks, (positions.size() - 1)));
    }

    public Vec3d predictPosition(PlayerEntity entity, int ticks) {
        Vec3d vec = AntiKnockBackModule.INSTANCE.resolveMinecraftObject(entity);
        double var15 = (entity.getX() - entity.field_6014);
        double var17 = (entity.getY() - entity.field_6036);
        double var19 = (entity.getZ() - entity.field_5969);
        int var21 = 0;
        if (var21 < ticks) {
            if (var15 > 0.0D) {
            } else {
            }
            float var22 = -0.3F;
            if (var19 > 0.0D) {
            } else {
            }
            float var23 = -0.3F;
            if (var13 != null) {
                if (SharedKt.getWorld().method_22347(BlockPos.ofFloored(vec.method_1031((var15 + var22), 0.25D, (var19 + var23))))) {
                    if (0L >= 0) {
                        if (!(SharedKt.getWorld().method_22347(BlockPos.ofFloored(vec.method_1031((var15 + var22), 1.0D, (var19 + var23)))))) {
                        }
                        var15 = 0.0D;
                    }
                    var19 = 0.0D;
                }
                vec = vec.method_1031(0.0D);
            }
        }
        return vec;
    }

    static {
        INSTANCE = new PlayerEntityHelper2();
        lookupMap = Collections.synchronizedMap((Map) new HashMap());
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
