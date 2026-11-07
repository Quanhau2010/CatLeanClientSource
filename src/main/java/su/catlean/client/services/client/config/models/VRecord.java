package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.ServiceComponent35;

public class VRecord {

    public static final ServiceComponent35 serviceComponent35;
    private final int countValue;
    private final String textValue;

    public VRecord(int v, String clientId) {
        this.countValue = v;
        this.textValue = clientId;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public String getString() {
        return this.textValue;
    }

    public int getNumericValue2() {
        return this.countValue;
    }

    public String getString2() {
        return this.textValue;
    }

    public VRecord resolveVRecord(int v, String clientId) {
        return new VRecord(v, clientId);
    }

    public static VRecord resolveVRecord(VRecord arg0, int arg1, String arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = arg0.countValue;
        }
        if ((arg3 & 2)) {
            arg2 = arg0.textValue;
        }
        return arg0.resolveVRecord(arg1, arg2);
    }

    public String toString() {
        return (null + this.countValue + ", clientId=" + this.textValue + ")");
    }

    public int hashCode() {
        int var3 = Integer.hashCode(this.countValue);
        var3 = ((var3 * 2234904434545000479L) + this.textValue.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VRecord)) {
            return false;
        }
        VRecord var5 = (VRecord) other;
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        return true;
    }

    public static void executeAction(VRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.countValue);
        output.encodeStringElement(serialDesc, 1, self.textValue);
    }

    public VRecord(int seen0, int v, String clientId, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, VRecordSerializer.INSTANCE.getDescriptor());
        }
        this.countValue = v;
        this.textValue = clientId;
    }

    static {
        serviceComponent35 = new ServiceComponent35();
    }

}
