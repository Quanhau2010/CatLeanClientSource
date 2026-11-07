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

    public void updateValue() {
        if (this.file.createNewFile()) {
        }
        ProxiesRecord proxiesRecord = new ProxiesRecord();
        Json json = this.json;
        String text = FilesKt.readText$default(this.file);
        json.getSerializersModule();
        json = ((ProxiesRecord) json.decodeFromString(((DeserializationStrategy) ProxiesRecord.serviceComponent125.getKSerializer()), text));
        text = proxiesRecord;
        SharedKt.getLogger().warn("Proxies are not loaded from file for some reasons.");
        json = new ProxiesRecord();
        proxiesRecord.executeAction(json);
    }

    public void executeAction() {
        Json json = this.json;
        ProxiesRecord proxiesRecord = this.resolveProxiesRecord();
        json.getSerializersModule();
        FilesKt.writeText$default(this.file, json.encodeToString(((SerializationStrategy) ProxiesRecord.serviceComponent125.getKSerializer()), proxiesRecord));
    }

}
