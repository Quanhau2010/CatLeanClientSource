package su.catlean.client.services.client;

import net.minecraft.class_1661;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.equip.AutoArmorModule;

public class EquipmentSlotServiceComponent {

    private final EquipmentSlot minecraftRef;
    private final int countValue;
    private int countValue2;
    private int countValue3;
    private int countValue4;

    public EquipmentSlotServiceComponent(EquipmentSlot equipmentSlot, int armorSlot, int prevProt, int newSlot, int newProtection) {
        this.minecraftRef = equipmentSlot;
        this.countValue = armorSlot;
        this.countValue2 = prevProt;
        this.countValue3 = newSlot;
        this.countValue4 = newProtection;
    }

    public EquipmentSlot getMinecraftObject() {
        return this.minecraftRef;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public void updateValue(int value) {
        this.countValue2 = value;
    }

    public int getNumericValue3() {
        return this.countValue3;
    }

    public void updateValue2(int value) {
        this.countValue3 = value;
    }

    public int getNumericValue4() {
        return this.countValue4;
    }

    public void updateValue3(int value) {
        this.countValue4 = value;
    }

    public void executeAction() {
        this.countValue2 = AutoArmorModule.computeValue(SharedKt.getPlayer().method_31548().method_5438(this.countValue));
        this.countValue3 = -1;
        this.countValue4 = -1;
    }

    public EquipmentSlot getMinecraftObject2() {
        return this.minecraftRef;
    }

    public int getNumericValue5() {
        return this.countValue;
    }

    public int getNumericValue6() {
        return this.countValue2;
    }

    public int getNumericValue7() {
        return this.countValue3;
    }

    public int getNumericValue8() {
        return this.countValue4;
    }

    public EquipmentSlotServiceComponent resolveEquipmentSlotServiceComponent(EquipmentSlot equipmentSlot, int armorSlot, int prevProt, int newSlot, int newProtection) {
        return new EquipmentSlotServiceComponent(equipmentSlot, armorSlot, prevProt, newSlot, newProtection);
    }

    public static EquipmentSlotServiceComponent resolveEquipmentSlotServiceComponent(EquipmentSlotServiceComponent arg0, EquipmentSlot arg1, int arg2, int arg3, int arg4, int arg5, int arg6, Object arg7) {
        if ((arg6 & 1) != 0) {
            arg1 = arg0.minecraftRef;
        }
        if ((arg6 & 2) != 0) {
            arg2 = arg0.countValue;
        }
        if ((arg6 & 4) != 0) {
            arg3 = arg0.countValue2;
        }
        if ((arg6 & 8) != 0) {
            arg4 = arg0.countValue3;
        }
        if ((arg6 & 16) != 0) {
            arg5 = arg0.countValue4;
        }
        if (arg0.resolveEquipmentSlotServiceComponent(arg1, arg2, arg3, arg4, arg5) != null) {
        }
        return null;
    }

    public String toString() {
        int index = this.countValue4;
        int index2 = this.countValue3;
        int index3 = this.countValue2;
        int index4 = this.countValue;
        EquipmentSlot equipmentSlot = this.minecraftRef;
        return ("ArmorData(equipmentSlot=" + equipmentSlot + ", armorSlot=" + index4 + ", prevProt=" + index3 + ", newSlot=" + index2 + ", newProtection=" + index + ")");
    }

    public int hashCode() {
        int index = this.minecraftRef.hashCode();
        index = ((index * 31) + Integer.hashCode(this.countValue));
        index = ((index * 31) + Integer.hashCode(this.countValue2));
        index = ((index * 31) + Integer.hashCode(this.countValue3));
        index = ((index * 31) + Integer.hashCode(this.countValue4));
        if (__UNDEF_KEY__ != null) {
        }
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EquipmentSlotServiceComponent)) {
            return false;
        }
        EquipmentSlotServiceComponent equipmentSlotServiceComponent = ((EquipmentSlotServiceComponent) other);
        if (this.minecraftRef != equipmentSlotServiceComponent.minecraftRef) {
            return false;
        }
        if (this.countValue != equipmentSlotServiceComponent.countValue) {
            return false;
        }
        if (this.countValue2 != equipmentSlotServiceComponent.countValue2) {
            return false;
        }
        if (this.countValue3 != equipmentSlotServiceComponent.countValue3) {
            return false;
        }
        if (this.countValue4 != equipmentSlotServiceComponent.countValue4) {
            return false;
        }
        return true;
    }

}
