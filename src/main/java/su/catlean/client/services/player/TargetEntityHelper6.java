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
        long var6 = ((0L ^ 74965760972846L) >>> 56);
        long var7 = (((0L ^ 74965760972846L) << 8) >>> 8);
        long var9 = (0L ^ 68997309831326L);
        long var11 = (0L ^ 29252912481339L);
        long var13 = (0L ^ 12961280391072L);
        long var15 = (0L ^ 38753063586444L);
        long var17 = (0L ^ 76083599961676L);
        long var19 = ((0L ^ 60568097754263L) >>> 32);
        long var20 = (((0L ^ 60568097754263L) << 32) >>> 48);
        long var21 = (((0L ^ 60568097754263L) << 48) >>> 48);
        long var22 = (0L ^ 31852927257017L);
        long var24 = (0L ^ 43306842265647L);
        Vec3d vec = this.resolveMinecraftObject(target);
        double var28 = (class_3532.method_15338(((Math.toDegrees(Math.atan2((vec.field_1350 - SharedKt.getPlayer().getZ()), (vec.field_1352 - SharedKt.getPlayer().getX()))) - 90) - currentRotation.getNumericValue())) + RangeServiceComponent.D(-1.0F, 1.0F));
        double var30 = (Math.toDegrees(Math.atan2((vec.field_1351 - (AntiKnockBackModule.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((vec.field_1352 - SharedKt.getPlayer().getX()), (vec.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
        boolean var32 = VecPacketHelper.INSTANCE.checkCondition(target, new MoveFixServiceComponent(currentRotation.getNumericValue(), currentRotation.getNumericValue2()), (AuraModule.INSTANCE.getAttackRange() + 2.0F), !(AuraModule.INSTANCE.getIgnoreWalls()));
        if (0L >= 0L) {
            if (!(SharedKt.getPlayer().isFallFlying())) {
            }
            if (var32) {
            } else {
            } else {
            }
        }
        double var33 = 180.0D;
        if (!(SharedKt.getPlayer().isFallFlying())) {
            if (!((SharedKt.getPlayer().field_6012 % 25))) {
            } else {
            }
        } else {
        }
        double var35 = 90.0D;
        if (Math.abs() > 0.3D) {
        } else {
        }
        double var37 = 0.0D;
        float var39 = ((currentRotation.getNumericValue() + Math.clamp()) + (Math.sin(Math.toRadians((SharedKt.getPlayer().field_6012 * 20.0F))) * 0.5F));
        float var41 = ((currentRotation.getNumericValue2() + Math.clamp()) + (Math.sin(Math.toRadians()) * 1.5F));
        double var43 = (var39 - currentRotation.getNumericValue());
        double var45 = Math.abs((MathKt.roundToInt() - var43));
        if (0L > 0L) {
            if (var45 < 1.0D) {
            }
            var39 = (var39 + !((SharedKt.getPlayer().field_6012 % 2)));
        }
        if (0L > 0L) {
        }
        return new MoveFixServiceComponent();
    }

    public Vec3d resolveMinecraftObject(Entity target) {
        long var4 = (0L ^ 108103236449891L);
        Box var6 = target.method_5829();
        return new Vec3d(RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1352, var6.field_1323, var6.field_1320), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1351, var6.field_1322, var6.field_1325), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1350, var6.field_1321, var6.field_1324));
    }

    static {
        INSTANCE = new TargetEntityHelper6();
    }

}
