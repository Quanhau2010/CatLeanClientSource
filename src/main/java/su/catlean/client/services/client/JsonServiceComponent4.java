package su.catlean.client.services.client;

import java.io.File;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import org.slf4j.Logger;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract3;
import su.catlean.client.services.client.config.models.ModulesConfigRecord;

public class JsonServiceComponent4 implements Contract3 {

    private final Json json;
    private final File file;
    public ModulesConfigRecord modulesConfigRecord;
    private static String textValue;

    public JsonServiceComponent4(Json json) {
        this.json = json;
        this.file = new File(ServiceComponent65.getFile(), "shared.ctlon");
    }

    public ModulesConfigRecord resolveModulesConfigRecord() {
        if (var3 == null) {
            if (this.modulesConfigRecord != null) {
                return this.modulesConfigRecord;
            }
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        return null;
    }

    public void executeAction(ModulesConfigRecord value) {
        this.modulesConfigRecord = value;
    }

    public void updateValue(long arg0) {
        long var3 = ((arg0 ^ 117038982073452L) >>> 48);
        long var4 = (((arg0 ^ 117038982073452L) << 16) >>> 32);
        long var5 = (((arg0 ^ 117038982073452L) << 48) >>> 48);
        long var6 = (arg0 ^ 9504272317057L);
        if (this.file.createNewFile()) {
        }
        ModulesConfigRecord var11 = new ModulesConfigRecord();
        Json var8 = this.json;
        String var9 = FilesKt.readText$default(this.file);
        int var10 = 0;
        var8.getSerializersModule();
        var8 = (ModulesConfigRecord) var8.decodeFromString((DeserializationStrategy) ModulesConfigRecord.serviceComponent21.getKSerializer());
        var9 = var11;
        SharedKt.getLogger().warn("Shared data are not loaded from file for some reasons.");
        var8 = new ModulesConfigRecord();
        var11.executeAction();
    }

    public void executeAction(int arg0, int arg1, byte arg2) {
        int var4 = (((arg0 << 32) | ((arg1 << 40) >>> 32)) | ((arg2 << 56) >>> 56));
        long var6 = (var4 ^ 116852923442287L);
        Json var8 = this.json;
        ModulesConfigRecord var9 = this.resolveModulesConfigRecord();
        int var10 = 0;
        var8.getSerializersModule();
        FilesKt.writeText$default(this.file, var8.encodeToString((SerializationStrategy) ModulesConfigRecord.serviceComponent21.getKSerializer()));
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
