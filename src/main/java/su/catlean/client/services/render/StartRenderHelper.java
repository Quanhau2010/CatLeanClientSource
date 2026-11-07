package su.catlean.client.services.render;

import java.awt.Color;
import net.minecraft.util.math.Vec3d;

public class StartRenderHelper {

    private final Vec3d vec3d;
    private final Vec3d vec3d2;
    private final Color colorValue;
    private final Color colorValue2;
    private final boolean enabledFlag;

    public StartRenderHelper(Vec3d start, Vec3d end, Color startColor, Color endColor, boolean ignoreFrustrum) {
        this.vec3d = start;
        this.vec3d2 = end;
        this.colorValue = startColor;
        this.colorValue2 = endColor;
        this.enabledFlag = ignoreFrustrum;
    }

    public Vec3d getMinecraftObject() {
        return this.vec3d;
    }

    public Vec3d getMinecraftObject2() {
        return this.vec3d2;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public Color getColor2() {
        return this.colorValue2;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

}
