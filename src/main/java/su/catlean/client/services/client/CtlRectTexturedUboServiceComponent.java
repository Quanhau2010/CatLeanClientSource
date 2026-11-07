package su.catlean.client.services.client;

import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import net.minecraft.class_11280;

public class CtlRectTexturedUboServiceComponent {

    public static final CtlRectTexturedUboServiceComponent INSTANCE;
    private static final int countValue;
    private static final class_11280 minecraftRef;

    private CtlRectTexturedUboServiceComponent() {
    }

    public class_11280 getMinecraftObject() {
        return minecraftRef;
    }

    public void executeAction() {
        minecraftRef.method_71100();
    }

    static {
        INSTANCE = new CtlRectTexturedUboServiceComponent();
        countValue = new Std140SizeCalculator().putVec2().putFloat().putFloat().putVec4().putFloat().putVec4().putFloat().get();
        minecraftRef = new class_11280(countValue, 0);
    }

}
