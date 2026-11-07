package su.catlean.client.services.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import su.catlean.client.features.modules.Module;

public class MinValueServiceComponent {

    public static final MinValueServiceComponent INSTANCE;
    private static final List itemList;
    private static Module[] moduleArray;

    private MinValueServiceComponent() {
    }

    public List getList() {
        return itemList;
    }

    public String resolveString(String id, Number minValue, String orElse) {
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            OverrideNameServiceComponent overrideNameServiceComponent = ((OverrideNameServiceComponent) element);
        }
        if (((OverrideNameServiceComponent) null) != null) {
            if (__UNDEF_KEY__ >= 0) {
                if (((OverrideNameServiceComponent) null).getString2() == null) {
                }
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ != null) {
            }
        }
        return orElse;
    }

    static {
        INSTANCE = new MinValueServiceComponent();
        itemList = new ArrayList();
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
