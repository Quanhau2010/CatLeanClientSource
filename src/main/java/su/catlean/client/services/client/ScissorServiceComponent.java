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
        class_1041 var6 = SharedKt.getMc().method_22683();
        int var7 = var6.method_4495();
        int var8 = var6.method_4506();
        int var9 = (MathKt.roundToInt((scissor.getNumericValue() * var7)) - 1.0F);
        int var10 = (MathKt.roundToInt((var8 - (scissor.getNumericValue4() * var7))) - 1.0F);
        int var11 = (MathKt.roundToInt(((scissor.getNumericValue3() - scissor.getNumericValue()) * var7)) + 1.0F);
        int var12 = (MathKt.roundToInt(((scissor.getNumericValue4() - scissor.getNumericValue2()) * var7)) + 1.0F);
        arrayDeque.addLast(new ServiceComponent78());
    }

    public ServiceComponent78 resolveServiceComponent78() {
        return (ServiceComponent78) arrayDeque.removeLast();
    }

    public ServiceComponent78 getServiceComponent78() {
        return (ServiceComponent78) arrayDeque.peekLast();
    }

    static {
        INSTANCE = new ScissorServiceComponent();
        arrayDeque = new ArrayDeque();
    }

}
