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
        if ((arg5 & 1) != 0) {
            arg1 = arg0.textValue;
        }
        if ((arg5 & 2) != 0) {
            arg2 = arg0.keyRecord;
        }
        if ((arg5 & 4) != 0) {
            arg3 = arg0.enabledFlag;
        }
        if ((arg5 & 8) != 0) {
            arg4 = arg0.textValue2;
        }
        return arg0.resolveIdRecord9(arg1, arg2, arg3, arg4);
    }

    public String toString() {
        String text = this.textValue2;
        boolean flag = this.enabledFlag;
        KeyRecord keyRecord = this.keyRecord;
        String text2 = this.textValue;
        return ("ChatMacro(id=" + text2 + ", bind=" + keyRecord + ", enabled=" + flag + ", message=" + text + ")");
    }

    public int hashCode() {
        int index = this.textValue.hashCode();
        index = ((index * 31) + this.keyRecord.hashCode());
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        index = ((index * 31) + this.textValue2.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord9)) {
            return false;
        }
        IdRecord9 idRecord9 = ((IdRecord9) other);
        if (!(Intrinsics.areEqual(this.textValue, idRecord9.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.keyRecord, idRecord9.keyRecord))) {
            return false;
        }
        if (this.enabledFlag != idRecord9.enabledFlag) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, idRecord9.textValue2))) {
            return false;
        }
        return true;
    }

    public static void executeAction(IdRecord9 self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.getString());
        output.encodeSerializableElement(serialDesc, 1, ((SerializationStrategy) KeyRecordSerializer.INSTANCE), self.getKeyRecord());
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
