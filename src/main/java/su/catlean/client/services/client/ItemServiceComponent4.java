package su.catlean.client.services.client;

import net.minecraft.class_3489;
import net.minecraft.item.ItemStack;

public class ItemServiceComponent4 {

    private static boolean enabledFlag;

    public static boolean checkCondition(ItemStack item) {
        return item.method_31573(class_3489.field_42611);
    }

    public static boolean checkCondition2(ItemStack item) {
        return item.method_31573(class_3489.field_42614);
    }

    public static boolean checkCondition(ItemStack item) {
        if (!(item.method_31573(class_3489.field_48294)) && !(item.method_31573(class_3489.field_48295)) && !(item.method_31573(class_3489.field_48296))) {
            if (item.method_31573(class_3489.field_48297)) {
            } else {
            }
        }
        return false;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
