package su.catlean.client.services.client;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class RotationRotationServiceComponent4Impl extends RotationServiceComponent4 {

    private static boolean enabledFlag;

    public RotationRotationServiceComponent4Impl(MoveFixServiceComponent rotation, int priority, Function0 action) {
        super(rotation, priority, this::resolveUnit);
    }

    private static Unit resolveUnit(Function0 arg0) {
        arg0.invoke();
        return Unit.INSTANCE;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
