package su.catlean.client.services.client;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import org.slf4j.Logger;
import su.catlean.SharedKt;
import su.catlean.client.services.client.config.models.IdRecord4;
import su.catlean.client.services.client.config.models.ModulesConfigRecord;

public class JsonJsonServiceComponent5Impl3 extends JsonServiceComponent5 {

    private final JsonServiceComponent4 jsonServiceComponent4;
    private final File file;
    public IdRecord4 idRecord4;
    public List itemList;

    public JsonJsonServiceComponent5Impl3(Json json, JsonServiceComponent4 sharedSource) {
        super(json);
        this.jsonServiceComponent4 = sharedSource;
        this.file = new File(ServiceComponent65.getFile(), "inventories");
    }

    public File getFile() {
        return this.file;
    }

    public IdRecord4 resolveIdRecord4() {
        if (var3 == null) {
            if (this.idRecord4 != null) {
                return this.idRecord4;
            }
            Intrinsics.throwUninitializedPropertyAccessException("current");
        }
        return null;
    }

    public void executeAction(IdRecord4 value) {
        this.idRecord4 = value;
    }

    public List resolveList() {
        if (var3 == null) {
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

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 87256153326366L);
        long var5 = (arg0 ^ 479973136051L);
        long var7 = (arg0 ^ 34621155594690L);
        long var9 = (arg0 ^ 17248969305239L);
        long var11 = (arg0 ^ 131961657424154L);
        this.getFile().mkdirs();
        Object var31 = this;
        JsonServiceComponent5 var14 = this;
        Object var32 = var31;
        int var15 = 0;
        if (var13 == null) {
            if (var14.getFile().exists()) {
                if (var13 == null) {
                }
                if (!(var14.getFile().isDirectory())) {
                }
            }
        }
        File[] var16 = var14.getFile().listFiles();
        if (var13 == null) {
            if (var16 != null) {
            }
            Object var17 = var16;
            int var18 = 0;
            Object var19 = var17;
            Collection var20 = (Collection) new ArrayList();
            int var21 = 0;
            int var22 = 0;
            Object var23 = var19;
            if (var22 < var23) {
                Object var24 = var19[var22];
                Object var25 = var24;
                int var26 = 0;
                if (arg0 > 0L) {
                    if (var13 == null) {
                    }
                    if (arg0 >= 0L) {
                        if (var13 == null) {
                            if (Intrinsics.areEqual(FilesKt.getExtension(), "ctlon")) {
                                var20.add();
                            }
                        }
                    }
                }
                var18 = (Iterable) var20;
                var19 = 0;
                var20 = var18;
                var21 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(4019414224492036106L));
                var22 = 0;
                if (arg0 > 0L) {
                    var23 = var20.iterator();
                    if (var23.hasNext()) {
                        var24 = var23.next();
                        var25 = (File) var24;
                        Object var27 = var21;
                        var26 = 0;
                        Json var28 = JsonServiceComponent5.S();
                        String var29 = FilesKt.readText$default(null, 1, null);
                        int var30 = 0;
                        var28.getSerializersModule();
                        var27.add(var28.decodeFromString((DeserializationStrategy) IdRecord4.serviceComponent22.getKSerializer()));
                        if (arg0 >= 0L) {
                            if (var13 == null) {
                            }
                        }
                        var18 = CollectionsKt.toMutableList((Collection) var21);
                        if (var13 == null) {
                            if (var18 != null) {
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
        var14 = new ArrayList();
        var15 = var32;
        SharedKt.getLogger().warn("Inventories are not loaded from file for some reasons.");
        var14 = new ArrayList();
        var31.executeAction();
        var15 = (Iterable) this.resolveList();
        var31 = this;
        var16 = 0;
        var17 = var15.iterator();
        if (var17.hasNext()) {
            var18 = var17.next();
            var19 = (IdRecord4) var18;
            var20 = 0;
        } else {
        }
        if (var13 == null) {
            if ((IdRecord4) null == null) {
            }
            var15 = new IdRecord4(this.jsonServiceComponent4.resolveModulesConfigRecord().getString3(), (Map) new LinkedHashMap());
            var16 = var15;
            var17 = 0;
            this.resolveList().add();
        }
        var31.executeAction();
    }

    public void executeAction(int arg0, int arg1, byte arg2) {
        int var4 = (((arg0 << 32) | ((arg1 << 40) >>> 32)) | ((arg2 << 56) >>> 56));
        long var6 = (var4 ^ 19986762959814L);
        Iterable var9 = (Iterable) this.resolveList();
        int var10 = 0;
        Iterator iterator = var9.iterator();
        if (iterator.hasNext()) {
            Object var12 = iterator.next();
            IdRecord4 var13 = (IdRecord4) var12;
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
            FilesKt.writeText$default(var15.encodeToString((SerializationStrategy) IdRecord4.serviceComponent22.getKSerializer()));
            if (arg1 > 0) {
            }
        }
    }

}
