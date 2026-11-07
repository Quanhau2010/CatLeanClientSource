package su.catlean.client.features.modules.render.esp;

public enum NameTagsSeeCatleanUsersMode {

    public static final NameTagsSeeCatleanUsersMode INSTANCE;
    public static final NameTagsSeeCatleanUsersMode ANONYMOUSLY;
    public static final NameTagsSeeCatleanUsersMode OFF;
    private static int countValue;

    NameTagsSeeCatleanUsersMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

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
