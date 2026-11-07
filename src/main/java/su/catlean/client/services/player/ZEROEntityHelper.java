package su.catlean.client.services.player;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public abstract class ZEROEntityHelper {

    private Vec3d vec3d;
    private static int countValue;

    public ZEROEntityHelper() {
        this.vec3d = Vec3d.ZERO;
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Entity arg0, MoveFixServiceComponent arg1, boolean arg2) {
    }

    public Vec3d resolveMinecraftObject(Entity target) {
        if (SharedKt.getPlayer().isFallFlying()) {
            return target.getEyePos();
        }
        if (!((SharedKt.getPlayer().field_6012 % 100))) {
            double offset = (PolygonShaderComponent.INSTANCE.computeValue(-0.1D, 0.1D, Math.random()) * 0.1D);
            this.vec3d = new Vec3d(offset, offset, offset);
        }
        return null;
    }

    public boolean isActive() {
        return true;
    }

    public boolean isActive2() {
        return true;
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 17;
        return 0;
    }

}
