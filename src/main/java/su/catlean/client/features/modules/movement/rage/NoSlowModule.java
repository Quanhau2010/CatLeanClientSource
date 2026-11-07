package su.catlean.client.features.modules.movement.rage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.Blocks;
import net.minecraft.class_1661;
import net.minecraft.class_241;
import net.minecraft.class_2868;
import net.minecraft.class_744;
import net.minecraft.class_9323;
import net.minecraft.class_9334;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ClearClickMapEvent;
import su.catlean.api.event.events.network.SlowDownEvent;
import su.catlean.api.event.events.player.KeyboardInputEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.ShouldStopSprintingEvent;
import su.catlean.api.event.events.world.SlipperinessEvent;
import su.catlean.api.event.events.world.StepOnSlimeEvent;
import su.catlean.api.event.events.world.SweetBerryBushCollisionEvent;
import su.catlean.api.event.events.world.VelocityMultiplierEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.SprintModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.mappings.NoSlowModeWhenMappings;
import su.catlean.mixins.accessors.ClientInputAccessor;

public class NoSlowModule extends Module {

    public static final NoSlowModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final VisibleVisibleSettingPropertyImpl limitPacketsSetting;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final VisibleVisibleSettingPropertyImpl mainHandSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 selectionSetting;
    private static final VisibleVisibleSettingPropertyImpl foodSetting;
    private static final VisibleVisibleSettingPropertyImpl projectilesSetting;
    private static final VisibleVisibleSettingPropertyImpl shieldSetting;
    private static final VisibleVisibleSettingPropertyImpl soulSandSetting;
    private static final VisibleVisibleSettingPropertyImpl honeySetting;
    private static final VisibleVisibleSettingPropertyImpl slimeSetting;
    private static final VisibleVisibleSettingPropertyImpl iceSetting;
    private static final VisibleVisibleSettingPropertyImpl sweetBerryBushSetting;
    private static final VisibleVisibleSettingPropertyImpl sneakSetting;
    private static final VisibleVisibleSettingPropertyImpl crawlSetting;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static boolean enabledFlag3;
    private static boolean enabledFlag4;
    private static boolean enabledFlag5;
    private static boolean enabledFlag6;

    private NoSlowModule() {
        super("no-slow", SubCategoriesKt.getRageMovementCategory());
    }

