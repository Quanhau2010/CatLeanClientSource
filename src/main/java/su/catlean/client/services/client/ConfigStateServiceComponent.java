package su.catlean.client.services.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.movement.basic.MoveFixModule;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.player.ConfigStateEntityHelper;
import su.catlean.client.services.player.EntitiesEntityHelper;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.tools.comparators.Comparator6;

public class ConfigStateServiceComponent {

    public static final ConfigStateServiceComponent INSTANCE;
    private static EndCrystalEntity minecraftRef;

    private ConfigStateServiceComponent() {
    }

    public EndCrystalEntity getMinecraftObject() {
        return minecraftRef;
    }

    public void updateValue(EndCrystalEntity value) {
        minecraftRef = value;
    }

    public CrystalServiceComponent resolveCrystalServiceComponent(AutoCrystalModule receiver, EntitiesEntityHelper configState) {
        if (var20) {
            if (minecraftRef != null) {
                EndCrystalEntity entity = minecraftRef;
                minecraftRef = null;
                Entity entity2 = entity;
                if (this.resolveServiceComponent95(receiver, receiver.resolveMinecraftObject(entity2), configState, 1, entity.field_6012) != null) {
                    return new CrystalServiceComponent(entity, 1);
                }
            }
        }
        if (var20) {
        }
        if (ConfigStateServiceComponent2.resolveDamageDataServiceComponent(configState, this.resolveList(receiver, configState)) != null && (EndCrystalEntity) ConfigStateServiceComponent2.resolveDamageDataServiceComponent(configState, this.resolveList(receiver, configState)).getObject() != null) {
            EndCrystalEntity entity3 = (EndCrystalEntity) ConfigStateServiceComponent2.resolveDamageDataServiceComponent(configState, this.resolveList(receiver, configState)).getObject();
            int var23 = 0;
            if (!(var20)) {
            }
        }
        return null;
    }

    private List resolveList(AutoCrystalModule arg0, short arg1, EntitiesEntityHelper arg2, char arg3, int arg4) {
        Iterable var20 = (Iterable) arg2.getList();
        int var21 = 0;
        Object var22 = var20;
        Collection var23 = (Collection) new ArrayList();
        int var24 = 0;
        Iterator iterator = var22.iterator();
        if (iterator.hasNext()) {
            Object var26 = iterator.next();
            if (arg4 >= 0) {
                if (!(var19)) {
                    if (!(var19)) {
                    }
                    var23.add();
                }
                var20 = (Iterable) var23;
                var21 = 0;
                var22 = var20;
                var23 = (Collection) new ArrayList();
                if (arg4 >= 0) {
                }
                var24 = 0;
            }
        }
        iterator = var22.iterator();
        if (iterator.hasNext()) {
            var26 = iterator.next();
            EndCrystalEntity entity = (EndCrystalEntity) var26;
            int var28 = 0;
            if (arg3 > 0) {
                if (!(var19)) {
                    if (arg4 >= 0) {
                        if (!(var19)) {
                        }
                    }
                    if (arg3 >= 0) {
                        if (!(var19)) {
                        }
                    }
                    if (arg1 >= 0) {
                        if (!(var19)) {
                        }
                    }
                    if (!(var19)) {
                        if (!(entity.method_31481()) && !(CrystalServiceComponent2.INSTANCE.checkCondition(entity.method_5628())) && !(CrystalServiceComponent2.INSTANCE.checkCondition(entity.method_5628())) && arg0.resolveMinecraftObject(SharedKt.getPlayer()).method_1025(arg0.resolveMinecraftObject(entity)) <= 49.0D) {
                        }
                    } else {
                    }
                    var23.add();
                }
                var20 = (Iterable) var23;
                var21 = 0;
                var22 = var20;
                var23 = (Collection) new ArrayList();
                if (arg4 > 0) {
                }
                var24 = 0;
            }
        }
        iterator = var22;
        var26 = 0;
        entity = iterator.iterator();
        if (entity.hasNext()) {
            var28 = entity.next();
            Object var29 = var28;
            int var30 = 0;
            EndCrystalEntity entity2 = (EndCrystalEntity) var29;
            int var32 = 0;
            if (arg3 > 0) {
                if (!(var19)) {
                }
                if (!(var19)) {
                    if (INSTANCE.resolveServiceComponent95(arg0, arg0.resolveMinecraftObject(entity2), arg2, 0, entity2.field_6012) != null) {
                        ServiceComponent95 var33 = INSTANCE.resolveServiceComponent95(arg0, arg0.resolveMinecraftObject(entity2), arg2, 0, entity2.field_6012);
                        int var34 = 0;
                    } else {
                    }
                }
                if (null != null) {
                    int var36 = 0;
                    var23.add();
                } else {
                }
            }
            if (arg1 >= 0) {
            }
        }
        return var23;
    }

