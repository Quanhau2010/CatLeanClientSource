package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.ServiceComponent121;

public class IdRecord12 {

    public static final ServiceComponent121 serviceComponent121;
    private String textValue;
    private String textValue2;
    private int countValue;
    private String textValue3;
    private String textValue4;
    private boolean enabledFlag;
    private int countValue2;
    private static int countValue3;

    public IdRecord12(String id, String ip, int port, String user, String password, boolean socks4, int ping) {
        this.textValue = id;
        this.textValue2 = ip;
        this.countValue = port;
        this.textValue3 = user;
        this.textValue4 = password;
        this.enabledFlag = socks4;
        this.countValue2 = ping;
    }

    public IdRecord12(String arg0, String arg1, int arg2, String arg3, String arg4, boolean arg5, int arg6, int arg7, DefaultConstructorMarker arg8) {
        if ((arg7 & 64)) {
            arg6 = -1;
        }
        this(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
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

    public void executeAction(String value) {
        this.textValue2 = value;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public String getString3() {
        return this.textValue3;
    }

    public void executeAction(String value) {
        this.textValue3 = value;
    }

    public String getString4() {
        return this.textValue4;
    }

    public void executeAction2(String value) {
        this.textValue4 = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public void updateValue2(int value) {
        this.countValue2 = value;
    }

    public static void executeAction() {
    }

    public String getString5() {
        return this.textValue;
    }

    public String getString6() {
        return this.textValue2;
    }

    public int getNumericValue3() {
        return this.countValue;
    }

    public String getString7() {
        return this.textValue3;
    }

    public String getString8() {
        return this.textValue4;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public int getNumericValue4() {
        return this.countValue2;
    }

    public IdRecord12 resolveIdRecord12(String id, String ip, int port, String user, String password, boolean socks4, int ping) {
        return new IdRecord12(id, ip, port, user, password, socks4, ping);
    }

    public static IdRecord12 resolveIdRecord12(IdRecord12 arg0, String arg1, String arg2, int arg3, String arg4, String arg5, boolean arg6, int arg7, int arg8, Object arg9) {
        if ((arg8 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg8 & 2)) {
            arg2 = arg0.textValue2;
        }
        if ((arg8 & 4)) {
            arg3 = arg0.countValue;
        }
        if ((arg8 & 8)) {
            arg4 = arg0.textValue3;
        }
        if ((arg8 & 16)) {
            arg5 = arg0.textValue4;
        }
        if ((arg8 & 32)) {
            arg6 = arg0.enabledFlag;
        }
        if ((arg8 & 64)) {
            arg7 = arg0.countValue2;
        }
        return arg0.resolveIdRecord12(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public String toString() {
        int var3 = this.countValue2;
        boolean var4 = this.enabledFlag;
        String var5 = this.textValue4;
        String var6 = this.textValue3;
        int var7 = this.countValue;
        String var8 = this.textValue2;
        String var9 = this.textValue;
        return ("Proxy(id=" + var9 + ", ip=" + var8 + ", port=" + var7 + ", user=" + var6 + ", password=" + var5 + ", socks4=" + var4 + ", ping=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = this.textValue.hashCode();
        var4 = ((var4 * 31) + this.textValue2.hashCode());
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue));
        var4 = ((var4 * 31) + this.textValue3.hashCode());
        var4 = ((var4 * 31) + this.textValue4.hashCode());
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue2));
        if (var4 != null) {
        }
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord12)) {
            return false;
        }
        IdRecord12 var5 = (IdRecord12) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, var5.textValue2))) {
            return false;
        }
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue3, var5.textValue3))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue4, var5.textValue4))) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        if (this.countValue2 != var5.countValue2) {
            return false;
        }
        return true;
    }

    public static void executeAction(IdRecord12 self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.textValue);
        output.encodeStringElement(serialDesc, 1, self.textValue2);
        output.encodeIntElement(serialDesc, 2, self.countValue);
        output.encodeStringElement(serialDesc, 3, self.textValue3);
        output.encodeStringElement(serialDesc, 4, self.textValue4);
        output.encodeBooleanElement(serialDesc, 5, self.enabledFlag);
    }

    public IdRecord12(int seen0, String id, String ip, int port, String user, String password, boolean socks4, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (63 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 63, IdRecord12Serializer.INSTANCE.getDescriptor());
        }
        this.textValue = id;
        this.textValue2 = ip;
        this.countValue = port;
        this.textValue3 = user;
        this.textValue4 = password;
        this.enabledFlag = socks4;
        this.countValue2 = -1;
    }

    static {
        serviceComponent121 = new ServiceComponent121();
    }

    public static void updateValue3(int arg0) {
        countValue3 = arg0;
    }

    public static int getNumericValue5() {
        return countValue3;
    }

    public static int getNumericValue6() {
        return 71;
        return 0;
    }

}
