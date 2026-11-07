package su.catlean.client.services.client;

import java.util.ArrayDeque;
import kotlin.math.MathKt;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import su.catlean.SharedKt;

public class ScissorServiceComponent {

    public static final ScissorServiceComponent INSTANCE;
    private static final ArrayDeque arrayDeque;

    private ScissorServiceComponent() {
    }

    public void executeAction(ServiceComponent78 scissor) {
        class_1041 class1041 = SharedKt.getMc().method_22683();
        int index = class1041.method_4495();
        int index2 = class1041.method_4506();
        int index3 = (MathKt.roundToInt((scissor.getNumericValue() * index)) - 1.0F);
        int index4 = (MathKt.roundToInt((index2 - (scissor.getNumericValue4() * index))) - 1.0F);
        int index5 = (MathKt.roundToInt(((scissor.getNumericValue3() - scissor.getNumericValue()) * index)) + 1.0F);
        int index6 = (MathKt.roundToInt(((scissor.getNumericValue4() - scissor.getNumericValue2()) * index)) + 1.0F);
        arrayDeque.addLast(new ServiceComponent78(index3, index4, index5, index6));
    }

    public ServiceComponent78 resolveServiceComponent78() {
        return ((ServiceComponent78) arrayDeque.removeLast());
    }

    public ServiceComponent78 getServiceComponent78() {
        return ((ServiceComponent78) arrayDeque.peekLast());
    }

    static {
        INSTANCE = new ScissorServiceComponent();
        arrayDeque = new ArrayDeque();
    }

}
