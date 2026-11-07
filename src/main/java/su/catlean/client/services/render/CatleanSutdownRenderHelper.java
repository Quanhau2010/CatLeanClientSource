package su.catlean.client.services.render;

import java.awt.Color;
import net.minecraft.class_1041;
import net.minecraft.class_2561;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import org.joml.Matrix3x2f;
import su.catlean.SharedKt;

public class CatleanSutdownRenderHelper extends Screen {

    public static final CatleanSutdownRenderHelper INSTANCE;
    private static final MissingnoRenderHelper missingnoRenderHelper;

    private CatleanSutdownRenderHelper() {
        super(class_2561.method_30163("catlean-sutdown"));
    }

    public void method_25394(DrawContext context, float delta) {
        int var13 = SharedKt.getMc().method_22683().method_4486();
        int var14 = SharedKt.getMc().method_22683().method_4502();
        int var15 = new Color(-1072689136).getRGB();
        context.method_25294(0, 0);
        MissingnoRenderHelper.executeAction(missingnoRenderHelper, (Matrix3x2f) context.method_51448(), ((var13 / 2.0D) - (missingnoRenderHelper.getNumericValue() / 2.0D)), ((var14 / 2.0D) - (missingnoRenderHelper.getNumericValue2() / 2.0D)), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.resolveColor(0), NewThemeRenderHelper.INSTANCE.resolveColor(180), 0.0F);
    }

    static {
        INSTANCE = new CatleanSutdownRenderHelper();
        missingnoRenderHelper = new MissingnoRenderHelper("logo", 230, 50);
    }

}
