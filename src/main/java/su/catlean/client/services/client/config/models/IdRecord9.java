package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.api.contracts.Contract8;
import su.catlean.client.services.client.ServiceComponent27;

public class IdRecord9 implements Contract8 {

    public static final ServiceComponent27 serviceComponent27;
    private String textValue;
    private KeyRecord keyRecord;
    private boolean enabledFlag;
    private String textValue2;
    private static String[] textValueArray;

    public IdRecord9(String id, KeyRecord bind, boolean enabled, String message) {
        this.textValue = id;
        this.keyRecord = bind;
        this.enabledFlag = enabled;
        this.textValue2 = message;
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(String value) {
        this.textValue = value;
    }

    public KeyRecord getKeyRecord() {
        return this.keyRecord;
    }

    public void executeAction(KeyRecord value) {
        this.keyRecord = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public String getString() {
        return this.textValue2;
    }

    public void executeAction(String value) {
        this.textValue2 = value;
    }

    public String getString2() {
        return this.textValue;
    }

    public KeyRecord getKeyRecord() {
        return this.keyRecord;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public String getString3() {
        return this.textValue2;
    }

    public IdRecord9 resolveIdRecord9(String id, KeyRecord bind, boolean enabled, String message) {
        return new IdRecord9(id, bind, enabled, message);
    }

    public static IdRecord9 resolveIdRecord9(IdRecord9 arg0, String arg1, KeyRecord arg2, boolean arg3, String arg4, int arg5, Object arg6) {
        if ((arg5 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg5 & 2)) {
            arg2 = arg0.keyRecord;
        }
        if ((arg5 & 4)) {
            arg3 = arg0.enabledFlag;
        }
        if ((arg5 & 8)) {
            arg4 = arg0.textValue2;
        }
        return arg0.resolveIdRecord9(arg1, arg2, arg3, arg4);
    }

    public String toString() {
        String var3 = this.textValue2;
        boolean var4 = this.enabledFlag;
        KeyRecord var5 = this.keyRecord;
        String var6 = this.textValue;
        return ("ChatMacro(id=" + var6 + ", bind=" + var5 + ", enabled=" + var4 + ", message=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.textValue.hashCode();
        var3 = ((var3 * 31) + this.keyRecord.hashCode());
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag));
        var3 = ((var3 * 31) + this.textValue2.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord9)) {
            return false;
        }
        IdRecord9 var5 = (IdRecord9) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.keyRecord, var5.keyRecord))) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, var5.textValue2))) {
            return false;
        }
        return true;
    }

    public static void executeAction(IdRecord9 self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.getString());
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) KeyRecordSerializer.INSTANCE, self.getKeyRecord());
        output.encodeBooleanElement(serialDesc, 2, self.isActive());
        output.encodeStringElement(serialDesc, 3, self.textValue2);
    }

    public IdRecord9(int seen0, String id, KeyRecord bind, boolean enabled, String message, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (15 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 15, IdRecord9Serializer.INSTANCE.getDescriptor());
        }
        this.textValue = id;
        this.keyRecord = bind;
        this.enabledFlag = enabled;
        this.textValue2 = message;
    }

    static {
        serviceComponent27 = new ServiceComponent27();
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
