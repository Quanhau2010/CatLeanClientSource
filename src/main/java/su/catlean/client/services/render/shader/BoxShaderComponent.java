package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_4604;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.services.client.ServiceComponent12;
import su.catlean.client.services.client.StringServiceComponent2;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;

public class BoxShaderComponent {

    public static final BoxShaderComponent INSTANCE;
    private static final class_2960 minecraftRef;
    private static final List itemList;

    private BoxShaderComponent() {
    }

    public void render(MatrixStack m, Box box) {
        int index = 4;
        int index2 = 0;
        int index3 = 6;
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        Color color = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor(0), 0.1F);
        Color color2 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor(180), 1.0F);
        if (!(TextShaderComponent2.INSTANCE.getMinecraftObject().method_23093(box))) {
            return;
        }
        Vec3d vec = SharedKt.getMc().method_1561().field_4686.method_71156();
        double offset = (box.field_1323 - vec.method_10216());
        double offset2 = (box.field_1322 - vec.method_10214());
        double offset3 = (box.field_1321 - vec.method_10215());
        double offset4 = (box.field_1320 - vec.method_10216());
        double offset5 = (box.field_1325 - vec.method_10214());
        double offset6 = (box.field_1324 - vec.method_10215());
        int index4 = (80 / 80.0F);
        formatRenderHelper.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper((0.0F + index4), 1.0F).resolveFormatRenderHelper(color);
        formatRenderHelper.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper((0.0F + index4), 0.0F).resolveFormatRenderHelper(color2);
        formatRenderHelper.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper((0.32F + index4), 0.0F).resolveFormatRenderHelper(color2);
        formatRenderHelper.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper((0.32F + index4), 1.0F).resolveFormatRenderHelper(color);
        formatRenderHelper.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper((0.32F + index4), 1.0F).resolveFormatRenderHelper(color);
        formatRenderHelper.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper((0.32F + index4), 0.0F).resolveFormatRenderHelper(color2);
        formatRenderHelper.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper((0.64F + index4), 0.0F).resolveFormatRenderHelper(color2);
        formatRenderHelper.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper((0.64F + index4), 1.0F).resolveFormatRenderHelper(color);
        formatRenderHelper.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper((0.64F + index4), 1.0F).resolveFormatRenderHelper(color);
        formatRenderHelper.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper((0.96F + index4), 1.0F).resolveFormatRenderHelper(color);
        formatRenderHelper.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper((0.96F + index4), 0.0F).resolveFormatRenderHelper(color2);
        formatRenderHelper.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper((0.64F + index4), 0.0F).resolveFormatRenderHelper(color2);
        formatRenderHelper.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper((0.96F + index4), 1.0F).resolveFormatRenderHelper(color);
        formatRenderHelper.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper((1.28F + index4), 1.0F).resolveFormatRenderHelper(color);
        formatRenderHelper.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper((1.28F + index4), 0.0F).resolveFormatRenderHelper(color2);
        formatRenderHelper.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper((0.96F + index4), 0.0F).resolveFormatRenderHelper(color2);
        TextShaderComponent2.INSTANCE.checkCondition(box, Direction.UP, PolygonShaderComponent.INSTANCE.resolveColor(color2, 0.4F));
        TextShaderComponent2.INSTANCE.checkCondition(box, Direction.UP, PolygonShaderComponent.INSTANCE.resolveColor(color2, 0.4F));
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline18(), null, null, m.method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0", SharedKt.getMc().method_1531().method_4619(minecraftRef).method_71659())));
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ServiceComponent12 serviceComponent12 = ((ServiceComponent12) element);
            double offset7 = (0.5D + RangesKt.coerceIn((PolygonShaderComponent.INSTANCE.computeValue((serviceComponent12.getNumericValue() + 1.0F), serviceComponent12.getNumericValue()) / 8.0F), 0.0F, 0.5F));
            Color color3 = PolygonShaderComponent.INSTANCE.resolveColor(color2, offset7);
            index = Direction.UP;
            index2 = box.method_35578((box.field_1325 - (1.0D - offset7))).method_1009(offset7, 0.0D, offset7);
            TextShaderComponent2.INSTANCE.checkCondition(index2, index, color3);
            if (__UNDEF_KEY__ <= 0) {
            }
        }
    }

    public void updateValue() {
        itemList.add(new ServiceComponent12());
    }

    public void executeAction() {
        itemList.removeIf(this::checkCondition);
    }

    private static boolean checkCondition(ServiceComponent12 arg0) {
        int index = arg0.getNumericValue();
        arg0.updateValue((index + -1));
        return index < 0;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        INSTANCE = new BoxShaderComponent();
        minecraftRef = StringServiceComponent2.resolveMinecraftObject("catlean", "textures/exclude/block.png");
        itemList = new ArrayList();
    }

}
