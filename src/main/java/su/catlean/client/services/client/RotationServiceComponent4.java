package su.catlean.client.services.client;

import kotlin.jvm.functions.Function0;

public class RotationServiceComponent4 {

    private final MoveFixServiceComponent moveFixServiceComponent;
    private final int countValue;
    private Function0 function0;
    private static String textValue;

    public RotationServiceComponent4(MoveFixServiceComponent rotation, int priority, Function0 action) {
        this.moveFixServiceComponent = rotation;
        this.countValue = priority;
        this.function0 = action;
    }

    public MoveFixServiceComponent getMoveFixServiceComponent() {
        return this.moveFixServiceComponent;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public Function0 getFunction0() {
        return this.function0;
    }

    public void executeAction(Function0 value) {
        this.function0 = value;
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
