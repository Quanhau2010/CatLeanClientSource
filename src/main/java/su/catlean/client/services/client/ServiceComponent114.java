package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;
import su.catlean.client.features.modules.Module;

public class ServiceComponent114 {

    private final BlockPos blockPos;
    private int countValue;
    private boolean enabledFlag;
    private static String[] textValueArray;

    public ServiceComponent114(BlockPos pos, int progress, boolean head) {
        this.blockPos = pos;
        this.countValue = progress;
        this.enabledFlag = head;
    }

    public BlockPos getMinecraftObject() {
        return this.blockPos;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public BlockPos getMinecraftObject2() {
        return this.blockPos;
    }

    public int getNumericValue2() {
        return this.countValue;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public ServiceComponent114 resolveServiceComponent114(BlockPos pos, int progress, boolean head) {
        return new ServiceComponent114(pos, progress, head);
    }

    public String toString() {
        boolean flag = this.enabledFlag;
        int index = this.countValue;
        BlockPos blockPos = this.blockPos;
        return ("BreakingPos(pos=" + blockPos + ", progress=" + index + ", head=" + flag + ")");
    }

    public int hashCode() {
        int index = this.blockPos.hashCode();
        index = ((index * 31) + Integer.hashCode(this.countValue));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        if (__UNDEF_KEY__ != null) {
        }
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent114)) {
            return false;
        }
        ServiceComponent114 serviceComponent114 = ((ServiceComponent114) other);
        if (!(Intrinsics.areEqual(this.blockPos, serviceComponent114.blockPos))) {
            return false;
        }
        if (this.countValue != serviceComponent114.countValue) {
            return false;
        }
        if (this.enabledFlag != serviceComponent114.enabledFlag) {
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
