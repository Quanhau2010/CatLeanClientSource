package su.catlean.client.features.modules.utility.misc;

import su.catlean.client.features.modules.Module;

public enum NameProtectReplaceMode {

    ONLY_SELF,
    FRIENDS,
    ALL;

    private static Module[] moduleArray;

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

}
