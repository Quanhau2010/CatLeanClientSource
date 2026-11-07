package su.catlean.client.services.client.config.models;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.ServiceComponent25;
import su.catlean.client.services.client.ServiceComponent49;
import su.catlean.client.services.client.ServiceComponent88;
import su.catlean.client.types.OptionMode;
import su.catlean.client.types.OptionMode4;

public class EvtRecord {

    public static final ServiceComponent25 serviceComponent25;
    private final OptionMode4 optionMode4;
    private final OptionMode optionMode;
    private final UserRecord userRecord;
    private static final Lazy[] lazyArray;

    public EvtRecord(OptionMode4 evt, OptionMode cmd, UserRecord data) {
        this.optionMode4 = evt;
        this.optionMode = cmd;
        this.userRecord = data;
    }

    public OptionMode4 getOptionMode4() {
        return this.optionMode4;
    }

    public OptionMode getOptionMode() {
        return this.optionMode;
    }

    public UserRecord getUserRecord() {
        return this.userRecord;
    }

    public OptionMode4 getOptionMode42() {
        return this.optionMode4;
    }

    public OptionMode getOptionMode2() {
        return this.optionMode;
    }

    public UserRecord getUserRecord2() {
        return this.userRecord;
    }

    public EvtRecord resolveEvtRecord(OptionMode4 evt, OptionMode cmd, UserRecord data) {
        return new EvtRecord(evt, cmd, data);
    }

    public static EvtRecord resolveEvtRecord(EvtRecord arg0, OptionMode4 arg1, OptionMode arg2, UserRecord arg3, int arg4, Object arg5) {
        if ((arg4 & 1)) {
            arg1 = arg0.optionMode4;
        }
        if ((arg4 & 2)) {
            arg2 = arg0.optionMode;
        }
        if ((arg4 & 4)) {
            arg3 = arg0.userRecord;
        }
        return arg0.resolveEvtRecord(arg1, arg2, arg3);
    }

    public String toString() {
        UserRecord var3 = this.userRecord;
        OptionMode var4 = this.optionMode;
        OptionMode4 var5 = this.optionMode4;
        return ("PacketPayload(evt=" + var5 + ", cmd=" + var4 + ", data=" + var3 + ")");
    }

    public int hashCode() {
        boolean var4 = this.optionMode4 != null;
        var4 = ((var4 * 31) + this.optionMode != null);
        var4 = ((var4 * 31) + this.userRecord.hashCode());
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EvtRecord)) {
            return false;
        }
        EvtRecord var5 = (EvtRecord) other;
        if (this.optionMode4 != var5.optionMode4) {
            return false;
        }
        if (this.optionMode != var5.optionMode) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.userRecord, var5.userRecord))) {
            return false;
        }
        return true;
    }

    public static void executeAction(EvtRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] var3 = lazyArray;
        output.encodeNullableSerializableElement(serialDesc, 0, (SerializationStrategy) var3[0].getValue(), self.optionMode4);
        output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) var3[1].getValue(), self.optionMode);
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) UserRecordSerializer.INSTANCE, self.userRecord);
    }

    public EvtRecord(int seen0, OptionMode4 evt, OptionMode cmd, UserRecord data, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (7 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 7, EvtRecordSerializer.INSTANCE.getDescriptor());
        }
        this.optionMode4 = evt;
        this.optionMode = cmd;
        this.userRecord = data;
    }

    private static KSerializer getKSerializer() {
        return OptionMode4.Companion.getKSerializer();
    }

    private static KSerializer getKSerializer2() {
        return OptionMode.Companion.getKSerializer();
    }

    public static Lazy[] process() {
        return lazyArray;
    }

    static {
        serviceComponent25 = new ServiceComponent25();
        Lazy[] var22 = new Lazy[3];
        var22[0] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        var22[1] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer2);
        var22[2] = null;
        lazyArray = var22;
    }

}
