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
        if ((arg4 & 1) != 0) {
            arg1 = arg0.optionMode4;
        }
        if ((arg4 & 2) != 0) {
            arg2 = arg0.optionMode;
        }
        if ((arg4 & 4) != 0) {
            arg3 = arg0.userRecord;
        }
        return arg0.resolveEvtRecord(arg1, arg2, arg3);
    }

    public String toString() {
        UserRecord userRecord = this.userRecord;
        OptionMode optionMode = this.optionMode;
        OptionMode4 optionMode4 = this.optionMode4;
        return ("PacketPayload(evt=" + optionMode4 + ", cmd=" + optionMode + ", data=" + userRecord + ")");
    }

    public int hashCode() {
        boolean flag = this.optionMode4 != null;
        flag = ((flag * 31) + this.optionMode != null);
        flag = ((flag * 31) + this.userRecord.hashCode());
        return flag;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EvtRecord)) {
            return false;
        }
        EvtRecord evtRecord = ((EvtRecord) other);
        if (this.optionMode4 != evtRecord.optionMode4) {
            return false;
        }
        if (this.optionMode != evtRecord.optionMode) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.userRecord, evtRecord.userRecord))) {
            return false;
        }
        return true;
    }

    public static void executeAction(EvtRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, ((SerializationStrategy) lazyArray[0].getValue()), self.optionMode4);
        output.encodeNullableSerializableElement(serialDesc, 1, ((SerializationStrategy) lazyArray[1].getValue()), self.optionMode);
        output.encodeSerializableElement(serialDesc, 2, ((SerializationStrategy) UserRecordSerializer.INSTANCE), self.userRecord);
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
        Lazy[] items = new Lazy[3];
        items[0] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        items[1] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer2);
        items[2] = null;
        lazyArray = items;
    }

}
