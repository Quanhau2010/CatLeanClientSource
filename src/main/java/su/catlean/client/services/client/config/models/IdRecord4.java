package su.catlean.client.services.client.config.models;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.ItemServiceComponent2;
import su.catlean.client.services.client.ServiceComponent22;

public class IdRecord4 {

    public static final ServiceComponent22 serviceComponent22;
    private String textValue;
    private Map lookupMap;
    private static final Lazy[] lazyArray;
    private static String textValue2;

    public IdRecord4(String id, Map items) {
        this.textValue = id;
        this.lookupMap = items;
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(String value) {
        this.textValue = value;
    }

    public Map getMap() {
        return this.lookupMap;
    }

    public void executeAction(Map value) {
        this.lookupMap = value;
    }

    public String getString2() {
        return this.textValue;
    }

    public Map getMap2() {
        return this.lookupMap;
    }

    public IdRecord4 resolveIdRecord4(String id, Map items) {
        return new IdRecord4(id, items);
    }

    public static IdRecord4 resolveIdRecord4(IdRecord4 arg0, String arg1, Map arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg3 & 2)) {
            arg2 = arg0.lookupMap;
        }
        return arg0.resolveIdRecord4(arg1, arg2);
    }

    public String toString() {
        return (null + this.textValue + ", items=" + this.lookupMap + ")");
    }

    public int hashCode() {
        int var3 = this.textValue.hashCode();
        var3 = ((var3 * 3027519470538063903L) + this.lookupMap.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdRecord4)) {
            return false;
        }
        IdRecord4 var5 = (IdRecord4) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.lookupMap, var5.lookupMap))) {
            return false;
        }
        return true;
    }

    public static void executeAction(IdRecord4 self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] var3 = lazyArray;
        output.encodeStringElement(serialDesc, 0, self.textValue);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) var3[1].getValue(), self.lookupMap);
    }

    public IdRecord4(int seen0, String id, Map items, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, IdRecord4Serializer.INSTANCE.getDescriptor());
        }
        this.textValue = id;
        this.lookupMap = items;
    }

    private static KSerializer getKSerializer() {
        return (KSerializer) new LinkedHashMapSerializer((KSerializer) IntSerializer.INSTANCE, (KSerializer) new ItemServiceComponent2());
    }

    public static Lazy[] process() {
        return lazyArray;
    }

    static {
        serviceComponent22 = new ServiceComponent22();
        Lazy[] var16 = new Lazy[2];
        var16[0] = null;
        var16[1] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        lazyArray = var16;
    }

    public static void updateValue(String arg0) {
        textValue2 = arg0;
    }

    public static String getString3() {
        return textValue2;
    }

}
