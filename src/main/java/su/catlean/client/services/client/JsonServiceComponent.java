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
import su.catlean.client.services.client.config.models.WayPointsRecord;

public class JsonServiceComponent implements Contract3 {

    private final Json json;
    private final File file;
    public WayPointsRecord wayPointsRecord;

    public JsonServiceComponent(Json json) {
        this.json = json;
        this.file = new File(ServiceComponent65.getFile(), "waypoints.ctlon");
    }

    public WayPointsRecord resolveWayPointsRecord() {
        if (this.wayPointsRecord != null) {
            return this.wayPointsRecord;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public void executeAction(WayPointsRecord value) {
        this.wayPointsRecord = value;
    }

    public void updateValue(long arg0) {
        long var3 = ((arg0 ^ 139522763903252L) >>> 48);
        long var4 = (((arg0 ^ 139522763903252L) << 16) >>> 48);
        long var5 = (((arg0 ^ 139522763903252L) << 32) >>> 32);
        long var6 = (arg0 ^ 135137456124477L);
        if (this.file.createNewFile()) {
        }
        WayPointsRecord var12 = new WayPointsRecord(new ArrayList());
        Json var9 = this.json;
        String var10 = FilesKt.readText$default(this.file);
        int var11 = 0;
        var9.getSerializersModule();
        var9 = (WayPointsRecord) var9.decodeFromString((DeserializationStrategy) WayPointsRecord.serviceComponent72.getKSerializer());
        var10 = var12;
        SharedKt.getLogger().warn("Waypoints are not loaded from file for some reasons.");
        var9 = new WayPointsRecord(new ArrayList());
        Object var8 = var9;
        var12.executeAction();
    }

    public void executeAction(int arg0, int arg1, byte arg2) {
        int var4 = (((arg0 << 32) | ((arg1 << 40) >>> 32)) | ((arg2 << 56) >>> 56));
        long var6 = (var4 ^ 49995006559783L);
        Json var8 = this.json;
        WayPointsRecord var9 = this.resolveWayPointsRecord();
        int var10 = 0;
        var8.getSerializersModule();
        FilesKt.writeText$default(this.file, var8.encodeToString((SerializationStrategy) WayPointsRecord.serviceComponent72.getKSerializer()));
    }

}
