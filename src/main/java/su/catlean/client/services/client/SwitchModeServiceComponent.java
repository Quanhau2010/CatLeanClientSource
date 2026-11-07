package su.catlean.client.services.client;

import net.minecraft.class_1661;
import net.minecraft.class_1743;
import net.minecraft.class_1835;
import net.minecraft.class_9362;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract2;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.AuraSwitchMode;
import su.catlean.client.services.network.ItemPacketHelper;

public class SwitchModeServiceComponent implements Contract2 {

    public static final SwitchModeServiceComponent INSTANCE;
    private static int countValue;

    private SwitchModeServiceComponent() {
    }

    public boolean checkCondition(boolean onlyWeapon, AuraSwitchMode switchMode) {
        ItemStack stack = SharedKt.getPlayer().method_6047();
        if (onlyWeapon) {
            if (switchMode == AuraSwitchMode.NONE) {
                if (!(ItemServiceComponent4.checkCondition(stack)) && !(stack.getItem() instanceof class_1743) && !(stack.getItem() instanceof class_1835)) {
                    if (stack.getItem() instanceof class_9362) {
                    } else {
                        if (!(ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().isActive())) {
                            if (ItemPacketHelper.INSTANCE.resolveStackServiceComponent23().isActive()) {
                            } else {
                            }
                        }
                    }
                }
            } else {
            }
            return false;
        }
        return true;
    }

    public void executeAction(boolean silent) {
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        if (stackServiceComponent2.isActive()) {
            stackServiceComponent2.updateValue();
            stackServiceComponent2.updateValue();
            return;
        }
        StackServiceComponent2 stackServiceComponent22 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent23();
        if (__UNDEF_KEY__ < 0 || __UNDEF_KEY__ >= 0) {
            return;
        }
        if (__UNDEF_KEY__ >= 0 && stackServiceComponent22.isActive()) {
            stackServiceComponent22.updateValue();
        }
        stackServiceComponent22.updateValue();
    }

    public static void executeAction(SwitchModeServiceComponent arg0, boolean arg1, int arg2, Object arg3) {
        if ((arg2 & 1) != 0) {
            arg1 = 0;
        }
        arg0.executeAction(arg1);
    }

    public void executeAction() {
        countValue = SharedKt.getPlayer().method_31548().method_67532();
        this.executeAction(true);
    }

    public void executeAction(MoveFixServiceComponent rotation) {
        this.updateValue();
    }

    public void updateValue() {
        this.updateValue();
    }

    public void updateValue() {
        ItemPacketHelper.INSTANCE.executeAction(countValue);
        countValue = -1;
    }

    static {
        INSTANCE = new SwitchModeServiceComponent();
        countValue = -1;
    }

}
