package su.catlean.client.types;

import su.catlean.client.features.modules.Module;

public enum OptionMode7 {

    Config,
    Window;

    private static Module[] moduleArray;

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

}
