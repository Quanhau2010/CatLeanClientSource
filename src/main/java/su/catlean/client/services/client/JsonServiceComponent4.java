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
        if (this.modulesConfigRecord != null) {
            return this.modulesConfigRecord;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public void executeAction(ModulesConfigRecord value) {
        this.modulesConfigRecord = value;
    }

    public void updateValue() {
        if (this.file.createNewFile()) {
        }
        ModulesConfigRecord modulesConfigRecord = new ModulesConfigRecord(null, null, null, null, false);
        Json json = this.json;
        String text = FilesKt.readText$default(this.file);
        json.getSerializersModule();
        json = ((ModulesConfigRecord) json.decodeFromString(((DeserializationStrategy) ModulesConfigRecord.serviceComponent21.getKSerializer()), text));
        text = modulesConfigRecord;
        SharedKt.getLogger().warn("Shared data are not loaded from file for some reasons.");
        json = new ModulesConfigRecord(null, null, null, null, false);
        modulesConfigRecord.executeAction(json);
    }

    public void executeAction() {
        Json json = this.json;
        ModulesConfigRecord modulesConfigRecord = this.resolveModulesConfigRecord();
        json.getSerializersModule();
        FilesKt.writeText$default(this.file, json.encodeToString(((SerializationStrategy) ModulesConfigRecord.serviceComponent21.getKSerializer()), modulesConfigRecord));
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
