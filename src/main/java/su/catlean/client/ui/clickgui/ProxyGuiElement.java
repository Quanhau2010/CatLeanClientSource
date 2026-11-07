package su.catlean.client.ui.clickgui;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import net.minecraft.class_2561;
import net.minecraft.client.network.ClientPlayerEntity;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract3;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.FilesDraggedEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EnabledServiceComponent;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl2;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl3;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl4;
import su.catlean.client.services.client.JsonServiceComponent;
import su.catlean.client.services.client.JsonServiceComponent2;
import su.catlean.client.services.client.JsonServiceComponent3;
import su.catlean.client.services.client.JsonServiceComponent4;
import su.catlean.client.services.client.JsonServiceComponent6;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.ProxyServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent122;
import su.catlean.client.services.client.ServiceComponent125;
import su.catlean.client.services.client.ServiceComponent26;
import su.catlean.client.services.client.ServiceComponent65;
import su.catlean.client.services.client.config.models.IdRecord12;
import su.catlean.client.services.client.config.models.IdRecord3;
import su.catlean.client.services.client.config.models.IdRecord8;
import su.catlean.client.services.client.config.models.ProxiesRecord;
import su.catlean.client.services.render.ConfigPanelRenderHelper3Impl;
import su.catlean.client.services.render.POSITIONCOLORRenderHelper;
import su.catlean.client.services.render.ProxyPanelRenderHelper3Impl;

public class ProxyGuiElement implements Contract9 {

    public static final ProxyGuiElement INSTANCE;
    private static final Json json;
    private static final JsonServiceComponent4 jsonServiceComponent4;
    private static final JsonJsonServiceComponent5Impl4 jsonJsonServiceComponent5Impl4;
    private static final JsonJsonServiceComponent5Impl2 jsonJsonServiceComponent5Impl2;
    private static final JsonJsonServiceComponent5Impl jsonJsonServiceComponent5Impl;
    private static final JsonServiceComponent jsonServiceComponent;
    private static final JsonServiceComponent3 jsonServiceComponent3;
    private static final JsonServiceComponent6 jsonServiceComponent6;
    private static final JsonServiceComponent2 jsonServiceComponent2;
    private static final JsonJsonServiceComponent5Impl3 jsonJsonServiceComponent5Impl3;
    private static final ServiceComponent10 serviceComponent10;
    private static Module[] moduleArray;

    private ProxyGuiElement() {
    }

    public JsonServiceComponent4 getJsonServiceComponent4() {
        return jsonServiceComponent4;
    }

    public JsonJsonServiceComponent5Impl4 getJsonJsonServiceComponent5Impl4() {
        return jsonJsonServiceComponent5Impl4;
    }

    public JsonJsonServiceComponent5Impl2 getJsonJsonServiceComponent5Impl2() {
        return jsonJsonServiceComponent5Impl2;
    }

    public JsonJsonServiceComponent5Impl getJsonJsonServiceComponent5Impl() {
        return jsonJsonServiceComponent5Impl;
    }

    public JsonServiceComponent getJsonServiceComponent() {
        return jsonServiceComponent;
    }

    public JsonServiceComponent3 getJsonServiceComponent3() {
        return jsonServiceComponent3;
    }

    public JsonServiceComponent6 getJsonServiceComponent6() {
        return jsonServiceComponent6;
    }

    public JsonServiceComponent2 getJsonServiceComponent2() {
        return jsonServiceComponent2;
    }

    public JsonJsonServiceComponent5Impl3 getJsonJsonServiceComponent5Impl3() {
        return jsonJsonServiceComponent5Impl3;
    }

