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
        List<BlockPos> list = this.arrayList;
        this.arrayList.clear();
        DoubleRef doubleRef = new DoubleRef();
        doubleRef.element = (this.playerEntity.getX() - this.playerEntity.field_6014);
        DoubleRef doubleRef2 = new DoubleRef();
        doubleRef2.element = (this.playerEntity.getY() - this.playerEntity.field_6036);
        DoubleRef doubleRef3 = new DoubleRef();
        doubleRef3.element = (this.playerEntity.getZ() - this.playerEntity.field_5969);
        if (Intrinsics.areEqual(this.playerEntity, SharedKt.getPlayer())) {
            doubleRef.element = SharedKt.getPlayer().method_18798().field_1352;
            doubleRef2.element = SharedKt.getPlayer().method_18798().field_1351;
            doubleRef3.element = SharedKt.getPlayer().method_18798().field_1350;
        }
        double offset = Math.hypot(doubleRef.element, doubleRef3.element);
        if (this.playerEntity.method_5715()) {
        } else {
        }
        double offset2 = class_3532.method_15350(0.08511D, 0.2837D, 0.45392000000000005D);
        if (arg1 < 0) {
            if (offset != 0.0D) {
                doubleRef.element = ((doubleRef.element / offset) * offset2);
                doubleRef3.element = ((doubleRef3.element / offset) * offset2);
            }
        }
        if (SharedKt.getWorld().method_52569(this.playerEntity, this.playerEntity.method_5829().method_1012(0.0D, -0.1D, 0.0D)) && doubleRef2.element > 0.0D) {
            doubleRef2.element = -0.0784D;
        }
        ObjectRef objectRef = new ObjectRef();
        objectRef.element = this.resolveMinecraftObject(this.playerEntity);
        if (arg0 >= 0) {
            if (__UNDEF_KEY__ != null) {
                if (doubleRef2.element > 0.0D) {
                    doubleRef2.element = this.computeValue(doubleRef2.element);
                }
            }
        }
        if (arg0 >= 0 && __UNDEF_KEY__ != null) {
            if (offset < 0.056740000000000006D) {
                doubleRef.element = 0.0D;
                doubleRef3.element = 0.0D;
            }
        }
        if (offset < 0.056740000000000006D && Math.abs(doubleRef2.element) < 0.1D) {
            this.arrayList.addAll(((Collection) Collections.nCopies(20, objectRef.element)));
            return;
        }
        int index = 20;
        int index2 = 0;
        if (index2 < index) {
            Box box = ((Box) objectRef.element).method_989(0.0D, -0.01D, 0.0D);
            PlayerEntity player = this.playerEntity;
            if (this.checkCondition(player, box)) {
            } else {
            }
            this.element = this.computeValue(doubleRef2.element);
            objectRef.element = this.resolveMinecraftObject(((Box) objectRef.element), doubleRef.element, doubleRef2.element, doubleRef3.element);
            this.arrayList.add(objectRef.element);
        }
        doubleRef = list;
    }

    public double computeValue(double d) {
        return ((d - 0.08D) * 0.98D);
    }

    public boolean checkCondition(PlayerEntity player, Box box) {
        return SharedKt.getWorld().method_20812(player, box).iterator().hasNext();
    }

    public Box resolveMinecraftObject(PlayerEntity entity) {
        Box box = entity.method_5829();
        Vec3d vec = new Vec3d(entity.field_6014, entity.field_6036, entity.field_5969);
        if (vec.method_1027() == 0.0D) {
            return entity.method_5829();
        }
        double offset = (box.method_17939() / 2.0D);
        return new Box((offset + vec.field_1352), vec.field_1351, (offset + vec.field_1350), (offset + vec.field_1352), (box.method_17940() + vec.field_1351), (offset + vec.field_1350));
    }

    private List resolveList(Entity arg0, List arg1, Box arg2) {
        Builder builder = ImmutableList.builderWithExpectedSize((arg1.size() + 1));
        if (!(arg1.isEmpty())) {
            builder.addAll(((Iterable) arg1));
        }
        class_2784 class2784 = SharedKt.getWorld().method_8621();
        boolean flag = class2784.method_39459(arg0, arg2);
        if (flag) {
            builder.add(class2784.method_17903());
        }
        return builder.addAll(SharedKt.getWorld().method_20812(arg0, arg2)).build();
    }

    public Box resolveMinecraftObject(Box box, double motionX, double motionY, double motionZ) {
        Box box2 = box.method_1012(motionX, motionY, motionZ);
        List list = this.resolveList(this.playerEntity, SharedKt.getWorld().method_20743(this.playerEntity, box2), box2);
        Box box3 = box;
        double offset = motionX;
        double offset2 = 0.0D;
        offset2 = motionY;
        double offset3 = 0.0D;
        offset3 = motionZ;
        if (list.isEmpty()) {
            return box3.method_989(offset, offset2, offset3);
        }
        if (offset2 != 0.0D) {
            double offset4 = class_259.method_1085(class_2351.field_11052, box3, ((Iterable) list), offset2);
            double offset5 = offset4;
            offset2 = offset5;
            if (offset4 != 0.0D) {
                box3 = box3.method_989(0.0D, offset2, 0.0D);
            }
        }
        offset4 = Math.abs(offset) < Math.abs(offset3);
        if (offset4 && offset3 != 0.0D) {
            offset5 = class_259.method_1085(class_2351.field_11051, box3, ((Iterable) list), offset3);
            offset3 = offset5;
            if (offset5 != 0.0D) {
                box3 = box3.method_989(0.0D, 0.0D, offset3);
            }
        }
        if (offset != 0.0D) {
            offset = class_259.method_1085(class_2351.field_11048, box3, ((Iterable) list), offset);
            if (!(offset4) && offset != 0.0D) {
                box3 = box3.method_989(offset, 0.0D, 0.0D);
            }
        }
        if (!(offset4) && offset3 != 0.0D) {
            offset3 = class_259.method_1085(class_2351.field_11051, box3, ((Iterable) list), offset3);
        }
        return box3.method_989(offset, offset2, offset3);
    }

}
