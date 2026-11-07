package su.catlean.client.features.modules.movement.rage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1531;
import net.minecraft.class_1661;
import net.minecraft.class_1690;
import net.minecraft.class_1702;
import net.minecraft.class_1713;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_744;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.utility.equip.ElytraSwapModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.player.EntityHelper3;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.mappings.SpeedBoostAngleModeWhenMappings;

public class SpeedModule extends Module {

    public static final SpeedModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final VisibleVisibleSettingPropertyImpl useTimerSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseInLiquidsSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseWhileSneakingSetting;
    private static final RangeVisibleSettingPropertyImpl fireWorkSlotSetting;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final VisibleVisibleSettingPropertyImpl armorStandsSetting;
    private static final RangeVisibleSettingPropertyImpl2 distanceSetting;
    private static final RangeVisibleSettingPropertyImpl2 speedSetting;
    private static final RangeVisibleSettingPropertyImpl2 groundSpeedSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 boostAngleSetting;
    private static final RangeVisibleSettingPropertyImpl2 predictTicksSetting;
    private static final RangeVisibleSettingPropertyImpl rollBackTicksSetting;
    private static double preciseValue;
    private static int countValue;
    private static int countValue2;
    private static float factorValue;
    private static final ServiceComponent10 serviceComponent10;

    private SpeedModule() {
        super("speed", SubCategoriesKt.getRageMovementCategory());
    }

