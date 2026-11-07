package su.catlean.client.services.render;

import java.awt.Color;
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
        this.countValue3 = RangeServiceComponent.f(((ClosedRange) new IntRange(0, 3)), false);
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
        int index = this.countValue;
        this.countValue = (index + -1);
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
        float factor = PolygonShaderComponent.INSTANCE.computeValue((this.countValue + 1.0F), this.countValue);
        if (this.enabledFlag) {
        } else {
        }
        float factor2 = 1.0F;
        float factor3 = (this.factorValue2 * factor2);
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        if (Intrinsics.areEqual(this.colorValue, Color.BLACK)) {
        } else {
        }
        Color color = this.colorValue;
        Vec3d vec = TextShaderComponent2.resolveMinecraftObject(this.vec3d3, this.vec3d, 0.0F).method_1020(class4184.method_71156());
        matrices.method_22904(vec.field_1352, vec.field_1351, vec.field_1350);
        RenderHelper4.render(matrices, base);
        if (__UNDEF_KEY__ >= 0) {
        }
        if (this.factorValue5 != 0.0F && this.factorValue6 != 0.0F) {
            RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40718.rotationDegrees(PolygonShaderComponent.INSTANCE.computeValue(this.factorValue6, this.factorValue5))));
        }
        Matrix4f matrix4f = matrices.method_23760().method_23761();
        if (!(this.enabledFlag)) {
        } else {
        }
        Color color2 = PolygonShaderComponent.INSTANCE.resolveColor(color, factor2);
        float factor4 = this.optionMode6.getNumericValue();
        float factor5 = this.optionMode6.getNumericValue3();
        float factor6 = this.optionMode6.getNumericValue2();
        float factor7 = this.optionMode6.getNumericValue4();
        matrices.method_22904((factor3 / 2.0D), (factor3 / 2.0D), -0.01D);
        polygon.resolveFormatRenderHelper(matrix4f, 0.0F, factor3, 0.0F).resolveFormatRenderHelper(factor5, factor6).resolveFormatRenderHelper(color2);
        polygon.resolveFormatRenderHelper(matrix4f, factor3, factor3, 0.0F).resolveFormatRenderHelper(factor4, factor6).resolveFormatRenderHelper(color2);
        polygon.resolveFormatRenderHelper(matrix4f, factor3, 0.0F, 0.0F).resolveFormatRenderHelper(factor4, factor7).resolveFormatRenderHelper(color2);
        polygon.resolveFormatRenderHelper(matrix4f, 0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(factor5, factor7).resolveFormatRenderHelper(color2);
        matrices.method_22909();
        if (__UNDEF_KEY__ >= 0) {
        }
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
