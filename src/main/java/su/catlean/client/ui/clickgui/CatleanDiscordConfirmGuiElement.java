package su.catlean.client.ui.clickgui;

import java.awt.Color;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_442;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.misc.RPCModule;
import su.catlean.client.services.client.AppIdXDGRUNTIMEDIRServiceComponentImpl;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.StringServiceComponent2;
import su.catlean.client.services.client.UrlServiceComponent;
import su.catlean.client.services.client.config.models.IdRecord2;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.LabelRenderHelper;
import su.catlean.client.services.render.shader.ColorValueShaderComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class CatleanDiscordConfirmGuiElement extends Screen {

    private final class_2960 minecraftRef;
    private final LabelRenderHelper labelRenderHelper;
    private final LabelRenderHelper labelRenderHelper2;

    public CatleanDiscordConfirmGuiElement() {
        super(class_2561.method_30163("catlean-discord-confirm"));
        this.minecraftRef = StringServiceComponent2.resolveMinecraftObject("catlean", "textures/exclude/discord_confirm.png");
        this.labelRenderHelper = new LabelRenderHelper(0.0F, 0.0F, 100.0F, 25.0F, KeyServiceComponent.INSTANCE.resolveString("gui.discord.yes", new Object[0]), this::getUnit, 0, null, null, 0.0F, 0.0F);
        this.labelRenderHelper2 = new LabelRenderHelper(0.0F, 0.0F, 100.0F, 25.0F, KeyServiceComponent.INSTANCE.resolveString("gui.discord.no", new Object[0]), this::getUnit2, 0, null, null, 0.0F, 0.0F);
    }

    public void method_25394(DrawContext context, int mouseX, int mouseY, float delta) {
        int index = (this.field_22789 / 2.0F);
        int index2 = (this.field_22790 / 2.0F);
        Color[] items = new Color[1];
        items[0] = new Color(-1072689136);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), 0.0F, 0.0F, this.field_22789, this.field_22790, items);
        items = (SFMServiceComponent.resolveFontRenderHelper7().computeValue("...") / 2.0F);
        SFMServiceComponent.resolveFontRenderHelper7().render(context, "...", (index - items), (index2 - 94.0F), Color.GRAY);
        context.render("...", StringsKt.dropLast(3, (4 - (SharedKt.getNumericValue() * (1200.0D / 1200.0D)))), (index - items), (index2 - 94.0F), Color.WHITE);
        SFMServiceComponent.resolveFontRenderHelper7().render(context, KeyServiceComponent.INSTANCE.resolveString("gui.discord.confirm", new Object[0]), index, (index2 - 10.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.5F));
        if (__UNDEF_KEY__ != null) {
            if (!(Intrinsics.areEqual(AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.getIdRecord22(), AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.getIdRecord2()))) {
                ColorValueShaderComponent.executeAction((index - 85.0F), (index2 - 108.0F), 65.0F, 65.0F, 32.5F, 2.0F, 0.0F, 1.0F, Color.WHITE, Color.WHITE, context.method_51448(), UrlServiceComponent.INSTANCE.resolveMinecraftObject(IdRecord2.resolveString(AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.getIdRecord22(), 0, true)));
                if (__UNDEF_KEY__ == null) {
                    ColorValueShaderComponent.executeAction((index - 85.0F), (index2 - 108.0F), 65.0F, 65.0F, 32.5F, 2.0F, 0.0F, 1.0F, Color.WHITE, Color.WHITE, context.method_51448(), UrlServiceComponent.INSTANCE.resolveMinecraftObject("https://i.imgur.com/y5rOVPP.png"));
                }
            }
        }
        ColorValueShaderComponent.executeAction((index + 20), (index2 - 108), 65.0F, 65.0F, 32.5F, 2.0F, 0.0F, 1.0F, Color.WHITE, Color.WHITE, context.method_51448(), this.minecraftRef);
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

    protected void method_57734(DrawContext context) {
    }

    public void method_25420(DrawContext context, float deltaTicks) {
    }

    private static Unit getUnit() {
        RPCModule.INSTANCE.setEnabled(true);
        SharedKt.getMc().method_1507(new class_442());
        return Unit.INSTANCE;
    }

    private static Unit getUnit2() {
        RPCModule.INSTANCE.setEnabled(false);
        SharedKt.getMc().method_1507(new class_442());
        return Unit.INSTANCE;
    }

}
