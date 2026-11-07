package su.catlean.client.services.client;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class RotationRotationServiceComponent4Impl2 extends RotationServiceComponent4 {

    public RotationRotationServiceComponent4Impl2(MoveFixServiceComponent rotation, int priority, Function0 action) {
        super(rotation, priority, this::resolveUnit);
    }

    private static Unit resolveUnit(Function0 arg0) {
        arg0.invoke();
        return Unit.INSTANCE;
    }

}
