package su.catlean.client.features.modules.pvp.attack;

import su.catlean.client.services.player.ZEROEntityHelper;

public enum AuraRotationMode {

    private final ZEROEntityHelper zEROEntityHelper;
    public static final AuraRotationMode SNAP;
    public static final AuraRotationMode DEFAULT;
    public static final AuraRotationMode NONE;
    public static final AuraRotationMode VULCAN;
    public static final AuraRotationMode HVH;
    public static final AuraRotationMode POLAR_SEP_25;
    public static final AuraRotationMode GRIM_SILENT;
    public static final AuraRotationMode ADVANCED;

    AuraRotationMode(String arg0, int arg1, ZEROEntityHelper arg2) {
        super(arg0, arg1);
        this.zEROEntityHelper = arg2;
    }

    public ZEROEntityHelper getZEROEntityHelper() {
        return this.zEROEntityHelper;
    }

}
