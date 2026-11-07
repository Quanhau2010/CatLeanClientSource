package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.ServiceComponent4;

public class IdRecord7 {

    public static final ServiceComponent4 serviceComponent4;
    private String textValue;
    private int countValue;
    private int countValue2;
    private int countValue3;
    private String textValue2;
    private int countValue4;
    private boolean enabledFlag;
    private static String textValue3;

    public IdRecord7(String id, int x, int y, int z, String server, int dimension, boolean visible) {
        this.textValue = id;
        this.countValue = x;
        this.countValue2 = y;
        this.countValue3 = z;
        this.textValue2 = server;
        this.countValue4 = dimension;
        this.enabledFlag = visible;
    }

    public IdRecord7(String arg0, int arg1, int arg2, int arg3, String arg4, int arg5, boolean arg6, int arg7, DefaultConstructorMarker arg8) {
        if ((arg7 & 16)) {
            arg4 = "localhost";
        }
        if ((arg7 & 32)) {
            arg5 = 0;
        }
        if ((arg7 & 64)) {
            arg6 = 1;
        }
        this(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(String value) {
        this.textValue = value;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public void updateValue2(int value) {
        this.countValue2 = value;
    }

    public int getNumericValue3() {
        return this.countValue3;
    }

    public void updateValue3(int value) {
        this.countValue3 = value;
    }

    public String getString2() {
        return this.textValue2;
    }

    public void executeAction(String value) {
        this.textValue2 = value;
    }

    public int getNumericValue4() {
        return this.countValue4;
    }

    public void updateValue4(int value) {
        this.countValue4 = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public String getString3() {
        return this.textValue;
    }

    public int getNumericValue5() {
        return this.countValue;
    }

    public int getNumericValue6() {
        return this.countValue2;
    }

    public int getNumericValue7() {
        return this.countValue3;
    }

    public String getString4() {
        return this.textValue2;
    }

    public int getNumericValue8() {
        return this.countValue4;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public IdRecord7 resolveIdRecord7(String id, int x, int y, int z, String server, int dimension, boolean visible) {
        return new IdRecord7(id, x, y, z, server, dimension, visible);
    }

    public static IdRecord7 resolveIdRecord7(IdRecord7 arg0, String arg1, int arg2, int arg3, int arg4, String arg5, int arg6, boolean arg7, int arg8, Object arg9) {
        if ((arg8 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg8 & 2)) {
            arg2 = arg0.countValue;
        }
        if ((arg8 & 4)) {
            arg3 = arg0.countValue2;
        }
        if ((arg8 & 8)) {
            arg4 = arg0.countValue3;
        }
        if ((arg8 & 16)) {
            arg5 = arg0.textValue2;
        }
        if ((arg8 & 32)) {
            arg6 = arg0.countValue4;
        }
        if ((arg8 & 64)) {
            arg7 = arg0.enabledFlag;
        }
        return arg0.resolveIdRecord7(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public String toString() {
        boolean var3 = this.enabledFlag;
        int var4 = this.countValue4;
        String var5 = this.textValue2;
        int var6 = this.countValue3;
        int var7 = this.countValue2;
        int var8 = this.countValue;
        String var9 = this.textValue;
        return ("WayPoint(id=" + var9 + ", x=" + var8 + ", y=" + var7 + ", z=" + var6 + ", server=" + var5 + ", dimension=" + var4 + ", visible=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = this.textValue.hashCode();
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue2));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue3));
        var4 = ((var4 * 31) + this.textValue2.hashCode());
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue4));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag));
        if (var4 != null) {
        }
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord7)) {
            return false;
        }
        IdRecord7 var5 = (IdRecord7) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (this.countValue2 != var5.countValue2) {
            return false;
        }
        if (this.countValue3 != var5.countValue3) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, var5.textValue2))) {
            return false;
        }
        if (this.countValue4 != var5.countValue4) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        return true;
    }

    public static void executeAction(IdRecord7 self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.textValue);
        output.encodeIntElement(serialDesc, 1, self.countValue);
        output.encodeIntElement(serialDesc, 2, self.countValue2);
        output.encodeIntElement(serialDesc, 3, self.countValue3);
        if (output.shouldEncodeElementDefault(serialDesc, 4)) {
        } else {
        }
        if (!(Intrinsics.areEqual(self.textValue2, "localhost"))) {
            output.encodeStringElement(serialDesc, 4, self.textValue2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5)) {
        } else {
        }
        if (self.countValue4) {
            output.encodeIntElement(serialDesc, 5, self.countValue4);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6)) {
        } else {
        }
        output.encodeBooleanElement(serialDesc, 6, self.enabledFlag);
    }

    public IdRecord7(int seen0, String id, int x, int y, int z, String server, int dimension, boolean visible, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (15 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 15, IdRecord7Serializer.INSTANCE.getDescriptor());
        }
        this.textValue = id;
        this.countValue = x;
        this.countValue2 = y;
        this.countValue3 = z;
        if (!((seen0 & 16))) {
            this.textValue2 = "localhost";
        }
        this.textValue2 = server;
        if (!((seen0 & 32))) {
            this.countValue4 = 0;
        }
        this.countValue4 = dimension;
        if (!((seen0 & 64))) {
            this.enabledFlag = 1;
        }
        this.enabledFlag = visible;
    }

    static {
        serviceComponent4 = new ServiceComponent4();
    }

    public static void updateValue(String arg0) {
        textValue3 = arg0;
    }

    public static String getString5() {
        return textValue3;
    }

}
