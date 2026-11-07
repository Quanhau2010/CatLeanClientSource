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
        if ((arg6 & 1)) {
            arg1 = arg0.minecraftRef;
        }
        if ((arg6 & 2)) {
            arg2 = arg0.countValue;
        }
        if ((arg6 & 4)) {
            arg3 = arg0.countValue2;
        }
        if ((arg6 & 8)) {
            arg4 = arg0.countValue3;
        }
        if ((arg6 & 16)) {
            arg5 = arg0.countValue4;
        }
        if (arg0.resolveEquipmentSlotServiceComponent(arg1, arg2, arg3, arg4, arg5) != null) {
        }
        return null;
    }

    public String toString() {
        int var3 = this.countValue4;
        int var4 = this.countValue3;
        int var5 = this.countValue2;
        int var6 = this.countValue;
        EquipmentSlot var7 = this.minecraftRef;
        return ("ArmorData(equipmentSlot=" + var7 + ", armorSlot=" + var6 + ", prevProt=" + var5 + ", newSlot=" + var4 + ", newProtection=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = this.minecraftRef.hashCode();
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue2));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue3));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue4));
        if (var3 != null) {
        }
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EquipmentSlotServiceComponent)) {
            return false;
        }
        EquipmentSlotServiceComponent var5 = (EquipmentSlotServiceComponent) other;
        if (this.minecraftRef != var5.minecraftRef) {
            return false;
        }
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (this.countValue2 != var5.countValue2) {
            return false;
        }
        if (this.countValue3 != var5.countValue3) {
            return false;
        }
        if (this.countValue4 != var5.countValue4) {
            return false;
        }
        return true;
    }

}