    public Vec3d resolveMinecraftObject(Vec3d vec, EntitiesEntityHelper configState, Vec3d eyes) {
        if (!(var12)) {
            if (!(configState.isActive3())) {
            }
            return new Vec3d(RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1352, (vec.field_1352 - 1.0D), (vec.field_1352 + 1.0D)), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1351, vec.field_1351, (vec.field_1351 + 2.0D)), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1350, (vec.field_1350 - 1.0D), (vec.field_1350 + 1.0D)));
        }
        List<BlockPos> positions = new ArrayList();
        Vec3d vec2 = vec.method_1031(-1.0D, 0.0D, -1.0D);
        int var15 = 0;
        if (var15 < 3) {
            int var16 = 0;
            if (var16 < 3) {
                int var17 = 0;
                if (var17 < 3) {
                    positions.add(new Vec3d((vec2.field_1352 + var15), (vec2.field_1351 + var16), (vec2.field_1350 + var17)));
                    if (!(var12)) {
                    }
                }
            }
        }
        var16 = (Iterable) positions;
        var17 = 0;
        Object var18 = var16;
        Collection var19 = (Collection) new ArrayList();
        int var20 = 0;
        Iterator iterator = var18.iterator();
        if (iterator.hasNext()) {
            Object var22 = iterator.next();
            Vec3d vec3 = (Vec3d) var22;
            int var24 = 0;
            if (!(var12)) {
                if (!(var12)) {
                    if (configState.isActive9()) {
                    }
                }
                if (!(var12)) {
                    if (eyes.method_1022(vec3) <= configState.getNumericValue2()) {
                    }
                } else {
                }
                if (!(var12)) {
                }
                var19.add();
            }
            var16 = (Iterable) var19;
        }
        var17 = 0;
        var15 = CollectionsKt.sortedWith((Comparator) new Comparator6(eyes)).iterator();
        if (var15.hasNext()) {
            var16 = (Vec3d) var15.next();
            return var16;
        }
        if (null != null) {
            if (var12) {
            }
        }
        return 0;
    }

    public ServiceComponent95 resolveServiceComponent95(AutoCrystalModule receiver, Vec3d pos, EntitiesEntityHelper configState, boolean secondaryCrystal, int age) {
        BlockPos blockPos = BlockPos.ofFloored(pos.method_1031(0.0D, -0.1D, 0.0D));
        if (!(var31)) {
            if (!(var31)) {
                if (!((receiver.getNumericValue() % 4))) {
                }
            }
            if (receiver.getRandomizeDelay() && 2 < RangeServiceComponent.P()) {
                return null;
            }
        }
        if (!(var31)) {
            if (!(configState.isActive3())) {
            }
            if (!(var31)) {
                if (MoveFixModule.INSTANCE.getEnabled()) {
                }
            } else {
            }
            int var33 = blockPos.method_10264();
            Object var34 = pos;
            if (!(var31)) {
                if (SharedKt.getPlayer().getEyePos().field_1351 > var33) {
                    Iterable var36 = (Iterable) ConfigStateEntityHelper.getList();
                    int var37 = 0;
                    Iterator iterator = var36.iterator();
                    if (!(var31)) {
                        if (!(iterator.hasNext())) {
                        }
                    }
                    Object var39 = iterator.next();
                    if (!(var31)) {
                        if (!(iterator.hasNext())) {
                        }
                    }
                    Vec3d vec = (Vec3d) var39;
                    int var41 = 0;
                    Vec3d vec2 = new Vec3d((blockPos.method_10263() + vec.field_1352), ((blockPos.method_10264() + vec.field_1351) + 1.0D), (blockPos.method_10260() + vec.field_1350));
                    vec = EventPacketHelper2.INSTANCE.computeValue(vec2);
                    var41 = iterator.next();
                    Vec3d vec3 = (Vec3d) var41;
                    int var43 = 0;
                    vec2 = new Vec3d((blockPos.method_10263() + vec3.field_1352), ((blockPos.method_10264() + vec3.field_1351) + 1.0D), (blockPos.method_10260() + vec3.field_1350));
                    vec3 = EventPacketHelper2.INSTANCE.computeValue(vec2);
                    if (Float.compare(vec, vec3) > 0) {
                        var39 = var41;
                        vec = vec3;
                    }
                    Vec3d vec4 = (Vec3d) var39;
                    var34 = new Vec3d((blockPos.method_10263() + vec4.field_1352), (blockPos.method_10264() + 1.0D), (blockPos.method_10260() + vec4.field_1350));
                }
            }
            if (!(var31)) {
                if (configState.isActive9()) {
                    return null;
                }
            }
            return null;
        }
        if (!(InteractVecServiceComponent.INSTANCE.checkCondition(pos)) && var34.method_1025(VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer())) > (configState.getNumericValue() * configState.getNumericValue()) && E(this, pos, configState) == null) {
            return null;
        }
        return ConfigStateServiceComponent2.resolveServiceComponent95(receiver, blockPos, configState, secondaryCrystal, 0, 0);
    }

    static {
        INSTANCE = new ConfigStateServiceComponent();
    }

}
