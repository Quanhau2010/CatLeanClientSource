package su.catlean.client.services.client;

import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import net.minecraft.class_11280;

public class CtlEspBloomUboServiceComponent {

    public static final CtlEspBloomUboServiceComponent INSTANCE;
    private static final int countValue;
    private static final class_11280 minecraftRef;

    private CtlEspBloomUboServiceComponent() {
    }

    public int getNumericValue() {
        return countValue;
    }

    public class_11280 getMinecraftObject() {
        return minecraftRef;
    }

    static {
        INSTANCE = new CtlEspBloomUboServiceComponent();
        countValue = new Std140SizeCalculator().putVec2().putVec2().putFloat().putFloat().putMat4f().putVec4().get();
        minecraftRef = new class_11280(countValue, 0);
    }

}
