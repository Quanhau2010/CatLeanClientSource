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

    public void updateValue() {
        if (this.file.createNewFile()) {
        }
        WayPointsRecord wayPointsRecord = new WayPointsRecord();
        Json json = this.json;
        String text = FilesKt.readText$default(this.file);
        json.getSerializersModule();
        json = ((WayPointsRecord) json.decodeFromString(((DeserializationStrategy) WayPointsRecord.serviceComponent72.getKSerializer()), text));
        text = wayPointsRecord;
        SharedKt.getLogger().warn("Waypoints are not loaded from file for some reasons.");
        json = new WayPointsRecord();
        wayPointsRecord.executeAction(json);
    }

    public void executeAction() {
        Json json = this.json;
        WayPointsRecord wayPointsRecord = this.resolveWayPointsRecord();
        json.getSerializersModule();
        FilesKt.writeText$default(this.file, json.encodeToString(((SerializationStrategy) WayPointsRecord.serviceComponent72.getKSerializer()), wayPointsRecord));
    }

}
