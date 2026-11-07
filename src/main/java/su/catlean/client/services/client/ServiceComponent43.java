package su.catlean.client.services.client;

import net.minecraft.class_1322.class_1323;
import net.minecraft.entity.EquipmentSlot;

public class ServiceComponent43 {

    public static final int[] countValueArray;
    public static final int[] countValueArray2;
    private static int[] countValueArray3;

    static {
        Object element = new int[EquipmentSlot.values()];
        element[EquipmentSlot.field_6169.ordinal()] = 1;
        element[EquipmentSlot.field_48824.ordinal()] = 2;
        element[EquipmentSlot.field_6172.ordinal()] = 3;
        element[EquipmentSlot.field_6166.ordinal()] = 4;
        countValueArray = element;
        element = new int[class_1323.values()];
        element[class_1323.field_6328.ordinal()] = 1;
        element[class_1323.field_6330.ordinal()] = 2;
        element[class_1323.field_6331.ordinal()] = 3;
        countValueArray2 = element;
    }

    public static void updateValue(int[] arg0) {
        countValueArray3 = arg0;
    }

    public static int[] process() {
        return countValueArray3;
    }

}
