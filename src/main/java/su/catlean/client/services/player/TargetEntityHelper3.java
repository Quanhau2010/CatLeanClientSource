package su.catlean.client.services.player;

import kotlin.ranges.RangesKt;
import net.minecraft.class_3532;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.services.client.MoveFixServiceComponent;

public class TargetEntityHelper3 extends ZEROEntityHelper {

    public static final TargetEntityHelper3 INSTANCE;
    private static int countValue;

    private TargetEntityHelper3() {
        super();
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Entity target, MoveFixServiceComponent currentRotation, boolean attackTick) {
        long var6 = ((0L ^ 74965760972846L) >>> 56);
        long var7 = (((0L ^ 74965760972846L) << 8) >>> 8);
        long var9 = (0L ^ 76083599961676L);
        long var11 = (0L ^ 38753063586444L);
        long var13 = (0L ^ 42077792783538L);
        long var15 = (0L ^ 43306842265647L);
        if (attackTick) {
            if (0L > 0L) {
                countValue = AuraModule.INSTANCE.checkCondition2();
            } else {
            }
            if (countValue > 0) {
                int var18 = countValue;
                countValue = (var18 + -1);
            }
        }
        var18 = this.resolveMinecraftObject(target);
        double var19 = class_3532.method_15338(((Math.toDegrees(Math.atan2((var18.field_1350 - SharedKt.getPlayer().getZ()), (var18.field_1352 - SharedKt.getPlayer().getX()))) - 90) - currentRotation.getNumericValue()));
        double var21 = (Math.toDegrees(Math.atan2((var18.field_1351 - (AuraModule.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((var18.field_1352 - SharedKt.getPlayer().getX()), (var18.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
        if (!(SharedKt.getPlayer().isFallFlying())) {
        } else {
        }
        double var23 = 180.0D;
        if (!(SharedKt.getPlayer().isFallFlying())) {
            if (!((SharedKt.getPlayer().field_6012 % 25))) {
            } else {
            }
        } else {
        }
        double var25 = 90.0D;
        float var27 = (currentRotation.getNumericValue() + RangesKt.coerceIn());
        float var29 = ((currentRotation.getNumericValue2() + RangesKt.coerceIn()) + Math.sin());
        if (countValue > 0) {
        } else {
        }
        return new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455());
    }

    public boolean isActive2() {
        return false;
    }

    static {
        INSTANCE = new TargetEntityHelper3();
    }

}
