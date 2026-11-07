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
        long var6 = (0L ^ 8549690578441L);
        long var8 = (0L ^ 76083599961676L);
        long var10 = (0L ^ 68997309831326L);
        long var12 = (0L ^ 38753063586444L);
        long var14 = ((0L ^ 60568097754263L) >>> 32);
        long var15 = (((0L ^ 60568097754263L) << 32) >>> 48);
        long var16 = (((0L ^ 60568097754263L) << 48) >>> 48);
        long var17 = (0L ^ 31852927257017L);
        long var19 = (0L ^ 36353052440722L);
        long var21 = (0L ^ 43306842265647L);
        Vec3d vec = this.resolveMinecraftObject(target);
        double var25 = class_3532.method_15338(((Math.toDegrees(Math.atan2((vec.field_1350 - SharedKt.getPlayer().getZ()), (vec.field_1352 - SharedKt.getPlayer().getX()))) - 90.0F) - currentRotation.getNumericValue()));
        double var27 = (Math.toDegrees(Math.atan2((vec.field_1351 - SharedKt.getPlayer().getEyePos().field_1351), Math.hypot((vec.field_1352 - SharedKt.getPlayer().getX()), (vec.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
        float var29 = (currentRotation.getNumericValue() + var25);
        float var30 = ((currentRotation.getNumericValue2() + var27) + Math.sin());
        if (!(attackTick)) {
            var29 = SharedKt.getPlayer().method_36454();
            var30 = SharedKt.getPlayer().method_36455();
        }
        if (AuraModule.INSTANCE.getPriorityManual() && VecPacketHelper.INSTANCE.checkCondition(AuraModule.INSTANCE.getTarget(), currentRotation, AuraModule.INSTANCE.getAttackRange(), !(AuraModule.INSTANCE.getIgnoreWalls()))) {
            return new MoveFixServiceComponent(SharedKt.getMc().field_1773.method_19418().method_19330(), SharedKt.getMc().field_1773.method_19418().method_19329());
        }
        return new MoveFixServiceComponent();
    }

    public boolean isActive2() {
        return false;
    }

    public Vec3d resolveMinecraftObject(Entity target) {
        long var4 = (0L ^ 108103236449891L);
        Box var6 = target.method_5829();
        return new Vec3d(RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1352, var6.field_1323, var6.field_1320), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1351, var6.field_1322, var6.field_1325), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1350, var6.field_1321, var6.field_1324));
    }

    static {
        INSTANCE = new TargetEntityHelper7();
    }

}
