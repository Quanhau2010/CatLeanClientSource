package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import su.catlean.client.services.client.ServiceComponent41;

public class UserRecord {

    public static final ServiceComponent41 serviceComponent41;
    private final IdRecord2 idRecord2;
    private final Integer integer;
    private final String textValue;

    public UserRecord(IdRecord2 user, Integer code, String message) {
        this.idRecord2 = user;
        this.integer = code;
        this.textValue = message;
    }

    public IdRecord2 getIdRecord2() {
        return this.idRecord2;
    }

    public Integer getInteger() {
        return this.integer;
    }

    public String getString() {
        return this.textValue;
    }

    public IdRecord2 getIdRecord22() {
        return this.idRecord2;
    }

    public Integer getInteger2() {
        return this.integer;
    }

    public String getString2() {
        return this.textValue;
    }

    public UserRecord resolveUserRecord(IdRecord2 user, Integer code, String message) {
        return new UserRecord(user, code, message);
    }

    public static UserRecord resolveUserRecord(UserRecord arg0, IdRecord2 arg1, Integer arg2, String arg3, int arg4, Object arg5) {
        if ((arg4 & 1)) {
            arg1 = arg0.idRecord2;
        }
        if ((arg4 & 2)) {
            arg2 = arg0.integer;
        }
        if ((arg4 & 4)) {
            arg3 = arg0.textValue;
        }
        return arg0.resolveUserRecord(arg1, arg2, arg3);
    }

    public String toString() {
        String var3 = this.textValue;
        Integer var4 = this.integer;
        IdRecord2 var5 = this.idRecord2;
        return ("PacketData(user=" + var5 + ", code=" + var4 + ", message=" + var3 + ")");
    }

    public int hashCode() {
        boolean var4 = this.idRecord2 != null;
        var4 = ((var4 * 31) + this.integer != null);
        var4 = ((var4 * 31) + this.textValue != null);
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserRecord)) {
            return false;
        }
        UserRecord var5 = (UserRecord) other;
        if (!(Intrinsics.areEqual(this.idRecord2, var5.idRecord2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.integer, var5.integer))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        return true;
    }

    public static void executeAction(UserRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, (SerializationStrategy) IdRecord2Serializer.INSTANCE, self.idRecord2);
        output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) IntSerializer.INSTANCE, self.integer);
        output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) StringSerializer.INSTANCE, self.textValue);
    }

    public UserRecord(int seen0, IdRecord2 user, Integer code, String message, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (7 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 7, UserRecordSerializer.INSTANCE.getDescriptor());
        }
        this.idRecord2 = user;
        this.integer = code;
        this.textValue = message;
    }

    static {
        serviceComponent41 = new ServiceComponent41();
    }

}
