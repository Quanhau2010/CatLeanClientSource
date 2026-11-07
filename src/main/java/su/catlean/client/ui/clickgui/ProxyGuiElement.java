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
        File[] var8 = ServiceComponent65.process();
        int var9 = 0;
        int var10 = 0;
        Object var11 = var8;
        if (var10 < var11) {
            Object var12 = var8[var10];
            Object var13 = var12;
            int var14 = 0;
            var13.mkdirs();
            if (arg0 >= 0) {
            }
            var8 = (Object[]) this.getClass().getDeclaredFields();
            var9 = 0;
        }
        var10 = var8;
        var11 = (Collection) new ArrayList();
        var12 = 0;
        var13 = 0;
        var14 = var10;
        if (var13 < var14) {
            Object var15 = var10[var13];
            Field var16 = (Field) var15;
            int var17 = 0;
            if (arg1 >= 0) {
                if (Contract3.class.isAssignableFrom(var16.getType())) {
                    var11.add();
                }
            }
        }
        var8 = (Iterable) var11;
        var9 = 0;
        var10 = var8.iterator();
        if (var10.hasNext()) {
            var11 = var10.next();
            var12 = (Field) var11;
            var13 = 0;
            var12.setAccessible(1);
            var12.get(INSTANCE).updateValue();
        }
    }

    public void updateValue() {
        jsonJsonServiceComponent5Impl2.executeAction(EnabledServiceComponent.INSTANCE.getArrayList2(), jsonJsonServiceComponent5Impl2.resolveIdRecord3().getString());
        jsonJsonServiceComponent5Impl4.executeAction(POSITIONCOLORRenderHelper.INSTANCE.getList(), jsonJsonServiceComponent5Impl4.resolveIdRecord8().getString());
        Object[] var15 = (Object[]) this.getClass().getDeclaredFields();
        int var16 = 0;
        Object var17 = var15;
        Collection var18 = (Collection) new ArrayList();
        int var19 = 0;
        int var20 = 0;
        Object var21 = var17;
        if (var20 < var21) {
            Object var22 = var17[var20];
            Field var23 = (Field) var22;
            int var24 = 0;
            if (var14 != null) {
                if (Contract3.class.isAssignableFrom(var23.getType())) {
                    var18.add();
                }
            }
        }
        var15 = (Iterable) var18;
        var16 = 0;
        var17 = var15.iterator();
        if (var17.hasNext()) {
            var18 = var17.next();
            var19 = (Field) var18;
            var20 = 0;
            var19.setAccessible(1);
            var19.get(INSTANCE).executeAction();
        }
    }

    private void onFilesDraggedEvent(FilesDraggedEvent arg0) {
        File var31 = new File(CollectionsKt.first(arg0.getPaths()).toString());
        if (var30 != null) {
            if (SharedKt.getMc().currentScreen instanceof CatleanPanelScreenGuiElement && ProxyPanelRenderHelper3Impl.INSTANCE.getContract4() != null) {
                if (var30 != null) {
                    if (StringsKt.contains$default((CharSequence) var31.getName(), (CharSequence) ".txt")) {
                        Closeable var32 = (Closeable) new BufferedReader((Reader) new FileReader());
                        BufferedReader var34 = (BufferedReader) var32;
                        int var35 = 0;
                        if (var34.ready()) {
                            String[] var36 = new String[1];
                            var36[0] = ":";
                            var36 = StringsKt.split$default((CharSequence) var34.readLine());
                            int var37 = 0;
                            if (var30 != null) {
                                if (var30 != null) {
                                    if (!(var36.isEmpty())) {
                                    }
                                    ListIterator iterator = var36.listIterator(var36.size());
                                    if (iterator.hasPrevious()) {
                                        String var39 = (String) iterator.previous();
                                        int var40 = 0;
                                        if (var30 != null) {
                                            if (!((CharSequence) var39.length())) {
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            }
                            var36 = (Collection) CollectionsKt.emptyList();
                            var37 = 0;
                            iterator = var36;
                            String[] var41 = (String[]) iterator.toArray(new String[0]);
                            if (StringsKt.toIntOrNull(var41[1]) != null) {
                            }
                            StringsKt.toIntOrNull(var41[1]);
                            int var22 = 64;
                            int var23 = 0;
                            int var24 = 0;
                            Object var25 = var41[3];
                            Object var26 = var41[2];
                            int var27 = 80;
                            Object var28 = var41[0];
                            String var29 = ("proxy_" + (Random.Default.nextFloat() * 10000));
                            ProxyServiceComponent.INSTANCE.checkCondition2(new IdRecord12());
                        }
                        var34 = Unit.INSTANCE;
                        CloseableKt.closeFinally();
                        var35 = CollectionsKt.take((Iterable) var36, (iterator.nextIndex() + 1));
                        Object var33 = var35;
                        CloseableKt.closeFinally();
                        ProxyPanelRenderHelper3Impl.INSTANCE.updateValue(null);
                        ProxyPanelRenderHelper3Impl.INSTANCE.updateValue();
                        var33 = var35;
                        if (var30 != null) {
                            if (SharedKt.getMc().player != null) {
                                SharedKt.getMc().player.method_7353(class_2561.method_30163(KeyServiceComponent.INSTANCE.resolveString("gui.proxy.import-error", new Object[0])), 0);
                            }
                        } else {
                        }
                    }
                }
            }
            if (var30 != null) {
                if (StringsKt.contains$default((CharSequence) var31.getName(), (CharSequence) ".ctlon")) {
                    var32 = json;
                    var33 = FilesKt.readText$default(null, 1, null);
                    var34 = 0;
                    var32.getSerializersModule();
                    jsonServiceComponent3.resolveProxiesRecord().getList().addAll((Collection) (ProxiesRecord) var32.decodeFromString((DeserializationStrategy) ProxiesRecord.serviceComponent125.getKSerializer()).getList());
                    ProxyPanelRenderHelper3Impl.INSTANCE.updateValue(null);
                    ProxyPanelRenderHelper3Impl.INSTANCE.updateValue();
                    if (var30 != null) {
                        if (SharedKt.getMc().player != null) {
                            SharedKt.getMc().player.method_7353(class_2561.method_30163(KeyServiceComponent.INSTANCE.resolveString("gui.proxy.import-error", new Object[0])), 0);
                        }
                    } else {
                    }
                    return;
                }
            }
        }
        }
        var32 = json;
        var33 = FilesKt.readText$default(null, 1, null);
        var34 = 0;
        var32.getSerializersModule();
        jsonJsonServiceComponent5Impl2.resolveList().add(var32.decodeFromString((DeserializationStrategy) IdRecord3.serviceComponent122.getKSerializer()));
        var33.printStackTrace();
        ConfigPanelRenderHelper3Impl.INSTANCE.updateValue();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getMc().currentScreen instanceof CatleanPanelScreenGuiElement) {
        } else {
        }
        RunnableServiceComponent var9 = RunnableServiceComponent.INSTANCE;
        int var10 = 0;
        int var11 = 0;
        var9.getExecutorService().execute((Runnable) new ServiceComponent26());
    }

    private static Unit resolveUnit(JsonBuilder arg0) {
        arg0.setPrettyPrint(1);
        arg0.setIgnoreUnknownKeys(1);
        arg0.setEncodeDefaults(1);
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
