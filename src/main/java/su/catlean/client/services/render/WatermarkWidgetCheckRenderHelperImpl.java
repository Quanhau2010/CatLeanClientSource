package su.catlean.client.services.render;

import com.mojang.authlib.GameProfile;
import java.awt.Color;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.class_12079.class_12081;
import net.minecraft.class_124;
import net.minecraft.class_8685;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import su.catlean.CatLeanKt;
import su.catlean.SharedKt;
import su.catlean.client.services.client.AppIdXDGRUNTIMEDIRServiceComponentImpl;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.UrlServiceComponent;
import su.catlean.client.services.client.config.models.IdRecord2;
import su.catlean.client.services.render.shader.ColorValueShaderComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class WatermarkWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final WatermarkWidgetCheckRenderHelperImpl INSTANCE;

    private WatermarkWidgetCheckRenderHelperImpl() {
        super("watermark-widget");
    }

    public void render(DrawContext context) {
        String text = (class_124.field_1080 + CatLeanKt.getModContainer().getMetadata().getVersion());
        String text2 = SharedKt.getPlayer().method_7334().name();
        if (SharedKt.getNetwork().method_45734() != null) {
            if (SharedKt.getNetwork().method_45734().field_3761 == null) {
            }
        }
        String text3 = "singleplayer";
        float factor = SFMServiceComponent.resolveFontRenderHelper().computeValue(("CatLean " + text));
        float factor2 = SFMServiceComponent.resolveFontRenderHelper().computeValue(text2);
        float factor3 = SFMServiceComponent.resolveFontRenderHelper().computeValue(text3);
        float factor4 = this.computeValue();
        CheckRenderHelper.executeAction(this, context.method_51448(), (factor4 + 30.0F), this.computeValue2(), (factor + 10.0F), 13.0F, 0.0F, false);
        CheckRenderHelper.executeAction(this, context.method_51448(), (factor4 + 30.0F), (this.computeValue2() + 14.0F), (factor2 + 6.0F), 13.0F, 0.0F, false);
        CheckRenderHelper.executeAction(this, context.method_51448(), (((factor4 + 31.0F) + factor2) + 6.0F), (this.computeValue2() + 14.0F), (factor3 + 7.0F), 13.0F, 0.0F, false);
        this.render(context, text, ((factor4 + 33.0F) + SFMServiceComponent.resolveFontRenderHelper6().computeValue("CatLean")), (this.computeValue2() + 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, text2, (factor4 + 33.0F), (this.computeValue2() + 15.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, text3, ((factor4 + 40.5F) + factor2), (this.computeValue2() + 15.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        if (!(Intrinsics.areEqual(AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.getIdRecord22(), AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.getIdRecord2()))) {
            ColorValueShaderComponent.executeAction((factor4 + 1.0F), (this.computeValue2() - 1.0F), 27.0F, 27.0F, 3.0F, 2.0F, 0.0F, 1.0F, Color.WHITE, NewThemeRenderHelper.INSTANCE.getColor5(), context.method_51448(), UrlServiceComponent.INSTANCE.resolveMinecraftObject(IdRecord2.resolveString(AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.getIdRecord22(), 0, true)));
        }
        this.render(context, factor4);
        this.executeAction((factor + 40.0F), 28.0F);
    }

    public void render(DrawContext context) {
        SFMServiceComponent.resolveFontRenderHelper6().render(context, "CatLean", (this.computeValue() + 33.0F), (this.computeValue2() + 0.5F), 10);
    }

    private void render(DrawContext arg0, float arg1) {
        arg0.method_51448().pushMatrix();
        PolygonShaderComponent.executeAction(((Matrix3x2f) arg0.method_51448()), ((AbstractClientPlayerEntity) SharedKt.getPlayer()).method_52814().comp_1626().comp_3627(), (arg1 + 3.0F), (this.computeValue2() + 1.0F), 24.0F, 24.0F, Color.WHITE, null, null, null, 0.125F, 0.125F, 0.25F, 0.25F, false);
        PolygonShaderComponent.executeAction(((Matrix3x2f) arg0.method_51448()), ((AbstractClientPlayerEntity) SharedKt.getPlayer()).method_52814().comp_1626().comp_3627(), (arg1 + 1.0F), (this.computeValue2() - 1.0F), 28.0F, 28.0F, Color.WHITE, null, null, null, 0.625F, 0.125F, 0.75F, 0.25F, false);
        arg0.method_51448().popMatrix();
    }

    static {
        INSTANCE = new WatermarkWidgetCheckRenderHelperImpl();
    }

}
