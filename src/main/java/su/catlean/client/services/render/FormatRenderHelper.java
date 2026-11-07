package su.catlean.client.services.render;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat.class_5595;
import java.awt.Color;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.minecraft.class_1041;
import net.minecraft.class_11280;
import net.minecraft.class_11280.class_11281;
import net.minecraft.class_12136;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.client.MinecraftClient;
import org.joml.Matrix3x2f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryUtil;
import su.catlean.SharedKt;
import su.catlean.api.event.GofraState;
import su.catlean.client.services.client.CtlVUboServiceComponent;
import su.catlean.client.services.client.ProjectionServiceComponent;
import su.catlean.client.services.client.ScissorServiceComponent;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.mixins.accessors.GlCommandEncoderAccessor;
import su.catlean.mixins.accessors.GlDeviceAccessor;
import su.catlean.mixins.accessors.RenderPassAccessor;

public class FormatRenderHelper {

    private final VertexFormat vertexFormat;
    private final boolean enabledFlag;
    private ByteBuffer byteBuffer;
    private final int countValue;
    private ByteBuffer byteBuffer2;
    private long timestampValue2;
    private final ByteBuffer byteBuffer3;
    private long timestampValue3;
    private final int[] countValueArray;
    private int countValue2;
    private int countValue3;
    private int countValue4;
    private final boolean enabledFlag2;
    private final boolean enabledFlag3;
    private final Vector3f vector3f;
    private static String[] textValueArray;

    public FormatRenderHelper(VertexFormat format, int objectsCount, boolean lines) {
        this.vertexFormat = format;
        this.enabledFlag = lines;
        this.byteBuffer = BufferUtils.createByteBuffer(((this.vertexFormat.getVertexSize() * objectsCount) * 4));
        if (this.enabledFlag) {
        } else {
        }
        2.countValue = 6;
        this.byteBuffer2 = BufferUtils.createByteBuffer(((objectsCount * this.countValue) * 4));
        this.timestampValue = MemoryUtil.memAddress0((Buffer) this.byteBuffer);
        this.timestampValue2 = MemoryUtil.memAddress0((Buffer) this.byteBuffer2);
        this.byteBuffer3 = MemoryUtil.memAlloc(24);
        this.timestampValue3 = this.timestampValue;
        this.countValueArray = new int[4];
        this.enabledFlag2 = Intrinsics.areEqual(this.vertexFormat, class_290.field_1592);
        this.enabledFlag3 = Intrinsics.areEqual(this.vertexFormat, class_290.field_1585);
        this.vector3f = new Vector3f();
    }

