package su.catlean.client.features.modules.utility.player;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Box;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.BoxContractEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;

public class BoxShrinkerModule extends Module {

    public static final BoxShrinkerModule INSTANCE;
    private static boolean enabledFlag;

    private BoxShrinkerModule() {
        super("box-shrinker", SubCategoriesKt.getPlayerUtilityCategory());
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    private void onBoxContractEvent(BoxContractEvent arg0) {
        if (enabledFlag) {
            return;
        }
        enabledFlag = 1;
        arg0.setValue(SharedKt.getPlayer().method_5829().method_1009(-1.0E-12D, 0.0D, -1.0E-12D));
        enabledFlag = 0;
        arg0.cancel();
    }

    static {
        INSTANCE = new BoxShrinkerModule();
    }

}
