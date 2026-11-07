package su.catlean.client.features.modules.movement.rage;

import su.catlean.client.features.modules.Module;

public enum BlinkAttackActionMode {

    public static final BlinkAttackActionMode REPEAT;
    public static final BlinkAttackActionMode OFF;
    public static final BlinkAttackActionMode NONE;
    private static Module[] moduleArray;

    BlinkAttackActionMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

}
