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
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) iterator.next());
            lookupMap.put(Integer.valueOf(player.method_5628()), new TargetEntityHelper12(((PlayerEntity) player)));
            if (__UNDEF_KEY__ != null) {
                if (((TargetEntityHelper12) lookupMap.get(Integer.valueOf(player.method_5628()))) != null) {
                    ((TargetEntityHelper12) lookupMap.get(Integer.valueOf(player.method_5628()))).executeAction();
                }
            }
        }
    }

    private void onEntityRemove(EntityRemove arg0) {
    }

    private void onDisconnectEvent(DisconnectEvent arg0) {
        lookupMap.clear();
    }

    public Vec3d predictPosition(PlayerEntity player, int ticks) {
        return this.predictPosition(player, ticks).method_1005().method_1031(0.0D, (player.method_5829().method_17940() / 2.0D), 0.0D);
    }

    public Box predictPosition(PlayerEntity player, int ticks) {
        if (lookupMap.containsKey(Integer.valueOf(player.method_5628()))) {
        }
        return player.method_5829();
        if (((TargetEntityHelper12) lookupMap.get(Integer.valueOf(player.method_5628()))) != null && ((TargetEntityHelper12) lookupMap.get(Integer.valueOf(player.method_5628()))).getArrayList() != null) {
        }
        List list = CollectionsKt.emptyList();
        if (list.isEmpty()) {
            return player.method_5829();
        }
        return ((Box) list.get(Math.min(ticks, (list.size() - 1))));
    }

    public Vec3d predictPosition(PlayerEntity entity, int ticks) {
        Vec3d vec = AntiKnockBackModule.INSTANCE.resolveMinecraftObject(entity);
        double offset = (entity.getX() - entity.field_6014);
        double offset2 = (entity.getZ() - entity.field_5969);
        int index = 0;
        if (index < ticks) {
            if (offset > 0.0D) {
            } else {
            }
            float factor = -0.3F;
            if (offset2 > 0.0D) {
            } else {
            }
            float factor2 = -0.3F;
            if (__UNDEF_KEY__ != null) {
                if (SharedKt.getWorld().method_22347(BlockPos.ofFloored(vec.method_1031((offset + factor), 0.25D, (offset2 + factor2))))) {
                    if (__UNDEF_KEY__ >= 0) {
                        if (!(SharedKt.getWorld().method_22347(BlockPos.ofFloored(vec.method_1031((offset + factor), 1.0D, (offset2 + factor2)))))) {
                            offset = 0.0D;
                            offset2 = 0.0D;
                        }
                        vec = vec.method_1031(offset, 0.0D, offset2);
                    }
                }
            }
        }
        return vec;
    }

    static {
        INSTANCE = new PlayerEntityHelper2();
        lookupMap = Collections.synchronizedMap(((Map) new HashMap()));
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
