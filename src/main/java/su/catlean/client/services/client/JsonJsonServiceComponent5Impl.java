package su.catlean.client.services.client;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import org.slf4j.Logger;
import su.catlean.SharedKt;
import su.catlean.client.services.client.config.models.IdRecord6;
import su.catlean.client.services.client.config.models.ModulesConfigRecord;

public class JsonJsonServiceComponent5Impl extends JsonServiceComponent5 {

    private final JsonServiceComponent4 jsonServiceComponent4;
    private final File file;
    public List itemList;
    public IdRecord6 idRecord6;

    public JsonJsonServiceComponent5Impl(Json json, JsonServiceComponent4 sharedSource) {
        super(json);
        this.jsonServiceComponent4 = sharedSource;
        this.file = new File(ServiceComponent65.getFile(), "themes");
    }

    public File getFile() {
        return this.file;
    }

    public List resolveList() {
        if (var6 == null) {
            if (this.itemList != null) {
                return this.itemList;
            }
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        return null;
    }

    public void executeAction(List value) {
        this.itemList = value;
    }

    public IdRecord6 resolveIdRecord6() {
        if (this.idRecord6 != null) {
            return this.idRecord6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("current");
        return null;
    }

    public void executeAction(IdRecord6 value) {
        this.idRecord6 = value;
    }

    public void updateValue(long arg0) {
        long var3 = ((arg0 ^ 396435401634L) >>> 8);
        long var5 = (((arg0 ^ 396435401634L) << 56) >>> 56);
        long var6 = (arg0 ^ 131961657424154L);
        long var8 = (arg0 ^ 110163522662523L);
        long var10 = (arg0 ^ 21783406429546L);
        this.getFile().mkdirs();
        Object var30 = this;
        JsonServiceComponent5 var13 = this;
        Object var31 = var30;
        int var14 = 0;
        if (var12 == null) {
            if (var13.getFile().exists()) {
                if (var12 == null) {
                }
                if (!(var13.getFile().isDirectory())) {
                }
            }
        }
        File[] var15 = var13.getFile().listFiles();
        if (var12 == null) {
            if (var15 != null) {
            }
            Object var16 = var15;
            int var17 = 0;
            Object var18 = var16;
            Collection var19 = (Collection) new ArrayList();
            int var20 = 0;
            int var21 = 0;
            Object var22 = var18;
            if (var21 < var22) {
                Object var23 = var18[var21];
                Object var24 = var23;
                int var25 = 0;
                if (arg0 >= 0L) {
                    if (var12 == null) {
                    }
                    if (arg0 > 0L) {
                        if (var12 == null) {
                            if (Intrinsics.areEqual(FilesKt.getExtension(), "ctlon")) {
                                var19.add();
                            }
                        }
                    }
                }
                var17 = (Iterable) var19;
                var18 = 0;
                var19 = var17;
                var20 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(6539417428504346634L));
                var21 = 0;
                if (arg0 > 0L) {
                    var22 = var19.iterator();
                    if (var22.hasNext()) {
                        var23 = var22.next();
                        var24 = (File) var23;
                        Object var26 = var20;
                        var25 = 0;
                        Json var27 = JsonServiceComponent5.S();
                        String var28 = FilesKt.readText$default(null, 1, null);
                        int var29 = 0;
                        var27.getSerializersModule();
                        var26.add(var27.decodeFromString((DeserializationStrategy) IdRecord6.serviceComponent3.getKSerializer()));
                        if (arg0 >= 0L) {
                            if (var12 == null) {
                            }
                        }
                        var17 = CollectionsKt.toMutableList((Collection) var20);
                        if (var12 == null) {
                            if (var17 != null) {
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
        var13 = new ArrayList();
        var14 = var31;
        SharedKt.getLogger().warn("Themes are not loaded from file for some reasons.");
        var13 = new ArrayList();
        var30.executeAction();
        var14 = (Iterable) this.resolveList();
        var30 = this;
        var15 = 0;
        var16 = var14.iterator();
        if (var16.hasNext()) {
            var17 = var16.next();
            var18 = (IdRecord6) var17;
            var19 = 0;
        } else {
        }
        if (var12 == null) {
            if ((IdRecord6) null == null) {
            }
            var14 = CatLeanServiceComponent.getIdRecord6();
            var15 = var14;
            var16 = 0;
            this.resolveList().addAll((Collection) CollectionsKt.listOf(CatLeanServiceComponent.getIdRecord6()));
        }
        var30.executeAction();
    }

    public void executeAction(int arg0, int arg1, byte arg2) {
        int var4 = (((arg0 << 32) | ((arg1 << 40) >>> 32)) | ((arg2 << 56) >>> 56));
        long var6 = ((var4 ^ 19920229037783L) >>> 8);
        long var8 = (((var4 ^ 19920229037783L) << 56) >>> 56);
        Iterable var10 = (Iterable) this.resolveList();
        int var11 = 0;
        Iterator iterator = var10.iterator();
        if (iterator.hasNext()) {
            Object var13 = iterator.next();
            IdRecord6 var14 = (IdRecord6) var13;
            int var15 = 0;
            File var16 = new File(this.getFile(), (var14.getString() + ".ctlon"));
            Object var17 = var16;
            int var18 = 0;
            var17.createNewFile();
            Object var19 = var16;
            var16 = this.getJson();
            var17 = var14;
            var18 = 0;
            var16.getSerializersModule();
            FilesKt.writeText$default(var16.encodeToString((SerializationStrategy) IdRecord6.serviceComponent3.getKSerializer()));
            if (arg1 >= 0) {
            }
        }
    }

}
