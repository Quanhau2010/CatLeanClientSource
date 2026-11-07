package su.catlean.client.features.modules.movement.rage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_239.class_240;
import net.minecraft.class_2616;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_3959;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_3965;
import net.minecraft.class_9323;
import net.minecraft.class_9334;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PostSyncEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.world.FireWorkVectorEvent;
import su.catlean.api.event.events.world.FireWorkVelocityEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.utility.equip.ElytraSwapModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.ServiceComponent71;
import su.catlean.client.services.client.ServiceComponent75;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.TitleRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class ElytraTargetModule extends Module {

    public static final ElytraTargetModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl2 predictSetting;
    private static final VisibleVisibleSettingPropertyImpl alwaysPredictSetting;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final VisibleVisibleSettingPropertyImpl offHandFireworkSetting;
    private static final VisibleVisibleSettingPropertyImpl bravoHvhSwapSetting;
    private static final RangeVisibleSettingPropertyImpl minSpeedSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseWhileEatingSetting;
    private static final VisibleVisibleSettingPropertyImpl peekAssistSetting;
    private static final VisibleVisibleSettingPropertyImpl fakeLagSetting;
    private static final VisibleVisibleSettingPropertyImpl onlyGroundPeekSetting;
    private static final VisibleVisibleSettingPropertyImpl boostSetting;
    private static final VisibleVisibleSettingPropertyImpl customSpeedSetting;
    private static final RangeVisibleSettingPropertyImpl2 degrees0Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees5Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees10Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees15Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees20Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees25Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees30Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees35Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees40Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees45Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees50Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees55Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees60Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees65Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees70Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees75Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees80Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees85Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees90Setting;
    private static final ServiceComponent38 serviceComponent38;
    private static final ServiceComponent38 serviceComponent382;
    private static final ServiceComponent38 serviceComponent383;
    private static final ServiceComponent38 serviceComponent384;
    private static boolean enabledFlag;
    private static MoveFixServiceComponent moveFixServiceComponent;
    private static Direction minecraftRef;
    private static boolean enabledFlag2;
    private static Box minecraftRef2;
    private static Box minecraftRef3;
    private static Vec3d vec3d;
    private static final HashMap hashMap;
    private static HashMap hashMap2;
    private static int[] countValueArray;

    private ElytraTargetModule() {
        super("elytra-target", SubCategoriesKt.getRageMovementCategory());
    }

    private float getPredict() {
        return ((Number) predictSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getAlwaysPredict() {
        return ((Boolean) alwaysPredictSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private int getDelay() {
        return ((Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getOffHandFirework() {
        return ((Boolean) offHandFireworkSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getBravoHvhSwap() {
        return ((Boolean) bravoHvhSwapSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private int getMinSpeed() {
        return ((Number) minSpeedSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getPauseWhileEating() {
        return ((Boolean) pauseWhileEatingSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getPeekAssist() {
        return ((Boolean) peekAssistSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private boolean getFakeLag() {
        return ((Boolean) fakeLagSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private boolean getOnlyGroundPeek() {
        return ((Boolean) onlyGroundPeekSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private boolean getBoost() {
        return ((Boolean) boostSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private boolean getCustomSpeed() {
        return ((Boolean) customSpeedSetting.getValue(this, DELEGATED_PROPERTIES[11]));
    }

    private float getDegrees0() {
        return ((Number) degrees0Setting.getValue(this, DELEGATED_PROPERTIES[12]));
    }

    private float getDegrees5() {
        return ((Number) degrees5Setting.getValue(this, DELEGATED_PROPERTIES[13]));
    }

    private float getDegrees10() {
        return ((Number) degrees10Setting.getValue(this, DELEGATED_PROPERTIES[14]));
    }

    private float getDegrees15() {
        return ((Number) degrees15Setting.getValue(this, DELEGATED_PROPERTIES[15]));
    }

    private float getDegrees20() {
        return ((Number) degrees20Setting.getValue(this, DELEGATED_PROPERTIES[16]));
    }

    private float getDegrees25() {
        return ((Number) degrees25Setting.getValue(this, DELEGATED_PROPERTIES[17]));
    }

    private float getDegrees30() {
        return ((Number) degrees30Setting.getValue(this, DELEGATED_PROPERTIES[18]));
    }

    private float getDegrees35() {
        return ((Number) degrees35Setting.getValue(this, DELEGATED_PROPERTIES[19]));
    }

    private float getDegrees40() {
        return ((Number) degrees40Setting.getValue(this, DELEGATED_PROPERTIES[20]));
    }

    private float getDegrees45() {
        return ((Number) degrees45Setting.getValue(this, DELEGATED_PROPERTIES[21]));
    }

    private float getDegrees50() {
        return ((Number) degrees50Setting.getValue(this, DELEGATED_PROPERTIES[22]));
    }

    private float getDegrees55() {
        return ((Number) degrees55Setting.getValue(this, DELEGATED_PROPERTIES[23]));
    }

    private float getDegrees60() {
        return ((Number) degrees60Setting.getValue(this, DELEGATED_PROPERTIES[24]));
    }

    private float getDegrees65() {
        return ((Number) degrees65Setting.getValue(this, DELEGATED_PROPERTIES[25]));
    }

    private float getDegrees70() {
        return ((Number) degrees70Setting.getValue(this, DELEGATED_PROPERTIES[26]));
    }

    private float getDegrees75() {
        return ((Number) degrees75Setting.getValue(this, DELEGATED_PROPERTIES[27]));
    }

    private float getDegrees80() {
        return ((Number) degrees80Setting.getValue(this, DELEGATED_PROPERTIES[28]));
    }

    private float getDegrees85() {
        return ((Number) degrees85Setting.getValue(this, DELEGATED_PROPERTIES[29]));
    }

    private float getDegrees90() {
        return ((Number) degrees90Setting.getValue(this, DELEGATED_PROPERTIES[30]));
    }

    public HashMap getHashMap() {
        return hashMap;
    }

    public void updateValue2() {
        TitleRenderHelper.INSTANCE.updateValue(true);
        BlinkModule.INSTANCE.updateValue2();
        TitleRenderHelper.INSTANCE.updateValue(false);
    }

    private void onPostSyncEvent(PostSyncEvent arg0) {
        if (this.getFakeLag()) {
            BlinkModule.INSTANCE.updateValue();
        }
        if (this.getOnlyGroundPeek()) {
            if (Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA) && SharedKt.getPlayer().isFallFlying() && AuraModule.INSTANCE.getTarget() != null && AuraModule.INSTANCE.getTarget() instanceof PlayerEntity && !(((PlayerEntity) AuraModule.INSTANCE.getTarget()).isFallFlying())) {
            } else {
            }
        }
        int index = 0;
        if (!(index) && BlinkModule.INSTANCE.getEnabled()) {
            TitleRenderHelper.INSTANCE.updateValue(true);
            BlinkModule.INSTANCE.updateValue2();
            enabledFlag2 = 0;
            TitleRenderHelper.INSTANCE.updateValue(false);
        }
        if (RotationServiceComponent.INSTANCE.getNumericValue() == RotationServiceComponent.INSTANCE.getNumericValue2() && this.getPeekAssist() && !(ElytraFreezeModule.INSTANCE.getEnabled()) && index) {
            enabledFlag = 1;
            moveFixServiceComponent = this.resolveMoveFixServiceComponent();
            serviceComponent382.updateValue();
            RunnableServiceComponent runnableServiceComponent = RunnableServiceComponent.INSTANCE;
            int index2 = 325;
            runnableServiceComponent.getExecutorService().execute(((Runnable) new ServiceComponent71(index2)));
        }
        runnableServiceComponent = new Item[1];
        runnableServiceComponent[0] = Items.FIREWORK_ROCKET;
        ElytraSwapModule.INSTANCE.updateValue(true);
        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
        serviceComponent383.updateValue();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (enabledFlag && moveFixServiceComponent != null) {
            SequenceServiceComponent.INSTANCE.executeAction(moveFixServiceComponent, 200);
        }
        if (SharedKt.getPlayer().method_6047().method_57353().method_57832(class_9334.field_50075) || SharedKt.getPlayer().method_6047().method_57353().method_57832(class_9334.field_49651)) {
            return;
        }
        this.executeAction(this.getOffHandFirework(), this.getBravoHvhSwap());
        serviceComponent38.updateValue();
    }

    private void onFireWorkVelocityEvent(FireWorkVelocityEvent arg0) {
        arg0.cancel();
        if (FireWorkVectorEvent.INSTANCE.call(SharedKt.getPlayer().method_5720())) {
        } else {
        }
        Vec3d vec = SharedKt.getPlayer().method_5720();
        if (this.getCustomSpeed()) {
            this.updateValue();
        }
        float factor = Math.abs(Math.toDegrees(Math.atan2(vec.field_1351, Math.hypot(vec.field_1352, vec.field_1350))));
        if (!(BlinkModule.INSTANCE.getEnabled())) {
            if (!(this.getBoost())) {
            } else {
                if (this.getCustomSpeed()) {
                } else {
                }
                Iterable iterable = ((Iterable) ((Map) hashMap).entrySet());
                Iterator iterator = iterable.iterator();
                if (!(iterator.hasNext())) {
                } else {
                    Object element = iterator.next();
                    if (!(iterator.hasNext())) {
                    } else {
                        Entry entry = ((Entry) element);
                        int index = 0;
                        entry = Math.abs((factor - ((Number) entry.getKey())));
                        index = iterator.next();
                        Entry entry2 = ((Entry) index);
                        entry2 = Math.abs((factor - ((Number) entry2.getKey())));
                        if (Float.compare(entry, entry2) > 0) {
                            element = index;
                            entry = entry2;
                        }
                    }
                }
                if (((Entry) element) != null) {
                } else {
                }
            }
        }
        float factor2 = 0.1F;
        float factor3 = 1.5F;
        Vec3d vec2 = SharedKt.getPlayer().method_18798();
        arg0.setVelocity(vec2.method_1031(((vec.field_1352 * factor2) + (((vec.field_1352 * factor3) - vec2.field_1352) * 0.5D)), ((vec.field_1351 * factor2) + (((vec.field_1351 * factor3) - vec2.field_1351) * 0.5D)), ((vec.field_1350 * factor2) + (((vec.field_1350 * factor3) - vec2.field_1350) * 0.5D))));
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        Box box = TextShaderComponent2.resolveMinecraftObject(minecraftRef3, minecraftRef2, 0.0F);
        TextShaderComponent2.checkCondition(box, NewThemeRenderHelper.INSTANCE.resolveColor(0));
        TextShaderComponent2.checkCondition(box, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor(0), 1.0F));
    }

    private void onReceivePacket(ReceivePacket arg0) {
        Packet packet = arg0.getPacket();
        if (((class_2616) packet).method_11267()) {
        }
        serviceComponent384.updateValue();
    }

    public void executeAction(boolean offhand, boolean alt) {
        Item[] items = new Item[1];
        items[0] = Items.FIREWORK_ROCKET;
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
        Item[] items2 = new Item[1];
        items2[0] = Items.FIREWORK_ROCKET;
        items = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items2);
        if (offhand) {
            if (BlinkModule.INSTANCE.getEnabled()) {
                ItemPacketHelper.INSTANCE.updateValue();
                if (stackServiceComponent2.isActive()) {
                    stackServiceComponent2.updateValue();
                }
                if (items.isActive()) {
                    HandServiceComponent.executeAction(items.getNumericValue(), ((SharedKt.getPlayer().method_31548().method_67532() % 8) + 1), class_1713.field_7791, true);
                    ItemPacketHelper.INSTANCE.executeAction(((SharedKt.getPlayer().method_31548().method_67532() % 8) + 1));
                } else {
                    if (!(Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.FIREWORK_ROCKET))) {
                        this.executeAction(MessageServiceComponent.resolveString(this, "no-fireworks", new Object[0], true));
                        return;
                    }
                }
                if (Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.FIREWORK_ROCKET)) {
                } else {
                }
                HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
                ItemPacketHelper.INSTANCE.updateValue2();
                HandServiceComponent.executeAction(items.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, true);
            } else {
                if (!(Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.FIREWORK_ROCKET))) {
                    if (items.isActive()) {
                        GuiMoveModule.INSTANCE.updateValue(true);
                        if (alt) {
                            HandServiceComponent.e(items.getNumericValue(), 0, null, false);
                            HandServiceComponent.e(45, 0, null, false);
                            HandServiceComponent.e(items.getNumericValue(), 0, null, false);
                        } else {
                            HandServiceComponent.e(items.getNumericValue(), 40, class_1713.field_7791, false);
                        }
                        if (Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.FIREWORK_ROCKET)) {
                        } else {
                        }
                        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
                        HandServiceComponent.executeAction(items.getNumericValue(), 40, class_1713.field_7791, true);
                        GuiMoveModule.INSTANCE.updateValue(false);
                    } else {
                        this.executeAction(MessageServiceComponent.resolveString(this, "no-fireworks", new Object[0], true));
                        if (Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.FIREWORK_ROCKET)) {
                        } else {
                        }
                        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
                    }
                } else {
                }
            }
        }
    }

    public void executeAction(Box box) {
        minecraftRef3 = minecraftRef2;
        minecraftRef2 = box;
    }

    private MoveFixServiceComponent resolveMoveFixServiceComponent() {
        Iterator iterator = ServiceComponent75.enumEntries.iterator();
        while (iterator.hasNext()) {
            Direction direction = ((Direction) iterator.next());
            Vector3f vector3f = direction.method_23955().mul(14.0F);
            if (direction == minecraftRef) {
            }
            class_3965 class3965 = SharedKt.getWorld().method_17742(new class_3959(this.resolveMinecraftObject(SharedKt.getPlayer()), this.resolveMinecraftObject(SharedKt.getPlayer()).method_1031(vector3f.x, vector3f.y, vector3f.z), class_3960.field_17558, class_242.field_1348, SharedKt.getPlayer()));
            class_3965 class39652 = SharedKt.getWorld().method_17742(new class_3959(this.resolveMinecraftObject(SharedKt.getPlayer()).method_1031(0.0D, SharedKt.getPlayer().method_5829().method_17940(), 0.0D), this.resolveMinecraftObject(SharedKt.getPlayer()).method_1031(vector3f.x, (vector3f.y + SharedKt.getPlayer().method_5829().method_17940()), vector3f.z), class_3960.field_17558, class_242.field_1348, SharedKt.getPlayer()));
            minecraftRef = direction;
            moveFixServiceComponent = __UNDEF_KEY__;
            return __UNDEF_KEY__;
        }
        return new MoveFixServiceComponent(EventPacketHelper2.INSTANCE.computeValue(), -88.0F, false);
    }

    private void updateValue() {
        Pair[] items = new Pair[19];
        items[0] = TuplesKt.to(Float.valueOf(0.0F), Float.valueOf(this.getDegrees0()));
        items[1] = TuplesKt.to(Float.valueOf(5.0F), Float.valueOf(this.getDegrees5()));
        items[2] = TuplesKt.to(Float.valueOf(10.0F), Float.valueOf(this.getDegrees10()));
        items[3] = TuplesKt.to(Float.valueOf(15.0F), Float.valueOf(this.getDegrees15()));
        items[4] = TuplesKt.to(Float.valueOf(20.0F), Float.valueOf(this.getDegrees20()));
        items[5] = TuplesKt.to(Float.valueOf(25.0F), Float.valueOf(this.getDegrees25()));
        items[6] = TuplesKt.to(Float.valueOf(30.0F), Float.valueOf(this.getDegrees30()));
        items[7] = TuplesKt.to(Float.valueOf(35.0F), Float.valueOf(this.getDegrees35()));
        items[8] = TuplesKt.to(Float.valueOf(40.0F), Float.valueOf(this.getDegrees40()));
        items[9] = TuplesKt.to(Float.valueOf(45.0F), Float.valueOf(this.getDegrees45()));
        items[10] = TuplesKt.to(Float.valueOf(50.0F), Float.valueOf(this.getDegrees50()));
        items[11] = TuplesKt.to(Float.valueOf(55.0F), Float.valueOf(this.getDegrees55()));
        items[12] = TuplesKt.to(Float.valueOf(60.0F), Float.valueOf(this.getDegrees60()));
        items[13] = TuplesKt.to(Float.valueOf(65.0F), Float.valueOf(this.getDegrees65()));
        items[14] = TuplesKt.to(Float.valueOf(70.0F), Float.valueOf(this.getDegrees70()));
        items[15] = TuplesKt.to(Float.valueOf(75.0F), Float.valueOf(this.getDegrees75()));
        items[16] = TuplesKt.to(Float.valueOf(80.0F), Float.valueOf(this.getDegrees80()));
        items[17] = TuplesKt.to(Float.valueOf(85.0F), Float.valueOf(this.getDegrees85()));
        items[18] = TuplesKt.to(Float.valueOf(90.0F), Float.valueOf(this.getDegrees90()));
        hashMap2 = MapsKt.hashMapOf(items);
    }

    public float computeValue() {
        if (AuraModule.INSTANCE.getTarget() == null) {
            AuraModule.INSTANCE.getTarget();
            return 0.0F;
        }
        if (vec3d == null) {
            vec3d = this.resolveMinecraftObject();
        } else {
            if (vec3d.method_1022(this.resolveMinecraftObject()) < 0.10000000149011612D) {
                vec3d = this.resolveMinecraftObject();
                return 0.0F;
            }
        }
        if (!(serviceComponent384.checkCondition(15))) {
            if (this.getAlwaysPredict()) {
            } else {
            }
        }
        return 0.0F;
    }

    public Vec3d resolveMinecraftObject(Entity player) {
        return new Vec3d((player.getX() - player.field_6014), (player.getY() - player.field_6036), (player.getZ() - player.field_5969));
    }

    private static boolean isActive() {
        return INSTANCE.getOffHandFirework();
    }

    private static boolean isActive2() {
        return INSTANCE.getPeekAssist();
    }

    private static boolean isActive3() {
        return INSTANCE.getPeekAssist();
    }

    private static boolean isActive4() {
        return INSTANCE.getBoost();
    }

    private static boolean isActive5() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive6() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive7() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive8() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive9() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive10() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive11() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive12() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive13() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive14() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive15() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive16() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive17() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive18() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive19() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive20() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive21() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive22() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive23() {
        return INSTANCE.getCustomSpeed();
    }

    public static void updateValue(boolean value) {
        enabledFlag = value;
    }

    public static void updateValue2(boolean value) {
        enabledFlag2 = value;
    }

    public static boolean checkCondition(ElytraTargetModule $this) {
        return $this.getFakeLag();
    }

    static {
        KProperty[] items = new KProperty[31];
        INSTANCE = new ElytraTargetModule();
        predictSetting = VisibleRenderHelper.registerSetting(INSTANCE, "predict-ticks", 0.0F, RangesKt.rangeTo(0.0F, 5.0F));
        alwaysPredictSetting = VisibleRenderHelper.registerSetting(INSTANCE, "always-predict", false);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 10, new IntRange(0, 30));
        offHandFireworkSetting = VisibleRenderHelper.registerSetting(INSTANCE, "offhand-firework", true);
        bravoHvhSwapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "bravo-hvh-swap", true, null, this::isActive);
        minSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-speed", 120, new IntRange(0, 200));
        pauseWhileEatingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-while-eating", true);
        peekAssistSetting = VisibleRenderHelper.registerSetting(INSTANCE, "peek-assist", true);
        fakeLagSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fake-lag", true, null, this::isActive2);
        onlyGroundPeekSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-ground-peek", true, null, this::isActive3);
        boostSetting = VisibleRenderHelper.registerSetting(INSTANCE, "boost", true);
        customSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "custom-speed", false, null, this::isActive4);
        degrees0Setting = VisibleRenderHelper.registerSetting(INSTANCE, "0-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive5);
        degrees5Setting = VisibleRenderHelper.registerSetting(INSTANCE, "5-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive6);
        degrees10Setting = VisibleRenderHelper.registerSetting(INSTANCE, "10-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive7);
        degrees15Setting = VisibleRenderHelper.registerSetting(INSTANCE, "15-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive8);
        degrees20Setting = VisibleRenderHelper.registerSetting(INSTANCE, "20-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive9);
        degrees25Setting = VisibleRenderHelper.registerSetting(INSTANCE, "25-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive10);
        degrees30Setting = VisibleRenderHelper.registerSetting(INSTANCE, "30-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive11);
        degrees35Setting = VisibleRenderHelper.registerSetting(INSTANCE, "35-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive12);
        degrees40Setting = VisibleRenderHelper.registerSetting(INSTANCE, "40-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive13);
        degrees45Setting = VisibleRenderHelper.registerSetting(INSTANCE, "45-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive14);
        degrees50Setting = VisibleRenderHelper.registerSetting(INSTANCE, "50-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive15);
        degrees55Setting = VisibleRenderHelper.registerSetting(INSTANCE, "55-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive16);
        degrees60Setting = VisibleRenderHelper.registerSetting(INSTANCE, "60-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive17);
        degrees65Setting = VisibleRenderHelper.registerSetting(INSTANCE, "65-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive18);
        degrees70Setting = VisibleRenderHelper.registerSetting(INSTANCE, "70-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive19);
        degrees75Setting = VisibleRenderHelper.registerSetting(INSTANCE, "75-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive20);
        degrees80Setting = VisibleRenderHelper.registerSetting(INSTANCE, "80-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive21);
        degrees85Setting = VisibleRenderHelper.registerSetting(INSTANCE, "85-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive22);
        degrees90Setting = VisibleRenderHelper.registerSetting(INSTANCE, "90-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive23);
        serviceComponent38 = new ServiceComponent38();
        serviceComponent382 = new ServiceComponent38();
        serviceComponent383 = new ServiceComponent38();
        serviceComponent384 = new ServiceComponent38();
        items = new Pair[19];
        items[0] = TuplesKt.to(Float.valueOf(0.0F), Float.valueOf(0.155F));
        items[1] = TuplesKt.to(Float.valueOf(5.0F), Float.valueOf(0.16F));
        items[2] = TuplesKt.to(Float.valueOf(10.0F), Float.valueOf(0.19F));
        items[3] = TuplesKt.to(Float.valueOf(15.0F), Float.valueOf(0.22F));
        items[4] = TuplesKt.to(Float.valueOf(20.0F), Float.valueOf(0.22F));
        items[5] = TuplesKt.to(Float.valueOf(25.0F), Float.valueOf(0.27F));
        items[6] = TuplesKt.to(Float.valueOf(30.0F), Float.valueOf(0.28F));
        items[7] = TuplesKt.to(Float.valueOf(35.0F), Float.valueOf(0.34F));
        items[8] = TuplesKt.to(Float.valueOf(40.0F), Float.valueOf(0.37F));
        items[9] = TuplesKt.to(Float.valueOf(45.0F), Float.valueOf(0.37F));
        items[10] = TuplesKt.to(Float.valueOf(50.0F), Float.valueOf(0.34F));
        items[11] = TuplesKt.to(Float.valueOf(55.0F), Float.valueOf(0.34F));
        items[12] = TuplesKt.to(Float.valueOf(60.0F), Float.valueOf(0.2F));
        items[13] = TuplesKt.to(Float.valueOf(65.0F), Float.valueOf(0.18F));
        items[14] = TuplesKt.to(Float.valueOf(70.0F), Float.valueOf(0.16F));
        items[15] = TuplesKt.to(Float.valueOf(75.0F), Float.valueOf(0.16F));
        items[16] = TuplesKt.to(Float.valueOf(80.0F), Float.valueOf(0.13F));
        items[17] = TuplesKt.to(Float.valueOf(85.0F), Float.valueOf(0.13F));
        items[18] = TuplesKt.to(Float.valueOf(90.0F), Float.valueOf(0.13F));
        hashMap = MapsKt.hashMapOf(items);
        items = new Pair[19];
        items[0] = TuplesKt.to(Float.valueOf(0.0F), Float.valueOf(0.155F));
        items[1] = TuplesKt.to(Float.valueOf(5.0F), Float.valueOf(0.16F));
        items[2] = TuplesKt.to(Float.valueOf(10.0F), Float.valueOf(0.19F));
        items[3] = TuplesKt.to(Float.valueOf(15.0F), Float.valueOf(0.22F));
        items[4] = TuplesKt.to(Float.valueOf(20.0F), Float.valueOf(0.22F));
        items[5] = TuplesKt.to(Float.valueOf(25.0F), Float.valueOf(0.27F));
        items[6] = TuplesKt.to(Float.valueOf(30.0F), Float.valueOf(0.28F));
        items[7] = TuplesKt.to(Float.valueOf(35.0F), Float.valueOf(0.34F));
        items[8] = TuplesKt.to(Float.valueOf(40.0F), Float.valueOf(0.37F));
        items[9] = TuplesKt.to(Float.valueOf(45.0F), Float.valueOf(0.37F));
        items[10] = TuplesKt.to(Float.valueOf(50.0F), Float.valueOf(0.34F));
        items[11] = TuplesKt.to(Float.valueOf(55.0F), Float.valueOf(0.34F));
        items[12] = TuplesKt.to(Float.valueOf(60.0F), Float.valueOf(0.2F));
        items[13] = TuplesKt.to(Float.valueOf(65.0F), Float.valueOf(0.18F));
        items[14] = TuplesKt.to(Float.valueOf(70.0F), Float.valueOf(0.16F));
        items[15] = TuplesKt.to(Float.valueOf(75.0F), Float.valueOf(0.16F));
        items[16] = TuplesKt.to(Float.valueOf(80.0F), Float.valueOf(0.13F));
        items[17] = TuplesKt.to(Float.valueOf(85.0F), Float.valueOf(0.13F));
        items[18] = TuplesKt.to(Float.valueOf(90.0F), Float.valueOf(0.13F));
        hashMap2 = MapsKt.hashMapOf(items);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
