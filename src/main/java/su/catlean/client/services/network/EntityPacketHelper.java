package su.catlean.client.services.network;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2561;
import net.minecraft.class_2663;
import net.minecraft.class_3532;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.World;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.PlayerEntityDeathEvent;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalTargetSortMode;
import su.catlean.client.features.modules.utility.misc.NotifierModule;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.tools.comparators.Comparator14;
import su.catlean.client.types.mappings.AutoCrystalTargetSortModeWhenMappings;

public class EntityPacketHelper {

    public static final EntityPacketHelper INSTANCE;
    private static final Map lookupMap;
    private static final Map lookupMap2;
    private static boolean enabledFlag;

    private EntityPacketHelper() {
    }

    private void onReceivePacket(ReceivePacket arg0) {
        Packet var13 = arg0.getPacket();
        if (var12 != null) {
            if (var12 != null) {
            }
        }
        Entity entity = (class_2663) var13.method_11469((World) SharedKt.getWorld());
        if (var12 != null) {
            if (entity instanceof PlayerEntity) {
            }
        } else {
        }
        if (null == null) {
            return;
        }
        PlayerEntity player = (PlayerEntity) entity;
        if (Intrinsics.areEqual(player, SharedKt.getMc().player)) {
            return;
        }
        Map var15 = lookupMap;
        entity = player.method_5477().getString();
        Integer var17 = Integer.valueOf(((Number) lookupMap.getOrDefault(player.method_5477().getString(), Integer.valueOf(0)) + 1));
        var15.put(entity);
        if (var12 != null) {
        }
        NotifierModule.INSTANCE.executeAction(player.method_5477().getString(), (Number) lookupMap.getOrDefault(player.method_5477().getString(), Integer.valueOf(0)));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterable var9 = (Iterable) SharedKt.getWorld().getPlayers();
        int var10 = 0;
        Object var11 = var9;
        Collection var12 = (Collection) new ArrayList();
        int var13 = 0;
        Iterator iterator = var11.iterator();
        if (iterator.hasNext()) {
            Object var15 = iterator.next();
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) var15;
            int var17 = 0;
            if (var8 != null) {
                if (player.method_6032() > 0.0F) {
                    if (player.isAlive()) {
                        if (var8 != null && var8 != null && var8 != null) {
                        }
                    }
                }
                if (var8 != null) {
                }
                if (var8 != null) {
                    if (player.method_29504() && !(Intrinsics.areEqual(player, SharedKt.getPlayer())) && !(lookupMap2.containsKey(player.method_5477().getString()))) {
                    }
                } else {
                }
                var12.add();
            }
            var9 = (Iterable) var12;
        }
        var10 = 0;
        var11 = var9.iterator();
        if (var11.hasNext()) {
            var12 = var11.next();
            var13 = (AbstractClientPlayerEntity) var12;
            iterator = 0;
            var15 = PlayerEntityDeathEvent.INSTANCE;
            player = var15;
            var17 = 0;
            player.setPlayer((PlayerEntity) var13);
            player.setTotemsPopped((Number) lookupMap.getOrDefault(var13.method_5477().getString(), Integer.valueOf(0)));
            var15.call();
            lookupMap2.put(var13.method_5477().getString(), Long.valueOf(SharedKt.getNumericValue()));
            lookupMap.remove(var13.method_5477().getString());
            if (var8 != null) {
            }
        }
        var9 = new ArrayList();
        var10 = lookupMap2;
        var11 = 0;
        var12 = var10.entrySet().iterator();
        if (var12.hasNext()) {
            var13 = (Entry) var12.next();
            iterator = var13;
            var15 = 0;
            player = (String) iterator.getKey();
            var17 = (Number) iterator.getValue().longValue();
            if (var8 != null) {
                if (var8 != null) {
                    if ((SharedKt.getNumericValue() - var17) > timestampValue) {
                        var9.add(player);
                    }
                }
            }
        }
        var10 = (Iterable) var9;
        var11 = 0;
        var12 = var10.iterator();
        if (var12.hasNext()) {
            var13 = var12.next();
            iterator = (String) var13;
            var15 = 0;
            lookupMap2.remove(iterator);
        }
    }

    public int computeValue(PlayerEntity entity) {
        return this.computeValue(entity.method_5477().getString());
    }

    public int computeValue(String name) {
        if (var4 != null) {
            if ((Integer) lookupMap.get(name) != null) {
            }
        }
        return 0;
    }

    public PlayerEntity findTarget(float range, AutoCrystalTargetSortMode targetBy, boolean ignoreNaked, boolean ignoreCreative) {
        return new NoWhenBranchMatchedException();
    }

    public static PlayerEntity findTarget(EntityPacketHelper arg0, float arg1, AutoCrystalTargetSortMode arg2, boolean arg3, boolean arg4, int arg5, Object arg6) {
        if (var14 != null) {
            if ((arg5 & 4)) {
                arg3 = 0;
            }
        }
        if (var14 != null) {
            if ((arg5 & 8)) {
            }
            arg4 = 0;
        }
        return arg0.findTarget(arg1, arg2, arg3, arg4);
    }

    private List resolveList(int arg0, byte arg1, float arg2, int arg3, boolean arg4, boolean arg5) {
        Iterable var16 = (Iterable) SharedKt.getWorld().getPlayers();
        int var17 = 0;
        Object var18 = var16;
        Collection var19 = (Collection) new ArrayList();
        int var20 = 0;
        Iterator iterator = var18.iterator();
        if (iterator.hasNext()) {
            Object var22 = iterator.next();
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) var22;
            int var24 = 0;
            if (arg0 > 0) {
                if (var15 != null) {
                    if (arg1 <= 0) {
                        if (var15 != null) {
                        }
                    }
                    if (arg0 >= 0) {
                        if (var15 != null) {
                        }
                    }
                    if (arg0 >= 0) {
                        if (var15 != null) {
                        }
                    }
                    if (arg1 <= 0) {
                        if (var15 != null) {
                        }
                    }
                    if (var15 != null) {
                        if (arg4) {
                            if (arg1 <= 0) {
                                if (var15 != null) {
                                }
                            }
                        }
                    }
                    if (var15 != null) {
                        if (arg5) {
                            if (var15 != null) {
                                if (!(player.method_29504()) && !(EntityHelper4.isFriend((PlayerEntity) player)) && !(Intrinsics.areEqual(player, SharedKt.getPlayer())) && SharedKt.getPlayer().distanceTo(player) < arg2 && player.method_6096() > 0 && !(player.method_68878())) {
                                }
                            }
                        }
                    } else {
                    }
                    var19.add();
                }
                var16 = (Iterable) var19;
                if (arg3 > 0) {
                }
                var17 = 0;
            }
        }
        return CollectionsKt.sortedWith((Comparator) new Comparator14());
    }

    private static List resolveList(EntityPacketHelper arg0, float arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        if (var13 != null) {
            if ((arg4 & 2)) {
                arg2 = 0;
            }
        }
        if (var13 != null) {
            if ((arg4 & 4)) {
            }
            arg3 = 0;
        }
        return arg0.resolveList(arg1, arg2, arg3);
    }

    public PlayerEntity findTarget(float range, boolean ignoreNaked, boolean ignoreCreative) {
        Iterable var12 = (Iterable) this.resolveList(range, ignoreNaked, ignoreCreative);
        int var13 = 0;
        Iterator iterator = var12.iterator();
        if (var11 != null) {
            if (!(iterator.hasNext())) {
            }
        }
        Object var15 = iterator.next();
        if (var11 != null) {
            if (!(iterator.hasNext())) {
            }
        }
        PlayerEntity player = (PlayerEntity) var15;
        int var17 = 0;
        player = SharedKt.getPlayer().distanceTo(player);
        var17 = iterator.next();
        PlayerEntity player2 = (PlayerEntity) var17;
        int var19 = 0;
        player2 = SharedKt.getPlayer().distanceTo(player2);
        if (Float.compare(player, player2) > 0) {
            var15 = var17;
            player = player2;
        }
        return (PlayerEntity) var15;
    }

    public static PlayerEntity findTarget(EntityPacketHelper arg0, float arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        if (var13 != null) {
            if ((arg4 & 2)) {
                arg2 = 0;
            }
        }
        if (var13 != null) {
            if ((arg4 & 4)) {
            }
            arg3 = 0;
        }
        return arg0.findTarget(arg1, arg2, arg3);
    }

    public PlayerEntity findTarget(float range, boolean ignoreNaked, boolean ignoreCreative) {
        Iterable var10 = (Iterable) this.resolveList(range, ignoreNaked, ignoreCreative);
        int var11 = 0;
        Iterator iterator = var10.iterator();
        if (var9 != null) {
            if (!(iterator.hasNext())) {
            }
        }
        Object var13 = iterator.next();
        if (var9 != null) {
            if (!(iterator.hasNext())) {
            }
        }
        PlayerEntity player = (PlayerEntity) var13;
        int var15 = 0;
        player = (player.method_6032() + player.method_6067());
        var15 = iterator.next();
        PlayerEntity player2 = (PlayerEntity) var15;
        int var17 = 0;
        player2 = (player2.method_6032() + player2.method_6067());
        if (Float.compare(player, player2) > 0) {
            var13 = var15;
            player = player2;
        }
        return (PlayerEntity) var13;
    }

    public static PlayerEntity findTarget(EntityPacketHelper arg0, float arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        if (var10 != null) {
            if ((arg4 & 2)) {
                arg2 = 0;
            }
        }
        if (var10 != null) {
            if ((arg4 & 4)) {
            }
            arg3 = 0;
        }
        return arg0.findTarget(arg1, arg2, arg3);
    }

    public PlayerEntity findTarget(float range, boolean ignoreNaked, boolean ignoreCreative) {
        Iterable var12 = (Iterable) this.resolveList(range, ignoreNaked, ignoreCreative);
        int var13 = 0;
        Iterator iterator = var12.iterator();
        if (var11 != null) {
            if (!(iterator.hasNext())) {
            }
        }
        Object var15 = iterator.next();
        if (var11 != null) {
            if (!(iterator.hasNext())) {
            }
        }
        PlayerEntity player = (PlayerEntity) var15;
        int var17 = 0;
        player = INSTANCE.computeValue((LivingEntity) player);
        var17 = iterator.next();
        PlayerEntity player2 = (PlayerEntity) var17;
        int var19 = 0;
        player2 = INSTANCE.computeValue((LivingEntity) player2);
        if (Float.compare(player, player2) > 0) {
            var15 = var17;
            player = player2;
        }
        return (PlayerEntity) var15;
    }

    public static PlayerEntity resolveMinecraftObject2(EntityPacketHelper arg0, float arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        if (var10 != null) {
            if ((arg4 & 2)) {
                arg2 = 0;
            }
        }
        if (var10 != null) {
            if ((arg4 & 4)) {
            }
            arg3 = 0;
        }
        return arg0.findTarget(arg1, arg2, arg3);
    }

    public PlayerEntity findTarget(float range, float fov) {
        Iterable var13 = (Iterable) resolveList(this, range);
        int var14 = 0;
        Object var15 = var13;
        Collection var16 = (Collection) new ArrayList();
        int var17 = 0;
        Iterator iterator = var15.iterator();
        if (iterator.hasNext()) {
            Object var19 = iterator.next();
            PlayerEntity player = (PlayerEntity) var19;
            int var21 = 0;
            if (0L >= 0) {
                if (var12 != null) {
                    if (var12 != null) {
                        if (INSTANCE.computeValue((LivingEntity) player) < fov) {
                        }
                    } else {
                    }
                    var16.add();
                }
                var13 = (Iterable) var16;
                if (0L < 0) {
                }
                var14 = 0;
            }
        }
        var15 = var13.iterator();
        if (0L >= 0 && var12 != null) {
            if (!(var15.hasNext())) {
            }
            var16 = var15.next();
            if (var12 != null) {
            }
            if (!(var15.hasNext())) {
            }
        }
        var17 = (PlayerEntity) var16;
        iterator = 0;
        var17 = INSTANCE.computeValue((LivingEntity) var17);
        iterator = var15.next();
        var19 = (PlayerEntity) iterator;
        player = 0;
        var19 = INSTANCE.computeValue((LivingEntity) var19);
        if (Float.compare() > 0) {
            var16 = iterator;
            var17 = var19;
        }
        return (PlayerEntity) var16;
    }

    public PlayerEntity findTarget(float range, AutoCrystalTargetSortMode targetBy, Function1 predicate) {
        return new NoWhenBranchMatchedException();
    }

    public PlayerEntity findTarget(float range, Function1 predicate) {
        Iterable var10 = (Iterable) resolveList(this, range);
        int var11 = 0;
        Object var12 = var10;
        Collection var13 = (Collection) new ArrayList();
        int var14 = 0;
        Iterator iterator = var12.iterator();
        if (iterator.hasNext()) {
            Object var16 = iterator.next();
            if (var9 != null) {
                if (var9 != null) {
                }
                var13.add();
            }
            var10 = (Iterable) var13;
        }
        var11 = 0;
        var12 = var10.iterator();
        if (var9 != null) {
            if (!(var12.hasNext())) {
            }
            var13 = var12.next();
            if (var9 != null) {
            }
            if (!(var12.hasNext())) {
            }
        }
        var14 = (PlayerEntity) var13;
        iterator = 0;
        var14 = SharedKt.getPlayer().distanceTo();
        iterator = var12.next();
        var16 = (PlayerEntity) iterator;
        int var17 = 0;
        var16 = SharedKt.getPlayer().distanceTo();
        if (Float.compare() > 0) {
            var13 = iterator;
            var14 = var16;
        }
        return (PlayerEntity) var13;
    }

    public PlayerEntity resolveMinecraftObject2(float range, Function1 predicate) {
        Iterable var8 = (Iterable) resolveList(this, range);
        int var9 = 0;
        Object var10 = var8;
        Collection var11 = (Collection) new ArrayList();
        int var12 = 0;
        Iterator iterator = var10.iterator();
        if (iterator.hasNext()) {
            Object var14 = iterator.next();
            if (var7 != null) {
                if (var7 != null) {
                }
                var11.add();
            }
            var8 = (Iterable) var11;
        }
        var9 = 0;
        var10 = var8.iterator();
        if (var7 != null) {
            if (!(var10.hasNext())) {
            }
            var11 = var10.next();
            if (var7 != null) {
            }
            if (!(var10.hasNext())) {
            }
        }
        var12 = (PlayerEntity) var11;
        iterator = 0;
        var12 = (var12.method_6032() + var12.method_6067());
        iterator = var10.next();
        var14 = (PlayerEntity) iterator;
        int var15 = 0;
        var14 = (var14.method_6032() + var14.method_6067());
        if (Float.compare() > 0) {
            var11 = iterator;
            var12 = var14;
        }
        return (PlayerEntity) var11;
    }

    public PlayerEntity resolveMinecraftObject3(float range, Function1 predicate) {
        Iterable var10 = (Iterable) resolveList(this, range);
        int var11 = 0;
        Object var12 = var10;
        Collection var13 = (Collection) new ArrayList();
        int var14 = 0;
        Iterator iterator = var12.iterator();
        if (iterator.hasNext()) {
            Object var16 = iterator.next();
            if (var9 != null) {
                if (var9 != null) {
                }
                var13.add();
            }
            var10 = (Iterable) var13;
        }
        var11 = 0;
        var12 = var10.iterator();
        if (var9 != null) {
            if (!(var12.hasNext())) {
            }
            var13 = var12.next();
            if (var9 != null) {
            }
            if (!(var12.hasNext())) {
            }
        }
        var14 = (PlayerEntity) var13;
        iterator = 0;
        var14 = INSTANCE.computeValue((LivingEntity) var14);
        iterator = var12.next();
        var16 = (PlayerEntity) iterator;
        int var17 = 0;
        var16 = INSTANCE.computeValue((LivingEntity) var16);
        if (Float.compare() > 0) {
            var13 = iterator;
            var14 = var16;
        }
        return (PlayerEntity) var13;
    }

    private float computeValue(LivingEntity arg0) {
        return Math.abs((class_3532.method_15338((Math.toDegrees(Math.atan2((arg0.getZ() - SharedKt.getPlayer().getZ()), (arg0.getX() - SharedKt.getPlayer().getX()))) - 90.0D)) - class_3532.method_15393(SharedKt.getPlayer().method_36454())));
    }

    static {
        INSTANCE = new EntityPacketHelper();
        lookupMap = (Map) new LinkedHashMap();
        lookupMap2 = (Map) new LinkedHashMap();
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        boolean var0 = isActive();
        if (!(var0)) {
            return true;
        }
        return false;
    }

}
