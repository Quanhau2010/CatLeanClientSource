package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.ServiceComponent73;

public class IdRecord10 {

    public static final ServiceComponent73 serviceComponent73;
    private final String textValue;
    private final String textValue2;
    private static int countValue;

    public IdRecord10(String id, String value) {
        this.textValue = id;
        this.textValue2 = value;
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

    public IdRecord10 resolveIdRecord10(String id, String value) {
        return new IdRecord10(id, value);
    }

    public static IdRecord10 resolveIdRecord10(IdRecord10 arg0, String arg1, String arg2, int arg3, Object arg4) {
        if ((arg3 & 1) != 0) {
            arg1 = arg0.textValue;
        }
        if ((arg3 & 2) != 0) {
            arg2 = arg0.textValue2;
        }
        return arg0.resolveIdRecord10(arg1, arg2);
    }

    public String toString() {
        return (null + this.textValue + ", value=" + this.textValue2 + ")");
    }

    public int hashCode() {
        int index = this.textValue.hashCode();
        index = ((index * 31) + this.textValue2.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord10)) {
            return false;
        }
        IdRecord10 idRecord10 = ((IdRecord10) other);
        if (!(Intrinsics.areEqual(this.textValue, idRecord10.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, idRecord10.textValue2))) {
            return false;
        }
        return true;
    }

    public static void executeAction(IdRecord10 self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.textValue);
        output.encodeStringElement(serialDesc, 1, self.textValue2);
    }

    public IdRecord10(int seen0, String id, String value, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, IdRecord10Serializer.INSTANCE.getDescriptor());
        }
        this.textValue = id;
        this.textValue2 = value;
    }

    static {
        serviceComponent73 = new ServiceComponent73();
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 56;
        return 0;
    }

}
