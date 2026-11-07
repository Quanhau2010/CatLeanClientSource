package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import net.minecraft.class_1041;
import net.minecraft.class_11280;
import net.minecraft.class_11280.class_11281;
import net.minecraft.class_241;
import net.minecraft.class_276;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import su.catlean.SharedKt;
import su.catlean.client.services.client.BufferServiceComponent3;
import su.catlean.client.services.client.CtlBlurserviceUboServiceComponent;
import su.catlean.client.services.render.FormatRenderHelper;

public class CtlBlurserviceFbShaderComponent {

    public static final CtlBlurserviceFbShaderComponent INSTANCE;
    private static final GpuTextureView[] gpuTextureViewArray;
    private static class_241 minecraftRef;

    private CtlBlurserviceFbShaderComponent() {
    }

    public GpuTextureView getGpuTextureView() {
        return gpuTextureViewArray[0];
    }

    private GpuTextureView resolveGpuTextureView(int arg0) {
        int index = (1 / Math.pow(2.0D, arg0));
        int index2 = (SharedKt.getMc().method_22683().method_4489() * index);
        int index3 = (SharedKt.getMc().method_22683().method_4506() * index);
        return RenderSystem.getDevice().createTextureView(RenderSystem.getDevice().createTexture(("ctl-blurservice-fb-" + arg0), 15, TextureFormat.RGBA8, index2, index3, 1, 1));
    }

    public void updateValue() {
        this.executeAction(gpuTextureViewArray[1], SharedKt.getMc().method_1522().method_71639(), VertexUBOShaderComponent.INSTANCE.getRenderPipeline8());
        int index = 1;
        if (index < 3) {
            this.executeAction(gpuTextureViewArray[(index + 1)], gpuTextureViewArray[index], VertexUBOShaderComponent.INSTANCE.getRenderPipeline8());
        }
        index = 3;
        if (0 < index) {
            this.executeAction(gpuTextureViewArray[(index - 1)], gpuTextureViewArray[index], VertexUBOShaderComponent.INSTANCE.getRenderPipeline9());
        }
        if (SharedKt.getMc().method_1522().field_1482 == minecraftRef.field_1343) {
            if (SharedKt.getMc().method_1522().field_1481 != minecraftRef.field_1342) {
                minecraftRef = new class_241(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
                index = 0;
                if (index < gpuTextureViewArray) {
                    gpuTextureViewArray[index].close();
                    gpuTextureViewArray[index] = this.resolveGpuTextureView(index);
                }
            }
        }
        timestampValue = SharedKt.getNumericValue();
    }

    private void executeAction(GpuTextureView arg0, GpuTextureView arg1, RenderPipeline arg2) {
        FormatRenderHelper.executeAction(new FormatRenderHelper(null, 0, false).resolveFormatRenderHelper(), arg2, arg0, null, CtlBlurserviceUboServiceComponent.INSTANCE.getMinecraftObject().method_71102(((class_11281) new BufferServiceComponent3((0.5F / arg0.getWidth(0)), (0.5F / arg0.getHeight(0)), 5.0F))), null, null, MapsKt.mapOf(TuplesKt.to("Sampler0", arg1)));
    }

    private int computeValue() {
        if (GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor()) != null) {
        } else {
            GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor()).refreshRate();
        }
        return 60;
    }

    static {
        INSTANCE = new CtlBlurserviceFbShaderComponent();
        int index = 0;
        GpuTextureView[] items = new GpuTextureView[6];
        if (index < 6) {
            items[index] = INSTANCE.resolveGpuTextureView(index);
        }
        gpuTextureViewArray = items;
        minecraftRef = new class_241(0.0F, 0.0F);
    }

}
