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
        return ((SpeedMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getUseTimer() {
        return ((Boolean) useTimerSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setUseTimer(boolean value) {
        useTimerSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private boolean getPauseInLiquids() {
        return ((Boolean) pauseInLiquidsSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setPauseInLiquids(boolean value) {
        pauseInLiquidsSetting.setValue(this, DELEGATED_PROPERTIES[2], Boolean.valueOf(value));
    }

    private boolean getPauseWhileSneaking() {
        return ((Boolean) pauseWhileSneakingSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setPauseWhileSneaking(boolean value) {
        pauseWhileSneakingSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private int getFireWorkSlot() {
        return ((Number) fireWorkSlotSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private int getDelay() {
        return ((Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getArmorStands() {
        return ((Boolean) armorStandsSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private float getDistance() {
        return ((Number) distanceSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private void setDistance(float value) {
        distanceSetting.setValue(this, DELEGATED_PROPERTIES[7], Float.valueOf(value));
    }

    private float getSpeed() {
        return ((Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private void setSpeed(float value) {
        speedSetting.setValue(this, DELEGATED_PROPERTIES[8], Float.valueOf(value));
    }

    private float getGroundSpeed() {
        return ((Number) groundSpeedSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private void setGroundSpeed(float value) {
        groundSpeedSetting.setValue(this, DELEGATED_PROPERTIES[9], Float.valueOf(value));
    }

    private SpeedBoostAngleMode getBoostAngle() {
        return ((SpeedBoostAngleMode) boostAngleSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private void setBoostAngle(SpeedBoostAngleMode value) {
        boostAngleSetting.setValue(this, DELEGATED_PROPERTIES[10], value);
    }

    private float getPredictTicks() {
        return ((Number) predictTicksSetting.getValue(this, DELEGATED_PROPERTIES[11]));
    }

    private void setPredictTicks(float value) {
        predictTicksSetting.setValue(this, DELEGATED_PROPERTIES[11], Float.valueOf(value));
    }

    private int getRollBackTicks() {
        return ((Number) rollBackTicksSetting.getValue(this, DELEGATED_PROPERTIES[12]));
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
        }
        if (this.getPauseInLiquids() || SharedKt.getPlayer().method_5715()) {
            return;
        }
        int index = 0;
        Iterator iterator = SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_1009(0.5D, 0.0D, 0.5D).method_989(0.0D, -1.0D, 0.0D)).iterator();
        while (iterator.hasNext()) {
            class_265 class265 = ((class_265) iterator.next());
            index = 1;
        }
        if (EventPacketHelper2.INSTANCE.checkCondition() && index && EventPacketHelper2.INSTANCE.getNumericValue() <= 0.0D) {
            SharedKt.getPlayer().method_24830(true);
            SharedKt.getPlayer().method_6043();
        }
        ServiceComponent98.INSTANCE.updateValue2(1.088F);
        SharedKt.getPlayer().method_5762(0.0D, -0.003D, 0.0D);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getPlayer().method_52535()) {
        }
        if (this.getPauseInLiquids() || SharedKt.getPlayer().method_5715()) {
            return;
        }
        EntityHelper3.INSTANCE.executeAction(this.getRollBackTicks());
        if (this.getMode() == SpeedMode.GRIM_ENTITY && EventPacketHelper2.INSTANCE.checkCondition()) {
            int index = 0;
            Iterable iterable = SharedKt.getWorld().method_18112();
            int index2 = 0;
            Iterable iterable2 = iterable;
            Collection collection = ((Collection) new ArrayList());
            Iterator iterator = iterable2.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                Entity entity = element;
                if (entity instanceof class_1531) {
                }
                if (!(entity instanceof LivingEntity)) {
                    if (!(Intrinsics.areEqual(entity, SharedKt.getPlayer())) && INSTANCE.getArmorStands() && entity instanceof class_1690) {
                    } else {
                    }
                }
                collection.add(element);
            }
            Iterator iterator2 = collection.iterator();
            while (iterator2.hasNext()) {
                iterable = iterator2.next();
                index2 = SharedKt.getPlayer().method_5829().method_1014(this.getDistance()).method_994(iterable.method_5829());
                collection = EntityHelper3.INSTANCE.getMap();
                if (collection.isEmpty()) {
                }
                iterator = collection.entrySet().iterator();
                while (iterator.hasNext()) {
                    element = ((Entry) iterator.next());
                    entity = element;
                    if (((Number) entity.getKey()) == iterable.method_5628()) {
                        Iterable iterable3 = ((Iterable) entity.getValue());
                        if (iterable3 instanceof Collection && ((Collection) iterable3).isEmpty()) {
                        }
                        Iterator iterator3 = iterable3.iterator();
                        while (iterator3.hasNext()) {
                            Object element2 = iterator3.next();
                            Box box = ((Box) element2);
                        }
                    }
                }
                iterable2 = 0;
                if (!(iterable2)) {
                }
            }
            if (SharedKt.getPlayer().isOnGround()) {
            }
            iterator2 = this.getSpeed();
            collection = AuraModule.INSTANCE.getTarget();
            if (AuraModule.INSTANCE.getEnabled() && collection != null) {
            }
            iterable = new NoWhenBranchMatchedException();
            iterable2 = EventPacketHelper2.process(((iterator2 / 100.0F) * index), false, 0.0F, 0.0F, iterable);
            collection = 0;
            SharedKt.getPlayer().method_5762(iterable2[0], 0.0D, iterable2[1]);
        }
        index = countValue2;
        countValue2 = (index + -1);
        index = ItemPacketHelper.INSTANCE.computeValue();
        iterable = new Item[1];
        iterable[0] = Items.FIREWORK_ROCKET;
        iterator2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(iterable);
        iterable = Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.FIREWORK_ROCKET);
        if (!(iterator2.isActive())) {
            iterable2 = new Item[1];
            iterable2[0] = Items.FIREWORK_ROCKET;
            index2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(iterable2);
            if (index2.isActive()) {
                HandServiceComponent.e(index2.getNumericValue(), (this.getFireWorkSlot() - 1), class_1713.field_7791, false);
            }
        }
        if (!(iterator2.isActive())) {
        }
        if (index != -2) {
            HandServiceComponent.e(index, 0, null, false);
            HandServiceComponent.e(6, 0, null, false);
            HandServiceComponent.e(index, 0, null, true);
        }
        ElytraSwapModule.INSTANCE.updateValue(true);
        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
        SharedKt.getPlayer().startFallFlying();
        index2 = SharedKt.getPlayer().method_31548().method_67532();
        if (index2 != iterator2.getNumericValue() && !(iterable)) {
            ItemPacketHelper.INSTANCE.executeAction(iterator2.getNumericValue());
        }
        if (iterable) {
        }
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        if (index2 != iterator2.getNumericValue() && !(iterable)) {
            ItemPacketHelper.INSTANCE.executeAction(index2);
        }
        if (index != -2) {
            HandServiceComponent.e(index, 0, null, false);
            HandServiceComponent.e(6, 0, null, false);
            HandServiceComponent.e(index, 0, null, true);
        }
        countValue2 = this.getDelay();
    }

    private void onMoveEvent(MoveEvent arg0) {
        if (SharedKt.getPlayer().method_31549().field_7479) {
            return;
        }
        if (SharedKt.getPlayer().isFallFlying()) {
            return;
        }
        if (SharedKt.getPlayer().method_7344().method_7586() <= 6) {
            return;
        }
        if (arg0.getCancelled()) {
            return;
        }
        if (SharedKt.getPlayer().method_52535()) {
        }
        if (this.getPauseInLiquids() || SharedKt.getPlayer().method_5715()) {
            return;
        }
        if (this.getMode() != SpeedMode.NCP) {
            if (this.getMode() == SpeedMode.STRICT_STRAFE) {
                if (EventPacketHelper2.INSTANCE.checkCondition()) {
                    if (this.getUseTimer()) {
                        ServiceComponent98.INSTANCE.updateValue2(1.088F);
                    }
                    if (this.getMode() == SpeedMode.NCP && SharedKt.getPlayer().field_3913.method_3128().field_1342 <= 0.0F && factorValue > 0.0F) {
                    } else {
                    }
                    float factor = EventPacketHelper2.INSTANCE.getNumericValue();
                    if (SharedKt.getPlayer().field_5976) {
                        if (!(StepModule.INSTANCE.getEnabled())) {
                        } else {
                        }
                    }
                    int index = 0;
                    if (countValue == 1 && SharedKt.getPlayer().isOnGround() && index) {
                        SharedKt.getPlayer().method_18800(SharedKt.getPlayer().method_18798().field_1352, EventPacketHelper2.INSTANCE.computeValue2(), SharedKt.getPlayer().method_18798().field_1350);
                        arg0.setY(EventPacketHelper2.INSTANCE.computeValue2());
                        preciseValue = (preciseValue * 2.149D);
                        countValue = 2;
                    }
                    if (countValue == 2) {
                        preciseValue = (factor - (0.66D * (factor - EventPacketHelper2.INSTANCE.computeValue())));
                        countValue = 3;
                    }
                    if (!(SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_989(0.0D, SharedKt.getPlayer().method_18798().method_10214(), 0.0D)).iterator().hasNext())) {
                        if (SharedKt.getPlayer().field_5992) {
                            countValue = 1;
                        }
                    }
                    preciseValue = (factor - (factor / 159.0D));
                    preciseValue = Math.max(preciseValue, EventPacketHelper2.INSTANCE.computeValue());
                    if (this.getMode() != SpeedMode.STRICT_STRAFE) {
                        if (SharedKt.getPlayer().field_3913.method_3128().field_1342 < 1.0F) {
                        } else {
                        }
                    }
                    double offset = 0.576D;
                    if (this.getMode() != SpeedMode.STRICT_STRAFE) {
                        if (SharedKt.getPlayer().field_3913.method_3128().field_1342 < 1.0F) {
                        }
                    }
                    double offset2 = 0.57D;
                    if (SharedKt.getPlayer().method_6059(class_1294.field_5904)) {
                        int index2 = SharedKt.getPlayer().method_6112(class_1294.field_5904).method_5578();
                        offset = (offset * (1 + (0.2D * (index2 + 1))));
                        offset2 = (offset2 * (1 + (0.2D * (index2 + 1))));
                    }
                    if (SharedKt.getPlayer().method_6059(class_1294.field_5909)) {
                        index2 = SharedKt.getPlayer().method_6112(class_1294.field_5909).method_5578();
                        offset = (offset / (1 + (0.2D * (index2 + 1))));
                        offset2 = (offset2 / (1 + (0.2D * (index2 + 1))));
                    }
                    if (countValue2 > 25) {
                    }
                    preciseValue = Math.min(offset, offset2);
                    index2 = countValue2;
                    countValue2 = (index2 + 1);
                    if (index2 > 50) {
                        countValue2 = 0;
                    }
                    EventPacketHelper2.INSTANCE.executeAction(arg0, preciseValue);
                    factorValue = SharedKt.getPlayer().field_3913.method_3128().field_1342;
                } else {
                    arg0.setX(0.0D);
                    arg0.setZ(0.0D);
                }
                arg0.cancel();
            }
        }
        while (SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_1009(-0.299D, 0.0D, -0.299D).method_989(0.0D, arg0.getY(), 0.0D)).iterator().hasNext()) {
            arg0.setX((arg0.getX() * 2));
            arg0.setZ((arg0.getZ() * 2));
            SharedKt.getPlayer().method_18799(SharedKt.getPlayer().method_18798().method_18805(2.0D, 1.0D, 2.0D));
            arg0.cancel();
        }
    }

    private static boolean isActive() {
        if (INSTANCE.getMode() != SpeedMode.NCP && INSTANCE.getMode() != SpeedMode.STRICT_STRAFE) {
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
        return INSTANCE.getBoostAngle() == SpeedBoostAngleMode.PREDICT;
    }

    private static boolean isActive10() {
        return INSTANCE.getMode() == SpeedMode.GRIM_ENTITY;
    }

    static {
        KProperty[] items = new KProperty[13];
        INSTANCE = new SpeedModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", SpeedMode.NCP);
        useTimerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "use-timer", false, null, this::isActive);
        pauseInLiquidsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-in-liquids", false);
        pauseWhileSneakingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-while-sneaking", false);
        fireWorkSlotSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire-slot", 1, new IntRange(1, 9), null, this::isActive2);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 8, new IntRange(1, 20), null, this::isActive3);
        armorStandsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "armor-stands", false, null, this::isActive4);
        distanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "distance", 1.0F, RangesKt.rangeTo(0.1F, 2.0F), null, this::isActive5);
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 8.0F, RangesKt.rangeTo(0.1F, 10.0F), null, this::isActive6);
        groundSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ground-speed", 8.0F, RangesKt.rangeTo(0.1F, 10.0F), null, this::isActive7);
        boostAngleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "boost-angle", SpeedBoostAngleMode.SERVER, null, this::isActive8);
        predictTicksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "predict-ticks", 3.0F, RangesKt.rangeTo(0.0F, 10.0F), null, this::isActive9);
        rollBackTicksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rollback-ticks", 5, new IntRange(0, 30), null, this::isActive10);
        serviceComponent10 = new ServiceComponent10();
    }

}
