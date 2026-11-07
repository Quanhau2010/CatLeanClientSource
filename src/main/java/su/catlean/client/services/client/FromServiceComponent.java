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
        float var14 = maxStepIn;
        float var15 = class_3532.method_15393((to.getNumericValue() - from.getNumericValue()));
        float var16 = (to.getNumericValue2() - from.getNumericValue2());
        double var17 = Math.hypot();
        if (var17 < 1.5F) {
            return from;
        }
        factorValue5 = (factorValue5 / 1.732051F);
        factorValue6 = (factorValue6 / 1.732051F);
        if (var17 >= distance) {
            float var18 = (Math.min(wind) / 2.236068F);
            factorValue5 = (factorValue5 + (RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(-1.0F, 1.0F)) * var18));
            factorValue6 = (factorValue6 + (RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(-1.0F, 1.0F)) * var18));
        } else {
            if (var14 < 3.0F) {
            } else {
            }
            var14 = (var14 / 2.236068F);
        }
        factorValue3 = (factorValue3 + (factorValue5 + ((gravity * var15) / var17)));
        factorValue4 = (factorValue4 + (factorValue6 + ((gravity * var16) / var17)));
        var18 = Math.hypot(factorValue3, factorValue4);
        if (var18 > var14) {
            float var19 = ((var14 / 2.0F) + ((RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(0.0F, 1.0F)) * var14) / 2.0F));
            factorValue3 = ((factorValue3 / var18) * var19);
            factorValue4 = ((factorValue4 / var18) * var19);
        }
        return new MoveFixServiceComponent(class_3532.method_15393((from.getNumericValue() + factorValue3)), RangesKt.coerceIn((from.getNumericValue2() + factorValue4), -90.0F, 90.0F), 0, null, 1805851353591840780L);
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
