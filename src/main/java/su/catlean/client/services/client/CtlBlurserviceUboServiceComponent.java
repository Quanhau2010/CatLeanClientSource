package su.catlean.client.services.client;

import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import net.minecraft.class_11280;

public class CtlBlurserviceUboServiceComponent {

    public static final CtlBlurserviceUboServiceComponent INSTANCE;
    private static final int countValue;
    private static final class_11280 minecraftRef;

    private CtlBlurserviceUboServiceComponent() {
    }

    public int getNumericValue() {
        return countValue;
    }

    public class_11280 getMinecraftObject() {
        return minecraftRef;
    }

    static {
        INSTANCE = new CtlBlurserviceUboServiceComponent();
        countValue = new Std140SizeCalculator().putVec2().putFloat().get();
        minecraftRef = new class_11280(countValue, 0);
    }

}
