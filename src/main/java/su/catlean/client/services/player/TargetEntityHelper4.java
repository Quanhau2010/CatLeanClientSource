package su.catlean.client.services.player;

import net.minecraft.class_3532;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.VecPacketHelper;

public class TargetEntityHelper4 extends ZEROEntityHelper {

    public static final TargetEntityHelper4 INSTANCE;

    private TargetEntityHelper4() {
        super();
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Entity target, MoveFixServiceComponent currentRotation, boolean attackTick) {
        Vec3d vec = this.resolveMinecraftObject(target);
        target.method_5857(target.method_5829().method_1009(-0.15D, 0.0D, -0.15D));
        boolean flag = VecPacketHelper.INSTANCE.checkCondition(target, new MoveFixServiceComponent(EventPacketHelper2.INSTANCE.computeValue(), EventPacketHelper2.INSTANCE.computeValue2(), false), (AuraModule.INSTANCE.getAttackRange() + 2.0F), !(AuraModule.INSTANCE.getIgnoreWalls()));
        target.method_5857(target.method_5829().method_1009(0.15D, 0.0D, 0.15D));
        double offset = (class_3532.method_15338(((Math.toDegrees(Math.atan2((vec.field_1350 - SharedKt.getPlayer().getZ()), (vec.field_1352 - SharedKt.getPlayer().getX()))) - 90) - currentRotation.getNumericValue())) + RangeServiceComponent.D(-1.0F, 1.0F, false));
        double offset2 = (Math.toDegrees(Math.atan2((vec.field_1351 - (EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((vec.field_1352 - SharedKt.getPlayer().getX()), (vec.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
        if (!(SharedKt.getPlayer().isFallFlying()) && AuraModule.INSTANCE.getAttackRange() < 4.0D) {
            if (flag) {
            } else {
            }
        } else {
        }
        double offset3 = 360.0D;
        if (!(SharedKt.getPlayer().isFallFlying()) && AuraModule.INSTANCE.getAttackRange() < 4.0D) {
            if (!((SharedKt.getPlayer().field_6012 % 25))) {
            } else {
            }
        } else {
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
        double offset = ((target.method_5829().method_17939() / 2.1D) * Math.sin(Math.toRadians(target.field_6012)));
        double offset2 = ((target.method_5829().method_17940() / 8) * Math.sin(Math.toRadians((target.field_6012 + 10.0D))));
        double offset3 = ((target.method_5829().method_17941() / 2.1D) * Math.cos(Math.toRadians(target.field_6012)));
        return EntityHelper.resolveMinecraftObject(target).method_1031(offset, ((target.method_17682() / 2.0D) + offset2), offset3);
    }

    static {
        INSTANCE = new TargetEntityHelper4();
    }

}
