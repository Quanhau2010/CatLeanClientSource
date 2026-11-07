package su.catlean.client.services.client;

import net.minecraft.item.ItemStack;

public class StackServiceComponent {

    private StackServiceComponent() {
    }

    public StackServiceComponent2 getStackServiceComponent2() {
        return StackServiceComponent2.getStackServiceComponent2();
    }

    public StackServiceComponent2 resolveStackServiceComponent2(ItemStack stack) {
        return new StackServiceComponent2(999, true, stack);
    }

}
