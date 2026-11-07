package su.catlean.client.features.modules.movement.basic;

import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1294;
import net.minecraft.class_1702;
import net.minecraft.class_2708;
import net.minecraft.class_2739;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_3675.class_306;
import net.minecraft.class_4050;
import net.minecraft.class_6373;
import net.minecraft.class_6374;
import net.minecraft.class_8705;
import net.minecraft.class_9334;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Box;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.AfterElytraEvent;
import su.catlean.api.event.events.player.EventPlayerTravel;
import su.catlean.api.event.events.player.EventPostPlayerTravel;
import su.catlean.api.event.events.player.FallFlyingEvent;
import su.catlean.api.event.events.player.JumpEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PreElytraEvent;
import su.catlean.api.event.events.player.SetPoseEvent;
import su.catlean.api.event.events.player.ShouldStopSprintingEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.equip.ElytraSwapModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.mixins.accessors.KeyMappingAccessor;
import su.catlean.mixins.accessors.LivingEntityAccessor;
import su.catlean.mixins.accessors.LocalPlayerAccessor;

public class ElytraRecastModule extends Module {

    public static final ElytraRecastModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl grimSetting;
    private static final VisibleVisibleSettingPropertyImpl tunnelsOffsetSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 bypassSetting;
    private static final VisibleVisibleSettingPropertyImpl grimDurabilitySetting;
    private static final VisibleVisibleSettingPropertyImpl changePitchSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchValueSetting;
    private static final VisibleVisibleSettingPropertyImpl allowBrokenSetting;
    private static float factorValue;
    private static float factorValue2;
    private static float factorValue3;
    private static float factorValue4;
    private static float factorValue5;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static boolean enabledFlag3;
    private static boolean enabledFlag4;
    private static int countValue;
    private static final Queue queue;
    private static final Queue queue2;
    private static final LinkedList linkedList;
    private static final LinkedList linkedList2;
    private static boolean enabledFlag5;
    private static double preciseValue;

    private ElytraRecastModule() {
        super("elytra-recast", SubCategoriesKt.getBasicMovementCategory());
    }

