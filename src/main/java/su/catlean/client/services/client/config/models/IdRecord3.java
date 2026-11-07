package su.catlean.client.services.client.config.models;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.ServiceComponent122;

public class IdRecord3 {

    public static final ServiceComponent122 serviceComponent122;
    private final String textValue;
    private List itemList;
    private static final Lazy[] lazyArray;
    private static String[] textValueArray;

    public IdRecord3(String id, List modules) {
        this.textValue = id;
        this.itemList = modules;
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

    public IdRecord3 resolveIdRecord3(String id, List modules) {
        return new IdRecord3(id, modules);
    }

    public static IdRecord3 resolveIdRecord3(IdRecord3 arg0, String arg1, List arg2, int arg3, Object arg4) {
        if ((arg3 & 1) != 0) {
            arg1 = arg0.textValue;
        }
        if ((arg3 & 2) != 0) {
            arg2 = arg0.itemList;
        }
        return arg0.resolveIdRecord3(arg1, arg2);
    }

    public String toString() {
        return (null + this.textValue + ", modules=" + this.itemList + ")");
    }

    public int hashCode() {
        int index = this.textValue.hashCode();
        index = ((index * 31) + this.itemList.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord3)) {
            return false;
        }
        IdRecord3 idRecord3 = ((IdRecord3) other);
        if (!(Intrinsics.areEqual(this.textValue, idRecord3.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemList, idRecord3.itemList))) {
            return false;
        }
        return true;
    }

    public static void executeAction(IdRecord3 self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.textValue);
        if (output.shouldEncodeElementDefault(serialDesc, 1)) {
        } else {
        }
        output.encodeSerializableElement(serialDesc, 1, ((SerializationStrategy) lazyArray[1].getValue()), self.itemList);
    }

    public IdRecord3(int seen0, String id, List modules, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, IdRecord3Serializer.INSTANCE.getDescriptor());
        }
        this.textValue = id;
        if ((seen0 & 2) == 0) {
            this.itemList = CollectionsKt.emptyList();
        }
        this.itemList = modules;
    }

    private static KSerializer getKSerializer() {
        return ((KSerializer) new ArrayListSerializer(((KSerializer) IdRecord5Serializer.INSTANCE)));
    }

    public static Lazy[] process() {
        return lazyArray;
    }

    static {
        serviceComponent122 = new ServiceComponent122();
        Lazy[] items = new Lazy[2];
        items[0] = null;
        items[1] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        lazyArray = items;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
