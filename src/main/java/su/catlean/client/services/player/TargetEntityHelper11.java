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
        long var6 = (0L ^ 8549690578441L);
        long var8 = (0L ^ 33615733051039L);
        long var10 = (0L ^ 68997309831326L);
        long var12 = (0L ^ 118435926143872L);
        long var14 = (0L ^ 12961280391072L);
        long var16 = (0L ^ 38753063586444L);
        long var18 = (0L ^ 65801053811260L);
        long var20 = (0L ^ 76083599961676L);
        long var22 = (0L ^ 43306842265647L);
        int var25 = countValue;
        countValue = (var25 + 1);
        var25 = this.resolveMinecraftObject(target);
        float var26 = 0.0F;
        float var27 = (this.computeValue(0) + moveFixServiceComponent.getNumericValue2());
        if (attackTick) {
            if (0L > 0L) {
                if (SharedKt.getPlayer().getEyePos().method_1022(target.getEyePos()) > (AuraModule.INSTANCE.getAttackRange() + 0.3F)) {
                }
                if (countValue > 8) {
                    float var28 = RangeServiceComponent.D(25.0F, 45.0F);
                    float var29 = RangesKt.coerceIn(class_3532.method_15393(((this.computeValue(1) + SharedKt.getMc().field_1773.method_19418().method_19330()) - currentRotation.getNumericValue())));
                    return new MoveFixServiceComponent((currentRotation.getNumericValue() + var29));
                }
                var26 = (this.computeValue(1) + moveFixServiceComponent.getNumericValue());
            } else {
                countValue = 0;
            }
            var28 = class_3532.method_15338(((Math.toDegrees(Math.atan2((var25.field_1350 - SharedKt.getPlayer().getZ()), (var25.field_1352 - SharedKt.getPlayer().getX()))) - 90.0F) - currentRotation.getNumericValue()));
            var29 = (Math.toDegrees(Math.atan2((var25.field_1351 - (EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((var25.field_1352 - SharedKt.getPlayer().getX()), (var25.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
            var26 = (currentRotation.getNumericValue() + RangesKt.coerceIn(-95.0F, 95.0F));
            var27 = (currentRotation.getNumericValue2() + var29);
            moveFixServiceComponent = new MoveFixServiceComponent();
        }
        var28 = (SharedKt.getPlayer().field_6012 % 400);
        if (0L > 0L) {
            if (0 <= var28) {
            }
        } else {
        }
        if (var28 < 11) {
            var27 = ((-90.0F + (RangeServiceComponent.D(18.0F, 20.0F) * ((SharedKt.getPlayer().field_6012 % 400) / 10.0F))) + RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(-1.0F, 1.0F)));
        }
        return new MoveFixServiceComponent();
    }

    private float computeValue(boolean arg0) {
        if (arg0) {
            int var7 = SharedKt.getPlayer().field_6012;
            double var8 = (Math.sin() + RangeServiceComponent.computeValue(-0.1F, 0.1F, 0));
            return (var8 * 15.0F);
        }
        var7 = (SharedKt.getPlayer().field_6012 + 2.0F);
        var8 = Math.sin();
        double var9 = (0.2D * Math.sin((((0.4D * var7) * 0.7D) + 1.23D)));
        int var11 = (1 + (0.3D * Math.sin((((0.4D * var7) * 0.5D) + 2.45D))));
        double var13 = ((var11 * var8) + var9);
        return (var13 * 6.0F);
    }

    public Vec3d resolveMinecraftObject(Entity target) {
        Vec3d vec = target.method_5829().method_1005();
        return new Vec3d(vec.field_1352, vec.field_1351, vec.field_1350);
    }

    static {
        INSTANCE = new TargetEntityHelper11();
        moveFixServiceComponent = new MoveFixServiceComponent(0.0F, 0.0F);
    }

}
