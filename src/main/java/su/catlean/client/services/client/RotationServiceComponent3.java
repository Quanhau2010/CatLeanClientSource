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

    public void executeAction(long arg0) {
        enabledFlag = SharedKt.getPlayer().method_6030().getItem().method_7853(SharedKt.getPlayer().method_6030()) == class_1839.field_8949;
        if (arg0 >= 0L) {
            if (AuraModule.INSTANCE.getWhileShielding() != AuraWhileShieldingMode.UNPRESS) {
            }
        }
        SharedKt.getInteractionManager().method_2897(((PlayerEntity) SharedKt.getPlayer()));
    }

    public void executeAction(MoveFixServiceComponent rotation) {
        HandServiceComponent.resolveMinecraftObject(Hand.field_5810, rotation.getNumericValue(), rotation.getNumericValue2());
    }

    public void updateValue() {
    }

    static {
        INSTANCE = new RotationServiceComponent3();
    }

}
