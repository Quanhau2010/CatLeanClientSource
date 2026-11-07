package su.catlean.client.services.client;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import org.slf4j.Logger;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract3;
import su.catlean.client.services.client.config.models.IdRecord;
import su.catlean.client.services.client.config.models.IdRecord11;
import su.catlean.client.services.client.config.models.IdRecord9;
import su.catlean.client.services.client.config.models.SettingMacrosRecord;

public class JsonServiceComponent6 implements Contract3 {

    private final Json json;
    private final File file;
    public List itemList;

    public JsonServiceComponent6(Json json) {
        this.json = json;
        this.file = new File(ServiceComponent65.getFile(), "macro.ctlon");
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
        long var3 = ((arg0 ^ 1817644076745L) >>> 32);
        long var4 = (((arg0 ^ 1817644076745L) << 32) >>> 48);
        long var5 = (((arg0 ^ 1817644076745L) << 48) >>> 48);
        if (this.file.createNewFile()) {
        }
        List positions = new ArrayList();
        Json var8 = this.json;
        String var9 = FilesKt.readText$default(this.file);
        int var10 = 0;
        var8.getSerializersModule();
        SettingMacrosRecord var7 = (SettingMacrosRecord) var8.decodeFromString((DeserializationStrategy) SettingMacrosRecord.serviceComponent104.getKSerializer());
        var8 = new ArrayList();
        var9 = var8;
        Object var12 = positions;
        var10 = 0;
        var9.addAll((Collection) var7.getList2());
        var9.addAll((Collection) var7.getList3());
        var9.addAll((Collection) var7.getList());
        var7 = var8;
        var8 = var12;
        SharedKt.getLogger().warn("Macros are not loaded from file for some reasons.");
        var7 = new ArrayList();
        Object var6 = var7;
        positions.executeAction();
    }

    public void executeAction(int arg0, int arg1, byte arg2) {
        int var4 = (((arg0 << 32) | ((arg1 << 40) >>> 32)) | ((arg2 << 56) >>> 56));
        long var6 = (var4 ^ 63175324088741L);
        long var8 = (var4 ^ 23103317616887L);
        Json var11 = this.json;
        Iterable var14 = (Iterable) this.resolveList();
        File var23 = this.file;
        int var15 = 0;
        Object var16 = var14;
        Collection var17 = (Collection) new ArrayList();
        int var18 = 0;
        Iterator iterator = var16.iterator();
        while (iterator.hasNext()) {
            Object var20 = iterator.next();
            var17.add();
        }
        List positions = TypeIntrinsics.asMutableList();
        var15 = (Iterable) this.resolveList();
        var16 = 0;
        var17 = var15;
        var18 = (Collection) new ArrayList();
        iterator = 0;
        var20 = var17.iterator();
        while (var20.hasNext()) {
            Object var21 = var20.next();
            var18.add();
        }
        List positions2 = TypeIntrinsics.asMutableList();
        var16 = (Iterable) this.resolveList();
        var17 = 0;
        var18 = var16;
        iterator = (Collection) new ArrayList();
        var20 = 0;
        var21 = var18.iterator();
        while (var21.hasNext()) {
            Object var22 = var21.next();
            iterator.add();
        }
        var14 = TypeIntrinsics.asMutableList(iterator);
        positions = new SettingMacrosRecord(positions, positions2);
        positions2 = 0;
        var11.getSerializersModule();
        FilesKt.writeText$default(var11.encodeToString((SerializationStrategy) SettingMacrosRecord.serviceComponent104.getKSerializer(), positions));
    }

}
