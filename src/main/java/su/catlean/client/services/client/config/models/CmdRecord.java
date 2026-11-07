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
import su.catlean.client.services.client.ServiceComponent49;
import su.catlean.client.services.client.ServiceComponent77;
import su.catlean.client.types.OptionMode;

public class CmdRecord {

    public static final ServiceComponent77 serviceComponent77;
    private final OptionMode optionMode;
    private final PidRecord pidRecord;
    private static final Lazy[] lazyArray;

    public CmdRecord(OptionMode cmd, PidRecord args) {
        this.optionMode = cmd;
        this.pidRecord = args;
    }

    public OptionMode getOptionMode() {
        return this.optionMode;
    }

    public PidRecord getPidRecord() {
        return this.pidRecord;
    }

    public OptionMode getOptionMode2() {
        return this.optionMode;
    }

    public PidRecord getPidRecord2() {
        return this.pidRecord;
    }

    public CmdRecord resolveCmdRecord(OptionMode cmd, PidRecord args) {
        return new CmdRecord(cmd, args);
    }

    public static CmdRecord resolveCmdRecord(CmdRecord arg0, OptionMode arg1, PidRecord arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = arg0.optionMode;
        }
        if ((arg3 & 2)) {
            arg2 = arg0.pidRecord;
        }
        return arg0.resolveCmdRecord(arg1, arg2);
    }

    public String toString() {
        return (null + this.optionMode + ", args=" + this.pidRecord + ")");
    }

    public int hashCode() {
        int var3 = this.optionMode.hashCode();
        var3 = ((var3 * -4540695697992712161L) + this.pidRecord.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CmdRecord)) {
            return false;
        }
        CmdRecord var5 = (CmdRecord) other;
        if (this.optionMode != var5.optionMode) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.pidRecord, var5.pidRecord))) {
            return false;
        }
        return true;
    }

    public static void executeAction(CmdRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] var3 = lazyArray;
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) var3[0].getValue(), self.optionMode);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) PidRecordSerializer.INSTANCE, self.pidRecord);
    }

    public CmdRecord(int seen0, OptionMode cmd, PidRecord args, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, CmdRecordSerializer.INSTANCE.getDescriptor());
        }
        this.optionMode = cmd;
        this.pidRecord = args;
    }

    private static KSerializer getKSerializer() {
        return OptionMode.Companion.getKSerializer();
    }

    public static Lazy[] process() {
        return lazyArray;
    }

    static {
        serviceComponent77 = new ServiceComponent77();
        Lazy[] var16 = new Lazy[2];
        var16[0] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        var16[1] = null;
        lazyArray = var16;
    }

}
