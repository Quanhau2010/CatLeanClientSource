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
        class_1713 class1713 = this.minecraftRef;
        int index = this.countValue3;
        int index2 = this.countValue2;
        int index3 = this.countValue;
        return ("ClickData(syncId=" + index3 + ", slotId=" + index2 + ", button=" + index + ", actionType=" + class1713 + ")");
    }

    public int hashCode() {
        int index = Integer.hashCode(this.countValue);
        index = ((index * 31) + Integer.hashCode(this.countValue2));
        index = ((index * 31) + Integer.hashCode(this.countValue3));
        index = ((index * 31) + this.minecraftRef.hashCode());
        if (__UNDEF_KEY__ == null) {
        }
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionTypeGuiElement)) {
            return false;
        }
        ActionTypeGuiElement actionTypeGuiElement = ((ActionTypeGuiElement) other);
        if (this.countValue != actionTypeGuiElement.countValue) {
            return false;
        }
        if (this.countValue2 != actionTypeGuiElement.countValue2) {
            return false;
        }
        if (this.countValue3 != actionTypeGuiElement.countValue3) {
            return false;
        }
        if (this.minecraftRef != actionTypeGuiElement.minecraftRef) {
            return false;
        }
        return true;
    }

}
