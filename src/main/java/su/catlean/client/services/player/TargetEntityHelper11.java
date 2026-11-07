package su.catlean.client.services.player;

import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_757;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RangeServiceComponent;

public class TargetEntityHelper11 extends ZEROEntityHelper {

    public static final TargetEntityHelper11 INSTANCE;
    private static int countValue;
    private static MoveFixServiceComponent moveFixServiceComponent;

    private TargetEntityHelper11() {
        super();
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Entity target, MoveFixServiceComponent currentRotation, boolean attackTick) {
        int index = countValue;
        countValue = (index + 1);
        index = this.resolveMinecraftObject(target);
        float factor = 0.0F;
        float factor2 = (this.computeValue(false) + moveFixServiceComponent.getNumericValue2());
        if (attackTick) {
            if (SharedKt.getPlayer().getEyePos().method_1022(target.getEyePos()) > (AuraModule.INSTANCE.getAttackRange() + 0.3F)) {
                if (countValue > 8) {
                    float factor3 = RangeServiceComponent.D(25.0F, 45.0F, false);
                    float factor4 = RangesKt.coerceIn(class_3532.method_15393(((this.computeValue(true) + SharedKt.getMc().field_1773.method_19418().method_19330()) - currentRotation.getNumericValue())), factor3, factor3);
                    return new MoveFixServiceComponent((currentRotation.getNumericValue() + factor4), factor2, false);
                }
                factor = (this.computeValue(true) + moveFixServiceComponent.getNumericValue());
            } else {
                countValue = 0;
                factor3 = class_3532.method_15338(((Math.toDegrees(Math.atan2((index.field_1350 - SharedKt.getPlayer().getZ()), (index.field_1352 - SharedKt.getPlayer().getX()))) - 90.0F) - currentRotation.getNumericValue()));
                factor4 = (Math.toDegrees(Math.atan2((index.field_1351 - (EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((index.field_1352 - SharedKt.getPlayer().getX()), (index.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
                factor = (currentRotation.getNumericValue() + RangesKt.coerceIn(factor3, -95.0F, 95.0F));
                factor2 = (currentRotation.getNumericValue2() + factor4);
                moveFixServiceComponent = new MoveFixServiceComponent(factor, factor2, false);
            }
        }
        factor3 = (SharedKt.getPlayer().field_6012 % 400);
        if (0 <= factor3) {
        } else {
            if (factor3 < 11) {
                factor2 = ((-90.0F + (RangeServiceComponent.D(18.0F, 20.0F, false) * ((SharedKt.getPlayer().field_6012 % 400) / 10.0F))) + RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(-1.0F, 1.0F)), false));
            }
        }
        return new MoveFixServiceComponent(factor, factor2, false);
    }

    private float computeValue(boolean arg0) {
        if (arg0) {
            int index = SharedKt.getPlayer().field_6012;
            double offset = (Math.sin(index) + RangeServiceComponent.computeValue(-0.1F, 0.1F, false));
            return (offset * 15.0F);
        }
        index = (SharedKt.getPlayer().field_6012 + 2.0F);
        offset = Math.sin(index);
        double offset2 = (0.2D * Math.sin((((0.4D * index) * 0.7D) + 1.23D)));
        int index2 = (1 + (0.3D * Math.sin((((0.4D * index) * 0.5D) + 2.45D))));
        int index3 = ((index2 * offset) + offset2);
        return (index3 * 6.0F);
    }

    public Vec3d resolveMinecraftObject(Entity target) {
        Vec3d vec = target.method_5829().method_1005();
        return new Vec3d(vec.field_1352, vec.field_1351, vec.field_1350);
    }

    static {
        INSTANCE = new TargetEntityHelper11();
        moveFixServiceComponent = new MoveFixServiceComponent(0.0F, 0.0F, false);
    }

}
