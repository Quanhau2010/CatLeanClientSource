package su.catlean.client.features.modules.movement.rage;

import su.catlean.client.features.modules.Module;

public enum BlinkAttackActionMode {

    REPEAT,
    OFF,
    NONE;

    private static Module[] moduleArray;

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

}
