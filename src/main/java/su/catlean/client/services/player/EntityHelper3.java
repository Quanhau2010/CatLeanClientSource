package su.catlean.client.services.player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;

public class EntityHelper3 {

    public static final EntityHelper3 INSTANCE;
    private static final Map lookupMap;
    private static String textValue;

    private EntityHelper3() {
    }

    public Map getMap() {
        return lookupMap;
    }

    public void executeAction(int samples) {
        Iterable iterable = ((Iterable) SharedKt.getWorld().getPlayers());
        int index = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) element);
            INSTANCE.executeAction(((PlayerEntity) player), samples);
            if (__UNDEF_KEY__ > 0) {
                if (__UNDEF_KEY__ == null) {
                }
            }
        }
        index = ((Iterable) SharedKt.getWorld().getPlayers());
        iterator = 0;
        element = index;
        player = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(index, 10)));
        Iterator iterator2 = element.iterator();
        while (iterator2.hasNext()) {
            Object element2 = iterator2.next();
            AbstractClientPlayerEntity player2 = ((AbstractClientPlayerEntity) element2);
            if (__UNDEF_KEY__ == null) {
                player.add(Integer.valueOf(player2.method_5628()));
            }
        }
        iterable = player;
        lookupMap.keySet().removeIf(this::checkCondition);
    }

    private void executeAction(PlayerEntity arg0, int arg1) {
        ArrayDeque arrayDeque = ((ArrayDeque) lookupMap.computeIfAbsent(Integer.valueOf(arg0.method_5628()), this::resolveArrayDeque));
        arrayDeque.addLast(arg0.method_5829().method_1014(0.0D));
        arrayDeque.removeFirst();
    }

    private static boolean checkCondition(List arg0, Integer arg1) {
        return !(arg0.contains(arg1));
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static ArrayDeque resolveArrayDeque(Integer arg0) {
        return new ArrayDeque();
    }

    private static ArrayDeque resolveArrayDeque(Function1 arg0, Object arg1) {
        return ((ArrayDeque) arg0.invoke(arg1));
    }

    static {
        INSTANCE = new EntityHelper3();
        lookupMap = ((Map) new LinkedHashMap());
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
