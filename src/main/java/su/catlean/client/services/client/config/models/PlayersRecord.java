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
import su.catlean.client.services.client.ServiceComponent24;

public class PlayersRecord {

    public static final ServiceComponent24 serviceComponent24;
    private final List itemList;
    private static final Lazy[] lazyArray;

    public PlayersRecord(List players) {
        this.itemList = players;
    }

    public List getList() {
        return this.itemList;
    }

    public List getList2() {
        return this.itemList;
    }

    public PlayersRecord resolvePlayersRecord(List players) {
        return new PlayersRecord(players);
    }

    public static PlayersRecord resolvePlayersRecord(PlayersRecord arg0, List arg1, int arg2, Object arg3) {
        if ((arg2 & 1)) {
            arg1 = arg0.itemList;
        }
        return arg0.resolvePlayersRecord(arg1);
    }

    public String toString() {
        return ("PlayersResponse(players=" + this.itemList + ")");
    }

    public int hashCode() {
        return this.itemList.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayersRecord)) {
            return false;
        }
        PlayersRecord var5 = (PlayersRecord) other;
        if (!(Intrinsics.areEqual(this.itemList, var5.itemList))) {
            return false;
        }
        return true;
    }

    public static void executeAction(PlayersRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] var3 = lazyArray;
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) var3[0].getValue(), self.itemList);
    }

    public PlayersRecord(int seen0, List players, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, PlayersRecordSerializer.INSTANCE.getDescriptor());
        }
        this.itemList = players;
    }

    private static KSerializer getKSerializer() {
        return (KSerializer) new ArrayListSerializer((KSerializer) StringSerializer.INSTANCE);
    }

    public static Lazy[] process() {
        return lazyArray;
    }

    static {
        serviceComponent24 = new ServiceComponent24();
        Lazy[] var11 = new Lazy[1];
        var11[0] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, this::getKSerializer);
        lazyArray = var11;
    }

}
