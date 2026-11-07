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
            List list = branches.get(event.getClass());
            Iterable iterable = ((Iterable) list);
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                Branch branch = ((Branch) element);
                branch.call(event);
            }
        } else {
        }
        return null;
    }

    public void plugAll(Object[] listeners) {
        int index = 0;
        if (index < listeners) {
            Object element = listeners[index];
            INSTANCE.plug(element);
        }
    }

    public void plug(Object obj) {
        Iterable iterable = ((Iterable) this.getBranches(obj));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Branch branch = ((Branch) element);
            INSTANCE.insert(branches.computeIfAbsent(branch.getEventTarget(), this::plug$lambda$5$lambda$4), branch);
        }
    }

    public void unplug(Object obj) {
        Iterable iterable = ((Iterable) this.getBranches(obj));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Branch branch = ((Branch) element);
            if (branches.get(branch.getEventTarget()) != null) {
                branches.get(branch.getEventTarget()).remove(branch);
            } else {
            }
        }
    }

    private void insert(List bl, Branch b) {
        List list = bl;
        int index = 0;
        int index2 = 0;
        Iterator iterator = bl.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Branch branch = ((Branch) element);
            if (b.getPriority() > branch.getPriority()) {
            } else {
            }
        }
        int index3 = -1;
        index = index3;
        index2 = 0;
        if (index == -1) {
        } else {
        }
        index3 = index;
        list.add(index3, b);
    }

    private List getBranches(Object obj) {
        return cachedBranches.computeIfAbsent(obj, this::getBranches$lambda$11);
    }

    private void getBranchesRecursive(List listeners, Class klass, Object obj) {
        Iterator iterator = ArrayIteratorKt.iterator(klass.getDeclaredMethods());
        while (iterator.hasNext()) {
            Method method = ((Method) iterator.next());
            listeners.add(new Branch(klass, obj, method));
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
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        INSTANCE.getBranchesRecursive(list, $obj.getClass(), $obj);
        return list;
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