    private SpeedMode getMode() {
        return (SpeedMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getUseTimer() {
        return (Boolean) useTimerSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setUseTimer(boolean value) {
        useTimerSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private boolean getPauseInLiquids() {
        return (Boolean) pauseInLiquidsSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setPauseInLiquids(boolean value) {
        pauseInLiquidsSetting.setValue(this, DELEGATED_PROPERTIES[2], Boolean.valueOf(value));
    }

    private boolean getPauseWhileSneaking() {
        return (Boolean) pauseWhileSneakingSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setPauseWhileSneaking(boolean value) {
        pauseWhileSneakingSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private int getFireWorkSlot() {
        return (Number) fireWorkSlotSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private int getDelay() {
        return (Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getArmorStands() {
        return (Boolean) armorStandsSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private float getDistance() {
        return (Number) distanceSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private void setDistance(float value) {
        distanceSetting.setValue(this, DELEGATED_PROPERTIES[7], Float.valueOf(value));
    }

    private float getSpeed() {
        return (Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private void setSpeed(float value) {
        speedSetting.setValue(this, DELEGATED_PROPERTIES[8], Float.valueOf(value));
    }

    private float getGroundSpeed() {
        return (Number) groundSpeedSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private void setGroundSpeed(float value) {
        groundSpeedSetting.setValue(this, DELEGATED_PROPERTIES[9], Float.valueOf(value));
    }

    private SpeedBoostAngleMode getBoostAngle() {
        return (SpeedBoostAngleMode) boostAngleSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private void setBoostAngle(SpeedBoostAngleMode value) {
        boostAngleSetting.setValue(this, DELEGATED_PROPERTIES[10], value);
    }

    private float getPredictTicks() {
        return (Number) predictTicksSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private void setPredictTicks(float value) {
        predictTicksSetting.setValue(this, DELEGATED_PROPERTIES[11], Float.valueOf(value));
    }

    private int getRollBackTicks() {
        return (Number) rollBackTicksSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private void setRollBackTicks(int value) {
        rollBackTicksSetting.setValue(this, DELEGATED_PROPERTIES[12], Integer.valueOf(value));
    }

    public void updateValue(long arg0) {
        countValue = 1;
        countValue2 = 0;
        preciseValue = 0.2873D;
        serviceComponent10.executeAction();
        if (arg0 >= 0L) {
        }
    }

    private void onPreSyncEvent(PreSyncEvent arg0) {
        if (SharedKt.getPlayer().method_52535()) {
            if (var20 && var20) {
            }
        }
        if (var20) {
            if (this.getPauseInLiquids() || SharedKt.getPlayer().method_5715()) {
                return;
            }
        }
        int var21 = 0;
        Iterator iterator = SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_1009(0.5D, 0.0D, 0.5D).method_989(0.0D, -1.0D, 0.0D)).iterator();
        if (iterator.hasNext()) {
            class_265 var23 = (class_265) iterator.next();
            var21 = 1;
        }
        if (EventPacketHelper2.INSTANCE.checkCondition()) {
            if (var21) {
                if (var20 && var20 && var20) {
                    if (EventPacketHelper2.INSTANCE.getNumericValue() <= 0.0D) {
                        SharedKt.getPlayer().method_24830(1);
                        SharedKt.getPlayer().method_6043();
                    }
                }
            }
        }
        if (var20) {
        }
        ServiceComponent98.INSTANCE.updateValue2(1.088F);
        SharedKt.getPlayer().method_5762(0.0D, -0.003D, 0.0D);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getPlayer().method_52535()) {
            if (!(var69) && !(var69)) {
            }
        }
        if (!(var69)) {
            if (this.getPauseInLiquids() || SharedKt.getPlayer().method_5715()) {
                return;
            }
        }
        if (!(var69)) {
            EntityHelper3.INSTANCE.executeAction(this.getRollBackTicks());
            if (!(var69)) {
                if (this.getMode() == SpeedMode.GRIM_ENTITY && EventPacketHelper2.INSTANCE.checkCondition()) {
                }
                int var70 = 0;
                Iterable var72 = SharedKt.getWorld().method_18112();
                int var73 = 0;
                Object var74 = var72;
                Collection var75 = (Collection) new ArrayList();
                int var76 = 0;
                Iterator iterator = var74.iterator();
                if (iterator.hasNext()) {
                    Object var78 = iterator.next();
                    Entity entity = var78;
                    int var80 = 0;
                    if (!(var69)) {
                        if (!(var69)) {
                        }
                        if (!(var69)) {
                            if (entity instanceof class_1531) {
                                if (!(var69)) {
                                }
                            }
                        }
                        if (!(var69)) {
                            if (!(entity instanceof LivingEntity)) {
                                if (!(var69)) {
                                    if (!(Intrinsics.areEqual(entity, SharedKt.getPlayer())) && INSTANCE.getArmorStands() && entity instanceof class_1690) {
                                    }
                                }
                            }
                        } else {
                        }
                        var75.add();
                    }
                    Iterator iterator2 = var75.iterator();
                    if (iterator2.hasNext()) {
                        var72 = iterator2.next();
                        var73 = SharedKt.getPlayer().method_5829().method_1014(this.getDistance()).method_994(var72.method_5829());
                        var75 = EntityHelper3.INSTANCE.getMap();
                        var76 = 0;
                        if (!(var69)) {
                            if (!(var69)) {
                                if (var75.isEmpty()) {
                                }
                            }
                            iterator = var75.entrySet().iterator();
                            if (iterator.hasNext()) {
                                var78 = (Entry) iterator.next();
                                entity = var78;
                                var80 = 0;
                                if (!(var69)) {
                                    if ((Number) entity.getKey() == var72.method_5628()) {
                                    }
                                    Iterable var81 = (Iterable) entity.getValue();
                                    int var82 = 0;
                                    if (var81 instanceof Collection) {
                                        if (!(var69) && !(var69)) {
                                            if ((Collection) var81.isEmpty()) {
                                            }
                                        }
                                    }
                                    Iterator iterator3 = var81.iterator();
                                    if (iterator3.hasNext()) {
                                        Object var84 = iterator3.next();
                                        Box var85 = (Box) var84;
                                        int var86 = 0;
                                    } else {
                                    }
                                }
                            } else {
                            }
                            var74 = 0;
                            if (!(var69)) {
                                if (!(var74)) {
                                }
                            }
                        }
                    }
                    if (SharedKt.getPlayer().isOnGround()) {
                    }
                    iterator2 = this.getSpeed();
                    var75 = AuraModule.INSTANCE.getTarget();
                    if (AuraModule.INSTANCE.getEnabled() && var75 != null) {
                    }
                    var72 = new NoWhenBranchMatchedException();
                    var74 = EventPacketHelper2.process(((iterator2 / 100.0F) * var70), 0, 0.0F, 0.0F);
                    var75 = 0;
                    SharedKt.getPlayer().method_5762(var74[0], 0.0D, var74[1]);
                }
            }
            var70 = countValue2;
            countValue2 = (var70 + -1);
        }
        var70 = ItemPacketHelper.INSTANCE.computeValue();
        var72 = new Item[1];
        var72[0] = Items.FIREWORK_ROCKET;
        iterator2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        var72 = Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.FIREWORK_ROCKET);
        if (!(var69)) {
            if (!(iterator2.isActive())) {
                var74 = new Item[1];
                var74[0] = Items.FIREWORK_ROCKET;
                var73 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
                if (!(var69)) {
                    if (var73.isActive()) {
                        HandServiceComponent.e(var73.getNumericValue(), (this.getFireWorkSlot() - 1), class_1713.field_7791);
                    }
                }
            }
        }
        if (!(var69)) {
        }
        if (!(iterator2.isActive())) {
            if (!(var69) && !(var69)) {
            }
        }
        if (!(var69)) {
        }
        if (!(var69)) {
        }
        if (!(var69)) {
        }
        if (!(var69)) {
            if (var70 != -2) {
                HandServiceComponent.e();
                HandServiceComponent.e();
                HandServiceComponent.e();
            }
            ElytraSwapModule.INSTANCE.updateValue(1);
            PacketPacketHelper.handlePacket((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982));
            SharedKt.getPlayer().startFallFlying();
        }
        var73 = SharedKt.getPlayer().method_31548().method_67532();
        if (var73 != iterator2.getNumericValue()) {
            if (!(var69) && !(var69)) {
                if (!(var72)) {
                    ItemPacketHelper.INSTANCE.executeAction(iterator2.getNumericValue());
                }
            }
        }
        if (var72) {
        }
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        if (!(var69)) {
            if (!(var69)) {
                if (var73 != iterator2.getNumericValue() && !(var72)) {
                    ItemPacketHelper.INSTANCE.executeAction();
                }
            }
            if (!(var69)) {
            }
            if (var70 != -2) {
                HandServiceComponent.e();
                HandServiceComponent.e();
                HandServiceComponent.e();
            }
        }
        countValue2 = this.getDelay();
    }

    private void onMoveEvent(MoveEvent arg0) {
        if (!(var29)) {
            if (SharedKt.getPlayer().method_31549().field_7479) {
                return;
            }
        }
        if (!(var29)) {
            if (SharedKt.getPlayer().isFallFlying()) {
                return;
            }
        }
        if (!(var29)) {
            if (SharedKt.getPlayer().method_7344().method_7586() <= 6) {
                return;
            }
        }
        if (!(var29)) {
            if (arg0.getCancelled()) {
                return;
            }
        }
        if (SharedKt.getPlayer().method_52535()) {
            if (!(var29) && !(var29)) {
            }
        }
        if (!(var29)) {
            if (this.getPauseInLiquids() || SharedKt.getPlayer().method_5715()) {
                return;
            }
        }
        if (!(var29)) {
            if (this.getMode() != SpeedMode.NCP) {
            }
            if (!(var29)) {
                if (this.getMode() == SpeedMode.STRICT_STRAFE) {
                }
                if (!(var29)) {
                    if (EventPacketHelper2.INSTANCE.checkCondition()) {
                        if (!(var29)) {
                        }
                        if (this.getUseTimer()) {
                            ServiceComponent98.INSTANCE.updateValue2(1.088F);
                        }
                    }
                    if (!(var29)) {
                        if (!(var29)) {
                        }
                        if (this.getMode() == SpeedMode.NCP && SharedKt.getPlayer().field_3913.method_3128().field_1342 <= 0.0F && factorValue > 0.0F) {
                        }
                    } else {
                    }
                    float var30 = EventPacketHelper2.INSTANCE.getNumericValue();
                    if (SharedKt.getPlayer().field_5976) {
                        if (!(var29) && !(var29)) {
                            if (!(StepModule.INSTANCE.getEnabled())) {
                            }
                        }
                    } else {
                    }
                    int var31 = 0;
                    if (!(var29)) {
                        if (!(var29)) {
                            if (!(var29)) {
                                if (countValue == 1 && SharedKt.getPlayer().isOnGround() && var31) {
                                    SharedKt.getPlayer().method_18800(SharedKt.getPlayer().method_18798().field_1352, EventPacketHelper2.INSTANCE.computeValue2(), SharedKt.getPlayer().method_18798().field_1350);
                                    arg0.setY(EventPacketHelper2.INSTANCE.computeValue2());
                                    preciseValue = (preciseValue * 2.149D);
                                    countValue = 2;
                                    if (var29) {
                                    }
                                }
                            }
                            if (!(var29)) {
                            }
                            if (countValue == 2) {
                                preciseValue = (var30 - (0.66D * (var30 - EventPacketHelper2.INSTANCE.computeValue())));
                                countValue = 3;
                                if (var29) {
                                }
                            }
                            if (!(SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_989(0.0D, SharedKt.getPlayer().method_18798().method_10214(), 0.0D)).iterator().hasNext())) {
                                if (!(var29) && !(var29)) {
                                    if (SharedKt.getPlayer().field_5992) {
                                    }
                                }
                                countValue = 1;
                            }
                            preciseValue = (var30 - (var30 / 159.0D));
                        }
                    }
                    if (!(var29)) {
                        preciseValue = Math.max(preciseValue, EventPacketHelper2.INSTANCE.computeValue());
                        if (this.getMode() != SpeedMode.STRICT_STRAFE) {
                            if (SharedKt.getPlayer().field_3913.method_3128().field_1342 < 1.0F) {
                            }
                        }
                    } else {
                    }
                    double var32 = 0.576D;
                    if (this.getMode() != SpeedMode.STRICT_STRAFE) {
                        if (SharedKt.getPlayer().field_3913.method_3128().field_1342 < 1.0F) {
                        }
                    }
                    double var34 = 0.57D;
                    if (!(var29)) {
                        if (SharedKt.getPlayer().method_6059(class_1294.field_5904)) {
                            int var36 = SharedKt.getPlayer().method_6112(class_1294.field_5904).method_5578();
                            var32 = (var32 * (1 + (0.2D * (var36 + 1))));
                            var34 = (var34 * (1 + (0.2D * (var36 + 1))));
                        }
                    }
                    if (!(var29)) {
                        if (SharedKt.getPlayer().method_6059(class_1294.field_5909)) {
                        }
                        var36 = SharedKt.getPlayer().method_6112(class_1294.field_5909).method_5578();
                        var32 = (var32 / (1 + (0.2D * (var36 + 1))));
                        var34 = (var34 / (1 + (0.2D * (var36 + 1))));
                    }
                    if (countValue2 > 25) {
                    }
                    preciseValue = Math.min();
                    var36 = countValue2;
                    countValue2 = (var36 + 1);
                    if (!(var29)) {
                        if (var36 > 50) {
                            countValue2 = 0;
                        }
                        EventPacketHelper2.INSTANCE.executeAction(arg0, preciseValue);
                        factorValue = SharedKt.getPlayer().field_3913.method_3128().field_1342;
                    }
                    if (var29) {
                    }
                    arg0.setX(0.0D);
                    arg0.setZ(0.0D);
                }
                arg0.cancel();
            }
        }
        if (!(var29)) {
        }
        if (!(var29)) {
        }
        arg0.setX((arg0.getX() * 2));
        arg0.setZ((arg0.getZ() * 2));
        SharedKt.getPlayer().method_18799(SharedKt.getPlayer().method_18798().method_18805(2.0D, 1.0D, 2.0D));
        arg0.cancel();
    }

    private static boolean isActive() {
        if (var4) {
        }
        if (var4) {
            if (INSTANCE.getMode() != SpeedMode.NCP && INSTANCE.getMode() != SpeedMode.STRICT_STRAFE) {
            }
            if (INSTANCE.getMode() == SpeedMode.MATRIX) {
            }
        }
        return false;
    }

    private static boolean isActive2() {
        return INSTANCE.getMode() == SpeedMode.FIREWORK;
    }

    private static boolean isActive3() {
        return INSTANCE.getMode() == SpeedMode.FIREWORK;
    }

    private static boolean isActive4() {
        return INSTANCE.getMode() == SpeedMode.GRIM_ENTITY;
    }

    private static boolean isActive5() {
        return INSTANCE.getMode() == SpeedMode.GRIM_ENTITY;
    }

    private static boolean isActive6() {
        return INSTANCE.getMode() == SpeedMode.GRIM_ENTITY;
    }

    private static boolean isActive7() {
        return INSTANCE.getMode() == SpeedMode.GRIM_ENTITY;
    }

    private static boolean isActive8() {
        return INSTANCE.getMode() == SpeedMode.GRIM_ENTITY;
    }

    private static boolean isActive9() {
        if (!(var6)) {
        }
        return INSTANCE.getBoostAngle() == SpeedBoostAngleMode.PREDICT;
    }

    private static boolean isActive10() {
        return INSTANCE.getMode() == SpeedMode.GRIM_ENTITY;
    }

    static {
        KProperty[] var32 = new KProperty[13];
        INSTANCE = new SpeedModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", SpeedMode.NCP);
        useTimerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "use-timer", 0, null, this::isActive);
        pauseInLiquidsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-in-liquids");
        pauseWhileSneakingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-while-sneaking");
        fireWorkSlotSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire-slot", 1, new IntRange(1, 9), null, this::isActive2);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 8, new IntRange(1, 20), null, this::isActive3);
        armorStandsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "armor-stands", 0, null, this::isActive4);
        distanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "distance", 1.0F, RangesKt.rangeTo(0.1F, 2.0F), null, this::isActive5);
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 8.0F, RangesKt.rangeTo(0.1F, 10.0F), null, this::isActive6);
        groundSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ground-speed", 8.0F, RangesKt.rangeTo(0.1F, 10.0F), null, this::isActive7);
        boostAngleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "boost-angle", SpeedBoostAngleMode.SERVER, null, this::isActive8);
        predictTicksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "predict-ticks", 3.0F, RangesKt.rangeTo(0.0F, 10.0F), null, this::isActive9);
        rollBackTicksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rollback-ticks", 5, new IntRange(0, 30), null, this::isActive10);
        serviceComponent10 = new ServiceComponent10();
    }

}
