package su.catlean.client.services.client.config.models;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent32;

public class IdRecord8 {

    public static final ServiceComponent32 serviceComponent32;
    private final String textValue;
    private List itemList;
    private static final Lazy[] lazyArray;
    private static Module[] moduleArray;

    public IdRecord8(String id, List widgets) {
        this.textValue = id;
        this.itemList = widgets;
    }

    public IdRecord8(String arg0, List arg1, int arg2, DefaultConstructorMarker arg3) {
        if ((arg2 & 2)) {
            arg1 = CollectionsKt.emptyList();
        }
        this(arg0, arg1);
    }

    public String getString() {
        return this.textValue;
    }

    public List getList() {
        return this.itemList;
    }

    public void executeAction(List value) {
        this.itemList = value;
    }

    public String getString2() {
        return this.textValue;
    }

    public List getList2() {
        return this.itemList;
    }

    public IdRecord8 resolveIdRecord8(String id, List widgets) {
        return new IdRecord8(id, widgets);
    }

    public static IdRecord8 resolveIdRecord8(IdRecord8 arg0, String arg1, List arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg3 & 2)) {
            arg2 = arg0.itemList;
        }
        return arg0.resolveIdRecord8(arg1, arg2);
    }

    public String toString() {
        return (null + this.textValue + ", widgets=" + this.itemList + ")");
    }

    public int hashCode() {
        int var3 = this.textValue.hashCode();
        var3 = ((var3 * 2672908704084394015L) + this.itemList.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord8)) {
            return false;
        }
        IdRecord8 var5 = (IdRecord8) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemList, var5.itemList))) {
            return false;
        }
        return true;
    }

    public static void executeAction(IdRecord8 self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] var6 = lazyArray;
        output.encodeStringElement(serialDesc, 0, self.textValue);
        if (output.shouldEncodeElementDefault(serialDesc, 1)) {
        } else {
        }
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) var6[1].getValue(), self.itemList);
    }

    public IdRecord8(int seen0, String id, List widgets, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, IdRecord8Serializer.INSTANCE.getDescriptor());
        }
        if (0L > 0) {
            this.textValue = id;
        }
        if (0L >= 0 && !((seen0 & 2))) {
            this.itemList = CollectionsKt.emptyList();
        }
        this.itemList = widgets;
    }

    private static KSerializer getKSerializer() {
        return (KSerializer) new ArrayListSerializer((KSerializer) IdRecord5Serializer.INSTANCE);
    }

    public static Lazy[] process() {
        return lazyArray;
    }

    static {
        serviceComponent32 = new ServiceComponent32();
        Lazy[] var16 = new Lazy[2];
        var16[0] = null;
        var16[1] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        lazyArray = var16;
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
