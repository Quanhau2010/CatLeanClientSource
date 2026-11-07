package su.catlean.client.services.client;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import org.slf4j.Logger;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract3;

public class JsonServiceComponent2 implements Contract3 {

    private final Json json;
    private final File file;
    public List itemList;

    public JsonServiceComponent2(Json json) {
        this.json = json;
        this.file = new File(ServiceComponent65.getFile(), "homies.ctlon");
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

    public void updateValue() {
        if (this.file.createNewFile()) {
        }
        List list = new ArrayList();
        Json json = this.json;
        String text = FilesKt.readText$default(this.file);
        json.getSerializersModule();
        json = json.decodeFromString(((DeserializationStrategy) new ArrayListSerializer(StringSerializer.INSTANCE)), text);
        text = list;
        SharedKt.getLogger().warn("Homies are not loaded from file for some reasons.");
        json = new ArrayList();
        list.executeAction(json);
    }

    public void executeAction() {
        Json json = this.json;
        List list = this.resolveList();
        json.getSerializersModule();
        FilesKt.writeText$default(this.file, json.encodeToString(((SerializationStrategy) new ArrayListSerializer(StringSerializer.INSTANCE)), list));
    }

}
