package su.catlean.client.features.modules.render.esp;

public enum NameTagsSeeCatleanUsersMode {

    INSTANCE,
    ANONYMOUSLY,
    OFF;

    private static int countValue;

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 111;
        return 0;
    }

}
