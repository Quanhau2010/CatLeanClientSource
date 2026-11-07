package su.catlean.client.services.client;

import net.minecraft.class_1743;
import net.minecraft.class_1821;
import net.minecraft.item.ItemStack;
import su.catlean.api.contracts.Contract7;

public class ServiceComponent11 implements Contract7 {

    public static final ServiceComponent11 INSTANCE;

    public ServiceComponent11() {
    }

    public boolean checkCondition(ItemStack it) {
        if (!(ItemServiceComponent4.checkCondition(it)) && !(ItemServiceComponent4.checkCondition2(it)) && !(it.getItem() instanceof class_1743)) {
            if (it.getItem() instanceof class_1821) {
            } else {
            }
        }
        return false;
    }

    static {
        INSTANCE = new ServiceComponent11();
    }

}
