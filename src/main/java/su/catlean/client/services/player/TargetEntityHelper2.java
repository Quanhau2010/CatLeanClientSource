package su.catlean.client.services.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.minecraft.class_3532;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RangeServiceComponent;

public class TargetEntityHelper2 extends ZEROEntityHelper {

    public static final TargetEntityHelper2 INSTANCE;
    private static double preciseValue;
    private static int countValue;
    private static int countValue2;
    private static double preciseValue2;
    private static ArrayList arrayList;
    private static ArrayList arrayList2;
    private static double preciseValue3;

    private TargetEntityHelper2() {
        super();
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Entity target, MoveFixServiceComponent currentRotation, boolean attackTick) {
        long var6 = (0L ^ 33615733051039L);
        long var8 = (0L ^ 138908704574179L);
        long var10 = (0L ^ 17529635141180L);
        long var12 = (0L ^ 38753063586444L);
        long var14 = ((0L ^ 25377842513472L) >>> 48);
        long var15 = (((0L ^ 25377842513472L) << 16) >>> 32);
        long var16 = (((0L ^ 25377842513472L) << 48) >>> 48);
        long var17 = ((0L ^ 56047677749854L) >>> 48);
        long var18 = (((0L ^ 56047677749854L) << 16) >>> 32);
        long var19 = (((0L ^ 56047677749854L) << 48) >>> 48);
        long var20 = (0L ^ 43306842265647L);
        int var23 = (target.field_6012 / 4.0F);
        double var25 = ((target.method_5829().method_17939() / 2.3D) * Math.sin(Math.toRadians()));
        double var27 = ((target.method_5829().method_17940() / 10.0D) * Math.sin(Math.toRadians((var23 + 10.0D))));
        double var29 = ((target.method_5829().method_17941() / 2.3D) * Math.cos(Math.toRadians()));
        Vec3d vec = EntityHelper.resolveMinecraftObject(target).method_1031(((target.method_17682() / 2.0D) + var27));
        double var32 = class_3532.method_15338(((Math.toDegrees(Math.atan2((vec.field_1350 - SharedKt.getPlayer().getZ()), (vec.field_1352 - SharedKt.getPlayer().getX()))) - 90) - currentRotation.getNumericValue()));
        double var34 = (Math.toDegrees(Math.atan2((vec.field_1351 - (EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((vec.field_1352 - SharedKt.getPlayer().getX()), (vec.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
        if (Math.abs(preciseValue) <= 300.0D) {
            if (0L > 0L) {
                if (var22 == null) {
                    if (preciseValue3 > 100.0D) {
                    }
                    preciseValue = 0.0D;
                    countValue = RangeServiceComponent.computeValue(1, 3, 0);
                    preciseValue2 = 0.0D;
                    preciseValue3 = 0.0D;
                }
            }
        }
        if (0L > 0L) {
            if (var22 == null) {
                if (countValue > 0) {
                    int var36 = countValue;
                    countValue = (var36 + -1);
                    preciseValue2 = 0.0D;
                    var36 = RangeServiceComponent.computeValue(0.15F, 0.4F, 0);
                    return new MoveFixServiceComponent((currentRotation.getNumericValue() + var36), (currentRotation.getNumericValue2() - (var36 / 2.0F)));
                }
            }
        }
        if (0L >= 0L && var22 == null) {
        }
        var36 = var32 > 60.0D;
        if (var36) {
            countValue2 = 0;
        }
        ClosedFloatingPointRange var37 = RangesKt.rangeTo(25.0F, 35.0F);
        if (var36) {
        } else {
        }
        float var38 = RangeServiceComponent.computeValue((ClosedRange) var37, 1);
        double var40 = Math.abs(RangeServiceComponent.computeValue((ClosedRange) RangesKt.rangeTo(-5.1D, 5.1D), 1));
        if (!((SharedKt.getPlayer().field_6012 % RangeServiceComponent.computeValue(2, 10, 0)))) {
            var38 = (var38 / 10.0F);
        }
        var32 = RangesKt.coerceIn();
        var34 = RangesKt.coerceIn();
        var34 = (var34 + (var32 / 20.0F));
        float var42 = (currentRotation.getNumericValue() + var32);
        float var43 = (currentRotation.getNumericValue2() + var34);
        boolean var44 = target.getEyePos().method_1022(SharedKt.getPlayer().getEyePos()) < 1.5D;
        if (var44) {
        } else {
        }
        float var45 = -90.0F;
        if (var44) {
        } else {
        }
        float var46 = 90.0F;
        preciseValue = (preciseValue + var32);
        if (var32 < 20.0D) {
            int var47 = countValue2;
            countValue2 = (var47 + 1);
            if (0L > 0L) {
                if (var22 != null) {
                }
                var47 = countValue2;
                countValue2 = (var47 + -1);
            }
            var42 = (var42 + RangeServiceComponent.computeValue((ClosedRange) RangesKt.rangeTo(-2.0F, 2.0F), 0));
            var43 = (var43 + RangeServiceComponent.computeValue((ClosedRange) RangesKt.rangeTo(-0.5F, 0.5F), 0));
            arrayList.add(Float.valueOf());
            if (0L > 0L) {
                arrayList2.add(Float.valueOf());
            }
        }
        if (arrayList.size() >= 25) {
            var47 = this.computeValue(this.resolveList(arrayList));
            preciseValue3 = (preciseValue3 + var47);
            arrayList.clear();
        }
        preciseValue2 = (preciseValue2 + RangeServiceComponent.computeValue((ClosedRange) RangesKt.rangeTo(0.1D, 0.3D), 0));
        return new MoveFixServiceComponent(RangesKt.coerceIn());
    }

    private List resolveList(List arg0, char arg1, int arg2, int arg3) {
        List positions = new ArrayList();
        Iterator iterator = arg0.iterator();
        if (iterator.hasNext()) {
            float var10 = (Number) iterator.next();
            if (arg1 >= 0) {
            } else {
            }
        }
        iterator = 0;
        if (iterator < 6) {
            var10 = new ArrayList();
            float var11 = 1.4E-45F;
            if (var12.hasNext()) {
                float var13 = (Number) var12.next();
                if (var7 == null) {
                    if (var11 == 1.4E-45F) {
                    }
                } else {
                }
                if (0) {
                    var11 = var13;
                    if (arg2 >= 0) {
                    }
                    var10.add(Float.valueOf(Math.abs((Math.abs() - Math.abs()))));
                    var11 = var13;
                }
            }
            positions = new ArrayList((Collection) var10);
        }
        return positions;
    }

    private float computeValue(List arg0) {
        List positions = arg0.stream().sorted().collect(Collectors.toList());
        int var6 = positions.size();
        float var7 = 0.0F;
        int var8 = 0;
        if (var8 < var6) {
            float var9 = Math.abs((((var8 + 1.0F) / var6) - (Number) positions.get()));
            if (var4 == null) {
                var7 = Math.max();
            }
        }
        return var7;
    }

    static {
        INSTANCE = new TargetEntityHelper2();
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
    }

}
