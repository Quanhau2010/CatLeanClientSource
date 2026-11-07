package su.catlean.client.services.client;

import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.utility.equip.AutoArmorModule;

public class ServiceComponent50 implements Runnable {

    private final int countValue;

    public ServiceComponent50(int arg0, long arg1) {
        this.countValue = arg0;
        this.timestampValue = arg1;
    }

    public void run() {
        Thread.sleep(this.countValue);
        int index = 5;
        if (index < 45) {
            AutoArmorModule.INSTANCE.getServiceComponent38().executeAction(-5);
            if (index >= 36) {
            } else {
            }
            ItemStack stack = (index - 36).method_5438(index);
            if (!(stack.isEmpty())) {
                if (!(stack.method_31578())) {
                    if (index <= 8) {
                        SharedKt.getInteractionManager().method_2906(SharedKt.getPlayer().field_7512.field_7763, index, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, ((PlayerEntity) SharedKt.getPlayer()));
                        Thread.sleep(this.timestampValue);
                        SharedKt.getNetwork().method_45730("fix hand");
                        Thread.sleep(this.timestampValue);
                        SharedKt.getInteractionManager().method_2906(SharedKt.getPlayer().field_7512.field_7763, index, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, ((PlayerEntity) SharedKt.getPlayer()));
                        Thread.sleep(this.timestampValue);
                    }
                }
            }
        }
        SharedKt.getInteractionManager().method_2906(SharedKt.getPlayer().field_7512.field_7763, 1, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, ((PlayerEntity) SharedKt.getPlayer()));
    }

}
