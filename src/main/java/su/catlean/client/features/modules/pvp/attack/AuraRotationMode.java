package su.catlean.client.features.modules.pvp.attack;

import su.catlean.client.services.player.ZEROEntityHelper;

public enum AuraRotationMode {

    SNAP,
    DEFAULT,
    NONE,
    VULCAN,
    HVH,
    POLAR_SEP_25,
    GRIM_SILENT,
    ADVANCED;

    private final ZEROEntityHelper zEROEntityHelper;

    public ZEROEntityHelper getZEROEntityHelper() {
        return this.zEROEntityHelper;
    }

}
