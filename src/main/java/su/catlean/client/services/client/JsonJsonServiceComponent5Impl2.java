package su.catlean.client.services.client;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import org.slf4j.Logger;
import su.catlean.SharedKt;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.config.models.IdRecord10;
import su.catlean.client.services.client.config.models.IdRecord3;
import su.catlean.client.services.client.config.models.IdRecord5;
import su.catlean.client.services.client.config.models.ModulesConfigRecord;

public class JsonJsonServiceComponent5Impl2 extends JsonServiceComponent5 {

    private final JsonServiceComponent4 jsonServiceComponent4;
    private final File file;
    public List itemList;
    public IdRecord3 idRecord3;
    private static String textValue;

    public JsonJsonServiceComponent5Impl2(Json json, JsonServiceComponent4 sharedSource) {
        super(json);
        this.jsonServiceComponent4 = sharedSource;
        this.file = new File(ServiceComponent65.getFile(), "modules");
    }

    public File getFile() {
        return this.file;
    }

    public List resolveList() {
        if (this.itemList != null) {
            return this.itemList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public void executeAction(List value) {
        this.itemList = value;
    }

    public IdRecord3 resolveIdRecord3() {
        if (this.idRecord3 != null) {
            return this.idRecord3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("current");
        return null;
    }

    public void executeAction(IdRecord3 value) {
        this.idRecord3 = value;
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 9832626491264L);
        long var5 = (arg0 ^ 131961657424154L);
        long var7 = (arg0 ^ 62475661977279L);
        long var9 = ((arg0 ^ 92269267164102L) >>> 48);
        long var10 = (((arg0 ^ 92269267164102L) << 16) >>> 32);
        long var11 = (((arg0 ^ 92269267164102L) << 48) >>> 48);
        long var12 = (arg0 ^ 91341289963808L);
        this.getFile().mkdirs();
        Object var32 = this;
        JsonServiceComponent5 var15 = this;
        Object var33 = var32;
        int var16 = 0;
        if (var14 == null) {
            if (var15.getFile().exists()) {
                if (var14 == null) {
                }
                if (!(var15.getFile().isDirectory())) {
                }
            }
        }
        File[] var17 = var15.getFile().listFiles();
        if (var14 == null) {
            if (var17 != null) {
            }
            Object var18 = var17;
            int var19 = 0;
            Object var20 = var18;
            Collection var21 = (Collection) new ArrayList();
            int var22 = 0;
            int var23 = 0;
            Object var24 = var20;
            if (var23 < var24) {
                Object var25 = var20[var23];
                Object var26 = var25;
                int var27 = 0;
                if (arg0 >= 0L) {
                    if (var14 == null) {
                    }
                    if (arg0 > 0L) {
                        if (var14 == null) {
                            if (Intrinsics.areEqual(FilesKt.getExtension(), "ctlon")) {
                                var21.add();
                            }
                        }
                    }
                }
                var19 = (Iterable) var21;
                var20 = 0;
                var21 = var19;
                var22 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
                var23 = 0;
                if (arg0 > 0L) {
                    var24 = var21.iterator();
                    if (var24.hasNext()) {
                        var25 = var24.next();
                        var26 = (File) var25;
                        Object var28 = var22;
                        var27 = 0;
                        Json var29 = JsonServiceComponent5.S();
                        String var30 = FilesKt.readText$default(null, 1, null);
                        int var31 = 0;
                        var29.getSerializersModule();
                        var28.add(var29.decodeFromString((DeserializationStrategy) IdRecord3.serviceComponent122.getKSerializer()));
                        if (arg0 >= 0L) {
                            if (var14 == null) {
                            }
                        }
                        var19 = CollectionsKt.toMutableList((Collection) var22);
                        if (var14 == null) {
                            if (var19 != null) {
                            }
                        }
                    }
                }
            }
        } else {
        }
        }
        }
        }
        }
        var15 = new ArrayList();
        var16 = var33;
        SharedKt.getLogger().warn("Modules are not loaded from file for some reasons.");
        var15 = new ArrayList();
        var32.executeAction();
        var16 = (Iterable) this.resolveList();
        var32 = this;
        var17 = 0;
        var18 = var16.iterator();
        if (var18.hasNext()) {
            var19 = var18.next();
            var20 = (IdRecord3) var19;
            var21 = 0;
        } else {
        }
        if (var14 == null) {
            if ((IdRecord3) null == null) {
            }
            var16 = new IdRecord3(this.jsonServiceComponent4.resolveModulesConfigRecord().getString());
            var17 = var16;
            var18 = 0;
            this.resolveList().add();
        }
        var32.executeAction();
    }

    public void executeAction(int arg0, int arg1, byte arg2) {
        int var4 = (((arg0 << 32) | ((arg1 << 40) >>> 32)) | ((arg2 << 56) >>> 56));
        long var6 = (var4 ^ 29356394894069L);
        Iterable var9 = (Iterable) this.resolveList();
        int var10 = 0;
        Iterator iterator = var9.iterator();
        if (iterator.hasNext()) {
            Object var12 = iterator.next();
            IdRecord3 var13 = (IdRecord3) var12;
            int var14 = 0;
            File var15 = new File(this.getFile(), (var13.getString() + ".ctlon"));
            Object var16 = var15;
            int var17 = 0;
            var16.createNewFile();
            Object var18 = var15;
            var15 = this.getJson();
            var16 = var13;
            var17 = 0;
            var15.getSerializersModule();
            FilesKt.writeText$default(var15.encodeToString((SerializationStrategy) IdRecord3.serviceComponent122.getKSerializer()));
            if (arg0 >= 0) {
            }
        }
    }

    public void executeAction(List modules, String id) {
        Iterable var18 = (Iterable) this.resolveList();
        int var19 = 0;
        Iterator iterator = var18.iterator();
        if (iterator.hasNext()) {
            Object var21 = iterator.next();
            IdRecord3 var22 = (IdRecord3) var21;
            int var23 = 0;
        } else {
        }
        if ((IdRecord3) null == null) {
        }
        IdRecord3 var16 = new IdRecord3(id);
        Iterable var17 = (Iterable) modules;
        Object var37 = var16;
        var18 = 0;
        var19 = var17;
        iterator = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        var21 = 0;
        var22 = var19.iterator();
        if (var22.hasNext()) {
            var23 = var22.next();
            Module var24 = (Module) var23;
            Object var38 = iterator;
            int var25 = 0;
            Iterable var26 = (Iterable) var24.getList();
            String var27 = var24.getString();
            int var28 = 0;
            Object var29 = var26;
            Collection var30 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
            int var31 = 0;
            if (var15 == null) {
                Iterator iterator2 = var29.iterator();
                if (iterator2.hasNext()) {
                    Object var33 = iterator2.next();
                    VisibleSettingProperty var34 = (VisibleSettingProperty) var33;
                    Object var35 = var30;
                    int var36 = 0;
                    var35.add(new IdRecord10(var34.getString(), var34.toString()));
                }
                List positions = var30;
                Object var40 = var27;
                var38.add(new IdRecord5(positions));
            }
            var37.executeAction(iterator);
            this.resolveList().removeIf(this::checkCondition);
            this.resolveList().add();
        }
    }

    private static boolean checkCondition(String arg0, IdRecord3 arg1) {
        return Intrinsics.areEqual(arg1.getString(), arg0);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
