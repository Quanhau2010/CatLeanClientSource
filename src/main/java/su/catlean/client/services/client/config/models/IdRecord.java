package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.api.contracts.Contract8;
import su.catlean.client.services.client.ServiceComponent29;

public class IdRecord implements Contract8 {

    public static final ServiceComponent29 serviceComponent29;
    private String textValue;
    private KeyRecord keyRecord;
    private boolean enabledFlag;
    private String textValue2;
    private boolean enabledFlag2;
    private static boolean enabledFlag3;

    public IdRecord(String id, KeyRecord bind, boolean enabled, String item, boolean legit) {
        this.textValue = id;
        this.keyRecord = bind;
        this.enabledFlag = enabled;
        this.textValue2 = item;
        this.enabledFlag2 = legit;
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

    public boolean isActive() {
        return this.enabledFlag2;
    }

    public void updateValue(boolean value) {
        this.enabledFlag2 = value;
    }

    public String getString2() {
        return this.textValue;
    }

    public KeyRecord getKeyRecord() {
        return this.keyRecord;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public String getString3() {
        return this.textValue2;
    }

    public boolean isActive3() {
        return this.enabledFlag2;
    }

    public IdRecord resolveIdRecord(String id, KeyRecord bind, boolean enabled, String item, boolean legit) {
        return new IdRecord(id, bind, enabled, item, legit);
    }

    public static IdRecord resolveIdRecord(IdRecord arg0, String arg1, KeyRecord arg2, boolean arg3, String arg4, boolean arg5, int arg6, Object arg7) {
        if ((arg6 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg6 & 2)) {
            arg2 = arg0.keyRecord;
        }
        if ((arg6 & 4)) {
            arg3 = arg0.enabledFlag;
        }
        if ((arg6 & 8)) {
            arg4 = arg0.textValue2;
        }
        if ((arg6 & 16)) {
            arg5 = arg0.enabledFlag2;
        }
        return arg0.resolveIdRecord(arg1, arg2, arg3, arg4, arg5);
    }

    public String toString() {
        boolean var3 = this.enabledFlag2;
        String var4 = this.textValue2;
        boolean var5 = this.enabledFlag;
        KeyRecord var6 = this.keyRecord;
        String var7 = this.textValue;
        return ("ItemMacro(id=" + var7 + ", bind=" + var6 + ", enabled=" + var5 + ", item=" + var4 + ", legit=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.textValue.hashCode();
        var3 = ((var3 * 31) + this.keyRecord.hashCode());
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag));
        var3 = ((var3 * 31) + this.textValue2.hashCode());
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag2));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord)) {
            return false;
        }
        IdRecord var5 = (IdRecord) other;
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
        if (this.enabledFlag2 != var5.enabledFlag2) {
            return false;
        }
        return true;
    }

    public static void executeAction(IdRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.getString());
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) KeyRecordSerializer.INSTANCE, self.getKeyRecord());
        output.encodeBooleanElement(serialDesc, 2, self.isActive());
        output.encodeStringElement(serialDesc, 3, self.textValue2);
        output.encodeBooleanElement(serialDesc, 4, self.enabledFlag2);
    }

    public IdRecord(int seen0, String id, KeyRecord bind, boolean enabled, String item, boolean legit, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (31 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 31, IdRecordSerializer.INSTANCE.getDescriptor());
        }
        this.textValue = id;
        this.keyRecord = bind;
        this.enabledFlag = enabled;
        this.textValue2 = item;
        this.enabledFlag2 = legit;
    }

    static {
        serviceComponent29 = new ServiceComponent29();
    }

    public static void updateValue2(boolean arg0) {
        enabledFlag3 = arg0;
    }

    public static boolean isActive4() {
        return enabledFlag3;
    }

    public static boolean isActive5() {
        return true;
        return false;
    }

}
