package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.ServiceComponent117;

public class IdRecord2 {

    public static final ServiceComponent117 serviceComponent117;
    private String textValue;
    private String textValue2;
    private String textValue3;
    private static String[] textValueArray;

    public IdRecord2(String id, String username, String avatar) {
        this.textValue = id;
        this.textValue2 = username;
        this.textValue3 = avatar;
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(String value) {
        this.textValue = value;
    }

    public String getString2() {
        return this.textValue2;
    }

    public void executeAction2(String value) {
        this.textValue2 = value;
    }

    public String getString3() {
        return this.textValue3;
    }

    public void executeAction(String value) {
        this.textValue3 = value;
    }

    public String resolveString(int size, boolean forcePng) {
        if (__UNDEF_KEY__ == null) {
            if (StringsKt.startsWith$default(this.textValue3, "a_", false)) {
                String text = this.textValue3;
                String text2 = this.textValue;
            } else {
                String text3 = this.textValue3;
                String text4 = this.textValue;
            }
        }
        return ("https://cdn.discordapp.com/avatars/" + text4 + "/" + text3 + ".png?size=" + size);
    }

    public static String resolveString(IdRecord2 arg0, int arg1, boolean arg2, int arg3, Object arg4) {
        if ((arg3 & 1) != 0) {
            arg1 = 128;
        }
        if ((arg3 & 2) != 0) {
            arg2 = 0;
        }
        return arg0.resolveString(arg1, arg2);
    }

    public String getString4() {
        return this.textValue;
    }

    public String getString5() {
        return this.textValue2;
    }

    public String getString6() {
        return this.textValue3;
    }

    public IdRecord2 resolveIdRecord2(String id, String username, String avatar) {
        return new IdRecord2(id, username, avatar);
    }

    public static IdRecord2 resolveIdRecord2(IdRecord2 arg0, String arg1, String arg2, String arg3, int arg4, Object arg5) {
        if ((arg4 & 1) != 0) {
            arg1 = arg0.textValue;
        }
        if ((arg4 & 2) != 0) {
            arg2 = arg0.textValue2;
        }
        if ((arg4 & 4) != 0) {
            arg3 = arg0.textValue3;
        }
        return arg0.resolveIdRecord2(arg1, arg2, arg3);
    }

    public String toString() {
        String text = this.textValue3;
        String text2 = this.textValue2;
        String text3 = this.textValue;
        return ("IPCUser(id=" + text3 + ", username=" + text2 + ", avatar=" + text + ")");
    }

    public int hashCode() {
        int index = this.textValue.hashCode();
        index = ((index * 31) + this.textValue2.hashCode());
        index = ((index * 31) + this.textValue3.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord2)) {
            return false;
        }
        IdRecord2 idRecord2 = ((IdRecord2) other);
        if (!(Intrinsics.areEqual(this.textValue, idRecord2.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, idRecord2.textValue2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue3, idRecord2.textValue3))) {
            return false;
        }
        return true;
    }

    public static void executeAction(IdRecord2 self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0)) {
        } else {
        }
        if (!(Intrinsics.areEqual(self.textValue, "none"))) {
            output.encodeStringElement(serialDesc, 0, self.textValue);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1)) {
        } else {
        }
        if (!(Intrinsics.areEqual(self.textValue2, "none"))) {
            output.encodeStringElement(serialDesc, 1, self.textValue2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2)) {
        } else {
        }
        output.encodeStringElement(serialDesc, 2, self.textValue3);
    }

    public IdRecord2(int seen0, String id, String username, String avatar, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 0, IdRecord2Serializer.INSTANCE.getDescriptor());
        }
        if ((seen0 & 1) == 0) {
            this.textValue = "none";
        }
        this.textValue = id;
        if ((seen0 & 2) == 0) {
            this.textValue2 = "none";
        }
        this.textValue2 = username;
        if ((seen0 & 4) == 0) {
            this.textValue3 = "none";
        }
        this.textValue3 = avatar;
    }

    public IdRecord2() {
        this();
    }

    static {
        serviceComponent117 = new ServiceComponent117();
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
