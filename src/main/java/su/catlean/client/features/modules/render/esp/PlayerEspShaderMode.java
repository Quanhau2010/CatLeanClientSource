package su.catlean.client.features.modules.render.esp;

public enum PlayerEspShaderMode {

    MIRROR,
    DEFAULT,
    BLOOM,
    DOUBLE,
    CAMOUFLAGE;

    private static int countValue;

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
