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

public class TargetEntityHelper9 extends ZEROEntityHelper {

    public static final TargetEntityHelper9 INSTANCE;
    private static double preciseValue;
    private static int countValue;
    private static int countValue2;
    private static double preciseValue2;
    private static ArrayList arrayList;
    private static ArrayList arrayList2;
    private static double preciseValue3;

    private TargetEntityHelper9() {
        super();
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Entity target, MoveFixServiceComponent currentRotation, boolean attackTick) {
        long var6 = (0L ^ 33615733051039L);
        long var8 = (0L ^ 17529635141180L);
        long var10 = (0L ^ 122620728483203L);
        long var12 = (0L ^ 28158549830711L);
        long var14 = (0L ^ 38753063586444L);
        long var16 = ((0L ^ 25377842513472L) >>> 48);
        long var17 = (((0L ^ 25377842513472L) << 16) >>> 32);
        long var18 = (((0L ^ 25377842513472L) << 48) >>> 48);
        long var19 = (0L ^ 43306842265647L);
        int var22 = (target.field_6012 / 4.0F);
        double var24 = ((target.method_5829().method_17939() / 2.3D) * Math.sin(Math.toRadians()));
        double var26 = ((target.method_5829().method_17940() / 10.0D) * Math.sin(Math.toRadians((var22 + 10.0D))));
        double var28 = ((target.method_5829().method_17941() / 2.3D) * Math.cos(Math.toRadians()));
        Vec3d vec = EntityHelper.resolveMinecraftObject(target).method_1031(((target.method_17682() / 2.0D) + var26));
        double var31 = class_3532.method_15338(((Math.toDegrees(Math.atan2((vec.field_1350 - SharedKt.getPlayer().getZ()), (vec.field_1352 - SharedKt.getPlayer().getX()))) - 90) - currentRotation.getNumericValue()));
        double var33 = (Math.toDegrees(Math.atan2((vec.field_1351 - (EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((vec.field_1352 - SharedKt.getPlayer().getX()), (vec.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
        if (Math.abs(preciseValue) <= 300.0D) {
            if (0L >= 0L) {
                if (var21 == null) {
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
            if (var21 == null) {
                if (countValue > 0) {
                    int var35 = countValue;
                    countValue = (var35 + -1);
                    preciseValue2 = 0.0D;
                    var35 = RangeServiceComponent.computeValue(0.15F, 0.4F, 0);
                    return new MoveFixServiceComponent((currentRotation.getNumericValue() + var35), (currentRotation.getNumericValue2() - (var35 / 2.0F)));
                }
            }
        }
        if (0L > 0L && var21 == null) {
        }
        var35 = var31 > 60.0D;
        if (var35) {
            countValue2 = 0;
        }
        ClosedFloatingPointRange var36 = RangesKt.rangeTo(25.0F, 35.0F);
        if (var35) {
        } else {
        }
        float var37 = RangeServiceComponent.computeValue((ClosedRange) var36, 1);
        double var39 = Math.abs(RangeServiceComponent.computeValue((ClosedRange) RangesKt.rangeTo(-5.1D, 5.1D), 1));
        if (!((SharedKt.getPlayer().field_6012 % RangeServiceComponent.computeValue(2, 10, 0)))) {
            var37 = (var37 / 10.0F);
        }
        var31 = RangesKt.coerceIn();
        var33 = RangesKt.coerceIn();
        var33 = (var33 + (var31 / 20.0F));
        float var41 = (currentRotation.getNumericValue() + var31);
        float var42 = (currentRotation.getNumericValue2() + var33);
        boolean var43 = target.getEyePos().method_1022(SharedKt.getPlayer().getEyePos()) < 1.5D;
        if (var43) {
        } else {
        }
        float var44 = -90.0F;
        if (var43) {
        } else {
        }
        float var45 = 90.0F;
        preciseValue = (preciseValue + var31);
        if (var31 < 20.0D) {
            int var46 = countValue2;
            countValue2 = (var46 + 1);
            if (0L >= 0L) {
                if (var21 != null) {
                }
                var46 = countValue2;
                countValue2 = (var46 + -1);
            }
            var41 = (var41 + RangeServiceComponent.computeValue((ClosedRange) RangesKt.rangeTo(-2.0F, 2.0F), 0));
            var42 = (var42 + RangeServiceComponent.computeValue((ClosedRange) RangesKt.rangeTo(-0.5F, 0.5F), 0));
            arrayList.add(Float.valueOf());
            if (0L >= 0L) {
                arrayList2.add(Float.valueOf());
            }
        }
        if (arrayList.size() >= 25) {
            var46 = this.computeValue(this.resolveList(arrayList));
            preciseValue3 = (preciseValue3 + var46);
            arrayList.clear();
        }
        preciseValue2 = (preciseValue2 + RangeServiceComponent.computeValue((ClosedRange) RangesKt.rangeTo(0.1D, 0.3D), 0));
        return new MoveFixServiceComponent(RangesKt.coerceIn());
    }

    private List resolveList(List arg0) {
        List positions = new ArrayList();
        Iterator iterator = arg0.iterator();
        if (iterator.hasNext()) {
            float var7 = (Number) iterator.next();
            if (var4 == null) {
                positions.add(Float.valueOf());
            }
        }
        iterator = 0;
        if (iterator < 6) {
            var7 = new ArrayList();
            float var8 = 1.4E-45F;
            if (var4 == null) {
                Iterator iterator2 = positions.iterator();
                if (iterator2.hasNext()) {
                    float var10 = (Number) iterator2.next();
                    if (var4 == null) {
                        if (var8 == 1.4E-45F) {
                        }
                    } else {
                    }
                    if (0) {
                        var8 = var10;
                    }
                    var7.add(Float.valueOf(Math.abs((Math.abs() - Math.abs()))));
                    var8 = var10;
                }
                positions = new ArrayList((Collection) var7);
            }
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
        INSTANCE = new TargetEntityHelper9();
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
    }

}
