package su.catlean.client.features.modules.pvp.protect;

import net.minecraft.entity.player.PlayerEntity;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.TrapPlacementModule;
import su.catlean.client.services.client.module.category.SubCategoriesKt;

public class SelfTrapModule extends TrapPlacementModule {

    public static final SelfTrapModule INSTANCE;

    private SelfTrapModule() {
        super("self-trap", SubCategoriesKt.getProtectCategory());
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        this.executeAction(((PlayerEntity) SharedKt.getPlayer()));
    }

    static {
        INSTANCE = new SelfTrapModule();
    }

}
