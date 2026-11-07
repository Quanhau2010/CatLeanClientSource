package su.catlean.client.services.client;

import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import net.minecraft.class_11280;

public class CtlRectBlurredUboServiceComponent {

    public static final CtlRectBlurredUboServiceComponent INSTANCE;
    private static final int countValue;
    private static final class_11280 minecraftRef;

    private CtlRectBlurredUboServiceComponent() {
    }

    public class_11280 getMinecraftObject() {
        return minecraftRef;
    }

    static {
        INSTANCE = new CtlRectBlurredUboServiceComponent();
        countValue = new Std140SizeCalculator().putVec2().putFloat().putFloat().putVec4().get();
        minecraftRef = new class_11280(countValue, 0);
    }

}
