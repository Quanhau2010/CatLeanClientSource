package su.catlean.client.services.player;

import kotlin.ranges.RangesKt;
import net.minecraft.class_3532;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.services.client.MoveFixServiceComponent;

public class TargetEntityHelper8 extends ZEROEntityHelper {

    public static final TargetEntityHelper8 INSTANCE;

    private TargetEntityHelper8() {
        super();
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Entity target, MoveFixServiceComponent currentRotation, boolean attackTick) {
        Vec3d vec = this.resolveMinecraftObject(target);
        double offset = class_3532.method_15338(((Math.toDegrees(Math.atan2((vec.field_1350 - SharedKt.getPlayer().getZ()), (vec.field_1352 - SharedKt.getPlayer().getX()))) - 90) - currentRotation.getNumericValue()));
        double offset2 = (Math.toDegrees(Math.atan2((vec.field_1351 - (EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((vec.field_1352 - SharedKt.getPlayer().getX()), (vec.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
        if (SharedKt.getPlayer().isFallFlying()) {
        } else {
        }
        double offset3 = 360.0D;
        if (!(attackTick)) {
            if (SharedKt.getPlayer().isFallFlying()) {
            } else {
            }
        }
        double offset4 = 180.0D;
        float factor = (currentRotation.getNumericValue() + Math.clamp(offset, offset3, offset3));
        float factor2 = ((currentRotation.getNumericValue2() + Math.clamp(offset2, offset4, offset4)) + Math.sin(Math.toRadians(offset)));
        return new MoveFixServiceComponent(factor, factor2, false);
    }

    public Vec3d resolveMinecraftObject(Entity target) {
        if (__UNDEF_KEY__ == null) {
            if (SharedKt.getPlayer().isFallFlying()) {
                return target.getEyePos();
            }
        }
        Box box = target.method_5829();
        return new Vec3d(RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1352, box.field_1323, box.field_1320), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1351, box.field_1322, box.field_1325), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1350, box.field_1321, box.field_1324));
    }

    static {
        INSTANCE = new TargetEntityHelper8();
    }

}
