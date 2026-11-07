package su.catlean.client.services.client;

import kotlin.jvm.functions.Function0;

public class ActionServiceComponent2 {

    private final Function0 function0;
    private static String[] textValueArray;

    public ActionServiceComponent2(Function0 action) {
        this.function0 = action;
    }

    public Function0 getFunction0() {
        return this.function0;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
