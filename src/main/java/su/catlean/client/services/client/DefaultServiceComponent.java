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
        EnabledServiceComponent enabledServiceComponent = EnabledServiceComponent.INSTANCE;
        int index = 0;
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().executeAction(enabledServiceComponent.getArrayList2(), ProxyGuiElement.INSTANCE.getJsonServiceComponent4().resolveModulesConfigRecord().getString());
        IdRecord3 idRecord3 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveIdRecord3();
        ProxyGuiElement.INSTANCE.getJsonServiceComponent4().resolveModulesConfigRecord().executeAction(id);
        Iterable iterable = ((Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList());
        JsonJsonServiceComponent5Impl2 jsonJsonServiceComponent5Impl2 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2();
        int index2 = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IdRecord3 idRecord32 = ((IdRecord3) element);
        }
        if (((IdRecord3) null) == null) {
            return;
        }
        element.executeAction(jsonJsonServiceComponent5Impl2);
        enabledServiceComponent.updateValue();
        enabledServiceComponent.executeAction(idRecord3);
        if (__UNDEF_KEY__ > 0) {
            if (__UNDEF_KEY__ == null) {
                enabledServiceComponent = POSITIONCOLORRenderHelper.INSTANCE;
                index = 0;
                ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().executeAction(enabledServiceComponent.getList(), ProxyGuiElement.INSTANCE.getJsonServiceComponent4().resolveModulesConfigRecord().getString2());
                ProxyGuiElement.INSTANCE.getJsonServiceComponent4().resolveModulesConfigRecord().executeAction(id);
                idRecord3 = ((Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveList());
                iterable = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4();
                jsonJsonServiceComponent5Impl2 = 0;
                index2 = idRecord3.iterator();
                while (index2.hasNext()) {
                    iterator = index2.next();
                    element = ((IdRecord8) iterator);
                    idRecord32 = 0;
                }
                if (__UNDEF_KEY__ < 0 && ((IdRecord8) null) == null) {
                    return;
                }
                iterator.executeAction(iterable);
                enabledServiceComponent.updateValue2();
                if (__UNDEF_KEY__ > 0) {
                    if (__UNDEF_KEY__ == null) {
                    }
                    BindDispatcherServiceComponentImpl.INSTANCE.executeAction((class_124.field_1068 + "Key Binds:"));
                }
            }
        }
        Iterable iterable2 = ((Iterable) EnabledServiceComponent.INSTANCE.getArrayList2());
        enabledServiceComponent = iterable2;
        index = ((Collection) new ArrayList());
        idRecord3 = 0;
        iterable = enabledServiceComponent.iterator();
        while (iterable.hasNext()) {
            if (__UNDEF_KEY__ > 0) {
                if (__UNDEF_KEY__ != null) {
                    jsonJsonServiceComponent5Impl2 = iterable.next();
                    index2 = ((Module) jsonJsonServiceComponent5Impl2);
                    iterator = 0;
                    if (__UNDEF_KEY__ != null) {
                        if (index2.getBind().getNumericValue() != -1) {
                        } else {
                        }
                    }
                    index.add(jsonJsonServiceComponent5Impl2);
                }
            }
        }
        Iterator iterator2 = index.iterator();
        while (iterator2.hasNext()) {
            iterable2 = ((Module) iterator2.next());
            String text = NoneServiceComponent.INSTANCE.resolveString(iterable2.getBind().getNumericValue());
            class_124 class124 = class_124.field_1068;
            BindDispatcherServiceComponentImpl.INSTANCE.executeAction((iterable2.getString2() + "- " + class124 + text));
        }
    }

    public static void executeAction(String id, OptionMode8 type) {
        if (__UNDEF_KEY__ != null) {
        }
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ != null) {
                if (Intrinsics.areEqual(id, ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveIdRecord3().getString())) {
                    executeAction(((IdRecord3) CollectionsKt.first(ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList())).getString(), type);
                    if (__UNDEF_KEY__ < 0) {
                        if (__UNDEF_KEY__ != null) {
                            if (__UNDEF_KEY__ == null && ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList().size() == 1) {
                                executeAction("default", type);
                                executeAction("default", type);
                            }
                            ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList().removeIf(this::checkCondition);
                        }
                    }
                }
            }
        }
        if (__UNDEF_KEY__ > 0) {
            if (__UNDEF_KEY__ != null) {
                if (Intrinsics.areEqual(id, ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveIdRecord8().getString())) {
                    executeAction(((IdRecord8) CollectionsKt.first(ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveList())).getString(), type);
                    if (__UNDEF_KEY__ > 0) {
                        if (__UNDEF_KEY__ != null) {
                            if (__UNDEF_KEY__ == null && ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveList().size() == 1) {
                                executeAction("default", type);
                                executeAction("default", type);
                            }
                            ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveList().removeIf(this::checkCondition2);
                        }
                    }
                }
            }
        }
    }

    public static void executeAction(String id, OptionMode8 type) {
        if (__UNDEF_KEY__ > 0) {
            JsonJsonServiceComponent5Impl2 jsonJsonServiceComponent5Impl2 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2();
            jsonJsonServiceComponent5Impl2.executeAction(EnabledServiceComponent.INSTANCE.getArrayList2(), id);
            jsonJsonServiceComponent5Impl2.executeAction();
        }
        jsonJsonServiceComponent5Impl2 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4();
        jsonJsonServiceComponent5Impl2.executeAction(POSITIONCOLORRenderHelper.INSTANCE.getList(), id);
        jsonJsonServiceComponent5Impl2.executeAction();
    }

    private static boolean checkCondition(String arg0, IdRecord3 arg1) {
        return Intrinsics.areEqual(arg1.getString(), arg0);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static boolean checkCondition(String arg0, IdRecord8 arg1) {
        return Intrinsics.areEqual(arg1.getString(), arg0);
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

}
