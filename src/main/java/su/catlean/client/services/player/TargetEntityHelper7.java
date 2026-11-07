package su.catlean.client.services.player;

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
import su.catlean.client.services.network.VecPacketHelper;

public class TargetEntityHelper7 extends ZEROEntityHelper {

    public static final TargetEntityHelper7 INSTANCE;

    private TargetEntityHelper7() {
        super();
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Entity target, MoveFixServiceComponent currentRotation, boolean attackTick) {
        Vec3d vec = this.resolveMinecraftObject(target);
        double offset = class_3532.method_15338(((Math.toDegrees(Math.atan2((vec.field_1350 - SharedKt.getPlayer().getZ()), (vec.field_1352 - SharedKt.getPlayer().getX()))) - 90.0F) - currentRotation.getNumericValue()));
        double offset2 = (Math.toDegrees(Math.atan2((vec.field_1351 - SharedKt.getPlayer().getEyePos().field_1351), Math.hypot((vec.field_1352 - SharedKt.getPlayer().getX()), (vec.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
        float factor = (currentRotation.getNumericValue() + offset);
        float factor2 = ((currentRotation.getNumericValue2() + offset2) + Math.sin(offset));
        if (!(attackTick)) {
            factor = SharedKt.getPlayer().method_36454();
            factor2 = SharedKt.getPlayer().method_36455();
        }
        if (AuraModule.INSTANCE.getPriorityManual() && VecPacketHelper.INSTANCE.checkCondition(AuraModule.INSTANCE.getTarget(), currentRotation, AuraModule.INSTANCE.getAttackRange(), !(AuraModule.INSTANCE.getIgnoreWalls()))) {
            return new MoveFixServiceComponent(SharedKt.getMc().field_1773.method_19418().method_19330(), SharedKt.getMc().field_1773.method_19418().method_19329(), false);
        }
        return new MoveFixServiceComponent(factor, factor2, false);
    }

    public boolean isActive2() {
        return false;
    }

    public Vec3d resolveMinecraftObject(Entity target) {
        Box box = target.method_5829();
        return new Vec3d(RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1352, box.field_1323, box.field_1320), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1351, box.field_1322, box.field_1325), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1350, box.field_1321, box.field_1324));
    }

    static {
        INSTANCE = new TargetEntityHelper7();
    }

}
