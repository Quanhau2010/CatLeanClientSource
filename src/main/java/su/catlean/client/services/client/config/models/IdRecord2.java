package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.DefaultConstructorMarker;
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

    public IdRecord2(String arg0, String arg1, String arg2, int arg3, DefaultConstructorMarker arg4) {
        if ((arg3 & 1)) {
            arg0 = "none";
        }
        if ((arg3 & 2)) {
            arg1 = "none";
        }
        if ((arg3 & 4)) {
            arg2 = "none";
        }
        this(arg0, arg1, arg2);
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
        if (var5 == null) {
            if (StringsKt.startsWith$default(this.textValue3, "a_")) {
                int var6 = size;
                String var7 = this.textValue3;
                String var8 = this.textValue;
            } else {
            }
            int var9 = size;
            String var10 = this.textValue3;
            String var11 = this.textValue;
        }
        return ("https://cdn.discordapp.com/avatars/" + var11 + "/" + var10 + ".png?size=" + var9);
    }

    public static String resolveString(IdRecord2 arg0, int arg1, boolean arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = 128;
        }
        if ((arg3 & 2)) {
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
        if ((arg4 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg4 & 2)) {
            arg2 = arg0.textValue2;
        }
        if ((arg4 & 4)) {
            arg3 = arg0.textValue3;
        }
        return arg0.resolveIdRecord2(arg1, arg2, arg3);
    }

    public String toString() {
        String var3 = this.textValue3;
        String var4 = this.textValue2;
        String var5 = this.textValue;
        return ("IPCUser(id=" + var5 + ", username=" + var4 + ", avatar=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.textValue.hashCode();
        var3 = ((var3 * 31) + this.textValue2.hashCode());
        var3 = ((var3 * 31) + this.textValue3.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord2)) {
            return false;
        }
        IdRecord2 var5 = (IdRecord2) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, var5.textValue2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue3, var5.textValue3))) {
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
        if ((0 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 0, IdRecord2Serializer.INSTANCE.getDescriptor());
        }
        if (!((seen0 & 1))) {
            this.textValue = "none";
        }
        this.textValue = id;
        if (!((seen0 & 2))) {
            this.textValue2 = "none";
        }
        this.textValue2 = username;
        if (!((seen0 & 4))) {
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