    public FormatRenderHelper(VertexFormat arg0, int arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
        if ((arg3 & 1)) {
            arg0 = class_290.field_1592;
        }
        if ((arg3 & 2)) {
            arg1 = 1;
        }
        if ((arg3 & 4)) {
            arg2 = 0;
        }
        this(arg0, arg1, arg2);
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public FormatRenderHelper resolveFormatRenderHelper() {
        return this.resolveFormatRenderHelper(-1.0F, -1.0F, 0.0F).resolveFormatRenderHelper(-1.0F, 1.0F, 0.0F).resolveFormatRenderHelper(1.0F, 1.0F, 0.0F).resolveFormatRenderHelper(1.0F, -1.0F, 0.0F);
    }

    public FormatRenderHelper resolveFormatRenderHelper() {
        int var14 = SharedKt.getMc().method_22683().method_4486();
        int var15 = SharedKt.getMc().method_22683().method_4502();
        return this.resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(Color.WHITE).resolveFormatRenderHelper(0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(0.0F, 1.0F).resolveFormatRenderHelper(Color.WHITE).resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(1.0F, 1.0F).resolveFormatRenderHelper(Color.WHITE).resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(1.0F, 0.0F).resolveFormatRenderHelper(Color.WHITE);
    }

    public FormatRenderHelper resolveFormatRenderHelper(Matrix4f matrix, float x, float y, float z, float u, float v, Color color) {
        matrix.transformPosition(x, y, z, this.vector3f);
        this.resolveFormatRenderHelper(this.vector3f.x, this.vector3f.y, this.vector3f.z, u, v, color);
        return this;
    }

    public FormatRenderHelper resolveFormatRenderHelper(float x, float y, float z, float u, float v, Color color) {
        this.executeAction(24);
        this.byteBuffer3.putFloat(0, x);
        this.byteBuffer3.putFloat(4, y);
        this.byteBuffer3.putFloat(8, z);
        this.byteBuffer3.putFloat(12, u);
        this.byteBuffer3.putFloat(16, v);
        this.byteBuffer3.put(20, color.getRed());
        this.byteBuffer3.put(21, color.getGreen());
        this.byteBuffer3.put(22, color.getBlue());
        this.byteBuffer3.put(23, RangesKt.coerceIn((color.getAlpha() * PolygonShaderComponent.INSTANCE.getNumericValue()), (ClosedRange) new IntRange(0, 255)));
        MemoryUtil.memCopy(MemoryUtil.memAddress(this.byteBuffer3), this.timestampValue3, 24L);
        this.timestampValue3 = (this.timestampValue3 + 24);
        this.resolveFormatRenderHelper2();
        return this;
    }

    public FormatRenderHelper resolveFormatRenderHelper(float x, float y, float z) {
        this.executeAction(12);
        MemoryUtil.memPutFloat(this.timestampValue3, x);
        MemoryUtil.memPutFloat((this.timestampValue3 + 4), y);
        MemoryUtil.memPutFloat((this.timestampValue3 + 8), z);
        this.timestampValue3 = (this.timestampValue3 + 12);
        if (var10 == null) {
            if (this.enabledFlag2) {
                this.resolveFormatRenderHelper2();
            }
        }
        return this;
    }

    public static FormatRenderHelper resolveFormatRenderHelper(FormatRenderHelper arg0, float arg1, float arg2, float arg3, int arg4, Object arg5) {
        if ((arg4 & 4)) {
            arg3 = 0.0F;
        }
        return arg0.resolveFormatRenderHelper(arg1, arg2, arg3);
    }

    public FormatRenderHelper resolveFormatRenderHelper(Matrix4f matrix, float x, float y, float z) {
        matrix.transformPosition(x, y, z, this.vector3f);
        return this.resolveFormatRenderHelper(this.vector3f.x, this.vector3f.y, this.vector3f.z);
    }

    public FormatRenderHelper resolveFormatRenderHelper(Matrix3x2f matrix, float x, float y, float z) {
        this.resolveMatrix4f(matrix).transformPosition(x, y, z, this.vector3f);
        return this.resolveFormatRenderHelper(this.vector3f.x, this.vector3f.y, this.vector3f.z);
    }

    public FormatRenderHelper resolveFormatRenderHelper(float u, float v) {
        this.executeAction(8);
        MemoryUtil.memPutFloat(this.timestampValue3, u);
        MemoryUtil.memPutFloat((this.timestampValue3 + 4), v);
        this.timestampValue3 = (this.timestampValue3 + 8);
        if (var9 == null) {
            if (this.enabledFlag3) {
                this.resolveFormatRenderHelper2();
            }
        }
        return this;
    }

    public FormatRenderHelper resolveFormatRenderHelper(Color c) {
        return this.resolveFormatRenderHelper(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
    }

    public FormatRenderHelper resolveFormatRenderHelper(float r, float g, float b) {
        return this.resolveFormatRenderHelper((r * 255), (g * 255), (b * 255), (0L * 255));
    }

    public FormatRenderHelper resolveFormatRenderHelper(int r, int g, int b) {
        this.executeAction(4);
        MemoryUtil.memPutByte(this.timestampValue3, r);
        MemoryUtil.memPutByte((this.timestampValue3 + 1L), g);
        MemoryUtil.memPutByte((this.timestampValue3 + 2), b);
        MemoryUtil.memPutByte((this.timestampValue3 + 3), RangesKt.coerceAtMost((0L * PolygonShaderComponent.INSTANCE.getNumericValue()), 255));
        this.timestampValue3 = (this.timestampValue3 + 4);
        if (var14 == null) {
            if (!(this.enabledFlag2)) {
                this.resolveFormatRenderHelper2();
            }
        }
        return this;
    }

    private void executeAction(int arg0) {
        ByteBuffer var5 = this.byteBuffer;
        int var6 = Math.max((var5.capacity() * 2), (var4 + arg0));
        ByteBuffer var7 = BufferUtils.createByteBuffer();
        MemoryUtil.memCopy(MemoryUtil.memAddress0((Buffer) var5), MemoryUtil.memAddress0((Buffer) var7));
        this.byteBuffer = var7;
        this.timestampValue = MemoryUtil.memAddress0((Buffer) this.byteBuffer);
        this.timestampValue3 = (this.timestampValue + var4);
    }

    private void executeAction2(int arg0) {
        int var4 = (this.countValue4 * 4);
        ByteBuffer var5 = this.byteBuffer2;
        int var6 = Math.max((var5.capacity() * 2), (var4 + arg0));
        ByteBuffer var7 = BufferUtils.createByteBuffer();
        MemoryUtil.memCopy(MemoryUtil.memAddress0((Buffer) var5), MemoryUtil.memAddress0((Buffer) var7));
        this.byteBuffer2 = var7;
        this.timestampValue2 = MemoryUtil.memAddress0((Buffer) this.byteBuffer2);
    }

    private FormatRenderHelper resolveFormatRenderHelper2() {
        int var7 = this.countValue3;
        this.countValue3 = (var7 + 1);
        int var6 = var7;
        this.countValueArray[this.countValue2] = var6;
        var7 = this.countValue2;
        this.countValue2 = (var7 + 1);
        if (this.enabledFlag) {
        } else {
        }
        if (2 == 4) {
            if (this.enabledFlag) {
            } else {
            }
            var7 = 6;
            this.executeAction2((var7 * 4));
            MemoryUtil.memPutInt(this.countValueArray[0]);
            MemoryUtil.memPutInt((var8 + 4), this.countValueArray[1]);
            if (!(this.enabledFlag)) {
                MemoryUtil.memPutInt((var8 + 8L), this.countValueArray[2]);
                MemoryUtil.memPutInt((var8 + 12L), this.countValueArray[2]);
                MemoryUtil.memPutInt((var8 + 16L), this.countValueArray[3]);
                MemoryUtil.memPutInt((var8 + 20L), this.countValueArray[0]);
            }
            this.countValue4 = (this.countValue4 + var7);
            this.countValue2 = 0;
        }
        return this;
    }

    public Matrix4f resolveMatrix4f(Matrix3x2f m) {
        Matrix4f var2 = new Matrix4f();
        Object var3 = var2;
        int var4 = 0;
        var3.m00(m.m00());
        var3.m01(m.m01());
        var3.m10(m.m10());
        var3.m11(m.m11());
        var3.m30(m.m20());
        var3.m31(m.m21());
        return var2;
    }

    public void executeAction(RenderPipeline pipeline, class_276 fb, GpuBufferSlice ubo, Matrix4f matrix3D, Matrix3x2f matrix2D, Map samplers) {
        this.executeAction(pipeline, fb.method_71639(), fb.method_71640(), ubo, matrix3D, matrix2D, samplers);
    }

    public static void executeAction(FormatRenderHelper arg0, RenderPipeline arg1, class_276 arg2, GpuBufferSlice arg3, Matrix4f arg4, Matrix3x2f arg5, Map arg6, int arg7, Object arg8) {
        if ((arg7 & 2)) {
            arg2 = SharedKt.getMc().method_1522();
        }
        if ((arg7 & 4)) {
        }
        if ((arg7 & 8)) {
        }
        if ((arg7 & 16)) {
        }
        if ((arg7 & 32)) {
            arg6 = MapsKt.emptyMap();
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void executeAction(RenderPipeline pipeline, GpuTextureView color, GpuTextureView depth, GpuBufferSlice ubo, Matrix4f matrix3D, Matrix3x2f matrix2D, Map samplers) {
        if (!(this.countValue3)) {
            return;
        }
        GpuBuffer var19 = this.vertexFormat.uploadImmediateIndexBuffer(this.byteBuffer2);
        GpuBuffer var20 = this.vertexFormat.uploadImmediateVertexBuffer(this.byteBuffer);
        if (matrix3D != null) {
        } else {
        }
        Matrix4f var21 = new Matrix4f().identity().setOrtho(0.0F, SharedKt.getMc().method_22683().method_4486(), SharedKt.getMc().method_22683().method_4502(), 0.0F, -100.0F, 100.0F);
        if (0L > 0 && var18 == null) {
            if (matrix3D == null) {
            }
            if (matrix2D != null) {
                Object var25 = matrix2D;
                Object var35 = var21;
                class_11280 var34 = CtlVUboServiceComponent.INSTANCE.getMinecraftObject();
                int var26 = 0;
                Matrix4f var36 = this.resolveMatrix4f();
            } else {
            }
        }
        Object var38 = var35;
        GpuBufferSlice var23 = var34.method_71102((class_11281) new ProjectionServiceComponent());
        Object var22 = var23;
        var23 = RenderSystem.getDevice().createCommandEncoder().createRenderPass(this::getString, color, OptionalInt.empty(), depth, OptionalDouble.empty());
        ServiceComponent78 var24 = ScissorServiceComponent.INSTANCE.getServiceComponent78();
        if (var24 != null) {
            var26 = var24;
            int var27 = 0;
            var23.enableScissor(var26.getNumericValue(), var26.getNumericValue2(), var26.getNumericValue3(), var26.getNumericValue4());
        } else {
            TextShaderComponent2.INSTANCE.getMatrix4f();
        }
        var26 = (RenderPassAccessor) var23.getEncoder();
        var25 = (GlCommandEncoderAccessor) var26.getBackendCatlean();
        (RenderPassAccessor) var23.setPipeline((GlDeviceAccessor) var25.compilePipelineCachedCatlean(pipeline));
        var23.setUniform("VertexUBO");
        if (ubo != null) {
            var26 = ubo;
            var27 = 0;
            var23.setUniform("UBO");
        } else {
        }
        var25 = RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST);
        var26 = samplers;
        var27 = 0;
        Iterator iterator = var26.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry var29 = (Entry) iterator.next();
            Object var30 = var29;
            int var31 = 0;
            String var32 = (String) var30.getKey();
            GpuTextureView var33 = (GpuTextureView) var30.getValue();
            var23.bindTexture();
            if (0L > 0 && var18 == null) {
            }
            var23.setVertexBuffer(0);
            var23.setIndexBuffer(class_5595.field_27373);
            var23.drawIndexed(0, 0, this.countValue4, 1);
        }
        if (var24 != null) {
            var27 = var24;
            iterator = 0;
            var23.disableScissor();
        } else {
        }
        GofraState.INSTANCE.setStopSwapBuffers(1);
        var23.close();
        GofraState.INSTANCE.setStopSwapBuffers(0);
        PolygonShaderComponent.INSTANCE.updateValue(1);
    }

    public static void executeAction(FormatRenderHelper arg0, RenderPipeline arg1, GpuTextureView arg2, GpuTextureView arg3, GpuBufferSlice arg4, Matrix4f arg5, Matrix3x2f arg6, Map arg7, int arg8, Object arg9) {
        if ((arg8 & 16)) {
        }
        if ((arg8 & 32)) {
        }
        if ((arg8 & 64)) {
            arg7 = MapsKt.emptyMap();
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private static String getString() {
        return "ctl-polygon-renderpass";
    }

    public FormatRenderHelper() {
        this();
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
