package su.catlean.client.services.client;

import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import net.minecraft.class_11280;

public class CtlEspCamouflageUboServiceComponent {

    public static final CtlEspCamouflageUboServiceComponent INSTANCE;
    private static final int countValue;
    private static final class_11280 minecraftRef;

    private CtlEspCamouflageUboServiceComponent() {
    }

    public int getNumericValue() {
        return countValue;
    }

    public class_11280 getMinecraftObject() {
        return minecraftRef;
    }

    static {
        INSTANCE = new CtlEspCamouflageUboServiceComponent();
        countValue = new Std140SizeCalculator().putVec2().putVec4().putVec4().putVec4().putVec4().putFloat().putFloat().get();
        minecraftRef = new class_11280(countValue);
    }

}
