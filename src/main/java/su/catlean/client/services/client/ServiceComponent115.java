package su.catlean.client.services.client;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.render.CatComponentRenderHelper;
import su.catlean.client.services.render.CategoryRenderHelper;
import su.catlean.client.services.render.CatleanInterfaceRenderHelper;

public class ServiceComponent115 implements Runnable {

    private final int countValue;
    private final Module module;
    private static String textValue;

    public ServiceComponent115(int arg0, Module arg1) {
        this.countValue = arg0;
        this.module = arg1;
    }

    public void run() {
        Thread.sleep(this.countValue);
        Iterable iterable = ((Iterable) CatleanInterfaceRenderHelper.getList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CategoryRenderHelper categoryRenderHelper = ((CategoryRenderHelper) element);
            Iterable iterable2 = ((Iterable) categoryRenderHelper.getArrayList2());
            Iterator iterator2 = iterable2.iterator();
            while (iterator2.hasNext()) {
                Object element2 = iterator2.next();
                CatComponentRenderHelper catComponentRenderHelper = ((CatComponentRenderHelper) element2);
                if (Intrinsics.areEqual(catComponentRenderHelper.getModule(), this.module)) {
                    catComponentRenderHelper.updateValue();
                }
            }
        }
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
