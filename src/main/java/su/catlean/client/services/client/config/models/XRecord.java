package su.catlean.client.services.client.config.models;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.ServiceComponent16;

public class XRecord {

    public static final ServiceComponent16 serviceComponent16;
    private float factorValue;
    private float factorValue2;

    public XRecord(float x, float y) {
        this.factorValue = x;
        this.factorValue2 = y;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public void updateValue2(float value) {
        this.factorValue2 = value;
    }

    public float getNumericValue3() {
        return this.factorValue;
    }

    public float getNumericValue4() {
        return this.factorValue2;
    }

    public XRecord resolveXRecord(float x, float y) {
        return new XRecord(x, y);
    }

    public static XRecord resolveXRecord(XRecord arg0, float arg1, float arg2, int arg3, Object arg4) {
        if ((arg3 & 1) != 0) {
            arg1 = arg0.factorValue;
        }
        if ((arg3 & 2) != 0) {
            arg2 = arg0.factorValue2;
        }
        return arg0.resolveXRecord(arg1, arg2);
    }

    public String toString() {
        return (null + this.factorValue + ", y=" + this.factorValue2 + ")");
    }

    public int hashCode() {
        int index = Float.hashCode(this.factorValue);
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof XRecord)) {
            return false;
        }
        XRecord xRecord = ((XRecord) other);
        if (Float.compare(this.factorValue, xRecord.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, xRecord.factorValue2)) {
            return false;
        }
        return true;
    }

    public static void executeAction(XRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0)) {
        } else {
        }
        if (Float.compare(self.factorValue, 0.5F)) {
            output.encodeFloatElement(serialDesc, 0, self.factorValue);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1)) {
        } else {
        }
        output.encodeFloatElement(serialDesc, 1, self.factorValue2);
    }

    public XRecord(int seen0, float x, float y, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 0, XRecordSerializer.INSTANCE.getDescriptor());
        }
        if (__UNDEF_KEY__ == null) {
            if (__UNDEF_KEY__ >= 0 && (seen0 & 1) == 0) {
                this.factorValue = 0.5F;
                if (__UNDEF_KEY__ >= 0) {
                    this.factorValue = x;
                }
            }
        }
        if ((seen0 & 2) == 0) {
            this.factorValue2 = 0.5F;
        }
        this.factorValue2 = y;
    }

    public XRecord() {
        this(0.0F, 0.0F);
    }

    static {
        serviceComponent16 = new ServiceComponent16();
    }

}
