package su.catlean.client.features.modules.utility.player;

import net.minecraft.block.BlockState;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;

public class MultiTaskModule extends Module {

    public static final MultiTaskModule INSTANCE;

    private MultiTaskModule() {
        super("multi-task", SubCategoriesKt.getPlayerUtilityCategory());
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        if (SharedKt.getMc().field_1765 instanceof class_3965) {
            class_3965 var14 = (class_3965) SharedKt.getMc().field_1765;
            if (SharedKt.getMc().options.field_1886.method_1434() && SharedKt.getMc().options.field_1904.method_1434() && !(SharedKt.getWorld().getBlockState(var14.method_17777()).method_26215())) {
                if (SharedKt.getInteractionManager().method_2923()) {
                } else {
                }
                SharedKt.getInteractionManager().method_2910(var14.method_17777(), var14.method_17780());
                SharedKt.getPlayer().method_6104(Hand.field_5808);
            }
        }
        var14 = (class_3966) SharedKt.getMc().field_1765;
        SharedKt.getInteractionManager().method_2918((PlayerEntity) SharedKt.getPlayer(), var14.method_17782());
        SharedKt.getPlayer().method_6104(Hand.field_5808);
    }

    static {
        INSTANCE = new MultiTaskModule();
    }

}
