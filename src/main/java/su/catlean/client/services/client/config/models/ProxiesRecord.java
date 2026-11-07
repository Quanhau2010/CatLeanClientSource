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
import su.catlean.client.services.client.ServiceComponent125;

public class ProxiesRecord {

    public static final ServiceComponent125 serviceComponent125;
    private final List itemList;
    private static final Lazy[] lazyArray;

    public ProxiesRecord(List proxies) {
        this.itemList = proxies;
    }

    public List getList() {
        return this.itemList;
    }

    public List getList2() {
        return this.itemList;
    }

    public ProxiesRecord resolveProxiesRecord(List proxies) {
        return new ProxiesRecord(proxies);
    }

    public static ProxiesRecord resolveProxiesRecord(ProxiesRecord arg0, List arg1, int arg2, Object arg3) {
        if ((arg2 & 1) != 0) {
            arg1 = arg0.itemList;
        }
        return arg0.resolveProxiesRecord(arg1);
    }

    public String toString() {
        return ("ProxyConfig(proxies=" + this.itemList + ")");
    }

    public int hashCode() {
        return this.itemList.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProxiesRecord)) {
            return false;
        }
        ProxiesRecord proxiesRecord = ((ProxiesRecord) other);
        if (!(Intrinsics.areEqual(this.itemList, proxiesRecord.itemList))) {
            return false;
        }
        return true;
    }

    public static void executeAction(ProxiesRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, ((SerializationStrategy) lazyArray[0].getValue()), self.itemList);
    }

    public ProxiesRecord(int seen0, List proxies, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, ProxiesRecordSerializer.INSTANCE.getDescriptor());
        }
        this.itemList = proxies;
    }

    private static KSerializer getKSerializer() {
        return ((KSerializer) new ArrayListSerializer(((KSerializer) IdRecord12Serializer.INSTANCE)));
    }

    public static Lazy[] process() {
        return lazyArray;
    }

    static {
        serviceComponent125 = new ServiceComponent125();
        Lazy[] items = new Lazy[1];
        items[0] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        lazyArray = items;
    }

}
