package su.catlean.client.services.client;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.services.network.TheNetherPacketHelper;

public class CrystalServiceComponent2 implements Contract9 {

    public static final CrystalServiceComponent2 INSTANCE;
    private static final ConcurrentHashMap concurrentHashMap;
    private static final ConcurrentHashMap concurrentHashMap2;
    private static final ConcurrentHashMap concurrentHashMap3;
    private static final ConcurrentHashMap concurrentHashMap4;
    private static Module[] moduleArray;

    private CrystalServiceComponent2() {
    }

    public ConcurrentHashMap getConcurrentHashMap() {
        return concurrentHashMap4;
    }

    public void executeAction(Pair crystal) {
        this.resolveLong(((Number) crystal.getFirst()), SharedKt.getNumericValue());
        this.updateValue(crystal);
    }

    public void executeAction() {
        concurrentHashMap.clear();
        concurrentHashMap2.clear();
        concurrentHashMap3.clear();
    }

    public void executeAction() {
        long time = SharedKt.getNumericValue();
        int index = (TheNetherPacketHelper.f() * 2L);
        concurrentHashMap.entrySet().removeIf(this::checkCondition);
        concurrentHashMap2.entrySet().removeIf(this::checkCondition2);
        concurrentHashMap3.entrySet().removeIf(this::checkCondition3);
        concurrentHashMap4.entrySet().removeIf(this::checkCondition4);
    }

    public boolean checkCondition(int id) {
        return concurrentHashMap.containsKey(Integer.valueOf(id));
    }

    public long computeValue(int id) {
        return ((Number) concurrentHashMap.getOrDefault(Integer.valueOf(id), Long.valueOf(-1L))).longValue();
    }

    public Long resolveLong(int id, long deathTime) {
        return ((Long) concurrentHashMap.putIfAbsent(Integer.valueOf(id), Long.valueOf(deathTime)));
    }

    public boolean checkCondition(int id) {
        return ((PlaceServiceComponent) concurrentHashMap2.get(Integer.valueOf(id))).checkCondition();
    }

    private void updateValue(Pair arg0) {
        concurrentHashMap2.compute(arg0.getFirst(), this::resolvePlaceServiceComponent);
    }

    public void executeAction(BlockPos blockPos) {
        boolean flag = AutoCrystalModule.INSTANCE.checkCondition(blockPos.up(), Lists.newArrayList(SharedKt.getWorld().method_18112()));
        concurrentHashMap3.compute(blockPos, this::resolvePlaceServiceComponent2);
        Box box = new Box((blockPos.method_10263() - 0.5D), (blockPos.method_10264() + 1.0D), (blockPos.method_10260() - 0.5D), (blockPos.method_10263() + 1.5D), (blockPos.method_10264() + 3.0D), (blockPos.method_10260() + 1.5D));
        if (__UNDEF_KEY__ != null) {
            if (!(concurrentHashMap4.containsKey(box))) {
            }
        }
        if (__UNDEF_KEY__ >= 0) {
        }
    }

    public boolean checkCondition(BlockPos blockPos, boolean ignoreMid) {
        Box box = new Box((blockPos.method_10263() - 0.5D), (blockPos.method_10264() + 1.0D), (blockPos.method_10260() - 0.5D), (blockPos.method_10263() + 1.5D), (blockPos.method_10264() + 3.0D), (blockPos.method_10260() + 1.5D));
        Map map = ((Map) concurrentHashMap4);
        if (map.isEmpty()) {
        } else {
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry entry = ((Entry) iterator.next());
                if (!(ignoreMid)) {
                    if (((Box) entry.getKey()).method_994(box) && !(Intrinsics.areEqual(((Box) entry.getKey()).method_1005(), box.method_1005()))) {
                    } else {
                    }
                }
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            if (0 != null) {
            }
        }
        return true;
    }

    public PlaceServiceComponent resolvePlaceServiceComponent(Vec3d pos) {
        Iterator iterator = concurrentHashMap3.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            BlockPos blockPos = ((BlockPos) entry.getKey());
            PlaceServiceComponent placeServiceComponent = ((PlaceServiceComponent) entry.getValue());
            ServiceComponent45.INSTANCE.executeAction(blockPos);
            iterator.remove();
            PlaceServiceComponent placeServiceComponent2 = placeServiceComponent;
        }
        entry = concurrentHashMap4.entrySet().iterator();
        while (entry.hasNext()) {
            placeServiceComponent = ((Box) ((Entry) entry.next()).getKey());
            entry.remove();
        }
        if (placeServiceComponent2 != null) {
        }
        return placeServiceComponent2;
    }

    public boolean checkCondition(BlockPos bp) {
        if (((PlaceServiceComponent) concurrentHashMap3.get(bp)) != null) {
        } else {
            return ((PlaceServiceComponent) concurrentHashMap3.get(bp)).checkCondition() == 1;
        }
    }

    private static boolean checkCondition(long arg0, long arg1, Entry arg2) {
        return (arg0 - ((Number) arg2.getValue()).longValue()) > arg1;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static boolean checkCondition(Entry arg0) {
        return ((PlaceServiceComponent) arg0.getValue()).checkCondition();
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static boolean checkCondition2(Entry arg0) {
        return ((PlaceServiceComponent) arg0.getValue()).checkCondition();
    }

    private static boolean checkCondition3(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static boolean checkCondition3(Entry arg0) {
        return (SharedKt.getNumericValue() - ((Number) arg0.getValue()).longValue()) > Math.max((TheNetherPacketHelper.f() * 1.5D), 50.0D);
    }

    private static boolean checkCondition4(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static PlaceServiceComponent resolvePlaceServiceComponent(Pair arg0, PlaceServiceComponent arg1) {
        if (arg1 == null) {
            return new PlaceServiceComponent(SharedKt.getNumericValue(), 1, ((Vec3d) arg0.getSecond()), false);
        }
        arg1.executeAction();
        return arg1;
    }

    private static PlaceServiceComponent resolvePlaceServiceComponent(Function2 arg0, Object arg1, Object arg2) {
        return ((PlaceServiceComponent) arg0.invoke(arg1, arg2));
    }

    private static PlaceServiceComponent resolvePlaceServiceComponent(BlockPos arg0, boolean arg1, BlockPos arg2, PlaceServiceComponent arg3) {
        if (arg3 == null) {
            return new PlaceServiceComponent(SharedKt.getNumericValue(), 1, arg0.toCenterPos(), true);
        }
        if (!(arg1)) {
            arg3.executeAction();
        }
        return arg3;
    }

    private static PlaceServiceComponent resolvePlaceServiceComponent2(Function2 arg0, Object arg1, Object arg2) {
        return ((PlaceServiceComponent) arg0.invoke(arg1, arg2));
    }

    private static boolean checkCondition(Vec3d arg0, BlockPos arg1) {
        return arg0.method_1025(arg1.toCenterPos()) < 0.3D;
    }

    private static boolean checkCondition5(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        INSTANCE = new CrystalServiceComponent2();
        concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap2 = new ConcurrentHashMap();
        concurrentHashMap3 = new ConcurrentHashMap();
        concurrentHashMap4 = new ConcurrentHashMap();
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
