package su.catlean.client.features.modules.render.esp;

public enum PlayerEspShaderMode {

    public static final PlayerEspShaderMode MIRROR;
    public static final PlayerEspShaderMode DEFAULT;
    public static final PlayerEspShaderMode BLOOM;
    public static final PlayerEspShaderMode DOUBLE;
    public static final PlayerEspShaderMode CAMOUFLAGE;
    private static int countValue;

    PlayerEspShaderMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 44;
        return 0;
    }

}
