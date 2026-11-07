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
        long var6 = (0L ^ 33615733051039L);
        long var8 = (0L ^ 76083599961676L);
        long var10 = (0L ^ 38753063586444L);
        long var12 = (0L ^ 43306842265647L);
        Vec3d vec = this.resolveMinecraftObject(target);
        double var16 = class_3532.method_15338(((Math.toDegrees(Math.atan2((vec.field_1350 - SharedKt.getPlayer().getZ()), (vec.field_1352 - SharedKt.getPlayer().getX()))) - 90) - currentRotation.getNumericValue()));
        double var18 = (Math.toDegrees(Math.atan2((vec.field_1351 - (EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((vec.field_1352 - SharedKt.getPlayer().getX()), (vec.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
        if (SharedKt.getPlayer().isFallFlying()) {
        } else {
        }
        double var20 = 360.0D;
        if (0L >= 0L) {
            if (!(attackTick)) {
            }
            if (SharedKt.getPlayer().isFallFlying()) {
            }
        } else {
        }
        double var22 = 180.0D;
        float var24 = (currentRotation.getNumericValue() + Math.clamp());
        float var26 = ((currentRotation.getNumericValue2() + Math.clamp()) + Math.sin(Math.toRadians()));
        return new MoveFixServiceComponent();
    }

    public Vec3d resolveMinecraftObject(Entity target) {
        long var4 = (0L ^ 108103236449891L);
        if (var6 == null) {
            if (SharedKt.getPlayer().isFallFlying()) {
                return target.getEyePos();
            }
        }
        Box var7 = target.method_5829();
        return new Vec3d(RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1352, var7.field_1323, var7.field_1320), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1351, var7.field_1322, var7.field_1325), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1350, var7.field_1321, var7.field_1324));
    }

    static {
        INSTANCE = new TargetEntityHelper8();
    }

}
