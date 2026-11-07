package su.catlean.client.ui.clickgui;

import net.minecraft.class_1713;
import su.catlean.client.features.modules.Module;

public class ActionTypeGuiElement {

    private final int countValue;
    private final int countValue2;
    private final int countValue3;
    private final class_1713 minecraftRef;

    public ActionTypeGuiElement(int syncId, int slotId, int button, class_1713 actionType) {
        this.countValue = syncId;
        this.countValue2 = slotId;
        this.countValue3 = button;
        this.minecraftRef = actionType;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public int getNumericValue3() {
        return this.countValue3;
    }

    public class_1713 getMinecraftObject() {
        return this.minecraftRef;
    }

    public int getNumericValue4() {
        return this.countValue;
    }

    public int getNumericValue5() {
        return this.countValue2;
    }

    public int getNumericValue6() {
        return this.countValue3;
    }

    public class_1713 getMinecraftObject2() {
        return this.minecraftRef;
    }

    public ActionTypeGuiElement resolveActionTypeGuiElement(int syncId, int slotId, int button, class_1713 actionType) {
        return new ActionTypeGuiElement(syncId, slotId, button, actionType);
    }

    public String toString() {
        class_1713 var3 = this.minecraftRef;
        int var4 = this.countValue3;
        int var5 = this.countValue2;
        int var6 = this.countValue;
        return ("ClickData(syncId=" + var6 + ", slotId=" + var5 + ", button=" + var4 + ", actionType=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = Integer.hashCode(this.countValue);
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue2));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue3));
        var4 = ((var4 * 31) + this.minecraftRef.hashCode());
        if (var3 == null) {
        }
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionTypeGuiElement)) {
            return false;
        }
        ActionTypeGuiElement var5 = (ActionTypeGuiElement) other;
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (this.countValue2 != var5.countValue2) {
            return false;
        }
        if (this.countValue3 != var5.countValue3) {
            return false;
        }
        if (this.minecraftRef != var5.minecraftRef) {
            return false;
        }
        return true;
    }

}
