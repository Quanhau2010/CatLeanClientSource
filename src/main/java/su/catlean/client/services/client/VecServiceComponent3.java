package su.catlean.client.services.client;

import net.minecraft.util.math.Vec3d;
import su.catlean.client.features.modules.Module;

public class VecServiceComponent3 {

    private final Vec3d vec3d;
    private final float factorValue;
    private final float factorValue2;
    private final ServiceComponent10 serviceComponent10;
    private static Module[] moduleArray;

    public VecServiceComponent3(Vec3d vec, float yaw, float pitch, ServiceComponent10 life) {
        this.vec3d = vec;
        this.factorValue = yaw;
        this.factorValue2 = pitch;
        this.serviceComponent10 = life;
    }

    public Vec3d getMinecraftObject() {
        return this.vec3d;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public ServiceComponent10 getServiceComponent10() {
        return this.serviceComponent10;
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
