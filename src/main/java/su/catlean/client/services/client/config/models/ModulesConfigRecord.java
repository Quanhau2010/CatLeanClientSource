package su.catlean.client.services.client.config.models;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import su.catlean.client.services.client.CatLeanServiceComponent;
import su.catlean.client.services.client.ServiceComponent21;

public class ModulesConfigRecord {

    public static final ServiceComponent21 serviceComponent21;
    private String textValue;
    private String textValue2;
    private String textValue3;
    private String textValue4;
    private boolean enabledFlag;
    private static String[] textValueArray;

    public ModulesConfigRecord(String modulesConfig, String widgetsConfig, String inventoriesConfig, String themeConfig, boolean rpcAsked) {
        this.textValue = modulesConfig;
        this.textValue2 = widgetsConfig;
        this.textValue3 = inventoriesConfig;
        this.textValue4 = themeConfig;
        this.enabledFlag = rpcAsked;
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(String value) {
        this.textValue = value;
    }

    public String getString2() {
        return this.textValue2;
    }

    public void executeAction(String value) {
        this.textValue2 = value;
    }

    public String getString3() {
        return this.textValue3;
    }

    public void executeAction(String value) {
        this.textValue3 = value;
    }

    public String getString4() {
        return this.textValue4;
    }

    public void executeAction2(String value) {
        this.textValue4 = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
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

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public ModulesConfigRecord resolveModulesConfigRecord(String modulesConfig, String widgetsConfig, String inventoriesConfig, String themeConfig, boolean rpcAsked) {
        return new ModulesConfigRecord(modulesConfig, widgetsConfig, inventoriesConfig, themeConfig, rpcAsked);
    }

    public static ModulesConfigRecord resolveModulesConfigRecord(ModulesConfigRecord arg0, String arg1, String arg2, String arg3, String arg4, boolean arg5, int arg6, Object arg7) {
        if ((arg6 & 1) != 0) {
            arg1 = arg0.textValue;
        }
        if ((arg6 & 2) != 0) {
            arg2 = arg0.textValue2;
        }
        if ((arg6 & 4) != 0) {
            arg3 = arg0.textValue3;
        }
        if ((arg6 & 8) != 0) {
            arg4 = arg0.textValue4;
        }
        if ((arg6 & 16) != 0) {
            arg5 = arg0.enabledFlag;
        }
        return arg0.resolveModulesConfigRecord(arg1, arg2, arg3, arg4, arg5);
    }

    public String toString() {
        boolean flag = this.enabledFlag;
        String text = this.textValue4;
        String text2 = this.textValue3;
        String text3 = this.textValue2;
        String text4 = this.textValue;
        return ("SharedConfig(modulesConfig=" + text4 + ", widgetsConfig=" + text3 + ", inventoriesConfig=" + text2 + ", themeConfig=" + text + ", rpcAsked=" + flag + ")");
    }

    public int hashCode() {
        int index = this.textValue.hashCode();
        index = ((index * 31) + this.textValue2.hashCode());
        index = ((index * 31) + this.textValue3.hashCode());
        index = ((index * 31) + this.textValue4.hashCode());
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModulesConfigRecord)) {
            return false;
        }
        ModulesConfigRecord modulesConfigRecord = ((ModulesConfigRecord) other);
        if (!(Intrinsics.areEqual(this.textValue, modulesConfigRecord.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, modulesConfigRecord.textValue2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue3, modulesConfigRecord.textValue3))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue4, modulesConfigRecord.textValue4))) {
            return false;
        }
        if (this.enabledFlag != modulesConfigRecord.enabledFlag) {
            return false;
        }
        return true;
    }

    public static void executeAction(ModulesConfigRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0)) {
        } else {
        }
        if (!(Intrinsics.areEqual(self.textValue, "default"))) {
            output.encodeStringElement(serialDesc, 0, self.textValue);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1)) {
        } else {
        }
        if (!(Intrinsics.areEqual(self.textValue2, "default"))) {
            output.encodeStringElement(serialDesc, 1, self.textValue2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2)) {
        } else {
        }
        if (!(Intrinsics.areEqual(self.textValue3, "default"))) {
            output.encodeStringElement(serialDesc, 2, self.textValue3);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3)) {
        } else {
        }
        if (!(Intrinsics.areEqual(self.textValue4, CatLeanServiceComponent.getIdRecord6().getString()))) {
            output.encodeStringElement(serialDesc, 3, self.textValue4);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4)) {
        } else {
        }
        output.encodeBooleanElement(serialDesc, 4, self.enabledFlag);
    }

    public ModulesConfigRecord(int seen0, String modulesConfig, String widgetsConfig, String inventoriesConfig, String themeConfig, boolean rpcAsked, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 0, ModulesConfigRecordSerializer.INSTANCE.getDescriptor());
        }
        if ((seen0 & 1) == 0) {
            this.textValue = "default";
        }
        this.textValue = modulesConfig;
        if ((seen0 & 2) == 0) {
            this.textValue2 = "default";
        }
        this.textValue2 = widgetsConfig;
        if ((seen0 & 4) == 0) {
            this.textValue3 = "default";
        }
        this.textValue3 = inventoriesConfig;
        if ((seen0 & 8) == 0) {
            this.textValue4 = CatLeanServiceComponent.getIdRecord6().getString();
        }
        this.textValue4 = themeConfig;
        if ((seen0 & 16) == 0) {
            this.enabledFlag = false;
        }
        this.enabledFlag = rpcAsked;
    }

    public ModulesConfigRecord() {
        this(null, null, null, null, false);
    }

    static {
        serviceComponent21 = new ServiceComponent21();
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
