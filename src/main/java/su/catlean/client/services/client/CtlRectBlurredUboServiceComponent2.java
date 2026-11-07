package su.catlean.client.services.client;

import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import net.minecraft.class_11280;

public class CtlRectBlurredUboServiceComponent2 {

    public static final CtlRectBlurredUboServiceComponent2 INSTANCE;
    private static final int countValue;
    private static final class_11280 minecraftRef;
    private static String[] textValueArray;

    private CtlRectBlurredUboServiceComponent2() {
    }

    public class_11280 getMinecraftObject() {
        return minecraftRef;
    }

    static {
        INSTANCE = new CtlRectBlurredUboServiceComponent2();
        countValue = new Std140SizeCalculator().putVec4().putFloat().putVec4().putVec4().putFloat().get();
        minecraftRef = new class_11280(countValue);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
