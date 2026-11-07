package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import net.minecraft.class_11280;
import net.minecraft.class_11280.class_11281;
import net.minecraft.class_241;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_4604;
import net.minecraft.class_6364;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL32C;
import su.catlean.SharedKt;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.client.features.modules.utility.misc.UILinesMode;
import su.catlean.client.features.modules.utility.misc.UIModule;
import su.catlean.client.services.client.CtlEspMultiDefaultUboServiceComponent;
import su.catlean.client.services.client.HalfTexelSizeServiceComponent;
import su.catlean.client.services.render.BoxRenderHelper;
import su.catlean.client.services.render.BoxRenderHelper2;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.MatrixStackRenderHelper;
import su.catlean.client.services.render.StartRenderHelper;
import su.catlean.client.types.mappings.class_2350WhenMappings;

public class POSITIONCOLORShaderComponent {

    public static final POSITIONCOLORShaderComponent INSTANCE;
    private static List itemList;
    private static List itemList2;
    private static List itemList3;
    private static List itemList4;
    private static List itemList5;
    private static List itemList6;
    private static List itemList7;
    private static class_6364 minecraftRef;
    private static class_6364 minecraftRef2;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;

    private POSITIONCOLORShaderComponent() {
    }

    public List getList() {
        return itemList;
    }

    public void executeAction(List value) {
        itemList = value;
    }

    public List getList2() {
        return itemList2;
    }

    public void executeAction2(List value) {
        itemList2 = value;
    }

    public List getList3() {
        return itemList3;
    }

    public void executeAction(List value) {
        itemList3 = value;
    }

    public List getList4() {
        return itemList4;
    }

    public void executeAction(List value) {
        itemList4 = value;
    }

    public List getList5() {
        return itemList5;
    }

    public void executeAction2(List value) {
        itemList5 = value;
    }

    public List getList6() {
        return itemList6;
    }

    public void executeAction3(List value) {
        itemList6 = value;
    }

    public List getList7() {
        return itemList7;
    }

    public void executeAction3(List value) {
        itemList7 = value;
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        MatrixStackRenderHelper.INSTANCE.render(arg0.getStack());
        this.render2(arg0.getStack());
        this.render(arg0.getStack());
        this.render(arg0.getStack());
        this.render(arg0.getStack());
        itemList.clear();
        itemList2.clear();
        itemList3.clear();
        itemList4.clear();
        itemList5.clear();
        itemList6.clear();
        itemList7.clear();
    }

