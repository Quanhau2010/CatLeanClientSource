package su.catlean.client.services.client;

import kotlin.ranges.RangesKt;
import net.minecraft.class_10055;
import net.minecraft.class_2960;
import net.minecraft.class_591;
import net.minecraft.util.math.Vec3d;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class ModelServiceComponent {

    private final class_591 minecraftRef;
    private final class_10055 minecraftRef2;
    private Vec3d vec3d;
    private final class_2960 minecraftRef3;
    private float factorValue;
    private float factorValue2;
    private Vec3d vec3d2;
    private static String[] textValueArray;

    public ModelServiceComponent(class_591 model, class_10055 state, Vec3d pos, class_2960 texture, float alpha) {
        this.minecraftRef = model;
        this.minecraftRef2 = state;
        this.vec3d = pos;
        this.minecraftRef3 = texture;
        this.factorValue = alpha;
        this.factorValue2 = this.factorValue;
        this.vec3d2 = this.vec3d;
    }

    public class_591 getMinecraftObject() {
        return this.minecraftRef;
    }

    public class_10055 getMinecraftObject() {
        return this.minecraftRef2;
    }

    public Vec3d getMinecraftObject() {
        return this.vec3d;
    }

    public void executeAction(Vec3d value) {
        this.vec3d = value;
    }

    public class_2960 getMinecraftObject() {
        return this.minecraftRef3;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public boolean checkCondition(float aSpeed, float ySpeed) {
        if (this.factorValue <= 0.0F) {
            return true;
        }
        this.factorValue2 = this.factorValue;
        this.factorValue = (this.factorValue - aSpeed);
        this.vec3d2 = this.vec3d;
        this.vec3d = new Vec3d(this.vec3d.field_1352, (this.vec3d.field_1351 + ySpeed), this.vec3d.field_1350);
        return false;
    }

    public float computeValue() {
        if ((RangesKt.coerceIn(PolygonShaderComponent.INSTANCE.computeValue(this.factorValue2, this.factorValue, TextShaderComponent2.INSTANCE.computeValue()), 0.0F, 255.0F) / 255.0F) != null) {
        }
        return null;
    }

    public Vec3d resolveMinecraftObject() {
        return TextShaderComponent2.INSTANCE.resolveMinecraftObject(this.vec3d2, this.vec3d, TextShaderComponent2.INSTANCE.computeValue());
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
