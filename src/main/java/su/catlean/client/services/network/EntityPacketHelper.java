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
        Packet packet = arg0.getPacket();
        if (__UNDEF_KEY__ != null) {
            if (__UNDEF_KEY__ != null) {
            }
        }
        Entity entity = ((class_2663) packet).method_11469(((World) SharedKt.getWorld()));
        if (__UNDEF_KEY__ != null) {
            if (entity instanceof PlayerEntity) {
            } else {
            }
        }
        if (null == null) {
            return;
        }
        PlayerEntity player = ((PlayerEntity) entity);
        if (Intrinsics.areEqual(player, SharedKt.getMc().player)) {
            return;
        }
        entity = player.method_5477().getString();
        Integer integer = Integer.valueOf((((Number) lookupMap.getOrDefault(player.method_5477().getString(), Integer.valueOf(0))) + 1));
        lookupMap.put(entity, integer);
        if (__UNDEF_KEY__ != null) {
        }
        NotifierModule.INSTANCE.executeAction(player.method_5477().getString(), ((Number) lookupMap.getOrDefault(player.method_5477().getString(), Integer.valueOf(0))));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterable iterable = ((Iterable) SharedKt.getWorld().getPlayers());
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) element);
            int index3 = 0;
            if (__UNDEF_KEY__ != null) {
                if (player.method_6032() > 0.0F) {
                    if (player.isAlive()) {
                        if (__UNDEF_KEY__ != null && __UNDEF_KEY__ != null && __UNDEF_KEY__ != null) {
                        }
                    }
                }
                if (__UNDEF_KEY__ != null) {
                }
                if (__UNDEF_KEY__ != null) {
                    if (player.method_29504() && !(Intrinsics.areEqual(player, SharedKt.getPlayer())) && !(lookupMap2.containsKey(player.method_5477().getString()))) {
                    } else {
                    }
                }
                collection.add(element);
                iterable = ((Iterable) collection);
            }
        }
        index = 0;
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index2 = ((AbstractClientPlayerEntity) collection);
            iterator = 0;
            element = PlayerEntityDeathEvent.INSTANCE;
            player = element;
            index3 = 0;
            player.setPlayer(((PlayerEntity) index2));
            player.setTotemsPopped(((Number) lookupMap.getOrDefault(index2.method_5477().getString(), Integer.valueOf(0))));
            element.call();
            lookupMap2.put(index2.method_5477().getString(), Long.valueOf(SharedKt.getNumericValue()));
            lookupMap.remove(index2.method_5477().getString());
            if (__UNDEF_KEY__ != null) {
            }
        }
        iterable = new ArrayList();
        index = lookupMap2;
        iterable2 = 0;
        collection = index.entrySet().iterator();
        while (collection.hasNext()) {
            index2 = ((Entry) collection.next());
            iterator = index2;
            element = 0;
            player = ((String) iterator.getKey());
            index3 = ((Number) iterator.getValue()).longValue();
            if (__UNDEF_KEY__ != null) {
                if (__UNDEF_KEY__ != null) {
                    if ((SharedKt.getNumericValue() - index3) > timestampValue) {
                        iterable.add(player);
                    }
                }
            }
        }
        index = ((Iterable) iterable);
        iterable2 = 0;
        collection = index.iterator();
        while (collection.hasNext()) {
            index2 = collection.next();
            iterator = ((String) index2);
            element = 0;
            lookupMap2.remove(iterator);
        }
    }

    public int computeValue(PlayerEntity entity) {
        return this.computeValue(entity.method_5477().getString());
    }

    public int computeValue(String name) {
        if (__UNDEF_KEY__ != null) {
            if (((Integer) lookupMap.get(name)) != null) {
            }
        }
        return 0;
    }

    public PlayerEntity findTarget(float range, AutoCrystalTargetSortMode targetBy, boolean ignoreNaked, boolean ignoreCreative) {
        return new NoWhenBranchMatchedException();
    }

    public static PlayerEntity findTarget(EntityPacketHelper arg0, float arg1, AutoCrystalTargetSortMode arg2, boolean arg3, boolean arg4, int arg5, Object arg6) {
        arg3 = 0;
        arg4 = 0;
        return arg0.findTarget(arg1, arg2, arg3, arg4);
    }

    private List resolveList(int arg0, byte arg1, float arg2, int arg3, boolean arg4, boolean arg5) {
        Iterable iterable = ((Iterable) SharedKt.getWorld().getPlayers());
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) element);
            if (arg0 > 0) {
                if (__UNDEF_KEY__ != null) {
                    if (arg1 <= 0) {
                        if (__UNDEF_KEY__ != null) {
                        }
                    }
                    if (arg0 >= 0) {
                        if (__UNDEF_KEY__ != null) {
                        }
                    }
                    if (arg0 >= 0) {
                        if (__UNDEF_KEY__ != null) {
                        }
                    }
                    if (arg1 <= 0) {
                        if (__UNDEF_KEY__ != null) {
                        }
                    }
                    if (__UNDEF_KEY__ != null) {
                        if (arg4) {
                            if (arg1 <= 0) {
                                if (__UNDEF_KEY__ != null) {
                                }
                            }
                        }
                    }
                    if (__UNDEF_KEY__ != null) {
                        if (arg5) {
                            if (__UNDEF_KEY__ != null) {
                                if (!(player.method_29504()) && !(EntityHelper4.isFriend(((PlayerEntity) player))) && !(Intrinsics.areEqual(player, SharedKt.getPlayer())) && SharedKt.getPlayer().distanceTo(player) < arg2 && player.method_6096() > 0 && !(player.method_68878())) {
                                } else {
                                }
                            }
                        }
                    }
                    collection.add(element);
                    iterable = ((Iterable) collection);
                    if (arg3 > 0) {
                    }
                }
            }
        }
        return CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator14()));
    }

    private static List resolveList(EntityPacketHelper arg0, float arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        arg2 = 0;
        arg3 = 0;
        return arg0.resolveList(arg1, arg2, arg3);
    }

    public PlayerEntity findTarget(float range, boolean ignoreNaked, boolean ignoreCreative) {
        Iterable iterable = ((Iterable) this.resolveList(range, ignoreNaked, ignoreCreative));
        Iterator iterator = iterable.iterator();
        if (__UNDEF_KEY__ != null) {
            if (!(iterator.hasNext())) {
            }
        }
        Object element = iterator.next();
        if (__UNDEF_KEY__ != null) {
            if (!(iterator.hasNext())) {
            }
        }
        PlayerEntity player = ((PlayerEntity) element);
        int index = 0;
        player = SharedKt.getPlayer().distanceTo(player);
        index = iterator.next();
        PlayerEntity player2 = ((PlayerEntity) index);
        player2 = SharedKt.getPlayer().distanceTo(player2);
        if (Float.compare(player, player2) > 0) {
            element = index;
            player = player2;
        }
        return ((PlayerEntity) element);
    }

    public static PlayerEntity findTarget(EntityPacketHelper arg0, float arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        arg2 = 0;
        arg3 = 0;
        return arg0.findTarget(arg1, arg2, arg3);
    }

    public PlayerEntity findTarget(float range, boolean ignoreNaked, boolean ignoreCreative) {
        Iterable iterable = ((Iterable) this.resolveList(range, ignoreNaked, ignoreCreative));
        Iterator iterator = iterable.iterator();
        if (__UNDEF_KEY__ != null) {
            if (!(iterator.hasNext())) {
            }
        }
        Object element = iterator.next();
        if (__UNDEF_KEY__ != null) {
            if (!(iterator.hasNext())) {
            }
        }
        PlayerEntity player = ((PlayerEntity) element);
        int index = 0;
        player = (player.method_6032() + player.method_6067());
        index = iterator.next();
        PlayerEntity player2 = ((PlayerEntity) index);
        player2 = (player2.method_6032() + player2.method_6067());
        if (Float.compare(player, player2) > 0) {
            element = index;
            player = player2;
        }
        return ((PlayerEntity) element);
    }

    public static PlayerEntity findTarget(EntityPacketHelper arg0, float arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        arg2 = 0;
        arg3 = 0;
        return arg0.findTarget(arg1, arg2, arg3);
    }

    public PlayerEntity findTarget(float range, boolean ignoreNaked, boolean ignoreCreative) {
        Iterable iterable = ((Iterable) this.resolveList(range, ignoreNaked, ignoreCreative));
        Iterator iterator = iterable.iterator();
        if (__UNDEF_KEY__ != null) {
            if (!(iterator.hasNext())) {
            }
        }
        Object element = iterator.next();
        if (__UNDEF_KEY__ != null) {
            if (!(iterator.hasNext())) {
            }
        }
        PlayerEntity player = ((PlayerEntity) element);
        int index = 0;
        player = INSTANCE.computeValue(((LivingEntity) player));
        index = iterator.next();
        PlayerEntity player2 = ((PlayerEntity) index);
        player2 = INSTANCE.computeValue(((LivingEntity) player2));
        if (Float.compare(player, player2) > 0) {
            element = index;
            player = player2;
        }
        return ((PlayerEntity) element);
    }

    public static PlayerEntity resolveMinecraftObject2(EntityPacketHelper arg0, float arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        arg2 = 0;
        arg3 = 0;
        return arg0.findTarget(arg1, arg2, arg3);
    }

    public PlayerEntity findTarget(float range, float fov) {
        Iterable iterable = ((Iterable) resolveList(this, range, false, false));
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            PlayerEntity player = ((PlayerEntity) element);
            if (__UNDEF_KEY__ >= 0) {
                if (__UNDEF_KEY__ != null) {
                    if (__UNDEF_KEY__ != null) {
                        if (INSTANCE.computeValue(((LivingEntity) player)) < fov) {
                        } else {
                        }
                    }
                    collection.add(element);
                    iterable = ((Iterable) collection);
                    if (__UNDEF_KEY__ < 0) {
                    }
                }
            }
        }
        iterable2 = iterable.iterator();
        if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ != null) {
            if (!(iterable2.hasNext())) {
            }
            collection = iterable2.next();
            if (__UNDEF_KEY__ != null) {
                if (!(iterable2.hasNext())) {
                }
            }
        }
        index = ((PlayerEntity) collection);
        iterator = 0;
        index = INSTANCE.computeValue(((LivingEntity) index));
        iterator = iterable2.next();
        element = ((PlayerEntity) iterator);
        player = 0;
        element = INSTANCE.computeValue(((LivingEntity) element));
        if (Float.compare(index, element) > 0) {
            collection = iterator;
            index = element;
        }
        return ((PlayerEntity) collection);
    }

    public PlayerEntity findTarget(float range, AutoCrystalTargetSortMode targetBy, Function1 predicate) {
        return new NoWhenBranchMatchedException();
    }

    public PlayerEntity findTarget(float range, Function1 predicate) {
        Iterable iterable = ((Iterable) resolveList(this, range, false, false));
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (__UNDEF_KEY__ != null) {
                if (__UNDEF_KEY__ != null) {
                }
                collection.add(element);
                iterable = ((Iterable) collection);
            }
        }
        iterable2 = iterable.iterator();
        if (__UNDEF_KEY__ != null) {
            if (!(iterable2.hasNext())) {
            }
            collection = iterable2.next();
            if (__UNDEF_KEY__ != null) {
                if (!(iterable2.hasNext())) {
                }
            }
        }
        index = ((PlayerEntity) collection);
        iterator = 0;
        index = SharedKt.getPlayer().distanceTo(index);
        iterator = iterable2.next();
        element = ((PlayerEntity) iterator);
        element = SharedKt.getPlayer().distanceTo(element);
        if (Float.compare(index, element) > 0) {
            collection = iterator;
            index = element;
        }
        return ((PlayerEntity) collection);
    }

    public PlayerEntity resolveMinecraftObject2(float range, Function1 predicate) {
        Iterable iterable = ((Iterable) resolveList(this, range, false, false));
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (__UNDEF_KEY__ != null) {
                if (__UNDEF_KEY__ != null) {
                }
                collection.add(element);
                iterable = ((Iterable) collection);
            }
        }
        iterable2 = iterable.iterator();
        if (__UNDEF_KEY__ != null) {
            if (!(iterable2.hasNext())) {
            }
            collection = iterable2.next();
            if (__UNDEF_KEY__ != null) {
                if (!(iterable2.hasNext())) {
                }
            }
        }
        index = ((PlayerEntity) collection);
        iterator = 0;
        index = (index.method_6032() + index.method_6067());
        iterator = iterable2.next();
        element = ((PlayerEntity) iterator);
        element = (element.method_6032() + element.method_6067());
        if (Float.compare(index, element) > 0) {
            collection = iterator;
            index = element;
        }
        return ((PlayerEntity) collection);
    }

    public PlayerEntity resolveMinecraftObject3(float range, Function1 predicate) {
        Iterable iterable = ((Iterable) resolveList(this, range, false, false));
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (__UNDEF_KEY__ != null) {
                if (__UNDEF_KEY__ != null) {
                }
                collection.add(element);
                iterable = ((Iterable) collection);
            }
        }
        iterable2 = iterable.iterator();
        if (__UNDEF_KEY__ != null) {
            if (!(iterable2.hasNext())) {
            }
            collection = iterable2.next();
            if (__UNDEF_KEY__ != null) {
                if (!(iterable2.hasNext())) {
                }
            }
        }
        index = ((PlayerEntity) collection);
        iterator = 0;
        index = INSTANCE.computeValue(((LivingEntity) index));
        iterator = iterable2.next();
        element = ((PlayerEntity) iterator);
        element = INSTANCE.computeValue(((LivingEntity) element));
        if (Float.compare(index, element) > 0) {
            collection = iterator;
            index = element;
        }
        return ((PlayerEntity) collection);
    }

    private float computeValue(LivingEntity arg0) {
        return Math.abs((class_3532.method_15338((Math.toDegrees(Math.atan2((arg0.getZ() - SharedKt.getPlayer().getZ()), (arg0.getX() - SharedKt.getPlayer().getX()))) - 90.0D)) - class_3532.method_15393(SharedKt.getPlayer().method_36454())));
    }

    static {
        INSTANCE = new EntityPacketHelper();
        lookupMap = ((Map) new LinkedHashMap());
        lookupMap2 = ((Map) new LinkedHashMap());
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        boolean flag = isActive();
        if (!(flag)) {
            return true;
        }
        return false;
    }

}
