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
        Iterable var10 = (Iterable) itemList;
        int var11 = 0;
        Iterator iterator = var10.iterator();
        if (iterator.hasNext()) {
            Object var13 = iterator.next();
            OverrideNameServiceComponent var14 = (OverrideNameServiceComponent) var13;
            int var15 = 0;
        } else {
        }
        if ((OverrideNameServiceComponent) null != null) {
            if (0L >= 0) {
                if ((OverrideNameServiceComponent) null.getString2() == null) {
                }
            }
        }
        if (0L >= 0) {
            if (var9 != null) {
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
