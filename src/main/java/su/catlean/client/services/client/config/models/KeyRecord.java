package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent70;

public class KeyRecord {

    public static final ServiceComponent70 serviceComponent70;
    private int countValue;
    private boolean enabledFlag;
    private boolean enabledFlag2;
    private static Module[] moduleArray;

    public KeyRecord(int key, boolean hold, boolean mouse) {
        this.countValue = key;
        this.enabledFlag = hold;
        this.enabledFlag2 = mouse;
    }

    public KeyRecord(int arg0, boolean arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
        if ((arg3 & 1)) {
            arg0 = -1;
        }
        if ((arg3 & 2)) {
            arg1 = 0;
        }
        if ((arg3 & 4)) {
            arg2 = 0;
        }
        this(arg0, arg1, arg2);
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public boolean isActive2() {
        return this.enabledFlag2;
    }

    public void updateValue2(boolean value) {
        this.enabledFlag2 = value;
    }

    public int getNumericValue2() {
        return this.countValue;
    }

    public boolean isActive3() {
        return this.enabledFlag;
    }

    public boolean isActive4() {
        return this.enabledFlag2;
    }

    public KeyRecord resolveKeyRecord(int key, boolean hold, boolean mouse) {
        return new KeyRecord(key, hold, mouse);
    }

    public static KeyRecord resolveKeyRecord(KeyRecord arg0, int arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        if ((arg4 & 1)) {
            arg1 = arg0.countValue;
        }
        if ((arg4 & 2)) {
            arg2 = arg0.enabledFlag;
        }
        if ((arg4 & 4)) {
            arg3 = arg0.enabledFlag2;
        }
        return arg0.resolveKeyRecord(arg1, arg2, arg3);
    }

    public String toString() {
        boolean var3 = this.enabledFlag2;
        boolean var4 = this.enabledFlag;
        int var5 = this.countValue;
        return ("Bind(key=" + var5 + ", hold=" + var4 + ", mouse=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Integer.hashCode(this.countValue);
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag));
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag2));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyRecord)) {
            return false;
        }
        KeyRecord var5 = (KeyRecord) other;
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        if (this.enabledFlag2 != var5.enabledFlag2) {
            return false;
        }
        return true;
    }

    public static void executeAction(KeyRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0)) {
        } else {
        }
        if (0L >= 0) {
            if (self.countValue != -1) {
                output.encodeIntElement(serialDesc, 0, self.countValue);
            }
        }
        if (0L > 0 && var8 == null) {
            if (output.shouldEncodeElementDefault(serialDesc, 1)) {
            } else {
            }
        }
        if (0L > 0) {
            if (self.enabledFlag) {
                output.encodeBooleanElement(serialDesc, 1, self.enabledFlag);
            }
        }
        if (0L > 0 && var8 == null) {
            if (output.shouldEncodeElementDefault(serialDesc, 2)) {
            } else {
            }
        }
        output.encodeBooleanElement(serialDesc, 2, self.enabledFlag2);
    }

    public KeyRecord(int seen0, int key, boolean hold, boolean mouse, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 0, KeyRecordSerializer.INSTANCE.getDescriptor());
        }
        if (var11 == null) {
            if (0L > 0L && !((seen0 & 1))) {
                this.countValue = -1;
            }
            if (0L >= 0L) {
            }
            this.countValue = key;
        }
        if (0L < 0) {
            if (!((seen0 & 2))) {
                this.enabledFlag = 0;
                if (0L <= 0) {
                }
                this.enabledFlag = hold;
            }
        }
        if (!((seen0 & 4))) {
            this.enabledFlag2 = 0;
        }
        this.enabledFlag2 = mouse;
    }

    public KeyRecord() {
        this();
    }

    static {
        serviceComponent70 = new ServiceComponent70();
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
