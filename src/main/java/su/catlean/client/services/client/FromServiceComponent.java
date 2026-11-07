package su.catlean.client.services.client;

import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.minecraft.class_3532;
import su.catlean.client.features.modules.Module;

public class FromServiceComponent {

    public static final FromServiceComponent INSTANCE;
    private static final float factorValue = 1.732051F;
    private static final float factorValue2 = 2.236068F;
    private static float factorValue3;
    private static float factorValue4;
    private static float factorValue5;
    private static float factorValue6;
    private static Module[] moduleArray;

    private FromServiceComponent() {
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(MoveFixServiceComponent from, MoveFixServiceComponent to, float gravity, float wind, float maxStepIn, float distance) {
        float factor = maxStepIn;
        float factor2 = class_3532.method_15393((to.getNumericValue() - from.getNumericValue()));
        float factor3 = (to.getNumericValue2() - from.getNumericValue2());
        double offset = Math.hypot(factor2, factor3);
        if (offset < 1.5F) {
            return from;
        }
        factorValue5 = (factorValue5 / 1.732051F);
        factorValue6 = (factorValue6 / 1.732051F);
        if (offset >= distance) {
            float factor4 = (Math.min(wind, offset) / 2.236068F);
            factorValue5 = (factorValue5 + (RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(-1.0F, 1.0F)), false) * factor4));
            factorValue6 = (factorValue6 + (RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(-1.0F, 1.0F)), false) * factor4));
        } else {
            if (factor < 3.0F) {
            } else {
            }
            factor = (factor / 2.236068F);
        }
        factorValue3 = (factorValue3 + (factorValue5 + ((gravity * factor2) / offset)));
        factorValue4 = (factorValue4 + (factorValue6 + ((gravity * factor3) / offset)));
        factor4 = Math.hypot(factorValue3, factorValue4);
        if (factor4 > factor) {
            float factor5 = ((factor / 2.0F) + ((RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(0.0F, 1.0F)), false) * factor) / 2.0F));
            factorValue3 = ((factorValue3 / factor4) * factor5);
            factorValue4 = ((factorValue4 / factor4) * factor5);
        }
        return new MoveFixServiceComponent(class_3532.method_15393((from.getNumericValue() + factorValue3)), RangesKt.coerceIn((from.getNumericValue2() + factorValue4), -90.0F, 90.0F), false);
    }

    static {
        INSTANCE = new FromServiceComponent();
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
