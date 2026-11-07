package su.catlean.client.services.client.config.models;

import java.util.List;
import kotlin.Lazy;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

public class WayPointsRecordSerializer implements GeneratedSerializer {

    public static final WayPointsRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private WayPointsRecordSerializer() {
    }

    public void executeAction(Encoder encoder, WayPointsRecord value) {
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        WayPointsRecord.executeAction(value);
        var6.endStructure();
    }

    public WayPointsRecord resolveWayPointsRecord(Decoder decoder) {
        SerialDescriptor var10 = serialDescriptor;
        int var11 = 1;
        int var13 = 0;
        CompositeDecoder var15 = decoder.beginStructure();
        Lazy[] var16 = WayPointsRecord.process();
        if (var9 != null) {
            if (var15.decodeSequentially()) {
            }
            List positions = var15.decodeSerializableElement(0, (DeserializationStrategy) var16[0].getValue());
            if (0L >= 0) {
                var13 = (var13 | 1);
            }
        }
        if (var9 == null && var11) {
            int var12 = var15.decodeElementIndex();
            if (var9 != null) {
                if (var9 != null) {
                }
                var11 = 0;
                if (0L >= 0) {
                    positions = var15.decodeSerializableElement(0, (DeserializationStrategy) var16[0].getValue(), positions);
                    var13 = (var13 | 1);
                }
            }
            var15.endStructure();
        }
        return new WayPointsRecord(positions, null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] var1 = WayPointsRecord.process();
        KSerializer[] var2 = new KSerializer[1];
        var2[0] = var1[0].getValue();
        return var2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (WayPointsRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveWayPointsRecord(decoder);
    }

    static {
        INSTANCE = new WayPointsRecordSerializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.js", (GeneratedSerializer) INSTANCE, 1);
        var11.addElement("wayPoints", 0);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
