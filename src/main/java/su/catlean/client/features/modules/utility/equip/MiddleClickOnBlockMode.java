package su.catlean.client.features.modules.utility.equip;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public enum MiddleClickOnBlockMode {

    FIREWORK,
    FRIEND,
    PEARL,
    INSTANCE,
    NONE;

    private final Function0 function0;
    private final Function0 function02;

    public Function0 getFunction0() {
        return this.function0;
    }

    public Function0 getFunction02() {
        return this.function02;
    }

    private static Unit getUnit() {
        return Unit.INSTANCE;
    }

    private static Unit getUnit2() {
        MiddleClickModule.executeAction();
        return Unit.INSTANCE;
    }

    private static Unit getUnit3() {
        MiddleClickModule.executeAction();
        return Unit.INSTANCE;
    }

    private static Unit getUnit4() {
        if (!(MiddleClickModule.checkCondition())) {
            MiddleClickModule.executeAction();
        }
        return Unit.INSTANCE;
    }

    private static Unit getUnit5() {
        if (MiddleClickModule.checkCondition()) {
            MiddleClickModule.executeAction();
        }
        return Unit.INSTANCE;
    }

    private static Unit getUnit6() {
        MiddleClickModule.executeAction2();
        return Unit.INSTANCE;
    }

    private static Unit getUnit7() {
        return Unit.INSTANCE;
    }

}
