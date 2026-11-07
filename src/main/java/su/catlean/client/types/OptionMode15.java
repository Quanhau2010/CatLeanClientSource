package su.catlean.client.types;

public enum OptionMode15 {

    public static final OptionMode15 NONE;
    public static final OptionMode15 ALL;
    public static final OptionMode15 ONLY_CRYSTALS;
    private static int[] countValueArray;

    OptionMode15(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
