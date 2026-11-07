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
import su.catlean.client.services.client.ServiceComponent126;

public class IdRecord5 {

    public static final ServiceComponent126 serviceComponent126;
    private final String textValue;
    private final List itemList;
    private static final Lazy[] lazyArray;
    private static boolean enabledFlag;

    public IdRecord5(String id, List settings) {
        this.textValue = id;
        this.itemList = settings;
    }

    public String getString() {
        return this.textValue;
    }

    public List getList() {
        return this.itemList;
    }

    public String getString2() {
        return this.textValue;
    }

    public List getList2() {
        return this.itemList;
    }

    public IdRecord5 resolveIdRecord5(String id, List settings) {
        return new IdRecord5(id, settings);
    }

    public static IdRecord5 resolveIdRecord5(IdRecord5 arg0, String arg1, List arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg3 & 2)) {
            arg2 = arg0.itemList;
        }
        return arg0.resolveIdRecord5(arg1, arg2);
    }

    public String toString() {
        return (null + this.textValue + ", settings=" + this.itemList + ")");
    }

    public int hashCode() {
        int var3 = this.textValue.hashCode();
        var3 = ((var3 * 5668537707442208799L) + this.itemList.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord5)) {
            return false;
        }
        IdRecord5 var5 = (IdRecord5) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemList, var5.itemList))) {
            return false;
        }
        return true;
    }

    public static void executeAction(IdRecord5 self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] var3 = lazyArray;
        output.encodeStringElement(serialDesc, 0, self.textValue);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) var3[1].getValue(), self.itemList);
    }

    public IdRecord5(int seen0, String id, List settings, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, IdRecord5Serializer.INSTANCE.getDescriptor());
        }
        this.textValue = id;
        this.itemList = settings;
    }

    private static KSerializer getKSerializer() {
        return (KSerializer) new ArrayListSerializer((KSerializer) IdRecord10Serializer.INSTANCE);
    }

    public static Lazy[] process() {
        return lazyArray;
    }

    static {
        serviceComponent126 = new ServiceComponent126();
        Lazy[] var16 = new Lazy[2];
        var16[0] = null;
        var16[1] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        lazyArray = var16;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