    private void executeAction(char arg0, short arg1, int arg2) {
        File[] items = ServiceComponent65.process();
        int index = 0;
        File[] items2 = items;
        if (index < items2) {
            Object element = items[index];
            Object element2 = element;
            int index2 = 0;
            element2.mkdirs();
            if (arg0 >= 0) {
                items = ((Object[]) this.getClass().getDeclaredFields());
            }
        }
        index = items;
        items2 = ((Collection) new ArrayList());
        element = 0;
        element2 = 0;
        index2 = index;
        if (element2 < index2) {
            Object element3 = index[element2];
            Field field = ((Field) element3);
            if (arg1 >= 0) {
                if (Contract3.class.isAssignableFrom(field.getType())) {
                    items2.add(element3);
                }
            }
        }
        items = ((Iterable) items2);
        index = items.iterator();
        while (index.hasNext()) {
            items2 = index.next();
            element = ((Field) items2);
            element2 = 0;
            element.setAccessible(true);
            element.get(INSTANCE).updateValue();
        }
    }

    public void updateValue() {
        jsonJsonServiceComponent5Impl2.executeAction(EnabledServiceComponent.INSTANCE.getArrayList2(), jsonJsonServiceComponent5Impl2.resolveIdRecord3().getString());
        jsonJsonServiceComponent5Impl4.executeAction(POSITIONCOLORRenderHelper.INSTANCE.getList(), jsonJsonServiceComponent5Impl4.resolveIdRecord8().getString());
        Object[] items = ((Object[]) this.getClass().getDeclaredFields());
        Object[] items2 = items;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        int index2 = 0;
        if (index2 < items2) {
            Object element = items2[index2];
            Field field = ((Field) element);
            if (__UNDEF_KEY__ != null) {
                if (Contract3.class.isAssignableFrom(field.getType())) {
                    collection.add(element);
                }
            }
        }
        items = ((Iterable) collection);
        items2 = items.iterator();
        while (items2.hasNext()) {
            collection = items2.next();
            index = ((Field) collection);
            index2 = 0;
            index.setAccessible(true);
            index.get(INSTANCE).executeAction();
        }
    }

