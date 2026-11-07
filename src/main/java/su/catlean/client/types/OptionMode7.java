package su.catlean.client.types;

import su.catlean.client.features.modules.Module;

public enum OptionMode7 {

    public static final OptionMode7 Config;
    public static final OptionMode7 Window;
    private static Module[] moduleArray;

    OptionMode7(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

}
