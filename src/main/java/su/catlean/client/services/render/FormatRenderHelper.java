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
        this.countValue = 6;
        this.byteBuffer2 = BufferUtils.createByteBuffer(((objectsCount * this.countValue) * 4));
        this.timestampValue = MemoryUtil.memAddress0(((Buffer) this.byteBuffer));
        this.timestampValue2 = MemoryUtil.memAddress0(((Buffer) this.byteBuffer2));
        this.byteBuffer3 = MemoryUtil.memAlloc(24);
        this.timestampValue3 = this.timestampValue;
        this.countValueArray = new int[4];
        this.enabledFlag2 = Intrinsics.areEqual(this.vertexFormat, class_290.field_1592);
        this.enabledFlag3 = Intrinsics.areEqual(this.vertexFormat, class_290.field_1585);
        this.vector3f = new Vector3f();
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public FormatRenderHelper resolveFormatRenderHelper() {
        return this.resolveFormatRenderHelper(-1.0F, -1.0F, 0.0F).resolveFormatRenderHelper(-1.0F, 1.0F, 0.0F).resolveFormatRenderHelper(1.0F, 1.0F, 0.0F).resolveFormatRenderHelper(1.0F, -1.0F, 0.0F);
    }

    public FormatRenderHelper resolveFormatRenderHelper() {
        int index = SharedKt.getMc().method_22683().method_4486();
        int index2 = SharedKt.getMc().method_22683().method_4502();
        return this.resolveFormatRenderHelper(0.0F, index2, 0.0F).resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(Color.WHITE).resolveFormatRenderHelper(0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(0.0F, 1.0F).resolveFormatRenderHelper(Color.WHITE).resolveFormatRenderHelper(index, 0.0F, 0.0F).resolveFormatRenderHelper(1.0F, 1.0F).resolveFormatRenderHelper(Color.WHITE).resolveFormatRenderHelper(index, index2, 0.0F).resolveFormatRenderHelper(1.0F, 0.0F).resolveFormatRenderHelper(Color.WHITE);
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
        this.byteBuffer3.put(23, RangesKt.coerceIn((color.getAlpha() * PolygonShaderComponent.INSTANCE.getNumericValue()), ((ClosedRange) new IntRange(0, 255))));
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
        if (__UNDEF_KEY__ == null) {
            if (this.enabledFlag2) {
                this.resolveFormatRenderHelper2();
            }
        }
        return this;
    }

    public static FormatRenderHelper resolveFormatRenderHelper(FormatRenderHelper arg0, float arg1, float arg2, float arg3, int arg4, Object arg5) {
        if ((arg4 & 4) != 0) {
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
        if (__UNDEF_KEY__ == null) {
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
        return this.resolveFormatRenderHelper((r * 255), (g * 255), (b * 255));
    }

    public FormatRenderHelper resolveFormatRenderHelper(int r, int g, int b) {
        this.executeAction(4);
        MemoryUtil.memPutByte(this.timestampValue3, r);
        MemoryUtil.memPutByte((this.timestampValue3 + 1L), g);
        MemoryUtil.memPutByte((this.timestampValue3 + 2), b);
        MemoryUtil.memPutByte((this.timestampValue3 + 3), RangesKt.coerceAtMost(255));
        this.timestampValue3 = (this.timestampValue3 + 4);
        if (__UNDEF_KEY__ == null) {
            if (!(this.enabledFlag2)) {
                this.resolveFormatRenderHelper2();
            }
        }
        return this;
    }

    private void executeAction(int arg0) {
        ByteBuffer byteBuffer = this.byteBuffer;
        int index = Math.max((byteBuffer.capacity() * 2));
        ByteBuffer byteBuffer2 = BufferUtils.createByteBuffer(index);
        MemoryUtil.memCopy(MemoryUtil.memAddress0(((Buffer) byteBuffer)), MemoryUtil.memAddress0(((Buffer) byteBuffer2)));
        this.byteBuffer = byteBuffer2;
        this.timestampValue = MemoryUtil.memAddress0(((Buffer) this.byteBuffer));
        this.timestampValue3 = (this.timestampValue + __UNDEF_KEY__);
    }

    private void executeAction2(int arg0) {
        int index = (this.countValue4 * 4);
        ByteBuffer byteBuffer = this.byteBuffer2;
        int index2 = Math.max((byteBuffer.capacity() * 2), (index + arg0));
        ByteBuffer byteBuffer2 = BufferUtils.createByteBuffer(index2);
        MemoryUtil.memCopy(MemoryUtil.memAddress0(((Buffer) byteBuffer)), MemoryUtil.memAddress0(((Buffer) byteBuffer2)), index);
        this.byteBuffer2 = byteBuffer2;
        this.timestampValue2 = MemoryUtil.memAddress0(((Buffer) this.byteBuffer2));
    }

    private FormatRenderHelper resolveFormatRenderHelper2() {
        int index = this.countValue3;
        this.countValue3 = (index + 1);
        this.countValueArray[this.countValue2] = index;
        index = this.countValue2;
        this.countValue2 = (index + 1);
        if (this.enabledFlag) {
        } else {
        }
        if (2 == 4) {
            if (this.enabledFlag) {
            } else {
            }
            index = 6;
            this.executeAction2((index * 4));
            MemoryUtil.memPutInt(this.countValueArray[0]);
            MemoryUtil.memPutInt(this.countValueArray[1]);
            if (!(this.enabledFlag)) {
                MemoryUtil.memPutInt(this.countValueArray[2]);
                MemoryUtil.memPutInt(this.countValueArray[2]);
                MemoryUtil.memPutInt(this.countValueArray[3]);
                MemoryUtil.memPutInt(this.countValueArray[0]);
            }
            this.countValue4 = (this.countValue4 + index);
            this.countValue2 = 0;
        }
        return this;
    }

    public Matrix4f resolveMatrix4f(Matrix3x2f m) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.m00(m.m00());
        matrix4f.m01(m.m01());
        matrix4f.m10(m.m10());
        matrix4f.m11(m.m11());
        matrix4f.m30(m.m20());
        matrix4f.m31(m.m21());
        return matrix4f;
    }

    public void executeAction(RenderPipeline pipeline, class_276 fb, GpuBufferSlice ubo, Matrix4f matrix3D, Matrix3x2f matrix2D, Map samplers) {
        this.executeAction(pipeline, fb.method_71639(), fb.method_71640(), ubo, matrix3D, matrix2D, samplers);
    }

    public static void executeAction(FormatRenderHelper arg0, RenderPipeline arg1, class_276 arg2, GpuBufferSlice arg3, Matrix4f arg4, Matrix3x2f arg5, Map arg6, int arg7, Object arg8) {
        if ((arg7 & 2) != 0) {
            arg2 = SharedKt.getMc().method_1522();
        }
        if ((arg7 & 4) != 0) {
        }
        if ((arg7 & 8) != 0) {
        }
        if ((arg7 & 16) != 0) {
        }
        if ((arg7 & 32) != 0) {
            arg6 = MapsKt.emptyMap();
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void executeAction(RenderPipeline pipeline, GpuTextureView color, GpuTextureView depth, GpuBufferSlice ubo, Matrix4f matrix3D, Matrix3x2f matrix2D, Map samplers) {
        if (!(this.countValue3)) {
            return;
        }
        GpuBuffer gpuBuffer = this.vertexFormat.uploadImmediateIndexBuffer(this.byteBuffer2);
        GpuBuffer gpuBuffer2 = this.vertexFormat.uploadImmediateVertexBuffer(this.byteBuffer);
        if (matrix3D != null) {
        } else {
        }
        Matrix4f matrix4f = new Matrix4f().identity().setOrtho(0.0F, SharedKt.getMc().method_22683().method_4486(), SharedKt.getMc().method_22683().method_4502(), 0.0F, -100.0F, 100.0F);
        if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__ == null) {
            if (matrix3D == null) {
                if (matrix2D != null) {
                    Matrix3x2f matrix3x2f = matrix2D;
                    class_11280 class11280 = CtlVUboServiceComponent.INSTANCE.getMinecraftObject();
                    int index = 0;
                    Matrix4f matrix4f2 = this.resolveMatrix4f(matrix3x2f);
                } else {
                }
            }
        }
        GpuBufferSlice gpuBufferSlice = class11280.method_71102(((class_11281) new ProjectionServiceComponent(matrix4f)));
        gpuBufferSlice = RenderSystem.getDevice().createCommandEncoder().createRenderPass(this::getString, color, OptionalInt.empty(), depth, OptionalDouble.empty());
        ServiceComponent78 serviceComponent78 = ScissorServiceComponent.INSTANCE.getServiceComponent78();
        if (serviceComponent78 != null) {
            index = serviceComponent78;
            gpuBufferSlice.enableScissor(index.getNumericValue(), index.getNumericValue2(), index.getNumericValue3(), index.getNumericValue4());
        } else {
            TextShaderComponent2.INSTANCE.getMatrix4f();
        }
        index = ((RenderPassAccessor) gpuBufferSlice).getEncoder();
        matrix3x2f = ((GlCommandEncoderAccessor) index).getBackendCatlean();
        ((RenderPassAccessor) gpuBufferSlice).setPipeline(((GlDeviceAccessor) matrix3x2f).compilePipelineCachedCatlean(pipeline));
        gpuBufferSlice.setUniform("VertexUBO", gpuBufferSlice);
        if (ubo != null) {
            index = ubo;
            gpuBufferSlice.setUniform("UBO", index);
        } else {
        }
        matrix3x2f = RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST);
        index = samplers;
        Iterator iterator = index.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            String text = ((String) entry.getKey());
            GpuTextureView gpuTextureView = ((GpuTextureView) entry.getValue());
            gpuBufferSlice.bindTexture(text, gpuTextureView, matrix3x2f);
            if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__ == null) {
                gpuBufferSlice.setVertexBuffer(0, gpuBuffer2);
                gpuBufferSlice.setIndexBuffer(gpuBuffer, class_5595.field_27373);
                gpuBufferSlice.drawIndexed(0, 0, this.countValue4, 1);
            }
        }
        if (serviceComponent78 != null) {
            iterator = 0;
            gpuBufferSlice.disableScissor();
        } else {
        }
        GofraState.INSTANCE.setStopSwapBuffers(true);
        gpuBufferSlice.close();
        GofraState.INSTANCE.setStopSwapBuffers(false);
        PolygonShaderComponent.INSTANCE.updateValue(true);
    }

    public static void executeAction(FormatRenderHelper arg0, RenderPipeline arg1, GpuTextureView arg2, GpuTextureView arg3, GpuBufferSlice arg4, Matrix4f arg5, Matrix3x2f arg6, Map arg7, int arg8, Object arg9) {
        if ((arg8 & 16) != 0) {
        }
        if ((arg8 & 32) != 0) {
        }
        if ((arg8 & 64) != 0) {
            arg7 = MapsKt.emptyMap();
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private static String getString() {
        return "ctl-polygon-renderpass";
    }

    public FormatRenderHelper() {
        this(null, 0, false);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
