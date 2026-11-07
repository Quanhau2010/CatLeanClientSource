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
        long var6 = (0L ^ 33615733051039L);
        long var8 = (0L ^ 45747537906684L);
        long var10 = (0L ^ 68997309831326L);
        long var12 = (0L ^ 29252912481339L);
        long var14 = (0L ^ 78446270612881L);
        long var16 = (0L ^ 38753063586444L);
        long var18 = (0L ^ 12961280391072L);
        long var20 = ((0L ^ 60568097754263L) >>> 32);
        long var21 = (((0L ^ 60568097754263L) << 32) >>> 48);
        long var22 = (((0L ^ 60568097754263L) << 48) >>> 48);
        long var23 = (0L ^ 76083599961676L);
        long var25 = (0L ^ 31852927257017L);
        long var27 = (0L ^ 43306842265647L);
        Vec3d vec = this.resolveMinecraftObject(target);
        target.method_5857(target.method_5829().method_1009(-0.15D, 0.0D, -0.15D));
        boolean var31 = VecPacketHelper.INSTANCE.checkCondition(target, new MoveFixServiceComponent(EventPacketHelper2.INSTANCE.computeValue(), EventPacketHelper2.INSTANCE.computeValue2()), (AuraModule.INSTANCE.getAttackRange() + 2.0F), !(AuraModule.INSTANCE.getIgnoreWalls()));
        target.method_5857(target.method_5829().method_1009(0.15D, 0.0D, 0.15D));
        double var32 = (class_3532.method_15338(((Math.toDegrees(Math.atan2((vec.field_1350 - SharedKt.getPlayer().getZ()), (vec.field_1352 - SharedKt.getPlayer().getX()))) - 90) - currentRotation.getNumericValue())) + RangeServiceComponent.D(-1.0F, 1.0F));
        double var34 = (Math.toDegrees(Math.atan2((vec.field_1351 - (EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((vec.field_1352 - SharedKt.getPlayer().getX()), (vec.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
        if (0L > 0L) {
            if (var29 == null) {
            }
            if (0L >= 0L) {
            }
            if (!(SharedKt.getPlayer().isFallFlying()) && AuraModule.INSTANCE.getAttackRange() < 4.0D) {
            }
            if (var31) {
            } else {
            } else {
            }
        }
        double var36 = 360.0D;
        if (0L >= 0L) {
            if (0L >= 0L) {
                if (var29 == null) {
                }
                if (!(SharedKt.getPlayer().isFallFlying()) && AuraModule.INSTANCE.getAttackRange() < 4.0D) {
                }
            }
            if (!((SharedKt.getPlayer().field_6012 % 25))) {
            } else {
            }
        } else {
        }
        double var38 = 180.0D;
        float var40 = (currentRotation.getNumericValue() + Math.clamp());
        float var42 = ((currentRotation.getNumericValue2() + Math.clamp()) + Math.sin(Math.toRadians()));
        return new MoveFixServiceComponent();
    }

    public Vec3d resolveMinecraftObject(Entity target) {
        long var4 = (0L ^ 100744130797779L);
        long var6 = (0L ^ 108103236449891L);
        if (var8 == null) {
            if (SharedKt.getPlayer().isFallFlying()) {
                return target.getEyePos();
            }
        }
        double var9 = ((target.method_5829().method_17939() / 2.1D) * Math.sin(Math.toRadians(target.field_6012)));
        double var11 = ((target.method_5829().method_17940() / 8) * Math.sin(Math.toRadians((target.field_6012 + 10.0D))));
        double var13 = ((target.method_5829().method_17941() / 2.1D) * Math.cos(Math.toRadians(target.field_6012)));
        return EntityHelper.resolveMinecraftObject(target).method_1031(((target.method_17682() / 2.0D) + var11));
    }

    static {
        INSTANCE = new TargetEntityHelper4();
    }

}
