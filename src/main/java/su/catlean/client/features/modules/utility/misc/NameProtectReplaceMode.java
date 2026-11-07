package su.catlean.client.features.modules.utility.misc;

import su.catlean.client.features.modules.Module;

public enum NameProtectReplaceMode {

    public static final NameProtectReplaceMode ONLY_SELF;
    public static final NameProtectReplaceMode FRIENDS;
    public static final NameProtectReplaceMode ALL;
    private static Module[] moduleArray;

    NameProtectReplaceMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

}
