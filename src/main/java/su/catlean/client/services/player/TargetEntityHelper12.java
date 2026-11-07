package su.catlean.client.services.player;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.DoubleRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import net.minecraft.class_2350.class_2351;
import net.minecraft.class_259;
import net.minecraft.class_2784;
import net.minecraft.class_3532;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;

public class TargetEntityHelper12 {

    private final PlayerEntity playerEntity;
    private final ArrayList arrayList;

    public TargetEntityHelper12(PlayerEntity target) {
        this.playerEntity = target;
        this.arrayList = new ArrayList();
    }

    public PlayerEntity getMinecraftObject() {
        return this.playerEntity;
    }

    public ArrayList getArrayList() {
        return this.arrayList;
    }

    public void executeAction(int arg0, short arg1) {
        List<BlockPos> positions = this.arrayList;
        int var22 = 0;
        this.arrayList.clear();
        DoubleRef var23 = new DoubleRef();
        var23.element = (this.playerEntity.getX() - this.playerEntity.field_6014);
        DoubleRef var24 = new DoubleRef();
        var24.element = (this.playerEntity.getY() - this.playerEntity.field_6036);
        DoubleRef var25 = new DoubleRef();
        var25.element = (this.playerEntity.getZ() - this.playerEntity.field_5969);
        if (Intrinsics.areEqual(this.playerEntity, SharedKt.getPlayer())) {
            var23.element = SharedKt.getPlayer().method_18798().field_1352;
            var24.element = SharedKt.getPlayer().method_18798().field_1351;
            var25.element = SharedKt.getPlayer().method_18798().field_1350;
        }
        double var26 = Math.hypot(var23.element, var25.element);
        if (this.playerEntity.method_5715()) {
        } else {
        }
        double var28 = class_3532.method_15350(0.08511D, 0.2837D, 0.45392000000000005D);
        if (arg1 < 0) {
            if (var26 != 0.0D) {
                var23.element = ((var23.element / var26) * var28);
                var25.element = ((var25.element / var26) * var28);
            }
        }
        if (SharedKt.getWorld().method_52569(this.playerEntity, this.playerEntity.method_5829().method_1012(0.0D, -0.1D, 0.0D)) && var24.element > 0.0D) {
            var24.element = -0.0784D;
        }
        ObjectRef var30 = new ObjectRef();
        var30.element = this.resolveMinecraftObject(this.playerEntity);
        if (arg0 >= 0) {
            if (var20 != null) {
                if (var24.element > 0.0D) {
                    var24.element = this.computeValue(var24.element);
                }
            }
        }
        if (arg0 >= 0 && var20 != null) {
            if (var26 < 0.056740000000000006D) {
                var23.element = 0.0D;
                var25.element = 0.0D;
            }
        }
        if (var26 < 0.056740000000000006D && Math.abs(var24.element) < 0.1D) {
            this.arrayList.addAll((Collection) Collections.nCopies(20, var30.element));
            return;
        }
        int var31 = 20;
        int var32 = 0;
        if (var32 < var31) {
            int var33 = var32;
            int var34 = 0;
            Box var18 = (Box) var30.element.method_989(0.0D, -0.01D, 0.0D);
            PlayerEntity player = this.playerEntity;
            if (this.checkCondition(player)) {
            } else {
            }
            -0.0784D.element = this.computeValue(var24.element);
            var30.element = this.resolveMinecraftObject((Box) var30.element, var23.element, var24.element, var25.element);
            this.arrayList.add(var30.element);
        }
        var22 = Unit.INSTANCE;
        var23 = positions;
    }

    public double computeValue(double d) {
        return ((d - 0.08D) * 0.98D);
    }

    public boolean checkCondition(PlayerEntity player, Box box) {
        return SharedKt.getWorld().method_20812(player, box).iterator().hasNext();
    }

    public Box resolveMinecraftObject(PlayerEntity entity) {
        Box var8 = entity.method_5829();
        Vec3d vec = new Vec3d(entity.field_6014, entity.field_6036, entity.field_5969);
        if (vec.method_1027() == 0.0D) {
            return entity.method_5829();
        }
        double var10 = (var8.method_17939() / 2.0D);
        return new Box((var10 + vec.field_1352), vec.field_1351, (var10 + vec.field_1350), (var10 + vec.field_1352), (var8.method_17940() + vec.field_1351), (var10 + vec.field_1350));
    }

    private List resolveList(Entity arg0, List arg1, Box arg2) {
        Builder var8 = ImmutableList.builderWithExpectedSize((arg1.size() + 1));
        if (!(arg1.isEmpty())) {
            var8.addAll((Iterable) arg1);
        }
        class_2784 var9 = SharedKt.getWorld().method_8621();
        boolean var10 = var9.method_39459(arg0, arg2);
        if (var10) {
            var8.add(var9.method_17903());
        }
        return var8.addAll(SharedKt.getWorld().method_20812(arg0, arg2)).build();
    }

    public Box resolveMinecraftObject(Box box, double motionX, double motionY, double motionZ) {
        Box var15 = box.method_1012(motionX, motionY, motionZ);
        List positions = this.resolveList(this.playerEntity, SharedKt.getWorld().method_20743(this.playerEntity));
        Object var17 = box;
        double var18 = motionX;
        double var28 = 0.0D;
        var28 = motionY;
        double var30 = 0.0D;
        var30 = motionZ;
        if (positions.isEmpty()) {
            return var17.method_989();
        }
        Object var20 = var17;
        if (var28 != 0.0D) {
            double var21 = class_259.method_1085(class_2351.field_11052, (Iterable) positions);
            double var23 = var21;
            int var26 = 0;
            var28 = var23;
            if (var21 != 0.0D) {
                var17 = var17.method_989(0.0D, 0.0D);
            }
        }
        var21 = Math.abs() < Math.abs();
        if (var21 && var30 != 0.0D) {
            var23 = class_259.method_1085(class_2351.field_11051, (Iterable) positions);
            double var25 = var23;
            int var27 = 0;
            var30 = var25;
            if (var23 != 0.0D) {
                var17 = var17.method_989(0.0D, 0.0D);
            }
        }
        if (var18 != 0.0D) {
            var18 = class_259.method_1085(class_2351.field_11048, (Iterable) positions);
            if (!(var21) && var18 != 0.0D) {
                var17 = var17.method_989(0.0D, 0.0D);
            }
        }
        if (!(var21) && var30 != 0.0D) {
            var30 = class_259.method_1085(class_2351.field_11051, (Iterable) positions);
        }
        return var20.method_989();
    }

}
