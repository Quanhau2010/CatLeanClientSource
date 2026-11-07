package su.catlean.client.types;

public enum OptionMode14 {

    public static final OptionMode14 DEFAULT;
    public static final OptionMode14 ALWAYS;
    public static final OptionMode14 BOOLS;
    private static String[] textValueArray;

    OptionMode14(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
