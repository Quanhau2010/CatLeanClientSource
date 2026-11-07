package su.catlean.client.services.client;

import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import net.minecraft.class_11280;

public class CtlEspDoubleGlowUboServiceComponent {

    public static final CtlEspDoubleGlowUboServiceComponent INSTANCE;
    private static final int countValue;
    private static final class_11280 minecraftRef;

    private CtlEspDoubleGlowUboServiceComponent() {
    }

    public int getNumericValue() {
        return countValue;
    }

    public class_11280 getMinecraftObject() {
        return minecraftRef;
    }

    static {
        INSTANCE = new CtlEspDoubleGlowUboServiceComponent();
        countValue = new Std140SizeCalculator().putFloat().putVec4().putVec4().putInt().putInt().putFloat().putFloat().putInt().putFloat().putVec2().putFloat().putFloat().get();
        minecraftRef = new class_11280(countValue);
    }

}