    private void onFilesDraggedEvent(FilesDraggedEvent arg0) {
        File file = new File(CollectionsKt.first(arg0.getPaths()).toString());
        if (__UNDEF_KEY__ != null) {
            if (SharedKt.getMc().currentScreen instanceof CatleanPanelScreenGuiElement && ProxyPanelRenderHelper3Impl.INSTANCE.getContract4() != null) {
                if (__UNDEF_KEY__ != null) {
                    if (StringsKt.contains$default(((CharSequence) file.getName()), ((CharSequence) ".txt"), false)) {
                        Closeable closeable = ((Closeable) new BufferedReader(((Reader) new FileReader(file))));
                        BufferedReader bufferedReader = ((BufferedReader) closeable);
                        int index = 0;
                        if (bufferedReader.ready()) {
                            String[] items = new String[1];
                            items[0] = ":";
                            items = StringsKt.split$default(((CharSequence) bufferedReader.readLine()), items, false);
                            if (__UNDEF_KEY__ != null) {
                                if (__UNDEF_KEY__ != null) {
                                    if (!(items.isEmpty())) {
                                        ListIterator iterator = items.listIterator(items.size());
                                        if (iterator.hasPrevious()) {
                                            String text = ((String) iterator.previous());
                                            if (__UNDEF_KEY__ != null) {
                                                if (!(((CharSequence) text).length())) {
                                                } else {
                                                }
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                    items = ((Collection) CollectionsKt.emptyList());
                                    iterator = items;
                                    String[] items2 = ((String[]) iterator.toArray(new String[0]));
                                    if (StringsKt.toIntOrNull(items2[1]) != null) {
                                    }
                                    StringsKt.toIntOrNull(items2[1]);
                                    int index2 = 64;
                                    int index3 = 0;
                                    int index4 = 0;
                                    Object element = items2[3];
                                    Object element2 = items2[2];
                                    int index5 = 80;
                                    Object element3 = items2[0];
                                    String text2 = ("proxy_" + (Random.Default.nextFloat() * 10000));
                                    ProxyServiceComponent.INSTANCE.checkCondition2(new IdRecord12(text2, element3, index5, element2, element, index4, index3, index2));
                                    bufferedReader = Unit.INSTANCE;
                                    CloseableKt.closeFinally(closeable);
                                    index = CollectionsKt.take(((Iterable) items), (iterator.nextIndex() + 1));
                                    int index6 = index;
                                    CloseableKt.closeFinally(closeable, index6);
                                    ProxyPanelRenderHelper3Impl.INSTANCE.updateValue(null);
                                    ProxyPanelRenderHelper3Impl.INSTANCE.updateValue();
                                    index6 = index;
                                    if (__UNDEF_KEY__ != null) {
                                        if (SharedKt.getMc().player != null) {
                                            SharedKt.getMc().player.method_7353(class_2561.method_30163(KeyServiceComponent.INSTANCE.resolveString("gui.proxy.import-error", new Object[0])), false);
                                        } else {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (__UNDEF_KEY__ != null) {
                    if (StringsKt.contains$default(((CharSequence) file.getName()), ((CharSequence) ".ctlon"), false)) {
                        closeable = json;
                        index6 = FilesKt.readText$default(file);
                        bufferedReader = 0;
                        closeable.getSerializersModule();
                        jsonServiceComponent3.resolveProxiesRecord().getList().addAll(((Collection) ((ProxiesRecord) closeable.decodeFromString(((DeserializationStrategy) ProxiesRecord.serviceComponent125.getKSerializer()), index6)).getList()));
                        ProxyPanelRenderHelper3Impl.INSTANCE.updateValue(null);
                        ProxyPanelRenderHelper3Impl.INSTANCE.updateValue();
                        if (__UNDEF_KEY__ != null) {
                            if (SharedKt.getMc().player != null) {
                                SharedKt.getMc().player.method_7353(class_2561.method_30163(KeyServiceComponent.INSTANCE.resolveString("gui.proxy.import-error", new Object[0])), false);
                            } else {
                            }
                        }
                        return;
                    }
                }
            }
        }
        closeable = json;
        index6 = FilesKt.readText$default(file);
        bufferedReader = 0;
        closeable.getSerializersModule();
        jsonJsonServiceComponent5Impl2.resolveList().add(closeable.decodeFromString(((DeserializationStrategy) IdRecord3.serviceComponent122.getKSerializer()), index6));
        index6.printStackTrace();
        ConfigPanelRenderHelper3Impl.INSTANCE.updateValue();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getMc().currentScreen instanceof CatleanPanelScreenGuiElement) {
        } else {
        }
        RunnableServiceComponent runnableServiceComponent = RunnableServiceComponent.INSTANCE;
        int index = 0;
        runnableServiceComponent.getExecutorService().execute(((Runnable) new ServiceComponent26(index)));
    }

    private static Unit resolveUnit(JsonBuilder arg0) {
        arg0.setPrettyPrint(true);
        arg0.setIgnoreUnknownKeys(true);
        arg0.setEncodeDefaults(true);
        return Unit.INSTANCE;
    }

    static {
        INSTANCE = new ProxyGuiElement();
        json = JsonKt.Json$default(null, this::resolveUnit);
        jsonServiceComponent4 = new JsonServiceComponent4(json);
        jsonJsonServiceComponent5Impl4 = new JsonJsonServiceComponent5Impl4(json, jsonServiceComponent4);
        jsonJsonServiceComponent5Impl2 = new JsonJsonServiceComponent5Impl2(json, jsonServiceComponent4);
        jsonJsonServiceComponent5Impl = new JsonJsonServiceComponent5Impl(json, jsonServiceComponent4);
        jsonServiceComponent = new JsonServiceComponent(json);
        jsonServiceComponent3 = new JsonServiceComponent3(json);
        jsonServiceComponent6 = new JsonServiceComponent6(json);
        jsonServiceComponent2 = new JsonServiceComponent2(json);
        jsonJsonServiceComponent5Impl3 = new JsonJsonServiceComponent5Impl3(json, jsonServiceComponent4);
        serviceComponent10 = new ServiceComponent10();
        INSTANCE.executeAction();
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
