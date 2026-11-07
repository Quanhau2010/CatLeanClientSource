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
import su.catlean.client.services.client.ServiceComponent72;

public class WayPointsRecord {

    public static final ServiceComponent72 serviceComponent72;
    private final List itemList;
    private static final Lazy[] lazyArray;

    public WayPointsRecord(List wayPoints) {
        this.itemList = wayPoints;
    }

    public List getList() {
        return this.itemList;
    }

    public List getList2() {
        return this.itemList;
    }

    public WayPointsRecord resolveWayPointsRecord(List wayPoints) {
        return new WayPointsRecord(wayPoints);
    }

    public static WayPointsRecord resolveWayPointsRecord(WayPointsRecord arg0, List arg1, int arg2, Object arg3) {
        if ((arg2 & 1)) {
            arg1 = arg0.itemList;
        }
        return arg0.resolveWayPointsRecord(arg1);
    }

    public String toString() {
        return ("WayPointConfig(wayPoints=" + this.itemList + ")");
    }

    public int hashCode() {
        return this.itemList.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WayPointsRecord)) {
            return false;
        }
        WayPointsRecord var5 = (WayPointsRecord) other;
        if (!(Intrinsics.areEqual(this.itemList, var5.itemList))) {
            return false;
        }
        return true;
    }

    public static void executeAction(WayPointsRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] var3 = lazyArray;
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) var3[0].getValue(), self.itemList);
    }

    public WayPointsRecord(int seen0, List wayPoints, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, WayPointsRecordSerializer.INSTANCE.getDescriptor());
        }
        this.itemList = wayPoints;
    }

    private static KSerializer getKSerializer() {
        return (KSerializer) new ArrayListSerializer((KSerializer) IdRecord7Serializer.INSTANCE);
    }

    public static Lazy[] process() {
        return lazyArray;
    }

    static {
        serviceComponent72 = new ServiceComponent72();
        Lazy[] var11 = new Lazy[1];
        var11[0] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        lazyArray = var11;
    }

}
