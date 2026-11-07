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
        int var6 = 0;
        Iterable var7 = (Iterable) CatleanInterfaceRenderHelper.getList();
        int var8 = 0;
        Iterator iterator = var7.iterator();
        while (iterator.hasNext()) {
            Object var10 = iterator.next();
            CategoryRenderHelper var11 = (CategoryRenderHelper) var10;
            int var12 = 0;
            Iterable var13 = (Iterable) var11.getArrayList2();
            int var14 = 0;
            Iterator iterator2 = var13.iterator();
            while (iterator2.hasNext()) {
                Object var16 = iterator2.next();
                CatComponentRenderHelper var17 = (CatComponentRenderHelper) var16;
                int var18 = 0;
                if (Intrinsics.areEqual(var17.getModule(), this.module)) {
                    var17.updateValue();
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
