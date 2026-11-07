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

    public void updateValue(long arg0) {
        long var3 = ((arg0 ^ 99836442500987L) >>> 48);
        long var4 = (((arg0 ^ 99836442500987L) << 16) >>> 16);
        if (this.file.createNewFile()) {
        }
        List positions = new ArrayList();
        Json var7 = this.json;
        String var8 = FilesKt.readText$default(this.file);
        int var9 = 0;
        var7.getSerializersModule();
        var7 = var7.decodeFromString((DeserializationStrategy) new ArrayListSerializer(StringSerializer.INSTANCE));
        var8 = positions;
        SharedKt.getLogger().warn("Homies are not loaded from file for some reasons.");
        var7 = new ArrayList();
        Object var6 = var7;
        positions.executeAction();
    }

    public void executeAction(int arg0, int arg1, byte arg2) {
        int var4 = (((arg0 << 32) | ((arg1 << 40) >>> 32)) | ((arg2 << 56) >>> 56));
        long var6 = (var4 ^ 33217499204655L);
        Json var8 = this.json;
        List positions = this.resolveList();
        int var10 = 0;
        var8.getSerializersModule();
        FilesKt.writeText$default(this.file, var8.encodeToString((SerializationStrategy) new ArrayListSerializer(StringSerializer.INSTANCE), positions));
    }

}
