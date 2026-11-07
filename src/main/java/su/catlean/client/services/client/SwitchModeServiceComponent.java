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
                    }
                } else {
                } else {
                    if (!(ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().isActive())) {
                        if (ItemPacketHelper.INSTANCE.resolveStackServiceComponent23().isActive()) {
                        }
                    } else {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public void executeAction(boolean silent) {
        StackServiceComponent2 var14 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        if (var14.isActive()) {
            var14.updateValue();
            var14.updateValue();
            return;
        }
        StackServiceComponent2 var15 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent23();
        if (0L < 0 || 0L >= 0) {
            return;
        }
        if (0L >= 0 && var15.isActive()) {
            var15.updateValue();
        }
        var15.updateValue();
    }

    public static void executeAction(SwitchModeServiceComponent arg0, boolean arg1, int arg2, Object arg3) {
        if ((arg2 & 1)) {
            arg1 = 0;
        }
        arg0.executeAction(arg1);
    }

    public void executeAction(int arg0, long arg1) {
        int var4 = ((arg0 << 32) | ((arg1 << 32) >>> 32));
        long var6 = ((var4 ^ 51486216026542L) >>> 48);
        long var7 = (((var4 ^ 51486216026542L) << 16) >>> 32);
        long var8 = (((var4 ^ 51486216026542L) << 48) >>> 48);
        long var9 = ((var4 ^ 104070571286828L) >>> 8);
        long var11 = (((var4 ^ 104070571286828L) << 56) >>> 56);
        long var12 = (var4 ^ 16782221287606L);
        if (var14) {
            countValue = SharedKt.getPlayer().method_31548().method_67532();
        }
        this.executeAction(1);
    }

    public void executeAction(MoveFixServiceComponent rotation) {
        int var5 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        long var7 = ((var5 ^ 26629572807522L) >>> 8);
        long var9 = (((var5 ^ 26629572807522L) << 56) >>> 56);
        long var10 = (var5 ^ 75397077659784L);
        this.updateValue();
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 102883187979937L);
        this.updateValue();
    }

    public void updateValue() {
        if (var5) {
            ItemPacketHelper.INSTANCE.executeAction(countValue);
        }
        countValue = -1;
    }

    static {
        INSTANCE = new SwitchModeServiceComponent();
        countValue = -1;
    }

}
