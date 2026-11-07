package su.catlean.client.services.client;

import java.util.Optional;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.services.network.EventPacketHelper2;

public class InteractVecServiceComponent {

    public static final InteractVecServiceComponent INSTANCE;
    private static final Float[] floatArray;

    private InteractVecServiceComponent() {
    }

    public Float[] process() {
        return floatArray;
    }

    public boolean checkCondition(Vec3d pos, Vec3d interactVec) {
        Box var10 = new Box(pos.method_1023(1.0D, 0.0D, 1.0D), pos.method_1031(1.0D, 2.0D, 1.0D));
        double var11 = SharedKt.getPlayer().method_55755();
        double var23 = 0.0D;
        var23 = 1.7976931348623157E308D;
        Vec3d vec = interactVec.method_1020(SharedKt.getPlayer().getEyePos()).method_1029().method_1021();
        Vec3d vec2 = EventPacketHelper2.INSTANCE.resolveMinecraftObject();
        Float[] var15 = floatArray;
        int var16 = 0;
        Object var17 = var15;
        if (var16 < var17) {
            float var18 = var15[var16];
            Vec3d vec3 = vec2.method_1031(0.0D, 0.0D);
            Vec3d vec4 = vec3.method_1019(vec);
            if (!(var10.method_1006(vec4))) {
                if (var10.method_1006(vec3)) {
                }
                return true;
            }
            Optional var21 = var10.method_992(vec3, vec4);
            int var22 = 0;
            if (var21.isPresent()) {
                var23 = Math.min(vec3.method_1025((Vec3d) var21.get()));
            }
        }
        return var23 <= (var11 * var11);
    }

    public static boolean checkCondition(InteractVecServiceComponent arg0, Vec3d arg1, Vec3d arg2, int arg3, Object arg4) {
        if ((arg3 & 2)) {
            arg2 = arg1;
        }
        return arg0.checkCondition(arg1, arg2);
    }

    static {
        INSTANCE = new InteractVecServiceComponent();
        Float[] var11 = new Float[2];
        var11[0] = Float.valueOf(1.62F);
        var11[1] = Float.valueOf(0.4F);
        floatArray = var11;
    }

}
