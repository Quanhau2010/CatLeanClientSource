package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;
import java.nio.IntBuffer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import net.minecraft.class_1011;
import net.minecraft.class_1011.class_1012;
import net.minecraft.class_1041;
import net.minecraft.class_1043;
import net.minecraft.class_1044;
import net.minecraft.class_10442;
import net.minecraft.class_10444;
import net.minecraft.class_1060;
import net.minecraft.class_11280;
import net.minecraft.class_11659;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_4184;
import net.minecraft.class_4608;
import net.minecraft.class_757;
import net.minecraft.class_811;
import net.minecraft.class_9779;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4d;
import org.joml.Vector4f;
import org.lwjgl.system.MemoryUtil;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.TickEvent;
import su.catlean.api.event.events.render.FlipFrameEvent;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.RenderScreenEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.CtlBlurserviceUboServiceComponent;
import su.catlean.client.services.client.CtlEspBloomUboServiceComponent;
import su.catlean.client.services.client.CtlEspDefaultUboServiceComponent;
import su.catlean.client.services.client.CtlEspDoubleGlowUboServiceComponent;
import su.catlean.client.services.client.CtlEspMirrorUboServiceComponent;
import su.catlean.client.services.client.CtlEspMultiDefaultUboServiceComponent;
import su.catlean.client.services.client.CtlRectBlurredUboServiceComponent;
import su.catlean.client.services.client.CtlRectBlurredUboServiceComponent2;
import su.catlean.client.services.client.CtlVUboServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ScissorServiceComponent;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.render.CatleanInterfaceRenderHelper;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.mixins.accessors.NativeImageAccessor;

public class PolygonShaderComponent {

    public static final PolygonShaderComponent INSTANCE;
    private static final CopyOnWriteArrayList copyOnWriteArrayList;
    private static boolean enabledFlag;
    private static final Matrix4f matrix4f;
    private static final Matrix4f matrix4f2;
    private static int[] countValueArray;
    private static int countValue;
    private static float factorValue;
    private static Module[] moduleArray;

