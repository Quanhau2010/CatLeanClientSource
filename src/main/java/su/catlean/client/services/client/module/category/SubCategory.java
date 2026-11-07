package su.catlean.client.services.client.module.category;

public class SubCategory {

    private final String textValue;
    private static int[] countValueArray;

    public SubCategory(String id) {
        this.textValue = id;
    }

    public String getString() {
        return this.textValue;
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
