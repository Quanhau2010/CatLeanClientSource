package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import su.catlean.client.services.client.ServiceComponent81;

public class LargeImageRecord {

    public static final ServiceComponent81 serviceComponent81;
    private final String textValue;
    private final String textValue2;
    private final String textValue3;
    private final String textValue4;

    public LargeImageRecord(String largeImage, String largeText, String smallImage, String smallText) {
        this.textValue = largeImage;
        this.textValue2 = largeText;
        this.textValue3 = smallImage;
        this.textValue4 = smallText;
    }

    public String getString() {
        return this.textValue;
    }

    public String getString2() {
        return this.textValue2;
    }

    public String getString3() {
        return this.textValue3;
    }

    public String getString4() {
        return this.textValue4;
    }

    public String getString5() {
        return this.textValue;
    }

    public String getString6() {
        return this.textValue2;
    }

    public String getString7() {
        return this.textValue3;
    }

    public String getString8() {
        return this.textValue4;
    }

    public LargeImageRecord resolveLargeImageRecord(String largeImage, String largeText, String smallImage, String smallText) {
        return new LargeImageRecord(largeImage, largeText, smallImage, smallText);
    }

    public static LargeImageRecord resolveLargeImageRecord(LargeImageRecord arg0, String arg1, String arg2, String arg3, String arg4, int arg5, Object arg6) {
        if ((arg5 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg5 & 2)) {
            arg2 = arg0.textValue2;
        }
        if ((arg5 & 4)) {
            arg3 = arg0.textValue3;
        }
        if ((arg5 & 8)) {
            arg4 = arg0.textValue4;
        }
        return arg0.resolveLargeImageRecord(arg1, arg2, arg3, arg4);
    }

    public String toString() {
        String var3 = this.textValue4;
        String var4 = this.textValue3;
        String var5 = this.textValue2;
        String var6 = this.textValue;
        return ("ActivityAsset(largeImage=" + var6 + ", largeText=" + var5 + ", smallImage=" + var4 + ", smallText=" + var3 + ")");
    }

    public int hashCode() {
        boolean var4 = this.textValue != null;
        var4 = ((var4 * 31) + this.textValue2 != null);
        var4 = ((var4 * 31) + this.textValue3 != null);
        var4 = ((var4 * 31) + this.textValue4 != null);
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LargeImageRecord)) {
            return false;
        }
        LargeImageRecord var5 = (LargeImageRecord) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, var5.textValue2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue3, var5.textValue3))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue4, var5.textValue4))) {
            return false;
        }
        return true;
    }

    public static void executeAction(LargeImageRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, (SerializationStrategy) StringSerializer.INSTANCE, self.textValue);
        output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) StringSerializer.INSTANCE, self.textValue2);
        output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) StringSerializer.INSTANCE, self.textValue3);
        output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) StringSerializer.INSTANCE, self.textValue4);
    }

    public LargeImageRecord(int seen0, String largeImage, String largeText, String smallImage, String smallText, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (15 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 15, LargeImageRecordSerializer.INSTANCE.getDescriptor());
        }
        this.textValue = largeImage;
        this.textValue2 = largeText;
        this.textValue3 = smallImage;
        this.textValue4 = smallText;
    }

    static {
        serviceComponent81 = new ServiceComponent81();
    }

}
