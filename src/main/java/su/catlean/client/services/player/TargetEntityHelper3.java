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
        if (attackTick) {
            countValue = AuraModule.INSTANCE.checkCondition2();
        } else {
            if (countValue > 0) {
                int index = countValue;
                countValue = (index + -1);
            }
        }
        index = this.resolveMinecraftObject(target);
        double offset = class_3532.method_15338(((Math.toDegrees(Math.atan2((index.field_1350 - SharedKt.getPlayer().getZ()), (index.field_1352 - SharedKt.getPlayer().getX()))) - 90) - currentRotation.getNumericValue()));
        double offset2 = (Math.toDegrees(Math.atan2((index.field_1351 - (AuraModule.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((index.field_1352 - SharedKt.getPlayer().getX()), (index.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
        if (!(SharedKt.getPlayer().isFallFlying())) {
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
        float factor = (currentRotation.getNumericValue() + RangesKt.coerceIn(offset, offset3, offset3));
        float factor2 = ((currentRotation.getNumericValue2() + RangesKt.coerceIn(offset2, offset4, offset4)) + Math.sin(offset));
        if (countValue > 0) {
        } else {
        }
        return new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455(), false);
    }

    public boolean isActive2() {
        return false;
    }

    static {
        INSTANCE = new TargetEntityHelper3();
    }

}
