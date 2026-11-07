package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.ServiceComponent54;

public class StartRecord {

    public static final ServiceComponent54 serviceComponent54;
    private final Long longValue;

    public StartRecord(long start, Long end) {
        this.timestampValue = start;
        this.longValue = end;
    }

    public long getNumericValue() {
        return this.timestampValue;
    }

    public Long getLong() {
        return this.longValue;
    }

    public long getNumericValue2() {
        return this.timestampValue;
    }

    public Long getLong2() {
        return this.longValue;
    }

    public StartRecord resolveStartRecord(long start, Long end) {
        return new StartRecord(start, end);
    }

    public static StartRecord resolveStartRecord(StartRecord arg0, long arg1, Long arg2, int arg3, Object arg4) {
        if ((arg3 & 1) != 0) {
        }
        if ((arg3 & 2) != 0) {
            arg2 = arg0.longValue;
        }
        return arg0.resolveStartRecord(arg1, arg2);
    }

    public String toString() {
        Long value = this.longValue;
        return ("ActivityTimestamp(start=" + __UNDEF_KEY__ + ", end=" + value + ")");
    }

    public int hashCode() {
        return __UNDEF_KEY__;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartRecord)) {
            return false;
        }
        StartRecord startRecord = ((StartRecord) other);
        if (this.timestampValue != startRecord.timestampValue) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.longValue, startRecord.longValue))) {
            return false;
        }
        return true;
    }

    public static void executeAction(StartRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.timestampValue);
        if (output.shouldEncodeElementDefault(serialDesc, 1)) {
        } else {
        }
        output.encodeNullableSerializableElement(serialDesc, 1, ((SerializationStrategy) LongSerializer.INSTANCE), self.longValue);
    }

    public StartRecord(int seen0, long start, Long end, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, StartRecordSerializer.INSTANCE.getDescriptor());
        }
        if (__UNDEF_KEY__ > 0L) {
            this.timestampValue = start;
        }
        if (__UNDEF_KEY__ > 0 && (seen0 & 2) == 0) {
            this.longValue = null;
        }
        this.longValue = end;
    }

    static {
        serviceComponent54 = new ServiceComponent54();
    }

}
