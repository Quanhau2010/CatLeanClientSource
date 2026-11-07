package su.catlean.client.services.client;

import kotlin.jvm.functions.Function1;

public class ActionServiceComponent3 {

    private final String textValue;
    private final Function1 function1;

    public ActionServiceComponent3(String id, Function1 action) {
        this.textValue = id;
        this.function1 = action;
    }

    public String getString() {
        return this.textValue;
    }

    public Function1 getFunction1() {
        return this.function1;
    }

}
