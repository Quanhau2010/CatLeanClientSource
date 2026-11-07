package su.catlean.client.types;

public enum OptionMode14 {

    DEFAULT,
    ALWAYS,
    BOOLS;

    private static String[] textValueArray;

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