    private boolean getGrim() {
        return (Boolean) grimSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setGrim(boolean value) {
        grimSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    private boolean getTunnelsOffset() {
        return (Boolean) tunnelsOffsetSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setTunnelsOffset(boolean value) {
        tunnelsOffsetSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private ElytraRecastBypassMode getBypass() {
        return (ElytraRecastBypassMode) bypassSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setBypass(ElytraRecastBypassMode value) {
        bypassSetting.setValue(this, DELEGATED_PROPERTIES[2], value);
    }

    private boolean getGrimDurability() {
        return (Boolean) grimDurabilitySetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setGrimDurability(boolean value) {
        grimDurabilitySetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private boolean getChangePitch() {
        return (Boolean) changePitchSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void setChangePitch(boolean value) {
        changePitchSetting.setValue(this, DELEGATED_PROPERTIES[4], Boolean.valueOf(value));
    }

    private float getPitchValue() {
        return (Number) pitchValueSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private void setPitchValue(float value) {
        pitchValueSetting.setValue(this, DELEGATED_PROPERTIES[5], Float.valueOf(value));
    }

    private boolean getAllowBroken() {
        return (Boolean) allowBrokenSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private void setAllowBroken(boolean value) {
        allowBrokenSetting.setValue(this, DELEGATED_PROPERTIES[6], Boolean.valueOf(value));
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 32978412894279L);
        long var5 = (arg0 ^ 67464996320865L);
        enabledFlag4 = 0;
        countValue = 0;
        if (!(var7)) {
            if (SharedKt.getMc().player != null) {
                factorValue5 = SharedKt.getPlayer().method_36454();
            }
            linkedList.clear();
            linkedList2.clear();
        }
    }

    private void onPreElytraEvent(PreElytraEvent arg0) {
        factorValue2 = SharedKt.getPlayer().method_36454();
        if (!(this.getChangePitch())) {
        }
        factorValue = SharedKt.getPlayer().method_36455();
        SharedKt.getPlayer().method_36457(this.getPitchValue());
        SharedKt.getPlayer().method_36456(factorValue5);
    }

    private void onAfterElytraEvent(AfterElytraEvent arg0) {
        if (!(this.getChangePitch())) {
        }
        SharedKt.getPlayer().method_36457(factorValue);
        SharedKt.getPlayer().method_36456(factorValue2);
    }

    public void onEventPlayerTravel(EventPlayerTravel e) {
        factorValue3 = SharedKt.getPlayer().method_36454();
        factorValue4 = SharedKt.getPlayer().method_36455();
        SharedKt.getPlayer().method_36457(this.getPitchValue());
        SharedKt.getPlayer().method_36456(factorValue5);
    }

    public void onEventPostPlayerTravel(EventPostPlayerTravel e) {
        SharedKt.getPlayer().method_36456(factorValue3);
        SharedKt.getPlayer().method_36457(factorValue4);
    }

    private void onJumpEvent(JumpEvent arg0) {
        if (!(var6)) {
            arg0.setYaw(factorValue5);
        }
        arg0.cancel();
    }

    private void onFallFlyingEvent(FallFlyingEvent arg0) {
        if (this.getGrim()) {
            arg0.setValue(1);
            arg0.cancel();
        } else {
            boolean var10 = arg0.getValue();
            if (enabledFlag && !(var10)) {
                arg0.setValue(this.checkCondition());
                arg0.cancel();
            }
            enabledFlag = var10;
        }
    }

    private void onShouldStopSprintingEvent(ShouldStopSprintingEvent arg0) {
        arg0.cancel();
    }

    private void onSetPoseEvent(SetPoseEvent arg0) {
        arg0.cancel();
        arg0.setPose(class_4050.field_18076);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (!(this.getChangePitch())) {
            if (this.getGrim()) {
            }
            if (this.getGrim()) {
            } else {
            }
            factorValue5.<init>(SharedKt.getPlayer().method_36454(), this.getPitchValue());
            new MoveFixServiceComponent.executeAction(new MoveFixServiceComponent, 201);
        }
        if (countValue > 0) {
            int var35 = countValue;
            countValue = (var35 + -1);
            SharedKt.getMc().options.field_1903.method_23481(0);
            SharedKt.getMc().options.field_1894.method_23481(0);
            SharedKt.getMc().options.field_1867.method_23481(0);
            this.updateValue();
            this.updateValue2();
            this.executeAction();
            this.updateValue3();
            factorValue5 = SharedKt.getPlayer().method_36454();
            enabledFlag = 0;
            enabledFlag2 = 0;
            SharedKt.getPlayer().method_66281();
            return;
        }
        if (!(SharedKt.getPlayer().isFallFlying()) || !(this.checkCondition())) {
            return;
        }
        SharedKt.getPlayer().method_5728(1);
        SharedKt.getMc().options.field_1903.method_23481(1);
        SharedKt.getMc().options.field_1894.method_23481(1);
        SharedKt.getMc().options.field_1867.method_23481(1);
        if (EventPacketHelper2.INSTANCE.getNumericValue() > 1.0D) {
        } else {
        }
        var35 = EventPacketHelper2.INSTANCE.getNumericValue();
        if (SharedKt.getPlayer().isOnGround()) {
            enabledFlag3 = 0;
        }
        if (var35 > 0.0F) {
            if (!(enabledFlag3) && this.checkCondition2()) {
                if (queue2.size() > 20) {
                    this.updateValue2();
                    SharedKt.getPlayer().method_66281();
                    enabledFlag = 0;
                }
                this.updateValue();
                enabledFlag3 = 1;
            }
            if (!(SharedKt.getPlayer().isFallFlying()) && !(enabledFlag) && this.checkCondition()) {
                enabledFlag = 1;
            }
        }
        (LivingEntityAccessor) SharedKt.getPlayer().setLastJumpCooldown(0);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (arg0.getPacket() instanceof class_2708) {
            enabledFlag = 0;
            enabledFlag2 = 0;
            countValue = 60;
            this.updateValue();
            this.updateValue2();
            SharedKt.getPlayer().method_66281();
        }
        if (arg0.getPacket() instanceof class_2739 && SharedKt.getPlayer().isFallFlying() && enabledFlag && this.getGrimDurability()) {
            arg0.cancel();
        }
        arg0.cancel();
        queue2.add((class_6373) arg0.getPacket());
    }

    private void onSendPacket(SendPacket arg0) {
        if (this.getBypass() == ElytraRecastBypassMode.FULL && SharedKt.getPlayer().isFallFlying() && enabledFlag && !(enabledFlag4) && this.checkCondition2()) {
            arg0.cancel();
            queue.add(arg0.getPacket());
        }
        double var19 = (LocalPlayerAccessor) SharedKt.getPlayer().getLastBaseY();
        boolean var21 = this.computeValue() >= 0.4D;
        if (arg0.getPacket() instanceof class_6374) {
            if (enabledFlag) {
                if (SharedKt.getPlayer().isFallFlying()) {
                    if (!(SharedKt.getWorld().method_18026(SharedKt.getPlayer().method_5829().method_989(0.0D, -1.0D, 0.0D)))) {
                        if (enabledFlag5) {
                            if (this.computeValue() >= 0.8D) {
                            }
                            if (!(enabledFlag5)) {
                                if (this.computeValue() < 0.4D) {
                                }
                                linkedList.add((class_6374) arg0.getPacket());
                                arg0.cancel();
                            }
                        }
                    }
                    if (var21) {
                        this.updateValue3();
                    }
                } else {
                    this.updateValue3();
                }
            }
        }
        }
        PlayerMoveC2SPacket var22 = (PlayerMoveC2SPacket) arg0.getPacket();
        if (enabledFlag) {
            if (SharedKt.getPlayer().isFallFlying()) {
                if (var22.method_12268(preciseValue) < preciseValue) {
                    enabledFlag5 = 1;
                } else {
                    if (var22.method_12268(preciseValue) > preciseValue) {
                        enabledFlag5 = 0;
                    }
                }
                preciseValue = var22.method_12268(preciseValue);
                if (!(SharedKt.getWorld().method_18026(SharedKt.getPlayer().method_5829().method_989(0.0D, -1.0D, 0.0D)))) {
                    if (enabledFlag5) {
                        if (this.computeValue(var22.method_12268()) >= 0.8D) {
                        }
                        if (!(enabledFlag5)) {
                            if (this.computeValue() < 0.4D) {
                            }
                            linkedList2.add();
                            arg0.cancel();
                        }
                    }
                }
                this.executeAction();
            }
        } else {
            this.executeAction();
        }
        }
    }

    private double computeValue(double arg0) {
        return (arg0 - Math.floor(arg0));
    }

    public void updateValue2(long arg0) {
        long var3 = (arg0 ^ 64129331416845L);
        long var5 = (arg0 ^ 73907896531847L);
        long var7 = ((arg0 ^ 29281619393040L) >>> 32);
        long var8 = (((arg0 ^ 29281619393040L) << 32) >>> 48);
        long var9 = (((arg0 ^ 29281619393040L) << 48) >>> 48);
        long var10 = (arg0 ^ 43815837977696L);
        long var12 = (arg0 ^ 114558609552098L);
        long var14 = ((arg0 ^ 44030506242343L) >>> 48);
        long var15 = (((arg0 ^ 44030506242343L) << 16) >>> 32);
        long var16 = (((arg0 ^ 44030506242343L) << 48) >>> 48);
        if (!(ServiceComponent13.checkCondition((KeyMappingAccessor) SharedKt.getMc().options.field_1894.getKey().method_1444()))) {
            SharedKt.getMc().options.field_1894.method_23481(0);
        }
        if (arg0 > 0L) {
            if (!(ServiceComponent13.checkCondition((KeyMappingAccessor) SharedKt.getMc().options.field_1903.getKey().method_1444()))) {
                SharedKt.getMc().options.field_1903.method_23481(0);
            }
            enabledFlag = 0;
            enabledFlag2 = 0;
            this.updateValue();
            this.updateValue2();
            this.executeAction();
            this.updateValue3();
        }
        if (arg0 > 0L) {
        }
    }

    private boolean checkCondition(int arg0, long arg1) {
        if (this.checkCondition()) {
            int var24 = ItemPacketHelper.INSTANCE.computeValue();
            if (arg1 >= 0L) {
                if (!(var23)) {
                    if (arg0 >= 0) {
                        if (!(var23)) {
                            if (var24 != -2 && var24 != -1 && this.getGrimDurability() && this.getGrim()) {
                                HandServiceComponent.e();
                                HandServiceComponent.e();
                            }
                            ElytraSwapModule.INSTANCE.updateValue(1);
                            SharedKt.getPlayer().startFallFlying();
                            PacketPacketHelper.handlePacket((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982));
                        }
                    }
                }
            }
            if (arg0 > 0) {
                if (arg1 > 0L) {
                    if (!(var23)) {
                        if (var24 != -2 && var24 != -1 && this.getGrimDurability() && this.getGrim()) {
                            HandServiceComponent.e();
                            HandServiceComponent.e();
                        }
                    }
                }
                if (arg0 >= 0) {
                    if (!(var23)) {
                    }
                }
                if (arg1 >= 0L) {
                }
                if (var24 == -2 && this.getGrimDurability() && this.getGrim()) {
                    Item[] var26 = new Item[6];
                    var26[0] = Items.NETHERITE_CHESTPLATE;
                    var26[1] = Items.DIAMOND_CHESTPLATE;
                    var26[2] = Items.IRON_CHESTPLATE;
                    var26[3] = Items.GOLDEN_CHESTPLATE;
                    var26[4] = Items.LEATHER_CHESTPLATE;
                    var26[5] = Items.CHAINMAIL_CHESTPLATE;
                    StackServiceComponent2 var25 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
                    if (var25.isActive()) {
                        HandServiceComponent.e(var25.getNumericValue());
                        HandServiceComponent.e();
                        HandServiceComponent.e(var25.getNumericValue());
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean checkCondition() {
        if (!(SharedKt.getPlayer().method_31549().field_7479) && !(SharedKt.getPlayer().method_5765()) && !(SharedKt.getPlayer().method_5799()) && !(SharedKt.getPlayer().method_6059(class_1294.field_5902)) && SharedKt.getPlayer().method_7344().method_7586() > 6.0F) {
            ItemStack stack = SharedKt.getPlayer().getEquippedStack(EquipmentSlot.CHEST);
            if (!(this.checkCondition(stack))) {
                if (stack.method_31574(Items.ELYTRA) && this.getAllowBroken()) {
                    if (this.getGrim()) {
                    }
                    if (this.getGrimDurability() && ItemPacketHelper.INSTANCE.computeValue() != -1) {
                    }
                }
            } else {
            }
            return false;
        }
        return false;
    }

    public boolean checkCondition(ItemStack s) {
        return s.method_57826(class_9334.field_54197);
    }

    private boolean checkCondition2() {
        if (!(this.getGrimDurability())) {
            if (this.getTunnelsOffset()) {
            }
        } else {
        }
        return false;
    }

    private void updateValue() {
        enabledFlag4 = 1;
        if (!(queue.isEmpty())) {
            PacketPacketHelper.handlePacket((Packet) queue.poll());
        }
        enabledFlag4 = 0;
    }

    private void updateValue2() {
        (class_6373) queue2.poll().method_36949((class_8705) SharedKt.getNetwork());
    }

    private void updateValue3() {
        enabledFlag4 = 1;
        if (!(linkedList.isEmpty())) {
            PacketPacketHelper.handlePacket((Packet) linkedList.poll());
        }
        enabledFlag4 = 0;
        factorValue5 = SharedKt.getPlayer().method_36454();
    }

    private void executeAction(int arg0, int arg1) {
        enabledFlag4 = 1;
        if (!(linkedList2.isEmpty())) {
            PacketPacketHelper.handlePacket((Packet) linkedList2.poll());
            if (arg0 >= 0) {
            }
        }
        enabledFlag4 = 0;
    }

    private static boolean isActive() {
        return INSTANCE.getGrim();
    }

    private static boolean isActive2() {
        return INSTANCE.getGrim();
    }

    private static boolean isActive3() {
        return !(INSTANCE.getGrim());
    }

    private static boolean isActive4() {
        return !(INSTANCE.getGrim());
    }

    private static boolean isActive5() {
        return !(INSTANCE.getGrim());
    }

    static {
        KProperty[] var30 = new KProperty[7];
        INSTANCE = new ElytraRecastModule();
        grimSetting = VisibleRenderHelper.registerSetting(INSTANCE, "grim");
        tunnelsOffsetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "tunnels-offset");
        bypassSetting = VisibleRenderHelper.registerSetting(INSTANCE, "bypass", ElytraRecastBypassMode.SEMI, null, this::isActive);
        grimDurabilitySetting = VisibleRenderHelper.registerSetting(INSTANCE, "grim-durability", 1, null, this::isActive2);
        changePitchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "change-pitch", 1, null, this::isActive3);
        pitchValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pitch", 87.0F, RangesKt.rangeTo(0.0F, 90.0F), null, this::isActive4);
        allowBrokenSetting = VisibleRenderHelper.registerSetting(INSTANCE, "allow-broken", 1, null, this::isActive5);
        queue = (Queue) new LinkedList();
        queue2 = (Queue) new LinkedList();
        linkedList = new LinkedList();
        linkedList2 = new LinkedList();
        enabledFlag5 = 1;
    }

}
