package su.catlean.client.services.player;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.services.client.MoveFixServiceComponent;

public class TargetEntityHelper5 extends ZEROEntityHelper {

    public static final TargetEntityHelper5 INSTANCE;

    private TargetEntityHelper5() {
        super();
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Entity target, MoveFixServiceComponent currentRotation, boolean attackTick) {
        return new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455(), false);
    }

    public Vec3d resolveMinecraftObject(Entity target) {
        return target.getEyePos();
    }

    public boolean isActive() {
        return false;
    }

    public boolean isActive2() {
        return false;
    }

    static {
        INSTANCE = new TargetEntityHelper5();
    }

}
