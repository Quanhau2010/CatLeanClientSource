package su.catlean.client.services.client;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_124;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.config.models.IdRecord3;
import su.catlean.client.services.client.config.models.IdRecord8;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.config.models.ModulesConfigRecord;
import su.catlean.client.services.render.POSITIONCOLORRenderHelper;
import su.catlean.client.types.OptionMode8;
import su.catlean.client.types.mappings.i0WhenMappings2;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class DefaultServiceComponent {

    public static void executeAction(String id, OptionMode8 type) {
        EnabledServiceComponent var46 = EnabledServiceComponent.INSTANCE;
        int var47 = 0;
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().executeAction(var46.getArrayList2(), ProxyGuiElement.INSTANCE.getJsonServiceComponent4().resolveModulesConfigRecord().getString());
        IdRecord3 var48 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveIdRecord3();
        ProxyGuiElement.INSTANCE.getJsonServiceComponent4().resolveModulesConfigRecord().executeAction(id);
        Iterable var49 = (Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList();
        JsonJsonServiceComponent5Impl2 var50 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2();
        int var51 = 0;
        Iterator iterator = var49.iterator();
        if (iterator.hasNext()) {
            Object var53 = iterator.next();
            IdRecord3 var54 = (IdRecord3) var53;
            int var55 = 0;
        } else {
        }
        if ((IdRecord3) null == null) {
            return;
        }
        var53.executeAction();
        var46.updateValue();
        var46.executeAction();
        if (0L > 0) {
            if (var42 == null) {
                var46 = POSITIONCOLORRenderHelper.INSTANCE;
                var47 = 0;
                ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().executeAction(var46.getList(), ProxyGuiElement.INSTANCE.getJsonServiceComponent4().resolveModulesConfigRecord().getString2());
                ProxyGuiElement.INSTANCE.getJsonServiceComponent4().resolveModulesConfigRecord().executeAction(id);
                var48 = (Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveList();
                var49 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4();
                var50 = 0;
                var51 = var48.iterator();
                if (var51.hasNext()) {
                    iterator = var51.next();
                    var53 = (IdRecord8) iterator;
                    var54 = 0;
                } else {
                }
                if (0L < 0 && (IdRecord8) null == null) {
                    return;
                }
                iterator.executeAction();
                var46.updateValue2();
                if (0L > 0) {
                    if (var42 == null) {
                    }
                }
                BindDispatcherServiceComponentImpl.INSTANCE.executeAction((class_124.field_1068 + "Key Binds:"));
            }
        }
        Iterable var44 = (Iterable) EnabledServiceComponent.INSTANCE.getArrayList2();
        int var45 = 0;
        var46 = var44;
        var47 = (Collection) new ArrayList();
        var48 = 0;
        var49 = var46.iterator();
        if (var49.hasNext()) {
            if (0L > 0) {
                if (var42 != null) {
                }
                var50 = var49.next();
                var51 = (Module) var50;
                iterator = 0;
                if (var42 != null) {
                    if (var51.getBind().getNumericValue() != -1) {
                    }
                } else {
                }
                var47.add();
            }
        }
        Iterator iterator2 = var47.iterator();
        var44 = (Module) iterator2.next();
        String var56 = NoneServiceComponent.INSTANCE.resolveString(var44.getBind().getNumericValue());
        class_124 var57 = class_124.field_1068;
        BindDispatcherServiceComponentImpl.INSTANCE.executeAction((var44.getString2() + "- " + var57 + var56));
    }

    public static void executeAction(String id, OptionMode8 type) {
        if (var22 != null) {
        }
        if (0L >= 0) {
            if (var22 != null) {
                if (Intrinsics.areEqual(id, ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveIdRecord3().getString())) {
                    executeAction((IdRecord3) CollectionsKt.first(ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList()).getString(), type);
                    if (0L < 0) {
                    }
                }
            }
            if (var22 != null) {
                if (var22 == null && ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList().size() == 1) {
                    executeAction("default", type);
                    executeAction("default", type);
                }
                ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList().removeIf(this::checkCondition);
            }
        }
        if (0L > 0) {
            if (var22 != null) {
                if (Intrinsics.areEqual(id, ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveIdRecord8().getString())) {
                    executeAction((IdRecord8) CollectionsKt.first(ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveList()).getString(), type);
                    if (0L > 0) {
                    }
                }
            }
            if (var22 != null) {
                if (var22 == null && ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveList().size() == 1) {
                    executeAction("default", type);
                    executeAction("default", type);
                }
                ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveList().removeIf(this::checkCondition2);
            }
        }
    }

    public static void executeAction(String id, OptionMode8 type) {
        if (0L > 0) {
            JsonJsonServiceComponent5Impl2 var18 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2();
            int var19 = 0;
            var18.executeAction(EnabledServiceComponent.INSTANCE.getArrayList2(), id);
            var18.executeAction();
        }
        var18 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4();
        var19 = 0;
        var18.executeAction(POSITIONCOLORRenderHelper.INSTANCE.getList(), id);
        var18.executeAction();
    }

    private static boolean checkCondition(String arg0, IdRecord3 arg1) {
        return Intrinsics.areEqual(arg1.getString(), arg0);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static boolean checkCondition(String arg0, IdRecord8 arg1) {
        return Intrinsics.areEqual(arg1.getString(), arg0);
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

}
