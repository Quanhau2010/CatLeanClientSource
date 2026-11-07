package su.catlean.client.services.client.config.models;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent106;

public class DetailsRecord {

    public static final ServiceComponent106 serviceComponent106;
    private final String textValue;
    private final String textValue2;
    private final StartRecord startRecord;
    private final LargeImageRecord largeImageRecord;
    private final List itemList;
    private static final Lazy[] lazyArray;

    public DetailsRecord(String details, String state, StartRecord timestamps, LargeImageRecord assets, List buttons) {
        this.textValue = details;
        this.textValue2 = state;
        this.startRecord = timestamps;
        this.largeImageRecord = assets;
        this.itemList = buttons;
    }

    public String getString() {
        return this.textValue;
    }

    public String getString2() {
        return this.textValue2;
    }

    public StartRecord getStartRecord() {
        return this.startRecord;
    }

    public LargeImageRecord getLargeImageRecord() {
        return this.largeImageRecord;
    }

    public List getList() {
        return this.itemList;
    }

    public String getString3() {
        return this.textValue;
    }

    public String getString4() {
        return this.textValue2;
    }

    public StartRecord getStartRecord2() {
        return this.startRecord;
    }

    public LargeImageRecord getLargeImageRecord2() {
        return this.largeImageRecord;
    }

    public List getList2() {
        return this.itemList;
    }

    public DetailsRecord resolveDetailsRecord(String details, String state, StartRecord timestamps, LargeImageRecord assets, List buttons) {
        return new DetailsRecord(details, state, timestamps, assets, buttons);
    }

    public static DetailsRecord resolveDetailsRecord(DetailsRecord arg0, String arg1, String arg2, StartRecord arg3, LargeImageRecord arg4, List arg5, int arg6, Object arg7) {
        if ((arg6 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg6 & 2)) {
            arg2 = arg0.textValue2;
        }
        if ((arg6 & 4)) {
            arg3 = arg0.startRecord;
        }
        if ((arg6 & 8)) {
            arg4 = arg0.largeImageRecord;
        }
        if ((arg6 & 16)) {
            arg5 = arg0.itemList;
        }
        return arg0.resolveDetailsRecord(arg1, arg2, arg3, arg4, arg5);
    }

    public String toString() {
        List positions = this.itemList;
        LargeImageRecord var4 = this.largeImageRecord;
        StartRecord var5 = this.startRecord;
        String var6 = this.textValue2;
        String var7 = this.textValue;
        return ("Activity(details=" + var7 + ", state=" + var6 + ", timestamps=" + var5 + ", assets=" + var4 + ", buttons=" + positions + ")");
    }

    public int hashCode() {
        boolean var4 = this.textValue != null;
        var4 = ((var4 * 31) + this.textValue2 != null);
        var4 = ((var4 * 31) + this.startRecord.hashCode());
        var4 = ((var4 * 31) + this.largeImageRecord != null);
        var4 = ((var4 * 31) + this.itemList != null);
        if (var4 != null) {
        }
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DetailsRecord)) {
            return false;
        }
        DetailsRecord var5 = (DetailsRecord) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, var5.textValue2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.startRecord, var5.startRecord))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.largeImageRecord, var5.largeImageRecord))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemList, var5.itemList))) {
            return false;
        }
        return true;
    }

    public static void executeAction(DetailsRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] var3 = lazyArray;
        output.encodeNullableSerializableElement(serialDesc, 0, (SerializationStrategy) StringSerializer.INSTANCE, self.textValue);
        output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) StringSerializer.INSTANCE, self.textValue2);
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) StartRecordSerializer.INSTANCE, self.startRecord);
        output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) LargeImageRecordSerializer.INSTANCE, self.largeImageRecord);
        output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) var3[4].getValue(), self.itemList);
    }

    public DetailsRecord(int seen0, String details, String state, StartRecord timestamps, LargeImageRecord assets, List buttons, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (31 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 31, DetailsRecordSerializer.INSTANCE.getDescriptor());
        }
        this.textValue = details;
        this.textValue2 = state;
        this.startRecord = timestamps;
        this.largeImageRecord = assets;
        this.itemList = buttons;
    }

    private static KSerializer getKSerializer() {
        return (KSerializer) new ArrayListSerializer((KSerializer) LabelRecordSerializer.INSTANCE);
    }

    public static Lazy[] process() {
        return lazyArray;
    }

    static {
        serviceComponent106 = new ServiceComponent106();
        Lazy[] var22 = new Lazy[5];
        var22[0] = null;
        var22[1] = null;
        var22[2] = null;
        var22[3] = null;
        var22[4] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        lazyArray = var22;
    }

}
