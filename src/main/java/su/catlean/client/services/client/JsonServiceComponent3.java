package su.catlean.client.services.client;

import java.io.File;
import java.util.ArrayList;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import org.slf4j.Logger;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract3;
import su.catlean.client.services.client.config.models.ProxiesRecord;

public class JsonServiceComponent3 implements Contract3 {

    private final Json json;
    private final File file;
    public ProxiesRecord proxiesRecord;

    public JsonServiceComponent3(Json json) {
        this.json = json;
        this.file = new File(ServiceComponent65.getFile(), "proxy.ctlon");
    }

    public ProxiesRecord resolveProxiesRecord() {
        if (this.proxiesRecord != null) {
            return this.proxiesRecord;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public void executeAction(ProxiesRecord value) {
        this.proxiesRecord = value;
    }

    public void updateValue(long arg0) {
        long var3 = ((arg0 ^ 5002786454352L) >>> 16);
        long var5 = (((arg0 ^ 5002786454352L) << 48) >>> 48);
        long var6 = (arg0 ^ 133444245573078L);
        if (this.file.createNewFile()) {
        }
        ProxiesRecord var12 = new ProxiesRecord(new ArrayList());
        Json var9 = this.json;
        String var10 = FilesKt.readText$default(this.file);
        int var11 = 0;
        var9.getSerializersModule();
        var9 = (ProxiesRecord) var9.decodeFromString((DeserializationStrategy) ProxiesRecord.serviceComponent125.getKSerializer());
        var10 = var12;
        SharedKt.getLogger().warn("Proxies are not loaded from file for some reasons.");
        var9 = new ProxiesRecord(new ArrayList());
        Object var8 = var9;
        var12.executeAction();
    }

    public void executeAction(int arg0, int arg1, byte arg2) {
        int var4 = (((arg0 << 32) | ((arg1 << 40) >>> 32)) | ((arg2 << 56) >>> 56));
        long var6 = (var4 ^ 133148621129362L);
        Json var8 = this.json;
        ProxiesRecord var9 = this.resolveProxiesRecord();
        int var10 = 0;
        var8.getSerializersModule();
        FilesKt.writeText$default(this.file, var8.encodeToString((SerializationStrategy) ProxiesRecord.serviceComponent125.getKSerializer()));
    }

}
