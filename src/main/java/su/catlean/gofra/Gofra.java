package su.catlean.gofra;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;

public class Gofra {

    public static final Gofra INSTANCE;
    private static final ConcurrentHashMap cachedBranches;
    private static final ConcurrentHashMap branches;

    private Gofra() {
    }

    public Unit drain(Object event) {
        if (branches.get(event.getClass()) != null) {
            List positions = branches.get(event.getClass());
            int var3 = 0;
            Iterable var4 = (Iterable) positions;
            int var5 = 0;
            Iterator iterator = var4.iterator();
            while (iterator.hasNext()) {
                Object var7 = iterator.next();
                Branch var8 = (Branch) var7;
                int var9 = 0;
                var8.call(event);
            }
        } else {
        }
        return null;
    }

    public void plugAll(Object[] listeners) {
        Object var2 = listeners;
        int var3 = 0;
        int var4 = 0;
        Object var5 = var2;
        if (var4 < var5) {
            Object var6 = var2[var4];
            Object var7 = var6;
            int var8 = 0;
            INSTANCE.plug();
        }
    }

    public void plug(Object obj) {
        Iterable var2 = (Iterable) this.getBranches(obj);
        int var3 = 0;
        Iterator iterator = var2.iterator();
        while (iterator.hasNext()) {
            Object var5 = iterator.next();
            Branch var6 = (Branch) var5;
            int var7 = 0;
            INSTANCE.insert(branches.computeIfAbsent(var6.getEventTarget(), this::plug$lambda$5$lambda$4));
        }
    }

    public void unplug(Object obj) {
        Iterable var2 = (Iterable) this.getBranches(obj);
        int var3 = 0;
        Iterator iterator = var2.iterator();
        while (iterator.hasNext()) {
            Object var5 = iterator.next();
            Branch var6 = (Branch) var5;
            int var7 = 0;
            if (branches.get(var6.getEventTarget()) != null) {
                branches.get(var6.getEventTarget()).remove();
            } else {
            }
        }
    }

    private void insert(List bl, Branch b) {
        Object var3 = bl;
        Object var10 = bl;
        int var4 = 0;
        int var5 = 0;
        Iterator iterator = var3.iterator();
        while (iterator.hasNext()) {
            Object var7 = iterator.next();
            Branch var8 = (Branch) var7;
            int var9 = 0;
            if (b.getPriority() > var8.getPriority()) {
            } else {
            }
        }
        int var11 = -1;
        var4 = var11;
        var5 = 0;
        if (var4 == -1) {
        } else {
        }
        var11 = var4;
        var10.add(b);
    }

    private List getBranches(Object obj) {
        return cachedBranches.computeIfAbsent(obj, this::getBranches$lambda$11);
    }

    private void getBranchesRecursive(List listeners, Class klass, Object obj) {
        Iterator iterator = ArrayIteratorKt.iterator(klass.getDeclaredMethods());
        while (iterator.hasNext()) {
            Method var5 = (Method) iterator.next();
            listeners.add(new Branch(klass, obj));
        }
        this.getBranchesRecursive(listeners, klass.getSuperclass(), obj);
    }

    private static List plug$lambda$5$lambda$3(Object it) {
        return new CopyOnWriteArrayList();
    }

    private static List plug$lambda$5$lambda$4(Function1 $tmp0, Object p0) {
        return $tmp0.invoke(p0);
    }

    private static List getBranches$lambda$10(Object $obj, Object it) {
        CopyOnWriteArrayList positions = new CopyOnWriteArrayList();
        Object var3 = positions;
        int var4 = 0;
        INSTANCE.getBranchesRecursive($obj.getClass(), $obj);
        return positions;
    }

    private static List getBranches$lambda$11(Function1 $tmp0, Object p0) {
        return $tmp0.invoke(p0);
    }

    static {
        INSTANCE = new Gofra();
        cachedBranches = new ConcurrentHashMap();
        branches = new ConcurrentHashMap();
    }

}
