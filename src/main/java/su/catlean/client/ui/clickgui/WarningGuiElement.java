package su.catlean.client.ui.clickgui;

import java.awt.Color;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.text.StringsKt;
import net.minecraft.class_11909;
import net.minecraft.class_156;
import net.minecraft.class_156.class_158;
import net.minecraft.class_2561;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import org.joml.Matrix3x2f;
import su.catlean.SharedKt;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.LabelRenderHelper;
import su.catlean.client.services.render.MissingnoRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class WarningGuiElement extends Screen {

    private final MissingnoRenderHelper missingnoRenderHelper;
    private final LabelRenderHelper labelRenderHelper;
    private final LabelRenderHelper labelRenderHelper2;

    public WarningGuiElement() {
        super(class_2561.method_30163("catlean-version-info-screen"));
        this.missingnoRenderHelper = new MissingnoRenderHelper("warning", 32, 32);
        this.labelRenderHelper = new LabelRenderHelper(0.0F, 0.0F, 100.0F, 25.0F, KeyServiceComponent.INSTANCE.resolveString("gui.version.yes", new Object[0]), this::getUnit, 0, null, null, 0.0F, 0.0F);
        this.labelRenderHelper2 = new LabelRenderHelper(0.0F, 0.0F, 100.0F, 25.0F, KeyServiceComponent.INSTANCE.resolveString("gui.version.no", new Object[0]), this::getUnit2, 0, null, null, 0.0F, 0.0F);
    }

    public void method_25394(DrawContext context, int mouseX, int mouseY, float delta) {
        int var26 = (this.field_22789 / 2.0F);
        int var27 = (this.field_22790 / 2.0F);
        Color[] var28 = new Color[1];
        var28[0] = new Color(-1072689136);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), 0.0F, 0.0F, this.field_22789, this.field_22790);
        String[] var29 = new String[1];
        var29[0] = ", ";
        var28 = StringsKt.split$default((CharSequence) KeyServiceComponent.INSTANCE.resolveString("gui.version.confirm", new Object[0]));
        var29 = 0.0F;
        Iterator iterator = var28.iterator();
        while (iterator.hasNext()) {
            String var31 = (String) iterator.next();
            SFMServiceComponent.resolveFontRenderHelper7().render(context, ((var27 - 10.0F) + var29), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.5F));
            var29 = (var29 + 23.0F);
        }
        iterator = 360;
        if (iterator >= 180) {
        } else {
        }
        var31 = PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, Color.YELLOW, (iterator / 360.0F));
        MissingnoRenderHelper.executeAction(this.missingnoRenderHelper, (Matrix3x2f) context.method_51448(), (var26 - 16.0D), (var27 - 60.0D), 0.0F, 0.0F, null, 0.0F);
        this.labelRenderHelper2.render((var26 - 110.0F), (var27 + 40.0F), mouseX, mouseY, context);
        this.labelRenderHelper.render((var26 + 10.0F), (var27 + 40.0F), mouseX, mouseY, context);
    }

    public boolean method_25402(class_11909 click, boolean doubled) {
        double var7 = click.comp_4798();
        double var9 = click.comp_4799();
        this.labelRenderHelper.executeAction();
        this.labelRenderHelper2.executeAction();
        return this.method_25402(click, doubled);
    }

    public void method_25419() {
    }

    private static Unit getUnit() {
        String var2 = "https://catlean.su/";
        class_156.method_668().method_673(URI.create());
        return Unit.INSTANCE;
    }

    private static Unit getUnit2() {
        SharedKt.getMc().close();
        return Unit.INSTANCE;
    }

}