    public NoSlowMode getMode() {
        if (!(var5)) {
        }
        return (NoSlowMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getLimitPackets() {
        return (Boolean) limitPacketsSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private int getDelay() {
        return (Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getMainHand() {
        return (Boolean) mainHandSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private SettingGroup getSelection() {
        return (SettingGroup) selectionSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getFood() {
        return (Boolean) foodSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getProjectiles() {
        return (Boolean) projectilesSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getShield() {
        return (Boolean) shieldSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private boolean getSoulSand() {
        return (Boolean) soulSandSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private boolean getHoney() {
        return (Boolean) honeySetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private boolean getSlime() {
        return (Boolean) slimeSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private boolean getIce() {
        return (Boolean) iceSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private boolean getSweetBerryBush() {
        return (Boolean) sweetBerryBushSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private boolean getSneak() {
        return (Boolean) sneakSetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    private boolean getCrawl() {
        return (Boolean) crawlSetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        enabledFlag3 = enabledFlag2;
        enabledFlag2 = !(enabledFlag2);
        if (enabledFlag4) {
            enabledFlag2 = 1;
            enabledFlag4 = 0;
        }
        if (enabledFlag) {
            SharedKt.getMc().options.field_1832.method_23481(0);
            SharedKt.getPlayer().method_5728(0);
            enabledFlag = 0;
        }
        PacketPacketHelper.handlePacket((Packet) new class_2868(SharedKt.getPlayer().method_31548().method_67532()));
        if (SharedKt.getPlayer().method_6058() == Hand.field_5810) {
            PacketPacketHelper.handlePacket((Packet) new class_2868(((SharedKt.getPlayer().method_31548().method_67532() % 8) + 1)));
            PacketPacketHelper.handlePacket((Packet) new class_2868(SharedKt.getPlayer().method_31548().method_67532()));
        } else {
            if (SharedKt.getPlayer().method_6048() > 3 && (SharedKt.getPlayer().field_6012 % 2)) {
            }
            HandServiceComponent.K(Hand.field_5810, 0.0F, 0.0F);
        }
    }

    private void onSlipperinessEvent(SlipperinessEvent arg0) {
        if (this.getSlime() && Intrinsics.areEqual(arg0.getBlock(), Blocks.field_10030)) {
            arg0.cancel();
        }
        if (!(Intrinsics.areEqual(arg0.getBlock(), Blocks.field_10295)) && !(Intrinsics.areEqual(arg0.getBlock(), Blocks.field_10225)) && !(Intrinsics.areEqual(arg0.getBlock(), Blocks.field_10384))) {
        }
        arg0.cancel();
    }

    private void onVelocityMultiplierEvent(VelocityMultiplierEvent arg0) {
        if (this.getSoulSand()) {
            if (!(Intrinsics.areEqual(arg0.getBlock(), Blocks.field_10114))) {
            }
        }
        arg0.cancel();
    }

    private void onStepOnSlimeEvent(StepOnSlimeEvent arg0) {
        arg0.cancel();
    }

    private void onClearClickMapEvent(ClearClickMapEvent arg0) {
        arg0.cancel();
    }

    private void onKeyboardInputEvent(KeyboardInputEvent arg0) {
        if (this.getMode() == NoSlowMode.MATRIX && SharedKt.getPlayer().method_6115() && !(SharedKt.getPlayer().isFallFlying())) {
            (ClientInputAccessor) SharedKt.getPlayer().field_3913.setMoveVector(new class_241((SharedKt.getPlayer().field_3913.method_3128().field_1343 * 5), (SharedKt.getPlayer().field_3913.method_3128().field_1342 * 5)));
            if (SharedKt.getPlayer().isOnGround()) {
                if (SharedKt.getPlayer().field_3913.method_3128().field_1342 != 0.0F && SharedKt.getPlayer().field_3913.method_3128().field_1343 != 0.0F) {
                } else {
                } else {
                    if (SharedKt.getPlayer().field_3913.method_3128().field_1342 != 0.0F && SharedKt.getPlayer().field_3913.method_3128().field_1343 != 0.0F) {
                    } else {
                    }
                }
            }
            float var11 = 0.67F;
            (ClientInputAccessor) SharedKt.getPlayer().field_3913.setMoveVector(new class_241((SharedKt.getPlayer().field_3913.method_3128().field_1343 * var11), (SharedKt.getPlayer().field_3913.method_3128().field_1342 * var11)));
        } else {
            (ClientInputAccessor) SharedKt.getPlayer().field_3913.setMoveVector(new class_241((SharedKt.getPlayer().field_3913.method_3128().field_1343 * 5), (SharedKt.getPlayer().field_3913.method_3128().field_1342 * 5)));
        }
    }

    private void onSlowDownEvent(SlowDownEvent arg0) {
        if (SharedKt.getPlayer().method_20448()) {
            if (!(this.getCrawl())) {
            }
        }
        arg0.cancel();
    }

    private void onShouldStopSprintingEvent(ShouldStopSprintingEvent arg0) {
        arg0.cancel();
    }

    private void onSweetBerryBushCollisionEvent(SweetBerryBushCollisionEvent arg0) {
        arg0.cancel();
    }

    private boolean checkCondition(boolean arg0) {
        if (this.getMode() == NoSlowMode.MATRIX) {
            return false;
        }
        if (!(this.getFood()) && SharedKt.getPlayer().method_6030().method_57353().method_57832(class_9334.field_50075)) {
            return false;
        }
        if (!(this.getShield()) && Intrinsics.areEqual(SharedKt.getPlayer().method_6030().getItem(), Items.field_8255)) {
            return false;
        }
        if (!(Intrinsics.areEqual(SharedKt.getPlayer().method_6030().getItem(), Items.field_8399))) {
            if (!(Intrinsics.areEqual(SharedKt.getPlayer().method_6030().getItem(), Items.field_8102))) {
                if (!(this.getProjectiles()) && Intrinsics.areEqual(SharedKt.getPlayer().method_6030().getItem(), Items.field_8547)) {
                }
            }
            return false;
        }
        if (!(this.getMainHand()) && SharedKt.getPlayer().method_6058() == Hand.field_5808) {
            return false;
        }
        if (this.getMode() == NoSlowMode.GRIM_2) {
            if (SharedKt.getPlayer().method_6048() < this.getDelay()) {
                if (SharedKt.getPlayer().method_6115() && SharedKt.getPlayer().method_6048() <= 2) {
                    enabledFlag6 = 1;
                    HandServiceComponent.e();
                    enabledFlag6 = 0;
                } else {
                    return true;
                }
            }
            return false;
        }
        if (this.getMode() == NoSlowMode.GRIM_3) {
            if (SharedKt.getPlayer().method_6115()) {
                enabledFlag5 = SharedKt.getPlayer().method_5624();
                SharedKt.getPlayer().method_5728(0);
                SprintModule.INSTANCE.updateValue(1);
                return false;
                enabledFlag6 = 1;
                HandServiceComponent.e();
                enabledFlag6 = 0;
                SprintModule.INSTANCE.updateValue(1);
                return false;
                SharedKt.getPlayer().method_5728(enabledFlag5);
                SprintModule.INSTANCE.updateValue(1);
                return false;
                return true;
            }
            return false;
        }
        if (this.getMode() == NoSlowMode.GRIM_V3) {
            if (!(SharedKt.getMc().options.field_1832.method_1434())) {
                if (SharedKt.getPlayer().method_6048() < 3) {
                    return false;
                }
                if (SharedKt.getPlayer().isOnGround()) {
                    if (SharedKt.getMc().options.field_1903.method_1434()) {
                        if (enabledFlag3) {
                            return true;
                        }
                        enabledFlag4 = 1;
                        return false;
                    }
                    return !((SharedKt.getPlayer().field_6012 % 2));
                }
                return !(enabledFlag2);
            }
            return false;
        }
        if (!(SharedKt.getPlayer().method_6079().method_57353().method_57832(class_9334.field_50075))) {
        }
        if (Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.field_8255) && this.getMode() == NoSlowMode.GRIM && SharedKt.getPlayer().method_6058() == Hand.field_5808) {
            return false;
        }
        return true;
    }

    private static boolean isActive() {
        return INSTANCE.getMode() == NoSlowMode.GRIM;
    }

    private static boolean isActive2() {
        return INSTANCE.getMode() == NoSlowMode.GRIM_2;
    }

    static {
        KProperty[] var35 = new KProperty[15];
        INSTANCE = new NoSlowModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", NoSlowMode.VANILLA);
        limitPacketsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "limit-packets", 0, null, this::isActive);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 3, new IntRange(1, 10), null, this::isActive2);
        mainHandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "main-hand");
        selectionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "selection", OptionMode14.BOOLS);
        foodSetting = VisibleRenderHelper.registerSetting(INSTANCE, "food", 1, INSTANCE.getSelection());
        projectilesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "projectiles", 1, INSTANCE.getSelection());
        shieldSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shield", 1, INSTANCE.getSelection());
        soulSandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "soul-sand", 1, INSTANCE.getSelection());
        honeySetting = VisibleRenderHelper.registerSetting(INSTANCE, "honey", 1, INSTANCE.getSelection());
        slimeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "slime", 1, INSTANCE.getSelection());
        iceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ice", 1, INSTANCE.getSelection());
        sweetBerryBushSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sweet-berry-bush", 1, INSTANCE.getSelection());
        sneakSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sneak", 0, INSTANCE.getSelection());
        crawlSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crawl", 0, INSTANCE.getSelection());
    }

}
