package su.catlean.client.features.modules.render.esp;

public enum StorageEspShaderMode {

    public static final StorageEspShaderMode DEFAULT;
    public static final StorageEspShaderMode LINES;
    public static final StorageEspShaderMode DOTS;
    private static int[] countValueArray;

    StorageEspShaderMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
