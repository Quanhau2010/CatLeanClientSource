package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.api.contracts.Contract8;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent51;

public class IdRecord11 implements Contract8 {

    public static final ServiceComponent51 serviceComponent51;
    private String textValue;
    private KeyRecord keyRecord;
    private boolean enabledFlag;
    private String textValue2;
    private String textValue3;
    private String textValue4;
    private String textValue5;
    private boolean enabledFlag2;
    private static Module[] moduleArray;

    public IdRecord11(String id, KeyRecord bind, boolean enabled, String module, String setting, String pressValue, String releaseValue, boolean hold) {
        this.textValue = id;
        this.keyRecord = bind;
        this.enabledFlag = enabled;
        this.textValue2 = module;
        this.textValue3 = setting;
        this.textValue4 = pressValue;
        this.textValue5 = releaseValue;
        this.enabledFlag2 = hold;
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
        return this.textValue3;
    }

    public void executeAction2(String value) {
        this.textValue3 = value;
    }

    public String getString3() {
        return this.textValue4;
    }

    public void executeAction(String value) {
        this.textValue4 = value;
    }

    public String getString4() {
        return this.textValue5;
    }

    public void executeAction3(String value) {
        this.textValue5 = value;
    }

    public boolean isActive() {
        return this.enabledFlag2;
    }

    public void updateValue(boolean value) {
        this.enabledFlag2 = value;
    }

    public String getString5() {
        return this.textValue;
    }

    public KeyRecord getKeyRecord() {
        return this.keyRecord;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public String getString6() {
        return this.textValue2;
    }

    public String getString7() {
        return this.textValue3;
    }

    public String getString8() {
        return this.textValue4;
    }

    public String getString9() {
        return this.textValue5;
    }

    public boolean isActive3() {
        return this.enabledFlag2;
    }

    public IdRecord11 resolveIdRecord11(String id, KeyRecord bind, boolean enabled, String module, String setting, String pressValue, String releaseValue, boolean hold) {
        return new IdRecord11(id, bind, enabled, module, setting, pressValue, releaseValue, hold);
    }

    public static IdRecord11 resolveIdRecord11(IdRecord11 arg0, String arg1, KeyRecord arg2, boolean arg3, String arg4, String arg5, String arg6, String arg7, boolean arg8, int arg9, Object arg10) {
        if ((arg9 & 1) != 0) {
            arg1 = arg0.textValue;
        }
        if ((arg9 & 2) != 0) {
            arg2 = arg0.keyRecord;
        }
        if ((arg9 & 4) != 0) {
            arg3 = arg0.enabledFlag;
        }
        if ((arg9 & 8) != 0) {
            arg4 = arg0.textValue2;
        }
        if ((arg9 & 16) != 0) {
            arg5 = arg0.textValue3;
        }
        if ((arg9 & 32) != 0) {
            arg6 = arg0.textValue4;
        }
        if ((arg9 & 64) != 0) {
            arg7 = arg0.textValue5;
        }
        if ((arg9 & 128) != 0) {
            arg8 = arg0.enabledFlag2;
        }
        return arg0.resolveIdRecord11(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public String toString() {
        boolean flag = this.enabledFlag2;
        String text = this.textValue5;
        String text2 = this.textValue4;
        String text3 = this.textValue3;
        String text4 = this.textValue2;
        boolean flag2 = this.enabledFlag;
        KeyRecord keyRecord = this.keyRecord;
        String text5 = this.textValue;
        return ("SettingMacro(id=" + text5 + ", bind=" + keyRecord + ", enabled=" + flag2 + ", module=" + text4 + ", setting=" + text3 + ", pressValue=" + text2 + ", releaseValue=" + text + ", hold=" + flag + ")");
    }

    public int hashCode() {
        int index = this.textValue.hashCode();
        index = ((index * 31) + this.keyRecord.hashCode());
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        index = ((index * 31) + this.textValue2.hashCode());
        index = ((index * 31) + this.textValue3.hashCode());
        index = ((index * 31) + this.textValue4.hashCode());
        index = ((index * 31) + this.textValue5.hashCode());
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag2));
        if (!(__UNDEF_KEY__)) {
        }
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord11)) {
            return false;
        }
        IdRecord11 idRecord11 = ((IdRecord11) other);
        if (!(Intrinsics.areEqual(this.textValue, idRecord11.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.keyRecord, idRecord11.keyRecord))) {
            return false;
        }
        if (this.enabledFlag != idRecord11.enabledFlag) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, idRecord11.textValue2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue3, idRecord11.textValue3))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue4, idRecord11.textValue4))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue5, idRecord11.textValue5))) {
            return false;
        }
        if (this.enabledFlag2 != idRecord11.enabledFlag2) {
            return false;
        }
        return true;
    }

    public static void executeAction(IdRecord11 self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.getString());
        output.encodeSerializableElement(serialDesc, 1, ((SerializationStrategy) KeyRecordSerializer.INSTANCE), self.getKeyRecord());
        output.encodeBooleanElement(serialDesc, 2, self.isActive());
        output.encodeStringElement(serialDesc, 3, self.textValue2);
        output.encodeStringElement(serialDesc, 4, self.textValue3);
        output.encodeStringElement(serialDesc, 5, self.textValue4);
        output.encodeStringElement(serialDesc, 6, self.textValue5);
        output.encodeBooleanElement(serialDesc, 7, self.enabledFlag2);
    }

    public IdRecord11(int seen0, String id, KeyRecord bind, boolean enabled, String module, String setting, String pressValue, String releaseValue, boolean hold, SerializationConstructorMarker serializationConstructorMarker) {
        if (255 != (255 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 255, IdRecord11Serializer.INSTANCE.getDescriptor());
        }
        this.textValue = id;
        this.keyRecord = bind;
        this.enabledFlag = enabled;
        this.textValue2 = module;
        this.textValue3 = setting;
        this.textValue4 = pressValue;
        this.textValue5 = releaseValue;
        this.enabledFlag2 = hold;
    }

    static {
        serviceComponent51 = new ServiceComponent51();
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
