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
        int var35 = 4;
        int var36 = 0;
        int var37 = 6;
        VertexFormat var38 = class_290.field_1575;
        FormatRenderHelper var40 = new FormatRenderHelper();
        Color var41 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor(0), 0.1F);
        Color var42 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor(180), 1.0F);
        if (!(TextShaderComponent2.INSTANCE.getMinecraftObject().method_23093(box))) {
            return;
        }
        Vec3d vec = SharedKt.getMc().method_1561().field_4686.method_71156();
        double var44 = (box.field_1323 - vec.method_10216());
        double var45 = (box.field_1322 - vec.method_10214());
        double var46 = (box.field_1321 - vec.method_10215());
        double var47 = (box.field_1320 - vec.method_10216());
        double var48 = (box.field_1325 - vec.method_10214());
        double var49 = (box.field_1324 - vec.method_10215());
        int var50 = (80 / 80.0F);
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.0F + var50), 1.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.0F + var50), 0.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.32F + var50), 0.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.32F + var50), 1.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.32F + var50), 1.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.32F + var50), 0.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.64F + var50), 0.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.64F + var50), 1.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.64F + var50), 1.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.96F + var50), 1.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.96F + var50), 0.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.64F + var50), 0.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.96F + var50), 1.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((1.28F + var50), 1.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((1.28F + var50), 0.0F).resolveFormatRenderHelper();
        var40.resolveFormatRenderHelper().resolveFormatRenderHelper((0.96F + var50), 0.0F).resolveFormatRenderHelper();
        TextShaderComponent2.INSTANCE.checkCondition(box, Direction.UP, PolygonShaderComponent.INSTANCE.resolveColor(0.4F));
        TextShaderComponent2.INSTANCE.checkCondition(box, Direction.UP, PolygonShaderComponent.INSTANCE.resolveColor(0.4F));
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline18(), null, null, m.method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0", SharedKt.getMc().method_1531().method_4619(minecraftRef).method_71659())));
        Iterable var51 = (Iterable) itemList;
        int var52 = 0;
        Iterator iterator = var51.iterator();
        if (iterator.hasNext()) {
            Object var54 = iterator.next();
            ServiceComponent12 var55 = (ServiceComponent12) var54;
            int var56 = 0;
            double var57 = (0.5D + RangesKt.coerceIn((PolygonShaderComponent.INSTANCE.computeValue((var55.getNumericValue() + 1.0F), var55.getNumericValue()) / 8.0F), 0.0F, 0.5F));
            Color var34 = PolygonShaderComponent.INSTANCE.resolveColor();
            var35 = Direction.UP;
            var36 = box.method_35578((box.field_1325 - (1.0D - var57))).method_1009(0.0D);
            TextShaderComponent2.INSTANCE.checkCondition();
            if (0L <= 0) {
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
        int var4 = arg0.getNumericValue();
        arg0.updateValue((var4 + -1));
        return var4 < 0;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        INSTANCE = new BoxShaderComponent();
        minecraftRef = StringServiceComponent2.resolveMinecraftObject("catlean", "textures/exclude/block.png");
        itemList = new ArrayList();
    }

}
