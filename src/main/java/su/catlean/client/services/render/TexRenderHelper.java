package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.types.OptionMode6;

public class TexRenderHelper {

    private OptionMode6 optionMode6;
    private Vec3d vec3d;
    private float factorValue;
    private float factorValue2;
    private int countValue;
    private Vec3d vec3d2;
    private Color colorValue;
    private float factorValue3;
    private float factorValue4;
    private boolean enabledFlag;
    private final int countValue2;
    private Vec3d vec3d3;
    private float factorValue5;
    private float factorValue6;
    private int countValue3;
    private static String textValue;

    public TexRenderHelper(OptionMode6 tex, Vec3d pos, float rotationSpeed, float scale, int lifetime, Vec3d velocity, Color color, float gravity, float drag, boolean useAgeFactor) {
        this.optionMode6 = tex;
        this.vec3d = pos;
        this.factorValue = rotationSpeed;
        this.factorValue2 = scale;
        this.countValue = lifetime;
        this.vec3d2 = velocity;
        this.colorValue = color;
        this.factorValue3 = gravity;
        this.factorValue4 = drag;
        this.enabledFlag = useAgeFactor;
        this.countValue2 = this.countValue;
        this.vec3d3 = this.vec3d;
        this.countValue3 = RangeServiceComponent.f((ClosedRange) new IntRange(0, 3));
    }

    public TexRenderHelper(OptionMode6 arg0, Vec3d arg1, float arg2, float arg3, int arg4, Vec3d arg5, Color arg6, float arg7, float arg8, boolean arg9, int arg10, DefaultConstructorMarker arg11) {
        if ((arg10 & 64)) {
            arg6 = Color.BLACK;
        }
        if ((arg10 & 128)) {
            arg7 = 0.03F;
        }
        if ((arg10 & 256)) {
            arg8 = 0.99F;
        }
        if ((arg10 & 512)) {
            arg9 = 1;
        }
        this(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public OptionMode6 getOptionMode6() {
        return this.optionMode6;
    }

    public void executeAction(OptionMode6 value) {
        this.optionMode6 = value;
    }

    public Vec3d getMinecraftObject() {
        return this.vec3d;
    }

    public void executeAction(Vec3d value) {
        this.vec3d = value;
    }

    public float getNumericValue() {
        return this.factorValue2;
    }

    public void updateValue(float value) {
        this.factorValue2 = value;
    }

    public Vec3d getMinecraftObject2() {
        return this.vec3d2;
    }

    public void executeAction2(Vec3d value) {
        this.vec3d2 = value;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public void executeAction(Color value) {
        this.colorValue = value;
    }

    public boolean checkCondition() {
        int var4 = this.countValue;
        this.countValue = (var4 + -1);
        if (this.countValue < 0) {
            return true;
        }
        this.vec3d3 = this.vec3d;
        this.vec3d = this.vec3d.method_1019(this.vec3d2);
        this.vec3d2 = this.vec3d2.method_1021(this.factorValue4);
        this.vec3d2 = this.vec3d2.method_1031(0.0D, this.factorValue3, 0.0D);
        this.factorValue6 = this.factorValue5;
        this.factorValue5 = (this.factorValue5 + this.factorValue);
        return false;
    }

    public void render(MatrixStack matrices, Quaternionfc base, FormatRenderHelper polygon) {
        matrices.method_22903();
        float var30 = PolygonShaderComponent.INSTANCE.computeValue((this.countValue + 1.0F), this.countValue);
        if (this.enabledFlag) {
        } else {
        }
        float var31 = 1.0F;
        float var32 = (this.factorValue2 * var31);
        class_4184 var33 = SharedKt.getMc().field_1773.method_19418();
        if (Intrinsics.areEqual(this.colorValue, Color.BLACK)) {
        } else {
        }
        Color var34 = this.colorValue;
        Vec3d vec = TextShaderComponent2.resolveMinecraftObject(this.vec3d3, this.vec3d, 0.0F).method_1020(var33.method_71156());
        matrices.method_22904(vec.field_1352, vec.field_1351, vec.field_1350);
        RenderHelper4.render(matrices, base);
        if (0L >= 0) {
        }
        if (this.factorValue5 != 0.0F && this.factorValue6 != 0.0F) {
            RenderHelper4.render(matrices, (Quaternionfc) class_7833.field_40718.rotationDegrees(PolygonShaderComponent.INSTANCE.computeValue(this.factorValue6, this.factorValue5)));
        }
        Matrix4f var36 = matrices.method_23760().method_23761();
        if (!(this.enabledFlag)) {
        } else {
        }
        Color var37 = PolygonShaderComponent.INSTANCE.resolveColor();
        float var38 = this.optionMode6.getNumericValue();
        float var39 = this.optionMode6.getNumericValue3();
        float var40 = this.optionMode6.getNumericValue2();
        float var41 = this.optionMode6.getNumericValue4();
        matrices.method_22904((var32 / 2.0D), (var32 / 2.0D), -0.01D);
        polygon.resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper().resolveFormatRenderHelper();
        polygon.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper().resolveFormatRenderHelper();
        polygon.resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper().resolveFormatRenderHelper();
        polygon.resolveFormatRenderHelper(0.0F, 0.0F, 0.0F).resolveFormatRenderHelper().resolveFormatRenderHelper();
        matrices.method_22909();
        if (0L >= 0) {
        }
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
