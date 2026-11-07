package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.ServiceComponent48;

public class LabelRecord {

    public static final ServiceComponent48 serviceComponent48;
    private final String textValue;
    private final String textValue2;

    public LabelRecord(String label, String url) {
        this.textValue = label;
        this.textValue2 = url;
    }

    public String getString() {
        return this.textValue;
    }

    public String getString2() {
        return this.textValue2;
    }

    public String getString3() {
        return this.textValue;
    }

    public String getString4() {
        return this.textValue2;
    }

    public LabelRecord resolveLabelRecord(String label, String url) {
        return new LabelRecord(label, url);
    }

    public static LabelRecord resolveLabelRecord(LabelRecord arg0, String arg1, String arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg3 & 2)) {
            arg2 = arg0.textValue2;
        }
        return arg0.resolveLabelRecord(arg1, arg2);
    }

    public String toString() {
        return (null + this.textValue + ", url=" + this.textValue2 + ")");
    }

    public int hashCode() {
        int var3 = this.textValue.hashCode();
        var3 = ((var3 * -3981489057677967329L) + this.textValue2.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LabelRecord)) {
            return false;
        }
        LabelRecord var5 = (LabelRecord) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, var5.textValue2))) {
            return false;
        }
        return true;
    }

    public static void executeAction(LabelRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.textValue);
        output.encodeStringElement(serialDesc, 1, self.textValue2);
    }

    public LabelRecord(int seen0, String label, String url, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, LabelRecordSerializer.INSTANCE.getDescriptor());
        }
        this.textValue = label;
        this.textValue2 = url;
    }

    static {
        serviceComponent48 = new ServiceComponent48();
    }

}
