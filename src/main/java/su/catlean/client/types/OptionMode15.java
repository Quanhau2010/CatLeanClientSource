package su.catlean.client.types;

public enum OptionMode15 {

    NONE,
    ALL,
    ONLY_CRYSTALS;

    private static int[] countValueArray;

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
