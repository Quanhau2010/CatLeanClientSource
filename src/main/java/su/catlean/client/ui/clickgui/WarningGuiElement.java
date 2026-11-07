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
        int index = (this.field_22789 / 2.0F);
        int index2 = (this.field_22790 / 2.0F);
        Color[] items = new Color[1];
        items[0] = new Color(-1072689136);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), 0.0F, 0.0F, this.field_22789, this.field_22790, items);
        String[] items2 = new String[1];
        items2[0] = ", ";
        items = StringsKt.split$default(((CharSequence) KeyServiceComponent.INSTANCE.resolveString("gui.version.confirm", new Object[0])), items2, false);
        items2 = 0.0F;
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            String text = ((String) iterator.next());
            SFMServiceComponent.resolveFontRenderHelper7().render(context, text, index, ((index2 - 10.0F) + items2), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.5F));
            items2 = (items2 + 23.0F);
        }
        iterator = 360;
        if (iterator >= 180) {
        } else {
        }
        text = PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, Color.YELLOW, (iterator / 360.0F));
        MissingnoRenderHelper.executeAction(this.missingnoRenderHelper, ((Matrix3x2f) context.method_51448()), (index - 16.0D), (index2 - 60.0D), 0.0F, 0.0F, text, null, 0.0F);
        this.labelRenderHelper2.render((index - 110.0F), (index2 + 40.0F), mouseX, mouseY, context);
        this.labelRenderHelper.render((index + 10.0F), (index2 + 40.0F), mouseX, mouseY, context);
    }

    public boolean method_25402(class_11909 click, boolean doubled) {
        double offset = click.comp_4798();
        double offset2 = click.comp_4799();
        this.labelRenderHelper.executeAction(offset, offset2);
        this.labelRenderHelper2.executeAction(offset, offset2);
        return this.method_25402(click, doubled);
    }

    public void method_25419() {
    }

    private static Unit getUnit() {
        String text = "https://catlean.su/";
        class_156.method_668().method_673(URI.create(text));
        return Unit.INSTANCE;
    }

    private static Unit getUnit2() {
        SharedKt.getMc().close();
        return Unit.INSTANCE;
    }

}
