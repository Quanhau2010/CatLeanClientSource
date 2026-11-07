package su.catlean.client.services.client;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1661;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.network.ItemPacketHelper;

public class StackServiceComponent2 {

    public static final StackServiceComponent stackServiceComponent;
    private final int countValue;
    private final boolean enabledFlag;
    private final ItemStack itemStack;
    private static final StackServiceComponent2 INSTANCE;
    private static Module[] moduleArray;

    public StackServiceComponent2(int slot, boolean found, ItemStack stack) {
        this.countValue = slot;
        this.enabledFlag = found;
        this.itemStack = stack;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public ItemStack getMinecraftObject() {
        return this.itemStack;
    }

    public boolean checkCondition() {
        if (SharedKt.getMc().player == null) {
        } else {
        }
        return SharedKt.getPlayer().method_31548().method_67532() == this.countValue;
    }

    private boolean checkCondition2() {
        return this.countValue < 9;
    }

    public void updateValue() {
        ItemPacketHelper.INSTANCE.executeAction(this.countValue);
    }

    public void executeAction(Function1 action) {
        if (__UNDEF_KEY__ == null) {
        }
        action.invoke(this);
    }

    public int getNumericValue2() {
        return this.countValue;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public ItemStack getMinecraftObject2() {
        return this.itemStack;
    }

    public StackServiceComponent2 resolveStackServiceComponent2(int slot, boolean found, ItemStack stack) {
        return new StackServiceComponent2(slot, found, stack);
    }

    public static StackServiceComponent2 resolveStackServiceComponent2(StackServiceComponent2 arg0, int arg1, boolean arg2, ItemStack arg3, int arg4, Object arg5) {
        if ((arg4 & 1) != 0) {
            arg1 = arg0.countValue;
        }
        if ((arg4 & 2) != 0) {
            arg2 = arg0.enabledFlag;
        }
        if ((arg4 & 4) != 0) {
            arg3 = arg0.itemStack;
        }
        return arg0.resolveStackServiceComponent2(arg1, arg2, arg3);
    }

    public String toString() {
        ItemStack stack = this.itemStack;
        boolean flag = this.enabledFlag;
        int index = this.countValue;
        return ("SearchInvResult(slot=" + index + ", found=" + flag + ", stack=" + stack + ")");
    }

    public int hashCode() {
        int index = Integer.hashCode(this.countValue);
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        index = ((index * 31) + this.itemStack.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StackServiceComponent2)) {
            return false;
        }
        StackServiceComponent2 stackServiceComponent2 = ((StackServiceComponent2) other);
        if (this.countValue != stackServiceComponent2.countValue) {
            return false;
        }
        if (this.enabledFlag != stackServiceComponent2.enabledFlag) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemStack, stackServiceComponent2.itemStack))) {
            return false;
        }
        return true;
    }

    public static StackServiceComponent2 getStackServiceComponent2() {
        return INSTANCE;
    }

    static {
        stackServiceComponent = new StackServiceComponent();
        INSTANCE = new StackServiceComponent2(-1, false, ItemStack.field_8037);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
