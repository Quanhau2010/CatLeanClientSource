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
import su.catlean.client.services.client.config.models.IdRecord10;
import su.catlean.client.services.client.config.models.IdRecord5;
import su.catlean.client.services.client.config.models.IdRecord8;
import su.catlean.client.services.client.config.models.ModulesConfigRecord;
import su.catlean.client.services.render.CheckRenderHelper;

public class JsonJsonServiceComponent5Impl4 extends JsonServiceComponent5 {

    private final JsonServiceComponent4 jsonServiceComponent4;
    private final File file;
    public IdRecord8 idRecord8;
    public List itemList;
    private static String[] textValueArray;

    public JsonJsonServiceComponent5Impl4(Json json, JsonServiceComponent4 sharedSource) {
        super(json);
        this.jsonServiceComponent4 = sharedSource;
        this.file = new File(ServiceComponent65.getFile(), "widgets");
    }

    public File getFile() {
        return this.file;
    }

    public IdRecord8 resolveIdRecord8() {
        if (this.idRecord8 != null) {
            return this.idRecord8;
        }
        Intrinsics.throwUninitializedPropertyAccessException("current");
        return null;
    }

    public void executeAction(IdRecord8 value) {
        this.idRecord8 = value;
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

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 93109896899108L);
        long var5 = ((arg0 ^ 35176628724501L) >>> 32);
        long var6 = (((arg0 ^ 35176628724501L) << 32) >>> 48);
        long var7 = (((arg0 ^ 35176628724501L) << 48) >>> 48);
        long var8 = ((arg0 ^ 57321926096347L) >>> 32);
        long var9 = (((arg0 ^ 57321926096347L) << 32) >>> 48);
        long var10 = (((arg0 ^ 57321926096347L) << 48) >>> 48);
        long var11 = (arg0 ^ 131961657424154L);
        long var13 = (arg0 ^ 38802389819421L);
        this.getFile().mkdirs();
        Object var33 = this;
        JsonServiceComponent5 var16 = this;
        Object var34 = var33;
        int var17 = 0;
        if (var15 == null) {
            if (var16.getFile().exists()) {
                if (var15 == null) {
                }
                if (!(var16.getFile().isDirectory())) {
                }
            }
        }
        File[] var18 = var16.getFile().listFiles();
        if (var15 == null) {
            if (var18 != null) {
            }
            Object var19 = var18;
            int var20 = 0;
            Object var21 = var19;
            Collection var22 = (Collection) new ArrayList();
            int var23 = 0;
            int var24 = 0;
            Object var25 = var21;
            if (var24 < var25) {
                Object var26 = var21[var24];
                Object var27 = var26;
                int var28 = 0;
                if (arg0 > 0L) {
                    if (var15 == null) {
                    }
                    if (arg0 >= 0L) {
                        if (var15 == null) {
                            if (Intrinsics.areEqual(FilesKt.getExtension(), "ctlon")) {
                                var22.add();
                            }
                        }
                    }
                }
                var20 = (Iterable) var22;
                var21 = 0;
                var22 = var20;
                var23 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
                var24 = 0;
                if (arg0 >= 0L) {
                    var25 = var22.iterator();
                    if (var25.hasNext()) {
                        var26 = var25.next();
                        var27 = (File) var26;
                        Object var29 = var23;
                        var28 = 0;
                        Json var30 = JsonServiceComponent5.S();
                        String var31 = FilesKt.readText$default(null, 1, null);
                        int var32 = 0;
                        var30.getSerializersModule();
                        var29.add(var30.decodeFromString((DeserializationStrategy) IdRecord8.serviceComponent32.getKSerializer()));
                        if (arg0 > 0L) {
                            if (var15 == null) {
                            }
                        }
                        var20 = CollectionsKt.toMutableList((Collection) var23);
                        if (var15 == null) {
                            if (var20 != null) {
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
        var16 = new ArrayList();
        var17 = var34;
        SharedKt.getLogger().warn("Widgets are not loaded from file for some reasons.");
        var16 = new ArrayList();
        var33.executeAction();
        var17 = (Iterable) this.resolveList();
        var33 = this;
        var18 = 0;
        var19 = var17.iterator();
        if (var19.hasNext()) {
            var20 = var19.next();
            var21 = (IdRecord8) var20;
            var22 = 0;
        } else {
        }
        if (var15 == null) {
            if ((IdRecord8) null == null) {
            }
            var17 = new IdRecord8(this.jsonServiceComponent4.resolveModulesConfigRecord().getString2());
            var18 = var17;
            var19 = 0;
            this.resolveList().add();
        }
        var33.executeAction();
    }

    public void executeAction(int arg0, int arg1, byte arg2) {
        int var4 = (((arg0 << 32) | ((arg1 << 40) >>> 32)) | ((arg2 << 56) >>> 56));
        long var6 = ((var4 ^ 15103071977056L) >>> 32);
        long var7 = (((var4 ^ 15103071977056L) << 32) >>> 48);
        long var8 = (((var4 ^ 15103071977056L) << 48) >>> 48);
        Iterable var10 = (Iterable) this.resolveList();
        int var11 = 0;
        Iterator iterator = var10.iterator();
        if (iterator.hasNext()) {
            Object var13 = iterator.next();
            IdRecord8 var14 = (IdRecord8) var13;
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
            FilesKt.writeText$default(var16.encodeToString((SerializationStrategy) IdRecord8.serviceComponent32.getKSerializer()));
            if (arg1 > 0) {
            }
        }
    }

    public void executeAction(List widgets, String id) {
        Iterable var21 = (Iterable) this.resolveList();
        int var22 = 0;
        Iterator iterator = var21.iterator();
        if (iterator.hasNext()) {
            Object var24 = iterator.next();
            IdRecord8 var25 = (IdRecord8) var24;
            int var26 = 0;
        } else {
        }
        if ((IdRecord8) null == null) {
        }
        IdRecord8 var19 = new IdRecord8(id);
        Iterable var20 = (Iterable) widgets;
        Object var40 = var19;
        var21 = 0;
        var22 = var20;
        iterator = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        var24 = 0;
        var25 = var22.iterator();
        if (var25.hasNext()) {
            var26 = var25.next();
            CheckRenderHelper var27 = (CheckRenderHelper) var26;
            Object var41 = iterator;
            int var28 = 0;
            Iterable var29 = (Iterable) var27.getList();
            String var30 = var27.getString();
            int var31 = 0;
            Object var32 = var29;
            Collection var33 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
            int var34 = 0;
            Iterator iterator2 = var32.iterator();
            if (iterator2.hasNext()) {
                Object var36 = iterator2.next();
                VisibleSettingProperty var37 = (VisibleSettingProperty) var36;
                Object var38 = var33;
                int var39 = 0;
                var38.add(new IdRecord10(var37.getString(), var37.toString()));
            }
            List positions = var33;
            Object var43 = var30;
            var41.add(new IdRecord5(positions));
        }
        var40.executeAction(iterator);
        this.resolveList().removeIf(this::checkCondition);
        this.resolveList().add();
    }

    private static boolean checkCondition(String arg0, IdRecord8 arg1) {
        return Intrinsics.areEqual(arg1.getString(), arg0);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
