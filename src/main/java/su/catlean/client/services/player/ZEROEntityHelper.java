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
        long var4 = (0L ^ 100744130797779L);
        long var6 = (0L ^ 108103236449891L);
        if (SharedKt.getPlayer().isFallFlying()) {
            return target.getEyePos();
        }
        if (0L > 0L) {
            if (!((SharedKt.getPlayer().field_6012 % -5005149948098903964L))) {
                double var9 = (PolygonShaderComponent.INSTANCE.computeValue(-0.1D, 0.1D, Math.random()) * 0.1D);
                this.vec3d = new Vec3d();
            }
        }
        if (0L >= 0L) {
            if (!(var8)) {
            }
        }
        return EntityHelper.resolveMinecraftObject(target).method_1031(this.vec3d.field_1352, ((target.method_17682() / 2.0D) + this.vec3d.field_1351), this.vec3d.field_1350);
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
