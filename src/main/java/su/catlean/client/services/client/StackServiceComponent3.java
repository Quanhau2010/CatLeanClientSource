package su.catlean.client.services.client;

import java.util.Optional;
import java.util.Set;
import net.minecraft.class_1890;
import net.minecraft.class_5321;
import net.minecraft.class_5455;
import net.minecraft.class_6880;
import net.minecraft.class_9304;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import su.catlean.SharedKt;

public class StackServiceComponent3 {

    private static int[] countValueArray;

    public static boolean checkCondition(ItemStack stack, class_5321 enchantment) {
        return class_1890.method_57532(stack).method_57534().contains(SharedKt.getWorld().method_30349().method_58561(enchantment).get());
    }

    public static int computeValue(ItemStack stack, class_5321 enchantment) {
        return class_1890.method_8225(((class_6880) SharedKt.getWorld().method_30349().method_58561(enchantment).get()), stack);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