    private void render(MatrixStack arg0) {
        this.updateValue();
        int index = 4;
        int index2 = 0;
        int index3 = (itemList2.size() * 6);
        VertexFormat vertexFormat = class_290.field_1576;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        Iterable iterable = ((Iterable) itemList2);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            BoxRenderHelper2 boxRenderHelper2 = ((BoxRenderHelper2) element);
            INSTANCE.executeAction(formatRenderHelper, boxRenderHelper2.getMinecraftObject(), boxRenderHelper2.getColor(), boxRenderHelper2.getColor());
        }
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline24(), ((class_276) minecraftRef), null, arg0.method_23760().method_23761());
        enabledFlag = 1;
    }

    private void render2(MatrixStack arg0) {
        if (!(0)) {
            if (!(((Collection) itemList4).isEmpty())) {
            } else {
            }
        }
        int index = 4;
        int index2 = 0;
        int index3 = ((itemList.size() * 6) + itemList4.size());
        VertexFormat vertexFormat = class_290.field_1576;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            BoxRenderHelper2 boxRenderHelper2 = ((BoxRenderHelper2) element);
            INSTANCE.executeAction(formatRenderHelper, boxRenderHelper2.getMinecraftObject(), boxRenderHelper2.getColor(), boxRenderHelper2.getColor2());
        }
        iterable = ((Iterable) itemList4);
        iterator = iterable.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            boxRenderHelper2 = ((BoxRenderHelper) element);
            INSTANCE.executeAction(boxRenderHelper2.getMinecraftObject(), formatRenderHelper, boxRenderHelper2.getColor(), boxRenderHelper2.getMinecraftObject());
        }
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, arg0.method_23760().method_23761());
    }

    private void render(int arg0, MatrixStack arg1, short arg2) {
        if (!(((Collection) itemList7).isEmpty())) {
        } else {
        }
        GL32C.glEnable(2848);
        GL32C.glHint(3154, 4354);
        int index = 1;
        int index2 = itemList7.size();
        VertexFormat vertexFormat = class_290.field_1576;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index2, index);
        Iterable iterable = ((Iterable) itemList7);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            StartRenderHelper startRenderHelper = ((StartRenderHelper) element);
            executeAction(INSTANCE, formatRenderHelper, startRenderHelper.getMinecraftObject(), startRenderHelper.getMinecraftObject2(), startRenderHelper.getColor(), startRenderHelper.getColor2(), false);
            if (arg2 <= 0) {
                if (!(__UNDEF_KEY__)) {
                    FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline26(), SharedKt.getMc().method_1522(), null, arg1.method_23760().method_23761());
                }
            }
        }
        GL32C.glDisable(2848);
    }

    private void render(MatrixStack arg0) {
        if (!(((Collection) itemList3).isEmpty())) {
        } else {
        }
        if (!(((Collection) itemList5).isEmpty())) {
        } else {
        }
        if (!(0) && !(0)) {
            if (!(((Collection) itemList6).isEmpty())) {
            } else {
            }
        }
        if (UIModule.INSTANCE.getLinesMode() == UILinesMode.NEW) {
            this.updateValue2();
        }
        GL32C.glEnable(2848);
        GL32C.glHint(3154, 4354);
        int index = 1;
        int index2 = ((itemList6.size() + (itemList5.size() * 4)) + (itemList3.size() * 12));
        VertexFormat vertexFormat = class_290.field_1576;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index2, index);
        Iterable iterable = ((Iterable) itemList3);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            BoxRenderHelper2 boxRenderHelper2 = ((BoxRenderHelper2) element);
            INSTANCE.executeAction(boxRenderHelper2.getMinecraftObject(), formatRenderHelper, boxRenderHelper2.getColor(), boxRenderHelper2.getColor2());
        }
        iterable = ((Iterable) itemList5);
        iterator = iterable.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            boxRenderHelper2 = ((BoxRenderHelper) element);
            INSTANCE.executeAction(boxRenderHelper2.getMinecraftObject(), formatRenderHelper, boxRenderHelper2.getColor(), boxRenderHelper2.getMinecraftObject());
        }
        iterable = ((Iterable) itemList6);
        iterator = iterable.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            boxRenderHelper2 = ((StartRenderHelper) element);
            INSTANCE.executeAction(formatRenderHelper, boxRenderHelper2.getMinecraftObject(), boxRenderHelper2.getMinecraftObject2(), boxRenderHelper2.getColor(), boxRenderHelper2.getColor2(), boxRenderHelper2.isActive());
        }
        if (UIModule.INSTANCE.getLinesMode() == UILinesMode.OLD) {
        }
        iterable = ((class_276) minecraftRef2);
        index2 = 52;
        Matrix4f matrix4f = arg0.method_23760().method_23761();
        class_276 class276 = SharedKt.getMc().method_1522();
        RenderPipeline renderPipeline = VertexUBOShaderComponent.INSTANCE.getRenderPipeline25();
        FormatRenderHelper.executeAction(renderPipeline, class276, iterable, matrix4f, vertexFormat, index2, index);
        GL32C.glDisable(2848);
        if (UIModule.INSTANCE.getLinesMode() == UILinesMode.NEW) {
        } else {
        }
        enabledFlag2 = 0;
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        if (minecraftRef != null && enabledFlag) {
            FormatRenderHelper.executeAction(new FormatRenderHelper(null, 0, false).resolveFormatRenderHelper(), VertexUBOShaderComponent.INSTANCE.getRenderPipeline6(), SharedKt.getMc().method_1522(), CtlEspMultiDefaultUboServiceComponent.INSTANCE.getMinecraftObject().method_71102(((class_11281) new HalfTexelSizeServiceComponent())), null, null, MapsKt.mapOf(TuplesKt.to("Sampler0", minecraftRef.method_71639())));
            enabledFlag = 0;
        }
        FormatRenderHelper.executeAction(new FormatRenderHelper(null, 0, false).resolveFormatRenderHelper(), VertexUBOShaderComponent.INSTANCE.getRenderPipeline7(), SharedKt.getMc().method_1522(), CtlEspMultiDefaultUboServiceComponent.INSTANCE.getMinecraftObject().method_71102(((class_11281) new HalfTexelSizeServiceComponent())), null, null, MapsKt.mapOf(TuplesKt.to("Sampler0", minecraftRef2.method_71639())));
        enabledFlag2 = 0;
    }

    private void executeAction(FormatRenderHelper arg0, Vec3d arg1, Vec3d arg2, Color arg3, Color arg4, boolean arg5) {
        if (!(arg5) && !(TextShaderComponent2.INSTANCE.getMinecraftObject().method_74404(arg2.field_1352, arg2.field_1351, arg2.field_1350))) {
            return;
        }
        Vec3d vec = SharedKt.getMc().method_1561().field_4686.method_71156();
        double offset = (arg1.field_1352 - vec.method_10216());
        double offset2 = (arg1.field_1351 - vec.method_10214());
        double offset3 = (arg1.field_1350 - vec.method_10215());
        double offset4 = (arg2.field_1352 - vec.method_10216());
        double offset5 = (arg2.field_1351 - vec.method_10214());
        double offset6 = (arg2.field_1350 - vec.method_10215());
        arg0.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper(arg3);
        arg0.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(arg4);
    }

    private static void executeAction(POSITIONCOLORShaderComponent arg0, FormatRenderHelper arg1, Vec3d arg2, Vec3d arg3, Color arg4, Color arg5, boolean arg6, int arg7, Object arg8) {
        if ((arg7 & 16) != 0) {
        }
        if ((arg7 & 32) != 0) {
            arg6 = 0;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg4, arg6);
    }

    private void executeAction(Box arg0, FormatRenderHelper arg1, Color arg2, Color arg3) {
        Vec3d vec = SharedKt.getMc().method_1561().field_4686.method_71156();
        double offset = (arg0.field_1323 - vec.method_10216());
        double offset2 = (arg0.field_1322 - vec.method_10214());
        double offset3 = (arg0.field_1321 - vec.method_10215());
        double offset4 = (arg0.field_1320 - vec.method_10216());
        double offset5 = (arg0.field_1325 - vec.method_10214());
        double offset6 = (arg0.field_1324 - vec.method_10215());
        arg1.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper(arg3);
        arg1.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper(arg3);
        arg1.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper(arg3);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(arg3);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(arg3);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(arg3);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(arg3);
        arg1.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper(arg3);
        arg1.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper(arg3);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(arg3);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(arg3);
        arg1.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper(arg3);
    }

    private void executeAction(Box arg0, FormatRenderHelper arg1, Color arg2, Direction arg3) {
        Vec3d vec = SharedKt.getMc().method_1561().field_4686.method_71156();
        double offset = (arg0.field_1323 - vec.method_10216());
        double offset2 = (arg0.field_1322 - vec.method_10214());
        double offset3 = (arg0.field_1321 - vec.method_10215());
        double offset4 = (arg0.field_1320 - vec.method_10216());
        double offset5 = (arg0.field_1325 - vec.method_10214());
        double offset6 = (arg0.field_1324 - vec.method_10215());
        if (!(__UNDEF_KEY__)) {
            arg1.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper(arg2);
            arg1.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(arg2);
            arg1.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(arg2);
            arg1.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(arg2);
            arg1.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(arg2);
            arg1.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper(arg2);
            arg1.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper(arg2);
        }
        arg1.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(arg2);
    }

    private void executeAction(Box arg0, FormatRenderHelper arg1, Color arg2, Direction arg3) {
        Vec3d vec = SharedKt.getMc().method_1561().field_4686.method_71156();
        double offset = (arg0.field_1323 - vec.method_10216());
        double offset2 = (arg0.field_1322 - vec.method_10214());
        double offset3 = (arg0.field_1321 - vec.method_10215());
        double offset4 = (arg0.field_1320 - vec.method_10216());
        double offset5 = (arg0.field_1325 - vec.method_10214());
        double offset6 = (arg0.field_1324 - vec.method_10215());
        if (__UNDEF_KEY__) {
            arg1.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper(arg2);
            arg1.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(arg2);
            arg1.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(arg2);
        }
        arg1.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(arg2);
        arg1.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(arg2);
    }

    public void executeAction(FormatRenderHelper polygon, Box box, Color c, Color c1) {
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
        polygon.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper(c);
        polygon.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper(c1);
        polygon.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(c1);
        polygon.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(c);
        polygon.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(c);
        polygon.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(c1);
        polygon.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(c1);
        polygon.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(c);
        polygon.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper(c);
        polygon.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(c);
        polygon.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(c1);
        polygon.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper(c1);
        polygon.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper(c);
        polygon.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper(c);
        polygon.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper(c1);
        polygon.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper(c1);
        polygon.resolveFormatRenderHelper(offset, offset5, offset3).resolveFormatRenderHelper(c1);
        polygon.resolveFormatRenderHelper(offset, offset5, offset6).resolveFormatRenderHelper(c1);
        polygon.resolveFormatRenderHelper(offset4, offset5, offset6).resolveFormatRenderHelper(c1);
        polygon.resolveFormatRenderHelper(offset4, offset5, offset3).resolveFormatRenderHelper(c1);
        polygon.resolveFormatRenderHelper(offset, offset2, offset3).resolveFormatRenderHelper(c);
        polygon.resolveFormatRenderHelper(offset, offset2, offset6).resolveFormatRenderHelper(c);
        polygon.resolveFormatRenderHelper(offset4, offset2, offset6).resolveFormatRenderHelper(c);
        polygon.resolveFormatRenderHelper(offset4, offset2, offset3).resolveFormatRenderHelper(c);
    }

    private void updateValue() {
        if (minecraftRef == null) {
            minecraftRef = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        if (SharedKt.getMc().method_1522().field_1482 == minecraftRef.field_1482) {
            if (SharedKt.getMc().method_1522().field_1481 != minecraftRef.field_1481) {
                minecraftRef.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
            }
        }
        RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(minecraftRef.method_30277(), 0, minecraftRef.method_30278(), 1.0D);
    }

    private void updateValue2() {
        if (minecraftRef2 == null) {
            minecraftRef2 = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        if (SharedKt.getMc().method_1522().field_1482 == minecraftRef2.field_1482) {
            if (SharedKt.getMc().method_1522().field_1481 != minecraftRef2.field_1481) {
                minecraftRef2.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
            }
        }
        RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(minecraftRef2.method_30277(), 0, minecraftRef2.method_30278(), 1.0D);
    }

    static {
        INSTANCE = new POSITIONCOLORShaderComponent();
        itemList = new ArrayList();
        itemList2 = new ArrayList();
        itemList3 = new ArrayList();
        itemList4 = new ArrayList();
        itemList5 = new ArrayList();
        itemList6 = new ArrayList();
        itemList7 = new ArrayList();
    }

}
