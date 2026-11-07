package su.catlean.client.services.player;

import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import net.minecraft.class_3532;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.movement.basic.AntiKnockBackModule;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.network.VecPacketHelper;

public class TargetEntityHelper6 extends ZEROEntityHelper {

    public static final TargetEntityHelper6 INSTANCE;

    private TargetEntityHelper6() {
        super();
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Entity target, MoveFixServiceComponent currentRotation, boolean attackTick) {
        Vec3d vec = this.resolveMinecraftObject(target);
        double offset = (class_3532.method_15338(((Math.toDegrees(Math.atan2((vec.field_1350 - SharedKt.getPlayer().getZ()), (vec.field_1352 - SharedKt.getPlayer().getX()))) - 90) - currentRotation.getNumericValue())) + RangeServiceComponent.D(-1.0F, 1.0F, false));
        double offset2 = (Math.toDegrees(Math.atan2((vec.field_1351 - (AntiKnockBackModule.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((vec.field_1352 - SharedKt.getPlayer().getX()), (vec.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
        boolean flag = VecPacketHelper.INSTANCE.checkCondition(target, new MoveFixServiceComponent(currentRotation.getNumericValue(), currentRotation.getNumericValue2(), false), (AuraModule.INSTANCE.getAttackRange() + 2.0F), !(AuraModule.INSTANCE.getIgnoreWalls()));
        if (!(SharedKt.getPlayer().isFallFlying())) {
            if (flag) {
            } else {
            }
        } else {
        }
        double offset3 = 180.0D;
        if (!(SharedKt.getPlayer().isFallFlying())) {
            if (!((SharedKt.getPlayer().field_6012 % 25))) {
            } else {
            }
        } else {
        }
        double offset4 = 90.0D;
        if (Math.abs(offset) > 0.3D) {
        } else {
        }
        double offset5 = 0.0D;
        float factor = ((currentRotation.getNumericValue() + Math.clamp(offset5, offset3, offset3)) + (Math.sin(Math.toRadians((SharedKt.getPlayer().field_6012 * 20.0F))) * 0.5F));
        float factor2 = ((currentRotation.getNumericValue2() + Math.clamp(offset2, offset4, offset4)) + (Math.sin(Math.toRadians(factor)) * 1.5F));
        float factor3 = (factor - currentRotation.getNumericValue());
        double offset6 = Math.abs((MathKt.roundToInt(factor3) - factor3));
        if (offset6 < 1.0D) {
            factor = (factor + !((SharedKt.getPlayer().field_6012 % 2)));
        }
        return new MoveFixServiceComponent(factor, factor2, false);
    }

    public Vec3d resolveMinecraftObject(Entity target) {
        Box box = target.method_5829();
        return new Vec3d(RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1352, box.field_1323, box.field_1320), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1351, box.field_1322, box.field_1325), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1350, box.field_1321, box.field_1324));
    }

    static {
        INSTANCE = new TargetEntityHelper6();
    }

}
