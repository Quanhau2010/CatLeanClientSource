package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
import net.minecraft.class_10055;
import net.minecraft.class_1007;
import net.minecraft.class_1041;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_12079.class_12081;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_4588;
import net.minecraft.class_4604;
import net.minecraft.class_591;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.class_8685;
import net.minecraft.class_897;
import net.minecraft.class_898;
import net.minecraft.class_9779;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.joml.Math;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionfc;
import org.joml.Vector4d;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL32C;
import su.catlean.SharedKt;
import su.catlean.api.event.GofraState;
import su.catlean.api.event.events.render.FrustrumEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.client.features.modules.render.esp.LogoutSpotsModule;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.BoxRenderHelper;
import su.catlean.client.services.render.BoxRenderHelper2;
import su.catlean.client.services.render.CatleanInterfaceRenderHelper;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.POSITIONCOLORRenderHelper;
import su.catlean.client.services.render.PolygonRenderHelper2;
import su.catlean.client.services.render.StartRenderHelper;

public class TextShaderComponent2 {

    public static final TextShaderComponent2 INSTANCE;
    private static Matrix4f matrix4f;
    private static class_4604 minecraftRef;
    private static float factorValue;
    private static float factorValue2;
    private static float factorValue3;
    private static int countValue;

    private TextShaderComponent2() {
    }

    public Matrix4f getMatrix4f() {
        return matrix4f;
    }

    public void executeAction(Matrix4f value) {
        matrix4f = value;
    }

    public class_4604 getMinecraftObject() {
        return minecraftRef;
    }

    public void executeAction(class_4604 value) {
        minecraftRef = value;
    }

    public float getNumericValue() {
        return factorValue;
    }

    public void updateValue(float value) {
        factorValue = value;
    }

    public float getNumericValue2() {
        return factorValue2;
    }

    public void updateValue2(float value) {
        factorValue2 = value;
    }

    public float getNumericValue3() {
        return factorValue3;
    }

    public void updateValue3(float value) {
        factorValue3 = value;
    }

