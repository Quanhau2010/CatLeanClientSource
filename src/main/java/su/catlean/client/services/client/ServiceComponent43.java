package su.catlean.client.services.client;

import net.minecraft.class_1322.class_1323;
import net.minecraft.entity.EquipmentSlot;

public class ServiceComponent43 {

    public static final int[] countValueArray;
    public static final int[] countValueArray2;
    private static int[] countValueArray3;

    static {
        Object var2 = new int[EquipmentSlot.values()];
        var2[EquipmentSlot.field_6169.ordinal()] = 1;
        var2[EquipmentSlot.field_48824.ordinal()] = 2;
        var2[EquipmentSlot.field_6172.ordinal()] = 3;
        var2[EquipmentSlot.field_6166.ordinal()] = 4;
        countValueArray = var2;
        var2 = new int[class_1323.values()];
        var2[class_1323.field_6328.ordinal()] = 1;
        var2[class_1323.field_6330.ordinal()] = 2;
        var2[class_1323.field_6331.ordinal()] = 3;
        countValueArray2 = var2;
    }

    public static void updateValue(int[] arg0) {
        countValueArray3 = arg0;
    }

    public static int[] process() {
        return countValueArray3;
    }

}
