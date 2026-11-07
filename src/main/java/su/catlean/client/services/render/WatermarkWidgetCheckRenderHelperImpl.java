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
        long var4 = (0L ^ 50910300018319L);
        long var6 = (0L ^ 42099833797024L);
        long var8 = (0L ^ 21040909390270L);
        long var10 = (0L ^ 129362142031597L);
        long var12 = (0L ^ 39732485283849L);
        long var14 = (0L ^ 90317468167310L);
        long var16 = (0L ^ 109580710346244L);
        long var18 = ((0L ^ 104104530525409L) >>> 48);
        long var19 = (((0L ^ 104104530525409L) << 16) >>> 32);
        long var20 = (((0L ^ 104104530525409L) << 48) >>> 48);
        long var21 = (0L ^ 16349136930672L);
        long var23 = (0L ^ 128377113661390L);
        long var25 = (0L ^ 20173347401993L);
        long var27 = (0L ^ 99949442920536L);
        long var29 = (0L ^ 30591967126976L);
        String var32 = (class_124.field_1080 + CatLeanKt.getModContainer().getMetadata().getVersion());
        String var33 = SharedKt.getPlayer().method_7334().name();
        if (SharedKt.getNetwork().method_45734() != null) {
            if (SharedKt.getNetwork().method_45734().field_3761 == null) {
            }
        }
        String var34 = "singleplayer";
        float var35 = SFMServiceComponent.resolveFontRenderHelper().computeValue(("CatLean " + var32));
        float var36 = SFMServiceComponent.resolveFontRenderHelper().computeValue();
        float var37 = SFMServiceComponent.resolveFontRenderHelper().computeValue();
        float var38 = this.computeValue();
        CheckRenderHelper.executeAction(this, context.method_51448(), (var38 + 30.0F), this.computeValue2(), (var35 + 10.0F), 13.0F, 0.0F);
        CheckRenderHelper.executeAction(this, context.method_51448(), (var38 + 30.0F), (this.computeValue2() + 14.0F), (var36 + 6.0F), 13.0F, 0.0F);
        CheckRenderHelper.executeAction(this, context.method_51448(), (((var38 + 31.0F) + var36) + 6.0F), (this.computeValue2() + 14.0F), (var37 + 7.0F), 13.0F, 0.0F);
        this.render(context, ((var38 + 33.0F) + SFMServiceComponent.resolveFontRenderHelper6().computeValue("CatLean")), (this.computeValue2() + 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, (var38 + 33.0F), (this.computeValue2() + 15.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        if (0L >= 0L) {
            this.render(context, ((var38 + 40.5F) + var36), (this.computeValue2() + 15.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        }
        if (!(Intrinsics.areEqual(AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.getIdRecord22(), AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.getIdRecord2()))) {
            ColorValueShaderComponent.executeAction((var38 + 1.0F), (this.computeValue2() - 1.0F), 27.0F, 27.0F, 3.0F, 2.0F, 0.0F, 1.0F, Color.WHITE, NewThemeRenderHelper.INSTANCE.getColor5(), context.method_51448(), UrlServiceComponent.INSTANCE.resolveMinecraftObject(IdRecord2.resolveString(AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.getIdRecord22())));
            if (0L >= 0L) {
            }
            this.render(context);
            this.executeAction((var35 + 40.0F), 28.0F);
        }
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 118901760466898L);
        long var6 = (0L ^ 84319185194541L);
        long var8 = (0L ^ 127062392772158L);
        long var10 = (0L ^ 98664999447709L);
        SFMServiceComponent.resolveFontRenderHelper6().render(context, "CatLean", (this.computeValue() + 33.0F), (this.computeValue2() + 0.5F), 10);
    }

    private void render(DrawContext arg0, float arg1) {
        arg0.method_51448().pushMatrix();
        PolygonShaderComponent.executeAction((Matrix3x2f) arg0.method_51448(), (AbstractClientPlayerEntity) SharedKt.getPlayer().method_52814().comp_1626().comp_3627(), (arg1 + 3.0F), (this.computeValue2() + 1.0F), 24.0F, 24.0F, Color.WHITE, null, null, null, 0.125F, 0.125F, 0.25F, 0.25F);
        PolygonShaderComponent.executeAction((Matrix3x2f) arg0.method_51448(), (AbstractClientPlayerEntity) SharedKt.getPlayer().method_52814().comp_1626().comp_3627(), (arg1 + 1.0F), (this.computeValue2() - 1.0F), 28.0F, 28.0F, Color.WHITE, null, null, null, 0.625F, 0.125F, 0.75F, 0.25F);
        arg0.method_51448().popMatrix();
    }

    static {
        INSTANCE = new WatermarkWidgetCheckRenderHelperImpl();
    }

}
