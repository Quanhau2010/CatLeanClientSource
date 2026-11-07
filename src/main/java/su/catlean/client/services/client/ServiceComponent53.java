package su.catlean.client.services.client;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public class ServiceComponent53 {

    private final int countValue;
    private final int countValue2;
    private final List itemList;
    private boolean enabledFlag;
    private static String[] textValueArray;

    public ServiceComponent53(int x, int z, List list, boolean recalc) {
        this.countValue = x;
        this.countValue2 = z;
        this.itemList = list;
        this.enabledFlag = recalc;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public List getList() {
        return this.itemList;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public int getNumericValue3() {
        return this.countValue;
    }

    public int getNumericValue4() {
        return this.countValue2;
    }

    public List getList2() {
        return this.itemList;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public ServiceComponent53 resolveServiceComponent53(int x, int z, List list, boolean recalc) {
        return new ServiceComponent53(x, z, list, recalc);
    }

    public String toString() {
        boolean var3 = this.enabledFlag;
        List positions = this.itemList;
        int var5 = this.countValue2;
        int var6 = this.countValue;
        return ("SearchChunk(x=" + var6 + ", z=" + var5 + ", list=" + positions + ", recalc=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Integer.hashCode(this.countValue);
        var3 = ((var3 * 31) + Integer.hashCode(this.countValue2));
        var3 = ((var3 * 31) + this.itemList.hashCode());
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent53)) {
            return false;
        }
        ServiceComponent53 var5 = (ServiceComponent53) other;
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (this.countValue2 != var5.countValue2) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemList, var5.itemList))) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        return true;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
