package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.DefaultConstructorMarker;
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
    private final Long long;

    public StartRecord(long start, Long end) {
        this.timestampValue = start;
        this.long = end;
    }

    public StartRecord(long arg0, Long arg1, int arg2, DefaultConstructorMarker arg3) {
        if ((arg2 & 2)) {
        }
        this(arg0, arg1);
    }

    public long getNumericValue() {
        return this.timestampValue;
    }

    public Long getLong() {
        return this.long;
    }

    public long getNumericValue2() {
        return this.timestampValue;
    }

    public Long getLong2() {
        return this.long;
    }

    public StartRecord resolveStartRecord(long start, Long end) {
        return new StartRecord(start, end);
    }

    public static StartRecord resolveStartRecord(StartRecord arg0, long arg1, Long arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
        }
        if ((arg3 & 2)) {
            arg2 = arg0.long;
        }
        return arg0.resolveStartRecord(arg1, arg2);
    }

    public String toString() {
        Long var3 = this.long;
        return ("ActivityTimestamp(start=" + var4 + ", end=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = ((var4 * 7846266987587043359L) + this.long != null);
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartRecord)) {
            return false;
        }
        StartRecord var5 = (StartRecord) other;
        if (this.timestampValue != var5.timestampValue) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.long, var5.long))) {
            return false;
        }
        return true;
    }

    public static void executeAction(StartRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.timestampValue);
        if (output.shouldEncodeElementDefault(serialDesc, 1)) {
        } else {
        }
        output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) LongSerializer.INSTANCE, self.long);
    }

    public StartRecord(int seen0, long start, Long end, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, StartRecordSerializer.INSTANCE.getDescriptor());
        }
        if (0L > 0L) {
            this.timestampValue = start;
        }
        if (0L > 0 && !((seen0 & 2))) {
            this.long = null;
        }
        this.long = end;
    }

    static {
        serviceComponent54 = new ServiceComponent54();
    }

}