    private PolygonShaderComponent() {
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public Matrix4f getMatrix4f() {
        return matrix4f;
    }

    public Matrix4f getMatrix4f2() {
        return matrix4f2;
    }

    public int[] process() {
        return countValueArray;
    }

    public void executeAction(int[] value) {
        countValueArray = value;
    }

    public float getNumericValue() {
        return factorValue;
    }

    public void updateValue(float value) {
        factorValue = value;
    }

    private void onTickEvent(TickEvent arg0) {
        int index = SharedKt.getMc().method_22683().method_4495();
        Iterable iterable = ((Iterable) SFMServiceComponent.getList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            FontRenderHelper fontRenderHelper = ((FontRenderHelper) element);
            fontRenderHelper.close();
            fontRenderHelper.updateValue();
            if (__UNDEF_KEY__ == null) {
            }
        }
        countValue = index;
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        CtlBlurserviceFbShaderComponent.INSTANCE.updateValue();
        Iterable iterable = ((Iterable) copyOnWriteArrayList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Function0 function0 = ((Function0) element);
            function0.invoke();
        }
        copyOnWriteArrayList.clear();
    }

    private void onRenderScreenEvent(RenderScreenEvent arg0) {
        GlStateManager._glBindFramebuffer(36160, 0);
        enabledFlag = 0;
    }

    private void onRenderScreenEvent2(RenderScreenEvent arg0) {
        CatleanInterfaceRenderHelper.INSTANCE.render(arg0.getContext());
    }

    private void onFlipFrameEvent(FlipFrameEvent arg0) {
        CtlRectBlurredUboServiceComponent2.INSTANCE.getMinecraftObject().method_71100();
        CtlBlurserviceUboServiceComponent.INSTANCE.getMinecraftObject().method_71100();
        CtlRectBlurredUboServiceComponent.INSTANCE.getMinecraftObject().method_71100();
        CtlVUboServiceComponent.INSTANCE.getMinecraftObject().method_71100();
        CtlEspDefaultUboServiceComponent.INSTANCE.getMinecraftObject().method_71100();
        CtlEspDoubleGlowUboServiceComponent.INSTANCE.getMinecraftObject().method_71100();
        CtlEspMirrorUboServiceComponent.INSTANCE.getMinecraftObject().method_71100();
        CtlEspBloomUboServiceComponent.INSTANCE.getMinecraftObject().method_71100();
        CtlEspMultiDefaultUboServiceComponent.INSTANCE.getMinecraftObject().method_71100();
    }

    public void executeAction(FormatRenderHelper polygon, float x, float y, float w, float h, Color[] colors) {
        if (__UNDEF_KEY__ == null) {
            if (colors > 1) {
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (colors > 1) {
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (colors > 1) {
            }
        }
        colors[3].resolveFormatRenderHelper(colors[0]);
    }

    public void executeAction(Matrix3x2fStack matrices, float x, float y, float w, float h, Color[] colors) {
        int index = 6;
        int index2 = 0;
        int index3 = 0;
        VertexFormat vertexFormat = class_290.field_1576;
        if (__UNDEF_KEY__ == null) {
            if (colors > 1) {
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (colors > 1) {
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (colors > 1) {
            }
        }
        FormatRenderHelper.executeAction(colors[3].resolveFormatRenderHelper(colors[0]), VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, null, new Matrix3x2f(((Matrix3x2fc) matrices)));
    }

    public void executeAction(Matrix3x2fStack matrices, float x, float y, float width, float height, Color c) {
        VertexFormat vertexFormat = class_290.field_1576;
        FormatRenderHelper.executeAction(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(new FormatRenderHelper(vertexFormat, 4, true), x, y, 0.0F).resolveFormatRenderHelper(c), x, (y + height), 0.0F).resolveFormatRenderHelper(c), x, (y + height), 0.0F).resolveFormatRenderHelper(c), (x + width), (y + height), 0.0F).resolveFormatRenderHelper(c), (x + width), (y + height), 0.0F).resolveFormatRenderHelper(c), (x + width), y, 0.0F).resolveFormatRenderHelper(c), (x + width), y, 0.0F).resolveFormatRenderHelper(c), x, y, 0.0F).resolveFormatRenderHelper(c), VertexUBOShaderComponent.INSTANCE.getRenderPipeline25(), null, null, null, new Matrix3x2f(((Matrix3x2fc) matrices)));
    }

    public void render(DrawContext context, ServiceComponent78 r1) {
        Vector2f vector2f = new Vector2f();
        Vector2f vector2f2 = new Vector2f();
        context.method_51448().transformPosition(r1.getNumericValue(), r1.getNumericValue2(), vector2f);
        context.method_51448().transformPosition(r1.getNumericValue3(), r1.getNumericValue4(), vector2f2);
        context.method_44379(vector2f.x, vector2f.y, vector2f2.x, vector2f2.y);
        ScissorServiceComponent.INSTANCE.executeAction(new ServiceComponent78(vector2f.x, vector2f.y, vector2f2.x, vector2f2.y));
    }

    public void render(DrawContext context) {
        context.method_44380();
        ScissorServiceComponent.INSTANCE.resolveServiceComponent78();
    }

    private void executeAction(FormatRenderHelper arg0, float arg1, float arg2, float arg3, float arg4, Color arg5) {
        arg0.resolveFormatRenderHelper(arg1, arg2, 0.0F).resolveFormatRenderHelper(arg5);
        arg0.resolveFormatRenderHelper(arg1, arg4, 0.0F).resolveFormatRenderHelper(arg5);
        arg0.resolveFormatRenderHelper(arg3, arg4, 0.0F).resolveFormatRenderHelper(arg5);
        arg0.resolveFormatRenderHelper(arg3, arg2, 0.0F).resolveFormatRenderHelper(arg5);
    }

    public void executeAction(Matrix3x2f matrices, class_2960 id, float x, float y, float width, float height, Color color1, Color color2, Color color3, Color color4, float uStart, float vStart, float uEnd, float vEnd, boolean altBlend) {
        GpuTextureView gpuTextureView = SharedKt.getMc().method_1531().method_4619(id).method_71659();
        int index = 6;
        int index2 = 0;
        int index3 = 0;
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, (x + 0), (y + height), 0.0F).resolveFormatRenderHelper(uStart, vEnd).resolveFormatRenderHelper(color1);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, (x + width), (y + height), 0.0F).resolveFormatRenderHelper(uEnd, vEnd).resolveFormatRenderHelper(color2);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, (x + width), (y + 0), 0.0F).resolveFormatRenderHelper(uEnd, vStart).resolveFormatRenderHelper(color3);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, (x + 0), (y + 0), 0.0F).resolveFormatRenderHelper(uStart, vStart).resolveFormatRenderHelper(color4);
        if (altBlend) {
        }
        index = 12;
        index2 = MapsKt.mapOf(TuplesKt.to("Sampler0", gpuTextureView));
        index3 = matrices;
        class_276 class276 = SharedKt.getMc().method_1522();
        RenderPipeline renderPipeline = VertexUBOShaderComponent.INSTANCE.getRenderPipeline14();
        RenderPipeline renderPipeline2 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline18();
        FormatRenderHelper.executeAction(renderPipeline2, renderPipeline, class276, vertexFormat, index3, index2, index);
    }

    public static void executeAction(PolygonShaderComponent arg0, Matrix3x2f arg1, class_2960 arg2, float arg3, float arg4, float arg5, float arg6, Color arg7, Color arg8, int arg9, Color arg10, Color arg11, float arg12, char arg13, float arg14, float arg15, short arg16, float arg17, boolean arg18, int arg19, Object arg20) {
        if ((arg19 & 64) != 0) {
            arg7 = Color.WHITE;
        }
        if (arg13 >= 0) {
            if (__UNDEF_KEY__ == null) {
                if ((arg19 & 128) != 0) {
                }
            }
        }
        if (arg9 >= 0) {
            if (__UNDEF_KEY__ == null) {
                if ((arg19 & 256) != 0) {
                }
            }
        }
        if (arg13 >= 0) {
            if (__UNDEF_KEY__ == null) {
                if ((arg19 & 512) != 0) {
                }
            }
        }
        if (arg13 > 0) {
            if (__UNDEF_KEY__ == null) {
                if ((arg19 & 1024) != 0) {
                    arg12 = 0.0F;
                }
            }
        }
        if (arg16 > 0) {
            if (__UNDEF_KEY__ == null) {
                if ((arg19 & 2048) != 0) {
                    arg14 = 0.0F;
                }
            }
        }
        if (arg13 >= 0) {
            if (__UNDEF_KEY__ == null) {
                if ((arg19 & 4096) != 0) {
                    arg15 = 1.0F;
                }
            }
        }
        if (arg9 > 0 && __UNDEF_KEY__ == null) {
            if ((arg19 & 8192) != 0) {
                arg17 = 1.0F;
            }
        }
        if ((arg19 & 16384) != 0) {
            arg18 = 0;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg7, arg7, arg7, arg12, arg14, arg15, arg17, arg18);
    }

    public void executeAction(FormatRenderHelper polygon, float x, float y, float width, float height, Color color1, Color color2, Color color3, Color color4, float uStart, float vStart, float uEnd, float vEnd) {
        FormatRenderHelper.resolveFormatRenderHelper(polygon, (x + 0), (y + height), 0.0F).resolveFormatRenderHelper(uStart, vEnd).resolveFormatRenderHelper(color1);
        FormatRenderHelper.resolveFormatRenderHelper(polygon, (x + width), (y + height), 0.0F).resolveFormatRenderHelper(uEnd, vEnd).resolveFormatRenderHelper(color2);
        FormatRenderHelper.resolveFormatRenderHelper(polygon, (x + width), (y + 0), 0.0F).resolveFormatRenderHelper(uEnd, vStart).resolveFormatRenderHelper(color3);
        FormatRenderHelper.resolveFormatRenderHelper(polygon, (x + 0), (y + 0), 0.0F).resolveFormatRenderHelper(uStart, vStart).resolveFormatRenderHelper(color4);
    }

    public static void executeAction(PolygonShaderComponent arg0, FormatRenderHelper arg1, float arg2, float arg3, float arg4, float arg5, Color arg6, Color arg7, Color arg8, Color arg9, float arg10, float arg11, float arg12, float arg13, int arg14, Object arg15) {
        if ((arg14 & 32) != 0) {
            arg6 = Color.WHITE;
        }
        if ((arg14 & 64) != 0) {
        }
        if ((arg14 & 128) != 0) {
        }
        if ((arg14 & 256) != 0) {
        }
        if ((arg14 & 512) != 0) {
            arg10 = 0.0F;
        }
        if ((arg14 & 1024) != 0) {
            arg11 = 0.0F;
        }
        if ((arg14 & 2048) != 0) {
            arg12 = 1.0F;
        }
        if ((arg14 & 4096) != 0) {
            arg13 = 1.0F;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg6, arg6, arg6, arg10, arg11, arg12, arg13);
    }

    public void executeAction(Matrix4f matrices, class_2960 id, float x, float y, float width, float height, Color color1, Color color2, Color color3, Color color4, boolean altBlend, float uStart, float vStart, float uEnd, float vEnd) {
        float factor = (height / 2.0F);
        float factor2 = (width / 2.0F);
        GpuTextureView gpuTextureView = SharedKt.getMc().method_1531().method_4619(id).method_71659();
        int index = 6;
        int index2 = 0;
        int index3 = 0;
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, (x - factor), (y + factor), 0.0F).resolveFormatRenderHelper(uStart, vEnd).resolveFormatRenderHelper(color1);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, (x + factor2), (y + factor), 0.0F).resolveFormatRenderHelper(uEnd, vEnd).resolveFormatRenderHelper(color2);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, (x + factor2), (y - factor), 0.0F).resolveFormatRenderHelper(uEnd, vStart).resolveFormatRenderHelper(color3);
        FormatRenderHelper.resolveFormatRenderHelper(formatRenderHelper, (x - factor2), (y - factor), 0.0F).resolveFormatRenderHelper(uStart, vStart).resolveFormatRenderHelper(color4);
        if (altBlend) {
        }
        index = 4;
        index2 = MapsKt.mapOf(TuplesKt.to("Sampler0", gpuTextureView));
        index3 = ((Matrix3x2f) new Matrix3x2fStack());
        vertexFormat = matrices;
        class_276 class276 = SharedKt.getMc().method_1522();
        RenderPipeline renderPipeline = VertexUBOShaderComponent.INSTANCE.getRenderPipeline14();
        RenderPipeline renderPipeline2 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline18();
        FormatRenderHelper.executeAction(renderPipeline2, renderPipeline, class276, vertexFormat, index3, index2, index);
    }

    public static void executeAction(PolygonShaderComponent arg0, Matrix4f arg1, class_2960 arg2, float arg3, float arg4, float arg5, float arg6, Color arg7, Color arg8, Color arg9, Color arg10, boolean arg11, float arg12, float arg13, float arg14, float arg15, int arg16, Object arg17) {
        if ((arg16 & 64) != 0) {
            arg7 = Color.WHITE;
        }
        if ((arg16 & 128) != 0) {
        }
        if ((arg16 & 256) != 0) {
        }
        if ((arg16 & 512) != 0) {
        }
        if ((arg16 & 1024) != 0) {
            arg11 = 0;
        }
        if ((arg16 & 2048) != 0) {
            arg12 = 0.0F;
        }
        if ((arg16 & 4096) != 0) {
            arg13 = 0.0F;
        }
        if ((arg16 & 8192) != 0) {
            arg14 = 1.0F;
        }
        if ((arg16 & 16384) != 0) {
            arg15 = 1.0F;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg7, arg7, arg7, arg11, arg12, arg13, arg14, arg15);
    }

    public void executeAction(Matrix3x2fStack matrices, float x, float y, float x1, float y1, Color color, Color color2) {
        int index = 2;
        int index2 = 1;
        int index3 = 0;
        VertexFormat vertexFormat = class_290.field_1576;
        FormatRenderHelper.executeAction(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(new FormatRenderHelper(vertexFormat, index3, index2, index), x, y, 0.0F).resolveFormatRenderHelper(color), x1, y1, 0.0F).resolveFormatRenderHelper(color2), VertexUBOShaderComponent.INSTANCE.getRenderPipeline25(), null, null, null, new Matrix3x2f(((Matrix3x2fc) matrices)));
    }

    public static void executeAction(PolygonShaderComponent arg0, Matrix3x2fStack arg1, float arg2, float arg3, float arg4, float arg5, Color arg6, Color arg7, int arg8, Object arg9) {
        if ((arg8 & 64) != 0) {
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg6);
    }

    private int computeValue(int arg0, int arg1, float arg2) {
        return MathKt.roundToInt((arg0 + ((arg1 - arg0) * arg2)));
    }

    public double computeValue(double oldValue, double newValue, float interpolationValue) {
        return (oldValue + ((newValue - oldValue) * interpolationValue));
    }

    public double computeValue(double oldValue, double newValue, double interpolationValue) {
        return (oldValue + ((newValue - oldValue) * interpolationValue));
    }

    public float computeValue(float oldValue, float newValue, float interpolationValue) {
        return (oldValue + ((newValue - oldValue) * interpolationValue));
    }

    public Vec3d resolveMinecraftObject(Vec3d pos) {
        if (__UNDEF_KEY__ == null) {
            if (SharedKt.getMc().method_1561().field_4686 != null) {
                if (__UNDEF_KEY__ == null) {
                    if (SharedKt.getMc().method_1561().field_4686.method_71156() == null) {
                        SharedKt.getMc().method_1561().field_4686.method_71156();
                    }
                }
            }
        }
        Vec3d vec = Vec3d.ZERO;
        if (__UNDEF_KEY__ == null) {
            if (this.checkCondition()) {
            } else {
            }
        }
        int index = (2 * 1);
        Vector3f vector3f = new Vector3f();
        double offset = (pos.field_1352 - vec.field_1352);
        double offset2 = (pos.field_1351 - vec.field_1351);
        double offset3 = (pos.field_1350 - vec.field_1350);
        Vector4f vector4f = new Vector4f(offset, offset2, offset3, 1.0F).mul(((Matrix4fc) matrix4f2));
        Matrix4f matrix4f = new Matrix4f(((Matrix4fc) TextShaderComponent2.INSTANCE.getMatrix4f()));
        Matrix4f matrix4f2 = new Matrix4f(((Matrix4fc) matrix4f));
        matrix4f.mul(((Matrix4fc) matrix4f2)).project(vector4f.x(), vector4f.y(), vector4f.z(), countValueArray, vector3f);
        return new Vec3d((vector3f.x / SharedKt.getMc().method_22683().method_4495()), ((index - vector3f.y) / SharedKt.getMc().method_22683().method_4495()), vector3f.z);
    }

    public void render(MatrixStack matrices, ItemStack stack) {
        if (__UNDEF_KEY__ == null) {
            matrices.method_22903();
            matrices.method_46416(8.0F, 8.0F, 150.0F);
            matrices.method_22905(16.0F, -16.0F, 16.0F);
        }
        class_10444 class10444 = new class_10444();
        SharedKt.getMc().method_65386().method_65598(class10444, stack, class_811.field_4317, ((World) SharedKt.getWorld()), null, 0);
        class10444.method_65604(matrices, ((class_11659) SharedKt.getMc().field_1773.method_72910()), 15728880, class_4608.field_21444, 0);
        matrices.method_22909();
    }

    public void executeAction(class_2960 i, BufferedImage bi) {
        if (RenderSystem.isOnRenderThread()) {
            SharedKt.getMc().method_1531().method_4616(i, ((class_1044) this.resolveMinecraftObject(bi)));
        }
        this.checkCondition(this::resolveUnit);
    }

    public boolean checkCondition(Function0 function) {
        return copyOnWriteArrayList.add(function);
    }

    public class_1043 resolveMinecraftObject(BufferedImage bi) {
        int index = bi.getWidth();
        int index2 = bi.getHeight();
        class_1011 class1011 = new class_1011(class_1012.field_4997, index, index2, false);
        long time = ((NativeImageAccessor) class1011).getPixels();
        IntBuffer intBuffer = MemoryUtil.memIntBuffer(time, (class1011.method_4307() * class1011.method_4323()));
        WritableRaster writableRaster = bi.getRaster();
        ColorModel colorModel = bi.getColorModel();
        int index3 = writableRaster.getNumBands();
        int index4 = writableRaster.getDataBuffer().getDataType();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("Unknown data buffer type: " + index4));
        int index5 = 0;
        if (index5 < index2) {
            int index6 = 0;
            if (index6 < index) {
                writableRaster.getDataElements(index6, index5, illegalArgumentException);
                int index7 = colorModel.getAlpha(illegalArgumentException);
                int index8 = colorModel.getRed(illegalArgumentException);
                int index9 = colorModel.getGreen(illegalArgumentException);
                int index10 = colorModel.getBlue(illegalArgumentException);
                int index11 = ((((index7 << 24) | (index10 << 16)) | (index9 << 8)) | index8);
                intBuffer.put(index11);
            }
        }
        index5 = this::resolveString;
        index6 = new class_1043(index5, class1011);
        index6.method_4524();
        return index6;
    }

    public Vector4d resolveVector4d(Entity ent, float offset) {
        return this.resolveVector4d(this.computeValue(ent.field_6014, ent.getX(), this.computeValue()), ((this.computeValue(ent.field_6036, ent.getY(), this.computeValue()) + ent.method_18381(ent.method_18376())) + offset), this.computeValue(ent.field_5969, ent.getZ(), this.computeValue()));
    }

    public static Vector4d resolveVector4d(PolygonShaderComponent arg0, Entity arg1, float arg2, int arg3, Object arg4) {
        if ((arg3 & 2) != 0) {
            arg2 = 0.4F;
        }
        return arg0.resolveVector4d(arg1, arg2);
    }

    public Vector4d resolveVector4d(Vec3d pos) {
        return this.resolveVector4d(pos.field_1352, pos.field_1351, pos.field_1350);
    }

    public Vector4d resolveVector4d(double x, double y, double z) {
        Vec3d vec = this.resolveMinecraftObject(new Vec3d(x, y, z));
        if (__UNDEF_KEY__ == null) {
        }
        if (vec.field_1350 > 0.0D && vec.field_1350 < 1.0D) {
            Vector4d vector4d = new Vector4d(vec.field_1352, vec.field_1351, Math.max(vec.field_1352, vec.field_1350), 0.0D);
        }
        return vector4d;
    }

    public Color resolveColor(Color receiver, float alpha) {
        return new Color(receiver.getRed(), receiver.getGreen(), receiver.getBlue(), (255.0F * Math.clamp(alpha, 0.0F, 1.0F)));
    }

    public Color resolveColor(Color receiver, Color end, float value) {
        float factor = Math.clamp(value, 0.0F, 1.0F);
        return new Color(this.computeValue(receiver.getRed(), end.getRed(), factor), this.computeValue(receiver.getGreen(), end.getGreen(), factor), this.computeValue(receiver.getBlue(), end.getBlue(), factor), this.computeValue(receiver.getAlpha(), end.getAlpha(), factor));
    }

    public float computeValue(Color receiver) {
        return (receiver.getRed() / 255.0F);
    }

    public float computeValue(Color receiver) {
        return (receiver.getGreen() / 255.0F);
    }

    public float computeValue(Color receiver) {
        return (receiver.getBlue() / 255.0F);
    }

    public float computeValue2(Color receiver) {
        return (receiver.getAlpha() / 255.0F);
    }

    public float computeValue() {
        return SharedKt.getMc().method_61966().method_60637(true);
    }

    public float computeValue(float oldValue, float newValue) {
        return this.computeValue(oldValue, newValue, this.computeValue());
    }

    public double computeValue(double oldValue, double newValue) {
        return this.computeValue(oldValue, newValue, this.computeValue());
    }

    public Vec3d[] process(Entity ent) {
        Box box = TextShaderComponent2.INSTANCE.resolveMinecraftObject(ent);
        Vec3d[] items = new Vec3d[8];
        items[0] = new Vec3d(box.field_1323, box.field_1322, box.field_1321);
        items[1] = new Vec3d(box.field_1323, box.field_1325, box.field_1321);
        items[2] = new Vec3d(box.field_1320, box.field_1322, box.field_1321);
        items[3] = new Vec3d(box.field_1320, box.field_1325, box.field_1321);
        items[4] = new Vec3d(box.field_1323, box.field_1322, box.field_1324);
        items[5] = new Vec3d(box.field_1323, box.field_1325, box.field_1324);
        items[6] = new Vec3d(box.field_1320, box.field_1322, box.field_1324);
        items[7] = new Vec3d(box.field_1320, box.field_1325, box.field_1324);
        return items;
    }

    public void executeAction(FormatRenderHelper polygon, float posX, float posY, float endPosX, float endPosY, Color color) {
        Color color2 = Color.BLACK;
        this.executeAction(polygon, (posX - 1.0F), posY, (posX + 0.5F), (endPosY + 0.5F), color2);
        this.executeAction(polygon, (posX - 1.0F), (posY - 0.5F), (endPosX + 0.5F), (posY + 1.0F), color2);
        this.executeAction(polygon, (endPosX - 1.0F), posY, (endPosX + 0.5F), (endPosY + 0.5F), color2);
        this.executeAction(polygon, (posX - 1.0F), (endPosY - 1.0F), (endPosX + 0.5F), (endPosY + 0.5F), color2);
        this.executeAction(polygon, (posX - 0.5F), posY, posX, endPosY, color);
        this.executeAction(polygon, posX, (endPosY - 0.5F), endPosX, endPosY, color);
        this.executeAction(polygon, (posX - 0.5F), posY, endPosX, (posY + 0.5F), color);
        this.executeAction(polygon, (endPosX - 0.5F), posY, endPosX, endPosY, color);
    }

    public Color resolveColor(int speed, int index, float saturation, float brightness) {
        long time = (((SharedKt.getNumericValue() / speed) + index) % 360);
        long time2 = (time / 360.0F);
        Color color = new Color(Color.HSBtoRGB(time2, saturation, brightness));
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), 255);
    }

    public Color resolveColor(int speed, int index) {
        int index2 = 0;
        index2 = (((SharedKt.getNumericValue() / speed) + index) % 360);
        int index3 = 360;
        index2 = (index2 % index3);
        if (__UNDEF_KEY__ == null) {
            if ((index3 / 360.0D) < 0.5D) {
            }
        }
        return Color.getHSBColor((index2 / 360.0D), 0.5F, 1.0F);
    }

    private boolean checkCondition() {
        return StringsKt.contains$default(((CharSequence) RenderSystem.getDevice().getVendor()), ((CharSequence) "Apple"), false);
    }

    private static Unit resolveUnit(class_2960 arg0, BufferedImage arg1) {
        SharedKt.getMc().method_1531().method_4616(arg0, ((class_1044) INSTANCE.resolveMinecraftObject(arg1)));
        return Unit.INSTANCE;
    }

    private static String resolveString(BufferedImage arg0) {
        return ("ctl_nibt_" + arg0.hashCode());
    }

    static {
        INSTANCE = new PolygonShaderComponent();
        copyOnWriteArrayList = new CopyOnWriteArrayList();
        matrix4f = new Matrix4f();
        matrix4f2 = new Matrix4f();
        countValueArray = new int[4];
        countValue = -1;
        factorValue = 1.0F;
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
