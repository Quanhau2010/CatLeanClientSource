package su.catlean.client.features.modules.utility.equip;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

public enum MiddleClickOnBlockMode {

    private final Function0 function0;
    private final Function0 function02;
    public static final MiddleClickOnBlockMode FIREWORK;
    public static final MiddleClickOnBlockMode FRIEND;
    public static final MiddleClickOnBlockMode PEARL;
    public static final MiddleClickOnBlockMode INSTANCE;
    public static final MiddleClickOnBlockMode NONE;

    MiddleClickOnBlockMode(String arg0, int arg1, Function0 arg2, Function0 arg3) {
        super(arg0, arg1);
        this.function0 = arg2;
        this.function02 = arg3;
    }

    MiddleClickOnBlockMode(String arg0, int arg1, Function0 arg2, Function0 arg3, int arg4, DefaultConstructorMarker arg5) {
        if ((arg4 & 2)) {
            arg3 = this::getUnit;
        }
        this(arg0, arg1, arg2, arg3);
    }

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
        if (var8) {
            MiddleClickModule var7 = MiddleClickModule.INSTANCE;
            if (!(MiddleClickModule.checkCondition())) {
            }
            MiddleClickModule.executeAction();
        }
        return Unit.INSTANCE;
    }

    private static Unit getUnit5() {
        if (var8) {
            MiddleClickModule var7 = MiddleClickModule.INSTANCE;
            if (MiddleClickModule.checkCondition()) {
            }
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
