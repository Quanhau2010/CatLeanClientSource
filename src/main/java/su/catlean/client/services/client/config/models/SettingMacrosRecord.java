package su.catlean.client.services.client.config.models;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.ServiceComponent104;

public class SettingMacrosRecord {

    public static final ServiceComponent104 serviceComponent104;
    private final List itemList;
    private final List itemList2;
    private final List itemList3;
    private static final Lazy[] lazyArray;

    public SettingMacrosRecord(List settingMacros, List chatMacros, List itemMacros) {
        this.itemList = settingMacros;
        this.itemList2 = chatMacros;
        this.itemList3 = itemMacros;
    }

    public SettingMacrosRecord(List arg0, List arg1, List arg2, int arg3, DefaultConstructorMarker arg4) {
        if ((arg3 & 1)) {
            arg0 = new ArrayList();
        }
        if ((arg3 & 2)) {
            arg1 = new ArrayList();
        }
        if ((arg3 & 4)) {
            arg2 = new ArrayList();
        }
        this(arg0, arg1, arg2);
    }

    public List getList() {
        return this.itemList;
    }

    public List getList2() {
        return this.itemList2;
    }

    public List getList3() {
        return this.itemList3;
    }

    public List getList4() {
        return this.itemList;
    }

    public List getList5() {
        return this.itemList2;
    }

    public List getList6() {
        return this.itemList3;
    }

    public SettingMacrosRecord resolveSettingMacrosRecord(List settingMacros, List chatMacros, List itemMacros) {
        return new SettingMacrosRecord(settingMacros, chatMacros, itemMacros);
    }

    public static SettingMacrosRecord resolveSettingMacrosRecord(SettingMacrosRecord arg0, List arg1, List arg2, List arg3, int arg4, Object arg5) {
        if ((arg4 & 1)) {
            arg1 = arg0.itemList;
        }
        if ((arg4 & 2)) {
            arg2 = arg0.itemList2;
        }
        if ((arg4 & 4)) {
            arg3 = arg0.itemList3;
        }
        return arg0.resolveSettingMacrosRecord(arg1, arg2, arg3);
    }

    public String toString() {
        List positions = this.itemList3;
        List positions2 = this.itemList2;
        List positions3 = this.itemList;
        return ("MacroConfig(settingMacros=" + positions3 + ", chatMacros=" + positions2 + ", itemMacros=" + positions + ")");
    }

    public int hashCode() {
        int var3 = this.itemList.hashCode();
        var3 = ((var3 * 31) + this.itemList2.hashCode());
        var3 = ((var3 * 31) + this.itemList3.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingMacrosRecord)) {
            return false;
        }
        SettingMacrosRecord var5 = (SettingMacrosRecord) other;
        if (!(Intrinsics.areEqual(this.itemList, var5.itemList))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemList2, var5.itemList2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemList3, var5.itemList3))) {
            return false;
        }
        return true;
    }

    public static void setValue(SettingMacrosRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] var6 = lazyArray;
        if (output.shouldEncodeElementDefault(serialDesc, 0)) {
        } else {
        }
        if (!(Intrinsics.areEqual(self.itemList, new ArrayList()))) {
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) var6[0].getValue(), self.itemList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1)) {
        } else {
        }
        if (!(Intrinsics.areEqual(self.itemList2, new ArrayList()))) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) var6[1].getValue(), self.itemList2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2)) {
        } else {
        }
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) var6[2].getValue(), self.itemList3);
    }

    public SettingMacrosRecord(int seen0, List settingMacros, List chatMacros, List itemMacros, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 0, SettingMacrosRecordSerializer.INSTANCE.getDescriptor());
        }
        if (!((seen0 & 1))) {
            this.itemList = new ArrayList();
        }
        this.itemList = settingMacros;
        if (!((seen0 & 2))) {
            this.itemList2 = new ArrayList();
        }
        this.itemList2 = chatMacros;
        if (!((seen0 & 4))) {
            this.itemList3 = new ArrayList();
        }
        this.itemList3 = itemMacros;
    }

    private static KSerializer getKSerializer() {
        return (KSerializer) new ArrayListSerializer((KSerializer) IdRecord11Serializer.INSTANCE);
    }

    private static KSerializer getKSerializer2() {
        return (KSerializer) new ArrayListSerializer((KSerializer) IdRecord9Serializer.INSTANCE);
    }

    private static KSerializer getKSerializer3() {
        return (KSerializer) new ArrayListSerializer((KSerializer) IdRecordSerializer.INSTANCE);
    }

    public SettingMacrosRecord() {
        this();
    }

    public static Lazy[] process() {
        return lazyArray;
    }

    static {
        serviceComponent104 = new ServiceComponent104();
        Lazy[] var22 = new Lazy[3];
        var22[0] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        var22[1] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer2);
        var22[2] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer3);
        lazyArray = var22;
    }

}
