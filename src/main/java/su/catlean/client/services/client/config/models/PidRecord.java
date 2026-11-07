package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.ServiceComponent85;

public class PidRecord {

    public static final ServiceComponent85 serviceComponent85;
    private final int countValue;
    private final DetailsRecord detailsRecord;

    public PidRecord(int pid, DetailsRecord activity) {
        this.countValue = pid;
        this.detailsRecord = activity;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public DetailsRecord getDetailsRecord() {
        return this.detailsRecord;
    }

    public int getNumericValue2() {
        return this.countValue;
    }

    public DetailsRecord getDetailsRecord2() {
        return this.detailsRecord;
    }

    public PidRecord resolvePidRecord(int pid, DetailsRecord activity) {
        return new PidRecord(pid, activity);
    }

    public static PidRecord resolvePidRecord(PidRecord arg0, int arg1, DetailsRecord arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = arg0.countValue;
        }
        if ((arg3 & 2)) {
            arg2 = arg0.detailsRecord;
        }
        return arg0.resolvePidRecord(arg1, arg2);
    }

    public String toString() {
        return (null + this.countValue + ", activity=" + this.detailsRecord + ")");
    }

    public int hashCode() {
        int var3 = Integer.hashCode(this.countValue);
        var3 = ((var3 * 2082152836036034591L) + this.detailsRecord.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PidRecord)) {
            return false;
        }
        PidRecord var5 = (PidRecord) other;
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.detailsRecord, var5.detailsRecord))) {
            return false;
        }
        return true;
    }

    public static void executeAction(PidRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.countValue);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) DetailsRecordSerializer.INSTANCE, self.detailsRecord);
    }

    public PidRecord(int seen0, int pid, DetailsRecord activity, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, PidRecordSerializer.INSTANCE.getDescriptor());
        }
        this.countValue = pid;
        this.detailsRecord = activity;
    }

    static {
        serviceComponent85 = new ServiceComponent85();
    }

}
