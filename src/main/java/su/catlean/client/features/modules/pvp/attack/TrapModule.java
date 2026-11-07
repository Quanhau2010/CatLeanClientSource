package su.catlean.client.features.modules.pvp.attack;

import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.TrapPlacementModule;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EntityPacketHelper;

public class TrapModule extends TrapPlacementModule {

    public static final TrapModule INSTANCE;

    private TrapModule() {
        super("trap", SubCategoriesKt.getAttackCategory());
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        this.executeAction(EntityPacketHelper.findTarget(this.getRange(), AutoCrystalTargetSortMode.FOV, 0, 0, 3105968912215310348L));
    }

    static {
        INSTANCE = new TrapModule();
    }

}
