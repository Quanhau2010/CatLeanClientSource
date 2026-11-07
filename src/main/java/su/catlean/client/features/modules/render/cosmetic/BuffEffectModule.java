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
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        arg0.getStack().method_22903();
        RenderHelper4.render(arg0.getStack(), ((Quaternionfc) class_7833.field_40716.rotationDegrees((class4184.method_19330() + 180.0F))));
        RenderHelper4.render(arg0.getStack(), ((Quaternionfc) class_7833.field_40714.rotationDegrees(class4184.method_19329())));
        int index = 4;
        int index2 = 0;
        int index3 = (itemList.size() * 2);
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        Iterator iterator = itemList.iterator();
        while (iterator.hasNext()) {
            ServiceComponent101 serviceComponent101 = ((ServiceComponent101) iterator.next());
            float factor = 0.0F;
            float factor2 = 90.0F;
            float factor3 = PolygonShaderComponent.INSTANCE.computeValue(Math.max(1, (serviceComponent101.getNumericValue2() - 1)), serviceComponent101.getNumericValue2());
            if (serviceComponent101.getNumericValue2() < 3) {
            } else {
                if (serviceComponent101.getNumericValue2() > 25) {
                } else {
                }
            }
            float factor4 = 1.0F;
            float factor5 = (8.0F * factor4);
            Color color = PolygonShaderComponent.INSTANCE.resolveColor(new Color(serviceComponent101.getNumericValue()), factor4);
            Color color2 = PolygonShaderComponent.INSTANCE.resolveColor(new Color(serviceComponent101.getNumericValue()), (factor4 * 0.3F));
            MatrixStack matrices = new MatrixStack();
            matrices.method_22903();
            RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40714.rotationDegrees(class4184.method_19329())));
            RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40716.rotationDegrees((class4184.method_19330() + 180.0F))));
            matrices.method_22904((serviceComponent101.getMinecraftObject().field_1352 - class4184.method_71156().field_1352), ((serviceComponent101.getMinecraftObject().field_1351 + 0.05F) - class4184.method_71156().field_1351), (serviceComponent101.getMinecraftObject().field_1350 - class4184.method_71156().field_1350));
            RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40716.rotationDegrees(factor)));
            RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40714.rotationDegrees(factor2)));
            matrices.method_22904(-4.0D, -4.0D, 0.0D);
            Matrix4f matrix4f = matrices.method_23760().method_23761();
            OptionMode6 optionMode6 = OptionMode6.CRACK;
            formatRenderHelper.resolveFormatRenderHelper(matrix4f, 0.0F, 8.0F, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color2);
            formatRenderHelper.resolveFormatRenderHelper(matrix4f, 8.0F, 8.0F, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color2);
            formatRenderHelper.resolveFormatRenderHelper(matrix4f, 8.0F, 0.0F, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color2);
            formatRenderHelper.resolveFormatRenderHelper(matrix4f, 0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color2);
            matrices.method_22904(4.0D, 4.0D, 0.0D);
            OptionMode6 optionMode62 = OptionMode6.CIRCLE;
            matrices.method_22904((factor5 / 2.0D), (factor5 / 2.0D), 0.0D);
            formatRenderHelper.resolveFormatRenderHelper(matrix4f, 0.0F, factor5, 0.0F).resolveFormatRenderHelper(optionMode62.getNumericValue3(), optionMode62.getNumericValue2()).resolveFormatRenderHelper(color);
            formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor5, factor5, 0.0F).resolveFormatRenderHelper(optionMode62.getNumericValue(), optionMode62.getNumericValue2()).resolveFormatRenderHelper(color);
            formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor5, 0.0F, 0.0F).resolveFormatRenderHelper(optionMode62.getNumericValue(), optionMode62.getNumericValue4()).resolveFormatRenderHelper(color);
            formatRenderHelper.resolveFormatRenderHelper(matrix4f, 0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(optionMode62.getNumericValue3(), optionMode62.getNumericValue4()).resolveFormatRenderHelper(color);
            matrices.method_22909();
        }
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline19(), null, null, arg0.getStack().method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0", SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659())));
        arg0.getStack().method_22909();
    }

    private void onTickEvent(TickEvent arg0) {
        itemList.removeIf(this::checkCondition);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (((class_2673) arg0.getPacket()).method_11532() != 2007) {
        }
        int index = ((class_2673) arg0.getPacket()).method_11534();
        int index2 = (((index >> 16) & 255) / 255.0F);
        int index3 = (((index >> 8) & 255) / 255.0F);
        int index4 = (((index >> 0) & 255) / 255.0F);
        Color color = new Color(index2, index3, index4);
        if (color.getRGB() == -13083194) {
            return;
        }
        countValue = color.getRGB();
    }

    private void onEntityRemove(EntityRemove arg0) {
        class_10691 class10691 = ((class_10691) arg0.getEntity());
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(class10691));
        itemList.add(new ServiceComponent101(blockPos.toCenterPos().method_1031(0.0D, -0.5D, 0.0D), countValue));
    }

    private static boolean checkCondition(ServiceComponent101 arg0) {
        if (arg0.getNumericValue2() == 3) {
            int index = 25;
            int index2 = 0;
            if (index2 < index) {
                int index3 = index2;
                POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(OptionMode6.FIREFLY, arg0.getMinecraftObject().method_1031(RangeServiceComponent.a(-3.0D, 3.0D, false), 0.0D, RangeServiceComponent.a(-3.0D, 3.0D, false)), 0.0F, 0.25F, 12, 0.0F, 0.0F, false));
            }
            index = 5;
            index2 = 0;
            if (index2 < index) {
                index3 = index2;
                POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(OptionMode6.FIREFLY, arg0.getMinecraftObject().method_1031(0.0D, -0.3D, 0.0D), 0.0F, 6.0F, 4, PolygonShaderComponent.INSTANCE.resolveColor(new Color(arg0.getNumericValue()), 0.5F), 0.0F, 0.0F, false));
            }
        }
        index = arg0.getNumericValue2();
        arg0.updateValue2((index + 1));
        return index > 30;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        INSTANCE = new BuffEffectModule();
        itemList = new ArrayList();
        countValue = -1;
    }

}
