package su.catlean.client.features.modules.render.esp;

public enum StorageEspShaderMode {

    DEFAULT,
    LINES,
    DOTS;

    private static int[] countValueArray;

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
