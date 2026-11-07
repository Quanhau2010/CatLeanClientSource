package su.catlean.client.services.client;

import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import net.minecraft.class_11280;

public class CtlVUboServiceComponent {

    public static final CtlVUboServiceComponent INSTANCE;
    private static final int countValue;
    private static final class_11280 minecraftRef;

    private CtlVUboServiceComponent() {
    }

    public int getNumericValue() {
        return countValue;
    }

    public class_11280 getMinecraftObject() {
        return minecraftRef;
    }

    static {
        INSTANCE = new CtlVUboServiceComponent();
        countValue = new Std140SizeCalculator().putMat4f().putMat4f().get();
        minecraftRef = new class_11280(countValue, 0);
    }

}
