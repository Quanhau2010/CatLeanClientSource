package su.catlean.client.features.modules.movement.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AutoDripstopeModule;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent102;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode18;

public class HoleAnchorModule extends Module {

    public static final HoleAnchorModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl disableOverHoleSetting;
    private static final RangeVisibleSettingPropertyImpl pitchSetting;
    private static final RangeVisibleSettingPropertyImpl2 maxSpeedSetting;
    private static final RangeVisibleSettingPropertyImpl2 rubberBandSpeedSetting;
    private static final RangeVisibleSettingPropertyImpl rubberBandTimeOutSetting;
    private static final VisibleVisibleSettingPropertyImpl useTimerSetting;
    private static final RangeVisibleSettingPropertyImpl2 timerValueSetting;
    private static final RangeVisibleSettingPropertyImpl hRangeSetting;
    private static final RangeVisibleSettingPropertyImpl vRangeSetting;
    private static final RangeVisibleSettingPropertyImpl prioritizedFovSetting;

    private HoleAnchorModule() {
        super("hole-anchor", SubCategoriesKt.getBasicMovementCategory());
    }

    private boolean getDisableOverHole() {
        return (Boolean) disableOverHoleSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private int getPitch() {
        return (Number) pitchSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private float getMaxSpeed() {
        return (Number) maxSpeedSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private float getRubberBandSpeed() {
        return (Number) rubberBandSpeedSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private int getRubberBandTimeOut() {
        return (Number) rubberBandTimeOutSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getUseTimer() {
        return (Boolean) useTimerSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private float getTimerValue() {
        return (Number) timerValueSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    public int getHRange() {
        if ((Number) hRangeSetting.getValue(this, DELEGATED_PROPERTIES[7]) != null) {
        }
        return null;
    }

    public int getVRange() {
        if (var5 != null) {
        }
        return (Number) vRangeSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private int getPrioritizedFov() {
        return (Number) prioritizedFovSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (!(MoveFixModule.INSTANCE.getEnabled())) {
            return;
        }
        BlockPos blockPos = this.resolveMinecraftObject();
        if (var13 == null) {
            if (blockPos != null) {
                Object var15 = blockPos;
                int var16 = 0;
                Vec3d vec = var15.down().toCenterPos();
                SequenceServiceComponent.INSTANCE.executeAction(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(vec).resolveMoveFixServiceComponent(OptionMode18.FORCE), 0);
            } else {
            }
        }
    }

    private void onMoveEvent(MoveEvent arg0) {
        if (MoveFixModule.INSTANCE.getEnabled()) {
            return;
        }
        BlockPos blockPos = this.resolveMinecraftObject();
        if (var21 == null) {
            if (blockPos != null) {
                Object var23 = blockPos;
                int var24 = 0;
                Vec3d vec = var23.down().toCenterPos();
                Vec3d vec2 = vec.method_1020(INSTANCE.resolveMinecraftObject(SharedKt.getPlayer())).method_1029().method_1021(Math.min(INSTANCE.computeValue(), vec.method_1022(INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()))));
                arg0.setX(vec2.field_1352);
                arg0.setZ(vec2.field_1350);
                arg0.cancel();
                if (var21 == null) {
                    if (INSTANCE.getUseTimer()) {
                        ServiceComponent98.INSTANCE.updateValue2(INSTANCE.getTimerValue());
                    }
                }
            } else {
            }
        }
    }

    private BlockPos resolveMinecraftObject(long arg0, char arg1) {
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        if (SharedKt.getPlayer().method_36455() < this.getPitch()) {
            return null;
        }
        if (ServiceComponent102.INSTANCE.checkCondition(blockPos)) {
            if (this.getDisableOverHole()) {
                this.updateValue2();
            }
            return null;
        }
        List positions = new ArrayList();
        int var34 = (blockPos.method_10263() - this.getHRange());
        int var35 = (blockPos.method_10263() + this.getHRange());
        if (arg0 > 0L) {
            if (var34 <= var35) {
            }
            int var36 = (blockPos.method_10260() - this.getHRange());
            int var37 = (blockPos.method_10260() + this.getHRange());
            if (arg0 >= 0L) {
                if (var36 <= var37) {
                    int var38 = (blockPos.method_10264() - this.getVRange());
                    int var39 = blockPos.method_10264();
                    if (var38 <= var39) {
                        BlockPos blockPos2 = new BlockPos();
                        Vec3d vec = blockPos2.down().toCenterPos();
                        boolean var44 = ExplosionPosEntityHelper.INSTANCE.checkCondition(vec);
                        if (arg1 >= 0) {
                            if (var44 && ServiceComponent102.INSTANCE.checkCondition(blockPos2.down())) {
                                positions.add(blockPos2);
                            }
                        }
                        if (arg0 > 0L) {
                            if (var31 == null) {
                                if (var38 != var39) {
                                }
                            }
                        }
                        if (arg0 >= 0L) {
                        }
                        if (var36 != var37) {
                        }
                    }
                }
            }
            if (var34 != var35) {
            }
        }
        var35 = (Iterable) positions;
        var36 = 0;
        var37 = var35;
        var38 = (Collection) new ArrayList();
        var39 = 0;
        blockPos2 = var37.iterator();
        while (blockPos2.hasNext()) {
            vec = blockPos2.next();
            var44 = (BlockPos) vec;
            int var45 = 0;
            if (arg1 >= 0) {
                var38.add(vec);
            }
            var35 = (Iterable) var38;
            if (arg1 > 0) {
                var36 = 0;
            }
        }
        var37 = var35.iterator();
        if (arg1 >= 0) {
            if (!(var37.hasNext())) {
            } else {
                var38 = var37.next();
            }
            if (!(var37.hasNext())) {
            } else {
                var39 = (BlockPos) var38;
                blockPos2 = 0;
                var39 = INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).method_1022(var39.toCenterPos());
                blockPos2 = var37.next();
                vec = (BlockPos) blockPos2;
                var44 = 0;
                vec = INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).method_1022(vec.toCenterPos());
                if (Double.compare(vec) > 0) {
                    var38 = blockPos2;
                    var39 = vec;
                }
            }
        }
        var34 = (BlockPos) var38;
        if (arg1 > 0) {
            if (var34 == null) {
                var35 = (Iterable) positions;
                var36 = 0;
                var37 = var35.iterator();
            }
            if (arg1 >= 0) {
                if (!(var37.hasNext())) {
                } else {
                    var38 = var37.next();
                }
                if (!(var37.hasNext())) {
                } else {
                    var39 = (BlockPos) var38;
                    blockPos2 = 0;
                    var39 = INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).method_1022(var39.toCenterPos());
                    blockPos2 = var37.next();
                    vec = (BlockPos) blockPos2;
                    var44 = 0;
                    vec = INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).method_1022(vec.toCenterPos());
                    if (Double.compare(vec) > 0) {
                        var38 = blockPos2;
                        var39 = vec;
                    }
                }
            }
        }
        return (BlockPos) var38;
    }

    private double computeValue() {
        if (EventPacketHelper2.INSTANCE.getNumericValue4() < (this.getRubberBandTimeOut() * 1000)) {
        } else {
        }
        return (0.2873D * this.getMaxSpeed());
    }

    private static boolean isActive() {
        return !(MoveFixModule.INSTANCE.getEnabled());
    }

    private static boolean isActive2() {
        return !(MoveFixModule.INSTANCE.getEnabled());
    }

    private static boolean isActive3() {
        return !(MoveFixModule.INSTANCE.getEnabled());
    }

    private static boolean isActive4() {
        return !(MoveFixModule.INSTANCE.getEnabled());
    }

    private static boolean isActive5() {
        return !(MoveFixModule.INSTANCE.getEnabled());
    }

    static {
        KProperty[] var30 = new KProperty[10];
        INSTANCE = new HoleAnchorModule();
        disableOverHoleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "disable-over-hole");
        pitchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pitch", 60, new IntRange(0, 90));
        maxSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-speed", 2.0F, RangesKt.rangeTo(0.1F, 5.0F), null, this::isActive);
        rubberBandSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rubberband-speed", 1.0F, RangesKt.rangeTo(0.1F, 5.0F), null, this::isActive2);
        rubberBandTimeOutSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rubberband-timeout", 10, new IntRange(1, 30), null, this::isActive3);
        useTimerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "use-timer", 0, null, this::isActive4);
        timerValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timer-value", 1.0F, RangesKt.rangeTo(1.0F, 10.0F), null, this::isActive5);
        hRangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "horizontal-range", 3, new IntRange(1, 3));
        vRangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "vertical-range", 3, new IntRange(1, 3));
        prioritizedFovSetting = VisibleRenderHelper.registerSetting(INSTANCE, "prioritized-fov", 30, new IntRange(10, 180));
    }

}
