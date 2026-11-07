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
        Box box = new Box(pos.method_1023(1.0D, 0.0D, 1.0D), pos.method_1031(1.0D, 2.0D, 1.0D));
        double offset = SharedKt.getPlayer().method_55755();
        double offset2 = 0.0D;
        offset2 = 1.7976931348623157E308D;
        Vec3d vec = interactVec.method_1020(SharedKt.getPlayer().getEyePos()).method_1029().method_1021(offset);
        Vec3d vec2 = EventPacketHelper2.INSTANCE.resolveMinecraftObject();
        int index = 0;
        if (index < floatArray) {
            float factor = floatArray[index];
            Vec3d vec3 = vec2.method_1031(0.0D, factor, 0.0D);
            Vec3d vec4 = vec3.method_1019(vec);
            if (!(box.method_1006(vec4))) {
                if (box.method_1006(vec3)) {
                    return true;
                }
            }
            Optional optional = box.method_992(vec3, vec4);
            if (optional.isPresent()) {
                offset2 = Math.min(offset2, vec3.method_1025(((Vec3d) optional.get())));
            }
        }
        return offset2 <= (offset * offset);
    }

    public static boolean checkCondition(InteractVecServiceComponent arg0, Vec3d arg1, Vec3d arg2, int arg3, Object arg4) {
        if ((arg3 & 2) != 0) {
        }
        return arg0.checkCondition(arg1, arg1);
    }

    static {
        INSTANCE = new InteractVecServiceComponent();
        Float[] items = new Float[2];
        items[0] = Float.valueOf(1.62F);
        items[1] = Float.valueOf(0.4F);
        floatArray = items;
    }

}
