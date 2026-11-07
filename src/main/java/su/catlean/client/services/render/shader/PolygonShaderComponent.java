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
        int var9 = SharedKt.getMc().method_22683().method_4495();
        Iterable var10 = (Iterable) SFMServiceComponent.getList();
        int var11 = 0;
        Iterator iterator = var10.iterator();
        if (iterator.hasNext()) {
            Object var13 = iterator.next();
            FontRenderHelper var14 = (FontRenderHelper) var13;
            int var15 = 0;
            var14.close();
            var14.updateValue();
            if (var8 == null) {
            }
        }
        countValue = var9;
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        CtlBlurserviceFbShaderComponent.INSTANCE.updateValue();
        Iterable var7 = (Iterable) copyOnWriteArrayList;
        int var8 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var10 = iterator.next();
            Function0 var11 = (Function0) var10;
            int var12 = 0;
            var11.invoke();
        }
        copyOnWriteArrayList.clear();
    }

    private void onRenderScreenEvent(RenderScreenEvent arg0) {
        if (var4 == null) {
            GlStateManager._glBindFramebuffer(36160, 0);
        }
        enabledFlag = 0;
    }

    private void onRenderScreenEvent2(RenderScreenEvent arg0) {
        if (var8 == null) {
        }
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
        if (var13 == null) {
            if (colors > 1) {
            }
        }
        if (var13 == null) {
            if (colors > 1) {
            }
        }
        if (var13 == null) {
            if (colors > 1) {
            }
        }
        colors[3].resolveFormatRenderHelper(colors[0]);
    }

    public void executeAction(Matrix3x2fStack matrices, float x, float y, float w, float h, Color[] colors) {
        int var18 = 6;
        int var19 = 0;
        int var20 = 0;
        VertexFormat var21 = class_290.field_1576;
        if (var22 == null) {
            if (colors > 1) {
            }
        }
        if (var22 == null) {
            if (colors > 1) {
            }
        }
        if (var22 == null) {
            if (colors > 1) {
            }
        }
        FormatRenderHelper.executeAction(colors[3].resolveFormatRenderHelper(colors[0]), VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, null, new Matrix3x2f((Matrix3x2fc) matrices));
    }

    public void executeAction(Matrix3x2fStack matrices, float x, float y, float width, float height, Color c) {
        VertexFormat var18 = class_290.field_1576;
        FormatRenderHelper.executeAction(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(new FormatRenderHelper(4, 1), x, y, 0.0F).resolveFormatRenderHelper(c), x, (y + height), 0.0F).resolveFormatRenderHelper(c), x, (y + height), 0.0F).resolveFormatRenderHelper(c), (x + width), (y + height), 0.0F).resolveFormatRenderHelper(c), (x + width), (y + height), 0.0F).resolveFormatRenderHelper(c), (x + width), y, 0.0F).resolveFormatRenderHelper(c), (x + width), y, 0.0F).resolveFormatRenderHelper(c), x, y, 0.0F).resolveFormatRenderHelper(c), VertexUBOShaderComponent.INSTANCE.getRenderPipeline25(), null, null, null, new Matrix3x2f((Matrix3x2fc) matrices));
    }

    public void render(DrawContext context, ServiceComponent78 r1) {
        Vector2f var7 = new Vector2f();
        Vector2f var8 = new Vector2f();
        context.method_51448().transformPosition(r1.getNumericValue(), r1.getNumericValue2());
        context.method_51448().transformPosition(r1.getNumericValue3(), r1.getNumericValue4());
        context.method_44379(var7.x, var7.y, var8.x, var8.y);
        ScissorServiceComponent.INSTANCE.executeAction(new ServiceComponent78(var7.x, var7.y, var8.x, var8.y));
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
        GpuTextureView var39 = SharedKt.getMc().method_1531().method_4619(id).method_71659();
        int var31 = 6;
        int var32 = 0;
        int var33 = 0;
        VertexFormat var34 = class_290.field_1575;
        FormatRenderHelper var40 = new FormatRenderHelper();
        FormatRenderHelper.resolveFormatRenderHelper((x + 0), (y + height), 0.0F).resolveFormatRenderHelper(uStart, vEnd).resolveFormatRenderHelper(color1);
        FormatRenderHelper.resolveFormatRenderHelper((x + width), (y + height), 0.0F).resolveFormatRenderHelper(uEnd, vEnd).resolveFormatRenderHelper(color2);
        FormatRenderHelper.resolveFormatRenderHelper((x + width), (y + 0), 0.0F).resolveFormatRenderHelper(uEnd, vStart).resolveFormatRenderHelper(color3);
        FormatRenderHelper.resolveFormatRenderHelper((x + 0), (y + 0), 0.0F).resolveFormatRenderHelper(uStart, vStart).resolveFormatRenderHelper(color4);
        if (altBlend) {
        }
        var31 = 12;
        var32 = MapsKt.mapOf(TuplesKt.to("Sampler0"));
        var33 = matrices;
        class_276 var36 = SharedKt.getMc().method_1522();
        RenderPipeline var37 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline14();
        RenderPipeline var38 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline18();
        FormatRenderHelper.executeAction();
    }

    public static void executeAction(PolygonShaderComponent arg0, Matrix3x2f arg1, class_2960 arg2, float arg3, float arg4, float arg5, float arg6, Color arg7, Color arg8, int arg9, Color arg10, Color arg11, float arg12, char arg13, float arg14, float arg15, short arg16, float arg17, boolean arg18, int arg19, Object arg20) {
        if (var25 == null) {
            if ((arg19 & 64)) {
                arg7 = Color.WHITE;
            }
        }
        if (arg13 >= 0) {
            if (var25 == null) {
                if ((arg19 & 128)) {
                    arg8 = arg7;
                }
            }
        }
        if (arg9 >= 0) {
            if (var25 == null) {
                if ((arg19 & 256)) {
                    arg10 = arg8;
                }
            }
        }
        if (arg13 >= 0) {
            if (var25 == null) {
                if ((arg19 & 512)) {
                    arg11 = arg10;
                }
            }
        }
        if (arg13 > 0) {
            if (var25 == null) {
                if ((arg19 & 1024)) {
                    arg12 = 0.0F;
                }
            }
        }
        if (arg16 > 0) {
            if (var25 == null) {
                if ((arg19 & 2048)) {
                    arg14 = 0.0F;
                }
            }
        }
        if (arg13 >= 0) {
            if (var25 == null) {
                if ((arg19 & 4096)) {
                    arg15 = 1.0F;
                }
            }
        }
        if (arg9 > 0) {
            if (var25 == null) {
                if ((arg19 & 8192)) {
                    arg17 = 1.0F;
                }
            }
        }
        if (var25 == null) {
            if ((arg19 & 16384)) {
            }
            arg18 = 0;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg10, arg11, arg12, arg14, arg15, arg17, arg18);
    }

    public void executeAction(FormatRenderHelper polygon, float x, float y, float width, float height, Color color1, Color color2, Color color3, Color color4, float uStart, float vStart, float uEnd, float vEnd) {
        FormatRenderHelper.resolveFormatRenderHelper(polygon, (x + 0), (y + height), 0.0F).resolveFormatRenderHelper(uStart, vEnd).resolveFormatRenderHelper(color1);
        FormatRenderHelper.resolveFormatRenderHelper(polygon, (x + width), (y + height), 0.0F).resolveFormatRenderHelper(uEnd, vEnd).resolveFormatRenderHelper(color2);
        FormatRenderHelper.resolveFormatRenderHelper(polygon, (x + width), (y + 0), 0.0F).resolveFormatRenderHelper(uEnd, vStart).resolveFormatRenderHelper(color3);
        FormatRenderHelper.resolveFormatRenderHelper(polygon, (x + 0), (y + 0), 0.0F).resolveFormatRenderHelper(uStart, vStart).resolveFormatRenderHelper(color4);
    }

    public static void executeAction(PolygonShaderComponent arg0, FormatRenderHelper arg1, float arg2, float arg3, float arg4, float arg5, Color arg6, Color arg7, Color arg8, Color arg9, float arg10, float arg11, float arg12, float arg13, int arg14, Object arg15) {
        if (var20 == null) {
            if ((arg14 & 32)) {
                arg6 = Color.WHITE;
            }
        }
        if (var20 == null) {
            if ((arg14 & 64)) {
                arg7 = arg6;
            }
        }
        if (var20 == null) {
            if ((arg14 & 128)) {
                arg8 = arg7;
            }
        }
        if (var20 == null) {
            if ((arg14 & 256)) {
                arg9 = arg8;
            }
        }
        if (var20 == null) {
            if ((arg14 & 512)) {
                arg10 = 0.0F;
            }
        }
        if (var20 == null) {
            if ((arg14 & 1024)) {
                arg11 = 0.0F;
            }
        }
        if (var20 == null) {
            if ((arg14 & 2048)) {
                arg12 = 1.0F;
            }
        }
        if ((arg14 & 4096)) {
            arg13 = 1.0F;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public void executeAction(Matrix4f matrices, class_2960 id, float x, float y, float width, float height, Color color1, Color color2, Color color3, Color color4, boolean altBlend, float uStart, float vStart, float uEnd, float vEnd) {
        float var39 = (height / 2.0F);
        float var40 = (width / 2.0F);
        GpuTextureView var41 = SharedKt.getMc().method_1531().method_4619(id).method_71659();
        int var31 = 6;
        int var32 = 0;
        int var33 = 0;
        VertexFormat var34 = class_290.field_1575;
        FormatRenderHelper var42 = new FormatRenderHelper();
        FormatRenderHelper.resolveFormatRenderHelper((x - var39), (y + var39), 0.0F).resolveFormatRenderHelper(uStart, vEnd).resolveFormatRenderHelper(color1);
        FormatRenderHelper.resolveFormatRenderHelper((x + var40), (y + var39), 0.0F).resolveFormatRenderHelper(uEnd, vEnd).resolveFormatRenderHelper(color2);
        FormatRenderHelper.resolveFormatRenderHelper((x + var40), (y - var39), 0.0F).resolveFormatRenderHelper(uEnd, vStart).resolveFormatRenderHelper(color3);
        FormatRenderHelper.resolveFormatRenderHelper((x - var40), (y - var39), 0.0F).resolveFormatRenderHelper(uStart, vStart).resolveFormatRenderHelper(color4);
        if (altBlend) {
        }
        var31 = 4;
        var32 = MapsKt.mapOf(TuplesKt.to("Sampler0"));
        var33 = (Matrix3x2f) new Matrix3x2fStack();
        var34 = matrices;
        class_276 var36 = SharedKt.getMc().method_1522();
        RenderPipeline var37 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline14();
        RenderPipeline var38 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline18();
        FormatRenderHelper.executeAction();
    }

    public static void executeAction(PolygonShaderComponent arg0, Matrix4f arg1, class_2960 arg2, float arg3, float arg4, float arg5, float arg6, Color arg7, Color arg8, Color arg9, Color arg10, boolean arg11, float arg12, float arg13, float arg14, float arg15, int arg16, Object arg17) {
        if (var22 == null) {
            if ((arg16 & 64)) {
                arg7 = Color.WHITE;
            }
        }
        if (var22 == null) {
            if ((arg16 & 128)) {
                arg8 = arg7;
            }
        }
        if (var22 == null) {
            if ((arg16 & 256)) {
                arg9 = arg8;
            }
        }
        if (var22 == null) {
            if ((arg16 & 512)) {
                arg10 = arg9;
            }
        }
        if (var22 == null) {
            if ((arg16 & 1024)) {
                arg11 = 0;
            }
        }
        if (var22 == null) {
            if ((arg16 & 2048)) {
                arg12 = 0.0F;
            }
        }
        if (var22 == null) {
            if ((arg16 & 4096)) {
                arg13 = 0.0F;
            }
        }
        if (var22 == null) {
            if ((arg16 & 8192)) {
                arg14 = 1.0F;
            }
        }
        if ((arg16 & 16384)) {
            arg15 = 1.0F;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
    }

    public void executeAction(Matrix3x2fStack matrices, float x, float y, float x1, float y1, Color color, Color color2) {
        int var22 = 2;
        int var23 = 1;
        int var24 = 0;
        VertexFormat var25 = class_290.field_1576;
        FormatRenderHelper.executeAction(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(new FormatRenderHelper(), x, y, 0.0F).resolveFormatRenderHelper(color), x1, y1, 0.0F).resolveFormatRenderHelper(color2), VertexUBOShaderComponent.INSTANCE.getRenderPipeline25(), null, null, null, new Matrix3x2f((Matrix3x2fc) matrices));
    }

    public static void executeAction(PolygonShaderComponent arg0, Matrix3x2fStack arg1, float arg2, float arg3, float arg4, float arg5, Color arg6, Color arg7, int arg8, Object arg9) {
        if ((arg8 & 64)) {
            arg7 = arg6;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
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
        if (var8 == null) {
            if (SharedKt.getMc().method_1561().field_4686 != null) {
                if (var8 == null) {
                    if (SharedKt.getMc().method_1561().field_4686.method_71156() == null) {
                    }
                    SharedKt.getMc().method_1561().field_4686.method_71156();
                }
            }
        }
        Vec3d vec = Vec3d.ZERO;
        if (var8 == null) {
            if (this.checkCondition()) {
            }
        } else {
        }
        int var10 = (2 * 1);
        Vector3f var11 = new Vector3f();
        double var12 = (pos.field_1352 - vec.field_1352);
        double var14 = (pos.field_1351 - vec.field_1351);
        double var16 = (pos.field_1350 - vec.field_1350);
        Vector4f var18 = new Vector4f(1.0F).mul((Matrix4fc) matrix4f2);
        Matrix4f var19 = new Matrix4f((Matrix4fc) TextShaderComponent2.INSTANCE.getMatrix4f());
        Matrix4f var20 = new Matrix4f((Matrix4fc) matrix4f);
        var19.mul((Matrix4fc) var20).project(var18.x(), var18.y(), var18.z(), countValueArray);
        return new Vec3d((var11.x / SharedKt.getMc().method_22683().method_4495()), ((var10 - var11.y) / SharedKt.getMc().method_22683().method_4495()), var11.z);
    }

    public void render(MatrixStack matrices, ItemStack stack) {
        if (var9 == null) {
            matrices.method_22903();
            matrices.method_46416(8.0F, 8.0F, 150.0F);
            matrices.method_22905(16.0F, -16.0F, 16.0F);
        }
        class_10444 var10 = new class_10444();
        SharedKt.getMc().method_65386().method_65598(stack, class_811.field_4317, (World) SharedKt.getWorld(), null, 0);
        var10.method_65604(matrices, (class_11659) SharedKt.getMc().field_1773.method_72910(), 15728880, class_4608.field_21444, 0);
        matrices.method_22909();
    }

    public void executeAction(class_2960 i, BufferedImage bi) {
        if (RenderSystem.isOnRenderThread()) {
            SharedKt.getMc().method_1531().method_4616(i, (class_1044) this.resolveMinecraftObject(bi));
        }
        this.checkCondition(this::resolveUnit);
    }

    public boolean checkCondition(Function0 function) {
        return copyOnWriteArrayList.add(function);
    }

    public class_1043 resolveMinecraftObject(BufferedImage bi) {
        int var4 = bi.getWidth();
        int var5 = bi.getHeight();
        class_1011 var6 = new class_1011(class_1012.field_4997, 0);
        long var7 = (NativeImageAccessor) var6.getPixels();
        IntBuffer var9 = MemoryUtil.memIntBuffer((var6.method_4307() * var6.method_4323()));
        WritableRaster var11 = bi.getRaster();
        ColorModel var12 = bi.getColorModel();
        int var13 = var11.getNumBands();
        int var14 = var11.getDataBuffer().getDataType();
        IllegalArgumentException var10 = new IllegalArgumentException(("Unknown data buffer type: " + var14));
        int var15 = 0;
        if (var15 < var5) {
            int var16 = 0;
            if (var16 < var4) {
                var11.getDataElements();
                int var17 = var12.getAlpha();
                int var18 = var12.getRed();
                int var19 = var12.getGreen();
                int var20 = var12.getBlue();
                int var21 = ((((var17 << 24) | (var20 << 16)) | (var19 << 8)) | var18);
                var9.put();
            }
        }
        var15 = this::resolveString;
        var16 = new class_1043();
        var16.method_4524();
        return var16;
    }

    public Vector4d resolveVector4d(Entity ent, float offset) {
        return this.resolveVector4d(this.computeValue(ent.field_6014, ent.getX(), this.computeValue()), ((this.computeValue(ent.field_6036, ent.getY(), this.computeValue()) + ent.method_18381(ent.method_18376())) + offset), this.computeValue(ent.field_5969, ent.getZ(), this.computeValue()));
    }

    public static Vector4d resolveVector4d(PolygonShaderComponent arg0, Entity arg1, float arg2, int arg3, Object arg4) {
        if ((arg3 & 2)) {
            arg2 = 0.4F;
        }
        return arg0.resolveVector4d(arg1, arg2);
    }

    public Vector4d resolveVector4d(Vec3d pos) {
        return this.resolveVector4d(pos.field_1352, pos.field_1351, pos.field_1350);
    }

    public Vector4d resolveVector4d(double x, double y, double z) {
        Vec3d vec = this.resolveMinecraftObject(new Vec3d(x, y, z));
        if (var14 == null) {
        }
        if (vec.field_1350 > 0.0D && vec.field_1350 < 1.0D) {
            Vector4d var15 = new Vector4d(vec.field_1352, vec.field_1351, Math.max(vec.field_1352, vec.field_1350), 0.0D);
        }
        return var15;
    }

    public Color resolveColor(Color receiver, float alpha) {
        return new Color(receiver.getRed(), receiver.getGreen(), receiver.getBlue(), (255.0F * Math.clamp(alpha, 0.0F, 1.0F)));
    }

    public Color resolveColor(Color receiver, Color end, float value) {
        float var6 = Math.clamp(value, 0.0F, 1.0F);
        return new Color(this.computeValue(receiver.getRed(), end.getRed()), this.computeValue(receiver.getGreen(), end.getGreen()), this.computeValue(receiver.getBlue(), end.getBlue()), this.computeValue(receiver.getAlpha(), end.getAlpha()));
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
        return SharedKt.getMc().method_61966().method_60637(1);
    }

    public float computeValue(float oldValue, float newValue) {
        return this.computeValue(oldValue, newValue, this.computeValue());
    }

    public double computeValue(double oldValue, double newValue) {
        return this.computeValue(oldValue, newValue, this.computeValue());
    }

    public Vec3d[] process(Entity ent) {
        Box var6 = TextShaderComponent2.INSTANCE.resolveMinecraftObject(ent);
        Vec3d[] var7 = new Vec3d[8];
        var7[0] = new Vec3d(var6.field_1323, var6.field_1322, var6.field_1321);
        var7[1] = new Vec3d(var6.field_1323, var6.field_1325, var6.field_1321);
        var7[2] = new Vec3d(var6.field_1320, var6.field_1322, var6.field_1321);
        var7[3] = new Vec3d(var6.field_1320, var6.field_1325, var6.field_1321);
        var7[4] = new Vec3d(var6.field_1323, var6.field_1322, var6.field_1324);
        var7[5] = new Vec3d(var6.field_1323, var6.field_1325, var6.field_1324);
        var7[6] = new Vec3d(var6.field_1320, var6.field_1322, var6.field_1324);
        var7[7] = new Vec3d(var6.field_1320, var6.field_1325, var6.field_1324);
        return var7;
    }

    public void executeAction(FormatRenderHelper polygon, float posX, float posY, float endPosX, float endPosY, Color color) {
        Color var11 = Color.BLACK;
        this.executeAction(polygon, (posX - 1.0F), posY, (posX + 0.5F), (endPosY + 0.5F));
        this.executeAction(polygon, (posX - 1.0F), (posY - 0.5F), (endPosX + 0.5F), (posY + 1.0F));
        this.executeAction(polygon, (endPosX - 1.0F), posY, (endPosX + 0.5F), (endPosY + 0.5F));
        this.executeAction(polygon, (posX - 1.0F), (endPosY - 1.0F), (endPosX + 0.5F), (endPosY + 0.5F));
        this.executeAction(polygon, (posX - 0.5F), posY, posX, endPosY, color);
        this.executeAction(polygon, posX, (endPosY - 0.5F), endPosX, endPosY, color);
        this.executeAction(polygon, (posX - 0.5F), posY, endPosX, (posY + 0.5F), color);
        this.executeAction(polygon, (endPosX - 0.5F), posY, endPosX, endPosY, color);
    }

    public Color resolveColor(int speed, int index, float saturation, float brightness) {
        long var10 = (((SharedKt.getNumericValue() / speed) + index) % 360);
        int var11 = (var10 / 360.0F);
        Color var12 = new Color(Color.HSBtoRGB(saturation, brightness));
        return new Color(var12.getRed(), var12.getGreen(), var12.getBlue(), 255);
    }

    public Color resolveColor(int speed, int index) {
        int var6 = 0;
        var6 = (((SharedKt.getNumericValue() / speed) + index) % 360);
        int var7 = 360;
        int var8 = var7;
        int var9 = 0;
        var6 = (var6 % var8);
        if (var5 == null) {
            if ((var7 / 360.0D) < 0.5D) {
            }
        }
        return Color.getHSBColor((var6 / 360.0D), 0.5F, 1.0F);
    }

    private boolean checkCondition() {
        return StringsKt.contains$default((CharSequence) RenderSystem.getDevice().getVendor(), (CharSequence) "Apple");
    }

    private static Unit resolveUnit(class_2960 arg0, BufferedImage arg1) {
        SharedKt.getMc().method_1531().method_4616(arg0, (class_1044) INSTANCE.resolveMinecraftObject(arg1));
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
