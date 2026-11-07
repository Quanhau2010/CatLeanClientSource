package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_290;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_4604;
import net.minecraft.class_7833;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.AtlasTextureServiceComponent;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.RenderHelper4;
import su.catlean.client.services.render.TexRenderHelper;

public class POSITIONTEXCOLORShaderComponent {

    public static final POSITIONTEXCOLORShaderComponent INSTANCE;
    private static final ArrayList arrayList;
    private static Module[] moduleArray;

    private POSITIONTEXCOLORShaderComponent() {
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (arrayList.isEmpty()) {
            return;
        }
        arg0.getStack().method_22903();
        RenderHelper4.render(arg0.getStack(), ((Quaternionfc) class_7833.field_40716.rotation(TextShaderComponent2.INSTANCE.getNumericValue2())));
        RenderHelper4.render(arg0.getStack(), ((Quaternionfc) class_7833.field_40714.rotation(TextShaderComponent2.INSTANCE.getNumericValue3())));
        GpuTextureView gpuTextureView = SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659();
        int index = 4;
        int index2 = 0;
        int index3 = arrayList.size();
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        MatrixStack matrices = new MatrixStack();
        RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40714.rotation(TextShaderComponent2.INSTANCE.getNumericValue3())));
        RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40716.rotation(TextShaderComponent2.INSTANCE.getNumericValue2())));
        Quaternionf quaternionf = new Quaternionf().rotateYXZ(TextShaderComponent2.INSTANCE.getNumericValue(), TextShaderComponent2.INSTANCE.getNumericValue3(), 0.0F);
        Iterable iterable = ((Iterable) arrayList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            TexRenderHelper texRenderHelper = ((TexRenderHelper) element);
            if (TextShaderComponent2.INSTANCE.getMinecraftObject().method_74404(texRenderHelper.getMinecraftObject().field_1352, texRenderHelper.getMinecraftObject().field_1351, texRenderHelper.getMinecraftObject().field_1350)) {
                texRenderHelper.render(matrices, ((Quaternionfc) quaternionf), formatRenderHelper);
            }
        }
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline19(), null, null, arg0.getStack().method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0", gpuTextureView)));
        arg0.getStack().method_22909();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        arrayList.removeIf(this::checkCondition);
    }

    public boolean checkCondition(TexRenderHelper p) {
        return arrayList.add(p);
    }

    private static boolean checkCondition2(TexRenderHelper arg0) {
        return arg0.checkCondition();
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        INSTANCE = new POSITIONTEXCOLORShaderComponent();
        arrayList = new ArrayList();
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
