package su.catlean.client.services.client.config.models;

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
        if ((arg4 & 1) != 0) {
            arg1 = arg0.countValue;
        }
        if ((arg4 & 2) != 0) {
            arg2 = arg0.enabledFlag;
        }
        if ((arg4 & 4) != 0) {
            arg3 = arg0.enabledFlag2;
        }
        return arg0.resolveKeyRecord(arg1, arg2, arg3);
    }

    public String toString() {
        boolean flag = this.enabledFlag2;
        boolean flag2 = this.enabledFlag;
        int index = this.countValue;
        return ("Bind(key=" + index + ", hold=" + flag2 + ", mouse=" + flag + ")");
    }

    public int hashCode() {
        int index = Integer.hashCode(this.countValue);
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag2));
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyRecord)) {
            return false;
        }
        KeyRecord keyRecord = ((KeyRecord) other);
        if (this.countValue != keyRecord.countValue) {
            return false;
        }
        if (this.enabledFlag != keyRecord.enabledFlag) {
            return false;
        }
        if (this.enabledFlag2 != keyRecord.enabledFlag2) {
            return false;
        }
        return true;
    }

    public static void executeAction(KeyRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0)) {
        } else {
        }
        if (__UNDEF_KEY__ >= 0) {
            if (self.countValue != -1) {
                output.encodeIntElement(serialDesc, 0, self.countValue);
            }
        }
        if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__ == null) {
            if (output.shouldEncodeElementDefault(serialDesc, 1)) {
            } else {
            }
        }
        if (__UNDEF_KEY__ > 0) {
            if (self.enabledFlag) {
                output.encodeBooleanElement(serialDesc, 1, self.enabledFlag);
            }
        }
        if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__ == null) {
            if (output.shouldEncodeElementDefault(serialDesc, 2)) {
            } else {
            }
        }
        output.encodeBooleanElement(serialDesc, 2, self.enabledFlag2);
    }

    public KeyRecord(int seen0, int key, boolean hold, boolean mouse, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 0, KeyRecordSerializer.INSTANCE.getDescriptor());
        }
        if (__UNDEF_KEY__ == null) {
            if (__UNDEF_KEY__ > 0L && (seen0 & 1) == 0) {
                this.countValue = -1;
                if (__UNDEF_KEY__ >= 0L) {
                    this.countValue = key;
                }
            }
        }
        if (__UNDEF_KEY__ < 0) {
            if ((seen0 & 2) == 0) {
                this.enabledFlag = false;
                if (__UNDEF_KEY__ <= 0) {
                    this.enabledFlag = hold;
                }
            }
        }
        if ((seen0 & 4) == 0) {
            this.enabledFlag2 = false;
        }
        this.enabledFlag2 = mouse;
    }

    public KeyRecord() {
        this(0, false, false);
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