    private void onFrustrumEvent(FrustrumEvent arg0) {
        minecraftRef = arg0.getFrustrum();
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        class_4184 var9 = SharedKt.getMc().field_1773.method_19418();
        factorValue = Math.toRadians(var9.method_19330());
        factorValue2 = Math.toRadians((var9.method_19330() + 180.0F));
        factorValue3 = Math.toRadians(var9.method_19329());
        GofraState.INSTANCE.setModifyBuffer(0);
        PolygonShaderComponent.INSTANCE.getMatrix4f().set((Matrix4fc) RenderSystem.getModelViewMatrix());
        PolygonShaderComponent.INSTANCE.getMatrix4f2().set((Matrix4fc) arg0.getStack().method_23760().method_23761());
        GL32C.glGetIntegerv(2978, PolygonShaderComponent.INSTANCE.process());
        matrix4f = arg0.getProjection();
        NewThemeRenderHelper.INSTANCE.updateValue();
        GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221185));
    }

    public void executeAction(String text, Vec3d pos, Color color, float offX, float offY, boolean shadow, FontRenderHelper font) {
        Vector4d var28 = PolygonShaderComponent.INSTANCE.resolveVector4d(pos);
        Matrix3x2fStack var29 = new Matrix3x2fStack(8);
        var29.translate(var28.x, var28.y);
        Entity entity = SharedKt.getMc().method_1560();
        var29.scale((1.0F - ((Number) RangesKt.coerceIn((Comparable) Float.valueOf(LogoutSpotsModule.INSTANCE.resolveMinecraftObject(entity).method_1022(pos)), RangesKt.rangeTo(1.0F, 10.0F)) / 10.0F)));
        if (0L >= 0 && shadow) {
            font.executeAction(text, (offX + 1.0F), (offY + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, PolygonShaderComponent.INSTANCE.computeValue2(color)));
        }
        font.executeAction(text, offX, offY, color);
    }

    public static void executeAction(TextShaderComponent2 arg0, String arg1, Vec3d arg2, Color arg3, float arg4, float arg5, boolean arg6, FontRenderHelper arg7, int arg8, Object arg9) {
        if ((arg8 & 8)) {
            arg4 = 0.0F;
        }
        if ((arg8 & 16)) {
            arg5 = 0.0F;
        }
        if ((arg8 & 32)) {
            arg6 = 0;
        }
        if ((arg8 & 64)) {
            arg7 = SFMServiceComponent.resolveFontRenderHelper7();
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public float computeValue() {
        return SharedKt.getMc().method_61966().method_60637(1);
    }

    public boolean checkCondition(Box box, Color color, Color color2) {
        return POSITIONCOLORShaderComponent.INSTANCE.getList2().add(new BoxRenderHelper2(box, color, color2));
    }

    public static boolean checkCondition(TextShaderComponent2 arg0, Box arg1, Color arg2, Color arg3, int arg4, Object arg5) {
        if ((arg4 & 4)) {
            arg3 = arg2;
        }
        return arg0.checkCondition(arg1, arg2, arg3);
    }

    public boolean checkCondition(Box box, Color color, Color color2) {
        return POSITIONCOLORShaderComponent.INSTANCE.getList().add(new BoxRenderHelper2(box, color, color2));
    }

    public static boolean checkCondition(TextShaderComponent2 arg0, Box arg1, Color arg2, Color arg3, int arg4, Object arg5) {
        if ((arg4 & 4)) {
            arg3 = arg2;
        }
        return arg0.checkCondition(arg1, arg2, arg3);
    }

    public boolean checkCondition(Box box, Color color, Color color2) {
        return POSITIONCOLORShaderComponent.INSTANCE.getList3().add(new BoxRenderHelper2(box, color, color2));
    }

    public static boolean checkCondition(TextShaderComponent2 arg0, Box arg1, Color arg2, Color arg3, int arg4, Object arg5) {
        if ((arg4 & 4)) {
            arg3 = arg2;
        }
        return arg0.checkCondition(arg1, arg2, arg3);
    }

    public boolean checkCondition(Box box, Direction side, Color color) {
        return POSITIONCOLORShaderComponent.INSTANCE.getList4().add(new BoxRenderHelper(box, color, side));
    }

    public boolean checkCondition(Box box, Direction side, Color color) {
        return POSITIONCOLORShaderComponent.INSTANCE.getList5().add(new BoxRenderHelper(box, color, side));
    }

    public boolean checkCondition(Vec3d start, Vec3d end, Color startColor, Color endColor, boolean ignoreFrustrum) {
        return POSITIONCOLORShaderComponent.INSTANCE.getList6().add(new StartRenderHelper(start, end, startColor, endColor, ignoreFrustrum));
    }

    public static boolean checkCondition(TextShaderComponent2 arg0, Vec3d arg1, Vec3d arg2, Color arg3, Color arg4, boolean arg5, int arg6, Object arg7) {
        if ((arg6 & 8)) {
            arg4 = arg3;
        }
        if ((arg6 & 16)) {
            arg5 = 0;
        }
        return arg0.checkCondition(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean checkCondition(Vec3d start, Vec3d end, Color startColor, Color endColor) {
        return POSITIONCOLORShaderComponent.INSTANCE.getList7().add(new StartRenderHelper(start, end, startColor, endColor));
    }

    public static boolean checkCondition(TextShaderComponent2 arg0, Vec3d arg1, Vec3d arg2, Color arg3, Color arg4, int arg5, Object arg6) {
        if ((arg5 & 8)) {
            arg4 = arg3;
        }
        return arg0.checkCondition(arg1, arg2, arg3, arg4);
    }

    public Box resolveMinecraftObject(Box from, Box to, float delta) {
        return new Box(PolygonShaderComponent.INSTANCE.computeValue(from.field_1323, to.field_1323, delta), PolygonShaderComponent.INSTANCE.computeValue(from.field_1322, to.field_1322, delta), PolygonShaderComponent.INSTANCE.computeValue(from.field_1321, to.field_1321, delta), PolygonShaderComponent.INSTANCE.computeValue(from.field_1320, to.field_1320, delta), PolygonShaderComponent.INSTANCE.computeValue(from.field_1325, to.field_1325, delta), PolygonShaderComponent.INSTANCE.computeValue(from.field_1324, to.field_1324, delta));
    }

    public static Box resolveMinecraftObject(TextShaderComponent2 arg0, Box arg1, Box arg2, float arg3, int arg4, Object arg5) {
        if ((arg4 & 4)) {
            arg3 = arg0.computeValue();
        }
        return arg0.resolveMinecraftObject(arg1, arg2, arg3);
    }

    public Vec3d resolveMinecraftObject(Vec3d from, Vec3d to, float delta) {
        return new Vec3d(PolygonShaderComponent.INSTANCE.computeValue(from.field_1352, to.field_1352, delta), PolygonShaderComponent.INSTANCE.computeValue(from.field_1351, to.field_1351, delta), PolygonShaderComponent.INSTANCE.computeValue(from.field_1350, to.field_1350, delta));
    }

    public static Vec3d resolveMinecraftObject(TextShaderComponent2 arg0, Vec3d arg1, Vec3d arg2, float arg3, int arg4, Object arg5) {
        if ((arg4 & 4)) {
            arg3 = arg0.computeValue();
        }
        return arg0.resolveMinecraftObject(arg1, arg2, arg3);
    }

    private Box resolveMinecraftObject(Entity arg0) {
        double var9 = var7.computeValue(PolygonShaderComponent.INSTANCE, arg0.field_6014, arg0.getX());
        double var11 = var7.computeValue(PolygonShaderComponent.INSTANCE, arg0.field_6036, arg0.getY());
        double var13 = var7.computeValue(PolygonShaderComponent.INSTANCE, arg0.field_5969, arg0.getZ());
        Box var15 = arg0.method_5829();
        int var16 = 0;
        return new Box((((var15.field_1323 - arg0.getX()) + var9) - 0.05D), ((var15.field_1322 - arg0.getY()) + var11), (((var15.field_1321 - arg0.getZ()) + var13) - 0.05D), (((var15.field_1320 - arg0.getX()) + var9) + 0.05D), (((var15.field_1325 - arg0.getY()) + var11) + 0.15D), (((var15.field_1324 - arg0.getZ()) + var13) + 0.05D));
    }

    public void executeAction(class_2960 texture, Vec3d pos, float yaw, float pitch, float roll, float scale, Color color, boolean altBlend, FormatRenderHelper polygon, float uStart, float vStart, float uEnd, float vEnd, boolean altRtotate) {
        MatrixStack matrices = new MatrixStack();
        class_4184 var44 = SharedKt.getMc().field_1773.method_19418();
        Vec3d vec = pos.method_1020(var44.method_71156());
        if (altRtotate) {
            matrices.method_22904(vec.field_1352, vec.field_1351, vec.field_1350);
            matrices.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees(yaw));
            matrices.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(pitch));
        }
        matrices.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(var44.method_19329()));
        matrices.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees(((var44.method_19330() + yaw) + 180.0F)));
        matrices.method_22904(vec.field_1352, vec.field_1351, vec.field_1350);
        matrices.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((var44.method_19330() + yaw)));
        if (0) {
            matrices.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(var44.method_19329()));
        }
        matrices.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(pitch));
        Matrix4f var46 = matrices.method_23760().method_23761();
        matrices.method_22904((scale / 2.0D), (scale / 2.0D), -0.01D);
        GpuTextureView var47 = SharedKt.getMc().method_1531().method_4619(texture).method_71659();
        var41.resolveFormatRenderHelper(0.0F, scale, 0.0F).resolveFormatRenderHelper(uStart, vEnd).resolveFormatRenderHelper(color);
        var41.resolveFormatRenderHelper(scale, scale, 0.0F).resolveFormatRenderHelper(uEnd, vEnd).resolveFormatRenderHelper(color);
        var41.resolveFormatRenderHelper(scale, 0.0F, 0.0F).resolveFormatRenderHelper(uEnd, vStart).resolveFormatRenderHelper(color);
        var41.resolveFormatRenderHelper(0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(uStart, vStart).resolveFormatRenderHelper(color);
        FormatRenderHelper.resolveFormatRenderHelper(0.0F, scale, 0.0F).resolveFormatRenderHelper(uStart, vEnd).resolveFormatRenderHelper(color);
        FormatRenderHelper.resolveFormatRenderHelper(scale, scale, 0.0F).resolveFormatRenderHelper(uEnd, vEnd).resolveFormatRenderHelper(color);
        FormatRenderHelper.resolveFormatRenderHelper(scale, 0.0F, 0.0F).resolveFormatRenderHelper(uEnd, vStart).resolveFormatRenderHelper(color);
        FormatRenderHelper.resolveFormatRenderHelper(0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(uStart, vStart).resolveFormatRenderHelper(color);
        int var32 = 20;
        Map var33 = MapsKt.mapOf(TuplesKt.to("Sampler0"));
        Object var35 = var46;
        class_276 var37 = SharedKt.getMc().method_1522();
        RenderPipeline var38 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline14();
        RenderPipeline var39 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline18();
        FormatRenderHelper.executeAction();
    }

    public static void executeAction(TextShaderComponent2 arg0, class_2960 arg1, Vec3d arg2, float arg3, float arg4, float arg5, float arg6, Color arg7, boolean arg8, FormatRenderHelper arg9, float arg10, float arg11, float arg12, float arg13, boolean arg14, int arg15, Object arg16) {
        if ((arg15 & 128)) {
            arg8 = 1;
        }
        if ((arg15 & 256)) {
        }
        if ((arg15 & 512)) {
            arg10 = 0.0F;
        }
        if ((arg15 & 1024)) {
            arg11 = 0.0F;
        }
        if ((arg15 & 2048)) {
            arg12 = 1.0F;
        }
        if ((arg15 & 4096)) {
            arg13 = 1.0F;
        }
        if ((arg15 & 8192)) {
            arg14 = 0;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
    }

    public void render(MatrixStack stack, Vec3d pos, PlayerEntity entity, float alpha, boolean depthTest) {
        GpuTextureView var35 = SharedKt.getMc().method_1531().method_4619((AbstractClientPlayerEntity) entity.method_52814().comp_1626().comp_3627()).method_71659();
        if (alpha == 1.0F) {
        } else {
        }
        Color var36 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), alpha);
        int var26 = 4;
        int var27 = 0;
        int var28 = 256;
        VertexFormat var29 = class_290.field_1575;
        FormatRenderHelper var37 = new FormatRenderHelper();
        PolygonRenderHelper2 var38 = new PolygonRenderHelper2();
        class_591 var39 = (class_591) (class_1007) SharedKt.getMc().method_1561().method_3953(entity).method_4038();
        class_10055 var40 = (class_10055) SharedKt.getMc().method_1561().method_3953(entity).method_62425(entity, this.computeValue());
        stack.method_22903();
        double var41 = (pos.field_1352 - SharedKt.getMc().method_1561().field_4686.method_71156().method_10216());
        double var43 = (pos.field_1351 - SharedKt.getMc().method_1561().field_4686.method_71156().method_10214());
        double var45 = (pos.field_1350 - SharedKt.getMc().method_1561().field_4686.method_71156().method_10215());
        stack.method_46416();
        stack.method_22905(var40.field_53453, var40.field_53453, var40.field_53453);
        LogoutSpotsModule.INSTANCE.render(stack, var40.field_53446);
        stack.method_22905(-1.0F, -1.0F, 1.0F);
        stack.method_22905(0.9375F, 0.9375F, 0.9375F);
        stack.method_46416(0.0F, -1.501F, 0.0F);
        var39.method_62110();
        var39.method_62100(stack, (class_4588) var38, 15728880, 0, var36.getRGB());
        var26 = 22;
        var27 = MapsKt.mapOf(TuplesKt.to("Sampler0"));
        var29 = new MatrixStack().method_23760().method_23761();
        RenderPipeline var32 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline16();
        RenderPipeline var33 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline17();
        FormatRenderHelper.executeAction();
        stack.method_22909();
    }

    public static void render(TextShaderComponent2 arg0, MatrixStack arg1, Vec3d arg2, PlayerEntity arg3, float arg4, boolean arg5, int arg6, Object arg7) {
        if ((arg6 & 16)) {
            arg5 = 0;
        }
        arg0.render(arg1, arg2, arg3, arg4, arg5);
    }

    public Box resolveMinecraftObject(Entity receiver) {
        return this.resolveMinecraftObject(receiver);
    }

    public Vec3d resolveMinecraftObject(PlayerEntity entity, float factor) {
        Vec3d vec = SharedKt.getMc().method_1561().field_4686.method_71156();
        double var8 = ((entity.field_6014 + ((entity.getX() - entity.field_6014) * factor)) - vec.field_1352);
        double var10 = ((entity.field_6036 + ((entity.getY() - entity.field_6036) * factor)) - vec.field_1351);
        double var12 = ((entity.field_5969 + ((entity.getZ() - entity.field_5969) * factor)) - vec.field_1350);
        return new Vec3d();
    }

    public static Vec3d resolveMinecraftObject(TextShaderComponent2 arg0, PlayerEntity arg1, float arg2, int arg3, Object arg4) {
        if ((arg3 & 2)) {
            arg2 = arg0.computeValue();
        }
        return arg0.resolveMinecraftObject(arg1, arg2);
    }

    static {
        INSTANCE = new TextShaderComponent2();
        matrix4f = new Matrix4f();
        minecraftRef = new class_4604(new Matrix4f(), new Matrix4f());
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 28;
        return 0;
    }

}
