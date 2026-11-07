package su.catlean.client.services.client.config.models;

import java.util.ArrayList;
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
        if ((arg4 & 1) != 0) {
            arg1 = arg0.itemList;
        }
        if ((arg4 & 2) != 0) {
            arg2 = arg0.itemList2;
        }
        if ((arg4 & 4) != 0) {
            arg3 = arg0.itemList3;
        }
        return arg0.resolveSettingMacrosRecord(arg1, arg2, arg3);
    }

    public String toString() {
        List list = this.itemList3;
        List list2 = this.itemList2;
        List list3 = this.itemList;
        return ("MacroConfig(settingMacros=" + list3 + ", chatMacros=" + list2 + ", itemMacros=" + list + ")");
    }

    public int hashCode() {
        int index = this.itemList.hashCode();
        index = ((index * 31) + this.itemList2.hashCode());
        index = ((index * 31) + this.itemList3.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingMacrosRecord)) {
            return false;
        }
        SettingMacrosRecord settingMacrosRecord = ((SettingMacrosRecord) other);
        if (!(Intrinsics.areEqual(this.itemList, settingMacrosRecord.itemList))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemList2, settingMacrosRecord.itemList2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemList3, settingMacrosRecord.itemList3))) {
            return false;
        }
        return true;
    }

    public static void setValue(SettingMacrosRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0)) {
        } else {
        }
        if (!(Intrinsics.areEqual(self.itemList, new ArrayList()))) {
            output.encodeSerializableElement(serialDesc, 0, ((SerializationStrategy) lazyArray[0].getValue()), self.itemList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1)) {
        } else {
        }
        if (!(Intrinsics.areEqual(self.itemList2, new ArrayList()))) {
            output.encodeSerializableElement(serialDesc, 1, ((SerializationStrategy) lazyArray[1].getValue()), self.itemList2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2)) {
        } else {
        }
        output.encodeSerializableElement(serialDesc, 2, ((SerializationStrategy) lazyArray[2].getValue()), self.itemList3);
    }

    public SettingMacrosRecord(int seen0, List settingMacros, List chatMacros, List itemMacros, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 0, SettingMacrosRecordSerializer.INSTANCE.getDescriptor());
        }
        if ((seen0 & 1) == 0) {
            this.itemList = new ArrayList();
        }
        this.itemList = settingMacros;
        if ((seen0 & 2) == 0) {
            this.itemList2 = new ArrayList();
        }
        this.itemList2 = chatMacros;
        if ((seen0 & 4) == 0) {
            this.itemList3 = new ArrayList();
        }
        this.itemList3 = itemMacros;
    }

    private static KSerializer getKSerializer() {
        return ((KSerializer) new ArrayListSerializer(((KSerializer) IdRecord11Serializer.INSTANCE)));
    }

    private static KSerializer getKSerializer2() {
        return ((KSerializer) new ArrayListSerializer(((KSerializer) IdRecord9Serializer.INSTANCE)));
    }

    private static KSerializer getKSerializer3() {
        return ((KSerializer) new ArrayListSerializer(((KSerializer) IdRecordSerializer.INSTANCE)));
    }

    public SettingMacrosRecord() {
        this();
    }

    public static Lazy[] process() {
        return lazyArray;
    }

    static {
        serviceComponent104 = new ServiceComponent104();
        Lazy[] items = new Lazy[3];
        items[0] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        items[1] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer2);
        items[2] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer3);
        lazyArray = items;
    }

}
