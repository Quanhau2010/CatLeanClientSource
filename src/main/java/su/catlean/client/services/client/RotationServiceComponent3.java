package su.catlean.client.services.client;

import net.minecraft.class_1839;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract2;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.AuraWhileShieldingMode;

public class RotationServiceComponent3 implements Contract2 {

    public static final RotationServiceComponent3 INSTANCE;
    private static boolean enabledFlag;

    private RotationServiceComponent3() {
    }

    public void executeAction(int arg0, long arg1) {
        int var4 = ((arg0 << 32) | ((arg1 << 32) >>> 32));
        long var6 = ((var4 ^ 20745683030457L) >>> 32);
        long var7 = (((var4 ^ 20745683030457L) << 32) >>> 32);
        long var9 = (var4 ^ 16782221287606L);
        long var11 = ((var4 ^ 134691496928949L) >>> 32);
        long var12 = (((var4 ^ 134691496928949L) << 32) >>> 56);
        long var13 = (((var4 ^ 134691496928949L) << 40) >>> 40);
        enabledFlag = SharedKt.getPlayer().method_6030().getItem().method_7853(SharedKt.getPlayer().method_6030()) == class_1839.field_8949;
        if (arg1 >= 0L) {
            if (AuraModule.INSTANCE.getWhileShielding() != AuraWhileShieldingMode.UNPRESS) {
            }
        }
        SharedKt.getInteractionManager().method_2897((PlayerEntity) SharedKt.getPlayer());
    }

    public void executeAction(MoveFixServiceComponent rotation) {
        int var5 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        long var7 = (var5 ^ 100624651377200L);
        long var9 = ((var5 ^ 66102524677371L) >>> 32);
        long var10 = (((var5 ^ 66102524677371L) << 32) >>> 56);
        long var11 = (((var5 ^ 66102524677371L) << 40) >>> 40);
        HandServiceComponent.resolveMinecraftObject(Hand.field_5810, rotation.getNumericValue(), rotation.getNumericValue2());
    }

    public void updateValue() {
    }

    static {
        INSTANCE = new RotationServiceComponent3();
    }

}
