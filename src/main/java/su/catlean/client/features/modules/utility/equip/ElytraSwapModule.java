package su.catlean.client.features.modules.utility.equip;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1890;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_2879;
import net.minecraft.class_6880;
import net.minecraft.class_9304;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.network.AfterSendPacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.ElytraRecastModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent2;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.TitleRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode16;

public class ElytraSwapModule extends Module {

    public static final ElytraSwapModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 switchButtonSetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 fireWorkButtonSetting;
    private static final VisibleVisibleSettingPropertyImpl startFireWorkSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 fireWorkModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 swapModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 hotBarSwapModeSetting;
    private static final VisibleVisibleSettingPropertyImpl swapOnLandSetting;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static int countValue;
    private static final Item[] minecraftRefArray;
    private static boolean enabledFlag3;

    private ElytraSwapModule() {
        super("elytra-swap", SubCategoriesKt.getEquipCategory());
    }

    private ElytraSwapMode getMode() {
        return (ElytraSwapMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private KeyRecord getSwitchButton() {
        return (KeyRecord) switchButtonSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private KeyRecord getFireWorkButton() {
        return (KeyRecord) fireWorkButtonSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getStartFireWork() {
        return (Boolean) startFireWorkSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private ElytraSwapFireWorkMode getFireWorkMode() {
        return (ElytraSwapFireWorkMode) fireWorkModeSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private ElytraSwapSwapMode getSwapMode() {
        return (ElytraSwapSwapMode) swapModeSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private ElytraSwapHotBarSwapMode getHotBarSwapMode() {
        return (ElytraSwapHotBarSwapMode) hotBarSwapModeSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getSwapOnLand() {
        return (Boolean) swapOnLandSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 32978412894279L);
        long var5 = (arg0 ^ 10016030373321L);
        long var7 = (arg0 ^ 9607710392669L);
        executeAction(this);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (EventPacketHelper2.INSTANCE.getNumericValue() > 15) {
            enabledFlag2 = 1;
        }
        if (Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA)) {
            this.executeAction(0, 1);
        }
        enabledFlag2 = 0;
    }

    private void onAfterSendPacket(AfterSendPacket arg0) {
        if (this.getMode() == ElytraSwapMode.BIND && this.getStartFireWork() && !(enabledFlag)) {
            this.updateValue();
        }
        enabledFlag = 0;
    }

    private void onInputEvent(InputEvent arg0) {
        if (arg0.getKey() == this.getSwitchButton().getNumericValue()) {
            executeAction(this);
        }
        this.updateValue();
    }

    private void updateValue() {
        RunnableServiceComponent2.executeAction(0, -10, 0, this::executeAction);
    }

    public int computeValue(short arg0) {
        Item[] var10 = minecraftRefArray;
        int var11 = 0;
        Object var12 = var10;
        if (var11 < var12) {
            Object var13 = var10[var11];
            Item[] var15 = new Item[1];
            var15[0] = var13;
            StackServiceComponent2 var14 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
            if (var14.isActive()) {
                return var14.getNumericValue();
            }
        }
        return -1;
    }

    private int computeValue(byte arg0, int arg1, int arg2) {
        int var11 = -1;
        int var12 = -1;
        int var13 = 0;
        if (var13 < 37) {
            if (arg1 > 0) {
                if (SharedKt.getMc().player != null && SharedKt.getMc().player.method_31548() != null) {
                } else {
                    SharedKt.getMc().player.method_31548().method_5438();
                }
            }
            if (arg2 > 0 && var10 != null) {
            }
            if (Intrinsics.areEqual(var14.getItem(), Items.ELYTRA) && ElytraRecastModule.INSTANCE.checkCondition()) {
                int var15 = 0;
                class_9304 var16 = class_1890.method_57532();
                Iterable var17 = (Iterable) var16.method_57534();
                int var18 = 0;
                Iterator iterator = var17.iterator();
                while (iterator.hasNext()) {
                    Object var20 = iterator.next();
                    class_6880 var21 = (class_6880) var20;
                    int var22 = 0;
                    if (arg0 >= 0) {
                        if (var10 != null) {
                            if (var21 != null) {
                                Object var23 = var21;
                                int var24 = 0;
                                var15 = (var15 + var16.method_57536());
                            } else {
                            }
                        }
                        if (arg0 >= 0) {
                        }
                    }
                }
                if (var15 > var12) {
                    var12 = var15;
                    if (arg0 >= 0) {
                        if (var13 < 9) {
                        }
                    } else {
                    }
                    var11 = var13;
                }
            }
        }
        return var11;
    }

    private void executeAction(boolean arg0, boolean arg1) {
        RunnableServiceComponent2.executeAction(0, -10, 0, this::executeAction);
    }

    private static void executeAction(ElytraSwapModule arg0, boolean arg1, boolean arg2, int arg3, Object arg4) {
        if ((arg3 & 2)) {
            arg2 = 0;
        }
        arg0.executeAction(arg1, arg2);
    }

    private void executeAction(int arg0, boolean arg1) {
        if (36 <= arg0) {
        } else {
        }
        if (arg0 < 45) {
            if (this.getHotBarSwapMode() == ElytraSwapHotBarSwapMode.DEFAULT) {
                HandServiceComponent.executeAction(6, (arg0 - 36), class_1713.field_7791, 1);
            } else {
                ItemPacketHelper.executeAction((arg0 - 36));
            } else {
                if (this.getSwapMode() == ElytraSwapSwapMode.DEFAULT) {
                    HandServiceComponent.e(arg0);
                    HandServiceComponent.e();
                    HandServiceComponent.e(arg0);
                } else {
                    HandServiceComponent.e(arg0, 7, class_1713.field_7791);
                    HandServiceComponent.e(6, 7, class_1713.field_7791);
                    HandServiceComponent.executeAction(arg0, 7, class_1713.field_7791, 1);
                }
            }
        }
        countValue = SharedKt.getPlayer().field_6012;
        this.executeAction();
    }

    private void executeAction() {
        RunnableServiceComponent2.executeAction(-1, -10, 0, this::executeAction2);
    }

    private static boolean isActive2() {
        return INSTANCE.getMode() == ElytraSwapMode.BIND;
    }

    private static boolean isActive3() {
        return INSTANCE.getMode() == ElytraSwapMode.BIND;
    }

    private static boolean isActive4() {
        return INSTANCE.getMode() == ElytraSwapMode.BIND;
    }

    private static boolean isActive5() {
        return INSTANCE.getMode() == ElytraSwapMode.BIND;
    }

    private static boolean isActive6() {
        return INSTANCE.getMode() == ElytraSwapMode.BIND;
    }

    private static void executeAction() {
        Item[] var31 = new Item[1];
        var31[0] = Items.FIREWORK_ROCKET;
        StackServiceComponent2 var30 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        Item[] var32 = new Item[1];
        var32[0] = Items.FIREWORK_ROCKET;
        var31 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        ItemPacketHelper.INSTANCE.updateValue();
        if (var30.isActive()) {
            var30.updateValue();
        } else {
            if (var31.isActive()) {
                HandServiceComponent.executeAction(var31.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, 1);
            } else {
                MessageServiceComponent.S(INSTANCE, MessageServiceComponent.resolveString(INSTANCE, "no-fireworks", new Object[0], 1));
                return;
            }
        }
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
        ItemPacketHelper.INSTANCE.updateValue2();
        HandServiceComponent.executeAction(var31.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, 1);
    }

    private static void executeAction(boolean arg0, boolean arg1) {
        if (Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA)) {
            int var34 = INSTANCE.computeValue();
            if (var34 != -1) {
                if (var34 >= 36) {
                } else {
                }
                int var29 = 4;
                ItemStack stack = (var34 - 36).method_5438().method_7972();
                class_1661 var31 = SharedKt.getPlayer().method_31548();
                int var32 = 0;
                MessageServiceComponent.e(MessageServiceComponent.Z(INSTANCE, "done-chestplate", new Object[0]), OptionMode16.SUCCESS, stack);
                INSTANCE.executeAction(0);
                TitleRenderHelper.INSTANCE.updateValue(1);
                INSTANCE.updateValue2();
                TitleRenderHelper.INSTANCE.updateValue(0);
            } else {
                if (INSTANCE) {
                    INSTANCE.executeAction(MessageServiceComponent.Z(INSTANCE, "no-chestplate", new Object[0]));
                } else {
                    MessageServiceComponent.S(INSTANCE, MessageServiceComponent.Z(INSTANCE, "no-chestplate", new Object[0]));
                } else {
                    var34 = INSTANCE.computeValue();
                    if (var34 != -1) {
                        if (var34 >= 36) {
                        } else {
                        }
                        var29 = 4;
                        stack = (var34 - 36).method_5438().method_7972();
                        var31 = SharedKt.getPlayer().method_31548();
                        var32 = 0;
                        MessageServiceComponent.e(MessageServiceComponent.Z(INSTANCE, "done-elytra", new Object[0]), OptionMode16.SUCCESS, stack);
                        INSTANCE.executeAction(1);
                        TitleRenderHelper.INSTANCE.updateValue(1);
                        INSTANCE.updateValue2();
                        TitleRenderHelper.INSTANCE.updateValue(0);
                    } else {
                        if (INSTANCE) {
                            INSTANCE.executeAction(MessageServiceComponent.resolveString(INSTANCE, "no-elytra", new Object[0], 1));
                        } else {
                            MessageServiceComponent.S(INSTANCE, MessageServiceComponent.resolveString(INSTANCE, "no-elytra", new Object[0], 1));
                        }
                    }
                }
            }
        }
    }

    private static void executeAction2() {
        if (Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA)) {
            if (SharedKt.getPlayer().isFallFlying()) {
                SharedKt.getMc().options.field_1903.method_23481(0);
            } else {
                SharedKt.getMc().options.field_1903.method_23481(!(((SharedKt.getPlayer().field_6012 - countValue) % 2)));
                INSTANCE.executeAction();
            } else {
                SharedKt.getMc().options.field_1903.method_23481(1);
                INSTANCE.executeAction();
            }
        }
    }

    static {
        KProperty[] var33 = new KProperty[8];
        INSTANCE = new ElytraSwapModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", ElytraSwapMode.ENABLE);
        switchButtonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch-button", new KeyRecord(), null, this::isActive2);
        fireWorkButtonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire-work-button", new KeyRecord(), null, this::isActive3);
        startFireWorkSetting = VisibleRenderHelper.registerSetting(INSTANCE, "start-fire-work", 0, null, this::isActive4);
        fireWorkModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire-work-mode", ElytraSwapFireWorkMode.SILENT, null, this::isActive5);
        swapModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap-mode", ElytraSwapSwapMode.ALT);
        hotBarSwapModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hotbar-swap-mode", ElytraSwapHotBarSwapMode.DEFAULT);
        swapOnLandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap-on-land", 0, null, this::isActive6);
        var33 = new Item[6];
        var33[0] = Items.NETHERITE_CHESTPLATE;
        var33[1] = Items.DIAMOND_CHESTPLATE;
        var33[2] = Items.CHAINMAIL_CHESTPLATE;
        var33[3] = Items.IRON_CHESTPLATE;
        var33[4] = Items.GOLDEN_CHESTPLATE;
        var33[5] = Items.LEATHER_CHESTPLATE;
        minecraftRefArray = var33;
    }

    public static void updateValue2(boolean arg0) {
        enabledFlag3 = arg0;
    }

    public static boolean isActive7() {
        return enabledFlag3;
    }

    public static boolean isActive8() {
        return true;
        return false;
    }

}
