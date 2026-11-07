package su.catlean.client.features.modules.render.cosmetic;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_10691;
import net.minecraft.class_2673;
import net.minecraft.class_290;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.TickEvent;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.world.EntityRemove;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.AtlasTextureServiceComponent;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.ServiceComponent101;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.RenderHelper4;
import su.catlean.client.services.render.TexRenderHelper;
import su.catlean.client.services.render.shader.POSITIONTEXCOLORShaderComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.types.OptionMode6;

public class BuffEffectModule extends Module {

    public static final BuffEffectModule INSTANCE;
    private static final List itemList;
    private static int countValue;

    private BuffEffectModule() {
        super("buff-effect", SubCategoriesKt.getCosmeticCategory());
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        class_4184 var29 = SharedKt.getMc().field_1773.method_19418();
        arg0.getStack().method_22903();
        RenderHelper4.render(arg0.getStack(), (Quaternionfc) class_7833.field_40716.rotationDegrees((var29.method_19330() + 180.0F)));
        RenderHelper4.render(arg0.getStack(), (Quaternionfc) class_7833.field_40714.rotationDegrees(var29.method_19329()));
        int var24 = 4;
        int var25 = 0;
        int var26 = (itemList.size() * 2);
        VertexFormat var27 = class_290.field_1575;
        FormatRenderHelper var30 = new FormatRenderHelper();
        Iterator iterator = itemList.iterator();
        while (iterator.hasNext()) {
            ServiceComponent101 var32 = (ServiceComponent101) iterator.next();
            float var33 = 0.0F;
            float var34 = 90.0F;
            float var35 = PolygonShaderComponent.INSTANCE.computeValue(Math.max(1, (var32.getNumericValue2() - 1)), var32.getNumericValue2());
            if (var32.getNumericValue2() < 3) {
            } else {
                if (var32.getNumericValue2() > 25) {
                } else {
                }
            }
            float var36 = 1.0F;
            float var37 = (8.0F * var36);
            Color var38 = PolygonShaderComponent.INSTANCE.resolveColor(new Color(var32.getNumericValue()));
            Color var39 = PolygonShaderComponent.INSTANCE.resolveColor(new Color(var32.getNumericValue()), (var36 * 0.3F));
            MatrixStack matrices = new MatrixStack();
            matrices.method_22903();
            RenderHelper4.render(matrices, (Quaternionfc) class_7833.field_40714.rotationDegrees(var29.method_19329()));
            RenderHelper4.render(matrices, (Quaternionfc) class_7833.field_40716.rotationDegrees((var29.method_19330() + 180.0F)));
            matrices.method_22904((var32.getMinecraftObject().field_1352 - var29.method_71156().field_1352), ((var32.getMinecraftObject().field_1351 + 0.05F) - var29.method_71156().field_1351), (var32.getMinecraftObject().field_1350 - var29.method_71156().field_1350));
            RenderHelper4.render(matrices, (Quaternionfc) class_7833.field_40716.rotationDegrees());
            RenderHelper4.render(matrices, (Quaternionfc) class_7833.field_40714.rotationDegrees());
            matrices.method_22904(-4.0D, -4.0D, 0.0D);
            Matrix4f var41 = matrices.method_23760().method_23761();
            OptionMode6 var42 = OptionMode6.CRACK;
            var30.resolveFormatRenderHelper(0.0F, 8.0F, 0.0F).resolveFormatRenderHelper(var42.getNumericValue3(), var42.getNumericValue2()).resolveFormatRenderHelper();
            var30.resolveFormatRenderHelper(8.0F, 8.0F, 0.0F).resolveFormatRenderHelper(var42.getNumericValue(), var42.getNumericValue2()).resolveFormatRenderHelper();
            var30.resolveFormatRenderHelper(8.0F, 0.0F, 0.0F).resolveFormatRenderHelper(var42.getNumericValue(), var42.getNumericValue4()).resolveFormatRenderHelper();
            var30.resolveFormatRenderHelper(0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(var42.getNumericValue3(), var42.getNumericValue4()).resolveFormatRenderHelper();
            matrices.method_22904(4.0D, 4.0D, 0.0D);
            OptionMode6 var43 = OptionMode6.CIRCLE;
            matrices.method_22904((var37 / 2.0D), (var37 / 2.0D), 0.0D);
            var30.resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(var43.getNumericValue3(), var43.getNumericValue2()).resolveFormatRenderHelper();
            var30.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var43.getNumericValue(), var43.getNumericValue2()).resolveFormatRenderHelper();
            var30.resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(var43.getNumericValue(), var43.getNumericValue4()).resolveFormatRenderHelper();
            var30.resolveFormatRenderHelper(0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(var43.getNumericValue3(), var43.getNumericValue4()).resolveFormatRenderHelper();
            matrices.method_22909();
        }
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline19(), null, null, arg0.getStack().method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0", SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659())));
        arg0.getStack().method_22909();
    }

    private void onTickEvent(TickEvent arg0) {
        itemList.removeIf(this::checkCondition);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if ((class_2673) arg0.getPacket().method_11532() != 2007) {
        }
        int var5 = (class_2673) arg0.getPacket().method_11534();
        int var6 = (((var5 >> 16) & 255) / 255.0F);
        int var7 = (((var5 >> 8) & 255) / 255.0F);
        int var8 = (((var5 >> 0) & 255) / 255.0F);
        Color var9 = new Color();
        if (var9.getRGB() == -13083194) {
            return;
        }
        countValue = var9.getRGB();
    }

    private void onEntityRemove(EntityRemove arg0) {
        if (var9) {
        }
        class_10691 var10 = (class_10691) arg0.getEntity();
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject());
        itemList.add(new ServiceComponent101(blockPos.toCenterPos().method_1031(0.0D, -0.5D, 0.0D), countValue));
    }

    private static boolean checkCondition(ServiceComponent101 arg0) {
        if (arg0.getNumericValue2() == 3) {
            int var11 = 25;
            int var12 = 0;
            if (var12 < var11) {
                int var13 = var12;
                int var14 = 0;
                POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(OptionMode6.FIREFLY, arg0.getMinecraftObject().method_1031(RangeServiceComponent.a(-3.0D, 3.0D), 0.0D, RangeServiceComponent.a(-3.0D, 3.0D)), 0.0F, 0.25F, 12, new Vec3d(((Math.random() / 2.0F) - 0.25F), (Math.random() / 4.0F), ((Math.random() / 2.0F) - 0.25F)), new Color(arg0.getNumericValue()), 0.0F, 0.0F));
            }
            var11 = 5;
            var12 = 0;
            if (var12 < var11) {
                var13 = var12;
                var14 = 0;
                POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(OptionMode6.FIREFLY, arg0.getMinecraftObject().method_1031(0.0D, -0.3D, 0.0D), 0.0F, 6.0F, 4, new Vec3d(0.0D, (var13 * 0.15D), 0.0D), PolygonShaderComponent.INSTANCE.resolveColor(new Color(arg0.getNumericValue()), 0.5F), 0.0F, 0.0F));
            }
        }
        var11 = arg0.getNumericValue2();
        arg0.updateValue2((var11 + 1));
        return var11 > 30;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        INSTANCE = new BuffEffectModule();
        itemList = new ArrayList();
        countValue = -1;
    }

}
