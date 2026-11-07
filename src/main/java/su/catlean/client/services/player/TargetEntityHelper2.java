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
        int index = (target.field_6012 / 4.0F);
        double offset = ((target.method_5829().method_17939() / 2.3D) * Math.sin(Math.toRadians(index)));
        double offset2 = ((target.method_5829().method_17940() / 10.0D) * Math.sin(Math.toRadians((index + 10.0D))));
        double offset3 = ((target.method_5829().method_17941() / 2.3D) * Math.cos(Math.toRadians(index)));
        Vec3d vec = EntityHelper.resolveMinecraftObject(target).method_1031(offset, ((target.method_17682() / 2.0D) + offset2), offset3);
        double offset4 = class_3532.method_15338(((Math.toDegrees(Math.atan2((vec.field_1350 - SharedKt.getPlayer().getZ()), (vec.field_1352 - SharedKt.getPlayer().getX()))) - 90) - currentRotation.getNumericValue()));
        double offset5 = (Math.toDegrees(Math.atan2((vec.field_1351 - (EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((vec.field_1352 - SharedKt.getPlayer().getX()), (vec.field_1350 - SharedKt.getPlayer().getZ())))) - currentRotation.getNumericValue2());
        if (Math.abs(preciseValue) <= 300.0D) {
            if (preciseValue3 > 100.0D) {
                preciseValue = 0.0D;
                countValue = RangeServiceComponent.computeValue(1, 3, false);
                preciseValue2 = 0.0D;
                preciseValue3 = 0.0D;
            }
        }
        if (countValue > 0) {
            int index2 = countValue;
            countValue = (index2 + -1);
            preciseValue2 = 0.0D;
            index2 = RangeServiceComponent.computeValue(0.15F, 0.4F, false);
            return new MoveFixServiceComponent((currentRotation.getNumericValue() + index2), (currentRotation.getNumericValue2() - (index2 / 2.0F)), false);
        }
        index2 = offset4 > 60.0D;
        if (index2) {
            countValue2 = 0;
        }
        ClosedFloatingPointRange closedFloatingPointRange = RangesKt.rangeTo(25.0F, 35.0F);
        if (index2) {
        } else {
        }
        float factor = RangeServiceComponent.computeValue(((ClosedRange) closedFloatingPointRange), true);
        double offset6 = Math.abs(RangeServiceComponent.computeValue(((ClosedRange) RangesKt.rangeTo(-5.1D, 5.1D)), true));
        if (!((SharedKt.getPlayer().field_6012 % RangeServiceComponent.computeValue(2, 10, false)))) {
            factor = (factor / 10.0F);
        }
        offset4 = RangesKt.coerceIn(offset4, factor, factor);
        offset5 = RangesKt.coerceIn(offset5, offset6, offset6);
        offset5 = (offset5 + (offset4 / 20.0F));
        float factor2 = (currentRotation.getNumericValue() + offset4);
        float factor3 = (currentRotation.getNumericValue2() + offset5);
        boolean flag = target.getEyePos().method_1022(SharedKt.getPlayer().getEyePos()) < 1.5D;
        if (flag) {
        } else {
        }
        float factor4 = -90.0F;
        if (flag) {
        } else {
        }
        float factor5 = 90.0F;
        preciseValue = (preciseValue + offset4);
        if (offset4 < 20.0D) {
            int index3 = countValue2;
            countValue2 = (index3 + 1);
        } else {
            index3 = countValue2;
            countValue2 = (index3 + -1);
        }
        factor2 = (factor2 + RangeServiceComponent.computeValue(((ClosedRange) RangesKt.rangeTo(-2.0F, 2.0F)), false));
        factor3 = (factor3 + RangeServiceComponent.computeValue(((ClosedRange) RangesKt.rangeTo(-0.5F, 0.5F)), false));
        arrayList.add(Float.valueOf(factor2));
        arrayList2.add(Float.valueOf(offset4));
        if (arrayList.size() >= 25) {
            index3 = this.computeValue(this.resolveList(arrayList));
            preciseValue3 = (preciseValue3 + index3);
            arrayList.clear();
        }
        preciseValue2 = (preciseValue2 + RangeServiceComponent.computeValue(((ClosedRange) RangesKt.rangeTo(0.1D, 0.3D)), false));
        return new MoveFixServiceComponent(factor2, RangesKt.coerceIn(factor3, factor4, factor5), false);
    }

    private List resolveList(List arg0, char arg1, int arg2, int arg3) {
        List list = new ArrayList();
        Iterator iterator = arg0.iterator();
        while (iterator.hasNext()) {
            float factor = ((Number) iterator.next());
            if (arg1 >= 0) {
            } else {
            }
        }
        iterator = 0;
        if (iterator < 6) {
            factor = new ArrayList();
            float factor2 = 1.4E-45F;
            while (this.hasNext()) {
                float factor3 = ((Number) this.next());
                if (__UNDEF_KEY__ == null) {
                    if (factor2 == 1.4E-45F) {
                    } else {
                    }
                }
                if (0) {
                    factor2 = factor3;
                    if (arg2 >= 0) {
                        factor.add(Float.valueOf(Math.abs((Math.abs(factor3) - Math.abs(factor2)))));
                        factor2 = factor3;
                    }
                }
            }
            list = new ArrayList(((Collection) factor));
        }
        return list;
    }

    private float computeValue(List arg0) {
        List list = arg0.stream().sorted().collect(Collectors.toList());
        int index = list.size();
        float factor = 0.0F;
        int index2 = 0;
        if (index2 < index) {
            float factor2 = Math.abs((((index2 + 1.0F) / index) - ((Number) list.get(index2))));
            if (__UNDEF_KEY__ == null) {
                factor = Math.max(factor, factor2);
            }
        }
        return factor;
    }

    static {
        INSTANCE = new TargetEntityHelper2();
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
    }

}
